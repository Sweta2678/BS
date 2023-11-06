<%@include file="/html/init.jsp" %>
<portlet:actionURL name="setCarouselPreferences" var="setCarouselPreferencesURL" />

<form action="<%=setCarouselPreferencesURL%>" method="post"> 
<table>
	<tr>	
	    Structure Key : &nbsp;&nbsp;
		<input type="text" name="structureKey" value="${structureKey}"/>
	</tr></br>	
	<tr>	
	    No of Articles : &nbsp;&nbsp;
		<input type="text" name="noOfArticles" value="${noOfArticles}"/>
	</tr></br>	
	<tr>	
	    Cache Time : &nbsp;&nbsp;
		<input type="text" name="cacheTime" value="${cacheTime}"/>
	</tr></br>	
	
	<tr>
		<input type="submit" value="Save"/>
	</tr>
	
</table>

</form>

