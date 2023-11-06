var menu=function()
{
	var t=15,z=50,s=6,a;
	function dd(n){this.n=n; this.h=[]; this.c=[]}
	dd.prototype.init=function(p,c){
		a=c; var w=document.getElementById(p), s=w.getElementsByTagName('ul'), l=s.length, i=0;
		for(i;i<l;i++){
			var h=s[i].parentNode; this.h[i]=h; this.c[i]=s[i];
			h.onmouseover=new Function(this.n+'.st('+i+',true)');
			h.onmouseout=new Function(this.n+'.st('+i+')');
		}
	}
	dd.prototype.st=function(x,f){
		var c=this.c[x], h=this.h[x], p=h.getElementsByTagName('a')[0];
		clearInterval(c.t); c.style.overflow='hidden';
		if(f){
			p.className+=' '+a;
			if(!c.mh){c.style.display='block'; c.style.height=''; c.mh=c.offsetHeight; c.style.height=0}
			if(c.mh==c.offsetHeight){c.style.overflow='visible'}
			else{c.style.zIndex=z; z++; c.t=setInterval(function(){sl(c,1)},t)}
		}else{p.className=p.className.replace(a,''); c.t=setInterval(function(){sl(c,-1)},t)}
	}
	function sl(c,f){
		var h=c.offsetHeight;
		if((h<=0&&f!=1)||(h>=c.mh&&f==1)){
			if(f==1){c.style.filter=''; c.style.opacity=1; c.style.overflow='visible'}
			clearInterval(c.t); return
		}
		var d=(f==1)?Math.ceil((c.mh-h)/s):Math.ceil(h/s), o=h/c.mh;
		c.style.opacity=o; c.style.filter='alpha(opacity='+(o*100)+')';
		c.style.height=h+(d*f)+'px'
	}
	return{dd:dd}
}();

function getExportReport(url)
{
    location.href = url;
};

function submitReportRequest(url, postData)
{
    jQuery("#overlay").fadeIn();
    jQuery.ajax({
		type: "POST",
        url: url,
        data: postData
    }).done( function(data) {
        jQuery("#overlay").fadeOut();
        jQuery.msgBox({
            type:"info",
            content:"An email with a link to your Report will be sent to you once the Report has been generated. \n" +
/*                  "This Report containing the results above will only be available for 7 days from when you receive the e-mail.",*/
                    "This Report will only be available for 7 days from when you receive the e-mail.",
            buttons: [{ value: "OK" }]
        });
    }).fail( function(jqXHR) {
        jQuery("#overlay").fadeOut();
        /*alert("AJAX request failed with status:" + jqXHR.statusText + " status code:" + jqXHR.status);*/
    });
};

function updateResults()
{
	 var frm = document.forms.filterForm;
     var varSelectTo = "";
     var x = 0;
	/*alert(document.getElementById("selectto").value);*/
     var varFilterText = document.getElementById("filterText").value;
     /*alert(varFilterText);*/
}

function validateAuditLog()
{
	var flag = true;
	
	if(jQuery("#auditLogFilter").is(':checked'))
    {
		if( jQuery("#logCreatedBy").val() == "")
		{
			jQuery.msgBox("Please select a user or a region.");
			flag =  false;
		}
		if(jQuery("#logCreatedBy").val() != "" && jQuery("#logRelativeCriteria").val() == "")
		{
			jQuery.msgBox("Please select a date criteria.");
			flag =  false;
		}
		if(jQuery("#logRelativeCriteria").val() == "since" && jQuery("#auditLogDate").val() == "")
		{
			jQuery.msgBox("Please select a date from the past.");
			flag =  false;
		}
		if(jQuery("#logRelativeCriteria").val() == "since" && jQuery("#auditLogDate").val() != "")
		{
			var dateVal = jQuery("#auditLogDate").datepicker("getDate");
	    	if(dateVal > new Date())
	    	{
	    		 jQuery.msgBox("Please select a date from the past.");
	    		 flag = false;
	    	}

		}
    }
	return flag;
}

