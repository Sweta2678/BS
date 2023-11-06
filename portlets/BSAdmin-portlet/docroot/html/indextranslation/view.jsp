<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"> 

<%@include file="/html/indextranslation/init.jsp" %>
<%@page import="javax.portlet.*"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.ihg.brandstandards.custom.model.Preferences"%>
<%@page import="com.liferay.util.PwdGenerator"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@page import="com.ihg.brandstandards.util.BrandStandardsUtil"%>

<portlet:resourceURL var="jqGridResourceURL"></portlet:resourceURL>

<link rel="stylesheet" type="text/css" media="screen" href="/BSTheme-theme/css/jqgrid/themes/redmond/jquery-ui-custom.css" />
<link rel="stylesheet" type="text/css" media="screen" href="/BSTheme-theme/css/jqgrid/themes/ui.jqgrid.css" />
<link rel="stylesheet" type="text/css" media="screen" href="/BSTheme-theme/css/jqgrid/themes/ui.multiselect.css" />

<script src="/BSTheme-theme/js/jqGrid/jquery.js" type="text/javascript"></script>
<script src="/BSTheme-theme/js/jqGrid/jquery-ui-custom.min.js" type="text/javascript"></script>
<script src="/BSTheme-theme/js/jqGrid/jquery.layout.js" type="text/javascript"></script>
<script src="/BSTheme-theme/js/jqGrid/i18n/grid.locale-en.js" type="text/javascript"></script>

<script type="text/javascript">
jQuery.jgrid.no_legacy_api = true;
jQuery.jgrid.useJSON = true;
</script>

<script src="/BSTheme-theme/js/jqGrid/ui.multiselect.js" type="text/javascript"></script>
<script src="/BSTheme-theme/js/jqGrid/jquery.jqGrid.js" type="text/javascript"></script>
<script src="/BSTheme-theme/js/jqGrid/jquery.tablednd.1.0.3.js" type="text/javascript"></script>
<script src="/BSTheme-theme/js/jqGrid/jquery.contextmenu.js" type="text/javascript"></script>
 <script type="text/javascript" src="/BSTheme-theme/js/treeAdmin/jquery.msgBox.js"></script>
<link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/msgBoxLight.css"/>

