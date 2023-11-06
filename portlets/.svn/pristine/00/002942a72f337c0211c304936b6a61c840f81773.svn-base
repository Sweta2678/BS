<%@page import="com.ihg.brandstandards.db.model.Publication"%>
<%@page import="com.ihg.brandstandards.gem.util.GemConstants"%>
<%@page import="com.ihg.brandstandards.util.BrandStandardsUtil"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.ihg.brandstandards.db.model.GEMTemplate"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.ihg.brandstandards.bridge.util.BridgeConstants"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@include file="/html/init.jsp"%>

<portlet:resourceURL id='uploadTemplateURL' var="uploadTemplateURL">
    <portlet:param name="requestType" value="uploadTemplate" />
</portlet:resourceURL>
<portlet:resourceURL id='generateGEMReportURL' var="generateGEMReportURL">
    <portlet:param name="requestType" value="generateGEMReport" />
</portlet:resourceURL>
<portlet:resourceURL id='openCreatePublicationModel' var="openCreatePublicationModel">
    <portlet:param name="requestType" value="openCreatePublication" />
</portlet:resourceURL>
<portlet:resourceURL var="createPublicationURL" id="createPublicationURL">
	<portlet:param name="requestType" value="createPublication" />
</portlet:resourceURL>
<portlet:resourceURL var="updateManualTypeURL" id="updateManualTypeURL">
	<portlet:param name="requestType" value="updateManualType" />
	<portlet:param name="cmd" value="update" />
</portlet:resourceURL>

<% 
	SimpleDateFormat publish_formatter = new SimpleDateFormat(BridgeConstants.DEFAULT_DATE_FORMAT);
%>
<script type="text/javascript">
	var createPublicationURL = '${createPublicationURL}'; 
	var updateManualTypeURL = '${updateManualTypeURL}';
	var openCreatePublicationModel = '${openCreatePublicationModel}';
	//var generateGEMReportURL = '${generateGEMReportURL}';
</script>
<link type="text/css" rel="stylesheet" href="/BSBridge-theme/css/jquery.timepicker.css" />
<link type="text/css" rel="stylesheet" href="/BSBridge-theme/css/msgBoxLight.css" />
<script type="text/javascript" src="/BSBridge-theme/js/jquery.validate.min-1.11.1.js"></script>
<script type="text/javascript" src="/BSBridge-theme/js/additional-methods.min-1.11.1.js"></script>
<script type="text/javascript" src="/BSBridge-theme/js/jquery.form.3.28.0.js"></script>
<script type="text/javascript" src="/BSBridge-theme/js/treeAdmin/jquery.blockUI.js"></script>
<script type="text/javascript" src="/BSBridge-theme/js/treeAdmin/jquery.msgBox.js"></script>
<script type="text/javascript" src="/BSBridge-theme/js/jquery.timepicker.min.js"></script>
<script type="text/javascript" src="/BSBridge-portlet/js/manageGEM.js"></script>
<style type="text/css">
	.aui em.required {
		color: #F00;
	}
</style>

<div class="row">
	<div class="span12">
		<div class="row">
			<div class="span6"><h3 class="progress-title">Manage Quality Center</h3></div>
         	<div class="span6">
          		<div class="pull-right">
         			<a id = "createPublicationRec" href="javascript:openCreatePublicationDialog();" role="button" class="btn btn-danger" data-toggle="modal">Create Publication</a>&nbsp;
         		</div>&nbsp;
				<c:if test="${activePublish}">
					<div class="pull-right alert alert-success publish_alert">${bridgePublishDate} Bridge Publication</div>
				</c:if>
			</div>
		</div>
	</div>
</div>

<c:choose>
	<c:when test="${activePublish}">
		<div class="row">
			<div class="span12">
		    	<p>The functions contained here help guide you through the process of Standards Measurement of published content for <u><strong>${currentBrand}</strong></u>.  You may be emailed on completion of long-running actions.</p>
			</div>
		</div>
	</c:when>
	<c:otherwise>
		Please create new measurement publication.
	</c:otherwise>
</c:choose>
<c:if test="${activePublish}">

<c:if test="${isGlobalMustNotSelectedForMeasurement}">
	<div class="row">
		<div class="span12">
			<p><span style="color:orange">Note: There are Global Must Standards which are not selected for measurement.</span></p>
		</div>
	</div>
</c:if>

