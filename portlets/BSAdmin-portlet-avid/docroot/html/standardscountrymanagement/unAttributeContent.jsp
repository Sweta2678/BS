<%@include file="/html/uielement/init.jsp"%>

<liferay-portlet:resourceURL id="unAttributeContentAction" var="unAttributeCotnent"  />

<div id="unAttributeContentModel" title="Un Attribute Content">
	<div class="modal-body">

			<label class="aui-field-label"><b>Un Attribute Content From</b></label>		
			<select name="unAttributeCountry" id="unAttributeCountryId" >
				<option value="">Select Country</option>
				<c:forEach var="countryCode" items="${countryList}">
					<option value="${countryCode}">${countryCode}</option>
				</c:forEach>
			</select>
		    <div id="countryValidation"></div>
	   		<br/>
	   		<div id="unAttributOptions">
	   		<label class="aui-field-label"><b>Attribute Options</b></label>
	   		<input type="checkbox" class="input_checkbox_filter" name="standards" value="standards" id="stdOption" title="Standards, Specification and Guidelines" />Standards, Specification and Guidelines
	   		<br/>
	   		<input type="checkbox" class="input_checkbox_filter" name="complianceDates" value="complianceDates" id="complianceDates" title="Compliance Dates" />Compliance Dates
	   		<br/>
	   		<input type="checkbox" class="input_checkbox_filter" name="expiryDates" value="expiryDates" id="expiryDates" title="Expiry Dates" />Expiry Dates
	   		<br/>
	   		<input type="checkbox" class="input_checkbox_filter" name="attachments" value="attachments" id="attachments" title="Attachments" />Attachments
	   		<br/>
	   		<input type="checkbox" class="input_checkbox_filter" name="images" value="images" id="images" title="Images" />Images
	   		<br/>
	   		<input type="checkbox" class="input_checkbox_filter" name="links" value="links" id="links" title="Links">Links 
	   		<br/>
	   		</div>
			<div class="modal-footer aui-panel-ft">
				<input class="btn pull-left" id="unAttributeContent" type="button" title="Un Attribute Content" value="Un Attribute Content" onclick="contentConfirmPopup()">
				<input type="button" class="btn pull-right unAttributeContentPopupClose" title="Close" value="Close">
			</div> 
				
	</div>
</div>

<script type="text/javascript">

	jQuery(document).ready(function() {
		jQuery('#stdOption').click(function() {
		  var checked = jQuery(this).prop('checked');
		  jQuery('#unAttributOptions').find('input:checkbox').prop('checked', checked);
		});
	})

function contentConfirmPopup(){
	
	var ctryCode = jQuery("#unAttributeCountryId").val();
	var attrValues = [];
	var unAttributeCotnentURL = '<%=unAttributeCotnent%>';
	jQuery("#unAttributOptions input:checked").each(function(i){
		attrValues[i] = jQuery(this).val();
	});
	if(attrValues.length > 0 && ctryCode != null && ctryCode != '' && typeof ctryCode != 'undefined' ){
		jQuery.msgBox({
			title: "Un Attribute Content",
			content: "Are you sure you want to Un attribute these contents?",
			type: "confirm",
			buttons: [{ value: "Yes" }, { value: "No" }],
			success: function (result) {
				if (result == "Yes") {
					jQuery.ajax({
						url: unAttributeCotnentURL+"&unAttributeCountry="+ctryCode+"&stdAttributesList="+attrValues,
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
									content:"Request to remove attributes is processed successfully.",
									success :function(result)
									{
										jQuery('.btn.pull-right.unAttributeContentPopupClose').click();
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
										jQuery('btn.pull-right.unAttributeContentPopupClose').click();
									}
								});
							}
						}
					});
				}
			}
		});	
	}
	else{
		if(attrValues.length < 1){
			jQuery("#countryValidation").text("Please select one attribute.");
			jQuery("#countryValidation").css({"color": "red"});
		}
		else if(ctryCode == null || ctryCode == '' ){
			jQuery("#countryValidation").text("Please select Country code.");
			jQuery("#countryValidation").css({"color": "red"});
		}
	}
}
	
</script>