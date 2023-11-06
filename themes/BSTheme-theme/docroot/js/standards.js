var formSbmtMsg = "The form submitted successfully.";
var goto_url = "/web/brand-standards/standards";
var allowSbmt = true;
var commentsVal = "";
var isChgRgnDisplay = false;
var isCntrAdded = false;
var isBrndAdded = false;
var submitted = false;
var validator;
var isFirstCrossRefRequest = true;
var stdTextTranslationMessage = "You have changed Text assigned to this standard, even though translated content already exists. Are you want to do this?";
var stdContextTranslationMessage = "You have changed Context assigned to this standard, even though translated content already exists. Are you want to do this?";
var stdImageTranslationMessage = "You cannot remove this image while a translation for it exists.  If you really want to remove this image please delete the translation first and try again.";
var stdAttachmentTranslationMessage = "You cannot remove this attachment while a translation for it exists.  If you really want to remove this attachment please delete the translation first and try again.";
var stdExtlLinkTranslationMessage = "You cannot remove this external link while a translation for it exists.  If you really want to remove this external link please delete the translation first and try again.";
var stdTextPrompt = true;
var stdContextPrompt = true;
var callCopyattr = false;
var editUrlArray=  []; /*Array which hold edited data of external link i.e. [0]-linkId, [1]-url, [2]-title, [3]-brand, [4]- country */
var editImageArray = []; /*Array which hold edited data of assign images i.e. [0]-imageId, [1]-brand, [2]- country */
var editAttachmentArray = []; /*Array which hold edited data of file attachment i.e. [0]-attachmentId, [1]-brand, [2]-country */
function showTextPromptWithOption(msgText)
{
	if(stdTextPrompt && jQuery("#std_name_orig").val()!=jQuery("#standard_name").val())
	{
		jQuery.msgBox({
			title:"Attention",
			content: msgText ,
			type:"confirm",
			buttons: [{ value: "Yes" }, { value: "No" }],
			success: function (result) {
				 if (result == "No") {
					 jQuery("#standard_name").val(jQuery("#std_name_orig").val());
				 }
				 else {
					stdTextPrompt = false;
				 }
			}
			});		
	}
	return true;
}
function showContextPromptWithOption(msgText)
{
	if(stdContextPrompt && jQuery("#standard_rationale_orig").val()!=jQuery("#standard_rationale").val())
	{
		jQuery.msgBox({
			title:"Attention",
			content: msgText ,
			type:"confirm",
			buttons: [{ value: "Yes" }, { value: "No" }],
			success: function (result) {
				 if (result == "No") {
					 jQuery("#standard_rationale").val(jQuery("#standard_rationale_orig").val());
				 }
				 else {
					stdContextPrompt = false;
				 }
			}
			});		
	}
}

function showPromptMessage(msgText)
{
        jQuery.msgBox({
            title: "Attention!",
            content: msgText,
            type: "error"
        });	
}

function isGlobalStd()
{
    var selCountriesCnt = jQuery('select#selectedcountries').val().length;
    if(selCountriesCnt >= allCountriesCount) 
    {
        jQuery("#global_std_ind").val('G');
    }
    else
    {
        var varSelectedRegions = new Array();
        jQuery('#selectedcountries option').each(function() {
            var selRegion = getRegionByCountryCode(this.value);
            if(jQuery.inArray(selRegion, varSelectedRegions) < 0)
            {
                varSelectedRegions.push(selRegion);
            }
        });	

        if (varSelectedRegions.length > 1)
        {
            jQuery("#global_std_ind").val('M');
        }
        else
        {
            jQuery("#global_std_ind").val('N');
        }
    }
};

function getFileName(fullName) 
{
    var fileName = fullName;
    
    if(fullName.lastIndexOf("/") > 0) {
        fileName = fullName.substring(fullName.lastIndexOf("/") + 1);
    }
    else if(fullName.lastIndexOf("\\") > 0) {
        fileName = fullName.substring(fullName.lastIndexOf("\\") + 1);
    }
    fileName = fileName.toLowerCase();
    
    return fileName;
};

function validateStdForm()
{
	var frmValid = false;
	if (validator)
	{
		frmValid =  validator.form();
	}
	else
	{
		validator = getFormValidator();
		frmValid = validator.form();
	}
    if(frmValid)
	{
		jQuery('table#assign_images tr.table_links_list').children('td.this_link').each(function(){
			var image = jQuery(this).children('input').val();
			if(image=='')
			{
				frmValid = false;
				 jQuery.msgBox({
					title: "Error!",
					content: "Atleast one brand, region and country must be selected with Assigned Image.",
					type: "error"
				});
				 
			}
		});
		/*jQuery('table#file_links tr.table_links_list').children('td.this_link').each(function(){
			var image = jQuery(this).children('input').val();
			if(image=='')
			{
				frmValid = false;
					 jQuery.msgBox({
						title: "Error!",
						content: "Atleast one brand, region and country must be selected with Assigned Image.",
						type: "error"
					});
			}
		});
		jQuery('table#url_links tr.table_links_list').children('td.this_link').each(function(){
			var image = jQuery(this).children('input').val();
			if(image=='')
			{
				frmValid = false;
					 jQuery.msgBox({
						title: "Error!",
						content: "Atleast one brand, region and country must be selected with Assigned Image.",
						type: "error"
					});
			}
		});
		*/
	}
	
	if(frmValid)
	{
		selectedVal = jQuery("select#Manual>option:selected").val();
		hotelFlagCount = jQuery("div.ht_lifecycle img.ht_active").length;
		if(selectedVal == 257 && (hotelFlagCount == 0))
        {
			frmValid = false;
			jQuery.msgBox({
				title: "Error!",
				content: "At least one Hotel Lifecycle Attribute needs to selected.",
				type: "error"
			});
		}
	}
	return frmValid;
};
function setCrossReferenceOrder()
{
    var strStndIds ="";
    var rowCount = 0;
    var addComma = false;
    jQuery("#searchedContentTable tr").each(function() {
        if(rowCount>0)
        {
            var standId = jQuery(this).find("td:first").html();   
            if(addComma){
                strStndIds = strStndIds + "," + standId;
            } else {
                strStndIds = strStndIds + standId;
                addComma = true;
            }
        }
        rowCount++;
    });
    jQuery("#updateOrderStdIds").val(strStndIds);
}
function allowSubmitStdForm()
{
    selectAllToSubmit();
    isGlobalStd();
	if(jQuery('#isDragged').val()){
		setCrossReferenceOrder();
	}
    /* alert(commentsVal);
       update hidden hidden_file_links varible */
    var linkArray = new Array();
    jQuery('table#file_links tr.table_links_list').children('td.this_link').each(function(){
        var theLink = jQuery(this).children('input').val();
        var name = jQuery(this).children('input').attr("name");
        if(name != null && name.length > 15 && name.substring(0, 15) === "files_to_upload") {
            theLink = name;
        }
        linkArray.push(theLink + "~~");
    });
    
    jQuery("#hidden_file_links").val(linkArray);
    
    /* update hidden hidden_images varible */
    var imageArray = new Array();
    jQuery('table#assign_images tr.table_links_list').children('td.this_link').each(function(){
        var image = jQuery(this).children('input').val();
		if(image=='')
		{
			var imageCBId = jQuery(this).children('select').attr("id");
			image = jQuery("select#"+imageCBId+"").multiselect("getChecked").map(function(){
				return this.value;	
			}).get().toString();
		}		
		imageArray.push(image + "~~");
    });
    jQuery("#hidden_images").val(imageArray);

    /* update hidden hidden_url_links varible */
    var urllinkArray = new Array();
    jQuery('table#url_links tr.table_links_list').children('td.this_link').each(function(){
        var theLink = jQuery(this).children('input').val();
        urllinkArray.push(theLink + "~~");
    });
    jQuery("#hidden_url_links").val(urllinkArray);
	
	/*Edit External link URL, TITLE, Brand, Region and Country data set into hidden  */
	if (editUrlArray.length > 0)
	{
		var editLinks = "";
		/*Array element formate(comma seprated each row) into request i.e. [1-0]linkId~~[1-1]url~~[1-2]title,[2-0]linkId~~[2-1]url~~[2-2]title */
		for (var i = 0; i < editUrlArray.length; i++) 
		{			
			editLinks +=  editUrlArray[i].ID + "~~" + editUrlArray[i].URL + "~~" + editUrlArray[i].TITLE + "~~" + editUrlArray[i].Brand + "~~" + editUrlArray[i].Cntr + ",,,";
		}		
		jQuery("#hidden_url_edit_links").val(editLinks);
	}
	
	/*Edit assign images Brand, Region and Country data set into hidden */
	if (editImageArray.length > 0)
	{
		var editImages = "";
		/*Array element formate(comma seprated each row) into request i.e. [1-0]iamgeId~~[1-1]Brand~~[1-2]Country,[2-0]imageId~~[2-1]Brand~~[2-2]Country */
		for (var i = 0; i < editImageArray.length; i++) 
		{			
			editImages +=  editImageArray[i].ID + "~~" + editImageArray[i].Brand + "~~" + editImageArray[i].Cntr + ",,,";
		}		
		jQuery("#hidden_edit_images").val(editImages);
	}
	
	/*Edit Attachment Brand, Region and Country data set into hidden */
	if (editAttachmentArray.length > 0)
	{
		var editLinks = "";
		/*Array element formate(comma seprated each row) into request i.e. [1-0]attachmentId~~[1-1]Brand~~[1-2]Country,[2-0]attachmentId~~[2-1]Brand~~[2-2]Country */
		for (var i = 0; i < editAttachmentArray.length; i++) 
		{			
			editLinks +=  editAttachmentArray[i].ID + "~~" + editAttachmentArray[i].TITLE + "~~" + editAttachmentArray[i].Brand + "~~" + editAttachmentArray[i].Cntr + ",,,";
		}		
		jQuery("#hidden_file_edit_links").val(editLinks);
	}	
      
    /* update hidden hidden_manual_references varible */
    var referencesArray = new Array();
    jQuery('table#references tr.table_links_list').children('td.this_link').each(function(){
        var reference = jQuery(this).children('input').val();
        referencesArray.push(reference + "~~");
    });
    jQuery("#hidden_manual_references").val(referencesArray);
    
    var biaArray = new Array();
    jQuery('table#impactAssessment tr.table_links_list').children('td.this_link').each(function(){
        var reference = jQuery(this).children('input').val();
        biaArray.push(reference + "~~");
    });
   /*  alert(biaArray); */
    jQuery("#hidden_bia_references").val(biaArray);
    processSpecGuidelineIds();

    if(!allowSbmt )
    {
        jQuery.msgBox({
            title: "Error!",
            content: "You do not have enough rights to perform this action.",
            type: "error"
        });
    }

	
    var readySubmit = allowSbmt;  
	
	if($('.status_brand_checkbox:checked').length<=0){
	jQuery.msgBox({
				title:"Error!",
				content:"At least one brand must apply " ,
				type:"error"
			});

			readySubmit = false;
	}
	
	
    if (jQuery("select#standard_change").val() != "NEW" && jQuery("select#standard_change").val() != "NA" && $('#references tr').length <= 1 || jQuery("select#standard_change").val() == "" )
    {
        jQuery.msgBox({
            title:"Error!",
            content:"Please add Historical Reference or modify the value for the \"Change\" field to \"New\" " ,
            type:"error"
        });

        readySubmit = false;
    }
	hotelLifeCycleFlagSelection();
    return readySubmit;
};

function addToSubmit(el)
{
    var t = el.type;
    if (el.parentNode.tagName.toLowerCase() == "td" && el.name == "historical_manual_url")
    {
        return false;
    }
    else if ( el.disabled || ((t == 'checkbox' || t == 'radio') && !el.checked) || t == 'button' ||
             (t == 'submit' || t == 'image') && el.form && el.form.clk != el )
    {
       return false;
    }
    return true;
};
function displayBrandStatusMessage(){
if(jQuery('.status_brand_checkbox:checked').length<=0){
	jQuery("#status_by_brand_message").css("display","block");
}else{
	jQuery("#status_by_brand_message").css("display","none");
}
}
function showStatusByBrand(val,standStatus){
if(jQuery('input:checkbox[id=standard_brand'+val+']').is(':checked')){
	jQuery('#'+val).css({color:'black'});
	jQuery('#standard_status'+val).css("display","block");
	if(standStatus==""){
		jQuery('#'+val).text("Initial Load of Existing Content");
	}
   }else{
	jQuery('#'+val).css({color:'gray'});
	jQuery('#standard_status'+val).css("display","none");
	if(standStatus==""){
		jQuery('#'+val).text("");
	}
   }
}

function changeCopyButtonAttr() {
	jQuery('#copy_attributes').removeAttr('disabled');
	callCopyattr = true;
}	
/* pre-submit callback */ 
function showRequest(formData, jqForm, options)
{
	if (validateStdForm())
    {
		if (callCopyattr == true) {
		if (stdId > 0 && isStd) {
			var deptFlags = $('#'+flag1).val();
			var guestJourneyFlags = $('#'+flag20).val();
			var locFlags = $('#'+flag25).val();
		    var corpFlags = $('#'+flag35).val();
			var wheelFlags = $('#'+flag40).val();
			var msFlags = $('#'+flag90).val();
			var specFlags = $('#'+flag92).val();
			var dgtFlags = $('#'+flag93).val();
			var grCategories = $('#'+flag412).val();
			var hotelMs = $('#'+flag419).val();
			
			$.ajax({
				url :checkAttr,
				data:{"deptFlags":deptFlags,"locFlags":locFlags,"corpFlags":corpFlags,"wheelFlags":wheelFlags,
				"guestJourneyFlags":guestJourneyFlags,"msFlags":msFlags,"specFlags":specFlags,"dgtFlags":dgtFlags,"grCategories":grCategories,"hotelMs":hotelMs,'stdId':stdId},
				type: "POST",
				success: function(data) {
					if (typeof data != 'undefined' && data != null && data == 'true') {
						jQuery.msgBox({
						title: "Attributes are modified",
						content: "Do you want to copy attribute changes to specifications and guidelines?",
						type: "confirm",
						buttons: [{ value: "Yes" }, { value: "No" }],
						success: function (result) {
							if (result == "Yes") {
								$.ajax({
								url :copyAttr,
								data:{"deptFlags":deptFlags,"locFlags":locFlags,"corpFlags":corpFlags,"wheelFlags":wheelFlags,
								"guestJourneyFlags":guestJourneyFlags,"msFlags":msFlags,"specFlags":specFlags,"dgtFlags":dgtFlags,"grCategories":grCategories,"hotelMs":hotelMs,'stdId':stdId},
								type: "POST",
								success: function(data) {
									checkForChanges();
								}, error: function (e) {
									jQuery.msgBox("Error occurred");
									console.log(e);
									}
								});
							} if(result == "No" || result == "Cancel") {
									callCopyattr = false;
									checkForChanges();
							}
								
						}
						});
					} else {
						checkForChanges();
					}
					
				}, error: function (e) {
				 	jQuery.unblockUI();
				 	jQuery.msgBox("Error occurred");
				 	console.log(e);
				}
			});
		} else {
			checkForChanges();
		}
		} else {
			checkForChanges();
		}
		
		var cnt_cntr = jQuery("input:hidden[id^='img_selected_cntr']").length + jQuery("input:hidden[id^='img_selected_cntr']").length + jQuery("input:hidden[id^='extl_selected_cntr']").length;
		var cnt_brnd = jQuery("input:hidden[id^='img_selected_brand']").length + jQuery("input:hidden[id^='img_selected_brand']").length + jQuery("input:hidden[id^='extl_selected_brand']").length;
		if (submitted==false && ((isCntrAdded && cnt_cntr > 0) || (isBrndAdded && cnt_brnd > 0)) )
		{
			jQuery.msgBox({
                title:"Info",
                content:"You may consider assigning newly added countries/brands to Images/Attachments/Links.",
                type:"info"
            });
		}
		
    }
    return submitted;
}

