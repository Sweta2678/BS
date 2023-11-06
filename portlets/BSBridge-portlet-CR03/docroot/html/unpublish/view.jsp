<%@page import="com.ihg.brandstandards.custom.model.Standard"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@include file="/html/init.jsp"%>
<script type="text/javascript" src="/BSBridge-theme/js/treeAdmin/jquery.blockUI.js"></script>
<script type="text/javascript" src="/BSBridge-theme/js/treeAdmin/jquery.msgBox.js"></script>
<portlet:renderURL var="findByIdURL" />
<c:choose>
	<c:when test="${displayNoPublishMessage}">
		Please create new publication.
	</c:when>
	<c:otherwise>
<%
	String idSearchCriteria = (String)request.getAttribute("findId"); 
	if(Validator.isNull(idSearchCriteria)){
		idSearchCriteria = "";
	} else {
		idSearchCriteria = idSearchCriteria.replaceAll(" ", ",");
	}
	long previousTaxonomyId = 0;
	int currPage = 0;
%>
<portlet:actionURL name="moveToPublish" var="moveToPublishUrl"/>
<portlet:resourceURL var="getCountriesURL" id="regionCountryList"/>

<portlet:resourceURL var="createReportURL" id='createReport'>
    <portlet:param name="requestType" value="createReport"></portlet:param>
</portlet:resourceURL>

