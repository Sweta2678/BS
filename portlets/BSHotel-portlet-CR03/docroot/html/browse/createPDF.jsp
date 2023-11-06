<%@include file="/html/init.jsp"%>
<%@page import="com.ihg.brandstandards.db.model.StandardsLocale"%>
<%@page import="java.util.Locale"%>

<portlet:resourceURL id='generatePDF' var="generatePDF">
	<portlet:param name="modalType" value="generatePDF"></portlet:param>
</portlet:resourceURL>

<div id="CreatePDFModal" title="Create PDF">
 	<div class="modal-body">
	    <div class="row">
			<c:if test="${showSearchResultsMsg}">
				<div class="span7">
					<div class="infoBar highlight" style="text-align:left">${searchResultsMsg}</div>
				</div>
			</c:if>
			<c:if test="${showNoSearchActiveMsg}">
				<div class="span7">
					<div class="infoBar">${noSearchActiveMsg}</div> 
				</div>
			</c:if>
	    </div>
    	<div class="row">
	      	<div class="span7">
		        <p style="margin-top: 10px;">
		          	${yourPDFLabel}&nbsp;
	        	<% 
	        		List<StandardsLocale> pdfLangs = new ArrayList<StandardsLocale>();
	        		String pdfSelectedLangCode = "";
	        		if(request.getAttribute("pdfSelectedLangCode") != null){
	        		    pdfSelectedLangCode = (String)request.getAttribute("pdfSelectedLangCode");
	        		}
        			if(request.getAttribute("pdfLangs") != null){
        			    pdfLangs = (List<StandardsLocale>)request.getAttribute("pdfLangs");
        			}
        			if (pdfLangs != null && pdfLangs.size() > 1) {
        		%>
        			<select style="margin-bottom:0;" class="input-medium" name="pdfLanguage" id="pdfLanguage">
        		<%
        			} else {
        		%>
        			<select style="margin-bottom:0;" disabled="disabled" class="input-medium" name="pdfLanguage" id="pdfLanguage">		
        		<%
        			}
        			BSLanguageUtil obsmLanguageUtil = (BSLanguageUtil)session.getAttribute("obsmLanguageUtil");
        			for (StandardsLocale pdfLang : pdfLangs){
        			    String selected = "";
        			    if(pdfSelectedLangCode != null && pdfSelectedLangCode.equalsIgnoreCase(pdfLang.getLocaleCode())){
        			        selected = "selected";
        			    }
	        	%>
        				<option value="<%= pdfLang.getLocaleCode()%>" <%= selected %>>
        					<%= (obsmLanguageUtil != null ? obsmLanguageUtil.get("bs.language."+pdfLang.getLocaleCode()) : "bs.language."+pdfLang.getLocaleCode()) %>
        				</option>
	        	<% } %>	
		           	</select> 
		           	${onLabel}&nbsp;
		           	<select style="margin-bottom:0;" class="input-small" name="pdfPaper" id="pdfPaper">
			             <option value="A4" ${a4Selected}>A4</option>
			             <option value="Letter" ${letterSelected}>${letterLabel}</option>
		           	</select> ${paperLabel} 
	         	</p>
	         	<p>${emailNoteLabel}</p><hr>
	      		<p style="text-align: right;"><em>${availableNoteLabel}</em></p>
	      	</div>
    	</div>
  	</div>
	<div class="modal-footer">
		<p style="margin-top: 5px; disaply: none;" id="generatePDFSection" class="errorMessage"><em style="color: #F00;" id="generatePDFMessage"></em></p>
		<button class="btn pull-left CreatePDFModalClose" title="${closeLabel}">${closeLabel}</button>
		<a class="btn btn-primary pull-right" id="generatePDFButton" onclick="javascript:generatePDF(false);" title="${generatepdfLabel}">${generatepdfLabel}</a>
		<%-- <a class="btn btn-primary pull-right" id="generateSelfAuditPDFButton" onclick="javascript:generatePDF(true);" title="${generateSelfAuditPdfLabel}">${generateSelfAuditPdfLabel}</a> --%>
	</div>
</div>

<script type="text/javascript">
	var generatePDFURL = '${generatePDF}';
	var scope = '${scope}';
	function generatePDF(isSelfAudit){
		if ('disabled' == $('#generatePDFButton').attr("disabled")) {
			return false;
		}
		if (isSelfAudit && 'disabled' == $('#generateSelfAuditPDFButton').attr("disabled")) {
			return false;
		}
		var pdfLanguage = $('#pdfLanguage').val();
		var pdfPaper = $('#pdfPaper').val();
		if(isSelfAudit){
			var eventLabel = 'Generated Self Audit PDF with' + pdfLanguage + ' & ' + pdfPaper; 
			_gaq.push(['_trackEvent', 'Search Standards', 'Generate Self Audit PDF', eventLabel]);
		} else {
			var eventLabel = 'Generated PDF with' + pdfLanguage + ' & ' + pdfPaper; 
			if('WCO' == scope){
				_gaq.push(['_trackEvent', 'What Changed On', 'Generate PDF', eventLabel]);
			} else {
				_gaq.push(['_trackEvent', 'Search Standards', 'Generate PDF', eventLabel]);
			}
		}
		
		$.ajax({
		  	url :generatePDFURL,
		  	data : {"pdfLanguage":pdfLanguage,"pdfPaper":pdfPaper, "isSelfAudit":isSelfAudit},
			type: "POST",
		  	dataType: "text",
		    success: function(data) {
		    	if (data != null && data != '' && typeof data != 'undefined') {
		    		$('#generatePDFSection').attr('display','inline');
		    		$('#generatePDFSection').find('#generatePDFMessage').html(data);
		    		if(isSelfAudit){
						$('#generateSelfAuditPDFButton').attr('disabled', 'disabled');
		    		} else {
		    			$('#generatePDFButton').attr('disabled', 'disabled');
		    		}
		    	} else {
		    		$( "#createPDF_popup" ).dialog("close");
		    	}
		    }
		});
	}
	$( ".CreatePDFModalClose" ).click(function() {
		$( "#createPDF_popup" ).dialog("close");
	});
</script>