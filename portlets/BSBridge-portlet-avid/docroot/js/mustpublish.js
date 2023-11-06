$(function() {
	/*import dialog */
	$( "#addByImport" ).dialog({
		autoOpen: false,
		width: 560,
		modal: true,
		resizable: false,
		open: function() {
            jQuery('.ui-widget-overlay').bind('click', function() {
                jQuery('#addByImport').dialog('close');
            });
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
		resizable: false,
		open: function() {
            jQuery('.ui-widget-overlay').bind('click', function() {
                jQuery('#confirm-dialog').dialog('close');
            });
        }
		
	});
	
	$( ".confirm-dialog-cancel" ).click(function() {
		$( "#confirm-dialog" ).dialog( "close" );
	});
	
	/*$( ".icon-remove" ).click(function() {
		$( "#confirm-dialog" ).dialog( "open" );
		$("body").css({ overflow: "hidden" });
	});*/
	
	/* Delete By ajax
	 * $( ".confirm-dialog-yes" ).click(function() {
		jQuery.ajax({			
	        url:__deleteURL,
	        data: {
	                stdId: __delteStdId
	        },
	        type: 'POST',
	        success: function(dataJson) 
	        	{ 
		        	 alert(dataJson);
	        	 }
	  	}); 
		$( "#confirm-dialog" ).dialog( "close" );
	});*/
	
	
	/*Add By Id Dialog */
	$( "#addNewItems" ).dialog({
		autoOpen: false,
		width: 860,
		modal: true,
		resizable: false,
		open: function() {
            jQuery('.ui-widget-overlay').bind('click', function() {
                jQuery('#addNewItems').dialog('close');
            });
        }
		
	});
	
	$( ".addByIdCancel" ).click(function() {
		$( "#addNewItems" ).dialog( "close" );
	});
	
	$( ".add-by-id" ).click(function() {
		$( "#addNewItems" ).dialog( "open" );
		//$("body").css({ overflow: "hidden" });
		jQuery("#searchResult").html('');
		jQuery("#selectedItems").html('');
		$("#searchId").val('');
		jQuery(".msg-text").html('');
		boxesValue = [];
	});
	$('#file').change(function(){
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
	
	$("#searchId").bind('paste', function () {
	    var element = this;
	    setTimeout(function () {
	        var newVal = jQuery(element).val().replace(/[^0-9]+/g, '').trim();
	        newVal = newVal.replace(/\s{2,}/g, ' ').trim();
	        $(element).val(newVal);
	    }, 200);
	});
	 

   $("#searchId").keydown(function(event) {
	   //Allow: space-> event.keyCode == 32 ||
       // Allow: escape, backspace, delete, tab, 
       if ( event.keyCode == 27 || event.keyCode == 46 || event.keyCode == 8 || event.keyCode == 9 || 
            //     enter,                        home, end, left, right                  Ctrl
            event.keyCode == 13 || (event.keyCode >= 35 && event.keyCode <= 40) || event.ctrlKey )
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
		if ($("input:checkbox[class='country" + regionId + "']").length > 0 )
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
});  

function createExportReport(url, reportId)
{
    var reportTitle = jQuery("#reportTitle").val();
    var postData = {reportId:reportId,reportTitle:reportTitle};
    jQuery.blockUI({ message: '<h3><img src="/BSTheme-theme/images/busy.gif" /> Please wait...</h3>' });
    
    jQuery.ajax({
        type: "POST",
        url: url,
        data: postData
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
}

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
}

function getCountry(stdId,rgnId, rgnCode)
{
	
	 jQuery.ajax({			
        url: regionCountryListURL,
        data: {
                stdId: stdId, 
                rgnCode: rgnCode,
                rgnId: rgnId
        },
       
        type: 'POST',
        success: function(dataJson) 
        	{ 
	        	$( "#regionCountrylist" ).dialog( "open" );
	        	
	    	//	$("body").css({ overflow: "hidden" }); 
	    		jQuery("#rgn-cnt-tbody").html('');
	    		jQuery("#rgn-cnt-tbody").append(dataJson);
        	 }
  	}); 
}

function deleteStd(stdId)
{
	$("#stdId").val(stdId);
	$( "#confirm-dialog" ).dialog( "open" );
	//$("body").css({ overflow: "hidden" });
	/*jQuery.msgbox({
		type: 'confirm',
		content: 'Are you sure you want to delete this item from list?',
		title: 'Attention',
		onClose: function(){
			if(this.val()){
				alert(stdId);
				$("#stdId").val(stdId);		
				alert($('#stdID').val());
				jQuery("#deleteForm").submit();
			} else {
				cancle
				return false;
			}
		}
	});
*/	
}

function searchById()
{
	var stdId = $("#searchId").val();
	if(stdId!=null && stdId!=""){
		jQuery.ajax({			
	        url: addByIdURL,
	        data: {
	        	stdId: stdId
	        },
	        type: 'POST',
	        success: function(dataJson) 
	        	{ 
		        	jQuery("#searchResult").html('');
		    		jQuery("#searchResult").append(dataJson);
					jQuery(".msg-text").html('');
					if(jQuery(".ajax-msg-text").html().length > 0){
						jQuery(".msg-text").html(jQuery(".ajax-msg-text").html());
					}
	        	}
		}); 
	}
	return false;
}
var boxesValue = [];
function additems(){
	var selectedItems = $('input[name=isMustPublish]:enabled:checked');
	
	$(selectedItems).each(function(){
		
		var itemValue = $("#"+ $(this).val()).val().split("#-#");
		//alert(itemValue[0] + "," +   itemValue[1]  + "," + itemValue[2]);
		
		var newRow = "<tr>" +
										"<td>"+ itemValue[1] + "</td>"+
										"<td>"+ itemValue[2] + "</td>"+
										"<td>"+ itemValue[0] + "</td>"+
										"<td class='cen'><a role='button' href='#'>" +
										"<i class='icon-remove' onclick='deleteSelectedItem(this);'></i></a></td>" +
									"</tr>";
		if(!itemExists(boxesValue, itemValue[1]))
		{
			jQuery("#selectedItems").append(newRow);
			boxesValue.push({id:itemValue[1],text:itemValue[0],type:itemValue[2]});    // remember to push array[boxesValue] value here
		}
		
       
    });
}

function itemExists(items, value) {
	if(items == null)
		return false;
    for (var i = 0; i < items.length; i++) {
        if (items[i].id == value) {
            return true;
        }
    }
    return false;
}

function deletArrayEelement(value) {
	if(boxesValue == null)
		return false;
    for (var i = 0; i < boxesValue.length; i++) {
        if (boxesValue[i].id == value) {
            boxesValue.splice(i, 1);
			break;
        }
    }
    return false;
}

function parentCheckUnCheck(stdid){
	var isCheck = $("#parent"+stdid+":enabled:checked").length > 0;
	if(!isCheck){
		/*$("#parent"+stdid).attr("checked","checked");*/
		document.getElementById("parent"+stdid).checked = true;
	}
}

function childCheckUnCheck(stdId){
	var childItems = $("input[id=child"+stdId+"]:enabled:checked");
	$(childItems).each(function(){
		$(this).attr("checked",false);
	});
}

function deleteSelectedItem(thisItem){
	var deleteId = $(thisItem).parents("td").prev().prev().prev().text();
	deletArrayEelement(deleteId);  // remember to pop/delete array[boxesValue] value here
	$(thisItem).parents("tr").remove();
	
}

function saveItems(){
	var idsToBeAdded = "";
	for (var i = 0; i < boxesValue.length; i++) {
		idsToBeAdded += boxesValue[i].id+",";
	}
	if(idsToBeAdded.length > 0){
		$("#addByIds").val(idsToBeAdded);
		document.getElementById('addByIdForm').submit();
	}
}

function find(){
	var ids = $("#findId").val();
	if(ids!=null && ids.length >0)
	{
		$("#findId").val(ids.replace(/\s{2,}/g, ' ').trim());
		document.getElementById('findForm').submit();
	}
}

function clearSearch(){
	$("#findId").val('');
	document.getElementById('findForm').submit();
}
