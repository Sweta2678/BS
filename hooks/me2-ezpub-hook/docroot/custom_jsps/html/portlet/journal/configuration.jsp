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
<%@page import="com.liferay.portal.service.PortletPreferencesLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@ include file="/html/portlet/journal/init.jsp" %>

<%
String tabs2 = ParamUtil.getString(request, "tabs2", "email-from");
String redirect = ParamUtil.getString(request, "redirect");
if(request.getParameter("easyPublishTab")!=null){
	portletPreferences.setValue("noCustom", ParamUtil.getString(request,"noCustom","false"));
	portletPreferences.setValue("hideLocalized", ParamUtil.getString(request,"hideLocalized","false"));
	portletPreferences.setValue("hideLanguage", ParamUtil.getString(request,"hideLanguage","false"));
	portletPreferences.setValue("hideStructure", ParamUtil.getString(request,"hideStructure","false"));
	portletPreferences.setValue("hideTemplate", ParamUtil.getString(request,"hideTemplate","false"));
	portletPreferences.setValue("hideSchedule", ParamUtil.getString(request,"hideSchedule","false"));
	portletPreferences.setValue("hideSearchable", ParamUtil.getString(request,"hideSearchable","false"));
	portletPreferences.setValue("hidePermission", ParamUtil.getString(request,"hidePermission","false"));
	portletPreferences.setValue("hideAbstract", ParamUtil.getString(request,"hideAbstract","false"));
	portletPreferences.setValue("hideAbstractDesc", ParamUtil.getString(request,"hideAbstractDesc","false"));
	portletPreferences.setValue("hideSmallImage", ParamUtil.getString(request,"hideSmallImage","false"));
	portletPreferences.setValue("hideCategorization", ParamUtil.getString(request,"hideCategorization","false"));
	portletPreferences.setValue("hideCatType", ParamUtil.getString(request,"hideCatType","false"));
	portletPreferences.setValue("hideCatSelect", ParamUtil.getString(request,"hideCatSelect","false"));
	portletPreferences.setValue("hideTags", ParamUtil.getString(request,"hideTags","false"));
	portletPreferences.setValue("hideCustomFields", ParamUtil.getString(request,"hideCustomFields","false"));
	portletPreferences.setValue("hideDisplayPage", ParamUtil.getString(request,"hideDisplayPage","false"));
	portletPreferences.setValue("hideRelatedAssets", ParamUtil.getString(request,"hideRelatedAssets","false"));
	portletPreferences.setValue("previewURL",ParamUtil.getString(request,"previewURL",null));
	portletPreferences.setValue("editorType",ParamUtil.getString(request,"editorType","liferay-article"));
	portletPreferences.store();
}
String emailFromName = ParamUtil.getString(request, "preferences--emailFromName--", JournalUtil.getEmailFromName(portletPreferences, company.getCompanyId()));
String emailFromAddress = ParamUtil.getString(request, "preferences--emailFromAddress--", JournalUtil.getEmailFromAddress(portletPreferences, company.getCompanyId()));

boolean emailArticleAddedEnabled = ParamUtil.getBoolean(request, "preferences--emailArticleAddedEnabled--", JournalUtil.getEmailArticleAddedEnabled(portletPreferences));
boolean emailArticleApprovalDeniedEnabled = ParamUtil.getBoolean(request, "preferences--emailArticleApprovalDeniedEnabled--", JournalUtil.getEmailArticleApprovalDeniedEnabled(portletPreferences));
boolean emailArticleApprovalGrantedEnabled = ParamUtil.getBoolean(request, "preferences--emailArticleApprovalGrantedEnabled--", JournalUtil.getEmailArticleApprovalGrantedEnabled(portletPreferences));
boolean emailArticleApprovalRequestedEnabled = ParamUtil.getBoolean(request, "preferences--emailArticleApprovalRequestedEnabled--", JournalUtil.getEmailArticleApprovalRequestedEnabled(portletPreferences));
boolean emailArticleReviewEnabled = ParamUtil.getBoolean(request, "preferences--emailArticleReviewEnabled--", JournalUtil.getEmailArticleReviewEnabled(portletPreferences));
boolean emailArticleUpdatedEnabled = ParamUtil.getBoolean(request, "preferences--emailArticleUpdatedEnabled--", JournalUtil.getEmailArticleUpdatedEnabled(portletPreferences));