<div class="accordion" id="Manageaccordion">
	<!--  ################## Manual Type Accordian  ##################-->
	<h3 class="">Current GEM Publication</h3>
	<div class="accordian-inner">
		<c:if test="${gemPublishId ne null}">
			<input type="hidden" name="gemPublishId" id="gemPublishId" value="${gemPublishId}"/>
			<input type="hidden" name="bridgePublishId" id="bridgePublishId" value="${bridgePublishId}"/>
			<div class="pull-right">
				<a id="edit_manual_link" href="#" class="btn btn-small btn-primary btn-block" >Edit Manual Type</a>
			</div>
			<div class="clear"></div>
		</c:if>
		<table class="table table-bordered">
		<thead>
			<tr>
				<th>GEM Publish Id</th>
				<th>Bridge Publish Id</th>
				<th>Department Id</th>
				<th>SA</th>
				<th>SE</th>
				<th>Waiver</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${gemPublishId}</td>
				<td>${bridgePublishId}</td>
				<td>${gemDeptId}</td>
				<c:choose>
					<c:when test="${manualTypes ne null}">
						<c:forEach var="manualType" items="${manualTypes}">
							<td>
							<c:choose>
								<c:when test="${'FULL_BUILD_OPERATE' eq manualType.value.parmValue}">
									BUILD & OPERATE
								</c:when>
								<c:otherwise>
									${manualType.value.parmValue}
								</c:otherwise>
							</c:choose>
							</td>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<td></td>
						<td></td>
						<td></td>
					</c:otherwise>
				</c:choose>
			</tr>
		</tbody>
		</table>
	</div>
	
	<!--  ################## Templates Accordian  ##################-->
	<h3 class="">Templates</h3>  
	<div class="accordion-inner">
		<div class="pull-right"> 
			<a id="upload_template_link" href="#" class="btn btn-small btn-primary btn-block" >Upload Template</a>
		</div>
		<div class="clear"></div>
		<table class="table table-bordered">
		<thead><tr><th>Template Id</th><th>Description</th><th>Template Type</th><th>GEM Publish Id</th><th>Region</th><th>Last Updated By</th><th>Last Updated Date</th></tr></thead>
		<tbody>
		<c:forEach var="gemTemplate" items="${gemTemplates}">
			<% 
				GEMTemplate gemTemplate = (GEMTemplate)pageContext.getAttribute("gemTemplate");
          	  	String fullName = "";
          	  	String regionCode = "";
          	  	if (Validator.isNotNull(gemTemplate.getCreatorId())) {
          	    	try {
          	    		User creator = UserLocalServiceUtil.getUser(GetterUtil.getLong(gemTemplate.getCreatorId()));
          	        	fullName = creator.getFullName();
          	        	regionCode = BrandStandardsUtil.getRegionCode(gemTemplate.getRegionId());
          	    	} catch (Exception e) {
          	    	    _log.error(e.getMessage());
          	    	}
          	    }
          	  	if(gemTemplate.getTemplateType().equals(GemConstants.TEMPLATE_TYPE_SA)){
          	  		pageContext.setAttribute("saTemplateId", gemTemplate.getTemplateId());
          	  	} else if(gemTemplate.getTemplateType().equals(GemConstants.TEMPLATE_TYPE_SE)){
          	  		pageContext.setAttribute("seTemplateId", gemTemplate.getTemplateId());
          	  	} else if(gemTemplate.getTemplateType().equals(GemConstants.TEMPLATE_TYPE_WAIVER)){
          	  		pageContext.setAttribute("waiverTemplateId", gemTemplate.getTemplateId());
          	  	}
			%>
			<tr>
				<td>${gemTemplate.templateId}</td>
				<td>${gemTemplate.templateName}</td>
				<c:choose>
					<c:when test="${gemTemplate.templateType eq 'WR'}">
						<td>${gemWaiverTemplateLabel}</td>
					</c:when>
					<c:otherwise>
						<td>${gemTemplate.templateType}</td>
					</c:otherwise>
				</c:choose>
				
				<td>${gemTemplate.publishId}</td>
				<td><%=regionCode%></td>
				<td><%=fullName%></td>
				<td><span id="dateText"><%=publish_formatter.format(gemTemplate.getCreatedDate())%></span></td>
				<%-- <td>
					<c:choose>
						<c:when test="${gemTemplate.templateType eq 'SA'}">
							<a id="generateSAReport" class="btn btn-small btn-primary" href="javascript:generateGEMReport('${gemTemplate.templateId}', 'SA')">Generate SA</a>
						</c:when>
						<c:when test="${gemTemplate.templateType eq 'SE'}">
							<a id="generateSEReport" class="btn btn-small btn-primary" href="javascript:generateGEMReport('${gemTemplate.templateId}', 'SE')">Generate SE</a>
						</c:when>
						<c:when test="${gemTemplate.templateType eq 'WR'}">
							<a id="generateWRReport" class="btn btn-small btn-primary" href="javascript:generateGEMReport('${gemTemplate.templateId}', 'WR')">Generate Waiver</a>
						</c:when>
					</c:choose>
				</td> --%>
			</tr>
		</c:forEach>
		</tbody>
     	</table>
	</div>
	
	<!--  ################## Self Audit Accordian  ##################-->
	<h3 class="">Self Audit</h3>
	<div class="accordion-inner">
		<div class="pull-right"> 
			<c:if test="${saTemplateId gt 0}"><a id="generateSAReport" class="btn btn-small btn-primary" href="javascript:openGEMReportDialog('${saTemplateId}', 'SA')">Generate SA</a></c:if>
		</div>
		<div class="clear"></div>
		<%-- <table class="table table-bordered">
		<thead><tr><th>Template Id</th><th>Description</th><th>Template Type</th><th>Region</th><th>Last Updated By</th><th>Last Updated Date</th></tr></thead>
		<tbody>
		<c:forEach var="gemTemplate" items="${gemSATemplates}">
			<% 
				GEMTemplate gemTemplate = (GEMTemplate)pageContext.getAttribute("gemTemplate");
				String fullName = "";
				String regionCode = "";
	      	    if (Validator.isNotNull(gemTemplate.getCreatorId())) {
	      	    	try {
	      	    		User creator = UserLocalServiceUtil.getUser(GetterUtil.getLong(gemTemplate.getCreatorId()));
	      	        	fullName = creator.getFullName();
	      	        	regionCode = BrandStandardsUtil.getRegionCode(gemTemplate.getRegionId());
	      	    	} catch (Exception e) {
	      	    	    _log.error(e.getMessage());
	      	    	}
	      	    	
	      	    }
			%>
			<tr>
				<td>${gemTemplate.templateId}</td>
				<td>${gemTemplate.templateName}</td>
				<td>${gemTemplate.templateType}</td>
				<td><%=regionCode%></td>
				<td><%=fullName%></td>
				<td><span id="dateText"><%=publish_formatter.format(gemTemplate.getCreatedDate())%></span></td>
			</tr>
		</c:forEach>
		</tbody>
     	</table> --%>
	</div>
	
	<!--  ################## Standards Evaluation Accordian  ##################-->
	<h3 class="">Standards Evaluation</h3>
	<div class="accordion-inner">
		<div class="pull-right"> 
			<c:if test="${seTemplateId gt 0}"><a id="generateSEReport" class="btn btn-small btn-primary" href="javascript:openGEMReportDialog('${seTemplateId}', 'SE')">Generate SE</a></c:if>
		</div>
		<div class="clear"></div>
		<%-- <table class="table table-bordered">
		<thead><tr><th>Template Id</th><th>Description</th><th>Template Type</th><th>Region</th><th>Last Updated By</th><th>Last Updated Date</th></tr></thead>
		<tbody>
		<c:forEach var="gemTemplate" items="${gemSETemplates}">
			<% 
				GEMTemplate gemTemplate = (GEMTemplate)pageContext.getAttribute("gemTemplate");
				String fullName = "";
				String regionCode = "";
	      	    if (Validator.isNotNull(gemTemplate.getCreatorId())) {
	      	    	try {
	      	    		User creator = UserLocalServiceUtil.getUser(GetterUtil.getLong(gemTemplate.getCreatorId()));
	      	        	fullName = creator.getFullName();
	      	        	regionCode = BrandStandardsUtil.getRegionCode(gemTemplate.getRegionId());
	      	    	} catch (Exception e) {
	      	    	    _log.error(e.getMessage());
	      	    	}
	      	    	
	      	    }
			%>
			<tr>
				<td>${gemTemplate.templateId}</td>
				<td>${gemTemplate.templateName}</td>
				<td>${gemTemplate.templateType}</td>
				<td><%=regionCode%></td>
				<td><%=fullName%></td>
				<td><span id="dateText"><%=publish_formatter.format(gemTemplate.getCreatedDate())%></span></td>
			</tr>
		</c:forEach>
		</tbody>
     	</table> --%>
	</div>
	
	<!--  ################## Waiver Accordian  ##################-->
	<h3 class="">Waiver</h3>
	<div class="accordion-inner">
		<div class="pull-right"> 
			<c:if test="${waiverTemplateId gt 0}"><a id="generateWRReport" class="btn btn-small btn-primary" href="javascript:openGEMReportDialog('${waiverTemplateId}', 'WR')">Generate Waiver</a></c:if>
		</div>
		<div class="clear"></div>
		<%-- <table class="table table-bordered">
		<thead><tr><th>Template Id</th><th>Description</th><th>Template Type</th><th>Region</th><th>Last Updated By</th><th>Last Updated Date</th></tr></thead>
		<tbody>
		<c:forEach var="gemTemplate" items="${gemWaiverTemplates}">
			<% 
				GEMTemplate gemTemplate = (GEMTemplate)pageContext.getAttribute("gemTemplate");
				String fullName = "";
				String regionCode = "";
	      	    if (Validator.isNotNull(gemTemplate.getCreatorId())) {
	      	    	try {
	      	    		User creator = UserLocalServiceUtil.getUser(GetterUtil.getLong(gemTemplate.getCreatorId()));
	      	        	fullName = creator.getFullName();
	      	        	regionCode = BrandStandardsUtil.getRegionCode(gemTemplate.getRegionId());
	      	    	} catch (Exception e) {
	      	    	    _log.error(e.getMessage());
	      	    	}
	      	    	
	      	    }
			%>
			<tr>
				<td>${gemTemplate.templateId}</td>
				<td>${gemTemplate.templateName}</td>
				<td>${gemWaiverTemplateLabel}</td>
				<td><%=regionCode%></td>
				<td><%=fullName%></td>
				<td><span id="dateText"><%=publish_formatter.format(gemTemplate.getCreatedDate())%></span></td>
			</tr>
		</c:forEach>
		</tbody>
     	</table> --%>
	</div>
	<!--  ################## Policy Report Accordian  ##################-->
	<h3 class="">Policy Report</h3>
	<div class="accordion-inner">
		<div class="pull-right"> 
			<c:if test="${seTemplateId gt 0}"><a id="generatePlocyReport" class="btn btn-small btn-primary" href="javascript:openGEMReportDialog('${seTemplateId}', 'Policy')">Generate Policy Report</a></c:if>
		</div>
		<div class="clear"></div>
	</div>
