<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.util.DLUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ihg.brandstandards.util.CMSStandardsListUtil"%>
<%@page import="com.ihg.brandstandards.util.BrandStandardsUtil"%>
<%@include file="/html/init.jsp" %>
<%@page import="com.liferay.portal.model.Image"%>
<%@page import="com.ihg.brandstandards.db.service.StandardsImagesLocalServiceUtil"%>
<%@page import="com.ihg.brandstandards.db.model.StandardsImages"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFileEntry"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.ImageLocalServiceUtil"%>
<%@page import="com.liferay.portal.webserver.WebServerServletTokenUtil"%>
<%@page import="com.ihg.brandstandards.db.model.StandardsChainImages"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.ihg.brandstandards.db.model.PublishExtStd"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletURL"%>


<%
	DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
	String tabs1 = (String)request.getAttribute("tabs1");
	String tabNames = (String)request.getAttribute("tabNames");
	String tabValues = (String)request.getAttribute("tabValues");
	String filterOn = (String)request.getAttribute("filterOn");
	String isNonMatch = (String)request.getAttribute("isNonMatch");
	String fromDate = (String)request.getAttribute("fromDate");
	String toDate = (String)request.getAttribute("toDate");
	String stdString = (String)request.getAttribute("stdString");
	PortletURL portletURL = renderResponse.createRenderURL();
	portletURL.setWindowState(WindowState.NORMAL);
	portletURL.setParameter("tabs1", tabs1);
	portletURL.setParameter("caloption", filterOn);
	portletURL.setParameter("between", fromDate);
	portletURL.setParameter("and", toDate);
	portletURL.setParameter("Search", stdString);
	boolean hasFilter = false;
	
	String editUrlParam = "&caloption="+filterOn+"&between="+fromDate+"&and="+toDate+"&Search="+stdString+"&isNotMatch="+isNonMatch;
	
	SearchContainer<PublishExtStd> searchContainerObj = (SearchContainer<PublishExtStd>) request.getAttribute("searchContainerObj");
	
	if((stdString!= null && !(stdString.isEmpty())) || (filterOn!= null && !(filterOn.isEmpty())) || (fromDate!= null && !(fromDate.isEmpty())) || (toDate!= null && !(toDate.isEmpty())))
	{
			hasFilter = true;
	}
%>
<portlet:resourceURL var="stdListUrl" id="getSpecifications">
	<portlet:param name="tabs1" value="<%=tabs1%>"></portlet:param>
</portlet:resourceURL>


<portlet:resourceURL var="removeNonMatchVal" id="removeNonMatchValue"></portlet:resourceURL>
<portlet:actionURL name="fetchFilterResults" var="filterResults">
	<portlet:param name="tabs1" value="<%=tabs1%>"></portlet:param>
</portlet:actionURL>

<portlet:resourceURL var="excelComplianceImport" id="excelComplianceImport"></portlet:resourceURL>

<link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/other/jquery-ui-1.10.1/themes/base/jquery.ui.all.css"/>
<link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/bsstyle.css" />
<link rel="stylesheet" href="/BSTheme-theme/css/other/jquery-ui-1.10.1/themes/base/jquery-ui.css" />
<link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/msgBoxLight.css"/>

<script type="text/javascript" src="/BSTheme-theme/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/jquery-ui-1.10.1.custom.min.js"></script>
<script src="/BSTheme-theme/js/jquery.validate.js"></script>
<script src="/BSTheme-theme/js/additional-methods.1.11.1.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/ajaxfileupload.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/jquery.nyroModal.custom.min.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/treeAdmin/jquery.msgBox.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/treeAdmin/jquery.blockUI.js"></script>

