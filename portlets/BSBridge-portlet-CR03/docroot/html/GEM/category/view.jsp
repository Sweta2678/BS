<%@include file="/html/init.jsp" %>
<c:choose>
	<c:when test="${isGemCategoryAdmin || isGemAdmin}">
<% int currPage = 0; %>

<!-- CSS Imports -->
<link type="text/css" rel="stylesheet" href="/BSBridge-theme/css/msgBoxLight.css" />
<!-- JS Imports -->
<script type="text/javascript" src="/BSTheme-theme/js/treeAdmin/jquery.msgBox.js"></script>

<!-- <link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/other/jquery-ui-1.10.1/themes/base/jquery-ui.css" />
<link type="text/css" rel="stylesheet" href="/BSBridge-theme/css/msgBoxLight.css" />
<link rel="stylesheet" type="text/css" media="screen" href="/BSTheme-theme/css/jqgrid/themes/ui.jqgrid.css" />
<link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/other/jquery-ui-1.10.1/themes/base/jquery.ui.all.css" /> -->

<!-- <script src="/BSTheme-theme/js/jqGrid/jquery.js" type="text/javascript"></script>
<script src="/BSTheme-theme/js/jqGrid/jquery-ui-custom.min.js" type="text/javascript"></script>
<script src="/BSTheme-theme/js/jqGrid/jquery.jqGrid.js" type="text/javascript"></script>
<script src="/BSTheme-theme/js/jqGrid/i18n/grid.locale-en.js" type="text/javascript"></script>
<script type="text/javascript" src="/BSTheme-theme/js/treeAdmin/jquery.msgBox.js"></script> -->

<portlet:resourceURL var="addCategoryURL">
	<portlet:param name="modalType" value="addCategory" />
</portlet:resourceURL>
<portlet:resourceURL var="editCategoryURL">
	<portlet:param name="modalType" value="editCategory" />
	<portlet:param name="categoryId" value="${gemCategory.categoryId}" />
</portlet:resourceURL>
<portlet:resourceURL var="showImportCategoryPopupURL">
	<portlet:param name="modalType" value="showImportCategoryPopup" />
</portlet:resourceURL>
<portlet:resourceURL var="importCategoriesFromXLSURL">
	<portlet:param name="modalType" value="importCategoriesFromXLS" />
</portlet:resourceURL>
<portlet:resourceURL var="exportCategoriesURL">
	<portlet:param name="modalType" value="exportCategories" />
</portlet:resourceURL>

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
	.categoryImportPopup {
		height: auto !important;
		width: auto !important;
	}
	.categoryImportPopup-content .modal-body{
		height: auto !important;
		width: auto !important;
	}
/** GEM Category Portlet CSS - END */
</style>
<!-- Keep the below 2 un-closed divs as this is a fix for footer left aligning issue -->
<div><div>

<div class="row">
	<div class="span12">
		<div class="row">
			<div class="span9"><h3 class="progress-title">Manage Categories</h3></div>
			<div class="span3">
				<a class="btn btn-small btn-primary pull-right" title="Add Category" href="javascript: void(0)" style="margin:0px 2px"
					onclick="createAddCategoryPopup('${addCategoryURL}')">Add Category</a>
				<c:if test="${isGemCategoryAdmin}">
					<a class="btn btn-small btn-primary pull-right" title="Import" href="javascript: void(0)" style="margin:0px 2px"
						onclick="showImportCategoryPopup()">Import</a>&nbsp;
				</c:if>
			</div>
		</div>
	</div>
</div>
<div class="clear"></div>