<style type="text/css">
	.lfr-search-container {margin-top: 0px;!important;}
	.pager {margin: 10px 0 !important;}
	.aui .btn-primary-DB, .aui .btn-primary-DB:focus, .aui .btn-primary-DB:hover {
	    background-color: #235ba3;
	    background-image: linear-gradient(to bottom, #3a75c4, #003571);
	}
	.aui .btn-info, .aui .btn-info:focus, .aui .btn-info:hover {
	    background-color: #49afcd;
	    background-image: linear-gradient(to bottom, #5bc0de, #2f96b4);
	    color: #fff;
	}
	.aui .btn-success:focus{
		background-color: #5bb75b;
    	background-image: linear-gradient(to bottom, #62c462, #51a351);
    	color: white;
	}
	
	.my_publish_btn {
    width: 112px;
    float: left;
    display: block;
    margin-left: 0;
    min-height: 30px;
    box-sizing: border-box;
}
.highlight {
		background-color: #f9e55b;
		color: black;
	}
</style>
<!-- Keep the below 2 un-closed divs as this is a fix for footer left aligning issue -->
<div><div>
<div class="row" > 
	<div class="well well-small" style="margin-bottom: 2px;" > 
		<div class="row" style="margin-top: 5px;"> 
            <div class="my_publish_btn" style="float:left;">
            	 <c:if test="${showExportButton eq 'YES'}">  
                	 <a class="btn btn-primary unpublish-report" href="#" id="unpublish-report" ><i class="icon-white icon-arrow-down"></i>Export</a>
                </c:if> 
            </div>
			<div class="span6 pull-right find_opts"> 
				<form class="form-inline" style="margin-bottom: 0;" id="findForm" name="findForm" method="post" action="<%= findByIdURL%>">
					<span><strong>Find By ID:</strong></span> 
					<input type="text" style="margin-bottom: 0px;" class="input-medium" placeholder="Enter STD ID to find ..." 
					  maxlength="2000" value='<c:if test="${not empty findId}">${findId} </c:if>' id="findId" name="findByStdId"> 
					<a href="#" role="button" class="btn btn-primary" onclick="javascript:find();"><i class="icon-search icon-white"></i> Go</a> 
					<a href="#" role="button" class="btn" onclick="javascript:clearSearch();"><i class="icon-remove"></i> Clear</a> 
				</form>
			</div> 
		</div>  
	</div>
</div>

	<%-- <div class="row" style="background-color:#e5e5e5;">
	<table>
		<tr>
			<td width="58%">
				<c:if test="${showExportButton eq 'YES'}"> 
	   				 <div class=" export-report">
	       				 <a class="btn btn-primary unpublish-report" href="#" id="unpublish-report" ><i class="icon-white icon-arrow-down"></i>Export</a>
	   				 </div>
			 </c:if> 
			</td>
			<td>
				 <div class="pull-right"> 
				<form class="form-inline" style="margin-bottom: 0;" id="findForm" name="findForm" method="post" action="<%= findByIdURL%>">
					<span><strong>Find By ID:</strong></span> 
					<input type="text" style="margin-bottom: 0px;" class="input-medium" placeholder="Enter STD ID to find ..." 
					  maxlength="2000" value='<c:if test="${not empty findId}">${findId} </c:if>' id="findId" name="findByStdId"> 
					<a href="#" role="button" class="btn btn-primary" onclick="javascript:find();"><i class="icon-search icon-white"></i> Go</a> 
					<a href="#" role="button" class="btn" onclick="javascript:clearSearch();"><i class="icon-remove"></i> Clear</a> 
				</form>
		</div> 
			</td>
		</tr>
	</table>
	
	   
	</div> --%>


<!-- Countries pop-up -->
<div id="regionCountrylist" title="View Attribution" style="display:none">
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
</div>
<!-- End Of Countries pop-up -->

<section id="standards">
<form action="${moveToPublishUrl}" method="post" name="unpublishFM" >
<div id="progress_standards">
	<table class="results_table">
        <liferay-ui:search-container hover="false" searchContainer="${searchContainer}"  emptyResultsMessage="No Standards Available" >
            <liferay-ui:search-container-results>
            <%
                pageContext.setAttribute("results",searchContainer.getResults());
                pageContext.setAttribute("total", searchContainer.getTotal() );
                currPage = searchContainer.getCur();
            %>
            </liferay-ui:search-container-results>
            <liferay-ui:search-container-row className="com.ihg.brandstandards.custom.model.Standard" keyProperty="stdId" modelVar="standards">
			<%	
				List<Standard> specsList = standards.getSpecifications();
				List<Standard> gdlnsList = standards.getGuidelines();
				if(previousTaxonomyId != standards.getTaxonomyId()) {
					String indexPath = standards.getTaxonomyPath();
					String currentIndex = standards.getTaxonomyText();
					if (indexPath != null && indexPath.contains(currentIndex)) {
						indexPath = indexPath.replace(currentIndex, "");
			%>
						<tr><td colspan="4">
                        <div class="row">
							<h4><span class="grey"><%=indexPath %></span> <span class="blue"><%= currentIndex%></span></h4>
						</div>
			<%		} else { %>
						<tr><td colspan="3">
                        <div class="row">
							<h4><span class="grey">${standards.taxonomyPath}</span></h4>
						</div>
			<% 		} %>
				<div class="row">&nbsp;</div>
                </td></tr>
			<% 	} 
				previousTaxonomyId = standards.getTaxonomyId();
			%>
					<tr >
						<td width="34px" class="cen">
							<c:if test="${not empty standards.status && standards.status ne 'GLBL_NOT_IN_MUST' && standards.status ne 'NOT_RGN' 
													&& standards.status ne 'NOT_BRND' && standards.status ne 'MUST_NOT' && standards.status ne 'MOVED_CTRY_DIFF'}">
								<a data-original-title="Move to Publish List" title="" data-placement="right" data-toggle="tooltip" 
									href="javascript:submitUnpublishFM(${standards.stdId})" id="chev">
									<i class="icon-chevron-left"></i>
								</a>
							</c:if>
						</td>
						<td width="71px" class="cen">
							<c:choose>
								<c:when test="${standards.regionCode eq 'GLBL'}">
									<%-- <c:choose>
										<c:when test="${standards.isGlobal eq 'G'}">
											<c:choose>
												<c:when test="${standards.framework eq 'Y'}">
													<img src="/BSBridge-theme/images/global_icon_red.png"
														class="global_icon" title="Global Framework standard icon"
														alt="Global Framework standard icon" /> 
												</c:when>
												<c:otherwise>
													<img src="/BSBridge-theme/images/global_icon.png"
														class="global_icon" title="Global standard icon"
														alt="Global standard icon" />
												</c:otherwise>
											</c:choose>
										</c:when>
										<c:otherwise>
											<c:choose>
												<c:when test="${standards.framework eq 'Y'}">
													<img src="/BSBridge-theme/images/global_icon_halfred.png"
														class="global_icon" title="Multi-region Framework standard icon"
														alt="Multi-region Framework standard icon" />
												</c:when>
												<c:otherwise>
													<img src="/BSBridge-theme/images/multi_region_icon.png"
														class="global_icon" title="Multi-region standard icon"
														alt="Multi-region standard icon" />
												</c:otherwise>
											</c:choose>
										</c:otherwise>
									</c:choose> --%>
									<!-- <span class="label label-success">Global Must</span> -->
									<button type="button" class="btn btn-mini btn-success" onclick="getCountry('${standards.stdId}');">Global Must</button>
								</c:when>
								<c:otherwise>
									<c:if test="${'N' eq standards.isGlobal}">
										<button type="button" class="btn btn-mini ${standards.curRegion} ${standards.curRegion}-DB" onclick="getCountry('${standards.stdId}');">${standards.regionCode}</button>
									</c:if>
								</c:otherwise>
							</c:choose>
						</td>
						<td colspan="2" width="910px">
							<strong>${standards.title}</strong>&nbsp;
							<span class="grey ${standards.stdId}" id="stdId">[${standards.stdId}]</span>
						</td>
					</tr>
				<c:forEach var="spec" items="${standards.specifications}">
					<tr >
						<td width="34px" class="cen">
							<c:if test="${not empty spec.status && spec.status ne 'GLBL_NOT_IN_MUST' && spec.status ne 'NOT_RGN' 
													&& spec.status ne 'NOT_BRND' && spec.status ne 'MUST_NOT' && spec.status ne 'MOVED_CTRY_DIFF'}">
								<c:choose>
									<c:when test="${not empty standards.status}">
										<a data-original-title="Move to Publish List" title="" data-placement="right" data-toggle="tooltip" 
											href="javascript:submitUnpublishFM('${standards.stdId},${spec.stdId}')" id="chev">
											<i class="icon-chevron-left"></i>
										</a>
									</c:when>
									<c:otherwise>
										<a data-original-title="Move to Publish List" title="" data-placement="right" data-toggle="tooltip" 
											href="javascript:submitUnpublishFM('${spec.stdId}')" id="chev">
											<i class="icon-chevron-left"></i>
										</a>
									</c:otherwise>
								</c:choose>
							</c:if>
						</td>
						
						<td width="71px" class="cen">
							<c:choose>
								<c:when test="${spec.regionCode eq 'GLBL'}">
									<%-- <c:choose>
										<c:when test="${spec.isGlobal eq 'G'}">
											<c:choose>
												<c:when test="${spec.framework eq 'Y'}">
													<img src="/BSBridge-theme/images/global_icon_red.png"
														class="global_icon" title="Global Framework standard icon"
														alt="Global Framework standard icon" /> 
												</c:when>
												<c:otherwise>
													<img src="/BSBridge-theme/images/global_icon.png"
														class="global_icon" title="Global standard icon"
														alt="Global standard icon" />
												</c:otherwise>
											</c:choose>
										</c:when>
										<c:otherwise>
											<c:choose>
												<c:when test="${spec.framework eq 'Y'}">
													<img src="/BSBridge-theme/images/global_icon_halfred.png"
														class="global_icon" title="Multi-region Framework standard icon"
														alt="Multi-region Framework standard icon" />
												</c:when>
												<c:otherwise>
													<img src="/BSBridge-theme/images/multi_region_icon.png"
														class="global_icon" title="Multi-region standard icon"
														alt="Multi-region standard icon" />
												</c:otherwise>
											</c:choose>
										</c:otherwise>
									</c:choose> --%>
									<!-- <span class="label label-success">Global Must</span> -->
									<button type="button" class="btn btn-mini btn-success" onclick="getCountry('${spec.stdId}');">Global Must</button>
								</c:when>
								<c:otherwise>
									<c:if test="${'N' eq spec.isGlobal}">
										<button type="button" class="btn btn-mini ${spec.curRegion} ${spec.curRegion}-DB" onclick="getCountry('${spec.stdId}');">${spec.regionCode}</button>
									</c:if>
								</c:otherwise>
							</c:choose>
						</td>
						<td class="bull">&bull;&nbsp; </td>
						<td>
							${spec.title}
							<span class="grey  ${spec.stdId}">&nbsp;[${spec.stdId}] </span>
						</td>
					</tr>
				</c:forEach>
				<c:if test="${not empty standards.guidelines}">
					<tr>
                        <td class="invisible" colspan="4"></td>
					</tr>
					<tr>
						<td style="padding-top:5px;padding-left:50px;" class="lg" colspan="4">
							<%-- <strong>${guidelines}</strong> --%>
							<strong>Guidelines</strong>
							
						</td>
					</tr>
				</c:if>
                <c:forEach var="gdln" items="${standards.guidelines}">
					<tr>
						<td width="34px" class="cen">
							<c:if test="${not empty gdln.status && gdln.status ne 'GLBL_NOT_IN_MUST' && gdln.status ne 'NOT_RGN' 
													&& gdln.status ne 'NOT_BRND' && gdln.status ne 'MUST_NOT' && gdln.status ne 'MOVED_CTRY_DIFF'}">
								<c:choose>
									<c:when test="${not empty standards.status}">
										<a data-original-title="Move to Publish List" title="" data-placement="right" data-toggle="tooltip" 
											href="javascript:submitUnpublishFM('${standards.stdId},${gdln.stdId}')" id="chev">
											<i class="icon-chevron-left"></i>
										</a>
									</c:when>
									<c:otherwise>
										<a data-original-title="Move to Publish List" title="" data-placement="right" data-toggle="tooltip" 
											href="javascript:submitUnpublishFM('${gdln.stdId}')" id="chev">
											<i class="icon-chevron-left"></i>
										</a>
									</c:otherwise>
								</c:choose>
							</c:if>
						</td>
						
						<td width="71px" class="cen">
							<c:choose>
								<c:when test="${gdln.regionCode eq 'GLBL'}">
									<%-- <c:choose>
										<c:when test="${gdln.isGlobal eq 'G'}">
											<c:choose>
												<c:when test="${gdln.framework eq 'Y'}">
													<img src="/BSBridge-theme/images/global_icon_red.png"
														class="global_icon" title="Global Framework standard icon"
														alt="Global Framework standard icon" /> 
												</c:when>
												<c:otherwise>
													<img src="/BSBridge-theme/images/global_icon.png"
														class="global_icon" title="Global standard icon"
														alt="Global standard icon" />
												</c:otherwise>
											</c:choose>
										</c:when>
										<c:otherwise>
											<c:choose>
												<c:when test="${gdln.framework eq 'Y'}">
													<img src="/BSBridge-theme/images/global_icon_halfred.png"
														class="global_icon" title="Multi-region Framework standard icon"
														alt="Multi-region Framework standard icon" />
												</c:when>
												<c:otherwise>
													<img src="/BSBridge-theme/images/multi_region_icon.png"
														class="global_icon" title="Multi-region standard icon"
														alt="Multi-region standard icon" />
												</c:otherwise>
											</c:choose>
										</c:otherwise>
									</c:choose> --%>
									<!-- <span class="label label-success">Global Must</span> -->
									<button type="button" class="btn btn-mini btn-success" onclick="getCountry('${gdln.stdId}');">Global Must</button>
								</c:when>
								<c:otherwise>
									<c:if test="${'N' eq gdln.isGlobal}">
										<button type="button" class="btn btn-mini ${gdln.curRegion} ${gdln.curRegion}-DB" onclick="getCountry('${gdln.stdId}');">${gdln.regionCode}</button>
									</c:if>	
								</c:otherwise>
							</c:choose>
						</td>
						<td class="bull lg">&bull; &nbsp;</td>
						<td  class="lg ">
							${gdln.description}&nbsp;<span class="${gdln.stdId}">[${gdln.stdId}]</span>
						</td>
					</tr>
				</c:forEach>
                <tr><td colspan=4><hr/></td></tr>
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</table>
</div>
</form>
</section>
<div class="clear"></div>

