<%@include file="/../html/attribute/init.jsp"%>

<portlet:actionURL name="importSpreadsheet" var="importAttr" />
<portlet:actionURL name="updateAttribute" var="updateAttribute" />
<portlet:resourceURL  var="exportReport" />
<portlet:resourceURL  var="exportStandardDetails">
	<portlet:param name="passStdIds" value="passStdIds"/>
</portlet:resourceURL>

<link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/other/jquery-ui-1.10.1/themes/base/jquery-ui.css" />
<link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/attribute_update.css" />
<link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/msgBoxLight.css" />

<div class="grid_12">
	<div class="rounded_container">
        <div class="rounded_container_contents">
            <h4 class="short_page_subtitle">Attribute</h4>
			<div class="report_container">
				<c:if test='${not empty region}'>
					<div class="button report_run_btn">
						<a href="#" class="results_filter export_attribute_link" title="Create Export Attribute Report">Create Export Attribute Report</a>
						<span></span>
					</div>  
					<div class="button report_run_btn">
						<a href="#" class="results_filter create_new_att_link" title="Create New Attribute Update Request">Create New Attribute Update Request</a>
						<span></span>
					</div>	
				</c:if>
			</div>
            <div class="clear"></div>
            <div class="divider">&nbsp;</div>
            <div class="clear"></div>
			<table class="results_table">
            	<tr class="results_header_bar">
                	<td width="350"><strong>Title</strong></td>
                    <td class=""><strong>Status</strong></td>
					<td>Created By</td>
					<td width="100">Created Date</td>
					<td>Email</td>
                    <td width="140"><strong>Actions</strong></td>
                </tr>
				<c:forEach var="attributeRequest" items="${requestObjects}" varStatus="status">
                <c:if test='${(attributeRequest.status ne "Processed") and (not empty region) and
				 ((region eq attributeRequest.userRegion)  or (region eq "ADMIN"))}'>
	                <tr>
	                	<td>${attributeRequest.requestTitle}</td>
						<input type="hidden" value="${attributeRequest.requestTitle}" id="request_${status.index}_${attributeRequest.requestId}"/>
						<input type="hidden" value="${attributeRequest.requestId}" id="id_${status.index}_${attributeRequest.requestId}"/>
	                    <td>${attributeRequest.status}</td>
						<td>${attributeRequest.userName}</td>
						<td><fmt:formatDate pattern="yyyy-MM-dd" value="${attributeRequest.createdDate}" /></td>
						<td>${attributeRequest.emailAddress}</td>
						<td>
							<c:if test='${attributeRequest.status ne "In Progress" }'>
								<c:if test='${attributeRequest.status ne "Ready for Update" &&  attributeRequest.status ne "Processed"
								 && attributeAdmin ne true}'>
									<portlet:renderURL var="approveAttributeRequest">
										<portlet:param name="approveRequest" value="approveRequest"></portlet:param>
										<portlet:param name="requestId" value="${attributeRequest.requestId}"></portlet:param>
									</portlet:renderURL>
									<a alt="Approve Request" title="Approve Request" href="#" class="approve_link" 
									id="approve_${status.index}_${attributeRequest.requestId}" onclick = "javascript:approveRequest('${approveAttributeRequest}',
									'Are you sure you want to approve this request?')">
										<img alt="Approve Request" title="Approve Request" src="/BSTheme-theme/images/approve_update.jpg" />
									</a>
								</c:if>
								<c:if test='${attributeRequest.status ne "Processed"}'>
									<portlet:resourceURL var="diffReport">
										<portlet:param name="diffReport" value="diffReport"></portlet:param>
										<portlet:param name="attrId" value="${attributeRequest.requestId}"></portlet:param>
									</portlet:resourceURL>
									<a alt="Create Diff Report" title="Create Diff Report" href="#" class="create_diff_link" onclick = "javascript:createDiffReport('${diffReport}',
									'Are you sure you want to create a diff report?')" >
										<img alt="Create Diff Report" title="Create Diff Report" src="/BSTheme-theme/images/create_diff.jpg" />
									</a>
								</c:if>
								<c:if test='${attributeRequest.status ne "Processed" && attributeAdmin ne true}'>
								<portlet:renderURL var="rejectAttributeRequest">
									<portlet:param name="rejectRequest" value="rejectRequest"></portlet:param>
									<portlet:param name="requestId" value="${attributeRequest.requestId}"></portlet:param>
								</portlet:renderURL>
								<a alt="Cancel Approval" title="Cancel Approval" href="#" class="cancel_link"  onclick = "javascript:approveRequest('${rejectAttributeRequest}',
								'Are you sure you want to reject this request?')" id="cancel_${status.index}_${attributeRequest.requestId}">
									<img alt="Cancel Approval" title="Cancel Approval" src="/BSTheme-theme/images/cancel_approve.jpg" />
								</a>
								</c:if>
								<c:if test='${(attributeRequest.status ne "Processed" && attributeRequest.status ne "Ready for Update") ||
								 attributeAdmin eq true }'>
									<a alt="Edit" title="Edit" href="javascript: void(0)" class="edit_link" id="${status.index}_${attributeRequest.requestId}">
										<img alt="Edit" title="Edit" src="/BSTheme-theme/images/edit_pencil_icon.png" />
									</a>
								</c:if>
								
								<portlet:renderURL var="executeUpdateAttributeRequest">
									<portlet:param name="executeUpdateAttributeRequest" value="executeUpdateAttributeRequest"></portlet:param>
									<portlet:param name="requestId" value="${attributeRequest.requestId}"></portlet:param>
								</portlet:renderURL>
								<c:set var="statusvalue" value="Ready for Update"></c:set>
								<c:if test="${attributeRequest.status eq  statusvalue || attributeAdmin eq true}">
									<a alt="Execute Update" title="Execute Update" href="#" class="delete_link" id="update_${status.index}_${attributeRequest.requestId}"
								 onclick = "javascript:approveRequest('${executeUpdateAttributeRequest}','Are you sure you want to update this request?')">
									<img alt="Execute Update" title="Execute Update" src="/BSTheme-theme/images/exe_update.jpg" />
								</a>
								</c:if>
								<c:if test='${attributeRequest.status ne "Processed"}'>
									<portlet:renderURL var="deleteAttributeRequest">
										<portlet:param name="deleteRequest" value="deleteRequest"></portlet:param>
										<portlet:param name="requestId" value="${attributeRequest.requestId}"></portlet:param>
									</portlet:renderURL>
									<a alt="Delete" title="Delete" href="#" class="delete_link" id="delete_${status.index}_${attributeRequest.requestId}"
									 onclick = "javascript:approveRequest('${deleteAttributeRequest}','Are you sure you want to delete this request?')">
										<img alt="Delete" title="Delete" src="/BSTheme-theme/images/delete_attribute_request.jpg" />
									</a>
								</c:if>
							</c:if>
						</td>
	                </tr>
               	</c:if>
         		</c:forEach>
			</table>
		</div>
	</div><!--ends rounded_container -->
	<div class="rounded_container_bottom">&nbsp;</div>
