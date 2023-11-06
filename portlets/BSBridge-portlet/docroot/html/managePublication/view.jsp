<%@page import="com.ihg.brandstandards.db.service.PublishedPdfListLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.exception.PortalException"%>
<%@page import="com.liferay.portal.kernel.exception.SystemException"%>
<%@page import="com.ihg.brandstandards.bridge.util.BridgeConstants"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.ihg.brandstandards.db.model.Publication"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Date"%>
<%@include file="/../html/init.jsp"%>


<portlet:resourceURL var="publication" id="publicationURL">
	<portlet:param name="requestType" value="createPublication"></portlet:param>
</portlet:resourceURL>

<portlet:resourceURL var="publishToStaging" id="publishToStaging">
	<portlet:param name="requestType" value="publishToStaging"></portlet:param>
</portlet:resourceURL>

<portlet:resourceURL var="deletePublication" id="deletePublication">
	<portlet:param name="requestType" value="deletePublication"></portlet:param>
</portlet:resourceURL>

<portlet:resourceURL var="updatePublicationURL" id="updatePublicationURL">
	<portlet:param name="requestType" value="updatePublication"></portlet:param>
</portlet:resourceURL>

<portlet:resourceURL var="publishToProduction" id="publishToProduction">
	<portlet:param name="requestType" value="publishToProduction"></portlet:param>
</portlet:resourceURL>

<portlet:resourceURL var="generateManualsURL" id="generateManualsURL">
	<portlet:param name="requestType" value="createManuals"></portlet:param>
</portlet:resourceURL>

<portlet:resourceURL var="createReportURL" id='createReport'>
    <portlet:param name="requestType" value="createReport"></portlet:param>
</portlet:resourceURL>

<%
    Map<String,List<Publication>> publicationList = null; 
    Map<Long,Boolean> checkProgress = null; 
    String suppossedPublicationDate = null;
    SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy hh:mm:ss");
    SimpleDateFormat serverDateFormat = new SimpleDateFormat("dd MMM yyyy hh:mm");
    SimpleDateFormat scheduleDateFormat = new SimpleDateFormat("dd MMM yyyy hh:mm:ss aaa");
    SimpleDateFormat publish_formatter = new SimpleDateFormat(BridgeConstants.DEFAULT_DATE_FORMAT);
    Date stageToProdDate = null;
    Map<String,String> languages = (Map<String,String>) renderRequest.getAttribute("languages");
    
    if (Validator.isNotNull(renderRequest.getAttribute("publication"))) {
        publicationList = (Map<String,List<Publication>>)renderRequest.getAttribute("publication");    
    }
    if (Validator.isNotNull(renderRequest.getAttribute("checkProgress"))) {
        checkProgress = (Map<Long,Boolean>)renderRequest.getAttribute("checkProgress");    
    }
    if (Validator.isNotNull(renderRequest.getAttribute("stageToProdDate"))) {
        stageToProdDate = (Date)renderRequest.getAttribute("stageToProdDate");
        suppossedPublicationDate = publish_formatter.format(stageToProdDate);
    }
    long stdCount = GetterUtil.getLong(""+renderRequest.getAttribute("stdCount"),0l);
    boolean publishToStageEnv = GetterUtil.getBoolean(""+renderRequest.getAttribute("publishToStaging"), false);
    boolean publishToProdEnv = GetterUtil.getBoolean(""+renderRequest.getAttribute("publishToProd"), false);
    boolean contTypeBuild = false;
    boolean contTypeOperate = false;
%>

<script type="text/javascript">
<%
if (Validator.isNotNull(publicationList) && !publicationList.get("bridgeArchive").isEmpty())
{
    Publication pub = publicationList.get("bridgeArchive").get(0);
%>
var archiveBridgePublishId = <%=pub.getPublishId() %>;
<%
}
else
{
%>
var archiveBridgePublishId = 0;
<%
}
%>

