<%@include file="/html/glossary/init.jsp" %>
<%
  String importProgressIdExl = PwdGenerator.getPassword(PwdGenerator.KEY3, 4);
  String exportProgressIdExl = PwdGenerator.getPassword(PwdGenerator.KEY3, 4);
%>
<portlet:renderURL var="changeCharacter"/>
<portlet:actionURL var="deleteGlossary" name="deleteGlossary" />
<portlet:actionURL var="exportURL"  name="exportURL" ></portlet:actionURL>
<portlet:resourceURL var="uploadExcelUrl" id="uploadValidateExcel"/>
<portlet:resourceURL var="exportExcelUrl" id="excelExport" />

<portlet:resourceURL var="glossaryImportPopupURL" id="glossaryImportPopup">
	<portlet:param name="IMPORT_ID_EXCEL" value="<%=importProgressIdExl%>"/>
</portlet:resourceURL>

<portlet:resourceURL var="glossaryExportPopupURL" id="glossaryExportPopup">
	<portlet:param name="EXPORT_ID_EXCEL" value="<%=exportProgressIdExl%>"/>
</portlet:resourceURL>
	  	 
<link rel="stylesheet" type="text/css" media="screen" href="/BSTheme-theme/css/jqgrid/themes/ui.jqgrid.css" />
<script src="/BSTheme-theme/js/jqGrid/grid.locale-en.js"></script>
<script src="/BSTheme-theme/js/jquery-migrate-1.0.0.js"></script>
<script src="/BSTheme-theme/js/jqGrid/jquery.jqGrid.js"></script>

<script type="text/javascript">
function showImportGlossaryPopup() {
  jQuery("#errors").css('display','none');
  AUI().use('aui-dialog', 'aui-base', 'aui-io-plugin-deprecated', 'aui-io-request', 'liferay-util-window', 'event', 'event-custom', 'io-form', function(A) {
	 var glossaryImportPopupURL='${glossaryImportPopupURL}';
	 var importIdVarExl='<%=importProgressIdExl%>';

	 var glossaryImportDialog = Liferay.Util.Window.getWindow({
	     dialog:{	 
			    on: { close: function() {  } },
				cssClass: 'glossaryImportPopup',  
	            title: 'Import Glossary',
	            centered: false,
	            draggable: false,
	            resizable: false,
	            top: 250,
	            left: 200,
	            xy:[250,200],
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
	            	    	    type:"info",
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
	                	
						eval(importIdVarExl).startProgress(); 
	                    var cfg = {
	                        method: 'POST',
	                        enctype: 'multipart/form-data',
	                        form: {
	                            id: '<portlet:namespace/>excelfm',
	                            upload: true
	                        },
	                        on: {
	                        	  complete: function(id, o, args) {
	                                  if(o && o.responseText)
	                            	  {
	                            	      response=A.JSON.parse(o.responseText);
		                            	  if(response.response == 'Failure')
		                            	  { 
		                            		  setTimeout(function () {
		                            		  /* eval(importIdVarExl).hideProgress(); */
		                            		  jQuery.msgBox({
		                          	    	    title: "Please try again!",
		                          	    	    content: response.response+": "+response.message,
		                          	    	    type:"info",
		                          	    	    }); 
		                            		   fileField.val('');
		                              		  }, 2000);
		                            	  } else {
		                            		  if(response.response == 'Success')
		                                	  {
		                  	      	              setTimeout(function () {
			                  	      	              jQuery("#errors").slideUp("slow", function () {});
			                  	      	              jQuery.msgBox({
			     	                                         title: "Success!",
			     	                                         content: "Record Inserted Successfully." ,
			     	                                         type: "info",
			     	                                         success: function (result) {
			     	                                        	 /* eval(importIdVarExl).hideProgress(); */
			     	                  	      	            	  glossaryImportDialog.hide();
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
		                                    	      colNames:['ID', 'Row','Column Name','Value','Error Message'],
		                                    	      colModel:[
		                                    	      {name:'id',index:'id', width:50, sorttype:"int",align:"center",sortable:false,search:false},
		                                    	      {name:'row',index:'row', width:50,sortable:false,search:false},
		                                    	      {name:'columnname',index:'columnName', width:145,sortable:false,search:false},
		                                    	      {name:'value',index:'value', width:200,sortable:false,search:false},
		                                    	      {name:'errormessage',index:'errorMessage',classes: 'errorCol', width:405,sortable:false,search:false}
		                                    	      ],
		                                    	      rowNum:10,
		                                    	      rowList:[10,20,30,40],
		                                    	      pager: '#indexExcelPager',
		                                    	      sortname: 'id',
		                                    	      viewrecords: true,
		                                    	      sortorder: "asc",
		                                    	      caption: 'Report : Invalid Rows In XLS File',
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
		                                    	    }).jqGrid('navButtonAdd','#indexExcelPager',{ 
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
			      	                                        	  /* eval(importIdVarExl).hideProgress(); */
			      	                                             return;
			      	                                         }
			      	                                     });
			                                        },
			                                        2000);
		                            		   }
	                              	    	}
	                            	  	}
	                             	}
	                            }
	                    };
	                    var request = A.io('<%=uploadExcelUrl.toString()%>', cfg);
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
		            		glossaryImportDialog.hide();
	               		}
		           	}
	          	  }]
	            }
	     	  }
	        }).plug(A.Plugin.IO, {autoLoad:true, uri: glossaryImportPopupURL.toString()}).render();
	 		glossaryImportDialog.show();
	 		glossaryImportDialog.titleNode.html('Import Glossary');
	  });
	}
