var goto_url = "/web/brand-standards/glossary?visibleChar=activeChar";
function submitGlossary() {
	var termTxt =  jQuery.trim(jQuery("#term_name").val());
	var termDef =  jQuery.trim(jQuery("#term_definition").val());
	if(termTxt=='')
	{
		jQuery.msgBox({
				   title:"Error!",
				   content:"Please enter Term Name",
				   type:"error"
	});
	return false;
	
	}
	if(termDef=='')
	{
		jQuery.msgBox({
				   title:"Error!",
				   content:"Please enter Term Definition",
				   type:"error"
		});
		
	return false;
	}
	if(!validateBrands()){
		return false;
	}
	
	var options = { 
		   url:           jQuery("#glossaryForm").attr('action'),         /* override for form's 'action' attribute*/  
		   beforeSubmit:  showRequest,  /* pre-submit callback*/ 
		   success:       showResponse, /* post-submit callback*/ 
		   type:      'post',       
		   dataType:  'html'        /* 'xml', 'script', or 'json' (expected server response type)*/ 
	};
	
	jQuery("#glossaryForm").ajaxSubmit(options); 		
	
	return false; 
}
 
function showRequest(formData, jqForm, options)
{
   
jQuery.blockUI({ message: '<h3><img src="/BSTheme-theme/images/busy.gif" /> Please wait...</h3>' });
return true;
}
 
function showResponse(responseText, statusText, xhr, $form)  
{ 
   jQuery.unblockUI();
   /*alert("responseText=" + responseText + "\n statusText=" + statusText +" sucess message "+ successMessage);*/
   
   if(responseText == successMessage)
   {
	       jQuery.msgBox({
               title: "Success!",
               content: responseText ,
               type:"info",
			   buttons: [{ value: "Ok" }],
			   success: function (result) {
							if (result == "Ok") {
								/*refreshTranslations();*/
								var visibleChar = jQuery("#visibleChar").val();
								window.location.href = goto_url.replace("activeChar",visibleChar);
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

function validateBrands()
{ 
	
	valid = false;
			jQuery('#regionBrand').children('#regionLbl').each(function(){
					var brandcode = jQuery(this).children('select').attr("id");
					brand = jQuery("select#"+brandcode+"").multiselect("getChecked").map(function(){
								return this.value;
							}).get().toString();
					if(brand!='')
					{
					   valid = true;
					}
				
			});				
	if (!valid)
	{
	    jQuery.msgBox({
		title: "Error!",
		content: "At least one brand must be assigned to at least one region.",
		type: "error"
		});
	}
	return valid;
};

function onCancel()
{
	var visibleChar = jQuery("#visibleChar").val();
	var temp = goto_url.replace("activeChar",visibleChar);
	window.location.href = goto_url.replace("activeChar",visibleChar);
}