<script type="text/javascript">
<% 	if(!filterOn.equals(StringPool.BLANK)) { %>
    	var filterSet = true;
<% 	} else { %>
   		var filterSet = false;
<%	} %>
/*Check if is not match true on load page after filter apply.*/
<% 	if(isNonMatch.equals("true") && !isNonMatch.equals(StringPool.BLANK)) { %>
 		var isNotMatch	= true;
<% 	} else { %>
		var isNotMatch	= false;
<%	} %>
jQuery(function(){
	jQuery('.nyroModal').nyroModal();
	
	if (jQuery('input[name=caloption]:checked').length > 0) {
		jQuery('#non-matching-spec').removeAttr("disabled");
	}
	if (jQuery('#betweenRadio:radio').is(':checked')) {
		jQuery(".from_to_dates").css('display','inline-flex');
	}
	/*when between radio button click, it will show up date range options*/

	jQuery('#betweenRadio:radio').click(
	    function(e){
	        if (jQuery(this).is(':checked')){
	        	jQuery(".from_to_dates").css('display','inline-flex');
	        	
	        }
	    });
    
	if (isNotMatch)
    {
    	getAllNonMatchingSpecs();	
    	/*jQuery("table.results_table tr.hidden_sub_results ").css('display','table-row');*/
    }
	
	/*when week, month, quarter radio button click, it will hide date range options*/	
	jQuery('#week:radio').click(
	    function(e){
	        if (jQuery(this).is(':checked')){
	        	jQuery(".from_to_dates").css('display','none');
	        }
	    });	
	jQuery('#month:radio').click(
	    function(e){
	        if (jQuery(this).is(':checked')){
	        	jQuery(".from_to_dates").css('display','none');
	        }
	    });	
	jQuery('#quarter:radio').click(
	    function(e){
	        if (jQuery(this).is(':checked')){
	        	jQuery(".from_to_dates").css('display','none');
	        }
	    });
	
	jQuery("#between").datepicker({
		showOn: "button",
		buttonText: 'Select Date',
		dateFormat: 'dd-M-yy',
		buttonImage: "/BSTheme-theme/images/calendar_icon.png",
		buttonImageOnly: true,
		changeMonth: true, 
		changeYear: true,
		onSelect: function(dateText, inst) {
	        var selectedDate = jQuery( this ).datepicker( "getDate" );
	        jQuery( "#and" ).datepicker( "option", "minDate", selectedDate );
	    }
		});

	jQuery("#and").datepicker({
		showOn: "button",
		dateFormat: 'dd-M-yy',
		buttonImage: "/BSTheme-theme/images/calendar_icon.png",
		buttonImageOnly: true,
		buttonText: 'Select Date',
		changeMonth: true, 
		changeYear: true,
		minDate: new Date()
		});
	

	jQuery(".view_details").click(function(){
		
		var parentId = jQuery(this).parent("td").siblings("td.parent_id").text();
		var timeInMilis = jQuery(this).attr("id");
		var hiddenDetails = jQuery(this).parent("td").parent("tr").siblings("._" + parentId);
		var theTitle = jQuery(this).attr("title");
		if( theTitle == "View Details" )
		{	
			jQuery(this).parent('td').parent('tr').css({color: "#fff", backgroundColor: "#d21d8e"});
			jQuery(hiddenDetails).show();
			jQuery(this).attr({title: "Close Details", alt: "Close Details"});
			jQuery(this).children("img").attr({src: "/BSTheme-theme/images/minus_viewless.png", title: "Close Details", alt: "Close Details Icon"});
		} 
		else 
		{
			jQuery(this).parent('td').parent('tr').css({color: "#000", backgroundColor: "#fff"});
			jQuery(hiddenDetails).hide();
			jQuery(this).attr({title: "View Details", alt: "View Details"});
			jQuery(this).children("img").attr({src: "/BSTheme-theme/images/plus_viewmore.png", title: "View Details", alt: "View Details Icon"});
		}
		return false;
	});
	
	
});

function showImages(imgDivId)
{
		jQuery("#StandardsImages #std_images").html(jQuery("#"+imgDivId).html());
        jQuery("#std_imgs").click();
        return false;
}

