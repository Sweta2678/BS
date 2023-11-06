function trimUrl(url, trimSeq)
{
    var theUrl = url;
    var indx = url.indexOf(trimSeq);
    if (indx > 0)
    {
        theUrl = url.substr(0, indx);
    }
    return theUrl;
};

function updateUsers(url, currUsr, newUsr, stdIds, reqName)
{
    jQuery.blockUI({ message: '<h3><img src="/BSTheme-theme/images/busy.gif" /> Please wait...</h3>' });
    if (currUsr && newUsr || (stdIds && newUsr))
    {
        if (currUsr === newUsr)
        {
            jQuery.msgBox({
                title: "Error!",
                content: "Current and New " + reqName + " should be different!",
                type: "error",
                success: function (result) {
                    jQuery.unblockUI();
                }
            });
        }
        else
        {
            var postData = {currUser:currUsr,newUser:newUsr,stdIds:stdIds};
			var stdIdFlag = false;
			if(stdIds.length > 0 ) 
			{
				stdIdFlag = true;
			}
            runUpdate(url, postData, reqName, false, stdIdFlag);
        }
    }
    else 
    {
        jQuery.msgBox({
            title: "Info!",
            content: "Please select " + reqName,
            type: "info",
            success: function (result) {
                jQuery.unblockUI();
            }
        });
    }
};

function runUpdate(url, postData, reqName, isRemove, stdIdFlag)
{
	var successMsg = "";
	if (stdIdFlag)
	{
	    var noteMsg = "Note - If the standard id is not attributed to the login user's region, no change will be made."; 
		successMsg = isRemove ? reqName + " was removed successfully. </br> " +noteMsg : reqName + " was updated successfully. </br> " +noteMsg;
    }
	else
	{
		successMsg = isRemove ? reqName + " was removed successfully." : reqName + " was updated successfully.";
	}
	var errMsg = isRemove ? "Failed to remove " + reqName + "! Failure status:" : "Failed to update " + reqName + "! Failure status:";
    
    jQuery.ajax({
        type: "POST",
        url: url,
        data: postData
    }).done( function(data) {
        jQuery.unblockUI();
		if (typeof data != 'undefined' && data != null) 
		{
			jQuery.msgBox({
				title: "Success!",
				content: successMsg, 
				type: "info",
				success: function (result) {
					clearSelection(url);
				}
			});
		} 
		
    }).fail( function(jqXHR) {
        jQuery.unblockUI();
        /*alert("AJAX request failed with status:" + jqXHR.statusText + " status code:" + jqXHR.status);*/
        jQuery.msgBox({
            title: "Error!",
            content: errMsg + jqXHR.statusText + " status code:" + jqXHR.status ,
            type: "error",
            success: function (result) {
                ;
            }
        });
    });
};

function clearSelection(url)
{
	var updAuth = url.indexOf("updatePrimaryAuthor");
	if (updAuth > 0)
	{
		jQuery("select#selectPrimaryAuthor").find("option").prop("selected", false);
		jQuery("select#selectNewPrimaryAuthor").find("option").prop("selected", false);
		jQuery('#selectPrimaryAuthor').prop("disabled", false);
		jQuery("#stdIdsPrimaryAuthor").val("");
		jQuery("#primAuthorUpdate").button("option", "disabled", true).addClass('ui-state-disabled');
	}
					var updaOtherAuth = url.indexOf("updateOtherAuthor");
					var del = url.indexOf("deleteOtherAuthor");
					if (updaOtherAuth > 0 || del > 0)
					{
						jQuery("select#selectOtherAuthor").find("option").prop("selected", false);
						jQuery("select#selectNewOtherAuthor").find("option").prop("selected", false);
						jQuery('#selectOtherAuthor').prop("disabled", false);
						jQuery("#stdIdsOtherAuthor").val("");
						jQuery("#otherAuthorUpdate").button("option", "disabled", true).addClass('ui-state-disabled');
						jQuery("#otherAuthorRemove").button("option", "disabled", true).addClass('ui-state-disabled');
					}
					var updOwner = url.indexOf("updateOwner");
					if (updOwner > 0)
					{
						jQuery("select#selectOwner").find("option").prop("selected", false);
						jQuery("select#selectNewOwner").find("option").prop("selected", false);
						jQuery('#selectOwner').prop("disabled", false);
						jQuery("#stdIdsOwner").val("");
						jQuery("#ownerUpdate").button("option", "disabled", true).addClass('ui-state-disabled');
					}
}
function toglePrimAuthorButton()
{
    var user = jQuery("select#selectPrimaryAuthor :selected").val();
    var newUser = jQuery("select#selectNewPrimaryAuthor :selected").val();
	var primaryStdIds = jQuery('#stdIdsPrimaryAuthor').val().trim();
	
    if (user && newUser || (primaryStdIds && newUser))
    {
        if (user === newUser)
        {
            jQuery.msgBox({
                title: "Error!",
                content: "Current and New Author should be different!",
                type: "error",
                success: function (result) {
                    jQuery("#primAuthorUpdate").button("option", "disabled", true).addClass('ui-state-disabled');
                    jQuery.unblockUI();
                }
            });
        }
        else
        {
            jQuery("#primAuthorUpdate").button("option", "disabled", false).removeClass('ui-state-disabled');
        }
    }
    else
    {
        jQuery("#primAuthorUpdate").button("option", "disabled", true).addClass('ui-state-disabled');
    }
};

