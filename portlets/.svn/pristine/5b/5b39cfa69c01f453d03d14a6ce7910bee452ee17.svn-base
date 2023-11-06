<%@include file="init.jsp"%>
<style type="text/css">
	.lfr-search-container {margin-top: 0px!important;}
	.pager {margin: 10px 0 !important;}
	/** GEM Category Portlet CSS - START */
	.wrap_field {
		display: block;
		float: left;
		height: auto;
		overflow: hidden;
		word-wrap: break-word;
	}
	.aui em.required {
		color: #F00;
	}
</style>
<portlet:resourceURL var="addNewDepartmentURL">
	<portlet:param name="cmd" value="addDepartment" />
</portlet:resourceURL>
<portlet:resourceURL var="checkDeleteAssociationURL">
	<portlet:param name="cmd" value="checkDeleteAssication" />
</portlet:resourceURL>
<div>
	<liferay-ui:error key="error-in-adding-new-department" message="Error in adding new department."/>
	<liferay-ui:error key="error-in-deleting-department" message="Error in deleting department."/>
	<%-- <liferay-ui:success key="department-has-added-successfully"  message="Department added successfully."/>
	<liferay-ui:success key="department-has-updated-successfully"  message="Department updated successfully."/>
	<liferay-ui:success key="department-has-deleted-successfully"  message="Department deleted successfully."/> --%>
	
	
<div class="row">
	<div class="span12">
		<div class="row">
			<div class="span9"><h3 class="progress-title">Manage Departments</h3></div>
			<div class="span3">
				<a class="btn btn-small btn-primary pull-right" title="Add Category" href="javascript: void(0)" style="margin:0px 2px"
					onclick="createAddDepartmentPopup('${addNewDepartmentURL}')">Add New Department</a>
			</div>
		</div>
	</div>
</div>
<div class="clear"></div>
	<div id="gemDepartment">
		<%@include file="/html/GEM/departmentAdmin/department-list.jsp"%>
	</div>
<div class="clear"></div>
</div>
<div id="addDepartment_popup" style="display:none;"></div>
<div id="editDepartment_popup" style="display:none;"></div>
<script type="text/javascript">
var addDepartmentDialog = '';
var editDepartmentDialog = '';
var addDepartmentPopupTitle = 'Add Department';
var editDepartmentPopupTitle = 'Edit Department';
var closeLabel = 'Close';
jQuery(document).ready(function() {
	/* Hiding Un-necessary info of liferay search container */
	if(jQuery('.search-results').length > 0){
		jQuery(".table-striped").css({"display":"none"});
	}
addDepartmentDialog = jQuery("#addDepartment_popup").dialog({
	title: addDepartmentPopupTitle,
	closeText: closeLabel,
	autoOpen: false,
	center: true,
	resizable: false,
	width: 850,
	modal: true,
	open: function() {
		jQuery('.addDepartmentPopupClose').bind('click', function() {
			addDepartmentDialog.dialog('close');
		});
	}
});

editDepartmentDialog = jQuery("#editDepartment_popup").dialog({
	title: editDepartmentPopupTitle,
	closeText: closeLabel,
	autoOpen: false,
	center: true,
	resizable: false,
	width: 850,
	modal: true,
	open: function() {
		jQuery('.editDepartmentPopupClose').bind('click', function() {
			editDepartmentDialog.dialog('close');
		});
	}
});

});
function createAddDepartmentPopup(addDepartmentPopupURL) {
	$.ajax({
		url: addDepartmentPopupURL,
		type: "POST",
		dataType: "text",
		success: function(data) {
			if (data != null && data != '' && typeof data != 'undefined') {
				jQuery('#addDepartment_popup').html(data);
				addDepartmentDialog.dialog("open");
			}
		}
	});
}

function createEditDepartmentPopup(editDepartmentPopupURL) {
	$.ajax({
		url: editDepartmentPopupURL,
		type: "POST",
		dataType: "text",
		success: function(data) {
			if (data != null && data != '' && typeof data != 'undefined') {
				jQuery('#editDepartment_popup').html(data);
				editDepartmentDialog.dialog("open");
			}
		}
	});
}
function deleteDepartment(deleteDepartmentPopupURL, departmentId){
	jQuery.ajax({          
        url:'<%=checkDeleteAssociationURL%>',
        data: {
        	departmentId: departmentId
        },
        type: 'POST',
		async: false,
        success: function(data) 
        { 
			var parsedData = JSON.parse(data);
            var isAssociate =  parsedData.isAssociate;
            var isActive =  parsedData.isActive;
            if(isAssociate=='true'){
            	jQuery.msgBox("This Department has association with publications. You can't delete this department.");
            	
            }else{
            	var confirmationTitle ='';
            	var successMsg = '';
            	if(isActive=='Y'){
            		confirmationTitle ='<span class=\"alert alert-danger\">Are you sure you want to delete this department?</span>';
            		successMsg ='Department deleted successfully.';
            	}else{
            		
            		confirmationTitle ='<span class=\"alert alert-danger\">This department is not associated to any publication. Are you sure you want to permanently delete this department and all its associated roles ?</span>';
            		successMsg ='Department has permanently deleted.';
            	}
          
            	jQuery.msgBox({
        		    title: "Are You Sure",
        		    content: confirmationTitle,
        		    type: "confirm",
        		    buttons: [{ value: "Yes" }, { value: "No" }],
        		    success: function (importConfirmation) {
        		        if (importConfirmation == "Yes") {
        					$.ajax({
        						url: deleteDepartmentPopupURL,
        						type: "POST",
        						dataType: "text",
        						success: function(data) {
        							if (data != null && data != '' && typeof data != 'undefined') {
        								if(data == 'Success'){
        									if(isActive=='Y'){
        										jQuery("#gemDeptTable #"+departmentId+" #statusSpan").text("Inactive");
        									}else{
        										jQuery("#gemDeptTable #"+departmentId).remove();
        										
        									}
        									
        									jQuery.msgBox({
        			                         	title: "Success!",
        			                            content: successMsg ,
        			                            type: "info",
        			                            success: function (result) {
        											return;
        			                           	}
        									});
        								} else {
        									jQuery.msgBox({
        										title: "Errors!",
        			                            content: "Department can not be deleted." ,
        			                            type: "info",
        			                            success: function (result) {
        			                       			return;
        			                        	}
        									});
        								}
        							}
        						}
        					});
        		        } else if(importConfirmation == "No" || importConfirmation == "Cancel") {
        					return;
        				}
        		    }
        		});
            	
            	
            	
            }
        }
    }); 
}

</script>