var publicationURL = '${publication}';
var publishDialog = '';
var stagingDialog = '';
var publishToStagingURL = '${publishToStaging}';
var publishIdValue = '';
var publishQueueIdValue = '';
var deletePublicationURL = '${deletePublication}';
var updatePublishDialog = '';
var updatePublicationURL = '${updatePublicationURL}';
var deletePublishDialog = '';
var publishToProdDialog = '';
var publishToProdURL = '${publishToProduction}';
var env_val = '';
var manualsDialog = '';
var generateManualsURL = '${generateManualsURL}';
var createReportURL = '${createReportURL}';
var fullManual = false;
var buildManual = false;
var operateManual = false;
</script>

<link type="text/css" rel="stylesheet" href="/BSBridge-theme/css/jquery.timepicker.css" />
<link type="text/css" rel="stylesheet" href="/BSBridge-theme/css/msgBoxLight.css" />

<script type="text/javascript" src="/BSBridge-theme/js/jquery.validate.min-1.11.1.js"></script>
<script type="text/javascript" src="/BSBridge-theme/js/additional-methods.min-1.11.1.js"></script>
<script type="text/javascript" src="/BSBridge-theme/js/jquery.form.3.28.0.js"></script>
<script type="text/javascript" src="/BSBridge-theme/js/treeAdmin/jquery.blockUI.js"></script>
<script type="text/javascript" src="/BSBridge-theme/js/treeAdmin/jquery.msgBox.js"></script>
<script type="text/javascript" src="/BSBridge-theme/js/jquery.timepicker.min.js"></script>
<script src="/BSBridge-portlet/js/managePublication.js"></script>

<style>
<!--
.buld_operate_item {
    width: 202px;
}

.buld_operate_item_upd {
    width: 202px;
}

label.error {
    color: red;
    font-size: 0.8em;
    margin-left : 0.5em;
}
-->
</style>

	<div class="row">
        <div class="span7"><h3 style="margin-top: 0px;">Manage Publications</h3></div>
        <div class="span5">
          <div class="pull-right">
            <c:choose>
            	<c:when test="${createPublication eq true}">
            		<a id = "createPublicationRec" href="#" role="button" class="btn btn-danger" data-toggle="modal" disabled="disabled">
            		Create Publication</a>&nbsp;
            	</c:when>
            	<c:otherwise>
            		<a id = "createPublicationRec" href="javascript:openDialog();" role="button" class="btn btn-danger" data-toggle="modal">
            		Create Publication</a>&nbsp;
            	</c:otherwise>
            </c:choose>
          </div>
        </div>
      </div>

      <section id="notes" class="collapse" style="padding-right: 20px;">
        <div class="alert alert-info align-left">
          <ul>
            <li>Because of the Bridge this screen will be slightly different to the operation of the current CMS Admin -> Publish screen.</li>
            <li>Movement of a given publication will be from top to bottom through the accordion panels.</li>

            <li>Possibly show the current server date and time on the Create Publication modal; we always get that wrong!</li>
          </ul>
        </div>
      </section>
      <div class="row">
        <div class="span12">
          <p>The functions contained here help guide you through the process of publishing content to OBSM for <u><strong>${currentBrand}</strong></u>.  You may be emailed on completion of long-running actions.</p>
        </div>
	</div>
