<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="javax.portlet.RenderRequest"%>
<%@include file="/html/whatChangedOn/init.jsp" %>

<portlet:resourceURL id='viewSearchModal' var="viewSearchModal">
	<portlet:param name="modalType" value="viewSearch" />
</portlet:resourceURL>
<portlet:resourceURL id='viewHelpModal' var="viewHelpModal">
	<portlet:param name="modalType" value="viewHelp" />
</portlet:resourceURL>
<portlet:actionURL var="varclearSearch" name="clearSearchAction" />
<portlet:resourceURL id='createPDFPopupURL' var ="createPDFPopupURL">
	<portlet:param name="modalType" value="createPDF" />
</portlet:resourceURL>

<%
	BSLanguageUtil obsmLanguageUtil = (BSLanguageUtil)session.getAttribute("obsmLanguageUtil");
	List<FlagCategory> htlLifeCycleFlags = FlagCategoryLocalServiceUtil.getFlagCategoryByParentId(91);
	String imagePath = "/BSHotel-portlet/images/";
	List<Standard> displayList = new ArrayList<Standard>();
	StandardsSearchCriteria criteria = null;
	String textSearchCriteria = (String)request.getAttribute("highlightSearchTexts");
	String searchCriteriaType = (String)request.getAttribute("searchCriteriaType");
	String idSearchCriteria = (String)request.getAttribute("highlightSearchIds");
	DateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
	if(session.getAttribute("whatChangedCriteria")!=null) {	
		criteria = (StandardsSearchCriteria)session.getAttribute("whatChangedCriteria");
	}
	String contentType = (String)request.getAttribute("contentType");
	String languageCode = (String)request.getAttribute("languageCode");
	String hotelCode = (String)request.getAttribute("hotelCode");
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
	String previousTextParam = (String)request.getAttribute("previousTextParam");
	String highlightParam = (String)request.getAttribute("highlightParam");
	String showCmplyParam = (String)request.getAttribute("showCmplyParam");
	String showLifecycleParam = (String)request.getAttribute("showLifecycleParam");
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
%>

<style type="text/css">
	.highlight {
		background-color: #f9e55b;
		color: black;
	}
	td.update {
		width: 80px;
		text-align: center;
	}
</style>

<script type="text/javascript">
	function cancelFilter() {
		var nodeObject = document.getElementById('<portlet:namespace/>clearFilter');
		nodeObject.value = "true";
		var frm  = document.getElementById('viewStandardsForm');
		//_gaq.push(['_trackEvent', 'What Changed On', 'Clear Search', 'What Changed On Clear Search']);
		document.viewStandardsForm.submit();
	}

	function highlightMe() 
	{
		var state=false;
		var txtCriteria = [<%=textSearchCriteria%>];
		var idCriteria = [<%=idSearchCriteria%>];
		var searchCriteriaType = "<%=searchCriteriaType%>";
		
		if ($('#showSearchHighlight').is(':checked')) 
		{
			for(var k = 0; k < txtCriteria.length; k++) 
			{
				if (searchCriteriaType == "all")
				{
					$("#standards").highlight(txtCriteria[k]);
				}
				else
				{
					$("#standards").highlight(txtCriteria[k], {wordsOnly : true});
				}
			}
			for(var l = 0; l < idCriteria.length; l++) 
			{
				$("#standards").highlight(idCriteria[l]);	
			}
			$(".update").unhighlight();
			state = true;
		} else 
		{
			$("#standards").unhighlight();	
			state = false;
		}
	}
	//Defect:8535 Resloved 
	function previousText() {
		if( $('#showPreviousText').is(':checked')) {
			$('.changeRow').attr('style','display: table-row');
			$('.showChange').text(closeChangeTxt);
			$(".showChange").toggleClass('showChange closeChange');
		} else {
			$('.changeRow').attr('style','display: none');
			$('.closeChange').text(showChangeTxt);
			$(".closeChange").toggleClass('closeChange showChange');
		}
		
	}
	
	function showCmplyDates() {
		if( $('#complianceDateCheckBox').is(':checked')) {
			$(".complianceDate").removeClass("invisible");
			$(".complianceDate").addClass("show_inline");
		} else {
			$(".complianceDate").removeClass("show_inline");
			$(".complianceDate").addClass("invisible");
		}
	}
	
	function showLifecycleIcons() {
		if( $('#showHotelLifeCycle').is(':checked')) {
			 $(".ht_icon_attr").css("display", 'inline-block');
		} else {
			 $(".ht_icon_attr").css("display", "none");
		}
	}
	
	function submitPagination(source, value) {	
		var pageNoValue = "";
		var itemsPageValue = "";
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
		var previousTextValue = 'N';
		var highlightValue = 'N';
		if( $('#showPreviousText').is(':checked')) {
			previousTextValue='Y';
		}
		if( $('#showSearchHighlight').is(':checked')) {
			highlightValue= 'Y';
		}
		window.location = submitUrl+"&previousText="+previousTextValue+"&highlight="+highlightValue;
	}
