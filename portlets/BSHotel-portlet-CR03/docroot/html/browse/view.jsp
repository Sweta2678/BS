<%@include file="/html/browse/init.jsp" %>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.ihg.me2.brandstandards.custom.util.BrandStandardsConstant"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.ihg.me2.brandstandards.custom.pojo.StandardsDisplayOptions"%>
<%@page import="javax.portlet.RenderRequest"%>

<portlet:resourceURL id='supportingMaterial' var="supportingMaterial">
	<portlet:param name="modalType" value="supportingMaterial"></portlet:param>
</portlet:resourceURL>
<portlet:resourceURL id='allSupportingMaterial'
	var="allSupportingMaterial">
	<portlet:param name="modalType" value="allSupportingMaterial"></portlet:param>
</portlet:resourceURL>
<portlet:resourceURL id='createPDFPopupURL' var ="createPDFPopupURL">
	<portlet:param name="modalType" value="createPDF"></portlet:param>
</portlet:resourceURL>
<portlet:resourceURL id='viewSearchModal' var="viewSearchModal">
	<portlet:param name="modalType" value="viewSearch"></portlet:param>
</portlet:resourceURL>
<portlet:resourceURL id='mandatoryImages' var="mandatoryImages">
	<portlet:param name="modalType" value="images"></portlet:param>
</portlet:resourceURL>

<portlet:resourceURL id='viewHelpModal' var="viewHelpModal">
	<portlet:param name="modalType" value="viewHelp"></portlet:param>
</portlet:resourceURL>

<portlet:resourceURL id='saveDisplayOptions' var="saveDisplayOptions">
</portlet:resourceURL>

<portlet:resourceURL id='referenceStandards' var="referenceStandards">
	<portlet:param name="modalType" value="referenceStandards"></portlet:param>
</portlet:resourceURL>
<portlet:actionURL var="varclearSearch" name="clearSearchAction" />

<style type="text/css">
	table.specs tbody tr td {
		vertical-align: top;
		line-height: 30px;
	}
	.highlight {
		background-color: #f9e55b;
		color: black;
	}
	td.update {
	  width: 80px;
	  text-align: center;
	}

	.aui .specs span.orangeborder {
	    border-bottom: 2px solid #FFA500;
	    padding-bottom: 6px;
	}
</style>

<%
	BSLanguageUtil obsmLanguageUtil = (BSLanguageUtil)session.getAttribute("obsmLanguageUtil");
	List<Standard> displayList = new ArrayList<Standard>();
	List<String> searchCriteriaTexts = new ArrayList<String>();
	List<String> replacedSearchCriteriaTexts = new ArrayList<String>();
	List<String> searchCriteriaIds = new ArrayList<String>();
	StandardsSearchCriteria criteria = null;
	StandardsDisplayOptions displayOptions = null;
	String textSearchCriteria = "";
	String replacedTextSearchCriteria = "";
	String idSearchCriteria = "";
	String languageCode = (String)request.getAttribute("languageCode");
	String hotelCode = (String)request.getAttribute("hotelCode");
	DateFormat formatter = new SimpleDateFormat(BrandStandardsConstant.DOWNLOAD_MANUAL_DATE_FORMAT);
	String contentType = (String)request.getAttribute("contentType");
	String searchCriteriaType = "";
	if(session.getAttribute("searchCriteria") != null) {	
		criteria = 	(StandardsSearchCriteria)session.getAttribute("searchCriteria");
		searchCriteriaTexts = criteria.getSearchCriteria();
		searchCriteriaType = criteria.getTextSearchType();
	
		if(searchCriteriaTexts != null) {
			for(int i = 0; i < searchCriteriaTexts.size(); i++) {
				String criterias = searchCriteriaTexts.get(i);
				if(i == 0) {
					textSearchCriteria = "'"+criterias+"'";
				} else {
					textSearchCriteria = textSearchCriteria +",'"+ criterias+"'";
				}
			}
		}
		replacedSearchCriteriaTexts = criteria.getReplacedSearchCriteria();
		if(replacedSearchCriteriaTexts != null && replacedSearchCriteriaTexts.size() > 0) {
			for(int i = 0; i < replacedSearchCriteriaTexts.size(); i++) {
				String criterias = replacedSearchCriteriaTexts.get(i);
				if(i == 0) {
					replacedTextSearchCriteria = "'"+criterias+"'";
				} else {
					replacedTextSearchCriteria = replacedTextSearchCriteria +",'"+ criterias+"'";
				}
			}
		}
		
		searchCriteriaIds = criteria.getIdSearchCriteria();
		if(searchCriteriaIds != null) {
			for(int i = 0; i < searchCriteriaIds.size(); i++) {
				String criterias = searchCriteriaIds.get(i);
				if(i == 0) {
					idSearchCriteria = "'"+criterias+"'";
				} else {
					idSearchCriteria = idSearchCriteria +",'"+ criterias+"'";
				}
			}
		}
	}
	
	displayList = (List<Standard>)request.getAttribute("displayList");
	int pageNumber = (Integer)request.getAttribute("pageNumber");
	int  noOfPages = (Integer)request.getAttribute("noOfPages");
	String publicUrl = themeDisplay.getPathFriendlyURLPublic();
	String communityUrl = themeDisplay.getURLHome();
	String friendlyUrl = themeDisplay.getLayout().getFriendlyURL();
	String url = publicUrl+"/brand-standards"+friendlyUrl;
	String displayMessage = (String)request.getAttribute("searchResultsMsg");
	boolean isSearch = (Boolean)request.getAttribute("isSearchActive");
	
	int previousPage = 1;
	int nextPage = noOfPages;
	String recordsPerPage = String.valueOf(request.getAttribute("recordsPerPage"));
	String whatsnewParam = "Y";
	String compDateParam = "Y";
	String highlightParam = "N";
	String hotleLifeCycleParam = "Y";
	if(session.getAttribute("displayOptions") != null) {	
		displayOptions = 	(StandardsDisplayOptions)session.getAttribute("displayOptions");
		whatsnewParam = displayOptions.isWhatsNew()?"Y":"N";
		compDateParam = displayOptions.isCompDate()?"Y":"N";
		highlightParam = displayOptions.isHighlight()?"Y":"N";
		hotleLifeCycleParam = displayOptions.isHotelLifeCycle()?"Y":"N";
	}
	if(pageNumber == previousPage) {
		previousPage = 1;	
	} else {
		previousPage = pageNumber-1;	
	}
	if(pageNumber == nextPage) {
		nextPage = noOfPages;	
	} else {
		nextPage = pageNumber+1;	
	}
	String hideDisplayLogic = (String)request.getAttribute("hideDisplayButton"); 
	String showDisplayLogic =(String)request.getAttribute("showDisplayButton");
	String imagePath = "/BSHotel-portlet/images/";
	List<FlagCategory> htlLifeCycleFlags = FlagCategoryLocalServiceUtil.getFlagCategoryByParentId(91);
