<%@ include file="/html/init.jsp" %>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>

<portlet:actionURL name="setAnalyticsId" var="setAnalyticsIdURL" />
<portlet:renderURL var="cancelURL">
	<portlet:param name="jspPage" value="/html/analytics/view.jsp" />
	<portlet:param name="p_p_mode" value="view" />
</portlet:renderURL>

<aui:form action="<%= setAnalyticsIdURL %>" method="POST" name="fm" >
	<% String analytics = (String)renderRequest.getAttribute("analyticsId"); %>
	<aui:input name="analyticsId" type="text" value='<%= analytics%>' ></aui:input>
	<aui:button-row>
		<aui:button type="submit"></aui:button>
		<aui:button type="cancel" value="Cancel" onClick="<%=cancelURL %>" />
	</aui:button-row>
</aui:form>

