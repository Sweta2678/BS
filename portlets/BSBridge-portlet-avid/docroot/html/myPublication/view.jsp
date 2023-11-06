<%@page import="com.ihg.brandstandards.custom.model.Standard"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer" %>
<%@page import="com.liferay.portal.kernel.search.SearchContext" %>
<%@page import="com.liferay.portal.kernel.search.SearchContextFactory" %>
<%@page import="com.liferay.portal.kernel.util.ListUtil" %>
<%@page import="com.liferay.portal.kernel.util.StringPool" %>
<%@page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@page import="com.liferay.portal.kernel.util.Validator" %>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="java.util.ArrayList"%>
<%@include file="/html/init.jsp"%>

<liferay-portlet:resourceURL var="getCountriesURL" id="regionCountryList"/>

<script type="text/javascript">
    var getCountriesURL = "${getCountriesURL}";
</script>

<c:choose>
    <c:when test="${displayNoPublishMessage}">
        Please create new publication.
    </c:when>
    <c:otherwise>
<script src="/BSBridge-portlet/js/bootstrap-tooltip.js"></script>
<script src="/BSBridge-portlet/js/mypublication.js"></script>

<portlet:actionURL name="deleteStandards" var="varMyPublication"/>

<portlet:resourceURL id='viewEditModal' var="viewEditModal">
	<portlet:param name="modalType" value="viewEdit"></portlet:param>
</portlet:resourceURL>

<portlet:renderURL var="addByIdsURL">
	<portlet:param name="pageType" value="addById"/>
</portlet:renderURL>

<portlet:resourceURL id='referenceStandards' var="referenceStandards">
	<portlet:param name="modalType" value="referenceStandards"></portlet:param>
</portlet:resourceURL>

<portlet:renderURL var="findIdURL" />

<portlet:resourceURL var="createReportURL" id='createReport'>
    <portlet:param name="requestType" value="createReport"></portlet:param>
</portlet:resourceURL>

<portlet:resourceURL var="getIssuesCountURL" id='getIssuesCount'>
    <portlet:param name="requestType" value="getIssuesCount"></portlet:param>
</portlet:resourceURL>

<style type="text/css">
	.highlight {
		background-color: #f9e55b;
		color: black;
	}
</style>

<%
	String idSearchCriteria = (String)request.getAttribute("findId"); 
	if(Validator.isNull(idSearchCriteria)){
		idSearchCriteria = "";
	} else {
		idSearchCriteria = idSearchCriteria.replaceAll(" ", ",");
	}

    String publicUrl = themeDisplay.getPathFriendlyURLPublic();
    String communityUrl = themeDisplay.getURLHome();
    String friendlyUrl = themeDisplay.getLayout().getFriendlyURL();
    String url = publicUrl + "/brand-standards" + friendlyUrl;
    boolean isStagePublish = session == null ? false : (session.getAttribute("isStagePublicationExist") == null ? false : (Boolean) session.getAttribute("isStagePublicationExist"));
    boolean isPublicationLocked = session == null ? false : (session.getAttribute("publicationLocked") == null ? false : (Boolean) session.getAttribute("publicationLocked"));
	long previousTaxonomyId = 0;
	long bridgePublishId = 0;
	bridgePublishId = (Long)request.getAttribute("bridgePublishId");
	int currPage = 0;
	List<Standard> displayList = new ArrayList<Standard>();
	displayList = (List<Standard>)request.getAttribute("displayList");
	int pageNumber = (Integer)request.getAttribute("pageNumber");
	int  noOfPages = (Integer)request.getAttribute("noOfPages");
	int importCount = (Integer)request.getAttribute("importCount");
	int previousPage = 1;
	int nextPage = noOfPages;
	String recordsPerPage = String.valueOf(request.getAttribute("recordsPerPage"));
	List<Long> missingReferences = new ArrayList<Long>();
	if (Validator.isNotNull(request.getAttribute("missingReference"))) {
		missingReferences = (List<Long>)request.getAttribute("missingReference");
	}
	if(pageNumber == previousPage)
	{
		previousPage = 1;	
	}
	else
	{
		previousPage = pageNumber-1;	
	}
	if(pageNumber == nextPage)
	{
		nextPage = noOfPages;	
	}
	else
	{
		nextPage = pageNumber+1;	
	}
