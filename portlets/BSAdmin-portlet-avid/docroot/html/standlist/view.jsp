<%
/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */
%>
<%@include file="/html/standlist/init.jsp" %>
<%@page import="com.ihg.brandstandards.util.ComplianceUtil"%>
<%@page import="com.ihg.brandstandards.util.UserPreferencesUtil"%>
<%@page import="com.sun.org.apache.xpath.internal.operations.Bool"%>
<%@page import="com.ihg.brandstandards.db.model.StandardsStatus"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFileEntry"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.ImageLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Image"%>
<%@page import="com.ihg.brandstandards.db.service.StandardsImagesLocalServiceUtil"%>
<%@page import="com.ihg.brandstandards.db.model.StandardsImages"%>
<%@page import="com.ihg.brandstandards.util.StandardsStatusUtil"%>
<%@page import="com.ihg.brandstandards.util.StandardsListUtil"%>
<%@page import="com.ihg.brandstandards.custom.model.CMSSearchCriteria"%>
<%@page import="com.ihg.brandstandards.report.ReportConfig"%>
<%@page import="com.ihg.brandstandards.util.RegionalUtil"%>
<%@page import="com.ihg.brandstandards.custom.model.Preferences"%>
<%@page import="com.ihg.brandstandards.db.model.StandardsRegionLocale"%>
<%@page import="com.ihg.brandstandards.db.service.StandardsRegionLocaleLocalServiceUtil"%>
<%@page import="com.ihg.brandstandards.db.service.StandardsRegionLocalServiceUtil"%>
<%@page import="com.ihg.brandstandards.portlet.StandardsController"%>
<%@page import="java.util.Map.Entry"%>

<portlet:resourceURL var="stdListUrl" id="getSpecifications"></portlet:resourceURL>
<portlet:resourceURL var="stdStatusUrl" id="updateStatus"></portlet:resourceURL>
<portlet:resourceURL var="stdCountUrl" id="getStandardsCount"></portlet:resourceURL>
<portlet:resourceURL var="varExportFullReport" id="exportFullReport"></portlet:resourceURL>
<portlet:resourceURL var="varExportReport" id="exportRecordsOnlyReport"></portlet:resourceURL>
<portlet:resourceURL var="varDisplayAllSpecUrl" id="dispAllSpecGuideline"></portlet:resourceURL>
<portlet:resourceURL var="varExportTranslationReport" id="exportTranslationReport"></portlet:resourceURL>
<portlet:resourceURL var="varImportTranslationReport" id="importTranslationReport"></portlet:resourceURL>
<portlet:resourceURL var="varExportAttachmentLinksReport" id="attachmentsLinksReport"></portlet:resourceURL>

<script type="text/javascript" src="/BSTheme-theme/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/jquery-ui-1.10.1.custom.min.js"></script>
<link href="/BSTheme-theme/css/other/jquery-ui-1.10.1/themes/base/jquery.ui.all.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/BSTheme-theme/js/jquery.multiselect.min.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/jquery.validate.min-1.11.0.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/ajaxfileupload.js"></script>

<%@include file="/html/common/countryregions.jsp" %>
<script type="text/javascript" src="/BSTheme-theme/js/jquery.nyroModal.custom.min.js"></script>
<!--items for jquery UI -->
<script type="text/javascript" src="/BSTheme-theme/js/jquery.ui.datepicker.validation.min.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/treeAdmin/jquery.msgBox.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/treeAdmin/jquery.blockUI.js"></script>
<link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/msgBoxLight.css"/>
<!-- Tree -->
<portlet:resourceURL var="ajaxURL" id="getTreeData" escapeXml="false" />
<script type="text/javascript" src="/BSTheme-theme/js/treeAdmin/jquery.jstreeStandard.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/treeAdmin/!script.js"></script>
<%-- <%@include file="/html/common/initmenu.jsp" %> --%>
<script type="text/javascript" src="/BSTheme-theme/js/hoverIntent.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/superfish.js"></script>

<link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/tree/!style.css"/>
<link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/tree/custom/!style.css"/>
<!-- End Tree -->
<script type="text/javascript" src="/BSTheme-theme/js/standard_list.js"></script>
<link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/standard_list.css"/>

<style>
#overlay {
    position: fixed;
    z-index: 10;
    background: black;
    display: block;
    opacity: .75;
    filter: alpha(opacity=75);
    width: 100%;
    height: 100%;
}
</style>
<%
StandardsView standView = (StandardsView) request.getAttribute("StandardsView");
String curPageNum = (String)request.getAttribute("curPageNum");
List<String> arlUsers = new ArrayList();
arlUsers = (ArrayList)request.getAttribute("arlUsers");
HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(request);
String recPerPage = httpRequest.getParameter(BrandStandardsUtil.REQUEST_PARAM_REC_PER_PAGE);
if (recPerPage == null)
{
    recPerPage = request.getParameter(SearchContainer.DEFAULT_DELTA_PARAM) == null ? String.valueOf(SearchContainer.DEFAULT_DELTA) : request.getParameter(SearchContainer.DEFAULT_DELTA_PARAM);
}
String redirect = ParamUtil.getString(request, "redirect");
String keywords = ParamUtil.getString(request, "keywords");
int currPage = 0;
boolean hasFilter = false;
Preferences preferences = (Preferences)session.getAttribute("Preferences");
String regionCode = "";
String discontFilter = "";
String chainCode = "";
if(preferences!=null)
{
	regionCode = preferences.getRegionCode();
	discontFilter = preferences.getDiscontinuedFilter();
	chainCode = preferences.getBrand();
}
CMSSearchCriteria stdSearchCriteria = (CMSSearchCriteria) session.getAttribute("searchCriteria");
if(stdSearchCriteria != null && !stdSearchCriteria.isEmpty())
{
    hasFilter = true;
}

//String preferedBrand = UserPreferencesUtil.getUserpreferences(renderRequest);
//String discontFilter = UserPreferencesUtil.getDiscontinuedFilter(renderRequest);
List<String> preferedBrandList  = new ArrayList<String>();
preferedBrandList.add(chainCode);
List<String> arlBrands = stdSearchCriteria == null ? preferedBrandList : stdSearchCriteria.getBrands();
if(!hasFilter && !"GL".equalsIgnoreCase(chainCode) && !BrandStandardsUtil.IsNullOrBlank(arlBrands))
{
    arlBrands.add(chainCode);
}


List<String> arlCountries = stdSearchCriteria == null ? null : stdSearchCriteria.getCountries();
List<String> searchCriteria = stdSearchCriteria == null ? null : stdSearchCriteria.getSearchCriteria();
List<String> arlStatus = stdSearchCriteria == null ? null : stdSearchCriteria.getStatus();
List<String> arlTechWriter = stdSearchCriteria == null ? null : stdSearchCriteria.getTechWriter();
List<String> arlStdOwner = stdSearchCriteria == null ? null : stdSearchCriteria.getStdOwner();
List<String> arlCategory = stdSearchCriteria == null ? null : stdSearchCriteria.getCategory();
List<String> arlDeptApplicability = stdSearchCriteria == null ? null : stdSearchCriteria.getDeptApplicability();
List<String> arlImportance = stdSearchCriteria == null ? null : stdSearchCriteria.getImportance();
List<String> arlGuestJourney = stdSearchCriteria == null ? null : stdSearchCriteria.getGuestJourney();
List<String> arlLocHotel = stdSearchCriteria == null ? null : stdSearchCriteria.getLocHotel();
List<String> arlCorpDept = stdSearchCriteria == null ? null : stdSearchCriteria.getCorpDept();
List<String> arlWheelQuad = stdSearchCriteria == null ? null : stdSearchCriteria.getWheelQuad();
List<String> arlMeasurement = stdSearchCriteria == null ? null : stdSearchCriteria.getMeasurement();
List<String> arlGemReportCategory = stdSearchCriteria == null ? null : stdSearchCriteria.getGemReportCategory();
List<String> arlAreaForMeasurement = stdSearchCriteria == null ? null : stdSearchCriteria.getAreaForMeasurement();
List<String> arlManual = stdSearchCriteria == null ? null : stdSearchCriteria.getManual();
List<String> arlAttachType = stdSearchCriteria == null ? null : stdSearchCriteria.getAttachType();
List<String> arlChangeType = stdSearchCriteria == null ? null : stdSearchCriteria.getChangeType();
List<String> arlRationale = stdSearchCriteria == null ? null : stdSearchCriteria.getRationale();
List<String> arlFlags = stdSearchCriteria == null ? null : stdSearchCriteria.getFlags();
List<String> arlImpactAssmnt = stdSearchCriteria == null ? null : stdSearchCriteria.getImpact();
List<String> arlImpactComments = stdSearchCriteria == null ? null : stdSearchCriteria.getImpactComments();
String histManual = stdSearchCriteria == null ? null : stdSearchCriteria.getHistManual();
String brandHallmark = stdSearchCriteria == null ? null : stdSearchCriteria.getBrandHallmark();
String strHasLinks = stdSearchCriteria == null ? null : stdSearchCriteria.isHasLinks() ? "Y" : "N";
String strHasGuidelines = stdSearchCriteria == null ? null : stdSearchCriteria.isHasGuidelines() ? "Y" : "N";
String strHasCrossReferences = stdSearchCriteria == null ? null : stdSearchCriteria.isHasCrossReference() ? "Y" : "N";
String strIndex = stdSearchCriteria == null ? "" : stdSearchCriteria.getIndex();
String strBranchOnly = stdSearchCriteria == null ? null : stdSearchCriteria.isBranchOnly() ? "Y" : "N";
String strRecordId = stdSearchCriteria == null ? "" : stdSearchCriteria.getRecordId(); 
String strSearchOptions = stdSearchCriteria == null ? "" : stdSearchCriteria.getTextSearchType(); 
String strLogDate = stdSearchCriteria == null ? "" : stdSearchCriteria.getLogDate();
String strLogCriteria = stdSearchCriteria == null ? "" : stdSearchCriteria.getLogCriteria();
String strSearchLog = stdSearchCriteria == null ? "" : stdSearchCriteria.getSearchLog();
String strLogCreatedBy = stdSearchCriteria == null ? "": stdSearchCriteria.getLogCreatedBy();
String strEnteredBy = stdSearchCriteria == null ? "": stdSearchCriteria.getEnteredBy();
String strInternalRef = stdSearchCriteria == null ? "": stdSearchCriteria.getInternalReference();
List<String> filterLogBrand = stdSearchCriteria == null ? null : stdSearchCriteria.getAuditLogBrands();
boolean isShowAllSpecGuideline = stdSearchCriteria == null ? false : stdSearchCriteria.isFetchAllSpecGuideline(); 

String indexHeader = "";
if(!BrandStandardsUtil.IsNullOrBlank(strIndex))
{
    try {
        indexHeader = TaxonomyLocalServiceUtil.getTaxonomy(Long.valueOf(strIndex)).getTitle();
        hasFilter = true;
    } catch(Exception exc)
    {
        
    }
}

String strFilterValue = "";
if(!BrandStandardsUtil.isNullOrBlank(searchCriteria))
{
    for(int i=0;i<searchCriteria.size();i++)
    {   
        strFilterValue += searchCriteria.get(i) + " ";
    }
}

String rationale = "";
if(!BrandStandardsUtil.isNullOrBlank(arlRationale))
{
    for(int i=0;i<arlRationale.size();i++)
    {
        rationale += arlRationale.get(i) + " ";
    }
}

String impactComments = "";
if(!BrandStandardsUtil.isNullOrBlank(arlImpactComments))
{
    for(String comments : arlImpactComments)
    {
        impactComments += comments + " ";
    }
}
%>

<!--open filter form and open each nested result row -->
<script type="text/javascript">
<%if(hasFilter)
{%>
    var filterSet = true;   
<%} else {%>
    var filterSet = false;   
<%}%>

var statusCurrValue;

jQuery(function() {
	
	if ( jQuery('ul.sf-menu').superfish() ) {
        jQuery('ul.sf-menu').superfish();
    }
	
    <%
    if(!BrandStandardsUtil.isNullOrBlank(arlCountries)) 
    {   for(int i=0;i<arlCountries.size();i++)
        {
    %>          
            jQuery('#selectedcountries').append("<option value='<%=arlCountries.get(i)%>' selected='selected'>"+ getCountryByCode('<%=arlCountries.get(i)%>')+"</option>");
    <%
        }
    }
    %>

    jQuery("#choose_img_button").click(function(){

        jQuery("#img_gallery_search").click();
        return false;
    });
        
});

jQuery(document).ready(function () {
	jQuery(".datepicker").datepicker({dateFormat: 'dd-M-yy', changeMonth: true, changeYear: true, buttonText: 'Select Date'});
});

function showImages(imgDivId)
{
		jQuery("#StandardsImages #std_images").html(jQuery("#cameraIconDiv"+imgDivId).html());
        jQuery("#std_imgs").click();
        return false;
}

function showSpecificationsOnLoad()
{
    <%
    long expandStdId = httpRequest.getParameter(BrandStandardsUtil.REQUEST_PARAM_STD_ID) == null ? 0L : Long.parseLong(httpRequest.getParameter(BrandStandardsUtil.REQUEST_PARAM_STD_ID));
    int pageNum = httpRequest.getParameter(BrandStandardsUtil.REQUEST_PARAM_PAGE_NUM) == null ? 0 : Integer.parseInt(httpRequest.getParameter(BrandStandardsUtil.REQUEST_PARAM_PAGE_NUM));
    if(expandStdId > 0)
    {
    %>
    jQuery(".results_table").find("td.parent_id").each(function() {
        var stdId = jQuery(this).text();
        if(stdId == <%=expandStdId%>)
        {
            var newThis = jQuery(this).siblings("td.row_expander").children(".view_details");
            newThis.click();
            var parentId = jQuery(newThis).parent("td").siblings("td.parent_id").text();
            var hiddenDetails = jQuery(newThis).parent("td").parent("tr").siblings("._" + parentId);
            var theTitle = jQuery(newThis).attr("title");

            if( theTitle == "View Details" )
            {   
                jQuery(newThis).parent('td').parent('tr').css({color: "#fff", backgroundColor: "#d21d8e"});
                jQuery(hiddenDetails).show();
                jQuery(newThis).attr({title: "Close Details", alt: "Close Details"});
                jQuery(newThis).children("img").attr({src: "/BSTheme-theme/images/minus_viewless.png", title: "Close Details", alt: "Close Details Icon"});
            }            
            return false;
        }
    });
    <%
    }
    %>
}

var expandedStd = new Array();

function showSpecifications(stdId, currPage, recPerPage)
{
	doShowSpecifications(stdId, currPage, recPerPage, false, 0);
	addExpandedStd(stdId, currPage, recPerPage);
}

function addExpandedStd(stdId, currPage, recPerPage)
{
    if(filterSet)
    {
        var found = false;
        for (var i=0; i<expandedStd.length; i++)
        {
            var tmp = expandedStd[i];
            if (stdId == tmp[0])
            {
                found = true;
                break;
            }
        }
        
        if (!found)
        {
            var std = new Array();
            std[0] = stdId;
            std[1] = currPage;
            std[2] = recPerPage;
            expandedStd.push(std);
            //alert("Added std: " + stdId + "  currPage=" + currPage + "  recPerPage=" + recPerPage);
        }
    }	
}

function doShowSpecifications(stdId, currPage, recPerPage, updateExpanded, expIndx)
{   
    var url = '<%=stdListUrl%>';
    var theUrl = url;
    var indx = url.indexOf("&_StandList_");
    if (indx > 0)
    {
        theUrl = url.substr(0, indx);
    }
    var divname = "#specs_"+stdId;
    var inData = {standardsId:stdId, <%=StandardsUtil.REQUEST_PARAM_PAGE_NUM%>:currPage, <%=StandardsUtil.REQUEST_PARAM_REC_PER_PAGE%>:recPerPage};
    //alert("currPage = " + currPage + " recPerPage=" + recPerPage); 
    jQuery.ajax({
        type: "POST",
        url: theUrl,
        data: inData
    }).done( function(data) {
            //alert("jQuery(divname) ====" + jQuery(divname));
        	//alert("updateExpanded ? " + updateExpanded + "  divname = " + divname);
            jQuery(divname).html(data);
            if (updateExpanded)
            {
                updateExpandedStandard(expIndx);
            }
    }).fail( function(jqXHR, textStatus) {
            alert("AJAX request failed with status:" + textStatus);
    });
}

