$(function(){
	jQuery( "#regionCountrylist" ).dialog({
			autoOpen: false,
			width: 860,
			modal: true,
			open: function() {
	            jQuery('.ui-widget-overlay').bind('click', function() {
	                jQuery('#regionCountrylist').dialog('close');
	            });
	        }
	});
	
	jQuery( "#confirm-dialog" ).dialog({
		autoOpen: false,
		width: 250,
		modal: true,
		open: function() {
            jQuery('.ui-widget-overlay').bind('click', function() {
                jQuery('#confirm-dialog').dialog('close');
            })
        }
	});
	
	jQuery( "#confirm-dialog-ok" ).click(function() {
		jQuery( "#confirm-dialog" ).dialog( "close" );
	});
	
    jQuery("#byId").bind('paste', function () {
        var element = this;
        setTimeout(function () {
            var newVal = jQuery(element).val().replace(/[^0-9 ]+/g, '').trim();
            newVal = newVal.replace(/\s{2,}/g, ' ').trim();
            jQuery(element).val(newVal);
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
    
    jQuery( "#ImportState" ).dialog({
	    autoOpen: false,
	    width: 360,
	    modal: true,
	    resizable: false,
	    open: function() {
			jQuery('.ui-widget-overlay').bind('click', function() {
				jQuery('#ImportState').dialog('close');
		    });
		}
    });
    
    jQuery( ".pull-left" ).click(function() {
    	jQuery( "#ImportState" ).dialog( "close" );
	});
    
    jQuery('#file').change(function(){
		if (this.value!= "") {
			var ext = this.value.match(/\.([^\.]+)$/)[1];
	        switch(ext)
	        {
	            case 'xls':
	            	document.getElementById("submit").disabled = false;
	                break;
	            case 'xlsm':
	            	document.getElementById("submit").disabled = false;
	            	break;
	            case 'xlsx':
	            	document.getElementById("submit").disabled = false;
	            	break;
	            default:
	            	document.getElementById("submit").disabled = true;
	            	//alert('Only files with following extensions are allowed: xls, xlsm');
	            	alert("Only files with following extensions are allowed: xls, xlsx, xlsm");
	                this.value='';
	        }
			
		} 
	});
    
	highlightText();

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
    
    $("#create-report").click(function() {
        $('#reportTitle').val('');
        $("#createReportDialog").dialog("open");
    });
    
});

function showCountry(publishId, readOnly)
{
	jQuery.ajax({
		url: showCountriesURL,
		data: {
			publishId: publishId,
			crntPg : crntPg,
		    rcPrPg : rcPrPg,
		    readOnly : readOnly
		},
		type: 'POST',
		success: function(data) 
		{ 
			jQuery( "#regionCountrylist" ).dialog( "open" );
			jQuery("#regionCountrylist").html('');
			jQuery("#regionCountrylist").append(data);
		}
  }); 
}

function changeState(publishId)
{
	stCd = jQuery("#"+publishId+"").val();
	jQuery.ajax({
		url: changeStateURL,
		data: {
			publishId: publishId,
			stateCd : stCd
		},
		type: 'POST',
		success: function(data) 
		{ 
			jQuery( "#confirm-dialog" ).dialog( "open" );         
			jQuery("body").css({ overflow: "hidden" }); 
			jQuery("#confirm-dialog-message").html('');
			jQuery("#confirm-dialog-message").append(data);
		}
  });
jQuery('button#confirm-dialog-ok').on('click', function(){
		jQuery("body").css({ overflow: "visible" }); 
	});
}

function filterbyState()
{
	jQuery('#formbystate').submit();
}

function filterbyId()
{
	var stateId = jQuery("#byId").val();
	if(validId(stateId))
	{
		jQuery('#formbystate').submit();
	}
}
function clearFilter()
{
	jQuery('#formbystate').attr("action", clearFilterURL);
	jQuery('#formbystate').submit();
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

function createReport() {
    var reportTitle = jQuery("#reportTitle").val();
    var reportId = jQuery("input[name='reports']:checked", "#createReportForm").val();
    var postData = {reportId:reportId,reportTitle:reportTitle};
    jQuery.blockUI({ message: '<h3><img src="/BSTheme-theme/images/busy.gif" /> Please wait...</h3>' });
    
    jQuery.ajax({
        type: "POST",
        url: excelExportURL,
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

function showImportPopup()
{
       jQuery( "#ImportState" ).dialog( "open" );
       jQuery('#file').val('');
       document.getElementById("submit").disabled = true;
}