%>
<script type="text/javascript">
var hideDisplayPanel = "<%=hideDisplayLogic%>";
var showDisplayPanel = "<%=showDisplayLogic%>";

function cancelFilter() {
	var nodeObject = document.getElementById('<portlet:namespace/>clearFilter');
	nodeObject.value = "true";
	var frm  = document.getElementById('viewStandardsForm');
 	document.viewStandardsForm.submit();
}

function highlightMeClick() {
	highlightMe();
	saveDisplayOptions();
}

function highlightMe() {
	var state=false;
	var txtCriteria = [<%=textSearchCriteria%>];
	var replacedTxtCriteria = [<%=replacedTextSearchCriteria%>];
	var idCriteria = [<%=idSearchCriteria%>];
	var searchCriteriaType = "<%=searchCriteriaType%>";
	
	if ($('#showSearchHighlight').is(':checked')) {
		for(var k=0; k<txtCriteria.length; k++) {
			if (searchCriteriaType == "all") {
				$("#standards").highlight(txtCriteria[k]);
			} else {
				$("#standards").highlight(txtCriteria[k], {wordsOnly : true});
			}
		}
		for(var k=0; k<replacedTxtCriteria.length; k++) {
			if (searchCriteriaType == "all") {
				$("#standards").highlight(replacedTxtCriteria[k]);
			} else {
				$("#standards").highlight(replacedTxtCriteria[k], {wordsOnly : true});
			}
		}
		for(var l=0; l<idCriteria.length; l++) {
			$("#standards").highlight(idCriteria[l]);		
		}
		$(".update").unhighlight();
		/* underline image  */
		$("span.img-match").addClass("orangeborder");
		state = true;
	} else {
		$("#standards").unhighlight();	
		/* remove underline image  */
		$("span.img-match").removeClass("orangeborder");
		state = false;
	}
}

function submitPagination(source, value) {	
	var pageNoValue = "";
	var itemsPageValue = "";
	/* alert($("#itemsPerPage").val());*/
	itemsPageValue = $("#itemsPerPage").val();
	 pageNoValue=$("#pageNumber").val();
	if(source == "links") {
		pageNoValue = value;
	}
	if(source == 'itemsPerPageLower') {
		itemsPageValue = $("#itemsPerPageLower").val();
	}
	if(source == 'pageNumberLower') {
		 pageNoValue=$("#pageNumberLower").val();
	}
	if(source == 'itemsPerPage' || source == 'itemsPerPageLower') {
		pageNoValue = 1;
	}
	var submitUrl = "<%=url%>?pageNumber="+pageNoValue+"&itemsPerPage="+itemsPageValue;
	var compDateValue ='N';
	var whatsnewValue = 'N';
	var highlightValue = 'N';
	var hotelLifeCycleValue = 'N';
	if( $('#complianceDateCheckBox').is(':checked')) {
		compDateValue='Y';
	}
	if( $('#whatsNewCheckBox').is(':checked')) {
		whatsnewValue='Y';
	}
	if( $('#showSearchHighlight').is(':checked')) {
		highlightValue= 'Y';
	}
	if( $('#showHotelLifeCycle').is(':checked')) {
		hotelLifeCycleValue ='Y';
	}
	/*alert("url  is "+submitUrl+"&whatsNew="+whatsnewValue+"&compDate="+compDateValue+"&highlight="+highlightValue);*/
	window.location = submitUrl+"&whatsNew="+whatsnewValue+"&compDate="+compDateValue+"&highlight="+highlightValue+"&hotelLifeCycle="+hotelLifeCycleValue;
}

function saveDisplayOptions() {
	var compDateValue = 'N';
	var whatsnewValue = 'N';
	var highlightValue = 'N';
	var hotelLifeCycleValue = 'N';
	if( $('#complianceDateCheckBox').is(':checked')) {
		compDateValue = 'Y';
	}
	if( $('#whatsNewCheckBox').is(':checked')) {
		whatsnewValue = 'Y';
	}
	if( $('#showSearchHighlight').is(':checked')) {
		highlightValue = 'Y';
	}
	if( $('#showHotelLifeCycle').is(':checked')) {
		hotelLifeCycleValue = 'Y';
	}
	var inData = {whatsNew:whatsnewValue,compDate:compDateValue,highlight:highlightValue,hotelLifeCycle:hotelLifeCycleValue};
    jQuery.ajax({
        type: "POST",
        url: '<%=saveDisplayOptions%>',
        data: inData
    }).done( function(data) {
           /* alert("Saved");*/
    }).fail( function(jqXHR, textStatus) {
            alert("AJAX request failed with status:" + textStatus);
    });
}

