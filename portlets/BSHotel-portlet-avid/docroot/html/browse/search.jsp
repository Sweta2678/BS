<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@include file="/html/browse/init.jsp" %>
<portlet:actionURL var="varSearchStandards" name="searchStandards" />
<%
	boolean isSearchOn = false;
	StandardsSearchCriteria stdSearchCriteria = (StandardsSearchCriteria) session.getAttribute("searchCriteria");
	if(stdSearchCriteria != null && stdSearchCriteria.isSearch()) {
	    isSearchOn = true;
	}
	List<FlagCategory> spcialismFlagCategories = new ArrayList<FlagCategory>();
	if(request.getAttribute("SPECIALISM_FLAGS") != null){
		spcialismFlagCategories = (List<FlagCategory>)request.getAttribute("SPECIALISM_FLAGS");
	}
	List<String> arlHoteLifecycle = stdSearchCriteria == null ? null : stdSearchCriteria.getHotelLifecycle();
	List<String> arlSpecialism = stdSearchCriteria == null ? null : stdSearchCriteria.getSpecialism();
	List<String> arlDeptApplicability = stdSearchCriteria == null ? null : stdSearchCriteria.getDeptApplicability();
	List<String> arlGuestJourney = stdSearchCriteria == null ? null : stdSearchCriteria.getGuestJourney();
	List<String> arlLocHotel = stdSearchCriteria == null ? null : stdSearchCriteria.getLocHotel();
	List<String> arlFlags = stdSearchCriteria == null ? null : stdSearchCriteria.getFlags();
	String strSearchOptions = stdSearchCriteria == null ? "" : stdSearchCriteria.getTextSearchType(); 
	String strHasLinks = stdSearchCriteria == null ? null : stdSearchCriteria.isHasLinks() ? "Y" : "N";
	String strHasAttachments = stdSearchCriteria == null ? null : stdSearchCriteria.isHasAttachments() ? "Y" : "N";
	String strHasImages = stdSearchCriteria == null ? null : stdSearchCriteria.isHasImages() ? "Y" : "N";
	String strHasSOP = stdSearchCriteria == null ? null : stdSearchCriteria.isHasSOP() ? "Y" : "N";
	String strHasTM = stdSearchCriteria == null ? null : stdSearchCriteria.isHasTrainingMaterial() ? "Y" : "N";
	String strSearchText = stdSearchCriteria == null ? "" : stdSearchCriteria.getTextSearch(); 
	String strComplianceDate = stdSearchCriteria == null ? "" : stdSearchCriteria.getComplianceDeadline();
	if(strSearchOptions == null || strSearchOptions.length() == 0) {
		strSearchOptions = "all";	
	}
	if(strSearchText == null) {
		strSearchText = "";	
	}
	String compDeadLineText = (String)request.getAttribute("compDeadlineLabel");
	String compDeadLineToLabelText = (String)request.getAttribute("compDeadlineToLabel");
	String compDeadLineBeyondText = (String)request.getAttribute("comDeadlineBeyond");
	String compDeadLineAndLabelText = (String)request.getAttribute("compDeadlineAndLabel");
	String brandCode = (String)request.getAttribute("brandCode");
	String contentType = (String) request.getAttribute("contentType");
	String imagePath = "/BSHotel-portlet/images/";
%>

<link type="text/css" rel="stylesheet" href="/BSHotel-theme/css/tooltip.css"/>
<script>
var complianceCount = 0;
var supporting = 0;
var total=0;
var compDeadlineLabel =  "<%=compDeadLineText%>";
var compDeadlineToLabel = "<%=compDeadLineToLabelText%>";
var compDeadlineBeyond = "<%=compDeadLineBeyondText%>";
var andLabel = "<%=compDeadLineAndLabelText%>";
var dateArray = <%=(JSONObject)request.getAttribute("monthMap")%>;
var filtersLabel = "${filtersLabel}";
var filterLabel = "${filterLabel}";
var filtersApply = "${filtersApply}";
var filterApply = "${filterApply}";
var dayDateLabel = "${dayDateLabel}";
var yearDateLabel = "${yearDateLabel}";
var langCodeVal = "${langCode}";
var differentDateFormat = "${differentDateFormat}";
var path = "<%=imagePath%>";
var brandCode = "<%=brandCode%>";
var specialismOpt = "";

