var validator;
var updContValidator;

// pre-submit callback 
function showRequest(formData, jqForm, options)
{
    if (validateContenTypeForm())
    {
        var isOperateChecked = $("#operateType").is(':checked');
        var isBuildChecked = $("#buildType").is(':checked');
        formData.push({ name: 'operateType', value: isOperateChecked });
        formData.push({ name: 'buildType', value: isBuildChecked });
        $.blockUI({ message: '<h3><img src="/BSTheme-theme/images/busy.gif" /> Please wait...</h3>' });
        return true;
    }
    return false;
};

//post-submit callback 
function showResponse(responseText, statusText, xhr, $form)  
{
    $.unblockUI();
    if (responseText && responseText == 'SUCCESS') 
    {
        window.location.href = "/web/brand-standards/bridge/manage";
    }
    else 
    {
       $.msgBox({
           title:"Error",
           content:responseText,
           type:"error"
       });
   }
    
};

function validateContenTypeForm()
{   
    if (validator)
    {
        return validator.form();
    }
    else
    {
        validator = getContenTypeFormValidator("#createDraftForm");
        return validator.form();
    }
};

function getContenTypeFormValidator(formSelector)
{
    var valdtr = $(formSelector).validate({
        rules: {
            required: true
        },
        messages: {
            operateType: 'Please select at least one value.'
        },
        errorPlacement: function(error, element) {
            if (element.attr("name") == "buld_operate_item")
            {
                error.insertAfter("#content_err_span"); 
            }
            if (element.attr("name") == "buld_operate_item_upd")
            {
                error.insertAfter("#content_upd_err_span"); 
            }
            else if (element.attr("name") == "dateInput")
            {
                error.insertAfter(".ui-datepicker-trigger");
            }
        }
    });
    return valdtr;
}

/* Update Content Type */
function validateUpdContenTypeForm()
{   
    if (updContValidator)
    {
        return updContValidator.form();
    }
    else
    {
        updContValidator = getContenTypeFormValidator("#updateContentTypeForm");
        return updContValidator.form();
    }
};

var origFullManual = false;
var origBuildManual = false;
var orogOperateManual = false;

function showUpdRequest(formData, jqForm, options)
{
    if (validateUpdContenTypeForm())
    {
        var isOperateChecked = $("#operateTypeUpd").is(':checked');
        var isBuildChecked = $("#buildTypeUpd").is(':checked');
        formData.push({ name: 'operateType', value: isOperateChecked });
        formData.push({ name: 'buildType', value: isBuildChecked });
        formData.push({ name: 'publishId', value: publishIdValue });
        formData.push({ name: 'environment', value: env_val });
        $.blockUI({ message: '<h3><img src="/BSTheme-theme/images/busy.gif" /> Please wait...</h3>' });
        return true;
    }
    return false;
};
/* END OF Update Content Type */