function toggleClasses() {
	/*$('.update').toggleClass('show');*/	
	/*$('.complianceDate').toggleClass('invisible');*/
	if( $('#whatsNewCheckBox').is(':checked')) {
		 $(".update").removeClass("invisible");
	      $(".update").addClass("show");
	} else {
		 $(".update").removeClass("show");
	      $(".update").addClass("invisible");
	}
	if( $('#complianceDateCheckBox').is(':checked')) {
		 $(".complianceDate").removeClass("invisible");
	      $(".complianceDate").addClass("show_inline");
	} else {
		 $(".complianceDate").removeClass("show_inline");
	      $(".complianceDate").addClass("invisible");
	}
	if( $('#showHotelLifeCycle').is(':checked')) {
		 $(".ht_icon_attr").css("display", 'inline-block');
	} else {
		 $(".ht_icon_attr").css("display", "none");
	}
	saveDisplayOptions();
}
</script>

<form action="${varclearSearch}" method="post" name="viewStandardsForm" id="viewStandardsForm">
	<aui:input type="hidden" id="clearFilter" name="clearFilter" value="false"/>
	<div class="clearfix"></div>
	<div class="row">
		<div class="well well-small" style="margin-bottom: 10px;">
			<div class="row">
				<div class="span10">
				<% if(isSearch) { %>
					<div class="infoBar highlight" style="text-align:left"><%=displayMessage %></div>
				<% } else { %>
					<div class="infoBar " style="text-align:left"><%=displayMessage %></div>
				<% } %>
				</div>
				<div class="span2">
              		<a href="#" class="pull-right btn btn-small btn-primary helpModalbtn "><i class="icon-white icon-question-sign "></i> ${showSearchHelp}</a>
            	</div>
			</div>
			<div class="row" style="margin-top: 5px;">
				<div class="span6 form-inline">
					<a href="#"  class="btn btn-primary searchoptionModal"><i class="icon-white icon-search"></i> ${searchStandards} <b class="caret"></b></a> 
				<% if(criteria != null) {%>
            		<a href="#" class="btn" type="button"  onmousedown="javascript:_gaq.push(['_trackEvent', 'Search Standards', 'Clear Search', 'Clear Search']);" onclick="javascript:cancelFilter()"><i class="icon-remove"></i>&nbsp;${clearSearch}</a>
				<% } %>
					<div style="margin-top: 3px;"></div>
				</div>
				<div class="span6">
					<div class="pull-right">
			      		<a href="#"  onclick="javascript:allSupportingMaterialPopup()" class="btn sup_mod allSupportingMatModalbtn" title="${allSupportingMaterialTitle}">
			          		<i class="icon-list"></i> ${allSupportingMaterialTitle}
						</a>
				 	<% if(criteria != null && criteria.getResultCount() > 0) { %>
						<a title="${createPDFLabel}" class="btn btn-primary createPDFModalbtn" href="javascript:createPDFPopup()" >
							<i class="icon-white icon-print"></i> ${createPDFLabel}
						</a>
				 	<% } %>
            		</div>
          		</div>
        	</div>
        	<hr>
        	<div class="row" style="margin-top: 5px;">
          		<%@include file="/html/paginationTop.jsp" %>
          		<div class="span3">
            		<a href="#" class="btn pull-right btn-small" id="showHideDisplay">${hideDisplayButton}</a>
          		</div>
        	</div>
        	<hr/>
        	<div class="row displayOptions show ">
         		<div class="form-inline span12  ">
                	<label class="checkbox"><strong>${DisplayOptions}:</strong></label>
                	<label class="checkbox">
                	<% if(compDateParam.equals("N")) { %>
                		<input type="checkbox" id="complianceDateCheckBox" name="complianceDateCheckBox" onclick="toggleClasses()"  > ${showFutureCompliance}
                	<% } else { %>
                  		<input type="checkbox" id="complianceDateCheckBox" name="complianceDateCheckBox" onclick="toggleClasses()"  checked="checked"> ${showFutureCompliance}
                  	<% } %>
                	</label>
                	<label class="checkbox">
                 	<% if(whatsnewParam.equals("N")) { %>
                 		<input type="checkbox"  id="whatsNewCheckBox" name="whatsNewCheckBox" onclick="toggleClasses()"  > ${showWhatsNew}
                 	<% } else {  %>
                  		<input type="checkbox" id="whatsNewCheckBox" name="whatsNewCheckBox" onclick="toggleClasses()"  checked="checked"> ${showWhatsNew}
                  	<% } %>
                	</label>
                	<label class="checkbox">
                	<% if(highlightParam.equals("N")) { %>
                 		<input type="checkbox" id="showSearchHighlight" name="showSearchHighlight" onclick="highlightMeClick()" <%=isSearch?"":" disabled "%> > ${showSearchHighlight }
                	<% } else { %>
                  		<input type="checkbox" id="showSearchHighlight" name="showSearchHighlight" onclick="highlightMeClick()"  checked="checked" <%=isSearch?"":" disabled "%>> ${showSearchHighlight }
                   <%} %>
                	</label>
                 	<%
              	  		/*Hotel Lifecycle show only for EX Brand*/
                  		if(!contentType.equals("OPERATE")) { /*HLC icon shows for Build content*/ 
              	  	%> 
		                <label class="checkbox">
		                <% if(hotleLifeCycleParam.equals("N")) { %>
		                 	<input type="checkbox" id="showHotelLifeCycle" name="showHotelLifeCycle" onclick="toggleClasses()" > ${showHotelLifeCycle}   
		                <% } else { %>
		                  	<input type="checkbox" id="showHotelLifeCycle" name="showHotelLifeCycle" onclick="toggleClasses()"  checked="checked"> ${showHotelLifeCycle}
		                <% } %>
		                </label>
	            	<% } %>     
              		<div class="clearfix"></div>
            	</div>
        	</div>
		</div>
	</div>
    <section id="standards">
	<%
		long previousTaxonomyId = 0;
		if(displayList != null && displayList.size() > 0) {	
		for(Standard standards : displayList) {
			List<Standard> SpecsList = standards.getSpecifications();
			List<Standard> GdlnsList = standards.getGuidelines();
			if(previousTaxonomyId!=standards.getTaxonomyId()) {
				String indexPath = standards.getTaxonomyPath();
				String currentIndex = standards.getTaxonomyText();
				if (indexPath != null && indexPath.contains(currentIndex)) {
					indexPath = indexPath.replace(currentIndex,"");
	%>
					<div class="row">
						<h4><span class="grey"><%=indexPath %></span> <span class="blue"><%= currentIndex%></span></h4>
						<div style="padding-left:10%;color:#058844;"><%= (Validator.isNotNull(standards.getTaxonomyDesc()) ? standards.getTaxonomyDesc() : "") %></div>
					</div>
	<%			} else { %>
					<div class="row">
						<h4><span class="grey"><%=standards.getTaxonomyPath() %></span></h4>
						<div style="padding-left:10%;color:#058844;"><%= (Validator.isNotNull(standards.getTaxonomyDesc()) ? standards.getTaxonomyDesc() : "") %></div>
					</div>
	<% 			} 
			} 
	%> 
			<div class="row">
			<table border="0" class="specs">
				<tbody>                                                           
					<tr >	
					<% if(whatsnewParam.equals("N")) {%>
						<td class="update invisible" width="60px">
							<%if("UPDATE".equals(standards.getStatus())){ %>
							<span class="label label-warning">${update}</span>
							<%}else if("NEW".equals(standards.getStatus())){ %>
							<span class="label label-success">${newLabel}</span><%} %>
						</td>
					<% } else {%>
						<td class="update show" width="60px">
							<%if(standards.getStatus().equals("UPDATE")){ %>
							<span class="label label-warning">${update}</span>
							<%}else if(standards.getStatus().equals("NEW")){ %>
							<span class="label label-success">${newLabel}</span><%} %>
						</td>
					<% } %>
					<c:choose>
						<c:when test="<%=standards.isSearchMatches()%>">
							<td colspan="3" width="900px" style="border-right:2px solid orange">
						</c:when>
						<c:otherwise>
							<td colspan="3" width="900px">
						</c:otherwise>
					</c:choose>
					
					<strong><%=standards.getTitle()%></strong>&nbsp;<span class="grey">[<%=standards.getStdId()%>]</span>
							<% 
							if (standards.isAttachmentExists() || standards.isLinkExists()) {%>
							 <span class="label label-info">
							 <a href="javascript:supportingMaterialPopup('<%=standards.getPublishStdId()%>')"> <img alt="${supportingMaterialTitle}" title="${supportingMaterialTitle}"  src="/BSHotel-theme/images/PaperClip_white.png" style="height:14px; width:14px;">
							 </a>
							 </span>
							<%} 
							if (standards.isImageExists()) {
								if ("IMG_MATCH".equals(standards.getImageStatus())) { %>
							<span class="img-match orangeborder">
							<span class="label label-info"><a class="imageModalTrigger" title="${viewDetailsLink}" href="javascript:allMandatoryImagesPopup('<%=standards.getPublishStdId()%>')" role="button" title="${viewDetails}">${viewDetailsLink}</a></span>
							</span>
								<%} else { %>
							<span class="label label-info"><a class="imageModalTrigger" title="${viewDetailsLink}" href="javascript:allMandatoryImagesPopup('<%=standards.getPublishStdId()%>')" role="button" title="${viewDetails}">${viewDetailsLink}</a></span>
							<%}
							} else {%>
							<span>&nbsp;</span>
							<%} %>
							<%if(compDateParam.equals("N")){ 
							if(Validator.isNotNull(standards.getComplianceDate())){
								String dateValue = standards.getComplianceDate();
								if (Validator.isNotNull(languageCode)) {
									dateValue = BrandStandardsUtil.getFormatedDate(formatter.parse(standards.getComplianceDate()), languageCode, obsmLanguageUtil);
								}
							%>
									<span class="complianceDate invisible label label-info">
									
									<%=dateValue %></span>
							<%} 
							}else{
								if(Validator.isNotNull(standards.getComplianceDate())){
									String dateValue = standards.getComplianceDate();
									if (Validator.isNotNull(languageCode)) {
										dateValue = BrandStandardsUtil.getFormatedDate(formatter.parse(standards.getComplianceDate()), languageCode, obsmLanguageUtil);
									}
								
								%>
									<span class="complianceDate show_inline label label-info">
									
									<%=dateValue %></span>
							<%} 
							}%>
							<%
							if(Validator.isNotNull(standards.getExpiryDate())){
								String dateValue = standards.getExpiryDate();
								if (Validator.isNotNull(languageCode)) {
									dateValue = BrandStandardsUtil.getFormatedDate(formatter.parse(standards.getExpiryDate()), languageCode, obsmLanguageUtil);
								}
							
							%>
								<span class="expiryDate show_inline label label-inverse">${expiresTxt} | <%=dateValue %></span>
						<%} 
							if (Validator.isNotNull(standards.getStdRefId())) {
						%>
							<span class="label"><i class="icon-share-alt icon-white"></i>${referencedIds} [
						<%
							int count = 0;
							for (String refIds : standards.getStdRefId().split(",")) {
							    if (count > 0) {
						%>
							,&nbsp;
						<% 		} %>
							 	<a href="#" class="grey" onclick='javascript:stdReferencePopup("<%=refIds %>")'><%=StringUtil.trim(refIds) %></a>
						<%
								count++;
							}
						%>
							]</span>
						<%  } %>
						
						<%/* CR 50.2 Added because We need to show only for Holiday inn Express*/
						if(!contentType.equals("OPERATE")) /*HLC icon shows for Build content*/ 
						{
							String display = "";
						    if (hotleLifeCycleParam.equals("Y")) 
							{
						        display = "true";
							}
							if (Validator.isNotNull(standards.getHotelLifeCycleFlags()) && standards.getHotelLifeCycleFlags().size() > 0) 
							{
						%>
								<span class="whiteSpaceNowrap">
						<%	
								for(FlagCategory flgCatgy : htlLifeCycleFlags)
								{ 
								    String active = "";
								    if(standards.getHotelLifeCycleFlags().containsKey(flgCatgy.getFlagCatId()))
								    {
								        active = "active";
								    }
								    String flgDesc = obsmLanguageUtil.get("bs.flag." + flgCatgy.getFlagCatId()+".desc");
						%>
									<img src="<%=imagePath + flgCatgy.getFlagCatId() + (active.length() > 0 ? "_" + hotelCode: "") + ".jpg"%>" class='ht_icon_attr'  <%=(display.length() > 0 ? "": "style='display:none'")%>  title='<%=flgDesc%>' alt='<%=flgDesc%>'  />
						<%		} %>
								</span>
						<%
							}
						 }
						%>
						</td>
					</tr>
					<% for(Standard specs: SpecsList) { %>
					
					<tr >	
					<% if(whatsnewParam.equals("N")){%>
						<td class="update invisible" width="60px">
							<%if(specs.getStatus()!=null && specs.getStatus().equals("UPDATE")){ %>
							<span class="label label-warning">${update}</span>
							<%}else if(specs.getStatus()!=null &&  specs.getStatus().equals("NEW")){ %>
							<span class="label label-success">${newLabel}</span><%} %>
						</td>
					<%}else{%>
						<td class="update show" width="60px">
							<%if(specs.getStatus()!=null && specs.getStatus().equals("UPDATE")){ %>
							<span class="label label-warning">${update}</span>
							<%}else if(specs.getStatus()!=null &&  specs.getStatus().equals("NEW")){ %>
							<span class="label label-success">${newLabel}</span><%} %>
						</td>
						<%} %>
						<td class="bull">&bull;</td>
						<c:choose>
						<c:when test="<%=specs.isSearchMatches()%>">
							<td style="border-right:2px solid orange">
						</c:when>
						<c:otherwise>
							<td>
						</c:otherwise>
						</c:choose>
						<%=specs.getTitle() %><span class="grey">&nbsp;[<%=specs.getStdId() %>] </span>
							<% if (specs.isAttachmentExists() || specs.isLinkExists()) {%>
							<span class="label label-info">
							<a href="javascript:supportingMaterialPopup('<%=specs.getPublishStdId()%>')">
							<img alt="${supportingMaterialTitle}" title="${supportingMaterialTitle}"  src="/BSHotel-theme/images/PaperClip_white.png" style="height:14px; width:14px;"></a></span>
							<%} if (specs.isImageExists()) {
								if ("IMG_MATCH".equals(specs.getImageStatus())) { %>
							<span class="img-match orangeborder">
							<span class="label label-info"><a class="imageModalTrigger" title="${viewDetailsLink}" href="javascript:allMandatoryImagesPopup('<%=specs.getPublishStdId()%>')" role="button">${viewDetailsLink}</a></span>
							</span>
							<%} else { %>
							<span class="label label-info"><a class="imageModalTrigger" title="${viewDetailsLink}" href="javascript:allMandatoryImagesPopup('<%=specs.getPublishStdId()%>')" role="button">${viewDetailsLink}</a></span>
							<%}
							} else {%>
							<span>&nbsp;</span>
							<%} %>
							<%if(compDateParam.equals("N")){ 
								if(Validator.isNotNull(specs.getComplianceDate())){
									String specDateValue = specs.getComplianceDate();
									if (Validator.isNotNull(languageCode)) {
										specDateValue = BrandStandardsUtil.getFormatedDate(formatter.parse(specs.getComplianceDate()), languageCode, obsmLanguageUtil);
									}
							
							%>
									<span class="complianceDate invisible label label-info">
									
									<%=specDateValue %></span>
							<%} 
							}else{
							
								if(Validator.isNotNull(specs.getComplianceDate())){
									String specDateValue = specs.getComplianceDate();
									if (Validator.isNotNull(languageCode)) {
										specDateValue = BrandStandardsUtil.getFormatedDate(formatter.parse(specs.getComplianceDate()), languageCode, obsmLanguageUtil);
									}
							%>
							<span class="complianceDate show_inline label label-info">
							
							<%=specDateValue %></span>
						<%}
						}%>
						<%
							if(Validator.isNotNull(specs.getExpiryDate())){
								String dateValue = specs.getExpiryDate();
								if (Validator.isNotNull(languageCode)) {
									dateValue = BrandStandardsUtil.getFormatedDate(formatter.parse(specs.getExpiryDate()), languageCode, obsmLanguageUtil);
								}
							
							%>
								<span class="expiryDate show_inline label label-inverse">${expiresTxt} | <%=dateValue %></span>
						<%}
							if (Validator.isNotNull(specs.getStdRefId())) {
							%>
								<span class="label"><i class="icon-share-alt icon-white"></i>${referencedIds} [
							<%
								int count =0;    
								for (String refIds : specs.getStdRefId().split(",")) {
								    if (count > 0) {
							%>
								,&nbsp;
							<%	        
								    }
							%>
									 <a href="#" class="grey" onclick='javascript:stdReferencePopup("<%=refIds %>")'><%=StringUtil.trim(refIds) %></a>
							<%	    count++;
								    }
							%>
								]</span>
							<%
								}
						%>
						<%/*CR 50.2 Added because We need to show only for Holiday inn Express*/
						if(!contentType.equals("OPERATE")) /*HLC icon shows for Build content*/ 
						{ 
							String displaySpecHlc = "";
						    if (hotleLifeCycleParam.equals("Y")) 
							{
						    	displaySpecHlc = "true";
							}
							if (Validator.isNotNull(specs.getHotelLifeCycleFlags())  && specs.getHotelLifeCycleFlags().size() > 0) 
							{
						%>
								<span class="whiteSpaceNowrap">
						<%	
								for(FlagCategory flgCatgy : htlLifeCycleFlags)
								{ 
								    String active = "";
								    if(specs.getHotelLifeCycleFlags().containsKey(flgCatgy.getFlagCatId()))
								    {
								        active = "active";
								    }
								    String flgDesc = obsmLanguageUtil.get("bs.flag." + flgCatgy.getFlagCatId()+".desc");	
						%>
									<img src="<%=imagePath + flgCatgy.getFlagCatId() + (active.length() > 0 ? "_" + hotelCode: "") + ".jpg"%>" class='ht_icon_attr'  <%=(displaySpecHlc.length() > 0 ? "": "style='display:none'")%>  title='<%=flgDesc%>' alt='<%=flgDesc%>'  />
						<%		} %>
								</span>
						<%
							}
						}
						%>						
						</td>
					</tr>
							
					
					<%
					}
					if(GdlnsList.size()>0)
					{
						%>
						<td class="update invisible"></td>
						</tr><td style="padding-top:5px;padding-left:50px;" class="lg" colspan="3"><strong>${guidelines}</strong></td></tr>
						<%
					}
					for(Standard gdln: GdlnsList)
					{
					%>
					
					<tr>
						<% if(whatsnewParam.equals("N")){%>
						<td class="update invisible" width="60px">
							<%if(gdln.getStatus()!=null && gdln.getStatus().equals("UPDATE")){ %>
							<span class="label label-warning">${update}</span>
							<%}else if(gdln.getStatus()!=null &&  gdln.getStatus().equals("NEW")){ %>
							<span class="label label-success">${newLabel}</span><%} %>
						</td>
					<%}else{%>
						<td class="update show" width="60px">
							<%if(gdln.getStatus()!=null && gdln.getStatus().equals("UPDATE")){ %>
							<span class="label label-warning">${update}</span>
							<%}else if(gdln.getStatus()!=null &&  gdln.getStatus().equals("NEW")){ %>
							<span class="label label-success">${newLabel}</span><%} %>
						</td>
						<%} %>
		
						<td class="bull lg">&bull; &nbsp;</td>
						<c:choose>
						<c:when test="<%=gdln.isSearchMatches()%>">
							<td class="lg" style="border-right:2px solid orange">
						</c:when>
						<c:otherwise>
							<td class="lg">
						</c:otherwise>
						</c:choose>
						<%=gdln.getDescription() %>&nbsp;[<%=gdln.getStdId() %>]
						<% if (gdln.isAttachmentExists() || gdln.isLinkExists()) {%>
							<span class="label label-info"><a href="javascript:supportingMaterialPopup('<%=gdln.getPublishStdId()%>')"><img alt="${supportingMaterialTitle}" title="${supportingMaterialTitle}"  src="/BSHotel-theme/images/PaperClip_white.png" style="height:14px; width:14px;"></a></span>
						<% }if (gdln.isImageExists()) {
								if ("IMG_MATCH".equals(gdln.getImageStatus())) { %>
						<span class="img-match orangeborder">
						<span class="label label-info"><a class="imageModalTrigger" title="${viewDetailsLink}" href="javascript:allMandatoryImagesPopup('<%=gdln.getPublishStdId()%>')" role="button">${viewDetailsLink}</a></span>
						</span>
						<%} else { %>
						<span class="label label-info"><a class="imageModalTrigger" title="${viewDetailsLink}" href="javascript:allMandatoryImagesPopup('<%=gdln.getPublishStdId()%>')" role="button">${viewDetailsLink}</a></span>
						<%}
						} else {%>
						<span>&nbsp;</span>
						<%}  
						  if (Validator.isNotNull(gdln.getStdRefId())) {
						%>
							<span class="label"><i class="icon-share-alt icon-white"></i>${referencedIds} [
						<%
							int count =0;    
							for (String refIds : gdln.getStdRefId().split(",")) {
							    if (count > 0) {
						%>
								,&nbsp;
						<%	        
							    }
						%>
								 <a href="#" class="grey" onclick='javascript:stdReferencePopup("<%=refIds %>")'><%=StringUtil.trim(refIds) %></a>
						<%	    
								count++;    
							}
						%>
							]</span>
						<%
							}
						%>
						
						<%/*CR 50.2 Added because We need to show only for Holiday inn Express*/
						if(!contentType.equals("OPERATE")) /*HLC icon shows for Build content*/ 
						{
							String displayGdlnHlc = "";
						    if (hotleLifeCycleParam.equals("Y")) 
							{
						    	displayGdlnHlc = "true";
							}
							if (Validator.isNotNull(gdln.getHotelLifeCycleFlags()) && gdln.getHotelLifeCycleFlags().size() > 0) 
							{
						%>
								<span class="whiteSpaceNowrap">
						<%	
								for(FlagCategory flgCatgy : htlLifeCycleFlags)
								{ 
								    String active = "";
								    if(gdln.getHotelLifeCycleFlags().containsKey(flgCatgy.getFlagCatId()))
								    {
								        active = "active";
								    }
									String flgDesc = obsmLanguageUtil.get("bs.flag." + flgCatgy.getFlagCatId()+".desc");
						%>
									<img src="<%=imagePath + flgCatgy.getFlagCatId() + (active.length() > 0 ? "_" + hotelCode: "") + ".jpg"%>" class='ht_icon_attr'  <%=(displayGdlnHlc.length() > 0 ? "": "style='display:none'")%>  title='<%=flgDesc%>' alt='<%=flgDesc%>'  />
						<%		} %>
								</span>
						<%
							}
						}
						%>
						</td>
					</tr>
								
					
					<%
					}
					previousTaxonomyId = standards.getTaxonomyId();
					%>
				</tbody>
			 </table>
		  <hr/>
		 </div><%
					}
				}
			
			 %>
			
			 </section>
	<section class="row">
		<div class="well well-small" style="margin-top: 5px;">
			<div class="row" style="margin-top: 5px;">
          		<%@include file="/html/paginationBottom.jsp" %>
        	</div>
        </div>
	</section>
