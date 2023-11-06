<%@include file="/html/uielement/init.jsp" %>
<c:choose>
	<c:when test="${(isElementContextAdmin || isElementTechAdmin)}">
<%
    String importElemProgressId = PwdGenerator.getPassword(PwdGenerator.KEY3, 4);
	int currPage = 0;
%>

<!-- CSS Imports -->
<link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/other/jquery-ui-1.10.1/themes/base/jquery-ui.css" />
<link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/msgBoxLight.css" />
<link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/jquery.multiselect.css" />
<link rel="stylesheet" type="text/css" media="screen" href="/BSTheme-theme/css/jqgrid/themes/ui.jqgrid.css" />
<link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/other/jquery-ui-1.10.1/themes/base/jquery.ui.all.css" />
<link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/uielement.css" />

<!-- JS Imports -->
<script src="/BSTheme-theme/js/jqGrid/jquery.js" type="text/javascript"></script>
<script src="/BSTheme-theme/js/jqGrid/jquery-ui-custom.min.js" type="text/javascript"></script>
<script src="/BSTheme-theme/js/jqGrid/jquery.jqGrid.js" type="text/javascript"></script>
<script src="/BSTheme-theme/js/jqGrid/i18n/grid.locale-en.js" type="text/javascript"></script>
<script type="text/javascript" src="/BSTheme-theme/js/treeAdmin/jquery.msgBox.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/jquery.multiselect.min.js"></script>

<portlet:resourceURL var="addElement">
	<portlet:param name="modalType" value="addElement" />
</portlet:resourceURL>
<portlet:resourceURL var="editElement">
	<portlet:param name="modalType" value="editElement" />
	<portlet:param name="elementId" value="${uiElement.elementId}" />
</portlet:resourceURL>
<portlet:resourceURL var="importElementPopURL">
	<portlet:param name="modalType" value="importElementPopup" />
	<portlet:param name="importElemProgressId" value="<%=importElemProgressId%>" />
</portlet:resourceURL>
<portlet:resourceURL var="importElementsFromXLS">
	<portlet:param name="modalType" value="importElementsFromXLS" />
</portlet:resourceURL>
<portlet:resourceURL var="exportElement">
	<portlet:param name="modalType" value="exportElement" />
</portlet:resourceURL>
<portlet:actionURL var="search" name="processSearch"/>
<portlet:actionURL var="clear" name="clearSearch"/>

<style type="text/css">
	button.ui-multiselect {
		width:220px !important;
    }