<style>
td.errorCol { color: #ff0000; font-weight:bold !important; }
.index_icon {width:30px;height:22px}
</style>

<%

long userId = PortalUtil.getUserId(renderRequest);
if (userId > 1)
{
	
Preferences preferences = (Preferences)session.getAttribute("Preferences");

String chainCode = "";
if(preferences!=null)
{
     chainCode = preferences.getBrand(); 
} 

Map<String, String> chnCdMap = BrandStandardsUtil.chainCodeMap();

%>

<portlet:resourceURL var="editTranslationUrl" id="editTranslation">
</portlet:resourceURL>

<div class="grid_9">
<div class="rounded_container">
<div class="rounded_container_contents">
 <!-- <div class="results_right_util result_utils"> -->
                        <div class="button filter_results_button" style="display:block; float:right;"><a href="javascript:void(0)" id="export_report" class="results_filter" title="Export Report">Export Report</a><span></span></div>
            <div class="button filter_results_button" style="display:block; float:right;"><a href="javascript:void(0)" onClick="javascript: showImportPopup();"  class="results_filter" title="Import Translations">Import Translations</a><span></span></div>
             <br/>
             <div  class="filter_results_button" style="float:right;margin-top:10px;text-align:right;width:100%">
             <label class="wrapper_label" for="standard_author" title="Brand">Brand
			 
			 <select id="brandList" name="brandList" title="Brand Dropdown"> 
                 <option value="GL">Select Brand</option>
             <%
             for(String chncode : chnCdMap.keySet()) 
             {
             %>
                <option value="<%=chncode%>"><%=chnCdMap.get(chncode)%></option>
             <%
             }
             %>
			 </select>
			  Translate
              <% Map<String, String>localeMap = null;
				 localeMap= IndexTranslationUtil.localeMap(); %>	
               
                <select id="localeList"  name="localeList"  title="Language Dropdown">  <!-- onchange="showIndexTrans(this)" -->
                     <%	for(String localeCd :localeMap.keySet())
					 	{	if(localeCd.equalsIgnoreCase(IndexTranslationUtil.DEFAULT_LOCALE)){%>
							<option value='<%=localeCd%>'><%=localeMap.get(localeCd)%></option>
					<% }else{%> 
					        <option value='<%=localeCd%>'>From English To <%=localeMap.get(localeCd)%></option>
			         <% } }   %> 
    	        </select>
   		        ID:
		        <input type="text" id="idSearch"  name="idSearch"  title="Search Box"/>
                <button id="searchById"  name="search" value="Search" title="Search">Search</button>
                <button id="reset"  name="reset" value="Reset"  title="Reset">Reset</button>
		       
		       </label>
		      
             </div>  
          <div class="clear"></div>
           
          <div class="divider"> </div>
           <div class="clear"></div>
<!-- Grid Start -->
<table id="indexGrid"></table>
<div id="indexPager"></div>
<table id="navgrid"></table>
<div id="pagernav"></div>
<!-- Grid End -->
</div>
</div>
</div>

<script>
var ColNEn, ColMEn, ColNLan, ColMLan, nwval, newval, id, chainCd;
ColNEn=['ID', 'Index Heading','', 'Description','Image'];
ColMEn=[
	    {name:'id',index:'id', width:60, sorttype:"int",align:"center"},
	    {name:'title',index:'title', width:380,search:false,title:false},
	    {name:'indexpath',index:'indexpath', hidden:true},
	    {name:'description',index:'description', width:380, align:"left",editable:false,sortable:false,search:false},
	    {name: "image", width:50, sortable:false,align:"center",editable:false,search:false,
	    	   formatter: function (cellvalue, options, rowObject) {
	    		   return "<img onClick=\"javascript: showImage('"+cellvalue+"');\" class='index_icon' src='"+cellvalue+"' alt='Image' />";
	    	   }}
	    ];
	    

ColNLan=['ID', 'Index Heading','', 'Translation','','',''];
ColMLan=[
	    {name:'id',index:'id', width:60, sorttype:"int",align:"center"},
	    {name:'title',index:'title', width:360,search:false,title:false},
	    {name:'indexpath',index:'indexpath', hidden:true},
	    {name:'translation',index:'translation', width:360, align:"left",editable:true,sortable:false,search:false,editoptions:{size:38}},
	    {name:'localecd',index:'localecd', hidden:true,editable:true},
	    {name: "image", width:50, sortable:false,align:"center",editable:false,search:false,
	    	   formatter: function (cellvalue, options, rowObject) {
	    	       return "<a onClick='javascript: showImagePopup("+jQuery.jgrid.stripHtml(cellvalue)+");' class='link' title='Image To Translate'><img src='/BSTheme-theme/images/camera_icon.jpg' alt='Image Translation' /></a>";
	    	   }},
	    {name: 'myac', width:50, fixed:true, sortable:false, resize:false, editable:false,search:false,formatter:'actions', 
	    		   formatoptions:{keys:true,
	    	/* extraparam: {localeCd: 'fr_FR'}, */
	     	onEdit:function(rowid) {
	    		   
	        },
	        onSuccess:function(jqXHR) {
	            var jsonResponse = jQuery.parseJSON(jqXHR.responseText);
	           /*  alert("jsonResponse.State"+jsonResponse.response); */
	             if (jsonResponse.response != 'Success') {
	            	alert("Some error occurred.Please try later!");
	            	return false;
	            } else {
	            	alert("Translation updated Successfully!");
	                return true;
	            }      
	        },
	        onError:function(rowid, jqXHR, textStatus) {
	        },
	        afterSave:function(rowid) {
	        },
	        afterRestore:function(rowid) {
	        },
	    	delbutton:false}}
	    ];  
	    
jQuery(document).ready(function () { 	
	 
	jQuery("select#localeList").val("en_GB");
	
	chainCd = '<%=chainCode%>';
	jQuery.trim(chainCd);
	//console.log("chainCd: "+chainCd);
    jQuery("select#brandList").val(chainCd);
	
   jQuery("#localeList").change(function() {	
        nwval = jQuery(this).val();
       if(nwval=='<%=IndexTranslationUtil.DEFAULT_LOCALE%>')
    	   {
    	     defaultLoad();
    	   }
       else
    	   {
	    	   jQuery("#indexGrid").jqGrid('GridUnload');
	           
			   	jQuery("#indexGrid").jqGrid({
					url:'<%=jqGridResourceURL.toString()%>',
					postData:{localeCd:nwval, chainCd:newval},
					datatype: "json",
					mtype: 'POST',
					    colNames:ColNLan,
					    colModel:ColMLan,
					    rowNum:20,
					    rowList:[10,20,50,100],
					    pager: '#indexPager',
					    sortname: 'id',
					    viewrecords: true,
					    sortorder: "asc",
					    width: 910,
					    height: "100%",
					    loadonce: true,
					    editurl:'<%=editTranslationUrl.toString()%>',
					    loadComplete: function() {
					    	var ids = jQuery("#indexGrid").jqGrid('getDataIDs');
					        for (var i=0;i<ids.length;i++) {
					            var id=ids[i];
					            var rowData = jQuery("#indexGrid").jqGrid('getRowData',id);
					            jQuery('#'+id,jQuery("#indexGrid")[0]).attr('title', rowData.indexpath);
					        }
					    }
					  
					});
    	   }
    });
   
    jQuery("#brandList").change(function() {
	   newval = jQuery(this).val();
	   nwval =  jQuery("#localeList").val();
	   
	   if(nwval=='<%=IndexTranslationUtil.DEFAULT_LOCALE%>')
	   {
	     defaultLoad();
	   }
   	   else
	   {
    	   jQuery("#indexGrid").jqGrid('GridUnload');
           
		   	jQuery("#indexGrid").jqGrid({
				url:'<%=jqGridResourceURL.toString()%>',
				postData:{localeCd:nwval, chainCd:newval},
				datatype: "json",
				mtype: 'POST',
				    colNames:ColNLan,
				    colModel:ColMLan,
				    rowNum:20,
				    rowList:[10,20,50,100],
				    pager: '#indexPager',
				    sortname: 'id',
				    viewrecords: true,
				    sortorder: "asc",
				    width: 910,
				    height: "100%",
				    loadonce: true,
				    editurl:'<%=editTranslationUrl.toString()%>',
				    loadComplete: function() {
				    	var ids = jQuery("#indexGrid").jqGrid('getDataIDs');
				        for (var i=0;i<ids.length;i++) {
				            var id=ids[i];
				            var rowData = jQuery("#indexGrid").jqGrid('getRowData',id);
				            jQuery('#'+id,jQuery("#indexGrid")[0]).attr('title', rowData.indexpath);
				        }
				    }
				  
				});
	   }
   }); 
   
window.defaultLoad = function(){  
	    jQuery("#indexGrid").jqGrid('GridUnload');
      	jQuery("#indexGrid").jqGrid({
			url:'<%=jqGridResourceURL.toString()%>',
			postData:{localeCd:nwval, chainCd:newval},
			datatype: "json",
			mtype: 'POST',
			    colNames:ColNEn,
			    colModel:ColMEn,
			    rowNum:20,
			    rowList:[10,20,50,100],
			    pager: '#indexPager',
			    sortname: 'id',
			    viewrecords: true,
			    sortorder: "asc",
			    width: 910,
			    height: "100%",
			    loadonce: true,
			    editurl:'<%=editTranslationUrl.toString()%>',
			    loadComplete: function() {
			        var ids = jQuery("#indexGrid").jqGrid('getDataIDs');
			        for (var i=0;i<ids.length;i++) {
			            var id=ids[i];
			            var rowData = jQuery("#indexGrid").jqGrid('getRowData',id);
			            jQuery('#'+id,jQuery("#indexGrid")[0]).attr('title', rowData.indexpath);
			        }
			    }
			});
	  }  
});


jQuery("#reset").click(function(){
	var grid=jQuery("#indexGrid");
	grid.jqGrid('setGridParam',{search:false});
	var postData=grid.jqGrid('getGridParam','postData');
	jQuery.extend(postData,{searchFied:"",searchString:"",searchOper:""});
	grid.trigger("reloadGrid",[{page:1}]);
	jQuery("input#idSearch").val("");
});

jQuery("#searchById").click(function()
{
	nwval =  jQuery("#localeList").val();
	newval = document.getElementById("brandList").value;
	var val=jQuery("input#idSearch").val();
	var grid=jQuery("#indexGrid");
	grid.jqGrid('setGridParam',{search:true});
	var postData=grid.jqGrid('getGridParam','postData');
	jQuery.extend(postData,{searchField:"id",searchString:val,searchOper:"eq"});
	grid.trigger("reloadGrid",[{page:1}]);
});

function showImage(imgUrl)
{
 AUI().ready('liferay-util-window', function(A) {
    var html="<div><img src='"+imgUrl+"' alt='Image'/></div>";
    var dialog2 = Liferay.Util.Window.getWindow(
     {
         header: 'display image',
         title: 'Index Image',
         bodyContent:html,
         centered: true,
         draggable: true,
         resizable: true,
         width: 400,
         height: 400,
         modal: true,
         toolbars: {
             footer:buttons = [{
                    label: 'Close',
                    render:true,
                    on: {
                        click: function() {
                            dialog2.hide();
                        }
                    }
                }]
         }
     }
    ).render();
    dialog2.titleNode.html(imgPopupTitle);
  }); 
}


	 
AUI().use('liferay-portlet-url','event','event-custom', function(A) {
  var urlExcelExport=null;
  var nodeObject = A.one('#export_report');
  if(nodeObject)
  {
      nodeObject.on('click', function(event){
      var selectedBrandValue = jQuery("#brandList option:selected").text();
      var selectedBrand = jQuery("#brandList").val();
      var selectedLocaleValue = jQuery("#localeList option:selected").text();
      var selectedLocale = jQuery("#localeList").val();
      urlExcelExport=Liferay.PortletURL.createResourceURL();
      urlExcelExport.setPortletId('IndexTranslation_WAR_BSAdminportlet');
      urlExcelExport.setResourceId('excelExport'); 
      urlExcelExport.setParameter('SELECTED_LOCALE',selectedLocale);
      urlExcelExport.setParameter('SELECTED_BRAND',selectedBrand)
	  jQuery.msgBox({
	     title: "Are You Sure",
	     content: "You want to do an export in "+selectedLocaleValue.replace('From English To','')+"?",
	     type: "confirm",
	     buttons: [{ value: "Yes" }, { value: "No" }],
	     success: function (result) {
	     if (result == "Yes") {
	       	location.href = urlExcelExport;
	        }
	     if(result == "No" || result == "Cancel")
	        {
	         return false;
	        }
	     }	
 	    }); 
	 });
  }
});
	
	 

</script>

<portlet:resourceURL var="uploadExcelUrl" id="uploadValidateExcel">
</portlet:resourceURL>

<portlet:resourceURL var="uploadTranslationImageUrl" id="uploadTranslationImage">
</portlet:resourceURL>

<portlet:resourceURL var="downloadErrorExcelUrl" id="downloadErrorExcel">
</portlet:resourceURL>

<portlet:resourceURL var="urlAddImage" id="imagePopup">
</portlet:resourceURL>
 
<portlet:resourceURL var="urlImport" id="importXlsPopup">
</portlet:resourceURL>

 <%-- 
 <portlet:renderURL var="urlAddImage" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
    <portlet:param name="COMMAND" value="<%=IndexTranslationUtil.CMD_UPLOAD_IMAGE_PAGE%>"/>
</portlet:renderURL>
 
<portlet:renderURL var="urlImport" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
    <portlet:param name="COMMAND" value="<%=IndexTranslationUtil.CMD_UPLOAD_EXCEL_PAGE%>"/>
</portlet:renderURL>
 --%> 

<%
  String importProgressIdImg = PwdGenerator.getPassword(PwdGenerator.KEY3, 4);
  String importProgressIdExl = PwdGenerator.getPassword(PwdGenerator.KEY3, 4);
%>

<style>

.uiPopup {
    height: auto !important;
    width: auto !important;
    top: 25% !important; 
    left: 60% !important; 
}

.uiPopup-content .modal-body {
    height: auto !important;
    width: auto !important;
}

.uiImportPopup {
    height: auto !important;
    width: auto !important;
    top: 25% !important; 
    left: 40% !important; 
}

.uiImportPopup-content .modal-body {
    height: auto !important;
    width: auto !important;
}

</style>

<script type="text/javascript">



function showImagePopup(taxId) {
	 var selectedLocale = jQuery("#localeList").val();
	// alert(selectedLocale); 
	// alert(taxId);
	 jQuery("#errors").css('display','none');
	 AUI().use('aui-dialog', 'aui-base', 'aui-io-plugin-deprecated', 'aui-io-request', 'liferay-util-window', 'event', 'event-custom', 'io-form' ,function(A) {
	 var importIdVarImg='';
     var urlAddImage = '${urlAddImage}';
     urlAddImage += "&TAXONOMY_ID=" + taxId + "&SELECTED_LOCALE=" + selectedLocale + "&IMPORT_ID_IMAGE=<%=importProgressIdImg%>" + taxId;

     //alert("=====>>>>"+urlAddImage);
	 
     var title = 'Image Translation';
	 importIdVarImg='<%=importProgressIdImg%>'+taxId;
	 
	    var dialog = Liferay.Util.Window.getWindow({
	        dialog:{
			    on: { close: function() {  } },  
                cssClass: 'uiPopup',
	            title: title,
	            centered: true,
	            draggable: false,
	            resizable: false,
	            top: 250,
                left: 200,
	            xy:[250,200],
	            modal: true,
	            toolbars: {
                    footer:buttons = [
                    {
                      label: 'Import',
                      render:true,
                      id: 'importImage',
                      on: {
                          click: function() {	                	
                            var fileField = A.one('#<portlet:namespace />file');
                            if (fileField.val()=="") {
                            	jQuery.msgBox({
                            	    title:"No image selected.",
                            	    content:"Please choose image again!",
                            	    type:"info",
                            	    }); 
                            	return;
                            }
                            eval(importIdVarImg).startProgress(); 
	                	
	                	    var cfg = {
	                            method: 'POST',
	                            enctype: 'multipart/form-data',
	                       
	                            form: {
		                            id: '<portlet:namespace/>fmImageUpload',
		                            upload: true
	                            },
	                            on: {
	                        	  complete: function(id,o,args) {
	                                if(o && o.responseText)
	                            	{
	                            	  response=A.JSON.parse(o.responseText);
	                            	  if(response.response == 'Failure')
	                            	  {
	                            		  setTimeout(function () {
	                            			  eval(importIdVarImg).hide();
	                            		  jQuery.msgBox({
	                          	    	    title: "Please try again!",
	                          	    	    content: response.response+": "+response.message,
	                          	    	    type:"info",
	                          	    	    }); 
	                            		   fileField.val('');
	                              		  }, 2000);
	                            	  }
	                            	  if(response.response == 'Success')
                                	  {
                                  	   jQuery("#indexTranslationImage").attr("src", response.imageUrl + '?dummy=' +  + new Date().getTime());
	                                  	 setTimeout(function () {
	                                  		jQuery.msgBox({
		                                         title: "Success!",
		                                         content: "Image uploaded successfully." ,
		                                         type: "info",
		                                         success: function (result) {
		                                        	 eval(importIdVarImg).hide(); 
		                                             return;
		                                         }
		                                     });
	                                     },
	                                     2000);
	                                  	 
	                                  }
	                            	}
	                            }
	                        }
	                    };
	                    var request = A.io('<%=uploadTranslationImageUrl.toString()%>', cfg);
	                   }
                      }},
                      {
                        label: 'Cancel',
                        render:true,
                        on: {
                            click: function() {
                                dialog.hide();
                           }
                        }
                   }]
                 }
	        }
	        }).plug(A.Plugin.IO, {autoLoad:true, uri: urlAddImage.toString()}).render();
	        dialog.show();
	        dialog.titleNode.html(title);
	  });
	}


function showImportPopup() {

  var selectedLocale = jQuery("#localeList").val();
  var importIdVarExl='';
  jQuery("#errors").css('display','none');
  AUI().use('aui-dialog', 'aui-base', 'aui-io-plugin-deprecated', 'aui-io-request', 'liferay-util-window', 'event', 'event-custom', 'io-form' ,function(A) {
 
    var urlImportXls = '${urlImport}';
    urlImportXls += "&SELECTED_LOCALE=" + selectedLocale + "&IMPORT_ID_EXCEL=<%=importProgressIdExl%>" + selectedLocale;
    importIdVarExl='<%=importProgressIdExl%>'+selectedLocale;

     var title = 'Import Translation';
     var dialog = Liferay.Util.Window.getWindow({
         dialog:{
		    on: { close: function() {  } },  
            cssClass: 'uiImportPopup',
            title: title,
            centered: false,
            draggable: false,
            resizable: false,
            top: 250,
            left: 200,
            xy:[250,200],
            modal: true,
            toolbars: {
                footer:buttons = [
                    {
                    label: 'Import',
                    render:true,
                    id: 'importSave',
                    on: {
                        click: function() {

                	var fileField = A.one('#<portlet:namespace />file');
                	if (fileField.val()=="") {
                		jQuery.msgBox({
            	    	    title:"No file selected.",
            	    	    content:"Please choose file again!",
            	    	    type:"info",
            	    	    }); 
                		return;
                	}
                	
                	eval(importIdVarExl).startProgress(); 
                    var cfg = {
                        method: 'POST',
                        enctype: 'multipart/form-data',
                       
                        form: {
                            id: '<portlet:namespace/>excelfm',
                            upload: true
                            },
                        on: {
                              complete: function(id,o,args) {
                                  if(o && o.responseText)
                            	  {
                            	      response=A.JSON.parse(o.responseText);
                                	  if(response.response == 'Failure')
                                	  { 
                                		  setTimeout(function () {
                                			  eval(importIdVarExl).hide();
                                		  jQuery.msgBox({
                              	    	    title: "Please try again!",
                              	    	    content: response.response+": "+response.message,
                              	    	    type:"info",
                              	    	    }); 
                                		   fileField.val('');
                                  		  }, 2000);
                                	  }
                                	  else
                                	  {
                                		  if(response.response == 'Success')
                                    	  {
                  	      	                  setTimeout(function () {
                  	      	            	  jQuery("#errors").slideUp("slow", function () {});
                  	      	            	  
                  	      	            	  jQuery.msgBox({
     	                                         title: "Success!",
     	                                         content: "Record Inserted Successfully." ,
     	                                         type: "info",
     	                                         success: function (result) {
     	                                        	 eval(importIdVarExl).hide();
     	                  	      	            	  dialog.hide();
     	                  	      	            	  reloadGrid(response.locale);
     	                                             return;
     	                                         }
     	                                     });
                  	      	                }, 2000);
                                	  }
                            		  else
                            		  {
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
                                    	      width: 850,
                                    	      height: "50%",
                                    	      excel: true,
                                    	      loadonce: true,
                                    	  }).jqGrid('navGrid', '#indexExcelPager', {
                                    	        add: false,
                                    	        edit: false,
                                    	        del: false,
                                    	        search: false,
                                    	        refresh: false
                                    	    }).jqGrid('navButtonAdd','#indexExcelPager',{ 
                                    	    	caption: " Export to Excel ",
                                    	        buttonicon: "ui-icon-newwin",
                                    	        onClickButton: function(){exportErrorReport();},
                                    	        position: "last", title:"", cursor: "pointer"
                                    	    });
                            		  
	                            		  setTimeout(function () {
	                                     		jQuery.msgBox({
	      	                                         title: "Errors!",
	      	                                         content: "Excel contains errors in records." ,
	      	                                         type: "info",
	      	                                         success: function (result) {
	      	                                        	  eval(importIdVarExl).hide();
	      	                                             return;
	      	                                         }
	      	                                     });
	                                        },
	                                        2000);
                            		   }
                              	    }//end else
                            	  }
                        		//dialog.close();
                             }
                         }
                    };
                    var request = A.io('<%=uploadExcelUrl.toString()%>', cfg);
                   }
                    }
                },
                {
                    label: 'Cancel',
                    on: {
                        click: function() {
                            dialog.hide();
                        }
                    }
          }]
        }
        }}).plug(A.Plugin.IO, {autoLoad:true, uri: urlImportXls.toString()}).render();
        dialog.show();
        dialog.titleNode.html(title);
  });
}


