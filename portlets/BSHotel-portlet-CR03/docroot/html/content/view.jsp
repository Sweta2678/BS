<%@include file="/html/init.jsp"%>
<%@page import="com.liferay.portal.util.PortletKeys"%>
<%@page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@page import="com.liferay.portlet.journal.model.JournalArticle"%>

<c:if test='${not empty resourcePrimkey}'>
	<liferay-ui:journal-article	articleResourcePrimKey="${resourcePrimkey}" />
</c:if>
<%
JournalArticle articleDisplay = null;
if(Validator.isNotNull(renderRequest.getAttribute("article"))) {
    articleDisplay = ((JournalArticle) renderRequest.getAttribute("article"));
%>

<c:if test="${hasEditPermission}">
	<div>
		<div class="icon-actions">
			<liferay-portlet:renderURL
				windowState="<%= WindowState.MAXIMIZED.toString() %>"
				var="editURL"
				portletName="<%= PortletKeys.JOURNAL %>">
				<portlet:param name="struts_action" value="/journal/edit_article" />
				<portlet:param name="redirect" value="<%= PortalUtil.getCurrentURL(renderRequest) %>" />
				<portlet:param name="referringPortletResource"
					value="<%=PortletKeys.JOURNAL_CONTENT %>" />
				<portlet:param name="groupId"
					value="<%= String.valueOf(articleDisplay.getGroupId()) %>" />
				<portlet:param name="articleId"
					value="<%= articleDisplay.getArticleId() %>" />
				<portlet:param name="version"
					value="<%= String.valueOf(articleDisplay.getVersion()) %>" />
			</liferay-portlet:renderURL>
	
			<liferay-ui:icon image="edit" message="edit-web-content"
				url="<%= editURL %>" />
		</div>
	</div>
</c:if>
<%
}
%>