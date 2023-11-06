<%@include file="/../html/init.jsp"%>

<portlet:actionURL name="setCustomPreferences" var="setCustomPreferencesURL" />

<portlet:renderURL var="cancelURL">
	<portlet:param name="jspPage" value="/html/content/view.jsp" />
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
		<aui:input name="isBrandSpecific" label="Brand Specific" type="checkbox" value="${isBrandSpecific}"></aui:input>
		<aui:input name="isLanguageSpecific" label="Language Specific" type="checkbox" value="${isLangSpecific}"></aui:input>
		<aui:select name="contentEnvironment" label="Select Environment"	id="contentEnvironment">
		<%
			boolean isProdEnvSelected = false;
			boolean isStagEnvSelected = true;
			
		%>
		<c:if test='${"production" eq contentEnvironmentVal}'>
						<%
						isProdEnvSelected = true;
						isStagEnvSelected = false;
						%>
		</c:if>
					
			<aui:option label = "Production Environment" value = "production" selected="<%=isProdEnvSelected %>"/>
			<aui:option label = "Staging Environment" value = "staging" selected="<%=isStagEnvSelected %>"/>
		</aui:select>
		<aui:button-row>
			<aui:button type="submit" />
			<aui:button type="cancel" value="Cancel" onClick="<%=cancelURL %>" />
		</aui:button-row>
	</aui:fieldset>

</aui:form>