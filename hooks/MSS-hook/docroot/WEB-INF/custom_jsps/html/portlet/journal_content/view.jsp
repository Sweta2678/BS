<%--
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */
--%>

<%@page import="com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.service.GroupLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Group"%>
<%@page import="com.liferay.portal.kernel.util.Validator" %>
<%@ include file="/html/portlet/journal_content/init.jsp" %>

<%@ page import="com.liferay.portal.service.GroupLocalServiceUtil" %>

<%
JournalArticle article = (JournalArticle)request.getAttribute(WebKeys.JOURNAL_ARTICLE);
JournalArticleDisplay articleDisplay = (JournalArticleDisplay)request.getAttribute(WebKeys.JOURNAL_ARTICLE_DISPLAY);

boolean print = ParamUtil.getString(request, "viewMode").equals(Constants.PRINT);

boolean hasViewPermission = true;

String title = StringPool.BLANK;
boolean approved = false;
boolean expired = true;
%>
<c:choose>
	<c:when test="<%= article == null %>">

		<%
		renderRequest.setAttribute(WebKeys.PORTLET_CONFIGURATOR_VISIBILITY, Boolean.TRUE);
		%>

		<c:choose>
			<c:when test="<%= Validator.isNull(articleId) %>">
				<div class="alert alert-info">
					<liferay-ui:message key="select-existing-web-content-or-add-some-web-content-to-be-displayed-in-this-portlet" />
				</div>
			</c:when>
			<c:otherwise>
				<div class="alert alert-error">
					<%= LanguageUtil.get(pageContext, "the-selected-web-content-no-longer-exists") %>
				</div>
			</c:otherwise>
		</c:choose>
	</c:when>
	<c:otherwise>

		<%
		hasViewPermission = JournalArticlePermission.contains(permissionChecker, article.getGroupId(), article.getArticleId(), ActionKeys.VIEW);
		%>

		<c:choose>
			<c:when test="<%= !hasViewPermission %>">

				<%
				renderRequest.setAttribute(WebKeys.PORTLET_CONFIGURATOR_VISIBILITY, Boolean.TRUE);
				%>

				<div class="alert alert-error">
					<liferay-ui:message key="you-do-not-have-the-roles-required-to-access-this-web-content-entry" />
				</div>
			</c:when>
			<c:otherwise>

				<%
				title = article.getTitle(locale);
				approved = article.isApproved();
				expired = article.isExpired();

				if (!expired) {
					Date expirationDate = article.getExpirationDate();

					if ((expirationDate != null) && expirationDate.before(new Date())) {
						expired = true;
					}
				}
				%>

				<c:choose>
					<c:when test="<%= (articleDisplay != null) && !expired %>">

						<%
						if (enableViewCountIncrement) {
							AssetEntryServiceUtil.incrementViewCounter(JournalArticle.class.getName(), articleDisplay.getResourcePrimKey());
						}

						if (themeDisplay.isStateExclusive()) {
							out.print(RuntimePageUtil.processXML(request, response, articleDisplay.getContent()));

							return;
						}

						PortletURL portletURL = renderResponse.createRenderURL();
						%>

						<c:if test="<%= enableConversions || enablePrint || (showAvailableLocales && (articleDisplay.getAvailableLocales().length > 1)) %>">
							<div class="user-actions">
								<c:if test="<%= enablePrint %>">
									<c:choose>
										<c:when test="<%= print %>">
											<div class="print-action">
												<liferay-ui:icon
													image="print"
													label="<%= true %>"
													message='<%= LanguageUtil.format(pageContext, "print-x-x", new Object[] {"hide-accessible", articleDisplay.getTitle()}) %>'
													url="javascript:print();"
												/>
											</div>

											<aui:script>
												print();
											</aui:script>
										</c:when>
										<c:otherwise>
											<portlet:renderURL var="printPageURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
												<portlet:param name="struts_action" value="/journal_content/view" />
												<portlet:param name="groupId" value="<%= String.valueOf(articleDisplay.getGroupId()) %>" />
												<portlet:param name="articleId" value="<%= articleDisplay.getArticleId() %>" />
												<portlet:param name="page" value="<%= String.valueOf(articleDisplay.getCurrentPage()) %>" />
												<portlet:param name="viewMode" value="<%= Constants.PRINT %>" />
											</portlet:renderURL>

											<div class="print-action">
												<liferay-ui:icon
													image="print"
													label="<%= true %>"
													message='<%= LanguageUtil.format(pageContext, "print-x-x", new Object[] {"hide-accessible", HtmlUtil.escape(articleDisplay.getTitle())}) %>'
													url='<%= "javascript:" + renderResponse.getNamespace() + "printPage();" %>'
												/>
											</div>

											<aui:script>
												function <portlet:namespace />printPage() {
													window.open('<%= printPageURL %>', '', "directories=0,height=480,left=80,location=1,menubar=1,resizable=1,scrollbars=yes,status=0,toolbar=0,top=180,width=640");
												}
											</aui:script>
										</c:otherwise>
									</c:choose>
								</c:if>

								<c:if test="<%= enableConversions && !print %>">
									<div class="export-actions">
										<liferay-ui:icon-list>

											<%
											for (String extension : extensions) {
											%>

												<portlet:actionURL var="exportArticleURL" windowState="<%= LiferayWindowState.EXCLUSIVE.toString() %>">
													<portlet:param name="struts_action" value="/journal_content/export_article" />
													<portlet:param name="groupId" value="<%= String.valueOf(articleDisplay.getGroupId()) %>" />
													<portlet:param name="articleId" value="<%= articleDisplay.getArticleId() %>" />
													<portlet:param name="targetExtension" value="<%= extension %>" />
												</portlet:actionURL>

												<liferay-ui:icon
													image='<%= "../file_system/small/" + HtmlUtil.escapeAttribute(extension) %>'
													label="<%= true %>"
													message='<%= LanguageUtil.format(pageContext, "x-convert-x-to-x", new Object[] {"hide-accessible", articleDisplay.getTitle(), StringUtil.toUpperCase(HtmlUtil.escape(extension))}) %>'
													method="get"
													url="<%= exportArticleURL %>"
												/>

											<%
											}
											%>

										</liferay-ui:icon-list>
									</div>
								</c:if>

								<c:if test="<%= showAvailableLocales && !print %>">

									<%
									String[] availableLocales = articleDisplay.getAvailableLocales();
									%>

									<c:if test="<%= availableLocales.length > 1 %>">
										<c:if test="<%= enableConversions || enablePrint %>">
											<div class="locale-separator"> </div>
										</c:if>

										<div class="locale-actions">
											<liferay-ui:language displayStyle="<%= 0 %>" formAction="<%= currentURL %>" languageId="<%= LanguageUtil.getLanguageId(request) %>" languageIds="<%= availableLocales %>" />
										</div>
									</c:if>
								</c:if>
							</div>
						</c:if>

						<div class="journal-content-article">
							<%= RuntimePageUtil.processXML(request, response, articleDisplay.getContent()) %>
						</div>

						<c:if test="<%= articleDisplay.isPaginate() %>">
							<liferay-ui:page-iterator
								cur="<%= articleDisplay.getCurrentPage() %>"
								curParam='<%= "page" %>'
								delta="<%= 1 %>"
								id="articleDisplayPages"
								maxPages="<%= 25 %>"
								total="<%= articleDisplay.getNumberOfPages() %>"
								type="article"
								url="<%= portletURL.toString() %>"
							/>

							<br />
						</c:if>
					</c:when>
					<c:otherwise>

					<%
					renderRequest.setAttribute(WebKeys.PORTLET_CONFIGURATOR_VISIBILITY, Boolean.TRUE);
					%>

					<br />
						<c:choose>
							<c:when test="<%= Validator.isNull(articleId) %>">
							</c:when>
							<c:otherwise>

								<%
								if (expired) {
								%>

									<div class="alert alert-block">
										<%= LanguageUtil.format(pageContext, "x-is-expired", HtmlUtil.escape(title)) %>
									</div>

								<%
								}
								else if (!approved) {
								%>

									<c:choose>
										<c:when test="<%= JournalArticlePermission.contains(permissionChecker, article.getGroupId(), article.getArticleId(), ActionKeys.UPDATE) %>">
											<liferay-portlet:renderURL portletName="<%= PortletKeys.JOURNAL %>" var="editURL" windowState="<%= WindowState.MAXIMIZED.toString() %>">
												<portlet:param name="struts_action" value="/journal/edit_article" />
												<portlet:param name="redirect" value="<%= currentURL %>" />
												<portlet:param name="groupId" value="<%= String.valueOf(article.getGroupId()) %>" />
												<portlet:param name="folderId" value="<%= String.valueOf(article.getFolderId()) %>" />
												<portlet:param name="articleId" value="<%= article.getArticleId() %>" />
												<portlet:param name="version" value="<%= String.valueOf(article.getVersion()) %>" />
											</liferay-portlet:renderURL>

											<div class="alert alert-block">
												<a href="<%= editURL %>">
													<%= LanguageUtil.format(pageContext, "x-is-not-approved", HtmlUtil.escape(title)) %>
												</a>
											</div>
										</c:when>
										<c:otherwise>
											<div class="alert alert-block">
												<%= LanguageUtil.format(pageContext, "x-is-not-approved", HtmlUtil.escape(title)) %>
											</div>
										</c:otherwise>
									</c:choose>

								<%
								}
								%>

							</c:otherwise>
						</c:choose>
					</c:otherwise>
				</c:choose>
			</c:otherwise>
		</c:choose>
	</c:otherwise>
