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

<%@page import="java.lang.reflect.Array"%>
<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@page import="java.util.Calendar"%>
<%
	String hidePermission = "false";
	String hideAbstract = "false";
	String hideCustomFields = "false";
	String hideCategorization = "false";
	String hideSchedule = "false";
	String hideDisplayPage = "false";
	String hideRelatedAssets = "false";
	String previewURL = null;
	Calendar calendar = CalendarFactoryUtil.getCalendar(user.getTimeZone());
	int displayDateMonth = calendar.get(Calendar.MONTH);
	int displayDateDay = calendar.get(Calendar.DAY_OF_MONTH);
	int displayDateYear = calendar.get(Calendar.YEAR);
	int displayDateHour = calendar.get(Calendar.HOUR_OF_DAY);
	int displayDateMinute = calendar.get(Calendar.MINUTE);
	
	if(!"true".equals(noCustom)) {
		hidePermission = portletSetup.getValue("hidePermission","false");
		hideAbstract = portletSetup.getValue("hideAbstract","false");
		hideCustomFields = portletSetup.getValue("hideCustomFields","false");
		hideCategorization = portletSetup.getValue("hideCategorization","false");
		hideSchedule = portletSetup.getValue("hideSchedule","false");
		hideDisplayPage = portletSetup.getValue("hideDisplayPage","false");
		hideRelatedAssets = portletSetup.getValue("hideRelatedAssets","false");
		previewURL = portletSetup.getValue("previewURL",null);
	}
	
	List<String> customSections = new ArrayList<String>();
	for(String section : mainSections) {
		if("permissions".equals(section) && hidePermission.equals("true")) {
			continue;
		} else if("abstract".equals(section) && hideAbstract.equals("true")) {
			continue;
		} else if("custom-fields".equals(section) && hideCustomFields.equals("true")) {
			continue;
		} else if("categorization".equals(section) && hideCategorization.equals("true")) {
			continue;
		} else if("schedule".equals(section) && hideSchedule.equals("true")) {
			continue;
		} else if("display-page".equals(section) && hideDisplayPage.equals("true")) {
			continue;
		} else if("related-assets".equals(section) && hideRelatedAssets.equals("true")) {
			continue;
		}
		
		customSections.add(section);
	}
	mainSections = customSections.toArray(new String[customSections.size()]);
	String[][] categorySections = {mainSections};
	
