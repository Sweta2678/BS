<%@include file="/html/init.jsp" %>
<portlet:actionURL var="saveRoleAssignmentPreferencesURL" name="saveRoleAssignmentPreferences"/>
<portlet:actionURL var="Cancel" name="Cancel" />
<portlet:actionURL var="setModeURL" name="setPortletMode" />
<aui:form  action="${saveRoleAssignmentPreferencesURL}" method="post" name="preferenceForm" id="preferenceForm">
	<aui:input id="roleSubTypes" type="textarea" name="roleSubTypes" label="Role Sub Types" value="${roleSubTypes}"/>
	<aui:button name="save" type="submit" value="Save"/>
	<aui:button onClick="self.location='${setModeURL}';" type="reset" value="Back" />
</aui:form>
<script type="text/javascript">
	function cancel() {
		self.location = "<%=Cancel.toString()%>";
	}
</script>