jQuery(function(){

	var nodeId = '';
	var nodeText = '';
	
    jQuery('.nyroModal').nyroModal();
    
    jQuery('.open_tree_selection').click(function(){
    	nodeId = '';
    	nodeText = '';
    	jQuery(".selected_tree_node").text('nothing yet'); 
    	jQuery("#taxonomy_tree_details").click();
        jQuery('.modal_title_text').html("description");
   	    getTreeData();
        return false;
    });

    jQuery(".multis").multiselect();
	jQuery.datepicker.setDefaults({showOn: 'both', buttonImageOnly: true, buttonImage: '/BSTheme-theme/images/calendar_icon.png'});
	jQuery(".datepicker").datepicker({buttonText: 'Select Date', dateFormat: 'dd-M-yy', changeMonth: true, changeYear: true});

	for (iReg1=0;iReg1<regions.length;iReg1++){
		jQuery('<option/>').val(regions[iReg1].region_cd).html(regions[iReg1].region_nm).appendTo('#standard_regions');
	}

    /* if Measurement (id="measurement") -> On-site Evaluation is selected then enable GEM Reporting Categories (id="gemReportCategory")*/
    jQuery("select#gemReportCategory").multiselect();
    jQuery("select#measurement").multiselect();
    jQuery("select#gemReportCategory").multiselect("disable");
    jQuery.map(jQuery("select#measurement").multiselect("getChecked"), function( input ){
        if (input.value === "323")
        {
            jQuery("select#gemReportCategory").multiselect("enable");
        }
        return input.value;
	});

	/*filter results*/
	jQuery(".filter_results_button").click(function(e){

        if ( jQuery("#outsideofGuestJourney").is(':checked') )
        {
            jQuery("select#guestJourney").multiselect("uncheckAll");
            jQuery("select#guestJourney").multiselect("disable");
        }
    
		jQuery(".filter_results_form").show();
		jQuery("div.advanced_filtering").hide();
		e.preventDefault();
		jQuery(".filter_results_button").unbind();
		/*do ajax call to filter results here.*/
	});
	
	jQuery(".apply_filter_button, .cancel_filter_button").click(function(e){
		e.preventDefault();
		jQuery("tr.submit_basic_filter").show();
		jQuery(".filter_results_form").hide();
	});

	/*results table*/
	jQuery(".view_details").click(function(){

		var parentId = jQuery(this).parent("td").siblings("td.parent_id").text();
		var hiddenDetails = jQuery(this).parent("td").parent("tr").siblings("._" + parentId);
		var theTitle = jQuery(this).attr("title");

		if( theTitle == "View Details" )
		{	
			jQuery(this).parent('td').parent('tr').css({color: "#fff", backgroundColor: "#d21d8e"});
			jQuery(hiddenDetails).show();
			jQuery(this).attr({title: "Close Details", alt: "Close Details"});
			jQuery(this).children("img").attr({src: "/BSTheme-theme/images/minus_viewless.png", title: "Close Details", alt: "Close Details Icon"});
		} 
		else 
		{
			jQuery(this).parent('td').parent('tr').css({color: "#000", backgroundColor: "#fff"});
			jQuery(hiddenDetails).hide();
			jQuery(this).attr({title: "View Details", alt: "View Details"});
			jQuery(this).children("img").attr({src: "/BSTheme-theme/images/plus_viewmore.png", title: "View Details", alt: "View Details Icon"});
		}
		return false;
	});

    showSpecificationsOnLoad();

    jQuery("#brand").multiselect({
        close: function(){  
            showFilterCount();
        }
    });
    jQuery("#searchStatus").multiselect({
        close: function(){  
            showFilterCount();
        }
    });
    jQuery("#techWriter").multiselect({
        close: function(){  
            showFilterCount();
        }
    });
    jQuery("#stdOwner").multiselect({
        close: function(){  
            showFilterCount();
        }
    });
    jQuery("#category").multiselect({
        close: function(){  
            showFilterCount();
        }
    });
    jQuery("#deptApplicability").multiselect({
        close: function(){  
            showFilterCount();
        }
    });
    jQuery("#importance").multiselect({
        close: function(){  
            showFilterCount();
        }
    });
    jQuery("#guestJourney").multiselect({
        close: function(){  
            showFilterCount();
        }
    });
    jQuery("#locHotel").multiselect({
        close: function(){  
            showFilterCount();
        }
    });
    jQuery("#corpDept").multiselect({
        close: function(){  
            showFilterCount();
        }
    });
    jQuery("#wheelQuadrant").multiselect({
        close: function(){  
            showFilterCount();
        }
    });
    jQuery("#ownershipType").multiselect({
        close: function(){  
            showFilterCount();
        }
    });
    jQuery("#designDiscipline").multiselect({
        close: function(){  
            showFilterCount();
        }
    });
    jQuery("#risk").multiselect({
        close: function(){  
            showFilterCount();
        }
    });
    jQuery("#measurement").multiselect({
        close: function(){  
            var isSelected = false;
            jQuery.map(jQuery("select#measurement").multiselect("getChecked"), function( input ){
                if (input.value === "323")
                {
                    isSelected = true;
                }
                return input.value;
            });
            
            if (isSelected)
            {
                jQuery("select#gemReportCategory").multiselect("enable");
            }
            else
            {
                jQuery("select#gemReportCategory").multiselect("uncheckAll");
                jQuery("select#gemReportCategory").multiselect("disable");
            }
        
            showFilterCount();
        }
    });
	/*jQuery("#hotellifecycle").multiselect({
        close: function(){  
            showFilterCount();
        }
    });*/
	jQuery("#specialistarea").multiselect({
        close: function(){  
            showFilterCount();
        }
    });
	jQuery("#digital").multiselect({
        close: function(){  
            showFilterCount();
        }
    });
    jQuery("#attachmentType").multiselect({
        close: function(){  
            showFilterCount();
        }
    });
    jQuery("#changeType").multiselect({
        close: function(){  
            showFilterCount();
        }
    });
    jQuery("#recordId").change(function(){
        showFilterCount();
    });
    jQuery("#filterText").change(function(){
        showFilterCount();
    });
    jQuery("#impactComments").change(function(){
        showFilterCount();
    });
    jQuery("#filterRationale").change(function(){
        showFilterCount();
    });
    jQuery("#internal_reference").change(function(){
        showFilterCount();
    });
    jQuery("#indexHeading").change(function(){
        showFilterCount();
    });
    jQuery("#brandHallmark").change(function(){
        showFilterCount();
    });
    jQuery("#hasLinks").change(function(){
        showFilterCount();
    });
    jQuery("#hasGuidelines").change(function(){
        showFilterCount();
    });
    jQuery("#historicalManual").change(function(){
        showFilterCount();
    });
    jQuery("#outsideofGuestJourney").change(function(){
        showFilterCount();
    }); 
    jQuery("#manual").change(function(){
        showFilterCount();
    }); 
	jQuery("#hasCrossReference").change(function(){
        showFilterCount();
    });
    jQuery("#plImpact").multiselect({
        close: function(){  
            showFilterCount();
        }
    });
    jQuery("#changeFromRegional").multiselect({
        close: function(){  
            showFilterCount();
        }
    });
    jQuery("#capExImpact").multiselect({
        close: function(){  
            showFilterCount();
        }
    });
    jQuery("#implementationImpact").multiselect({
        close: function(){  
            showFilterCount();
        }
    });

    jQuery(".adv_filter_button").click(function(){
        jQuery(".advanced_filtering").show('slow');
        jQuery("tr.submit_basic_filter").hide();
    });
                        
    jQuery(".basic_filter_button").click(function(){
        jQuery("tr.submit_basic_filter").show();
        jQuery(".advanced_filtering").hide(400);
    });

    jQuery("table").delegate("tr td img.delete_this_image", "click", function(event){
        jQuery(this).parent('td').parent('tr').remove();
        showFilterCount();
        return false;
    });

    jQuery("table").delegate("tr td img.clear_this_index", "click", function(event){
        jQuery("#tree_selection").val("");
        jQuery("#indexHeading").val("");
        disableBranchSearchRadioButtons();
        showFilterCount();
        return false;
    });

    jQuery("table").delegate("tr td img.clear_launch_date", "click", function(event){
        jQuery("#fromLaunchDate").val("");
        jQuery("#toLaunchDate").val("");
        showFilterCount();
        return false;
    });
    
    jQuery("table").delegate("tr td img.clear_compliance_deadline", "click", function(event){
        jQuery("#fromComplianceDate").val("");
        jQuery("#toComplianceDate").val("");
        showFilterCount();
        return false;
    });

    jQuery("table").delegate("tr td img.clear_std_text", "click", function(event){
        jQuery("#filterText").val("");
        showFilterCount();
        return false;
    });
    
    jQuery("table").delegate("tr td img.clear_std_id", "click", function(event){
        jQuery("#recordId").val("");
        showFilterCount();
        return false;
    });

    jQuery("table").delegate("tr td img.clear_rationale", "click", function(event){
        jQuery("#filterRationale").val("");
        showFilterCount();
        return false;
    });
    
    jQuery(".run_reports").click(function(){
        var theReportId = jQuery(".accordionContent").children().find("input:checked").val();
        jQuery(".reports").hide();
        if(theReportId == "" || theReportId == null){
            jQuery.msgBox("Please choose a report.");
            return false;
        }else if(theReportId=='147'){
        	var reportBrands = jQuery("#reportBrands").val();
        	if(reportBrands==null){
        		jQuery.msgBox("Please select Brand.");
    			return false;	
        	}
        }
        
        var requireLocale = jQuery(".accordionContent").children().find("input:checked").attr("require_locale");
        if (requireLocale === "true")
        {
            var secLang = jQuery("#report_lang_select option:selected").val();
            if (!secLang)
            {
                jQuery.msgBox("Please select language.");
                return false;
            }
        }
        
        var theReport = jQuery(".accordionContent").children().find("input:checked");
        if(jQuery(theReport).attr("report_type") == "content_report")
        {
        	runContentReport(theReportId);
        }
        else
        {
            runFullReport(theReportId)
        }
        theReport.prop('checked', false);
        jQuery("select#report_lang_select option").removeAttr("selected");
        jQuery("#reportTitle").val(null);
        $("#reportType").val(null);
        $("#reportBrands").multiselect("uncheckAll");
        $('.attachmentLinkFields').hide();
		$('.otherReportFields').show();
		
        return false;
    });
	
	jQuery(".process").click(function(){

        var importLang = jQuery("#import_lang").val();
		var exportLang = jQuery("#export_lang").val();
		var exportReportTitle = jQuery("#export_report_title").val();
		var file = jQuery("#file").val();
		
		if ( exportLang != "-1")
		{
			runExportTranslationReport(exportLang,exportReportTitle);
		}
		else if (importLang!="-1" && file!="")
		{
			runImportTranslationReport(importLang, file);
		}
		else
		{
			alert('Enable to Process Action');
		}
		jQuery(".process_btn").addClass("disable_a_href");
		return false;
    });
    
    jQuery(".open_reports").click(function(){
        jQuery(".reports").show();
    });

    jQuery(".cancel_reports").click(function(){
        checkedValues = [];
        jQuery(".reports").hide();
        var theReport = jQuery(".accordionContent").children().find("input:checked");
        theReport.prop('checked', false);
        jQuery("select#report_lang_select option").removeAttr("selected");
        jQuery("#reportTitle").val(null);
        $('.attachmentLinkFields').hide();
		$('.otherReportFields').show();
    });

	jQuery(".open_translation").click(function(){
        jQuery(".translation").show();
    });	
	
	jQuery(".cancel_translation").click(function(){
        checkedValues = [];
        jQuery(".translation").hide();
        var theItem = jQuery(".accordionContent").children().find("input:checked");
        theItem.attr("checked", "");
    });

    jQuery('.reports .accordionButton').click(function() {
        jQuery('.reports div.accordionContent').slideUp('normal');	
        jQuery(this).next().slideDown('normal');
    });
	 jQuery('.translation .accordionButton').click(function() {
        jQuery('.translation div.accordionContent').slideUp('normal');	
        jQuery(this).next().slideDown('normal');
    }); 
    jQuery("div.accordionContent").hide();
       
    jQuery("#open").trigger('click');
	jQuery("#open_translation").trigger('click');

    jQuery('div.filter_results_form').keypress(function (e) {
        if (e.which == 13) {
            showFilter();
            return false;
        }
    });

    jQuery('textarea#cmt_txt_area[maxlength]').keyup(function(){  
        /*get the limit from maxlength attribute*/  
        var limit = parseInt(jQuery(this).attr('maxlength'));  
        /*get the current text inside the textarea*/  
        var text = jQuery(this).val();  
        /*count the number of characters in the text*/  
        var chars = text.length;  
  
        /*check if there are more characters then allowed*/  
        if(chars > limit){  
            /*and if there are use substr to get the text before the limit*/  
            var new_text = text.substr(0, limit);  
  
            /*and change the current text with the new text*/  
            jQuery(this).val(new_text);  
        }  
    });  

    jQuery("#recordId").bind('paste', function () {
        var element = this;
        setTimeout(function () {
            var newVal = jQuery(element).val().replace(/[^0-9 ]+/g, '').trim();
            newVal = newVal.replace(/\s{2,}/g, ' ').trim();
            jQuery(element).val(newVal);
            showFilterCount();
        }, 200);
    });

    jQuery("#recordId").keydown(function(event) {
        /* Allow: escape, backspace, delete, tab,*/ 
        if ( event.keyCode == 27 || event.keyCode == 46 || event.keyCode == 8 || event.keyCode == 9 || 
             /* Allow: space,           enter,                        home, end, left, right                  Ctrl*/
             event.keyCode == 32 || event.keyCode == 13 || (event.keyCode >= 35 && event.keyCode <= 40) || event.ctrlKey )
        {
            return;
        }
        else 
        {
            /* Ensure that it is a number and stop the keypress*/
            if (event.shiftKey || (event.keyCode < 48 || event.keyCode > 57) && (event.keyCode < 96 || event.keyCode > 105 )) 
            {
                event.preventDefault(); 
            }   
        }
    });
    
   
    
    jQuery("#logCreatedBy").hide();
    jQuery("#logRelativeCriteria").hide();
    jQuery("#auditLogDatePicker").hide();
    jQuery("#auditLogClearButton").hide();
	jQuery("#auditLogBrand").hide();

    
    jQuery('#auditLogFilter').click (function ()
    {
        var thisCheck = jQuery(this);
        if (thisCheck.is (':checked'))
        {
	
            jQuery("#logCreatedBy").show();
            jQuery("#logRelativeCriteria").show();
            jQuery("#auditLogClearButton").show();
			jQuery("#auditLogDatePicker").hide();
			jQuery("#auditLogBrand").show();
           
			
        }
        else
        {

            jQuery("#logCreatedBy").hide();
            jQuery("#logRelativeCriteria").hide();
            jQuery("#auditLogDatePicker").hide();
			jQuery("#auditLogClearButton").hide();
			jQuery("#auditLogBrand").hide();
			jQuery("#logCreatedBy").val("");
			jQuery("#auditLog_brand").multiselect("uncheckAll");   
			jQuery("#logRelativeCriteria").val("");
			jQuery("#auditLogDate").val("");
			
        }
    });
    
    if(jQuery("#auditLogFilter").is(':checked'))
    {
    	 jQuery("#logCreatedBy").show();
    	 jQuery("#logRelativeCriteria").show();
    	 jQuery("#auditLogDatePicker").hide();
		 jQuery("#auditLogBrand").show();
    }
   

    jQuery("select#logRelativeCriteria").change(function(){
	jQuery("#auditLogDate").val("");
        var val = jQuery(this).val(); 
        if(val == "since")
    	{
    		jQuery("#auditLogDatePicker").show();
			jQuery(".datepicker").datepicker({buttonText: 'Select Date', dateFormat: 'dd-M-yy', changeMonth: true, changeYear: true});
    	}
        if(val == "lastDay")
        {
        	jQuery("#auditLogDatePicker").hide();
        }
    });
    
    if(jQuery("#logRelativeCriteria").val() == "since")
    {
    	jQuery("#auditLogDatePicker").show();
		jQuery(".datepicker").datepicker({buttonText: 'Select Date', dateFormat: 'dd-M-yy', changeMonth: true, changeYear: true});
    }
    
    jQuery("table").delegate("tr td img.clear_audit_log_filter", "click", function(event){
        jQuery("#logCreatedBy").val("");
        jQuery("#auditLogFilter").attr('checked', false);
        jQuery("#auditLogDate").val("");
        jQuery("#logRelativeCriteria").val("");
        jQuery("#auditLogDatePicker").hide();
        jQuery("#logCreatedBy").hide();
        jQuery("#logRelativeCriteria").hide();
        jQuery("#auditLogClearButton").hide();
		jQuery("#auditLog_brand").multiselect("uncheckAll");   
		jQuery("#auditLogBrand").hide();
        showFilterCount();
        return false;
    });

    jQuery("#outsideofGuestJourney").click(function() {
        if(this.checked)
        {
            jQuery("select#guestJourney").multiselect("uncheckAll");
            jQuery("select#guestJourney").multiselect("disable");
        }
        else
        {
            jQuery("select#guestJourney").multiselect("enable");
        }
    });
    
    jQuery("#auditLogDate").datepicker("option","maxDate", "+0m +0w + 0d");
	
	/************* Add for CR 50.2 change *********/
	$('div.ht_lifecycle img').click(function(){
		var $this = $(this);
		var path = $(this).attr('path');
		var path = "/BSTheme-theme/images/";
		var imageId = $(this).attr('id');
		if($this.hasClass('ht_active'))
		{
			$(this).attr('src',path+imageId+'_active.png');
			$(this).prevAll().each(function(){
				imageId = $(this).attr('id');
				$(this).attr('src',path+imageId+'_active.png');
			});
			$this.prevAll().removeClass('ht_inactive').addClass('ht_active');
			$(this).nextAll().each(function(){
				imageId = $(this).attr('id');
				$(this).attr('src',path+imageId+'_inactive.png');
			});
			$this.nextAll().removeClass('ht_active').addClass('ht_inactive');
			var prevAllLen = $(this).prev().length;
			if(prevAllLen == 0 )	
			{
				$(this).attr('src',path+$(this).attr('id')+'_inactive.png');
				$this.removeClass('ht_active').addClass('ht_inactive');
			}
		}
		else
		{
			$this.removeClass('ht_inactive').addClass('ht_active');
			$(this).attr('src',path+imageId+'_active.png');
			$(this).prevAll().each(function(){
				imageId = $(this).attr('id');
				$(this).attr('src',path+imageId+'_active.png');
			});
			$this.prevAll().removeClass('ht_inactive').addClass('ht_active');
			$(this).nextAll().each(function(){
				imageId = $(this).attr('id');
				$(this).attr('src',path+imageId+'_inactive.png');
			});
			$this.nextAll().removeClass('ht_active').addClass('ht_inactive');
		}
		hotelLifeCycleFlagSelection();
		showFilterCount();
	});
	
	/************* End for CR 50.2 change *********/
});

