$(function() {
    /*import dialog */
    $( "#addByImport" ).dialog({
        autoOpen: false,
        width: 560,
         modal: true,
        open: function() {
            jQuery('.ui-widget-overlay').bind('click', function() {
                jQuery('#addByImport').dialog('close');
            })
        }
        
    });
    
    $( ".searchoptioncancel" ).click(function() {
        $( "#addByImport" ).dialog( "close" );
    });
    
    $( ".add-by-import" ).click(function() {
        $( "#addByImport" ).dialog( "open" );
        //$("body").css({ overflow: "hidden" });
        $('#file').val('');
        document.getElementById("upload").disabled = true;
    });
    
	 
	$("#file").change(function() {
		if (this.value!= "") {
			var ext = this.value.match(/\.([^\.]+)$/)[1];
	        switch(ext)
	        {
	            case 'xls':
	            	document.getElementById("upload").disabled = false;
	                break;
	            case 'xlsm':
	            	document.getElementById("upload").disabled = false;
	            	break;
	            default:
	            	document.getElementById("upload").disabled = true;
	            	//alert('Only files with following extensions are allowed: xls, xlsm');
	            	alert("Only files with following extensions are allowed: xls, xlsm");
	                this.value='';
	        }
		} 
	});
    
    /*export dialog */
    $("#exportReport").dialog({
        autoOpen: false,
        width: 560,
         modal: true,
        open: function() {
            jQuery('.ui-widget-overlay').bind('click', function() {
                jQuery('#exportReport').dialog('close');
            })
        }
    });
    
    $(".exportCancel").click(function() {
        $("#exportReport").dialog("close");
    });
    
    $(".export-report").click(function() {
        $("#exportReport").dialog("open");
        $('#reportTitle').val('');
    });
    
    if (disableAddToMyPub) {
    	jQuery('#addToMyPublication').attr('disabled', 'disabled');
    }
});

function updateSelectionVal (stdId) {
	
	var chkBoxVal = 'N';
	if ($('#selectStd_'+stdId).prop('checked')) {
		chkBoxVal = 'Y';
	}
	$.ajax({
	  	url :updatePublicationURL,
	  	type: "POST",
	  	data: {"standardId":stdId,"isSelected":chkBoxVal},
	  	dataType: "text",
	    success: function(data) {
	    	
	    }
	 });
}

function exportStds(reportId)
{
	var title = $("#reportTitle").val();
    jQuery.blockUI({ message: '<h3><img src="/BSTheme-theme/images/busy.gif" /> Please wait...</h3>' });

    jQuery.ajax({
        type: "POST",
        url: exportURL,
        data: {reportId:reportId,reportTitle:title}
    }).done( function(data) {
        jQuery.unblockUI();
        jQuery.msgBox({
            title: "Success!",
            content: "An email with a link to your Report will be sent to you once the Report has been generated.", 
            type: "info",
            buttons: [{ value: "OK" }],
            success: function (result) {
                $("#exportReport").dialog("close");
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
}

function submitPagination(source, value)
{	var pageNoValue = "";
	var itemsPageValue = "";
	//alert($("#itemsPerPage").val());
	itemsPageValue = $("#itemsPerPage").val();
	 pageNoValue=$("#pageNumber").val();
	if(source == "links")
	{
		pageNoValue = value;
	}
	if(source == 'itemsPerPageLower')
	{
		itemsPageValue = $("#itemsPerPageLower").val();
	}
	if(source == 'pageNumberLower')
	{
		 pageNoValue=$("#pageNumberLower").val();
	}
	if(source == 'itemsPerPage' || source == 'itemsPerPageLower')
	{
		pageNoValue = 1;
	}
	var submitUrl = pageUrl + "?renderJSP=viewImport&pageNumber="+pageNoValue+"&itemsPerPage="+itemsPageValue;
	window.location = submitUrl;
}

function saveStds()
{
	jQuery( "#" + portletNameSpace + "addPublishStadnards" ).attr('action',saveStandardImportURL);
	jQuery('#saveImport').attr('disabled', 'disabled');
	jQuery( "#" + portletNameSpace + "addPublishStadnards" ).submit();
}


function addStds()
{
	if (!disableAddToMyPub)
	{
		jQuery('#addToMyPublication').attr('disabled', 'disabled');
		/*jQuery( "#" + portletNameSpace + "addPublishStadnards" ).submit();*/
		addStdToMyPublication();
	}
}

function addStdToMyPublication()
{
    jQuery.blockUI({ message: '<h3><img src="/BSTheme-theme/images/busy.gif" /> Please wait...</h3>' });

    jQuery.ajax({
        type: "POST",
        url: addStandardsURL
    }).done( function(data) {
        jQuery.unblockUI();
        if (data == "SCHEDULE_SUCCESS")
        {
	        jQuery.msgBox({
	            title: "Success!",
	            content: "An email will be sent to you once the system adds Standards to My Publication.", 
	            type: "info",
	            buttons: [{ value: "OK" }],
	            success: function (result) {
	            	window.location = pageUrl + "?renderJSP=viewImport";
	            }
	        });
        }
        else if (data == "SUCCESS")
        {
	        jQuery.msgBox({
	            title: "Success!",
	            content: "Standards successfully added to My Publication.", 
	            type: "info",
	            buttons: [{ value: "OK" }],
	            success: function (result) {
	            	window.location = pageUrl + "?renderJSP=viewImport";
	            }
	        });
        }
        else
        {
        	jQuery.msgBox({
                title: "Error!",
                content: "Failed to add to My Publication! Failure status:" + data ,
                type: "error",
                success: function (result) {
                    ;
                }
            });
        }
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
}


