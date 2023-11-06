<%@include file="/html/init.jsp"%>

<portlet:actionURL name="setCustomPreferences" var="setCustomPreferencesURL" />
<portlet:renderURL var="cancelURL">
	<portlet:param name="jspPage" value="/html/download/view.jsp" />
</portlet:renderURL>

<aui:form name="fm" action="<%= setCustomPreferencesURL %>"	method="post">
	<aui:fieldset column="4">
		<aui:select name="articleType" label="Select Article Type"
			id="selectedArticleType">
				<c:forEach var="structure" items="${structureList}">
					<%
						boolean isSelected = false;
					%>
					<c:if test='${articleType eq structure.structureId}'>
						<%
							isSelected = true;
						%>
					</c:if>
					<aui:option label="${structure.name}" value="${structure.structureId}" selected="<%=isSelected %>"/>
			</c:forEach>
		</aui:select>
		<aui:select name="environment" label="Select Environment"	id="environment">
			<%
				boolean isProdEnvSelected = false;
				boolean isStagEnvSelected = true;
			%>
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
			<aui:button type="cancel" value="Cancel" onClick="<%=cancelURL %>" />
		</aui:button-row>
	</aui:fieldset>
</aui:form>