</c:choose>

<%
JournalArticle latestArticle = null;

try {
	if (articleDisplay != null) {
		latestArticle = JournalArticleLocalServiceUtil.getLatestArticle(articleDisplay.getGroupId(), articleDisplay.getArticleId(), WorkflowConstants.STATUS_ANY);
	}
}
catch (NoSuchArticleException nsae) {
}

DDMTemplate ddmTemplate = null;

if ((articleDisplay != null) && Validator.isNotNull(articleDisplay.getDDMTemplateKey())) {
	ddmTemplate = DDMTemplateLocalServiceUtil.fetchTemplate(articleDisplay.getGroupId(), PortalUtil.getClassNameId(DDMStructure.class), articleDisplay.getDDMTemplateKey(), true);
}

boolean showEditArticleIcon = (latestArticle != null) && JournalArticlePermission.contains(permissionChecker, latestArticle.getGroupId(), latestArticle.getArticleId(), ActionKeys.UPDATE);
boolean showEditTemplateIcon = (ddmTemplate != null) && DDMTemplatePermission.contains(permissionChecker, ddmTemplate, PortletKeys.JOURNAL, ActionKeys.UPDATE);
boolean showSelectArticleIcon = PortletPermissionUtil.contains(permissionChecker, layout, portletDisplay.getId(), ActionKeys.CONFIGURATION);
boolean showAddArticleIcon = showSelectArticleIcon && JournalPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADD_ARTICLE);
boolean showIconsActions = themeDisplay.isSignedIn() && !layout.isLayoutPrototypeLinkActive() && (showEditArticleIcon || showEditTemplateIcon || showSelectArticleIcon || showAddArticleIcon);
%>