$(function() {
    
    var options = { 
        url:           publicationURL,  // override for form's 'action' attribute 
        target:        '#output',   // target element(s) to be updated with server response 
        beforeSubmit:  showRequest,  // pre-submit callback 
        success:       showResponse, // post-submit callback 
        // other available options: 
        type:      'post',        // 'get' or 'post', override for form's 'method' attribute 
        dataType:  'html'        // 'xml', 'script', or 'json' (expected server response type) 
    }; 
 
    // bind form using 'ajaxForm' 
    var crForm = $("#createDraftForm").ajaxForm(options);
    validator = getContenTypeFormValidator("#createDraftForm");
    
    $("#createPublication").bind('click', function (e) {
        e.preventDefault();
        e.stopPropagation();
        crForm.submit();
    });

    $("#closeCreateDraft").bind('click', function (e) {
        e.preventDefault();
        e.stopPropagation();
        $("#updatePublicationDate").val('');
        $("#createPublicationModal").dialog('close');
    });

    /* Update Content Type */
    var options = { 
        url:           updatePublicationURL,  // override for form's 'action' attribute 
        target:        '#output',   // target element(s) to be updated with server response 
        beforeSubmit:  showUpdRequest,  // pre-submit callback 
        success:       showResponse, // post-submit callback 
        // other available options: 
        type:      'post',        // 'get' or 'post', override for form's 'method' attribute 
        dataType:  'html'        // 'xml', 'script', or 'json' (expected server response type) 
    }; 
 
    // bind form using 'ajaxForm' 
    var updCntTypeForm = $("#updateContentTypeForm").ajaxForm(options);
    updContValidator = getContenTypeFormValidator("#updateContentTypeForm");
    
    $("#updateContTypeBtn").bind('click', function (e) {
        e.preventDefault();
        e.stopPropagation();
        updCntTypeForm.submit();
    });

    $("#closeContTypeBtn").bind('click', function (e) {
        e.preventDefault();
        e.stopPropagation();

        $("#updateContentTypeModal").dialog('close');

        $("#operateTypeUpd").prop("checked", origOperateManual);
        $("#buildTypeUpd").prop("checked", origBuildManual);
        
        operateManual = $("#operateTypeUpd").is(':checked');
        buildManual = $("#buildTypeUpd").is(':checked');
        fullManualShowHide(operateManual, buildManual);
    });
    
    if (fullManual)
    {
        $("#full-manual").show();
        $("#full-manual-upd").show();
    }
    else
    {
        $("#full-manual").hide();
        $("#full-manual-upd").hide();
    }
    
    $("#operateType, #buildType").bind('click', function (e) {
        operateManual = $("#operateType").is(':checked');
        buildManual = $("#buildType").is(':checked');
        fullManualShowHide(operateManual, buildManual);
    });

    $("#closeCreateDraft").bind('click', function (e) {
        $("#operateType").prop("checked", false);
        $("#buildType").prop("checked", false);
        
        operateManual = $("#operateType").is(':checked');
        buildManual = $("#buildType").is(':checked');
        fullManualShowHide(operateManual, buildManual);
    });

    $("#operateTypeUpd, #buildTypeUpd").bind('click', function (e) {
        operateManual = $("#operateTypeUpd").is(':checked');
        buildManual = $("#buildTypeUpd").is(':checked');
        fullManualShowHide(operateManual, buildManual);
    });

    function fullManualShowHide(operateManual, buildManual)
    {
        if (operateManual && buildManual)
        {
            fullManual = true;
            $("#full-manual").show();
            $("#full-manual-upd").show();
        }
        else
        {
            fullManual = false;
            $("#full-manual").hide();
            $("#full-manual-upd").hide();
        }
    };
    /* END OF Update Content Type */
    
	publishDialog = $( "#createPublicationModal" ).dialog({
		title:"Create Publication",
		autoOpen: false,
		center:true,
		resizable:false,
		width: 560,
		 modal: true
		});
		
	stagingDialog = $( "#publishToStaging" ).dialog({
		title:"Push To Staging",
		autoOpen: false,
		center:true,
		resizable:false,
		width: 560,
		 modal: true
		});
	
	updatePublishDialog = $( "#updatePublicationModal" ).dialog({
		title:"Update Publication",
		autoOpen: false,
		center:true,
		resizable:false,
		width: 560,
		 modal: true
		});
	
    updateContTypeDialog = $( "#updateContentTypeModal" ).dialog({
        title:"Update Publication Content Type",
        autoOpen: false,
        center:true,
        resizable:false,
        width: 560,
         modal: true
        });
    
	deletePublishDialog = $( "#deletePublicationModal" ).dialog({
		title:"Are you sure?",
		autoOpen: false,
		center:true,
		resizable:false,
		width: 560,
		 modal: true
		});
	
	publishToProdDialog = $( "#publishToProduction" ).dialog({
		title:"Push To Production",
		autoOpen: false,
		center:true,
		resizable:false,
		width: 560,
		 modal: true
		});
	
	manualsDialog = $( "#generateManuals" ).dialog({
		title:"Are you sure?",
		autoOpen: false,
		center:true,
		resizable:false,
		width: 560,
		 modal: true
		});
	
	//Manageaccordion call
	$("#Manageaccordion").accordion({
	        collapsible: true,
	        active: 0,
			heightStyle: "content"
	    });
	
	$( "#dateNow_ps" ).datepicker({
		minDate: 0,
		changeMonth: true, 
        changeYear: true,
		showOn: "button",
		buttonImage: "/BSBridge-theme/images/cal-icon.png",
		buttonImageOnly: true,
		buttonText: "Select date"
	});
	
	$("#timeNow_ps").timepicker({ 'step': 20, 'timeFormat': 'H:i' });
	$("#timeNow_pp").timepicker({ 'step': 20, 'timeFormat': 'H:i' });
	
	$( "#dateNow_pp" ).datepicker({
		minDate: 0,
		changeMonth: true, 
        changeYear: true,
		showOn: "button",
		buttonImage: "/BSBridge-theme/images/cal-icon.png",
		buttonImageOnly: true,
		buttonText: "Select date"
	});
	
	$( "#updatePublicationDate" ).datepicker({
		minDate: 0,
		changeMonth: true, 
        changeYear: true,
		showOn: "button",
		buttonImage: "/BSBridge-theme/images/cal-icon.png",
		buttonImageOnly: true,
		buttonText: "Select date"
	});
	
	$( "#dateInput" ).datepicker({
		minDate: 0,
        changeMonth: true, 
        changeYear: true, 
        //dateFormat: 'dd-M-yy',
        //showOn: 'both',
		showOn: "button",
		buttonImage: "/BSBridge-theme/images/cal-icon.png",
		buttonImageOnly: true,
		buttonText: "Select date"
	});
	
	$("#checkNow_ps").change(function(){
          $(".checknow_date").toggle(this.checked);
          $("#times_ps").toggle(this.checked);
    });
	
	$('#checkNow_ps').click (function(){
		if ($('#checkNow_ps').prop('checked')) {
			$('#dp2_ps').css('display','inline-block');
			$('#timeNow_ps').css('display','inline-block');
		} else {
			$('#dp2_ps').css('display','none');
			$('#timeNow_ps').css('display','none');
		}
		
	});

	$('#checkNow_pp').click (function(){
		if ($('#checkNow_pp').prop('checked')) {
			$('#dp2_pp').css('display','inline-block');
			$('#timeNow_pp').css('display','inline-block');
		} else {
			$('#dp2_pp').css('display','none');
			$('#timeNow_pp').css('display','none');
		}
		
	});
	
	$('#Manageaccordion table td').css('text-align','center');
	$('#Manageaccordion table th').css('text-align','center');
	
	$("#inputEmail_pp").keydown(function() {
		if($("#inputEmail_pp").val().length > 1024) {
			 $('#publishToProductionBtn').prop('disabled',true);
		} else {
			 $('#publishToProductionBtn').prop('disabled',false);
		}
	});
	
	$("#inputEmail_ps").keydown(function() {
		if($("#inputEmail_ps").val().length > 1024) {
			 $('#publishToStagingBtn').prop('disabled',true);
		} else {
			 $('#publishToStagingBtn').prop('disabled',false);
		}
	});
	
	$('#timeNow_pp').keydown(function(event){
	  event.preventDefault();
	});
	
	
    /*export dialog */
    $("#createReportDialog").dialog({
        autoOpen: false,
        width: 560,
         modal: true,
        open: function() {
            jQuery('.ui-widget-overlay').bind('click', function() {
                jQuery('#createReportDialog').dialog('close');
            })
        }
    });
    
    $(".reportCancel").click(function() {
        $("#createReportDialog").dialog("close");
    });
    
});

