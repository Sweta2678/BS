<%@include file="./init.jsp"%>
<portlet:actionURL name="setPreferences" var="setPreferencesUrl">
</portlet:actionURL>

<portlet:renderURL var="cancelURL">
	<portlet:param name="jspPage" value="/html/mustPublish/view.jsp" />
</portlet:renderURL>
<portlet:actionURL name="setPortletMode" var="setModeURL"></portlet:actionURL>

<aui:form name="fm" id="fm" action="<%= setPreferencesUrl.toString() %>" method="post">
	<aui:fieldset column="4">
		<aui:select name="type" id="type">
			<aui:option value="Y"    selected="${type eq 'Y' }"  > Must Publish</aui:option>
			<aui:option value="N"  selected="${type eq 'N' }" >Must Not Publish</aui:option>
		</aui:select>
		<br/>
		<aui:button-row>
			<aui:button type="submit" />
			<aui:button type="reset" value="Cancel" onClick="self.location='${setModeURL }';" />
		</aui:button-row>
	</aui:fieldset>
</aui:form>