var expandedStd = new Array();
/*Show specifications on click on plust sign */
function showSpecifications(stdId, parentId, timeInMilis)
{
	doShowSpecifications(stdId, parentId, timeInMilis, false, 0);
	addExpandedStd(stdId, parentId, timeInMilis);
}

function addExpandedStd(stdId, parentId, timeInMilis)
{
    if(filterSet)
    {
        var found = false;
        for (var i=0; i<expandedStd.length; i++)
        {
            var tmp = expandedStd[i];
            if (stdId == tmp[0] && timeInMilis == tmp[1])
            {
                found = true;
                break;
            }
        }
        
        if (!found)
        {
            var std = new Array();
            std[0] = stdId;
            std[1] = timeInMilis;
            std[2] = parentId;
            expandedStd.push(std);
            /*alert("Added std: " + stdId + "  currPage=" + currPage + "  recPerPage=" + recPerPage);*/
        }
    }	
}


function doShowSpecifications(stdId, parentId, timeInMilis, updateExpanded, expIndx)
{  
    var url = '<%=stdListUrl%>';
    var theUrl = url;
    var indx = url.indexOf("&_ComplianceAdmin_WAR_BSAdminportlet_publishExtStdsSearchContainerPrimaryKeys");
    if (indx > 0)
    {
        theUrl = url.substr(0, indx);
    }
    var divname = "#specs_"+stdId;
    var caloption = jQuery('input[name=caloption][checked]').val();
    var isNonMatch = "";
    if(jQuery('#non-matching-spec').is(':checked')){
    	isNonMatch = jQuery('#non-matching-spec').val();
    }
    var between = jQuery('#between').val();
    var and = jQuery('#and').val();
    var Search = jQuery('#Search').val();
    var inData = {standardsId:stdId,parentId:parentId,caloption:caloption,nonMatch:isNonMatch,between:between,and:and,Search:Search};
 
    jQuery.ajax({
        type: "POST",
        url: theUrl,
        data: inData
    }).done( function(data) {
            /*console.log("jQuery(divname) ====" + jQuery(divname));*/
        	/*console.log("updateExpanded ? " + updateExpanded + "  divname = " + divname); */
            jQuery(divname).html(data);
            if (updateExpanded)
            {
                updateExpandedStandard(expIndx);
            }
    }).fail( function(jqXHR, textStatus) {
           /* alert("AJAX request failed with status:" + textStatus);*/
    	/*window.location.reload();*/
    });
}
/* Show all not matching specifications */
function getAllNonMatchingSpecs()
{
	
	var theTitle = jQuery(".view_details").attr("title");
	if(jQuery('#non-matching-spec').is(':checked'))
    {
    	isNonMatch = jQuery('#non-matching-spec').val();
    	jQuery(".view_details").trigger( "click" );
    	
    	/*jQuery(".view_details").trigger( "click" );*/
    	jQuery("table.results_table tr.hidden_sub_results ").css('display','table-row');
    }
	else
    {
    	removeNonMatch();
    	jQuery("table.results_table tr.hidden_sub_results ").css('display','none');
    }
	
}

/*Call to remove session value if non match checkbox unchecked*/
function removeNonMatch()
{
    var url = '<%=removeNonMatchVal%>';
    var isNonMatch = "";
    if(jQuery('#non-matching-spec').is(':checked'))
    {
    	isNonMatch = jQuery('#non-matching-spec').val();
    }
    jQuery.post(url, {nonMatch:isNonMatch}, 
    	function(data){
    	/*updateExpandedStandard(0);*/
    });
} 
function updateExpandedStandard(indx)
{
	
    /* console.log("(2) updateExpandedStandard: expandedStd.length = " + expandedStd.length + " indx = " + indx); */
    if (expandedStd.length > indx)
    { 
        var std = expandedStd[indx];
        /* console.log("(3) Update standard: id=" + std[0] + " currPage=" + std[1] + " recPerPage=" + std[2]); */
        doShowSpecifications(std[0], std[2], std[1], true, indx + 1);
    }
}
 function sumbitForm()
{
	if (jQuery('#betweenRadio:radio').is(':checked'))
	{
		var between = jQuery('#between').val();
	    var and = jQuery('#and').val();
			
	    if( between != null && between != '' && typeof between != 'undefined'
	    	&& and != null && and != '' && typeof and != 'undefined' ) 
    	{
	    	jQuery('#adminForm').submit();
    	}else
   		{
    		alert("Please enter valid dates !");
   		}
	}
	else
	{
		jQuery('#adminForm').submit();
	}
} 


