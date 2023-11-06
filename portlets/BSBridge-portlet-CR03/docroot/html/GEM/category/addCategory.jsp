<%@include file="/html/init.jsp" %>
<portlet:actionURL var="addCategoryURL" name="processSave"/>
<portlet:resourceURL var="validateKeyURL">
	<portlet:param name="modalType" value="validateGEMCategoryId" />
</portlet:resourceURL>

<div id="AddCategoryModal" title="Add Category">
	<div style="max-height:400px; overflow-y:auto;">
		<form name="addCategoryFM" method="post" action="">
			<div class="clear"></div>
			<input id="recPerPage" name="recPerPage" type="hidden" value="${recPerPage}" >
			<input id="pageNum" name="pageNum" type="hidden" value="${pageNum}" >
			<div class="form-horizontal">
				<div class="control-group">
					<label class="control-label" title="GEM Category Id"><em class="required">* </em>GEM Category Id:</label>
					<div class="controls">
						<input type="text" id="gemCategoryCode" name="gemCategoryCode" maxlength=20 style="width:300px;" class="input_text required">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" title="GEM Parent Category Id">GEM Parent Category Id:</label>
					<div class="controls">
						<select id="gemPrntCategoryId" name="gemPrntCategoryId" style="width:315px;">
							<option value="-1">None</option>
							<c:forEach var="category" items="${gemCategoryList}">
								<c:if test="${category.categoryId gt 0}">
									<option value="${category.gemCategoryCode}">${category.gemCategoryCode} (${category.categoryName})</option>
								</c:if>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" title="Category Name"><em class="required">* </em>Category Name:</label>
					<div class="controls">
						<input type="text" id="categoryName" name="categoryName" maxlength="100" style="width:300px;" class="input_text required">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" title="Category View Type"><em class="required">* </em>Category View Type:</label>
					<div class="controls">
						<select id="categoryViewType" name="categoryViewType">
							<c:forEach var="viewType" items="${categoryViewTypes}">
								<option value="${viewType}">${viewType}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" title="Category Answer All"><em class="required">* </em>Category Answer All:</label>
					<div class="controls">
						<select name="categoryAnsAll"  id="categoryAnsAll" >
							<option value="Yes" selected>Yes</option>
							<option value="No">No</option>
					   	</select>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" title="Duplicatable"><em class="required">* </em>Duplicatable:</label>
					<div class="controls">
						<select name="duplicatable"  id="duplicatable" >
							<option value="Yes">Yes</option>
							<option value="No" selected>No</option>
					   	</select>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" title="Display Order Number"><em class="required">* </em>Display Order Number:</label>
					<div class="controls">
						<input type="text" id="displayOrderNumber" name="displayOrderNumber" maxlength="5" style="width:50px;" class="input_text required">
					</div>
				</div>
			</div>
		</form>
	</div>
	<div class="modal-footer aui-panel-ft">
		<input class="btn pull-left" type="button" title="Edit Category" value="Save" onclick="submitAddCategory('${addCategoryURL}')">
		<button class="btn pull-right addCategoryPopupClose" title="Cancel">Cancel</button>
	</div>
</div>

<script type="text/javascript">
	$(".addCategoryPopupClose").click(function() {
		addCategoryDialog.dialog('close');
	});

	function submitAddCategory(url) {
		 var gemCategoryCode = jQuery.trim(jQuery('#AddCategoryModal input#gemCategoryCode').val());
		 var categoryName = jQuery.trim(jQuery('#AddCategoryModal input#categoryName').val());
		 var categoryViewType = jQuery.trim(jQuery('#AddCategoryModal #categoryViewType option:selected').val());
		 var displayOrderNumber = jQuery.trim(jQuery('#AddCategoryModal input#displayOrderNumber').val());
		 
		 if(typeof gemCategoryCode == 'undefined' || gemCategoryCode == null || gemCategoryCode == '' || gemCategoryCode == 'null') {
			 jQuery.msgBox("Please enter GEM Category ID.");
		 } else if(gemCategoryCode.length > 20){
			 jQuery.msgBox("GEM Category ID cannot be more than 20 characters.");
		 } else if(typeof categoryName == 'undefined' || categoryName == null || categoryName == '' || categoryName == 'null') {
			 jQuery.msgBox("Please enter Category Name.");
		 } else if(categoryName.length > 100){
			 jQuery.msgBox("Category Name cannot be more than 100 characters.");
		 } else if(typeof categoryViewType == 'undefined' || categoryViewType == null || categoryViewType == '' || categoryViewType == 'null') {
			 jQuery.msgBox("Please enter Category View Type.");
		 } else if(categoryViewType.length > 20){
			 jQuery.msgBox("Category View type cannot be more than 20 characters.");
		 } else if(typeof displayOrderNumber == 'undefined' || displayOrderNumber == null || displayOrderNumber == '' || displayOrderNumber == 'null') {
			 jQuery.msgBox("Please enter Display Order Number.");
		 } else if(isNaN(displayOrderNumber) == true || displayOrderNumber.length > 5){
			 jQuery.msgBox("Display Order Number cannot be more than 5 digit.");
		 } else {
			 $.ajax({
			  	url: '${validateKeyURL}',
			  	data: {"gemCategoryCode":gemCategoryCode},
				type: "POST",
			  	dataType: "text",
			    success: function(data) {
			    	if (data != null && data != '' && typeof data != 'undefined') {
			    		if(data == 'Category Exist'){
			    			jQuery.msgBox("Category ID already exist. Please enter different Category ID.");
			    		} else {
			    			jQuery.msgBox("Invalid Category ID. Please enter different Category ID.");
			    		}
			    	} else {
			    		document.addCategoryFM.action=url;
						document.addCategoryFM.submit();
			    	}
			    }
			});
		 }
	}
</script>