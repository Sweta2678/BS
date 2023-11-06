<%@include file="/html/uielement/init.jsp"%>

<liferay-portlet:resourceURL id="stdCtryValidationAction" var="stdCtryValidationURL" />
<portlet:resourceURL var="getSuberRegionByRegionIdURL" id="getSuberRegionByRegionId"/>

<div id="CountryRegionModal" title="Standards Country Regions">
	<div class="modal-body">

		<label class="aui-field-label">Country/Region Code</label>		
		<c:choose>
			<c:when test="${not empty countryCode}">
				<input type="text" id="standardsCountryCode" name="stdCountryCode" value="${countryCode}" readonly="readonly" style="cursor: not-allowed; background-color: #eee;">	
			</c:when>
			<c:otherwise>
				<input type="text" id="standardsCountryCode" class="txtOnly" name="stdCountryCode" value="${countryCode}" maxlength="3">
			</c:otherwise>
		</c:choose>
	    		
	    <label>Region</label> 
	    <select name="stdRegionCode"  id="standardsRegionCode" >
	    	<c:if test="${empty countryCode}">
	    		<option value="0">Select Region</option>
	    	</c:if>
			<c:forEach var="region" items="${stdRegionMap}">
				<option value="${region.key}" ${region.key == regionId ? 'selected' : '' } >${region.value}</option>
			</c:forEach>
   		</select>
   		<c:choose>
   			<c:when test="${not empty countryCode}">
   				<input type="hidden" id="hiddenCtryCode" name="hiddenCountryCode" value="${countryCode}">
   			</c:when>
   			<c:otherwise>
				<input type="hidden" id="hiddenCtryCode" name="hiddenCountryCode" value="">
			</c:otherwise>
   		</c:choose>
		
		
		<label>Sub Region</label>
		<select name="stdSubRegionCode" id="standardsSubRegionCode" >
			<c:if test="${not empty regionId}">
				<c:forEach var="subRegion" items="${subRegionList}">
					<option value="${subRegion.regionId}" ${subRegion.regionId == subRegionId ? 'selected' : ''}>${subRegion.regionCode}</option>
				</c:forEach>
			</c:if>
		</select>
		
		<div class="modal-footer aui-panel-ft">
			<input class="btn pull-left" id="submitCountry" type="button" title="Save" value="Save" onclick="submitCtryPopUp()">
			<input type="button" class="btn pull-right countryRegionPopupClose" title="Cancel" value="Cancel">
		</div> 
	</div>

	
</div>

<script type="text/javascript">

jQuery(document).ready(function() {


	jQuery( ".txtOnly" ).on('change keyup', function() {
		var str = jQuery(this).val().replace(/[^a-zA-Z]/g, '');
		jQuery(this).val(str);
	});

	jQuery("#standardsRegionCode").change(function() {
			
		var regionId = jQuery('#standardsRegionCode').val();
		if(regionId > 0){
			jQuery('#standardsSubRegionCode').prop("disabled", false);
			jQuery.ajax({
				url: '${getSuberRegionByRegionIdURL}'+ '&stdRegionId='+ regionId,
				type: "POST",
				dataType: "text",
				success: function(data) {
					if (data != null && data != '' && typeof data != 'undefined') {
		                var options="<option value=''>Select Sub Region</option>";
		                jQuery.each(JSON.parse(data),function(k,v){
		                    options +="<option value="+k+">"+v+"</option>";
		                });         
		                jQuery("#standardsSubRegionCode").empty().append(options); 
					}
				}
			});
		}
		else{
			jQuery('#standardsSubRegionCode').innerHTML = "";
			jQuery('#standardsSubRegionCode').prop("disabled", true);
		}

	 });
});

jQuery(".countryRegionPopupClose").click(function() {
	countryRegionDialog.dialog('close');
});

function submitCtryPopUp(){
	
	jQuery("#standardsRegionCode").css('border','');
	jQuery("#standardsCountryCode").css('border','');
	
	if(jQuery("#standardsCountryCode").val() == ''){
		jQuery("#standardsCountryCode").css('border','1px solid red');
		return false;
	}
	
	else if(jQuery("#standardsRegionCode").val() == 0){
		jQuery("#standardsRegionCode").css('border','1px solid red');
		return false;
	}
	
	else if(jQuery("#standardsSubRegionCode").val() == ''){
		jQuery("#standardsSubRegionCode").css('border','1px solid red');
		return false;
	}
	else if(jQuery("#standardsRegionCode").val() == 0 && jQuery("#standardsCountryCode").val() == '' && jQuery("#standardsSubRegionCode").val() == ''){
		jQuery("#standardsRegionCode").css('border','1px solid red');
		jQuery("#standardsCountryCode").css('border','1px solid red');
		jQuery("#standardsSubRegionCode").css('border','1px solid red');
		return false;
	}
	else{
		var ctryCode = jQuery("#standardsCountryCode").val();
		var regionCode = jQuery("#standardsRegionCode").val();
		var subRegionCode = jQuery("#standardsSubRegionCode").val();
		var hiddenCtryCode = jQuery("#hiddenCtryCode").val();
		var stdCtryValidationURL = '<%=stdCtryValidationURL%>';
		
		jQuery.ajax({
			url: stdCtryValidationURL+"&stdCountryCode="+ctryCode+"&stdRegionCode="+regionCode+"&stdSubRegionCode="+subRegionCode+"&hiddenCountryCode="+hiddenCtryCode,
			type: "POST",
			dataType: "text",
			beforeSend : function() {
				jQuery.blockUI({ message: '<h3><img src="/BSTheme-theme/images/busy.gif" /> Please wait...</h3>' });
        	}, 
			success: function(data) {
				if (data.trim() == 'success') 
				{
					jQuery.unblockUI();
					jQuery.msgBox({
						type: 'success',
						title:"Manage Country/Region",
						content:"Request is processed successfully.",
						success :function(result)
						{
							jQuery('.btn.pull-right.countryRegionPopupClose').click();	
						}
					});
				}
				else if(data.trim() == 'Country already exists')
				{
					jQuery.unblockUI();
					jQuery.msgBox({
						type: 'warning',
						title:"Manage Country/Region",
						content:"Country/Region code already exists.",
						success :function(result)
						{
							jQuery('.btn.pull-right.countryRegionPopupClose').click();
						}
				
					});
				}
				
			}
		});
	}
}

</script>