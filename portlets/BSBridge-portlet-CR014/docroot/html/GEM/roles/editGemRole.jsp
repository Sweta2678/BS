<%@include file="/html/init.jsp"%>
<portlet:actionURL var="editGemRoleURL" name="processEdit">
	<portlet:param name="gemRoleId" value="${editGemRole.gemGrpId}" />
	<portlet:param name="delta" value="${recPerPage}" />
	<portlet:param name="cur" value="${pageNum}" />
</portlet:actionURL>
<portlet:resourceURL var="validateKeyURL">
	<portlet:param name="modalType" value="validateGEMRoleCode" />
</portlet:resourceURL>
<portlet:renderURL var="cancel" />

<div id="EditGemRoleModal" title="Edit Role">
	<div style="max-height:400px; overflow-y:auto;">
		<form name="editGemRoleFM" method="post" action="">
			<div class="clear"></div>
			<input id="recPerPage" name="recPerPage" type="hidden" value="${recPerPage}" >
			<input id="pageNum" name="pageNum" type="hidden" value="${pageNum}" >
			<div class="form-horizontal">
				<div class="control-group">
					<label class="control-label" title="Role Id">Role Id:</label>
					<div class="controls">
						<span style="display:inline-block;margin-top: 5px;">${editGemRole.gemGrpId}</span>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" title="Owner Group Id">Owner Group Id:</label>
					<div class="controls">
						<input type="text" id="ownerGrpId" name="ownerGrpId" maxlength="100" style="width:300px;" class="input_text required" value="${editGemRole.ownerGrpId}">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" title="Key"><em class="required">* </em>Key:</label>
					<div class="controls">
						<span style="display:inline-block;margin-top: 5px;">${editGemRole.gemGrpCode}</span>
						<%-- <input type="text" id="gemRoleCode" name="gemRoleCode" maxlength="50" style="width:300px;" class="input_text required" value="${editGemRole.gemRoleCode}"> --%>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" title="Owner Group"><em class="required">* </em>Owner Group:</label>
					<div class="controls">
						<input type="text" id="ownerGrpName" name="ownerGrpName" maxlength="200" style="width:300px;" class="input_text required" value="${editGemRole.ownerGrpName}">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" title="Owner(s)"><em class="required">* </em>Owner(s):</label>
					<div class="controls">
						<select id="busOwnerName" name="busOwnerName" style="width:315px;" >
							<c:forEach var="owner" items="${businessOwnerList}">
								<option value="${owner.fullName}" <c:if test="${editGemRole.busOwnerName eq owner.fullName}">selected</c:if>>${owner.fullName}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" title="Delegate 1">Delegate 1:</label>
					<div class="controls">
						<input type="text" id="deligate1Name" name="deligate1Name" maxlength="200" style="width:300px;" class="input_text required" value="${editGemRole.deligate1Name}">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" title="Delegate 2">Delegate 2:</label>
					<div class="controls">
						<input type="text" id="deligate2Name" name="deligate2Name" maxlength="200" style="width:300px;" class="input_text required" value="${editGemRole.deligate2Name}">
					</div>
				</div>
			</div>
		</form>
	</div>
	<div class="modal-footer aui-panel-ft">
		<input class="btn pull-left" type="button" title="Save"	value="Save" onclick="submitEditGemRole('${editGemRoleURL}')">
		<button class="btn pull-right editGemRolePopupClose" title="Cancel">Cancel</button>
	</div>
</div>

<script type="text/javascript">
	$(".editGemRolePopupClose").click(function() {
		editGemRoleDialog.dialog('close');
	});

	function submitEditGemRole(url) {
		 var itemsPerPage = jQuery.trim(jQuery('#<portlet:namespace />itemsPerPage').val());
		 var currPage = jQuery.trim(jQuery('#<portlet:namespace />page').val());
		 var gemRoleCode = jQuery.trim(jQuery('#EditGemRoleModal input#gemRoleCode').val());
		 var ownerGrpName = jQuery.trim(jQuery('#EditGemRoleModal input#ownerGrpName').val());
		 var busOwnerName = jQuery.trim(jQuery('#EditGemRoleModal #busOwnerName option:selected').val());
		 
		 /* if(typeof gemRoleCode == 'undefined' || gemRoleCode == null || gemRoleCode == '' || gemRoleCode == 'null') {
			 jQuery.msgBox("Please enter Role Key.");
		 } else if(gemRoleCode.length > 50){
			 jQuery.msgBox("Role Key cannot be more than 50 characters.");
		 } else */ 
		 if(typeof ownerGrpName == 'undefined' || ownerGrpName == null || ownerGrpName == '' || ownerGrpName == 'null') {
			 jQuery.msgBox("Please enter Owner Group Name.");
		 } else if(ownerGrpName.length > 200){
			 jQuery.msgBox("Owner Group Name cannot be more than 200 characters.");
		 } else if(typeof busOwnerName == 'undefined' || busOwnerName == null || busOwnerName == '' || busOwnerName == 'null') {
			 jQuery.msgBox("Please select Business Owner.");
		 } else {
			 /*if(typeof itemsPerPage != 'undefined' && itemsPerPage != null && itemsPerPage != '' && itemsPerPage != 'null') {
				url = url+'&delta='+itemsPerPage;
				jQuery('#recPerPage').val(itemsPerPage);
			}
			if(typeof currPage != 'undefined' && currPage != null && currPage != '' && currPage != 'null'){
				url = url+'&cur='+currPage;
				jQuery('#pageNum').val(currPage);
			}*/
			document.editGemRoleFM.action = url;
			document.editGemRoleFM.submit();
		 }
	}
</script>