function copyAttributes (stdId) {
	var copyContent = false;

	jQuery.msgBox({
		title: "Are You Sure",
		content: "You want to copy attribute changes to specifications and guidelines?",
	    type: "confirm",
		autoClose: true,
	    buttons: [{ value: "Yes" }, { value: "No" }],
	    success:function (result) {
	      if (result == "Yes") {
			loadProgressBar();
			copyContent = true;
	       } 
		  if(result == "No" || result == "Cancel") {
				callCopyattr = false;
		  }
		  
	    }, afterClose: function () {
			copyAttributeIds(stdId, copyContent);
		}
		
		});
}


function copyAttributeIds(stdId, copyContent)
{

	if (copyContent) {
		var deptFlags = $('#'+flag1).val();
		var guestJourneyFlags = $('#'+flag20).val();
		var locFlags = $('#'+flag25).val();
		var corpFlags = $('#'+flag35).val();
		var wheelFlags = $('#'+flag40).val();
		var msFlags = $('#'+flag90).val();
		var specFlags = $('#'+flag92).val();
		var dgtFlags = $('#'+flag93).val();
		var grCategories = $('#'+flag412).val();
		var hotelMs = $('#'+flag419).val();
		$.ajax({
			url :copyAttr,
			data:{"deptFlags":deptFlags,"locFlags":locFlags,"corpFlags":corpFlags,"wheelFlags":wheelFlags,
			"guestJourneyFlags":guestJourneyFlags,"msFlags":msFlags,"specFlags":specFlags,"dgtFlags":dgtFlags,"grCategories":grCategories,"hotelMs":hotelMs,"stdId":stdId},
			type: "POST",
			success: function(data) {
				jQuery.unblockUI();
				jQuery.msgBox({
					title:"Success",
					content:"Attributes copied successfully.",
					type:"info",
					autoClose: false
				});
				
			}, error: function (e) {
				jQuery.unblockUI();
				jQuery.msgBox("Error occurred");
				console.log(e);
				
			} 
		});
	}
}


function loadProgressBar () {
	jQuery.blockUI({ message: '<h3><img src="/BSTheme-theme/images/busy.gif" /> </h3>' });
}

function checkForChanges () {
		callCopyattr = false;
        commentsVal = jQuery("#cmt_txt_area").val();
        jQuery("#hidden_comments_value").val(commentsVal);
		if(allowSubmitStdForm()) {			
			if (jQuery("#cmt_txt_area").val() == null || jQuery("#cmt_txt_area").val() == '') {
				showComment();	
			} else
			{
				jQuery.blockUI({ message: '<h3><img src="/BSTheme-theme/images/busy.gif" /> Please wait...</h3>' });
			return true;
			}
		}
	
	return true;
}

/* post-submit callback */ 
function showResponse(responseText, statusText, xhr, $form)  
{ 
    submitted = false;
    jQuery.unblockUI();
    /*alert("responseText=" + responseText + "\n statusText=" + statusText); */
    
    if(responseText == formSbmtMsg)
    {
        if(jQuery("input#save_new_spec_add_another").val() == 1) 
        {
            jQuery("input#save_new_spec_add_another").val(0);
            jQuery("input#standard_name").val("");
			jQuery("textarea#standard_rationale").val("");
            jQuery("textarea#standard_supporting_notes").val("");
            var beginFormUrl = window.location.pathname + window.location.search;
            window.location.href = beginFormUrl;
        }
        else 
        {
            jQuery.msgBox({
                title: "Success!",
                content: responseText ,
                type: "info",
                success: function (result) {
                    window.location.href = goto_url + window.location.search;
                }
            });
        }
    }
    else
    {
        jQuery.msgBox({
            title:"Error!",
            content:responseText ,
            type:"error"
        });
        return false;
    }
};

function showComment()
{	
	var popID = "comments_div"; /*Get Popup Name */
	var popWidth = 700;
	/*Fade in the Popup and add close button */
	jQuery('#' + popID).fadeIn().css({ 'width': Number( popWidth ) });

	/*Define margin for center alignment (vertical   horizontal) - we add 80px to the height/width to accomodate for the padding  and border width defined in the css */
	var popMargTop = (jQuery('#' + popID).height() + 80) / 2;
	var popMargLeft = (jQuery('#' + popID).width() + 80) / 2;

	/*Apply Margin to Popup */
	jQuery('#' + popID).css({
		'margin-top' : -popMargTop,
		'margin-left' : -popMargLeft
	});
	
    jQuery('body').append('<div id="cmt_modalwindow_fade"></div>'); /*Add the fade layer to bottom of the body tag. */
    jQuery('#cmt_modalwindow_fade').css({'filter' : 'alpha(opacity=80)', 'position': 'fixed', 'z-index': 10}).fadeIn();
    jQuery('#' + popID).insertAfter('#shareidea_modalwindow_fade'); 

		/*Close Popups and Fade Layer */
	jQuery('#cmt_close').click(function() { /*When clicking on the close ... */
	    jQuery('#cmt_modalwindow_fade, .comments_modalwindow_block').fadeOut(function() {
	    	jQuery("#hidden_comments_value").val("");
            jQuery("#cmt_txt_area").val("");
	        jQuery('#cmt_modalwindow_fade, a.comments_modalwindow_close').remove();  /*fade them both out */
            jQuery("input#save_new_spec_add_another").val(0);
            submitted = false;
	    });
	    return false;
	});
	/* On click of Ok button. */
	jQuery('#cmt_submit').click(function() { /* When clicking on the close ... */ 
		
        if (!submitted)
        {
            commentsVal = jQuery("#cmt_txt_area").val();
        
            jQuery("#hidden_comments_value").val(commentsVal);
            if(commentsVal.length > 0)
            {	
                jQuery('#cmt_modalwindow_fade, .comments_modalwindow_block').fadeOut(function() {
                    jQuery('#cmt_modalwindow_fade, a.comments_modalwindow_close').remove();  /* fade them both out */
                });
                submitted = true;
                jQuery("#submit").trigger('click');
            }
            else
            {
                jQuery.msgBox({
                    title:"Error!",
                    content:"Please enter comments.",
                    type:"error"
                });
            }
        }
	});
};

function getFormValidator()
{
    var valdtr = jQuery("#new_standard_form").validate({
        rules: {
            required: true,

            files_to_upload: {
                required: true,
                duplicateFile: true
            },

            spec_author: {
                required: true
            },
            
            GuestJourney: {
                vlidateGuestJourney: true
            }
        },
        messages: {
            GuestJourney: 'Please select option(s) for "Guest Journey" or check "Outside of Guest Journey" checkbox.',
            references: ""
        },
        ignore: ":hidden:not('#manuals_brand, #manuals_regions, #manual_type, #DepartmentApplicability, #GuestJourney, #Manual, #CorporateDepartmentdetails, #OwnershipType')" /*Tells it to check the jqueryUI multi-select */
    });
    return valdtr;
};

