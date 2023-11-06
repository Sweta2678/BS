<%@page import="com.liferay.portal.util.PortletKeys"%>
<%@page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portlet.journal.model.JournalArticle"%>
<%@page import="javax.portlet.RenderRequest"%>
<%@include file="/html/init.jsp" %>

<portlet:resourceURL id='downloadManual' var="downloadManual" />

<div class="span4 marginTop10">
<div class="well well-small"><c:if
	test='${not empty resourcePrimkey}'>
	<liferay-ui:journal-article articleResourcePrimKey="${resourcePrimkey}" />
</c:if>
<%
BSLanguageUtil obsmLanguageUtil = (BSLanguageUtil)session.getAttribute("obsmLanguageUtil");

JournalArticle articleDisplay = null;
if(Validator.isNotNull(renderRequest.getAttribute("article"))) {
    articleDisplay = ((JournalArticle) renderRequest.getAttribute("article"));
%>

<c:if test="${hasEditPermission}">
	<div>
		<div class="icon-actions">
			<liferay-portlet:renderURL
				windowState="<%= WindowState.MAXIMIZED.toString() %>"
				var="editURL"
				portletName="<%= com.liferay.portal.util.PortletKeys.JOURNAL %>">
				<portlet:param name="struts_action" value="/journal/edit_article" />
				<portlet:param name="redirect" value="<%= PortalUtil.getCurrentURL(renderRequest) %>" />
				<portlet:param name="referringPortletResource"
					value="<%=PortletKeys.JOURNAL_CONTENT %>" />
				<portlet:param name="groupId"
					value="<%= String.valueOf(articleDisplay.getGroupId()) %>" />
				<portlet:param name="articleId"
					value="<%= articleDisplay.getArticleId() %>" />
				<portlet:param name="version"
					value="<%= String.valueOf(articleDisplay.getVersion()) %>" />
			</liferay-portlet:renderURL>
	
			<liferay-ui:icon image="edit" message="edit-web-content"
				url="<%= editURL %>" />
		</div>
	</div>
</c:if>
<%
}
%>

<p><em>${publishMsg}&nbsp;${publishDate}</em></p>

<form class="">
	<div class="control-group">
	<c:choose>
		<c:when test='${staticManuals ne null && not empty staticManuals}'>
				<label style="display : none;"><c:out value="${fn:length(staticManuals)}" /></label>
				<div class="controls">
					<c:choose> 
						<c:when test="${fn:length(buildTypesList) gt 1}">
							<select name="manual" id="manual" >
								<c:forEach var="staticManual" items="${staticManuals}" varStatus="status">
									<c:set var="languageKey" value="${staticManual.key}" />	
									 <c:forEach var="manualType" items="${staticManual.value}" varStatus="status">
										<c:set var="manualTypeKey" value="${fn:toLowerCase(manualType.key)}" />
										<c:if test="${langCode == staticManual.key }">
											<option value="${manualType.key }">
											<%= (obsmLanguageUtil != null ? obsmLanguageUtil.get("bs.obsm.home.manual."+pageContext.getAttribute("manualTypeKey")) : "bs.obsm.home.manual."+pageContext.getAttribute("manualTypeKey"))%>
											</option>
										</c:if>
									 </c:forEach>							
								</c:forEach>
							</select>
						</c:when>
						<c:otherwise>
								<c:forEach var="staticManual" items="${staticManuals}" varStatus="status">
									<c:set var="languageKey" value="${staticManual.key}" />	
									 <c:forEach var="manualType" items="${staticManual.value}" varStatus="status">
										<c:set var="manualTypeKey" value="${fn:toLowerCase(manualType.key)}" />
										<c:if test="${langCode == staticManual.key }">	
											<%= (obsmLanguageUtil != null ? obsmLanguageUtil.get("bs.obsm.home.manual."+pageContext.getAttribute("manualTypeKey")) : "bs.obsm.home.manual."+pageContext.getAttribute("manualTypeKey"))%>
										</c:if>
									 </c:forEach>							
								</c:forEach>
						</c:otherwise>
					</c:choose>
				</div>
				<label class="control-label" for="language">${languageMsg}</label>
				<div class="controls">
					<c:choose>
						<c:when test="${fn:length(staticManuals) gt 1}">
							<select name="language" id="language">
						</c:when>
						<c:otherwise>
							<select name="language" id="language"  disabled="disabled" >
						</c:otherwise>
					</c:choose>
						<c:forEach var="staticManual" items="${staticManuals}" varStatus="status">
							<c:set var="languageKey" value="${staticManual.key}" />
							<option value="${staticManual.key}" ${staticManual.key == langCode ? 'selected' : ''}>
							
							<%= (obsmLanguageUtil != null ? obsmLanguageUtil.get("bs.language." + pageContext.getAttribute("languageKey")) : "bs.language." + pageContext.getAttribute("languageKey"))%>
							</option>
						</c:forEach>
					</select>
				</div>
			</c:when>
		<c:otherwise>
			<em>${noManuals}</em>
		</c:otherwise>
	</c:choose>