function exportErrorReport(){
//	alert("exportErrorReport");
	
	var cols=5;
	var file='xls';
    var columns = cols.toString().split(",");
    var columnNms = jQuery("#indexExcelGrid").jqGrid('getGridParam','colNames');
    var theads = "";
    for(var cc=0;cc<columnNms.length;cc++){
        var isAdd = true;
        for(var p=0;p<columns.length;p++){
            if(cc==columns[p]){
                isAdd = false;
                break;
            }
        }
        if(isAdd){
            theads = theads +"<th>"+columnNms[cc]+"</th>"
        }
    }
    theads = "<tr>"+theads+"</tr>";
    var mya=[];//new Array();
    var idToDataIndex=jQuery("#indexExcelGrid").jqGrid('getGridParam','_index');
    for(id in idToDataIndex)
    	{
    	if(idToDataIndex.hasOwnProperty(id))
    		{
    		//alert("id===="+id);
    		mya.push(id);
    		}
    	}
  // alert("mya===>>>"+mya);
 //   mya=jQuery("#indexExcelGrid").jqGrid('getDataIDs');  // Get All IDs
   // alert("mya.length===>>>"+mya.length);
    var data=jQuery("#indexExcelGrid").jqGrid('getRowData',mya[0]);     // Get First row to get the labels
   // alert(data);
    var colNames=new Array();
    var ii=0;
    for (var i in data){
        colNames[ii++]=i;
    }

    var pageHead = "XLS Errors Report";
    var html="<html><head><style script='css/text'>table.tableList_1 th {border:1px solid #a8da7f; border-bottom:2px solid #a8da7f; text-align:center; vertical-align: middle; padding:5px; background:#e4fad0;}table.tableList_1 td {border:1px solid #a8da7f; text-align: left; vertical-align: top; padding:5px;}</style></head><body><div class='pageHead_1'>"+pageHead+"</div><table border='"+(file=='pdf'? '0' : '1')+"' class='tableList_1 t_space' cellspacing='10' cellpadding='0'>"+theads;
    //alert('len'+mya.length);
     data=jQuery("#indexExcelGrid").jqGrid('getGridParam','data');
    for(i=0;i<mya.length;i++)
    {
        html=html+"<tr>";
        html=html+"<td>"+data[i].id+"</td>";
        html=html+"<td>"+data[i].row+"</td>";
        html=html+"<td>"+data[i].columnname+"</td>";
        html=html+"<td>"+data[i].value+"</td>";
        html=html+"<td>"+data[i].errormessage+"</td>";// output each column as tab delimited
          //  }
        //}
        html=html+"</tr>";  // output each row with end of line

    }
    html=html+"</table></body></html>";  // end of line at the end
  //  alert(html);
    document.formstyle.excelBuffer.value=html;
    document.formstyle.fileType.value=file;
    document.formstyle.method='POST';
    document.formstyle.action='<%=downloadErrorExcelUrl%>';  // send it to server which will open this contents in excel file
    document.formstyle.submit();
}