</form>
	<div id="supportingMaterial_popup" style="display: none;"></div>
	<div id="allSupportingMaterial_popup" style="display: none;"></div>		
	<div id="createPDF_popup" style="display:none;"> </div>	
	<div id="searchModal" title="${searchOptions}" style="display:none;">	</div>
	<div id="mandatoryImages_popup" title="${images}" style="display:none;">	</div>
    <div id="helpModal" title="${searchStandardsHelp}" style="display:none;  overflow-y:auto;">	</div>
	<div id="stdReferenceDialog_popup" style="display: none;" title="${referenceTitle}"></div>
<script type="text/javascript">
var supportingMaterial = '${supportingMaterial}';
var allSupportingMaterial = '${allSupportingMaterial}';
var supportingMaterialTitle = '${supportingMaterialTitle}';
var allSupportingMaterialTitle = '${allSupportingMaterialTitle}';
var dialog = "";
var allMaterialdialog = "";
var createPDFPopupURL = '${createPDFPopupURL}';
var closeLabel = '${closeLabel}';
var createPDFLabel = '${createPDFLabel}';
var viewSearchModal = '${viewSearchModal}';
var createPDFDialog = "";
var mandatoryImages = '${mandatoryImages}';
var imagesDialog = '';
var viewDetails = '${viewDetails}';
var viewHelpModal = '${viewHelpModal}';
var showSearchOptions = ${showSearchOptions};
var stdReferenceDialog = '';
var referenceTitle = '${referenceTitle}';
var referenceStandards = '${referenceStandards}';
$(document).ready(function(){

	/*jQuery('#download-manual').attr('href',langCode);*/
	dialog = $( "#supportingMaterial_popup" ).dialog({
		title:supportingMaterialTitle,
		autoOpen: false,
		center:true,
		resizable:false,
		width: 717,
		 modal: true,
		open: function() {
	        $('.SupportingMatModalClose').bind('click', function() {
	            $('#supportingMaterial_popup').dialog('close');
	        })
	    }	
	});
	
	allMaterialdialog = $( "#allSupportingMaterial_popup" ).dialog({
    	title:allSupportingMaterialTitle,
		autoOpen: false,
		center:true,
		resizable:false,
    	width: 860,
    	 modal: true,
    	open: function() {
           $('#closePopUp').bind('click', function() {
                $('#allSupportingMaterial_popup').dialog('close');
            })
        }
	});

	createPDFDialog = $( "#createPDF_popup" ).dialog({
	    title: createPDFLabel,
	    closeText: closeLabel,
		autoOpen: false,
		center:true,
		resizable:false,
		width: 560,
		modal: true,
		open: function() {
	        $('.CreatePDFModalClose').bind('click', function() {
	            $('#createPDF_popup').dialog('close');
	        })
	    }
		/* beforeClose: function(event, ui) {
			$("body").css({ overflow: "inherit" })
		} */
		
	});
	
	var createSearchDialog =jQuery( "#searchModal" ).dialog({
		autoOpen: false,
		width: 865,
		resizable:false,
		modal: true
	});
	
	stdReferenceDialog = $( "#stdReferenceDialog_popup" ).dialog({
		title:referenceTitle,
		autoOpen: false,
		center:true,
		resizable:false,
		width: 717,
		 modal: true
	});
	
	$( ".searchoptionModal" ).click(function() {
		$.ajax({
		  	url :viewSearchModal,
		  	type: "POST",
		  	dataType: "text",
		    success: function(data) {
		    	if (data != null && data != '' && typeof data != 'undefined') {
		    		_gaq.push(['_trackEvent', 'Search Standards', "Open Dialog",  "Search Standards Dialog"]);
		    		$('#searchModal').html(data);
		    		createSearchDialog.dialog( "open" );
		    	}
		    }
		 });
	});
	
	
	var createHelpDialog = $( "#helpModal" ).dialog({
		autoOpen: false,
		width: 860,
		resizable:false,
		modal: true
	});
	
	$( ".helpModalbtn" ).click(function() {
		$.ajax({
		  	url :viewHelpModal,
		  	type: "POST",
		  	dataType: "text",
		    success: function(data) {
		    	if (data != null && data != '' && typeof data != 'undefined') {
		    		_gaq.push(['_trackEvent', 'Search Standards', "Open Dialog", "Help Dialog"]);
		    		$('#helpModal').html(data);
		    		createHelpDialog.dialog( "open" );
		    	}
		    }
		 });
	});	
	
	imagesDialog = $( "#mandatoryImages_popup" ).dialog({
		title:viewDetails,
		autoOpen: false,
		center:true,
		resizable:false,
		width: 717,
		modal: true
	});
	
	/*All support material help tooltip call*/

	$(".help-tooltip").tooltip({
	    items: "img, [data-geo], [title]",
	    content: function() {
	    var element = $( this );
	        if ( element.is( "[data-geo]" ) ) {
	        var title = element.attr( "title" );
	        var text = element.text();
	        return "<h3 class='tooltip-title'>"+text+"</h3><div class='tooltip-content'>"+title+"</div>";
	        }

	    },
	     position: {
	        my: "center bottom-20",
	        at: "center top",
	        using: function( position, feedback ) {
	        $( this ).css( position );
	        $( "<div>" )
	        .addClass( "arrow" )
	        .addClass( feedback.vertical )
	        .addClass( feedback.horizontal )
	        .appendTo( this );
	        }
	        }

	});
	highlightMe();
	if(showSearchOptions)
	{
		$.ajax({
		  	url :viewSearchModal,
		  	type: "POST",
		  	dataType: "text",
		    success: function(data) {
		    	if (data != null && data != '' && typeof data != 'undefined') {
		    		$('#searchModal').html(data);
		    		createSearchDialog.dialog( "open" );
		    	}
		    }
		 });
	}
});

