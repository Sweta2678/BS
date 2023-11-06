<%@include file="/html/init.jsp" %>
<portlet:actionURL name="setArticleListingPreferences" var="setPreferencesURL" />

<form action="<%=  setPreferencesURL%>" method="post"> 
<table>
	<tr>	
	    <td>Structure KEY : &nbsp;&nbsp;</td>
		<td><input type="text" name="<portlet:namespace/>prefStructureKey" value="${structureKey}"/></td>
	</tr>	
	<tr>	
	    <td>No Of Articles : &nbsp;&nbsp;</td>
		<td><input type="text" name="<portlet:namespace/>preNoOfArticle" value="${noOfArticle}"/></td>
	</tr>
	<tr>	
	    <td>Display Style :</td> 
		<td>
		<select name="<portlet:namespace/>displayStyle">
			<option value="">Select</option>
			<option value="home-latest-article" ${displayStyle eq 'home-latest-article' ? 'selected=true' : '' }>Home Latest Article</option>
		</select>
		
		</td>
	</tr>
	<tr>
		<td><input type="submit" value="Save"/></td>
	</tr>
	
</table>

</form>

