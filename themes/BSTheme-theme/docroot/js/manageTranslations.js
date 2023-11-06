


function duplicateAssignedImage(newImgId)
{
    var duplicate = false;
    
    jQuery('table#assign_images tr.table_links_list').children('td.this_link').each(function(){
        var input = jQuery(this).children('input');
        var varType = jQuery(input).attr("var_type");
        if ( varType == "imgId" ) 
        {
            var curId = jQuery(input).val();
            if (curId == newImgId )
            {
                duplicate = true;
                return false;
            }
        }
    });
    return duplicate;
}

function addAssignedImageTranslate(selectImgTbl)
{
	var jsImage = new Object();
    jsImage.stdImgId = 0;
    jsImage.image = "";
    jsImage.thumbnail = "";
    jsImage.imgTitle = "";
    jsImage.imgId = 0;
    jsImage.imgSmallId = 0;
    jsImage.imgDate = "";
    jsImage.imgDateTime = "";
    jsImage.imgAuthor = jQuery("#currUserName").val();
    jsImage.imgDesc = "";
    jsImage.imgSortOrder = 0;
    jsImage.imgUuId = "";
    jsImage.imgGroup = 0;
    jsImage.insertedNewRow = false;
	jsImage.stdCount = 0;
	jsImage.specCount = 0;
	jsImage.gdlnCount = 0;
	var idArray = jQuery("#choose_image_helper").text().split('--');
	var parentImageId = idArray[0];
	var localeCd = idArray[1];
	var targetDivId = idArray[0]+'--'+idArray[1]+'--defaultImage';
	var defaultCheckboxId = idArray[0]+'--'+idArray[1]+'--use_current_checkboxspan';
    jQuery(selectImgTbl).each(function(){
        jQuery(this).children('td.this_link').each(function(){
            var value = jQuery(this).children('input').val();
            if ( value.search("imgId:") > -1 ) 
            {
                jsImage.imgId = jQuery(this).text();
            }
			else if ( value.search("author:") > -1 )
            {
                jsImage.imgAuthor = jQuery(this).text().trim();
            }
            else if ( value.search("date:") > -1 )
            {
                jsImage.imgDateTime = jQuery(this).text();
                var str = jsImage.imgDateTime.split(" ");
                var strDate = str[0].split("-");
                var date = new Date(parseInt(strDate[0], 10), parseInt(strDate[1], 10) - 1, parseInt(strDate[2], 10));
                jsImage.imgDate = jQuery.datepicker.formatDate('dd M yy', date);
            }
            else if ( value.search("desc:") > -1 )
            {
                jsImage.imgDesc = jQuery(this).text();
                if (!jsImage.imgDesc)
                {
                    jsImage.imgDesc = '  ';
                }
            }
            else if ( value.search("uuid:") > -1 )
            {
                jsImage.imgUuId = jQuery(this).text();
            }
            else if ( value.search("group:") > -1 )
            {
                jsImage.imgGroup = jQuery(this).text();
            }
            else if ( value.search("smallId:") > -1 )
            {
                jsImage.imgSmallId = jQuery(this).text();
            }
            else if ( value.search("title:") > -1 )
            {
                jsImage.imgTitle = jQuery(this).text();
            }
			else if ( value.search("stdCount:") > -1 )
            {
                jsImage.stdCount = jQuery(this).text();
            }
			else if ( value.search("specCount:") > -1 )
            {
                jsImage.specCount = jQuery(this).text();
            }
			else if ( value.search("gdlnCount:") > -1 )
            {
                jsImage.gdlnCount = jQuery(this).text();
            }
        });
		if($('#'+targetDivId+'Child').length == 0)
		{
			var klon = $( '#'+targetDivId);
			klon.clone().attr('id', targetDivId+'Child').insertAfter( klon );
			populateTranslatedImage(targetDivId+'Child',jsImage);
		}
		else
		{
			populateTranslatedImage(targetDivId+'Child',jsImage);
		}
		removeDefaultCheckBox(defaultCheckboxId);
}); 

}