function showAllSpecGuideline()
{
    var url = '<%=varDisplayAllSpecUrl%>';
    var theUrl = url;
    var indx = url.indexOf("&_StandList_");
    if (indx > 0)
    {
        theUrl = url.substr(0, indx);
    }
    var varShowAllSpecsGuideline = jQuery("#showAllSpecsGuidelines").is(':checked') ? 'Y' : 'N';
    jQuery.post(theUrl, {showAllSpecsGuidelines:varShowAllSpecsGuideline}, function(data){
    	updateExpandedStandard(0);
    });
}

function updateExpandedStandard(indx)
{
   	// alert("updateExpandedStandard: expandedStd.length = " + expandedStd.length + " indx = " + indx);
    if (expandedStd.length > indx)
    {
        var std = expandedStd[indx];
        //alert("Update standard: id=" + std[0] + " currPage=" + std[1] + " recPerPage=" + std[2]);
        doShowSpecifications(std[0], std[1], std[2], true, indx + 1);
    }
}

var submitted = false;
var lastSelectedStdId = 0;

function showComments(stdId)
{	
	//alert("show comments for stdId = " + stdId);
	lastSelectedStdId = stdId;
	//var nodeObject = document.getElementById('status_'+stdId);
	var statValue = jQuery("#statusValue").val();
	var popID = "comments_div"; //Get Popup Name
	var popWidth = 700;
	//alert(statusCurrValue);
	//Fade in the Popup and add close button
	jQuery('#comments_div').fadeIn().css({ 'width': Number( popWidth ) });

	//Define margin for center alignment (vertical   horizontal) - we add 80px to the height/width to accomodate for the padding  and border width defined in the css
	var popMargTop = (jQuery('#comments_div').height() + 80) / 2;
	var popMargLeft = (jQuery('#comments_div').width() + 80) / 2;

	//Apply Margin to Popup
	jQuery('#comments_div').css({
		'margin-top' : -popMargTop,
		'margin-left' : -popMargLeft
	});
	
		jQuery('body').append('<div id="cmt_modalwindow_fade"></div>'); //Add the fade layer to bottom of the body tag.
		jQuery('#cmt_modalwindow_fade').css({'filter' : 'alpha(opacity=80)', 'position': 'fixed', 'z-index': 10}).fadeIn();
		jQuery('#comments_div').insertAfter('#cmt_modalwindow_fade'); 
		//Close Popups and Fade Layer
		jQuery('#cmt_close').click(function() { //When clicking on the close ...
	    	jQuery('#cmt_modalwindow_fade, .comments_modalwindow_block').fadeOut(function() {
		        jQuery('#cmt_modalwindow_fade, a.comments_modalwindow_close').remove();  //fade them both out
		        jQuery("#cmt_txt_area").val("");
		        var nodeObject = document.getElementById('status_' + lastSelectedStdId);
		        for (var i = 0; i < nodeObject.options.length; i++) 
		        {
		            if (nodeObject.options[i].value === statusCurrValue) 
		            {
		                nodeObject.selectedIndex = i;
		                break;
		            }
		        }
		           
			    submitted = false;
	    	});
	    
	    return false;
	});
	// On click of Ok button.
	jQuery('#cmt_submit').click(function() { //When clicking on the close ... 
		commentsVal = jQuery("#cmt_txt_area").val();
		//alert("1");
        //alert("Request update for record id = " + stdId);
		if (submitted==false)
        {
            submitted = true;
			//alert("2");
			 if(commentsVal.length > 0)
	         {
				//alert("3");
		    	jQuery('#cmt_modalwindow_fade, .comments_modalwindow_block').fadeOut(function() {
		        	jQuery('#cmt_modalwindow_fade, a.comments_modalwindow_close').remove();  //fade them both out
		   		});
		    	//alert("record id = " + lastSelectedStdId);
                updateStatus(lastSelectedStdId, commentsVal);
	         }
			 else
	         {
	             alert("Please enter comments.");
                 submitted = false;
	         }
        }
	    return false;
	});
	return false;
}
function updateStatus(stdId, commentsVal)
{	
	var nodeObjectValue;
	var nodeObject = document.getElementById('status_'+stdId);
	nodeObjectValue = nodeObject.value;
	var divname = "#statusDiv_"+stdId;
	var url = '<%=stdStatusUrl%>';
    var theUrl = url;
    var indx = url.indexOf("&_StandList_");
    if (indx > 0)
    {
        theUrl = url.substr(0, indx);
    }
    jQuery("#overlay").fadeIn();
	jQuery.post(theUrl, {standardsId:stdId,status:nodeObjectValue,comments:commentsVal}, function(data){
		jQuery(divname).html(data);
		submitted = false;
		jQuery("#cmt_txt_area").val("");
		jQuery("#overlay").fadeOut();
    });
	return false;
}

function cancelFilter()
{
	//alert("inside cancel filter");
	var nodeObject = document.getElementById('<portlet:namespace/>clearFilter');
	nodeObject.value = "true";
	var frm  = document.getElementById('<portlet:namespace/>filterForm');
	frm.submit();
}

function showFilter()
{
	//alert("inside cancel filter");
	var varAssignImage = jQuery("table#filter_image_table input").map(function(){
        return this.value;
    }).get().join("~~~~");
	jQuery("#<%=StandardsUtil.REQUEST_PARAM_HIDDEN_IMAGES%>").val(varAssignImage);
    
	var nodeObject = document.getElementById('<portlet:namespace/>applyButton');
	nodeObject.value = "true";
	var frm  = document.getElementById('<portlet:namespace/>filterForm');
	if(validateAuditLog())
	{
		frm.submit();
	}
}

function showPopup(stdId, key)
{		
	
	var view_detail = "/web/brand-standards/view-details?id="+stdId;
	var view_log = "/web/brand-standards/view-log?stdId=" + stdId + "&objType=STD";
	var url = view_log;
	if(key=="View"){
		url = view_detail + "&view=true";
	}
	window.open( url, "_blank", "height = 700, width = 960, menubar=1, toolbar=1, status = 1, resizable = yes, scrollbars=yes" );
	
	return false; 
}	

function showFilterCount()
{	
	jQuery("#selectedcountries option").each(function(){
        jQuery(this).attr("selected","selected");
	});
	var varSelectedcountries = [];
	jQuery('#selectedcountries option').each(function() {
		if (this.selected == true) {
			varSelectedcountries.push(this.value);
		}
    });
	var varBrand = jQuery("#brand").multiselect("getChecked").map(function(){
		   return this.value;	
	}).get();
	var varStatus = jQuery("#searchStatus").multiselect("getChecked").map(function(){
		   return this.value;	
	}).get();
	var varTechWriter = jQuery("#techWriter").multiselect("getChecked").map(function(){
		   return this.value;	
	}).get();
	var varStdOwner = jQuery("#stdOwner").multiselect("getChecked").map(function(){
		   return this.value;	
	}).get();
	var varCategory = jQuery("#category").multiselect("getChecked").map(function(){
		   return this.value;	
	}).get();
	var varDeptAppl = jQuery("#deptApplicability").multiselect("getChecked").map(function(){
		   return this.value;	
	}).get();
	var varImportance = jQuery("#importance").multiselect("getChecked").map(function(){
		   return this.value;	
	}).get();
	var varGuestJourney = jQuery("#guestJourney").multiselect("getChecked").map(function(){
		   return this.value;	
	}).get();
	var varLocHotel = jQuery("#locHotel").multiselect("getChecked").map(function(){
		   return this.value;	
	}).get();
	var varCorpDept = jQuery("#corpDept").multiselect("getChecked").map(function(){
		   return this.value;	
	}).get();
	var varWheelQuad = jQuery("#wheelQuadrant").multiselect("getChecked").map(function(){
		   return this.value;	
	}).get();
	var varMeasurement = jQuery("#measurement").multiselect("getChecked").map(function(){
		   return this.value;	
	}).get();
    var varGemReportCategory = jQuery("#gemReportCategory").multiselect("getChecked").map(function(){
        return this.value;   
    }).get();
    var varAreaForMeasurement = jQuery("#areaForMeasurement").multiselect("getChecked").map(function(){
        return this.value;   
    }).get();
	/*//Commented becuase of CR 50.2 
		var varHotelLifecycle = jQuery("#hotellifecycle").multiselect("getChecked").map(function(){
		   return this.value;	
	}).get(); */
	var varSpecialistArea = jQuery("#specialistarea").multiselect("getChecked").map(function(){
		   return this.value;	
	}).get();
	var varDigital = jQuery("#digital").multiselect("getChecked").map(function(){
		   return this.value;	
	}).get();
	var varBrandsafetystandards = jQuery("#brandsafetystandards").multiselect("getChecked").map(function(){
		   return this.value;	
	}).get();
	var varAttachType = jQuery("#attachmentType").multiselect("getChecked").map(function(){
		   return this.value;	
	}).get();
	var varChangeType = jQuery("#changeType").multiselect("getChecked").map(function(){
		   return this.value;	
	}).get();
    var varPlImpact = jQuery("#plImpact").multiselect("getChecked").map(function(){
		   return this.value;	
	}).get();
    var varChangeFromRegional = jQuery("#changeFromRegional").multiselect("getChecked").map(function(){
		   return this.value;	
	}).get();
	var varCapExImpact = jQuery("#capExImpact").multiselect("getChecked").map(function(){
		   return this.value;	
	}).get();
	var varImplementationImpact = jQuery("#implementationImpact").multiselect("getChecked").map(function(){
		   return this.value;	
	}).get();
	var varAssignImage = jQuery("table#filter_image_table input").map(function(){
	    return this.value;
	}).get();
	
	//CR 50.2 change
	var varHotelLifecycle = jQuery("#hotellifecycle").val();
	var varShowAllSpecsGuideline = jQuery("#showAllSpecsGuidelines").is(':checked') ? 'Y' : 'N';
	var varRationale = jQuery("#filterRationale").val();
	var varImpactComments = jQuery("#impactComments").val();
	var varFilterText = jQuery("#filterText").val(); 
	var varHasLinks = jQuery("#hasLinks").is(':checked')?'Y':'N';
	var varHasGuidelines = jQuery("#hasGuidelines").is(':checked')?'Y':'N';
    var varOutsideofGuestJourney = jQuery("#outsideofGuestJourney").is(':checked') ? jQuery("#outsideofGuestJourney").val() : "";
	var varIndexHeading =jQuery("#indexHeading").val();
    var varInternalReference =jQuery("#internal_reference").val();
    var varRecordId = jQuery("#recordId").val();
    if (varRecordId != null && varRecordId.length > 0)
    {
    	varRecordId = varRecordId.replace(/[^0-9 ]+/g, '').trim();
        varRecordId = varRecordId.replace(/\s{2,}/g, ' ').trim();
        jQuery("#recordId").val(varRecordId);
    }
    var varAuditLog = jQuery("#auditLogFilter").is(':checked')? 'Y' : 'N';
    var varCreatedBy = jQuery("#logCreatedBy").val();
    var varLogCriteria = jQuery("#logRelativeCriteria").val();
    var varLogDate = jQuery("#auditLogDate").val();
    var varBranchSearch = jQuery("input[name='branchSearch']").filter(':checked').val();
	var varHistManual = jQuery("#historicalManual").val();
	var varBrndHallmark = jQuery("#brandHallmark").is(':checked')?'Y':'N';
	var varCrossReference = jQuery("#hasCrossReference").is(':checked')?'Y':'N';
	var varManual = jQuery("#manual").val();
	var varSearchOptions = jQuery("#searchOptions").val();
	var varEnteredBy = jQuery("#enteredBy").val();
    var url = '<%=stdCountUrl%>';
	var theUrl = url;
    var indx = url.indexOf("&_StandList_");
    if (indx > 0)
    {
        theUrl = url.substr(0, indx);
    }
    //validateAuditLog();
	var divname = "#searchCounter";
	var postData = {<%=StandardsUtil.REQUEST_PARAM_HIDDEN_IMAGES%>:varAssignImage,brand:varBrand,branchSearch:varBranchSearch,outsideofGuestJourney:varOutsideofGuestJourney,selectedcountries:varSelectedcountries,showAllSpecsGuidelines:varShowAllSpecsGuideline,filterText:varFilterText,filterRationale:varRationale,status:varStatus,indexHeading:varIndexHeading,recordId:varRecordId,techWriter:varTechWriter,stdOwner:varStdOwner,category:varCategory,brandHallmark:varBrndHallmark,deptApp:varDeptAppl,importance:varImportance,guestJourney:varGuestJourney,locHotel:varLocHotel,manual:varManual,corpDept:varCorpDept,wheelQuad:varWheelQuad,measurement:varMeasurement,gemReportCategory:varGemReportCategory,areaForMeasurement:varAreaForMeasurement,hotellifecycle:varHotelLifecycle,specialistarea:varSpecialistArea,digital:varDigital,brandsafetystandards:varBrandsafetystandards,attachType:varAttachType,hasLinks:varHasLinks,hasGuidelines:varHasGuidelines,changeType:varChangeType,historicalManual:varHistManual,plImpact:varPlImpact,changeFromRegional:varChangeFromRegional,capExImpact:varCapExImpact,implementationImpact:varImplementationImpact,impactComments:varImpactComments,searchOptions:varSearchOptions,auditLogFilter:varAuditLog,logCreatedBy:varCreatedBy,logRelativeCriteria:varLogCriteria,auditLogDate:varLogDate,enteredBy:varEnteredBy,hasCrossReference:varCrossReference,internal_reference:varInternalReference};
	
	jQuery.ajax({
	    type: "POST",
	    url: theUrl,
	    data: postData
	}).done( function(data) {
	    jQuery(divname).html(data);
	}).fail( function(jqXHR) {
        //alert("AJAX request failed with status:" + jqXHR.statusText + " status code:" + jqXHR.status);
	});
}

function runFullReport(reportId){
    var url = '<%=varExportFullReport%>';
    var indx = url.indexOf("&_StandList_WAR_BSAdminportlet_INSTANCE_");
    if (indx > 0)
    {
        url = url.substr(0, indx);
    }
	var secLang = jQuery("#report_lang_select option:selected");
	var secLangCd = jQuery(secLang).val();
	var secLangDesc = jQuery(secLang).text();
    var reportTitle = jQuery("#reportTitle").val();
    var postData = {reportId:reportId,reportTitle:reportTitle};
	if (secLangCd)
	{
        postData = {reportId:reportId,reportTitle:reportTitle,secLangCd:secLangCd,secLangDesc:secLangDesc};
	}
    submitReportRequest(url, postData);
    return false;
}

function runContentReport(reportId){
    var url;
    if(reportId==147){
    	url = '<%=varExportAttachmentLinksReport %>';
    }else{
    	url = '<%=varExportReport%>';
    }
    var indx = url.indexOf("&_StandList_WAR_BSAdminportlet_INSTANCE_");
    if (indx > 0)
    {
        url = url.substr(0, indx);
    }
	var secLang = jQuery("#report_lang_select option:selected");
	var secLangCd = jQuery(secLang).val();
	var secLangDesc = jQuery(secLang).text();
    var reportTitle = jQuery("#reportTitle").val();
    var postData = {reportId:reportId,reportTitle:reportTitle};
	if (secLangCd)
	{
        postData = {reportId:reportId,reportTitle:reportTitle,secLangCd:secLangCd,secLangDesc:secLangDesc};
	}
	if(reportId==147){
		var reportType = jQuery("#reportType").val();
		var reportBrands = jQuery("#reportBrands").val().toString();
		postData = {reportId:reportId,reportTitle:reportTitle,reportBrands:reportBrands,reportType:reportType};
	}
    submitReportRequest(url, postData);
    return false;
}

function getCurrentValue(stdId, obj)
{
	jQuery("#statusValue").val(obj.value);
	statusCurrValue = obj.value;
	
}

//CR 45
function runExportTranslationReport(exportLang,exportReportTitle){
    var url = '<%=varExportTranslationReport%>';
    var indx = url.indexOf("&_StandList_WAR_BSAdminportlet_INSTANCE_");
    if (indx > 0)
    {
        url = url.substr(0, indx);
    }
    var postData = "";
	if (exportLang)
	{
        postData = {reportId:"29",langCd:exportLang, reportTitle:exportReportTitle };
	}
	
	submitReportRequest(url, postData);
	$('#file').val('');
	$('#export_lang').val('');
	$('#import_lang').val('');
	$('#export_report_title').val('');
	$(".translation").hide();
    return false;
}