%>
<div class="article-form <%= ((article != null) && !article.isNew()) ? "article-form-edit" : "article-form-add" %>">
	<c:if test="<%= showHeader %>">
		<liferay-util:include page="/html/portlet/journal/article_header.jsp" />
	</c:if>

	<aui:form enctype="multipart/form-data" method="post" name="fm2">
		<input name="groupId" type="hidden" value="" />
		<input name="articleId" type="hidden" value="" />
		<input name="version" type="hidden" value="" />
		<input name="title" type="hidden" value="" />
		<input name="xml" type="hidden" value="" />
	</aui:form>

	<portlet:actionURL var="editArticleActionURL" windowState="<%= WindowState.MAXIMIZED.toString() %>">
		<portlet:param name="struts_action" value="/journal/edit_article" />
	</portlet:actionURL>

	<portlet:renderURL var="editArticleRenderURL" windowState="<%= WindowState.MAXIMIZED.toString() %>">
		<portlet:param name="struts_action" value="/journal/edit_article" />
	</portlet:renderURL>

	<aui:form action="<%= editArticleActionURL %>" cssClass="lfr-dynamic-form" enctype="multipart/form-data" method="post" name="fm1" onSubmit='<%= renderResponse.getNamespace() + "submitForm(event);" %>'>
		<aui:input name="<%= Constants.CMD %>" type="hidden" />
		<aui:input name="tabs2" type="hidden" value="<%= tabs2 %>" />
		<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
		<aui:input name="backURL" type="hidden" value="<%= backURL %>" />
		<aui:input name="portletResource" type="hidden" value="<%= portletResource %>" />
		<aui:input name="referringPortletResource" type="hidden" value="<%= referringPortletResource %>" />
		<aui:input name="groupId" type="hidden" value="<%= groupId %>" />
		<aui:input name="privateLayout" type="hidden" value="<%= layout.isPrivateLayout() %>" />
		<aui:input name="folderId" type="hidden" value="<%= folderId %>" />
		<aui:input name="classNameId" type="hidden" value="<%= classNameId %>" />
		<aui:input name="classPK" type="hidden" value="<%= classPK %>" />
		<aui:input name="articleId" type="hidden" value="<%= articleId %>" />
		<aui:input name="articleIds" type="hidden" value="<%= articleId + EditArticleAction.VERSION_SEPARATOR + version %>" />
		<aui:input name="version" type="hidden" value="<%= ((article == null) || article.isNew()) ? version : article.getVersion() %>" />
		<aui:input name="languageId" type="hidden" value="<%= Validator.isNotNull(toLanguageId) ? toLanguageId : defaultLanguageId %>" />
		<aui:input name="articleURL" type="hidden" value="<%= editArticleRenderURL %>" />
		<aui:input name="ddmStructureId" type="hidden" />
		<aui:input name="ddmTemplateId" type="hidden" />
		<aui:input name="workflowAction" type="hidden" value="<%= String.valueOf(WorkflowConstants.ACTION_SAVE_DRAFT) %>" />
		
		<c:if test='<%= hideSchedule.equals("true") %>'>
			<aui:input name="displayDateDay" type="hidden" value="<%= displayDateDay %>" />
			<aui:input name="displayDateMonth" type="hidden" value="<%= displayDateMonth %>" />
			<aui:input name="displayDateYear" type="hidden" value="<%= displayDateYear %>" />
			<aui:input name="displayDateHour" type="hidden" value="<%= displayDateHour %>" />
			<aui:input name="displayDateMinute" type="hidden" value="<%= displayDateMinute %>" />
			<aui:input name="neverExpire" type="hidden" value="true" />
			<aui:input name="neverReview" type="hidden" value="true" />
		</c:if>

		<liferay-ui:error exception="<%= ArticleContentSizeException.class %>" message="you-have-exceeded-the-maximum-web-content-size-allowed" />

		<aui:model-context bean="<%= article %>" defaultLanguageId="<%= defaultLanguageId %>" model="<%= JournalArticle.class %>" />

		<div class="journal-article-wrapper" id="<portlet:namespace />journalArticleWrapper">
			<div class="journal-article-wrapper-content">
				<c:if test="<%= Validator.isNull(toLanguageId) %>">
					<c:if test="<%= (article != null) && !article.isNew() %>">
						<aui:workflow-status id="<%= String.valueOf(article.getArticleId()) %>" status="<%= article.getStatus() %>" version="<%= String.valueOf(article.getVersion()) %>" />

						<liferay-util:include page="/html/portlet/journal/article_toolbar.jsp" />
					</c:if>
				</c:if>

				<liferay-util:buffer var="htmlTop">
					<c:if test="<%= article != null %>">
						<div class="article-info">
							<div class="float-container">
								<c:if test="<%= article.isSmallImage() %>">
									<img alt="" class="article-image" src="<%= HtmlUtil.escape(article.getArticleImageURL(themeDisplay)) %>" width="150" />
								</c:if>

								<c:if test="<%= !article.isNew() %>">
									<span class="article-name"><%= HtmlUtil.escape(article.getTitle(locale)) %></span>
								</c:if>
							</div>
						</div>
					</c:if>
				</liferay-util:buffer>

				<liferay-util:buffer var="htmlBottom">

					<%
					boolean approved = false;
					boolean pending = false;

					if ((article != null) && (version > 0)) {
						approved = article.isApproved();

						if (WorkflowDefinitionLinkLocalServiceUtil.hasWorkflowDefinitionLink(themeDisplay.getCompanyId(), scopeGroupId, JournalArticle.class.getName())) {
							pending = article.isPending();
						}
					}
					%>

					<c:if test="<%= approved %>">
						<div class="alert alert-info">
							<liferay-ui:message key="a-new-version-will-be-created-automatically-if-this-content-is-modified" />
						</div>
					</c:if>

					<c:if test="<%= pending %>">
						<div class="alert alert-info">
							<liferay-ui:message key="there-is-a-publication-workflow-in-process" />
						</div>
					</c:if>

					<aui:button-row cssClass="journal-article-button-row">

						<%
						boolean hasSavePermission = false;

						if (article != null) {
							hasSavePermission = JournalArticlePermission.contains(permissionChecker, article, ActionKeys.UPDATE);
						}
						else {
							hasSavePermission = JournalFolderPermission.contains(permissionChecker, groupId, folderId, ActionKeys.ADD_ARTICLE);
						}

						String saveButtonLabel = "save";

						if ((article == null) || article.isDraft() || article.isApproved()) {
							saveButtonLabel = "save-as-draft";
						}

						String publishButtonLabel = "publish";

						if (WorkflowDefinitionLinkLocalServiceUtil.hasWorkflowDefinitionLink(themeDisplay.getCompanyId(), groupId, JournalArticle.class.getName())) {
							publishButtonLabel = "submit-for-publication";
						}

						if (classNameId > JournalArticleConstants.CLASSNAME_ID_DEFAULT) {
							publishButtonLabel = "save";
						}
						%>

						<c:choose>
							<c:when test="<%= Validator.isNull(toLanguageId) %>">
								<c:if test="<%= hasSavePermission %>">
									<c:if test="<%= classNameId == JournalArticleConstants.CLASSNAME_ID_DEFAULT %>">
										<aui:button name="saveButton" onClick='<%= renderResponse.getNamespace() + "saveArticle()" %>' primary="<%= false %>" type="submit" value="<%= saveButtonLabel %>" />
									</c:if>

									<aui:button disabled="<%= pending %>" name="publishButton" onClick='<%= renderResponse.getNamespace() + "publishArticle()" %>' type="submit" value="<%= publishButtonLabel %>" />
								</c:if>
							</c:when>
							<c:otherwise>
								<aui:button name="translateButton" onClick='<%= renderResponse.getNamespace() + "translateArticle()" %>' type="submit" value="save" />

								<%
								String[] translations = article.getAvailableLanguageIds();
								%>

								<aui:button disabled="<%= toLanguageId.equals(defaultLanguageId) || !ArrayUtil.contains(translations, toLanguageId) %>" name="removeArticleLocaleButton" onClick='<%= renderResponse.getNamespace() + "removeArticleLocale();" %>' value="remove-translation" />
							</c:otherwise>
						</c:choose>
						<aui:button href="<%= redirect %>" type="cancel" />
					</aui:button-row>
				</liferay-util:buffer>

				<c:choose>
					<c:when test="<%= Validator.isNull(toLanguageId) %>">
						<liferay-ui:form-navigator
							categoryNames="<%= _CATEGORY_NAMES %>"
							categorySections="<%= categorySections %>"
							formName="fm1"
							htmlBottom="<%= htmlBottom %>"
							htmlTop="<%= htmlTop %>"
							jspPath="/html/portlet/journal/article/"
							showButtons="<%= false %>"
						/>
					</c:when>
					<c:otherwise>

						<%
						for (String section : mainSections) {
						%>

							<div class="form-section">
								<liferay-util:include page='<%= "/html/portlet/journal/article/" + _getSectionJsp(section) + ".jsp" %>' />
							</div>

						<%
						}
						%>

						<%= htmlBottom %>

					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</aui:form>