function openBridgeReport(activePubId)
{
    $("#createReportDialog").dialog('option', 'title', 'Create Bridge Report');
    $('#reportTitle').val('');
    
    /* Populate report here */
    $("#reportLst").empty();
    $("<span><input type='radio' name='reports' value='120' publishId='" + activePubId + "' checked /> Global Bridge Current Publication Status</span>").appendTo("#reportLst");
    if (archiveBridgePublishId > 0)
    {
        $("<br>").appendTo("#reportLst");
        $("<span><input type='radio' name='reports' value='121' publishId='" + archiveBridgePublishId + "' /> Global Bridge Post Publication Summary</span>").appendTo("#reportLst");
    }
    $("#createReportDialog").dialog("open");
};

function openStageReport(activePubId)
{
    $("#createReportDialog").dialog('option', 'title', 'Create Staging Report');
    $('#reportTitle').val('');
    
    /* Populate report here */
    $("#reportLst").empty();
    $("<span><input type='radio' name='reports' value='122' publishId='" + activePubId + "' checked /> Global Staging Current Publication Status</span>").appendTo("#reportLst");
/*
    $("<br>").appendTo("#reportLst");
    $("<span><input type='radio' name='reports' value='123' />Global Post Publication Summary Report</span>").appendTo("#reportLst");
*/
    $("#createReportDialog").dialog("open");
};