<div class="accordion" id="Manageaccordion">
            <%
            	if (Validator.isNotNull(publicationList)) {
            %>
              <h3 class="">Current Draft Publication in the Bridge</h3>  
                <div class="accordion-inner">
                    <table class="table table-bordered">
                      <thead>
                        <tr>
                          <th>ID</th>
                          <th>Expected Publication Date</th>
                          <th>Manual Type</th>
                          <th>Created By</th>
                          <th>Date Created</th>
                          <th width="120px">Actions</th>
                        </tr>
                      </thead>
                      <tbody>
                      <c:set var="isDeletedStaging" value='<%=publicationList.get("bridge").size() %>'></c:set>  
                      
				        <%
                          
                          	for (Publication draftPublication : publicationList.get("bridge")) {
                          	  	User creator = null;
                          	  	String fullName = "";
                          	    if (Validator.isNotNull(GetterUtil.getLong(draftPublication.getCreatorId()))) {
                          	    	try {
                          	        	creator = UserLocalServiceUtil.getUser(GetterUtil.getLong(draftPublication.getCreatorId()));
                          	        	fullName = creator.getFullName();
                          	    	} catch (PortalException e) {
                          	    	    _log.error(e.getMessage());
                          	    	} catch (SystemException e) {
                          	    	    _log.error(e.getMessage());
                          	    	}
                          	    }
                          %>
							<tr>
								<td><%=draftPublication.getPublishId() %></td>
								
                          		<td>
                          		<% if (Validator.isNotNull(draftPublication.getPublishDate())) {%>
                          			<span id="dateText"><%=publish_formatter.format(draftPublication.getPublishDate())%></span>
                          		<%} else { %>
                          			<span id="dateText"></span>
                          		<%} %>
                          		<c:if test="${updatePublicationDate eq true }">
                          			&nbsp;<a href="#" 
                          			onclick = "javascript:openUpdatePublishDialog(<%=draftPublication.getPublishId() %>,'BRIDGE')"><i class="icon-edit"></i></a>
                          		</c:if>
                          		</td>
                                <td><% String conType = draftPublication.getPublishContentType();
                                    if (BridgeConstants.MANUAL_TYPE_FULL_BUILD_OPERATE.equals(conType)) {
                                        contTypeBuild = true;
                                        contTypeOperate = true;
                                    %>
                                    <script type="text/javascript">
                                        fullManual = true;
                                        buildManual = true;
                                        operateManual = true;
                                    </script>
                                        Full <br>Operate <br>Build, Convert & Renovate
                                    <%     
                                    } else if (BridgeConstants.MANUAL_TYPE_BUILD.equals(conType)) {
                                        contTypeBuild = true;
                                        contTypeOperate = false;
                                    %>
                                    <script type="text/javascript">
                                        fullManual = false;
                                        buildManual = true;
                                        operateManual = false;
                                    </script>
                                        Build, Convert & Renovate
                                    <%   
                                    } else if (BridgeConstants.MANUAL_TYPE_OPERATE.equals(conType)) {
                                        contTypeBuild = false;
                                        contTypeOperate = true;
                                    %>
                                    <script type="text/javascript">
                                        fullManual = false;
                                        buildManual = false;
                                        operateManual = true;
                                    </script>
                                        Operate
                                    <%   
                                    } else if (BridgeConstants.MANUAL_TYPE_FULL.equals(conType)) {
                                        contTypeBuild = false;
                                        contTypeOperate = false;
                                    %>
                                    <script type="text/javascript">
                                        fullManual = true;
                                        buildManual = false;
                                        operateManual = false;
                                    </script>
                                        Full
                                    <%   
                                    } else {
                                        contTypeBuild = false;
                                        contTypeOperate = false;
                                    %>
                                    <script type="text/javascript">
                                        fullManual = false;
                                        buildManual = false;
                                        operateManual = false;
                                    </script>
                                        <%=conType %>
                                    <% 
                                    }
                                    if (conType != null) {
                                %>
                                <c:if test="${updatePublicationDate eq true }">
                                    &nbsp;<a href="#" onclick="openUpdateContentTypeDialog(<%=draftPublication.getPublishId() %>,'BRIDGE')">
                                    <i class="icon-edit edit_content_type"></i></a>
                                </c:if>
                                <%} %>
                                </td>
                          		<td><%=fullName %></td>
                         		<td><%=publish_formatter.format(draftPublication.getCreatedDate()) %></td>
                         		<td class="le">
                            		<%
                            			String isDisabled = "";
                            			if (Validator.isNotNull(checkProgress) && checkProgress.containsKey(draftPublication.getPublishId()) && 
                            					checkProgress.get(draftPublication.getPublishId()) == true && stdCount > 0l && publishToStageEnv && publishToProdEnv) {
                            			
                            		%>
                            			<button href="#"  onclick="javascript:openStagingDialog(<%=draftPublication.getPublishId() %>)" 
                            			role="button" id="btn-small-staging" class="btn btn-small btn-primary btn-block" data-toggle="modal">Push to Staging</button>
                           			
                            		<%	
                            			} else {
                            		%>
                            			<button href="#"  onclick="javascript:openStagingDialog(<%=draftPublication.getPublishId() %>)" disabled="disabled" 
                            			role="button" id="btn-small-staging" class="btn btn-small btn-primary btn-block" data-toggle="modal">Push to Staging</button>
                           			
                            		<%
                            			}
                            		%>
                            		<c:choose>
                            			<c:when test="${removeDraftPublication eq true}">
                            				<button onclick="javascript:deletePublishRecord(<%=draftPublication.getPublishId()%>,0);" role="button" 
                            				class="btn btn-small btn-danger btn-block" data-toggle="modal">Cancel</button>
                            			</c:when>
                            			<c:otherwise>
                            				<button  role="button" class="btn btn-small btn-danger btn-block" data-toggle="modal" disabled="disabled">Cancel</button>
                            			</c:otherwise>
                            		</c:choose>
                                    <!-- Bridge Report -->
                           			<button id="bridge-report" href="#" role="button" class="btn btn-small btn-primary btn-block bridge-report" 
                                            onclick="javascript:openBridgeReport(<%=draftPublication.getPublishId() %>)">Reports</button>
                       			</td>
							</tr>                          
                          <%
                          	}
                          %>
                      </tbody>
                    </table>
                </div>
                 <h3 class="">Publications in Staging</h3>
                <div class="accordion-inner">
                   <table class="table table-bordered">
                    <thead>
                      <tr>
                        <th>Id</th>
                        <th>Assumed Publication Date</th>
                        <th>Status</th>
                        <th>Date of Push</th>
                        <th>Languages Published</th>
                        <th>By</th>
                        <th width="120px">Actions</th>
                      </tr>
                    </thead>
                    <tbody>
                    	<%
                    		for (Publication stagePublication : publicationList.get("staging")) {
                    		    User creator = null;
                          	  	String fullName = "";
                          	    if (Validator.isNotNull(GetterUtil.getLong(stagePublication.getCreatorId()))) {
                          	    	try {
                          	        	creator = UserLocalServiceUtil.getUser(GetterUtil.getLong(stagePublication.getCreatorId()));
                          	        	fullName = creator.getFullName();
                          	    	} catch (PortalException e) {
                          	    	    _log.error(e.getMessage());
                          	    	} catch (SystemException e) {
                          	    	    _log.error(e.getMessage());
                          	    	}
                          	    }
                        %>
							<tr>
								<td><%=stagePublication.getPublishId() %></td>
                          		<td>
                          		<% if (Validator.isNotNull(suppossedPublicationDate) && "ACTIVE".equals(stagePublication.getPublishStatCd())) {%>
                          			<span id="dateText"><%=suppossedPublicationDate%></span>
                          		<%} else if (Validator.isNotNull(stagePublication.getPublishDate())) { %>
                          			<span id="dateText"><%=publish_formatter.format(stagePublication.getPublishDate())%></span>
                          		<%} else { %>
                          			<span id="dateText"></span>
                          		<%
                          			} %>
                          		</td>
                          		<td><%=stagePublication.getPublishStatCd() %></td>
                          		<td><%=formatter.format(stagePublication.getCreatedDate()) %></td>
                          		<td>
                          		<%
                          			if (Validator.isNotNull(stagePublication.getPublishLocaleList())) {
                          				//languages
                          				for (String publishLocale :stagePublication.getPublishLocaleList().split(",")) {
                          		%>
                          				<%=languages.get(publishLocale) %><br/>
                          		<% 			
                          				}
                          				
                          			}
                          		%>
                          		</td>
                         		<td><%=fullName %></td>
                         		<% if ("ACTIVE".equals(stagePublication.getPublishStatCd())) {
                         		%>
                         			<td class="le">
                         			<c:choose>
	                            			<c:when test='${isDeletedStaging ne 0}'>
	                            		<button href="#" role="button" class="btn btn-small btn-danger btn-block" data-toggle="modal" 
	                           			onclick="javascript:openManualsDialog(<%=stagePublication.getPublishId() %>,'STAGING')">Generate Manuals</button>
                                       </c:when>
	                            			<c:otherwise>
	                            				<button href="#" role="button" class="btn btn-small btn-danger btn-block" data-toggle="modal" 
	                           						onclick="#" disabled="disabled">Generate Manuals</button>
	                            			</c:otherwise>
	                            		</c:choose>
	                           			<!-- Staging Reports -->
	                        			<button id="staging-report" href="#" role="button" class="btn btn-small btn-primary btn-block stage-report"
                                        onclick="javascript:openStageReport(<%=stagePublication.getPublishId() %>)">Reports</button>
                                        <c:choose>
	                            			<c:when test='${publishToProd eq true && isDeletedStaging ne 0}'>
	                            				<button href="#"  onclick="javascript:openProductionDialog(<%=stagePublication.getPublishId() %>)" role="button" 
	                            				class="btn btn-small btn-primary btn-block" data-toggle="modal">Push to Production</button>
	                            			</c:when>
	                            			<c:otherwise>
	                            				<button href="#"  onclick="#" role="button" 
	                            				class="btn btn-small btn-primary btn-block" disabled="disabled" data-toggle="modal">Push to Production</button>
	                            			</c:otherwise>
	                            		</c:choose>
	                       			</td>
                         		
                         		<%	
                         		
                         			} else { 
                         		%>
	                         		<td class="le">
	                            		<button onclick="javascript:deletePublishRecord(0,<%=stagePublication.getPublishId()%>);" role="button" 
                            				class="btn btn-small btn-danger btn-block" data-toggle="modal">Cancel</button>
	                       			</td>
                       			<%} %>
							</tr> 
						<%
                    		}
						%>                         
                    </tbody>
                  </table>
                </div>
                <h3 class="">Production Publication History</h3>
                <div class="accordion-inner">
                  <table class="table table-bordered">
                    <thead>
                      <tr>
                        <th>Id</th>
                        <th>Scheduled By</th>
                        <th>Date Scheduled</th>
                        <th>Status</th>
                        <th>Published Date</th>
                        <th>Languages</th>
                        <th width="120px">Actions</th>
                      </tr>
                    </thead>
                    <tbody>
    					<%
    						for (Publication prodPublication : publicationList.get("production")) {
    						    User creator = null;
                          	  	String fullName = "";
                          	    if (Validator.isNotNull(GetterUtil.getLong(prodPublication.getCreatorId()))) {
                          	    	try {
                          	        	creator = UserLocalServiceUtil.getUser(GetterUtil.getLong(prodPublication.getCreatorId()));
                          	        	fullName = creator.getFullName();
                          	    	} catch (PortalException e) {
                          	    	    _log.error(e.getMessage());
                          	    	} catch (SystemException e) {
                          	    	    _log.error(e.getMessage());
                          	    	}
                          	    }
                        %>                  
							<tr>
								<td><%=prodPublication.getPublishId() %></td>
                          		<td><%=fullName %></td>
                          		<td>
                          		<% if (Validator.isNotNull(prodPublication.getPublishDate())) {%>
                          			<span id="dateText"><%=scheduleDateFormat.format(prodPublication.getPublishDate())%></span>
                          		<%} else { %>
                          			<span id="dateText"></span>
                          		<%} %>
                          		</td>
                          		<td><%=prodPublication.getPublishStatCd() %></td>
                          		<td><span id="dateText"><%=publish_formatter.format(prodPublication.getUpdatedDate())%></span></td>
                         		<td>
								<%
                          			if (Validator.isNotNull(prodPublication.getPublishLocaleList())) {
                          				//languages
                          				for (String publishLocale :prodPublication.getPublishLocaleList().split(",")) {
                          		%>
                          				<%=languages.get(publishLocale) %><br/>
                          		<% 			
                          				}
                          				
                          			}
                          		%>
								</td>
                         		<td class="le">
                         		<%  
                         			if ("ACTIVE".equals(prodPublication.getPublishStatCd())) {
								%>
											<button href="#" role="button" class="btn btn-small btn-danger btn-block" data-toggle="modal" 
											onclick="javascript:openManualsDialog(<%=prodPublication.getPublishId() %>,'PRODUCTION')"><%=PublishedPdfListLocalServiceUtil.getPublishedManualCount(prodPublication.getPublishId())>0?"Regenerate ":"Generate " %>Manuals</button>
                                        <!-- Production Reports -->
                                        <button id="production-report" href="#" role="button" class="btn btn-small btn-primary btn-block production-report"
                                                onclick="javascript:openProductionReport(<%=prodPublication.getPublishId() %>, true)">Reports</button>
								<%                         			
                         			}
                         			else
                         			{
                         		%>
                                    <!-- Production Reports -->
                            		<button id="production-report" href="#" role="button" class="btn btn-small btn-primary btn-block production-report"
                                            onclick="javascript:openProductionReport(<%=prodPublication.getPublishId() %>, false)">Reports</button>
                                 <%
                                    }
                         		 %>
                       			</td>
							</tr>                          
                      <%
                          }
                      %>
                    </tbody>
                  </table>
                </div>
           <%
            }
           %>
          </div>

