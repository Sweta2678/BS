<%@include file="/html/init.jsp" %>
<c:choose>
	<c:when test="${isGemAdmin}">
<% int currPage = 0; %>
<!-- CSS Imports -->
<link type="text/css" rel="stylesheet" href="/BSBridge-theme/css/msgBoxLight.css" />
<!-- JS Imports -->
<script type="text/javascript" src="/BSTheme-theme/js/treeAdmin/jquery.msgBox.js"></script>
<portlet:actionURL var="refreshGemRolesURL" name="refreshGemRoles"/>
<portlet:resourceURL var="addGemRoleURL">
	<portlet:param name="modalType" value="addGemRole" />
</portlet:resourceURL>
<portlet:resourceURL var="editGemRoleURL">
	<portlet:param name="modalType" value="editGemRole" />
	<portlet:param name="gemRoleId" value="${gemRole.gemGrpId}" />
</portlet:resourceURL>

<style type="text/css">
	.lfr-search-container {margin-top: 0px!important;}
	.pager {margin: 10px 0 !important;}
	/** GEM Role Portlet CSS - START */
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
/** GEM Role Portlet CSS - END */
</style>
<!-- Keep the below 2 un-closed divs as this is a fix for footer left aligning issue -->
<div><div>

<form name="refreshGemRoleFM" method="post" action="">
<div class="row">
	<div class="span12">
		<div class="row">
			<div class="span9"><h3 class="progress-title">Manage Roles</h3></div>
			<div class="span3">
				<a class="btn btn-small btn-primary pull-right" title="Add Role" href="javascript: void(0)" style="margin:0px 2px"
					onclick="createAddGemRolePopup('${addGemRoleURL}')">Add Role</a>
				<a class="btn btn-small btn-primary pull-right" title="Refresh Roles" href="javascript: void(0)" style="margin:0px 2px" 
					onclick="submitRefreshGemRoleFM('${refreshGemRolesURL}')">Refresh Roles</a>
			</div>
		</div>
	</div>
</div>
</form>
<div class="clear"></div>

<div id="gemGemRole">
	<form name="GEMRoleFM" method="post" action="">
		<table id="gemRoleTable" class="table table-bordered">
			<thead>
				<tr class="results_header_bar">
					<td width="20%"><strong>Key</strong></td>
					<td width="7%"><strong>Role Id</strong></td>
					<td width="15%"><strong>Owner Group Id</strong></td>
					<td width="18%"><strong>Owner Group</strong></td>
					<td width="18%"><strong>Owner(s)</strong></td>
					<td width="10%"><strong>Delegate 1</strong></td>
					<td width="10%"><strong>Delegate 2</strong></td>
					<td width="2%"><strong>Actions</strong></td>
				</tr>
			</thead>
			<tbody>
			<liferay-ui:search-container hover="false" searchContainer="${searchContainer}">
				<liferay-ui:search-container-results>
				    <%
   						pageContext.setAttribute("results", searchContainer.getResults());
   						pageContext.setAttribute("total", searchContainer.getTotal() );
   						currPage = searchContainer.getCur();
				    %>
				</liferay-ui:search-container-results>
				<liferay-ui:search-container-row className="com.ihg.brandstandards.db.model.GEMRole" keyProperty="gemGrpId" modelVar="gemRole">
					<portlet:resourceURL id='editGemRolePopupURL' var ="editGemRolePopupURL">
						<portlet:param name="modalType" value="editGemRole" />
						<portlet:param name="gemRoleId" value="${gemRole.gemGrpId}" />
					</portlet:resourceURL>
					<portlet:resourceURL id='deleteGemRolePopupURL' var ="deleteGemRolePopupURL">
						<portlet:param name="modalType" value="deleteGemRole" />
						<portlet:param name="gemRoleId" value="${gemRole.gemGrpId}" />
					</portlet:resourceURL>
					<c:choose>
						<c:when test="${empty gemRole.ownerGrpName || gemRole.ownerGrpName eq ' '}" > 
							<tr id="${gemRole.gemGrpId}" style="background-color:#f2dede">
						</c:when>
						<c:otherwise>
							<tr id="${gemRole.gemGrpId}">
						</c:otherwise>
					</c:choose>
						<td><span class="wrap_field">${gemRole.gemGrpCode}</span></td>
						<td><span class="wrap_field">${gemRole.gemGrpId}</span></td>
						<td><span class="wrap_field">${gemRole.ownerGrpId}</span></td>
						<td><span class="wrap_field">${gemRole.ownerGrpName}</span></td>
						<td><span class="wrap_field">${gemRole.busOwnerName}</span></td>
						<td><span class="wrap_field">${gemRole.deligate1Name}</span></td>
						<td><span class="wrap_field">${gemRole.deligate2Name}</span></td>
						<td style="text-align:center;">
							<a class="edit_link" href="javascript: void(0)" title="Edit Role" onclick="createEditGemRolePopup('${editGemRolePopupURL}')">
								<i class="icon-edit" id=""></i>
							</a>
							<a class="edit_link" href="javascript: void(0)" title="Delete Role" onclick="deleteGemRole('${deleteGemRolePopupURL}', '${gemRole.gemGrpId}')">
								<i class="icon-remove"></i>
							</a>
						</td>
					</tr>
				</liferay-ui:search-container-row>
				<liferay-ui:search-iterator />
			</liferay-ui:search-container>		
			</tbody>
		</table>
	</form>