</div>
<div class="control-group hide">
	<label class="control-label" for="paper">Paper Size</label>
	<div class="controls">
		<select name="paper">
			<option>A4</option>
			<option>Letter</option>
		</select>
	</div>
</div>
<c:if test='${staticManuals ne null && not empty staticManuals}'>
	<a href="${pdfList}" id="download-manual" onmousedown="javascript:trackEvent();" class="btn btn-primary"
		download target="_blank"><i class="icon-white icon-download-alt"></i>
		${downloadMsg}</a>
</c:if>
<div class="clearfix"></div>
</form>
</div>
</div>


<div id="supportingMaterial_popup" style="display: none;"></div>
<div id="allSupportingMaterial_popup" style="display: none;"></div>
<script type="text/javascript">
var manualURL = '${downloadManual}';
var langCode = $('#language').val();
var countryVal = "${countryCode}";
var jsonPdfObj = null;
var brandCode = '${brand}';
$(document).ready(function(){
      
	var jsonStaticManuals = '${jsonStaticManuals}';
	var multiTypes = '${fn:length(buildTypesList)}';
	/* console.log(multiTypes); */
	if(jsonStaticManuals!='undefined' && jsonStaticManuals!='' )
	{
		if(multiTypes > 1)
		{
			jsonPdfObj = jQuery.parseJSON( jsonStaticManuals );
			var selectedLang = $('#language option:selected').val();
			var selectedManual =  $('#manual option:selected').val();
			var downloadLink = jsonPdfObj.map[selectedLang].map[selectedManual];
			console.log("dlownload : "+downloadLink);
			$('#download-manual').attr('href',downloadLink);
			
			$('#manual ,#language' ).change(function () {
				var selectedLang =	$('#language option:selected').val();
				var selectedManual = $('#manual option:selected').val();
				var downloadLink =  jsonPdfObj.map[selectedLang].map[selectedManual];
				$('#download-manual').attr('href',downloadLink);
			});
		}
		else
		{
			jsonPdfObj = jQuery.parseJSON( jsonStaticManuals );
			
			var selectedLang = $('#language option:selected').val();
			var selectedManual = '${buildTypesList[0]}';
			var downloadLink = jsonPdfObj.map[selectedLang].map[selectedManual];
			/* console.log("dlownload : "+downloadLink); */
			$('#download-manual').attr('href',downloadLink);
			
			$('#manual ,#language' ).change(function () {
				var selectedLang =	$('#language option:selected').val();
				var selectedManual = '${buildTypesList[0]}';
				var downloadLink =  jsonPdfObj.map[selectedLang].map[selectedManual];
				$('#download-manual').attr('href',downloadLink);
			});
		}
	}
});


function downloadManual() {
	$.ajax({
	  	url :manualURL,
	  	data: {"langCode":langCode},
	  	type: "GET",
	  	dataType: "text",
	    success: function(data) {
	    	if (data != null && data != '' && typeof data != 'undefined') {
	    		$('#download-manual').attr('href',data);	
	    	}
	    }
	    });
}

function downloadPDF () {
	//langCode = $('#language').val();
	//$('#download-manual').attr('href',langCode);
}

function trackEvent () {
	var brand = "${brand}";
	var dwnManualType = $('#manual').val();
	var downloadtype = '';
	if ('OPERATE' == dwnManualType) {
		downloadtype = 'Operations Extract';
	} else if ('BUILD' == dwnManualType) {
		downloadtype = 'Build & Design Extract';			
	} else {
		downloadtype = 'Full Manual';
	}
	var language = $("#language").find("option:selected").val();
	_gaq.push(['_trackEvent', 'Download Full Manual', downloadtype, downloadtype+" for "+language]);
}

</script>