%>
<script type="text/javascript">
var viewEditModal = '${viewEditModal}';
var createReportURL = '${createReportURL}';
var createEditDialog  = "";
var addByIdsURL = '${addByIdsURL}';
var addByIdDialog = '';
var stdReferenceDialog = '';
var referenceStandards = '${referenceStandards}';
var getIssuesCountURL = '${getIssuesCountURL}';

function loadIssueCount()
{
	$('#spinnerImg').show();
	$.ajax({
	  	url: getIssuesCountURL,
	  	type: "POST",
	  	dataType: "text",
	    success: function(data) {
	    	if (data != null && data != '' && typeof data != 'undefined') {
		    	$('#spinnerImg').hide();
	    		/* alert("issue count = " + data); */
 	    		$('#issuesCountVal').html(data);
	    		if (data > 0)
    			{
	    			$('#issueCountSection').show();
    			}
	    	}
	    }, 
	    error: function(data) {
	    	$('#spinnerImg').hide();
	    }
	 });
}


$(document).ready(function(){
	
	stdReferenceDialog = $( "#stdReferenceDialog_popup" ).dialog({
		title:"Reference",
		autoOpen: false,
		center:true,
		resizable:false,
		width: 717,
		 modal: true
	});
	
	createEditDialog = $( "#editStandard" ).dialog({
		autoOpen: false,
		width: 1024,
		resizable:false,
		modal: true
	});
	
	addByIdDialog = $( "#addByIdDiv" ).dialog({
    	title:"Add New Items",
		autoOpen: false,
		center:true,
		resizable:false,
    	width: 860,
    	 modal: true,
    	open: function() {
           $('#closePopUp').bind('click', function() {
                $('#addByIdDiv').dialog('close');
            })
        }
	});
	
	var idCriteria = [<%=idSearchCriteria%>];
	for(var l = 0; l < idCriteria.length; l++) {
		$("." +idCriteria[l]).addClass('highlight');
	}
	
    $('#standards').tooltip({
       selector: "a[data-toggle=tooltip]"
    });
    
    $("#myPubIssueCount").click(function() {
    	var errViewURL = "/web/brand-standards/bridge/my-publication-issues";
        window.location = errViewURL;
    });
    
    loadIssueCount();
});

function stdReferencePopup(stdId) {
	//load block UI
	loadProgressBar();
	$.ajax({
	  	url :referenceStandards,
	  	data:{"stdId":stdId},
	  	type: "POST",
	  	dataType: "text",
	    success: function(data) {
	    	if (data != null && data != '' && typeof data != 'undefined') {
	    		//_gaq.push(['_trackEvent', 'Search Standards', "Open Dialog", "Standard reference dialog for standard "+stdId]);
	    		$('#stdReferenceDialog_popup').html(data);
	    		stdReferenceDialog.dialog( "open" );
	    	}
	    	jQuery.unblockUI();
	    }
	 });
}

function submitPagination(source, value)
{	var pageNoValue = "";
	var itemsPageValue = "";
	itemsPageValue = $("#itemsPerPage").val();
	 pageNoValue=$("#pageNumber").val();
	if(source == "links")
	{
		pageNoValue = value;
	}
	if(source == 'itemsPerPageLower')
	{
		itemsPageValue = $("#itemsPerPageLower").val();
	}
	if(source == 'pageNumberLower')
	{
		 pageNoValue=$("#pageNumberLower").val();
	}
	if(source == 'itemsPerPage' || source == 'itemsPerPageLower')
	{
		pageNoValue = 1;
	}
	var submitUrl = "<%=url%>?pageNumber="+pageNoValue+"&itemsPerPage="+itemsPageValue;
	window.location = submitUrl;
}