/* On doc load all processing */
jQuery(function(){

    var url = jQuery("#new_standard_form").attr("action");
	
    var options = { 
        url:           url,         /* override for form's 'action' attribute */ 
        target:        '#output',   /* target element(s) to be updated with server response */ 
        beforeSubmit:  showRequest,  /* pre-submit callback */ 
        success:       showResponse, /* post-submit callback */ 
 
        /* other available options: */ 
        type:      'post',        /* 'get' or 'post', override for form's 'method' attribute */ 
        dataType:  'html',        /* 'xml', 'script', or 'json' (expected server response type) */ 
        callCopyattr : false
		/*clearForm: true         clear all form fields after successful submit */ 
        /*resetForm: true         reset the form after successful submit */ 
 
        /* $.ajax options can be used here too, for example: */ 
        /*timeout:   3000 */ 
    }; 
 
    /* bind form using 'ajaxForm' */ 
    jQuery('#new_standard_form').ajaxForm(options); 

    jQuery(".multis").multiselect();
 
    jQuery("select#manual_type").multiselect("uncheckAll");
    
    var lastActiveSection = 0;

    jQuery("#accordion").accordion({
        collapsible: true,
        active: 0    
    });
	
	jQuery("#accordion_brand").accordion({
        collapsible: true,
        active: false    
    });

    validator = getFormValidator();
    
    /* if Measurement (id="Measurement") -> On-site Evaluation is selected then enable GEM Reporting Categories (id="GEMReportingCategories") */
    jQuery("select#Measurement").multiselect();
    jQuery("select#GEMReportingCategories").attr("disabled", true);
    jQuery.map(jQuery("select#Measurement").multiselect("getChecked"), function( input ){
        if (input.value === "323")
        {
            jQuery("select#GEMReportingCategories").removeAttr("disabled");
        }
        return input.value;
	});
    
    jQuery("select#Measurement").multiselect({
        close: function(event, ui){
            var isSelected = false;
            jQuery.map(jQuery("select#Measurement").multiselect("getChecked"), function( input ){
                if (input.value === "323")
                {
                    isSelected = true;
                }
                return input.value;
            });
            
            if (isSelected)
            {
                jQuery("select#GEMReportingCategories").removeAttr("disabled");
            }
            else
            {
                jQuery("select#GEMReportingCategories>option:selected").removeAttr("selected");
                jQuery("select#GEMReportingCategories").attr("disabled", true);
            }
        }
    });
    
    jQuery('#accordion h3').bind('click', function (e) {
        /* bind to the the header / anchor clicks */
        /* alert("Validation of required fields happen now! Section: " + e.target.textContent); */
        var selected = jQuery("#accordion").accordion("option", "active");
        var accrodianName = jQuery.trim(jQuery(this).text());
       
        if(accrodianName == "Business Impact Assessment" && isStd)
        {
		
            populateBiaRegions();
            populateBiaBrands();
        }

        var isValid = validateStdForm();
       
        if(!isValid)
        {
            e.preventDefault();
            e.stopPropagation();
/*            alert("Required fields are empty in section " + e.target.textContent); */
           
            jQuery("#accordion").accordion("option", "active", lastActiveSection);
           
           
        }
        else
        {
            var checked = false;
                       if(lastActiveSection==1)
                       {
                       if(jQuery('.status_brand_checkbox:checked').length<=0)
                               {
                                       e.preventDefault();
                                       e.stopPropagation();
                                       jQuery("#accordion").accordion("option", "active", lastActiveSection);
                                       jQuery("#status_by_brand_message").css("display","block");
                                       checked = true;
                               }
                       }
            if(lastActiveSection==2)
            {
           
                if (jQuery("select#standard_change").val() != "NEW" && jQuery("select#standard_change").val() != "NA" && (jQuery("select#standard_change").val() == "" || $('#references tr').length <= 1))
                {
                    e.preventDefault();
                    e.stopPropagation();
                    jQuery("#accordion").accordion("option", "active", lastActiveSection);
                    jQuery.msgBox({
                        title:"Error!",
                        content:"Please add Historical Reference or modify the value for the \"Change\" field to \"New\" " ,
                        type:"error"
                    });
					 checked = true;
                }
               
               
            }
            if((lastActiveSection != 0 || jQuery("#accordion").accordion("option", "active") != false) && accrodianName != '* Manage Status by Brand' && accrodianName!= '*  Historical References' && !checked)
            {
            if(jQuery('.status_brand_checkbox:checked').length<=0)
                {
                    e.preventDefault();
                    e.stopPropagation();
                    jQuery("#accordion").accordion("option", "active", lastActiveSection);
                    jQuery.msgBox({
                        title:"Error!",
                        content:"At least one brand must apply" ,
                        type:"error"
                    });
                }
           
            else
            {
            if (jQuery("select#standard_change").val() != "NEW" && jQuery("select#standard_change").val() != "NA" && (jQuery("select#standard_change").val() == "" || $('#references tr').length <= 1))
                {
                    e.preventDefault();
                    e.stopPropagation();
                    jQuery("#accordion").accordion("option", "active", lastActiveSection);
                    jQuery.msgBox({
                        title:"Error!",
                        content:"Please add Historical Reference or modify the value for the \"Change\" field to \"New\" " ,
                        type:"error"
                    });
                }
            }
            }
            lastActiveSection = jQuery("#accordion").accordion("option", "active");
           
        }
   
        if(accrodianName == 'IHG Supporting Links/External Links' || accrodianName == 'Summary/IHG Supporting Links/External Links') {
            populateSupportLinkBrands();
			populateSupportLinkRegion();
            populateExternalLinkBrands();
			populateExternalLinkRegion();
        }
        if(accrodianName == 'Manage Translations') {
            populateTranslations();
        }
        if(accrodianName == "Cross References"){
            if(isFirstCrossRefRequest){
                var inData = {regionCode:regionCode,stdId:stdId};
                jQuery.ajax({
                    type: "POST",
                    url: crossReferenceUrl,
                    data: inData,
                }).done(function(data){
                    jQuery('#crossReferenceDiv').html(data);
                    isFirstCrossRefRequest = false;
                }).fail(function(jqXHR, textStatus){
                    alert("AJAX request failed with status:" + textStatus);
                });
            }
        }
        if(accrodianName == "Specification and Guideline Ordering"){
        //viewOrders();
        }
    });
	
	jQuery('#accordion_brand h3').bind('click', function (e) {
		// bind to the the header / anchor clicks
		// alert("Validation of required fields happen now! Section: " + e.target.textContent);
		var selected = jQuery("#accordion_brand").accordion("option", "active");
		var accrodianName = jQuery.trim(jQuery(this).text());
		var accordionCode = $(this).attr('id').substring('changeOrderAccordion_'.length, $(this).attr('id').length);
		viewOrders(accordionCode);		
	});
     function viewOrders(brandVal) {
		if (jQuery('#spec_gdln_'+brandVal+"_check").val() != 'true') {
			var url = changeOrder;
			var inData = {stdId:stdId,regionCode:regionCode,chainCode:brandVal};
			jQuery.ajax({
				type: "POST",
				url: url,
				data: inData,
			}).done( function(data) {
				   jQuery('#spec_gdln_'+brandVal).html(data);
				   jQuery('#spec_gdln_'+brandVal+"_check").val("true");
			}).fail( function(jqXHR, textStatus) {
					alert("AJAX request failed with status:" + textStatus);
			});
		}
	}
	function populateTranslations() {
		var url = manageTranslationsUrl;
		var inData = {standardsId:stdId, rgnCode:regionCode};
		jQuery.ajax({
	        type: "POST",
	        url: url,
	        data: inData
	    }).done( function(data) {
	           jQuery('#manageTranslationsAccordion').html(data);
	    }).fail( function(jqXHR, textStatus) {
	            alert("AJAX request failed with status:" + textStatus);
	    });
	}
    initDragNDropImages();
    
	for (iReg1 = 0; iReg1 < regions.length; iReg1++)
    {
		jQuery('<option/>').val(regions[iReg1].region_cd).html(regions[iReg1].region_nm).appendTo('#standard_regions');
		jQuery('<option/>').val(regions[iReg1].region_cd).html(regions[iReg1].region_nm).appendTo('#manuals_regions');
	}
    
	jQuery.datepicker.setDefaults({showOn: 'both', buttonImageOnly: true, buttonImage: '/BSTheme-theme/images/calendar_icon.png'});
	jQuery(".datepicker").datepicker({dateFormat: 'd M yy'});
    jQuery('#standard_effect_date,#standard_days_to_imp').datepicker();
    
	jQuery.validator.addMethod("duplicateFile", function(value, element) {

        /* value = value of the element (file name) */
        /* element = element to validate (<input>) */
        var fileName = getFileName(value);
		if(/[&@\]\}:,=>\/<\n\[\{%|\+#\?\(\)\'\"\r;\*~]/g.test(fileName))
		{
			valid = false;
            return false;
		}
        var fileType = null; 
        var fileInput = null;
        jQuery(element).parent('td').parent('tr').children('td.this_link').each(function(){
            var nameAttr = jQuery(this).children('input').attr("name");
            if(nameAttr != null && nameAttr.length > 0 && nameAttr === "file_type") {
                fileType = jQuery(this).children('input').val();
            }
            else if(nameAttr != null && nameAttr.length > 15 && nameAttr.substring(0, 15) === "files_to_upload") {
                fileInput = nameAttr;
            }
        });

        var aFileType = null;
        var aFileName = null;
        var valid = true;
        jQuery('table#file_links tr.table_links_list').each(function(){

            aFileName = null;
            aFileType = null;

            jQuery(this).children('td.this_link').each(function(){
                var name = jQuery(this).children('input').attr("name");
                var uploadedFileName = jQuery(this).find("a").text();
                if(name != null && name.length > 15 && name.substring(0, 15) === "files_to_upload") {
                    if (name != fileInput) {
                        var file = jQuery(this).children('input').val();
                        aFileName = getFileName(file);
                    }
                } else if(uploadedFileName != null && uploadedFileName.length > 0) {
                    aFileName = uploadedFileName;
                } else if (name != null && name.length > 0 && name === "file_type") {
                    aFileType = jQuery(this).children('input').val();
                }
            });

            if(aFileName != null && aFileType != null) {
                if(fileName == aFileName.toLowerCase() && fileType == aFileType ) {
                    valid = false;
                    return false;
                }
            }
        });

        return valid; 
    });

    jQuery.validator.addMethod("vlidateGuestJourney", function(value, element) {

        var selItems = jQuery("select#GuestJourney").multiselect("getChecked").map(function(){
           return this.value;	
        }).get().toString();
        var isChecked = jQuery("#OutsideofGuestJourney").is(':checked')

        if(selItems.length == 0 && !isChecked)
        {
            return false;
        }
        return true;
    });

	jQuery.validator.addClassRules({

        files_to_upload:{

            required: true,
			duplicateFile: true
		}
    });

	var nameIncrease = 0;
	var fileLinkId = 0;
	/*add file links into table */
    jQuery('.add_standard_file').click(function(){

        var type = jQuery("select#standard_file_type option:selected").text();
        var typeValue = jQuery("select#standard_file_type option:selected").val();
        var title = jQuery("input#standard_file_title").val();
		var language = jQuery("#support_link_lang").val();
		var lang_name = jQuery("#support_link_lang option:selected").text();
		var dependentValues = jQuery.map(jQuery("#support_link_brand").multiselect("getChecked"), function( input ){
			return input.value;
		});
		var dependentTitles = jQuery.map(jQuery("#support_link_brand").multiselect("getChecked"), function( input ){
			return input.title;
		});
		
		var dependentRegionValues = jQuery.map(jQuery("#support_link_region").multiselect("getChecked"), function( input ){
			return input.value;
		});
		var dependentRegionTitles = jQuery.map(jQuery("#support_link_region").multiselect("getChecked"), function( input ){
			return input.title;
		});
		
		var dependentCountryValues = jQuery.map(jQuery("#support_link_country").multiselect("getChecked"), function( input ){
			return input.value;
		});
		var dependentCountryTitles = jQuery.map(jQuery("#support_link_country").multiselect("getChecked"), function( input ){
			return input.title;
		});
        if(typeValue != "" && title != "" && dependentValues!="" && dependentCountryValues!="" && dependentRegionValues!="") {
			linkStr = '<tr class="table_links_list atchment">'+
					'<td style="display:none;" class="standard_file_type_td this_link">' + fileLinkId + '<input type="hidden" value="~~~id:' + fileLinkId + '"/></td>' + 
					'<td class="standard_file_type_td this_link"';
			if(typeValue=='GDLN') {
			  linkStr = linkStr + 'style="display:none;"';
			}
			linkStr = linkStr + '>'+ type + '<input type="hidden" name="file_type" value="' + typeValue + '"/></td>' + 
					'<td class="standard_file_title_td this_link">' + title + '<input type="hidden" value="' + title + '"/><img class="edit_this_attachment" title="Edit url" src="/BSTheme-theme/images/edit_pencil_icon.png" alt="Edit url" /></td>' + 
					'<td class="standard_file_file_td this_link"><input type="file" title="File not selected or duplicate/invalid file name found. Please select different file." name="files_to_upload' + nameIncrease + '" class="files_to_upload"/></td>' + 
					
					'<td class="standard_file_title_td this_link"><p class="tiny_text">'+ dependentTitles.toString().replace(/,/g,", ") +'</p><input type="hidden" id="file_selected_brand' +fileLinkId +'" value="' + dependentValues + '"/><img id="file_select_brand' +fileLinkId +'" title="edit brand" src="/BSTheme-theme/images/edit_pencil_icon.png" alt="edit brands"/></td>' +
					
					'<td class="standard_file_title_td this_link"><p class="tiny_text">'+ dependentRegionTitles.toString().replace(/,/g,", ") +'</p><input type="hidden" id="file_selected_rgn' +fileLinkId +'" value="' + dependentRegionValues + '"/><img id="file_select_region' +fileLinkId +'" title="edit region" src="/BSTheme-theme/images/edit_pencil_icon.png" alt="edit region"/></td>' +
					
					'<td class="standard_file_title_td this_link"><p class="tiny_text">'+ dependentCountryTitles.toString().replace(/,/g,", ") +'</p><input type="hidden" id="file_selected_cntr' +fileLinkId +'" value="' + dependentCountryValues + '"/><img id="file_select_country' +fileLinkId +'" title="edit country" src="/BSTheme-theme/images/edit_pencil_icon.png" alt="edit country"/></td>' +
					
					'<td class="standard_file_title_td this_link">' + lang_name + '<input type="hidden" value="' + language + '"/></td>' +
					'<td><img class="delete_this_file" title="delete" src="/BSTheme-theme/images/delete.png" alt="delete"/></td></tr>';
			jQuery("table#file_links").append(linkStr);

			/*populateBrandsFromMS('support_link_brand', 'file_brand_'+fileLinkId); */
			/*  Country Region Function Loading */
			populateSelectBrandPopUp("file_select_brand",fileLinkId,"file");
			populateSelectRegionPopUp("file_select_region",fileLinkId,"file");
			populateSelectCountryPopUp("file_select_country",fileLinkId,"file");
			fileLinkId--;
			jQuery("table#file_links td:nth-child(1)").hide;
            jQuery("select#standard_file_type").val("");
            jQuery("input#standard_file_title").val("");
            
			//deselect all checkboxes for brand, region, country 
			jQuery("select#support_link_country").multiselect("uncheckAll");
			jQuery("select#support_link_region").multiselect("uncheckAll");
			jQuery("select#support_link_brand").multiselect("uncheckAll");
            nameIncrease++; 

        } else {
            if(typeValue=='GDLN') {
                jQuery.msgBox({
                    title:"Error!",
                    content:"Title, Brand, Region and Country are required.",
                    type:"error"
                });
            } else {
                jQuery.msgBox({
                    title:"Error!",
                    content:"A Type, Title, Brand, Region and Country are required.",
                    type:"error"
                });
            }
        }
        return false;
    });
    
	
	//edit external links URL into table
    jQuery("table").delegate("tr td img.edit_this_attachment", "click", function(event){
    	var thisItem = this;
    	var linkId = jQuery(thisItem).parent('td').parent('tr').children().children('input').val();
    	var editURL = jQuery(thisItem).parent('td').children('input').val();
    	var tdClass = jQuery(thisItem).parent('td').attr('class');
	   
    	var editUrlTD = jQuery(thisItem).parent('td');
    	if (tdClass.indexOf("standard_file_title_td")!= -1)
    	{
		   editUrlTD.html('<input type="text" value="'+ editURL +'" title="Please enter a title" onblur="validateLink(this);" /><img class="edit_this_attachment" title="Edit url" src="/BSTheme-theme/images/edit_pencil_icon.png" alt="Edit Title" />');
    	} 
        return false;
    });
    
    /* Delete File */
    var fileDelArray = new Array();
    jQuery("table").delegate("tr td img.delete_this_file", "click", function(event){

        var thisItem = this;
        jQuery.msgBox({
            title:"Are You Sure",
            content:"Are you sure you want to delete this?" ,
            type:"confirm",
            buttons: [{ value: "Yes" }, { value: "No" }],
            success: function (result) {
                if (result == "Yes") {
                    var theId = jQuery(thisItem).parent('td').parent('tr').children().children('input').val();
                    if(theId.length > 6 && theId.substring(0, 6) === "~~~id:") {
                        theId = theId.split('~~~id:')[1];
                        fileDelArray.push(theId);
                        if(theId > 0) {
                            jQuery("#hidden_file_del_links").val(fileDelArray);
                        }
                    }
                    jQuery(thisItem).parent('td').parent('tr').remove();
                }
            }
        });
        return false;
    });
    
	var urlLinkId = 0;
    /* add file links into table */
    jQuery('.add_standard_url_link').click(function(){

        var url = jQuery("input#standard_url_link").val();
        var urltitle = jQuery("input#standard_url_link_title").val();
        var isValid = jQuery("#standard_url_link").valid();
		var language = jQuery("#extl_link_lang").val();
		var lang_name = jQuery("#extl_link_lang option:selected").text();
		var dependentValues = jQuery.map(jQuery("#extl_link_brand").multiselect("getChecked"), function( input ){
			return input.value;
		});
		var dependentTitles = jQuery.map(jQuery("#extl_link_brand").multiselect("getChecked"), function( input ){
			return input.title;
		});
		var dependentRegionValues = jQuery.map(jQuery("#extl_link_region").multiselect("getChecked"), function( input ){
			return input.value;
		});
		
		var dependentRegionTitles = jQuery.map(jQuery("#extl_link_region").multiselect("getChecked"), function( input ){
			return input.title;
		});
		
		var dependentCountryValues = jQuery.map(jQuery("#extl_link_country").multiselect("getChecked"), function( input ){
			return input.value;
		});
		var dependentCountryTitles = jQuery.map(jQuery("#extl_link_country").multiselect("getChecked"), function( input ){
			return input.title;
		});
        if(urltitle != "" && isValid == 1 && dependentValues!="" && dependentCountryValues!="" && dependentRegionValues!=""){
            jQuery("table#url_links").append('<tr class="table_links_list externl_lnk"><td style="display:none;" class="standard_url_link_td this_link">' + urlLinkId + '<input type="hidden" value="~~~id:' + urlLinkId + '"/></td>' + 
			'<td class="standard_url_link_td this_link">'+ url + ' <input type="hidden" value="' +url+ '"/><img class="edit_this_link" title="Edit url" src="/BSTheme-theme/images/edit_pencil_icon.png" alt="Edit url" /></td>' + 
			'<td class="standard_url_link_title_td this_link">'+ urltitle +'<input type="hidden" value="' +urltitle+ '"/><img class="edit_this_link" title="Edit title" src="/BSTheme-theme/images/edit_pencil_icon.png" alt="Edit title" /></td>' + 
			
			
			'<td class="standard_url_link_title_td this_link"><p class="tiny_text">'+ dependentTitles.toString().replace(/,/g,", ") +'</p><input type="hidden" id="extl_selected_brand' +urlLinkId +'" value="' + dependentValues + '"/><img id="extl_select_brand' +urlLinkId +'" title="edit brand" src="/BSTheme-theme/images/edit_pencil_icon.png" alt="edit brands"/></td>' +
					
			'<td class="standard_url_link_title_td this_link"><p class="tiny_text">'+ dependentRegionTitles.toString().replace(/,/g,", ") +'</p><input type="hidden" id="extl_selected_rgn' +urlLinkId +'" value="' + dependentRegionValues + '"/><img id="extl_select_region' +urlLinkId +'" title="edit region" src="/BSTheme-theme/images/edit_pencil_icon.png" alt="edit region"/></td>' +
			
			'<td class="standard_url_link_title_td this_link"><p class="tiny_text">'+ dependentCountryTitles.toString().replace(/,/g,", ") +'</p><input type="hidden" id="extl_selected_cntr' +urlLinkId +'" value="' + dependentCountryValues + '"/><img id="extl_select_country' +urlLinkId +'" title="edit country" src="/BSTheme-theme/images/edit_pencil_icon.png" alt="edit country"/></td>' +		
			
			'<td class="standard_url_link_title_td this_link">' + lang_name + '<input type="hidden" value="' + language + '"/></td>' +
			'<td><img class="delete_this_link" title="delete" src="/BSTheme-theme/images/delete.png" alt="delete"/></td></tr>');
			
			/* populateBrandsFromMS('extl_link_brand', 'url_brands_'+urlLinkId); */
			/* Country Region Function Loading */
			populateSelectBrandPopUp("extl_select_brand",urlLinkId,"extl");
			populateSelectRegionPopUp("extl_select_region",urlLinkId,"extl");
			populateSelectCountryPopUp("extl_select_country",urlLinkId,"extl");
			
			urlLinkId--;
            jQuery("table#url_links td:nth-child(1)").hide;
            jQuery("input#standard_url_link").val("");
            jQuery("input#standard_url_link_title").val(""); 
			
			//deselect all checkboxes for brand, region, country
			jQuery("select#extl_link_brand").multiselect("uncheckAll");
			jQuery("select#extl_link_region").multiselect("uncheckAll");
			jQuery("select#extl_link_country").multiselect("uncheckAll");
		
        } else {
            jQuery.msgBox({
                title:"Error!",
                content:"A valid URL, Title, Brand, Region and Country are required.",
                type:"error"
            });
        }
        return false;
    });

	
	//edit external links URL into table
    jQuery("table").delegate("tr td img.edit_this_link", "click", function(event){
		var thisItem = this;
	   var linkId = jQuery(thisItem).parent('td').parent('tr').children().children('input').val();
	   var editURL = jQuery(thisItem).parent('td').children('input').val();
	   var tdClass = jQuery(thisItem).parent('td').attr('class');
	   
	   var editUrlTD = jQuery(thisItem).parent('td');
	   if (tdClass.indexOf("standard_url_link_td")!= -1)
	   {
		   editUrlTD.html('<input type="text" class="input_text url" id="edit_link_'+linkId+'" title="Please enter a valid URL that begins with http://" maxlength="2000" value="' +editURL+ '" onblur="validateLink(this);" /> <img class="edit_this_field" title="Edit url" src="/BSTheme-theme/images/edit_pencil_icon.png" alt="Edit url" />');
	   } else {
			editUrlTD.html('<input type="text" id="edit_link_'+linkId+'" title="Please enter a title"  value="' +editURL+ '"  onblur="validateLink(this);"/> <img class="edit_this_field" title="Edit title" src="/BSTheme-theme/images/edit_pencil_icon.png" alt="Edit title" />');
	   }
	   
	   
       return false;
    });
	
    /* Delete Link URL */
    var urlDelArray = new Array();
    jQuery("table").delegate("tr td img.delete_this_link", "click", function(event){
    
            var thisItem = this;
            jQuery.msgBox({
            title:"Are You Sure",
            content:"Are you sure you want to delete this?" ,
            type:"confirm",
            buttons: [{ value: "Yes" }, { value: "No" }],
            success: function (result) {
                if (result == "Yes") {
                    var theId = jQuery(thisItem).parent('td').parent('tr').children().children('input').val();
                    if(theId.length > 6 && theId.substring(0, 6) === "~~~id:") {
                        theId = theId.split('~~~id:')[1];
                        urlDelArray.push(theId);
                        if(theId > 0) {
                            jQuery("#hidden_url_del_links").val(urlDelArray);
                        }
                    }
                    jQuery(thisItem).parent('td').parent('tr').remove();
                }
            }
        });
        return false;
    });

    /* Delete Assign Image */
    var imgDelArray = new Array();
    jQuery("table").delegate("tr td img.delete_this_image", "click", function(event){
    
            var thisItem = this;
            jQuery.msgBox({
            title:"Are You Sure",
            content:"Are you sure you want to un-assign this image from this " + recordType + "?" ,
            type:"confirm",
            buttons: [{ value: "Yes" }, { value: "No" }],
            success: function (result) {
                if (result == "Yes") {
                    var theId = jQuery(thisItem).parent('td').parent('tr').children().children('input').val();
                    if(theId.length > 6 && theId.substring(0, 6) === "~~~id:") {
                        theId = theId.split('~~~id:')[1];
                        imgDelArray.push(theId);
                        if(theId > 0) {
                            jQuery("#hidden_del_images").val(imgDelArray);
                        }
                    }
                    jQuery(thisItem).parent('td').parent('tr').remove();
                    indexAssignImagesRows();
                    initDragNDropImages();
                }
            }
        });
        return false;
    });

    /* Set Standard/Specification Title to the header Text */
    jQuery('textarea#standard_name').blur(function(){
        var val = jQuery(this).val();
        if(val.length > 80)
        {
            val = val.substring(0, 77) + "...";
        }
        jQuery("span#header_rec_title").text(val);       
    });
    
    /* Set Guideline Title to the header Text */
    jQuery('textarea#standard_rationale').blur(function(){
        if( jQuery("#objTyp").val() == "GDLN")
        {
            var val = jQuery(this).val();
            if(val.length > 80)
            {
                val = val.substring(0, 77) + "...";
            }
            jQuery("span#header_rec_title").text(val);       
        }
    });
    
    jQuery('textarea#standard_supporting_notes[maxlength], textarea#standard_rationale[maxlength], textarea#standard_name[maxlength], textarea#bia_comments[maxlength], textarea#cmt_txt_area[maxlength]').keyup(function(){  
        /* get the limit from maxlength attribute */  
        var limit = parseInt(jQuery(this).attr('maxlength'));  
        /*get the current text inside the textarea */  
        var text = jQuery(this).val();  
        /*count the number of characters in the text */  
        var chars = text.length;  
  
        /*check if there are more characters then allowed */  
        if(chars > limit){  
            /*and if there are use substr to get the text before the limit */  
            var new_text = text.substr(0, limit);  
  
            /*and change the current text with the new text */  
            jQuery(this).val(new_text);  
        }  
    });  

    /* On Add Another record after submit */ 
    jQuery('#add_specification_record').click(function(){
        jQuery("input#save_new_spec_add_another").val(1);
        jQuery("#submit").trigger('click');
        return false;
    });
    
	/*add manual reference into table */
	jQuery('.add_reference').click(function(){
		
        var theManual = jQuery("select#brand_manual option:selected");
        var manual = theManual.val(); 
        var manualText = theManual.text(); 
        var title = jQuery("input#title_code_page").val();
        
        if( manual != "" && title != ""){
            var stdManualId = 0;
            var regionArray = theManual.attr("region");
            var brandArray = theManual.attr("brand");
            var manualId = theManual.attr("id");
            var changeType = jQuery("#change_type>option:selected").val();
            var changeTypeText = jQuery("#change_type>option:selected").text();
        
            jQuery("table#references").append('<tr class="table_links_list"><td style="display:none;" class="standard_file_type_td this_link">' + stdManualId + ' <input type="hidden" value="~~~id:' + stdManualId + '"/></td><td style="display:none;" class="standard_file_type_td this_link">' + manualId + ' <input type="hidden" value="' + manualId + '"/></td><td class="standard_file_type_td this_link">'+ brandArray + '<input type="hidden" value="' + brandArray + '"/></td><td class="standard_file_type_td this_link">'+ regionArray + '<input type="hidden" value="' + regionArray + '"/></td><td class="standard_file_type_td this_link">'+ changeTypeText + '<input type="hidden" value="' + changeType + '"/></td><td class="standard_file_type_td this_link">'+ manualText + '<input type="hidden" value="' + manual + '"/></td><td class="standard_file_type_td this_link">'+ title + '<input type="hidden" value="' + title + '"/></td><td><img class="delete_manual_reference" src="/BSTheme-theme/images/delete.png" /></td></tr>');
            jQuery("#title_code_page").val("");
            /* update hidden hidden_manual_references varible */
            var referencesArray = new Array();
            jQuery('table#references tr.table_links_list').children('td.this_link').each(function(){
                var reference = jQuery(this).children('input').val();
                referencesArray.push(reference + "~~");
            });
            jQuery("#hidden_manual_references").val(referencesArray);
        } else {
            jQuery.msgBox({
                title:"Error!",
                content:"A Manual and Title are required.",
                type:"error"
            });
        }
        return false;
	});
	
	/* Delete manual reference */ 
    var urlDelArray = new Array();
    jQuery("table").delegate("tr td img.delete_manual_reference", "click", function(event){
    
            var thisItem = this;
            jQuery.msgBox({
            title:"Are You Sure",
            content:"Are you sure you want to delete this?" ,
            type:"confirm",
            buttons: [{ value: "Yes" }, { value: "No" }],
            success: function (result) {
                if (result == "Yes") {
                    var theId = jQuery(thisItem).parent('td').parent('tr').children().children('input').val();
                    if(theId.length > 6 && theId.substring(0, 6) === "~~~id:") {
                        theId = theId.split('~~~id:')[1];
                        urlDelArray.push(theId);
                        if(theId > 0) {
                            jQuery("#hidden_del_manual_references").val(urlDelArray);
                        }
                    }
                    jQuery(thisItem).parent('td').parent('tr').remove();

                    /* update hidden hidden_manual_references varible */
                    var referencesArray = new Array();
                    jQuery('table#references tr.table_links_list').children('td.this_link').each(function(){
                        var reference = jQuery(thisItem).children('input').val();
                        referencesArray.push(reference + "~~");
                    });
                    jQuery("#hidden_manual_references").val(referencesArray);
                    if (jQuery("#hidden_manual_references").val().length == 0)
                    {
                        var newOption = '<option value="NEW">New</option>';
                        jQuery(newOption).insertBefore("select#standard_change option:nth-child(1)");
                    }
                }
            }
        });
        return false;
    });
	
  /*add impact assessments into table */
	jQuery('.impact_assess').click(function(){
		/*alert("inside impact assess"); */
		var valuesExist = false;
		var editValues = false;
        var brand = jQuery("select#standard_bia_brand option:selected");
        var region = jQuery("select#standard_bia_regions option:selected");
        var capex = jQuery("select#CapEx option:selected");
        var pandl = jQuery("select#pandl option:selected");
        var implementation = jQuery("select#implementation option:selected");
        var change = jQuery("select#changeRegional option:selected");
        var biaCommentsObj = jQuery("#bia_comments");
        var biaComments = biaCommentsObj.val();
        var brandVal = brand.val();
        var regionVal = region.val();
        var capexVal = capex.val();
        var pandlVal = pandl.val();
        var implementationVal = implementation.val();
        var changeRegVal = change.val();
        var brandText = brand.text();
        var regionText = region.text();
        var capexText = capex.text();
        var pandlText = pandl.text();
        var implText = implementation.text();
        var changeRegText = change.text();
        var stdbiaId=0;
       	var table = jQuery("#impactAssessment");
       	var rowCount = jQuery('#impactAssessment tr').length;
       	var trId = rowCount + 1;
    	var biaCommentsVal = biaComments;
       	jQuery("table#impactAssessment tr ").each(function() {  	
       		/*alert("inside each Function") */
       		var firstTd = jQuery(this).children("td:first");
	       	var secondTd = firstTd.next();
	       	var thirdTd = secondTd.next();
	       	var fourthTd = thirdTd.next();
	       	var fifthTd = fourthTd.next();
	       	var sixthTd = fifthTd.next();
	       	var seventhTd = sixthTd.next();
	       	var eightTd = seventhTd.next();
	       
	       	if(!isChgRgnDisplay)
	       	{
	       		changeRegText="";
	       		changeRegVal="0";
	       	}
	       	if(biaCommentsVal == "")
	       	{
	       		biaCommentsVal = "0";
	       	}
	       		
	       /*	alert(firstTd.text()+" "+secondTd.text()+" "+thirdTd.text()+" "+fourthTd.text()+" "+fifthTd.text()+" "+sixthTd.text()); */
	       	if(secondTd.text() == brandText && thirdTd.text() == regionText && fourthTd.text() == changeRegText && fifthTd.text()== pandlText && sixthTd.text() == capexText && seventhTd.text() == implText)
	       	{   
	       		valuesExist = true;
	       		/*alert("The values you are trying to enter already exist in the table"); */
	       		return false;
	       	}
	       	else if(secondTd.text() == brandText && thirdTd.text() == regionText)
	       	{
	       		editValues = true;
	       		jQuery(this).html('<td style="display:none;" class="standard_file_type_td this_link">' + firstTd.text() + ' <input type="hidden" value="~~~id:' + firstTd.text() + '"/></td><td class="standard_file_type_td this_link">'+ brandText + '<input type="hidden" value="' + brandVal + '"/></td><td class="standard_file_type_td this_link">'+ regionText + '<input type="hidden" value="' + regionVal + '"/></td><td class="standard_file_type_td this_link">'+ changeRegText + '<input type="hidden" value="' + changeRegVal + '"/></td><td class="standard_file_type_td this_link">'+ pandlText + '<input type="hidden" value="' + pandlVal + '"/></td><td class="standard_file_type_td this_link">'+ capexText + '<input type="hidden" value="' + capexVal + '"/></td><td class="standard_file_type_td this_link">'+ implText + '<input type="hidden" value="' + implementationVal + '"/></td><td class="standard_file_type_td this_link">'+ biaComments + '<input type="hidden" value="' + biaCommentsVal + '"/></td><td><img class="delete_bia_reference" src="/BSTheme-theme/images/delete.png" /></td>');
	       	}
       	});
       
        if( brandVal != "" && regionVal != "" && capexVal !="" && pandlVal != "" && implementationVal!="" && !valuesExist && !editValues ){
           var biaId = 0;
        
            jQuery("table#impactAssessment").append('<tr id='+trId+' class="table_links_list"><td style="display:none;" class="standard_file_type_td this_link">' + biaId + ' <input type="hidden" value="~~~id:' + biaId + '"/></td><td class="standard_file_type_td this_link">'+ brandText + '<input type="hidden" value="' + brandVal + '"/></td><td class="standard_file_type_td this_link">'+ regionText + '<input type="hidden" value="' + regionVal + '"/></td></td><td class="standard_file_type_td this_link">'+ changeRegText + '<input type="hidden" value="' + changeRegVal + '"/></td><td class="standard_file_type_td this_link">'+ pandlText + '<input type="hidden" value="' + pandlVal + '"/></td><td class="standard_file_type_td this_link">'+ capexText + '<input type="hidden" value="' + capexVal + '"/></td><td class="standard_file_type_td this_link">'+ implText + '<input type="hidden" value="' + implementationVal + '"/></td><td class="standard_file_type_td this_link">'+ biaComments + '<input type="hidden" value="' + biaCommentsVal + '"/></td><td><img class="delete_bia_reference" src="/BSTheme-theme/images/delete.png" /></td></tr>');
           
        }
        return false;
	});
	
	/* Delete impact assessment reference */
    var urlBiaDelArray = new Array();
    jQuery("table").delegate("tr td img.delete_bia_reference", "click", function(event){
    
        var thisItem = this;
        jQuery.msgBox({
            title:"Are You Sure",
            content:"Are you sure you want to delete this?" ,
            type:"confirm",
            buttons: [{ value: "Yes" }, { value: "No" }],
            success: function (result) {
                if (result == "Yes") {
                    var theId = jQuery(thisItem).parent('td').parent('tr').children().children('input').val();
                    if(theId.length > 6 && theId.substring(0, 6) === "~~~id:") {
                        theId = theId.split('~~~id:')[1];
                        urlBiaDelArray.push(theId);
                        if(theId > 0) {
                            jQuery("#hidden_del_bia_references").val(urlBiaDelArray);
                        }
                    }
                    jQuery(thisItem).parent('td').parent('tr').remove();
                    /* update hidden hidden_manual_references varible */
                    var referencesArray = new Array();
                    jQuery('table#impactAssessment tr.table_links_list').children('td.this_link').each(function(){
                        var reference = jQuery(thisItem).children('input').val();
                        referencesArray.push(reference + "~~");
                    });
                    jQuery("#hidden_bia_references").val(referencesArray);
                }
            }
        });
        return false;
    });
	
	jQuery("select#standard_change").change(function(){
	    var thisValue = jQuery(this).val();
	    if(thisValue == "NEW"){
            jQuery.msgBox({
                title:"Are You Sure",
                content:jQuery("#change_type_mew_msg").val() ,
                type:"confirm",
                buttons: [{ value: "Yes" }, { value: "No" }],
                success: function (result) {
                    if (result == "Yes") {
                        /*clear any values inside of the hidden section  */
                        jQuery("select#manuals_brand").multiselect("uncheckAll");
                        jQuery("select#manuals_regions>option:selected").removeAttr("selected");
                        jQuery("select#manual_type").multiselect("uncheckAll");
                        jQuery("select#brand_manual>option:selected").removeAttr("selected");
                        jQuery("select#change_type>option:selected").removeAttr("selected");
                        jQuery("select#change_type").find("option:selected").removeAttr("selected");
                        jQuery("#title_code_page").val("");
                        jQuery("table#references tbody").children("tr.table_links_list").remove();
                        
                        jQuery(".hidden_form_contents").hide();
                        
                        /*reset any option values that clicking 'filter' may have populated. */
                        jQuery("select#brand_manual").empty().append('<option value="">Click the filter button</option>');
                    }
                    else
                    {
                        jQuery("select#standard_change>option:eq(1)").attr('selected', false);
                    }
                }
            });
		}else {
			jQuery(".hidden_form_contents").show();
		}
	});
	
    jQuery("select#brand_manual").change(function(){
        var thisValue = jQuery(this).val();
        
        jQuery("#change_type>option:selected").removeAttr("selected");
        jQuery("#change_type option").each(function() {
            if(jQuery(this).val() == "NEW")
            {
                jQuery(this).attr('selected', 'selected');
                return false;
            }
        });
	});
    
	jQuery(".filter_contents").click(function(){

        var brandArray = jQuery("select#manuals_brand").multiselect("getChecked").map(function(){
           return this.value;	
        }).get().toString();

        var regionsArray = jQuery("select#manuals_regions").find("option:selected").map(function(){
           return this.value;	
        }).get().toString();

        var manualTypeArray = jQuery("select#manual_type").multiselect("getChecked").map(function(){
           return this.value;	
        }).get().toString();

        var url = jQuery("#historical_manual_url").val();
		
        jQuery.post(url, {brandArray:brandArray, regionsArray:regionsArray, manualTypeArray:manualTypeArray}, function(data){

            if(data.message == "Success") {
            
                delete data["message"];
                var recordCnt = data.recordCnt;
                delete data["recordCnt"];
                
                jQuery.msgBox({
                    title:"Info",
                    content:"Search returned " + recordCnt + " records",
                    type:"info"
                });
                /* clear previous values */
                jQuery("select#brand_manual").empty().append('<option value="">Select</option>');
                
                var theSelect = jQuery('select#brand_manual');
                jQuery.each(data, function(id, obj) {
                    theSelect.append(
                        jQuery('<option></option>').attr("id", id).attr("region", obj.region).attr("brand", obj.brand).val(obj.type).html(obj.title)
                    );
                });
            } else if(data.message == "Search failed") {
                jQuery.msgBox({
                    title:"Error!",
                    content:"Error occur during search",
                    type:"error"
                });
            } else {
                jQuery.msgBox({
                    title:"Info",
                    content:"There are no historical manuals for this brand / regional / Manual Type combination.  Please change your selection or contact your local administrator and request that the manual is uploaded to the CMS.",
                    type:"info"
                });
            }
        }, "json");    
		return false; /*do not refresh the page with default click behavior - return false instead; */
	});
   
    jQuery("#btn-add, #add_all_countries").click(function() {
        jQuery('#selectedcountries option').each(function() {
            if(!jQuery(this).attr("selected"))
            {
                jQuery(this).attr("selected", "selected");
            }
        });	
    });	

    if (jQuery("#OutsideofGuestJourney").is(':checked'))
    {
        jQuery("select#GuestJourney").multiselect("uncheckAll");
        jQuery("select#GuestJourney").multiselect("disable");
    }
    
    jQuery("#OutsideofGuestJourney").change(function() {
        if(this.checked)
        {
            jQuery("select#GuestJourney").multiselect("uncheckAll");
            jQuery("select#GuestJourney").multiselect("disable");
        }
        else
        {
            jQuery("select#GuestJourney").multiselect("enable");
        }
    });

    jQuery("label.wrapper_label").bind('click', function (e) {
        var tagName = e.target.tagName.toLowerCase();
        if(tagName == 'label' || tagName == 'span')
        {
            return false;
        }
        return true;
    });
    
	/************* code for changing Multiselect options based on single-select choice *********/
    var selectedAuthor = jQuery("#standard_author").val();
    if(selectedAuthor)
    {
        jQuery("#secondary_author option[value='"+selectedAuthor+"']").attr("selected", false);
        jQuery("#secondary_author option[value='"+selectedAuthor+"']").attr("disabled", true);
        jQuery("#secondary_author").multiselect("refresh");
    }
    
	jQuery("#secondary_author").multiselect({
		header: false /* no checkall to show */
	});

	jQuery("#standard_author").change(function(){
		/*now show 'other authors' */
		jQuery(".secondary_author_cont").show();
		
		var primaryAuthor = jQuery("#standard_author").val();
		/*console.log("primaryAuthor: "+primaryAuthor); */
		jQuery("#secondary_author option[value='"+primaryAuthor+"']").attr("selected", false);
        jQuery("#secondary_author option[value='"+primaryAuthor+"']").attr("checked", false);
		
		/*re-set all values of other authors */
		jQuery("#secondary_author").multiselect("refresh");
		jQuery("#secondary_author option").attr("disabled", false);
		
		/* disable the selected out of multiselect and refresh the UI */
		jQuery("#secondary_author option[value='"+primaryAuthor+"']").attr("disabled", true);
		jQuery("#secondary_author").multiselect("refresh");
	});
	
	/************* code for changing Multiselect options based on single-select choice *********/
    
	/************* other authors multi validation - 2 chosen at max *********************************/
    jQuery("#secondary_author").multiselect().bind("multiselectclick multiselectcheckall multiselectuncheckall", function( event, ui ){
        var checkedVals = jQuery("#secondary_author").multiselect("getChecked").map(function(){
            return this.value;
        }).get();

        if (checkedVals.length > 2) {
            event.preventDefault();
            event.stopPropagation();
            var lastChecked = ui.text;
            if(lastChecked)
            {
                jQuery("#secondary_author").multiselect("widget").find(":checkbox[value='"+lastChecked+"']").each(function(){
                    jQuery(this).attr("selected", false);
                    jQuery(this).attr("checked", false);
                });
            }
        }
    });
	/************* ends other authors multi validation  *********************************************/
    jQuery("input[id^='standard_brand']").change(function(e) {
    	if ( !$( this ).prop( 'checked' ) )
        {
    		if (!isLastBrandForImgFileLink(jQuery(this).val()))
    		{
    			updateBrandFromImgFileLink(customeTrim(jQuery(this).val()), customeTrim(jQuery(this).parent().text()));
        	}
    		else
    		{
    			$( this ).prop( 'checked', true );
    			jQuery.msgBox({
	                title:"Info",
	                content:"You can't remove " +jQuery(this).parent().text() +", this may empty one or many entry from Images/ Attachments/ Links",
	                type:"info"
	            });
    		}
        }
    	else
		{
    		isBrndAdded = true;
		}
         
    });
    
    
    
    /************* Add for CR 50.2 on change of Manual selection show hotel lifecycle section *********/
	var path = "/BSTheme-theme/images/";
	if(stdId < 0)
	{	
		jQuery("#hotel_lifecycle").css("display", "none");
	}
	
	jQuery('div.ht_lifecycle img').click(function()
	{	var $this = $(this);
		var imageId = $(this).attr('id');
		if(isHotelLifeCycleAdmin=='true'){
			if($this.hasClass('ht_active'))
			{	var restrictIds = jQuery('#restrictId').val();
			var clickedVal = $this.attr("id");
			/*var clickedVal = $this.next().attr("id");*/
			var restrictedHotelAttr = restrictHotelLifecycle(restrictIds, clickedVal);
	
				if(restrictedHotelAttr){
					var checkFlag = Boolean(checkRestrictedHotelLifecycle(restrictIds, imageId));
					if(!checkFlag) {
					$this.removeClass('ht_active').addClass('ht_inactive');
					$(this).attr('src',path+imageId+'_inactive.png');
					}
				}else{
					$this.removeClass('ht_active').addClass('ht_inactive');
					$(this).attr('src',path+imageId+'_inactive.png');
				}
			}else{
				
				$this.removeClass('ht_inactive').addClass('ht_active');
				$(this).attr('src',path+imageId+'_active.png');
				
			}
			
		}else{
			
			var manualArray = jQuery("select#Manual").multiselect("getChecked").map(function(){
				return this.value;	
			  });	
		if($this.hasClass('ht_active'))
		{
			
		    /*If Build & Operate then this it will show error message*/
			
			if(manualArray.length > 1) 
			{
				
				jQuery.msgBox({
						title: "Error!",
						content: "Content attributed to both manuals must always be attributed to existing.  If you want to select a lower Hotel Lifecycle then unattributed the operate manual.",
						type: "error",
						buttons: [{ value: "OK" }]
					});
			}
			else
			{
				var restrictIds = jQuery('#restrictId').val();
				/*var clickedVal = $this.attr("id");*/
				var clickedVal = $this.next().attr("id");
				var restrictedHotelAttr = restrictHotelLifecycle(restrictIds, clickedVal);
		
				if(restrictedHotelAttr){
					$(this).nextAll().each(function(){
						imageId = $(this).attr('id');
						var checkFlag = Boolean(checkRestrictedHotelLifecycle(restrictIds, imageId));
						if(!checkFlag) {
							$(this).attr('src',path+imageId+'_inactive.png');
							$(this).removeClass('ht_active').addClass('ht_inactive');
						}
					});
					
				}else {
					
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
			}
		}
		else
		{
			
			if(manualArray.length > 1) 
			{
				
				jQuery.msgBox({
						title: "Error!",
						content: "Content attributed to both manuals must always be attributed to existing.  If you want to select a lower Hotel Lifecycle then unattributed the operate manual.",
						type: "error",
						buttons: [{ value: "OK" }]
					});
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
		}
	}
	});
	
	jQuery("select#Manual").change(function(e, ui)
	{
		var selectedVal = jQuery("select#Manual>option:selected").val();
		var manualArray = jQuery("select#Manual").multiselect("getChecked").map(function(){
							return this.value;	
						  });
		if(manualArray.length > 1)
		{
			jQuery("#hotel_lifecycle").css("display", "block");
			jQuery('div.ht_lifecycle img').removeClass('ht_inactive').addClass('ht_active');
			jQuery('div.ht_lifecycle img').each(function(){
				imageId = $(this).attr('id');
				$(this).attr('src',path+imageId+'_active.png');
			});
		}
		else if(selectedVal == 258)
		{
			jQuery("#hotel_lifecycle").css("display", "none");
			jQuery('div.ht_lifecycle img').removeClass('ht_active').addClass('ht_inactive');
			jQuery('div.ht_lifecycle img').each(function(){
				imageId = $(this).attr('id');
				$(this).attr('src',path+imageId+'_inactive.png');
			});
		}
		else if(selectedVal == 257)
		{
			jQuery("#hotel_lifecycle").css("display", "block");
		}
			
	});
	
	var restrictHotelLifeCycleIds = jQuery('#restrictId').val();
	var restrictArray = restrictHotelLifeCycleIds.split(",");
	$("select#Manual").multiselect({
			click: function(e, ui){
				var clickVal =  ui.value;
				var isChecked = ui.checked ? true : false;
				var is257CheckedWithHotelLFC = false;
				//bellow if condition for part of CR 50.3
				if((restrictHotelLifeCycleIds != '' && restrictArray.length >= 1) && clickVal == 257 && !isChecked && isStd && (stdId > 0)){
					is257CheckedWithHotelLFC = true;
					e.preventDefault();
					e.stopPropagation();
					jQuery.msgBox({
						title: "Error!",
						content: "You cannot change the manual type as the Specification/Guideline are attributed to other manual type",
						type: "error"
					});
					jQuery("#hotel_lifecycle").css("display", "block");
					restrictArray.forEach(function(id,val){
						jQuery('div.ht_lifecycle img[id="'+id+'"]').attr('src',path+id+'_active.png');
						jQuery('div.ht_lifecycle img[id="'+id+'"]').removeClass('ht_inactive').addClass('ht_active');
					});
					
				}
				//Bellow condition for part of QC 7165
				if(!isChecked && !is257CheckedWithHotelLFC && isStd)
				{
					manualClick(e,clickVal);
				}
			},
			uncheckAll: function(e, ui){
				    //bellow 257 checking for part of CR 50.3 & QC 7165 both
					$("select#Manual").multiselect("widget").find(":checkbox[value='257']").each(function(){
						if(((restrictHotelLifeCycleIds != '' && restrictArray.length >= 1) || resManual.indexOf("257") != -1) && isStd && (stdId > 0)){
							is257CheckedWithHotelLFC = true;
							this.click();
						}
					});
					
					//Bellow checking for part of QC 7165
					$("select#Manual").multiselect("widget").find(":checkbox[value='258']").each(function(){
						if((resManual.indexOf("258") != -1 ) && isStd && (stdId > 0)){
							this.click();
						}
					});					
				
			}
			
	});

function manualClick(e, clickVal){
	
		if (resManual.indexOf(clickVal) != -1)
		{
			e.preventDefault();
			e.stopPropagation();
			jQuery.msgBox({
				title: "Error!",
				content: "You cannot change the manual type as the Specification/Guideline are attributed to other manual type",
				type: "error"
			});
		}
}	
	/* In standards edit mode Hotel Lifecycle is showing if Manual Type is operate. */
	var selectedManualVal = jQuery("select#Manual>option:selected").val();
	if(selectedManualVal == 258)
    {
		jQuery("#hotel_lifecycle").css("display", "none");
		jQuery('div.ht_lifecycle img').removeClass('ht_active').addClass('ht_inactive');
		jQuery('div.ht_lifecycle img').each(function(){
			imageId = $(this).attr('id');
			$(this).attr('src',path+imageId+'_inactive.png');
		});
	}
    else if(selectedManualVal == 257)
    {
	   jQuery("#hotel_lifecycle").css("display", "block");
	}
	else 
	{
	}
	/************* End for CR 50.2 on change of Manual selection show hotel lifecycle section *********/
	
 });

function populateSupportLinkBrands()
{
	jQuery('#support_link_brand_dv').html('');
	jQuery('#support_link_brand_dv').html('<select id="support_link_brand" class="multis combo_select_width" name="support_link_brand"></select>');
	populateBrands('support_link_brand');
	jQuery("#support_link_brand").multiselect();
	jQuery("select#support_link_brand").multiselect("uncheckAll");
}
function populateSupportLinkRegion()
{
	jQuery('#support_link_region_dv').html('');
	jQuery('#support_link_region_dv').html('<select id="support_link_region" class="multis combo_select_width" name="support_link_region" onchange="populateSupportLinkCountry()"></select>');
	populateRegions('support_link_region');
	jQuery("#support_link_region").multiselect();
	jQuery("select#support_link_region").multiselect("uncheckAll");
}
function populateSupportLinkCountry()
{
	jQuery('#support_link_country_dv').html('');
	jQuery('#support_link_country_dv').html('<select id="support_link_country" class="multis combo_select_width" name="support_link_country"></select>');
	var selectedReg = jQuery.map(jQuery("#support_link_region").multiselect("getChecked"), function( input ){
			return input.value;
		});
	
	jQuery("#support_link_country").empty();
	populateCountryByRegion(selectedReg,"support_link_country");
	jQuery("#support_link_country").multiselect();
	jQuery("select#support_link_country").multiselect("uncheckAll");
}

function populateExternalLinkBrands()
{
	jQuery('#extl_link_brand_dv').html('');
	jQuery('#extl_link_brand_dv').html('<select id="extl_link_brand" class="multis combo_select_width" name="extl_link_brand"></select>');
	populateBrands('extl_link_brand');
	jQuery("#extl_link_brand").multiselect();
	jQuery("select#extl_link_brand").multiselect("uncheckAll");
}

function populateExternalLinkRegion()
{
	jQuery('#extl_link_region_dv').html('');
	jQuery('#extl_link_region_dv').html('<select id="extl_link_region" class="multis combo_select_width" name="extl_link_region" onchange="populateExternalLinkCountry()"></select>');
	populateRegions('extl_link_region');
	jQuery("#extl_link_region").multiselect();
	jQuery("select#extl_link_region").multiselect("uncheckAll");
}
function populateExternalLinkCountry()
{
	jQuery('#extl_link_country_dv').html('');
	jQuery('#extl_link_country_dv').html('<select id="extl_link_country" class="multis combo_select_width" name="extl_link_country"></select>');
	var selectedReg = jQuery.map(jQuery("#extl_link_region").multiselect("getChecked"), function( input ){
			return input.value;
		});
	
	jQuery("#extl_link_country").empty();
	populateCountryByRegion(selectedReg,"extl_link_country");
	jQuery("#extl_link_country").multiselect();
	jQuery("select#extl_link_country").multiselect("uncheckAll");
}
function populateBiaBrands()
{
	populateBrands('standard_bia_brand');
}
function populateBrands(targetFld)
{
	populateBrandsFromCB('standard_brand', targetFld);
}
function populateRegions(targetFld)
{
	var selectedStdCntr = getStdSelectedCountry();
	var cntryArray = selectedStdCntr.split(",");
	var selectRgnByCntr = "";
	for (var i = 0; i < cntryArray.length-1; i++) 
	{	
		selectRgnByCntr += getRegionByCountryCode(cntryArray[i]).region_cd  + ",";
	}
	for (iReg1 = 0; iReg1 < regions.length; iReg1++)
    {
		if(isStringFound(selectRgnByCntr, regions[iReg1].region_cd))
		{
			jQuery('<option/>').val(regions[iReg1].region_cd).html(regions[iReg1].region_nm).appendTo('#'+targetFld);
		}
	}
}

function populateCountryByRegion(selectedRegionArray,targetFld)
{
	var selectedStdCntr = getStdSelectedCountry();
	for (slReg=0 ; slReg <selectedRegionArray.length; slReg++)
	{
		for (iReg=0;iReg<regions.length;iReg++)
		{
			if(selectedRegionArray[slReg] == regions[iReg].region_cd)
			{
				var country = regions[iReg].countries;
				for(iCnt=0;iCnt <country.length; iCnt++)
				{
					if (isStringFound(selectedStdCntr,country[iCnt][0]))
					{
						jQuery("#"+targetFld).append('<option value="'+country[iCnt][0]+'">'+country[iCnt][1]+'</option>');
					}
				}
			}
		}
	}
}
function populateBrandsFromCB(sourceFld, targetFld)
{
    var target = jQuery("#"+targetFld);
	var source = jQuery("#"+sourceFld);
    var dependentValues = [];
	var dependentTitles = [];
	jQuery('input:checkbox[name=' + sourceFld + ']:checked').each(function() {
	   dependentValues.push(jQuery(this).val());
	   dependentTitles.push(jQuery(this).parent().text());
     });

    /* update the target based on checked values */
    dependentValues.length ? dependentValues.join(', ') : '';
    dependentTitles.length ? dependentValues.join(', ') : '';
    jQuery(target).empty();
    for (var i = 0; i < dependentValues.length; i++) {
        jQuery(target).append('<option value="'+dependentValues[i]+'">'+dependentTitles[i]+'</option>');
    }
}
function populateBrandsFromMS(sourceFld, targetFld)
{
    var target = jQuery("#"+targetFld);
	var source = jQuery("#"+sourceFld);
    var dependentValues = [];
	var dependentTitles = [];
	
	var dependentValues = jQuery.map(jQuery(source).multiselect("getChecked"), function( input ){
        return input.value;
    });
    var dependentTitles = jQuery.map(jQuery(source).multiselect("getChecked"), function( input ){
        return input.title;
    });

    /* update the target based on checked values */
    dependentValues.length ? dependentValues.join(', ') : '';
    dependentTitles.length ? dependentValues.join(', ') : '';
    jQuery(target).empty();
    for (var i = 0; i < dependentValues.length; i++) {
        jQuery(target).append('<option value="'+dependentValues[i]+'">'+dependentTitles[i]+'</option>');
    }
}

function populateBiaRegions()
{
	var varSelectedRegions = new Array();
	jQuery('#selectedcountries option').each(function() {
		var selRegion = getRegionByCountryCode(this.value);
		if(jQuery.inArray(selRegion, varSelectedRegions) < 0)
		{
				varSelectedRegions.push(selRegion);
		}
    });	
    jQuery('#standard_bia_regions option').each( function() {
    	jQuery(this).remove();
    	
    });
    jQuery('#standard_bia_regions').append("<option value=''>Select</option>");
    for (iReg=0;iReg<varSelectedRegions.length;iReg++){
    	jQuery('#standard_bia_regions').append("<option value='"+varSelectedRegions[iReg].region_cd+"'>"+varSelectedRegions[iReg].region_nm+"</option>");
    }
    if(varSelectedRegions.length==4)
    {
    	jQuery("#changeRegional_div").show();
    	isChgRgnDisplay = true;
    }
    else
    {
    	jQuery("#changeRegional_div").hide();
    }
	
};

function initDragNDropImages()
{
    jQuery("#assign_images").tableDnD({
        onDragClass: "assignImgDrag",
        onDrop: function(table, row) {
            indexAssignImagesRows();
        },
        onDragStart: function(table, row) {
            /*alert("Started dragging row " + row.id); */
        }
    });
};

function indexAssignImagesRows()
{
    jQuery('table#assign_images tr.table_links_list').children('td.img_sort_order').each(function(){
        jQuery(this).children('input').val(jQuery(this).parent("tr").index());
    });
};

function duplicateAssignedImage(newImgId)
{
    var duplicate = false;
    
    jQuery('table#assign_images tr.table_links_list').children('td.this_link').each(function(){
        var input = jQuery(this).children('input');
        var varType = jQuery(input).attr("var_type");
        if ( varType == "imgId" ) 
        {
            var curId = jQuery(input).val();
            if (curId == newImgId )
            {
                duplicate = true;
                return false;
            }
        }
    });
    return duplicate;
}
var imageBrandId = 0;
function addAssignedImage(selectImgTbl)
{
    var stdImgId = 0;
    var image = "";
    var thumbnail = "";
    var imgTitle = "";
    var imgId = 0;
    var imgSmallId = 0;
    var imgDate = "";
    var imgDateTime = "";
    var imgAuthor = jQuery("#currUserName").val();
    var imgDesc = "";
    var imgSortOrder = 0;
    var imgUuId = "";
    var imgGroup = 0;
    var insertedNewRow = false;
    jQuery(selectImgTbl).each(function(){
        jQuery(this).children('td.this_link').each(function(){
            var value = jQuery(this).children('input').val();
            if ( value.search("imgId:") > -1 ) 
            {
                imgId = jQuery(this).text();
            }
            else if ( value.search("date:") > -1 )
            {
                imgDateTime = jQuery(this).text();
                var str = imgDateTime.split(" ");
                var strDate = str[0].split("-");
                var date = new Date(parseInt(strDate[0], 10), parseInt(strDate[1], 10) - 1, parseInt(strDate[2], 10));
                imgDate = jQuery.datepicker.formatDate('dd M yy', date);
            }
            else if ( value.search("desc:") > -1 )
            {
                imgDesc = jQuery(this).text();
                if (!imgDesc)
                {
                    imgDesc = '  ';
                }
            }
            else if ( value.search("uuid:") > -1 )
            {
                imgUuId = jQuery(this).text();
            }
            else if ( value.search("group:") > -1 )
            {
                imgGroup = jQuery(this).text();
            }
            else if ( value.search("smallId:") > -1 )
            {
                imgSmallId = jQuery(this).text();
            }
            else if ( value.search("title:") > -1 )
            {
                imgTitle = jQuery(this).text();
            }
        });

        if (!duplicateAssignedImage(imgId))
        {
            image = "/image/image_gallery?uuid=" + imgUuId + "&groupId=" + imgGroup;
            thumbnail = "/image/image_gallery?img_id=" + imgSmallId;
            jQuery("table#assign_images").append('<tr class="table_links_list">' + 
                '<td style="display:none;" class="asing_img_td this_link">' + imageBrandId + ' <input type="hidden" value="~~~id:' + imageBrandId + '"/></td>' +
                '<td style="display:none;" class="asing_img_td this_link img_sort_order"><input type="hidden" value="' + imgSortOrder + '"/></td>' +
                '<td class="asing_img_td this_link"><a href="'+ image + '" onclick="window.open (this.href, \'_blank\', \'height = 400, width = 650, resizable = yes\'); return false;"> <img title="image ' + imgId + '" src="' + thumbnail + '" alt="' + imgId + '"/></a>' +
                ' <input type="hidden" value="img_id=' + imgId + '"/></td>' +
                '<td class="asing_img_title_td this_link">'+ imgTitle +'<input type="hidden" value="' + imgTitle + '"/></td>' +
                '<td class="asing_img_td this_link">' + imgId + '<input type="hidden" var_type="imgId" value="' + imgId + '"/></td>' +
                '<td class="asing_img_td this_link">' + imgDate + '<input type="hidden" value="' + imgDate + '"/></td>' +
                '<td class="asing_img_td this_link">' + imgAuthor + '<input type="hidden" value="' + imgAuthor + '"/></td>' +
				
                '<td class="asing_img_td this_link"><p class="tiny_text"></p><input type="hidden" id="img_selected_brand'+imgId+'" value=""/><div id="btn-select-brand'+imgId+'"><a title="select brand" href="#" class="select_brand">Select Brand</a></div></td>' +
				
				'<td class="asing_img_td this_link"><p class="tiny_text"></p><input type="hidden" id="img_selected_rgn'+imgId+'" value=""/><div id="btn-select-rgn'+imgId+'"><a title="select region" href="#" class="select_rgn">Select Region</a></div></td>' +

				'<td class="asing_img_td this_link"><p class="tiny_text"></p><input type="hidden" id="img_selected_cntr'+imgId+'" value=""/><div id="btn-select-cntr'+imgId+'"><a title="select country" href="#" class="select_cntr">Select Country</a></div></td>' +
				
				'<td class="asing_img_td this_link">' + imgDesc + '<input type="hidden" value="NA"/></td>' +
                '<td><img class="delete_this_image" title="delete" src="/BSTheme-theme/images/delete.png" alt="delete"/></td></tr>');
			populateBrands("image_brand_"+imageBrandId);
			jQuery("#image_brand_"+imageBrandId).multiselect();
			jQuery("select#image_brand_"+imageBrandId).multiselect("uncheckAll");
			/* Country Region Function Loading */
			populateSelectBrandPopUp("btn-select-brand",imgId,"img");			
			populateSelectCountryPopUp("btn-select-cntr",imgId,"img");			
			populateSelectRegionPopUp("btn-select-rgn",imgId,"img");		
			imageBrandId--;
			stdImgId = 0;
            image = "";
            thumbnail = "";
            imgTitle = "";
            imgId = 0;
            imgSmallId = 0;
            imgDate = "";
            imgDateTime = "";
            imgDesc = "";
            imgSortOrder = 0;
            imgUuId = "";
            imgGroup = 0;
            insertedNewRow = true;
        }
    });
    
    if (insertedNewRow)
    {
        indexAssignImagesRows();
        initDragNDropImages();
    }
};

function populateSelectBrandPopUp(elementId, entryPKId, isFor)
{
	var dynamicID = "#"+elementId+entryPKId;
	jQuery(dynamicID).click( function(){		
		jQuery("#img_brand_popup").click();
		var dependentValues = [];
		var dependentTitles = [];
		jQuery('input:checkbox[name="standard_brand"]:checked').each(function() {
		   dependentValues.push(jQuery(this).val());
		   dependentTitles.push(jQuery(this).parent().text());
		 });
		 jQuery("#select-brand-list").html("");
		 var forId = isFor + "_selected_brand"; 
		 var popUpFor =isFor + "Brand"
		 var selectedBrand = jQuery('#'+forId+entryPKId).val();
		 /* bellow value is equal to entryPKId, we can ignore */
		 var rowID = jQuery(dynamicID).parent('td').parent('tr').children().children('input').val();
		 rowID = rowID.replace("~~~id:","");
				 
		 jQuery("#select-brand-list").append('<h3>Select Brand</h3><input type="checkbox" id="selectall"/> All Brands<div class="divider"> </div><input id="img_id" type="hidden" class="'+ rowID +'" value="'+forId+entryPKId+'"> <input id="popup_for" type="hidden" value="'+popUpFor+'"> ');
		 var dynamicTable = "<table>";
		 for (var i = 0; i < dependentValues.length; i++) 
		 {			
				if ((i+1)%2==1)
				{
					dynamicTable += "<tr>";
				}
				if (isStringFound(selectedBrand, dependentValues[i]))
				{
					dynamicTable += '<td class="perspective_left"><input id="select_img_brand'+dependentValues[i]+'" class="select_img_brand_checkbox" checked type="checkbox" value="'+dependentValues[i]+'" name="select_img_brand">' +dependentTitles[i] +'</td>';
				} 
				else 
				{
					dynamicTable += '<td class="perspective_right"><input id="select_img_brand'+dependentValues[i]+'" class="select_img_brand_checkbox" type="checkbox" value="'+dependentValues[i]+'" name="select_img_brand">' +dependentTitles[i]  +'</td>'
					
				}
				if ((i+1)%2==0)
				{
					dynamicTable += "</tr>";
				}
		}
		dynamicTable += "</table>";
		jQuery("#select-brand-list").append(dynamicTable);
		if(isFor=="img"){
			jQuery(this).html('<a href="#"><img title="edit brand" src="/BSTheme-theme/images/edit_pencil_icon.png" alt="edit brands"/> </a>');
		}
		//Select all Code start
		jQuery(".select_img_brand_checkbox").change(function() { //loop through each checkbox
               checkForSelectAll('selectall', 'select_img_brand_checkbox');				
		});
		//Select all Code start
		selectDeselectAll('selectall', 'select_img_brand_checkbox');
		//Select all Code end
	});
}

function populateSelectCountryPopUp(elementId, entryPKId, isFor)
{
	var dynamicID = "#"+elementId+entryPKId;
	jQuery(dynamicID).click( function(){  
		jQuery("#img_brand_popup").click();
		 jQuery("#select-brand-list").html("");		 
		 
		var forId = isFor + "_selected_cntr";
		var popUpFor =isFor + "Cntr" ;
		var selectedStdCntr = getStdSelectedCountry();
		var selectedCntr = jQuery("#"+forId+entryPKId).val();
		 var rowID = jQuery(dynamicID).parent('td').parent('tr').children().children('input').val();
		 rowID = rowID.replace("~~~id:","");		 
		  
		 var imgRgnSelected = jQuery("#" + isFor+"_selected_rgn"+entryPKId).val();
		 imgRgnSelected = imgRgnSelected.split(",");
		 var regionsArray = new Array();
		 for (var i=0; i < imgRgnSelected.length; i++)
		 {
			if(imgRgnSelected[i]=="AMEA")
			{
				regionsArray.push(ameaOptions);
			}
			if(imgRgnSelected[i]=="AMER")
			{
				regionsArray.push(amerOptions);
			}
			if(imgRgnSelected[i]=="EURO")
			{
				regionsArray.push(euOptions);
			}
			if(imgRgnSelected[i]=="GC")
			{
				regionsArray.push(gcOptions);
			}
		 }
		 
		 jQuery("#select-brand-list").append('<h3>Select Country</h3><input type="checkbox" id="selectall"/> All Countries<div class="divider"> </div><input id="img_id" type="hidden" class="'+ rowID +'" value="'+forId+entryPKId+'"> <input id="popup_for" type="hidden" value="'+popUpFor+'">');
		 var countryCount = 0;
		 var dynamicTable = "<table>";
		 for (var r=0; r < regionsArray.length; r++)
		 {
			 var regionCountry = regionsArray[r];
			 for (var i = 0; i < regionCountry.length; i++) 
			 {			
				if(isStringFound(selectedStdCntr, regionCountry[i][0]))	
				{
					if ((countryCount+1)%2==1)
					{
						dynamicTable += "<tr>";
					}
					
					if (isStringFound(selectedCntr, regionCountry[i][0]))
					{
						dynamicTable += '<td class="perspective_left"><input id="select_img_cntr'+regionCountry[i][0]+'" class="select_img_cntr_checkbox" checked type="checkbox" value="'+regionCountry[i][0]+'" name="select_img_cntr">' +regionCountry[i][1] +'</td>';
					} 
					else 
					{
						dynamicTable += '<td class="perspective_right"><input id="select_img_cntr'+regionCountry[i][0]+'" class="select_img_cntr_checkbox" type="checkbox" value="'+regionCountry[i][0]+'" name="select_img_cntr">' +regionCountry[i][1] +'</td>';
					}
					
					if ((countryCount+1)%2==0)
					{
						dynamicTable += "</tr>";
					}
					countryCount++;
				}
			}
		}
		dynamicTable += "</table>";
		if (regionsArray.length==0)
		{
			dynamicTable = '<em class="required">Region(s) must be selected before selecting country.</em><br/><br/>';
		}
		if(countryCount <= 0 && regionsArray.length>0)
		{
			dynamicTable = '<em class="required"> Region countries not found in selected standards country list, Please select other region!!</em><br/><br/>';
			
			
		}
		
		jQuery("#select-brand-list").append(dynamicTable);
		if(isFor=="img"){
			jQuery(this).html('<a href="#"><img title="edit country" src="/BSTheme-theme/images/edit_pencil_icon.png" alt="edit country"/> </a>');
		}
		
		//Select all Code start
		jQuery(".select_img_cntr_checkbox").change(function() { //loop through each checkbox
               checkForSelectAll('selectall', 'select_img_cntr_checkbox');				
		});
		selectDeselectAll('selectall', 'select_img_cntr_checkbox');
		//Select all Code end
	});
}
function populateSelectRegionPopUp(elementId, entryPKId, isFor)
{
	var dynamicID = "#"+elementId+entryPKId;
	jQuery(dynamicID).click( function(){
		jQuery("#img_brand_popup").click();
		jQuery("#select-brand-list").html("");
		var stdRegion =  "";
		jQuery("#standard_regions option").each(function(){
			stdRegion +=this.value +",";
		});
		var forId = isFor + "_selected_rgn";
		var popUpFor =isFor + "Rgn" ;
		
		var selectedStdCntr = getStdSelectedCountry();
		var cntryArray = selectedStdCntr.split(",");
		var selectRgnByCntr = "";
		for (var i = 0; i < cntryArray.length-1; i++) 
		 {	
			 selectRgnByCntr += getRegionByCountryCode(cntryArray[i]).region_cd  + ",";
		 }
		 
		var selectedRgn = jQuery("#"+forId+entryPKId).val();
		var rowID = jQuery(dynamicID).parent('td').parent('tr').children().children('input').val();
		rowID = rowID.replace("~~~id:","");
		
		jQuery("#select-brand-list").append('<h3>Select Region</h3><input type="checkbox" id="selectall"/> All Regions<div class="divider"> </div><input id="img_id" type="hidden" class="'+ rowID +'" value="'+forId+entryPKId+'"> <input id="popup_for" type="hidden" value="'+popUpFor+'"> ');
		 var dynamicTable = "<table>";
		 var regionCount = 0;
		 for (var i = 0; i < regions.length; i++) 
		 {			
			if(isStringFound(selectRgnByCntr, regions[i].region_cd))
			{
					if ((regionCount+1)%2==1)
					{
						dynamicTable += "<tr>";
					}
					
					if(isStringFound(selectedRgn, regions[i].region_cd))	
					{
						dynamicTable += '<td class="perspective_left"><input id="select_img_rgn'+regions[i].region_cd+'" class="select_img_rgn_checkbox" checked type="checkbox" value="'+regions[i].region_cd+'" name="select_img_rgn">' +regions[i].region_nm +'</td>';
					} 
					else 
					{
						dynamicTable += '<td class="perspective_right"><input id="select_img_rgn'+regions[i].region_cd+'" class="select_img_rgn_checkbox" type="checkbox" value="'+regions[i].region_cd+'" name="select_img_rgn">' +regions[i].region_nm +'</td>';
					}
					
					if ((regionCount+1)%2==0)
					{
						dynamicTable += "</tr>";
					}
					regionCount++;
			}
				
		}
		if (selectRgnByCntr.length==0)
		{
			dynamicTable = '<em class="required">Standards countries must be selected for region(s) assignment.</em><br/><br/>';
		}
		dynamicTable += "</table>";
		jQuery("#select-brand-list").append(dynamicTable);
		if(isFor=="img"){
			jQuery(this).html('<a href="#"><img title="edit region" src="/BSTheme-theme/images/edit_pencil_icon.png" alt="edit Region"/> </a>');
		}
		//Select all Code start
		jQuery(".select_img_rgn_checkbox").change(function() { //loop through each checkbox
               checkForSelectAll('selectall', 'select_img_rgn_checkbox');				
		});
		//Select all Code start
		selectDeselectAll('selectall', 'select_img_rgn_checkbox');
		//Select all Code end
	});
}
/*
  Select/deselect All brand/region/country
*/
function selectDeselectAll(selectCheckEleId, cssClass)
{
	jQuery('#'+selectCheckEleId).click(function(event) {  
			if(this.checked) { // check select status
				jQuery('.'+cssClass).each(function() { 
                this.checked = true;                
				});
			}else{
				jQuery('.'+cssClass).each(function() { 
                this.checked = false;                     
				});         
			}
		});
		//Check for select all state
		checkForSelectAll(selectCheckEleId, cssClass);
		
}
/*
Check Country/region/brand all check box checked or not for extlink/attachments/images
*/
function checkForSelectAll (selectCheckEleId, cssClass)
{
	var selectedCheckLen = jQuery('.'+cssClass+':checked').length;
	var totalCheckLen = jQuery('.'+cssClass).length;
	if (selectedCheckLen == totalCheckLen  && selectedCheckLen  > 0 ) 
	{
		jQuery('#'+selectCheckEleId).prop("checked", true);
	}
	else
	{
		jQuery('#'+selectCheckEleId).prop("checked", false);
	}
}

function getStdSelectedCountry()
{
	var selectedStdCntr = "";
		jQuery('#selectedcountries option').each(function() {
			selectedStdCntr += this.value + ",";
		});
	return selectedStdCntr;
}


function isStringFound(selectedBrand, searchBrand)
{
	if(selectedBrand==null)
	{
		return false;
	}
	var strArray = selectedBrand.split(",");
	if(strArray.length > 0)
	{
		for (var i=0; i< strArray.length ; i ++)
		{
			if (strArray[i]==searchBrand)
			{
				return true;
			}
		}
	}
	return false;
}

function btnPopupSave(){
	var popupFor = jQuery("#popup_for").val();
	var codeValues = [];
	var titleValues = [];
	if (popupFor == "imgBrand")
	{
		jQuery('input:checkbox[name="select_img_brand"]:checked').each(function() 
		{
			 codeValues.push(jQuery(this).val());	 
			 titleValues.push(jQuery(this).parent().text());
		});
		if (codeValues.length > 0) 
		{
			var stdImageId = jQuery("#img_id").attr("class");
			if (stdImageId != "0")
			{
				var indx = isArrayElementFound(editImageArray, stdImageId);
				if (indx != -1) 
				{
					var elementRow = editImageArray[indx];				
					editImageArray[indx] = {ID:elementRow.ID,Brand:codeValues,Cntr:elementRow.Cntr};
				}
				else
				{
					editImageArray.push({ID:stdImageId,Brand:codeValues,Cntr:"##"});
				}
			}
		}
	} 
	else if (popupFor == "imgCntr") 
	{
		jQuery('input:checkbox[name="select_img_cntr"]:checked').each(function() 
		{
			 codeValues.push(jQuery(this).val());	 
			 titleValues.push(jQuery(this).parent().text());
		});
		if (codeValues.length > 0) 
		{
			var stdImageId = jQuery("#img_id").attr("class");
			if (stdImageId != "0")
			{
				var indx = isArrayElementFound(editImageArray, stdImageId);
				if (indx != -1) 
				{
					var elementRow = editImageArray[indx];				
					editImageArray[indx] = {ID:elementRow.ID,Brand:elementRow.Brand,Cntr:codeValues};
				}
				else
				{
					editImageArray.push({ID:stdImageId,Brand:"##",Cntr:codeValues});
				}
			}
		}
		
	}
	else if (popupFor == "imgRgn")
	{
		jQuery('input:checkbox[name="select_img_rgn"]:checked').each(function() 
		{
			 codeValues.push(jQuery(this).val());	 
			 titleValues.push(jQuery(this).parent().text());
		});
		
	}
	else if (popupFor == "fileBrand")
	{
		jQuery('input:checkbox[name="select_img_brand"]:checked').each(function() 
		{
			 codeValues.push(jQuery(this).val());	 
			 titleValues.push(jQuery(this).parent().text());
		});
		
		if (codeValues.length > 0) 
		{
			var stdImageId = jQuery("#img_id").attr("class");
			if (stdImageId != "0")
			{
				var indx = isArrayElementFound(editAttachmentArray, stdImageId);
				if (indx != -1) 
				{
					var elementRow = editAttachmentArray[indx];				
					editAttachmentArray[indx] = {ID:elementRow.ID, TITLE:elementRow.TITLE,Brand:codeValues,Cntr:elementRow.Cntr};
				}
				else
				{
					editAttachmentArray.push({ID:stdImageId,TITLE:"##",Brand:codeValues,Cntr:"##"});
				}
			}
		}
		
	} 
	else if (popupFor == "fileRgn")
	{
		jQuery('input:checkbox[name="select_img_rgn"]:checked').each(function() 
		{
			 codeValues.push(jQuery(this).val());	 
			 titleValues.push(jQuery(this).parent().text());
		});
		
	}
	else if (popupFor == "fileCntr") 
	{
		jQuery('input:checkbox[name="select_img_cntr"]:checked').each(function() 
		{
			 codeValues.push(jQuery(this).val());	 
			 titleValues.push(jQuery(this).parent().text());
		});
		if (codeValues.length > 0) 
		{
			var stdImageId = jQuery("#img_id").attr("class");
			if (stdImageId != "0")
			{
				var indx = isArrayElementFound(editAttachmentArray, stdImageId);
				if (indx != -1) 
				{
					var elementRow = editAttachmentArray[indx];				
					editAttachmentArray[indx] = {ID:elementRow.ID, TITLE:elementRow.TITLE,Brand:elementRow.Brand,Cntr:codeValues};
				}
				else
				{
					editAttachmentArray.push({ID:stdImageId,TITLE:"##",Brand:"##",Cntr:codeValues});
				}
			}
		}
		
	}
	else if (popupFor == "extlBrand")
	{
		jQuery('input:checkbox[name="select_img_brand"]:checked').each(function() 
		{
			 codeValues.push(jQuery(this).val());	 
			 titleValues.push(jQuery(this).parent().text());
		});
		
		if (codeValues.length > 0) 
		{
			var stdImageId = jQuery("#img_id").attr("class");
			if (stdImageId != "0")
			{
				var indx = isArrayElementFound(editUrlArray, stdImageId);
				if (indx != -1) 
				{
					var elementRow = editUrlArray[indx];				
					editUrlArray[indx] = {ID:elementRow.ID,URL:elementRow.URL,TITLE:elementRow.TITLE,Brand:codeValues,Cntr:elementRow.Cntr};
				}
				else
				{
					editUrlArray.push({ID:stdImageId,URL:"#URL#",TITLE:"#Title#",Brand:codeValues,Cntr:"##"});
				}
			}
		}
		
	} 
	else if (popupFor == "extlRgn")
	{
		jQuery('input:checkbox[name="select_img_rgn"]:checked').each(function() 
		{
			 codeValues.push(jQuery(this).val());	 
			 titleValues.push(jQuery(this).parent().text());
		});
		
	}
	else if (popupFor == "extlCntr") 
	{
		jQuery('input:checkbox[name="select_img_cntr"]:checked').each(function() 
		{
			 codeValues.push(jQuery(this).val());	 
			 titleValues.push(jQuery(this).parent().text());
		});
		if (codeValues.length > 0) 
		{
			var stdImageId = jQuery("#img_id").attr("class");
			if (stdImageId != "0")
			{
				var indx = isArrayElementFound(editUrlArray, stdImageId);
				if (indx != -1) 
				{
					var elementRow = editUrlArray[indx];				
					editUrlArray[indx] = {ID:elementRow.ID,URL:elementRow.URL,TITLE:elementRow.TITLE,Brand:elementRow.Brand,Cntr:codeValues};
				}
				else
				{
					editUrlArray.push({ID:stdImageId,URL:"#URL#",TITLE:"#Title#",Brand:"##",Cntr:codeValues});
				}
			}
		}
		
	}
	if (jQuery('input:checkbox[name^="select_img_"]').length>0)
	{
		if (codeValues.length > 0 ) 
		{
			jQuery("#"+jQuery("#img_id").val()).val(codeValues);  // Store selected value to hidden
			jQuery("#"+jQuery("#img_id").val()).prev().html(titleValues.join(", ")); 
			jQuery.nmTop().close();
		} 
		else 
		{
			var opt = ""
			if (popupFor.lastIndexOf("Cntr")>0)
			{
				opt = "country"
			} 
			else if (popupFor.lastIndexOf("Rgn")>0)
			{
				opt = "region"
			}
			else if (popupFor.lastIndexOf("Brand")>0)
			{
				opt = "brand";
			}
			jQuery.msgBox({
				title: "Error!",
				content: "Atleast one " +opt+ " must be selected.",
				type: "error"
			});
		}
	} 
	else
	{
		jQuery.nmTop().close();
	}
}

function btnPopupCancel(){
	jQuery.nmTop().close();
}

/* Bellow function use to find element by id from Array (i.e. editUrlArray). */
function isArrayElementFound(sourceArray,id)
{
	var foundInxed =-1;
	if (sourceArray.length < 1)
	{
		return foundInxed;
	}
	for (var i = 0; i < sourceArray.length; i++) 
	{
		if (sourceArray[i].ID==id)
		{
			foundInxed = i;
			break;
		}
	}
	return foundInxed;
}
function initStdDragNDrop()
{
    jQuery("#searchedContentTable").tableDnD({
        onDragClass: "assignImgDrag",
        onDrop: function(table, row) {
        	jQuery('#isDragged').val(true);
        },
        onDragStart: function(table, row) {
        }
    });
};
function searchAction(){
	var searchStdId = jQuery("#crs_std_id").val();

	var dependentValues = [];
	jQuery('input:checkbox[name=standard_brand]:checked').each(function() {
	   dependentValues.push(jQuery(this).val());
     });
	var inData = {searchStdId:searchStdId, brands:dependentValues, regionCode:regionCode};
	jQuery.ajax({
		type: "POST",
		url: searchStdUrl,
		data: inData,
		datatype: "json",
	}).done(function(data){
		if(!jQuery.isEmptyObject(data)){
			var html = '<div class="cross_search_items"><p>'+data.stdType+': <span class="cross_search_id">'+searchStdId+'</span></p><p class="cross_search_text">'+data.stdTitle+'</p></div><input type="button" id="addButton" value="Add" onclick="addReference('+searchStdId+',\''+data.stdType+'\',\''+escape(data.stdTitle)+'\')">';
			jQuery("#resultSearchDiv").show();
			jQuery("#results").html(html);
		}else{
			jQuery("#resultSearchDiv").show();
			jQuery("#results").html('<div class="cross_search_items">No Record Found</div>');
		}
		
	}).fail(function(jqXHR, textStatus){
		alert("AJAX request failed with status:" + textStatus);
	});
}
function deleteRecord(stdId){
	jQuery.msgBox({
            title:"Are You Sure",
            content:"Are you sure you want to delete this?" ,
            type:"confirm",
            buttons: [{ value: "Yes" }, { value: "No" }],
            success: function (result) {
                if (result == "Yes") {
                    var isDeleted = false;
					jQuery('#searchedContentTable #'+stdId).remove();
					for (var i =0; i < standardArray.length; i++){
					   if (standardArray[i].std === stdId) {
						  standardArray.splice(i,1);
						  break;
					   }
					}
					if(standardArray.length == 0){
						jQuery("#myreferences").hide();
					}
					if(addStdIds.length == 0){
						deleteStdIds[deleteStdIds.length] = stdId;
					}
					for (var i =0; i < addStdIds.length; i++){
					   if (addStdIds[i] == stdId) {
							isDeleted = true;
							addStdIds.splice(i,1);
							break;
					   }
					}
					if(!isDeleted && addStdIds.length > 0){
						deleteStdIds[deleteStdIds.length] = stdId;
					}
					jQuery('#addStdIds').val(addStdIds);
					jQuery('#deleteStdIds').val(deleteStdIds);
					/*alert("addIds length : "+addStdIds.length);*/
					/*alert("deleteIds length : "+deleteStdIds.length);*/
                }
            }
        });
		return false;
}
function addReference(searchStdId,type,title){
	var actualTitle = unescape(title);
	var returnFlag = checkValidation(searchStdId);
	if(returnFlag){
		return false;
	}
	var htmlTr = '<tr id='+searchStdId+' class="crossRefRow"><td>'+searchStdId+'</td><td>'+type+'</td><td>'+actualTitle+'</td><td><a class="delete_cross_item"><img style="cursor:pointer;" src="/BSTheme-theme/images/delete.png" alt="delete" title="delete" onclick="deleteRecord('+searchStdId+')"/></a></td></tr>';
	var refObject = new Object();
	var isDeleted = false;
	refObject.std = searchStdId;
	refObject.type = type;
	refObject.title = actualTitle;
	standardArray[standardArray.length] = refObject;
	jQuery('#myreferences').show();
	jQuery('#searchedContentTable tbody').append(htmlTr);
	if(deleteStdIds.length == 0){
		addStdIds[addStdIds.length] = searchStdId;
	}
	for (var i =0; i < deleteStdIds.length; i++){
	   if (deleteStdIds[i] == searchStdId) {
			isDeleted = true;
		  	deleteStdIds.splice(i,1);
	      	break;
	   }
	}
	if(!isDeleted && deleteStdIds.length > 0){
		addStdIds[addStdIds.length] = searchStdId;
	}
	jQuery('#addStdIds').val(addStdIds);
	jQuery('#deleteStdIds').val(deleteStdIds);
	/*alert("addIds length : "+addStdIds.length);*/
	/*alert("deleteIds length : "+deleteStdIds.length);*/
	initStdDragNDrop();
}
function checkValidation(searchStdId){
	var filteredMyReference = $(standardArray).filter(function(){
        return this.std == searchStdId;
    });
	var filterdOtherReference = $(xRefOtherArray).filter(function(){
        return this.std == searchStdId;
    });
	if(stdId==searchStdId){
		jQuery.msgBox({
            title: "Error!",
            content: "Cross-reference must be different to the currently selected standard or specification.",
            type: "error"
        });
		return true;
	}
	if(filteredMyReference.length > 0){
		jQuery.msgBox({
            title: "Error!",
            content: "Selected cross-reference already added.",
            type: "error"
        });
		return true;
	}
	if(filterdOtherReference.length > 0){
		jQuery.msgBox({
            title: "Error!",
            content: "Selected cross-reference already referencing this standard or specification.",
            type: "error"
        });
		return true;
	}
	return false;
}
function processSpecGuidelineIds()
{
	var chainList = $('#chainSortOrder').val();
	if (typeof chainList != 'undefined' && chainList != null && chainList != '') {
		var chainArray = chainList.split(',');
		for (var i = 0; i < chainArray.length; i++) {
			processIds("#specification_list_"+chainArray[i], "#spec_std_ids_"+chainArray[i]);
			processIds("#guideline_list_"+chainArray[i], "#guide_std_ids_"+chainArray[i]);
		}
	} else {
		processIds("#specification_list", "#spec_std_ids");
		processIds("#guideline_list", "#guide_std_ids");
	}
	
}

function restrictManual(e, both, childs)
{
	var changedValue = jQuery("#Manual").val();
	if(changedValue != both)
	{
		var childArray = childs.split(",");
		var bFound = false;
		for (var i = 0; i < childArray.length; i++) 
		{
			if(childArray[i] == both || childArray[i]!=changedValue)
			{
				bFound = true;
				break;
			}
		}
		if(bFound)
		{
			jQuery.msgBox({
				title: "Error!",
				content: "You cannot change the manual type as the Specification/Guideline are attributed to other manual type",
				type: "error"
			});
			jQuery("#Manual").val(manualOpt);
		}
	}
}

function hotelLifeCycleFlagSelection()
{
	var hotelLifeCycleArray = new Array(); 
	jQuery.each(jQuery("div.ht_lifecycle img.ht_active"), function(index, value)
	{
    var id = jQuery(value).attr('id'); 
    hotelLifeCycleArray.push(id);
	});
	jQuery("#HotelLifecycle").val(hotelLifeCycleArray);
	return hotelLifeCycleArray;
}

function restrictHotelLifecycle(restrictId, clickedVal)
{
	var checkExist = false;
	
	var restrictArray = restrictId.split(",");
	for (var i = 0; i < restrictArray.length; i++) 
	{
		if(restrictArray[i] == clickedVal && isStd && (stdId > 0) )
		{
			checkExist = true;
			break;
		}
	}
	if(checkExist)
	{
		jQuery.msgBox({
			title: "Error!",
			content: "Attribute can not be <b>unattributed</b> at present time. \n" +
					 "There are specifications and or guidelines below \n" +
					 "that are also attributed to this Hotel Lifecycle. \n" +
					 "Re attribute the specifications and guidelines first \n" +
					 "before unattributing the standard.",
			type: "error",
			buttons: [{ value: "OK" }]
		});
		return checkExist;

	}	
}
function checkRestrictedHotelLifecycle (restrictId, currentId){
var restrictArray = restrictId.split(",");
for (var i = 0; i < restrictArray.length; i++) 
	{
		if(restrictArray[i] == currentId && isStd && (stdId > 0) )
		{
			return true;
		}
	}
 return false;	
}
// CR 50.2 Change End

/* save edited external links URL into table */
function validateLink(field)
{
	var thisItem = field;
	var linkId = jQuery(thisItem).parent('td').parent('tr').children().children('input').val();
	var editURL = jQuery(thisItem).parent('td').children('input').val();
	var editUrlTD = jQuery(thisItem).parent('td');
	var tdClass = jQuery(thisItem).parent('td').attr('class');
	var tdParentClass = jQuery(thisItem).parent('td').parent('tr').attr('class');
	var isValid = jQuery(thisItem).parent('td').children('input').valid();
		
	if(tdParentClass.indexOf('externl_lnk')!= -1)
	{
		if (isValid == 1 && editURL!="") 
		{
			editUrlTD.html(editURL + ' <input type="hidden" value="' +editURL+ '"/> <img class="edit_this_link" title="Save" src="/BSTheme-theme/images/edit_pencil_icon.png" alt="Save" />');
			linkId = linkId.replace("~~~id:","");
			var indx = isArrayElementFound(editUrlArray, linkId);
			
			if(indx!= -1)
			{ /* Edit Array element */
				var elementRow = editUrlArray[indx];
				if (tdClass.indexOf("standard_url_link_td")!= -1)
				{
					editUrlArray[indx] = {ID:linkId,URL:editURL,TITLE:elementRow.TITLE,Brand:elementRow.Brand,Cntr:elementRow.Cntr};		
				} else 
				{
					editUrlArray[indx] = {ID:linkId,URL:elementRow.URL,TITLE:editURL,Brand:elementRow.Brand,Cntr:elementRow.Cntr};
				}
			}
			else if(linkId > 0) 
			{  
				if (tdClass.indexOf("standard_url_link_td")!= -1)
				{
					editUrlArray.push({ID:linkId,URL:editURL,TITLE:"#Title#",Brand:"##",Cntr:"##"});	
				} 
				else 
				{
					editUrlArray.push({ID:linkId,URL:"#URL#",TITLE:editURL,Brand:"##",Cntr:"##"});	
				}
			} 
		}
	} else if (tdParentClass.indexOf('atchment')!= -1)
	{
		if (isValid == 1 && editURL!="") 
		{
			editUrlTD.html(editURL + ' <input type="hidden" value="' +editURL+ '"/> <img class="edit_this_attachment" title="Save" src="/BSTheme-theme/images/edit_pencil_icon.png" alt="Save" />');
			linkId = linkId.replace("~~~id:","");
			var indx = isArrayElementFound(editAttachmentArray, linkId);
			
			if(indx!= -1)
			{ /* Edit Array element */
				var elementRow = editAttachmentArray[indx];
				editAttachmentArray[indx] = {ID:linkId,TITLE:editURL,Brand:elementRow.Brand, Cntr:elementRow.Cntr};		
			}
			else if (linkId > 0) 
			{  
				editAttachmentArray.push({ID:linkId,TITLE:editURL,Brand:"##",Cntr:"##"});	
			} 
		}
	}
	return false;
}

function lastCountryCheck( resourceValue, removeValue)
{
	var isLast = false;
	resourceValue = resourceValue.replace(removeValue, "");
	resourceValue = resourceValue.substring(resourceValue.length-1,resourceValue.length) == "," ? resourceValue.substring(0,resourceValue.length-1) : resourceValue;
	resourceValue = resourceValue == "," ? resourceValue.replace(",","") : resourceValue;
	if(resourceValue.length == 0)
	{
		isLast = true;
	}
	return isLast;
}

function isLastCountryForImgFileLink(cntCode)
{
	var isLast = false;
	jQuery("input:hidden[id^='img_selected_cntr']").each(function(){
		var imgCntrValue = jQuery(this).val();
		if (imgCntrValue!=null && imgCntrValue!="" )
		{
			if (lastCountryCheck(imgCntrValue, cntCode))
			{
				isLast = true;
			}
		}
	});
	
	
	jQuery("input:hidden[id^='file_selected_cntr']").each(function(){
		var fileCntrValue = jQuery(this).val();
		if (fileCntrValue!=null && fileCntrValue!="" )
		{
			if (lastCountryCheck(fileCntrValue, cntCode))
			{
				isLast = true;
			}
		}
	});
	
	jQuery("input:hidden[id^='extl_selected_cntr']").each(function(){
		var linkCntrValue = jQuery(this).val();
		if (linkCntrValue!=null && linkCntrValue!="" )
		{
			if (lastCountryCheck(linkCntrValue, cntCode))
			{
				isLast = true;
			}
		}
	});
	return isLast;
}
/* update region and country for ext link, assign image, supporting material*/	
function updateRegionCountryFromImgFileLink( cntCode, cntName)
{
		cntName = customeTrim(cntName);
		jQuery("input:hidden[id^='img_selected_cntr']").each(function(){
			setRegionCountryCodeAndName(this, cntCode, cntName);
			
			var stdAssImgId = jQuery(this).attr("id").replace("img_selected_cntr", "");
			stdAssImgId = jQuery("#" +stdAssImgId+ " td:first input").val().replace("~~~id:","");
			var indx = isArrayElementFound(editImageArray, stdAssImgId);
			if (indx != -1) 
			{
				var elementRow = editImageArray[indx];				
				editImageArray[indx] = {ID:elementRow.ID,Brand:elementRow.Brand,Cntr:jQuery(this).val()};
			}
			else
			{
				editImageArray.push({ID:stdAssImgId,Brand:"##",Cntr:jQuery(this).val()});
			}
		});
		
		jQuery("input:hidden[id^='file_selected_cntr']").each(function(){
			setRegionCountryCodeAndName(this, cntCode, cntName);
			
			var attchFileId = jQuery(this).attr("id").replace("file_selected_cntr", "");
			var indx = isArrayElementFound(editAttachmentArray, attchFileId);
			if(indx!= -1)
			{ /* Edit Array element */
				var elementRow = editAttachmentArray[indx];
				editAttachmentArray[indx] = {ID:elementRow.ID,TITLE:elementRow.TITLE,Brand:elementRow.Brand, Cntr:jQuery(this).val()};		
			}
			else
			{  
				editAttachmentArray.push({ID:attchFileId,TITLE:"##",Brand:"##",Cntr:jQuery(this).val()});	
			} 
		});	

		jQuery("input:hidden[id^='extl_selected_cntr']").each(function(){
			setRegionCountryCodeAndName(this, cntCode, cntName);
			
			var stdLinkId = jQuery(this).attr("id").replace("extl_selected_cntr", "");
			var indx = isArrayElementFound(editUrlArray, stdLinkId);
			if (indx != -1) 
			{
				var elementRow = editUrlArray[indx];				
				editUrlArray[indx] = {ID:elementRow.ID,URL:elementRow.URL,TITLE:elementRow.TITLE,Brand:elementRow.Brand,Cntr:jQuery(this).val()};
			}
			else
			{
				editUrlArray.push({ID:stdLinkId,URL:"#URL#",TITLE:"#Title#",Brand:"##",Cntr:jQuery(this).val()});
			}
		});	
}

/* set region and country for ext link, assign image, supporting material*/
function setRegionCountryCodeAndName(element, cntCode, cntName)
{
	//Set country based on main country remove
	setCodeAndName(element, cntCode, cntName);
	
	//Set Region based on country remove
	var regionId = jQuery(element).attr("id").replace("cntr", "rgn");
	var regionText = customeTrim(jQuery ("#"+regionId).prev().html());
	var regionCode = jQuery ("#"+regionId).val();
		
	var selectedCountry = getStdSelectedCountry();
	var countryRegion = getRegionByCountryCode(cntCode);
    var removeRegionCode = countryRegion.region_cd; 
	var removeRegionName = countryRegion.region_nm; 	
	var isCntry = checkCountryRegion(removeRegionCode, selectedCountry);
	if(!isCntry)
	{
		regionCode = regionCode.replace (removeRegionCode, "") ;
		regionCode = regionCode == "," ? regionCode.replace(",","") : regionCode;
		jQuery ("#"+regionId).val(regionCode.replace(",,",","))
			
		regionText = regionText.replace (removeRegionName , ""); 
		regionText = regionText.replace(", ,",",");
		regionText = regionText.replace(",,",",");
		regionText = regionText.substring(regionText.length-2,regionText.length) == ", " ? regionText.substring(0,regionText.length-2) : regionText;
		regionText = regionText.substring(0,2) == ", " ? regionText.substring(2,regionText.length) : regionText;
		regionText = regionText.substring(0,1) == "," ? regionText.substring(1,regionText.length) : regionText;
		jQuery ("#"+regionId).prev().html(regionText);
	}
}

/* Check country  region when remove country*/
function checkCountryRegion(rgn_cd, selectedCountries)
{
	var countryList = "";
	for (jReg=0; jReg < regions.length; jReg++)
    {
		if (regions[jReg].region_cd == rgn_cd)
		{
			countryList = regions[jReg].countries.join(',');
		}
    }
	var selectedCntArr = selectedCountries.split(",");
	for (i=0; i<selectedCntArr.length; i++)
	{
		if("" != selectedCntArr[i] && countryList.indexOf(selectedCntArr[i]) != -1)
		{
			return true;
		}
	}
	
	return false;
}

function isLastBrandForImgFileLink(brndCode)
{
	var isLast = false;
	jQuery("input:hidden[id^='img_selected_brand']").each(function(){
		var imgBrndValue = jQuery(this).val();
		if (imgBrndValue!=null && imgBrndValue!="" )
		{
			if (lastCountryCheck(imgBrndValue, brndCode))
			{
				isLast = true;
			}
		}
	});
	
	
	jQuery("input:hidden[id^='file_selected_brand']").each(function(){
		var fileBrndValue = jQuery(this).val();
		if (fileBrndValue!=null && fileBrndValue!="" )
		{
			if (lastCountryCheck(fileBrndValue, brndCode))
			{
				isLast = true;
			}
		}
	});
	
	jQuery("input:hidden[id^='extl_selected_brand']").each(function(){
		var linkBrndValue = jQuery(this).val();
		if (linkBrndValue!=null && linkBrndValue!="" )
		{
			if (lastCountryCheck(linkBrndValue, brndCode))
			{
				isLast = true;
			}
		}
	});
	return isLast;
}

function updateBrandFromImgFileLink( brndCode, brndName)
{
		brndName= customeTrim(brndName);
		jQuery("input:hidden[id^='img_selected_brand']").each(function(){
			setCodeAndName(this, brndCode, brndName);
			
			var stdAssImgId = jQuery(this).attr("id").replace("img_selected_brand", "");
			stdAssImgId = jQuery("#" +stdAssImgId+ " td:first input").val().replace("~~~id:","");
			var indx = isArrayElementFound(editImageArray, stdAssImgId);
			if (indx != -1) 
			{
				var elementRow = editImageArray[indx];				
				editImageArray[indx] = {ID:elementRow.ID,Brand:jQuery(this).val(),Cntr:elementRow.Cntr};
			}
			else
			{
			
				
				editImageArray.push({ID:stdAssImgId,Brand:jQuery(this).val(),Cntr:"##"});
			}
		});
		
		jQuery("input:hidden[id^='file_selected_brand']").each(function(){
			setCodeAndName(this, brndCode, brndName);
			
			var attchFileId = jQuery(this).attr("id").replace("file_selected_brand", "");
			var indx = isArrayElementFound(editAttachmentArray, attchFileId);
			if(indx!= -1)
			{ /* Edit Array element */
				var elementRow = editAttachmentArray[indx];
				editAttachmentArray[indx] = {ID:elementRow.ID,TITLE:elementRow.TITLE,Brand:jQuery(this).val(),Cntr:elementRow.Cntr};		
			}
			else
			{  
				editAttachmentArray.push({ID:attchFileId,TITLE:"##",Brand:jQuery(this).val(),Cntr:"##"});	
			} 
		});	

		jQuery("input:hidden[id^='extl_selected_brand']").each(function(){
			setCodeAndName(this, brndCode, brndName);
			
			var stdLinkId = jQuery(this).attr("id").replace("extl_selected_brand", "");
			var indx = isArrayElementFound(editUrlArray, stdLinkId);
			if (indx != -1) 
			{
				var elementRow = editUrlArray[indx];				
				editUrlArray[indx] = {ID:elementRow.ID,URL:elementRow.URL,TITLE:elementRow.TITLE,Brand:jQuery(this).val(),Cntr:elementRow.Cntr};
			}
			else
			{
				editUrlArray.push({ID:stdLinkId,URL:"#URL#",TITLE:"#Title#",Brand:jQuery(this).val(),Cntr:"##"});
			}
		});	
}
//This method set code/name value of country/brand for imges/links/attachments
function setCodeAndName(element, brndCode, brndName)
{
	//Set country based on main country remove
	var selectedCode = customeTrim(jQuery(element).val());
	if (selectedCode != null && selectedCode!="")
	{
		selectedCode = selectedCode.replace(brndCode, "");
		selectedCode = selectedCode == "," ? selectedCode.replace(",","") : selectedCode;
		selectedCode = selectedCode.substring(selectedCode.length-1,selectedCode.length) == "," ? selectedCode.substring(0,selectedCode.length-1) : selectedCode;
		selectedCode = selectedCode.substring(0,1) == "," ? selectedCode.substring(1,selectedCode.length) : selectedCode;
		jQuery(element).val(selectedCode.replace(",,",",")); 
	}
				 
	var selectedName = customeTrim(jQuery(element).prev().text());
	if (selectedName != null && selectedName!="")
	{
		selectedName = selectedName.replace(brndName, "");	
		selectedName = selectedName.replace(", ,",",");
		selectedName = selectedName.replace(",,",",");
		selectedName = selectedName.substring(selectedName.length-2,selectedName.length) == ", " ? selectedName.substring(0,selectedName.length-2) : selectedName;
					
		selectedName = selectedName.substring(0,2) == ", " ? selectedName.substring(2,selectedName.length) : selectedName;
		selectedName = selectedName.substring(0,1) == "," ? selectedName.substring(1,selectedName.length) : selectedName;
		jQuery(element).prev().html(selectedName);
	}
}

function customeTrim(str)
{
		return str.replace(/^\s+/,"").replace(/\s+$/,"");
}