<c:if test="<%= showIconsActions && !print && hasViewPermission %>">
	<div class="lfr-meta-actions icons-container">
		<div class="lfr-icon-actions">
			<c:if test="<%= showEditArticleIcon %>">
				<liferay-portlet:renderURL portletName="<%= PortletKeys.JOURNAL %>" var="editURL" windowState="<%= WindowState.MAXIMIZED.toString() %>">
					<portlet:param name="struts_action" value="/journal/edit_article" />
					<portlet:param name="redirect" value="<%= currentURL %>" />
					<portlet:param name="groupId" value="<%= String.valueOf(latestArticle.getGroupId()) %>" />
					<portlet:param name="folderId" value="<%= String.valueOf(latestArticle.getFolderId()) %>" />
					<portlet:param name="articleId" value="<%= latestArticle.getArticleId() %>" />
					<portlet:param name="version" value="<%= String.valueOf(latestArticle.getVersion()) %>" />
				</liferay-portlet:renderURL>

				<liferay-ui:icon
					cssClass="lfr-icon-action lfr-icon-action-edit"
					image="edit"
					label="<%= true %>"
					message="edit"
					url="<%= editURL %>"
				/>
			</c:if>

			<c:if test="<%= showEditTemplateIcon %>">
				<liferay-portlet:renderURL portletName="<%= PortletKeys.DYNAMIC_DATA_MAPPING %>" var="editTemplateURL" windowState="<%= WindowState.MAXIMIZED.toString() %>">
					<portlet:param name="struts_action" value="/dynamic_data_mapping/edit_template" />
					<portlet:param name="redirect" value="<%= currentURL %>" />
					<portlet:param name="refererPortletName" value="<%= PortletKeys.JOURNAL_CONTENT %>" />
					<portlet:param name="groupId" value="<%= String.valueOf(ddmTemplate.getGroupId()) %>" />
					<portlet:param name="templateId" value="<%= String.valueOf(ddmTemplate.getTemplateId()) %>" />
				</liferay-portlet:renderURL>

				<liferay-ui:icon
					cssClass="lfr-icon-action lfr-icon-action-edit-template"
					image="../file_system/small/xml"
					label="<%= true %>"
					message="edit-template"
					url="<%= editTemplateURL %>"
				/>
			</c:if>

			<c:if test="<%= showSelectArticleIcon %>">
				<liferay-ui:icon
					cssClass="lfr-icon-action lfr-icon-action-configuration"
					image="configuration"
					label="<%= true %>"
					message="select-web-content"
					method="get"
					onClick="<%= portletDisplay.getURLConfigurationJS() %>"
					url="<%= portletDisplay.getURLConfiguration() %>"
				/>
			</c:if>

			<c:if test="<%= showAddArticleIcon %>">
				<liferay-portlet:renderURL portletName="<%= PortletKeys.JOURNAL %>" var="addArticleURL" windowState="<%= WindowState.MAXIMIZED.toString() %>">
					<portlet:param name="struts_action" value="/journal/edit_article" />
					<portlet:param name="redirect" value="<%= currentURL %>" />
					<portlet:param name="portletResource" value="<%= portletDisplay.getId() %>" />
					<portlet:param name="groupId" value="<%= String.valueOf(scopeGroupId) %>" />
				</liferay-portlet:renderURL>

				<liferay-ui:icon
					cssClass="lfr-icon-action lfr-icon-action-add"
					image="add_article"
					label="<%= true %>"
					message="add"
					url="<%= addArticleURL %>"
				/>
			</c:if>
		</div>
	</div>
