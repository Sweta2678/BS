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
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.model.Group"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portlet.asset.service.AssetTagLocalServiceUtil"%>
<%@ include file="/html/portlet/polls_display/init.jsp" %>

<%
PollsQuestion question = (PollsQuestion)request.getAttribute(WebKeys.POLLS_QUESTION);
%>

<c:choose>
	<c:when test="<%= question == null %>">

		<%
		renderRequest.setAttribute(WebKeys.PORTLET_CONFIGURATOR_VISIBILITY, Boolean.TRUE);
		%>

		<div class="alert alert-info portlet-configuration">
			<a href="<%= portletDisplay.getURLConfiguration() %>" onClick="<%= portletDisplay.getURLConfigurationJS() %>">
				<liferay-ui:message key="please-configure-this-portlet-to-make-it-visible-to-all-users" />
			</a>
		</div>
	</c:when>
	<c:otherwise>

		<%
		String redirect = StringPool.BLANK;

		question = question.toEscapedModel();

		List<PollsChoice> choices = question.getChoices();

		boolean hasVoted = PollsUtil.hasVoted(request, question.getQuestionId());
		%>

		<portlet:actionURL var="voteQuestionURL">
			<portlet:param name="struts_action" value="/polls_display/vote_question" />
		</portlet:actionURL>

