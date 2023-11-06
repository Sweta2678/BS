<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@include file="/html/init.jsp"%>
<%@page import="com.ihg.brandstandards.custom.model.Standard"%>
<portlet:resourceURL id='exportPopup' var="exportPopupURL">
	<portlet:param name="requestType" value="ExportPopup" />
	<portlet:param name="reportLocaleCode" value="${reportLocaleCode}" />
	<portlet:param name="reportType" value="${reportType}" />
</portlet:resourceURL>

<portlet:resourceURL id='showImagesPopup' var="showImagesPopupURL">
	<portlet:param name="requestType" value="ShowImagesPopup" />
	<portlet:param name="reportLocaleCode" value="${reportLocaleCode}" />
	<portlet:param name="reportType" value="${reportType}" />
</portlet:resourceURL>

<portlet:resourceURL id='acknowledge' var="acknowledgeURL">
	<portlet:param name="requestType" value="Acknowledge" />
	<portlet:param name="reportLocaleCode" value="${reportLocaleCode}" />
	<portlet:param name="reportType" value="${reportType}" />
</portlet:resourceURL>

<%
	StringBuffer standardIds = new StringBuffer();
	long previousTaxonomyId = 0;
	int currPage = 0;
	int stdCount = 0;
	int specCount = 0;
	int gdlnCount = 0;
%>
<style type="text/css">
	.lfr-search-container {margin-top: 0px!important;}
	.pager {margin: 10px 0 !important;}
</style>
<!-- Keep the below 2 un-closed divs as this is a fix for footer left aligning issue -->
<div><div>

<div style="background-color:#e5e5e5;border:1px solid #d3d3d3" class="row"> 
	<div class="pull-right">
		<form action="${exportPopupURL}" method="post" name="exportProgressFM" >
			<input name="requestType" id="requestType" type="hidden" value="ExportPopup">
			<input name="reportLocaleCode" id="reportLocaleCode" type="hidden" value="${reportLocaleCode}">
			<input name="reportType" id="reportType" type="hidden" value="${reportType}">
			<input name="standardIds" id="standardIds" type="hidden" value="">
			<c:if test="${reportType eq 'NotificationView'}">
				<c:if test="${(((currentPage eq 'Progress') && (selectedRegion eq 'GLBL')) || (currentPage eq 'Summary'))}">
					<a class="btn btn-primary" href="javascript:acknowledgeAllNotification()">Acknowledge All</a>
				</c:if>
			</c:if>
			<c:if test="${showExportButton eq 'YES'}">
				<a class="btn btn-primary" href="javascript:createExportPopup('<%=standardIds.toString()%>')"><i class="icon-arrow-down icon-white"></i>Export</a>
			</c:if>
			<c:choose>
	    		<c:when test="${currentPage eq 'Progress'}">
	    			<a class="btn btn-primary" href="/web/brand-standards/bridge/progress"><i class="icon-white icon-progress"></i> Progress</a>
	    		</c:when>
	    		<c:otherwise>
	    			<a class="btn btn-primary" href="/web/brand-standards/bridge/summary"><i class="icon-white icon-summary"></i> Summary</a>
	    		</c:otherwise>
    		</c:choose>
		</form>
	</div>
</div>

<div class="row">
	<div class="modal-header">
    	<h3 id="brandModalLabel">
    	<c:choose>
	    	<c:when test="${not empty translationLocale}">
    			${translationLocale} ${overallProgressSection} for ${selectedBrand} in ${selectedRegion}
    		</c:when>
	    	<c:otherwise>
	    		${overallProgressSection} for ${selectedBrand} in ${selectedRegion}
	    	</c:otherwise>
    	</c:choose>
    	</h3>
	</div>
