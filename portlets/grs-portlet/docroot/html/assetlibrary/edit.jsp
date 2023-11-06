<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />
<%@ include file="/html/init.jsp" %>


<portlet:actionURL name="setAssetLibPreferences" var="setAssetLibPreferences" />

<div id="preference-form" class="msg-container">	
	<form name="assetLibPrefForm" id="assetLibPrefForm" method="POST" action="<%= setAssetLibPreferences.toString() %>" title="Portlet Preferences">
	<div>
	<label>Max Documents</label>
		<input type="text" name="<portlet:namespace/>maxDocuments" id="maxDocuments" value="${documentPrefs}">
	</div>
	<input type="submit" value='<liferay-ui:message key="Save Preferences" />' name="btnSave" id="btnSave" />
	</form>
</div>
