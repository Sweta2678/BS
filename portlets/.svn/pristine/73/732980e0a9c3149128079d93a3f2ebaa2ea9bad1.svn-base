<%@include file="/html/whatChangedOn/init.jsp" %>
<portlet:actionURL var="varSearchStandards" name="searchStandards" />

<%
	StandardsSearchCriteria stdSearchCriteria = (StandardsSearchCriteria) session.getAttribute("whatChangedCriteria");
	boolean isSearchOn = false;
	if(stdSearchCriteria != null && stdSearchCriteria.isSearch()) {
	    isSearchOn = true;
	}
	List<String> arlHoteLifecycle = stdSearchCriteria == null ? null : stdSearchCriteria.getHotelLifecycle();
	List<String> arlSpecialism = stdSearchCriteria == null ? null : stdSearchCriteria.getSpecialism();
	List<String> arlDeptApplicability = stdSearchCriteria == null ? null : stdSearchCriteria.getDeptApplicability();
	List<String> arlGuestJourney = stdSearchCriteria == null ? null : stdSearchCriteria.getGuestJourney();
	List<String> arlLocHotel = stdSearchCriteria == null ? null : stdSearchCriteria.getLocHotel();
	List<String> arlFlags = stdSearchCriteria == null ? null : stdSearchCriteria.getFlags();
	
	String strSearchOptions = stdSearchCriteria == null ? "" : stdSearchCriteria.getTextSearchType(); 
	String strFilterByNew = stdSearchCriteria == null ? "Y" : stdSearchCriteria.isFilterByNew() ? "Y" : "N";
	String strFilterByUpdated = stdSearchCriteria == null ? "Y" : stdSearchCriteria.isFilterByUpdated() ? "Y" : "N";
	String strFilterByTextUpdate = stdSearchCriteria == null ? "Y" : stdSearchCriteria.isFilterByTextUpdate() ? "Y" : "N";
	String strFilterByComplianceUpdate = stdSearchCriteria == null ? "Y" : stdSearchCriteria.isFilterByComplianceUpdate() ? "Y" : "N";
	String strFilterByLifecycleUpdate = stdSearchCriteria == null ? "Y" : stdSearchCriteria.isFilterByLifecycleUpdate() ? "Y" : "N";
	String strFilterByRemoved = stdSearchCriteria == null ? "Y" : stdSearchCriteria.isFilterByRemoved() ? "Y" : "N";
	String strSearchText = stdSearchCriteria == null ? "" : stdSearchCriteria.getTextSearch();
	String contentType = request.getAttribute("contentType") != null ? (String)request.getAttribute("contentType") : null; 
	
	if(strSearchOptions == null || strSearchOptions.length() == 0) {
		strSearchOptions = "all";	
	}
	if(strSearchText == null) {
		strSearchText = "";	
	}
	String brandCode = (String)request.getAttribute("hotelCode");
	String imagePath = "/BSHotel-portlet/images/";
%>

<link type="text/css" rel="stylesheet" href="/BSHotel-theme/css/tooltip.css"/>