</div>
<div class="clear"></div>
<section id="standards">
<div id="progress_standards">
	<c:choose>
	<c:when test="${reportType eq 'NotificationView'}">
		<%@include file="/html/progress/view_details_notification.jsp"%>
	</c:when>
	<c:otherwise>
    <table class="results_table">
	    <liferay-ui:search-container hover="false" searchContainer="${searchContainer}">
            <liferay-ui:search-container-results>
            <%
	        	stdCount = 0;
				specCount = 0;
				gdlnCount = 0;
                pageContext.setAttribute("results", searchContainer.getResults());
                pageContext.setAttribute("total", searchContainer.getTotal() );
                currPage = searchContainer.getCur();
				if(searchContainer.getResultEnd() > searchContainer.getDelta()){
                	stdCount = (searchContainer.getResultEnd() - searchContainer.getDelta());
				} else {
					stdCount = searchContainer.getResultEnd();
				}
            %>
            </liferay-ui:search-container-results>
            <liferay-ui:search-container-row className="com.ihg.brandstandards.custom.model.Standard" keyProperty="stdId" modelVar="standards">
			<%	
				standardIds.append(standards.getStdId());
				standardIds.append(StringPool.COMMA);
				List<Standard> specsList = standards.getSpecifications();
				List<Standard> gdlnsList = standards.getGuidelines();
				specCount = specCount + specsList.size();
				gdlnCount = gdlnCount + gdlnsList.size();
				if(previousTaxonomyId != standards.getTaxonomyId()) {
					String indexPath = standards.getTaxonomyPath();
					String currentIndex = standards.getTaxonomyText();
					String indexPathHtml = "";
					if (indexPath != null && indexPath.contains(currentIndex)) {
						indexPath = indexPath.replace(currentIndex, "");
						indexPathHtml = "<span class=\"grey\">"+indexPath+"</span><span class=\"blue\">"+currentIndex+"</span>";
					} else {
						indexPathHtml = "<span class=\"grey\">"+indexPath+"</span>";
					}
			%>
						<tr>
						<c:choose>	
						<c:when test="${reportType eq 'IndexTranslationView'}">
							<!-- Show Error Indicator before Index when showing Missing Index View Details -->
							<td class="show" width="100%" style="padding-right:5px">
								<c:if test="${not empty standards.status}">
									<span class="label  ${indicatorStyle}">${standards.status}</span>
								</c:if>
							</td>
							<td colspan="2" width="910px">
						</c:when>
						<c:otherwise>
							<td colspan="3" >
						</c:otherwise>
						</c:choose>	
								<div class="row">
									<h4>
										<%=indexPathHtml %>
										<!-- Show Index Id when showing Index View Details -->
										<c:if test="${reportType eq 'IndexTranslationView'}"><span class="grey">[${standards.taxonomyId}]</span></c:if>
									</h4>
								</div>
								<div class="row">&nbsp;</div>
                			</td>
                		</tr>
			<% 		}  previousTaxonomyId = standards.getTaxonomyId(); %>
				<!-- Don't show standards under index when showing Index View Details -->
				<c:if test="${reportType ne 'IndexTranslationView'}">
					<tr >	
						<td class="show" width="100%" style="padding-right:5px">
							<c:if test="${not empty standards.status}">
								<span class="label  ${indicatorStyle}">${standards.status}</span>
							</c:if>
						</td>
						<td colspan="2" width="910px">
							<%
								/** Displaying Mandatory Image Icon beside standard */
								StringBuffer stdImageIds = new StringBuffer();
								if(Validator.isNotNull(standards.getImageList())) {
									String images[] = standards.getImageList().split(";;; ");
									if (images != null && images.length > 0) {
										for (String image : images) {
						                	String imageData[] = image.split(":::");
						                    if (imageData.length >= 2) {
						                    	stdImageIds.append(imageData[1]+",");
						                    }
										}
									}
								}
								if(Validator.isNotNull(stdImageIds.toString())){
							%>
								<a onclick="showImagePopup('<%=stdImageIds.toString()%>');">
									<img alt="Mandatory Images" title="Mandatory Images" src="/BSTheme-theme/images/camera_icon.jpg">
								</a>
							<% } %>
							
							<strong>${standards.title}</strong>&nbsp;
							<span class="grey">[${standards.stdId}]</span>
							
							<%
								/** Displaying Attachment & Links below standard */
								if(Validator.isNotNull(standards.getAttachmentList())) {
									String attachments[] = standards.getAttachmentList().split(";;; ");
									if (attachments != null && attachments.length > 0) {
										out.println("<br><strong>Attachments:</strong>");
										for (String attachment : attachments) {
						                	String attachmentData[] = attachment.split(":::");
						                    if (attachmentData.length >= 2) {
						                    	out.println("<br><a target=\"_blank\" href=\""+attachmentData[1]+"\">"+attachmentData[0]+"</a>");
						                    } else if (attachmentData.length >= 1) {
						                    	out.println("<br><a target=\"_blank\" href=\"#\">"+attachmentData[0]+"</a>");
						                    }
										}
									}
								}
							
								if(Validator.isNotNull(standards.getLinkList())) {
									String links[] = standards.getLinkList().split(";;; ");
									if (links != null && links.length > 0) {
										out.println("<br><strong>Links:</strong>");
										for (String link : links) {
						                	String linkData[] = link.split(":::");
						                	if (linkData.length >= 2) {
						                    	out.println("<br><a target=\"_blank\" href=\""+linkData[1]+"\">"+linkData[0]+"</a>");
						                    } else if (linkData.length >= 1) {
						                    	out.println("<br><a target=\"_blank\" href=\"#\">"+linkData[0]+"</a>");
						                    }
										}
									}
								}
							%>
						</td>
					</tr>
				<c:forEach var="spec" items="${standards.specifications}">
					<%	
						Standard spec = (Standard)pageContext.getAttribute("spec");
						standardIds.append(spec.getStdId());
						standardIds.append(StringPool.COMMA);
					%>
					<tr >
						<td class="show">
							<c:if test="${not empty spec.status}">
								<span class="label  ${indicatorStyle}">${spec.status}</span>
							</c:if>
						</td>
						<td class="bull">&bull;&nbsp; </td>
						<td>
							<%
								/** Displaying Mandatory Image Icon beside standard */
								StringBuffer specImageIds = new StringBuffer();
								if(Validator.isNotNull(spec.getImageList())) {
									String images[] = spec.getImageList().split(";;; ");
									if (images != null && images.length > 0) {
										for (String image : images) {
						                	String imageData[] = image.split(":::");
						                    if (imageData.length >= 2) {
						                    	specImageIds.append(imageData[1]+",");
						                    }
										}
									}
								}
								if(Validator.isNotNull(specImageIds.toString())){
							%>
								<a onclick="showImagePopup('<%=specImageIds.toString()%>');">
									<img alt="Mandatory Images" title="Mandatory Images" src="/BSTheme-theme/images/camera_icon.jpg">
								</a>
							<% } %>
							
							${spec.title}
							<span class="grey">&nbsp;[${spec.stdId}] </span>
							<%
								/** Displaying Attachment & Links below standard */
								if(Validator.isNotNull(spec.getAttachmentList())) {
									String attachments[] = spec.getAttachmentList().split(";;; ");
									if (attachments != null && attachments.length > 0) {
										out.println("<br><strong>Attachments:</strong>");
										for (String attachment : attachments) {
						                	String attachmentData[] = attachment.split(":::");
						                    if (attachmentData.length >= 2) {
						                    	out.println("<br><a target=\"_blank\" href=\""+attachmentData[1]+"\">"+attachmentData[0]+"</a>");
						                    } else if (attachmentData.length >= 1) {
						                    	out.println("<br><a target=\"_blank\" href=\"#\">"+attachmentData[0]+"</a>");
						                    }
										}
									}
								}
							
								if(Validator.isNotNull(spec.getLinkList())) {
									String links[] = spec.getLinkList().split(";;; ");
									if (links != null && links.length > 0) {
										out.println("<br><strong>Links:</strong>");
										for (String link : links) {
						                	String linkData[] = link.split(":::");
						                	if (linkData.length >= 2) {
						                    	out.println("<br><a target=\"_blank\" href=\""+linkData[1]+"\">"+linkData[0]+"</a>");
						                    } else if (linkData.length >= 1) {
						                    	out.println("<br><a target=\"_blank\" href=\"#\">"+linkData[0]+"</a>");
						                    }
										}
									}
								}
							%>
						</td>
					</tr>
				</c:forEach>
				<c:if test="${not empty standards.guidelines}">
					<tr>
                        <td class="invisible" colspan="3"></td>
					</tr>
					<tr>
						<td class="show"></td>
						<td style="padding-top:5px;" class="lg" colspan="2">
							<strong>Guidelines</strong>
						</td>
					</tr>
				</c:if>
                <c:forEach var="gdln" items="${standards.guidelines}">
					<%	
						Standard gdln = (Standard)pageContext.getAttribute("gdln");
						standardIds.append(gdln.getStdId());
						standardIds.append(StringPool.COMMA);
					%>
					<tr>
						<td class="show">
							<c:if test="${not empty gdln.status}">
								<span class="label  ${indicatorStyle}">${gdln.status}</span>
							</c:if>
						</td>
						<td class="bull lg">&bull; &nbsp;</td>
						<td  class="lg ">
							<%
								/** Displaying Mandatory Image Icon beside standard */
								StringBuffer gdlnImageIds = new StringBuffer();
								if(Validator.isNotNull(gdln.getImageList())) {
									String images[] = gdln.getImageList().split(";;; ");
									if (images != null && images.length > 0) {
										for (String image : images) {
						                	String imageData[] = image.split(":::");
						                    if (imageData.length >= 2) {
						                    	gdlnImageIds.append(imageData[1]+",");
						                    }
										}
									}
								}
								if(Validator.isNotNull(gdlnImageIds.toString())){
							%>
								<a onclick="showImagePopup('<%=gdlnImageIds.toString()%>');">
									<img alt="Mandatory Images" title="Mandatory Images" src="/BSTheme-theme/images/camera_icon.jpg">
								</a>
							<% } %>
							
							${gdln.description}&nbsp;[${gdln.stdId}]
							<%
								/** Displaying Attachment & Links below standard */
								if(Validator.isNotNull(gdln.getAttachmentList())) {
									String attachments[] = gdln.getAttachmentList().split(";;; ");
									if (attachments != null && attachments.length > 0) {
										out.println("<br><strong>Attachments:</strong>");
										for (String attachment : attachments) {
						                	String attachmentData[] = attachment.split(":::");
						                    if (attachmentData.length >= 2) {
						                    	out.println("<br><a target=\"_blank\" href=\""+attachmentData[1]+"\">"+attachmentData[0]+"</a>");
						                    } else if (attachmentData.length >= 1) {
						                    	out.println("<br><a target=\"_blank\" href=\"#\">"+attachmentData[0]+"</a>");
						                    }
										}
									}
								}
							
								if(Validator.isNotNull(gdln.getLinkList())) {
									String links[] = gdln.getLinkList().split(";;; ");
									if (links != null && links.length > 0) {
										out.println("<br><strong>Links:</strong>");
										for (String link : links) {
						                	String linkData[] = link.split(":::");
						                	if (linkData.length >= 2) {
						                    	out.println("<br><a target=\"_blank\" href=\""+linkData[1]+"\">"+linkData[0]+"</a>");
						                    } else if (linkData.length >= 1) {
						                    	out.println("<br><a target=\"_blank\" href=\"#\">"+linkData[0]+"</a>");
						                    }
										}
									}
								}
							%>
						</td>
					</tr>
				</c:forEach>
				</c:if>
                <tr><td colspan=3><hr/></td></tr>
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</table>
	</c:otherwise>
	</c:choose>
