<%@include file="/html/init.jsp"%>
<portlet:actionURL name="setCustomPreferences" var="setCustomPreferencesURL" />
<p>Select preferences.<p>
<div>
	<form action="${setCustomPreferencesURL}" method="post" name="clearCacheForm">
		<select name="pageName"> 
			<option value="default" ${pageNamePreferences eq 'default' ? 'selected' : ''}>Please select</option>
			<option title="Sync Counter Portlet"  value="syncCounterPortlet" ${pageNamePreferences eq 'syncCounterPortlet' ? 'selected' : ''}>
				Sync Counter Portlet
			</option>
			<option title="Clear Cache Portlet" value="clearCachePortlet" ${pageNamePreferences eq 'clearCachePortlet' ? 'selected' : ''}>
				Clear Cache Portlet
			</option>
		</select>
		<input type="Submit" value="Submit" class="btn btn-primary" />
	</form>
</div>