function runImportTranslationReport(importLang, file){
    var url = '<%=varImportTranslationReport%>';
    var indx = url.indexOf("&_StandList_WAR_BSAdminportlet_INSTANCE_");
    if (indx > 0)
    {
        url = url.substr(0, indx);
    }
    var postData = "";
	if (importLang && file)
	{
        postData = {reportId:"30",langCd:importLang, fileName: file};
	}
	
	jQuery("#overlay").fadeIn();
	$.ajaxFileUpload
	(
	{
    	secureuri : false,
    	fileElementId : 'file',
    	data: postData,
        url: url,
        success: function (data, status)
		{
            jQuery("#overlay").fadeOut();
            jQuery.msgBox({
                type:"info",
                content:"An email with a link to your Report will be sent to you once the Report has been generated. \n" +
//                      "This Report containing the results above will only be available for 7 days from when you receive the e-mail.",
                        "This Report will only be available for 7 days from when you receive the e-mail.",
                buttons: [{ value: "OK" }]
            });
            $('#file').val('');
            $('#export_lang').val('');
            $('#import_lang').val('');
			$('#export_report_title').val('');
            $(".translation").hide();
        },
		error: function (data, status, e) {
            jQuery("#overlay").fadeOut();
            //alert("AJAX request failed with status:" + jqXHR.statusText + " status code:" + jqXHR.status);
        }
	})
    return false;
}

$(document).ready(function(){
	$('#export_lang').change(function(){
		if (this.value != "-1") {
			$(".process_btn").removeClass("disable_a_href");
		} else {
			$(".process_btn").addClass("disable_a_href");
		}
		 $('#file').val('');
         $('#import_lang').val('');
		
	});
	$('#import_lang').change(function(){
		if (this.value != "-1") {
			var file =$('#file').val();
			if (file!="") {
				$(".process_btn").removeClass("disable_a_href");
			}
		} else {
			$(".process_btn").addClass("disable_a_href");
		}
		 $('#export_lang').val('');
	});
	
	$('#file').change(function(){
		if (this.value!= "") {
			var ext = this.value.match(/\.([^\.]+)$/)[1];
	        switch(ext)
	        {
	            case 'xls':
	            	var lang =$('#import_lang').val();
	    			if (lang!="-1") {
	    				$(".process_btn").removeClass("disable_a_href");
	    			}
	                break;
	            case 'xlsm':
	            	var lang =$('#import_lang').val();
	    			if (lang!="-1") {
	    				$(".process_btn").removeClass("disable_a_href");
	    			}
	                break;
	            default:
	            	$(".process_btn").addClass("disable_a_href");
	            	//alert('Only files with following extensions are allowed: xls, xlsm');
	            	jQuery.msgBox({
	                    type:"info",
	                    content:"Only files with following extensions are allowed: xls, xlsm",
	                    buttons: [{ value: "OK" }]
	                });
	                this.value='';
	        }
			
		} else {
			$(".process_btn").addClass("disable_a_href");
		}
		 $('#export_lang').val('');
	});
});

//CR 45 END

/* TODO - this is cuonter for Comments text area
jQuery(function() {
    
	jQuery('#cmt_txt_area').jqEasyCounter({
	    'maxChars': 2000,
	    'maxCharsWarning': 1900,
	    'msgFontColor': '#FFF',
	    'msgFontSize': '11px',
	    'msgTextAlign': 'left',
	    'msgWarningColor': '#F00',
	    'msgAppendMethod': 'insertBefore'               
	});
});
*/

</script>
<!--ends opening scripts -->

<liferay-portlet:renderURL varImpl="searchURL"></liferay-portlet:renderURL>