</script>

<script type="text/javascript">
function showExportGlossaryPopup() {
	jQuery("#errors").css('display','none');
	AUI().use('aui-dialog', 'aui-base', 'aui-io-plugin-deprecated', 'liferay-util-window', 'liferay-portlet-url', 'event', 'event-custom', 'io-form', function(A) {
	  	 var urlExcelExport = '${exportExcelUrl}';
	  	 var exportURLView='${glossaryExportPopupURL}';
	  	 var exportIdVarExl='<%=exportProgressIdExl%>';
	  	 var glossaryExportDialog = Liferay.Util.Window.getWindow({
	 		 dialog:{
	  			    on: { close: function() {  } },
					cssClass: 'glossaryExportPopup',  
	  	            title: 'Export Glossary',
	  	            centered: false,
	  	            draggable: false,
	  	            resizable: false,
	  	            xy:[250,200],
	  	            modal: true,
	  	            toolbars: {
		            	footer: buttons=[{
		            	label: 'Export',
		                on: {
		                	click: function() {
	  	                	//urlExcelExport.setParameter('SELECTED_LOCALE', A.one('#<portlet:namespace/>localeCd').get('value'));
	  	                	urlExcelExport = urlExcelExport+'&SELECTED_LOCALE='+A.one('#<portlet:namespace/>localeCd').get('value');
	  	                	eval(exportIdVarExl).startProgress(); 
	  	                    var cfg = {
	  	                        method: 'POST',
	  	                        form: {
		                            id: '<portlet:namespace/>excelfm',
		                        },
	  	                        on: {
	  	                              complete: function(id, o, args) {
	  	                            	  var responseParseError = false;
	  	                            	  var response = "";
	  	                              	  if(o && o.responseText) {
			                            	  try {  
		  	                            	  	response = A.JSON.parse(o.responseText);
			                            	  } catch(e){
			                            		  responseParseError = true;
			                            	  }
			                            	  
			                            	  if(!responseParseError && response.response == 'Failure') { 
			                            		  setTimeout(function () {
			                            		  jQuery.msgBox({
			                          	    	    title: "Please try again!",
			                          	    	    content: response.response+": "+response.message,
			                          	    	    type:"info",
			                          	    	    }); 
			                            		   fileField.val('');
			                              		  }, 2000);
			                            	  	}
			                            	  	else if(responseParseError || response.response == 'Success') {
	                            		  			setTimeout(function () {
		                  	      	            		jQuery("#errors").slideUp("slow", function () {});
		                  	      	            		jQuery.msgBox({
		     	                                         	title: "Success!",
		     	                                         	content: "Glossary Export Successfully." ,
		     	                                         	type: "info",
		     	                                         	success: function (result) {
		     	                  	      	            	 	glossaryExportDialog.hide();
		     	                                             	return;
		     	                                         	}
		     	                                     	});
		                  	      	                }, 2000);
	                            		  			location.href = urlExcelExport;
	                                	  		}
                                	  	}
	  	                            	//glossaryExportDialog.hide();
	  	                             }
	  	                            }
	  	                    };
	  	                    var request = A.io(urlExcelExport, cfg);  
	  	                    }
		                }
	  	             },
	  	             {
	  	                label: 'Cancel',
		           		on: {
		                	click: function() {
		                		glossaryExportDialog.hide();
		                	}
	  	               	}
	  	          	  }]
		        	}
		    	  }
		}).plug(A.Plugin.IO, {uri: exportURLView.toString()}).render();
	  	glossaryExportDialog.show();
	  	glossaryExportDialog.titleNode.html('Export Glossary');
	});
}
</script>

