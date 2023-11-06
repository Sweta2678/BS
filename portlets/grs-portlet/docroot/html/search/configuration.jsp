<%@include file="/html/init.jsp" %>
<portlet:actionURL name="setSearchResultsPreferences" var="setPreferencesURL" />

<form action="<%=  setPreferencesURL%>" method="post"> 
<table>	
	<tr>	
	    Search Results per page : &nbsp;&nbsp;
		<input type="text" name="<portlet:namespace/>prefRecordsPerPage" value="${recordsPerPage}"/>
	</tr></br>	
	<tr>	
	    Structure Keys : &nbsp;&nbsp;
		<input type="text" name="<portlet:namespace/>prefStructureKeys" value="${structureKeys}"/>
	</tr></br>		
	<tr>
		<input type="submit" value="Save"/>
	</tr>
	
</table>

</form>

