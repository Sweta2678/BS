<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@include file="/html/updatePreview/init.jsp" %>
<portlet:actionURL name="FilterData" var="FilterData" />
<portlet:actionURL name="ClearFilter" var="ClearFilter" />
<portlet:resourceURL var="exportReport" id="exportReport" />
<portlet:renderURL var="loadGroupResults">
</portlet:renderURL>
<portlet:resourceURL id='referenceStandards' var="referenceStandards">
	<portlet:param name="modalType" value="referenceStandards"></portlet:param>
</portlet:resourceURL>

<portlet:resourceURL id='viewDetails' var="viewDetails">
	<portlet:param name="modalType" value="viewDetails"></portlet:param>
</portlet:resourceURL>

<portlet:resourceURL id='supportingMaterial' var="supportingMaterial">
	<portlet:param name="modalType" value="supportingMaterial"></portlet:param>
</portlet:resourceURL>

<portlet:resourceURL var="exportAllReport" id="exportAllReport" />
<portlet:resourceURL var="groupCountryDetails" id="groupCountryDetails" />
<portlet:resourceURL var="generateUniqueGroups" id="generateUniqueGroups" />

<style type="text/css">
	.lfr-search-container {margin-top: 0px!important;}
	.pager {margin: 10px 0 !important;}
	.portlet-msg-success {display:none;}
	.alert-success {display:none;}
</style>
<script type="text/javascript">
	var referenceStandards = '${referenceStandards}';
	var stdReferenceDialog = '';
	var imagesDialog = '';
	var mandatoryImages = '${viewDetails}';
	var supportingMaterial = '${supportingMaterial}';
	var supportingMaterialTitle = '${supportingMaterialTitle}';
	var attchDialog = '';
	var generateUniqueGroups = '${generateUniqueGroups}';
</script>

<%
    SearchContainer<BridgePublishAppModel> searchContainerObj = (SearchContainer<BridgePublishAppModel>) request.getAttribute("searchContainerObj");
%>
<script src="/BSBridge-portlet/js/jquery.highlight.js"></script>
<script src="/BSBridge-portlet/js/bootstrap-dropdown.js"></script>
<script src="/BSBridge-portlet/js/bridgeUpdatePreview.js"></script>
<script type="text/javascript">
	var clearFilterURL = '${ClearFilter}';
	var exportReportURL = '${exportReport}';
	var exportAllReportURL = '${exportAllReport}';
	var byIdString = '${byId}';
	var loadGroupStd = '${loadGroupResults}';
	var selectedGroup = '${selectedGroupName}';
	$(document).ready(function() {
        $('.dropdown-toggle').dropdown();
    });
	var groupCountryDialog = '';
	var groupCountryDetails = '${groupCountryDetails}';
</script>
<c:if test="${errorMessage ne null}">
	<c:out value="${errorMessage}"></c:out>
</c:if>
<c:choose>
	<c:when test="${activePublish}">
