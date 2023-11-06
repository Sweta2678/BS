<%@include file="/html/uielement/init.jsp"%>
<%
  String exportElemProgressId = PwdGenerator.getPassword(PwdGenerator.KEY3, 4);
%>
<portlet:resourceURL var="exportElements">
	<portlet:param name="modalType" value="exportElementsToXLS" />
	<portlet:param name="exportProgressId" value="<%=exportElemProgressId%>"></portlet:param>
</portlet:resourceURL>
<portlet:renderURL var="cancel" />

<liferay-ui:upload-progress
    id="<%=exportElemProgressId%>"
    message="Exporting"
    redirect="#"
   />
<div id="ExportElementModal" title="Export UI Element">
	<div class="modal-body">
		<form action="${exportElements}" enctype="multipart/form-data" method="post" name="exportUIElement" >
			<aui:fieldset>
			    <aui:select name="exportLanguage"  id="exportLanguage" label="<em class=\"required\">* </em>Select Language" >
					<c:forEach var="langOpt" items="${activeLanguages}">
						<aui:option value="${langOpt.key}">${langOpt.value}</aui:option>
					</c:forEach>
		   		</aui:select>
		   		<c:if test="${isElementTechAdmin}">
			   		<label class="aui-field-label" for="<portlet:namespace />exportModule"><em class="required">* </em>Used In</label>
			   		<select multiple="multiple" id="<portlet:namespace />exportModule" name="<portlet:namespace />exportModule" class="exportmultis required" style="display: none;">
					   <c:forEach var="opt" items="${usedInOptions}">
							<option value="${opt.key}">${opt.value}
						</c:forEach>
					</select>
			   		<aui:input type="checkbox" name="importUsedIn" id="importUsedIn" 
							   value="" title="Export Used In information to Excel" label="Export \"Used In\" information to Excel"/>
				</c:if>
		   	</aui:fieldset>  		
		</form>
	</div>

	<div class="modal-footer aui-panel-ft">
		<input class="btn pull-left" type="button" title="Export"
			value="Export" onclick="submitUIElement('${exportElements}')">
		<button class="btn pull-right exportElementPopupClose" title="Close">Close</button>
	</div>
</div>

<script type="text/javascript">
	var isElementTechAdmin = '${isElementTechAdmin}';
	var processProgress = '<%= exportElemProgressId %>';
	jQuery(".exportmultis").multiselect();
	function submitUIElement(url) {
		var exportLanguage = $('#<portlet:namespace />exportLanguage').val();
		var exportModule = $('#<portlet:namespace />exportModule').val();
		var exportUsedIn = $('#<portlet:namespace />importUsedInCheckbox').is(':checked');
		
		if(typeof exportLanguage == 'undefined' || exportLanguage == null || exportLanguage == '' || exportLanguage == 'null') {
			jQuery.msgBox("Please select language.");
		} else if(isElementTechAdmin == 'true' && 
				 (exportModule == 'undefined' || exportModule == null || exportModule == '' || exportModule == 'null')) {
			jQuery.msgBox("Please select Used In information.");
		} else {
			url = url+"&<portlet:namespace/>exportLanguage="+exportLanguage;
			if(exportModule != null){
				url = url+"&<portlet:namespace/>exportModule="+exportModule;
			}
			url = url+"&<portlet:namespace/>exportUsedIn="+exportUsedIn;
			document.exportUIElement.action = url;
			document.exportUIElement.submit();
			eval(processProgress).startProgress();
		}
	}
	$(".exportElementPopupClose").click(function() {
		exportElementDialog.dialog('close');
	});
</script>