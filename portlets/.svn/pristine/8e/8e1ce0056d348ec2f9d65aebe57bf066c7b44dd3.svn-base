<%@page import="com.ihg.brandstandards.db.model.GEMCategory"%>
<%@include file="/html/init.jsp"%>

<portlet:actionURL var="editCategoryURL" name="processEdit">
	<portlet:param name="categoryId" value="${editCategory.categoryId}" />
	<portlet:param name="delta" value="${recPerPage}" />
	<portlet:param name="cur" value="${pageNum}" />
</portlet:actionURL>
<portlet:resourceURL var="validateKeyURL">
	<portlet:param name="modalType" value="validateGEMCategoryId" />
</portlet:resourceURL>
<portlet:renderURL var="cancel" />

<div id="EditCategoryModal" title="Edit Category">
	<div style="max-height:400px; overflow-y:auto;">
		<form name="editCategoryFM" method="post" action="">
			<div class="clear"></div>
			<input id="recPerPage" name="recPerPage" type="hidden" value="${recPerPage}" >
			<input id="pageNum" name="pageNum" type="hidden" value="${pageNum}" >
			<div class="form-horizontal">
				<div class="control-group">
					<label class="control-label" title="">Category Id:</label>
					<div class="controls">
						<span style="display:inline-block;margin-top: 5px;">${editCategory.categoryId}</span>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" title="GEM Category Id"><em class="required">* </em>GEM Category Id:</label>
					<div class="controls">
						<input type="text" id="gemCategoryCode" name="gemCategoryCode" maxlength=20 style="width:300px;" class="input_text required" value="${editCategory.gemCategoryCode}">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" title="GEM Parent Category Id">GEM Parent Category Id:</label>
					<div class="controls">
						<select id="gemPrntCategoryId" name="gemPrntCategoryId" style="width:315px;">
							<option value="-1">None</option>
							<c:forEach var="category" items="${gemCategoryList}">
								<c:if test="${category.categoryId gt 0}">
									<option value="${category.gemCategoryCode}" 
										<c:if test="${editCategory.gemPrntCategoryId eq category.gemCategoryCode}">selected</c:if>>
										${category.gemCategoryCode} (${category.categoryName})
									</option>
								</c:if>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" title="Category Name"><em class="required">* </em>Category Name:</label>
					<div class="controls">
						<input type="text" id="categoryName" name="categoryName" maxlength="100" style="width:300px;" class="input_text required" value="${editCategory.categoryName}">
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" title="Category View Type"><em class="required">* </em>Category View Type:</label>
					<div class="controls">
						<select id="categoryViewType" name="categoryViewType">
							<c:forEach var="viewType" items="${categoryViewTypes}">
								<option value="${viewType}" <c:if test="${editCategory.categoryViewType eq viewType}">selected</c:if>>${viewType}</option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" title="Category Answer All"><em class="required">* </em>Category Answer All:</label>
					<div class="controls">
						<select name="categoryAnsAll"  id="categoryAnsAll" >
							<option value="Yes" <c:if test="${editCategory.gemPrntCategoryId eq 'Yes'}">selected</c:if> >Yes</option>
							<option value="No" <c:if test="${editCategory.gemPrntCategoryId eq 'No'}">selected</c:if> >No</option>
					   	</select>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" title="Duplicatable"><em class="required">* </em>Duplicatable:</label>
					<div class="controls">
						<select name="duplicatable"  id="duplicatable" >
							<option value="Yes" <c:if test="${editCategory.duplicatable eq 'Yes'}">selected</c:if> >Yes</option>
							<option value="No" <c:if test="${editCategory.duplicatable eq 'No'}">selected</c:if> >No</option>
					   	</select>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" title="Display Order Number"><em class="required">* </em>Display Order Number:</label>
					<div class="controls">
						<input type="text" id="displayOrderNumber" name="displayOrderNumber" maxlength="5" style="width:50px;" class="input_text required" value="${editCategory.displayOrderNumber}">
					</div>
				</div>
			</div>					
		</form>
	</div>
	<div class="modal-footer aui-panel-ft">
		<input class="btn pull-left" type="button" title="Save"	value="Save" onclick="submitEditCategory('${editCategoryURL}')">
		<button class="btn pull-right editCategoryPopupClose" title="Cancel">Cancel</button>
	</div>
</div>

<script type="text/javascript">
	$(".editCategoryPopupClose").click(function() {
		editCategoryDialog.dialog('close');
	});

	function submitEditCategory(url) {
		 var oldGemCategoryCode = '${editCategory.gemCategoryCode}';
		 var itemsPerPage = jQuery.trim(jQuery('#<portlet:namespace />itemsPerPage').val());
		 var currPage = jQuery.trim(jQuery('#<portlet:namespace />page').val());
		 var gemCategoryCode = jQuery.trim(jQuery('#EditCategoryModal input#gemCategoryCode').val());
		 var categoryName = jQuery.trim(jQuery('#EditCategoryModal input#categoryName').val());
		 var categoryViewType = jQuery.trim(jQuery('#EditCategoryModal #categoryViewType option:selected').val());
		 var displayOrderNumber = jQuery.trim(jQuery('#EditCategoryModal input#displayOrderNumber').val());
		 
		 if(typeof gemCategoryCode == 'undefined' || gemCategoryCode == null || gemCategoryCode == '' || gemCategoryCode == 'null') {
			 jQuery.msgBox("Please enter GEM Category ID.");
		 } else if(gemCategoryCode.length > 20){
			 jQuery.msgBox("GEM Category ID cannot be more than 20 characters.");
		 } else if(typeof categoryName == 'undefined' || categoryName == null || categoryName == '' || categoryName == 'null') {
			 jQuery.msgBox("Please enter Category Name.");
		 } else if(categoryName.length > 100){
			 jQuery.msgBox("Category Name cannot be more than 100 characters.");
		 } else if(typeof displayOrderNumber == 'undefined' || displayOrderNumber == null || displayOrderNumber == '' || displayOrderNumber == 'null') {
			 jQuery.msgBox("Please enter Display Order Number.");
		 } else if(isNaN(displayOrderNumber) == true || displayOrderNumber.length > 5){
			 jQuery.msgBox("Display Order Number cannot be more than 5 digit.");
		 } else {
			/* if(typeof itemsPerPage != 'undefined' && itemsPerPage != null && itemsPerPage != '' && itemsPerPage != 'null'){
				url = url+'&delta='+itemsPerPage;
			}
			if(typeof currPage != 'undefined' && currPage != null && currPage != '' && currPage != 'null'){
				url = url+'&cur='+currPage;
			} */
			if(oldGemCategoryCode != gemCategoryCode) {
				$.ajax({
				  	url: '${validateKeyURL}',
				  	data: {"gemCategoryCode":gemCategoryCode},
					type: "POST",
				  	dataType: "text",
				    success: function(data) {
				    	if (data != null && data != '' && typeof data != 'undefined') {
				    		if(data == 'Category Exist'){
				    			jQuery.msgBox("GEM Category ID already exist. Please enter different GEM Category ID.");
				    		} else {
				    			jQuery.msgBox("Invalid GEM Category ID. Please enter different GEM Category ID.");
				    		}
				    	} else {
							document.editCategoryFM.action = url;
							document.editCategoryFM.submit();
				    	}
				    }
				});
			} else {
				document.editCategoryFM.action = url;
				document.editCategoryFM.submit(); 
			}
		 }
	}
</script>