<div id="createPublicationModal" style="display:none;">
   <form id="createDraftForm" name="createDraftForm" class="createDraftForm">
      <div class="modal-body">
        <p>You are about to create a publication for <strong><em>${currentBrand}</em></strong>.  Please complete the form below to begin this process:</p>
          <div class="control-group">
           
			<label title="Expected Publication Date" class="wrapper_label push_to_datepicker">
				<span class="wrapper_span">
					<em class="required">* </em>Expected Publication Date:
				</span> 			
				<div id="createDT" class="checknow_date">
                  <input class="input-small required" size="16" type="text" id="dateInput" name="dateInput" >
                </div>
			</label>
            <div class="clear"></div>
            <hr>
            <div class="clear"></div>
            <label title="Manual Type" class="wrapper_label" id="pub_content_type"> 
                <span class="wrapper_span"><em class="required">* </em>Manual Type:</span>
                <span id="content_err_span"></span>
            </label> 
            <div class="clear"></div>
            <fieldset>
            <label id="full-manual" title="Manual Type Full" class="wrapper_label">
                <span class="wrapper_span">Full:</span>             
                <div id="operate-type" name="operate-type" class="buld_operate_item">
                  <input class="fullType pull-right" type="checkbox" id="fullType" disabled="disabled" checked="checked" >
                </div>
            </label> 
            <div class="clear"></div>
            <label title="Manual Type Operate" class="wrapper_label">
                <span class="wrapper_span">Operate:</span>             
                <div id="operate-type" name="operate-type" class="buld_operate_item">
                  <input class="operateType pull-right" type="checkbox" id="operateType" name="buld_operate_item" required minlength="1">
                </div>
            </label> 
            <div class="clear"></div>
            <label title="Manual Type Build" class="wrapper_label">
                <span class="wrapper_span">Build, Convert & Renovate:</span>             
                <div id="build-type" name="build-type" class="buld_operate_item">
                  <input type="checkbox" id="buildType" name="buld_operate_item" class="buildType pull-right">
                </div>
            </label> 
            </fieldset>
          </div>
      </div>
      <div class="modal-footer">
        <button class="btn pull-left" id="closeCreateDraft" data-dismiss="modal" aria-hidden="true">Close</button>
        <button class="btn btn-danger pull-right" id="createPublication" title="Create" >Create</button>
      </div>
   </form>
 </div>
 
 <div id="updatePublicationModal" style="display:none;">
    <form class="updatePublishForm">
      <div class="modal-body">
        <p>You are about to update a publication for <strong><em>${currentBrand}</em></strong>.  Please complete the form below to begin this process:</p>
          <div class="control-group">
            <label title="Expected Production Publish Date" class="wrapper_label push_to_datepicker" id="aui_3_2_0_11313">
				<span class="wrapper_span" id="aui_3_2_0_11415">
					<em class="required">* </em>Expected Publication Date:
				</span> 			
				<div id="updateDT" class="checknow_date">
                  <input class="input-small" size="16" type="text" value="" id="updatePublicationDate">
                </div>
			</label> 
               <!--  <label class="wrapper_label" title="Expected Production Publish Date"><span class="wrapper_span"><em class="required">* </em>Expected Production Publish Date:</span>
			    	<input type="text" class="datepicker required" readonly="readonly" name="updatePublicationDate" id="updatePublicationDate" />
				</label> -->
          </div>
      </div>
      <div class="modal-footer">
        <button class="btn pull-left" data-dismiss="modal" aria-hidden="true" onclick="javascript:closeModal('updatePublicationModal')">Close</button>
        <button class="btn btn-danger pull-right"  onclick="javascript:updatePublication();">Update</button>
      </div>
    </form>
 </div>

 <div id="updateContentTypeModal" style="display:none;">
    <form id="updateContentTypeForm" name="updateContentTypeForm" class="updateContentTypeForm">
      <div class="modal-body">
        <p>You are about to update a publication for <strong><em>${currentBrand}</em></strong>.  Please complete the form below to begin this process:</p>
          <div class="control-group">
            <div class="clear"></div>
            <label title="Manual Type" class="wrapper_label" id="pub_content_type"> 
                <span class="wrapper_span"><em class="required">* </em>Manual Type:</span>
                <span id="content_upd_err_span"></span>
            </label> 
            <div class="clear"></div>
            <fieldset>
            <label id="full-manual-upd" title="Manual Type Full" class="wrapper_label">
                <span class="wrapper_span">Full:</span>             
                <div id="operate-type-div" class="buld_operate_item_upd">
                  <input class="fullType pull-right" type="checkbox" id="fullTypeUpd" disabled="disabled" checked="checked" >
                </div>
            </label> 
            <div class="clear"></div>
            <label title="Manual Type Operate" class="wrapper_label">
                <span class="wrapper_span">Operate:</span>             
                <div id="operate-type-div" class="buld_operate_item_upd">
                  <input class="operateType pull-right" type="checkbox" id="operateTypeUpd" name="buld_operate_item_upd" <%=contTypeOperate ? "checked='true'" : "" %> required minlength="1">
                </div>
            </label> 
            <div class="clear"></div>
            <label title="Manual Type Build" class="wrapper_label">
                <span class="wrapper_span">Build, Convert & Renovate:</span>             
                <div id="build-type-div" class="buld_operate_item_upd">
                  <input type="checkbox" id="buildTypeUpd" name="buld_operate_item_upd" class="buildType pull-right" <%=contTypeBuild ? "checked='true'" : "" %>>
                </div>
            </label> 
            </fieldset>
          </div>
      </div>
      <div class="modal-footer">
        <button class="btn pull-left" id="closeContTypeBtn" data-dismiss="modal" aria-hidden="true">Close</button>
        <button class="btn btn-danger pull-right" id="updateContTypeBtn" title="Update" >Update</button>
      </div>
    </form>
 </div>
  
 <div id="publishToStaging" class ="modal-small" style="display:none;">
 	<div class="modal-body">
      <div class="pull-left">
        <p>You are about to push to staging for <strong><em>${currentBrand}</em></strong>.  Please complete the form below to begin this process:</p>
        <form class="form-horizontal" id="stagingForm">
          <div class="control-group">
            <!-- <label class="control-label wrapper_label push_to_datepicker" for="chkNow">Schedule Push:</label>
            <div class="controls">
                <div>
                <input type="checkbox" id="checkNow_ps">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <div id="dp2_ps" class="checknow_date" style="display: none;">
                  <input class="input-small" size="16" type="text" value="" id="dateNow_ps">
                </div>&nbsp;&nbsp;&nbsp;&nbsp;
                	<input type="text" name="timeNow_ps" id="timeNow_ps" class="ui-timepicker-input input_small required" style="display: none; width:90px;"/>
              </div>
            </div> -->
          </div>
          <div class="control-group">
            <label class="control-label" for="inputEmail_ps">Notify via Email(Optional):</label>
            <div class="controls">
              <input class="input-xlarge" type="text" name="inputEmail_ps" id="inputEmail_ps"  placeholder="Enter email addresses" value="">
            </div>
          </div>
          <div class="control-group">
            <label class="control-label" for="inputDateTime_ps">Current Server Time:</label>
            <div class="controls">
              <input disabled class="input-medium" type="text" id="inputDateTime_ps" placeholder="<%= serverDateFormat.format(new Date())%>">
            </div>
          </div>
        </form>
      </div>
    </div>
    <div class="modal-footer">
      <button class="btn pull-left" data-dismiss="modal" aria-hidden="true" onclick="javascript:closeModal('publishToStaging')">Cancel</button>
      <button class="btn pull-right btn-danger" onclick="javascript:publishToStage();" id="publishToStagingBtn">Push</button>
    </div>
 </div>
 
 
 <div id="publishToProduction" class ="modal-small" style="display:none;">
 	<div class="modal-body">
      <div class="pull-left">
        <p>You are about to push to production for <strong><em>${currentBrand}</em></strong>.  Please complete the form below to begin this process:</p>
        <form class="form-horizontal" id="prodPublication" name="prodPublication">
          <div class="control-group">
            <label class="control-label" for="chkNow">Schedule Push:</label>
            <div class="controls">
                <div>
                <input type="checkbox" id="checkNow_pp">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <div id="dp2_pp" class="checknow_date" style="display: none;">
                  <input class="input-small" size="16" type="text" readOnly id="dateNow_pp">
                </div>&nbsp;&nbsp;&nbsp;&nbsp;
                	<input type="text" name="timeNow_pp" id="timeNow_pp" class="ui-timepicker-input input_small required" style="display: none; width:90px;" value='00:00'/>
              </div>
            </div>
          </div>
          <div class="control-group">
            <label class="control-label" for="inputEmail_pp">Notify via Email(Optional):</label>
            <div class="controls">
              <input class="input-xlarge" type="text" name="inputEmail_pp" id="inputEmail_pp"  placeholder="Enter email addresses" value="">
            </div>
          </div>
          <div class="control-group">
            <label class="control-label" for="inputDateTime_pp">Current Server Time:</label>
            <div class="controls">
              <input disabled class="input-medium" type="text" id="inputDateTime_pp" placeholder="<%= serverDateFormat.format(new Date())%>">
            </div>
          </div>
        </form>
      </div>
    </div>
    <div class="modal-footer">
      <button class="btn pull-left" data-dismiss="modal" aria-hidden="true" id="publishToProductionBtn" onclick="javascript:closeModal('publishToProduction')">Cancel</button>
      <button class="btn pull-right btn-danger" onclick="javascript:publishToProd();">Push</button>
    </div>
 </div>
 <div id="deletePublicationModal" class="modal-small" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="false" style="display: none;">
      <div class="modal-body">
        <div class="alert alert-danger" id="deleteMessage">Are you sure you want to remove this publication, regions may be working on it!!</div>
      </div>
      <div class="modal-footer">
        <button class="btn pull-left" data-dismiss="modal" aria-hidden="true" onclick="javascript:closeModal('deletePublicationModal')">No</button>
        <button class="btn btn-primary" data-dismiss="modal" aria-hidden="true" onclick="javascript:deletePublication()">Yes</button>
      </div>
  </div>
  <div id="generateManuals" class="modal-small" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="false" style="display: none;">
      <div class="modal-body">
        <div class="alert alert-danger" id="createManuals">Are you sure you want to regenerate all manuals?</div>
        <div >
        	<input type="checkbox" class="regionSelect" name="regionSelect" value="AMER" style="margin:0px 10px 5px 0px;">AMER <br/>
        	<input type="checkbox" class="regionSelect" name="regionSelect" value="AMEA" style="margin:0px 10px 5px 0px;">AMEA <br/>
        	<input type="checkbox" class="regionSelect" name="regionSelect" value="EURO" style="margin:0px 10px 5px 0px;">EURO <br/>
        	<input type="checkbox" class="regionSelect" name="regionSelect" value="GC" style="margin:0px 10px 5px 0px;"> GC
        </div>
      </div>
      <div class="modal-footer">
        <button class="btn pull-left" data-dismiss="modal" aria-hidden="true" onclick="javascript:closeModal('generateManuals')">No</button>
        <button class="btn btn-primary" data-dismiss="modal" aria-hidden="true" onclick="javascript:generateManuals()">Yes</button>
      </div>
 </div>	

<div id="createReportDialog" title="Create Report" style="display:none">
<form id="createReportForm" name="createReportForm" method="post" >
    <div class="modal-body">
        <div id="reportLst">
            <!-- <span><input type="radio" checked  style="margin-top: -3px;"/>Export Compliance Report</span> -->
        </div>
        <h4>Report Title <input type="text" id="reportTitle" name="reportTitle"/> </h4> 
      </div>
    <div class="modal-footer">
        <div class="pull-left"><button type="button" class="btn reportCancel">Cancel</button></div>
        <div class="pull-right"><a class="btn btn-primary" href="javascript:createReport()">Run</a></div>
    </div>
</form>
</div>
 
<%!
private static Log _log = LogFactoryUtil.getLog("BSBridge-portlet.docroot.html.managePublication.view.jsp");
%>