<!-- Keep the below 2 un-closed divs as this is a fix for footer left aligning issue -->
<div><div>
	
	<c:if test="${not empty message}">
		<div class="alert alert-warning" role="alert">
   			<strong><c:out value="${message}"/></strong>
  			</div>
	</c:if>
		
	<c:choose>
		<c:when test ="${loggedIn eq true && not empty countryGroups}">
			<div class="row"> 
				<div class="well well-small" style="margin-bottom: 2px;"> 
					<div class="row">
						<div class="span6">
							<div class="pull-left">
								<span><strong>Unique Groups:</strong></span> 
								<%-- <select name="group" id="group" onchange = "javascript:loadAnotherGroup()">
								<c:forEach var="countryGrp" items="${countryGroups}" varStatus="status">
									<c:choose>
						   				<c:when test="${countryGrp.groupName eq selectedGroupName}">
						   					<option value="${countryGrp.groupName}" selected="selected">${countryGrp.groupName}</option>
						   				</c:when>
						   				<c:otherwise>
						   					<option value="${countryGrp.groupName}">${countryGrp.groupName}</option>
						   				</c:otherwise>
						   			</c:choose>
								</c:forEach>
					   		</select>  --%>
			   				 <span style="display: inline-block; margin-right: 5px;">${selectedGroupName}</span>
					   		<div class="pull-right">
					   			<a class="btn btn-primary" href="javascript:groupCountryPopup(${publishId}, ${regionId}, '${selectedGroupName}')">Country/Region Info</a>
					   		</div> 
			   		
				   			 <%-- <span title="${countryCode}">
					   			<c:choose>
					   				<c:when test="${fn:length(countryCode) gt 30}">
					   					${fn:substring(countryCode, 0, 30)}...	
					   				</c:when>
					   				<c:otherwise>
					   					${countryCode}
					   				</c:otherwise>
					   			</c:choose>
					   		</span>  --%>
						</div>
					</div>
				  	<div class="span6">
						<div class="pull-right dropdown">
							<a id="dLabel" class="btn btn-primary dropdown-toggle" data-toggle="dropdown" href="#">
								<i class="icon-white icon-print"></i> Create PDF
							</a>&nbsp;
							<ul class="dropdown-menu" role="menu" >
								<li><a href="#" onclick="javascript:exportReport('exportReport');">Create PDF For ${selectedGroupName}</a></li>
								<li class="divider"></li>
								<li><a href="#" onclick="javascript:exportReport('exportAllReport');">Create PDF For All Groups</a></li>
							</ul>
							<c:if test="${adminUser eq true}">
								<a id="dLabel" href="#" role="button" class="btn btn-primary"  data-target="#"
								 onclick="javascript:generateGroups('OTHER');">
									<i class="icon-white icon-print"></i> Generate Groups
								</a>&nbsp;
							</c:if>
						</div>
				  	</div>
	 			</div>
	 			<hr>
	   			<form class="form-inline form-search" style="margin-bottom: 0;" name="formbyid" id="formbyid" method="POST" action="<%=FilterData%>">
				    <div class="row" style="margin-top: 5px;">
						<div class="span6"> 
				           <div class="pull-left"> 
					         <span><strong>Filter By:</strong></span> &nbsp;
				             <select onchange="javascript:filterbyState();" id="byState" name="byState" class="input-medium"> 
				              	<option value="" >Please Select</option>
								<option value="NEW" <c:if test="${byState eq 'NEW'}">selected="selected" </c:if>>New</option>
								<option value="UPDATE" <c:if test="${byState eq 'UPDATE'}">selected="selected" </c:if>>Update</option>
								<option value="IMAGES" <c:if test="${byState eq 'IMAGES'}">selected="selected" </c:if>>Mandatory Image</option>
								<option value="REFERENCES" <c:if test="${byState eq 'REFERENCES'}">selected="selected" </c:if>>Cross References</option>
								<option value="HOTEL_LIFECYCLE" <c:if test="${byState eq 'HOTEL_LIFECYCLE'}">selected="selected" </c:if>>Hotel Lifecycle</option>
								<option value="COMPLIANCE" <c:if test="${byState eq 'COMPLIANCE'}">selected="selected" </c:if> >Future Compliance</option>
								<option value="ATTACHMENTS" <c:if test="${byState eq 'ATTACHMENTS'}">selected="selected" </c:if>>Attachments</option>
								<option value="LINKS" <c:if test="${byState eq 'LINKS'}">selected="selected" </c:if>>Links</option>
				             </select> 
				          </div> 
						</div> 
						<div class="span6"> 
				       		<div class="pull-right"> 
								<span><strong>Find By ID:</strong></span> 
			             	    <input type="text" style="margin-bottom: 0px;" value="${byId}" class="input-medium" placeholder="Enter STD ID to find ..." name="byId" id="byId" maxlength="2000"> 
			             	     <input type="hidden" value="${selectedGroupName}" id="selectedGrp" name="selectedGrp">
			             	     <a href="#find" role="button" class="btn btn-primary" onclick="javascript:filterbyId();"><i class="icon-search icon-white"></i> Go</a> 
			             	     <a href="#clearFind" role="button" class="btn" onclick="javascript:clearFilter();"><i class="icon-remove"></i> Clear</a>  
			           		</div> 
			          	</div> 
					</div>  
			</form>
		</div> 
	</div>

	<c:if test="${not empty notFound }">
		<div class="alert alert-warning" role="alert">
	    	<strong>The following terms were not found <c:out value="${notFound}"/></strong>
	   	</div>
	   	 <%  searchContainerObj.setEmptyResultsMessage(StringPool.BLANK); %><!-- Here we set empty message for search container, to remove multiple message i.e. above message and empty result message. -->
	</c:if>