function openProductionReport(publishId, isActive)
{
    $("#createReportDialog").dialog('option', 'title', 'Create Production Report');
    $('#reportTitle').val('');
    
    /* Populate report here */
    $("#reportLst").empty();
    if (isActive)
    {
        $("<span><input type='radio' name='reports' value='124' publishId='" + publishId + "' checked /> Global Production Current Publication Status</span>").appendTo("#reportLst");
    }
    /*$("<br>").appendTo("#reportLst");*/
    else
    {
        $("<span><input type='radio' name='reports' value='125' publishId='" + publishId + "' checked /> Global Production Post Publication Summary</span>").appendTo("#reportLst");
    }
    $("#createReportDialog").dialog("open");
};


function createReport(reportId)
{
    var reportTitle = jQuery("#reportTitle").val();
    var reportId = jQuery("input[name='reports']:checked", "#createReportForm").val();
    var publishId = jQuery("input[name='reports']:checked").attr("publishId");
    var postData = {reportId:reportId,reportTitle:reportTitle,reportPublishId:publishId};
    jQuery.blockUI({ message: '<h3><img src="/BSTheme-theme/images/busy.gif" /> Please wait...</h3>' });
    
    jQuery.ajax({
        type: "POST",
        url: createReportURL,
        data: postData
    }).done( function(data) {
        jQuery.unblockUI();
        jQuery.msgBox({
            title: "Success!",
            content: "An email with a link to your Report will be sent to you once the Report has been generated.", 
            type: "info",
            buttons: [{ value: "OK" }],
            success: function (result) {
                $("#createReportDialog").dialog("close");
            }
        });
    }).fail( function(jqXHR) {
        jQuery.unblockUI();
        jQuery.msgBox({
            title: "Error!",
            content: "Failed submit request! Failure status:" + jqXHR.statusText + " status code:" + jqXHR.status ,
            type: "error",
            success: function (result) {
                ;
            }
        });
    });
};

function openDialog() {
	
	$( "#dateInput" ).datepicker("setDate", new Date() );
	publishDialog.dialog( "open" );
};

function openStagingDialog (publishVal) {
	publishIdValue = publishVal;
	$( "#dateNow_ps" ).datepicker("setDate", new Date() );
	stagingDialog.dialog( "open" );
};

function openProductionDialog (publishVal) {
	publishIdValue = publishVal;
	$( "#dateNow_pp" ).datepicker("setDate", new Date() );
	publishToProdDialog.dialog( "open" );
};

function openUpdatePublishDialog (publishIdVal, env) {
	publishIdValue = publishIdVal;
	env_val = env;
	$( "#updatePublicationDate" ).datepicker("setDate", new Date() );
	updatePublishDialog.dialog("open");
};

function openUpdateContentTypeDialog (publishIdVal, env) {
    publishIdValue = publishIdVal;
    env_val = env;
    updateContTypeDialog.dialog("open");
    
    origOperateManual = operateManual;
    origBuildManual = buildManual;
};

function deletePublishRecord (publishIdVal, publishQueueId) {
	publishIdValue = publishIdVal;
	publishQueueIdValue = publishQueueId;
	if (publishQueueId != 0) {
		$('#deleteMessage').text('Are you sure you want to remove this staging publication request?');
	} else {
		$('#deleteMessage').text('Are you sure you want to remove this publication, regions may be working on it!!');
	}
	deletePublishDialog.dialog("open");
};

function updatePublication() {
	var publishDate = $('#updatePublicationDate').val();
	$.ajax({
	  	url :updatePublicationURL,
	  	type: "POST",
	  	data: {"publishDate":publishDate,"publishId":publishIdValue, "environment":env_val},
	  	dataType: "text",
	    success: function(data) {
	    	if (data != null && typeof data != 'undefined' && data != '' && data == 'SUCCESS') {
	    		window.location.href = "/web/brand-standards/bridge/manage";
	    	} else {
	    		jQuery.msgBox({
	                title:"Error",
	                content:data,
	                type:"error"
	            });
	    	}
	    }
	 });
};

