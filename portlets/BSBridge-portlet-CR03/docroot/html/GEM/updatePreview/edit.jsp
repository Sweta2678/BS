<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@include file="init.jsp"%>

<portlet:actionURL name="savePreferences" var="savePreferences" />

<portlet:renderURL var="cancelURL">
	<portlet:param name="jspPage" value="/html/GEM/updatePreview/view.jsp" />
</portlet:renderURL>


<aui:form name="fm" action="<%= savePreferences %>"	method="post">
	<aui:fieldset column="1">
	
		<%
			String groupType = (String)renderRequest.getAttribute("groupType");
	
		%>
		<aui:input name="groupType" type="text" value='<%= groupType%>' label="Group Type" />
		<aui:button-row>
			<aui:button type="submit" />
			<aui:button type="cancel" value="Cancel" onClick="<%=cancelURL %>" />
		</aui:button-row>
	</aui:fieldset>

</aui:form>