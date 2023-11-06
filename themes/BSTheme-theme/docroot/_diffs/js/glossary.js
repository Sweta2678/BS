
/* pre-submit callback */ 
function showRequest(formData, jqForm, options)
{
    if (validateStdForm())
    {
        jQuery.blockUI({ message: '<h3><img src="/BSTheme-theme/images/busy.gif" /> Please wait...</h3>' });
        return true;
    }
    return false;
};

/* post-submit callback */ 
function showResponse(responseText, statusText, xhr, $form)  
{ 
    submitted = false;
    jQuery.unblockUI();
    /*alert("responseText=" + responseText + "\n statusText=" + statusText);*/
    if(responseText.indexOf("ERROR:") === 0)
    {
        jQuery.msgBox({
            title: "Error!",
            content: "Validation failed for specified IDs in the file!" ,
            type: "error",
            success: function (result) {
                jQuery("#initial_data_div").hide();
                jQuery("#confirm_data_div").hide();
                jQuery("#displ_error").text(responseText.substring(6));
                jQuery("#errorm_data_div").show();
            }
        });
    }
    else
    {
        jQuery.msgBox({
            title: "Success!",
            content: "Validation of request is successful", /*responseText ,*/
            type: "info",
            success: function (result) {
                jQuery("#displ_environment").text("Staging");
                jQuery("#displ_date").text(jQuery('input:radio[name="pub_schedule"]:checked').val());
                jQuery("#displ_schedule_date").text(jQuery("#dateInput").val());
                jQuery("#displ_schedule_time").text(jQuery("#timeInput").val());
                jQuery("#displ_brand").text(jQuery("select#selectBrand :selected").text());
                jQuery("#displ_email").text(jQuery("#emailField").val());
                
                if(responseText && responseText.length > 80)
                {
                    jQuery(".displ_more_ids").show();
                    jQuery("#displ_id_less").text(responseText.substring(0, 80) + "... ");
                }
                else
                {
                    jQuery(".displ_more_ids").hide();
                    jQuery("#displ_id_less").text(responseText);
                }
                jQuery("#displ_id_more").text(responseText);
                jQuery("#initial_data_div").hide();
                jQuery("#confirm_data_div").show();
            }
        });
    }
};

jQuery.validator.addMethod("multiemail", function(value, element) {
        if (this.optional(element)) /* return true on optional element*/ 
            return true;
        var emails = value.split(/[;,]+/); /* split element by , and ;*/
        valid = true;
        for (var i in emails) 
        {
            value = emails[i];
            valid = valid && jQuery.validator.methods.email.call(this, $.trim(value), element);
        }
        return valid;
    },
    jQuery.validator.messages.email
);

function validateStdForm()
{	
	if (validator)
	{
		return validator.form();
	}
	else
	{
		validator = getFormValidator();
		return validator.form();
	}
};

function getFormValidator()
{
    var valdtr = jQuery("#publishAdminForm").validate({
        rules: {
            required: true,

            uploadFile: {
                required: true,
                extension: "xls|txt"
            },

            environment: {
                required: true
            },
            
            emailField: {
                required: true,
                multiemail: true
            }
            
        },
        messages: {
            emailField: 'Invalid email address'
        },
        errorPlacement: function(error, element) {
            if (element.attr("id") == "environment_stage" || element.attr("id") == "environment_prod")
            {
                error.insertAfter("#env_err_span"); 
            }
            else if (element.attr("name") == "dateInput")
            {
                error.insertAfter(".ui-datepicker-trigger");
            }
            else if (element.attr("name") == "timeInput")
            {
                error.insertAfter(".ui-timepicker-trigger"); 
            }
            else
            {
                error.insertAfter(element);
            }
        }
    });
    return valdtr;
};

jQuery(function() {
    jQuery(".nyroModal").nyroModal({closeOnClick: false});

    jQuery("#gloss_btn_add").click(function(){
        jQuery("#add_new_term").click();
        jQuery('.modal_title_text').html("Add New Term");
    });

    jQuery("#gloss_btn_edit").click(function(){
        alert("click on edit");
    });

    jQuery(".glossary_cancel_a").click(function(){
    
        jQuery(".nyroModalClose").click();
    });
    
    jQuery(".glossary_cancel_a").click(function(){
        jQuery(".nyroModalClose").click();
    });
});