<aui:form action="<%= searchURL %>" method="post" name="filterForm" onSubmit="selectAllToSubmit()">
   <aui:input type="hidden" id="clearFilter" name="clearFilter" value="false"/>
   <aui:input type="hidden" id="applyButton" name="applyButton" value="false"/>
   <aui:input type="hidden" id="statusValue" name="statusValue" />
   <input type="hidden" name="<%=StandardsUtil.REQUEST_PARAM_HIDDEN_IMAGES%>" id="<%=StandardsUtil.REQUEST_PARAM_HIDDEN_IMAGES%>" value="" />
   
    <%
    PortletURL itUrl = renderResponse.createRenderURL();
    SearchContainer listContainer = (SearchContainer)request.getAttribute("searchContainer");
    String prefBrandCode = (String)request.getAttribute("preferBrand");
	long companyId = themeDisplay.getCompanyId();
	long currentUserId = themeDisplay.getUser().getUserId();
	List<Role> arlCurrentUserRoles = RoleLocalServiceUtil.getUserRoles(currentUserId);
  	Map<String, String> chnCdMap = BrandStandardsUtil.chainCodeMap();
    boolean allowExportReport = StandardsUtil.validAuthor(arlCurrentUserRoles);
    boolean isPublishAdmin = StandardsUtil.isPublishAdmin(arlCurrentUserRoles);
    boolean isSuperAdmin = StandardsUtil.isSuperAdmin(arlCurrentUserRoles);
	Map<String, String> fileTypes = StandardsUtil.fileTypes();
	boolean flag = request.isUserInRole(BrandStandardsUtil.AUTHORS_AMER_ROLE);
	List<StandardsStatus> uniqueStatusList = StandardsStatusUtil.getStatuses(user, true, isSuperAdmin, regionCode);
	Map<String, String> categoryMap = StandardsUtil.categoryMap();
    Map<String, String> changeMap = StandardsUtil.changeMap();
	int standardsCount = 0;
	if(request.getAttribute("standardsCount")!=null)
	{
		standardsCount = (Integer)request.getAttribute("standardsCount");
	}
    %>
   
	<div <c:choose><c:when test='<%=isSuperAdmin && !regionCode.equals("GLBL")%>'> class='rounded_container stagingContent'</c:when> <c:otherwise>class='rounded_container'</c:otherwise></c:choose> >
		<div class="rounded_container_contents stdlist_main">
			<h4 class="short_page_subtitle">Standards</h4>
			<%if (allowExportReport) {
			 // <!-- CR 45 START -->
					String userRgnCode = StandardsController.getRegionCodeFromUserRole(user.getRoles());
					long regionId = StandardsRegionLocalServiceUtil.getStandardsRegionByRegionCode(userRgnCode).getRegionId();
					List<StandardsRegionLocale> regionLocales =	StandardsRegionLocaleLocalServiceUtil.getStandardsRegionLocaleByRegionId(regionId);
					%>
					<div class="report_container">
						<c:set var="count" value="<%=listContainer.getTotal() %>"/>
						<c:if test="${count gt 0 }">
							<div class="button report_run_btn "><a href="#" class="open_translation">Translation</a><span></span></div>
						</c:if>
						<c:if test="${count eq 0 }">
						<div class="button report_run_btn disable_a_href"><a href="#" class="open_translation">Translation</a><span></span></div>
						</c:if>
		                <div class="translation">
		                    
		                    <div class="report_accordion">
		                        <div class="accordionButton" id="open_translation">Expand <span class="accordion_sm_txt">Export</span></div>
		                        <div class="accordionContent">
		                            <p class="report_instructions">Select a second language for this report: </p>
		                            <select id="export_lang">
		                            	<option value="-1"> Select </option>
		                            	<% for(StandardsRegionLocale stdRgnLcl :regionLocales) { %>
		                        		<option value="<%=stdRgnLcl.getLocaleCode()%>"  ><%= StandardsLocaleLocalServiceUtil.getStandardsLocale(stdRgnLcl.getLocaleCode()).getLocaleName()%></option>
		                        	<% } %>
		                            </select>
		                            <p class="report_instructions">An email with a link to your Report will be send to you once the Report has been generated. This Report will only be available for 7 days from when you receive the e-mail.</p>
									<p class="report_instructions"><a title="help icon tooltip" href="javascript:return false;" class="help_icon tooltip"><img title="help" alt="help icon" src="/BSTheme-theme/images/help.png"> <span class="classic">Your report will be emailed to you on completion. Should you wish to provide a title for your report please add text to the 'Report Title' text box. This is useful when requesting multiple reports to help you distinguish between the emails and files when you receive them in your inbox.</span></a>Report Title:</p>
		                            <div class="report_name_div" id="aui_3_2_0_1822"> <input type="text" title="Report Title" maxlength="250" size="50" class="report_name" id="export_report_title" name="export_report_title"> </div>
		                        </div>
		                        <div class="accordionButton">Expand <span class="accordion_sm_txt">Import</span></div>
		                        <div class="accordionContent">
		                        	<%-- <form action="<%= varImportTranslationReport %>" enctype="multipart/form-data" method="post" name="importfm" id="importfm"> --%>
		                            <p class="report_instructions">This import contains translation for:</p> <select id="import_lang">
		                            	<option value="-1"> Select </option>
		                            	<% for(StandardsRegionLocale stdRgnLcl :regionLocales) { %>
		                        		<option value="<%=stdRgnLcl.getLocaleCode()%>"  ><%= StandardsLocaleLocalServiceUtil.getStandardsLocale(stdRgnLcl.getLocaleCode()).getLocaleName()%></option>
		                        	<% } %>
		                            </select> 
		                            <p class="report_instructions">Select File: </p> <input id="file" name="file" type="file"  accept="application/vnd.openxmlformats-officedocument.spreadsheetml.sheet,application/vnd.ms-excel"/> <br/>
		    
		                           <p class="report_instructions"> The results of this import will be emailed to you.</p>
		                            <!-- </form> -->
		                        </div>
		                    </div>
		                    <div class="clear"></div>
		                    <div class="button report_run process_btn disable_a_href"><a href="javascript;" class="process disable_a_tag" title="Run Report">Process</a><span></span></div>
		                    <div class="button report_run"><a href="#" class="cancel_translation" title="Cancel Report">Cancel</a><span></span></div>
		                </div>
		            </div>
			<!--CR 45  END-->
			<%
			
			List<ReportConfig> reportConfigs = (List<ReportConfig>) request.getAttribute("reportConfigs"); %>
            <div class="report_container">
                <div class="button report_run_btn"><a href="#" class="open_reports">Run a Report</a><span></span></div>
				<div class="reports">
                    <p class="report_instructions">Choose a report, then click 'run'. <br/>Only one report can be run at a time.</p>
                    <div class="report_accordion">
                        <div class="accordionButton" id="open">Content Specific Reports</span></div>
                        <div class="accordionContent">
                            <ul>
                            <%for (ReportConfig entry : reportConfigs) { 
                                if ("StandardAdmin".equals(entry.getFeature()) && "SingleBrand".equals(entry.getQualifier()) && !"GL".equalsIgnoreCase(prefBrandCode)) { 
                                %>
                                <li>
                                    <input type="radio" class="report_checkbox" value="<%=entry.getId() %>" name="export_report" id="content_report_<%=entry.getId()%>" require_locale="<%=entry.isRequireSecondLang()%>" report_type="content_report" title="Content Report: <%=entry.getName() %>" />
                                    <label for="content_report_<%=entry.getId()%>" class="report_label"><%=entry.getName() %></label>
                                </li>
                                <%        
                                }
                                else if (isSuperAdmin && "AllBrandSuperAdmin".equals(entry.getQualifier()) && "GL".equals(prefBrandCode) ) { 
                                %>
                                <li>
                                    <input type="radio" class="report_checkbox" value="<%=entry.getId() %>" name="export_report" id="content_report_<%=entry.getId()%>" require_locale="<%=entry.isRequireSecondLang()%>" report_type="content_report" title="Content Report: <%=entry.getName() %>" />
                                    <label for="content_report_<%=entry.getId()%>" class="report_label"><%=entry.getName() %></label>
                                </li>
                                <%
                                }                                
                                else if ("StandardAdmin".equals(entry.getFeature()) && BrandStandardsUtil.IsNullOrBlank(entry.getQualifier()))  { 
                                %>
                                <li>
                                    <input type="radio" class="report_checkbox" value="<%=entry.getId() %>" name="export_report" id="content_report_<%=entry.getId()%>" require_locale="<%=entry.isRequireSecondLang()%>" report_type="content_report" title="Content Report: <%=entry.getName() %>" />
                                    <label for="content_report_<%=entry.getId()%>" class="report_label"><%=entry.getName() %></label>
                                </li>
                                <%  
                                }
                              }%>
                            </ul>
                        </div>
                    </div>
                    <div class="clear"></div>
                    <div class="report_lang_select_div">
                        <p class="report_instructions"><a class="help_icon tooltip" href="javascript:return false;" title="help icon tooltip"><img src="/BSTheme-theme/images/help.png" alt="help icon" title="help"/>
                                <span class="classic">Your report will be emailed to you on completion. Should you wish to provide a title for your report please add text to the 'Report Title' text box. This is useful when requesting multiple reports to help you distinguish between the emails and files when you receive them in your inbox.</span></a>Report Title:</p>
                        <div class="report_name_div">
                            <input type="text" name="reportTitle" id="reportTitle" class="report_name" size="50" maxlength="250" title="Report Title" />
                        </div>
                        <div class="clear"></div>
                        <div class="attachmentLinkFields" style="display:none;">
                        	<p class="report_instructions"><a class="help_icon tooltip" href="javascript:return false;" title="help icon tooltip"><img src="/BSTheme-theme/images/help.png" alt="help icon" title="help"/>
                                <span class="classic">Select Brand Instruction...</span></a>Select Brand<em class="required">* </em>:</p>
							<select id="reportBrands" class="multis applicable_filter" name="reportBrands" multiple="multiple" title="Brands">
							<%	
								
								for(String chncode : chnCdMap.keySet())
								{	
								    if(!BrandStandardsUtil.isNullOrBlank(arlBrands))
									{   
											if(arlBrands.contains(chncode))
											{
											%>
												<option value='<%=chncode%>' selected="true"><%=chnCdMap.get(chncode)%></option> 
											<%}
											else
											{
											%>
												<option value='<%=chncode%>'><%=chnCdMap.get(chncode)%></option> 
										  <%}
									}
									else
									{
									%>	
									 <option value='<%=chncode%>'><%=chnCdMap.get(chncode)%></option> 
								  <%}
								}%> 
							</select>
                                                            
                            <p class="report_instructions"><a class="help_icon tooltip" href="javascript:return false;" title="help icon tooltip"><img src="/BSTheme-theme/images/help.png" alt="help icon" title="help"/>
                                <span class="classic">Select Report Instruction...</span></a>Select Report:</p>
                            <p><select class="report_brand_select" id="reportType" name="reportType">
                            		<option value="links">Links Only</option>
                            		<option value="attachments">Attachments Only</option>
	                               <option value="linksAndAttachments">Links and Attachments</option></select></p>
                                
                        </div>
                        <div class="otherReportFields">
                        	<p class="report_instructions">Select a second language for this report:</p>
	                        <p><select class="report_lang_select" id="report_lang_select">
	                               <option value="">Select One</option>
	                             <%
	                               List<StandardsLocale> stdLocales = StandardsLocaleLocalServiceUtil.getStandardsLocales(-1,  -1);
	                               for (StandardsLocale stdLocale : stdLocales)
	                               {
	                                   if ("Y".equals(stdLocale.getIsActive())) 
	                                   { %>
	                                   <option value="<%=stdLocale.getLocaleCode() %>"><%=stdLocale.getLocaleName() %></option>
	                             <%    }
	                              }%>
	                        </select></p>
                        </div>
                        
                        <div class="divider"></div>
                    </div>    
                    <% 
                    	String sPath = "#";
                    	String environment = System.getProperty("app.environment.type") != null ? System.getProperty("app.environment.type").trim() : "ENVIRONMENT_PROD";
	                    if ("ENVIRONMENT_QA".equals(environment))
	                    {
	                    	sPath = "/brandstandards/qa/downloads/manuals/BrandStandardsImageCatalog.pdf";
	                    } else if("ENVIRONMENT_PROD".equals(environment)) 
	                    {
	                    	sPath = "/brandstandards/downloads/manuals/BrandStandardsImageCatalog.pdf";
	                    }                    
                    %>
                    <div class="button image_catalog"><a href="<%=sPath%>" target="_blank" class="run_image_catalog" title="Run Image Catalogue">Image Catalogue</a><span></span></div>
                    <div class="button report_run"><a href="#" class="run_reports" title="Run Report">Run</a><span></span></div>
                    <div class="button report_run"><a href="#" class="cancel_reports" title="Cancel Report">Cancel</a><span></span></div>
                </div>
				
            </div>
			<%} %>
			<div class="results_right_util result_utils">
                <%if(hasFilter)  
                  {%>
				<div class="button_red filter_results_button"><a href="#" class="results_filter" title="Filter Results">Filter Results</a><span></span></div>
                <%}
                  else
                  {%>
                <div class="button filter_results_button"><a href="#" class="results_filter" title="Filter Results">Filter Results</a><span></span></div>
                <%} %>
				<%if( StandardsUtil.validAuthor(user.getRoles()) || (isSuperAdmin && (regionCode!=null ||!regionCode.equals("NA"))))
					{%>
                    <a class="add_new_standard" href="/web/brand-standards/standard_wizard?<%=StandardsUtil.REQUEST_PARAM_PAGE_NUM%>=0" title="add new standard tooltip"><img class="add_icon" src="/BSTheme-theme/images/plus_icon.png" alt="add new standard icon" title="add new standard" /> Add New Standard</a>
				<%} %>
			</div>
            <div class="clear"></div>
            <div id="displayResultAllSpec" class="display_result_all_spec" <%if(!hasFilter){%>style="display:none;"<%}%> >
                <span class="disp_res_all_spec_lbl">Result Display:</span>
                <input type="checkbox" class="display_result_all_spec_check" name="showAllSpecsGuidelines" id="showAllSpecsGuidelines" value="Y"
                <%if(isShowAllSpecGuideline)
                {%>
                    checked="checked"
                <%}%>
                    onclick="showAllSpecGuideline()" title="Display Result All Spec Checkbox" />
                <span class="disp_res_all_spec_desc">Show all non-matching Specifications and Guidelines (for each Standard matching this filter criteria)</span>
            </div>
            <div class="clear"></div>
           <div id="searchCounter"> <p class="totals_display"><strong><%=standardsCount %></strong> Standards match this criteria</p></div>
			<div class="filter_results_form">
			
				<table class="filter_table" summary="Data table for filtered results">
					<tr>
						<td colspan="4"><p class="hidden_title_bar">Select Criteria to Filter by:</p></td>
					</tr>
					<tr>
						<td><p class="applicable_filter">Applicable Brands:</p></td>
						<td colspan="3">
							<select id="brand" class="multis applicable_filter" name="brand" multiple="multiple" title="Brands">
							<%	
								
								for(String chncode : chnCdMap.keySet())
								{	
								    if(!BrandStandardsUtil.isNullOrBlank(arlBrands))
									{   
											if(arlBrands.contains(chncode))
											{
											%>
												<option value='<%=chncode%>' selected="true"><%=chnCdMap.get(chncode)%></option> 
											<%}
											else
											{
											%>
												<option value='<%=chncode%>'><%=chnCdMap.get(chncode)%></option> 
										  <%}
									}
									else
									{
									%>	
									 <option value='<%=chncode%>'><%=chnCdMap.get(chncode)%></option> 
								  <%}
								}%> 
							</select>
						</td>
					</tr>
					<tr>
						<td><p class="applicable_filter">Applicable Regions:</p></td>
						<td>
							<select id="standard_regions" name="standard_regions" class="standard_regions_filter" multiple="multiple" size="4" title="Region">
							</select>
							<div class="clear_filter"></div>
						</td>
						<td class="filler_cell">&nbsp;</td>
						<td></td>
					</tr>
					<tr>
						<td>Click to Add Countries:</td>
						<td colspan="3" style="text-align:left;">
							<div class="countries_cont_left_filter">
								<a href="#" class="move_countries_filter" id="add_all_countries" title="Move All countries">Click here to add all countries</a>
								<select class="multi_add multi_sel_countries" name="selectfrom" id="select-from" multiple size="5" title="Select From">
								</select>
							</div>
							<div class="countries_cont_middle">
								<div class="add_remove_icons">
									<a class="move_item" href="JavaScript:void(0);" id="btn-add" title="add item">Add &raquo;</a>
									<a class="move_item" href="JavaScript:void(0);" id="btn-remove" title="remove item">&laquo; Remove</a>
								</div>
							</div>
							<div class="countries_cont_right_filter">
								<a href="#" class="remove_countries_filter" id="remove_all_countries" title="remove countries">Click here to remove all countries</a>
								<select class="multi_remove required multi_sel_countries" name="selectedcountries" id="selectedcountries" multiple size="5" title="SelectedCountries">
								
	                            </select>
							</div>
							<div class="clear_filter"></div>
						</td>
					</tr>
                    <tr>
                        <td><span>Standard, Specification, Guideline ID<a class="help_icon tooltip" href="javascript:return false;"><img src="/BSTheme-theme/images/help.png" alt="details" title="details"/>
                            <span class="classic">Enter a single Standard ID or a space seperated list of Standard ID's to filter based on Standard ID.</span></a></span>
                        </td>
                        <td colspan="2">
                            <input type="text" name="recordId" id="recordId" value="<%=strRecordId %>" class="filter_text" size="75" maxlength="2000" title="Standard, Specification or Guideline ID" />
                            <div class="clear_filter"></div>
                        </td>
                        <td>
                           <img class="clear_std_id" title="clear Standard Id" src="/BSTheme-theme/images/delete.png" alt="clear Standard Id"/>
                        </td>
                    </tr>
					<tr>
						<td>Standard, Specification or Guideline text</td>
						<td colspan="2">
							<input type="text" name="filterText" id="filterText" value="<%=strFilterValue %>" class="filter_text" size="75" maxlength="4000" title="Filter Text" />
						</td>
                        <td>
                           <img class="clear_std_text" title="clear Standard text" src="/BSTheme-theme/images/delete.png" alt="clear Standard text"/>
                        </td>
					</tr>
					<tr>
						<td>Standard text search options</td>
						<td colspan="2">
						<%if(strSearchOptions.equals("all")){ %>
							<input type="radio" name="searchOptions" id="searchOptions" value="all" class="standard_radio" checked="checked"> Search All Words 
							<span><a class="help_icon tooltip" href="javascript:return false;"><img src="/BSTheme-theme/images/help.png" alt="Search All Words help icon"/>
                            <span class="classic">Returns all content/words containing the search criteria. E.g. Search for "ice" returns content with service, device and ice within it.</span></a></span>
							&nbsp;&nbsp;&nbsp;
							
							<input type="radio" name="searchOptions" id="searchOptions" value="exact" class="standard_radio"> Match Exact Phrase 
							<span><a class="help_icon tooltip" href="javascript:return false;"><img src="/BSTheme-theme/images/help.png" alt="Match Exact Phrase help icon"/>
                            <span class="classic">Returns single words only containing the exact search criteria only. E.g. Search for "ice" returns "ice" only content.</span></a></span>
							&nbsp;&nbsp;&nbsp;

							<input type="radio" name="searchOptions" id="searchOptions" value="any" class="standard_radio"> Match Any of the Words 
							<span><a class="help_icon tooltip" href="javascript:return false;"><img src="/BSTheme-theme/images/help.png" alt="Match Any of the Words help icon"/>
                            <span class="classic">Returns content containing the exact search criteria on multiple words/phrases. E.g. Search for "ice bucket" returns content with "Ice", "bucket" and or "ice bucket" within it.</span></a></span>
							&nbsp;&nbsp;&nbsp;

						<%} else if(strSearchOptions.equals("exact")){ %>
							<input type="radio" name="searchOptions" id="searchOptions" value="all" class="standard_radio" > Search All Words 
							<span><a class="help_icon tooltip" href="javascript:return false;"><img src="/BSTheme-theme/images/help.png" alt="Search All Words help icon"/>
                            <span class="classic">Returns all content/words containing the search criteria. E.g. Search for "ice" returns content with service, device and ice within it.</span></a></span>
							&nbsp;&nbsp;&nbsp;
							
							<input type="radio" name="searchOptions" id="searchOptions" value="exact" class="standard_radio" checked="checked"> Match Exact Phrase 
							<span><a class="help_icon tooltip" href="javascript:return false;"><img src="/BSTheme-theme/images/help.png" alt="Match Exact Phrase help icon"/>
                            <span class="classic">Returns single words only containing the exact search criteria only. E.g. Search for "ice" returns "ice" only content.</span></a></span>
							&nbsp;&nbsp;&nbsp;

							<input type="radio" name="searchOptions" id="searchOptions" value="any" class="standard_radio"> Match Any of the Words 
							<span><a class="help_icon tooltip" href="javascript:return false;"><img src="/BSTheme-theme/images/help.png" alt="Match Any of the Words help icon"/>
                            <span class="classic">Returns content containing the exact search criteria on multiple words/phrases. E.g. Search for "ice bucket" returns content with "Ice", "bucket" and or "ice bucket" within it.</span></a></span>
							&nbsp;&nbsp;&nbsp;
						<%} else if(strSearchOptions.equals("any")){ %>
							<input type="radio" name="searchOptions" id="searchOptions" value="all" class="standard_radio"> Search All Words 
							<span><a class="help_icon tooltip" href="javascript:return false;"><img src="/BSTheme-theme/images/help.png" alt="Search All Words help icon"/>
                            <span class="classic">Returns all content/words containing the search criteria. E.g. Search for "ice" returns content with service, device and ice within it.</span></a></span>
							&nbsp;&nbsp;&nbsp;
							
							<input type="radio" name="searchOptions" id="searchOptions" value="exact" class="standard_radio"> Match Exact Phrase 
							<span><a class="help_icon tooltip" href="javascript:return false;"><img src="/BSTheme-theme/images/help.png" alt="Match Exact Phrase help icon"/>
                            <span class="classic">Returns single words only containing the exact search criteria only. E.g. Search for "ice" returns "ice" only content.</span></a></span>
							&nbsp;&nbsp;&nbsp;

							<input type="radio" name="searchOptions" id="searchOptions" value="any" class="standard_radio" checked="checked"> Match Any of the Words 
							<span><a class="help_icon tooltip" href="javascript:return false;"><img src="/BSTheme-theme/images/help.png" alt="Match Any of the Words help icon"/>
                            <span class="classic">Returns content containing the exact search criteria on multiple words/phrases. E.g. Search for "ice bucket" returns content with "Ice", "bucket" and or "ice bucket" within it.</span></a></span>
							&nbsp;&nbsp;&nbsp;
						<%}else{ %>
							<input type="radio" name="searchOptions" id="searchOptions" value="all" class="standard_radio" checked="checked"> Search All Words 
							<span><a class="help_icon tooltip" href="javascript:return false;"><img src="/BSTheme-theme/images/help.png" alt="Search All Words help icon"/>
                            <span class="classic">Returns all content/words containing the search criteria. E.g. Search for "ice" returns content with service, device and ice within it.</span></a></span>
							&nbsp;&nbsp;&nbsp;
							
							<input type="radio" name="searchOptions" id="searchOptions" value="exact" class="standard_radio"> Match Exact Phrase 
							<span><a class="help_icon tooltip" href="javascript:return false;"><img src="/BSTheme-theme/images/help.png" alt="Match Exact Phrase help icon"/>
                            <span class="classic">Returns single words only containing the exact search criteria only. E.g. Search for "ice" returns "ice" only content.</span></a></span>
							&nbsp;&nbsp;&nbsp;

							<input type="radio" name="searchOptions" id="searchOptions" value="any" class="standard_radio"> Match Any of the Words 
							<span><a class="help_icon tooltip" href="javascript:return false;"><img src="/BSTheme-theme/images/help.png" alt="Match Any of the Words help icon"/>
                            <span class="classic">Returns content containing the exact search criteria on multiple words/phrases. E.g. Search for "ice bucket" returns content with "Ice", "bucket" and or "ice bucket" within it.</span></a></span>
							&nbsp;&nbsp;&nbsp;
						<%} %>
						</td>
                        <td></td>
					</tr>
					
					<tr class="submit_basic_filter">
						<td></td>
						 <td>
							<aui:button name="submitButton" type="button" value="apply filter"  class="apply_filter_button" onClick="javascript:showFilter();"/>
							<aui:button type="button" onClick="javascript:cancelFilter();" value="cancel filter" class="cancel_filter_button"  />
						</td>
						<td class="filler_cell"><input  type="button" name="advancedFilter" value="advanced filter" class="adv_filter_button" title="Advance Filter"/></td>
                        <td></td>
					</tr>
				</table>
				<div class="advanced_filtering">
				    <table class="filter_table" summary="Filter Table">
					  <div class="divider">&nbsp;</div>
					  <tr>
				            <td colspan="3"><p class="hidden_title_bar">Advanced Filtering</p></td>
                            <td></td>
				          </tr>
				          <tr>
				          <td><p class="applicable_filter">Choose An Image To Show Its Associated Items:</p></td>
				          <td colspan = "2">
				              <div class="choose_image_space"><span>&nbsp;</span></div>
				              <div class="button choose_image_button" id="choose_img_button"><a href="#" class="choose_image" title="Assign Images button">Choose Images</a><span></span></div>
				              <table class="filter_image_table" id="filter_image_table" summary="table for image filtering">
                                  <tr class="results_header_bar">
                                      <td colspan="2">Your Image Selections - Each Associated Standard, Specification or Guideline will display in the results</td>
                                  </tr>
                                  <% Map<String, String> imageMap = stdSearchCriteria == null ? null : stdSearchCriteria.getImage();
				                  if (!BrandStandardsUtil.isNullOrBlank(imageMap))
				                  {
                                      for(Entry<String, String> img : imageMap.entrySet())
                                      { %>
                                  <tr class="table_links_list">
                                      <td class="img_select_table_cell1 this_link"><%=img.getValue() %><input type="hidden" class="image_id" value="<%=img.getKey() %>===<%=img.getValue() %>" /></td>
                                      <td><img class="delete_this_image" title="delete image" src="/BSTheme-theme/images/delete.png" alt="delete image"/></td>
                                  </tr>
                                  <%  }
				                  } %>
				              </table>
                              <div class="choose_image_space"><span>&nbsp;</span></div>
				          </td>
				          <td></td>
				          </tr>
				          <tr>
				          <td><p class="applicable_filter">Show Content Entered By:</p></td>
				          <td colspan = "2"> 
				          <select id="enteredBy" class="single_select " name="enteredBy"  title="EnteredBy">
				          <option value="">Select</option>
				          <%if(strEnteredBy.equals("GLBL") )
				          { %>
				          <option value="GLBL" selected = "selected">Global</option>
				          <%}else{ %>
				          <option value="GLBL" >Global</option>
				          <%} %>
				           <%if(strEnteredBy.equals("AMEA") )
				          { %>
				          <option value="AMEA" selected = "selected">AMEA</option>
				          <%}else{ %>
				          <option value="AMEA" >AMEA</option>
				          <%} %>
				           <%if(strEnteredBy.equals("AMER") )
				          { %>
				          <option value="AMER" selected = "selected">Americas</option>
				          <%}else{ %>
				          <option value="AMER" >Americas</option>
				          <%} %>
				           <%if(strEnteredBy.equals("EURO") )
				          { %>
				          <option value="EURO" selected = "selected">Europe</option>
				          <%}else{ %>
				          <option value="EURO" >Europe</option>
				          <%} %>
				           <%if(strEnteredBy.equals("GC") )
				          { %>
				          <option value="GC" selected = "selected">Greater China</option>
				          <%}else{ %>
				          <option value="GC" >Greater China</option>
				          <%} %>
				          </select>
				          </td>
                          <td></td>
				          </tr>
				          
						<tr>
							<td><p class="applicable_filter">Rationale:</p></td>
							<td colspan = "2">
                                <input type="text" name="filterRationale" id="filterRationale"  value="<%=rationale %>" class="adv_filter_text" size="75" maxlength="4000" title="Rationale" />
							</td>
                            <td>
                               <!-- <img class="clear_rationale" title="clear Rationale" src="/BSTheme-theme/images/delete.png" alt="clear Rationale"/> -->
                            </td>
						</tr>
						<tr>
							<td>  <p class="applicable_filter" >Select Index Heading:</p></td>
							<td colspan="2">
							   <input type="text" value="<%=indexHeader%>" id="tree_selection" class="input_text open_tree_selection" size="75" readonly="readonly" title="Select Index" />
                    	       <input type="hidden" value="<%=strIndex%>" id="indexHeading" name="indexHeading"  />
							</td>
							<td>
                               <img class="clear_this_index" title="clear index" src="/BSTheme-theme/images/delete.png" alt="clear index"/>
                            </td>
						</tr>
                        <tr>
                            <td></td>
                            <td colspan="2">
                               <%
                               boolean disabled = false;
                               if(BrandStandardsUtil.IsNullOrBlank(strIndex))
                               {
                                   disabled = true;
                               }
                               if(disabled)
                               {%>
                                   <span class="applicable_radio_filter">Just this Index point</span>
                                   <input type="radio" class="input_radio_filter" name="branchSearch" id="branchOnly" value="branchOnly" checked="checked" disabled="disabled"onchange="showFilterCount()" title="Seach on selected branch only, excluding children" />
                                   <span class="applicable_radio_filter">From this Index point down</span>
                                   <input type="radio" class="input_radio_filter" name="branchSearch" id="branchAndChildren" value="branchAndChildren" disabled="disabled" onchange="showFilterCount()" title="Seach on selected branch only, including children" />
                               <%}
                               else if("Y".equals(strBranchOnly))
                               {%>
                                   <span class="applicable_radio_filter">Just this Index point</span>
                                   <input type="radio" class="input_radio_filter" name="branchSearch" id="branchOnly" value="branchOnly" checked="checked" onchange="showFilterCount()" title="Seach on selected branch only, excluding children" />
                                   <span class="applicable_radio_filter">From this Index point down</span>
                                   <input type="radio" class="input_radio_filter" name="branchSearch" id="branchAndChildren" value="branchAndChildren" onchange="showFilterCount()" title="Seach on selected branch only, including children"/>
                               <%}
                               else
                               {%>
                                   <span class="applicable_radio_filter">Just this Index point</span>
                                   <input type="radio" class="input_radio_filter" name="branchSearch" id="branchOnly" value="branchOnly" onchange="showFilterCount()" title="Seach on selected branch only, excluding children" />
                                   <span class="applicable_radio_filter">From this Index point down</span>
                                   <input type="radio" class="input_radio_filter" name="branchSearch" id="branchAndChildren" value="branchAndChildren" checked="checked" onchange="showFilterCount()" title="Seach on selected branch only, including children" />
                               <%}%>
                            </td>
                            <td></td>
                        </tr>
						<tr>
							<td><p class="applicable_filter">Status:</p></td>
							<td colspan="2">
								<select id="searchStatus" class="multis applicable_filter" name="searchStatus" multiple="multiple" title="Status">
								<%	for(StandardsStatus stdStatus : uniqueStatusList)
								{
								    if("true".equals(discontFilter) && (stdStatus.getStatusCode().equals("D_FOR_REF") || stdStatus.getStatusCode().equals("D_NOT_RQ") || stdStatus.getStatusCode().equals("D_RPLCD")))
								    {
								        continue;
								    }
								    if(!BrandStandardsUtil.isNullOrBlank(arlStatus))
									{ 
										if(arlStatus.contains(stdStatus.getStatusCode()))
										{%>
											<option value='<%=stdStatus.getStatusCode()%>' selected="true"><%=stdStatus.getTitle()%></option> 
									  <%}
										else
										{%>
											<option value='<%=stdStatus.getStatusCode()%>'><%=stdStatus.getTitle()%></option> 
									  <%}
									}
									else
									{%>	
									 <option value='<%=stdStatus.getStatusCode()%>'><%=stdStatus.getTitle()%></option> 
								  <%}
								}%>
								</select>
							</td>
                            <td></td>
						</tr>
						                         <tr>
                            <td><p class="applicable_filter">Audit Log Filter:</p></td>
                            <td colspan = "2">
                            <%if(strSearchLog.equals("Y"))
                            {%>
                              <input type="checkbox" class="input_checkbox_filter" name="auditLogFilter" id="auditLogFilter" value="Y"  checked="checked"  title="Audit Log Filter" />   
                          <%}
                            else
                            {%>
                                <input type="checkbox" class="input_checkbox_filter" name="auditLogFilter" id="auditLogFilter" value="Y"  title="Audit Log Filter" "/>
                          <%}%>


                                <span style="width:15px"> &nbsp;</span>
                                <select id="logCreatedBy"  class="single_select required" name="logCreatedBy" style="width:240px; padding:3px; height:26px;" title="Log created by" onchange="showFilterCount()">
                                <option value="">Changes By ...</option>
                               <%for(int i=0;i<arlUsers.size();i++) 
                               {
                            	   String userIdName[] = arlUsers.get(i).split(":");
                                	if(strLogCreatedBy.equals(userIdName[0])){
                                %>
                              		<option value="<%=userIdName[0]%>" selected="selected"><%=userIdName[1]%></option>
                              	<%} 
                                	else{%>
                                		<option value="<%=userIdName[0]%>" ><%=userIdName[1]%></option>
                                	<%}
                               }
                              	%>
                                </select>

                                <span style="width:15px"> &nbsp;</span>
                                <select id="logRelativeCriteria"  class="single_select required" name="logRelativeCriteria" style="width: 120px; padding:3px; height:26px;" title="Log Relative Criteria" onchange="showFilterCount()">
	                               <option value="" >Select</option>
	                                <%if(strLogCriteria.equals("lastDay")){ %>
	                                <option value="lastDay" selected="selected">In Last 24 Hours</option>
	                                <%}else{ %>
	                                <option value="lastDay">In Last 24 Hours</option>
									 <%} %>
	                                <%if(strLogCriteria.equals("since")){ %>
	                                <option value="since" selected="selected">Since ...</option>
	                                <%}else{ %>
	                                <option value="since">Since ...</option>
	                                <%} %>
                                </select>
                                <span id="auditLogDatePicker" class="audit_date_filter_cel">
                                <%if(strLogDate!=null && strLogDate.length() >0) {%>
                                <input type="text" class="datepicker audit_date_input_filter" name="auditLogDate" readonly="readonly" id="auditLogDate" value="<%= strLogDate %>" onchange="showFilterCount()" title="Audit Log Date" />
                                <%}else{ %>
                                <input type="text" class="datepicker audit_date_input_filter" name="auditLogDate" readonly="readonly" id="auditLogDate" value="" onchange="showFilterCount()" title="Audit Log Date" />
                                <%} %>
                                </span>
                            </td>
                            <td>
                                <span id="auditLogClearButton">
                                    <img class="clear_audit_log_filter" title="clear audit log filter" src="/BSTheme-theme/images/delete.png" alt="clear audit log filter"/>
                                </span>
                            </td>
                           
                        </tr>
                      
                        <tr>
                       <td></td>
                       <td>
                           <div id="auditLogBrand" style="padding-left:20px;">
                                <select id="auditLog_brand" class="multis" name="auditLog_brand" title="audit log  brand select" multiple="multiple">
                                <%
	                                if(!BrandStandardsUtil.isNullOrBlank(filterLogBrand)&& filterLogBrand.contains("all"))
	                                {
                                %>
                                		<option value="all" selected="selected">All Brands</option>
                                <%
	                                }
	                                else
	                                { %>
	                                    <option value="all">All Brands</option>
	                          <%  	}
                              
                              
	                              for(String chncode : chnCdMap.keySet())
	                              {
	                                  if(!BrandStandardsUtil.isNullOrBlank(filterLogBrand)&& filterLogBrand.contains(chncode))
	                                  {
		                      %>
		                          		<option value="<%=chncode%>" selected="selected"><%=chnCdMap.get(chncode)%></option>
		                      <%                                                  
		                          	  }
	                                  else
	                                  { 
	                          %>
	                                     <option value="<%=chncode%>"><%=chnCdMap.get(chncode)%></option> 
	                         <%
	                                }
	                              }
		                      %> 
                                </select>
                            	</div>
                            </td>
                           
                            
                            </tr>
                        <tr><td>
                        <p class="applicable_filter">Internal Reference:</p></td>
                        <td colspan="2"><input type="text" class="adv_filter_text" name="internal_reference" id="internal_reference" size="50" maxlength="50" value="<%=strInternalRef%>"/></td>                    
                        <td></td>
                        </tr>
						<tr>
							<td><p class="applicable_filter">Authors:</p></td>
							<td colspan="2">
							<%
							List<User> arlWriters = StandardsUtil.getAllTechnicalWriters(companyId);
							%>
								<select id="techWriter" class="multis applicable_filter" name="techWriter" multiple="multiple" title="Tech Writer">
								<%
								for(User userObj : arlWriters)
		                      	{
									if(!BrandStandardsUtil.isNullOrBlank(arlTechWriter))
									{	
										if(arlTechWriter.contains(userObj.getFullName()))
										{%>	
											<option  value="<%=userObj.getFullName()%>" selected = "selected"><%=userObj.getFullName()%></option>
									  <%}
										else
										{%>	
											<option  value="<%=userObj.getFullName()%>"><%=userObj.getFullName()%></option>
									  <%}
									}
									else
									{%>	
										<option  value="<%=userObj.getFullName()%>"><%=userObj.getFullName()%></option>
								  <%}	
								}%>
								</select>
							</td>
                            <td></td>
						</tr>
						<tr>
							<td><p class="applicable_filter">Standards Owner:</p></td>
							<td colspan="2">
							<%	
							List<User> arlOwners = StandardsUtil.getAllBusOwners(companyId);
							%>
								<select id="stdOwner" class="multis applicable_filter" name="stdOwner" multiple="multiple" title="Owner">
								<%
		                      		if(!StandardsUtil.isNullOrBlank(arlStdOwner) && arlStdOwner.contains("To Be Assigned"))
									{%>	
										<option  value="To Be Assigned" selected="selected">To Be Assigned</option>
								  <%}
									else
									{%>	
										<option  value="To Be Assigned">To Be Assigned</option>
								<%}
								for(User userObj : arlOwners)
		                      	{	
								    if(!BrandStandardsUtil.isNullOrBlank(arlStdOwner))
									{	
			                      		if(arlStdOwner.contains(userObj.getFullName()))
										{%>	
											<option  value="<%=userObj.getFullName()%>" selected="selected"><%=userObj.getFullName()%></option>
									  <%}
										else
										{%>	
											<option  value="<%=userObj.getFullName()%>"><%=userObj.getFullName()%></option>
									  <%}
									}
			                      	else
									{%>	
										<option  value="<%=userObj.getFullName()%>"><%=userObj.getFullName()%></option>
								  <%}
								}%>
								</select>
							</td>
                            <td></td>
						</tr>
						<tr>
							<td><p class="applicable_filter">Category:</p></td>
							<td colspan="2">
								<select id="category" class="multis applicable_filter" name="category" multiple="multiple" title="Category">
					               <%
	                            	for (Map.Entry entry : categoryMap.entrySet()) 
	                            	{
	                            		if(!BrandStandardsUtil.isNullOrBlank(arlCategory))
	                            		{
                                            if(arlCategory.contains(entry.getKey()))
                                            {%>
                                                <option value="<%= entry.getKey()%>" selected="true"><%= entry.getValue()%></option>
                                          <%}
                                            else
                                            {%>
                                                <option value="<%= entry.getKey()%>"><%= entry.getValue()%></option>
                                          <%}
	                            		}
	                            		else
	                            		{%>
	                            	        <option value="<%= entry.getKey()%>"><%= entry.getValue()%></option>
	                            	  <%}
	                            	}%>
								</select>
							</td>
                            <td></td>
						</tr>
						<tr>
							<td><p class="applicable_filter">Department Applicability:</p></td>
							<td colspan="2">
							<%	
								FlagCategory flagCategory = FlagCategoryLocalServiceUtil.getFlagCategory(1);
								List<FlagCategory> flagCategories = FlagCategoryLocalServiceUtil.getFlagCategoryByParentId(1);	%>
								<select id="deptApplicability" class="multis applicable_filter" name="deptApplicability" multiple="multiple" title="Department">
			                        <%
			                        for(FlagCategory flgOption : flagCategories)
			                      	{	
			                      	    if(!BrandStandardsUtil.isNullOrBlank(arlFlags))
				                      	{ 	
			                      	        boolean found = false;
				                      		for(int i=0;i< arlFlags.size();i++)
				                      		{
				                      			if(flgOption.getFlagCatId() == Integer.parseInt((String)arlFlags.get(i)))
				                      			{
				                      				found = true;
				                      				break;
				                      			}
				                      		}
				                      		if(found)
			                      			{%>		
												<option value="<%=flgOption.getFlagCatId()%>" selected="selected"><%=flgOption.getTxtValue()%></option>
										  <%}
			                      			else
			                      			{%>		
												<option value="<%=flgOption.getFlagCatId()%>"><%=flgOption.getTxtValue()%></option>
										  <%}
				                      	}
				                      	else
		                      			{%>		
											<option value="<%=flgOption.getFlagCatId()%>"><%=flgOption.getTxtValue()%></option>
									  <%}
			                       	}%>
								</select>
							</td>
                            <td></td>
						</tr>
					
						<tr>
							<td><p class="applicable_filter">Guest Journey:</p></td>
							<td colspan="3">
                            <%
                            // outside of guest journey
                            FlagCategory guestJourney = FlagCategoryLocalServiceUtil.getFlagCategory(21);
                            List<FlagCategory> guestJourneys = FlagCategoryLocalServiceUtil.getFlagCategoryByParentId(21);
                            boolean bFound = false;
                            if(!BrandStandardsUtil.isNullOrBlank(arlFlags))
                            {   
                                for(FlagCategory flgOption : guestJourneys)
                                {
                                    if( arlFlags.contains(String.valueOf(flgOption.getFlagCatId())) )
                                    {
                                        bFound = true;
                                        break;
                                    }
                                }
                            }
							
						    flagCategory = FlagCategoryLocalServiceUtil.getFlagCategory(20);
							flagCategories = FlagCategoryLocalServiceUtil.getFlagCategoryByParentId(20);%>
								<select id="guestJourney" class="multis applicable_filter" name="guestJourney" multiple="multiple" title="Guest Journey">
					                <%
			                      	for(FlagCategory flgOption : flagCategories)
			                      	{	
			                      	    if(!bFound && !BrandStandardsUtil.isNullOrBlank(arlFlags))
				                      	{ 	
			                      	        boolean found = false;
				                      		for(int i=0;i< arlFlags.size();i++)
				                      		{
				                      			if(flgOption.getFlagCatId() == Integer.parseInt((String)arlFlags.get(i)))
				                      			{
				                      				found = true;
				                      				break;
				                      			}
				                      		}
				                      		if(found)
			                      			{%>		
												<option value="<%=flgOption.getFlagCatId()%>" selected="selected"><%=flgOption.getTxtValue()%></option>
										  <%}
			                      			else
			                      			{%>		
												<option value="<%=flgOption.getFlagCatId()%>"><%=flgOption.getTxtValue()%></option>
										  <%}
				                      	}
				                      	else
		                      			{%>		
											<option value="<%=flgOption.getFlagCatId()%>"><%=flgOption.getTxtValue()%></option>
									  <%}
			                       	}%>
								</select>
			                    <input type="checkbox" class="input_checkbox" name="outsideofGuestJourney" id="outsideofGuestJourney" value="<%=guestJourneys.get(0).getFlagCatId()%>" <%=bFound?"checked":""%> title="<%=guestJourney.getTxtValue()%>" /> <%=guestJourney.getTxtValue()%>
							</td>
						</tr>
						<tr>
							<td><p class="applicable_filter">Location Within Hotel:</p></td>
							<td colspan="2">
							  <%flagCategory = FlagCategoryLocalServiceUtil.getFlagCategory(25);
								flagCategories = FlagCategoryLocalServiceUtil.getFlagCategoryByParentId(25);	%>
								<select id="locHotel" class="multis applicable_filter" name="locHotel" multiple="multiple" title="Location">
								<%
		                      	for(FlagCategory flgOption : flagCategories)
		                      	{	
		                      	    if(!BrandStandardsUtil.isNullOrBlank(arlFlags))
			                      	{ 	
		                      	        boolean found = false;
			                      		for(int i=0;i< arlFlags.size();i++)
			                      		{
			                      			if(flgOption.getFlagCatId() == Integer.parseInt((String)arlFlags.get(i)))
			                      			{
			                      				found = true;
			                      				break;
			                      			}
			                      		}
			                      		if(found)
		                      			{%>		
											<option value="<%=flgOption.getFlagCatId()%>" selected="selected"><%=flgOption.getTxtValue()%></option>
									  <%}
		                      			else
		                      			{%>		
											<option value="<%=flgOption.getFlagCatId()%>"><%=flgOption.getTxtValue()%></option>
									  <%}
			                      	}
			                      	else
	                      			{%>		
										<option value="<%=flgOption.getFlagCatId()%>"><%=flgOption.getTxtValue()%></option>
								  <%}
		                       	}%>
								</select>
							</td>
                            <td></td>
						</tr>
						<tr>
							<td><p class="applicable_filter">Manual:</p></td>
							<td colspan="2">
						  <%flagCategory = FlagCategoryLocalServiceUtil.getFlagCategory(30);
							flagCategories = FlagCategoryLocalServiceUtil.getFlagCategoryByParentId(30);%>
								<select id="manual"  class="single_select " name="manual" title="Manual">
									<option value="">Select</option>
									<%
			                      	for(FlagCategory flgOption : flagCategories)
			                      	{	
			                      	    if(!BrandStandardsUtil.isNullOrBlank(arlFlags))
				                      	{ 	
			                      	        boolean found = false;
				                      		for(int i=0;i< arlFlags.size();i++)
				                      		{
				                      			if(flgOption.getFlagCatId() == Integer.parseInt((String)arlFlags.get(i)))
				                      			{
				                      				found = true;
				                      				break;
				                      			}
				                      		}
				                      		if(found)
			                      			{%>		
												<option value="<%=flgOption.getFlagCatId()%>" selected="selected"><%=flgOption.getTxtValue()%></option>
										  <%}
			                      			else
			                      			{%>		
												<option value="<%=flgOption.getFlagCatId()%>"><%=flgOption.getTxtValue()%></option>
										  <%}
				                      	}
				                      	else
		                      			{%>		
											<option value="<%=flgOption.getFlagCatId()%>"><%=flgOption.getTxtValue()%></option>
									  <%}
			                       	}%>
								</select>
							</td>
                            <td></td>
						</tr>
						<tr>
							<td><p class="applicable_filter">Corporate Department:</p></td>
							<td colspan="2">
						  <%flagCategory = FlagCategoryLocalServiceUtil.getFlagCategory(35);
							flagCategories = FlagCategoryLocalServiceUtil.getFlagCategoryByParentId(35);%>
								<select id="corpDept" class="multis applicable_filter" name="corpDept" multiple="multiple" title="Corporate Dept">
                                <%
		                      	for(FlagCategory flgOption : flagCategories)
		                      	{	
		                      	    if(!BrandStandardsUtil.isNullOrBlank(arlFlags))
			                      	{ 	
		                      	        boolean found = false;
			                      		for(int i=0;i< arlFlags.size();i++)
			                      		{
			                      			if(flgOption.getFlagCatId() == Integer.parseInt((String)arlFlags.get(i)))
			                      			{
			                      				found = true;
			                      				break;
			                      			}
			                      		}
			                      		if(found)
		                      			{%>		
											<option value="<%=flgOption.getFlagCatId()%>" selected="selected"><%=flgOption.getTxtValue()%></option>
									  <%}
		                      			else
		                      			{%>		
											<option value="<%=flgOption.getFlagCatId()%>"><%=flgOption.getTxtValue()%></option>
									  <%}
			                      	}
			                      	else
	                      			{%>		
										<option value="<%=flgOption.getFlagCatId()%>"><%=flgOption.getTxtValue()%></option>
								  <%}
		                       	}%>
								</select>
							</td>
                            <td></td>
						</tr>
						<tr>
							<td><p class="applicable_filter">Wheel Quadrant:</p></td>
						  <%flagCategory = FlagCategoryLocalServiceUtil.getFlagCategory(40);
							flagCategories = FlagCategoryLocalServiceUtil.getFlagCategoryByParentId(40);%>
							<td colspan="2">
								<select id="wheelQuadrant" class="multis applicable_filter" name="wheelQuadrant" multiple="multiple" title="Wheel Quadrant">
									<%
			                      	for(FlagCategory flgOption : flagCategories)
			                      	{	
			                      	    if(!BrandStandardsUtil.isNullOrBlank(arlFlags))
				                      	{ 	
			                      	        boolean found = false;
				                      		for(int i=0;i< arlFlags.size();i++)
				                      		{
				                      			if(flgOption.getFlagCatId() == Integer.parseInt((String)arlFlags.get(i)))
				                      			{
				                      				found = true;
				                      				break;
				                      			}
				                      		}
				                      		if(found)
			                      			{%>		
												<option value="<%=flgOption.getFlagCatId()%>" selected="selected"><%=flgOption.getTxtValue()%></option>
										  <%}
			                      			else
			                      			{%>		
												<option value="<%=flgOption.getFlagCatId()%>"><%=flgOption.getTxtValue()%></option>
										  <%}
				                      	}
				                      	else
		                      			{%>		
											<option value="<%=flgOption.getFlagCatId()%>"><%=flgOption.getTxtValue()%></option>
									  <%}
			                       	}%>
								</select>
							</td>
                            <td></td>
						</tr>
						<tr>
							<td><p class="applicable_filter">Hotel Lifecycle:</p></td>
							<td colspan="2">
						<%	flagCategory = FlagCategoryLocalServiceUtil.getFlagCategory(91);
							//CR 50.3 Reverse hotle Lifecycle
							flagCategories = StandardsListUtil.getReverseHotleLifecycle(91); 
							
						%>
							<input type="hidden" name="hotellifecycle" id="hotellifecycle" value='' />
								<div class="ht_lifecycle">
			                     
			                     <%
				                    for(FlagCategory flgOption : flagCategories)
	                             	{
				                       String flagDesc = StringPool.BLANK;
			                           
				                       if (flgOption.getFlagCatId() == 479)
		                        	   {
		                        		   flagDesc = "Applicable to existing / operating IHG hotels now. Hotels may have until a date based compliance deadline to comply with the standard.";
		                        	   }
		                        	   else if (flgOption.getFlagCatId() == 399)
		                        	   {
		                        		   flagDesc = "Applicable to existing / operating IHG properties at the event of replacement.";
		                        	   }
		                        	   else if (flgOption.getFlagCatId() == 478	)
		                        	   {
		                        		   flagDesc = "Applicable to existing / operating IHG properties at the event of renovation.";
		                        	   }
		                        	   else if (flgOption.getFlagCatId() == 477)
		                        	   {
		                        		   
		                        		   flagDesc = "Applicable to properties that are being converted to IHG. Hotels must comply prior to opening.";
		                        	   }
		                        	   else if (flgOption.getFlagCatId() == 396)
		                        	   {
		                        		   flagDesc = "Applicable to New Build hotels.  Hotels must comply at the appropriate point during construction, prior to opening.";
		                        	   }
				                       
				                       if(!BrandStandardsUtil.isNullOrBlank(arlFlags))
			                           {
				                    	   boolean found = false;
				              			   for(int i=0;i< arlFlags.size();i++)
				                  		   {
				              				   if(flgOption.getFlagCatId() == Integer.parseInt((String)arlFlags.get(i)))
				                  			   {
				                    			found = true;
				                    			break;
				                    		   }
				                    	   }
				                    	   if(found)
										   {
				                  %>
											<img id="<%=flgOption.getFlagCatId()%>" class="ht_active" src="/BSTheme-theme/images/<%=flgOption.getFlagCatId()%>_active.png" title="<%=flagDesc%>" /><span><%=flgOption.getTxtValue()%></span>
								 <%
							           	   }
		                               	   else
		                                   {
								 %>		
											<img id="<%=flgOption.getFlagCatId()%>" class="ht_inactive" src="/BSTheme-theme/images/<%=flgOption.getFlagCatId()%>_inactive.png"  title="<%=flagDesc%>" /><span><%=flgOption.getTxtValue()%></span>
								 <%
		                                   }
	                             	   }
				                       else
				                       {
				                 %>
				                 		
				                 		<img id="<%=flgOption.getFlagCatId()%>" class="ht_inactive" src="/BSTheme-theme/images/<%=flgOption.getFlagCatId()%>_inactive.png"  title="<%=flagDesc%>" /><span><%=flgOption.getTxtValue()%></span> 				                 <%    	   
				                       }
	                             	}  
								 %>	
								
							  </div>
							</td>
                            <td></td>
						</tr>
						<tr>
							<td><p class="applicable_filter">Specialist Area:</p></td>
							<td colspan="2">
						<%	flagCategory = FlagCategoryLocalServiceUtil.getFlagCategory(92);
							flagCategories = FlagCategoryLocalServiceUtil.getFlagCategoryByParentId(92); %>
								<select id="specialistarea" class="multis applicable_filter" name="specialistarea" multiple="multiple" title="Specialist Area">
									<%
			                      	for(FlagCategory flgOption : flagCategories)
			                      	{	
			                      	    if(!BrandStandardsUtil.isNullOrBlank(arlFlags))
				                      	{ 	
			                      	        boolean found = false;
				                      		for(int i=0;i< arlFlags.size();i++)
				                      		{
				                      			if(flgOption.getFlagCatId() == Integer.parseInt((String)arlFlags.get(i)))
				                      			{
				                      				found = true;
				                      				break;
				                      			}
				                      		}
				                      		if(found)
			                      			{%>		
												<option value="<%=flgOption.getFlagCatId()%>" selected="selected"><%=flgOption.getTxtValue()%></option>
										  <%}
			                      			else
			                      			{%>		
												<option value="<%=flgOption.getFlagCatId()%>"><%=flgOption.getTxtValue()%></option>
										  <%}
				                      	}
				                      	else
		                      			{%>		
											<option value="<%=flgOption.getFlagCatId()%>"><%=flgOption.getTxtValue()%></option>
									  <%}
			                       	}%>	
								</select>
							</td>
                            <td></td>
						</tr>
						<tr>
							<td><p class="applicable_filter">Digital:</p></td>
							<td colspan="2">
						<%	flagCategory = FlagCategoryLocalServiceUtil.getFlagCategory(93);
							flagCategories = FlagCategoryLocalServiceUtil.getFlagCategoryByParentId(93); %>
								<select id="digital" class="multis applicable_filter" name="digital" multiple="multiple" title="Digital">
									<%
			                      	for(FlagCategory flgOption : flagCategories)
			                      	{	
			                      	    if(!BrandStandardsUtil.isNullOrBlank(arlFlags))
				                      	{ 	
			                      	        boolean found = false;
				                      		for(int i=0;i< arlFlags.size();i++)
				                      		{
				                      			if(flgOption.getFlagCatId() == Integer.parseInt((String)arlFlags.get(i)))
				                      			{
				                      				found = true;
				                      				break;
				                      			}
				                      		}
				                      		if(found)
			                      			{%>		
												<option value="<%=flgOption.getFlagCatId()%>" selected="selected"><%=flgOption.getTxtValue()%></option>
										  <%}
			                      			else
			                      			{%>		
												<option value="<%=flgOption.getFlagCatId()%>"><%=flgOption.getTxtValue()%></option>
										  <%}
				                      	}
				                      	else
		                      			{%>		
											<option value="<%=flgOption.getFlagCatId()%>"><%=flgOption.getTxtValue()%></option>
									  <%}
			                       	}%>	
								</select>
							</td>
                            <td></td>
						</tr>
						<tr>
							<td><p class="applicable_filter">Brand Safety Standards:</p></td>
							<td colspan="2">
						<%	flagCategory = FlagCategoryLocalServiceUtil.getFlagCategory(500);
							flagCategories = FlagCategoryLocalServiceUtil.getFlagCategoryByParentId(500); %>
								<select id="brandsafetystandards" class="multis applicable_filter" name="brandsafetystandards" multiple="multiple" title="Brand Safety Standards">
									<%
			                      	for(FlagCategory flgOption : flagCategories)
			                      	{	
			                      	    if(!BrandStandardsUtil.isNullOrBlank(arlFlags))
				                      	{ 	
			                      	        boolean found = false;
				                      		for(int i=0;i< arlFlags.size();i++)
				                      		{
				                      			if(flgOption.getFlagCatId() == Integer.parseInt((String)arlFlags.get(i)))
				                      			{
				                      				found = true;
				                      				break;
				                      			}
				                      		}
				                      		if(found)
			                      			{%>		
												<option value="<%=flgOption.getFlagCatId()%>" selected="selected"><%=flgOption.getTxtValue()%></option>
										  <%}
			                      			else
			                      			{%>		
												<option value="<%=flgOption.getFlagCatId()%>"><%=flgOption.getTxtValue()%></option>
										  <%}
				                      	}
				                      	else
		                      			{%>		
											<option value="<%=flgOption.getFlagCatId()%>"><%=flgOption.getTxtValue()%></option>
									  <%}
			                       	}%>	
								</select>
							</td>
                            <td></td>
						</tr>
                        <tr>
                            <td><p class="applicable_filter">Measurement:</p></td>
                            <td colspan="2">
                        <%  flagCategory = FlagCategoryLocalServiceUtil.getFlagCategory(90);
                            flagCategories = FlagCategoryLocalServiceUtil.getFlagCategoryByParentId(90); %>
                                <select id="measurement" class="multis applicable_filter" name="measurement" multiple="multiple" title="Measurement">
                                    <%
                                    for(FlagCategory flgOption : flagCategories)
                                    {   
                                        if(!BrandStandardsUtil.isNullOrBlank(arlFlags))
                                        {   
                                            boolean found = false;
                                            for(int i=0;i< arlFlags.size();i++)
                                            {
                                                if(flgOption.getFlagCatId() == Integer.parseInt((String)arlFlags.get(i)))
                                                {
                                                    found = true;
                                                    break;
                                                }
                                            }
                                            if(found)
                                            {%>     
                                                <option value="<%=flgOption.getFlagCatId()%>" selected="selected"><%=flgOption.getTxtValue()%></option>
                                          <%}
                                            else
                                            {%>     
                                                <option value="<%=flgOption.getFlagCatId()%>"><%=flgOption.getTxtValue()%></option>
                                          <%}
                                        }
                                        else
                                        {%>     
                                            <option value="<%=flgOption.getFlagCatId()%>"><%=flgOption.getTxtValue()%></option>
                                      <%}
                                    }%> 
                                </select>
                            </td>
                            <td></td>
                        </tr>
                        <tr>
                            <td><p class="applicable_filter">GEM Reporting Categories:</p></td>
                            <td colspan="2">
                        <%  flagCategory = FlagCategoryLocalServiceUtil.getFlagCategory(412);
                            flagCategories = FlagCategoryLocalServiceUtil.getFlagCategoryByParentId(412); %>
                                <select id="gemReportCategory" class="multis applicable_filter" name="gemReportCategory" multiple="multiple" title="GEM Reporting Categories">
                                    <%
                                    for(FlagCategory flgOption : flagCategories)
                                    {   
                                        if(!BrandStandardsUtil.isNullOrBlank(arlFlags))
                                        {   
                                            boolean found = false;
                                            for(int i=0;i< arlFlags.size();i++)
                                            {
                                                if(flgOption.getFlagCatId() == Integer.parseInt((String)arlFlags.get(i)))
                                                {
                                                    found = true;
                                                    break;
                                                }
                                            }
                                            if(found)
                                            {%>     
                                                <option value="<%=flgOption.getFlagCatId()%>" selected="selected"><%=flgOption.getTxtValue()%></option>
                                          <%}
                                            else
                                            {%>     
                                                <option value="<%=flgOption.getFlagCatId()%>"><%=flgOption.getTxtValue()%></option>
                                          <%}
                                        }
                                        else
                                        {%>     
                                            <option value="<%=flgOption.getFlagCatId()%>"><%=flgOption.getTxtValue()%></option>
                                      <%}
                                    }%> 
                                </select>
                            </td>
                            <td></td>
                        </tr>
                        <tr>
                            <td><p class="applicable_filter">Area of the Hotel for Measurement:</p></td>
                            <td colspan="2">
                        <%  flagCategory = FlagCategoryLocalServiceUtil.getFlagCategory(419);
                            flagCategories = FlagCategoryLocalServiceUtil.getFlagCategoryByParentId(419); %>
                                <select id="areaForMeasurement" class="multis applicable_filter" name="areaForMeasurement" multiple="multiple" title="Area of the Hotel for Measurement">
                                    <%
                                    for(FlagCategory flgOption : flagCategories)
                                    {   
                                        if(!BrandStandardsUtil.isNullOrBlank(arlFlags))
                                        {   
                                            boolean found = false;
                                            for(int i=0;i< arlFlags.size();i++)
                                            {
                                                if(flgOption.getFlagCatId() == Integer.parseInt((String)arlFlags.get(i)))
                                                {
                                                    found = true;
                                                    break;
                                                }
                                            }
                                            if(found)
                                            {%>     
                                                <option value="<%=flgOption.getFlagCatId()%>" selected="selected"><%=flgOption.getTxtValue()%></option>
                                          <%}
                                            else
                                            {%>     
                                                <option value="<%=flgOption.getFlagCatId()%>"><%=flgOption.getTxtValue()%></option>
                                          <%}
                                        }
                                        else
                                        {%>     
                                            <option value="<%=flgOption.getFlagCatId()%>"><%=flgOption.getTxtValue()%></option>
                                      <%}
                                    }%> 
                                </select>
                            </td>
                            <td></td>
                        </tr>






						<tr>
							<td><p class="applicable_filter">File Attachment Type:</p></td>
							<td colspan="2">
								<select id="attachmentType" class="multis applicable_filter" name="attachmentType" multiple="multiple" title="Attachment Type">
									<%
	                            	for (Map.Entry entry : fileTypes.entrySet()) 
	                            	{
	                            		if(!BrandStandardsUtil.isNullOrBlank(arlAttachType))
	                            		{	
	                            			if(arlAttachType.contains(entry.getKey()))
                            				{
                            					%>
            	                            	<option value="<%= entry.getKey()%>" selected="true"><%= entry.getValue()%></option>
            	                            	<%
                            				}
                            				else
                            				{%>
            	                            	<option value="<%= entry.getKey()%>"><%= entry.getValue()%></option>
            	                          <%}
	                            		}
	                            		else{%>
	                            	        <option value="<%= entry.getKey()%>"><%= entry.getValue()%></option>
	                            	  <%}
	                            	}%>
								</select>
							</td>
                            <td></td>
						</tr>
						<tr>
							<td><p class="applicable_filter">Has URL Links:</p></td>
							<td>
							<%if("Y".equalsIgnoreCase(strHasLinks))
							{%>
								<input type="checkbox" class="input_checkbox_filter" name="hasLinks" id="hasLinks" value="Y"  checked="checked" title="Has Links"/>
						  <%}
							else
							{%>
								<input type="checkbox" class="input_checkbox_filter" name="hasLinks" id="hasLinks" value="Y" title="Has Links"/>
						  <%}%>
							</td>
							<td class="filler_cell">&nbsp;</td>
                            <td></td>
						</tr>
						<tr>
							<td><p class="applicable_filter">Has Guidelines:</p></td>
							<td>
							<%if("Y".equals(strHasGuidelines))
							{%>
								<input type="checkbox" class="input_checkbox_filter" name="hasGuidelines" id="hasGuidelines" value="Y"  checked="checked" title="Has Guidelines" />
						  <%}
							else
							{%>
							    <input type="checkbox" class="input_checkbox_filter" name="hasGuidelines" id="hasGuidelines" value="Y" title="Has Guidelines"/>
						  <%}%>
							</td>
							<td class="filler_cell">&nbsp;</td>
                            <td></td>
						</tr>
						<tr>
							<td><p class="applicable_filter">Change Type:</p></td>
							<td colspan="2">
								<select id="changeType" class="multis applicable_filter" name="changeType" multiple="multiple" title="Filter">
					               <%
	                            	for (Map.Entry entry : changeMap.entrySet()) 
	                            	{
	                            		if(!BrandStandardsUtil.isNullOrBlank(arlChangeType))
	                            		{	
	                            			if(arlChangeType.contains(entry.getKey()))
                            				{%>
            	                            	<option value="<%= entry.getKey()%>" selected="true"><%= entry.getValue()%></option>
            	                          <%}
                            				else
                            				{%>
            	                            	<option value="<%= entry.getKey()%>"><%= entry.getValue()%></option>
            	                          <%}
	                            		}
	                            		else{%>
	                            	        <option value="<%= entry.getKey()%>"><%= entry.getValue()%></option>
	                            	  <%}
	                            	}%>
								</select>
							</td>
                            <td></td>
						</tr>
						<tr>
							<td><p class="applicable_filter">Historical Manual:</p></td>
							<td colspan="2">
							<%  List<HistManuals> arlHistManual = HistManualsLocalServiceUtil.getManuals();
                             %>
								<select id="historicalManual"  class="single_select required" name="historicalManual" title="Historical Manual">
								<option value="">Select</option>
								<%
								for(HistManuals histManuals : arlHistManual)
		                      	{
									if(histManual != null && !histManual.isEmpty() && Integer.parseInt(histManual) == histManuals.getHistManualId())
									{%>
										<option  value="<%=histManuals.getHistManualId()%>" selected="true"><%=histManuals.getTitle().length() < 63 ? histManuals.getTitle() : histManuals.getTitle().substring(0, 60) + "..."%></option>
								  <%}
									else
									{%>	
									    <option  value="<%=histManuals.getHistManualId()%>"><%=histManuals.getTitle().length() < 63 ? histManuals.getTitle() : histManuals.getTitle().substring(0, 60) + "..."%></option>
								  <%}
								}%>	
								</select>
							</td>
                            <td></td>
						</tr>
                        <tr>
                            <td><p class="applicable_filter">Change from Regional:</p></td>
                            <td colspan="2">
                        <%  flagCategory = FlagCategoryLocalServiceUtil.getFlagCategory(75);
                            flagCategories = FlagCategoryLocalServiceUtil.getFlagCategoryByParentId(75); %>
                                <select id="changeFromRegional"  class="multis required" name="changeFromRegional" multiple="multiple" title="Change from Regional">
                                    <%
                                    for (FlagCategory flgOption : flagCategories)
                                    {
                                        if (!BrandStandardsUtil.isNullOrBlank(arlImpactAssmnt))
                                        {
                                            boolean found = false;
                                            for (int i = 0; i < arlImpactAssmnt.size(); i++)
                                            {
                                                if (flgOption.getFlagCatId() == Integer.parseInt((String) arlImpactAssmnt.get(i)))
                                                {
                                                    found = true;
                                                    break;
                                                }
                                            }
                                            if (found)
                                            {
                                            %>     
                                                <option value="<%=flgOption.getFlagCatId()%>" selected="selected"><%=flgOption.getTxtValue()%></option>
                                          <%}
                                            else
                                            {%>     
                                                <option value="<%=flgOption.getFlagCatId()%>"><%=flgOption.getTxtValue()%></option>
                                          <%}
                                        }
                                        else
                                        {%>     
                                            <option value="<%=flgOption.getFlagCatId()%>"><%=flgOption.getTxtValue()%></option>
                                      <%}
                                    }%> 
                                </select>
                            </td>
                            <td></td>
                        </tr>
                        <tr>
                            <td><p class="applicable_filter">P&L:</p></td>
                            <td colspan="2">
                        <%  flagCategory = FlagCategoryLocalServiceUtil.getFlagCategory(60);
                            flagCategories = FlagCategoryLocalServiceUtil.getFlagCategoryByParentId(60); %>
                                <select id="plImpact"  class="multis required" name="plImpact" multiple="multiple" title="P&L Impact">
                                    <%
                                    for (FlagCategory flgOption : flagCategories)
                                    {
                                        if (!BrandStandardsUtil.isNullOrBlank(arlImpactAssmnt))
                                        {
                                            boolean found = false;
                                            for (int i = 0; i < arlImpactAssmnt.size(); i++)
                                            {
                                                if (flgOption.getFlagCatId() == Integer.parseInt((String) arlImpactAssmnt.get(i)))
                                                {
                                                    found = true;
                                                    break;
                                                }
                                            }
                                            if (found)
                                            {
                                            %>     
                                                <option value="<%=flgOption.getFlagCatId()%>" selected="selected"><%=flgOption.getTxtValue()%></option>
                                          <%}
                                            else
                                            {%>     
                                                <option value="<%=flgOption.getFlagCatId()%>"><%=flgOption.getTxtValue()%></option>
                                          <%}
                                        }
                                        else
                                        {%>     
                                            <option value="<%=flgOption.getFlagCatId()%>"><%=flgOption.getTxtValue()%></option>
                                      <%}
                                    }%> 
                                </select>
                            </td>
                            <td></td>
                        </tr>
                        <tr>
                            <td><p class="applicable_filter">CapEx:</p></td>
                            <td colspan="2">
                        <%  flagCategory = FlagCategoryLocalServiceUtil.getFlagCategory(70);
                            flagCategories = FlagCategoryLocalServiceUtil.getFlagCategoryByParentId(70); %>
                                <select id="capExImpact"  class="multis required" name="capExImpact" multiple="multiple" title="CapEx Impact">
                                    <%
                                    for (FlagCategory flgOption : flagCategories)
                                    {
                                        if (!BrandStandardsUtil.isNullOrBlank(arlImpactAssmnt))
                                        {
                                            boolean found = false;
                                            for (int i = 0; i < arlImpactAssmnt.size(); i++)
                                            {
                                                if (flgOption.getFlagCatId() == Integer.parseInt((String) arlImpactAssmnt.get(i)))
                                                {
                                                    found = true;
                                                    break;
                                                }
                                            }
                                            if (found)
                                            {
                                            %>     
                                                <option value="<%=flgOption.getFlagCatId()%>" selected="selected"><%=flgOption.getTxtValue()%></option>
                                          <%}
                                            else
                                            {%>     
                                                <option value="<%=flgOption.getFlagCatId()%>"><%=flgOption.getTxtValue()%></option>
                                          <%}
                                        }
                                        else
                                        {%>     
                                            <option value="<%=flgOption.getFlagCatId()%>"><%=flgOption.getTxtValue()%></option>
                                      <%}
                                    }%> 
                                </select>
                            </td>
                            <td></td>
                        </tr>
                        <tr>
                            <td><p class="applicable_filter">Implementation:</p></td>
                            <td colspan="2">
                        <%  flagCategory = FlagCategoryLocalServiceUtil.getFlagCategory(65);
                            flagCategories = FlagCategoryLocalServiceUtil.getFlagCategoryByParentId(65); %>
                                <select id="implementationImpact"  class="multis required" name="implementationImpact" multiple="multiple" title="Implementation Impact">
                                    <%
                                    for (FlagCategory flgOption : flagCategories)
                                    {
                                        if (!BrandStandardsUtil.isNullOrBlank(arlImpactAssmnt))
                                        {
                                            boolean found = false;
                                            for (int i = 0; i < arlImpactAssmnt.size(); i++)
                                            {
                                                if (flgOption.getFlagCatId() == Integer.parseInt((String) arlImpactAssmnt.get(i)))
                                                {
                                                    found = true;
                                                    break;
                                                }
                                            }
                                            if (found)
                                            {
                                            %>     
                                                <option value="<%=flgOption.getFlagCatId()%>" selected="selected"><%=flgOption.getTxtValue()%></option>
                                          <%}
                                            else
                                            {%>     
                                                <option value="<%=flgOption.getFlagCatId()%>"><%=flgOption.getTxtValue()%></option>
                                          <%}
                                        }
                                        else
                                        {%>     
                                            <option value="<%=flgOption.getFlagCatId()%>"><%=flgOption.getTxtValue()%></option>
                                      <%}
                                    }%> 
                                </select>
                            </td>
                            <td></td>
                        </tr>
                        <tr>
                            <td><p class="applicable_filter">Comments:</p></td>
                            <td colspan = "2">
                                <input type="text" name="impactComments" id="impactComments"  value="<%=impactComments %>" class="adv_filter_text" size="75" maxlength="500" title="ImpactComments" />
                            </td>
                            <td></td>
                        </tr>
                        <tr>
                        	<td><p class="applicable_filter">Has cross-references:</p></td>
                        	<td colspan = "2">
                        	<%
                        	if("Y".equals(strHasCrossReferences)){
                        	%>
                        		<input type="checkbox" class="input_checkbox_filter" name="hasCrossReference" id="hasCrossReference" value="Y"  checked="checked"  title="Has Cross Reference" />
                        	<%}else{ %>
                        		<input type="checkbox" class="input_checkbox_filter" name="hasCrossReference" id="hasCrossReference" value="Y" title="Has Cross Reference" />
                        	<%} %>
                        	</td>
                        </tr>
				        <tr>
							<td></td>
							<td>
								<aui:button name="submitButton" type="button" value="apply filter"  class="apply_filter_button"  onClick="javascript:showFilter();"/>
								<aui:button type="button" onClick="javascript:cancelFilter();" value="cancel filter" class="cancel_filter_button"  />
							</td>
							<td><input type="button" name="basicFilter" value="basic filter" class="basic_filter_button" title="Basic Filter"/></td>
                            <td></td>
				        </tr>
				    </table>
				</div>
			</div><!--ends filter_results_form-->
			<div class="divider">&nbsp;</div>
            <div class="clear"></div>
            <table class="results_table" summary="Data table for all results">
					<tr class="results_header_bar">
						<td class="result_table_cell1"><strong>ID</strong></td>
	                    <td class="result_table_cell2"><strong>Standard</strong></td>
	                    <c:if test="<%=!\"GL\".equalsIgnoreCase(prefBrandCode) %>"><td class="result_table_cell3"><strong>Status</strong></td></c:if>
	                    <td class="result_table_cell4"><strong>Author</strong></td>
	                    <td class="result_table_cell5">&nbsp;</td>
	                </tr>
					<liferay-ui:search-container hover="false"  searchContainer="<%=listContainer%>" >
					<liferay-ui:search-container-results>
				    <%
					pageContext.setAttribute("results",searchContainer.getResults());
					pageContext.setAttribute("total", searchContainer.getTotal() );
					currPage = searchContainer.getCur();
				    %>
					</liferay-ui:search-container-results>
					<liferay-ui:search-container-row className="com.ihg.brandstandards.db.model.Standards" keyProperty="stdId" modelVar="standard">
					<%String selectDivName = "statusDiv_"+standard.getStdId(); %>
					<%String selectName = "status_"+standard.getStdId(); %>
						<tr>
							<td class="parent_id"><%=standard.getStdId() %></td>
							<td>
							<%
								List<StandardsImages> stdImgs = StandardsImagesLocalServiceUtil.getStandardsImagesByStdId(standard.getStdId());
								if(!BrandStandardsUtil.isNullOrBlank(stdImgs))
								{
							%>
									<a onclick="showImages(<%=standard.getStdId()%>);" >
										<img src="/BSTheme-theme/images/camera_icon.jpg" class="global_icon" title="Has Images" alt="Has Images" />
									</a>
									<div id="cameraIconDiv<%=standard.getStdId()%>" style="display:none">
                                        <%  for(StandardsImages stdImg : stdImgs)
                                            {
                                                DLFileEntry igImage = null;
                                                String largeImage = "";
                                                String imageId = "";
	                                            try{
	                                            	imageId = stdImg.getImageId()+"";
	                                            	igImage = DLFileEntryLocalServiceUtil.getFileEntry(stdImg.getImageId());
	                                            	FileEntry fileEntry = DLAppLocalServiceUtil.getFileEntry(igImage.getFileEntryId());
	                                                largeImage = DLUtil.getPreviewURL(fileEntry, fileEntry.getLatestFileVersion(), themeDisplay, "");
	                                            } catch(Exception e){
	                                                _log.error("CMS Standards List: Image retrival Expection:===>"+e.getMessage());
	                                            }
                                        %>
                                                <img src="<%=largeImage %>" alt="Standards Image" id="<%=imageId %>"/><br/>
                                        <%  	
                                            }
                                        %>										
									</div>
							<%  } %>
							<%
                            if("GLBL".equals(standard.getRegionCode())) 
                            {
                                if("G".equals(standard.getIsGlobal())) 
    							{
    							    if("Y".equals(standard.getFramework())) 
    							    {
                                    %>
	                                <img src="/BSTheme-theme/images/global_icon_red.png" class="global_icon" title="Global Framework standard icon" alt="Global Framework standard icon" />
                                    <%
                                    }
    							    else
    							    {
                                    %>
                                    <img src="/BSTheme-theme/images/global_icon.png" class="global_icon" title="Global standard icon" alt="Global standard icon" />
                                    <%
                                    }
                                } 
                                else  
                                {
                                    if("Y".equals(standard.getFramework())) 
                                    {
                                    %>
                                    <img src="/BSTheme-theme/images/global_icon_halfred.png" class="global_icon" title="Multi-region Framework standard icon" alt="Multi-region Framework standard icon" />
                                    <%
                                    }
                                    else
                                    {
                                    %>
                                    <img src="/BSTheme-theme/images/multi_region_icon.png" class="global_icon" title="Multi-region standard icon" alt="Multi-region standard icon" />
                                    <%
                                    }
                                }
                            }
                            %>
							<%=standard.getTitle() %>
							</td>
							<c:if test="<%=!\"GL\".equalsIgnoreCase(prefBrandCode) %>">
							<td class="result_table_cell3"><%
                                if( (StandardsStatusUtil.hasApproverRole(user, standard) && !StandardsStatusUtil.PUBLISH_LOCK_STATUS.equals(standard.getStatus())) || isSuperAdmin || isPublishAdmin) 
                                {
                                    List<StandardsStatus> statusList = null; 
	                                if (isPublishAdmin || isSuperAdmin)
						            {
    						            if ( (!"GLBL".equals(standard.getRegionCode())) && standard.getRegionCode().equals(regionCode) )
    						            {
    						                statusList = StandardsStatusUtil.getStatuses(user, isSuperAdmin, regionCode);
                                    %>
                                    <div id="<%=selectDivName%>">
                                        <c:choose>
                                        <c:when test="<%=standard.getStatusId() != 0 %>">
                                        <select class="status_select" name="<%=selectName%>" inlineLabel="left" id="<%=selectName%>" onfocus="getCurrentValue(<%=standard.getStdId() %>, this)" onchange="showComments(<%=standard.getStdId() %>);" title="Status">
                                            <% for(StandardsStatus stdStatus : statusList) {%>
                                                <option id="<%=stdStatus.getStatusId()%>" value="<%=stdStatus.getStatusId()%>" <%=(standard.getStatusId()==stdStatus.getStatusId())?"selected='true'":""%>><%=stdStatus.getTitle()%></option>
                                            <% } %>
                                        </select>
                                        </c:when>
                                        <c:otherwise>
                                            <label class="wrapper_label status_val_label" style="padding: 0px !important;" for="<%=selectDivName%>">Not Applicable</label>
                                        </c:otherwise>
                                        </c:choose>
                                    </div>
                                    <%
    						            }
    						            else if ("GLBL".equals(standard.getRegionCode()))
    						            {
    						                statusList = StandardsStatusUtil.getStatuses(standard);
                                    %>
                                    <div id="<%=selectDivName%>">
                                        <c:choose>
                                        <c:when test="<%=standard.getStatusId() != 0 %>">
                                        <select class="status_select" name="<%=selectName%>" inlineLabel="left" id="<%=selectName%>" onfocus="getCurrentValue(<%=standard.getStdId() %>, this)" onchange="showComments(<%=standard.getStdId() %>);" title="Status">
                                            <% for(StandardsStatus stdStatus : statusList) {%>
                                                <option id="<%=stdStatus.getStatusId()%>" value="<%=stdStatus.getStatusId()%>" <%=(standard.getStatusId()==stdStatus.getStatusId())?"selected='true'":""%>><%=stdStatus.getTitle()%></option>
                                            <% } %>
                                        </select>
                                        </c:when>
                                        <c:otherwise>
                                            <label class="wrapper_label status_val_label" style="padding: 0px !important;" for="<%=selectDivName%>">Not Applicable</label>
                                        </c:otherwise>
                                        </c:choose>
                                    </div>
                                    <%
                                        }
    						            else
    						            {
                                    %>
    	                                <c:choose>
                                            <c:when test="<%=standard.getStatusId() != 0 %>">
                                            <label class="wrapper_label status_val_label"  style="padding: 0px !important;" for="<%=selectDivName%>"><%=StandardsStatusUtil.getStatusById(standard.getStatusId()).getTitle()%></label>
                                            </c:when>
                                            <c:otherwise>
                                                <label class="wrapper_label status_val_label"  style="padding: 0px !important;" for="<%=selectDivName%>">Not Applicable</label>
                                            </c:otherwise>
                                        </c:choose>
                                   <% 
                                        }
						            }
						            else
						            {
						                statusList = StandardsStatusUtil.getStatuses(standard);
								%>
								
								<div id="<%=selectDivName%>">
									<c:choose>
									<c:when test="<%=standard.getStatusId() != 0 %>">
									<select class="status_select" name="<%=selectName%>" inlineLabel="left" id="<%=selectName%>" onfocus="getCurrentValue(<%=standard.getStdId() %>, this)" onchange="showComments(<%=standard.getStdId() %>);" title="Status">
										<% for(StandardsStatus stdStatus : statusList) {%>
											<option id="<%=stdStatus.getStatusId()%>" value="<%=stdStatus.getStatusId()%>" <%=(standard.getStatusId()==stdStatus.getStatusId())?"selected='true'":""%>><%=stdStatus.getTitle()%></option>
										<% } %>
									</select>
									</c:when>
									<c:otherwise>
										<label class="wrapper_label status_val_label" style="padding: 0px !important;" for="<%=selectDivName%>">Not Applicable</label>
									</c:otherwise>
									</c:choose>
								</div>
                                <%  }%>
								<%}else {%>
									<c:choose>
										<c:when test="<%=standard.getStatusId() != 0 %>">
										<label class="wrapper_label status_val_label"  style="padding: 0px !important;" for="<%=selectDivName%>"><%=StandardsStatusUtil.getStatusById(standard.getStatusId()).getTitle()%></label>
										</c:when>
										<c:otherwise>
											<label class="wrapper_label status_val_label"  style="padding: 0px !important;" for="<%=selectDivName%>">Not Applicable</label>
										</c:otherwise>
									</c:choose>
								<%} %>
							</td>
							</c:if>
							<td><%=standard.getAuthor() %></td>
							<td class="row_expander">
							<% if( StandardsUtil.hasEditAccess(user, standard) || ("GLBL".equals(standard.getRegionCode()) && StandardsUtil.validAuthor(user.getRoles())) || isSuperAdmin || isPublishAdmin) {%>
                                <% if(StandardsStatusUtil.PUBLISH_LOCK_STATUS.equals(standard.getStatus()) && !isPublishAdmin && !isSuperAdmin)
                                {%>
                                    <img src="/BSTheme-theme/images/no_entry.png" alt="Record Locked by Publishing Icon" title="Record Locked by Publishing" />
                                <%} else { %>
    								<a href="/web/brand-standards/manage-translations?standardsId=<%=standard.getStdId()%>&<%=StandardsUtil.REQUEST_PARAM_PAGE_NUM%>=<%=curPageNum %>&<%=StandardsUtil.REQUEST_PARAM_REC_PER_PAGE %>=<%=recPerPage %>" title="Manage Translations" ><img class="log_icon" alt="Manage Translations" src="/BSTheme-theme/images/translate_icon.png" /></a>
                                <% } %>
							<%}else{ %>
								<div class="icon_placeholder">&nbsp;</div>
							<%} %>
							
		 						<a class="view_log" href="#"><img class="log_icon" alt="View And Print" title="View And Print" src="/BSTheme-theme/images/view_icon.png" onclick="showPopup(<%=standard.getStdId()%>, 'View')"/></a>
								<a class="view_log" href="#"><img class="log_icon" alt="View Log" title="View Log" src="/BSTheme-theme/images/log_icon.png" onclick="showPopup(<%=standard.getStdId()%>, 'Log')"/></a>
								<a title="View Details" class="view_details" href="#" onclick="showSpecifications(<%=standard.getStdId() %>, <%=currPage %>, <%=recPerPage %>)">
								<img src="/BSTheme-theme/images/plus_viewmore.png" alt="View Details Icon" title="View Details" /></a>
                                <% if(StandardsStatusUtil.PUBLISH_LOCK_STATUS.equals(standard.getStatus()) && !isPublishAdmin && !isSuperAdmin)
                                {%>
                                    <img src="/BSTheme-theme/images/no_entry.png" alt="Record Locked by Publishing Icon" title="Record Locked by Publishing" />
                                <%} else { %>
    								<% if(StandardsUtil.hasEditAccess(user, standard) || isSuperAdmin){%>
    									<a title="Edit Tooltip" href="/web/brand-standards/standard_wizard?id=<%=standard.getStdId() %>&<%=StandardsUtil.REQUEST_PARAM_PAGE_NUM%>=<%=curPageNum %>&<%=StandardsUtil.REQUEST_PARAM_REC_PER_PAGE %>=<%=recPerPage %>">
    										<img alt="Edit Icon" title="Edit" src="/BSTheme-theme/images/edit_pencil_icon.png" />
    									</a>
                                    <% } else if(("GLBL".equals(standard.getRegionCode()) && RegionalUtil.hasEditAccess(user, standard)) || isSuperAdmin) { %>
    		                                <a title="Edit Tooltip" href="/web/brand-standards/regional_manual?id=<%=standard.getStdId() %>&<%=StandardsUtil.REQUEST_PARAM_PAGE_NUM%>=<%=curPageNum %>&<%=StandardsUtil.REQUEST_PARAM_REC_PER_PAGE %>=<%=recPerPage %>">
    											<img alt="Edit Icon" title="Link to Regional Manual" src="/BSTheme-theme/images/edit_reg_manual_icon.png" /> 
    										</a>
    							    <% } else { %>
                                    <div class="icon_placeholder2">&nbsp;</div>
                                    <% } %>
                                <% } %>
                                
                                <% if(StandardsStatusUtil.PUBLISH_LOCK_STATUS.equals(standard.getStatus()) && !isPublishAdmin && !isSuperAdmin)
                                {%>
                                    <img src="/BSTheme-theme/images/no_entry.png" alt="Record Locked by Publishing Icon" title="Record Locked by Publishing" />
                                <%} else  if (StandardsUtil.showComplianceIcon(standard.getStdId())){ %> <!-- This condition done in CR 50.3 -->
								    <a href="/web/brand-standards/manage-compliance?id=<%=standard.getStdId()%>&<%=StandardsUtil.REQUEST_PARAM_PAGE_NUM%>=<%=curPageNum %>&<%=StandardsUtil.REQUEST_PARAM_REC_PER_PAGE %>=<%=recPerPage %>" title="Manage Compliance" ><img class="edit_icon" style="margin-right: 3px;margin-left: 3px;margin-bottom: -5px;" alt="Manage Compliance" src="/BSTheme-theme/images/calendar_small_icon.png" /></a>
                                <% } %>
									
							</td>
						</tr>
						<tr class="_<%=standard.getStdId()%> hidden_sub_results">
							<td colspan="5">
								<div id="specs_<%=standard.getStdId()%>"></div>
							</td>
          				</tr>
					</liferay-ui:search-container-row>
					<liferay-ui:search-iterator />
				</liferay-ui:search-container>
			</table>
        </div>
        <div class="rounded_container_bottom">&nbsp;</div>
    </div><!--ends rounded_container -->