function togleOtherAuthorButton()
{
    var user = jQuery("select#selectOtherAuthor :selected").val();
    var newUser = jQuery("select#selectNewOtherAuthor :selected").val();
    var otherAuthorStdIds = jQuery('#stdIdsOtherAuthor').val().trim();
	
    if ((user && otherAuthorStdIds) || user)
    {
        jQuery("#otherAuthorRemove").button("option", "disabled", false).removeClass('ui-state-disabled');
    }
    else
    {
        jQuery("#otherAuthorRemove").button("option", "disabled", true).addClass('ui-state-disabled');
    }
    
    if ( (user && newUser) ||  (newUser && otherAuthorStdIds) ) 
    {
        if (user === newUser)
        {
            jQuery.msgBox({
                title: "Error!",
                content: "Current and New Author should be different!",
                type: "error",
                success: function (result) {
                    jQuery("#otherAuthorUpdate").button("option", "disabled", true).addClass('ui-state-disabled');
                    jQuery("#otherAuthorRemove").button("option", "disabled", true).addClass('ui-state-disabled');
                    jQuery.unblockUI();
                }
            });
        }
        else
        {
            jQuery("#otherAuthorUpdate").button("option", "disabled", false).removeClass('ui-state-disabled');
            jQuery("#otherAuthorRemove").button("option", "disabled", true).addClass('ui-state-disabled');
        }
    }
    else
    {
        jQuery("#otherAuthorUpdate").button("option", "disabled", true).addClass('ui-state-disabled');
    }
};

function togleOwnerButton()
{
    var user = jQuery("select#selectOwner :selected").val();
    var newUser = jQuery("select#selectNewOwner :selected").val();
	var busOwnerStdIds = jQuery('#stdIdsOwner').val().trim();
	
    if (user && newUser || (busOwnerStdIds && newUser))
    {
        if (user === newUser)
        {
            jQuery.msgBox({
                title: "Error!",
                content: "Current and New Owner should be different!",
                type: "error",
                success: function (result) {
                    jQuery("#ownerUpdate").button("option", "disabled", true).addClass('ui-state-disabled');
                    jQuery.unblockUI();
                }
            });
        }
        else
        {
            jQuery("#ownerUpdate").button("option", "disabled", false).removeClass('ui-state-disabled');
        }
    }
    else
    {
        jQuery("#ownerUpdate").button("option", "disabled", true).addClass('ui-state-disabled');
    }
};



