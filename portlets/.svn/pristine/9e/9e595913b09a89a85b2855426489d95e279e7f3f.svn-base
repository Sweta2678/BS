<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@include file="/html/init.jsp"%>
<link rel="stylesheet" type="text/css" href="/BSBridge-theme/css/easyui/themes/gray/easyui.css" />
<link rel="stylesheet" type="text/css" href="/BSBridge-theme/css/easyui/themes/icon.css" />
 <script type="text/javascript" src="/BSBridge-theme/js/jquery-1.11.3.min.js"></script> 
<script type="text/javascript" src="/BSBridge-theme/js/jquery.easyui.min.js"></script>
	<portlet:resourceURL var="deleteDuplicateSTDURL" id="deleteDupicateSTD">
	    <portlet:param name="requestType" value="deleteDupicateSTD" />
	</portlet:resourceURL>
		<%
String searchIds = (String)request.getAttribute("searchIds");
if(searchIds==null){
	searchIds="";
}
%>
<portlet:resourceURL var="getStdRecords" id="getStdRecords">
	    <portlet:param name="requestType" value="getStdRecords" />
	     <portlet:param name="searchIds" value="<%=searchIds %>" />
</portlet:resourceURL>
 <div id="editGrid">
    <div style="margin:10px 0;"></div>
   <table id="dp"  class="easyui-datagrid" style="width:940px;height:auto;"
            data-options="singleSelect:true,collapsible:false,url:'<%=getStdRecords.toString()%>',method:'post',pageSize: 20,
        pageList: [10,20,50,100],pagePosition:'both', toolbar: '#tb',
	 rowStyler: function(index,row){
                     	var background = '';
				         if (row.stdType == 'STD')
				         {
				             return background + 'font-weight: bold;';
				         }
				         else if (row.stdType == 'GDLN')
				         {
				             return background + 'color:#808080;'; /* gray */
				         }
                } "  pagination="true" >
        <thead>
            <tr>
                <th data-options="field:'glblRgn',width:48">Region</th>
                <th data-options="field:'stdId',width:60,align:'right'">STD ID</th>
                <th data-options="field:'mnlType',width:75,formatter:formatMnlType">Manual Type</th>
                <th data-options="field:'stdStatus',width:95,formatter:formatStatus,styler:styleStdStatus">Status</th>
                <th data-options="field:'stdType',width:90,formatter:formatStdType,styler:styleStdType">Type</th>
                <th data-options="field:'title',width:140,formatter:formatTitle">Text</th>
                <th data-options="field:'catgyHead',width:110,formatter:formatCategoryHeading,styler:styleCategoryHeading">Category Heading</th>
                <th data-options="field:'seRptCatgy',width:130,formatter:formatSEReportingCategory,styler:styleSEReportingCategory">SE Reporting Category</th>
                <th data-options="field:'crit',width:90,formatter:formatCrit,styler:styleCrit">Q Criticality</th>
                <th data-options="field:'duplicateInd',width:60,formatter:formatDuplicate">Duplicate</th>
                <th data-options="field:'action',width:40,formatter:formatAction">Action</th>
            </tr>
        </thead>
    </table>