</aui:form>

<!-- Image Gallery Search content --> 
<a href="#ImageGallerySearch" id="img_gallery_search" title="" class="nyroModal" style="display:none;">DOM Element (hidden div)</a>

<div id="ImageGallerySearch" class="model_content">
    <div id="img_model_frame"></div>
     <iframe src="/web/brand-standards/assign-image?COMMAND=GUEST_SEARCH_IMAGE"></iframe>
</div>
<!-- End of Image Gallery Search content --> 

<a href="#StandardsImages" id="std_imgs" title="" class="nyroModal" style="display:none;">DOM Element (hidden div)</a>

<div id="StandardsImages" class="model_content">
    <h4 class="img_modal_title_text">Images</h4>
	<div id="std_images"></div>
</div>
<!-- End of Image Gallery Search content --> 

 
<!-- Taxonomy Tree content --> 
<a href="#TreeData" id="taxonomy_tree_details" title="" class="nyroModal" style="display:none;">DOM Element (hidden div)</a>
 
<div id="TreeData" class="model_content">
      <h4>Select Index Position</h4>
      <p>Click on the arrows to expand the tree.<br/>
           Click a heading to choose where you would like to insert the Standard.<br/>
           The Standard will be inserted under the heading that you've selected.</p>
           
      <p class="small_text"><strong>You've selected: <span class="selected_tree_node">nothing yet</span></strong><span class="span_space">&nbsp;</span></p>
      <p><a class="close_page" title="accept seelcted item">Click here to accept this selection</a></p>
      <div id="Taxonomy" class=" jstree jstree-4 jstree-default jstree-focused">
      </div>
      <div class="clear"></div>