<div id="gemCategory">
	<form name="GEMCategoryFM" method="post" action="">
		<table id="gemCatgyTable" class="table table-bordered">
			<thead>
				<tr class="results_header_bar">
					<c:if test="${isGemCategoryAdmin}"><td width="10%"><strong>Category Id</strong></td></c:if>
					<td width="10%"><strong>GEM Category Id</strong></td>
					<td width="10%"><strong>Parent Id</strong></td>
					<td width="30%"><strong>Category Name</strong></td>
					<td width="10%"><strong>View Type</strong></td>
					<td width="10%"><strong>Answer All</strong></td>
					<td width="10%"><strong>Duplicatable</strong></td>
					<td width="13%"><strong>Display Order</strong></td>
					<td width="7%"><strong>Actions</strong></td>
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
				<liferay-ui:search-container-row className="com.ihg.brandstandards.db.model.GEMCategory" keyProperty="categoryId" modelVar="category">
					<portlet:resourceURL id='editCategoryPopupURL' var ="editCategoryPopupURL">
						<portlet:param name="modalType" value="editCategory" />
						<portlet:param name="categoryId" value="${category.categoryId}" />
					</portlet:resourceURL>
					<portlet:resourceURL id='deleteCategoryPopupURL' var ="deleteCategoryPopupURL">
						<portlet:param name="modalType" value="deleteCategory" />
						<portlet:param name="categoryId" value="${category.categoryId}" />
						<portlet:param name="gemCategoryCode" value="${category.gemCategoryCode}" />
						<portlet:param name="gemPrntCategoryId" value="${category.gemPrntCategoryId}" />
					</portlet:resourceURL>
					<tr id="${category.categoryId}">
						<c:if test="${isGemCategoryAdmin}"><td><span class="wrap_field">${category.categoryId}</span></td></c:if>
						<td><span class="wrap_field">${category.gemCategoryCode}</span></td>
						<td>
							<c:choose>
								<c:when test="${category.gemPrntCategoryId ne '-1'}">
									<span class="wrap_field">${category.gemPrntCategoryId}</span>
								</c:when>
							</c:choose>
						</td>
						<td><span class="wrap_field">${category.categoryName}</span></td>
						<td><span class="wrap_field">${category.categoryViewType}</span></td>
						<td><span class="wrap_field">${category.categoryAnsAll}</span></td>
						<td><span class="wrap_field">${category.duplicatable}</span></td>
						<td><span class="wrap_field">${category.displayOrderNumber}</span></td>
						<td style="text-align:center;">
							<a class="edit_link" href="javascript: void(0)" title="Edit Category" onclick="createEditCategoryPopup('${editCategoryPopupURL}')">
								<i class="icon-edit" id=""></i>
							</a>
							<a class="edit_link" href="javascript: void(0)" title="Delete Category" onclick="deleteCategory('${deleteCategoryPopupURL}', '${category.categoryId}')">
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

<div id="addCategory_popup" style="display:none;"></div>		
<div id="editCategory_popup" style="display:none;"> </div>	
<div id="importCategory_popup" style="display:none;"></div>		
<div id="exportCategory_popup" style="display:none;"> </div>	
	
