<%@page import="com.ihg.brandstandards.bridge.util.BridgeConstants"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.ihg.brandstandards.db.model.Publication"%>
<%@include file="/html/init.jsp"%>
<script type="text/javascript" src="/BSBridge-portlet/js/manageGEM.js"></script>
<% 
	SimpleDateFormat publish_formatter = new SimpleDateFormat(BridgeConstants.DEFAULT_DATE_FORMAT);
%>
<form id="createDraftForm" name="createDraftForm" class="createDraftForm">
	<input type="hidden" name="cmd" id="cmd" value="${cmd}"/>
	<input type="hidden" name="oldGemSEManualType" id="oldGemSEManualType" value="${gemSEManualType}"/>
	<input type="hidden" name="oldGemSAManualType" id="oldGemSAManualType" value="${gemSAManualType}"/>
	<input type="hidden" name="oldGemWaiverManualType" id="oldGemWaiverManualType" value="${gemWaiverManualType}"/>
	<div class="modal-body">
		<c:choose>
			<c:when test="${cmd eq 'update'}">
				<p>You are about to update manual types of current measurement publication for <strong><em>${currentBrand}</em></strong>.</p>
			</c:when>
			<c:otherwise>
				<p>You are about to create a measurement publication for <strong><em>${currentBrand}</em></strong>.  Please complete the form below to begin this process:</p>
			</c:otherwise>
		</c:choose>
		<p><strong>Publication</strong></p>
        <div class="control-group">
        	<label class="control-label" title="Publication Type"><em class="required">* </em>Publication Environment:</label>
			<div class="controls">
				<select id="gemPublicationEnv" name="gemPublicationEnv" title="Publication Environment" <c:if test="${cmd eq 'update'}">disabled</c:if>>
					<option value="GEM_CMS">BRIDGE</option>
					<!-- <option value="GEM_OBSM">OBSM</option> -->
				</select>
			</div>
			
			<label class="control-label" title="Bridge Publication:"><em class="required">* </em>Bridge Publication:</label>
			<div class="controls">
				<select id="gemBridgePublicationId" name="gemBridgePublicationId" title="Bridge Publication" <c:if test="${cmd eq 'update'}">disabled</c:if>>
					<option value="">Please Select Bridge Publication</option>
					<c:forEach var="publish" items="${bridgePublishList}">
						<% Publication publish = (Publication)pageContext.getAttribute("publish"); %>
						<option value="${publish.publishId}" <c:if test="${bridgePublishId eq publish.publishId}">selected</c:if>><%=publish_formatter.format(publish.getPublishDate())%></option>
					</c:forEach>
				</select>
			</div>
		</div>
		<p><strong>Manual Type</strong></p>
		<div class="control-group">	
			<label class="control-label" title="SE Manual Type:"><em class="required">* </em>SE:</label>
			<div class="controls">
				<select id="gemSEManualType" name="gemSEManualType" title="SE Manual Type" >
					<option value="full_build_operate" <c:if test="${gemSEManualType eq 'full_build_operate'}">selected</c:if>>Build & Operate</option>
					<option value="build" <c:if test="${gemSEManualType eq 'build'}">selected</c:if>>Build</option>
					<option value="operate" <c:if test="${gemSEManualType eq 'operate'}">selected</c:if>>Operate</option>
				</select>
			</div>
			
			<label class="control-label" title="SA Manual Type:"><em class="required">* </em>SA:</label>
			<div class="controls">
				<select id="gemSAManualType" name="gemSAManualType" title="SA Manual Type" >
					<option value="">Please Select Manual Type</option>
					<option value="full_build_operate" <c:if test="${gemSAManualType eq 'full_build_operate'}">selected</c:if>>Build & Operate</option>
					<option value="build" <c:if test="${gemSAManualType eq 'build'}">selected</c:if>>Build</option>
					<option value="operate" <c:if test="${gemSAManualType eq 'operate'}">selected</c:if>>Operate</option>
				</select>
			</div>
			
			<label class="control-label" title="Waiver Manual Type:"><em class="required">* </em>Waiver:</label>
			<div class="controls">
				<select id="gemWaiverManualType" name="gemWaiverManualType" title="Waiver Manual Type" >
					<option value="">Please Select Manual Type</option>
					<option value="full_build_operate" <c:if test="${gemWaiverManualType eq 'full_build_operate'}">selected</c:if>>Build & Operate</option>
					<option value="build" <c:if test="${gemWaiverManualType eq 'build'}">selected</c:if>>Build</option>
					<option value="operate" <c:if test="${gemWaiverManualType eq 'operate'}">selected</c:if>>Operate</option>
				</select>
			</div>
			
			<%-- <label class="control-label" title="OBSM Publication"><em class="required">* </em>OBSM Publication:</label>
			<div class="controls">
				<select id="gemOBSMPublicationId" name="gemOBSMPublicationId" title="OBSM Publication" >
					<option value="">Please Select Bridge Publication</option>
					<c:forEach var="publish" items="${bridgePublishList}">
						<% Publication publish = (Publication)pageContext.getAttribute("publish"); %>
						<option value="${publish.publishId}"><%=publish_formatter.format(publish.getPublishDate())%></option>
					</c:forEach>
				</select>
			</div> --%>
		</div>
	</div>
	<div class="modal-footer">
		<a class="btn pull-left" id="closeCreateDraft" data-dismiss="modal" aria-hidden="true">Close</a>
        <!-- <button class="btn btn-danger pull-right" id="createGemPublication" title="Create">Create</button> -->
        <c:choose>
	        <c:when test="${cmd eq 'update'}">
	        	<a class="btn btn-danger pull-right manageGemPublication" id="createGemPublication" title="Update">Update</a>
	        </c:when>
	        <c:otherwise>
	        	<a class="btn btn-danger pull-right manageGemPublication" id="updateGemPublication" title="Create">Create</a>
	        </c:otherwise>
	   	</c:choose>
	</div>
   	</form>