$(document).ready(function(){
	
	$("a.tooltip").tooltip();
	
	/*allsupportaccordion call*/
	$("#searchstandardaccordion").accordion({
	        collapsible: true,
	        active: false,
	        heightStyle: "content"
	 });
	
	$('.complianceGroup input[name=compDeadline]:radio').on('click', function (e) {
		var txt = '';
	    var val = $(this).val();
	    if (val == '0d') {
	      txt = compDeadlineToLabel+' ' + getComplianceDate();
	    } else if (val == '12m+') {
	      txt = compDeadlineBeyond;
	    } else {
	      txt = compDeadlineLabel +' '+ getComplianceDate() +' '+ andLabel +' '+ getComplianceDate(getLongestDate(val));
	    }
		$('#horizon').text(txt);
	    $('#horizon').attr("title", txt);
	    complianceCount =1;   
		updateFiltersTotal();
	});
	
	$('#complianceDateNone').on('click', function (e) {
	    $('#horizon').text('');
	    $('#horizon').attr("title", '');
	    $('.complianceGroup').find('input[name=compDeadline]:radio').each( function () {
	         $(this).prop('checked','');
	         $(this).change();
	    });
	    if(total > 0) {
	  		complianceCount = -1;
	  	} else {
	  	  	complianceCount = 0;
	  	}
	    updateFiltersTotal();
	});

	$('.supportingMaterialGroup input[name=supportingMaterial]:radio').on('click', function (e) {
		var txt = '';
	   	var val = $(this).val();
	   	supporting = 1;   
	    updateFiltersTotal();
	});
		  
	$('#supportingMaterialGroupNone').on('click', function (e) {
	    $('.supportingMaterialGroup').find('input[name=supportingMaterial]:radio').each( function () {
	         $(this).prop('checked','');
	         $(this).change();
	    });
	    if(total > 0) {
			supporting = -1;
		} else {
			supporting = 0;
		}
	    updateFiltersTotal();
	});

	$('#hotelLifecycleGroupAll').on('click', function (e) {
		var contentType = '<%=contentType%>';
		if(contentType != 'OPERATE'){
	    $(".hotelLifecycleGroup").find("input:checkbox").each(function() { 
	        if(!$(this).prop('checked') && !$(this).prop('disabled')) { 
	          $(this).prop('checked','checked');
	          $(this).change();
	        } 
	    });
		
		$(".hotelLifecycleGroup").find('img').each(function(){
			imageId = $(this).attr('id');
			$(this).attr('src', path + imageId + '_' + brandCode + '.jpg');
			$(this).removeClass('ht_inactive').addClass('ht_active');
		});
		}
	});
	
	$('#hotelLifecycleGroupNone').on('click', function (e) {
		var contentType = '<%=contentType%>';
		if(contentType != 'OPERATE'){
		$(".hotelLifecycleGroup").find("input:checkbox").each(function() { 
			$(this).prop("checked", false);
			$(this).change();
		});
		
		$(".hotelLifecycleGroup").find('img').each(function(){
			imageId = $(this).attr('id');
			$(this).attr('src', path + imageId + '.jpg');
			$(this).removeClass('ht_active').addClass('ht_inactive');
		});
		}
	});
	
	$('#specialismGroupAll').on('click', function (e) {
	    $(".specialismGroup").find("input:checkbox").each(function() { 
	        if(!$(this).prop('checked') && !$(this).prop('disabled')) { 
	          $(this).prop('checked','checked');
	          $(this).change();
	        } 
	    });
	    /* hotelLifecycleGroup(); */
	});

	$('#specialismGroupNone').on('click', function (e) {
	    $(".specialismGroup").find("input:checkbox").each(function() { 
	        $(this).prop('checked', false);
	        $(this).change();
	    });
	    /* hotelLifecycleGroup(); */
	});
		  
	$('#hotelDeptGroupAll').on('click', function (e) {
	    $(".hotelDeptGroup").find("input:checkbox").each(function() { 
	        if(!$(this).prop('checked') && !$(this).prop('disabled')) { 
	          $(this).prop('checked','checked');
	          $(this).change();
	        } 
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

		$(".specialismGroup").find("input:checkbox").each(function() { 
			$(this).prop('checked', false);
			$(this).change();
		});

		$(".hotelLifecycleGroup").find("input:checkbox").each(function() { 
			$(this).prop("checked", false);
			$(this).change();
		});
		
		$(".hotelLifecycleGroup").find('img').each(function(){
			imageId = $(this).attr('id');
			$(this).attr('src', path + imageId + '.jpg');
			$(this).removeClass('ht_active').addClass('ht_inactive');
		});
		buildInd = true;
		
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
		
		$('.complianceGroup').find('input[name=compDeadline]:radio').each( function () {
			$(this).prop('checked','');
			$(this).change();
			complianceCount = 0;
		});
		$(".supportingMaterialGroup").find('input[name=supportingMaterial]:radio').each(function() { 
			$(this).prop('checked', '');
			$(this).change();
			supporting = 0;
		});
		$('#horizon').text('');
		$('#horizon').attr("title", '');
		updateFiltersTotal();
	});

    var buildInd = true;
        
	function isBuildEnabled() {
	    var isBuild = false;
	    var count = $('.specialismGroup input').filter(':checked').length;
	    if (count == 0) {
	        isBuild = true;
	    } else {
	        $('.specialismGroup :checked').each(function() {
	            if (this.value == "257" || this.value == "403" || this.value == "401" || this.value == "480") {
	                isBuild = true;
	            }
	        });
	    }
	    return isBuild;
	};


	function updateFiltersTotal() {
		var hotelLife = 0;
		buildInd = isBuildEnabled();
		if (buildInd) {
		    hotelLife = $('.hotelLifecycleGroup input').filter(':checked').length || 0;
		}
		var specialism = $('.specialismGroup input').filter(':checked').length || 0;
		var hotelDept = $('.hotelDeptGroup input').filter(':checked').length || 0;
		var hotelLoc = $('.hotelLocationGroup input').filter(':checked').length || 0;
		var gjs = $('.guestJourneyGroup input').filter(':checked').length || 0;
		var suppMat = $("input:radio[id='supportingMaterial']:checked").length || 0;
		var compDeadline = $("input:radio[id='compDeadline']:checked").length || 0;
		var total = parseInt(hotelLife, 10) + parseInt(specialism, 10) + parseInt(hotelDept, 10) + parseInt(hotelLoc, 10) + parseInt(gjs, 10)+ parseInt(suppMat, 10);
		total = total + parseInt(compDeadline, 10);
		  
		if (total == 0 || total > 1) {
			$('.numOfFilters').text(total + " "+filtersApply);	
		} else {
			$('.numOfFilters').text(total+" "+filterApply);
		}
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
		      hotelLifecycleGroup();
		} else {
            var txt = currNumFilters == 1 ? ' '+filterLabel : ' '+filtersLabel;
            $('.specialismGroup .filterNum').text(currNumFilters+txt);
            /* Should NOT deselect Lifecycle icons! */
            var buildOpt = false;
            var operateOpt = false;
            $('.specialismGroup :checked').each(function() {
                if (this.value == "257" || this.value == "403" || this.value == "401" || this.value == "480") {
                  buildOpt = true;
                } else {
                  operateOpt = true;
                }
            });
            buildInd = buildOpt;
            
            if (operateOpt && !buildOpt) {
                hotelLifecycleGroup();
            }
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
	
	function complianceDateGroup() {
		var cval = $(".complianceGroup input:radio[id='compDeadline']:checked").val();
	    var ctxt = '';
		if (cval == '0d') {
			ctxt = compDeadlineToLabel+' ' + getComplianceDate();
	    } else if (cval == '12m+') {
	      	ctxt = compDeadlineBeyond;
	    } else if (cval == '7d' || cval == '1m' || cval == '3m' || cval == '6m' || cval == '12m'){
	      	ctxt = compDeadlineLabel +' '+ getComplianceDate() +' '+ andLabel +' '+ getComplianceDate(getLongestDate(cval));
	    }
	    $('#horizon').text(ctxt);
	    $('#horizon').attr("title", ctxt);
	}
	
	function supportingMaterialGroup() {
		currNumFilters = $(".supportingMaterialGroup input:radio[id='supportingMaterial']:checked").val();
		if(currNumFilters== 'hasAttachments' || currNumFilters== 'hasLinks' || currNumFilters== 'hasImages' 
				|| currNumFilters== 'hasSOP' || currNumFilters== 'hasTrainMaterial' ) {
			currNumFilters =1;
			var txt = currNumFilters == 1 ? ' '+filterLabel : ' '+filtersLabel;
			$('.supportingMaterialGroup .filterNum').text(currNumFilters+txt);
		} else {
			$('.supportingMaterialGroup .filterNum').text('');
		}
	}
	
	$(".supportingMaterialGroup input").on('change', function (e) {
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
	complianceDateGroup();
	
	$( ".searchoptioncancel" ).click(function() {
		$( "#searchModal" ).dialog( "close" );
	});

	$( "#changeSearchCriteria" ).mousedown(function() {
		var searchtxtVal = $('#filterText').val();
		var eventLabel = 'Search';
		if (typeof searchtxtVal != 'undefined' && searchtxtVal != null && searchtxtVal != '' && searchtxtVal != 'null') {
		 	eventLabel = "Search for "+searchtxtVal;
		}
		_gaq.push(['_trackEvent', 'Search Standards', 'Search', eventLabel]);
	});
	 
	$( "#searchStdBtn" ).mousedown(function() {
		 var searchtxtVal = $('#filterText').val();
		 var eventLabel = 'Search';
		 if (typeof searchtxtVal != 'undefined' && searchtxtVal != null && searchtxtVal != '' && searchtxtVal != 'null') {
			 eventLabel = "Search for "+searchtxtVal;
		 }
		 _gaq.push(['_trackEvent', 'Search Standards', 'Search', eventLabel]);
	});

	function getComplianceDate(dt) {
		if (dt == null) {
			dt = new Date();
		}
		var day = dt.getDate();
		var month = dt.getMonth();
		var year = dt.getFullYear();
		var monthVal = months[month];
		var translatedDateVal = '';
		var translatedMonth = dateArray[monthVal];
		if (typeof differentDateFormat != 'undefined' && differentDateFormat != null && differentDateFormat == langCodeVal) {
		 	translatedDateVal =  (year+yearDateLabel+' '+translatedMonth+' '+(day < 10 ? '0' : '')+ day + dayDateLabel);
		} else {
		 	translatedDateVal =  ((day < 10 ? '0' : '') + day + ' ' + translatedMonth  +' ' + year);			  
		}
		return translatedDateVal;
	}
	
	$('div.ht_lifecycle img').click(function() {
		var $this = $(this);
		var imageId = $(this).attr('id');
		if($this.hasClass('ht_active')) {
			$this.removeClass('ht_active').addClass('ht_inactive');
			/* $(this).attr('src', path + imageId + '_' + brandCode + '.jpg'); */
			$(this).attr('src', path + imageId + '.jpg');
			$('input[value="'+imageId+'"]').prop('checked', false);
			/* $(this).prevAll('img').each(function(){
				imageId = $(this).attr('id');
				$('input[value="'+imageId+'"]').prop('checked',true);
				$(this).attr('src',path + imageId + '_' + brandCode + '.jpg');
			});
			$this.prevAll().removeClass('ht_inactive').addClass('ht_active');
			$(this).nextAll().each(function(){
				imageId = $(this).attr('id');
				$('input[value="'+imageId+'"]').prop('checked',false);
				$(this).attr('src', path + imageId + '.jpg');
			});
			$(this).nextAll(':checkbox').each(function(){
				imageId = $(this).attr('id');
				$(this).prop('checked',false);
			});
			$this.nextAll().removeClass('ht_active').addClass('ht_inactive'); */
		} else if ($this.hasClass('ht_inactive')) {
			$this.removeClass('ht_inactive').addClass('ht_active');
			$(this).attr('src', path + imageId + '_' + brandCode + '.jpg');
			$('input[value="'+imageId+'"]').prop('checked',true);
			/* $(this).prevAll('img').each(function(){
			    imageId = $(this).attr('id');
				$('input[value="'+imageId+'"]').prop('checked',true);
				$(this).attr('src',path + imageId +'_' + brandCode + '.jpg');
			});
			$this.prevAll().removeClass('ht_inactive').addClass('ht_active');
			$(this).nextAll('img').each(function(){
				imageId = $(this).attr('id');
				$('input[value="'+imageId+'"]').prop('checked',false);
				$(this).attr('src', path + imageId + '.jpg');
			});
			$this.nextAll().removeClass('ht_active').addClass('ht_inactive'); */
		}
		hotelLifecycleGroup();
		
        buildInd = true;
		specialismGroup();
    	updateFiltersTotal();
	});
	
	function updateHotelLiferCycleIcons() {
		$('div.ht_lifecycle img').each(function(){
			imageId = $(this).attr('id');
			$('input[value="'+imageId+'"]').prop('checked',false);
			$(this).attr('src', path + imageId + '.jpg');
			$(this).removeClass('ht_active').addClass('ht_inactive');
		});	
		hotelLifecycleGroup();
	    updateFiltersTotal();
	}
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
	<% } else if(strSearchOptions.equals("exact")) { %>
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
	<% } else if(strSearchOptions.equals("any")) { %>
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
	<p class="pull-right"><strong style="font-style:italic;"><span class="numOfFilters">0 ${filtersApply}</span></strong></p>
	<div class="clearfix"></div>
	
	<div class="accordion" id="searchstandardaccordion">    
		<h3 class="hotelLifecycleGroup">${byHotelLifeCycle} <span style="display: inline-block; text-align:right;" class="filterNum"></span></h3>  
		<div class="accordion-inner hotelLifecycleGroup">
	 		<div class="row">
				<p class="span6"><em>${byHotelLifeCycleNote}</em></p>
				<div class="span4" style="text-align:right;">
                  	${check}: 
                  	<span class="btn" id="hotelLifecycleGroupAll" >${searchAll }</span>
                  	<span class="btn" id="hotelLifecycleGroupNone">${searchNone}</span>
               	</div>
			</div>
			<%	
				FlagCategory flagCategory = FlagCategoryLocalServiceUtil.getFlagCategory(91);
				List<FlagCategory> flagCategoriesOrginal = FlagCategoryLocalServiceUtil.getFlagCategoryByParentId(91);
				List<FlagCategory> flagCategories = new ArrayList<FlagCategory>();
				flagCategories.addAll(flagCategoriesOrginal);
				Collections.reverse(flagCategories);
				List<FlagCategory> arlFlagCategory = new ArrayList<FlagCategory>();
			%>
			<div class="row">
				<div class="span3">
					<div class="ht_lifecycle">                  
      		<%	String showDisabled = "";
				String checked = "";
             	if (contentType.equalsIgnoreCase("OPERATE")) {
             	    showDisabled = "disabled='disabled'";
   				}
				for (FlagCategory flgOption : flagCategories) {
					checked = "";
         			if ( (!contentType.equalsIgnoreCase("OPERATE") && !BrandStandardsUtil.isNullOrBlank(arlHoteLifecycle) && arlHoteLifecycle.contains(flgOption.getFlagCatId()+"")) ) {
         					//|| (!(contentType.equalsIgnoreCase("OPERATE")) && !isSearchOn) ) {
               			checked = "checked='checked'";
      				} else if(contentType.equalsIgnoreCase("OPERATE")) {
         				showDisabled = "disabled='disabled'";
         				checked = "";
         			}
			%>
				<input id="hotelLifecycle" name ="hotelLifecycle" type="checkbox" value="<%=flgOption.getFlagCatId()%>" <%=checked%> <%=showDisabled%> style="display:none;" />
				<img src="<%=imagePath + flgOption.getFlagCatId() + ((showDisabled.length() < 1 && checked.length() > 0) ? "_" + brandCode: "") + ".jpg"%>" 
					path="<%=imagePath%>" <%=showDisabled.length() > 0 ? "": (checked.length() > 0) ? "class='ht_active'":"class='ht_inactive'"%> id="<%=flgOption.getFlagCatId()%>" />
			<%		
				} 
			%>
					</div>
				</div>
			</div>   
		</div>
		    
	    <h3 class="specialismGroup">${bySpecialism} <span style="display: inline-block; text-align:right;" class="filterNum"></span></h3>  
		<div class="accordion-inner specialismGroup">
           	<div class="row">
               	<p class="span6"><em>${bySpecialismNote}</em></p>
               	<div class="span4" style="text-align:right;">
                  	${check}: 
                  	<span class="btn" id="specialismGroupAll" >${searchAll }</span>
                  	<span class="btn" id="specialismGroupNone">${searchNone}</span>
               	</div>
				<p style="text-align:right;float:right;">${bssAbbreviation}</p>
			</div>
			<div class="row">
			<%	int size = spcialismFlagCategories.size();
                int sizeBy3 = Math.round(size/3) + 1;
                showDisabled = "";
				int rowCount = 0;
				for (FlagCategory flgOption : spcialismFlagCategories) {
					long flgId = flgOption.getFlagCatId();
					checked = "";
					if (contentType.equalsIgnoreCase("OPERATE")) {
						/* Digital Channels and IHG Rewards accessible.*/
						showDisabled = "disabled='disabled'";
					}
					if(flgOption.getFlagCatId() == 480) {  /* CR 50.3 If build & design, poiont it to manual-Build type.*/
						flgOption.setFlagCatId(257);
					}
			%>
					<script type="text/javascript">
						if (specialismOpt && specialismOpt.length > 0) {
						    specialismOpt += ",";
						}
						specialismOpt += <%=flgOption.getFlagCatId()%>; 
					</script>
			<%		if(rowCount == 0 || rowCount == sizeBy3 || rowCount == (sizeBy3 * 2)) { %>
                		<div class="span3">
			<% 		}
					if(!BrandStandardsUtil.isNullOrBlank(arlSpecialism) &&  arlSpecialism.contains(flgOption.getFlagCatId() + "")) {
						checked = "checked='checked'";        
					}
			%>		
                   <label class="checkbox"><input id="specialism" name ="specialism" type="checkbox" 
                   		value="<%=flgOption.getFlagCatId()%>" <%=checked%> <%=showDisabled%> ><%=request.getAttribute(String.valueOf(flgId))%></label>
			<% 		if(rowCount == (sizeBy3 - 1) || rowCount == ((sizeBy3 * 2) - 1) || size == rowCount + 1) { %>
						</div>
			<% 		}
					rowCount++;
               	}
			%>
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
				arlFlagCategory = new ArrayList<FlagCategory>();
			%>
			<div class="row">
			<%	size = flagCategories.size();
				sizeBy3 = Math.round(size/3) + 1;
				showDisabled = "";
				rowCount = 0;
				for(FlagCategory flgOption : flagCategories) {	
					if(rowCount == 0 || rowCount == sizeBy3 || rowCount == (sizeBy3 * 2)) {
			%>
				<div class="span3">
			<%		}
					if(!BrandStandardsUtil.isNullOrBlank(arlDeptApplicability)) { 	
						boolean found = arlDeptApplicability.contains(flgOption.getFlagCatId()+"");
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
			<div class="row"><p class="span6"><em>${hotelLocationNote}</em></p>
				<div class="span4" style="text-align:right;">
                   	${check}: 
                   	<span class="btn" id="hotelLocationGroupAll">${searchAll}</span>
                   	<span class="btn" id="hotelLocationGroupNone">${searchNone}</span>
				</div>
			</div>
			<%	
			 	flagCategory = FlagCategoryLocalServiceUtil.getFlagCategory(25);
			 	flagCategories = FlagCategoryLocalServiceUtil.getFlagCategoryByParentId(25);	
			 	arlFlagCategory = BrandStandardsUtil.sortFlagCategories(flagCategories);
			%>
			<div class="row">
			<%	size = arlFlagCategory.size();
              	sizeBy3 = Math.round(size/3)+1;
              	rowCount = 0;
              	showDisabled="";
               	for(FlagCategory flgOption : arlFlagCategory) {	
					if(rowCount == 0 || rowCount == sizeBy3 || rowCount == (sizeBy3 * 2)) {
			%>
						<div class="span3">
			<%		}
					if(!BrandStandardsUtil.isNullOrBlank(arlLocHotel)) { 	
						boolean found = false;
						for(int i = 0; i < arlLocHotel.size(); i++) {
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
			<% 		}
  					if(rowCount == (sizeBy3 - 1) || rowCount == ((sizeBy3 * 2) - 1) || size == rowCount + 1) {
           	%>
           				</div>
           	<%		}
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
					if(rowCount == 0 || rowCount == sizeBy3 || rowCount == (sizeBy3 * 2)) {
			%>	
						<div class="span3"><%
					}
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
			<%			} else {%>		
							<label class="checkbox"><input type="checkbox"  id="guestJourney" name="guestJourney" 
								value="<%=flgOption.getFlagCatId()%>" <%=showDisabled %>><%=request.getAttribute(String.valueOf(flgOption.getFlagCatId()))%></label>
			<%			}
					} else {
			%>		
						<label class="checkbox"><input type="checkbox" id="guestJourney" name="guestJourney" 
							value="<%=flgOption.getFlagCatId()%>" <%=showDisabled %>><%=request.getAttribute(String.valueOf(flgOption.getFlagCatId()))%></label>
			<%		}
					if(rowCount == (sizeBy3 - 1) || rowCount == ((sizeBy3 * 2) - 1) || size == rowCount + 1) {
			%>
						</div>
			<%
					}
					rowCount++;
				}
			%>
			</div>
		</div>
		
	  	<h3 class="complianceGroup">${byComplianceDeadline}<span style="display: inline-block; text-align:right;" id="horizon" class="filterNum"></span></h3>
		<div class="accordion-inner complianceGroup">
			<div class="row">
               	<p class="span6"><em>${complianceDeadlineNote}:</em></p>
				<div class="span4" style="text-align:right;">
                   	<span id="complianceDateNone" class="btn">${clearSearch}</span>
				</div>
			</div>
			<div class="row">
		<%	if(strComplianceDate!=null && strComplianceDate.equals("0d")) { %>
				<div class="span2"><label class="radio"><input id="compDeadline" name="compDeadline" type="radio" value="0d" checked="checked">${searchNow}</label></div>
				<div class="span2"><label class="radio"><input id="compDeadline" name="compDeadline" type="radio" value="7d">${nextSevenDays}</label></div>
				<div class="span2"><label class="radio"><input id="compDeadline" name="compDeadline" type="radio" value="1m">${nextMonth}</label></div>
				<div class="span2"><label class="radio"><input id="compDeadline" name="compDeadline" type="radio" value="3m">${nextQuarter}</label></div>
			</div>
			<div class="row">
            	<div class="span2"><label class="radio"><input id="compDeadline" name="compDeadline" type="radio" value="6m">${nextSixMonths}</label></div>
            	<div class="span2"><label class="radio"><input id="compDeadline" name="compDeadline" type="radio" value="12m">${next12Months}</label></div>
            	<div class="span2"><label class="radio"><input id="compDeadline" name="compDeadline" type="radio" value="12m+">${beyond12Months}</label></div>
		<%	} else if(strComplianceDate!=null && strComplianceDate.equals("7d")) {  %>
				<div class="span2"><label class="radio"><input id="compDeadline" name="compDeadline" type="radio" value="0d">${searchNow}</label></div>
				<div class="span2"><label class="radio"><input id="compDeadline" name="compDeadline" type="radio" value="7d"  checked="checked">${nextSevenDays}</label></div>
				<div class="span2"><label class="radio"><input id="compDeadline" name="compDeadline" type="radio" value="1m">${nextMonth}</label></div>
				<div class="span2"><label class="radio"><input id="compDeadline" name="compDeadline" type="radio" value="3m">${nextQuarter}</label></div>
			</div>
			<div class="row">
				<div class="span2"><label class="radio"><input id="compDeadline" name="compDeadline" type="radio" value="6m">${nextSixMonths}</label></div>
				<div class="span2"><label class="radio"><input id="compDeadline" name="compDeadline" type="radio" value="12m">${next12Months}</label></div>
				<div class="span2"><label class="radio"><input id="compDeadline" name="compDeadline" type="radio" value="12m+">${beyond12Months}</label></div>
		<% } else if(strComplianceDate!=null && strComplianceDate.equals("1m")) {  %>
				<div class="span2"><label class="radio"><input id="compDeadline" name="compDeadline" type="radio" value="0d">${searchNow}</label></div>
				<div class="span2"><label class="radio"><input id="compDeadline" name="compDeadline" type="radio" value="7d">${nextSevenDays}</label></div>
				<div class="span2"><label class="radio"><input id="compDeadline" name="compDeadline" type="radio" value="1m"  checked="checked">${nextMonth}</label></div>
				<div class="span2"><label class="radio"><input id="compDeadline" name="compDeadline" type="radio" value="3m">${nextQuarter}</label></div>
			</div>
			<div class="row">
  				<div class="span2"><label class="radio"><input id="compDeadline" name="compDeadline" type="radio" value="6m">${nextSixMonths}</label></div>
				<div class="span2"><label class="radio"><input id="compDeadline" name="compDeadline" type="radio" value="12m">${next12Months}</label></div>
				<div class="span2"><label class="radio"><input id="compDeadline" name="compDeadline" type="radio" value="12m+">${beyond12Months}</label></div>
		<% } else if(strComplianceDate!=null && strComplianceDate.equals("3m")) {  %>
				<div class="span2"><label class="radio"><input id="compDeadline" name="compDeadline" type="radio" value="0d">${searchNow}</label></div>
				<div class="span2"><label class="radio"><input id="compDeadline" name="compDeadline" type="radio" value="7d">${nextSevenDays}</label></div>
				<div class="span2"><label class="radio"><input id="compDeadline" name="compDeadline" type="radio" value="1m">${nextMonth}</label></div>
				<div class="span2"><label class="radio"><input id="compDeadline" name="compDeadline" type="radio" value="3m"  checked="checked">${nextQuarter}</label></div>
			</div>
				<div class="row">
				<div class="span2"><label class="radio"><input id="compDeadline" name="compDeadline" type="radio" value="6m">${nextSixMonths}</label></div>
				<div class="span2"><label class="radio"><input id="compDeadline" name="compDeadline" type="radio" value="12m">${next12Months}</label></div>
				<div class="span2"><label class="radio"><input id="compDeadline" name="compDeadline" type="radio" value="12m+">${beyond12Months}</label></div>
		<% } else if(strComplianceDate!=null && strComplianceDate.equals("6m")) {  %>
				<div class="span2"><label class="radio"><input id="compDeadline" name="compDeadline" type="radio" value="0d">${searchNow}</label></div>
				<div class="span2"><label class="radio"><input id="compDeadline" name="compDeadline" type="radio" value="7d">${nextSevenDays}</label></div>
				<div class="span2"><label class="radio"><input id="compDeadline" name="compDeadline" type="radio" value="1m">${nextMonth}</label></div>
				<div class="span2"><label class="radio"><input id="compDeadline" name="compDeadline" type="radio" value="3m">${nextQuarter}</label></div>
			</div>
				<div class="row">
				<div class="span2"><label class="radio"><input id="compDeadline" name="compDeadline" type="radio" value="6m"  checked="checked">${nextSixMonths}</label></div>
				<div class="span2"><label class="radio"><input id="compDeadline" name="compDeadline" type="radio" value="12m">${next12Months}</label></div>
				<div class="span2"><label class="radio"><input id="compDeadline" name="compDeadline" type="radio" value="12m+">${beyond12Months}</label></div>
		<% } else if(strComplianceDate!=null && strComplianceDate.equals("12m")) {  %>
				<div class="span2"><label class="radio"><input id="compDeadline" name="compDeadline" type="radio" value="0d">${searchNow}</label></div>
				<div class="span2"><label class="radio"><input id="compDeadline" name="compDeadline" type="radio" value="7d">${nextSevenDays}</label></div>
				<div class="span2"><label class="radio"><input id="compDeadline" name="compDeadline" type="radio" value="1m">${nextMonth}</label></div>
				<div class="span2"><label class="radio"><input id="compDeadline" name="compDeadline" type="radio" value="3m">${nextQuarter}</label></div>
			</div>
				<div class="row">
				<div class="span2"><label class="radio"><input id="compDeadline" name="compDeadline" type="radio" value="6m">${nextSixMonths}</label></div>
				<div class="span2"><label class="radio"><input id="compDeadline" name="compDeadline" type="radio" value="12m"  checked="checked">${next12Months}</label></div>
				<div class="span2"><label class="radio"><input id="compDeadline" name="compDeadline" type="radio" value="12m+">${beyond12Months}</label></div>
		<% } else if(strComplianceDate!=null && strComplianceDate.equals("12m+")) {  %>
				<div class="span2"><label class="radio"><input id="compDeadline" name="compDeadline" type="radio" value="0d">${searchNow}</label></div>
				<div class="span2"><label class="radio"><input id="compDeadline" name="compDeadline" type="radio" value="7d">${nextSevenDays}</label></div>
				<div class="span2"><label class="radio"><input id="compDeadline" name="compDeadline" type="radio" value="1m">${nextMonth}</label></div>
				<div class="span2"><label class="radio"><input id="compDeadline" name="compDeadline" type="radio" value="3m">${nextQuarter}</label></div>
				</div>
			<div class="row">
				<div class="span2"><label class="radio"><input id="compDeadline" name="compDeadline" type="radio" value="6m">${nextSixMonths}</label></div>
				<div class="span2"><label class="radio"><input id="compDeadline" name="compDeadline" type="radio" value="12m">${next12Months}</label></div>
				<div class="span2"><label class="radio"><input id="compDeadline" name="compDeadline" type="radio" value="12m+"  checked="checked">${beyond12Months}</label></div>
		<% } else { %>
				<div class="span2"><label class="radio"><input id="compDeadline" name="compDeadline" type="radio" value="0d">${searchNow}</label></div>
				<div class="span2"><label class="radio"><input id="compDeadline" name="compDeadline" type="radio" value="7d">${nextSevenDays}</label></div>
				<div class="span2"><label class="radio"><input id="compDeadline" name="compDeadline" type="radio" value="1m">${nextMonth}</label></div>
				<div class="span2"><label class="radio"><input id="compDeadline" name="compDeadline" type="radio" value="3m">${nextQuarter}</label></div>
			</div>
				<div class="row">
				<div class="span2"><label class="radio"><input id="compDeadline" name="compDeadline" type="radio" value="6m">${nextSixMonths}</label></div>
				<div class="span2"><label class="radio"><input id="compDeadline" name="compDeadline" type="radio" value="12m">${next12Months}</label></div>
				<div class="span2"><label class="radio"><input id="compDeadline" name="compDeadline" type="radio" value="12m+">${beyond12Months}</label></div>
		<% } %>
			</div>
			<div class="row"><br></div>
		</div>
             
		<h3 class="supportingMaterialGroup">${bySupportingMaterial} <span style="display: inline-block; text-align:right;" class="filterNum"></span></h3>
        <div class="accordion-inner supportingMaterialGroup">
			<div class="row">
				<p class="span6"></p>
				<div class="span4" style="text-align:right;">
              		<span id="supportingMaterialGroupNone" class="btn">${clearSearch}</span>
                </div>
			</div>
			<div class="row">
				<div class="span3">
               	<% if("Y".equals(strHasAttachments)) { %>
                  	<label class="radio"><input name="supportingMaterial" id="supportingMaterial" type="radio" value="hasAttachments" checked="checked">${hasAttachments}</label>
				<% } else { %>
                   	<label class="radio"><input name="supportingMaterial" id="supportingMaterial" type="radio" value="hasAttachments">${hasAttachments}</label>
				<% } %>
				</div>
      			<div class="span3">
				<% if("Y".equals(strHasLinks)) { %>
                  	<label class="radio"><input name="supportingMaterial" id="supportingMaterial" type="radio" value="hasLinks" checked="checked">${hasLinks}</label>
				<% } else { %>
                   	<label class="radio"><input name="supportingMaterial" id="supportingMaterial" type="radio" value="hasLinks">${hasLinks}</label>
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