</div>

<div id="addGemRole_popup" style="display:none;"></div>		
<div id="editGemRole_popup" style="display:none;"> </div>	
	
<script type="text/javascript">
	var editGemRoleURL = '${editGemRoleURL}'; 
	var showEditRoleDialog = '${showEditRoleDialog}';
	
	var addGemRoleDialog = '';
	var editGemRoleDialog = '';
	
	var addGemRolePopupTitle = 'Add Role';
	var editGemRolePopupTitle = 'Edit Role';
	var closeLabel = 'Close';
	
	jQuery(document).ready(function() {
		/* Hiding Un-necessary info of liferay search container */
		if(jQuery('.search-results').length > 0){
			jQuery(".table-striped").css({"display":"none"});
		}
		
		addGemRoleDialog = jQuery("#addGemRole_popup").dialog({
			title: addGemRolePopupTitle,
			closeText: closeLabel,
			autoOpen: false,
			center: true,
			resizable: false,
			width: 850,
			modal: true,
			open: function() {
				jQuery('.addGemRolePopupClose').bind('click', function() {
					addGemRoleDialog.dialog('close');
				});
			}
		});
		
		editGemRoleDialog = jQuery("#editGemRole_popup").dialog({
			title: editGemRolePopupTitle,
			closeText: closeLabel,
			autoOpen: false,
			center: true,
			resizable: false,
			width: 850,
			modal: true,
			open: function() {
				jQuery('.editGemRolePopupClose').bind('click', function() {
					editGemRoleDialog.dialog('close');
				});
			}
		});
		
		if(showEditRoleDialog == 'true'){
			$.ajax({
				url: editGemRoleURL,
				type: "POST",
				dataType: "text",
				success: function(data) {
					if (data != null && data != '' && typeof data != 'undefined') {
						jQuery('#editGemRole_popup').html(data);
						editGemRoleDialog.dialog("open");
					}
				}
			});
		}
	});

	function createAddGemRolePopup(addGemRolePopupURL) {
		$.ajax({
			url: addGemRolePopupURL,
			type: "POST",
			dataType: "text",
			success: function(data) {
				if (data != null && data != '' && typeof data != 'undefined') {
					jQuery('#addGemRole_popup').html(data);
					addGemRoleDialog.dialog("open");
				}
			}
		});
	}
	
	function createEditGemRolePopup(editGemRolePopupURL) {
		$.ajax({
			url: editGemRolePopupURL,
			type: "POST",
			dataType: "text",
			success: function(data) {
				if (data != null && data != '' && typeof data != 'undefined') {
					jQuery('#editGemRole_popup').html(data);
					editGemRoleDialog.dialog("open");
				}
			}
		});
	}
	
	function deleteGemRole(deleteGemRolePopupURL, gemGrpId) {
		jQuery.msgBox({
		    title: "Are You Sure",
		    content: "<span class=\"alert alert-danger\">Are you sure you want to Delete this role?</span>",
		    type: "confirm",
		    buttons: [{ value: "Yes" }, { value: "No" }],
		    success: function (importConfirmation) {
		        if (importConfirmation == "Yes") {
					$.ajax({
						url: deleteGemRolePopupURL,
						type: "POST",
						dataType: "text",
						success: function(data) {
							if (data != null && data != '' && typeof data != 'undefined') {
								if(data == 'Success'){
									jQuery("#gemRoleTable #"+gemGrpId).remove();
									jQuery.msgBox({
			                         	title: "Success!",
			                            content: "Role deleted successfully." ,
			                            type: "info",
			                            success: function (result) {
											return;
			                           	}
									});
								} else {
									jQuery.msgBox({
										title: "Errors!",
			                            content: "Role can not be deleted." ,
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
	
	function submitRefreshGemRoleFM(url) {
		document.refreshGemRoleFM.action=url;
		document.refreshGemRoleFM.submit();
	}

</script>

	</c:when>
	<c:otherwise>
		You do not have access to this portlet. Please contact support/technical team to get access to this portlet.
	</c:otherwise>
</c:choose>