<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portlet.PortletURLFactoryUtil"%>
<%@page import="java.util.Enumeration"%>
<%@page import="java.util.Map"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@include file="/html/mustPublish/init.jsp"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>

<script type="text/javascript" src="/BSBridge-theme/js/treeAdmin/jquery.blockUI.js"></script>
<script type="text/javascript" src="/BSBridge-theme/js/treeAdmin/jquery.msgBox.js"></script>
<script src="/BSBridge-portlet/js/mustpublish.js"></script>

<liferay-portlet:resourceURL var="regionCountryListURL" id="regionCountryList"/>
<liferay-portlet:resourceURL var="addByIdURL" id="addByIdSearch"/>
<liferay-portlet:actionURL var="deleteURL" name="deleteStandards"/>
<liferay-portlet:actionURL name="importMustPublish" var="importURL"/>
<liferay-portlet:actionURL name="addMustPublish" var="addByidSaveURL"/>
<portlet:resourceURL var="exportReportURL" id='exportReport'>
    <portlet:param name="requestType" value="exportReport"></portlet:param>
</portlet:resourceURL>
<%String fileName="";
fileName=ParamUtil.getString(renderRequest,"fileName","");
%>
 <portlet:resourceURL id="getCSVData" var="csvDataURL">
 <portlet:param name="fileName" value="<%=fileName%>"></portlet:param>
 </portlet:resourceURL>
<liferay-portlet:renderURL var="findIdURL" />
<%
	String idSearchCriteria = (String)request.getAttribute("highlightSearchIds"); 
	if(Validator.isNull(idSearchCriteria)){
		idSearchCriteria = "";
	}
	String stdIds=(String)session.getAttribute("result_ids");
	 boolean stdIdsAvail=false;
	if(Validator.isNotNull(stdIds) && stdIds.length()>0){
		stdIdsAvail=true;
	}
	session.removeAttribute("result_ids");
%>
<script type="text/javascript">
	var regionCountryListURL =  '${regionCountryListURL}';
	var addByIdURL = '${addByIdURL}';
	
	$(document).ready(function() {
		/* Hiding Un-necessary info of liferay search container */
		if(jQuery('.search-results').length > 0){
			jQuery(".table-striped").css({"display":"none"}); 
		} else {
			jQuery(".taglib-search-iterator-page-iterator-bottom").css({"display":"none"});
		}
		
		var idCriteria = [<%=idSearchCriteria%>];
		for(var l = 0; l < idCriteria.length; l++) {
			$("#standards").highlight(idCriteria[l]);	
		}
		
		$( "#addedInImport" ).dialog({
	        autoOpen: false,
	        width: 560,
	         modal: true,
	        open: function() {
	            jQuery('.ui-widget-overlay,.errorInImport').bind('click', function() {
	            	
	                jQuery('#addedInImport').dialog('close');
	            })
	        }
	        
	    });
		
		var std_ids='<%=stdIdsAvail%>';
		if(std_ids == 'true'){
		 $( "#addedInImport" ).dialog( "open" );
		}
		
		
		});
	
	
</script>
<style type="text/css">
	.lfr-search-container {margin-top: 0px;!important;}
	.pager {margin: 10px 0 !important;}
	.ui-dialog {top: 5% !important;}
	table.specs.must-publish-list {width: auto;}
	#addedInImport ul li{
	margin:10px;
	}
	#addedInImport ul{margin-left:15px;}
	 .show-read-more .more-text{
        display: none;
    }
    
		.btn.download-btn {
		  border: none;
		  padding: 12px 4px;
		  cursor: pointer;
		  font-size: 14px;
		}
		
		/* /* Darker background on mouse-over */
		.download-btn.btn:hover {
		  background-color: RoyalBlue;
		} */