function supportingMaterialPopup(stdId) {
	loadProgressBar();
	$.ajax({
	  	url :supportingMaterial,
	  	data:{"stdId":stdId},
	  	type: "POST",
	  	dataType: "text",
	    success: function(data) {
	    	if (data != null && data != '' && typeof data != 'undefined') {
	    		_gaq.push(['_trackEvent', 'Search Standards', "Open Dialog", "Supporting Material dialog for standard "+stdId]);
	    		$('#supportingMaterial_popup').html(data);
	    		dialog.dialog( "open" );
	    	}
	    	jQuery.unblockUI();
	    }
	 });
}

function stdReferencePopup(stdId) {
	loadProgressBar();
	$.ajax({
	  	url :referenceStandards,
	  	data:{"stdId":stdId},
	  	type: "POST",
	  	dataType: "text",
	    success: function(data) {
	    	if (data != null && data != '' && typeof data != 'undefined') {
	    		_gaq.push(['_trackEvent', 'Search Standards', "Open Dialog", "Standard reference dialog for standard "+stdId]);
	    		$('#stdReferenceDialog_popup').html(data);
	    		stdReferenceDialog.dialog( "open" );
	    	}
	    	jQuery.unblockUI();
	    }
	 });
}


function allSupportingMaterialPopup() {
	loadProgressBar();
	$.ajax({
	  	url :allSupportingMaterial,
	  	type: "POST",
	  	dataType: "text",
	    success: function(data) {
	    	
	    	if (data != null && data != '' && typeof data != 'undefined') {
	    		_gaq.push(['_trackEvent', 'Search Standards', "Open Dialog", "All Supporting Material dialog"]);
	    		$('#allSupportingMaterial_popup').html(data);
	    		allMaterialdialog.dialog( "open" );
	    	}
	    	jQuery.unblockUI();
	    }
	 });
}