</div>
<!-- End of Taxonomy Tree content --> 
<div id="comments_div" class="comments_modalwindow_block">
 <div style="color:#FFFFFF; font-size:13px; text-align:center; margin-top:20px">
 <label class="wrapper_label" for="cmt_txt_area" title="cmt_txt_area label">
 <div style="float:left;padding-top:25%; padding-right:20px;">Comments </div><div><textarea rows="20" cols="80" name="cmt_txt_area" id="cmt_txt_area" maxlength="2000"></textarea></div>
 </label>
 </div>
 <div class="cmt_button">
    <input type="button" value="Cancel" name="cancel" id="cmt_close" />
	<input type="button" value="Submit" name="submit" id="cmt_submit"/>
 </div>

</div>       

<script type="text/javascript">

function getTreeData()
{
	jQuery("#Taxonomy").jstree("close_all",-1);
	
	jQuery("#Taxonomy").jstree({  
		"types" :{
			"max_depth": 4
		},
		"xml_data" : {
            "ajax" : {
            	"type" : "POST",
                "url" : "<%=renderResponse.encodeURL(ajaxURL.toString())%>", 
                "async": false,
                "cache": false,
                "data" : function (n) {
                		      return {
                		      	 action : "xmlTaxonomy"
                		      };
                           }
            },
            "xsl" : "nest"
        },
        "plugins" : [ "themes", "xml_data","ui"],
        "ui" : {
            "select_multiple_modifier" : "false",
             "select_limit" : 1
         },
         "themes" : {
        	 "icons" : false
         },
         "core" : { "initially_open" : [ "1" ] } 
	}) 
	.delegate(".tree_node", "click", function (event, data) {
		nodeId = jQuery(this).parent().attr("id");
		jQuery("#indexHeading").val(nodeId);
		nodeText = jQuery(this).text();
		jQuery(".selected_tree_node").text(nodeText);
		jQuery('.close_page').show();
		enableBranchSearchRadioButtons();
		showFilterCount();
	}) 
	.bind("loaded.jstree", function(e,data) {
 	    /* handler  code */
 	    //alert("Tree loaded");
 	    //Hiding root node
 	    $("ul:contains('Root Of Tree')").css('position','relative');
		$("ul:contains('Root Of Tree')").css('top','-20px');
		$("ul:contains('Root Of Tree')").css('left','-20px');
 		  
 		$("a:contains('Root Of Tree')").css("visibility","hidden");
 		$(".jstree-last .jstree-icon").first().hide();
 		$(".tree_item").first().hide();
 		//End Hiding root node 
 	    });
}

