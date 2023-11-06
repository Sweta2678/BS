
jQuery(function() {
	
		jQuery.unblockUI();
		
		if (requestProcessed != null && requestProcessed == 'true') {
			jQuery.msgBox({
                title:"Success",
                content:"Your request processed successfully",
                type:"info"
            });
		} else if (wrongExcelsheet  != null && wrongExcelsheet  == 'true') {
			jQuery.msgBox({
                title:"Error",
                content:"Provided excelsheet is wrong. Please do export again to get right excelsheet",
                type:"error"
            });
		} else if (deleteError != null && deleteError != "") {
			jQuery.msgBox({
                title:"Error",
                content:deleteError,
                type:"error"
            });
		} else if (approveError != null && approveError != "") {
			jQuery.msgBox({
                title:"Error",
                content:approveError,
                type:"error"
            });
		} else if (rejectError != null && rejectError != "") {
			jQuery.msgBox({
                title:"Error",
                content:rejectError,
                type:"error"
            });
		} else if (processError != null && processError != "") {
			jQuery.msgBox({
                title:"Error",
                content:processError,
                type:"error"
            });
		} else if (standardNotExistMsg != null && standardNotExistMsg != "") {
			jQuery.msgBox({
                title:"Error",
                content:standardNotExistMsg,
                type:"error"
            });
		} else if (requestProcessed != null && requestProcessed == 'false') {
			jQuery.msgBox({
                title:"Error",
                content:"Please check your email for error details",
                type:"error"
            });
		} else if (noAccessMsg != null && noAccessMsg != '') {
			jQuery.msgBox({
                title:"Error",
                content:noAccessMsg,
                type:"error"
            });
		} else if (inProgressMsg != null && inProgressMsg != '') {
			jQuery.msgBox({
                title:"In Progress",
                content:inProgressMsg,
                type:"info"
            });
		} else if (largeRequest != null && largeRequest != '') {
			jQuery.msgBox({
                title:"In Progress",
                content:largeRequest,
                type:"info"
            });
		}
		
	});
	/**
	 * 
	 * @param url
	 */
	function downloadURL(url) {
	    $('<iframe>', { id:'idown', src:url }).hide().appendTo('body');
	}

	function loadProgressBar () {
		//jQuery.unblockUI();
		jQuery.blockUI({ message: '<h3><img src="/BSTheme-theme/images/busy.gif" /> </h3>' });
	}
	
	function exportAttributeData () {
		var stdIdVal = jQuery("textarea#stdIds").val();
		var standard_brand = jQuery("#standard_brand").val();
		var standard_region = jQuery("#standard_region").val();
		var isClosed = false;
		var resultMessage = '';
		if (stdIdVal != null && typeof stdIdVal != 'undefined' && stdIdVal != '') {
			jQuery.msgBox({
			    title: "Are You Sure",
			    content: "You want to do an export?",
			    type: "confirm",
			    buttons: [{ value: "Yes" }, { value: "No" }],
				autoClose: false,
				success: function (result) {
			       if (result == "Yes") {
			    	   loadProgressBar();
					$.ajax({
				  		url :exportURL,
				  		data:{"stdIds":stdIdVal,"standard_brand":standard_brand,"standard_region":standard_region},
				  		type: "POST",
				  		success: function(data) {
							
				  			if (typeof data != 'undefined' && data != null && data != '' &&  data == reportInProgress) {
								jQuery.unblockUI();
								isClosed = true;
								resultMessage = data;
							} else {			  							  			
								location.href = exportReport;
								setTimeout($.unblockUI, 5000); 
							}
				  		}, error: function (e) {
				    		jQuery.unblockUI();
				    		jQuery.msgBox({
			                    title:"Error!",
			                    content:"Error occurred",
			                    type:"error"
			                });
				    		console.log(e);
						}
			 		});
			       } else if (result == "No") {
						jQuery("textarea#stdIds").val("");
						jQuery("#standard_brand").val("");
						jQuery("#standard_region").val("");
				   }
			    }, afterClose: function () {
						console.log(isClosed);
						jQuery.unblockUI();
						if (isClosed == true) {
							jQuery.msgBox({
			                    title:"In Progress",
			                    content:resultMessage,
			                    type:"info",
								autoClose: false
								});
							}
						}
			});
			
		} else {
			jQuery.msgBox({
                title:"Error!",
                content:"Please provide standard Ids",
                type:"error"
            });
		}
		
		
	}
	
	

	function approveRequest (url, message) {
		jQuery.msgBox({
		    title: "Are You Sure",
		    content: message,
		    type: "confirm",
		    buttons: [{ value: "Yes" }, { value: "No" }],
		    success: function (result) {
		       if (result == "Yes") {
		    	loadProgressBar();      
				location.href = url;
		       } if(result == "No" || result == "Cancel") {
			          return false;
			  }
		    }
		});
	}
	
	$('.create_new_att_link').click(function(){
		$( "#create_new_attribute" ).dialog({
		resizable: false,
		modal: true,
		width: 900
		});
	});
	
	$('.edit_link').click(function(){

	
	    var editRequest = 'request_'+this.id;
		var requestValue = 'id_'+this.id;
		$('#standard_name').val($('#'+editRequest).val());
		$('#attr_id').val($('#'+requestValue).val());
		$( "#attribute_edit" ).dialog({
	      resizable: false,
	      modal: true,
		  width: 900
	    });
	});
	
	$('.export_attribute_link').click(function(){
		jQuery("textarea#stdIds").val("");
		jQuery("#standard_brand").val("");
		jQuery("#standard_region").val("");
    $( "#export_attribute" ).dialog({
      resizable: false,
      modal: true,
	  width: 600,
      buttons: {
        "Submit": function() {
          exportAttributeData();
		  $( this ).dialog( "close" );
        },
        Cancel: function() {
		  jQuery("textarea#stdIds").val("");
		  jQuery("#standard_brand").val("");
		  jQuery("#standard_region").val("");
          $( this ).dialog( "close" );
        }
      }
    });
	});
	
	function createDiffReport (diffURL, message) {
		//location.href = diffURL;
		jQuery.msgBox({
			    title: "Are You Sure",
			    content: "You want to create a diff report?",
			    type: "confirm",
			    buttons: [{ value: "Yes" }, { value: "No" }],
			    success: function (result) {
			       if (result == "Yes") {
			    	loadProgressBar();   
					location.href = diffURL;
					setTimeout($.unblockUI, 5000);
					} if(result == "No" || result == "Cancel") {
				          return false;
					}
				}
			});
		
	}
	$("#importAttr").validate({
		 
		rules: {
					// Targeting form fields
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
	       // Submit the form when validation passes
	    	loadProgressBar();
	    	form.submit();
	    }	 
				
	});
	$("#updateAttribute").validate({
		 
		rules: {
					// Targeting form fields
			standard_file: {
					  required: false,
					 extension: "xls|xlsx|xlsm"
				   } 
	             },
	        messages: {
	        standard_file: {
	                extension: 'Only xls or xlsx or xlsm files are allowed',
	            }
	        },
	    submitHandler: function(form) {
	       // Submit the form when validation passes
	    	loadProgressBar();
	    	form.submit();
	    }	 
				
	});

	$('.att_cancel').click(function(){
		$("#create_new_attribute").dialog( "close" );
		$("#attribute_edit").dialog( "close" );
	});
	
	jQuery("#stdIds").keydown(function(event) {
        // Allow: escape, backspace, delete, tab, 
        if ( event.keyCode == 27 || event.keyCode == 46 || event.keyCode == 8 || event.keyCode == 9 || 
             // Allow: space,           enter,                        home, end, left, right                  Ctrl
             event.keyCode == 32 || event.keyCode == 13 || (event.keyCode >= 35 && event.keyCode <= 40) || event.ctrlKey )
        {
            return;
        }
        else 
        {
            // Ensure that it is a number and stop the keypress
            if (event.shiftKey || (event.keyCode < 48 || event.keyCode > 57) && (event.keyCode < 96 || event.keyCode > 105 )) 
            {
                event.preventDefault(); 
            }   
        }
    });
	
	jQuery.validator.setDefaults({
		debug: true,
		success: "valid"
	});
	