function allMandatoryImagesPopup(stdId) {
	loadProgressBar();
	$.ajax({
	  	url :mandatoryImages,
	  	type: "POST",
	  	data: {"standardID":stdId},
	  	dataType: "text",
	    success: function(data) {
	    	
	    	if (data != null && data != '' && typeof data != 'undefined') {
	    		_gaq.push(['_trackEvent', 'Search Standards', "Open Dialog", "View Details Dialog for Standard "+stdId]);
	    		$('#mandatoryImages_popup').html(data);
	    		imagesDialog.dialog( "open" );
	    	}
	    	jQuery.unblockUI();
	    }
	 });
}

function createPDFPopup() {
	$.ajax({
	  	url :createPDFPopupURL,
	  	type: "POST",
	  	dataType: "text",
	    success: function(data) {
	    	if (data != null && data != '' && typeof data != 'undefined') {
	    		_gaq.push(['_trackEvent', 'Search Standards', "Open Dialog", "Create PDF Dialog"]);
	    		$('#createPDF_popup').html(data);
	    		createPDFDialog.dialog( "open" );
	    	}
	    }
    });
}

function loadProgressBar () {
	jQuery.blockUI({ message: '<h3><img src="/BSHotel-theme/images/busy.gif" /> </h3>' });
}
</script>