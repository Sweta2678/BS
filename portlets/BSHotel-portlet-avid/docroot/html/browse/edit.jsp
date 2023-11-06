<%@include file="/html/init.jsp"%>

<portlet:actionURL name="setCustomPreferences" var="setCustomPreferencesURL" />

<%
	boolean isProdEnvSelected = false;
	boolean isStagEnvSelected = true;
%>
<aui:form name="fm" action="<%= setCustomPreferencesURL %>"	method="post">
	<aui:fieldset column="4">
	
		<aui:select name="environment" label="Select Environment" id="environment">
		<c:if test='${"PRODUCTION" eq environmentVal}'>
		<%
			isProdEnvSelected = true;
			isStagEnvSelected = false;
		%>
		</c:if>
					
			<aui:option label = "Production Environment" value = "PRODUCTION" selected="<%=isProdEnvSelected %>"/>
			<aui:option label = "Staging Environment" value = "STAGING" selected="<%=isStagEnvSelected %>"/>
		</aui:select>
		<aui:button-row>
			<aui:button type="submit" />
		</aui:button-row>
	</aui:fieldset>

</aui:form>