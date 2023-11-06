	function loadPopUp(fileAdded){
	
	    jQuery( "#manageTagImport" ).dialog({
	        autoOpen: false,
	        width: 560,
	         modal: true,
	        open: function() {
	            jQuery('.ui-widget-overlay,.errorInImport').bind('click', function() {
	            	
	                jQuery('#manageTagImport').dialog('close');
	            })
	        }        
	    });
		
		var isFileAdded=fileAdded;
		if(isFileAdded == 'true'){
			jQuery( "#manageTagImport" ).dialog( "open" );
		}
}



function fileOnChangeValidation(e){
	if (e.value!= "" && e.value != undefined) {
		var ext = e.value.match(/\.([^\.]+)$/)[1];
		
		if(ext=='xls'||ext=='xlsx' || ext=='xlsm'){
			document.getElementById("tagsAdd").disabled = false;
	    	document.getElementById("tagsAdd").classList.remove("ui-state-disabled");
	    	document.getElementById("tagsRemove").disabled = false;
	    	document.getElementById("tagsRemove").classList.remove("ui-state-disabled");
		}else{
			document.getElementById("tagsAdd").disabled = true;
	        document.getElementById("tagsAdd").classList.add("ui-state-disabled");
	        document.getElementById("tagsRemove").disabled = true;
	        document.getElementById("tagsRemove").classList.add("ui-state-disabled");
	        alert("Only files with following extensions are allowed: xls, xlsx, xlsm");
	        e.value='';
		}
	} 
}

function bindTagAction(nameSpace){
	jQuery('#tag-container').find('#tag-box').find(".lfr-form-row:last-child").find('img.delete-row').bind("click", function(){
		if(jQuery('#tag-container').find(".lfr-form-row").length>1){
			jQuery(this).closest(".lfr-form-row").remove();
		}else{
			jQuery(this).closest(".lfr-form-row").find('input.lfr-input-text').val("");
		}
		checkValues();
		updateOrSection(nameSpace);
	});
	jQuery('#tag-container').find('#tag-box').find(".lfr-form-row:last-child").find('.tagText').bind("change", function(){
		checkValues();
		updateOrSection(nameSpace);
	});
}

function updateOrSection(namespace){
	var tagsVal="";
	jQuery(".tagText").each(function(index) {
				    tagsVal=(tagsVal==""?"":tagsVal)+(index == 0 || index==(length-1) || tagsVal=='' ? "":",")+jQuery(this).val().trim();
					
				});
	tagsVal=tagsVal.trim();
	if($('#'+namespace+'file').val() != ""){
			$('#stdIdsText').attr('disabled','disabled');
			$('.tagText').attr('disabled','disabled');
			$('.add-row').attr('disabled','disabled');
			$('.delete-row').attr('disabled','disabled');

	}else if ($('#stdIdsText').val() != "" || tagsVal != "" ){
			$('#'+namespace+'file').val(''); 
			$('#'+namespace+'file').attr('disabled','disabled');
	}else{
			$('#stdIdsText').removeAttr('disabled','disabled');
			$('.tagText').removeAttr('disabled','disabled');
			$('.add-row').removeAttr('disabled','disabled');
			$('.delete-row').removeAttr('disabled','disabled');
			$('#'+namespace+'file').removeAttr('disabled','disabled');
	}

	}