function cancelForm(){
	document.getElementById("Search").value = "";
	document.getElementById("week").value = "";
	document.getElementById("month").value = "";
	document.getElementById("quarter").value = "";
	document.getElementById("betweenRadio").value = "";
	document.getElementById("between").value = "";
	document.getElementById("and").value = "";
	jQuery('#adminForm').submit();
} 
function clearDates(){
	jQuery('.from_to_dates #between').val("");
	jQuery('.from_to_dates #and').val("");
}
function clearTextBox(){
	jQuery('#Search').val("");
}

function clearCalOptions(){
	
	jQuery('#week').prop('checked', false);
	jQuery('#month').prop('checked', false);
	jQuery('#quarter').prop('checked', false);
	jQuery('#betweenRadio').prop('checked', false);
	jQuery('.from_to_dates').hide();
}

function runExcelComplianceImport()
{
	var brandCd = '<%=tabs1%>';
    var url = '<%=excelComplianceImport%>';
    var indx = url.indexOf("&_ComplianceAdmin_WAR_BSAdminportlet_");
    if (indx > 0)
    {
        url = url.substr(0, indx);
    }
    var file = jQuery("#file").val();
    var whereToUpdate = jQuery("#whereToUpdate").val();
    var whatToUpdate = jQuery("#whatToUpdate").val();
    var cmplyImportType = jQuery("#cmplyImportType").val();
	
    if(!whereToUpdate) {
    	jQuery.msgBox({
            type:"info",
            content:"Please select where to update.",
            buttons: [{value: "OK"}]
        });
    	return;
    } else if(!whatToUpdate) {
    	jQuery.msgBox({
            type:"info",
            content:"Please select what to update.",
            buttons: [{value: "OK"}]
        });
    	return;
    }  else if(!cmplyImportType) {
    	jQuery.msgBox({
            type:"info",
            content:"Please select compliance import type.",
            buttons: [{value: "OK"}]
        });
    	return;
    } else if(whereToUpdate=='Bridge_Compliance_Admin' && cmplyImportType=='Import_By_Rule'){
    	jQuery.msgBox({
            type:"info",
            content:"Compliance Admin cannot be imported by rule for both Compliance and Expiry. Compliance rules can be imported only for Compliance on Manage Compliance.",
            buttons: [{value: "OK"}]
        });
    	return;
    }  else if(whereToUpdate=='CMS_Manage_Compliance' && whatToUpdate=='Expiry' && cmplyImportType=='Import_By_Rule'){
    	jQuery.msgBox({
            type:"info",
            content:"Manage Compliance cannot be imported by rule for Expiry. Manage Compliance can be imported by rule for Compliance option only.",
            buttons: [{value: "OK"}]
        });
    	return;
    } else if (!file) {
    	jQuery.msgBox({
            type:"info",
            content:"Please select import file.",
            buttons: [{value: "OK"}]
        });
    	return;
   	}
    
    var postData = {reportId:"31",brandCd:brandCd,fileName:file,whereToUpdate:whereToUpdate,whatToUpdate:whatToUpdate,cmplyImportType:cmplyImportType};
	
    jQuery.blockUI({ message: '<h3><img src="/BSTheme-theme/images/busy.gif" /> Please wait...</h3>' });
	$.ajaxFileUpload ( 
	{
    	secureuri : false,
    	fileElementId : 'file',
    	data: postData,
        url: url,
        success: function (data, status)
		{
        	jQuery.unblockUI();
            jQuery.msgBox({
                type:"info",
                content:"An email with detailed import process log will be sent to you once the import is complete.",
                buttons: [{value: "OK"}]
            });
            $('#file').val('');
            jQuery("#ImportCompliance").dialog("close");
        },
		error: function (data, status, e) {
			jQuery.unblockUI();
            jQuery("#ImportCompliance").dialog("close");
            /* alert("AJAX request failed with status:" + jqXHR.statusText + " status code:" + jqXHR.status); */
        }
	})
    return false;
}
jQuery(function(){

	jQuery('.filter_results_button').click(function(){
    	jQuery('.filter_results_form').show();
    	
           e.preventDefault();
    });
		
    jQuery('.comp_cancel_filter').click(function(e){
    	jQuery('.non_matching_spec').hide();
    	jQuery('.filter_results_form').hide();
    });
    
    jQuery('#Search').keypress(function(e) {
        	if (e.which < 8 || 
       			(e.which > 8 && e.which < 32) || 
      		    (e.which > 32 && e.which < 48) || 
      		    e.which > 57 ) 
        	{
        		    e.preventDefault();
       		}
    }); 
    
    jQuery('#Search').bind("paste",function(e) {
        e.preventDefault();
    });
    
    /*  Compliance Import  */
	jQuery("#runComplianceImport").click(function(){
		runExcelComplianceImport();
		return false;
    });
 
    jQuery("#ImportCompliance").dialog({
	    autoOpen: false,
	    width: 360,
	    modal: true,
	    resizable: false,
	    open: function() {
			jQuery('.ui-widget-overlay').bind('click', function() {
				jQuery('#ImportState').dialog('close');
		    });
		}
    });
    
    jQuery(".cmplyDlgClose").click(function() {
    	jQuery("#ImportCompliance").dialog("close");
	});

    jQuery(".import-cmply-btn").click(function(e){
        jQuery("#ImportCompliance").dialog("open");
        
    	jQuery("#whereToUpdate").val('');
    	jQuery("#whatToUpdate").val('');
    	jQuery("#cmplyImportType").val('');
        jQuery('#file').val('');
    });
});