</style>
<div id="addedInImport" title="Attention" style="display:none;">
				<div class="modal-body">
				<h4>Some standards failed to be imported due to one of the following reasons:</h4>
			        <ul >
						  <li>Not a Global or Multi Regional Standard/Spec/Guideline </li>
						  <li>Not associated with the selected brand <strong><%=(String)renderRequest.getAttribute("brand")%></strong></li>
						  <li>Discontinued Standard/Spec/Guideline</li>
					</ul>
					<Strong>Invalid Standard/Spec/Guideline Id('s) : </strong>
					
       					<p>
       					<%=stdIds %>
       					<% String count=ParamUtil.getString(renderRequest,"recordCount","");
       					if(Validator.isNotNull(count) && Long.valueOf(count) > 100){ %>
       					...
       					<strong>To view more Id's click on 
       					<a href="#" onclick="window.location.href='${csvDataURL}'"> Download. </a></strong>
       					<%} %>
       					</p>
       					
			      
			      </div>
				<div class="modal-footer">
				    <div class="pull-right"><button type="submit" style="width:85px;"  class="btn btn-primary errorInImport">OK</button></div>
			  	</div>
		</div>
<c:choose>
	<c:when test="${bridgePublishId eq 0}">
		Please create new publication.
	</c:when>
	<c:when test ="${loggedIn and empty error}">
		<%
		    PortletURL iteratorURL = renderResponse.createRenderURL();
			//List<BridgePublishAppModel> displayStd = (List<BridgePublishModel>) request.getAttribute("displayStd");
			SearchContainer<BridgePublishAppModel> searchContainerObj = (SearchContainer<BridgePublishAppModel>) request.getAttribute("searchContainerObj");
		%>
		<!-- Keep the below 2 un-closed divs as this is a fix for footer left aligning issue -->
		<div><div>
        
		<div class="row" > 
			<div class="well well-small" style="margin-bottom: 2px;" > 
				<div class="row" style="margin-top: 5px;"> 
					<div class="span6"> 
						<div class="pull-left"> 
							<form class="form-inline" style="margin-bottom: 0;"> 
								<c:if test="${publicationLocked eq false && bridgePublishId gt 0}">
									<a class="btn btn-primary add-by-id" href="#"><i class="icon-white icon-plus"></i> Add By ID</a> 
									<c:if test="${isMust}">
										<a class="btn btn-primary add-by-import" href="#"><i class="icon-white icon-plus"></i> Add By Import</a>
										<a class="btn btn-primary export-report" id="export" href="#"><i class="icon-arrow-down icon-white"></i>Export</a>
									</c:if>
								</c:if>
								<div style="margin-top: 3px;"> </div> 
							</form> 
						</div> 
						<c:if test="${isMust && issueCount gt 0}">
						<div class="pull-right issues_count"> 
							<img src="/BSBridge-theme/images/issue_icon.png"> ${issueCount} Issues
						</div>
						</c:if>
					</div> 
					<div class="span6"> 
						<div class="pull-right"> 
							<form class="form-inline" style="margin-bottom: 0;" id="findForm" name="findForm" method="post" action="<%= findIdURL%>"> 
								<span><strong>Find By ID:</strong></span> 
								<input type="text" style="margin-bottom: 0px;" class="input-medium" placeholder="Enter STD ID to find ..."  maxlength="2000" value='<c:if test="${not empty findId}">${findId} </c:if>' id="findId" name="findId">
								<c:set var="findIds" value="${fn:split(findId, ' ')}"/> 
									<a href="#" role="button" class="btn btn-primary" onclick="find();"><i class="icon-search icon-white"></i> Go</a> 
									<a href="#" role="button" class="btn" onclick="clearSearch();"><i class="icon-remove"></i> Clear</a> 
							</form> 
						</div> 
					</div>  
				</div> 
			</div> 
		</div>
		<c:if test="${not empty notFound }">
			<div class="alert alert-warning" role="alert">
	     		 <strong>The following terms were not found <c:out value="${notFound }"/></strong> 
	    	</div>
	    	<%  searchContainerObj.setEmptyResultsMessage(StringPool.BLANK); %> <!-- Here we set empty message for search container, to remove multiple message i.e. above message and empty result message. -->
    	</c:if>
		<section id="standards">
			<div id="result">
			<c:set var="prevPath" value="-" />
			<table>
			<liferay-ui:search-container id="searchContainer" emptyResultsMessage="No Standards Available" searchContainer="<%=searchContainerObj%>" delta="1" >
				<liferay-ui:search-container-results results="<%=searchContainer.getResults()%>" total="<%=searchContainer.getTotal()%>"/>
				<liferay-ui:search-container-row className="com.ihg.brandstandards.bridge.model.BridgePublishAppModel" keyProperty="stdId" modelVar="std" >
					<c:set var="currPath" value="${std.taxonomyPath}${ std.currentPath}" />
					<c:set var="searchIdFoundForStd" value="false"/>
					<c:choose>
						<c:when test="${currPath eq prevPath}">
						</c:when>
						<c:otherwise>
							<tr>
								<td>
									<div class="row" >
										<h4 >
											<span class="grey">${std.taxonomyPath}</span>
											<c:out value="${std.currentPath}"/>
										</h4>
									</div>
								</td>
							</tr>
						</c:otherwise>
					</c:choose>
					<tr> 
						<td>
							<div  class="row">
								<table class="specs must-publish-list" border="0">
									<tbody>
										<tr>
											<td class="align-center">
												<table border="0" class="btns">
													<tbody>
														<tr>
															<c:if test="${isMust}">
																<td width="55px"><button class='btn btn-mini ${std.amea} <c:if test="${std.amea eq 'btn-primary'}"> btn-primary-DB </c:if>' type="button" onclick="getCountry('${std.stdId }','3','AMEA');">AMEA</button></td>
																<td width="55px"><button class='btn btn-mini ${std.amer} <c:if test="${std.amer eq 'btn-primary'}"> btn-primary-DB </c:if>' type="button" onclick="getCountry('${std.stdId }','2','AMER');">AMER </button></td>
																<td width="40px"><button class='btn btn-mini ${std.euro} <c:if test="${std.euro eq 'btn-primary'}"> btn-primary-DB </c:if>' type="button" onclick="getCountry('${std.stdId }','4','EURO');">EU</button></td>
																<td width="40px"><button class='btn btn-mini ${std.gc} <c:if test="${std.gc eq 'btn-primary'}"> btn-primary-DB </c:if>' type="button" onclick="getCountry('${std.stdId }','5','GC');">GC</button></td>
																<td width="20px"><a href="#"><i class="icon-remove" onclick="deleteStd('${std.stdId },${std.chieldIds }');"></i></a></td>
															</c:if>
														</tr>
													</tbody>
												</table>
											</td>
											<td width="14">
												<c:if test="${std.regionCode eq 'GLBL'}">
														<c:choose>
															<c:when test="${std.isGlobal eq 'G'}">
																<c:if test="${std.framework eq 'Y'}">
																		<img src="/BSBridge-theme/images/global_icon_red.png"
																			class="global_icon" title="Global Framework standard icon"
																			alt="Global Framework standard icon" /> 
																</c:if>
															</c:when>
															<c:otherwise>
																<c:if test="${std.framework eq 'Y'}">
																	<img src="/BSBridge-theme/images/global_icon_halfred.png"
																		class="global_icon" title="Multi-region Framework standard icon"
																		alt="Multi-region Framework standard icon" />
																</c:if>
															</c:otherwise>
														</c:choose>
												</c:if>
											</td>
											<td colspan="2">
												<strong>${std.title}</strong><span class="grey">&nbsp;[${std.stdId }]</span>
											</td>
										</tr>
										<c:forEach items="${std.specifications}" var="specStd">
											<c:set var="searchIdFoundForSpec" value="false"/>
											<tr>
												<td class="align-center">
													<table border="0" class="btns">
														<tbody>
															<tr>
																<c:choose>
																<c:when test="${isMust}">
																	<td width="55px"><button class='btn btn-mini ${specStd.amea} <c:if test="${specStd.amea eq 'btn-primary'}"> btn-primary-DB </c:if>' type="button" onclick="getCountry('${specStd.stdId }','3','AMEA');">AMEA</button></td>
																	<td width="55px"><button class='btn btn-mini ${specStd.amer} <c:if test="${specStd.amer eq 'btn-primary'}"> btn-primary-DB </c:if>' type="button" onclick="getCountry('${specStd.stdId }','2','AMER');" >AMER</button></td>
																	<td width="40px"><button class='btn btn-mini ${specStd.euro} <c:if test="${specStd.euro eq 'btn-primary'}"> btn-primary-DB </c:if>' type="button" onclick="getCountry('${specStd.stdId }','4','EURO');" >EU</button></td>
																	<td width="40px"><button class='btn btn-mini ${specStd.gc} <c:if test="${specStd.gc eq 'btn-primary'}"> btn-primary-DB </c:if>' type="button" onclick="getCountry('${specStd.stdId }','5','GC');" >GC</button></td>
																</c:when>
																<c:otherwise>
																	<td><span class="label  label-important">Global Must Not</span></td>
																</c:otherwise>
																</c:choose>
																<td width="20px"><a href="#"><i class="icon-remove" onclick="deleteStd('${specStd.stdId },');"></i></a></td>
															</tr>
														</tbody>
													</table>
												</td>
												<td width="14">
													<c:if test="${specStd.regionCode eq 'GLBL'}">
														<c:choose>
															<c:when test="${specStd.isGlobal eq 'G'}">
																<c:if test="${specStd.framework eq 'Y'}">
																	<img src="/BSBridge-theme/images/global_icon_red.png"
																		class="global_icon" title="Global Framework standard icon"
																		alt="Global Framework standard icon" /> 
																</c:if>
															</c:when>
															<c:otherwise>
																<c:if test="${specStd.framework eq 'Y'}">
																	<img src="/BSBridge-theme/images/global_icon_halfred.png"
																		class="global_icon" title="Multi-region Framework standard icon"
																		alt="Multi-region Framework standard icon" />
																</c:if>
															</c:otherwise>
														</c:choose>
													</c:if>
												</td>
												<td class="bull">&#8226;</td>
												<td>
													${specStd.title} <span class="grey">&nbsp;[${specStd.stdId}]</span>
												</td>
											</tr>
										</c:forEach>
										<c:if test="${fn:length(std.guidelines) gt 0}">
											<tr><td class="invisible"></td><td></td><td style="padding-top:5px;" class="lg" colspan="2"><strong>Guidelines</strong></td></tr>
											<c:forEach items="${std.guidelines}" var="gndlStd">
												<c:set var="searchIdFoundForGndl" value="false"/>
												<tr>
													<td class="align-center">
														<table border="0" class="btns">
															<tbody>
																<tr>
																	<c:choose>
																	<c:when test="${isMust}">
																		<td width="55px"><button class='btn btn-mini ${gndlStd.amea} <c:if test="${gndlStd.amea eq 'btn-primary'}"> btn-primary-DB </c:if>' type="button" onclick="getCountry('${gndlStd.stdId }','3','AMEA');">AMEA</button></td>
																		<td width="55px"><button class='btn btn-mini ${gndlStd.amer} <c:if test="${gndlStd.amer eq 'btn-primary'}"> btn-primary-DB </c:if>' type="button" onclick="getCountry('${gndlStd.stdId }','2','AMER');">AMER</button></td>
																		<td width="40px"><button class='btn btn-mini ${gndlStd.euro} <c:if test="${gndlStd.euro eq 'btn-primary'}"> btn-primary-DB </c:if>' type="button" onclick="getCountry('${gndlStd.stdId }','4','EURO');" >EU</button></td>
																		<td width="40px"><button class='btn btn-mini ${gndlStd.gc} <c:if test="${gndlStd.gc eq 'btn-primary'}"> btn-primary-DB </c:if>' type="button" onclick="getCountry('${gndlStd.stdId }','5','GC');" >GC</button></td>
																	</c:when>
																	<c:otherwise>
																		<td><span class="label  label-important">Global Must Not</span></td>
																	</c:otherwise>
																	</c:choose>
																	<td width="20px"><a href="#"><i class="icon-remove" onclick="deleteStd('${gndlStd.stdId },');"></i></a></td>
																</tr>
															</tbody>
														</table>
													</td>
													<td width="14">
														<c:if test="${gndlStd.regionCode eq 'GLBL'}">
															<c:choose>
																<c:when test="${gndlStd.isGlobal eq 'G'}">
																	<c:if test="${gndlStd.framework eq 'Y'}">
																		<img src="/BSBridge-theme/images/global_icon_red.png"
																			class="global_icon" title="Global Framework standard icon"
																			alt="Global Framework standard icon" /> 
																	</c:if>
																</c:when>
																<c:otherwise>
																	<c:if test="${gndlStd.framework eq 'Y'}">
																		<img src="/BSBridge-theme/images/global_icon_halfred.png"
																			class="global_icon" title="Multi-region Framework standard icon"
																			alt="Multi-region Framework standard icon" />
																	</c:if>
																</c:otherwise>
															</c:choose> 
														</c:if>
													</td>
													<td class="bull lg">&#8226;</td>
													<td class="lg">
														${gndlStd.title} <span class="grey">&nbsp;[${gndlStd.stdId}]</span>
													</td>
												</tr>
											</c:forEach>
										</c:if>
									</tbody>
								</table>
								<hr/>
							</div>
						</td>
					</tr>
					<c:set var="prevPath" value="${currPath }" />
				</liferay-ui:search-container-row>
				<liferay-ui:search-iterator/>
			</liferay-ui:search-container>
			</table>
			</div>
		</section>
		
		<div id="addByImport" <c:choose><c:when test="${isMust}">title="Add items to Global Must List"</c:when> <c:otherwise>title="Add items to Global Must Not List"</c:otherwise></c:choose> style="display:none">
			<form id="importForm" name="importForm" action="<%=importURL %>" method="post" enctype="multipart/form-data">
				<div class="modal-body">
			        <h4>Please select a file to upload:</h4> <input type="file" id="file" class="add_item_file_input" name="file"/>
			      </div>
				<div class="modal-footer">
				    <div class="pull-left"><button type="button" class="btn searchoptioncancel">Cancel</button></div>
				    <div class="pull-right"><button type="submit" id="upload" class="btn btn-primary">Upload</button></div>
			  	</div>
		  	</form>
		</div>
		
		<div id="regionCountrylist" title="View Attribution" style="display:none">
			<form id="countryForm" name="countryForm">
				<input type="hidden" id="findId" name="findId" value="${findId}"/>
				<input type="hidden" id="bridgeGlobalPublishId" name="bridgeGlobalPublishId" value=""/>
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
		
		<div id="confirm-dialog" title="Attention" style="display:none">
			<form id="deleteForm" name="deleteForm" action="<%=deleteURL %>" method="post" >
				<div class="modal-body">
					<input type="hidden" id="stdId" name="stdId"/>
					Are you sure you want to delete this item from list?
			  	</div>
			  	<div class="modal-footer">
					<div class="pull-left"><button type="button" class="btn confirm-dialog-cancel">No</button></div>
					<div class="pull-right"><button type="submit" class="btn btn-primary">Yes</button></div>
			  	</div>
		  	</form>
		</div>
		
		<div id="addNewItems" title="Add New Items" style="display:none">
			<div class="modal-body">
				<div class="row-fluid"> 
					<p>
						<c:choose>
						<c:when test="${isMust}">
							To Add a Standard, Specification or Guideline use the search features below to locate the Standard, Specification or Guideline that should be added.
						</c:when>
						<c:otherwise>
							To Add a Specification or Guideline of a Global Must Standard use the search features below to locate the Specification or Guideline that should be added to Global Must Not.
						</c:otherwise>
						</c:choose>  
						<strong>Note: Only single CMS IDs are accepted.</strong>
					</p>
					<hr> 
				</div>
				<div class="row-fluid">
					<div class="span5">
						<form style="margin-bottom: 0;" class="form-inline" onsubmit="return searchById();">
							<span><strong>Find By ID:</strong></span> 
							<input type="text"
								placeholder="Enter STD ID to find ..." class="input-medium"
								style="margin-bottom: 0px;" id="searchId" name="searchId"> <a
								class="btn btn-primary" role="button" href="#" onclick="searchById();"><i
								class="icon-search icon-white"></i> Go</a>
						</form>
					</div>
					<div class="msg-text"></div>
				</div>
				<hr> 
				<div id="searchResult">
					<!-- Ajax result will fill content i.e. addById.jsp -->
				</div>
			</div>
			<div class="modal-footer">
				<form id="addByIdForm" name="addByIdForm" style="margin-bottom: 0;" class="form-inline" action="<%=addByidSaveURL %>" method="post">
					<input type="hidden" id="findId" name="findId" value="${findId}"/>
					<input type="hidden" id="addByIds" name="addByIds"/>
					<button type="button" aria-hidden="true" data-dismiss="modal"
						class="btn pull-left addByIdCancel">Cancel</button>
					<button type="button" aria-hidden="true" submitdata-dismiss="modal"
						class="btn btn-primary pull-right" id="addByIdAdd" onclick="saveItems();">Add</button>
				</form>
			</div>
		</div>
        
		<div id="exportReport" title="Compliance Report" style="display:none">
			<form id="exportForm" name="exportForm" method="post" >
			    <div class="modal-body">
			        <input type="radio" checked  style="margin-top: -3px;"/> Export Issue from Import
			        <h4>Report Title <input type="text" id="reportTitle" name="reportTitle"/> </h4> 
			      </div>
			    <div class="modal-footer">
			        <div class="pull-left"><button type="button" class="btn exportCancel">Cancel</button></div>
			        <div class="pull-right"><a class="btn btn-primary" href="javascript:createExportReport('${exportReportURL}', ${reportId})">Run</a></div>
			    </div>
			</form>
		</div>
	</c:when>
	<c:otherwise>
		<c:choose>
			<c:when test="${not empty error }">
				${error}
			</c:when>
			<c:otherwise>
				Not logged in !!
			</c:otherwise>
		</c:choose>
	</c:otherwise>
</c:choose>