function submitForm(action,namespace,xlsURL,uploadTagURL,addRemoveTags){
	jQuery('#'+namespace+'submitAction').val(action);
	var file=jQuery('#'+namespace+'file').val();
	var stdId=jQuery("#stdIdsText").val();
	var tagsVal="";
	var length=jQuery(".tagText").length
	jQuery(".tagText").each(function(index) {
	   tagsVal=(tagsVal==""?"":tagsVal)+(index == 0 || index==(length-1) || tagsVal=='' ? "":",")+jQuery(this).val();
		
	});
		if(action !='' && action != undefined){
		//$("#importForm").submit();
		jQuery.msgBox({
						    title: "Are You Sure",
						    content: "You want to "+action+" tags?",
						    type: "confirm",
						    buttons: [{ value: "Yes" }, { value: "No" }],
						    success: function (importConfirmation) {
						        if (importConfirmation == "Yes") {
						        	if(file !='' && file != undefined){
						        	jQuery.blockUI({ message: " <h3><img src='/BSTheme-theme/images/busy.gif'></img> Please wait...</h3>" });
									var A = AUI();
						            var myForm = A.one("#"+namespace+"importForm");
						            var configs = {
						                method: 'POST',
						                form: {
						                    id: myForm,
						                    upload: true
						                },
						                sync: true,
						                on: {
										complete: function(id, o, args) {
												if(args && args.responseText) {
													jQuery("#"+namespace+"file").val('');
													document.getElementById("tagsAdd").disabled = true;
										            document.getElementById("tagsAdd").classList.add("ui-state-disabled");
										            document.getElementById("tagsRemove").disabled = true;
										            document.getElementById("tagsRemove").classList.add("ui-state-disabled");
													response=A.JSON.parse(args.responseText);
													if(response.success == 'false') { 
														setTimeout(function () {
															/* eval(importElemProgressIdVar).hideProgress(); */
					                            			jQuery.msgBox({
						                          	    		title: "Please try again!",
						                          	    	    content: response.message,
						                          	    	    type:"info"
						                          	    	}); 
					                            			fileField.val('');
					                              		}, 500);
														
													} else {
														if(response.fileAdded == 'true') {
															var fileName=response.xlsFile;
															var getDownloadFileUrl=xlsURL+"&"+namespace+"fileName="+fileName;
															
															jQuery( "#manageTagImport span#action" ).html(action=="add"?"added":"deleted");
															jQuery( "#manageTagImport a" ).attr("onclick","window.location.href='"+getDownloadFileUrl+"'");
															jQuery( "#manageTagImport" ).dialog( "open" );
															if(action=="remove"){
																jQuery("#manageTagImport .modal-body ul").append("<li id=\"deleteLi\">4 No Ids/Tags are available for delete		</li>");
															}else{
																jQuery("#manageTagImport .modal-body ul li#deleteLi").remove();
															}
															
														} else {
														setTimeout(function () {
																jQuery("#errors").slideUp("slow", function () {});
					                  	      	            	jQuery.msgBox({
					     	                                    	title: "Success!",
					     	                                        content: "Records "+(action=="add"?"added":"deleted") + " successfully." ,
					     	                                        type: "info",
					     	                                        success: function (result) {
					     	                                        	/* eval(importElemProgressIdVar).hideProgress(); */
					     	                                        	//importDialog.hide();
																	
					     	                  	      	            	/* reloadGrid(response.locale); */
					     	                                            return;
																	}
																});
															}, 500);
														
														}
													}
													 jQuery.unblockUI();
												}
											}
						                }
						            };
						            //'<portlet:resourceURL/>'
									A.io.request(uploadTagURL,configs);
						        	}
						        	else if(stdId != "" && tagsVal!=""){
										 jQuery.ajax({
										        type: "POST",
										        url: addRemoveTags,
										        data: {"standardIds":stdId,
										        	"tagsValue":tagsVal,
										        	"action":action}
										    }).done( function(data) {
										    	var task=(action=="add"?"added":"deleted");
										    	jQuery("#stdIdsText").val('');
										      var tagLength=jQuery(".tagText").length;
										      jQuery(".tagText").each(function(index) {
										    	  if((tagLength - index)>2){
										    		  jQuery(this).closest(".lfr-form-row").remove();
										    	  }else{
										    		  jQuery(this).val('');  
										    	  }
										      });
										     // $("#tagText_1").val('');
										      var hasInValData=data.hasInValData;
										      var idList=data.idList;
										      var status=data.status;
										      var content="";
										      if(status == 'Success'){
										    	   content="Your record "+task+" successfully.";
											     	if(hasInValData == 'true'){
											     		content = content + " Some invalid data has not been added : "+ idList;
											     	}  
										      }else{
										    	  content="Due to invalid id, your data has not been "+task+": "+idList;
										      }
										     	
										     	
										     	setTimeout(function () { jQuery.msgBox({
	     	                                    	title: status+"!",
	     	                                        content: content ,
	     	                                        type: "info"
	     	                                      
												});}, 500);
										    }).fail( function(failData) {
										        
										    });
						        }
						        }
				                if(importConfirmation == "No" || importConfirmation == "Cancel")
								{
								  return;
								}
						    }
						});
	}
	
}


function checkValues(){
	var tagsVal="";
	var length=jQuery(".tagText").length;
	jQuery(".tagText").each(function(index) {
		   tagsVal=(tagsVal==""?"":tagsVal)+(index == 0 || index==(length-1) || tagsVal=='' ? "":",")+jQuery(this).val().trim();
			
		});
	var stdIdsText=jQuery("#stdIdsText").val().trim();
	tagsVal=tagsVal.trim();
	if ((stdIdsText!= "" && stdIdsText != undefined)  && (tagsVal != "" && tagsVal != undefined)) {
		document.getElementById("tagsAdd").disabled = false;
    	document.getElementById("tagsAdd").classList.remove("ui-state-disabled");
    	document.getElementById("tagsRemove").disabled = false;
    	document.getElementById("tagsRemove").classList.remove("ui-state-disabled");
	}
	else{
		document.getElementById("tagsAdd").disabled = true;
        document.getElementById("tagsAdd").classList.add("ui-state-disabled");
        document.getElementById("tagsRemove").disabled = true;
        document.getElementById("tagsRemove").classList.add("ui-state-disabled");
	}	
}

jQuery(function() {




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
	        if (event.shiftKey ||(event.keyCode < 48 || event.keyCode > 57) && (event.keyCode < 96 || event.keyCode > 105 )) 
	        {
	            event.preventDefault(); 
	        }   
	    }
	
});
});
	
	
	