</script>

<link href="/BSTheme-theme/css/complianceAdmin.css" rel="stylesheet" type="text/css" />
<c:if test="${allowCmplyImport == true}">
	<div class="pull-left">
		Download Compliance Import Templates : 
		<a href="/brandstandards/files/templates/AMEA_Compliance_Template.xlsx" title="AMEA Compliance Import Template"><i class="icon-arrow-down icon-white"></i><strong>AMEA</strong></a> | 
		<a href="/brandstandards/files/templates/AMER_Compliance_Template.xlsx" title="AMER Compliance Import Template"><i class="icon-arrow-down icon-white"></i><strong>AMER</strong></a> | 
		<a href="/brandstandards/files/templates/EURO_Compliance_Template.xlsx" title="EURO Compliance Import Template"><i class="icon-arrow-down icon-white"></i><strong>EURO</strong></a> | 
		<a href="/brandstandards/files/templates/GC_Compliance_Template.xlsx" title="GC Compliance Import Template"><i class="icon-arrow-down icon-white"></i><strong>GC</strong></a>
		<div class="import-cmply-btn button">
			<a class="import-cmply-href" href="javascript:void(0)" title="Import Compliance"><i class="icon-arrow-up icon-white"></i>Import</a><span></span>
		</div>
	</div>
</c:if>
<div class="clear"></div>
<div class="rounded_container">	
	<div id="tabs">
		<liferay-ui:tabs
		   names="<%=tabValues%>"
		   tabsValues="<%=tabValues%>"
		   param="tabs1"
		   url="<%= portletURL.toString() %>"
		/>
	</div>
