<%@page import="com.ihg.brandstandards.custom.model.Standard"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.search.SearchContext"%>
<%@page import="com.liferay.portal.kernel.search.SearchContextFactory"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="java.util.ArrayList"%>
<%@include file="/html/init.jsp"%>

<portlet:resourceURL var="createReportURL" id='exportErrorReport'>
</portlet:resourceURL>

<portlet:resourceURL id='deleteStd' var="deleteStdURL">
</portlet:resourceURL>

<c:choose>
	<c:when test="${displayNoPublishMessage}">
        Please create new publication.
	</c:when>
	<c:otherwise>

<%
	StringBuilder standardIds = new StringBuilder();
	long previousTaxonomyId = 0;
	int currPage = 0;
	int stdCount = 0;
	int specCount = 0;
	int gdlnCount = 0;
%>

<script type="text/javascript">
var createReportURL = '${createReportURL}';
var deleteStdURL = '${deleteStdURL}';

function showImagePopup(imageId)
{

};

</script>

<script type="text/javascript" src="/BSBridge-portlet/js/myPublicationErrorDetails.js"></script>
 

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
			<input name="standardIds" id="standardIds" type="hidden" value="">
			<a class="btn btn-primary" href="#" id="exportErrorReport"><i class="icon-arrow-down icon-white"></i>Export</a>
  			<a class="btn btn-primary" href="/web/brand-standards/bridge/my-publication"><i class="icon-white icon-mypublication"></i> My Publication</a>
		</form>
	</div>
</div>

<div class="row">
	<div class="modal-header">
    	<h3 id="brandModalLabel"> My Publication issues for ${selectedBrand} in ${regionCode} </h3>
	</div>
</div>
<div class="clear"></div>

<section id="standards">
<div id="progress_standards">
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
							<td colspan="4" >
								<div class="row">
									<h4>
										<%=indexPathHtml %>
									</h4>
								</div>
								<div class="row">&nbsp;</div>
                			</td>
                		</tr>
			<% 		}  previousTaxonomyId = standards.getTaxonomyId(); %>
				<!-- Don't show standards under index when showing Index View Details -->
					<tr>	
						<td class="show" width="100%" style="padding-right:5px">
							<c:if test="${not empty standards.status}">
								<span class="label  ${indicatorStyle}">${standards.status}</span>
							</c:if>
						</td>
						<td width="21px" style="padding-left:5px">
							<% if (standards.isRemovable()) { %>
								<a data-original-title="Delete" title="" data-placement="right" data-toggle="tooltip" href="javascript:deleteStd(<%=standards.getStdId()%>)" id="remove_std"><i class="icon-remove"></i></a>
							<% } %>
						</td>
						<td colspan="2" width="900px">
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
					<tr>
						<td class="show">
							<c:if test="${not empty spec.status}">
								<span class="label  ${indicatorStyle}">${spec.status}</span>
							</c:if>
						</td>
						<td width="21px" style="padding-left:5px">
							<% if (spec.isRemovable()) { %>
								<a data-original-title="Delete" title="" data-placement="right" data-toggle="tooltip" href="javascript:deleteStd(<%=spec.getStdId()%>)" id="remove_std"><i class="icon-remove"></i></a>
							<% } %>
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
                        <td class="invisible" colspan="4"></td>
					</tr>
					<tr>
						<td class="show"></td>
						<td style="padding-top:5px;" class="lg" colspan="3">
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
						<td width="21px" style="padding-left:5px">
							<% if (gdln.isRemovable()) { %>
								<a data-original-title="Delete" title="" data-placement="right" data-toggle="tooltip" href="javascript:deleteStd(<%=gdln.getStdId()%>)" id="remove_std"><i class="icon-remove"></i></a>
							<% } %>
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
                <tr><td colspan=4><hr/></td></tr>
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</table>
</div>
</section>
<div class="clear"></div>

<div id="exportReportDialog" title="Export Report" style="display:none">
	<form id="exportReportForm" name="exportReportForm" method="post" >
	    <div class="modal-body">
	        <h4>Report Title <input type="text" id="reportTitle" name="reportTitle"/> </h4> 
	      </div>
	    <div class="modal-footer">
	        <div class="pull-left"><button type="button" class="btn reportCancel">Cancel</button></div>
	        <div class="pull-right"><a class="btn btn-primary" href="javascript:exportReport()">Run</a></div>
	    </div>
	</form>
</div>

	</c:otherwise>
</c:choose>