</div><!--ends grid_9 -->
	
<div id="create_new_attribute" title="Create New Attribute" class="dialog">
	<form method="post" action="${importAttr}"  id="importAttr" enctype="multipart/form-data">
		<label class="wrapper_label"><span class="wrapper_span"><em class="required">* </em>Title:</span>              
			<input type="text" class="input_text required" name="requestTitle" id="requestTitle" style="width: 481px;"/>            
		</label>
		<label class="wrapper_label"><span class="wrapper_span"><em class="required">* </em>File to Upload:</span>            
			<input type="file" class="input_text required" name="uploadFile" id="uploadFile" value="" style="width: 481px;"/>       
		</label>
		<input type="submit" class="att_submit" value="save" name="save"/>
		<input type="button" class="att_cancel" value="cancel" name="cancel" />
	</form>
</div>

<div id="export_attribute" title="Attribute Report" class="dialog">
	<p>Please provide standard Ids to get attribute report</p>
	<label class="wrapper_label"><span class="wrapper_span">Standard Ids:</span>              
		 <textarea style="width: 214px;" name='stdIds' id='stdIds'></textarea>           
	</label>
	<label class="wrapper_label"><span class="wrapper_span">Select Template</span>            
		<select id="standard_brand" class="required" name="standard_brand"> 
        	<option value="OBSM attributes">OBSM attributes</option>
        	<option value="Quality attributes">Quality attributes</option>
        	<option value="OBSM & Quality attributes">OBSM &amp; Quality attributes</option>
			<!--CR70.2 : Hotel Lifecycle attributes entry added--> 
			<option value="Hotel Lifecycle attributes">Hotel Lifecycle attributes</option>
            <!-- <option value="Build">Build</option>  -->
     	</select>     
	</label>
	<label class="wrapper_label"><span class="wrapper_span">Select Region</span>            
		<select id="standard_region" class="required" name="standard_region"> 
		    <option value="GLBL">Global</option>
		    <option value="AMEA">AMEA</option>
		    <option value="AMER">AMER</option>
		   	<option value="EURO">EURO</option>
		   	<option value="GC">GC</option>
		</select>     
	</label>
</div>
	
<div id="attribute_edit" title="Edit Attribute" class="dialog">
	<form method="post" action="${updateAttribute}"  id="updateAttribute" enctype="multipart/form-data">
		<label class="wrapper_label"><span class="wrapper_span"><em class="required">* </em>Title:</span>              
			<input type="text" class="input_text required" name="standard_name" id="standard_name" value="" style="width: 481px;"/>  
			<input type="hidden" name="attr_id" id="attr_id" value="" style="width: 481px;"/>  				 
		</label>
		<label class="wrapper_label"><span class="wrapper_span">File to Upload:</span>            
			<input type="file" class="input_text" name="standard_file" id="standard_file" value="" style="width: 481px;"/>       
		</label>
        <input type="submit" class="att_submit" value="save" name="save" />
        <input type="button" class="att_cancel" value="cancel" name="cancel" />
	</form>
</div>
<script src="/BSTheme-theme/js/jqGrid/jquery.js" type="text/javascript"></script>
<script type="text/javascript" src="/BSTheme-theme/js/jqGrid/jquery-ui-custom.min.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/treeAdmin/jquery.msgBox.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/treeAdmin/jquery.blockUI.js"></script>
<script type="text/javascript">
	var exportURL = '${exportStandardDetails}';
	var exportReport = '${exportReport}';
	var requestProcessed = '${requestProcessed}';
	var wrongExcelsheet = '${wrongExcelsheet}';
	var deleteError = '${deleteError}';
	var approveError = '${approveError}';
	var rejectError = '${rejectError}';
	var processError = '${processError}';
	var standardNotExistMsg = '${standardNotExistMsg}';
	var noAccessMsg =  '${noAccess}';
	var inProgressMsg = '${inProgressMsg}';
	var largeRequest = '${largeRequest}';
	var reportInProgress = '${reportInProgress}';
</script>
<script type="text/javascript" src="/BSTheme-theme/js/jquery.validate.js"></script>
<script src="/BSTheme-theme/js/additional-methods.1.11.1.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/attribute_update.js"></script>
		