<section id="standards">
<div id="result" style="min-height:400px;">
	<c:set var="prevPath" value="-" />
	<table class="specs"><tbody>
		<liferay-ui:search-container id="searchContainer" emptyResultsMessage="No results available" searchContainer="<%=searchContainerObj%>">
			<liferay-ui:search-container-results results="<%=searchContainer.getResults()%>" total="<%=searchContainer.getTotal()%>"/>
			<liferay-ui:search-container-row className="com.ihg.brandstandards.bridge.model.BridgePublishAppModel" keyProperty="stdId" modelVar="std" >
			<c:set var="currPath" value="${std.taxonomyPath}${std.taxonomyText}" />
			<c:choose>
				<c:when test="${currPath eq prevPath}"> </c:when>
				<c:otherwise>
					<tr>
				   		<td colspan="3">
							<div class="row"><h4 ><span class="grey" >${std.taxonomyPath}</span><span class="blue">${std.taxonomyText}</span></h4></div>
				  		</td>
				  	</tr>
				</c:otherwise>
			</c:choose>
			<!-- Standards Display -->
			<tr> 
				<c:choose>
					<c:when test='${"UPDATE" eq std.status}'>
						<td class="update" width="50px"><span class="label label-warning">Update</span></td>
					</c:when>
					<c:when test='${"NEW" eq std.status}'>
						<td class="new" width="50px"><span class="label label-success">New</span></td>
					</c:when>
                    <c:when test='${"NO_CHANGE" eq std.status}'>
                        <td class="no_change" width="50px"><span class="label label-warning">No Change</span></td>
                    </c:when>
					<c:otherwise>
                        <td width="50px"></td>
					</c:otherwise>
				</c:choose>
		  		<td colspan="2">
		  			<strong><c:out value="${std.title}"/><span id="s_id"><c:out value="[${std.stdId }]"/></span></strong> 
					<c:if test='${"UPDATE" eq std.status && activeOBSMPublish}'>
						<a href="#" onclick="jQuery('#${std.stdId}').toggle();return false;"><span class="label">Show Current OBSM Text</span></a>
					</c:if>
				  	<c:if test='${std.attachmentExists eq true}'>
						<span class="label label-info">
							<a href="javascript:supportingMaterialPopup('${std.stdId}')"> 
								<img alt="Supporting Material" title="Supporting Material" src="/BSBridge-theme/images/PaperClip_white.png" style="height:14px; width:14px;">
							</a>
						</span>
					</c:if>
					<c:if test='${not empty std.complDateStr}'>
						<span class="complianceDate show_inline label label-info">${std.complDateStr}</span>
					</c:if>
					<c:if test='${std.imageAttached eq true}'>
						<span class="label label-info">
							<a role="button" title="View Details" href="javascript:allMandatoryImagesPopup('${std.stdId}')" class="imageModalTrigger">View Details</a>
						</span>
					</c:if>
					<c:if test='${std.referenceExists eq true}'>
						<span class="label label-default"><i class="icon-share-alt icon-white"></i>See also ID number [
					 		<c:forEach items="${fn:split(std.stdReference, ',')}" var="reference" varStatus="counter">
								<c:if test="${!counter.first}">,&nbsp;</c:if>
								<a href="#" class="grey" onclick="javascript:stdReferencePopup('${reference}')">${reference}</a>
							</c:forEach>]
						</span>
					</c:if>
					<c:if test='${not empty std.hotelLifecycleAttr}'>
				  		<span class="whiteSpaceNowrap">
							<c:forEach items="${htlLifeCycleFlags}" var="flgCatgy">
							<c:choose>
							    <c:when test='${fn:contains(std.hotelLifecycleAttr,flgCatgy.flagCatId)}'>
							    	<img src="/BSBridge-portlet/img/${flgCatgy.flagCatId}_${hotelCode}.jpg" class='ht_icon_attr' title='${flgCatgy.txtValue}' />
							    </c:when>
							    <c:otherwise>
							    	<img src="/BSBridge-portlet/img/${flgCatgy.flagCatId}.jpg" class='ht_icon_attr' title='${flgCatgy.txtValue}' />
							    </c:otherwise>
							</c:choose>
							</c:forEach> 
						</span>
					</c:if>
				</td>
			</tr>
			<c:if test='${"UPDATE" eq std.status && activeOBSMPublish}'>
				<tr id="${std.stdId}" class="changeRow">
					<td class="update visible"></td>
					<td colspan="2"><strong><c:out value="${std.currentTitle}"/></strong></td>
				</tr>
			</c:if>
			<!-- Specifications Display -->
			<c:forEach items="${std.specifications}" var="specStd">
			<tr>
				<c:choose>
					<c:when test='${"UPDATE" eq specStd.status}'>
						<td class="update" width="50px"><span class="label label-warning">Update</span></td>
					</c:when>
					<c:when test='${"NEW" eq specStd.status}'>
						<td class="new" width="50px"><span class="label label-success">New</span></td>
					</c:when>
                    <c:when test='${"NO_CHANGE" eq specStd.status}'>
                        <td class="no_change" width="50px"><span class="label label-warning">No Change</span></td>
                    </c:when>
                    <c:otherwise>
                        <td width="50px"></td>
                    </c:otherwise>
				</c:choose>
				<td class="bull">&#8226;</td>
				<td>
					<c:out value="${specStd.title}"/><span id="s_id"><c:out value="[${specStd.stdId }]"/></span>
					<c:if test='${"UPDATE" eq specStd.status && activeOBSMPublish}'>
						<a href="#" onclick="jQuery('#${specStd.stdId}').toggle();return false;"><span class="label">Show Current OBSM Text</span></a>
					</c:if>
					<c:if test='${specStd.attachmentExists eq true}'>
						<span class="label label-info">
							<a href="javascript:supportingMaterialPopup('${specStd.stdId}')">
								<img alt="Supporting Material" title="Supporting Material" src="/BSBridge-theme/images/PaperClip_white.png" style="height:14px; width:14px;">
							</a>
						</span>
					</c:if>
					<c:if test='${not empty specStd.complDateStr}'>
						<span class="complianceDate show_inline label label-info">${specStd.complDateStr}</span>
					</c:if>
					<c:if test='${specStd.imageAttached eq true}'>
						<span class="label label-info">
							<a role="button" title="View Details" href="javascript:allMandatoryImagesPopup('${specStd.stdId }')" class="imageModalTrigger">View Details</a>
						</span>
					</c:if> 
					<c:if test='${specStd.referenceExists eq true}'>
						<span class="label label-default"><i class="icon-share-alt icon-white"></i>See also ID number [
							<c:forEach items="${fn:split(specStd.stdReference, ',')}" var="reference" varStatus="counter">
								<c:if test="${!counter.first}">,&nbsp;</c:if>
								<a href="#" class="grey" onclick="javascript:stdReferencePopup('${reference}')">${reference}</a>
							</c:forEach>]
						</span>
					</c:if>
					<c:if test='${not empty specStd.hotelLifecycleAttr}'>
		  				<span class="whiteSpaceNowrap">
							<c:forEach items="${htlLifeCycleFlags}" var="flgCatgy">
							<c:choose>
							    <c:when test='${fn:contains(specStd.hotelLifecycleAttr,flgCatgy.flagCatId)}'>
							    	<img src="/BSBridge-portlet/img/${flgCatgy.flagCatId}_${hotelCode}.jpg" class='ht_icon_attr' title='${flgCatgy.txtValue }' />
							    </c:when>
							    <c:otherwise>
							    	<img src="/BSBridge-portlet/img/${flgCatgy.flagCatId}.jpg" class='ht_icon_attr' title='${flgCatgy.txtValue }' />
							    </c:otherwise>
							</c:choose>
							</c:forEach> 
						</span>
					</c:if>
				</td>
			</tr>
			<c:if test='${"UPDATE" eq specStd.status && activeOBSMPublish}'>
				<tr id="${specStd.stdId}" class="changeRow">
					<td class="update visible">&nbsp;</td>
					<td class="bull">&#8226;</td>
					<td><c:out value="${specStd.currentTitle}"/></td>
				</tr>
			</c:if>
			</c:forEach>
			<!-- Guidelines Display -->					
			<c:if test="${fn:length(std.guidelines) gt 0}">
				<tr>
					<td class="update invisible"></td>
					<td style="padding-top:5px;" class="lg" colspan="2"><strong>Guidelines</strong></td>
				</tr>
				<c:forEach items="${std.guidelines}" var="gdlnStd">
				<tr>
					<c:choose>
						<c:when test='${"UPDATE" eq gdlnStd.status}'>
							<td class="update" width="50px"><span class="label label-warning">Update</span></td>
						</c:when>
						<c:when test='${"NEW" eq gdlnStd.status}'>
							<td class="new" width="50px"><span class="label label-success">New</span></td>
						</c:when>
                    <c:when test='${"NO_CHANGE" eq gdlnStd.status}'>
                        <td class="no_change" width="50px"><span class="label label-warning">No Change</span></td>
                    </c:when>
                    <c:otherwise>
                        <td width="50px"></td>
                    </c:otherwise>
					</c:choose>		
					<td class="bull">&#8226;</td>
					<td class="lg">
						<c:out value="${gdlnStd.title}"/><span id="s_id"><c:out value="[${gdlnStd.stdId}]"/></span>
						<c:if test='${"UPDATE" eq gdlnStd.status && activeOBSMPublish}'>
							<a href="#" onclick="jQuery('#${gdlnStd.stdId}').toggle();return false;"><span class="label">Show Current OBSM Text</span></a>
						</c:if>
						<c:if test='${gdlnStd.attachmentExists eq true}'>
							<span class="label label-info">
								<a href="javascript:supportingMaterialPopup('${gdlnStd.stdId}')">
									<img alt="Supporting Material" title="Supporting Material" src="/BSBridge-theme/images/PaperClip_white.png" style="height:14px; width:14px;">
								</a>
							</span>
						</c:if>
						<%-- <c:if test='${not empty gdlnStd.complDateStr}'>
							<span class="complianceDate show_inline label label-info">${gdlnStd.complDateStr}</span>
						</c:if> --%>
						<c:if test='${gdlnStd.imageAttached eq true}'>
							<span class="label label-info">
								<a role="button" href="javascript:allMandatoryImagesPopup('${gdlnStd.stdId}')" title="View Details" class="imageModalTrigger">View Details</a>
							</span>
						</c:if>
						<c:if test='${gdlnStd.referenceExists eq true}'>
							<span class="label label-default"><i class="icon-share-alt icon-white"></i>See also ID number [
								<c:forEach items="${fn:split(gdlnStd.stdReference, ',')}" var="reference" varStatus="counter">
									<c:if test="${!counter.first}">,&nbsp;</c:if>
									<a href="#" class="grey" onclick="javascript:stdReferencePopup('${reference}')">${reference}</a>
								</c:forEach>]
							</span>
						</c:if> 
						<c:if test='${not empty gdlnStd.hotelLifecycleAttr}'>
			  				<span class="whiteSpaceNowrap">
								<c:forEach items="${htlLifeCycleFlags}" var="flgCatgy">
								<c:choose>
								    <c:when test='${fn:contains(gdlnStd.hotelLifecycleAttr,flgCatgy.flagCatId)}'>
								    	<img src="/BSBridge-portlet/img/${flgCatgy.flagCatId}_${hotelCode}.jpg" class='ht_icon_attr' title='${flgCatgy.txtValue }' />
								    </c:when>
								    <c:otherwise>
								    	<img src="/BSBridge-portlet/img/${flgCatgy.flagCatId}.jpg" class='ht_icon_attr' title='${flgCatgy.txtValue }' />
								    </c:otherwise>
								</c:choose>
								</c:forEach> 
							</span>
						</c:if>
					</td>
				</tr>
				<c:if test='${"UPDATE" eq gdlnStd.status && activeOBSMPublish}'>
					<tr id="${gdlnStd.stdId}" class="changeRow">
						<td class="update">&nbsp;</td>
						<td class="bull">&#8226;</td>
						<td><c:out value="${gdlnStd.currentTitle}"/><td>
					</tr>
				</c:if>							
				</c:forEach>
			</c:if>
			<tr><td colspan=3><hr/></td></tr>
			<c:set var="prevPath" value="${currPath}" />
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator/>
		</liferay-ui:search-container>
	</tbody></table>
</div>
</section>

<div id="stdReferenceDialog_popup" style="display: none;" title="Reference"></div>
<div id="mandatoryImages_popup" title="Details" style="display:none;">	</div>
<div id="supportingMaterial_popup" style="display: none;"></div>
<div id="groupCountry_popup" style="display: none;" title="Countries/Region"></div>
</c:when>
<c:when test="${empty countryGroups}">
	Please add records in my publication.
</c:when>
<c:otherwise>
	Not logged in !!
</c:otherwise>
</c:choose>
</c:when>
<c:otherwise>
	Please create new publication.
</c:otherwise>
</c:choose>