<!-- Export Report -->
<c:choose>
	<c:when test="${regionCode eq 'AMEA'}"><c:set var="regionReportId" value="140"></c:set></c:when>
	<c:when test="${regionCode eq 'AMER'}"><c:set var="regionReportId" value="143"></c:set></c:when>
	<c:when test="${regionCode eq 'EURO'}"><c:set var="regionReportId" value="144"></c:set></c:when>
	<c:when test="${regionCode eq 'GC'}"><c:set var="regionReportId" value="145"></c:set></c:when>
</c:choose>

<div id="createReportDialog" title="Create Report" style="display:none">
    <form id="createReportForm" name="createReportForm" method="post" >
        <div class="modal-body">
            <div id="reportLst">
                <span><input type='radio' name='reports' value='${regionReportId}' checked />Unpublish Report</span>
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

<script type="text/javascript">
	var moveToPublishUrl = '${moveToPublishUrl}';
	var createReportURL = '${createReportURL}';
	var getCountriesURL = '${getCountriesURL}';
	
	$(document).ready(function() {
		/* Hiding Un-necessary info of liferay search container */
		if(jQuery('.search-results').length > 0){
			jQuery(".table-striped").css({"display":"none"}); 
		} else {
			jQuery(".taglib-search-iterator-page-iterator-bottom").css({"display":"none"});
		}
		
	    $("#createReportDialog").dialog({
	        autoOpen: false,
	        width: 560,
	         modal: true,
	        open: function() {
	            jQuery('.ui-widget-overlay').bind('click', function() {
	                jQuery('#createReportDialog').dialog('close');
	            })
	        }
	    });
	    
	    $( "#regionCountrylist" ).dialog({
			autoOpen: false,
			width: 860,
			modal: true,
			resizable: false,
			open: function() {
				jQuery('.ui-widget-overlay').bind('click', function() {
					jQuery('#regionCountrylist').dialog('close');
				});
			}
			
		});
	    
	    var idCriteria = [<%=idSearchCriteria%>];
		for(var l = 0; l < idCriteria.length; l++) {
			$("." +idCriteria[l]).addClass('highlight');
		}
	  
	    
	    $( ".regioncountrycancel" ).click(function() {
			$( "#regionCountrylist" ).dialog("close" );
		});
	    
	    $(".reportCancel").click(function() {
	        $("#createReportDialog").dialog("close");
	    });
	    
	    $("#unpublish-report").click(function() {
	        $('#reportTitle').val('');
	        $("#createReportDialog").dialog("open");
	    });
	    
	    $(".btn-clear-option").click(function(){ 
	        $('#showUpdatedHighlight').prop( "checked", false );
	        $('#showNewHighlight').prop( "checked", false );
	        $('#missingRefs').prop( "checked", false );
	        highlightNew();
	        hideReferences(); 
	    });

	});
	
	function submitUnpublishFM(stdId) {
		moveToPublishUrl = moveToPublishUrl+"&<portlet:namespace/>stdId="+stdId;
		document.unpublishFM.action = moveToPublishUrl;
		document.unpublishFM.submit();
	}
	
	function createReport() {
	    var reportTitle = jQuery("#reportTitle").val();
	    var reportId = jQuery("input[name='reports']:checked", "#createReportForm").val();
	    var postData = {reportId:reportId,reportTitle:reportTitle};
	    jQuery.blockUI({ message: '<h3><img src="/BSTheme-theme/images/busy.gif" /> Please wait...</h3>' });
	    
	    jQuery.ajax({
	        type: "POST",
	        url: createReportURL,
	        data: postData
	    }).done( function(data) {
	        jQuery.unblockUI();
	        jQuery.msgBox({
	            title: "Success!",
	            content: "An email with a link to your Report will be sent to you once the Report has been generated.", 
	            type: "info",
	            buttons: [{ value: "OK" }],
	            success: function (result) {
	                $("#createReportDialog").dialog("close");
	            }
	        });
	    }).fail( function(jqXHR) {
	        jQuery.unblockUI();
	        jQuery.msgBox({
	            title: "Error!",
	            content: "Failed submit request! Failure status:" + jqXHR.statusText + " status code:" + jqXHR.status ,
	            type: "error",
	            success: function (result) {
	                ;
	            }
	        });
	    });
	};
	
	function getCountry(stdId)
	{
	    jQuery.ajax({          
	        url:getCountriesURL,
	        data: {
	            stdId: stdId
	        },
	        type: 'POST',
	        success: function(dataJson) 
	        { 
	            jQuery("#regionCountrylist").dialog("open");
	            //jQuery("#rgn-cnt-tbody").html('');
	            jQuery("#rgn-cnt-tbody").html(dataJson);
	        }
	    }); 
	};

	function find(){
		var ids = $("#findId").val();
		if(ids!=null && ids.length >0)
		{
			$("#findId").val(ids.replace(/\s{2,}/g, ' ').trim());
			$('#findForm').submit();
		}
	}

	function clearSearch(){
		$("#findId").val('');
		$('#findForm').submit();
	};

	$("#findId").bind('paste', function () {
	    var element = this;
	    setTimeout(function () {
	        var newVal = $(element).val().replace(/[^0-9 ]+/g, '').trim();
	        newVal = newVal.replace(/\s{2,}/g, ' ').trim();
	        $(element).val(newVal);
	    }, 200);
	});
	 

    $("#findId").keydown(function(event) {
        // Allow: escape, backspace, delete, tab, 
        if ( event.keyCode == 27 || event.keyCode == 46 || event.keyCode == 8 || event.keyCode == 9 || 
             // Allow: space            enter,                        home, end, left, right                  Ctrl
             event.keyCode == 32 || event.keyCode == 13 || (event.keyCode >= 35 && event.keyCode <= 40) || event.ctrlKey )
        {
            return;
        }
        else 
        {
            // Ensure that it is a number and stop the keypress
            if (event.shiftKey || (event.keyCode < 48 || event.keyCode > 57) && (event.keyCode < 96 || event.keyCode > 105 )) 
            {
                event.preventDefault();
            }   
        }
    });
</script>	
	</c:otherwise>
</c:choose>