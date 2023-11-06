<%@include file="/html/init.jsp" %>
<portlet:actionURL name="setArticleListingPreferences" var="setPreferencesURL" />

<form action="<%=  setPreferencesURL%>" method="post"> 
<table>
	<tr>	
	    Structure KEY : &nbsp;&nbsp;
		<input type="text" name="<portlet:namespace/>prefStructureKey" value="${structureKey}"/>
	</tr></br>	
	<tr>	
	    Articles per page : &nbsp;&nbsp;
		<input type="text" name="<portlet:namespace/>prefArticlePerPage" value="${articlePerPage}"/>
	</tr></br>
	<tr>	
	    Category ID : &nbsp;&nbsp;
		<input type="text" name="<portlet:namespace/>categoryID" value="${categoryID}"/>
	</tr></br>
	<tr>	
	    Global Category ID : &nbsp;&nbsp;
		<input type="text" name="<portlet:namespace/>glblCategoryID" value="${glblCategoryID}"/>
	</tr></br>		
	<tr>
		<input type="submit" value="Save"/>
	</tr>
	
</table>

</form>

