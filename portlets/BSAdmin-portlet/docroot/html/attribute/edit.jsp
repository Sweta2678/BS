<%@include file="init.jsp"%>

<portlet:actionURL name="setCustomPreferences" var="setCustomPreferencesURL" />

<portlet:renderURL var="cancelURL">
	<portlet:param name="jspPage" value="/html/attribute/view.jsp" />
</portlet:renderURL>


<aui:form name="fm" action="<%= setCustomPreferencesURL %>"	method="post">
	<aui:fieldset column="1">
	
		
		<aui:select name="contentEnvironment" label="Select Environment"	id="contentEnvironment">
		<%
			boolean isProdEnvSelected = false;
			boolean isQAEnvSelected = true;
			
		%>
		<c:if test='${"PROD" eq contentEnvironmentVal}'>
						<%
						isProdEnvSelected = true;
						isQAEnvSelected = false;
						%>
		</c:if>
					
			<aui:option label = "Production Environment" value = "PROD" selected="<%=isProdEnvSelected %>"/>
			<aui:option label = "QA Environment" value = "QA" selected="<%=isQAEnvSelected %>"/>
		</aui:select>
		<aui:button-row>
			<aui:button type="submit" />
			<aui:button type="cancel" value="Cancel" onClick="<%=cancelURL %>" />
		</aui:button-row>
	</aui:fieldset>

</aui:form>