String emailParam = StringPool.BLANK;
String defaultEmailSubject = StringPool.BLANK;
String defaultEmailBody = StringPool.BLANK;

if (tabs2.equals("web-content-added-email")) {
	emailParam = "emailArticleAdded";
	defaultEmailSubject = ContentUtil.get(PropsValues.JOURNAL_EMAIL_ARTICLE_ADDED_SUBJECT);
	defaultEmailBody = ContentUtil.get(PropsValues.JOURNAL_EMAIL_ARTICLE_ADDED_BODY);
}
else if (tabs2.equals("web-content-approval-denied-email")) {
	emailParam = "emailArticleApprovalDenied";
	defaultEmailSubject = ContentUtil.get(PropsValues.JOURNAL_EMAIL_ARTICLE_APPROVAL_DENIED_SUBJECT);
	defaultEmailBody = ContentUtil.get(PropsValues.JOURNAL_EMAIL_ARTICLE_APPROVAL_DENIED_BODY);
}
else if (tabs2.equals("web-content-approval-granted-email")) {
	emailParam = "emailArticleApprovalGranted";
	defaultEmailSubject = ContentUtil.get(PropsValues.JOURNAL_EMAIL_ARTICLE_APPROVAL_GRANTED_SUBJECT);
	defaultEmailBody = ContentUtil.get(PropsValues.JOURNAL_EMAIL_ARTICLE_APPROVAL_GRANTED_BODY);
}
else if (tabs2.equals("web-content-approval-requested-email")) {
	emailParam = "emailArticleApprovalRequested";
	defaultEmailSubject = ContentUtil.get(PropsValues.JOURNAL_EMAIL_ARTICLE_APPROVAL_REQUESTED_SUBJECT);
	defaultEmailBody = ContentUtil.get(PropsValues.JOURNAL_EMAIL_ARTICLE_APPROVAL_REQUESTED_BODY);
}
else if (tabs2.equals("web-content-review-email")) {
	emailParam = "emailArticleReview";
	defaultEmailSubject = ContentUtil.get(PropsValues.JOURNAL_EMAIL_ARTICLE_REVIEW_SUBJECT);
	defaultEmailBody = ContentUtil.get(PropsValues.JOURNAL_EMAIL_ARTICLE_REVIEW_BODY);
}
else if (tabs2.equals("web-content-updated-email")) {
	emailParam = "emailArticleUpdated";
	defaultEmailSubject = ContentUtil.get(PropsValues.JOURNAL_EMAIL_ARTICLE_UPDATED_SUBJECT);
	defaultEmailBody = ContentUtil.get(PropsValues.JOURNAL_EMAIL_ARTICLE_UPDATED_BODY);
}

String emailSubjectParam = emailParam + "Subject";
String emailBodyParam = emailParam + "Body";

String emailSubject = PrefsParamUtil.getString(portletPreferences, request, emailSubjectParam, defaultEmailSubject);
String emailBody = PrefsParamUtil.getString(portletPreferences, request, emailBodyParam, defaultEmailBody);
%>

<liferay-portlet:renderURL portletConfiguration="true" var="portletURL">
	<portlet:param name="tabs2" value="<%= tabs2 %>" />
	<portlet:param name="redirect" value="<%= redirect %>" />
</liferay-portlet:renderURL>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationURL" />