<script>
	var filtersLabel = "${filtersLabel}";
	var filterLabel = "${filterLabel}";
	var filtersApply = "${filtersApply}";
	var filterApply = "${filterApply}";
	
	$(document).ready(function(){
		$("#searchstandardaccordion").accordion({
		        collapsible: true,
		        active: false,
		        heightStyle: "content"
		 });
		
		  $('#hotelLifecycleGroupAll').on('click', function (e) {
		      $(".hotelLifecycleGroup").find("input:checkbox").each(function() { 
		          if(!$(this).prop('checked') && !$(this).prop('disabled')) { 
		            $(this).prop('checked','checked');
		            $(this).change();
		          } 
		      });
		  });

		  $('#hotelLifecycleGroupNone').on('click', function (e) {
		      $(".hotelLifecycleGroup").find("input:checkbox").each(function() { 
		          $(this).prop('checked', '');
		          $(this).change();
		      });
		  });

		  $('#specialismGroupAll').on('click', function (e) {
		      $(".specialismGroup").find("input:checkbox").each(function() { 
		          if(!$(this).prop('checked') && !$(this).prop('disabled')) { 
		            $(this).prop('checked','checked');
		            $(this).change();
		          } 
		      });
		  });

		  $('#specialismGroupNone').on('click', function (e) {
		      $(".specialismGroup").find("input:checkbox").each(function() { 
		          $(this).prop('checked', '');
		          $(this).change();
		      });
		  });

		  $('#hotelDeptGroupAll').on('click', function (e) {
		      $(".hotelDeptGroup").find("input:checkbox").each(function() { 
		          if(!$(this).prop('checked') && !$(this).prop('disabled')) { 
		            $(this).prop('checked','checked');
		            $(this).change();
		          } 
		      });
		  });
	
		  $('#supportingMaterialGroupAll').on('click', function (e) {
		      $(".supportingMaterialGroup").find("input:checkbox").each(function() { 
		          if(!$(this).prop('checked')) { 
		            $(this).prop('checked','checked');
		            $(this).change();
		          } 
		      });
		  });
	
		  $('#supportingMaterialGroupNone').on('click', function (e) {
		      $(".supportingMaterialGroup").find("input:checkbox").each(function() { 
		          $(this).prop('checked', '');
		          $(this).change();
		      });
		  });
	
		  $('#hotelDeptGroupNone').on('click', function (e) {
		      $(".hotelDeptGroup").find("input:checkbox").each(function() { 
		          $(this).prop('checked', '');
		          $(this).change();
		      });
		  });
	
		  $('#hotelLocationGroupAll').on('click', function (e) {
		      $(".hotelLocationGroup").find("input:checkbox").each(function() { 
		          if(!$(this).prop('checked') && !$(this).prop('disabled')) { 
		            $(this).prop('checked','checked');
		            $(this).change();
		          } 
		      });
		  });
	
		  $('#hotelLocationGroupNone').on('click', function (e) {
		      $(".hotelLocationGroup").find("input:checkbox").each(function() { 
		          $(this).prop('checked', '');
		          $(this).change();
		      });
		  });
	
		  $('#guestJourneyGroupAll').on('click', function (e) {
		      $(".guestJourneyGroup").find("input:checkbox").each(function() { 
		          if(!$(this).prop('checked') && !$(this).prop('disabled')) { 
		            $(this).prop('checked','checked');
		            $(this).change();
		          } 
		      });
		  });
	
		  $('#guestJourneyGroupNone').on('click', function (e) {
		      $(".guestJourneyGroup").find("input:checkbox").each(function() { 
		          $(this).prop('checked', '');
		          $(this).change();
		      });
		  });
	
		$('.clearSearch').on('click', function (e) {
			$('#filterText').val("");
			
			$(".hotelLifecycleGroup").find("input:checkbox").each(function() { 
		          $(this).prop('checked', '');
		          $(this).change();
		      });
			$(".specialismGroup").find("input:checkbox").each(function() { 
		          $(this).prop('checked', '');
		          $(this).change();
		      });
			$(".hotelLocationGroup").find("input:checkbox").each(function() { 
		          $(this).prop('checked', '');
		          $(this).change();
		      });
			$(".guestJourneyGroup").find("input:checkbox").each(function() { 
		          $(this).prop('checked', '');
		          $(this).change();
		      });
			$(".hotelDeptGroup").find("input:checkbox").each(function() { 
		          $(this).prop('checked', '');
		          $(this).change();
		      });
			$(".supportingMaterialGroup").find("input:checkbox").each(function() { 
		          $(this).prop('checked', '');
		          $(this).change();
		      });
			 updateFiltersTotal();
		});

		function updateFiltersTotal() {
			var hotelLife = $('.hotelLifecycleGroup input').filter(':checked').length || 0;
			var specialism = $('.specialismGroup input').filter(':checked').length || 0;
			var hotelDept = $('.hotelDeptGroup input').filter(':checked').length || 0;
		  	var hotelLoc = $('.hotelLocationGroup input').filter(':checked').length || 0;
		  	var gjs = $('.guestJourneyGroup input').filter(':checked').length || 0;
		  	var suppMat = $('.supportingMaterialGroup input').filter(':checked').length || 0;
		  	var total = parseInt(hotelLife, 10) + parseInt(specialism, 10) + parseInt(hotelDept, 10) + parseInt(hotelLoc, 10) + parseInt(gjs, 10)+ parseInt(suppMat, 10);
		  	if (total == 0 || total > 1) {
		  		$('.numOfFilters').text(total + " "+filtersApply);	
		  	} else {
		  		$('.numOfFilters').text(total+" "+filterApply);
		  	}
		  	$('.numOfFilters').text(total);
		}
		
		function setFilterTotal () {
			currNumFilters = $('.hotelLifecycleGroup input').filter(':checked').length;
			currNumFilters = $('.specialismGroup input').filter(':checked').length;
			currNumFilters = $('.hotelDeptGroup input').filter(':checked').length;
			currNumFilters = $('.hotelLocationGroup input').filter(':checked').length;
			currNumFilters = $('.guestJourneyGroup input').filter(':checked').length;
			currNumFilters = $('.supportingMaterialGroup input').filter(':checked').length;
		}
		
		function hotelLifecycleGroup() {
			 currNumFilters = $('.hotelLifecycleGroup input').filter(':checked').length;
			  if (currNumFilters == 0) {
			      $('.hotelLifecycleGroup .filterNum').text('');
			  } else {
			      var txt = currNumFilters == 1 ? ' '+filterLabel : ' '+filtersLabel;
			      $('.hotelLifecycleGroup .filterNum').text(currNumFilters+txt);
			  }
		}
		$('.hotelLifecycleGroup input').on('change', function (e) {
			hotelLifecycleGroup();
		    updateFiltersTotal();
	 	
		});
		
		function specialismGroup() {
			currNumFilters = $('.specialismGroup input').filter(':checked').length;
			  if (currNumFilters == 0) {
			      $('.specialismGroup .filterNum').text('');
			  } else {
			      var txt = currNumFilters == 1 ? ' '+filterLabel : ' '+filtersLabel;
			      $('.specialismGroup .filterNum').text(currNumFilters+txt);
			  }
		}
		
		$('.specialismGroup input').on('change', function (e) {
			specialismGroup();
		    updateFiltersTotal();
	 	
		});
		
		function hotelDeptGroup () {
			 currNumFilters = $('.hotelDeptGroup input').filter(':checked').length;
			  if (currNumFilters == 0) {
			      $('.hotelDeptGroup .filterNum').text('');
			  } else {
			      var txt = currNumFilters == 1 ? ' '+filterLabel : ' '+filtersLabel;
			      $('.hotelDeptGroup .filterNum').text(currNumFilters+txt);
			  }
		}
		$('.hotelDeptGroup input').on('change', function (e) {
			hotelDeptGroup();
		    updateFiltersTotal();
		});
		
		function hotelLocationGroup () {
			currNumFilters = $('.hotelLocationGroup input').filter(':checked').length;
		    if (currNumFilters == 0) {
		        $('.hotelLocationGroup .filterNum').text('');
		    } else {
		      var txt = currNumFilters == 1 ? ' '+filterLabel : ' '+filtersLabel;
		      $('.hotelLocationGroup .filterNum').text(currNumFilters + txt);
		    }
		}
		
		$('.hotelLocationGroup input').on('change', function (e) {
			hotelLocationGroup();
		  	updateFiltersTotal();
		});
		
		function guestJourneyGroup() {
			currNumFilters = $('.guestJourneyGroup input').filter(':checked').length;
			if (currNumFilters == 0) {
			  $('.guestJourneyGroup .filterNum').text('');
			} else {
			  var txt = currNumFilters == 1 ? ' '+filterLabel : ' '+filtersLabel;
			  $('.guestJourneyGroup .filterNum').text(currNumFilters+txt);
			}
		}
		
		$('.guestJourneyGroup input').on('change', function (e) {
			guestJourneyGroup();
		  	updateFiltersTotal();
		});
	
		function supportingMaterialGroup() {
			currNumFilters = $('.supportingMaterialGroup input').filter(':checked').length;
			if (currNumFilters == 0) {
			   $('.supportingMaterialGroup .filterNum').text('');
			} else {
			   var txt = currNumFilters == 1 ? ' '+filterLabel : ' '+filtersLabel;
			   $('.supportingMaterialGroup .filterNum').text(currNumFilters+txt);
			}
		}
		$('.supportingMaterialGroup input').on('change', function (e) {
			  supportingMaterialGroup();
			  updateFiltersTotal();
		});
		
		updateFiltersTotal();
		hotelLifecycleGroup();
		specialismGroup();
		supportingMaterialGroup();
		guestJourneyGroup();
		hotelDeptGroup();
		hotelLocationGroup();
		
		$( ".searchoptioncancel" ).click(function() {
			$( "#searchModal" ).dialog( "close" );
		});
		
		$("#changeSearchCriteria").mousedown(function() {
			var searchtxtVal = $('#filterText').val();
		 	var eventLabel = 'Search';
		 	if (typeof searchtxtVal != 'undefined' && searchtxtVal != null && searchtxtVal != '' && searchtxtVal != 'null') {
			 	eventLabel = "Search for "+searchtxtVal;
		 	}
			_gaq.push(['_trackEvent', 'What Changed On', 'Search', eventLabel]);
		});
		
		$("#searchStdBtn").mousedown(function() {
			var searchtxtVal = $('#filterText').val();
		 	var eventLabel = 'Search';
		 	if (typeof searchtxtVal != 'undefined' && searchtxtVal != null && searchtxtVal != '' && searchtxtVal != 'null') {
			 	eventLabel = "Search for "+searchtxtVal;
		 	}
			_gaq.push(['_trackEvent', 'What Changed On', 'Search', eventLabel]);
		});
		
		$(".hotelLifecycleGroup").hide();
	});