function deleteStd(stdId) 
{
	var nodeObject = document.getElementById('<portlet:namespace/>hidStdId');
	nodeObject.value = stdId;
	jQuery.msgBox({
		title:"Are You Sure",
		content: "Are you sure you want to delete this?" ,
		type:"confirm",
		buttons: [{ value: "Yes" }, { value: "No" }],
		success: function (result) {
			if (result == "Yes") {
				jQuery( "#<portlet:namespace/>myPublish" ).submit();
			}
		}
	});
}

function submitViewImport() {
	var viewURL = "/web/brand-standards<%=themeDisplay.getLayout().getFriendlyURL()%>?renderJSP=viewImport";
	window.location = viewURL;
}

function editStd(stdId) 
{
	$.ajax({
	  	url :viewEditModal,
	  	data:{"stdId":stdId},
	  	type: "POST",
	  	dataType: "text",
	    success: function(data) {
	    	
	    		$('#editStandard').html(data);
	    		$('#editStandard').attr("display","block");
	    		createEditDialog.dialog( "open" );
	    	
	    	jQuery.unblockUI();
	    }
	 });

}

function addByIds() {
	//load block UI
	loadProgressBar();
	$.ajax({
	  	url :addByIdsURL,
	  	type: "POST",
	  	dataType: "text",
	    success: function(data) {
	    	
	    	if (data != null && data != '' && typeof data != 'undefined') {
	    		$('#addByIdDiv').html(data);
	    		addByIdDialog.dialog( "open" );
	    	}
	    	jQuery.unblockUI();
	    }, error: function(data) {
	    	jQuery.unblockUI();
	    }
	 });
}

function openErrorDetails()
{
	//load block UI
	loadProgressBar();
	$.ajax({
	  	url: errorDetailsURL,
	  	type: "POST",
	  	dataType: "text",
	    success: function(data) {
	    	
//	    	if (data != null && data != '' && typeof data != 'undefined') {
//	    		$('#addByIdDiv').html(data);
//	    		addByIdDialog.dialog( "open" );
//	    	}
	    	jQuery.unblockUI();
	    }, error: function(data) {
	    	jQuery.unblockUI();
	    }
	 });	
}

function loadProgressBar () {
	jQuery.blockUI({ message: '<h3><img src="/BSBridge-theme/images/busy.gif" /> </h3>' });
}


function highlightNew()
{
	if ($('#showNewHighlight').is(':checked'))
	{
		$(".standards_NEW").addClass('highlight');
	}
	else 
	{
		$(".standards_NEW").removeClass('highlight');
	}
	
	if ($('#showUpdatedHighlight').is(':checked'))
	{
		$(".standards_UPDATED").addClass('highlight');
	}
	else
	{
		$(".standards_UPDATED").removeClass('highlight');
	}
}

function hideReferences()
{
	if ($('#missingRefs').is(':checked')) {
		$('.reference_missing').css('display','inline-block');
	} else {
		$('.reference_missing').css('display','none');
	}
}

</script>

<style type="text/css">
	.taglib-search-iterator-page-iterator-top {margin-left: -20px;}
    
    .show_opts_div {
        float: right;
    }
    
    .find_opts {
        width: 388px;
    }
 
.my_publish_btn {
    width: 112px;
    float: left;
    display: block;
    margin-left: 0;
    min-height: 30px;
    box-sizing: border-box;
}
</style>
<!-- Keep the below 2 un-closed divs as this is a fix for footer left aligning issue -->
<div><div>