</div>
</section>
<div class="clear"></div>

<div id="export_report_popup" style="display:none;"> </div>
<div id="show_image_popup" style="display:none;"> </div>

<script type="text/javascript">
	var showExportButton = '${showExportButton}';
	var reportType = '${reportType}';
	var showImagesPopupURL = '${showImagesPopupURL}';
	var acknowledgeURL = '${acknowledgeURL}';
	var showImagesPopupDialog = "";
	var exportPopupURL = '${exportPopupURL}';
	var exportPopupDialog = "";
	var stdCount = <%=stdCount%>;
	var specCount = <%=specCount%>;
	var gdlnCount = <%=gdlnCount%>;
	var stdText = ' Standards ';
	var specText = ' Specifications ';
	var gdlnText = ' Guidelines.';
	$(document).ready(function() {
		
		showImagesPopupDialog = $( "#show_image_popup" ).dialog({
		    title: 'Mandatory Images',
		    closeText: 'Close',
			autoOpen: false,
			center:true,
			resizable:false,
			width: 560,
			modal: true,
			open: function() {
		        $('.showImagesPopupClose').bind('click', function() {
		            $('#show_image_popup').dialog('close');
		        })
		    }
		});
		
		exportPopupDialog = $( "#export_report_popup" ).dialog({
		    title: 'Export Report',
		    closeText: 'Close',
			autoOpen: false,
			center:true,
			resizable:false,
			width: 560,
			modal: true,
			open: function() {
		        $('.exportPopupClose').bind('click', function() {
		            $('#export_report_popup').dialog('close');
		        })
		    }
		});
		
		if(stdCount == 1){
			stdText = ' Standard ';
		}
		
		if(specCount == 1){
			specText = ' Specification ';
		}
		
		if(gdlnCount == 1){
			gdlnText = ' Guideline.';
		}
		
		/* Overridding result message of liferay search container */
		if(jQuery('.search-results').length > 0){
			if(reportType == 'IndexTranslationView'){
				jQuery('.search-results').html('Showing '+ stdCount + (stdCount == 1 ? ' Index' : ' Indexes' ));
			} else {
				jQuery('.search-results').html('Showing '+ stdCount + stdText + specCount + specText + gdlnCount + gdlnText);
			}
		} else {
			if(reportType == 'IndexTranslationView'){
				jQuery('.search-results').html('Showing '+ stdCount + (stdCount == 1 ? ' Index' : ' Indexes' ));
			} else {
				jQuery('.taglib-page-iterator').html('Showing '+ stdCount + stdText + specCount + specText + gdlnCount + gdlnText);
			}
		}
		
		/* Hiding Un-necessary info of liferay search container */
		if(showExportButton == 'YES'){
			jQuery(".table-striped").css({"display":"none"}); 
		} else {
			jQuery(".taglib-search-iterator-page-iterator-bottom").css({"display":"none"});
		}
	});
	
	function createExportPopup(standardIds) {
		$('#<portlet:namespace />standardIds').val(standardIds);
		document.exportProgressFM.submit();
	}
	
	function showImagePopup(imageIds) {
		$.ajax({
		  	url :showImagesPopupURL,
		  	type: "POST",
		  	dataType: "text",
		  	data : {"imageIds":imageIds},
		    success: function(data) {
		    	if (data != null && data != '' && typeof data != 'undefined') {
		    		$('#show_image_popup').html(data);
		    		showImagesPopupDialog.dialog( "open" );
		    	}
		    }
	    });
	}
	
	function acknowledgeNotification(notificationIds) {
		loadProgressBar();
		$.ajax({
		  	url: acknowledgeURL,
		  	type: "POST",
		  	dataType: "text",
		  	data: {"notificationIds":notificationIds}
		}).done(function(data) {
			jQuery.unblockUI();
	        if (data != null && data != '' && typeof data != 'undefined') {
	    		/* console.log(data+'--'+notificationIds+'--'+'#notif'+notificationIds); */
	    		if(data == 'Fail'){
	    			jQuery.msgBox({
	    	            title: "Error!",
	    	            content: "Failed to update Acknowledgement for Notification!",
	    	            type: "error",
	    	            success: function (result) { ; }
	    	        });
	    		} else if(data == 'Success'){
	    			/* $('#notif'+notificationIds).html('<img src="/BSTheme-theme/images/green_arrow.jpg" alt="Acknowledged" class="log_icon">'); */
	    			$('#notifRow'+notificationIds).hide();
	    		}
	    	}
	    }).fail( function(jqXHR) {
	        jQuery.unblockUI();
	        jQuery.msgBox({
	            title: "Error!",
	            content: "Failed to update Acknowledgement for Notification! Failure status:" + jqXHR.statusText + " status code:" + jqXHR.status ,
	            type: "error",
	            success: function (result) {
	                ;
	            }
	        });
	    });
	}
	
	function acknowledgeAllNotification() {
		var notificationIds = '<%=standardIds%>';
		jQuery.msgBox({
		    title: "Are You Sure",
		    content: "Are you sure you want to Acknowledge all notification at once?",
		    type: "confirm",
		    buttons: [{ value: "Yes" }, { value: "No" }],
		    success: function (acknowledgeConfirm) {
		        if (acknowledgeConfirm == "Yes") {
		        	loadProgressBar();
		        	$.ajax({
					  	url: acknowledgeURL,
					  	type: "POST",
					  	dataType: "text",
					  	data: {"notificationIds":notificationIds}
					}).done(function(data) {
						jQuery.unblockUI();
						if (data != null && data != '' && typeof data != 'undefined') {
				    		/* console.log(data+'--'+notificationIds+'--'+'#notif'+notificationIds); */
				    		if(data == 'Fail'){
				    			jQuery.msgBox({
				    	            title: "Error!",
				    	            content: "Failed to update Acknowledgement for all Notifications!",
				    	            type: "error",
				    	            success: function (result) { ; }
				    	        });
				    		} else {
				    			/* console.log("Acknowledged All - Re-Loading"); */
				    			location.reload();
				    		}
				    	}
				    }).fail( function(jqXHR) {
				        jQuery.unblockUI();
				        jQuery.msgBox({
				            title: "Error!",
				            content: "Failed to update Acknowledgement for all Notifications! Failure status:" + jqXHR.statusText + " status code:" + jqXHR.status ,
				            type: "error",
				            success: function (result) {
				                ;
				            }
				        });
				    });
		        } else if(acknowledgeConfirm == "No" || acknowledgeConfirm == "Cancel") {
					return;
				}
		 	}
		});
	}
	
	function loadProgressBar () {
		jQuery.blockUI({ message: '<h3><img src="/BSBridge-theme/images/busy.gif" /> Please wait...</h3>' });
	}
</script>