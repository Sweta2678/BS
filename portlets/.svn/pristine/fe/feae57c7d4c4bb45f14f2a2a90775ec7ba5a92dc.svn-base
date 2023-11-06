<%@include file="/html/init.jsp"%>
<portlet:actionURL name="setPreferences" var="setFeedbackPreferencesURL" />
<portlet:renderURL var="cancelURL" portletMode="view" />

<c:set var="delta" value='<%=portletPreferences.getValue("delta", "")%>' />
<c:set var="directoryArticleId" value='<%=portletPreferences.getValue("directoryArticleId", "")%>' />

<liferay-ui:success key="preferences-saved-successfully" message="Preferences saved successfully." />
<liferay-ui:error key="error-saving-preferences" message="Error saving preferences. Please try again after some time." />

<aui:form action="<%=setFeedbackPreferencesURL%>" method="post">
	<aui:input name="delta" value="${delta }" label="Enter Delta" />

	<aui:button-row>
		<aui:button type="submit" value="Save" />
		<aui:button value="Cancel" onClick="<%=cancelURL%>" />
	</aui:button-row>
</aui:form>