</div>

<div id="upload_new_template" title="Upload Template" class="dialog" style="display:none;">
	<form method="post" action="${uploadTemplateURL}" id="uploadTemplate" name="uploadTemplate" enctype="multipart/form-data">
		<div class="modal-body">
	        <p>You are about to upload a template for <strong><em>${currentBrand}</em></strong>.  Please complete the form below to begin this process:</p>
	          <div class="control-group">
				<label title="Expected Publication Date" class="wrapper_label">
					<span class="wrapper_span">
						<em class="required">* </em>Select Type:
					</span> 			
					<div id="templateType">
	                 	 <select id="template_type" class="required" name="template_type"> 
			    			<option value="<%=GemConstants.TEMPLATE_TYPE_SA%>">SA Template</option>
			    			<option value="<%=GemConstants.TEMPLATE_TYPE_SE%>">SE Template</option>
			    			<option value="<%=GemConstants.TEMPLATE_TYPE_WAIVER%>">Waiver Template</option>
						</select>
	                </div>
				</label>
	            <hr>
	            <div class="clear"></div>
	            <label title="Manual Type" class="wrapper_label"> 
	                <span class="wrapper_span"><em class="required">* </em>Template to Upload:</span>
	                <span id="content_err_span"></span>
	                <div id="templateFile">
	                	<input type="file" class="input_text required" name="uploadFile" id="uploadFile"/>
	                </div>
	            </label> 
	            <div class="clear"></div>
	          </div>
	      </div>
	      <div class="modal-footer">
	    	<input type="button" class="btn pull-left  att_cancel" value="Cancel" name="Cancel" />
	        <input type="submit" class="btn btn-danger pull-right att_submit" value="Upload" name="Upload"/>
	      </div>
     </form>
</div>

<div id="createReportDialog" title="Create Report" style="display:none">
	<form id="createReportForm" name="createReportForm" method="post" >
	    <div class="modal-body">
	    	<input type="hidden" id="reportType" name="reportType" />
	    	<input type="hidden" id="templateId" name="templateId" />
	        <h4>Report Title <input type="text" id="reportTitle" name="reportTitle" /></h4> 
	      </div>
	    <div class="modal-footer">
	        <div class="pull-left"><button type="button" class="btn reportCancel">Cancel</button></div>
	        <div class="pull-right"><a class="btn btn-primary" href="javascript:generateGEMReport('${generateGEMReportURL}')">Run</a></div>
	    </div>
	</form>
</div>

</c:if>

<div id="createPublicationModal" style="display:none;"></div>
<%! private static Log _log = LogFactoryUtil.getLog("BSBridge-portlet.docroot.html.GEM.manage.view.jsp"); %>