</style>
<div id="uielement">
<div class="rounded_container">
	<div class="rounded_container_contents">
		<h4 class="short_page_subtitle">UI Element Search</h4>
		<form name="UIElementFM" method="post" action="">
			<div class="report_container">
				<div class="button uielem_btn">
					<a class="results_filter" title="Import" href="javascript: void(0)" onclick="showImportUIElementPopup()">Import</a>
					<span></span>
				</div>
				<div class="button uielem_btn">
					<a class="results_filter" title="Export" href="javascript: void(0)" onclick="createExportElementPopup('${exportElement}')">Export</a>
					<span></span>
				</div>
				<c:if test="${isElementTechAdmin}">
					<div class="button uielem_btn">
						<a class="open_reports translation_add_link" title="Add Key" href="javascript: void(0)" onclick="createAddElementPopup('${addElement}')">Add Key</a>
						<span></span>
					</div>
				</c:if>
			</div>
			<div class="clear"></div>
			<div class="divider">&nbsp;</div>
			<div class="clear"></div>
			<div class="search_criteria">
				<div class="search_left_panel">
					<label class="wrapper_label"><span class="wrapper_span">Element Value:</span>              
                      		<input type="text" style="width: 216px;" id="elementValue" name="elementValue" value="${elementValue}" placeholder="Enter label text here" class="input_text required">             
                  		</label>
                  		<label class="wrapper_label"><span class="wrapper_span">Element Key:</span>              
                        <input type="text" style="width: 216px;" id="elementKey" name="elementKey" value="${elementKey}" placeholder="Enter key/Select from picklist" class="input_text required">
                    </label>
                    <c:if test="${isElementTechAdmin}">
	                    <label class="wrapper_label"><span class="wrapper_span">Used In:</span>              
							<select multiple="multiple" id="usedIn" name="usedIn" class="usedinmultis required" style="display: none;">
			                    <c:forEach var="opt" items="${usedInOptions}">
									<%
									    Map.Entry<String, String> opt = (Map.Entry<String, String>)pageContext.getAttribute("opt");
										String selected = "";
										if(renderRequest.getAttribute("moduleNames") != null) {
										    if(renderRequest.getAttribute("moduleNames").toString().contains(opt.getKey())) {
										        selected = "selected";
											}
										}
									%>
									<option value="${opt.key}" <%=selected%>>${opt.value}</option>
								</c:forEach>
			                </select>
	                    </label>
                    </c:if>
                    <input type="submit" style="margin:15px 0px 15px 220px;" class="navigation_button" 
                    	title="Search UI Element" value="Search" name="Search" id="Search" onclick="submitUIElementFM('${search}')">
                    <input type="submit" style="margin:15px 0px 15px 20px;" class="navigation_button" 
                    	title="Clear Search" value="Clear" name="Clear" id="Clear" onclick="submitUIElementFM('${clear}')">
				</div>
				<div class="search_right_panel">
					<label class="wrapper_label">
						<span class="wrapper_span">Search In:</span> 
						<select id="searchLanguage" name="searchLanguage">
							<c:forEach var="langOpt" items="${activeLanguages}">
								<option value="${langOpt.key}">${langOpt.value}</option>
							</c:forEach>
						</select>
					</label>
					<label class="wrapper_label">
						<span class="wrapper_span">Display Second Language:</span> 
						<select id="secondLanguage" name="secondLanguage">
							<option value="Second Language">Select Language</option>
							<c:forEach var="langOpt" items="${activeSecondLanguages}">
								<option value="${langOpt.key}">${langOpt.value}</option>
							</c:forEach>
						</select>
					</label>
				</div>
			</div>
			<table class="results_table">
				<tbody>
				<tr class="results_header_bar">
					<c:if test="${isElementTechAdmin}">
						<td class="" width="50"><strong>Id</strong></td>
					</c:if>
					<td class="" width="200"><strong>Element Key</strong></td>
					<td class="" width="100"><strong>Used In</strong></td>
					<td class="" width="250"><strong>English UK</strong></td>
					<td class="" width="250"><strong>${selSecondLanguage}</strong></td>
					<td class="" width="50"><strong>Actions</strong></td>
				</tr>
				<liferay-ui:search-container hover="false" searchContainer="${searchContainer}">
					<liferay-ui:search-container-results>
					    <%
    						pageContext.setAttribute("results", searchContainer.getResults());
    						pageContext.setAttribute("total", searchContainer.getTotal() );
    						currPage = searchContainer.getCur();
					    %>
					</liferay-ui:search-container-results>
					<liferay-ui:search-container-row className="com.ihg.brandstandards.bsadmin.model.UIElementData" 
						keyProperty="elementKey" modelVar="uiElement">
						<portlet:resourceURL id='editElementPopupURL' var ="editElementPopupURL">
							<portlet:param name="modalType" value="editElement" />
							<portlet:param name="elementId" value="${uiElement.elementId}" />
						</portlet:resourceURL>
						<tr>
							<c:if test="${isElementTechAdmin}">
								<td><span class="wrap_field" style="width:50px">${uiElement.elementId}</span></td>
							</c:if>
							<td><span class="wrap_field" style="width:200px">${uiElement.elementKey}</span></td>
							<td><span class="wrap_field" style="width:100px">${uiElement.usedIn}</span></td>
							<td><span class="wrap_field" style="width:250px">${uiElement.enGBValue}</span></td>
							<td><span class="wrap_field" style="width:250px">${uiElement.secondLangValue}</span></td>
							<td style="text-align:center;">
								<a class="edit_link" href="javascript: void(0)" title="Edit Element">
									<img  onclick="createEditElementPopup('${editElementPopupURL}')" 
										src="/BSTheme-theme/images/edit_pencil_icon.png" 
										title="Edit Element" alt="Edit Element"> 
								</a>
							</td>
						</tr>
					</liferay-ui:search-container-row>
					<liferay-ui:search-iterator />
				</liferay-ui:search-container>		
				</tbody>
			</table>
		</form>
		<div class="rounded_container_bottom"></div>
	</div>
</div>
</div>

<div id="addElement_popup" style="display:none;"></div>		
<div id="viewElement_popup" style="display:none;"></div>		
<div id="editElement_popup" style="display:none;"> </div>	
<div id="importElement_popup" style="display:none;"></div>		
<div id="exportElement_popup" style="display:none;"> </div>	
	