</script>

<form action="${varclearSearch}" method="post" name="viewStandardsForm" id="viewStandardsForm">
	<aui:input type="hidden" id="clearFilter" name="clearFilter" value="false"/>
	<div class="clearfix"></div>
	<div class="row">
		<div class="well well-small" style="margin-bottom:0px; padding:9px 9px 5px 9px;">
			<div class="row">
	          	<div class="span10">
		          	<% if(isSearch){ %>
						<div class="infoBar highlight" style="text-align:left"><%=displayMessage %></div>
					<% } else { %>
						<div class="infoBar" style="text-align:left"><%=displayMessage %></div>
					<% } %>
				</div>
				
				<div class="span2">
					<a href="#" class="pull-right btn btn-small btn-primary helpModalbtn ">
						<i class="icon-white icon-question-sign "></i> ${showSearchHelp}
					</a>
	            </div>
			</div>
			
			<div class="row" style="margin-top: 5px;">
				<div class="span6 form-inline">
					<a href="#"  class="btn btn-primary searchoptionModal">
						<i class="icon-white icon-search"></i> ${searchStandards} <b class="caret"></b>
					</a> 
					<% if(criteria != null) { %>
						<a href="#" class="btn" type="button" onmousedown="javascript:_gaq.push(['_trackEvent', 'What Changed On', 'Clear Search', 'What Changed On Clear Search']);" onclick="javascript:cancelFilter()">
							<i class="icon-remove"></i>&nbsp;${clearSearch}
						</a>
					<% } %>
					<div style="margin-top: 3px;"> </div>
				</div>
				<div class="span6">
					<div class="pull-right">
		             	<span style="font-size:14px; font-weight:bold; padding-bottom:8px; padding-top:3px;" 
		             		class="alert alert-small alert-warning alert-diagonals">${currPublicationDate}&nbsp;${publicationText}</span>
						<c:if test="${isActivePublish}">
							<a title="${createPDFLabel}" class="btn btn-primary createPDFModalbtn" href="javascript:createPDFPopup()">
								<i class="icon-white icon-print"></i> ${createPDFLabel}
							</a>
						</c:if>
	            	</div>
				</div>
			</div>
			<hr>
			<div class="row" style="margin-top: 5px;">
          		<%@include file="/html/paginationTop.jsp" %>
				<div class="span3">
            		<a href="#" class="btn pull-right btn-small" id="showHideDisplayOptions">${hideDisplayButton}</a>
				</div>
			</div>
          	<hr/>
          	
			<div class="row displayOptions show">
				<div class="form-inline">
	                <label class="checkbox"><strong>${DisplayOptions}:</strong></label>
	                <label class="checkbox">
		                <%	if("N".equals(showCmplyParam)) { %>
		                		<input type="checkbox" id="complianceDateCheckBox" name="complianceDateCheckBox" onchange="showCmplyDates()"> ${showFutureCompliance}
		                <%	} else { %>
		                  		<input type="checkbox" id="complianceDateCheckBox" name="complianceDateCheckBox" onchange="showCmplyDates()" checked="checked"> ${showFutureCompliance}
		                <% } %>
	                </label>
	                <label class="checkbox">
	                	<% if(!isSearch) { %>
	                		<input type="checkbox" id="showSearchHighlight" name="showSearchHighlight" onchange="highlightMe()" disabled> ${showSearchHighlight}
		                <% } else if("Y".equals(highlightParam)) { %>
		                 	<input type="checkbox" id="showSearchHighlight" name="showSearchHighlight" onchange="highlightMe()" checked="checked"> ${showSearchHighlight}
		                <% } else { %>
		                  	<input type="checkbox" id="showSearchHighlight" name="showSearchHighlight" onchange="highlightMe()"> ${showSearchHighlight}
		                <% } %>
	                </label>
	                <label class="checkbox">
	                	<% if("Y".equals(previousTextParam)){ %>
	                 		<input type="checkbox"  id="showPreviousText" name="showPreviousText" onchange="previousText()" checked="checked"> ${showPreviousText}
	                 	<% } else {  %>
	                  		<input type="checkbox" id="showPreviousText" name="showPreviousText" onchange="previousText()" > ${showPreviousText}
	                 	<% } %>
	                </label>
	                <% 	/* Hotel Lifecycle show only for EX Brand */
                  		if(!"OPERATE".equals(contentType)) { /* HLC icon shows for Build content */ 
              	  	%> 
	                <label class="checkbox">
	                	<%	if("N".equals(showLifecycleParam)) { %>
	                 		<input type="checkbox" id="showHotelLifeCycle" name="showHotelLifeCycle" onchange="showLifecycleIcons()" > ${showHotelLifeCycle}   
	                	<%	} else { %>
	                  		<input type="checkbox" id="showHotelLifeCycle" name="showHotelLifeCycle" onchange="showLifecycleIcons()"  checked="checked"> ${showHotelLifeCycle}
	                	<%	} %>
	                </label>
	            	<%	} %>  
					<div class="clearfix"></div>
				</div>
			</div>
			<hr/>
			
			<div class="row displayOptions show">
				<div class="form-inline">
					<strong>${iconLegendHeading}:</strong>
					<span class="label label-warning" style="margin-left:15px;">T</span> ${textUpdate}
					<span class="label label-warning" style="margin-left:15px;">C</span> ${complianceUpdate}
					<span class="label label-warning" style="margin-left:15px;">L</span> ${lifecycleUpdate}
					<%-- <span class="label label label-important" style="margin-left:15px;">${filterByRemoved}</span> ${removedUpdate} --%>
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
			if(previousTaxonomyId != standards.getTaxonomyId()) {
				String indexPath = standards.getTaxonomyPath();
				String currentIndex = standards.getTaxonomyText();
				if (indexPath != null && indexPath.contains(currentIndex)) {
					indexPath = indexPath.replace(currentIndex, "");
%>
					<div class="row">
						<h4><span class="grey"><%=indexPath %></span> <span class="blue"><%= currentIndex%></span></h4>
						<div style="padding-left:10%;color:#058844;"><%= (Validator.isNotNull(standards.getTaxonomyDesc()) ? standards.getTaxonomyDesc() : "") %></div>
					</div>
<%				} else { %>
					<div class="row">
						<h4><span class="grey"><%=standards.getTaxonomyPath() %></span></h4>
						<div style="padding-left:10%;color:#058844;"><%= (Validator.isNotNull(standards.getTaxonomyDesc()) ? standards.getTaxonomyDesc() : "") %></div>
					</div>
<% 				} 
			}