function reloadGrid(selLocale, selBrand)
{	
	 $("#localeList").val(selLocale);
	 $("#brandList").val(selBrand);
	
	 jQuery("#indexGrid").jqGrid('GridUnload');
     
	   	jQuery("#indexGrid").jqGrid({
			url:'<%=jqGridResourceURL.toString()%>',
			postData:{localeCd:selLocale, chainCd:selBrand},
			datatype: "json",
			mtype: 'POST',
			    colNames:ColNLan,
			    colModel:ColMLan,
			    rowNum:20,
			    rowList:[10,20,50,100],
			    pager: '#indexPager',
			    sortname: 'id',
			    viewrecords: true,
			    sortorder: "asc",
			    width: 910,
			    height: "100%",
			    loadonce: true,
			    editurl:'<%=editTranslationUrl.toString()%>',
			    loadComplete: function() {
			    	var ids = jQuery("#indexGrid").jqGrid('getDataIDs');
			        for (var i=0;i<ids.length;i++) {
			            var id=ids[i];
			            var rowData = jQuery("#indexGrid").jqGrid('getRowData',id);
			            jQuery('#'+id,jQuery("#indexGrid")[0]).attr('title', rowData.indexpath);
			        }
			    }
			  
			});
	
}




$(window).load(function() {
 //   alert("window load occurred!");
    defaultLoad();
});

</script>

 <form id="formstyle" action="" method="post" name="formstyle">
     <input type="hidden" name="excelBuffer" id="excelBuffer" value="" />
     <input type="hidden" name="fileName" id="fileName" value="ExcelErrors" />
     <input type="hidden" name="fileType" id="fileType" value="" />
 </form>
 
 
<%
	} else {
%>
	Not logged in !!
<%
	}
%>