<form id="adminForm" name="adminForm" method="post" action="<%=filterResults.toString()%>">
<div class="rounded_container_contents">
<div class="aui-tab-content-custom">

<div class="clear"></div>

<div id="ImportCompliance" title="Import Compliance" style="display:none">
	<div class="modal-body">
		<div class="control-group">
			<label class="control-label" title="Where to Update"><em class="required">* </em>Where to Update:</label>
			<div class="controls">
				<select name="whereToUpdate" id="whereToUpdate">
					<option value="">Please select</option>
					<option value="Bridge_Compliance_Admin">Compliance Admin</option>
					<option value="CMS_Manage_Compliance">Manage Compliance</option>
				</select>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label" title="What to Update"><em class="required">* </em>What to Update:</label>
			<div class="controls">
				<select name="whatToUpdate" id="whatToUpdate">
					<option value="">Please select</option>
					<option value="Compliance">Compliance</option>
					<option value="Expiry">Expiry</option>
				</select>
			</div>
		</div>
		
		<div class="control-group">
			<label class="control-label" title="Compliance Import Type"><em class="required">* </em>Compliance Import Type:</label>
			<div class="controls">
				<select name="cmplyImportType" id="cmplyImportType">
					<option value="">Please select</option>
					<option value="Import_By_Date">By Date</option>
					<option value="Import_By_Rule">By Rule</option>
				</select>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label" title="Import File"><em class="required">* </em>Import File:</label>
			<div class="controls">
				<input name="file" id="file" type="file" class="add_item_file_input" accept="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet,application/vnd.ms-excel"/>
			</div>
		</div>
	</div>
	<div class="modal-footer">
	    <button aria-hidden="true" data-dismiss="modal" type="button" name="cancel" id="cancel" class="btn pull-left cmplyDlgClose">Cancel</button>
	    <button aria-hidden="true" data-dismiss="modal" type="button" name="submit" id="runComplianceImport" class="btn btn-primary pull-right">Import</button>
	</div>
</div>

<div id="confirm-dialog" title="Confirmation" style="display:none">
    <div class="modal-body" id="confirm-dialog-message">
      
    </div>
    <div class="modal-footer">
        <div class="pull-right"><button type="button" id="confirm-dialog-ok" class="btn btn-primary">Ok</button></div>
    </div>
</div>



<div class="results_right_util result_utils" style="width:auto;">
<% if(hasFilter) { %>
	<div class="button_red filter_results_button"><a href="javascript:void(0)" class="results_filter" title="Filter Results">Filter Results</a><span></span></div>
<% } else { %>
	<div class="button filter_results_button"><a href="javascript:void(0)" class="results_filter" title="Filter Results">Filter Results</a><span></span></div>
<% } %> 
</div>

<div class="clear"></div>
<% if(hasFilter) { %>
	<div class="non_matching_spec" id="aui_3_2_0_1423"> 
		<div align="left" style="margin-bottom: 10px;" id="aui_3_2_0_1422"> 
			<label for="non-matching-spec" id="aui_3_2_0_1421"> 
			<input type="checkbox" name="isNonMatch" id="non-matching-spec" value="true" 
			<% if(isNonMatch.equals("true") && !isNonMatch.equals(StringPool.BLANK)) { %>
				checked ="checked" 
			<% } %> 
			onclick="getAllNonMatchingSpecs()" title="Show all non-matching Specifications"> Show all non-matching Specifications
			</label> 
		</div> 
	</div>
<% } %>

