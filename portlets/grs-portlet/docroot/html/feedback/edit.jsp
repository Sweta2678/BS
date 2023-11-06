<%@include file="/html/init.jsp"%>
<portlet:actionURL name="setPreferences" var="setFeedbackPreferencesURL" />
<portlet:renderURL var="cancelURL" portletMode="view"/>

<%
String adminEmail = portletPreferences.getValue("admin-email", "");
%>

<liferay-ui:success key="preferences-saved-successfully" message="Preferences saved successfully."/>
<liferay-ui:error key="error-saving-preferences" message="Error saving preferences. Please try again after some time."/>

<aui:form action="<%=setFeedbackPreferencesURL%>" method="post">

	<aui:input name="admin-email" value="<%=adminEmail %>" label="Enter Admin Email" />
	<aui:button-row>
		<aui:button type="submit" value="Save" />
		<aui:button value="Cancel" onClick="<%=cancelURL %>" />
	</aui:button-row>

</aui:form>