</c:if>

<c:if test="<%= (articleDisplay != null) && hasViewPermission %>">
	<%
		boolean isMeetingPointSite = Boolean.FALSE;
		try 
		{
			Group group = GroupLocalServiceUtil.getGroup(themeDisplay.getScopeGroupId());
			if(group != null)
			{
				String meetingPointSiteNames = com.liferay.portal.kernel.util.PropsUtil.get("meetingpoint.site.names");
				if(meetingPointSiteNames != null && !meetingPointSiteNames.isEmpty())
				{
					String[] siteNames = meetingPointSiteNames.trim().split(StringPool.COMMA);
					if(siteNames != null && siteNames.length > 0)
					{
						for(String siteName : siteNames)
						{
							if(siteName.equalsIgnoreCase(group.getName()))
							{
								isMeetingPointSite = Boolean.TRUE;
							}
						}
					}
				}
			}
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	%>
	<c:choose>
		<c:when test="<%=isMeetingPointSite %>">
			<%
			boolean isFeedbackTemplate = false;
			
			if(Validator.isNotNull(ddmTemplate))
			{	
				String mssTemplateId = ddmTemplate.getTemplateKey();
				String mssTemplateName = ddmTemplate.getName(Locale.US);
				String feedbackChallengeTemplateId = com.liferay.portal.kernel.util.PropsUtil.get("feedback.challenge.template.id");
				
				if(Validator.isNotNull(mssTemplateName) && Validator.isNotNull(feedbackChallengeTemplateId)
						&& mssTemplateName.equalsIgnoreCase(feedbackChallengeTemplateId))
				{
					isFeedbackTemplate = true;
				}
			}
			%>
			<% if(enableComments && !isFeedbackTemplate) { %>
				<div id="rate<%=articleDisplay.getArticleId()%>"></div> 
				<div class="article_comments">
					<h2><liferay-ui:message key="comments.share.your.thoughts" /></h2>
			<% } %>
			
			<%String commentsPageURL = ""; %>
			<% if(enableComments || isFeedbackTemplate) { %>
			
				<%@page import="com.liferay.portlet.expando.model.ExpandoTableConstants" %>
				
				<% 
					
					long plId = themeDisplay.getPlid();
					String pageSectorLevel = "";
					final String COMMENTS_PAGEID_PARAM_NAME = com.liferay.portal.kernel.util.PropsUtil.get("meetingpoint.comments.pageid.param.name");
					final String COMMENTS_ARTICLEID_PARAM_NAME = com.liferay.portal.kernel.util.PropsUtil.get("meetingpoint.comments.articleid.param.name");//"articleId";
					final String PAGE_TYPE_NULL_VALUE = com.liferay.portal.kernel.util.PropsUtil.get("page.type.custom.attribute.null.value");
					
					if(plId > 0)
					{
						/*Get Page Type*/				
						/* Object pageType = MSSCommonsUtil.getObjectExpandoValue(themeDisplay.getCompanyId(), Layout.class.getName(), 
									ExpandoTableConstants.DEFAULT_TABLE_NAME, PropsUtil.get("page.type.custom.attribute.name"), layout.getPlid()); */
						Object pageType = null; 
						try 
						{
							pageType = ExpandoValueLocalServiceUtil.getData(themeDisplay.getCompanyId(), Layout.class.getName(), 
									ExpandoTableConstants.DEFAULT_TABLE_NAME, com.liferay.portal.kernel.util.PropsUtil.get("page.type.custom.attribute.name"), layout.getPlid());
						}
						catch (Exception e) 
						{
							//DO NOTHING
						}
				
						if(pageType != null)
						{
							String[] pageTypeArr = (String[])pageType;
									
							if(pageTypeArr != null & pageTypeArr.length > 0)
							{
								pageSectorLevel = pageTypeArr[0];
											
								if(Validator.isNotNull(pageSectorLevel) && !pageSectorLevel.equalsIgnoreCase(PAGE_TYPE_NULL_VALUE))
								{
									Group group = GroupLocalServiceUtil.getGroup(themeDisplay.getCompanyId(), themeDisplay.getScopeGroupName()); 
									String commentsPageURLSuffix = com.liferay.portal.kernel.util.PropsUtil.get("meetingpoint.comments.page.friendlyurl.suffix");
									commentsPageURL = group.getPathFriendlyURL(false, themeDisplay) + group.getFriendlyURL() + 
														StringPool.SLASH + pageSectorLevel + commentsPageURLSuffix + 
														StringPool.QUESTION + COMMENTS_PAGEID_PARAM_NAME + StringPool.EQUAL +
														themeDisplay.getLayout().getPlid() + StringPool.AMPERSAND + 
														COMMENTS_ARTICLEID_PARAM_NAME + StringPool.EQUAL; 
														
								}
							}
						}
					}
				%>
			<% } %>
							
			<% if(enableComments && !isFeedbackTemplate) { %>
				<div class="comments-rating-container">
					<div class="comments-container">
					<%
						int commentsCount = 0;
						
						try{
							commentsCount = com.liferay.portlet.messageboards.service.MBMessageLocalServiceUtil
							.getDiscussionMessagesCount(JournalArticle.class.getName(), 
									articleDisplay.getResourcePrimKey(), com.liferay.portal.kernel.workflow.WorkflowConstants.STATUS_APPROVED);	
						}catch(Exception e){
							
						}
						
						if(commentsCount > 0){
					%>
						<span class="comments-big-icon" title="Comments Icon">Comments Icon</span>
                        <span class="text-container">
                            <span class="fLeft"><a href="<%= commentsPageURL + articleDisplay.getArticleId()%>"><liferay-ui:message key="comments.view.all" />&nbsp;<span><%=commentsCount%></span>&nbsp;<liferay-ui:message key="comments.view.comments" /></a></span>
                            <span class="comments-small-icon" title="comments Icon">Comments Icon</span>
                            <span>/ <a id ="footercommentlink<%=articleDisplay.getArticleId()%>" href="<%= commentsPageURL + articleDisplay.getArticleId()%>"><liferay-ui:message key="comments.add.comments" /></a></span>
                        </span>
					<% }else{ %>
						<span class="comments-big-icon" title="Comments Icon">Comments Icon</span>
                        <span class="text-container">
                            <span class="fLeft"><a href="<%= commentsPageURL + articleDisplay.getArticleId()%>"><liferay-ui:message key="comments.view.all" />&nbsp;<liferay-ui:message key="comments.view.comments" /></a></span>
                            <span class="comments-small-icon" title="comments Icon">Comments Icon</span>
                            <span>/ <a id ="footercommentlink<%=articleDisplay.getArticleId()%>" href="<%= commentsPageURL + articleDisplay.getArticleId()%>"><liferay-ui:message key="comments.add.comments" /></a></span>
                        </span>
					<% } %>
				</div><!-- end of comments-container -->
				
				<c:if test="<%= enableRelatedAssets %>">
					<div class="entry-links">
						<liferay-ui:asset-links
							className="<%= JournalArticle.class.getName() %>"
							classPK="<%= articleDisplay.getResourcePrimKey() %>"
						/>
					</div>
				</c:if>
			
				<c:if test="<%= enableRatings && !print %>">
					<div class="ratings-tips-container">
                         <div class="ratings-container">
                            <span class="ratings-big-icon" title="Ratings Icon">Comments Icon</span>
                            <div class="comments-aui-ratings">					
                            	<div class="taglib-ratings-wrapper">
									<liferay-ui:ratings
										className="<%= JournalArticle.class.getName() %>"
										classPK="<%= articleDisplay.getResourcePrimKey() %>"
									/>
								</div>
							</div>
                         </div><!-- end of ratings container-->
                         <div class="tips-container fLeft">
                         	<span class="tips-icon" title="Tips Icon">Tips Icon</span>
                            <span class="tips-text-container"><liferay-ui:message key="comments.rate.comments" /></span>
                         </div><!--end of tips container  -->
                     </div><!--end of ratings-tips container  -->
				</c:if>
				</div>	<!-- end of comments-rating-container -->	
				<div class="clear"></div>
				</div>	<!--end of article comments -->			
			<% } else if(isFeedbackTemplate) { 
			
				int challengeCommentsCount = com.liferay.portlet.messageboards.service.MBMessageLocalServiceUtil
						.getDiscussionMessagesCount(JournalArticle.class.getName(), 
								articleDisplay.getResourcePrimKey(), com.liferay.portal.kernel.workflow.WorkflowConstants.STATUS_APPROVED);	
			%>				
				<script type="text/javascript">				
				
					function getElementsByClassName(node, classname) {
					
				    	var a = [];
				    	var re = new RegExp('(^| )'+classname+'( |$)');
				    	var els = node.getElementsByTagName("*");
				    	for(var i=0,j=els.length; i<j; i++)
				    	{
				    		if(re.test(els[i].className))
				    		{
				    			a.push(els[i]);
				    		}
				    	}
				        	
				    	return a;
					}				
					var feedbackChallengeCommentLinks = getElementsByClassName(document.body, "feedback_challenge_comments_link");
					
					for (var i = 0; i < feedbackChallengeCommentLinks.length; i++) {
						feedbackChallengeCommentLinks[i].href = '<%= commentsPageURL %>' + feedbackChallengeCommentLinks[i].id;
					}
					var commentCount = "<%=challengeCommentsCount%>";
					if(commentCount > 0){
						jQuery('.feedback_challenge_comments_link').find('span').html(commentCount+'&nbsp');
					}
				</script>
				<c:if test="<%= enableRelatedAssets %>">
					<div class="entry-links">
						<liferay-ui:asset-links
							className="<%= JournalArticle.class.getName() %>"
							classPK="<%= articleDisplay.getResourcePrimKey() %>"
						/>
					</div>
				</c:if>
			
				<c:if test="<%= enableRatings && !print %>">
					<div class="taglib-ratings-wrapper">
						<liferay-ui:ratings
							className="<%= JournalArticle.class.getName() %>"
							classPK="<%= articleDisplay.getResourcePrimKey() %>"
						/>
					</div>
				</c:if>
			<% } %>
		</c:when>
		<c:otherwise>
			<c:if test="<%= enableRelatedAssets %>">
				<div class="entry-links">
					<liferay-ui:asset-links
						className="<%= JournalArticle.class.getName() %>"
						classPK="<%= articleDisplay.getResourcePrimKey() %>"
					/>
				</div>
			</c:if>
		
			<c:if test="<%= enableRatings && !print %>">
				<div class="taglib-ratings-wrapper">
					<liferay-ui:ratings
						className="<%= JournalArticle.class.getName() %>"
						classPK="<%= articleDisplay.getResourcePrimKey() %>"
					/>
				</div>
			</c:if>
		
			<c:if test="<%= enableComments %>">
		
				<%
				int discussionMessagesCount = MBMessageLocalServiceUtil.getDiscussionMessagesCount(PortalUtil.getClassNameId(JournalArticle.class.getName()), articleDisplay.getResourcePrimKey(), WorkflowConstants.STATUS_APPROVED);
				%>
		
				<c:if test="<%= discussionMessagesCount > 0 %>">
					<liferay-ui:header
						title="comments"
					/>
				</c:if>
		
				<portlet:actionURL var="discussionURL">
					<portlet:param name="struts_action" value="/journal_content/edit_article_discussion" />
				</portlet:actionURL>
		
				<liferay-ui:discussion
					className="<%= JournalArticle.class.getName() %>"
					classPK="<%= articleDisplay.getResourcePrimKey() %>"
					formAction="<%= discussionURL %>"
					hideControls="<%= print %>"
					ratingsEnabled="<%= enableCommentRatings && !print %>"
					redirect="<%= currentURL %>"
					userId="<%= articleDisplay.getUserId() %>"
				/>
			</c:if>
		</c:otherwise>
	</c:choose>
</c:if>
