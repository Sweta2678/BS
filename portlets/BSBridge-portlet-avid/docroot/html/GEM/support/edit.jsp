<%--
/**
* Copyright (c) 2000-2010 Liferay, Inc. All rights reserved.
*
* This library is free software; you can redistribute it and/or modify it under
* the terms of the GNU Lesser General Public License as published by the Free
* Software Foundation; either version 2.1 of the License, or (at your option)
* any later version.
*
* This library is distributed in the hope that it will be useful, but WITHOUT
* ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
* FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
* details.
*/
--%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<portlet:defineObjects />

<portlet:actionURL name="submitSupportConfig" var="submitSupportConfigUrl" />
<portlet:actionURL  name="Cancel" var="Cancel"/>

<aui:form action="<%=submitSupportConfigUrl.toString()%>" method="post" name="fm" >
	<aui:layout>
			<aui:input id="receiverEmails"  name="receiverEmails"  style="width:100%;"
				helpMessage="Enter the email(s) of the receiver in a semi colon separated format.  (e.g. user1@xyz.com;user2@xyz.com"  label="Email addresses" 
				inlineField="false" type="text" 
 				value="${receiverEmails}" />
	</aui:layout>
<aui:button-row>
		<aui:button name="saveButton" type="submit" value="save" />
		<aui:button name="cancelButton" type="button" value="cancel" last="true" onclick="cancel();"/>
</aui:button-row>
</aui:form>
<script type="text/javascript">
function cancel()
{
	self.location = "<%=Cancel.toString()%>";
}
</script>