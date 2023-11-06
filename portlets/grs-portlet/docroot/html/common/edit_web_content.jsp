<%@page import="com.liferay.portlet.journal.model.JournalArticle"%>
<%@page import="com.liferay.portal.util.PortletKeys"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>

<%@page import="javax.portlet.WindowState"%>
<%@ include file="/html/init.jsp" %>

<% if(ActionUtil.hasResourcePermission(themeDisplay)) {%>
    <div class="webContentEdit">
		<h3 class="click-to-edit-content-text">Click to edit content:</h3>
		<div class="icon-actions">
			<liferay-portlet:renderURL windowState="<%= WindowState.MAXIMIZED.toString() %>" var="editURL" portletName="<%= PortletKeys.JOURNAL %>">
				<portlet:param name="struts_action" value="/journal/edit_article" />
				<portlet:param name="redirect" value="<%= PortalUtil.getCurrentURL(renderRequest) %>" />
				<portlet:param name="referringPortletResource"	value="<%=PortletKeys.JOURNAL_CONTENT %>" />
				<portlet:param name="groupId" value="<%= groupId %>" />
				<portlet:param name="articleId" value="<%= articalId %>" />
				<portlet:param name="version" value="<%= version %>" />
			</liferay-portlet:renderURL>

		<liferay-ui:icon image="edit" message="edit-web-content" url="<%= editURL %>" />
		
	</div>
	</div>
			
<% } %>