/**
 * This method populates manage translation accordion with choosen translated image
 */
function populateTranslatedImage(translationDiv, jsImage)
{
	jQuery('#'+translationDiv).addClass('translatedImageContainer');
	/* image anchor*/
	jQuery('#'+translationDiv+' a.trans_img_link').attr('href',"/image/image_gallery?uuid="+jsImage.imgUuId+"&groupId="+jsImage.imgGroup);
	/* image thumbnail*/
	jQuery('#'+translationDiv+' a.trans_img_link img').attr('src','/image/image_gallery?img_id='+jsImage.imgSmallId);
	jQuery('#'+translationDiv+' a.trans_img_link img').attr('title','image--'+jsImage.imgId);
	jQuery('#'+translationDiv+' a.trans_img_link img').attr('alt','image--'+jsImage.imgSmallId);
	/* image title*/
	jQuery('#'+translationDiv+' div.image-title').text(jsImage.imgTitle);
	/* image Id*/
	jQuery('#'+translationDiv+' span.trans_image_id').text('ID: '+jsImage.imgId);
	/* image date time*/
	jQuery('#'+translationDiv+' span.trans_image_date').text('Uploaded: '+jsImage.imgDate);
	jQuery('#'+translationDiv+' span.trans_image_std_cnt').text(jsImage.stdCount);
	jQuery('#'+translationDiv+' span.trans_image_spec_cnt').text(jsImage.specCount);
	jQuery('#'+translationDiv+' span.trans_image_gdln_cnt').text(jsImage.gdlnCount);
	
}

/**
 * To remove default checkbox and add remove translated image link
 */
 
function removeDefaultCheckBox(removeCheckBoxId)
{
	jQuery('#'+removeCheckBoxId).remove();
	var idArr = removeCheckBoxId.split('--');
	var idPrefix = idArr[0]+"--"+idArr[1]+"--";
	var removeImageTranslationLink = '<div class="image_translation_remove_link" id="'+idPrefix+'remove_trans_img_div"><a href="" id="'+idPrefix+'remove_trans_img_link" title="Remove Translated Image">Remove Translated Image</a><span></span></div>';
	if(jQuery('#'+idPrefix+'remove_trans_img_div').length == 0)
	{
		jQuery('#'+idPrefix+'select_trans_img_link').append(removeImageTranslationLink);
	}
}
/**
 * from jsp start
 */
