<%@include file="/html/init.jsp"%>
<portlet:resourceURL id='languageUpdateRefreshURL' var="languageUpdateRefreshURL">
	<portlet:param name="requestType" value="RegionRefreshURL" />
</portlet:resourceURL>
<% int rowCount = 0; %>
<c:set var="defaultDateFormat" value="dd MMM yyyy hh:mm zzz"/>	
<div class="lst-update-time" style="float:right;"><span>Last updated at <fmt:formatDate value="${lastUpdatedTime }" pattern="${defaultDateFormat}" /><i onclick="javascript:hardReferesh(${tabIndx});" class="icon-refresh pull-right" style="background-color:pink;margin-left:10px;" title="Real Time"></i><i title="Batch Update"  onclick="javascript:loadTabData(${tabIndx});" class="icon-refresh pull-left"></i></span></div>
<div class="row">
	<div id="overallProgress${tabIndx}">
		<%@include file="/html/progress/progress_overall.jsp"%>
	</div>
	<div id="complianceProgress${tabIndx}" class="span5">
		<%@include file="/html/progress/progress_compliance.jsp"%>
	</div>
	<div id="dummy${tabIndx}">
	</div>
	<div id="notificationProgress${tabIndx}" class="span5">
		<%@include file="/html/progress/progress_notifications.jsp"%>
	</div>
</div>

<c:if test="${tabIndx eq 0}">
	<portlet:resourceURL id='translationExecOverrideURL' var="translationExecOverrideURL">
		<portlet:param name="requestType" value="TranslationExecOverride" />
	</portlet:resourceURL>
	<div id="translationExecOverrideDiv">
		<div class="trans_exec_override_div">
			<input type="checkbox" name="translationExecOverride" id="translationExecOverride" class="translation_exec_override"  ${translationExecOverrideChecked} onChange="updateTranslationExecOverride()">
			<span id="translationExecOverrideTitle" class="translation_exec_override_txt">Translation Executive Override</span>
       </div>
    </div>
</c:if>
     
<div id="languageSelection">
	<div class="well well-small">
		<table style="width:100%"><tbody><tr>
		<c:forEach var="langOpt" items="${activeSecondLanguages}">
			<%
				Map<String, String> selectedBrdgRgnLangs = new HashMap<String, String>();
				String checked = "";
				if(request.getAttribute("selectedBrdgRgnLangs") != null){
					selectedBrdgRgnLangs = (Map<String, String>)request.getAttribute("selectedBrdgRgnLangs");
				}
				Map.Entry<String, String> langOpt = (Map.Entry<String, String>)pageContext.getAttribute("langOpt");
				if(selectedBrdgRgnLangs != null && selectedBrdgRgnLangs.get(langOpt.getKey()) != null) {
					checked = "checked=\"checked\"";
				}
				if(rowCount > 0 && (rowCount % 5) == 0 ){
					out.println("</tr><tr>");
	            }
				rowCount++;
			%>
			<td>
				<label class="checkbox">
					<input type="checkbox" name="${tabIndx}_${langOpt.key}" id="${tabIndx}_${langOpt.key}" <%=checked %> onChange="updateLanguageSelection('${tabIndx}', '${langOpt.key}')"> ${langOpt.value}
				</label>
			</td>
		</c:forEach>
	</tr></tbody></table>
	</div>
</div>

<div class="row">	
    <div id="indexTranslationProgress${tabIndx}">
        <%@include file="/html/progress/progress_index_translation.jsp"%>
    </div>
    <div id="contentTranslationProgress${tabIndx}" class="span5">
        <%@include file="/html/progress/progress_content_translation.jsp"%>
    </div>
    <div id="supportDocsProgress${tabIndx}">
        <%@include file="/html/progress/progress_attachment_translation.jsp"%>
    </div>
    <div id="linksProgress${tabIndx}" class="span5">
        <%@include file="/html/progress/progress_link_translation.jsp"%>
    </div>
    <div id="imagesProgress${tabIndx}">
        <%@include file="/html/progress/progress_image_translation.jsp"%>
    </div>
</div>

<script type="text/javascript">
	function updateLanguageSelection(tabIndx, localeCode){
		var tabIndx = '${tabIndx}';
		var languageUpdateRefreshURL = '${languageUpdateRefreshURL}';
		languageUpdateRefreshURL = languageUpdateRefreshURL+"&updateLanguage=true&tabIndx=${tabIndx}";
		var elementChecked = $('#'+tabIndx+'_'+localeCode).is(':checked');
		/* load block UI */
		loadProgressBar();
		$.ajax({
		  	url :languageUpdateRefreshURL,
		  	type: "POST",
		  	data: {updateLanguage:'true',localeCode:localeCode,elementChecked:elementChecked}
		}).done(function(data) {
	    	if (data != null && data != '' && typeof data != 'undefined') {
	    		if(tabIndx == 0){
                    $('#global').html(data);
                } else if(tabIndx == 1){
	    			$('#amea').html(data);
	    		} else if(tabIndx == 2){
	    			$('#amer').html(data);
	    		} else if(tabIndx == 3){
	    			$('#euro').html(data);
	    		} else if(tabIndx == 4){
	    			$('#gc').html(data);
	    		} else if(tabIndx == -1){
	    			$('#region').html(data);
	    		}
	    	}
			/* Un load block UI */
			unLoadProgressBar(); //jQuery.unblockUI();
		}).fail( function(jqXHR) {
			/* Un load block UI */
	        unLoadProgressBar(); //jQuery.unblockUI();
		});
	}
	
	function updateTranslationExecOverride() {
		var translationExecOverrideURL = '${translationExecOverrideURL}';
		var elementChecked = $('#translationExecOverride').is(':checked');
		/* load block UI */
		loadProgressBar();
		$.ajax({
		  	url :translationExecOverrideURL,
		  	type: "POST",
		  	data: {elementChecked:elementChecked}
		}).done(function(data) {
	    	if (data != null && data != '' && typeof data != 'undefined') {
	    		if(data == 'Fail'){
	    			alert("Failed to update Translation Executive Override");
	    		}
	    	}
			/* Un load block UI */
			unLoadProgressBar(); //jQuery.unblockUI();
		}).fail( function(jqXHR) {
			/* Un load block UI */
	        unLoadProgressBar(); //jQuery.unblockUI();
		});
	}
	
	function showViewDetails(localeCode, viewType) {
        var viewURL = "/web/brand-standards<%=themeDisplay.getLayout().getFriendlyURL()%>?requestType=ViewDetails&viewType="+viewType+"&localeCode="+localeCode+"&tabIndx=${tabIndx}";
        window.location = viewURL;
    }
	
	function hardReferesh(tabIndex){
		loadTabData(tabIndex,true);
	}
</script>
<style>
.summary-region .lst-update-time span{
	position: absolute;
	right: 10px;
	top: 55px;
}
#progress_Tabs .lst-update-time span{
	position: absolute;
	top: 20px;
	right: 10px;
}
table.table-bordered .icon-refresh {
    display: none !important;
}
</style>