function duplicateAssignedImage(newImgId)
{
    var duplicate = false;
    
    jQuery('table#filter_image_table tr.table_links_list').children('td.this_link').each(function(){
        var input = jQuery(this).children('input');
        var varType = jQuery(input).attr("var_type");
        if ( varType == "imgId" ) 
        {
            var val = jQuery(input).val();
            var curId = val.substring(0, val.indexOf("==="));
            if (curId == newImgId )
            {
                duplicate = true;
                return false;
            }
        }
    });
    return duplicate;
};

function addAssignedImage(selectImgTbl)
{
    var imgTitle = "";
    var imgId = 0;
    var insertedNewRow = false;

    jQuery(selectImgTbl).each(function(){
        jQuery(this).children('td.this_link').each(function(){
            var value = jQuery(this).children('input').val();
            if ( value.search("imgId:") > -1 ) 
            {
                imgId = jQuery(this).text();
            }
            else if ( value.search("title:") > -1 )
            {
                imgTitle = jQuery(this).text();
            }
        });

        if (!duplicateAssignedImage(imgId))
        {
            jQuery("table#filter_image_table").append('<tr class="table_links_list">' + 
                '<td class="img_select_table_cell1 this_link">' + imgTitle + '<input type="hidden" class="image_id" var_type="imgId" value="' + imgId + '===' + imgTitle + '" /></td>' + 
                '<td><img class="delete_this_image" title="delete" src="/BSTheme-theme/images/delete.png" alt="delete"/></td></tr>');
            imgTitle = "";
            imgId = 0;
            insertedNewRow = true;
        }
    });
    
    if (insertedNewRow)
    {
        showFilterCount();
    }
};

function hotelLifeCycleFlagSelection()
{
	var hotelLifeCycleArray = new Array(); 
	jQuery.each(jQuery("div.ht_lifecycle img.ht_active"), function(index, value)
	{
    var id = jQuery(value).attr('id'); 
    hotelLifeCycleArray.push(id);
	});
	console.log(hotelLifeCycleArray);
	jQuery("#hotellifecycle").val(hotelLifeCycleArray);
}

/*This function is call from filter standards, remove/add country have common jsp countryregions.jsp.
we change implementation for add/remove countries based on validation of link/attachment/images and that implemntation in standards.js.
so, we need same function in standard_list.js that will always return fales, because we don't need any validation from standard_list.js */
function isLastCountryForImgFileLink(cntCode)
{
                       return false;
}