<div class="clear"></div>
<div class="filter_results_form" style="float: none;">
	<div style="margin-bottom: 10px;">
		<label>
			<span>Standard, Specification ID</span><a class="help_icon tooltip" href="javascript:return false;"><img src="/BSTheme-theme/images/help.png" alt="details" title="details"/>
			<span class="classic">Enter a single Standard ID or a space seperated list of Standard ID's to filter based on Standard ID.</span></a>     
            <input type="text" class="input_text required" name="Search" value="<%=stdString%>" id="Search" style="width: 220px;"/>
            <img alt="Clear Standard Id" src="https://me2qa.ihgmerlin.com/BSTheme-theme/images/delete.png" title="Clear Standard Id" class="clear_std_id" onclick="clearTextBox()"/>
		</label>
		
	</div>
	<div class="calendar-options">
		<label for="week" style="display:inline !important">
		<input type="radio" name="caloption" <c:if test="<%= \"week\".equalsIgnoreCase(filterOn)%>">checked</c:if> id="week" value="week"/>Week</label>
		<label for="month" style="display:inline !important">
		<input type="radio" name="caloption" <c:if test="<%= \"month\".equalsIgnoreCase(filterOn)%>">checked</c:if> id="month" value="month"/>Month</label>
		<label for="quarter" style="display:inline !important">
		<input type="radio" name="caloption" <c:if test="<%= \"quarter\".equalsIgnoreCase(filterOn)%>">checked</c:if> id="quarter" value="quarter"/>Quarter</label>
		<label for="betweenRadio" style="display:inline !important">
		<input type="radio" name="caloption" <c:if test="<%= \"between\".equalsIgnoreCase(filterOn)%>">checked</c:if> id="betweenRadio" value="between"  onclick="clearDates()"/>Between</label>
		<div class="from_to_dates">
			<input type="text" name="between" id="between" class="datepicker" value="<%=fromDate%>" readonly="readonly"/>
			<label for="and">and</label>
			<input type="text" name="and" id="and" class="datepicker" readonly="readonly" value="<%=toDate%>"/>
		</div>
		<img alt="Clear Date Options" src="https://me2qa.ihgmerlin.com/BSTheme-theme/images/delete.png" title="Clear Date Options" class="clear_std_id" onclick="clearCalOptions()"/>
	</div> 
	<div style="text-align: center;">
		<span class="aui-button"> 
		<span class="aui-button-content" id="aui_3_2_0_1218"> 
			<input type="button" id="apply" value="apply filter" class="aui-button-input comp_apply_filter" onclick="sumbitForm()"/></span> 
		</span>
		<span class="aui-button"> 
			<span class="aui-button-content">
				<input type="button" value="cancel filter" class="aui-button-input comp_cancel_filter" onclick="cancelForm()"/> 
			</span> 
		</span>
	</div>
</div> 

<div class="clear"></div>
<div class="divider">&nbsp;</div>
<div class="clear"></div>
<table class="results_table" summary="Data table for all results">
	<tr class="results_header_bar">
		<td class="result_table_cell1"><strong>ID</strong></td>
        <td class="result_table_cell2"><strong>Standard</strong></td>
       <!--  <td class="result_table_cell3"><strong>Deadline</strong></td> -->
        <!-- <td class="result_table_cell4"><strong>Expires Others</strong></td> -->
        <td class="result_table_cell5">&nbsp;</td>
     </tr>
