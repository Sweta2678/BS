<%@include file="/html/init.jsp" %>
This is the <b>Compliance Rule Utility Fix</b> portlet in View mode.
<portlet:actionURL var="fixComplianceURL" ></portlet:actionURL>
<form action="<%= fixComplianceURL %>" method="post" >
	<input type="submit" value="Fix Compliance Rule" />
</form>