<%
	String[] tags = AssetTagLocalServiceUtil.getTagNames(Group.class.getName(), themeDisplay.getScopeGroupId());
	boolean flag = false;
	for(String tag : tags)
	{
		if(tag.equals("conference"))
		{
			flag = true;
			break;
		}
	}

	if(flag)
	{
%>

		<aui:form action="<%= voteQuestionURL %>" method="post" name="fm">
			<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.VOTE %>" />
			<aui:input name="redirect" type="hidden" value="<%= currentURL %>" />
			<aui:input name="questionId" type="hidden" value="<%= question.getQuestionId() %>" />
			
			<div class="addi_rightInfo">
				<h5>Poll</h5>
				<!--contentainer started-->
				<liferay-ui:error exception="<%= DuplicateVoteException.class %>" message="you-may-only-vote-once" />
				<liferay-ui:error exception="<%= NoSuchChoiceException.class %>" message="please-select-an-option" />
			
				<c:if test="<%= question.getExpirationDate()==null %>">	
					<aui:input name="successMessage" type="hidden" value='Thanks for voting!' />
				</c:if>
			
				<div class="latest-res"> 
					<!--content box started-->
					<ul>
						<li> 
						    <div class="poll_Q">
						  	  <div class="latest-res-left"><span class="number" style="padding-top: 7px;">Q</span></div>
							  <div class="latest-res-right poll"><span href="#" class="bold"><b><%=StringUtil.replace(question.getDescription(locale), StringPool.NEW_LINE, "<br />")%></b></span></div>
							</div>
							<div class="poll_Choices row">
								<c:choose>
									<c:when test="<%= !question.isExpired() && !hasVoted && PollsQuestionPermission.contains(permissionChecker, question, ActionKeys.ADD_VOTE) %>">
												<%
												for (PollsChoice choice : choices) {
													choice = choice.toEscapedModel();
												%>
													<input type="radio"	name="<portlet:namespace />choiceId" value="<%=choice.getChoiceId()%>"/>
													<label for="choiceId"><%=choice.getDescription(locale)%></label> <br>
												<%
												}
												%>
											<aui:button type="submit" value="vote[action]" class="poll_Vote" />
									</c:when>
									<c:otherwise>
										<c:choose>
											<c:when test="<%= question.getExpirationDate()!=null &&  !question.isExpired()%>">
												<c:choose>
													<c:when test="<%=PollsQuestionPermission.contains(permissionChecker, question, ActionKeys.ADD_VOTE)%>">
														<div class="portlet-msg-success">Thanks for voting!</div>
													</c:when>
													<c:otherwise>
														<div class="portlet-msg-success">Result will be displayed soon.</div>
													</c:otherwise>
												</c:choose>
											</c:when>
											<c:otherwise>
												<%@ include file="/html/portlet/polls_display/ihgamer_ResultDisplay.me2-conf-hook.jsp"%>
											</c:otherwise>
										</c:choose>
										<c:if test="<%= !themeDisplay.isSignedIn() && !question.isExpired() && !PollsQuestionPermission.contains(permissionChecker, question, ActionKeys.ADD_VOTE) %>">
											<div class="alert alert-info">
												<a href="<%= themeDisplay.getURLSignIn() %>" target="_top"><liferay-ui:message key="please-sign-in-to-vote" /></a>
											</div>
										</c:if>
									</c:otherwise>
								</c:choose>
							</div>
						</li>
					</ul>	
				</div>
			</div>		
		</aui:form>
<%
}
else
{	
%>
	<aui:form action="<%= voteQuestionURL %>" method="post" name="fm">
		<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.VOTE %>" />
		<aui:input name="redirect" type="hidden" value="<%= currentURL %>" />
		<aui:input name="questionId" type="hidden" value="<%= question.getQuestionId() %>" />
		
		<div class = "rightpanel">
			<div class="poll_vote">
				<div class = "poll_img">Poll Icon</div>
					<h2>Polls</h2>
					<!--contentainer started-->
					<liferay-ui:error exception="<%= DuplicateVoteException.class %>" message="you-may-only-vote-once" />
					<liferay-ui:error exception="<%= NoSuchChoiceException.class %>" message="please-select-an-option" />
					<c:if test="<%= question.getExpirationDate()==null %>">
						<aui:input name="successMessage" type="hidden" value='Thanks for voting!' />
					</c:if>	

					<div class="portlet-sub-container ">
			
						<!--content box started-->
						<div class="poll_text" >
							<%= StringUtil.replace(question.getDescription(locale), StringPool.NEW_LINE, "<br />") %></p></div>
							<div class = "poll_options">
								<c:choose>
									<c:when test="<%= !question.isExpired() && !hasVoted && PollsQuestionPermission.contains(permissionChecker, question, ActionKeys.ADD_VOTE) %>">
										<ul>
												<%
												for (PollsChoice choice : choices) {
													choice = choice.toEscapedModel();
												%>
												<li>
													<input style="margin-right:8px;" type="radio" class = "grsPollVoteRadioBtn" name="<portlet:namespace />choiceId" value="<%=choice.getChoiceId()%>"><%=choice.getDescription(locale)%>
												</li>
												<%
												}
												%>
										</ul>
										<div class = "poll_submit">
												<button class="button">VOTE</button>
												<!-- <span><a>See the Result!</a></span> -->
										</div>
									</c:when>
									<c:otherwise>
										<c:choose>
											<c:when test="<%= question.getExpirationDate()!=null &&  !question.isExpired()%>">
												<c:choose>
													<c:when test="<%=PollsQuestionPermission.contains(permissionChecker, question, ActionKeys.ADD_VOTE)%>">
														<div class="portlet-msg-success">Thanks for voting!</div>
													</c:when>
													<c:otherwise>
														<div class="portlet-msg-success">Result will be displayed soon.</div>
													</c:otherwise>
												</c:choose>
											</c:when>
											<c:otherwise>
												<%@ include file="/html/portlet/polls_display/ihgamer_ResultDisplay.me2-conf-hook.jsp"%>
											</c:otherwise>
										</c:choose>
										<c:if test="<%= !themeDisplay.isSignedIn() && !question.isExpired() && !PollsQuestionPermission.contains(permissionChecker, question, ActionKeys.ADD_VOTE) %>">
											<div class="alert alert-info">
												<a href="<%= themeDisplay.getURLSignIn() %>" target="_top"><liferay-ui:message key="please-sign-in-to-vote" /></a>
											</div>
										</c:if>
									</c:otherwise>
								</c:choose>
							</div>
							<!--content box ended-->
						</div>	
					</div>
				</div>
	</aui:form>
<%
	}
%>
	</c:otherwise>
</c:choose>

<%
boolean hasConfigurationPermission = PortletPermissionUtil.contains(permissionChecker, layout, portletDisplay.getId(), ActionKeys.CONFIGURATION);

boolean hasViewPermission = true;