jQuery('.close_page').click(function(){
	jQuery(".open_tree_selection").val(nodeText);
	jQuery(".nyroModalClose").click(); 
});

function enableBranchSearchRadioButtons() {
    jQuery("input[name='branchSearch']").each(function(i) {
        jQuery(this).removeAttr("disabled");
    });
};

function disableBranchSearchRadioButtons() { 
	
    jQuery("#branchOnly").attr('checked', 'checked');
    jQuery("#branchAndChildren").removeAttr("checked");

    jQuery("input[name='branchSearch']").each(function(i) {
        jQuery(this).attr('disabled', 'disabled');
    });
};
$(function(){
	$(".accordionContent input.report_checkbox").on('click',function(){
		if(this.value=='147'){
			$('.attachmentLinkFields').show();
			$('.otherReportFields').hide();
		}else{
			$('.attachmentLinkFields').hide();
			$('.otherReportFields').show();
		}
	});
});
</script>
<style>
    .aui .attachmentLinkFields button.ui-multiselect {
    width: 231px !important;
}
.aui select#report_brand_select{
	width:100%;
}
    </style>
<!-- end tree code  -->
<%!
	private static Log _log = LogFactoryUtil.getLog("BSAdmin-portlet.docroot.html.standlist.view_jsp");
%>