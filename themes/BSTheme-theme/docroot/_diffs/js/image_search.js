
function duplicateImage(imgId)
{
    var duplicate = false;
    
    jQuery('table#search_assign_images tr.table_links_list').children('td.this_link').each(function(){
        var value = jQuery(this).children('input').val();
        if ( value.search("imgId:") > -1 ) 
        {
            var curId = jQuery(this).text();
            if (curId == imgId )
            {
                duplicate = true;
                return false;
            }
        }
    });

    return duplicate;
}

/* On doc load all processing*/
jQuery(function(){

    /*add Assign Image into table*/
    jQuery(".add_selected_image").click(function(){

        var imgId = jQuery(this).find(".image_id").attr("value");
        var smallImgId = jQuery(this).find(".small_image_id").text();
        var imgTitle = jQuery(this).find(".image-title").text();
        var imgDate = jQuery(this).find(".image_date").attr("value");
        var imgAuthor = jQuery(this).find(".image_author").attr("value");
        var imgDesc = jQuery(this).find(".image_desc").text();
        var imgUuId = jQuery(this).find(".image_uuid").text();
        var imgGroupId = jQuery(this).find(".image_groupid").text();
		var stdCount = jQuery(this).find(".image_std_cnt").text();
		var specCount = jQuery(this).find(".image_spec_cnt").text();
		var gdlnCount = jQuery(this).find(".image_gdln_cnt").text();
        var duplicate = duplicateImage(imgId);
        if( !duplicate ) {
            jQuery("table#search_assign_images").append('<tr class="table_links_list">' + 
                                                 '<td style="display:none;" class="search_img_td this_link">' + imgId + '<input type="hidden" value="imgId:' + imgId + '"/></td>' +
                                                 '<td style="display:none;" class="search_img_td this_link">' + imgAuthor + '<input type="hidden" value="author:' + imgAuthor + '"/></td>' +
                                                 '<td style="display:none;" class="search_img_td this_link">' + imgDate + '<input type="hidden" value="date:' + imgDate + '"/></td>' +
                                                 '<td style="display:none;" class="search_img_td this_link">' + imgDesc + '<input type="hidden" value="desc:' + imgDesc + '"/></td>' +
                                                 '<td style="display:none;" class="search_img_td this_link">' + imgUuId + '<input type="hidden" value="uuid:' + imgUuId + '"/></td>' +
												 '<td style="display:none;" class="search_img_td this_link">' + stdCount + '<input type="hidden" value="stdCount:' + stdCount + '"/></td>' +
												 '<td style="display:none;" class="search_img_td this_link">' + specCount + '<input type="hidden" value="specCount:' + specCount + '"/></td>' +
												 '<td style="display:none;" class="search_img_td this_link">' + gdlnCount + '<input type="hidden" value="gdlnCount:' + gdlnCount + '"/></td>' +
                                                 '<td style="display:none;" class="search_img_td this_link">' + imgGroupId + '<input type="hidden" value="group:' + imgGroupId + '"/></td>' +
                                                 '<td style="display:none;" class="search_img_td this_link">' + smallImgId + '<input type="hidden" value="smallId:' + smallImgId + '"/></td>' +
                                                 '<td class="search_img_td this_link">'+ imgTitle +'<input type="hidden" value="title:' + imgTitle + '"/></td>' +
                                                 '<td><img class="delete_search_image" title="delete" src="/BSTheme-theme/images/delete.png" alt="delete"/></td>' + 
                                                 '<td style="display:none;"><input type="hidden" class="search_img" value="#' + this.id + '"/></td>' + 
                                                 '</tr>');
            jQuery(this).css("border-color", "#FF0000");
			if(jQuery(this).hasClass('translated_image')) {
				parent.addAssignedImageTranslate(jQuery('table#search_assign_images tr.table_links_list'));
				parent.jQuery.nmTop().close();
			}
        } else {
            jQuery.msgBox({
                title:"Error!",
                content:"The image already selected.",
                type:"error"
            });
        }
        return false;
    });

    /* Delete Selected Image*/
    jQuery("table").delegate("tr td img.delete_search_image", "click", function(event){
    
            var thisItem = this;
            jQuery.msgBox({
            title:"Are You Sure",
            content:"Are you sure you want to delete selected image?" ,
            type:"confirm",
            buttons: [{ value: "Yes" }, { value: "No" }],
            success: function (result) {
                if (result == "Yes") {
                    try {
                        var image = jQuery(thisItem).parent('td').parent('tr').find("input.search_img").val();
                        jQuery(image).css("border-color", "#A9A9A9"); 
                    } catch (exception) {
                        ;
                    }
                    jQuery(thisItem).parent('td').parent('tr').remove();
                }
            }
        });
        return false;
    });

    jQuery("#img_assign_accept").click(function(){
        parent.addAssignedImage(jQuery('table#search_assign_images tr.table_links_list'));
        parent.jQuery.nmTop().close();
    });
	jQuery("#img_assign_accept_translate").click(function(){
        parent.addAssignedImageTranslate(jQuery('table#search_assign_images tr.table_links_list'));
        parent.jQuery.nmTop().close();
    });
	
});