if (question != null) {
	hasViewPermission = PollsQuestionPermission.contains(permissionChecker, question, ActionKeys.VIEW);
}

boolean showAddPollIcon = hasConfigurationPermission && PollsPermission.contains(permissionChecker, scopeGroupId, ActionKeys.ADD_QUESTION);
boolean showEditPollIcon = (question != null) && PollsQuestionPermission.contains(permissionChecker, question, ActionKeys.UPDATE);
boolean showIconsActions = themeDisplay.isSignedIn() && (hasConfigurationPermission || showEditPollIcon || showAddPollIcon);
%>

<c:if test="<%= hasViewPermission && showIconsActions %>">

	<%
	long controlPanelPlid = PortalUtil.getControlPanelPlid(company.getCompanyId());

	PortletURL redirectURL = liferayPortletResponse.createRenderURL();

	redirectURL.setParameter("struts_action", "/polls_display/add_question_redirect");
	redirectURL.setWindowState(LiferayWindowState.POP_UP);
	%>

	<div class="lfr-meta-actions icons-container">
		<div class="lfr-icon-actions">
			<c:if test="<%= showEditPollIcon %>">
				<liferay-portlet:renderURL doAsGroupId="<%= scopeGroupId %>" plid="<%= controlPanelPlid %>" portletName="<%= PortletKeys.POLLS %>" refererPlid="<%= plid %>" var="editQuestionURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
					<liferay-portlet:param name="struts_action" value="/polls/edit_question" />
					<liferay-portlet:param name="redirect" value="<%= redirectURL.toString() %>" />
					<liferay-portlet:param name="referringPortletResource" value="<%= portletDisplay.getId() %>" />
					<liferay-portlet:param name="questionId" value="<%= String.valueOf(question.getQuestionId()) %>" />
				</liferay-portlet:renderURL>

				<%
				String taglibEditQuestionURL = "javascript:Liferay.Util.openWindow({id: '" + liferayPortletResponse.getNamespace() + "editQuestion', title: '" + HtmlUtil.escapeJS(ResourceActionsUtil.getModelResource(locale, PollsQuestion.class.getName())) + "', uri:'" + HtmlUtil.escapeJS(editQuestionURL.toString()) + "'});";
				%>

				<liferay-ui:icon
					cssClass="lfr-icon-action lfr-icon-action-edit"
					image="edit"
					label="<%= true %>"
					message="edit-question"
					url="<%= taglibEditQuestionURL %>"
				/>
			</c:if>

			<c:if test="<%= hasConfigurationPermission %>">
				<liferay-ui:icon
					cssClass="lfr-icon-action lfr-icon-action-configuration"
					image="configuration"
					label="<%= true %>"
					message="select-question"
					method="get"
					onClick="<%= portletDisplay.getURLConfigurationJS() %>"
					url="<%= portletDisplay.getURLConfiguration() %>"
				/>
			</c:if>

			<c:if test="<%= showAddPollIcon %>">
				<liferay-portlet:renderURL doAsGroupId="<%= scopeGroupId %>" plid="<%= controlPanelPlid %>" portletName="<%= PortletKeys.POLLS %>" refererPlid="<%= plid %>" var="editQuestionURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
					<liferay-portlet:param name="struts_action" value="/polls/edit_question" />
					<liferay-portlet:param name="redirect" value="<%= redirectURL.toString() %>" />
					<liferay-portlet:param name="referringPortletResource" value="<%= portletDisplay.getId() %>" />
				</liferay-portlet:renderURL>

				<%
				String taglibEditQuestionURL = "javascript:Liferay.Util.openWindow({id: '" + liferayPortletResponse.getNamespace() + "editQuestion', title: '" + HtmlUtil.escapeJS(ResourceActionsUtil.getModelResource(locale, PollsQuestion.class.getName())) + "', uri:'" + HtmlUtil.escapeJS(editQuestionURL.toString()) + "'});";
				%>

				<liferay-ui:icon
					cssClass="lfr-icon-action lfr-icon-action-add"
					image="add_article"
					label="<%= true %>"
					message="add-question"
					url="<%= taglibEditQuestionURL %>"
				/>
			</c:if>
		</div>
	</div>
</c:if>