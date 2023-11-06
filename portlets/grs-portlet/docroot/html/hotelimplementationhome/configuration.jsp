<%@include file="/html/init.jsp" %>
<portlet:actionURL name="setHomePagePreferences" var="setPreferencesURL" />

<form action="<%=  setPreferencesURL%>" method="post"> 
<table>
	<tr>	
	    GRS Communication Group Id : &nbsp;&nbsp;
		<input type="text" name="<portlet:namespace/>prefgroupid" value="${groupid}"/>
	</tr></br>	
	<tr>	
	    GRS Communication Understand the GRS Category ID : &nbsp;&nbsp;
		<input type="text" name="<portlet:namespace/>prefgrsCommCategoryIDUnderstandTheGRS" value="${grsCommCategoryIDUnderstandTheGRS}"/>
	</tr></br>	
	<tr>	
	    GRS Communication Get Ready for Category ID : &nbsp;&nbsp;
		<input type="text" name="<portlet:namespace/>prefgrsCommCategoryIDGetReady" value="${grsCommCategoryIDGetReady}"/>
	</tr></br>	
	<tr>	
	    GRS Hotel Implementation Understand the GRS Category ID : &nbsp;&nbsp;
		<input type="text" name="<portlet:namespace/>prefgrsHotelImpCategoryIDUnderstandTheGRS" value="${grsHotelImpCategoryIDUnderstandTheGRS}"/>
	</tr></br>
	<tr>	
	    GRS Hotel Implementation Get Ready for Category ID : &nbsp;&nbsp;
		<input type="text" name="<portlet:namespace/>prefgrsHotelImpCategoryIDGetReady" value="${grsHotelImpCategoryIDGetReady}"/>
	</tr></br>	
	<tr>	
	    Records Per Category : &nbsp;&nbsp;
		<input type="text" name="<portlet:namespace/>prefRecordsPerPage" value="${recordsPerPage}"/>
	</tr></br>
	<tr>	
	    Home Page Details Portal Web Content Id : &nbsp;&nbsp;
		<input type="text" name="<portlet:namespace/>prefGrsImpHomePageDetailsWebConentId" value="${grsImpHomePageDetailsWebConentId}"/>
	</tr></br>
	<tr>
		<input type="submit" value="Save"/>
	</tr>
	
</table>

</form>

