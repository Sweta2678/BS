$(function() {
	/** Manage Accordion call*/
	$("#Manageaccordion").accordion({
        collapsible: true,
        active: 0,
		heightStyle: "content"
    });
	
	$('#Manageaccordion table td').css('text-align','center');
	$('#Manageaccordion table th').css('text-align','center');
	
	$('#upload_template_link').click(function(){
		$("#upload_new_template").dialog({
			resizable: false,
			modal: true,
			width: 900
		});
	});
	
	$('.att_cancel').click(function(){
		$("#upload_new_template").dialog( "close" );
	});
	
	jQuery.validator.setDefaults({
		debug: true,
		success: "valid"
	});
	
	$("#uploadTemplate").validate({
		rules: {
			/** Targeting form fields*/
			uploadFile: {
				required: true,
				extension: "xls|xlsx|xlsm"
			} 
		},
        messages: {
        	uploadFile: {
        		require_from_group: 'Upload xls or xlsx or xlsm file',
                extension: 'Only xls or xlsx or xlsm files are allowed',
            }
        },
	    submitHandler: function(form) {
	    	loadProgressBar();
	    	var formObj = $("#uploadTemplate");
	    	var formURL = formObj.attr("action");
		    var formData = new FormData(formObj[0]);
		    $.ajax({
		        url: formURL,
		    	type: 'POST',
		        data:  formData,
		        contentType: false,
		        mimeType:"multipart/form-data",
		        cache: false,
		        processData:false,
		        success: function(data, textStatus, jqXHR) {
			    	$( "#upload_new_template" ).dialog("close");
			    	jQuery.unblockUI();
			    	if (data == 'success') {
			    		jQuery.msgBox({
			                title: "Success!",
			                content: "Your template uploaded successfully", 
			                type: "info",
			                buttons: [{ value: "OK" }],
			                success: function (result) {
			                	window.location.href = "/web/brand-standards/gem/manage";
			                }
			            });
			    	} else {
			    		jQuery.msgBox({
			                title:"Error",
			                content:"Error occured",
			                type:"error"
			            });
			    	}
		        },
		        error: function(jqXHR, textStatus, errorThrown) {
		        	$( "#upload_new_template" ).dialog("close");
		        	jQuery.unblockUI();
		        }          
		    });
	    }	 
	});
	
	$("#createReportDialog").dialog({
        autoOpen: false,
        width: 560,
        modal: true,
        open: function() {
            jQuery('.ui-widget-overlay').bind('click', function() {
                jQuery('#createReportDialog').dialog('close');
            });
        }
    });
	
	$("#createPublicationModal").dialog({
		title:"Manage Measurement Publication",
		autoOpen: false,
		center:true,
		resizable:false,
		width: 560,
		modal: true
	});
	
    $("#closeCreateDraft").bind('click', function (e) {
        e.preventDefault();
        e.stopPropagation();
        $("#createPublicationModal").dialog('close');
    });
    
    $(".reportCancel").click(function() {
        $("#createReportDialog").dialog("close");
    });
    
    $("#createDraftForm .manageGemPublication").on('click', function() {
    	var gemPublicationEnv = jQuery.trim(jQuery('#createDraftForm #gemPublicationEnv option:selected').val());
    	var gemBridgePublicationId = jQuery.trim(jQuery('#createDraftForm #gemBridgePublicationId option:selected').val());
    	var gemOBSMPublicationId = jQuery.trim(jQuery('#createDraftForm #gemOBSMPublicationId option:selected').val());
    	
    	var gemSEManualType = jQuery.trim(jQuery('#createDraftForm #gemSEManualType option:selected').val());
    	var gemSAManualType = jQuery.trim(jQuery('#createDraftForm #gemSAManualType option:selected').val());
    	var gemWaiverManualType = jQuery.trim(jQuery('#createDraftForm #gemWaiverManualType option:selected').val());
    	var cmd = jQuery.trim(jQuery('#createDraftForm #cmd').val());
    	
    	var oldGemSEManualType = jQuery.trim(jQuery('#createDraftForm #oldGemSEManualType').val());
    	var oldGemSAManualType = jQuery.trim(jQuery('#createDraftForm #oldGemSAManualType').val());
    	var oldGemWaiverManualType = jQuery.trim(jQuery('#createDraftForm #oldGemWaiverManualType').val());
    	
    	if(gemPublicationEnv == 'GEM_CMS' && (typeof gemBridgePublicationId == 'undefined' || gemBridgePublicationId == null || gemBridgePublicationId == '' || gemBridgePublicationId == 'null')) {
    		jQuery.msgBox("Please select correct bridge publication for measurement.");
        } 
    	/* else if(gemPublicationEnv == 'GEM_CMS' && (typeof gemOBSMPublicationId == 'undefined' || gemOBSMPublicationId == null || gemOBSMPublicationId == '' || gemOBSMPublicationId == 'null')) {
    		jQuery.msgBox("Please select correct OBSM publication for measurement.");
    		return false;
    	}*/
    	else if(typeof gemSEManualType == 'undefined' || gemSEManualType == null || gemSEManualType == '' || gemSEManualType == 'null') {
    		jQuery.msgBox("Please select SE manual type.");
        }
    	else if(typeof gemSAManualType == 'undefined' || gemSAManualType == null || gemSAManualType == '' || gemSAManualType == 'null') {
    		jQuery.msgBox("Please select SA manual type.");
        }
    	else if(typeof gemWaiverManualType == 'undefined' || gemWaiverManualType == null || gemWaiverManualType == '' || gemWaiverManualType == 'null') {
    		jQuery.msgBox("Please select Waiver manual type.");
        }
    	else {
    		if(gemSEManualType == 'build' && (gemSAManualType == 'full_build_operate' || gemSAManualType == 'operate' || gemWaiverManualType == 'full_build_operate' || gemWaiverManualType == 'operate')){
    			jQuery.msgBox("Manual type of SA/Waiver should not be different or higher than SE.");
    		}
    		else if(gemSEManualType == 'operate' && (gemSAManualType == 'full_build_operate' || gemSAManualType == 'build' || gemWaiverManualType == 'full_build_operate' || gemWaiverManualType == 'build')){
    			jQuery.msgBox("Manual type of SA/Waiver should not be different or higher than SE.");
    		}
    		else{
    			var detailContent = "<span class=\"alert alert-danger\">Are you sure you want to drop current gem publication if already exist and create new gem publication?</span>";
    			if(cmd == 'update'){
    				detailContent = "<span class=\"alert alert-danger\">Are you sure you want to update current gem publication manual types?</span>";
    			}
	    		jQuery.msgBox({
	    		    title: "Are You Sure",
	    		    content: detailContent,
	    		    type: "confirm",
	    		    buttons: [{value: "Yes"}, {value: "No"}],
	    		    success: function (importConfirmation) {
	    		        if (importConfirmation == "Yes") {
	    			    	loadProgressBar();
	    					$.ajax({
	    					  	url :createPublicationURL,
	    					  	data: {"gemPublicationEnv":gemPublicationEnv,"gemBridgePublicationId":gemBridgePublicationId,"gemSEManualType":gemSEManualType,"gemSAManualType":gemSAManualType,"gemWaiverManualType":gemWaiverManualType,"oldGemSEManualType":oldGemSEManualType,"oldGemSAManualType":oldGemSAManualType,"oldGemWaiverManualType":oldGemWaiverManualType},
	    					  	type: "POST",
	    					  	dataType: "text"
	    					}).done(function(data) {
	    						/* Un load block UI */
	    						jQuery.unblockUI();
	    						if (data != null && data != '' && typeof data != 'undefined') {
	    							
	    				    		if(data == 'SUCCESS'){
	    				    			window.location.href = "/web/brand-standards/gem/manage";
	    							} else {
	    								jQuery.msgBox({
	    									title: "Errors!",
	    		                            content: "Failed to create Measurement Publication." ,
	    		                            type: "info",
	    		                            success: function (result) {
	    		                       			return;
	    		                        	}
	    								});
	    							}
	    				    	}
	    					}).fail( function(jqXHR) {
	    						/* Un load block UI */
	    				        jQuery.unblockUI();
	    				    });
	    		        } else if(importConfirmation == "No" || importConfirmation == "Cancel") {
	    					return false;
	    				}
	    		    }
	    		});
    		}
        }
    });
    
    $("#edit_manual_link").click(function (){
    	loadProgressBar();
    	var gemPublishId = jQuery("#gemPublishId").val();
    	var bridgePublishId = jQuery("#bridgePublishId").val();
    	$.ajax({
    	  	url : updateManualTypeURL,
    	  	data: {"gemPublishId":gemPublishId,"bridgePublishId":bridgePublishId},
    	  	type: "POST",
    	  	dataType: "text",
    	  	success: function(data) {
    	    	if (data != null && data != '' && typeof data != 'undefined') {
    	    		$('#createPublicationModal').html(data);
    	    		$('#createPublicationModal').dialog("open");
    	    	}
    	    	jQuery.unblockUI();
    		}
    	});
    });
});

