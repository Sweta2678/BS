function submitTranslation(languageId) {
		
		var title =  jQuery.trim(jQuery("#" + languageId + "Term").val());
		var context =  jQuery.trim(jQuery("#" + languageId + "Definition").val());
		jQuery('#locale').val(languageId);
		if(title=='')
	    {
			jQuery.msgBox({
	            title:"Error!",
	            content:"Please enter Term Translation",
	            type:"error"
	        });
			return false;
		}
		if(context=='')
	    {
			jQuery.msgBox({
	            title:"Error!",
	            content:"Please enter Term Definition",
	            type:"error"
	        });
			return false;
		}
		var options = { 
		        url:           jQuery("#transForm").attr('action'),         /* override for form's 'action' attribute*/  
		        beforeSubmit:  showRequest,  /* pre-submit callback*/ 
		        success:       showResponse, /* post-submit callback*/ 
		        type:      'post',       
		        dataType:  'html'        /* 'xml', 'script', or 'json' (expected server response type)*/ 
		}; 
		jQuery('#transForm').submit(function() { 
			/* submit the form*/ 
			jQuery(this).ajaxSubmit(options); 
			/* return false to prevent normal browser submit and page navigation*/ 
			return false; 
		});
		jQuery('#transForm').submit();
	}
	
	function showRequest(formData, jqForm, options)
	{
	    
		jQuery.blockUI({ message: '<h3><img src="/BSTheme-theme/images/busy.gif" /> Please wait...</h3>' });
		return true;
	}
	
	function showResponse(responseText, statusText, xhr, $form)  
	{ 
	    jQuery.unblockUI();
	    /*alert("responseText=" + responseText + "\n statusText=" + statusText);*/
	    
	    if(responseText == successMessage)
	    {
				
	            jQuery.msgBox({
	                title: "Success!",
	                content: responseText ,
	                type:"info",
			        buttons: [{ value: "Ok" }],
					success: function (result) {
			            	 if (result == "Ok") {
									refreshTranslations();
								}
							}
	            });
	            
	    }
	    else
	    {
	        jQuery.msgBox({
	            title:"Error!",
	            content:responseText,
	            type:"error"
	        });
	        return false;
	    }
	};
	
	var transmodified = false;
	var imageMinusLocation = "/BSTheme-theme/images/minus_color.png";
	var imagePlusLocation = "/BSTheme-theme/images/plus_color.png";

	/* ///////////////////////////////////// static html js //////////////////////////////////////////////// */
	jQuery(function() {
		
		/* bind ajax refresh */
		jQuery('.refresh_translation,.tr_cancel').click(function(){
			refreshTranslations();
			return false;
		});
		
		/* expand/contract the translation table */

		jQuery(".edit_translation").click(function() {
			var transFields = jQuery(this);
			if(transmodified)
			{
					jQuery.msgBox({
			            title:"Attention",
			            content:"You may lose the changes of current translation, are you sure you want to close the current accordion?" ,
			            type:"confirm",
			            buttons: [{ value: "Yes" }, { value: "No" }],
			            success: function (result) {
			            	 if (result == "Yes") {
			            		openCloseRow(transFields)
								transmodified = false;
							 }
							 else {
								return false;
							 }
						}
					});
			}
			else
			{
				openCloseRow(transFields);
			}
			return false;
		});

		jQuery('.trans_text').change(function()
		{
			transmodified = true;
		});
		
	});

	jQuery("#transForm").validate({
		rules: {
			field: {
				required: true
			}
		}
	});	

	function refreshTranslations() {
		location.reload();
	}
	function openCloseRow(transFields)
	{	
		if (!jQuery(transFields).hasClass("trans_open")) {
			jQuery('.trans_open').each(function()
			{				
				jQuery(this).parent().parent().next(".table_hidden_row").hide();
				jQuery(this).children("img").attr("src", imagePlusLocation);
				jQuery(this).removeClass("trans_open");
			});
		}
		jQuery(transFields).toggleClass("trans_open");
		/* if to open, else to close*/	
		if (jQuery(transFields).hasClass("trans_open")) {
			jQuery(transFields).parent().parent().next(".table_hidden_row").show();
			jQuery(transFields).children("img").attr("src", imageMinusLocation);
		} else {
			jQuery(transFields).parent().parent().next(".table_hidden_row").hide();
			jQuery(transFields).children("img").attr("src", imagePlusLocation);
		}
	}