<script type="text/javascript">
	var editCategoryURL = '${editCategoryURL}'; 
	var showEditCategoryDialog = '${showEditCategoryDialog}';
	
	var addCategoryDialog = '';
	var editCategoryDialog = '';
	var exportCategoryDialog = '';
	
	var addCategoryPopupTitle = 'Add Category';
	var editCategoryPopupTitle = 'Edit Category';
	var importCategoryPopupTitle = 'Import Categories';
	var exportCategoryPopupTitle = 'Export Categories';
	var closeLabel = 'Close';
	
	jQuery(document).ready(function() {
		/* Hiding Un-necessary info of liferay search container */
		if(jQuery('.search-results').length > 0){
			jQuery(".table-striped").css({"display":"none"});
		}
		
		addCategoryDialog = jQuery("#addCategory_popup").dialog({
			title: addCategoryPopupTitle,
			closeText: closeLabel,
			autoOpen: false,
			center: true,
			resizable: false,
			width: 850,
			modal: true,
			open: function() {
				jQuery('.addCategoryPopupClose').bind('click', function() {
					addCategoryDialog.dialog('close');
				});
			}
		});
		
		editCategoryDialog = jQuery("#editCategory_popup").dialog({
			title: editCategoryPopupTitle,
			closeText: closeLabel,
			autoOpen: false,
			center: true,
			resizable: false,
			width: 850,
			modal: true,
			open: function() {
				jQuery('.editCategoryPopupClose').bind('click', function() {
					editCategoryDialog.dialog('close');
				});
			}
		});
		
		if(showEditCategoryDialog == 'true'){
			$.ajax({
				url: editCategoryURL,
				type: "POST",
				dataType: "text",
				success: function(data) {
					if (data != null && data != '' && typeof data != 'undefined') {
						jQuery('#editCategory_popup').html(data);
						editCategoryDialog.dialog("open");
					}
				}
			});
		}
		
		exportCategoryDialog = $("#exportCategory_popup").dialog({
			title: exportCategoryPopupTitle,
			closeText: closeLabel,
			autoOpen: false,
			center: true,
			resizable: false,
			width: 325,
			modal: true,
			open: function() {
				$('.exportCategoryPopupClose').bind('click', function() {
					exportCategoryDialog.dialog('close');
				});
			}
		});
	});

	function createAddCategoryPopup(addCategoryPopupURL) {
		$.ajax({
			url: addCategoryPopupURL,
			type: "POST",
			dataType: "text",
			success: function(data) {
				if (data != null && data != '' && typeof data != 'undefined') {
					jQuery('#addCategory_popup').html(data);
					addCategoryDialog.dialog("open");
				}
			}
		});
	}
	
	function createExportCategoryPopup(exportCategoryPopupURL) {
		$.ajax({
			url: exportCategoryPopupURL,
			type: "POST",
			dataType: "text",
			success: function(data) {
				if (data != null && data != '' && typeof data != 'undefined') {
					jQuery('#exportCategory_popup').html(data);
					exportCategoryDialog.dialog("open");
				}
			}
		});
	}
	
	function createEditCategoryPopup(editCategoryPopupURL) {
		$.ajax({
			url: editCategoryPopupURL,
			type: "POST",
			dataType: "text",
			success: function(data) {
				if (data != null && data != '' && typeof data != 'undefined') {
					jQuery('#editCategory_popup').html(data);
					editCategoryDialog.dialog("open");
				}
			}
		});
	}
	function deleteCategory(deleteCategoryPopupURL, categoryId){
		jQuery.msgBox({
		    title: "Are You Sure",
		    content: "<span class=\"alert alert-danger\">Are you sure you want to Delete this category?</span>",
		    type: "confirm",
		    buttons: [{ value: "Yes" }, { value: "No" }],
		    success: function (importConfirmation) {
		        if (importConfirmation == "Yes") {
					$.ajax({
						url: deleteCategoryPopupURL,
						type: "POST",
						dataType: "text",
						success: function(data) {
							if (data != null && data != '' && typeof data != 'undefined') {
								if(data == 'Success'){
									jQuery("#gemCatgyTable #"+categoryId).remove();
									jQuery.msgBox({
			                         	title: "Success!",
			                            content: "Category deleted successfully." ,
			                            type: "info",
			                            success: function (result) {
											return;
			                           	}
									});
								} else {
									jQuery.msgBox({
										title: "Errors!",
			                            content: "Category can not be deleted." ,
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

	function showImportCategoryPopup() {
		jQuery("#errors").css('display','none');
		AUI().use('aui-dialog', 'aui-base', 'aui-io-plugin-deprecated', 'liferay-util-window', 'event', 'event-custom', 'io-form', function(A) {
			var showImportCategoryPopupURL = '${showImportCategoryPopupURL}';

	 		var importDialog = Liferay.Util.Window.getWindow({
		    dialog:{
				on: { close: function() {  } },
				cssClass: 'categoryImportPopup',
	            title: importCategoryPopupTitle,
	            centered: false,
				/* center: true, */
	            draggable: false,
	            resizable: false,
	            top: 250,
	            left: 200,
	            xy: [215, 100],
	            modal: true,
	            toolbars: {
	            	footer: buttons=[{
	                label: 'Import',
	                render:true,
	                id: 'importSave',
	                on: {
	                	click: function() {
	                	var fileField = A.one('#<portlet:namespace/>file');
	                	if (fileField.val()=="") {
	                		jQuery.msgBox({
	            	    	    title:"No file selected.",
	            	    	    content:"Please choose file again!",
	            	    	    type:"info"
	            	    	    }); 
	                		return;
	                	}
	                	
						jQuery.msgBox({
						    title: "Are You Sure",
						    content: "You want to do an import?",
						    type: "confirm",
						    buttons: [{ value: "Yes" }, { value: "No" }],
						    success: function (importConfirmation) {
						        if (importConfirmation == "Yes") {
				                    var cfg = {
				                        method: 'POST',
				                        enctype: 'multipart/form-data',
				                        form: {
											id: '<portlet:namespace/>excelfm',
				                            upload: true
				                        },
				                        on: {
											complete: function(id, o, args) {
												if(o && o.responseText) {
													response=A.JSON.parse(o.responseText);
													if(response.response == 'Failure') { 
														setTimeout(function () {
					                            			jQuery.msgBox({
						                          	    		title: "Please try again!",
						                          	    	    content: response.response + ": " + response.message,
						                          	    	    type:"info"
						                          	    	}); 
					                            			fileField.val('');
					                              		}, 2000);
													} else {
														if(response.response == 'Success') {
															setTimeout(function () {
																jQuery("#errors").slideUp("slow", function () {});
					                  	      	            	jQuery.msgBox({
					     	                                    	title: "Success!",
					     	                                        content: "Records updated successfully." ,
					     	                                        type: "info",
					     	                                        success: function (result) {
					     	                                        	importDialog.hide();
					     	                                            return;
																	}
																});
															}, 2000);
														} else {
															/* jQuery("#errors").css('display','none');
					                            		  	jQuery("#indexExcelGrid").jqGrid({
					                                    		data:o.responseText,
					                                    	  	jsonReader : {
																	root: "rows",
					                                    		    page: "page",
					                                    		    total: "total",
					                                    		    records: "records",
					                                    		    repeatitems: true,
					                                    		    cell: "cell",
					                                    		    id: "id"
					                                    		},
					                                    		datastr : o.responseText,
					                                    	  	datatype: "jsonstring",
					                                    	    colNames:['ID', 'Row', 'Column Name', 'Value', 'Error Message'],
					                                    	    colModel:[
					                                    	    	{name:'id', index:'id', classes: '', width:125, sorttype:"int", align:"center", sortable:false, search:false},
					                                    	    	{name:'row', index:'row', width:25, sortable:false, search:false},
					                                    	    	{name:'columnname', index:'columnName', width:145, sortable:false, search:false},
					                                    	    	{name:'value', index:'value', classes: '',width:200, sortable:false, search:false},
					                                    	    	{name:'errormessage', index:'errorMessage', classes: 'errorCol', width:450, sortable:false, search:false}
					                                    	    ],
					                                    	    rowNum:10,
					                                    	    rowList:[10,20,30,40],
					                                    	    pager: '#indexExcelPager',
					                                    	    sortname: 'id',
					                                    	    viewrecords: true,
					                                    	    sortorder: "asc",
					                                    	    caption: 'Report : Invalide Rows In XLS File',
					                                    	    width: 850,
					                                    	    height: "100%",
					                                    	    excel: true,
					                                    	    loadonce: true,
					                                    	    gridview: true
					                                  		}).jqGrid('navGrid', '#indexExcelPager', {
					                                    	   	add: false,
					                                    	    edit: false,
					                                    	    del: false,
					                                    	    search: false,
					                                    	    refresh: false
					                                   		}).jqGrid('navButtonAdd', '#indexExcelPager',{ 
					                                    	   	caption: "Navigation ",
					                                    	    buttonicon: "ui-icon-newwin",
					                                    	    position: "last", title:"Pagination", cursor: "pointer"
					                                  		}); */
															setTimeout(function () {
																jQuery.msgBox({
																	title: "Errors!",
						      	                                    content: "Excel contains errors in records." ,
						      	                                    type: "info",
						      	                                    success: function (result) {
						      	                                        return;
						      	                                    }
						      	                                });
						                            		}, 2000);
					                           			}
				                              	    }
												}
											}
										}
				                    };
									var request = A.io('${importCategoriesFromXLSURL}', cfg);
						        }
						        if(importConfirmation == "No" || importConfirmation == "Cancel")
								{
								  return;
								}
						    }
						});
					}
	            	}
	           	},
	            {
	           		label: 'Cancel',
	           		on: {
	                	click: function() {
	               			importDialog.hide();
						}
	           		}
	          	}]
	        }
		    }
	        }).plug(A.Plugin.IO, {autoLoad:true, uri:showImportCategoryPopupURL.toString()}).render();
	 		importDialog.show();
	 		importDialog.titleNode.html(importCategoryPopupTitle);
		});
	}
</script>

	</c:when>
	<c:otherwise>
		You do not have access to this portlet. Please contact support/technical team to get access to this portlet.
	</c:otherwise>
</c:choose>