<aui:form action="<%= configurationURL %>" method="post" name="fm" onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "saveConfiguration();" %>'>
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	<aui:input name="tabs2" type="hidden" value="<%= tabs2 %>" />
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />

	<%
	String tabs1Names = "email-from,web-content-added-email,web-content-review-email,web-content-updated-email,Easy Publishing Tool";

	if (WorkflowDefinitionLinkLocalServiceUtil.hasWorkflowDefinitionLink(themeDisplay.getCompanyId(), scopeGroupId, JournalArticle.class.getName())) {
		tabs1Names = tabs1Names.concat(",web-content-approval-denied-email,web-content-approval-granted-email,web-content-approval-requested-email,Easy Publishing Tool");
	}
	%>

	<liferay-ui:tabs
		names="<%= tabs1Names %>"
		param="tabs2"
		url="<%= portletURL %>"
	/>

	<liferay-ui:error key="emailFromAddress" message="please-enter-a-valid-email-address" />
	<liferay-ui:error key="emailFromName" message="please-enter-a-valid-name" />
	<liferay-ui:error key="emailArticleAddedBody" message="please-enter-a-valid-body" />
	<liferay-ui:error key="emailArticleAddedSubject" message="please-enter-a-valid-subject" />
	<liferay-ui:error key="emailArticleApprovalDeniedBody" message="please-enter-a-valid-body" />
	<liferay-ui:error key="emailArticleApprovalDeniedSubject" message="please-enter-a-valid-subject" />
	<liferay-ui:error key="emailArticleApprovalGrantedBody" message="please-enter-a-valid-body" />
	<liferay-ui:error key="emailArticleApprovalGrantedSubject" message="please-enter-a-valid-subject" />
	<liferay-ui:error key="emailArticleApprovalRequestedBody" message="please-enter-a-valid-body" />
	<liferay-ui:error key="emailArticleApprovalRequestedSubject" message="please-enter-a-valid-subject" />
	<liferay-ui:error key="emailArticleReviewBody" message="please-enter-a-valid-body" />
	<liferay-ui:error key="emailArticleReviewSubject" message="please-enter-a-valid-subject" />
	<liferay-ui:error key="emailArticleUpdatedBody" message="please-enter-a-valid-body" />
	<liferay-ui:error key="emailArticleUpdatedSubject" message="please-enter-a-valid-subject" />

	<c:choose>
		<c:when test='<%= tabs2.equals("email-from") %>'>
			<aui:fieldset>
				<aui:input cssClass="lfr-input-text-container" label="name" name="preferences--emailFromName--" type="text" value="<%= emailFromName %>" />

				<aui:input cssClass="lfr-input-text-container" label="address" name="preferences--emailFromAddress--" type="text" value="<%= emailFromAddress %>" />
			</aui:fieldset>
		</c:when>
		<c:when test='<%= tabs2.equals("Easy Publishing Tool") %>'>
			<%@include file="easy_publish_options.jspf" %>
		</c:when>
		<c:when test='<%= tabs2.startsWith("web-content-added-") || tabs2.startsWith("web-content-approval-") || tabs2.startsWith("web-content-review-") || tabs2.startsWith("web-content-updated-") %>'>
			<aui:fieldset>
				<c:choose>
					<c:when test='<%= tabs2.equals("web-content-added-email") %>'>
						<aui:input label="enabled" name="preferences--emailArticleAddedEnabled--" type="checkbox" value="<%= emailArticleAddedEnabled %>" />
					</c:when>
					<c:when test='<%= tabs2.equals("web-content-approval-denied-email") %>'>
						<aui:input label="enabled" name="preferences--emailArticleApprovalDeniedEnabled--" type="checkbox" value="<%= emailArticleApprovalDeniedEnabled %>" />
					</c:when>
					<c:when test='<%= tabs2.equals("web-content-approval-granted-email") %>'>
						<aui:input label="enabled" name="preferences--emailArticleApprovalGrantedEnabled--" type="checkbox" value="<%= emailArticleApprovalGrantedEnabled %>" />
					</c:when>
					<c:when test='<%= tabs2.equals("web-content-approval-requested-email") %>'>
						<aui:input label="enabled" name="preferences--emailArticleApprovalRequestedEnabled--" type="checkbox" value="<%= emailArticleApprovalRequestedEnabled %>" />
					</c:when>
					<c:when test='<%= tabs2.equals("web-content-review-email") %>'>
						<aui:input label="enabled" name="preferences--emailArticleReviewEnabled--" type="checkbox" value="<%= emailArticleReviewEnabled %>" />
					</c:when>
					<c:when test='<%= tabs2.equals("web-content-updated-email") %>'>
						<aui:input label="enabled" name="preferences--emailArticleUpdatedEnabled--" type="checkbox" value="<%= emailArticleUpdatedEnabled %>" />
					</c:when>
				</c:choose>

				<aui:input cssClass="lfr-input-text-container" label="subject" name='<%= "preferences--" + emailSubjectParam + "--" %>' value="<%= emailSubject %>" />

				<aui:field-wrapper label="body">
					<liferay-ui:input-editor editorImpl="<%= EDITOR_WYSIWYG_IMPL_KEY %>" />

					<aui:input name='<%= "preferences--" + emailBodyParam + "--" %>' type="hidden" />
				</aui:field-wrapper>
			</aui:fieldset>

			<div class="definition-of-terms">
				<h4><liferay-ui:message key="definition-of-terms" /></h4>

				<dl>
					<dt>
						[$ARTICLE_ID$]
					</dt>
					<dd>
						<liferay-ui:message key="the-web-content-id" />
					</dd>
					<dt>
						[$ARTICLE_TITLE$]
					</dt>
					<dd>
						<liferay-ui:message key="the-web-content-title" />
					</dd>

					<c:if test='<%= tabs2.startsWith("web-content-added-") || tabs2.startsWith("web-content-approval-") || tabs2.startsWith("web-content-review-") || tabs2.startsWith("web-content-updated-") %>'>
						<dt>
							[$ARTICLE_URL$]
						</dt>
						<dd>
							<liferay-ui:message key="the-web-content-url" />
						</dd>
					</c:if>

					<dt>
						[$ARTICLE_VERSION$]
					</dt>
					<dd>
						<liferay-ui:message key="the-web-content-version" />
					</dd>
					<dt>
						[$FROM_ADDRESS$]
					</dt>
					<dd>
						<%= HtmlUtil.escape(emailFromAddress) %>
					</dd>
					<dt>
						[$FROM_NAME$]
					</dt>
					<dd>
						<%= HtmlUtil.escape(emailFromName) %>
					</dd>
					<dt>
						[$PORTAL_URL$]
					</dt>
					<dd>
						<%= company.getVirtualHostname() %>
					</dd>
					<dt>
						[$PORTLET_NAME$]
					</dt>
					<dd>
						<%= PortalUtil.getPortletTitle(renderResponse) %>
					</dd>
					<dt>
						[$TO_ADDRESS$]
					</dt>
					<dd>
						<liferay-ui:message key="the-address-of-the-email-recipient" />
					</dd>
					<dt>
						[$TO_NAME$]
					</dt>
					<dd>
						<liferay-ui:message key="the-name-of-the-email-recipient" />
					</dd>
				</dl>
			</div>
		</c:when>
	</c:choose>
	
	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>

<aui:script>
	function <portlet:namespace />initEditor() {
		return "<%= UnicodeFormatter.toString(emailBody) %>";
	}

	function <portlet:namespace />saveConfiguration() {
		<c:if test='<%= tabs2.startsWith("web-content-added-") || tabs2.startsWith("web-content-approval-") || tabs2.startsWith("web-content-review-") || tabs2.startsWith("web-content-updated-") %>'>
			document.<portlet:namespace />fm.<portlet:namespace /><%= emailBodyParam %>.value = window.<portlet:namespace />editor.getHTML();
		</c:if>

		submitForm(document.<portlet:namespace />fm);
	}
</aui:script>

<%!
public static final String EDITOR_WYSIWYG_IMPL_KEY = "editor.wysiwyg.portal-web.docroot.html.portlet.journal.configuration.jsp";
%>