<liferay-ui:search-container hover="false" searchContainer="<%=searchContainerObj%>">
	<liferay-ui:search-container-results results="<%=searchContainer.getResults()%>" total="<%=searchContainer.getTotal()%>"/>
	<liferay-ui:search-container-row className="com.ihg.brandstandards.db.model.PublishExtStd" modelVar="publishStd" >
	<tr>
		<td class="parent_id"><%=publishStd.getStdId() %></td>
		<td>
		<%
			List<StandardsChainImages> stdImgs = new ArrayList<StandardsChainImages>();
			try {
	   			stdImgs = CMSStandardsListUtil.getStandardsImagesByStdIdChaincode(publishStd.getStdId(), tabs1);
	   		} catch(Exception e){
	   			_log.error(e.getMessage());
	   		}	
			if(!BrandStandardsUtil.isNullOrBlank(stdImgs)) {
		%>
			<a onclick="showImages(<%=publishStd.getStdId()%>);" ><img src="/BSTheme-theme/images/camera_icon.jpg" class="global_icon" title="Has Images" alt="Has Images" /></a>
			<div id="<%=publishStd.getStdId()%>" style="display:none">
		<%  for(StandardsChainImages stdImg : stdImgs) {
				StandardsImages image = null;
				DLFileEntry igImage = null;
	            String largeImage = "";
	            String imageId = "";
	            try {
					image = StandardsImagesLocalServiceUtil.getStandardsImages(stdImg.getStdImageId());
                	imageId = image.getImageId()+"";
                	igImage = DLFileEntryLocalServiceUtil.getFileEntry(image.getImageId());
                	FileEntry fileEntry = DLAppLocalServiceUtil.getFileEntry(igImage.getFileEntryId());
                    largeImage = DLUtil.getPreviewURL(fileEntry, fileEntry.getLatestFileVersion(), themeDisplay, "");
               	} catch(Exception e){
                   	_log.error("Compliance Standards List: Image retrival Expection:===>"+e.getMessage());
               	}
		%>
			<img src="<%=largeImage %>" alt="Standards Image" id="<%=imageId %>"/><br/>
		<% 	} %>
			</div>
		<%  } %>
		<% 	if("GLBL".equals(publishStd.getRegionCode())) {
				if("G".equals(publishStd.getIsGlobal())) {
					if("Y".equals(publishStd.getFramework())) {
		%>
					<img src="/BSTheme-theme/images/global_icon_red.png" class="global_icon" title="Global Framework standard icon" alt="Global Framework standard icon" />
		<% 			} else { %>
					<img src="/BSTheme-theme/images/global_icon.png" class="global_icon" title="Global standard icon" alt="Global standard icon" />
		<% 			}
				} else {
					if("Y".equals(publishStd.getFramework())) {
		%>
					<img src="/BSTheme-theme/images/global_icon_halfred.png" class="global_icon" title="Multi-region Framework standard icon" alt="Multi-region Framework standard icon" />
		<% 			} else { %>
					<img src="/BSTheme-theme/images/multi_region_icon.png" class="global_icon" title="Multi-region standard icon" alt="Multi-region standard icon" />
		<%			}
				}
			}
		%>
			<%=publishStd.getTitle() %>
		</td>
		<%-- <td><%=df.format(publishStd.getCompDate()) %></td> --%>
		<%-- <td><c:choose><c:when test="<%=Validator.isNotNull(publishStd.getExpiredIds()) %>">Yes</c:when><c:otherwise>&nbsp;</c:otherwise></c:choose></td> --%>
		<td class="row_expander">
			<a title="View Details" id="" class="view_details" onclick="showSpecifications(<%=publishStd.getStdId() %>, <%=publishStd.getParentId() %>,'')">
				<img src="/BSTheme-theme/images/plus_viewmore.png" alt="View Details Icon" title="View Details" />
			</a>
			<a title="Edit Tooltip" href="/web/brand-standards/compliance-deadline?stdId=<%=publishStd.getStdId()%>&brandCode=<%=tabs1%><%=editUrlParam%>">
				<img class="log_icon" alt="Edit Icon" title="Edit Deadline" src="/BSTheme-theme/images/edit_pencil_icon.png" /> 
			</a>
		</td>
	</tr>
	<tr class="_<%=publishStd.getStdId()%> hidden_sub_results">
		<td colspan="5">
			<div id="specs_<%=publishStd.getStdId()%>"></div>
		</td>
    </tr>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>
</table> 
</div>

<div class="rounded_container_bottom">&nbsp;</div>
</div>
</form>
</div>
<a href="#StandardsImages" id="std_imgs" title="" class="nyroModal" style="display:none;">DOM Element (hidden div)</a>

<div id="StandardsImages" class="model_content">
    <h4 class="img_modal_title_text">Images</h4>
	<div id="std_images"></div>
</div>
<%!
	private static Log _log = LogFactoryUtil.getLog("BSAdmin-portlet.docroot.html.complianceAdmin.viewSpecifications_jsp");
%>