jQuery(function(){
	
    jQuery("#byId").bind('paste', function () {
        var element = this;
        setTimeout(function () {
            var newVal = jQuery(element).val().replace(/[^0-9 ]+/g, '').trim();
            newVal = newVal.replace(/\s{2,}/g, ' ').trim();
            jQuery(element).val(newVal);
            showFilterCount();
        }, 200);
    });

    jQuery("#byId").keydown(function(event) {
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
    highlightText();
    
    stdReferenceDialog = $( "#stdReferenceDialog_popup" ).dialog({
		title:"Reference",
		autoOpen: false,
		center:true,
		resizable:false,
		width: 717,
		 modal: true
	});
    
    imagesDialog = $( "#mandatoryImages_popup" ).dialog({
		title:"Details",
		autoOpen: false,
		center:true,
		resizable:false,
		width: 717,
		modal: true
	});
    
    attchDialog = $( "#supportingMaterial_popup" ).dialog({
		title:"Supporting Material",
		autoOpen: false,
		center:true,
		resizable:false,
		width: 717,
		 modal: true,
		open: function() {
	        $('.SupportingMatModalClose').bind('click', function() {
	            $('#supportingMaterial_popup').dialog('close');
	        })
	    }	
	});
    
    setLevelIdDialog = $( "#updateLevelId_popup" ).dialog({
		title:"Countries",
		autoOpen: false,
		center:true,
		resizable:false,
		width: 717,
		 modal: true
	});
    
    $('.dropdown').on({
		"shown.bs.dropdown": function() { this.closable = false; },
		"click":             function() { this.closable = true; },
		"hide.bs.dropdown":  function() { return this.closable; }
	});
   
});


function filterbyId()
{
	//var stateId = jQuery("#byId").val();
	//if(validId(stateId))
	//{
	jQuery('#formbyid').submit();
	//}
}
function clearFilter()
{
	jQuery('#formbyid').attr("action", clearFilterURL);
	jQuery('#formbyid').submit();
}
function validId(stateId)
{
	if(stateId != '')
	{
		return true;
	}
	return false;
}
function highlightText()
{
	if(byIdString!='undefined')
	{
		var txtCriteria = byIdString.split(" ");
		for(var k=0;k < txtCriteria.length;k++)
		{
			$("#standards #s_id").highlight(txtCriteria[k]);
		}
	}
}

function loadAnotherGroup () {
	var groupName = $('#group').find("option:selected").val();
	window.location.href = loadGroupStd+"&groupName="+groupName;
}

function filterbyState()
{
	jQuery('#formbyid').submit();
}



function loadProgressBar () {
	jQuery.blockUI({ message: '<h3><img src="/BSBridge-theme/images/busy.gif" /> </h3>' });
}

function stdReferencePopup(stdId) {
	//load block UI
	loadProgressBar();
	$.ajax({
	  	url :referenceStandards,
	  	data:{"stdId":stdId},
	  	type: "POST",
	  	dataType: "text",
	    success: function(data) {
	    	if (data != null && data != '' && typeof data != 'undefined') {
	    		$('#stdReferenceDialog_popup').html(data);
	    		stdReferenceDialog.dialog( "open" );
	    	}
	    	jQuery.unblockUI();
	    }
	 });
}

function allMandatoryImagesPopup(stdId) {
	//load block UI
	loadProgressBar();
	$.ajax({
	  	url :mandatoryImages,
	  	type: "POST",
	  	data: {'standardID':stdId,'groupName':selectedGroup},
	  	dataType: "text",
	    success: function(data) {
	    	
	    	if (data != null && data != '' && typeof data != 'undefined') {
	    		$('#mandatoryImages_popup').html(data);
	    		imagesDialog.dialog( "open" );
	    	}
	    	jQuery.unblockUI();
	    }
	 });
}

function supportingMaterialPopup(stdId) {
	//load block UI
	loadProgressBar();
	$.ajax({
	  	url :supportingMaterial,
	  	data:{'stdId':stdId,'groupName':selectedGroup},
	  	type: "POST",
	  	dataType: "text",
	    success: function(data) {
	    	if (data != null && data != '' && typeof data != 'undefined') {
	    		$('#supportingMaterial_popup').html(data);
	    		attchDialog.dialog( "open" );
	    	}
	    	jQuery.unblockUI();
	    }
	 });
}
function levelIdPopup(publishId, regionId) {
	//load block UI
	loadProgressBar();
	$.ajax({
	  	url :updateLevelId,
	  	data:{'publishId':publishId,'regionId':regionId},
	  	type: "POST",
	  	dataType: "text",
	    success: function(data) {
	    	if (data != null && data != '' && typeof data != 'undefined') {
	    		$('#updateLevelId_popup').html(data);
	    		setLevelIdDialog.dialog( "open" );
	    	}
	    	jQuery.unblockUI();
	    }
	 });
	}

function generateGroups(groupType) {
	jQuery.ajax({
		url: generateUniqueGroups,
		data:{'groupValue':groupType},
		type: 'POST',
		success: function(data) 
		{ 
			jQuery.msgBox({
                title:"Info!",
                content:data,
                type:"info"
            });
		}
	});
}