<script type="text/javascript">
	var availableElementKeys = '${availableElementKeys}'.split(',');
	var editElementURL = '${editElement}'; 
	var showEditElementDialog = '${showEditElementDialog}';
	
	var addElementDialog = '';
	var editElementDialog = '';
	var exportElementDialog = '';
	
	var addElementPopupTitle = 'Add UI Element';
	var editElementPopupTitle = 'Edit UI Element';
	var importElementPopupTitle = 'Import UI Element';
	var exportElementPopupTitle = 'Export UI Element';
	var closeLabel = 'Close';
	jQuery(".usedinmultis").multiselect();
	function submitUIElementFM(url) {
		document.UIElementFM.action = url;
		document.UIElementFM.submit();
	}
	jQuery(document).ready(function() {
		jQuery( "#elementKey" ).autocomplete({
			source: availableElementKeys
		});
		jQuery('#searchLanguage option[value="${searchLanguage}"]').prop('selected', true);
		jQuery('#secondLanguage option[value="${secondLanguage}"]').prop('selected', true);
		
		addElementDialog = jQuery("#addElement_popup").dialog({
			title: addElementPopupTitle,
			closeText: closeLabel,
			autoOpen: false,
			center: true,
			resizable: false,
			width: 850,
			modal: true,
			open: function() {
				jQuery('.addElementPopupClose').bind('click', function() {
					addElementDialog.dialog('close');
				});
			}
		});
		
		editElementDialog = jQuery("#editElement_popup").dialog({
			title: editElementPopupTitle,
			closeText: closeLabel,
			autoOpen: false,
			center: true,
			resizable: false,
			width: 850,
			modal: true,
			open: function() {
				jQuery('.editElementPopupClose').bind('click', function() {
					editElementDialog.dialog('close');
				});
			}
		});
		
		if(showEditElementDialog == 'true'){
			$.ajax({
				url: editElementURL,
				type: "POST",
				dataType: "text",
				success: function(data) {
					if (data != null && data != '' && typeof data != 'undefined') {
						jQuery('#editElement_popup').html(data);
						editElementDialog.dialog("open");
					}
				}
			});
		}
		
		exportElementDialog = $("#exportElement_popup").dialog({
			title: exportElementPopupTitle,
			closeText: closeLabel,
			autoOpen: false,
			center: true,
			resizable: false,
			width: 325,
			modal: true,
			open: function() {
				$('.exportElementPopupClose').bind('click', function() {
					exportElementDialog.dialog('close');
				});
			}
		});
	});

	function createAddElementPopup(addElementPopupURL) {
		$.ajax({
			url: addElementPopupURL,
			type: "POST",
			dataType: "text",
			success: function(data) {
				if (data != null && data != '' && typeof data != 'undefined') {
					jQuery('#addElement_popup').html(data);
					addElementDialog.dialog("open");
				}
			}
		});
	}
	
	function createExportElementPopup(exportElementPopupURL) {
		$.ajax({
			url: exportElementPopupURL,
			type: "POST",
			dataType: "text",
			success: function(data) {
				if (data != null && data != '' && typeof data != 'undefined') {
					jQuery('#exportElement_popup').html(data);
					exportElementDialog.dialog("open");
				}
			}
		});
	}
	
	function createEditElementPopup(editElementPopupURL) {
		$.ajax({
			url: editElementPopupURL,
			type: "POST",
			dataType: "text",
			success: function(data) {
				if (data != null && data != '' && typeof data != 'undefined') {
					jQuery('#editElement_popup').html(data);
					editElementDialog.dialog("open");
				}
			}
		});
	}
</script>

<script type="text/javascript">

	function showImportUIElementPopup() {
		var importElemProgressIdVar = '';
		jQuery("#errors").css('display','none');
		AUI().use('aui-dialog', 'aui-base', 'aui-io-plugin-deprecated', 'liferay-util-window', 'event', 'event-custom', 'io-form', function(A) {
			var importElementWindowURL = '${importElementPopURL}';
	 		importElemProgressIdVar='<%=importElemProgressId%>';

	 		var importDialog = Liferay.Util.Window.getWindow({
		    dialog:{
				on: { close: function() {  } },
				cssClass: 'uiElementImportPopup',
	            title: importElementPopupTitle,
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
	                	
	                	var isElementTechAdmin = '${isElementTechAdmin}';
						var importModule = $('#importModule').val();
						var importUsedIn = $('#importUsedIn').is(':checked');
						if(isElementTechAdmin == 'true' && 
								 (importModule == 'undefined' || importModule == null || importModule == '' || importModule == 'null')
								 && (typeof importUsedIn == 'undefined' || importUsedIn == null || importUsedIn == '' || importUsedIn == 'null') ){
								jQuery.msgBox("Please select Used In information OR Select Import \"Used In\" Information from Excel check box.");
								return;
						}
						
						if(isElementTechAdmin == 'true' && importModule && importUsedIn){
							jQuery.msgBox("Please select Used In information OR Select Import \"Used In\" Information from Excel check box.");
							return;
						}
						jQuery.msgBox({
						    title: "Are You Sure",
						    content: "You want to do an import?",
						    type: "confirm",
						    buttons: [{ value: "Yes" }, { value: "No" }],
						    success: function (importConfirmation) {
						        if (importConfirmation == "Yes") {
				                	eval(importElemProgressIdVar).startProgress(); 
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
															/* eval(importElemProgressIdVar).hideProgress(); */
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
					     	                                        	/* eval(importElemProgressIdVar).hideProgress(); */
					     	                                        	importDialog.hide();
					     	                  	      	            	/* reloadGrid(response.locale); */
					     	                                            return;
																	}
																});
															}, 2000);
														} else {
															jQuery("#errors").css('display','none');
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
					                                  		});
															setTimeout(function () {
																jQuery.msgBox({
																	title: "Errors!",
						      	                                    content: "Excel contains errors in records." ,
						      	                                    type: "info",
						      	                                    success: function (result) {
						      	                                    	/* eval(importElemProgressIdVar).hideProgress(); */
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
									var request = A.io('${importElementsFromXLS}', cfg);
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
	        }).plug(A.Plugin.IO, {autoLoad:true, uri:importElementWindowURL.toString()}).render();
	 		importDialog.show();
	 		importDialog.titleNode.html(importElementPopupTitle);
		});
	}
</script>

	</c:when>
	<c:otherwise>
		You do not have access to this portlet. Please contact support/technical team to get access to this portlet.
	</c:otherwise>
</c:choose>