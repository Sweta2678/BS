<%@include file="/html/init.jsp" %>
<portlet:actionURL var="addGemRoleURL" name="processSave"/>
<portlet:resourceURL var="validateKeyURL">
	<portlet:param name="modalType" value="validateGEMRoleCode" />
</portlet:resourceURL>

<div id="AddGemRoleModal" title="Add Role">
	<div style="max-height:400px; overflow-y:auto;">
		<form name="addGemRoleFM" method="post" action="">
			<div class="clear"></div>
			<input id="recPerPage" name="recPerPage" type="hidden" value="${recPerPage}" >
			<input id="pageNum" name="pageNum" type="hidden" value="${pageNum}" >
			<div class="form-horizontal">
				<div class="control-group">
					<label class="control-label" title="Key"><em class="required">* </em>Key:</label>
					<div class="controls">
						<input type="text" id="gemRoleCode" name="gemRoleCode" maxlength=50 style="width:300px;" class="input_text required">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" title="Owner Group Id">Owner Group Id:</label>
					<div class="controls">
						<input type="text" id="ownerGrpId" name="ownerGrpId" maxlength="100" style="width:300px;" class="input_text required">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" title="Owner Group"><em class="required">* </em>Owner Group:</label>
					<div class="controls">
						<input type="text" id="ownerGrpName" name="ownerGrpName" maxlength="200" style="width:300px;" class="input_text required">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" title="Owner(s)"><em class="required">* </em>Owner(s):</label>
					<div class="controls">
						<select id="busOwnerName" name="busOwnerName" style="width:315px;" >
							<c:forEach var="owner" items="${businessOwnerList}">
								<option value="${owner.fullName}">${owner.fullName}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" title="Deligate 1">Delegate 1:</label>
					<div class="controls">
						<input type="text" id="deligate1Name" name="deligate1Name" maxlength="200" style="width:300px;" class="input_text">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" title="Deligate 2">Delegate 2:</label>
					<div class="controls">
						<input type="text" id="deligate2Name" name="deligate2Name" maxlength="200" style="width:300px;" class="input_text">
					</div>
				</div>
			</div>
		</form>
	</div>
	<div class="modal-footer aui-panel-ft">
		<input class="btn pull-left" type="button" title="Edit Role" value="Save" onclick="submitAddGemRole('${addGemRoleURL}')">
		<button class="btn pull-right addGemRolePopupClose" title="Cancel">Cancel</button>
	</div>
</div>

<script type="text/javascript">
	$(".addGemRolePopupClose").click(function() {
		addGemRoleDialog.dialog('close');
	});

	function submitAddGemRole(url) {
		 var gemRoleCode = jQuery.trim(jQuery('#AddGemRoleModal input#gemRoleCode').val());
		 var ownerGrpName = jQuery.trim(jQuery('#AddGemRoleModal input#ownerGrpName').val());
		 var busOwnerName = jQuery.trim(jQuery('#AddGemRoleModal #busOwnerName option:selected').val());
		 
		 if(typeof gemRoleCode == 'undefined' || gemRoleCode == null || gemRoleCode == '' || gemRoleCode == 'null') {
			 jQuery.msgBox("Please enter Role Key.");
		 } else if(gemRoleCode.length > 50){
			 jQuery.msgBox("Role Key cannot be more than 50 characters.");
		 } else if(typeof ownerGrpName == 'undefined' || ownerGrpName == null || ownerGrpName == '' || ownerGrpName == 'null') {
			 jQuery.msgBox("Please enter Owner Group Name.");
		 } else if(ownerGrpName.length > 200){
			 jQuery.msgBox("Owner Group Name cannot be more than 200 characters.");
		 } else if(typeof busOwnerName == 'undefined' || busOwnerName == null || busOwnerName == '' || busOwnerName == 'null') {
			 jQuery.msgBox("Please select Business Owner.");
		 } else {
			 $.ajax({
			  	url: '${validateKeyURL}',
			  	data: {"gemRoleCode":gemRoleCode},
				type: "POST",
			  	dataType: "text",
			    success: function(data) {
			    	if (data != null && data != '' && typeof data != 'undefined') {
			    		if(data == 'Role Exist'){
			    			jQuery.msgBox("Role Key already exist. Please enter different Role Key.");
			    		} else {
			    			jQuery.msgBox("Invalid Role Key. Please enter different Role Key ID.");
			    		}
			    	} else {
			    		document.addGemRoleFM.action=url;
						document.addGemRoleFM.submit();
			    	}
			    }
			});
		 }
	}
</script>