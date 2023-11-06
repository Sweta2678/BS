$(function() {
         
    /*Country list dialog */
    $( "#regionCountrylist" ).dialog({
        autoOpen: false,
        width: 860,
        modal: true,
        resizable: false,
        open: function() {
            jQuery('.ui-widget-overlay').bind('click', function() {
                jQuery('#regionCountrylist').dialog('close');
            });
        }
        
    });
    
    $( ".regioncountrycancel" ).click(function() {
        $( "#regionCountrylist" ).dialog( "close" );
    });

	/*confirmation dialog */
	
	$( "#confirm-dialog" ).dialog({
		autoOpen: false,
		width: 250,
		modal: true,
		open: function() {
            jQuery('.ui-widget-overlay').bind('click', function() {
                jQuery('#confirm-dialog').dialog('close');
            })
        }
		
	});
	
	$( ".confirm-dialog-cancel" ).click(function() {
		$( "#confirm-dialog" ).dialog( "close" );
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

	$("#findId").bind('paste', function () {
	    var element = this;
	    setTimeout(function () {
	        var newVal = $(element).val().replace(/[^0-9 ]+/g, '').trim();
	        newVal = newVal.replace(/\s{2,}/g, ' ').trim();
	        $(element).val(newVal);
	    }, 200);
	});
	 

    $("#findId").keydown(function(event) {
        // Allow: escape, backspace, delete, tab, 
        if ( event.keyCode == 27 || event.keyCode == 46 || event.keyCode == 8 || event.keyCode == 9 || 
             // Allow: space            enter,                        home, end, left, right                  Ctrl
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
	
    $('#wobble').delegate("input:checkbox[id='country']", 'change', function () {       
          var parentRegionId = $(this).attr('class').replace($(this).val(),"").replace("country","");
          var regionCountryCount = $("input:checkbox[class='country"+parentRegionId+"']").length;     
          var regionSelectedCountryCount = $("input:checkbox[class^='country"+parentRegionId+"']:checked").length;
          var regionCode = $('#regionCode').val();
          if (regionCode != "GC")
          {
              if (this.checked)
              {
                  if (regionCountryCount == regionSelectedCountryCount)
                  {
                      $("#region"+parentRegionId).prop( "checked", true );
                  }
              } 
              else 
              {
                  $("#region"+parentRegionId).prop( "checked", false );
              }
          }
          allCountryOptionCheckUncheck(regionCode);
          document.getElementById("saveCountry").disabled = false;
    });
    
    $('#wobble').delegate("input:checkbox[id^='region']", 'change', function () {
          var regionCode = $('#regionCode').val();
          var isRegionSelect = this.checked;
          var regionId = $(this).attr('id').replace("region","");
          $("input:checkbox[class='country" + regionId + "']").each(function (){
              $(this).prop( "checked", isRegionSelect );
          });
          allCountryOptionCheckUncheck(regionCode);
		  if ($("input:checkbox[class='country"+ regionId +"']").length > 0 )
		  {
				document.getElementById("saveCountry").disabled = false;
		  }
    });
    
    $('#wobble').delegate("input:checkbox[id='allCountry']", 'change', function () {
          var isAllSelect = this.checked;
          $("input:checkbox[id='country']").each(function(){
              $(this).prop( "checked",isAllSelect);
          });
          var regionCode = $('#regionCode').val();
          if (regionCode !=  "GC")
          {
              $("input:checkbox[id^='region']").each(function(){
                  $(this).prop( "checked",isAllSelect);
              });
          }
		  if ($("input:checkbox[class^='country']").length > 0 )
		  {	
			document.getElementById("saveCountry").disabled = false;
		  }
    });
    
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
    
    $("#my-publication-report").click(function() {
        $('#reportTitle').val('');
        $("#createReportDialog").dialog("open");
    });
    
    $(".btn-clear-option").click(function(){ 
    	$('#showUpdatedHighlight').prop( "checked", false );
    	$('#showNewHighlight').prop( "checked", false );
    	$('#missingRefs').prop( "checked", false );
    	highlightNew();
    	hideReferences(); 
    });
});

function createReport(reportId) {
    var reportTitle = jQuery("#reportTitle").val();
    var reportId = jQuery("input[name='reports']:checked", "#createReportForm").val();
    var postData = {reportId:reportId,reportTitle:reportTitle};
    loadProgressBar();
    
    jQuery.ajax({
        type: "POST",
        url: createReportURL,
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

function find(){
	var ids = $("#findId").val();
	if(ids!=null && ids.length >0)
	{
		$("#findId").val(ids.replace(/\s{2,}/g, ' ').trim());
		$('#findForm').submit();
	}
}

function clearSearch(){
	$("#findId").val('');
	$('#findForm').submit();
};

function selectSubRegion()
{
    $("input:checkbox[id^='region']").each(function(){
        var regionNo = $(this).attr("id").replace("region","");
        var noOfCountry = $("input:checkbox[class='country"+regionNo+"']").length;
        var noOfSelectedCountry = $("input:checkbox[class='country"+regionNo+"']:checked").length;
        if (noOfCountry>0)
        {
            $(this).prop( "checked",noOfCountry==noOfSelectedCountry);
        }
    });
    var regionCode = $('#regionCode').val();
    allCountryOptionCheckUncheck(regionCode);
};

function allCountryOptionCheckUncheck(regionCode)
{
    if (regionCode ==  "GC")
    {
        var noOfCountry = $("input:checkbox[class^='country']").length;
        var noOfSelectedCountry = $("input:checkbox[class^='country']:checked").length;
        if (noOfCountry>0)
        {
            $("#allCountry").prop( "checked",noOfCountry==noOfSelectedCountry);
        }
    }
    else 
    {
        var noOfRegion = $("input:checkbox[class^='region']").length;
        var noOfSelectedRegion = $("input:checkbox[class^='region']:checked").length;
        
        if (noOfRegion)
        {
            $("#allCountry").prop( "checked",noOfRegion==noOfSelectedRegion);
        }
    }
};

function getCountry(stdId,rgnId, rgnCode)
{
    jQuery.ajax({          
        url:getCountriesURL,
        data: {
            stdId: stdId
        },
        type: 'POST',
        success: function(dataJson) 
        { 
            $("#regionCountrylist").dialog("open");
            jQuery("#rgn-cnt-tbody").html('');
            jQuery("#rgn-cnt-tbody").append(dataJson);
        }
    }); 
};