</div>

<c:if test='<%= (article != null) && SessionMessages.contains(renderRequest, "previewRequested") %>'>
	 <c:choose>
		  	<c:when test="<%= Validator.isNull(previewURL) %>">
					<aui:script use="liferay-journal-preview">
						<liferay-portlet:renderURL plid="<%= JournalUtil.getPreviewPlid(article, themeDisplay) %>" var="previewArticleContentURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
							<portlet:param name="struts_action" value="/journal/preview_article_content" />
							<portlet:param name="groupId" value="<%= String.valueOf(article.getGroupId()) %>" />
							<portlet:param name="articleId" value="<%= article.getArticleId() %>" />
							<portlet:param name="version" value="<%= String.valueOf(article.getVersion()) %>" />
						</liferay-portlet:renderURL>
				
						Liferay.fire(
							'previewArticle',
							{
								title: '<%= HtmlUtil.escapeJS(article.getTitle(locale)) %>',
								uri: '<%= HtmlUtil.escapeJS(previewArticleContentURL.toString()) %>'
							}
						);
					</aui:script>
			</c:when>
			<c:when test="<%= !Validator.isNull(previewURL) %>">
					<aui:script use="liferay-journal-preview">
						Liferay.fire(
							'previewArticle',
							{
								title: '<%= HtmlUtil.escapeJS(article.getTitle(locale)) %>',
								uri: '<%= HtmlUtil.escapeJS(previewURL + article.getArticleId()) %>&preview=true&version=<%=article.getVersion()%>'
							}
						);
					</aui:script>
			</c:when>					
	 </c:choose>
				  
</c:if>