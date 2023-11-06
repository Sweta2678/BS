<%@include file="/html/uielement/init.jsp"%>

<portlet:resourceURL var="auiImportElement">
	<portlet:param name="modalType" value="importElementsToXLS" />
</portlet:resourceURL>

<!-- Keep this css here because we are overriding only for this JSP. -->
<style>
	#errors {
		display:none;
		padding:10px;
		background-color:#9F9;
		border:2px solid #396;
		margin-bottom:20px;
	} 
</style>

<%  
	String importElemProgressId = (String)request.getAttribute("importElemProgressId");
%>
<portlet:renderURL var="cancel" />

<liferay-ui:upload-progress
    id="<%=importElemProgressId%>"
    message="uploading"
    redirect="#"
   />
<aui:form action="${auiImportElement}" enctype="multipart/form-data" method="post" name="excelfm" >

     <aui:input name="localeCd" id="localeCd" type="hidden" value="" />
	 <aui:input name="importElemProgressId" type="hidden" value="<%= importElemProgressId %>" />
 	 <aui:fieldset>
	    <aui:select name="importLanguage"  id="importLanguage" label="<em class=\"required\">* </em>Select Language">
			<c:forEach var="langOpt" items="${activeLanguages}">
				<option value="${langOpt.key}">${langOpt.value}</option>
			</c:forEach>
   		</aui:select>
		<aui:input name="file" type="file" label="<em class=\"required\">* </em>Import File"></aui:input>
		<c:if test="${isElementTechAdmin}">
			<span class="aui-field aui-field-select aui-field-menu">
				<span class="aui-field-content">
					<label for="importModule" class="aui-field-label"><em class="required">* </em>Used In</label>
					<span class="aui-field-element ">
						<select multiple="multiple" id="importModule" name="importModule" class="importmultis required" style="display: none;">
							<c:forEach var="opt" items="${usedInOptions}">
								<option value="${opt.key}">${opt.value}
							</c:forEach>
						</select>
					</span>
				</span>
			</span>
			<span class="aui-field aui-field-select aui-field-menu">
				<span class="aui-field-content">
					<label for="" class="aui-field-label">(OR)</label>
				</span>
			</span>
			<span class="aui-field aui-field-choice" id="aui_3_2_0_11223">
				<span class="aui-field-content" id="aui_3_2_0_11222">
					<span class="aui-field-element aui-field-label-right" id="aui_3_2_0_11235">
						<input type="checkbox" name="importUsedIn" id="importUsedIn" 
						   value="" title="Import Used In information from Excel"> 
					</span>
					<label for="importUsedIn" class="aui-field-label" id="aui_3_2_0_11221">
						<em class="required">* </em>Import "Used In" information from Excel
					</label>
				</span>
			</span>
		</c:if>		
	 </aui:fieldset>
</aui:form>

<div id='errors'></div>


<!-- Grid Start -->
<table id="indexExcelGrid"></table>
<div id="indexExcelPager"></div>
<table id="navgrid"></table>
<div id="pagernav"></div>
<!-- Grid End -->

<aui:script use="aui-base">
	var validateFile = function(fileField) {
		var value = fileField.val();
		if (value) {
			var extension = value.substring(value.lastIndexOf('.')).toLowerCase();
			var validExtensions = ['.xls','.xlsm'];
			if ((A.Array.indexOf(validExtensions, '*') == -1) &&
				(A.Array.indexOf(validExtensions, extension) == -1)) {
					alert('Only files with following extensions are allowed: xls, xlsm');
					fileField.val('');
			}
		}
	};

	var onFileChange = function(event) {
		validateFile(event.currentTarget);
	};

	var fileField = A.one('#<portlet:namespace />file')

	if (fileField) {
		fileField.on('change', onFileChange);
		validateFile(fileField);
	}

	var nodeObject = A.one('#<portlet:namespace />importLanguage');
	A.one('#<portlet:namespace />localeCd').set('value', nodeObject.get('value'));
	if(nodeObject) {
		nodeObject.on('change', function(event){
			A.one('#<portlet:namespace />localeCd').set('value', nodeObject.get('value'));
		});
	}
     
</aui:script>

<script type="text/javascript">
	var isElementTechAdmin = '${isElementTechAdmin}';
	var processProgress = '';
	jQuery(".importmultis").multiselect();
	jQuery(".importElementPopupClose").click(function() {
		importElementDialog.dialog('close');
	});

	/* function submitUIElement(url) {
		var importLanguage = $('#importLanguage').val();
		var file = $('#file').val();
		var importModule = $('#importModule').val();
		var importUsedIn = $('#importUsedIn').is(':checked');
		
		if(typeof importLanguage == 'undefined' || importLanguage == null || importLanguage == '' || importLanguage == 'null') {
			jQuery.msgBox("Please select language.");
		} else if(typeof file == 'undefined' || file == null || file == '' || file == 'null') {
			jQuery.msgBox("Please select file.");
		} else if(isElementTechAdmin == 'true' && 
				 (importModule == 'undefined' || importModule == null || importModule == '' || importModule == 'null')
				 && (typeof importUsedIn == 'undefined' || importUsedIn == null || importUsedIn == '' || importUsedIn == 'null') ){
				jQuery.msgBox("Please select Used In information OR Select Import \"Used In\" Information from Excel checkbox.");
		} else {
			document.importUIElement.action = url;
			document.importUIElement.submit();
			eval(processProgress).startProgress();
		}
	} */
</script>