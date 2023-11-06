<%@include file="/html/init.jsp"%>
<portlet:actionURL name="setDefaultTimeStamp" var="setDefaultTimeStampURL" />
<p>Select preferences.<p>
<div>
	<form action="${setDefaultTimeStampURL}" method="post" name="defaultTimeStampForm">
		<select name="<portlet:namespace/>timeSlot" id="<portlet:namespace/>timeSlot"> 
			<option value="">Please select</option>
			<option value="5" ${defaultTime eq '5' ? 'selected' : ''}>5 min</option>
			<option value="10" ${defaultTime eq '10' ? 'selected' : ''}>10 min</option>
			<option value="15" ${defaultTime eq '15' ? 'selected' : ''}>15 min</option>
			<option value="20" ${defaultTime eq '20' ? 'selected' : ''}>20 min</option>
			<option value="25" ${defaultTime eq '25' ? 'selected' : ''}>25 min</option>
			<option value="30" ${defaultTime eq '30' ? 'selected' : ''}>30 min</option>
			<option value="60" ${defaultTime eq '60' ? 'selected' : ''}>1 hour</option>
			<option value="120" ${defaultTime eq '120' ? 'selected' : ''}>2 hour</option>
		</select>
		<input type="Submit" value="Submit" class="btn btn-primary" />
	</form>
</div>