%>
		<div class="row">
			<table border="0" class="specs">
			<tbody>
			<!-- ################################## Standard Display ####################################################### -->	
				<tr >	
					<td class="update show" width="50px">
						<% if("CHANGED".equals(standards.getChangedStatus())){ %>
						<span class="label label-warning">${changed}</span>
						<% } else if("UPDATE".equals(standards.getChangedStatus())){ %>
						<span class="label label-warning">${update}</span>
						<% } else if("NEW".equals(standards.getChangedStatus())){ %>
						<span class="label label-success">${newLabel}</span> 
						<% } else if("REMOVED".equals(standards.getChangedStatus())){ %>
							<span class="label label-important">${filterByRemoved}</span>
						<% } %>
					</td>
					<td colspan="3" width="910px">
					<% if("REMOVED".equals(standards.getChangedStatus())){ %>
					<del>
					<% } %>
						<strong><%=standards.getTitle()%></strong>&nbsp;
						<span class="grey">[<%=standards.getStdId()%>]</span>
						<!-- Display Standard Compliance & Expiry Date  -->
						<%	if(Validator.isNotNull(standards.getComplianceDate())) {
								String dateValue = standards.getComplianceDate();
								if (Validator.isNotNull(languageCode)) {
									dateValue = BrandStandardsUtil.getFormatedDate(formatter.parse(standards.getComplianceDate()), languageCode, obsmLanguageUtil);
								}
								if("N".equals(showCmplyParam)) {
						%>
								<span class="complianceDate invisible label label-info"><%=dateValue %></span>
						<%		} else { %>
								<span class="complianceDate show_inline label label-info"><%=dateValue %></span>
						<%		}
							}
							if(Validator.isNotNull(standards.getExpiryDate())){
								String dateValue = standards.getExpiryDate();
								if (Validator.isNotNull(languageCode)) {
									dateValue = BrandStandardsUtil.getFormatedDate(formatter.parse(standards.getExpiryDate()), languageCode, obsmLanguageUtil);
								}
						%>
							<span class="expiryDate show_inline label label-inverse">${expiresTxt} | <%=dateValue %></span>
						<%	} %>
						<!-- Display Standard Hotel Life Cycle Icons  -->
						<%	//HLC icon shows for Build content 
						if(!"OPERATE".equals(contentType)) { 
							String display = "";
						    if ("Y".equals(showLifecycleParam))  {
						        display = "true";
							}
							if (Validator.isNotNull(standards.getHotelLifeCycleFlags()) && standards.getHotelLifeCycleFlags().size() > 0) {
						%>
								<span class="whiteSpaceNowrap">
						<%		for(FlagCategory flgCatgy : htlLifeCycleFlags) { 
									String active = "";
								    if(standards.getHotelLifeCycleFlags().containsKey(flgCatgy.getFlagCatId())) {
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
						<!-- Displaying Show Change Button/Label -->
						<% if("CHANGED".equals(standards.getChangedStatus())){ %>
							<span class="label showChange" id="showTxt<%=standards.getStdId()%>" onclick="javascript:changeShowLabel(<%=standards.getStdId()%>)">${showChange}</span>
						<% } %>
					<% if("REMOVED".equals(standards.getChangedStatus())){ %>
					</del>
					<% } %>
					</td>
				</tr>
				<!-- Below row is to show Previous text incase of Update status -->
				<% if("CHANGED".equals(standards.getChangedStatus())){ %>
				<tr class="changeRow" id="changeRow<%=standards.getStdId()%>">
	              	<td class="update">
	              	<% 	if(standards.isTextUpdated()) { %>
	              		<span class="label label-warning" title="${textUpdate}">T</span>
	              	<% 	} 
	              		if(standards.isComplianceUpdated()){ 
	              	%>
	              		<span class="label label-warning" title="${complianceUpdate}">C</span>
	              	<% 	} 
	              		if(standards.isLifecycleUpdated()){ 
	              	%>
	              		<span class="label label-warning" title="${lifecycleUpdate}">L</span>
	              	<%	} %>
	              	</td>
	              	<td colspan="3" >
						<div class="highlighted_content">
							<strong><%=standards.getPrevTitleText()%></strong>&nbsp;
							<span class="grey">[<%=standards.getStdId()%>]</span>
							<!-- Display Standard Previous Compliance & Expiry Date  -->
						<%	if(Validator.isNotNull(standards.getPrevCmplyDate())) {
								String dateValue = formatter.format(standards.getPrevCmplyDate());
								if (Validator.isNotNull(languageCode)) {
									dateValue = BrandStandardsUtil.getFormatedDate(standards.getPrevCmplyDate(), languageCode, obsmLanguageUtil);
								}
								if("N".equals(showCmplyParam)) {
						%>
									<span class="complianceDate invisible label label-gray"><%=dateValue %></span>
						<%		} else { %>
									<span class="complianceDate show_inline label label-gray"><%=dateValue %></span>
						<%		}
							}
							if(Validator.isNotNull(standards.getPrevExpiryDate())){
								String dateValue = formatter.format(standards.getPrevExpiryDate());
								if (Validator.isNotNull(languageCode)) {
									dateValue = BrandStandardsUtil.getFormatedDate(standards.getPrevExpiryDate(), languageCode, obsmLanguageUtil);
								}
						%>
							<span class="expiryDate show_inline label label-gray">${expiresTxt} | <%=dateValue %></span>
						<%	} %>
						<!-- Display Standard Previous Hotel Life Cycle Icons  -->
						<%	//HLC icon shows for Build content 
						if(!"OPERATE".equals(contentType)) { 
							String display = "";
						    if ("Y".equals(showLifecycleParam))  {
						        display = "true";
							}
							if (Validator.isNotNull(standards.getPrevHotelLifeCycleFlags()) && standards.getPrevHotelLifeCycleFlags().size() > 0) {
						%>
								<span class="whiteSpaceNowrap">
						<%		for(FlagCategory flgCatgy : htlLifeCycleFlags) { 
									String active = "";
								    if(standards.getPrevHotelLifeCycleFlags().containsKey(flgCatgy.getFlagCatId())) {
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
							<span class="label label-gray">${validText}&nbsp;${prevPublicationDate}&nbsp;-&nbsp;${currPublicationDate}</span>
						</div>
	              	</td>
	            </tr>
				<% } %>
			<!-- ################################## Specification Display ####################################################### -->	
			<% for(Standard specs: SpecsList) { %>
				<tr >
					<td class="update show">
						<% if("CHANGED".equals(specs.getChangedStatus())){ %>
							<span class="label label-warning">${changed}</span>
						<% } else if("UPDATE".equals(specs.getChangedStatus())){ %>
							<span class="label label-warning">${update}</span>
						<% } else if("NEW".equals(specs.getChangedStatus())){ %>
								<span class="label label-success">${newLabel}</span>
						<% } else if("REMOVED".equals(specs.getChangedStatus())){ %>
								<span class="label label-important">${filterByRemoved}</span>
						<% } %>
					</td>
					<td class="bull">&bull;&nbsp; </td>
					<td>
					<% if("REMOVED".equals(specs.getChangedStatus())){ %>
					<del>
					<% } %>
						<%=specs.getTitle() %><span class="grey">&nbsp;[<%=specs.getStdId() %>] </span>
						<!-- Display Sepc Compliance & Expiry Date  -->
						<%	if(Validator.isNotNull(specs.getComplianceDate())) {
								String dateValue = specs.getComplianceDate();
								if (Validator.isNotNull(languageCode)) {
									dateValue = BrandStandardsUtil.getFormatedDate(formatter.parse(specs.getComplianceDate()), languageCode, obsmLanguageUtil);
								}
								if("N".equals(showCmplyParam)) {
						%>
								<span class="complianceDate invisible label label-info"><%=dateValue %></span>
						<%		} else { %>
								<span class="complianceDate show_inline label label-info"><%=dateValue %></span>
						<%		}
							}
							if(Validator.isNotNull(specs.getExpiryDate())){
								String dateValue = specs.getExpiryDate();
								if (Validator.isNotNull(languageCode)) {
									dateValue = BrandStandardsUtil.getFormatedDate(formatter.parse(specs.getExpiryDate()), languageCode, obsmLanguageUtil);
								}
						%>
							<span class="expiryDate show_inline label label-inverse">${expiresTxt} | <%=dateValue %></span>
						<%	} %>
						<!-- Display Spec Hotel Life Cycle Icons  -->
						<%	//HLC icon shows for Build content 
						if(!"OPERATE".equals(contentType)) { 
							String display = "";
						    if ("Y".equals(showLifecycleParam))  {
						        display = "true";
							}
							if (Validator.isNotNull(specs.getHotelLifeCycleFlags()) && specs.getHotelLifeCycleFlags().size() > 0) {
						%>
								<span class="whiteSpaceNowrap">
						<%		for(FlagCategory flgCatgy : htlLifeCycleFlags) { 
									String active = "";
								    if(specs.getHotelLifeCycleFlags().containsKey(flgCatgy.getFlagCatId())) {
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
						<!-- Displaying Show Change Button/Label -->
						<% if("CHANGED".equals(specs.getChangedStatus())){ %>
							<span class="label showChange" id="showTxt<%=specs.getStdId()%>" onclick="javascript:changeShowLabel(<%=specs.getStdId()%>)">${showChange}</span>
						<% } %>
					<% if("REMOVED".equals(specs.getChangedStatus())){ %>
					</del>
					<% } %>
					</td>
				</tr>
				<!-- Below row is to show Previous text incase of Update status -->
				<% if("CHANGED".equals(specs.getChangedStatus())){ %>
				<tr class="changeRow" id="changeRow<%=specs.getStdId()%>">
	              	<td class="update">
	              	<% 	if(specs.isTextUpdated()) { %>
	              		<span class="label label-warning" title="${textUpdate}">T</span>
	              	<% 	} 
	              		if(specs.isComplianceUpdated()){ 
	              	%>
	              		<span class="label label-warning" title="${complianceUpdate}">C</span>
	              	<% 	} 
	              		if(specs.isLifecycleUpdated()){ 
	              	%>
	              		<span class="label label-warning" title="${lifecycleUpdate}">L</span>
	              	<%	} %>
	              	</td>
	              	<td class="bull">&bull;&nbsp; </td>
	              	<td>
						<div class="highlighted_content">
							<%=specs.getPrevTitleText() %><span class="grey">&nbsp;[<%=specs.getStdId() %>]</span>
							<!-- Display Spec Previous Compliance & Expiry Date  -->
						<%	if(Validator.isNotNull(specs.getPrevCmplyDate())) {
								String dateValue = formatter.format(specs.getPrevCmplyDate());
								if (Validator.isNotNull(languageCode)) {
									dateValue = BrandStandardsUtil.getFormatedDate(specs.getPrevCmplyDate(), languageCode, obsmLanguageUtil);
								}
								if("N".equals(showCmplyParam)) {
						%>
									<span class="complianceDate invisible label label-gray"><%=dateValue %></span>
						<%		} else { %>
									<span class="complianceDate show_inline label label-gray"><%=dateValue %></span>
						<%		}
							}
							if(Validator.isNotNull(specs.getPrevExpiryDate())){
								String dateValue = formatter.format(specs.getPrevExpiryDate());
								if (Validator.isNotNull(languageCode)) {
									dateValue = BrandStandardsUtil.getFormatedDate(specs.getPrevExpiryDate(), languageCode, obsmLanguageUtil);
								}
						%>
							<span class="expiryDate show_inline label label-gray">${expiresTxt} | <%=dateValue %></span>
						<%	} %>
						<!-- Display Spec Previous Hotel Life Cycle Icons  -->
						<%	//HLC icon shows for Build content 
						if(!"OPERATE".equals(contentType)) { 
							String display = "";
						    if ("Y".equals(showLifecycleParam))  {
						        display = "true";
							}
							if (Validator.isNotNull(specs.getPrevHotelLifeCycleFlags()) && specs.getPrevHotelLifeCycleFlags().size() > 0) {
						%>
								<span class="whiteSpaceNowrap">
						<%		for(FlagCategory flgCatgy : htlLifeCycleFlags) { 
									String active = "";
								    if(specs.getPrevHotelLifeCycleFlags().containsKey(flgCatgy.getFlagCatId())) {
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
							<span class="label label-gray">${validText}&nbsp;${prevPublicationDate}&nbsp;-&nbsp;${currPublicationDate}</span>
						</div>
	              	</td>
	            </tr>
				<% } %>
			<!-- ################################## Guideline Display ####################################################### -->	
			<% } if(GdlnsList.size() > 0) { %>
				<tr>
					<td class="update invisible"></td>
				</tr>
				<tr>
					<td style="padding-top:5px;padding-left:50px;" class="lg" colspan="3">
						<strong>${guidelines}</strong>
					</td>
				</tr>
			<% }
			   for(Standard gdln: GdlnsList) {
			%>
				<tr>
					<td class="update show">
						<% if("CHANGED".equals(gdln.getChangedStatus())){ %>
							<span class="label label-warning">${changed}</span>
						<% } else if("UPDATE".equals(gdln.getChangedStatus())){ %>
							<span class="label label-warning">${update}</span>
						<% } else if("NEW".equals(gdln.getChangedStatus())){ %>
							<span class="label label-success">${newLabel}</span>
						<% } else if("REMOVED".equals(gdln.getChangedStatus())){ %>
							<span class="label label-important">${filterByRemoved}</span>
						<% } %>
					</td>
					<td class="bull lg">&bull; &nbsp;</td>
					<td  class="lg ">
					<% if("REMOVED".equals(gdln.getChangedStatus())){ %>
					<del>
					<% } %>
						<%=gdln.getDescription() %>&nbsp;[<%=gdln.getStdId() %>]
						<!-- Display Guideline Compliance & Expiry Date  -->
						<%	if(Validator.isNotNull(gdln.getComplianceDate())) {
								String dateValue = gdln.getComplianceDate();
								if (Validator.isNotNull(languageCode)) {
									dateValue = BrandStandardsUtil.getFormatedDate(formatter.parse(gdln.getComplianceDate()), languageCode, obsmLanguageUtil);
								}
								if("N".equals(showCmplyParam)) {
						%>
								<span class="complianceDate invisible label label-info"><%=dateValue %></span>
						<%		} else { %>
								<span class="complianceDate show_inline label label-info"><%=dateValue %></span>
						<%		}
							}
							if(Validator.isNotNull(gdln.getExpiryDate())){
								String dateValue = gdln.getExpiryDate();
								if (Validator.isNotNull(languageCode)) {
									dateValue = BrandStandardsUtil.getFormatedDate(formatter.parse(gdln.getExpiryDate()), languageCode, obsmLanguageUtil);
								}
						%>
							<span class="expiryDate show_inline label label-inverse">${expiresTxt} | <%=dateValue %></span>
						<%	} %>
						<!-- Display Guideline Hotel Life Cycle Icons  -->
						<%	//HLC icon shows for Build content 
						if(!"OPERATE".equals(contentType)) { 
							String display = "";
						    if ("Y".equals(showLifecycleParam))  {
						        display = "true";
							}
							if (Validator.isNotNull(gdln.getHotelLifeCycleFlags()) && gdln.getHotelLifeCycleFlags().size() > 0) {
						%>
								<span class="whiteSpaceNowrap">
						<%		for(FlagCategory flgCatgy : htlLifeCycleFlags) { 
									String active = "";
								    if(gdln.getHotelLifeCycleFlags().containsKey(flgCatgy.getFlagCatId())) {
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
						<!-- Displaying Show Change Button/Label -->
						<% if("CHANGED".equals(gdln.getChangedStatus())){  %>
							<span class="label showChange" id="showTxt<%=gdln.getStdId()%>" onclick="javascript:changeShowLabel(<%=gdln.getStdId()%>)">${showChange}</span>
						<% } %>
					<% if("REMOVED".equals(gdln.getChangedStatus())){ %>
					</del>
					<% } %>
					</td>
				</tr>
				<!-- Below row is to show Previous text incase of Update status -->
				<% if("CHANGED".equals(gdln.getChangedStatus())){  %>
				<tr class="changeRow" id="changeRow<%=gdln.getStdId()%>">
	              	<td class="update">
	              	<% 	if(gdln.isTextUpdated()) { %>
	              		<span class="label label-warning" title="${textUpdate}">T</span>
	              	<% 	} 
	              		if(gdln.isLifecycleUpdated()){ 
	              	%>
	              		<span class="label label-warning" title="${lifecycleUpdate}">L</span>
	              	<%	} %>
	              	</td>
	              	<td class="bull lg">&bull; &nbsp;</td>
				  	<td  class="lg ">
						<div class="highlighted_content">
							<%=gdln.getPrevDescription() %>&nbsp;[<%=gdln.getStdId() %>]
							<!-- Display Guideline Previous Compliance & Expiry Date  -->
						<%	if(Validator.isNotNull(gdln.getPrevCmplyDate())) {
								String dateValue = formatter.format(gdln.getPrevCmplyDate());
								if (Validator.isNotNull(languageCode)) {
									dateValue = BrandStandardsUtil.getFormatedDate(gdln.getPrevCmplyDate(), languageCode, obsmLanguageUtil);
								}
								if("N".equals(showCmplyParam)) {
						%>
									<%-- <span class="complianceDate invisible label label-gray"><%=dateValue %></span> --%>
						<%		} else { %>
									<%-- <span class="complianceDate show_inline label label-gray"><%=dateValue %></span> --%>
						<%		}
							}
							if(Validator.isNotNull(gdln.getPrevExpiryDate())){
								String dateValue = formatter.format(gdln.getPrevExpiryDate());
								if (Validator.isNotNull(languageCode)) {
									dateValue = BrandStandardsUtil.getFormatedDate(gdln.getPrevExpiryDate(), languageCode, obsmLanguageUtil);
								}
						%>
							<%-- <span class="expiryDate show_inline label label-gray">${expiresTxt} | <%=dateValue %></span> --%>
						<%	} %>
						<!-- Display Guideline Previous Hotel Life Cycle Icons  -->
						<%	//HLC icon shows for Build content 
						if(!"OPERATE".equals(contentType)) { 
							String display = "";
						    if ("Y".equals(showLifecycleParam))  {
						        display = "true";
							}
							if (Validator.isNotNull(gdln.getPrevHotelLifeCycleFlags()) && gdln.getPrevHotelLifeCycleFlags().size() > 0) {
						%>
								<span class="whiteSpaceNowrap">
						<%		for(FlagCategory flgCatgy : htlLifeCycleFlags) { 
									String active = "";
								    if(gdln.getPrevHotelLifeCycleFlags().containsKey(flgCatgy.getFlagCatId())) {
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
							<span class="label label-gray">${validText}&nbsp;${prevPublicationDate}&nbsp;-&nbsp;${currPublicationDate}</span>
						</div>
	              	</td>
	            </tr>
			<% 	   }
			} 
			previousTaxonomyId = standards.getTaxonomyId(); 
			%>
			</tbody>
			</table>
			<hr/>
		</div>
<%
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

<div id="searchModal" title="${searchOptions}" style="display:none;"></div>
<div id="helpModal" title="${searchStandardsHelp }" style="display:none;  overflow-y:auto;"></div>
<div id="createPDF_popup" style="display:none;"> </div>

<script type="text/javascript">
	var dialog = "";
	var viewSearchModal = '${viewSearchModal}';
	var viewHelpModal = '${viewHelpModal}';
	var createPDFPopupURL = '${createPDFPopupURL}';
	var showDisplayButton = "${showDisplayButton}";
	var hideDisplayButton = "${hideDisplayButton}";
	var searchOptions = "${searchOptions}";
	var closeLabel = "${closeLabel}";
	var createPDFLabel = '${createPDFLabel}';
	var createPDFDialog = "";
	var showChangeTxt = '${showChange}';
	var closeChangeTxt = '${closeChange}';
	$(document).ready(function(){
		//Defect:8535 Resloved 
		if( $('#showPreviousText').is(':checked')) {
			$('.changeRow').attr('style','display: table-row');
		}else{
			$('.changeRow').attr('style','display: none');
		}
		if(navigator.appName == "Microsoft Internet Explorer") {
		    $(function() {
		      $('input:radio, input:checkbox').click(function() {
		        this.blur();
		        this.focus();
		      });
		    });
		}
		
		$('#showHideDisplayOptions').click(function (e) {
		    e.preventDefault();
		    $('.displayOptions').toggle().toggleClass("show");
		    if ($('.displayOptions').hasClass("show")) {
		      $(e.delegateTarget).text(hideDisplayButton);
		    } else {
		      $(e.delegateTarget).text(showDisplayButton);
		    }
		});
		
		var createSearchDialog =jQuery( "#searchModal" ).dialog({
			title: searchOptions,
		    closeText: closeLabel,
			autoOpen: false,
			center:true,
			resizable:false,
			width: 865,
			modal: true
		});
		
		$(".searchoptionModal").click(function() {
			$.ajax({
			  	url :viewSearchModal,
			  	type: "POST",
			  	dataType: "text",
			    success: function(data) {
			    	if (data != null && data != '' && typeof data != 'undefined') {
			    		_gaq.push(['_trackEvent', 'What Changed On', 'Open Dialog',  'What Changed On Search Dialog']);
			    		$('#searchModal').html(data);
			    		createSearchDialog.dialog( "open" );
			    	}
			    }
			 });
		});
		
		var createHelpDialog = $( "#helpModal" ).dialog({
			autoOpen: false,
			center:true,
			resizable:false,
			width: 860,
			modal: true
		});
		
		$(".helpModalbtn").click(function() {
			$.ajax({
			  	url :viewHelpModal,
			  	type: "POST",
			  	dataType: "text",
			    success: function(data) {
			    	if (data != null && data != '' && typeof data != 'undefined') {
			    		_gaq.push(['_trackEvent', 'What Changed On', 'Open Dialog', 'What Changed On Help Dialog']);
			    		$('#helpModal').html(data);
			    		createHelpDialog.dialog( "open" );
			    	}
			    }
			 });
		});	
		
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
		
		createPDFDialog = $("#createPDF_popup").dialog({
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
		});
		highlightMe();
	});
	
	function createPDFPopup() {
		$.ajax({
		  	url :createPDFPopupURL,
		  	type: "POST",
		  	dataType: "text",
		    success: function(data) {
		    	if (data != null && data != '' && typeof data != 'undefined') {
		    		_gaq.push(['_trackEvent', 'What Changed On', "Open Dialog", "Create PDF Dialog"]);
		    		$('#createPDF_popup').html(data);
		    		createPDFDialog.dialog("open");
		    	}
		    }
	    });
	}
	
	function changeShowLabel(stdId){
		$('#changeRow'+stdId).toggle();
		if ($('#showTxt'+stdId).hasClass("showChange")) {
			$('#showTxt'+stdId).removeClass('showChange');
			$('#showTxt'+stdId).addClass('closeChange');
			$('#showTxt'+stdId).text(closeChangeTxt);
		} else {
			$('#showTxt'+stdId).removeClass('closeChange');
			$('#showTxt'+stdId).addClass('showChange');
			$('#showTxt'+stdId).text(showChangeTxt);
		}
		return false;
	}
</script>