</div>
    <script type="text/javascript">
    jQuery.noConflict(true);
    
    jQuery(document).ready(function() {
   	 jQuery.ajaxSetup({ cache: true });
  	});
    
    	function deleteEntry(qlrptId){
    		var deleteDuplicateSTDURL = '<%=deleteDuplicateSTDURL%>'+'&qlrptId='+qlrptId;
    		jQuery.msgBox({
    		    title: "Are You Sure",
    		    content: '<span class=\"alert alert-danger\">Are you sure you want to Delete this duplicate standard and all it\'s specifications from measurement ?</span>',
    		    type: "confirm",
    		    buttons: [{ value: "Yes" }, { value: "No" }],
    		    success: function (importConfirmation) {
    		        if (importConfirmation == "Yes") {
    		        	jQuery.blockUI({ message: '<h3><img src="/BSBridge-theme/images/busy.gif" /> Please wait...</h3>' });
    		        	setTimeout(function(){ 
    					$.ajax({
    						url: deleteDuplicateSTDURL,
    						type: "POST",
    						dataType: "text",
    						success: function(data) {
    							jQuery.unblockUI();
    							if (data != null && data != '' && typeof data != 'undefined') {
    								if(data == 'Success'){   									
    									jQuery.msgBox({
    			                         	title: "Success!",
    			                            content: "Duplicate standard deleted successfully." ,
    			                            type: "info",
    			                            buttons: [{ value: "OK" }],
    			                            success: function (result) {
    			                            	var searchIds = jQuery.trim($('#<portlet:namespace/>findId').val()); 
    			                            	reloadDuplicateListing(searchIds);
    											return;
    			                           	}
    									});
    								} else {
    									jQuery.msgBox({
    										title: "Errors!",
    			                            content: "Duplicate STD can not be deleted." ,
    			                            type: "info",
    			                            success: function (result) {
    			                       			return;
    			                        	}
    									});
    								}
    							}
    							
    						}
    					});
    		        	}, 2000);
    		        } else if(importConfirmation == "No" || importConfirmation == "Cancel") {
    					return;
    				}
    		    }
    		});
        	
    	
    	}
	    function formatDuplicate(val,row){
	    	if (val == 'Y') {
	            return 'YES';                
	        } else{
	            return 'NO';                
	        } 
	    }
	    function formatAction(val,row){
	    	if (row.duplicateInd == 'Y' && row.stdType =='STD') {
	            return '<a href=\"javascript:deleteEntry('+row.id+');\"title=\"Delete\" class=\"easyui-tooltip delete \">X</a>';                
	        } else{
	            return ' ';                
	        } 
	    }
        function formatMnlType(val,row){
        	if (row.mnlType == '258') {
                return 'Operate';                
            } else if (row.mnlType == '257') {
                return 'Build';                
            } else if (row.mnlType == '257, 258' || row.mnlType == '258, 257') {
                return 'Build & Operate';                
            }
        }
        
        function formatStatus(val,row){
        	if (row.stdStatus == 'D_FOR_REF' || row.stdStatus == 'D_NOT_RQ' || row.stdStatus == 'D_RPLCD' || row.stdStatus == 'INST_RQ')
            {
                return 'Discontinued';                
            }
            else if (row.inPublication == 0)
            {
                return 'NOT Published'; 
            } 
            else if (row.catgyHead > 0 && row.crit > 0 && row.seRptCatgy > 0) 
            {
            	if (row.glblMust == 'N')
            	{
            		return 'Measured';
            	}
            	else
            	{
            		return 'Measured Global Must';
            	}
            }
            else if (row.glblMust == 'Y' && row.catgyHead > 0 && (row.crit == 0 || row.seRptCatgy == 0)) 
            {
            	return 'Global Must';
            }
        }
        
        function formatStdType(val,row){
            if (val == 'STD')
            {
                return 'Standard';
            }
            else if (val == 'SPEC')
            {
                return 'Specification';
            }
            else if (val == 'GDLN')
            {
                return 'Guideline';
            }
        }
        function formatTitle(val,row){
        	return '<span title=\"' + val + '\" class=\"easyui-tooltip\">' + val + '</span>';
        }
        function formatCategoryHeading(val,row){
        	 return row.catgyHeadNm;
        }
        function formatSEReportingCategory(val,row){
        	 return row.seRptCatgyNm;
        }
        function formatCrit(val,row){
        	 return row.critNm;
        }
        
        function styleCrit(val,row){
        	  if (val == '0' && row.stdType != 'GDLN')
              {
                  return 'background-color:#FFB2CC;'; 
              }
              else
              {
                  return 'background-color:inherit;';
              }
        }
        function styleSEReportingCategory(val,row){
        	 if (row.stdType == 'SPEC')
             {
                 return 'background-color:#EBEBEB;'; 
             }
         	else if (val == '0' && row.stdType != 'GDLN')
             {
                 return 'background-color:#FFB2CC;'; 
             }
             else
             {
                 return 'background-color:inherit;';
             }
        }
        function  styleCategoryHeading(val,row){
        	 if (row.stdType == 'SPEC')
             {
                 return 'background-color:#EBEBEB;'; 
             }
             else if (val == '0' && row.stdType != 'GDLN')
             {
                 return 'background-color:#FFB2CC;'; 
             }
				else
             {
                 return 'background-color:inherit;';
             }
        }
        function styleStdType(val,row){
        	  if (val == 'STD')
              {
                  return 'color:#FF0000;'; /* red */
              }
              else if (val == 'SPEC')
              {
                  return 'color:#00008B;';  /* blue */
              }
        }
        function styleStdStatus(val,row){
        	  if (row.stdStatus == 'D_FOR_REF' || row.stdStatus == 'D_NOT_RQ' || row.stdStatus == 'D_RPLCD' || row.stdStatus == 'INST_RQ' || row.inPublication == 0)
              {
                  return 'background-color:#FF0000;'; /* red */
              }
              else if (row.catgyHead > 0 && row.crit > 0 && row.seRptCatgy > 0) 
              {
                  return 'color:#009933;';  /* green */
              }
        }	

    </script> 
    
    
   