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


<%@ include file="/html/portlet/polls_display/init.jsp" %>
<div class="sidecol modules alignright">

<%

PollsQuestion question = (PollsQuestion)request.getAttribute(WebKeys.POLLS_QUESTION);
%>
<c:choose>
	<c:when test="<%= question == null %>">
		<div class="poll">
	<h3 >AMEA Poll</h3>
	<div class="pollContent"> 
		<%
		renderRequest.setAttribute(WebKeys.PORTLET_CONFIGURATOR_VISIBILITY, Boolean.TRUE);
		%>

		<div class="alert alert-info portlet-configuration">
			<a href="<%= portletDisplay.getURLConfiguration() %>" onClick="<%= portletDisplay.getURLConfigurationJS() %>">
				<liferay-ui:message key="please-configure-this-portlet-to-make-it-visible-to-all-users" />
			</a>
		</div>
		</div>
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

		<aui:form action="<%= voteQuestionURL %>" method="post" name="fm">
			<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.VOTE %>" />
			<aui:input name="redirect" type="hidden" value="<%= currentURL %>" />
			<aui:input name="questionId" type="hidden" value="<%= question.getQuestionId() %>" />
			<aui:input name="successMessage" type="hidden" value='<%= LanguageUtil.get(pageContext, "thank-you-for-your-vote") %>' />

			<liferay-ui:error exception="<%= DuplicateVoteException.class %>" message="you-may-only-vote-once" />
			<liferay-ui:error exception="<%= NoSuchChoiceException.class %>" message="please-select-an-option" />
			

			<c:choose>
				<c:when test="<%= !question.isExpired() && !hasVoted && PollsQuestionPermission.contains(permissionChecker, question, ActionKeys.ADD_VOTE) %>">
					<div class="poll">
					<h3 >AMEA Poll</h3>
					<div class="pollContent"> 
					<div class="ameaPoll">
					<p><%= StringUtil.replace(question.getDescription(locale), StringPool.NEW_LINE, "<br />") %></p>
					
							<div class="formContent">
							<%
							for (PollsChoice choice : choices) {
								choice = choice.toEscapedModel();
							%>
								<p>
								<input type="radio" name="<portlet:namespace/>choiceId" value="<%= choice.getChoiceId() %>">
										<span><%=choice.getDescription(locale) %></span></p>
								<%-- <aui:input label='<%= "<strong>" + choice.getName() + ".</strong> " + choice.getDescription(locale) %>' name="choiceId" type="radio" value="<%= choice.getChoiceId() %>" /> --%>

							<%
							}
							%>
							</div>
						
						</div>
						<div class="poll-vote">
						<%-- 	<span><%=question.getVotesCount()%> people voted...</span> --%>
							<button type="submit">Vote</button>
							<!-- <aui:button type="submit" value="vote[action]" /> -->
						</div>
					</div>
					</div>
					
				</c:when>
				
				<c:otherwise>
				<div class="poll ameaPolldiv">
					<h3 >AMEA Poll</h3>
					<div class="pollContent pollTable"> 
					<div class="ameaPoll viewpoll">
					<p><%= StringUtil.replace(question.getDescription(locale), StringPool.NEW_LINE, "<br />") %></p>
					</div>
					<div class="poll-vote">
					<%@ include file="/html/portlet/polls/view_question_results.amea-comm-hook.jspf" %>

					<c:if test="<%= !themeDisplay.isSignedIn() && !question.isExpired() && !PollsQuestionPermission.contains(permissionChecker, question, ActionKeys.ADD_VOTE) %>">
						<div class="alert alert-info">
							<a href="<%= themeDisplay.getURLSignIn() %>" target="_top"><liferay-ui:message key="please-sign-in-to-vote" /></a>
						</div>
					</c:if>
					</div>
					</div>
					</div>
				</c:otherwise>
			</c:choose>
			
		</aui:form>
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
				<liferay-portlet:renderURL doAsGroupId="<%= scopeGroupId %>" plid="<%= controlPanelPlid %>" portletName="<%= PortletKeys.POLLS %>" refererPlid="<%= plid %>" var="editPollURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
					<liferay-portlet:param name="struts_action" value="/polls/edit_question" />
					<liferay-portlet:param name="redirect" value="<%= redirectURL.toString() %>" />
					<liferay-portlet:param name="referringPortletResource" value="<%= portletDisplay.getId() %>" />
					<liferay-portlet:param name="questionId" value="<%= String.valueOf(question.getQuestionId()) %>" />
				</liferay-portlet:renderURL>

				<%
				String editQuestionURL = "javascript:Liferay.Util.openWindow({id: '" + liferayPortletResponse.getNamespace() + "editQuestion', title: '" + UnicodeFormatter.toString(ResourceActionsUtil.getModelResource(locale, PollsQuestion.class.getName())) + "', uri:'" + HtmlUtil.escapeURL(editPollURL.toString()) + "'});";
				%>

				<liferay-ui:icon
					cssClass="lfr-icon-action lfr-icon-action-edit"
					image="edit"
					label="<%= true %>"
					message="edit-question"
					url="<%= editQuestionURL %>"
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
				<liferay-portlet:renderURL doAsGroupId="<%= scopeGroupId %>" plid="<%= controlPanelPlid %>" portletName="<%= PortletKeys.POLLS %>" refererPlid="<%= plid %>" var="addPollURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
					<liferay-portlet:param name="struts_action" value="/polls/edit_question" />
					<liferay-portlet:param name="redirect" value="<%= redirectURL.toString() %>" />
					<liferay-portlet:param name="referringPortletResource" value="<%= portletDisplay.getId() %>" />
				</liferay-portlet:renderURL>

				<%
				String addQuestionURL = "javascript:Liferay.Util.openWindow({id: '" + liferayPortletResponse.getNamespace() + "editQuestion', title: '" + UnicodeFormatter.toString(ResourceActionsUtil.getModelResource(locale, PollsQuestion.class.getName())) + "', uri:'" + HtmlUtil.escapeURL(addPollURL.toString()) + "'});";
				%>

				<liferay-ui:icon
					cssClass="lfr-icon-action lfr-icon-action-add"
					image="add_article"
					label="<%= true %>"
					message="add-question"
					url="<%= addQuestionURL %>"
				/>
			</c:if>
		</div>
	</div>
</c:if>

</div>
<script>
jQuery(function(){   
  jQuery('.formContent input[type="radio"]').each(function(){
  	jQuery(this).prettyCheckable();
  });
});
</script>