<div class="row" > 
	<div class="well well-small" style="margin-bottom: 10px;" > 
		<div class="row" style="margin-top: 5px;"> 
			<div class="my_publish_btn"> 
				<div class="form-inline" style="margin-bottom: 0;"> 
				  <%if(bridgePublishId > 0 && !isPublicationLocked){ %>
					<a class="btn btn-primary" href="${addByIdsURL}" role="button" data-toggle="modal"><i class="icon-white icon-plus"></i> Add By ID</a>
					<%} %>
					<div style="margin-top: 3px;"> </div> 
				</div> 
			</div> 
            <div class="my_publish_btn">
                <a class="btn btn-primary my-publication-report" href="#" id="my-publication-report" > <i class="icon-white icon-arrow-down"></i> Export</a>
                <!-- <button class="btn btn-primary" id="summary-report">Export</button> -->
            </div>
			<div class="span6 pull-right find_opts"> 
				<form class="form-inline" style="margin-bottom: 0;" id="findForm" name="findForm" method="post" action="<%= findIdURL%>">
					<span><strong>Find By ID:</strong></span> 
					<input type="text" style="margin-bottom: 0px;" class="input-medium" placeholder="Enter STD ID to find ..." 
					  maxlength="2000" value='<c:if test="${not empty findId}">${findId} </c:if>' id="findId" name="findByStdId"> 
					<a href="#" role="button" class="btn btn-primary" onclick="javascript:find();"><i class="icon-search icon-white"></i> Go</a> 
					<a href="#" role="button" class="btn" onclick="javascript:clearSearch();"><i class="icon-remove"></i> Clear</a> 
				</form>
			</div> 
		</div> 
		<hr/>  
		<div class="row" style="margin-top: 5px;">
			<div class="span8 form-inline">	 
				
					<label>Items Per Page:</label>
					<select class="input-mini" id="itemsPerPage" name="itemsPerPage" onchange="submitPagination('itemsPerPage',0)">
						<c:forEach var="opt" items="${itemsPerPageOptions}">
							<%
								String opt = (String)pageContext.getAttribute("opt");
								String selected = "";
								if(recordsPerPage != null && opt != null && recordsPerPage.trim().equalsIgnoreCase(opt.trim())) {
									selected = "selected";
								}
							%>
							<option <%=selected%> value="${opt}">${opt}</option>
						</c:forEach>
					</select>
					<label>&nbsp;|&nbsp;Page:</label>
					<select class="input-mini" id="pageNumber" name="pageNumber" onchange="submitPagination('pageNumber',0)">
						<% 	for(int i = 0; i < noOfPages; i++) {
								if(i+1 == pageNumber) { 
						%>  
									<option selected value="<%=i+1%>"><%=i+1 %></option>
						<%  	} else { %>
									<option value="<%=i+1%>"><%=i+1 %></option>
						<%  	}
				          	} 
				        %>
					</select>
				    <span> of &nbsp; <%=noOfPages %></span>
				    <span>&nbsp;|&nbsp;</span>
				   	<% if(pageNumber != 1) { %>
				   		<a href="#" onclick="submitPagination('links', 1)">
				   			<i class="icon-first"></i>First
				   		</a>
				   	<% } else { %>
				   		<i class="icon-first"></i>First
				   	<% } %>
				    <span>&nbsp;|&nbsp;</span>
				   	<% if(pageNumber != 1) { %>
				   		<a href="#" onclick="submitPagination('links', <%=previousPage%>)">
				   			<i class="icon-previous"></i>Previous
				   		</a>
				   	<% } else { %>
				   		<i class="icon-previous"></i>Previous
				   	<% } %>
				    <span>&nbsp;|&nbsp;</span>
				    <% if(pageNumber != noOfPages) { %>
				    	<a href="#" onclick="submitPagination('links', <%=nextPage%>)">
				    		<i class="icon-next"></i>&nbsp;Next
				    	</a>
				    <% } else { %>
				    <i class="icon-next"></i>&nbsp;Next
				    <% } %>
				    <span>&nbsp;|&nbsp;</span>
				    <% if(pageNumber != noOfPages) { %>
				    	<a href="#" onclick="submitPagination('links', <%=noOfPages%>)">
				    		<i class="icon-last"></i>&nbsp;Last
				    	</a>
				    <% } else { %>
				    	<i class="icon-last"></i>&nbsp;Last
				    <% } %>
				
	        	
			</div>
			 <div class="span2 show_opts_div">
				<div class="pull-right">
   	                <span>&nbsp;<img src="/BSBridge-theme/images/busy.gif" id="spinnerImg" style="display: none;" />&nbsp;</span>
					<span id="issueCountSection" style="display: none;">
						<a id="myPubIssueCount" class="issue_counter" href="#"><span><i class="icon-red icon-exclamation-sign"></i> 
						<span id="issuesCountVal">${issuesCount}</span> Issues</span></a>
					</span>
					<a class="btn btn-small" href="#" id="show_opts">Show Options</a>
				</div>
			</div> 
		</div>
		 <div class="displayOptions" id="showHideDisplay" style="display: none;">
			<div class="row">
				<hr>
				<div style="padding-bottom:0px; margin-bottom:0;" class="form-inline span12">
					<label class="checkbox"><strong>Display Options:</strong></label> 
					<label class="radio"> <input id="showNewHighlight" name="optionsRadios" type="checkbox" onclick="javascript:highlightNew();" /> Highlight New </label> 
					<label class="radio"> <input id="showUpdatedHighlight" name="optionsRadios" type="checkbox"  onclick="javascript:highlightNew();"/> Highlight Published </label> 
					<label class="checkbox"> <input checked="checked" id="missingRefs" type="checkbox" onclick="javascript:hideReferences();" /> Show missing cross-references </label>
					<button class="btn btn-mini pull-right btn-clear-option">Clear</button>
					<div class="clearfix"></div>
			 	</div>
			</div>
		</div> 
	</div>
