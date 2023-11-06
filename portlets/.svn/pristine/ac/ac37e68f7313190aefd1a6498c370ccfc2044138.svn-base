<%@include file="/html/uielement/init.jsp"%>


<!--items for jquery UI -->


<liferay-portlet:resourceURL id="attributeContentAction" var="attributeCotnentURL"  />

<div id="attributeContentModel" title="Country/Region Attribute Content">
	<div class="modal-body">

			<label class="aui-field-label"><b>Attribute Content From</b></label>		
			<select name="attributeFromCountry" id="attributeFromCountryId" onchange="clearValidationText()" >
				<option value="">Select Country/Region From</option>
				<c:forEach var="countryCodeFrom" items="${countryList}">
					<option value="${countryCodeFrom}">${countryCodeFrom}</option>
				</c:forEach>
			</select>
		    		
		    <label class="aui-field-label"><b>Attribute Content To</b></label> 
		    <select name="attributeToCountry"  id="attributeToCountryId" onchange="clearValidationText()">
		   		<option value="">Select Country/Region To</option>
				<c:forEach var="countryCodeTo" items="${countryList}">
					<option value="${countryCodeTo}" >${countryCodeTo}</option>
				</c:forEach>
	   		</select>
	   		
	   		<div id="countryValidation"></div>
	   		<br/>
	   		<div id="attributeOptions">
	   		<label class="aui-field-label"><b>Attribute Options</b></label>
	   		<input type="checkbox" class="input_checkbox_filter" name="stdAttributesList" value="standards" id="standards" title="Standards, Specification and Guidelines" />Standards, Specification and Guidelines
	   		<br/>
	   		<input type="checkbox" class="input_checkbox_filter" name="stdAttributesList" value="complianceDates" id="complianceDates" title="Compliance Dates" />Compliance Dates
	   		<br/>
	   		<input type="checkbox" class="input_checkbox_filter" name="stdAttributesList" value="expiryDates" id="expiryDates" title="Expiry Dates" />Expiry Dates
	   		<br/>
	   		<input type="checkbox" class="input_checkbox_filter" name="stdAttributesList" value="attachments" id="attachments" title="Attachments" />Attachments
	   		<br/>
	   		<input type="checkbox" class="input_checkbox_filter" name="stdAttributesList" value="images" id="images" title="Images" />Images
	   		<br/>
	   		<input type="checkbox" class="input_checkbox_filter" name="stdAttributesList" value="links" id="links" title="Links">Links 
	   		<br/>
	   		</div>
			
			<div class="modal-footer aui-panel-ft">
				<input class="btn pull-left" id="attributeContent" type="button" title="Attribute Content" value="Attribute Content" onclick="contentConfirmationPopup()">
				<input type="button" class="btn pull-right attributeContentPopupClose" title="Close" value="Close">
			</div> 
				
	</div>
</div>

<script type="text/javascript">

	function contentConfirmationPopup(){
		
		var fromCountry = jQuery("#attributeFromCountryId").val();
		var toCountry = jQuery("#attributeToCountryId").val();
		var attrValues = [];
		var attributeCotnentURL = '<%=attributeCotnentURL%>';
		jQuery("#attributeOptions input:checked").each(function(i){
			attrValues[i] = jQuery(this).val();
		});
		
		if(fromCountry != null && fromCountry != '' && typeof fromCountry != 'undefined' ){
			if(toCountry != null && toCountry != '' && typeof toCountry != 'undefined' ){
				if(fromCountry === toCountry){
					jQuery("#countryValidation").text("Origin country and destination country can not be the same.");
					jQuery("#countryValidation").css({"color": "red"});
				}
				else if(attrValues.length < 1){
					jQuery("#countryValidation").text("Please select one attribute.");
					jQuery("#countryValidation").css({"color": "red"});
				}
				else{
					jQuery("#countryValidation").html('');
					jQuery.msgBox({
						title: "Attribute Content",
						content: "Are you sure you want to attribute these contents?",
						type: "confirm",
						buttons: [{ value: "Yes" }, { value: "No" }],
						success: function (result){
							if (result == "Yes") {
								jQuery.ajax({
									url: attributeCotnentURL+"&attributeFromCountry="+fromCountry+"&attributeToCountry="+toCountry+"&stdAttributesList="+attrValues,
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
												title:"Attribute Content",
												content:"Request to assign attributes is processed successfully.",
												success :function(result)
												{
													jQuery('.btn.pull-right.attributeContentPopupClose').click();
												}
											});
										}
										else if(data.trim() == 'Origin and destination country have no common standards.')
										{
											jQuery.unblockUI();
											jQuery.msgBox({
												type: 'warning',
												title:"Attribute Content",
												content:"Origin and destination country have no common standards.",
												success :function(result)
												{
													jQuery('.btn.pull-right.attributeContentPopupClose').click();
												}
										
											});
										}
										else 
										{
											jQuery.unblockUI();
											jQuery.msgBox({
												type: 'error',
												title:"Attribute Content",
												content:"Problem in processing the request.",
												success :function(result)
												{
													jQuery('.btn.pull-right.attributeContentPopupClose').click();
												}
											});
										}
									}
								});
							}
						}
					});	
				}
			}
		}
		
	}	
	
	
	function clearValidationText(){
		
		var fromCountry = jQuery("#attributeFromCountryId").val();
		var toCountry = jQuery("#attributeToCountryId").val();
		
		if(fromCountry != null && fromCountry != '' && typeof fromCountry != 'undefined' ){
			if(toCountry != null && toCountry != '' && typeof toCountry != 'undefined' ){
				if(fromCountry != toCountry){
					jQuery("#countryValidation").html('');
				}
			}
		}
	}

</script>