jQuery(function() {

    /****   Disable all buttons   ****/
    jQuery("#primAuthorUpdate").button();
    jQuery("#primAuthorUpdate").button("option", "disabled", true).addClass('ui-state-disabled');

    jQuery("#otherAuthorUpdate").button();
    jQuery("#otherAuthorUpdate").button("option", "disabled", true).addClass('ui-state-disabled');

    jQuery("#otherAuthorRemove").button();
    jQuery("#otherAuthorRemove").button("option", "disabled", true).addClass('ui-state-disabled');

    jQuery("#ownerUpdate").button();
    jQuery("#ownerUpdate").button("option", "disabled", true).addClass('ui-state-disabled');

	jQuery("#brandStatusUpdate").button();
    jQuery("#brandStatusUpdate").button("option", "disabled", true).addClass('ui-state-disabled');

	
    /****   Update Primary Author   ****/
    jQuery("#primAuthorUpdate").click(function(){
        var currAuth = jQuery("select#selectPrimaryAuthor :selected").val();
        var newAuth = jQuery("select#selectNewPrimaryAuthor :selected").val();
		var stdIds = jQuery("#stdIdsPrimaryAuthor").val();
        var url = jQuery("#updPrimAuthor").val();
        updateUsers(url, currAuth, newAuth, stdIds, "Primary Author");
        return false;
    });

    /****   Update Other Author   ****/
    jQuery("#otherAuthorUpdate").click(function(){
        var currAuth = jQuery("select#selectOtherAuthor :selected").val();
        var newAuth = jQuery("select#selectNewOtherAuthor :selected").val();
		var stdIds = jQuery("#stdIdsOtherAuthor").val();
        var url = jQuery("#updOtherAuthor").val();
        updateUsers(url, currAuth, newAuth, stdIds, "Author");
        return false;
    });

    /****   Update Owner   ****/
    jQuery("#ownerUpdate").click(function(){
        var currOwner = jQuery("select#selectOwner :selected").val();
        var newOwner = jQuery("select#selectNewOwner :selected").val();
		var stdIds = jQuery("#stdIdsOwner").val();
        var url = jQuery("#updOwner").val();
        updateUsers(url, currOwner, newOwner, stdIds, "Owner");
        return false;
    });

    /****   Remove Other Author   ****/
    jQuery("#otherAuthorRemove").click(function(){
        var currAuth = jQuery("select#selectOtherAuthor :selected").val();
		var stdIds = jQuery("#stdIdsOtherAuthor").val();
        var postData = {currUser:currAuth,stdIds:stdIds};
        var url = jQuery("#rmOtherAuthor").val();
        jQuery.blockUI({ message: '<h3><img src="/BSTheme-theme/images/busy.gif" /> Please wait...</h3>' });
        
        if (currAuth)
		{
			var stdIdFlag = false;
			if(stdIds.length > 0 ) 
			{
				stdIdFlag = true;
			}
            runUpdate(url, postData, "Author", true, stdIdFlag);
        }
        else 
        {
            jQuery.msgBox({
                title: "Info!",
                content: "Please select Author",
                type: "info",
                success: function (result) {
                    jQuery.unblockUI();
                }
            });
        }
        return false;
    });
    
	//If uncheck brand button then disabled update button
	jQuery('input:checkbox[name=standard_brand]').click(function(){
		if(jQuery('input:checkbox[name="standard_brand"]:checked').length == 0)
		{
			jQuery("#brandStatusUpdate").button("option", "disabled", true).addClass('ui-state-disabled');
		}
	});
	
	/****   Update Brand status   ****/
	jQuery("#brandStatusUpdate").click(function(){
		var successMsg = "The brands attributed to the IDs have been updated. </br> Note - if the brand selected is not attributed to the ID, no change will be made.";
		var confirmMsg = "Do you want to continue.";
		var errMsg = "Failed to update brand status.";
		var failedIdMsg = "Failed to update brand status for";
		var failedIdErrMsg = "</br>Potential error causes could include:</br> 1.The standard not un-attributed </br>2.Standard in wrong status </br>3.Incorrect user permissions";
		var failedAttributeErrMsg = "</br>Potential error causes could include:</br> 1.The brand(s) not attributed </br>2.Brand(s) attribution in wrong status </br>3.Incorrect user permissions";
		var failedErrMsg ;
		var sts= null;
		var stdIds = jQuery("#stdIdsBrandStatus").val();
        var url = jQuery("#updBrandStatus").val();
		var selectedBrandArray = [];
		var selectedBrandStatusArray = [];
        jQuery('input:checkbox[name="standard_brand"]:checked').each(function() {
	   		selectedBrandArray.push(jQuery(this).val());
			selectedBrandStatusArray.push(jQuery(this).val()+"-"+jQuery("#standard_status"+ jQuery(this).val()).val());
			 sts = jQuery("#standard_status"+ jQuery(this).val()).val();
     	});
		var selectedBrandsStatus = selectedBrandStatusArray.join("_");
		var postData = {updateStdIds:stdIds,selectedBrandsStatus:selectedBrandsStatus}
		jQuery.blockUI({ message: '<h3><img src="/BSTheme-theme/images/busy.gif" /> Please wait...</h3>' });
		var failedBrandIds =[];
		if(stdIds.length > 0 && selectedBrandArray.length > 0)
		{
			console.log(stdIds);
			console.log(sts);
			if(sts == "UnAttribute" || sts == "Attribute" ){
				
				if(sts == "UnAttribute"){
					failedErrMsg = failedIdErrMsg;
				}else{
					failedErrMsg = failedAttributeErrMsg;
				}
				jQuery.msgBox({
					title: "Confirmation",
					content: confirmMsg, 
					type: "confirm",
					success: function (result) {
						console.log("::result::"+result);
						if(result == "Yes"){
							jQuery.ajax({
								type: "POST",
								url: url,
								dataType: 'json',
								data: postData
							}).done( function(data) {
								jQuery.unblockUI();
								if (typeof data != 'undefined' && data != null) 
								{
									var json = JSON.stringify(data);
									console.log("json::::::::"+json);
									if(json.length > 0){
									var failedList = '[' + json +']';
									var failedListJson = $.parseJSON(failedList);
									
									for (var i = 0; i < failedListJson.length; i++) {
									    console.log(failedListJson[i]['failedBrandListSet']);
									    if(failedListJson[i]['failedBrandListSet'] != null && failedListJson[i]['failedBrandListSet'] != 'undefined'){
									    failedBrandIds.push(failedListJson[i]['failedBrandListSet'].replace("[", " ").replace("]", " "));
									    }
									}
									}
									if(failedBrandIds.length > 0){
										console.log("Failed::::::::");
										for(var i=0;i<=30;i++){}										
										jQuery.msgBox({
											title: "Failed Brand Ids!",
											content: failedIdMsg+failedBrandIds+failedErrMsg, 
											type: "info",
											success: function (result) {
												jQuery.unblockUI();
											}
										});
									}else{
										console.log("Success::::::::");
										for(var i=0;i<=30;i++){}		
										jQuery.msgBox({
											title: "Success!",
											content: successMsg, 
											type: "info",
											success: function (result) {
												jQuery.unblockUI();
											}
										});
									}
									
								}
								var upBrandStatus = url.indexOf("updateBrandStatus");
								if (upBrandStatus > 0)
								{
									jQuery("#stdIdsBrandStatus").val("");
									jQuery("#brandStatusUpdate").button("option", "disabled", true).addClass('ui-state-disabled');
									jQuery.each(selectedBrandArray, function(index, value){
										var brandId = "standard_brand"+value;
										var statusId = "standard_status"+value;
										jQuery('#'+brandId).removeAttr('checked');
										jQuery('#'+statusId).css("display","none");
									});
								}
											
							}).fail( function(jqXHR) {
								jQuery.unblockUI();
								//alert("AJAX request failed with status:" + jqXHR.statusText + " status code:" + jqXHR.status);
								jQuery.msgBox({
									title: "Error!",
									content: errMsg + jqXHR.statusText + " status code:" + jqXHR.status ,
									type: "error",
									success: function (result) {
										;
									}
								});
							});
						}else{
							jQuery.unblockUI();
						}
					}
				});
			}else{
				console.log("Success:::else:::::");
				jQuery.ajax({
					type: "POST",
					url: url,
					data: postData
				}).done( function(data) {
					jQuery.unblockUI();
					
					if (typeof data != 'undefined' && data != null) 
					{
						jQuery.msgBox({
							title: "Success!",
							content: successMsg, 
							type: "info",
							success: function (result) {
							}
						});
					}
					var upBrandStatus = url.indexOf("updateBrandStatus");
					if (upBrandStatus > 0)
					{
						jQuery("#stdIdsBrandStatus").val("");
						jQuery("#brandStatusUpdate").button("option", "disabled", true).addClass('ui-state-disabled');
						jQuery.each(selectedBrandArray, function(index, value){
							var brandId = "standard_brand"+value;
							var statusId = "standard_status"+value;
							jQuery('#'+brandId).removeAttr('checked');
							jQuery('#'+statusId).css("display","none");
						});
					}
								
				}).fail( function(jqXHR) {
					jQuery.unblockUI();
					//alert("AJAX request failed with status:" + jqXHR.statusText + " status code:" + jqXHR.status);
					jQuery.msgBox({
						title: "Error!",
						content: errMsg + jqXHR.statusText + " status code:" + jqXHR.status ,
						type: "error",
						success: function (result) {
							;
						}
					});
				});
			}
			}
			
	});
    /****   Enable/Disable buttons based on selection ****/
    
  /* jQuery("select#selectPrimaryAuthor").change(function(){
        toglePrimAuthorButton();
    }); */

    jQuery("select#selectNewPrimaryAuthor").change(function(){
        toglePrimAuthorButton();
	});

   jQuery("select#selectOtherAuthor").change(function(){
        togleOtherAuthorButton();
    }); 

    jQuery("select#selectNewOtherAuthor").change(function(){
        togleOtherAuthorButton();
    });
    
   /* jQuery("select#selectOwner").change(function(){
        togleOwnerButton();
    }); */

    jQuery("select#selectNewOwner").change(function(){
        togleOwnerButton();
    });
	
	jQuery(".stdIdsText").bind('paste', function () {
	 
        var element = this;
        setTimeout(function () {
            var newVal = jQuery(element).val().replace(/[^0-9, ]+/g, '').trim();
            newVal = newVal.replace(/\s{2,}/g, ' ').trim();
            jQuery(element).val(newVal);
        }, 200);
    });

	
    jQuery(".stdIdsText").keydown(function(event) {
        // Allow: escape, backspace, delete, tab, comma
		if ( event.keyCode == 27 || event.keyCode == 46 || event.keyCode == 8 || event.keyCode == 9 || event.keyCode == 188 ||
			// Allowspace,            enter,                home, end, left, right 				          Ctrl 
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
	
	jQuery( ".stdIdsText" ).blur(function() {
		
		var stdIdsPrimaryAuthor = jQuery('#stdIdsPrimaryAuthor').val();
		var stdIdsOtherAuthor = jQuery('#stdIdsOtherAuthor').val();
		var stdIdsOwner = jQuery('#stdIdsOwner').val();
		var stdIds = jQuery("#stdIdsBrandStatus").val();
		if(stdIdsPrimaryAuthor.length > 0 ) 
		{
			jQuery('#selectPrimaryAuthor').prop("disabled", true);
		}
		else
		{
			jQuery('#selectPrimaryAuthor').prop("disabled", false);
		}
		if (stdIdsOwner.length > 0) 
		{
			jQuery('#selectOwner').prop("disabled", true);
		}
		else
		{
			jQuery('#selectOwner').prop("disabled", false);
		}
		if(jQuery('input:checkbox[name=standard_brand]').is(':checked'))
		{
			if(stdIds.length > 0 )
			{
				jQuery("#brandStatusUpdate").button("option", "disabled", false).removeClass('ui-state-disabled');
			}
			else
			{
				jQuery("#brandStatusUpdate").button("option", "disabled", true).addClass('ui-state-disabled');
			}
		}		
	});
	
});

function showStatusByBrand(val,standStatus)
{
	var stdIds = jQuery("#stdIdsBrandStatus").val();
	if(jQuery('input:checkbox[id=standard_brand'+val+']').is(':checked'))
	{
		jQuery('#'+val).css({color:'black'});
		jQuery('#standard_status'+val).css("display","block");
		
		if(standStatus == "")
		{
			jQuery('#'+val).text("Initial Load of Existing Content");
		}
		
		if(stdIds.length > 0 )
		{
			jQuery("#brandStatusUpdate").button("option", "disabled", false).removeClass('ui-state-disabled');
		}
   }
   else
   {
		jQuery('#'+val).css({color:'gray'});
		jQuery('#standard_status'+val).css("display","none");
		if(standStatus == "")
		{
			jQuery('#'+val).text("");
		}
		if(stdIds.length > 0 )
		{
			jQuery("#brandStatusUpdate").button("option", "disabled", false).removeClass('ui-state-disabled');
		}else
		{
			jQuery("#brandStatusUpdate").button("option", "disabled", true).addClass('ui-state-disabled');
		}
   }
}