</div>


<aui:form action="<%=varMyPublication %>" method="post" name="myPublish" id="myPublish">
<aui:input type="hidden" id="hidStdId" name="hidStdId" value=""/>
<section id="standards">		
<%	
if(displayList!=null && displayList.size()>0)
{	for(Standard standards : displayList)
	{
	List<Standard> specsList = standards.getSpecifications();
	List<Standard> gdlnsList = standards.getGuidelines();
	if(previousTaxonomyId != standards.getTaxonomyId()) {
		String indexPath = standards.getTaxonomyPath();
		String currentIndex = standards.getTaxonomyText();
		if (indexPath != null && indexPath.contains(currentIndex)) {
			indexPath = indexPath.replace(currentIndex, "");
	%>
		<div class="row">
			<h4><span class="grey"><%=indexPath %></span> <span class="blue"><%= currentIndex%></span></h4>
		</div>
		<%} else { %>
					
		<div class="row">
			<h4><span class="grey"><%=indexPath%></span></h4>
		</div>
		<% 		} %>
			
		<% 	} 
			previousTaxonomyId = standards.getTaxonomyId();
		%>

		<div class="row">
			<table border="0" class="specs">
				<tbody>                                                           
					<tr >
					<%if(standards.isMustPublish() == false && "N".equals(standards.getIsGlobal())) { %>	
                    <td width="50px">
                    	<button  class='btn btn-mini <%=standards.getRegionCode()%> <%if (standards.getRegionCode().equals("btn-primary")){ %>btn-primary-DB <%} %>' 
                    		type="button" 
                    	 onclick="getCountry('<%=standards.getStdId()%>');">
                    	${regionCode}</button>
                    </td>
                    
					<td width="10px">
						<a data-original-title="Edit" title="" data-placement="right" data-toggle="tooltip" href="javascript:editStd(<%=standards.getStdId()%>)" id="edit_std"><i class="icon-edit"></i></a>
					</td>
					<td width="10px">
						<a data-original-title="Delete" title="" data-placement="right" data-toggle="tooltip" href="javascript:deleteStd(<%=standards.getStdId()%>)" id="remove_std"><i class="icon-remove"></i></a>
					</td>
					<% } else { 
						if(standards.isRemovable()) {
					%>
					<td colspan="2" width="70">
						<span class="label badge-important">Global Must</span>
					</td>
					<td width="10px">
						<a data-original-title="Delete" title="" data-placement="right" data-toggle="tooltip" href="javascript:deleteStd(<%=standards.getStdId()%>)" id="remove_std"><i class="icon-remove"></i></a>
					</td>
					<%	} else {
					%>
						<td colspan="3" width="70">
							<span class="label label-success">Global Must</span>
						</td>
					<%	
						}
						
					}
					%>
					<td colspan="2" width="870">					
						<strong><%=standards.getTitle()%></strong>&nbsp;<span class="grey standards_<%=standards.getStatus()%> <%=standards.getStdId()%> ">[<%=standards.getStdId()%>]</span>
						<% 
							if (Validator.isNotNull(standards.getStdRefId())) {
								boolean isRefMissing = false;
								for (String refIds : standards.getStdRefId().split(",")) {
									if (missingReferences.contains(GetterUtil.getLong(refIds))) {
										isRefMissing = true;
										break;
									}
								}
								if (isRefMissing) {
						%>
							<a href="#" class="label label-important reference_missing" data-toggle="tooltip" data-placement="top" title="" data-original-title="Cross reference missing">
									<i class="icon-share-alt icon-white"></i>${referencedIds} [
						<%
								} else {
						%>
									<a href="#" class="label label-default"><i class="icon-share-alt icon-white"></i>${referencedIds} [
						<%	
								}
								int count =0;
								for (String refIds : standards.getStdRefId().split(",")) {
							    	if (count > 0) {
						%>
										,&nbsp;
						<%        
							    	}
						%>
							 		<span onclick='javascript:stdReferencePopup(<%=refIds %>)'><%=StringUtil.trim(refIds) %></span>
						<%
									count++;
								}
						%>
								]</a>
						<%
							}
						%>
					</td>
					</tr>
					<%
					for(Standard specs: specsList)
					{
					   // publishStdIds.add(specs.getPublishStdId());
						%>
					
					<tr >
					<%if(specs.isMustPublish() == false && "N".equals(specs.getIsGlobal())){ %>
                    	<td width="50px">
                    		<button class='btn btn-mini <%=specs.getRegionCode()%> <%if (specs.getRegionCode().equals("btn-primary")){ %>btn-primary-DB <%} %>' 
                    		type="button" 
                    		onclick="getCountry('<%=specs.getStdId()%>');">${regionCode}</button>
                    	</td>
						<td width="10px">&nbsp;</td>
						<td width="10px" class="pull-left">
							<a data-original-title="Delete" title="" data-placement="right" data-toggle="tooltip" href="javascript:deleteStd(<%=specs.getStdId()%>)" id="remove_std"><i class="icon-remove"></i></a>
						</td>
					<% } else { 
						if(specs.isRemovable()) {
					%>
					<td colspan="2" width="70">
						<span class="label badge-important">Global Must</span>
					</td>
					<td width="10px">
						<a data-original-title="Delete" title="" data-placement="right" data-toggle="tooltip" href="javascript:deleteStd(<%=specs.getStdId()%>)" id="remove_std"><i class="icon-remove"></i></a>
					</td>
					<%	} else {
					%>
						<td colspan="2" width="70">
							<span class="label label-success">Global Must</span>
						</td>
						<td class="bull">&bull;</td>
					<%	
						}
						
					}
					%>
					
					<td width="870">
						<%=specs.getTitle() %>&nbsp;<span class="grey standards_<%=specs.getStatus()%> <%=specs.getStdId() %>">[<%=specs.getStdId() %>] </span>
						<% 
							boolean isRefMissing = false;
							if (Validator.isNotNull(specs.getStdRefId())) {
								for (String refIds : specs.getStdRefId().split(",")) {
									if (missingReferences.contains(GetterUtil.getLong(refIds))) {
										isRefMissing = true;
										break;
									}
								}
								if (isRefMissing) {
							%>
									<a href="#" class="label label-important reference_missing" data-toggle="tooltip" data-placement="top" title="" data-original-title="Cross reference missing"><i class="icon-share-alt icon-white"></i>${referencedIds} [
							<%
								} else {
							%>
									<a href="#" class="label label-default"><i class="icon-share-alt icon-white"></i>${referencedIds} [
							<%	
								}
								int count =0;    
								for (String refIds : specs.getStdRefId().split(",")) {
								    if (count > 0) {
							%>
								,&nbsp;
							<%	        
								    }
							%>
									 <span onclick='javascript:stdReferencePopup(<%=refIds %>)'><%=StringUtil.trim(refIds) %></span>
							<%	    count++;
								    }
							%>
								]</a>
							<%
								}
						%>
						</td>
					</tr>
					<%
					}
					if(gdlnsList.size()>0)
					{
						%>
						<tr>
							<td class="update invisible"></td>
							<td>&nbsp;</td>
							<td class="lg" colspan="3" style="padding-top:5px;"><strong>Guidelines</strong></td>
						</tr>
						<%
					}
					for(Standard gdln: gdlnsList)
					{
					  //  publishStdIds.add(gdln.getPublishStdId());
						%>
					
					<tr>
					<%if(gdln.isMustPublish() == false && "N".equals(gdln.getIsGlobal())) { %>
						<td width="50px">
					   		<button  class='btn btn-mini <%=gdln.getRegionCode()%> <%if (gdln.getRegionCode().equals("btn-primary")){ %>btn-primary-DB <%} %>' 
                    		type="button" 
                    		onclick="getCountry('<%=gdln.getStdId()%>');" >${regionCode}</button>
                    	</td>
						<td width="10px">&nbsp;</td>
						<td width="10px" class="pull-left">
							<a data-original-title="Delete" title="" data-placement="right" data-toggle="tooltip" href="javascript:deleteStd(<%=gdln.getStdId()%>)" id="remove_std"><i class="icon-remove"></i></a>
						</td>
					<% } else { 
						if(gdln.isRemovable()) {
					%>
					<td colspan="2" width="70">
						<span class="label badge-important">Global Must</span>
					</td>
					<td width="10px">
						<a data-original-title="Delete" title="" data-placement="right" data-toggle="tooltip" href="javascript:deleteStd(<%=gdln.getStdId()%>)" id="remove_std"><i class="icon-remove"></i></a>
					</td>
					<%	} else {
					%>
						<td colspan="2" width="70">
							<span class="label label-success">Global Must</span>
						</td>
						<td class="bull lg">&bull; &nbsp;</td>
					<%	
						}
						
					}
					boolean isSearchMatchedGdlnId = false;					
					%>
					<td width="870" class="lg ">
						<%=gdln.getTitle() %>&nbsp; <span class="grey standards_<%=gdln.getStatus()%> <%=gdln.getStdId() %>">[<%=gdln.getStdId() %>]</span>
						<%
							boolean isRefMissing = false;
							if (Validator.isNotNull(gdln.getStdRefId())) {
							for (String refIds : gdln.getStdRefId().split(",")) {
								if (missingReferences.contains(GetterUtil.getLong(refIds))) {
									isRefMissing = true;
									break;
								}
							}
							if (isRefMissing) {
						%>
								<a href="#" class="label label-important reference_missing" data-toggle="tooltip" data-placement="top" title="" data-original-title="Cross reference missing"><i class="icon-share-alt icon-white"></i>${referencedIds} [
						<%
							} else {
						%>
								<a href="#" class="label label-default"><i class="icon-share-alt icon-white"></i>${referencedIds} [
						<%	
							}
							int count =0;    
							for (String refIds : gdln.getStdRefId().split(",")) {
							    if (count > 0) {
						%>
								,&nbsp;
						<%	        
							    }
						%>
								 <span onclick='javascript:stdReferencePopup("<%=refIds %>")'><%=StringUtil.trim(refIds) %></span>
						<%	    
								count++;    
							}
						%>
							]</a>
						<%
							}
						%>
						</td>
						
					</tr>
					<%
		}
		previousTaxonomyId = standards.getTaxonomyId();
		%>
				</tbody>
			 </table>
		  <hr/>
		 </div>
	<%
					}
				}
			
			 %>
</section>
</aui:form>

<!-- Countries pop-up -->
<div id="regionCountrylist" title="View Attribution" style="display:none">
    <form id="countryForm" name="countryForm">
        <input type="hidden" id="bridgePublishId" name="bridgePublishId" value=""/>
        <input type="hidden" id="regionCode" name="regionCode" value=""/>
        <div class="modal-body" id="modal-body-region-code">
             <div class="row-fluid">
                  <div class="table-rgn-padding">
                    <table width="100%" cellspacing="4" cellpadding="4" id="wobble">
                      <tbody id="rgn-cnt-tbody">
                    </tbody></table>
                  </div>
            </div> 
        </div>
        <div class="modal-footer">
            <div class="pull-left"><button type="button" class="btn regioncountrycancel">Cancel</button></div>
        </div>
    </form>
</div>
<!-- End Of Countries pop-up -->

<!-- Export Report -->
<div id="createReportDialog" title="Create Report" style="display:none">
    <form id="createReportForm" name="createReportForm" method="post" >
        <div class="modal-body">
            <div id="reportLst">
                <span><input type='radio' name='reports' value='126' checked /> My Publication Report</span>
            </div>
            <h4>Report Title <input type="text" id="reportTitle" name="reportTitle"/> </h4> 
          </div>
        <div class="modal-footer">
            <div class="pull-left"><button type="button" class="btn reportCancel">Cancel</button></div>
            <div class="pull-right"><a class="btn btn-primary" href="javascript:createReport()">Run</a></div>
        </div>
    </form>
</div>
<!-- End Of Export Report -->

<section class="row">
	<div class="well well-small" style="margin-top: 5px;">
		<div class="form-inline" style="margin-top: 5px;">
         		
				<label>Items Per Page:</label>
				<select class="input-mini" id="itemsPerPageLower" name="itemsPerPageLower" onchange="submitPagination('itemsPerPageLower',0)">
					<c:forEach var="opt" items="${itemsPerPageOptions}">
						<%
							String opt = (String)pageContext.getAttribute("opt");
							String selected = "";
							if(recordsPerPage != null && opt != null && recordsPerPage.trim().equalsIgnoreCase(opt.trim())) {
								selected = "selected";
							}
						%>
						<option <%=selected%> value="${opt}">${opt}</option>
					</c:forEach>
				</select>
				<label>&nbsp;|&nbsp;Page:</label>
				<select class="input-mini" id="pageNumberLower" name="pageNumberLower" onchange="submitPagination('pageNumberLower',0)">
					<% 	for(int i = 0; i < noOfPages; i++) {
							if(i+1 == pageNumber) { 
					%>  
								<option selected value="<%=i+1%>"><%=i+1 %></option>
					<%  	} else { %>
								<option value="<%=i+1%>"><%=i+1 %></option>
					<%  	}
			          	} 
			        %>
				</select>
			    <span> of&nbsp; <%=noOfPages %></span>
			    <span>&nbsp;|&nbsp;</span>
			   	<% if(pageNumber != 1) { %>
			   		<a href="#" onclick="submitPagination('links', 1)">
			   			<i class="icon-step-backward"></i>First
			   		</a>
			   	<% } else { %>
			   		<i class="icon-step-backward"></i>First
			   	<% } %>
			    <span>&nbsp;|&nbsp;</span>
			   	<% if(pageNumber != 1) { %>
			   		<a href="#" onclick="submitPagination('links', <%=previousPage%>)">
			   			<i class="icon-chevron-left"></i>Previous
			   		</a>
			   	<% } else { %>
			   		<i class="icon-chevron-left"></i>Previous
			   	<% } %>
			    <span>&nbsp;|&nbsp;</span>
			    <% if(pageNumber != noOfPages) { %>
			    	<a href="#" onclick="submitPagination('links', <%=nextPage%>)">
			    		<i class="icon-chevron-right"></i>&nbsp;Next
			    	</a>
			    <% } else { %>
			    <i class="icon-chevron-right"></i>&nbsp;Next
			    <% } %>
			    <span>&nbsp;|&nbsp;</span>
			    <% if(pageNumber != noOfPages) { %>
			    	<a href="#" onclick="submitPagination('links', <%=noOfPages%>)">
			    		<i class="icon-step-forward"></i>&nbsp;Last
			    	</a>
			    <% } else { %>
			    	<i class="icon-step-forward"></i>&nbsp; Last
			    <% } %>
       	</div>
       </div>
</section>		

		<div id="stdReferenceDialog_popup" style="display: none;" title="${referenceTitle}"></div>
		<div id="editStandard" title="Modify Standard" style="display:none"> </div>
		<div id="addByIdDiv" title="Add New Items" style="display:none"></div>
    </c:otherwise>
</c:choose>