function submitTranslation(languageId) {
		var title =  jQuery.trim(jQuery("#" + languageId + "translationTitle").val());
		var context =  jQuery.trim(jQuery("#" + languageId + "translationContext").val());
		var comment = jQuery.trim(jQuery("#" + languageId + "Comment").val());
		var noneCheck = [];
		var noneUnCheck = [];
		var noneAttachCheck = [];
		var noneAttachUnCheck = [];
		var parentIds = [];
		var urls = [];
		var titles = [];
		var parentStdImageIds = [];
		var translatedImageIds = [];
		var translatedImageTitles = [];
		var useDefaultImagesChecked = [];
		var useDefaultImagesUnchecked = [];
		var newAttachmentsAdded = [];
		var newAttachmentsNames = [];
		var flag = true;
		/* External links*/
		jQuery("#translationExtLinks" + languageId + " .input-none-checkbox")
				.each(function() {
					var id = jQuery(this).attr('id');
					idArr = id.split('--');
					if (jQuery(this).is(':checked')) {
						noneCheck.push(idArr[0]);
					} else {
						noneUnCheck.push(idArr[0]);
					}
				});
		jQuery("#translationExtLinks" + languageId + " .input-urls").each(
				function() {
					var id = jQuery(this).attr('id');
					idArr = id.split('--');
					if (jQuery.inArray(idArr[0], noneCheck) == -1) {
						if (jQuery(this).valid() && jQuery.trim(jQuery(this).val())!='') {
							parentIds.push(idArr[0]);
							urls.push(jQuery(this).val());

						} else {
							jQuery.msgBox({
					            title: "Error!",
					            content: "Please enter a valid URL",
					            type: "error"
					        });
							flag = false;
							return false;
						}
					}

				});

		jQuery("#translationExtLinks" + languageId + " .input-titles").each(
				function() {
					if (jQuery.inArray(idArr[0], noneCheck) == -1) {
						if (jQuery.trim(jQuery(this).val()) != '') {
							var titleInput = jQuery(this).val();
							titleInput = titleInput.replace(/\,/g,'~~!~~');
							titles.push(titleInput);
						} else {
								jQuery.msgBox({
						            title: "Error!",
						            content: "Please enter a valid title",
						            type: "error"
						        });
								flag = false;
								return false;
							}
						}
					});
		if(flag == false)
		{
			return false;
		}
		/* Image translations*/
		jQuery('#' + languageId + '--imageTranslatorDiv .translatedImageContainer').each(
			function() {
				var parentStdImageId = jQuery(this).attr('id').split('--')[0];
				var imageTitleArr = jQuery(this).find('img.trans_img').attr('title').split('--');
				parentStdImageIds.push(parentStdImageId);
				translatedImageIds.push(imageTitleArr[1]);
				translatedImageTitles.push(jQuery(this).find('.image-title').text());
			}
		);

		/* Submitting use current image checkboxes*/
		jQuery('#' + languageId + '--imageTranslatorDiv .hidden_images_right')
				.each(
						function() {
							var parentStdImageId = jQuery(this).attr('id')
									.split('--')[0];
							var localeCode = jQuery(this).attr('id')
									.split('--')[1];
							var checkboxId = parentStdImageId + "--"
									+ localeCode + '--use_current_checkbox';
							if (jQuery("#" + checkboxId).length > 0
									&& jQuery("#" + checkboxId).is(':checked')) {
								useDefaultImagesChecked.push(checkboxId);
							} else if (jQuery("#" + checkboxId).length > 0
									&& jQuery("#" + checkboxId).is(':checked') == false) {
								useDefaultImagesUnchecked.push(checkboxId);
							}
						});
		
		/* Attachments Translations*/
		
		jQuery("#translationAttachTable" + languageId + " .attach-none-check").each(function() {
			var id = jQuery(this).attr('id');
			idArr = id.split('--');
			if (jQuery(this).is(':checked')) {
				noneAttachCheck.push(idArr[0]);
			} else if (!jQuery(this).is(':disabled')){
				noneAttachUnCheck.push(idArr[0]);
			}
		});
		jQuery("#translationAttachTable" + languageId +" tr.attch_connected_row_btm .new_file_added").each(function()
		{
			if(jQuery(this).val()=='')
			{
				flag=false;
				jQuery.msgBox({
		            title: "Error!",
		            content: "Please upload the translated file",
		            type: "error"
		        });
			}
			var currentVal = jQuery(this).val().replace("C:\\fakepath\\", "");
			if(/[&@\]\}:,=>\/<\n\[\{%|\+#\?\(\)\'\"\r;\*~]/g.test(currentVal) && flag!=false)
			{
				flag=false;
				jQuery.msgBox({
		            title: "Error!",
		            content: "Invalid filename",
		            type: "error"
		        });
			}
			var currentId = jQuery(this).attr('id');
			jQuery('.'+languageId+'--attachment').each(
			function()
			{
			if(jQuery(this).is('a'))
			{
				if(currentVal == jQuery(this).text() && flag!=false)
				{
					flag=false;
					jQuery.msgBox({
		            title: "Error!",
		            content: "Duplicate file name found. Please select different file.",
		            type: "error"
		        });
				}
			}
			else
			{
			if(jQuery(this).is('input'))
			{
				if(currentVal == jQuery(this).val().replace("C:\\fakepath\\", "") && currentId != jQuery(this).attr('id') && flag!=false)
				{
					flag=false;
					jQuery.msgBox({
		            title: "Error!",
		            content: "Duplicate file name found. Please select different file.",
		            type: "error"
		        });
				}
			}
			}
			});
			newAttachmentsAdded.push(jQuery(this).attr('name'));
			newAttachmentsNames.push(jQuery(this).val().replace("C:\\fakepath\\", ""));
		});
		jQuery("#translationAttachTable" + languageId +" tr.attch_connected_row_btm .new_attachment_title").each(function()
		{
			if(jQuery.trim(jQuery(this).val()) == '')
			{
				flag = false;
				jQuery.msgBox({
		            title: "Error!",
		            content: "Please enter a valid title",
		            type: "error"
		        });
			}
		});
		if(flag == false)
		{
			return false;
		}
		
		jQuery('#standardsId').val(stdId);
		jQuery('#langId' ).val( languageId);
		jQuery('#transTitle' ).val(title);
		jQuery('#stdContext').val( context);
		jQuery('#transComment').val(comment);
		jQuery('#parents').val(parentIds);
		jQuery('#transUrls').val(urls);
		jQuery('#transTitles').val(titles);
		jQuery('#noneChecked').val(noneCheck);
		jQuery('#noneUnChecked').val(noneUnCheck);
		jQuery('#parentStdImages').val(parentStdImageIds);
		jQuery('#translatedImages').val(translatedImageIds);
		jQuery('#translatedImagesTitle').val(translatedImageTitles);
		jQuery('#imageDefaultChecked').val(useDefaultImagesChecked);
		jQuery('#imageDefaultUnchecked').val(useDefaultImagesUnchecked);
		jQuery('#newAttachAdded').val(newAttachmentsAdded);
		jQuery('#noneAttachCheck').val(noneAttachCheck);
		jQuery('#noneAttachUnCheck').val(noneAttachUnCheck);
		jQuery('#newAttachmentsNames').val(newAttachmentsNames);
		
		var options = { 
		        url:           jQuery("#transForm").attr('action'),         /* override for form's 'action' attribute*/  
		        beforeSubmit:  showRequest,  /* pre-submit callback*/ 
		        success:       showResponse, /* post-submit callback*/ 
		        
		        type:      'post',       
		        dataType:  'html'        /* 'xml', 'script', or 'json' (expected server response type)*/ 
		}; 
		jQuery('#transForm').submit(function() { 
			/* submit the form*/ 
			jQuery(this).ajaxSubmit(options); 
			/* return false to prevent normal browser submit and page navigation*/ 
			return false; 
		});
		jQuery('#transForm').submit();
		if(jQuery('#'+languageId+'deletedAttachments').length > 0)
		{
			jQuery('#'+languageId+'deletedAttachments').val('');
		}
		if(jQuery('#'+languageId+'deletedExtLinks').length == 0)
		{
			jQuery('#'+languageId+'deletedExtLinks').val('');
		}
	}
	
	
	function showRequest(formData, jqForm, options)
	{
	    
		jQuery.blockUI({ message: '<h3><img src="/BSTheme-theme/images/busy.gif" /> Please wait...</h3>' });
		return true;
	}
	
	function showResponse(responseText, statusText, xhr, $form)  
	{ 
	    jQuery.unblockUI();
	    /*alert("responseText=" + responseText + "\n statusText=" + statusText);*/
	    
	    if(responseText == "Translation data successfully submitted")
	    {
				
	            jQuery.msgBox({
	                title: "Success!",
	                content: responseText ,
	                type:"info",
			        buttons: [{ value: "Ok" }],
					success: function (result) {
			            	 if (result == "Ok") {
									refreshTranslations();
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
	
	
	/* ///////////////////////////////////// static html js //////////////////////////////////////////////// */
	jQuery(function() {
		
		/* bind ajax refresh*/
		jQuery('.refresh_translation,.tr_cancel').click(function(){
			refreshTranslations();
			return false;
		});
		
		/* for image search popup*/
		jQuery('.nyroModal').nyroModal({
			closeOnClick : false
		});

		jQuery('.close_page').click(function() {
			jQuery(".open_tree_selection").val(nodeText);
			jQuery(".nyroModalClose").click();
		});

		jQuery("#accordion").accordion({
			collapsible : true,
			active : 4,
			heightStyle : "content"
		});
		/*expand/contract the translation table*/
		var imageMinusLocation = "/BSTheme-theme/images/minus_color.png";
		var imagePlusLocation = "/BSTheme-theme/images/plus_color.png";
		jQuery(".edit_translation").click(function() {
			var transFields = jQuery(this);
			if(transmodified)
			{
					jQuery.msgBox({
			            title:"Attention",
			            content:"You may lose the changes of current translation, are you sure you want to close the current accordion?" ,
			            type:"confirm",
			            buttons: [{ value: "Yes" }, { value: "No" }],
			            success: function (result) {
			            	 if (result == "Yes") {
			            		if (!jQuery(transFields).hasClass("trans_open")) {
									jQuery('.trans_open').each(function()
									{				
										jQuery(this).parent().parent().next(".table_hidden_row").hide();
										jQuery(this).children("img").attr("src", imagePlusLocation);
										jQuery(this).removeClass("trans_open");
									});
								}
								jQuery(transFields).toggleClass("trans_open");
								/* if to open, else to close*/	
								if (jQuery(transFields).hasClass("trans_open")) {
									jQuery(transFields).parent().parent().next(".table_hidden_row").show();
									jQuery(transFields).children("img").attr("src", imageMinusLocation);
								} else {
									/*jQuery.msgBox({
										title:"Attention",
										content:"You will lose the changes of current translation, are you sure you want to close the current accordion?" ,
										type:"confirm",
										buttons: [{ value: "Yes" }, { value: "No" }],
										success: function (result) {
											 if (result == "No") {
												 stoptheprocess = true;
											 }
										}
										});
									if(stoptheprocess)
									{
										return false;
									}*/
									jQuery(transFields).parent().parent().next(".table_hidden_row").hide();
									jQuery(transFields).children("img").attr("src", imagePlusLocation);
									transmodified = false;
								}
							}
							else {
								return false;
							}
						}
					});
			}
			else
			{
				if (!jQuery(transFields).hasClass("trans_open")) {
									jQuery('.trans_open').each(function()
									{				
										jQuery(this).parent().parent().next(".table_hidden_row").hide();
										jQuery(this).children("img").attr("src", imagePlusLocation);
										jQuery(this).removeClass("trans_open");
									});
								}
								jQuery(transFields).toggleClass("trans_open");
								/* if to open, else to close*/	
								if (jQuery(transFields).hasClass("trans_open")) {
									jQuery(transFields).parent().parent().next(".table_hidden_row").show();
									jQuery(transFields).children("img").attr("src", imageMinusLocation);
								} else {
									jQuery(transFields).parent().parent().next(".table_hidden_row").hide();
									jQuery(transFields).children("img").attr("src", imagePlusLocation);
								}
			}
			return false;
		});

		/*trigger click to change translated attachment*/
		jQuery(".hidden_attach_table").delegate(".change_attach", "click",
				function() {
					jQuery(this).hide();
					jQuery(this).siblings(".open_hidden_attach").hide();
					jQuery(this).siblings(".hidden_new_file").show();
					jQuery(this).siblings(".hidden_new_file").click();

					return false;
				});

		/*delete an attachment*/
		jQuery(".hidden_attach_table").delegate(".hidden_delete_attachlink_icon", "click", function(){
			var thisId = jQuery(this).attr('id');
			jQuery.msgBox({
	            title:"Are You Sure",
	            content:"Are you sure you want to delete this attachment?" ,
	            type:"confirm",
	            buttons: [{ value: "Yes" }, { value: "No" }],
	            success: function (result) {
	                if (result == "Yes") {
	                	var idArr = jQuery('#'+thisId).attr('id').split('--');
						var parentId = idArr[0];
						var localeCd = idArr[1];
	                	if(jQuery('#'+thisId).hasClass('new_file_added') == false)
	                	{
	                		if(jQuery('#'+localeCd+'deletedAttachments').length == 0)
							{
								var hiddenInput = '<input type="hidden" id="'+localeCd+'deletedAttachments" name="'+localeCd+'deletedAttachments" value="'+parentId+'" />'
								jQuery(hiddenInput).appendTo(jQuery('#transForm'));
							}
							else
							{
								var newValue = jQuery('#'+localeCd+'deletedAttachments').val() + ","+parentId;
								jQuery('#'+localeCd+'deletedAttachments').val(newValue);
							}
	                		/*deletedAttachmets.push(jQuery('#'+thisId).attr('id'));*/
	                	}
	                	/*disable the none box*/
						jQuery('#'+thisId).parent().parent().prev("tr").find(".tr_attach_none").attr("disabled", false);
						
						/*show add button again*/
						jQuery('#'+thisId).parent().parent().prev("tr").find(".hidden_add_link_icon").show();
						jQuery('#'+thisId).parent().parent().prev("tr").find(".hidden_add_attach_icon").show();
						
						jQuery('#'+thisId).parent().parent("tr").remove();
						transmodified = true;
	                }
	                else {
	                	return false;
	                }
	            }
	        });
			return false;
		});
		
	
		/*delete a link*/
		jQuery(".hidden_attach_table").delegate(
				".hidden_delete_link_icon",
				"click",
				function() {
					var thisId = jQuery(this).attr('id');
					jQuery.msgBox({
			            title:"Are You Sure",
			            content:"Are you sure you want to delete this link?" ,
			            type:"confirm",
			            buttons: [{ value: "Yes" }, { value: "No" }],
			            success: function (result) {
			                if (result == "Yes") {
								var idArr = jQuery('#'+thisId).attr('id').split('--');
								var parentId = idArr[0];
								var localeCd = idArr[1];

								var prevIsTop = jQuery('#'+thisId).parent().parent().prev("tr")
										.hasClass("attch_connected_row_top");
								var nextIsBtm = jQuery('#'+thisId).parent().parent().next("tr")
										.hasClass("attch_connected_row_btm");

								if (nextIsBtm) {
									/*alert("there are other siblings here... don't turn on the 'none' checkbox yet.");*/
								} else if (prevIsTop) {
									/* remove class attch_connected_row_top from parent as child is deleted*/
									jQuery('#'+thisId).closest("tr").prev("tr").removeClass(
											"attch_connected_row_top").find(
											".tr_attach_none").attr("disabled", false);
								}
								jQuery('#'+thisId).parent().parent().prev("tr").find(".hidden_add_link_icon").show();
								if(jQuery('#'+localeCd+'deletedExtLinks').length == 0)
								{
									var hiddenInput = '<input type="hidden" id="'+localeCd+'deletedExtLinks" name="'+localeCd+'deletedExtLinks" value="'+parentId+'" />'
									jQuery(hiddenInput).appendTo(jQuery('#transForm'));
								}
								else
								{
									var newValue = jQuery('#'+localeCd+'deletedExtLinks').val() + ","+parentId;
									jQuery('#'+localeCd+'deletedExtLinks').val(newValue);
								}
								/*deletedExtLinks.push(parentId);*/
								jQuery('#'+thisId).parent().parent("tr").remove();
								transmodified = true;
			                }
			                else {
			                	return false;
			                }
			            }
			        });
					return false;
				});

		/*dd an attachment*/
		jQuery(".hidden_attach_table").delegate(".hidden_add_attach_icon", "click", function(){
		
			var activeAttachmentRow = jQuery(this).parent().parent("tr");
			jQuery(activeAttachmentRow).addClass("attch_connected_row_top");
			jQuery(this).hide();
			var idArr = jQuery(this).attr('id').split('--');
			var parentId = idArr[0];
			var localeCd = idArr[1];
			var idPrefix = parentId + "--" + localeCd + "--";
			var langName = idArr[3];
			var newAttachmentRow = '<tr class="attch_connected_row_btm"><td><input type="text" maxlength="75" id="'+ idPrefix+'newfileTitle" value="" name="'+ idPrefix+'newfileTitle" class="orig_hidden_title_attch new_attachment_title" /></td><td><input type="file" class="new_file_added '+localeCd+'--attachment" id="'+idPrefix+'transFile" name="'+idPrefix+'newfile" /></td><td><p class="tiny_text no_change">As original attachment</p></td><td>'+langName+'</td><td class="align_cell_middle"></td><td class="align_cell_middle"><a href="" class="hidden_delete_attachlink_icon" id="'+idPrefix+'deleteAttachment"><img src="/BSTheme-theme/images/delete.png" /></a></td><td class="align_cell_middle"></td></tr>';
												
			jQuery(newAttachmentRow).insertAfter(activeAttachmentRow);
			
			jQuery(this).parent().siblings().find(".tr_attach_none").attr("checked", false);
			jQuery(this).parent().siblings().find(".tr_attach_none").attr("disabled", true);
			transmodified = true;
		
			return false;
		});

		/*add a link*/
		jQuery(".hidden_attach_table")
				.delegate(
						".hidden_add_link_icon",
						"click",
						function() {
							var activeAttachmentRow = jQuery(this).parent().parent(
									"tr");
							if (jQuery(activeAttachmentRow).hasClass(
									"attch_connected_row_top")) {
								return false;
							}
							jQuery(activeAttachmentRow).addClass(
									"attch_connected_row_top");
							var idArr = jQuery(this).attr('id').split('--');
							var parentId = idArr[0];
							var localeCd = idArr[1];
							var idPrefix = parentId + "--" + localeCd + "--";
							var langName = idArr[3];
							var newAttachmentRow = '<tr class="attch_connected_row_btm"><td width="135"><img src="/BSTheme-theme/images/solo_branch.png"/><span class="'+idPrefix+'toggle-helper"><input type="text" class="input-urls orig_hidden_title_attch url" id="'+idPrefix+'url" value="" maxlength="2000"> </span></td><td><span class="'+idPrefix+'toggle-helper"><input type="text" class="input-titles orig_hidden_title_attch required" title="Please enter valid title" id="'+idPrefix+'title" maxlength="500" value=""> </span></td><td><p class="tiny_text">As original attachment</p></td><td>'
									+ langName
									+ '</td><td class="align_cell_middle"></td><td class="align_cell_middle"><a href="" id="'+idPrefix+'deleteExtLink" class="hidden_delete_link_icon"><img src="/BSTheme-theme/images/delete.png" /></a></td><td class="align_cell_middle"></td></tr>'

							jQuery(newAttachmentRow)
									.insertAfter(activeAttachmentRow);
							jQuery(this).hide();
							jQuery(this).parent().siblings().find(".tr_attach_none")
									.attr("checked", false);
							jQuery(this).parent().siblings().find(".tr_attach_none")
									.attr("disabled", true);
							transmodified = true;
							return false;
						});

		/* choose image link */
		jQuery(".image_translation_link").click(function() {
			jQuery("#choose_image_helper").text(jQuery(this).attr('id'));
			jQuery("#img_gallery_search_translation").click();
			jQuery(".img_modal_title_text").html("Image Search");
			return false;
		});

		/* remove image translation*/
		jQuery('div.hidden_images_cont')
				.delegate(
						'.image_translation_remove_link',
						'click',
						function() {
							var idArr = jQuery(this).attr('id').split('--');
							var translatedDivId = idArr[0] + '--' + idArr[1]
									+ '--defaultImageChild';
							jQuery('#' + translatedDivId).remove();
							var useDefaultImage = '<span id="'+idArr[0]+'--'+idArr[1]+'--use_current_checkboxspan" ><input type="checkbox" id="'+idArr[0]+'--'+idArr[1]+'--use_current_checkbox" class="tr_use_this_1image" value="" name="tr_use_this_1image" /> Use Current Image<br /></span>';
							var right_links_div = idArr[0] + '--' + idArr[1]
									+ '--select_trans_img_link';
							jQuery('#' + right_links_div).prepend(
									useDefaultImage);
							jQuery(this).remove();
							return false;
						});
		jQuery('.trans_text').change(function()
		{
			transmodified = true;
		});
		
	});
	jQuery( "#transForm" ).validate({
		rules: {
			field: {
				required: true,
				url: true
			}
		}
	});	

	function refreshTranslations() {
		location.reload();
	}