function publishToStage () {
	var publishDate = $('#dateNow_ps').val();
	var isSchedule = $('#checkNow_ps').is(':checked');
	var publishTime = $('#timeNow_ps').val();
	var emailId = $('#inputEmail_ps').val();
	$.ajax({
	  	url :publishToStagingURL,
	  	type: "POST",
	  	data: {"publishDate":publishDate,"draftPublishId":publishIdValue,"publishEmail":emailId,"publishTime":publishTime,"publishSchedule":isSchedule},
	  	dataType: "text",
	    success: function(data) {
	    	if (data != null && typeof data != 'undefined' && data != '' && data == 'SUCCESS') {
	            window.location.href = "/web/brand-standards/bridge/manage";
	    	} else {
	    		
	    		jQuery.msgBox({
	                title:"Error",
	                content:data,
	                type:"error"
	            });
	    	}
	    }
	 });
};

function publishToProd () {
	var publishDate = $('#dateNow_pp').val();
	var isSchedule = $('#checkNow_pp').is(':checked');
	var publishTime = $('#timeNow_pp').val();
	var emailId = $('#inputEmail_pp').val();
	$.ajax({
	  	url :publishToProdURL,
	  	type: "POST",
	  	data: {"publishDate":publishDate,"draftPublishId":publishIdValue,"publishEmail":emailId,"publishTime":publishTime,"publishSchedule":isSchedule},
	  	dataType: "text",
	    success: function(data) {
	    	
	    	if (data != null && typeof data != 'undefined' && data != '' && data == 'SUCCESS') {
	              window.location.href = "/web/brand-standards/bridge/manage";
	    	} else {
	    		
	    		jQuery.msgBox({
	                title:"Error",
	                content:data,
	                type:"error"
	            });
	    	}
	    }
	 });
};

function deletePublication () {
   	$.ajax({
  		url :deletePublicationURL,
  		data:{"publishId":publishIdValue,"publishQueueId":publishQueueIdValue},
  		type: "POST",
  		success: function(data) {
  			if ('SUCCESS' != data) {
  				jQuery.msgBox({
                    title:"Error!",
                    content:data,
                    type:"error"
                });
  			} else {
  				window.location.href = "/web/brand-standards/bridge/manage";
  			}
  			
  		}, error: function (e) {
    		jQuery.msgBox({
                   title:"Error!",
                   content:e,
                   type:"error"
               });
    		console.log(e);
		}
		});
};

function closeModal (divId) {
	if (divId != '' && divId != null) {
		if ('publishToStaging' == divId) {
			$('#checkNow_ps').removeAttr('checked');
			$('#dateNow_ps').val('');
			$('#timeNow_ps').val('');
			$('#inputEmail_ps').val('');
			$('#dp2_ps').css('display','none');
			$('#timeNow_ps').css('display','none');
		} else if ('publishToProduction' == divId) {
			$('#checkNow_pp').removeAttr('checked');
			$('#dateNow_pp').val('');
			$('#timeNow_pp').val('');
			$('#inputEmail_pp').val('');
			$('#dp2_pp').css('display','none');
			$('#timeNow_pp').css('display','none');
		} else if ('createPublicationModal' == divId) {
			$('#dateInput').val('');
		} else if ('updatePublicationModal' == divId) {
			$('#updatePublicationDate').val('');
		}
		$( "#"+divId ).dialog('close');
	}
};

function generateManuals () {
		
	$.ajax({
	  		url :generateManualsURL,
	  		data:{"publishId":publishIdValue,"pubEnv":env_val},
	  		type: "POST",
	  		success: function(data) {
	  			window.location.href = "/web/brand-standards/bridge/manage";
	  		}, error: function (e) {
	    		jQuery.msgBox({
	                   title:"Error!",
	                   content:"Error occurred",
	                   type:"error"
	               });
	    		console.log(e);
			}
		});
	
};

function openManualsDialog (publishIdVal, pubEnv) {
	if ('STAGING' == pubEnv) {
		$('#createManuals').html("Are you sure you want to regenerate all manuals in <u>Staging</u> for this publication?");
	} else {
		$('#createManuals').html("Are you sure you want to regenerate all manuals in <u>Production</u> for this publication?");
	}
	env_val = pubEnv;
	publishIdValue = publishIdVal;
	manualsDialog.dialog("open");
};