</script>

<aui:form action="${varSearchStandards}" method="post" name="filterForm" cssClass="marginBottomZero">

	<div class="modal-body ">
		
		<div class="form-inline">
      		<label for="filterText" class="ie7_search_label">${search}</label>
      		<input class="searchInput ie7_searchInput" style="width: 550px;" type="search" name="filterText" id="filterText" placeholder="${searchTerm}" maxlength="2000" value="<%=strSearchText%>">
      		<div class="pull-right">
      			<button type="submit" class="btn btn-primary" id="searchStdBtn"><i class="icon-search icon-white"></i> ${goButton}</button>
      			<button type="button" class="btn clearSearch" ><i class="icon-remove"></i> ${clearSearch}</button>
    		</div>
      	</div>
      	<div class="form-inline" style="font-size: 0.8em; margin: 5px 0 10px 50px;clear:both;">
      		<% if(strSearchOptions.equals("all")) { %>
      		<label class="radio">
				<input type="radio" name="searchOptions" id="searchOptions" value="all" class="standard_radio" checked="checked"> ${searchAllWords} 
				<span><a class="help_icon tooltip" href="javascript:return false;"><img src="/BSTheme-theme/images/help.png" alt="Search All Words help icon"/>
                <span class="classic">${searchAllWordsHelp}</span></a></span>
			</label>
			<label class="radio">
				<input type="radio" name="searchOptions" id="searchOptions" value="exact" class="standard_radio"> ${matchExactPhrase} 
				<span><a class="help_icon tooltip" href="javascript:return false;"><img src="/BSTheme-theme/images/help.png" alt="Match Exact Phrase help icon"/>
                <span class="classic">${matchExactPhraseHelp}</span></a></span>
			</label>
            <label class="radio">
				<input type="radio" name="searchOptions" id="searchOptions" value="any" class="standard_radio"> ${matchAnyWords}
				<span><a class="help_icon tooltip" href="javascript:return false;"><img src="/BSTheme-theme/images/help.png" alt="Match Any of the Words help icon"/>
				<span class="classic">${matchAnyWordsHelp}</span></a></span>
			</label>
			<% } else if(strSearchOptions.equals("exact")){ %>
			<label class="radio">
				<input type="radio" name="searchOptions" id="searchOptions" value="all" class="standard_radio" > ${searchAllWords} 
				<span><a class="help_icon tooltip" href="javascript:return false;"><img src="/BSTheme-theme/images/help.png" alt="Search All Words help icon"/>
                <span class="classic">${searchAllWordsHelp}</span></a></span>
			</label>
            <label class="radio">
				<input type="radio" name="searchOptions" id="searchOptions" value="exact" class="standard_radio" checked="checked"> ${matchExactPhrase}
				<span><a class="help_icon tooltip" href="javascript:return false;"><img src="/BSTheme-theme/images/help.png" alt="Match Exact Phrase help icon"/>
                <span class="classic">${matchExactPhraseHelp}</span></a></span>
			</label>
            <label class="radio"> 
				<input type="radio" name="searchOptions" id="searchOptions" value="any" class="standard_radio">  ${matchAnyWords}
				<span><a class="help_icon tooltip" href="javascript:return false;"><img src="/BSTheme-theme/images/help.png" alt="Match Any of the Words help icon"/>
				<span class="classic">${matchAnyWordsHelp}</span></a></span>
			</label>
			<% } else if(strSearchOptions.equals("any")){ %>
			<label class="radio">
				<input type="radio" name="searchOptions" id="searchOptions" value="all" class="standard_radio"> ${searchAllWords}
				<span><a class="help_icon tooltip" href="javascript:return false;"><img src="/BSTheme-theme/images/help.png" alt="Search All Words help icon"/>
                <span class="classic">${searchAllWordsHelp}</span></a></span>
			</label>
            <label class="radio">
				<input type="radio" name="searchOptions" id="searchOptions" value="exact" class="standard_radio"> ${matchExactPhrase}
				<span><a class="help_icon tooltip" href="javascript:return false;"><img src="/BSTheme-theme/images/help.png" alt="Match Exact Phrase help icon"/>
                <span class="classic">${matchExactPhraseHelp}</span></a></span>
			</label>
            <label class="radio">
				<input type="radio" name="searchOptions" id="searchOptions" value="any" class="standard_radio" checked="checked">  ${matchAnyWords}
				<span><a class="help_icon tooltip" href="javascript:return false;"><img src="/BSTheme-theme/images/help.png" alt="Match Any of the Words help icon"/>
				<span class="classic">${matchAnyWordsHelp}</span></a></span>
			</label>
			<% } else { %>
			<label class="radio">
				<input type="radio" name="searchOptions" id="searchOptions" value="all" class="standard_radio" checked="checked"> ${searchAllWords}
				<span><a class="help_icon tooltip" href="javascript:return false;"><img src="/BSTheme-theme/images/help.png" alt="Search All Words help icon"/>
                <span class="classic">${searchAllWordsHelp}</span></a></span>
			</label>
            <label class="radio">
				<input type="radio" name="searchOptions" id="searchOptions" value="exact" class="standard_radio"> ${matchExactPhrase}
				<span><a class="help_icon tooltip" href="javascript:return false;"><img src="/BSTheme-theme/images/help.png" alt="Match Exact Phrase help icon"/>
                <span class="classic">${matchExactPhraseHelp}</span></a></span>
			</label>
            <label class="radio">
				<input type="radio" name="searchOptions" id="searchOptions" value="any" class="standard_radio"> ${matchAnyWords}
				<span><a class="help_icon tooltip" href="javascript:return false;"><img src="/BSTheme-theme/images/help.png" alt="Match Any of the Words help icon"/>
				<span class="classic">${matchAnyWordsHelp}</span></a></span>
			</label>
			<% } %>
		</div>
		
		<p class="pull-left"><em>${searchNote}</em></p>
		<p class="pull-right"><strong style="font-style:italic;"><span class="numOfFilters">0</span> ${filtersApply}</strong></p>
		<div class="clearfix"></div>
		<div class="accordion" id="searchstandardaccordion">  
			
		<h3 class="hotelLifecycleGroup">${byHotelLifeCycle}<span style="display: inline-block; text-align:right;" class="filterNum"></span></h3>  
		<div class="accordion-inner hotelLifecycleGroup">
           	<div class="row">
               	<p class="span6"><em>${byHotelLifeCycleNote}</em></p>
			</div>
			<%	
				FlagCategory flagCategory = FlagCategoryLocalServiceUtil.getFlagCategory(91);
				List<FlagCategory> flagCategoriesOrginal = FlagCategoryLocalServiceUtil.getFlagCategoryByParentId(91);
				List<FlagCategory> flagCategories = new ArrayList<FlagCategory>();
				flagCategories.addAll(flagCategoriesOrginal);
				Collections.reverse(flagCategories);
			%>
			<div class="row">
				<div class="span3">
					<div class="ht_lifecycle">                  
			<%	String showDisabled = "";
				String checked = "";
				int index = 0;
				if (contentType.equalsIgnoreCase("OPERATE")) {
					showDisabled = "disabled='disabled'";
				}
				for (FlagCategory flgOption : flagCategories) {
                    checked = "";
                	if ((!BrandStandardsUtil.isNullOrBlank(arlHoteLifecycle) && arlHoteLifecycle.contains(flgOption.getFlagCatId()+"")) 
                			|| (!(contentType.equalsIgnoreCase("OPERATE")) && !isSearchOn && index == 0 )) {
                    	checked = "";
 					} else if(contentType.equalsIgnoreCase("OPERATE")) {
                		showDisabled = "disabled='disabled'";
                		checked = "";
                	}
			%>
						<input id="hotelLifecycle" name ="hotelLifecycle" type="checkbox" value="<%=flgOption.getFlagCatId()%>" <%=checked%> <%=showDisabled%> style="display:none;" />
						<img src="<%=imagePath + flgOption.getFlagCatId() + ((showDisabled.length() < 1 && checked.length() > 0) ? "_" + brandCode: "") + ".jpg"%>" 
							path="<%=imagePath%>" <%=showDisabled.length() > 0 ? "": (checked.length() > 0) ? "class='ht_active'":"class='ht_inactive'"%> id="<%=flgOption.getFlagCatId()%>" />
           	<%		index++;
				} 
			%>
					</div>
				</div>
			</div>   
		</div>
              
		<h3 class="specialismGroup">${bySpecialism}<span style="display: inline-block; text-align:right;" class="filterNum"></span></h3>  
		<div class="accordion-inner specialismGroup">
           	<div class="row">
               	<p class="span6"><em>${bySpecialismNote}</em></p>
				<div class="span4" style="text-align:right;">
                   	${check}: 
                   	<span class="btn" id="specialismGroupAll" >${searchAll}</span>
                   	<span class="btn" id="specialismGroupNone">${searchNone}</span>
				</div>
			</div>
			<div class="row">
			<% 
				String operateChecked = "";
				String buildChecked = "";
				if(!BrandStandardsUtil.isNullOrBlank(arlSpecialism) &&  arlSpecialism.contains("258")) {
					operateChecked = "checked='checked'";        
               	}
				if(!BrandStandardsUtil.isNullOrBlank(arlSpecialism) &&  arlSpecialism.contains("257")) {
					buildChecked = "checked='checked'";        
               	}
			%>
				<div class="span3">
					<label class="checkbox">
						<input id="specialism" name ="specialism" type="checkbox" value="258" <%=operateChecked %> ><%=request.getAttribute("258")%>
					</label>
				</div>
				<div class="span3">
					<label class="checkbox">
						<input id="specialism" name ="specialism" type="checkbox" value="257" <%=buildChecked %> ><%=request.getAttribute("257")%>
					</label>
				</div>
			</div>   
		</div>     
            
		<h3 class="hotelDeptGroup">${byHotelDepartment}<span style="display: inline-block; text-align:right;" class="filterNum"></span></h3>  
		<div class="accordion-inner hotelDeptGroup">
           	<div class="row">
               	<p class="span6"><em>${hotelDepartmentNote}</em></p>
				<div class="span4" style="text-align:right;">
                   	${check}: 
                   	<span class="btn" id="hotelDeptGroupAll" >${searchAll }</span>
                   	<span class="btn" id="hotelDeptGroupNone">${searchNone}</span>
				</div>
			</div>
			<%	
				flagCategory = FlagCategoryLocalServiceUtil.getFlagCategory(1);
				flagCategories = FlagCategoryLocalServiceUtil.getFlagCategoryByParentId(1);	
			%>
			<div class="row">
			<%	int size = flagCategories.size();
				int sizeBy3 = Math.round(size/3)+1;
				showDisabled = "";
				int rowCount = 0;
				for(FlagCategory flgOption : flagCategories) {	
                   	if(rowCount == 0 || rowCount == sizeBy3 || rowCount == (sizeBy3*2)) {
			%>
						<div class="span3">
			<% 		}
					if(!BrandStandardsUtil.isNullOrBlank(arlDeptApplicability)) { 	
						boolean found = false;
                      	for(int i = 0; i < arlDeptApplicability.size(); i++) {	
                      		if(flgOption.getFlagCatId() == Long.parseLong((String)arlDeptApplicability.get(i))) {
                      			found = true;
                      			break;
                      		}
                      	}
                      	if(found) {
			%>		
                     			<label class="checkbox"><input id="deptApplicability" name ="deptApplicability" type="checkbox" 
                     				value="<%=flgOption.getFlagCatId()%>" checked="checked"><%=request.getAttribute(String.valueOf(flgOption.getFlagCatId()))%></label>
			<%			} else { %>		
							<label class="checkbox"><input id="deptApplicability" name="deptApplicability" type="checkbox" 
								value="<%=flgOption.getFlagCatId()%>" <%=showDisabled %>><%=request.getAttribute(String.valueOf(flgOption.getFlagCatId()))%></label>
			<%			}
					} else {
			%>		
						<label class="checkbox"><input id="deptApplicability" name="deptApplicability" type="checkbox" 
							value="<%=flgOption.getFlagCatId()%>" <%=showDisabled %>><%=request.getAttribute(String.valueOf(flgOption.getFlagCatId()))%></label>
			<%		}
					if(rowCount == (sizeBy3 - 1) || rowCount == ((sizeBy3 * 2) - 1) || size == rowCount + 1) {
			%>			
						</div>
			<%		}
					rowCount++;
				} 
			%>
			</div>
		</div>
	   
		<h3 class="hotelLocationGroup">${byHotelLocation}<span style="display: inline-block; text-align:right;" class="filterNum"></span></h3>
		<div class="accordion-inner hotelLocationGroup">
			<div class="row">
				<p class="span6"><em>${hotelLocationNote}</em></p>
                <div class="span4" style="text-align:right;">
                   	${check}: 
                   	<span class="btn" id="hotelLocationGroupAll">${searchAll}</span>
                   	<span class="btn" id="hotelLocationGroupNone">${searchNone}</span>
                </div>
			</div>
			<%	
				 flagCategory = FlagCategoryLocalServiceUtil.getFlagCategory(25);
				 flagCategories = FlagCategoryLocalServiceUtil.getFlagCategoryByParentId(25);	
				 List<FlagCategory> arlFlagCategory = BrandStandardsUtil.sortFlagCategories(flagCategories);
			%>
			<div class="row">
			<%	size = arlFlagCategory.size();
				sizeBy3 = Math.round(size/3)+1;
				rowCount = 0;
				showDisabled="";
				for(FlagCategory flgOption : arlFlagCategory) {	
					if(rowCount == 0 || rowCount == sizeBy3 || rowCount == (sizeBy3*2)) {
			%>
						<div class="span3">
			<%		}
					if(!BrandStandardsUtil.isNullOrBlank(arlLocHotel)) { 	
						boolean found = false;
                     		for(int i=0;i< arlLocHotel.size();i++) {
                     			if(flgOption.getFlagCatId() == Long.parseLong((String)arlLocHotel.get(i))) {
                     				found = true;
                     				break;
                     			}
                     		}
                     		if(found) {
			%>		
								<label class="checkbox"><input id="locHotel" name="locHotel" type="checkbox" 
									value="<%=flgOption.getFlagCatId()%>" checked="checked"><%=request.getAttribute(String.valueOf(flgOption.getFlagCatId()))%></label>
			<%			} else { %>		
								<label class="checkbox"><input id="locHotel" name="locHotel" type="checkbox" 
									value="<%=flgOption.getFlagCatId()%>" <%=showDisabled %>><%=request.getAttribute(String.valueOf(flgOption.getFlagCatId()))%></label>
			<%			}
					} else {
			%>		
							<label class="checkbox"><input id="locHotel" name="locHotel" type="checkbox" 
								value="<%=flgOption.getFlagCatId()%>" <%=showDisabled %>><%=request.getAttribute(String.valueOf(flgOption.getFlagCatId()))%></label>
			<%		}
					if(rowCount == (sizeBy3 - 1) || rowCount == ((sizeBy3 * 2) - 1) || size == (rowCount + 1)) {
			%>
						</div>
			<%
                     	}
					rowCount++;
				}
			%>
			</div>
		</div>
			
		<h3 class="guestJourneyGroup">${byGuestJourney}<span style="display: inline-block; text-align:right;" class="filterNum"></span></h3>
		<div class="accordion-inner guestJourneyGroup">
           	<div class="row">
               	<p class="span6"><em>${guestJourneyNote}</em></p>
				<div class="span4" style="text-align:right;">
                	${check}: 
                    <span class="btn" id="guestJourneyGroupAll">${searchAll}</span>
                    <span class="btn" id="guestJourneyGroupNone">${searchNone}</span>
				</div>
			</div>
			<%	
				flagCategory = FlagCategoryLocalServiceUtil.getFlagCategory(20);
				flagCategories = FlagCategoryLocalServiceUtil.getFlagCategoryByParentId(20);	
			%>
			<div class="row">
			<%	size = flagCategories.size();
				sizeBy3 = Math.round(size/3)+1;
				rowCount = 0;
				for(FlagCategory flgOption : flagCategories) {	
					if(rowCount == 0 || rowCount == sizeBy3 || rowCount == (sizeBy3*2)) {
			%>
						<div class="span3">
			<%		}
                    if(!BrandStandardsUtil.isNullOrBlank(arlGuestJourney)) { 	
						boolean found = false;
						for(int i = 0; i < arlGuestJourney.size(); i++) {
							if(flgOption.getFlagCatId() == Long.parseLong((String)arlGuestJourney.get(i))) {
	                      		found = true;
	                      		break;
	                      	}
						}
						if(found) {
			%>		
							<label class="checkbox"><input type="checkbox" id="guestJourney" name="guestJourney" 
								value="<%=flgOption.getFlagCatId()%>" checked="checked"><%=request.getAttribute(String.valueOf(flgOption.getFlagCatId()))%></label>
			<%			} else { %>		
							<label class="checkbox"><input type="checkbox"  id="guestJourney" name="guestJourney" 
								value="<%=flgOption.getFlagCatId()%>" <%=showDisabled %>><%=request.getAttribute(String.valueOf(flgOption.getFlagCatId()))%></label>
			<%			}
					} else {
			%>		
						<label class="checkbox"><input type="checkbox" id="guestJourney" name="guestJourney" 
							value="<%=flgOption.getFlagCatId()%>" <%=showDisabled %>><%=request.getAttribute(String.valueOf(flgOption.getFlagCatId()))%></label>
			<%		}
					if(rowCount == (sizeBy3 - 1) || rowCount == ((sizeBy3 * 2) - 1) || size == (rowCount + 1)) {
            %>            		
            			</div>
			<%		}
					rowCount++;
				}
			%>
			</div>
		</div>
			 
		<h3 class="supportingMaterialGroup">${searchFilterBy} <span style="display: inline-block; text-align:right;" class="filterNum"></span></h3>
		<div class="accordion-inner supportingMaterialGroup">
			<div class="row">
				<p class="span6"><em>${byChangeTypeNote}</em></p>
				<div class="span4" style="text-align:right;">
                   	${check}: 
                   	<span class="btn" id="supportingMaterialGroupAll">${searchAll}</span>
                   	<span class="btn" id="supportingMaterialGroupNone">${searchNone}</span>
				</div>
			</div>
			<div class="row">
				<div class="span2">
				<% if("Y".equals(strFilterByNew)) { %>
                    <label class="checkbox"><input name="filterByNew" id="filterByNew" type="checkbox" value="Y" checked="checked">${filterByNew}</label>
				<% } else { %>
                     <label class="checkbox"><input name="filterByNew" id="filterByNew" type="checkbox" value="Y">${filterByNew}</label>
				<% } %>
				</div>
				<div class="span2">
				<% if("Y".equals(strFilterByTextUpdate)) { %>
                   	<label class="checkbox"><input name="filterByTextUpdate" id="filterByTextUpdate" type="checkbox" value="Y" checked="checked">${filterByTextUpdate}</label>
				<% } else { %>
					<label class="checkbox"><input name="filterByTextUpdate" id="filterByTextUpdate" type="checkbox" value="Y">${filterByTextUpdate}</label>
				<% } %>
				</div>
				<div class="span2">
                   <% if("Y".equals(strFilterByComplianceUpdate)) { %>
                   	<label class="checkbox"><input name="filterByComplianceUpdate" id="filterByComplianceUpdate" type="checkbox" value="Y" checked="checked">${filterByComplianceUpdate}</label>
				<% } else { %>
					<label class="checkbox"><input name="filterByComplianceUpdate" id="filterByComplianceUpdate" type="checkbox" value="Y">${filterByComplianceUpdate}</label>
				<% } %>
				</div>
				<div class="span2">
				<% if("Y".equals(strFilterByLifecycleUpdate)) { %>
                   	<label class="checkbox"><input name="filterByLifecycleUpdate" id="filterByLifecycleUpdate" type="checkbox" value="Y" checked="checked">${filterByLifecycleUpdate}</label>
				<% } else { %>
					<label class="checkbox"><input name="filterByLifecycleUpdate" id="filterByLifecycleUpdate" type="checkbox" value="Y">${filterByLifecycleUpdate}</label>
				<% } %>
				</div>
				<div class="span2">
				<% if("Y".equals(strFilterByRemoved)) { %>
                   	<label class="checkbox"><input name="filterByRemoved" id="filterByRemoved" type="checkbox" value="Y" checked="checked">${filterByRemoved}</label>
				<% } else { %>
					<label class="checkbox"><input name="filterByRemoved" id="filterByRemoved" type="checkbox" value="Y">${filterByRemoved}</label>
				<% } %>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="modal-footer">
	<div class="pull-left"><button type="button" class="btn searchoptioncancel">${cancelButton}</button></div>
	<div class="pull-right"><button type="submit" class="btn btn-primary" id="changeSearchCriteria"><i class="icon-search icon-white"></i> ${goButton}</button></div>
</div>

</aui:form>