<c:if test ="${loggedIn}">
		<script src="/BSTheme-theme/js/glossaryListing.js"></script>
		<c:choose>
			<c:when test="${errorMessage ne null}">
				<c:out value="${errorMessage}"></c:out>
			</c:when>
		<c:otherwise>
				<liferay-ui:success key="deleteFailMessage" message="deleteFailMessage"></liferay-ui:success>
		<div class="rounded_container">
	        <div class="rounded_container_contents">
	        
	            <h4 class="short_page_subtitle">Glossary</h4>
				
				<form id="glossaryForm" method="post"> 
	            <div class="results_right_util result_utils"> 
	                <div class="button filter_results_button"><a href="javascript:void(0)" onClick="javascript: showImportGlossaryPopup();" class="glossary_import_a">Import Glossary</a><span></span></div> 
	                <a class="add_new_glossary" href="/web/brand-standards/glossary-wizard?visibleChar=${activeChar}"><img class="add_icon" src="/BSTheme-theme/images/plus_icon.png" alt="add new entry" title="add new entry" /> Add New Entry</a> 
	            </div>
				<div class="report_container"> 
					<div class="button report_run_btn"><a href="javascript:void(0)" onClick="javascript: showExportGlossaryPopup();"  id="export_glossary" class="glossary_export_a">Export Glossary</a><span></span></div> 
				</div>
	            <div class="clear"></div>
	            
	            <div class="divider">&nbsp;</div>
	            <div class="clear"></div>
				
	             <!-- Glossary pagination start -->
				 <input type="hidden" name="glossaryId" id="glossaryId" value="">
				 	<div class="row"> 
				 		<div class="pagination pagination-centered pagination-small"> 
				 			<ul> 
				 				<c:forEach items="${staticChars}" var="staticChar">
							    	<c:choose>
							    		<c:when test="${fn:contains(enableChars, staticChar)}">
							    			<c:choose>
							    				<c:when test="${staticChar eq activeChar}"><li class="active"><a class="enableLink" style="cursor: pointer;">${staticChar}</a></li></c:when>
							    				<c:otherwise><li class="disabled"><a class="enableLink" style="cursor: pointer;">${staticChar}</a></li></c:otherwise>
							    			</c:choose>
							    		</c:when>
							    		<c:otherwise>
								   			<li class="disabled"><a>${staticChar}</a></li>
								   		</c:otherwise>
							    	</c:choose>
							    </c:forEach>
							    <c:choose>
									<c:when test="${not empty glossaryExts}">	
							    		<li <c:if test='${activeChar eq "ALL"}'>class="active"</c:if>><a class="enableLink" style="cursor: pointer;">ALL</a></li>
							    	</c:when>
							    	<c:otherwise>
							    		<li class="disabled"><a>ALL</a></li>
							    	</c:otherwise>
							    </c:choose>
				 			</ul> 
				 		</div> 
				 	</div> 
				 </form>
				 
				  <!-- Glossary pagination end -->
				 
				 
	            <script>
	            $(".results_table").find("td.parent_id").text();
	            </script>
	            
	            <table class="results_table">
	            	<tr class="results_header_bar">
	                	<td width="100"><strong>Term</strong></td>
	                    <td><strong>Definition</strong></td>
	                    <td width="100" style="padding-right:15px"><strong>Brand</strong></td>
	                    <td width="100"><strong>Region</strong></td> 
						<td width="80">&nbsp;</td>
	                </tr>
	               
	                <c:forEach var="glossaryExt" items="${glossaryExts}">
	                 <tr id="glossary_${glossaryExt.glossaryId}">
	                	<td>${glossaryExt.glossaryTermText}</td>
						<td>${glossaryExt.glossaryTermDesc}</td>
						<td>
							<c:set var="chainCode" value="${fn:split(glossaryExt.glossaryChains, ', ')}"></c:set>
							<c:forEach var="chnCode" items="${chainCode}" varStatus="status">
								<c:choose>
									<c:when test="${(status.count) !=  fn:length(chainCode)}">
										<c:out value="${chnCdMap[chnCode]}"></c:out>,
									</c:when>
									<c:otherwise>
										<c:out value="${chnCdMap[chnCode]}"></c:out>
									</c:otherwise>
								</c:choose> 
							
							</c:forEach> 
						</td>
						<td>${glossaryExt.glossaryRegions}</td>
						<td>
							<a href="/web/brand-standards/glossary-translation?glossaryId=${glossaryExt.glossaryId}&visibleChar=${activeChar}" title="Manage Translations"><img class="log_icon" alt="Manage Translations" src="/BSTheme-theme/images/translate_icon.png"></a>
							<a title="Edit Glossary" href="/web/brand-standards/glossary-wizard?glossaryId=${glossaryExt.glossaryId}&visibleChar=${activeChar}"> <img alt="Edit Glossary" title="Edit Glossary" src="/BSTheme-theme/images/edit_pencil_icon.png"> </a>
							<c:if test="${glossaryExt.activeInd=='N'}">
								<a href="#delete" onclick="deleteGlossary('${glossaryExt.glossaryId}','<%=deleteGlossary%>')" title="Delete Glossary"><img class="log_icon" alt="Delete Glossary" src="/BSTheme-theme/images/delete.png"></a>
							</c:if>
						</td>
	                	</tr>
	                </c:forEach>
	                
				</table>
	        </div>
	        
	        <div class="rounded_container_bottom">&nbsp;</div>
	    </div><!--ends rounded_container -->
	
	
	<div class="clear"></div>
		</c:otherwise>	
	</c:choose>
</c:if>

<c:if test="${!loggedIn}">
	Not logged in !!
</c:if>
<script type="text/javascript">
	jQuery(".enableLink").click(function(){
		var appendChar = jQuery(this).html();
		var url = "<%=changeCharacter%>&visibleChar="+appendChar;
		jQuery("#glossaryForm").attr("action", url);
		jQuery("#glossaryForm").submit();
	});
</script>
