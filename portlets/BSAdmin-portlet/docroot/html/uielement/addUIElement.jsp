<%@include file="/html/uielement/init.jsp" %>
<portlet:actionURL var="save" name="processSave"/>
<portlet:resourceURL var="validateKey">
	<portlet:param name="modalType" value="validateKey" />
</portlet:resourceURL>

<div id="AddElementModal" title="Add UI Element">
	<div style="max-height:400px; overflow-y:auto;">
		<form name="addUIElementFM" method="post" action="">
			<label class="wrapper_label">
				<span class="wrapper_span"><em class="required">* </em>Key:</span>              
				<input type="text" id="addElementKey" name="addElementKey" maxlength="250" style="width:600px;" class="input_text required">
			</label>
			<c:if test="${isElementTechAdmin}">
				<label class="wrapper_label">
					<span class="wrapper_span"><em class="required">* </em>Element Used In:</span>
					<select id="addSelectModule" name="addSelectModule" class="multis required" 
	                	multiple="multiple" style="display: none;">
	                    <c:forEach var="opt" items="${usedInOptions}">
							<option value="${opt.key}">${opt.value}
						</c:forEach>
	                </select>
	            </label>
            </c:if>
            <c:forEach var="lang" items="${activeLanguages}">
				<label class="wrapper_label">
	            	<span class="wrapper_span">
	            	<% 
	            		Map.Entry<String, String> lang = (Map.Entry<String, String>)pageContext.getAttribute("lang");
	            		if(lang.getKey().equalsIgnoreCase("en_GB")) {
	            	%>
	            		<em class="required">* </em>
	            	<% } %>
	            		${lang.value}:
	            	</span>              
					<textarea id="language_${lang.key}" name="language_${lang.key}"
								maxlength="4000" class="uielement_textarea" style="width:600px; height:50px;"></textarea>
	            </label>
			</c:forEach>
			</form>
	</div>
	<div class="modal-footer aui-panel-ft">
		<input class="btn pull-left" type="button" title="Edit Element"
			value="Save" onclick="submitUIElement('${save}')">
		<button class="btn pull-right addElementPopupClose" title="Cancel">Cancel</button>
	</div>
</div>

<script type="text/javascript">
	var isElementTechAdmin = '${isElementTechAdmin}';
	var validateKeyURL = '${validateKey}';
	jQuery(".multis").multiselect();
	
	$(".addElementPopupClose").click(function() {
		addElementDialog.dialog('close');
	});

	 function submitUIElement(url)
	 {
		 var addElementKey = jQuery.trim(jQuery('input#addElementKey').val());
		 var addSelectModule = jQuery.trim(jQuery('#addSelectModule').val());
		 var enGBValue = jQuery.trim(jQuery('#AddElementModal textarea#language_en_GB').val());
		 if(typeof addElementKey == 'undefined' || addElementKey == null || addElementKey == '' || addElementKey == 'null') {
			 jQuery.msgBox("Please enter Element Key.");
		 } else if(addElementKey.length > 250){
			 jQuery.msgBox("Element Key cannot be more than 250 characters.");
		 } else if(isElementTechAdmin == 'true' && 
				 (addSelectModule == 'undefined' || addSelectModule == null || addSelectModule == '' || addSelectModule == 'null')) {
			 jQuery.msgBox("Please select Used In information.");
		 } else if(typeof enGBValue == 'undefined' || enGBValue == null || enGBValue == '' || enGBValue == 'null') {
			 jQuery.msgBox("Please enter English UK value.");
		 } else {
			 $.ajax({
			  	url :validateKeyURL,
			  	data : {"addElementKey":addElementKey},
				type: "POST",
			  	dataType: "text",
			    success: function(data) {
			    	if (data != null && data != '' && typeof data != 'undefined') {
			    		if(data == 'Element Exist'){
			    			jQuery.msgBox("Element Key already exist. Please enter different Element Key.");
			    		} else {
			    			jQuery.msgBox("Invalid Element Key. Please enter different Element Key.");
			    		}
			    	} else {
			    		document.addUIElementFM.action=url;
						document.addUIElementFM.submit();
			    	}
			    }
			});
		 }
	 }
</script>