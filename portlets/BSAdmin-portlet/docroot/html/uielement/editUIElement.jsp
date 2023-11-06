<%@include file="/html/uielement/init.jsp"%>
<%
    UIElementData editUIElement = (UIElementData)request.getAttribute("editUIElement");
	if(editUIElement == null){
	 	editUIElement = (UIElementData)pageContext.getAttribute("editUIElement");
	}
%>
<portlet:actionURL var="save" name="processEdit">
	<portlet:param name="elementId" value="${editUIElement.elementId}"></portlet:param>
</portlet:actionURL>
<portlet:renderURL var="saveElement">
	<portlet:param name="elementId" value="${editUIElement.elementId}"></portlet:param>
</portlet:renderURL>
<portlet:renderURL var="cancel" />

<div id="EditElementModal" title="Edit UI Element">
	<div style="max-height:400px; overflow-y:auto;">
		<form name="editUIElementFM" method="post" action="">
			<label class="wrapper_label">
				<span class="wrapper_span">Key:</span>
				<span style="display:inline-block;margin-top: 5px;">${editUIElement.elementKey}</span>            
			</label>
			<c:if test="${isElementTechAdmin}">
				<label class="wrapper_label">
					<span class="wrapper_span"><em class="required">* </em>Element Used In:</span>
					<select id="editSelectModule" name="editSelectModule" class="multis required" 
	                	multiple="multiple" style="display: none;">
	                    <c:forEach var="opt" items="${usedInOptions}">
							<% 
								Map.Entry<String, String> opt = (Map.Entry<String, String>)pageContext.getAttribute("opt");
								String selected = "";
								if(editUIElement.getUsedIn().contains(opt.getKey())){
								    selected = "selected";
								}
							%>
							<option value="${opt.key}" <%=selected%> >${opt.value}</option>
						</c:forEach>
	                </select>
	            </label>
	        </c:if>
	        <label class="wrapper_label">
	        	<span class="wrapper_span">English UK:</span>              
				<span style="display:inline-block;margin-top:5px;">${editUIElement.enGBValue}</span>            
			</label>
			<c:forEach var="lang" items="${activeLanguages}">
				<label class="wrapper_label">
	            	<span class="wrapper_span">
	            	<% 
	            		Map.Entry<String, String> lang = (Map.Entry<String, String>)pageContext.getAttribute("lang");
	            		if(lang.getKey().equalsIgnoreCase("en_GB")) {
	            		    out.println("<em class=\"required\">* </em>");
	            		}
	            		String elemValue = "";
	            		if(editUIElement.getLanguages().get(lang.getKey()) != null){
	            		    elemValue =editUIElement.getLanguages().get(lang.getKey());
	            		}
	            	%>
	            		${lang.value}:
	            	</span>              
					<textarea id="language_${lang.key}" name="language_${lang.key}"
								maxlength="4000" class="uielement_textarea" style="width:600px; height:50px;"><%=elemValue%></textarea>
	            </label>
			</c:forEach>
		</form>
	</div>
	<div class="modal-footer aui-panel-ft">
		<input class="btn pull-left" type="button" title="Save"
			value="Save" onclick="submitUIElement('${save}')">
		<button class="btn pull-right editElementPopupClose" title="Cancel">Cancel</button>
	</div>
</div>

<script type="text/javascript">
	var elementId = '${editUIElement.elementId}';
	var isElementTechAdmin = '${isElementTechAdmin}';
	$(document).ready(function() {
		//alert("editUIElement.elementId==="+elementId);
	});
	jQuery(".multis").multiselect();
	
	$(".editElementPopupClose").click(function() {
		editElementDialog.dialog('close');
	});

	function submitUIElement(url) {
		 var editSelectModule = jQuery.trim(jQuery('#editSelectModule').val());
		 var enGBValue = jQuery.trim(jQuery('#EditElementModal textarea#language_en_GB').val());
		 var itemsPerPage = jQuery.trim(jQuery('#<portlet:namespace />itemsPerPage').val());
		 var currPage = jQuery.trim(jQuery('#<portlet:namespace />page').val());
		 if(isElementTechAdmin == 'true' && 
				 (editSelectModule == 'undefined' || editSelectModule == null || editSelectModule == '' || editSelectModule == 'null')) {
			 jQuery.msgBox("Please select Used In information.");
		 } else if(typeof enGBValue == 'undefined' || enGBValue == null || enGBValue == '' || enGBValue == 'null') {
			 jQuery.msgBox("Please enter English UK value.");
		 } else {
			 if(typeof itemsPerPage != 'undefined' && itemsPerPage != null && itemsPerPage != '' && itemsPerPage != 'null'){
				 url = url+'&delta='+itemsPerPage;
			 }
			 if(typeof currPage != 'undefined' && currPage != null && currPage != '' && currPage != 'null'){
				 url = url+'&cur='+currPage;
			 }
			 document.editUIElementFM.action = url;
			 document.editUIElementFM.submit();
		 }
	}
</script>