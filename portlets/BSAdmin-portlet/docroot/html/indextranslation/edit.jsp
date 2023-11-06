<%
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
%>
<%@include file="/html/init.jsp" %>
<portlet:actionURL  name="SavePrefs" var="SavePrefs"/>
<portlet:actionURL  name="Cancel" var="Cancel"/>
<aui:form action="<%=SavePrefs.toString()%>" method="post" name="fm" >
	<aui:layout>
	<% String sUserValue = (String) renderRequest.getPreferences().getValue("Image_Folder", ""); %>
		<aui:input id="Image_Folder" name="Image_Folder" style="width:100%;" 
			helpMessage="Taxonomy Trees/Brand Standards Global Folder Id" 
			label="Image Folder Id" inlineField="false" type="text" value="<%=sUserValue%>" />
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