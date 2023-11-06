<%@include file="/html/init.jsp"%>
<portlet:actionURL var="saveManageIdAction" name="saveManageIdAction" />
<form name="editManageIdFM" method="post" action="<%=saveManageIdAction%>">
<div id="EditManageIdModal" title="Edit Management Id">
	<div style="max-height:400px; overflow-y:auto;">
		<div class="clear"></div>
		<div class="form-horizontal">
			<div class="control-group">
				<label class="control-label" title="Country Code">Country Code</label>
				<div class="controls">
					<label class="control-label" title="Country Code" style="text-align:left"><c:out value="${country}" /> </label>
				</div>
			</div>
			<input type="hidden" name="manageIdValues" id="manageIdValues" value="">
			<input type="hidden" name="countryCode" id="countryCode" value="${country}">
			<input type="hidden" name="brandCode" id="brandCode" value="${brand}">
			<div class="control-group">
				<label class="control-label" title="Brand">Brand </label>
				<div class="controls">
					<label class="control-label" title="Brand" style="text-align:left"><c:out value="${brandName}" /> </label>
				</div>
			</div>
			<c:forEach var="brandManageId" items="${managementIds}">
				<div class="control-group">
					<label class="control-label" title="${brandManageId.key}"><c:out value="${brandManageId.key}" /></label>
					<div class="controls">
						<c:set var="manageId" value="${brandManageId.value}" > </c:set>
						<c:if test="${manageId != null}">
							<input type="text" id="${manageId.managementId}" name="${manageId.chainCode}" maxlength="200" class="input_text required" value="${manageId.value}">
           				</c:if>
           				<c:if test="${manageId == null}">
							<input type="text" id="-1" name="${brandManageId.key}" maxlength="200" class="input_text required" value="">
           				</c:if>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
	<div class="modal-footer aui-panel-ft">
		<input class="btn pull-left" type="submit" title="Save"	value="Save">
		<input class="btn pull-right editManageIdPopupClose" type="button" title="Cancel" value="Cancel" onclick="editManageIdDialog.dialog('close');">
	</div>
</div>
</form>
