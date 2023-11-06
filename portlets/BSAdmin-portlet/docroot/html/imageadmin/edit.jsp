<%@page import="com.ihg.brandstandards.util.BrandStandardsUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<portlet:defineObjects />

<portlet:actionURL  name="savePrefs" var="savePrefs"/>
<portlet:actionURL  name="cancel" var="cancel"/>
<aui:form action="<%=savePrefs.toString()%>" method="post" name="fm" >
	<aui:layout>

<%
	String sUserValue = (String) renderRequest.getPreferences().getValue(BrandStandardsUtil.BS_IMG_GALLERY_FOLDER, "");
%>
	<aui:input id="<%=BrandStandardsUtil.BS_IMG_GALLERY_FOLDER%>"  name="<%=BrandStandardsUtil.BS_IMG_GALLERY_FOLDER%>"  style="width:100%;"
		label="<%=BrandStandardsUtil.BS_IMG_GALLERY_FOLDER%>" 
		inlineField="false" type="text" 
 		value="<%=sUserValue%>" />

	</aui:layout>
	
	<aui:button-row>
		<aui:button name="saveButton" type="submit" value="save" />
		<aui:button name="cancelButton" type="button" value="cancel" last="true" onclick="cancel();"/>
	</aui:button-row>
</aui:form>

<script language="JavaScript">
function cancel()
{
	self.location = "<%=cancel.toString()%>";
}
</script>