 $(function() {
	$("#exportReportDialog").dialog({
		autoOpen: false,
		width: 560,
		 modal: true,
		open: function() {
			jQuery('.ui-widget-overlay').bind('click', function() {
				jQuery('#exportReportDialog').dialog('close');
			})
		}
	});
	
	$(".reportCancel").click(function() {
		$("#exportReportDialog").dialog("close");
	});
	
	$("#exportErrorReport").click(function() {
		$('#reportTitle').val('');
		$("#exportReportDialog").dialog("open");
	});
});
	
function loadProgressBar () {
	jQuery.blockUI({ message: '<h3><img src="/BSBridge-theme/images/busy.gif" /> Please wait...</h3>' });
}
	
function exportReport() {
	var reportTitle = jQuery("#reportTitle").val();
	createReportURL = createReportURL + "&reportTitle=" + reportTitle;
	
	jQuery.msgBox({
		title: "Are You Sure",
		content: "You want to do an export?",
		type: "confirm",
		buttons: [{ value: "Yes" }, { value: "No" }],
		autoClose: false,
		success: function (result) {
		   if (result == "Yes") {
			   loadProgressBar();
			   location.href = createReportURL;
				setTimeout($.unblockUI, 5000); 
				$("#exportReportDialog").dialog("close");
		   } else {
			   jQuery.unblockUI();
			   $("#exportReportDialog").dialog("close");
		   }
	}});
}

function deleteRec(stdId)
{
    var postData = {stdId:stdId};
    loadProgressBar();
    
    jQuery.ajax({
        type: "POST",
        url: deleteStdURL,
        data: postData
    }).done( function(data) {
        jQuery.unblockUI();
        window.location.reload();
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

function deleteStd(stdId)
{
	jQuery.msgBox({
		title:"Are You Sure",
		content: "Are you sure you want to delete this?" ,
		type:"confirm",
		buttons: [{value: "Yes"}, {value: "No"}],
		success: function (result) {
			if (result == "Yes") {
				deleteRec(stdId);
			}
		}
	});
}