<%@include file="/html/init.jsp"%>
<portlet:actionURL name="setDefaultTimeStamp" var="setDefaultTimeStampURL" />
<p>Select preferences.<p>
<div>
	<form action="${setDefaultTimeStampURL}" method="post" name="defaultTimeStampForm">
		<select name="<portlet:namespace/>timeSlot"> 
			<option value="">Please select</option>
			
			<option value="10" ${defaultTime eq '10' ? 'selected' : ''}>
				10
			</option>
			<option value="15" ${defaultTime eq '15' ? 'selected' : ''}>
				15
			</option>
		</select>
		<input type="Submit" value="Submit" class="btn btn-primary" />
	</form>
</div>