function loadProgressBar () {
	jQuery.blockUI({ message: '<h3><img src="/BSTheme-theme/images/busy.gif" /> </h3>' });
}

function openGEMReportDialog(templateId, reportType) {
	$('#reportType').val(reportType);
	$('#templateId').val(templateId);
    $('#reportTitle').val('');
    $("#createReportDialog").dialog("open");
}

function openCreatePublicationDialog() {
	loadProgressBar();
	jQuery.ajax({
		type: "POST",
		url: openCreatePublicationModel,
		dataType: "text",
		success: function(data) {
	    	if (data != null && data != '' && typeof data != 'undefined') {
	    		$('#createPublicationModal').html(data);
	    		$('#createPublicationModal').dialog("open");
	    	}
	    	jQuery.unblockUI();
		}
	});
}

function generateGEMReport(generateGEMReportURL) {
	var reportType = jQuery("#reportType").val();
	var templateId = jQuery("#templateId").val();
	var reportTitle = jQuery("#reportTitle").val();
	loadProgressBar();
	jQuery.ajax({
		type: "POST",
	  	dataType: "text",
	    url: generateGEMReportURL,
	  	data: {"templateId":templateId, "reportType":reportType, "reportTitle":reportTitle}
	}).done( function(data) {
		jQuery.unblockUI();
		if (data != null && data != '' && typeof data != 'undefined') {
			if(reportType == 'SA') {
				$('#generateSAReport').attr('disabled', 'disabled');
			} else if(reportType == 'SE') {
				$('#generateSEReport').attr('disabled', 'disabled');
			} else if(reportType == 'WR') {
				$('#generateWRReport').attr('disabled', 'disabled');
			} else if(reportType == 'Policy') {
				$('#generatePlocyReport').attr('disabled', 'disabled');
			}
			if(data == 'Failure') {
				jQuery.msgBox({
			        title: "Error!",
			        content: "Failed to process your request!",
			        type: "error",
			        success: function (result) { }
			    });
			} else if(data == 'Groups_Inprogress') {
				jQuery.msgBox({
			        title: "Error!",
			        content: (reportType == 'SE' ? "SE" : "SA") + " Unique Groups generation is In Progress. Please try after some time to request report!",
			        type: "error",
			        success: function (result) { }
			    });
			} else if(data == 'Exist') {
				jQuery.msgBox({
			        title: "Error!",
			        content: "A request with the same metadata already raised and it is in process queue. Try after some time to re-submit!",
			        type: "error",
			        success: function (result) { }
			    });
			} else if(data == 'Success') {
				$("#createReportDialog").dialog("close");
				jQuery.msgBox({
		            title: "Success!",
		            content: "An email with a link to your Report will be sent to you once the Report has been generated.", 
		            type: "info",
		            buttons: [{ value: "OK" }],
		            success: function (result) { }
		        });
			}
		}
	}).fail( function(jqXHR) {
		jQuery.unblockUI();
	    jQuery.msgBox({
	        title: "Error!",
	        content: "Failed submit request! Failure status:" + jqXHR.statusText + " status code:" + jqXHR.status,
	        type: "error",
	        success: function (result) { }
	    });
	});
}
