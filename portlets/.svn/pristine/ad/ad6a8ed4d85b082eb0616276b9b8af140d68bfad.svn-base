
<%@include file="/html/init.jsp" %>
<%@ page import="com.liferay.portlet.messageboards.model.MBMessage" %>
<%@ page import="com.liferay.portlet.messageboards.model.MBCategory" %>
<%@ page import="com.liferay.portlet.messageboards.model.MBMessageDisplay" %>
<portlet:actionURL name="setDiscussionPreferences" var="setDiscussionPreferences" />

<div id="preference-form" class="msg-container">	
	<form name="discussionPrefForm" id="discussionPrefForm" method="POST" action="<%= setDiscussionPreferences.toString() %>" title="Portlet Preferences">
	<div id="mb-category">
	<label>Max Discussions</label>
		<input type="text" name="<portlet:namespace/>maxDiscussion" id="maxDiscussion" value="${discussionPrefs}">
	</div>
	<div id="mb-category">
	<label>Comment Policy WebContent ID </label>
		<input type="text" name="<portlet:namespace/>prefWebcontentId" id="prefWebcontentId" value="${webContentId}">
	</div>		
	<input style="margin-left:200px;" type="submit" value='<liferay-ui:message key="Save Preferences" />' name="btnSave" id="btnSave" />
	</form>
</div>
