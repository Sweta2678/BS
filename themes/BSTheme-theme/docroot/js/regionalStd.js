var formSbmtMsg = "The form submitted successfully.";
var goto_url = "/web/brand-standards/standards";
var allowSbmt = true;


/* Multi*/
jQuery(document).ready(function(){

   jQuery(".multis").multiselect();
   jQuery("#manual_type").multiselect("checkAll");
});
/* End Multi*/


/* On doc load all processing*/
jQuery(function(){

	jQuery("#new_standard_form").formwizard({ 

		formPluginEnabled: true,

		historyEnabled : true,

		validationEnabled: true,

		validationOptions : {
			rules: {

				required: true

			},
			messages: {
			},
            ignore: ":hidden:not('#manuals_brand,  #manual_type,')" /*Tells it to check the jqueryUI multi-select*/
		},

		focusFirstInput : true,

		formOptions :{

			success: function(data){
			
				jQuery('#cmt_modalwindow_fade, .comments_modalwindow_block').fadeOut(function() {
		        	jQuery('#cmt_modalwindow_fade, a.comments_modalwindow_close').remove();  /*fade them both out*/
		   		});
				
				if(data==formSbmtMsg)
                {
					alert(data);
                    window.location.href = goto_url + window.location.search;
                 
                }
                else
                {
                    alert(data);
                }
			},

			beforeSerialize : function (){
				
				var commentsVal=jQuery("#cmt_txt_area").val();
				jQuery("#hidden_comment").val(commentsVal);
				
				if(commentsVal.length > 0)
		         {
					jQuery('#cmt_modalwindow_fade, .comments_modalwindow_block').fadeOut(function() {
			        	jQuery('#cmt_modalwindow_fade, a.comments_modalwindow_close').remove();  /*fade them both out*/
			   		});
			     }
				 else
		         {
		             alert("Please enter comments.");
	                 return false;
		         }
				
				
				/* update hidden hidden_manual_references varible*/
                var referencesArray = new Array();
                jQuery('table#reg_references tr.table_links_list').children('td.this_link').each(function(){
                    var reference = jQuery(this).children('input').val();
                    referencesArray.push(reference + "~~");
                });
                jQuery("#hidden_manual_references").val(referencesArray);
                
				return allowSbmt;
			},

			resetForm: false

		},				

		disableInputFields: true

	 }

	);
   
	/*add manual reference into table*/
	jQuery('.add_reference').click(function(){
		
        var theManual = jQuery("select#brand_manual option:selected");
        var manual = theManual.val(); 
        var manualText = theManual.text();
        var title = jQuery("input#title_code_page").val();
        
        if( manual != "" && title != ""){
            var stdManualId = 0;
            var regionArray = theManual.attr("region");
            var brandArray = theManual.attr("brand");
            var manualId = theManual.attr("id");
            var changeType = jQuery("#change_type>option:selected").val();
            var changeTypeText = jQuery("#change_type>option:selected").text();
        
            jQuery("table#reg_references").append('<tr class="table_links_list"><td style="display:none;" class="standard_file_type_td this_link">' + stdManualId + ' <input type="hidden" value="~~~id:' + stdManualId + '"/></td><td style="display:none;" class="standard_file_type_td this_link">' + manualId + ' <input type="hidden" value="' + manualId + '"/></td><td class="standard_file_type_td this_link">'+ brandArray + '<input type="hidden" value="' + brandArray + '"/></td><td class="standard_file_type_td this_link">'+ regionArray + '<input type="hidden" id="region_0" value="' + regionArray + '"/></td><td class="standard_file_type_td this_link">'+ changeTypeText + '<input type="hidden" value="' + changeType + '"/></td><td class="standard_file_type_td this_link">'+ manualText + '<input type="hidden" value="' + manual + '"/></td><td class="standard_file_type_td this_link">'+ title + '<input type="hidden" value="' + title + '"/></td><td><img class="delete_manual_reference" src="/BSTheme-theme/images/delete.png" /></td></tr>');
            jQuery("#title_code_page").val("");
        } else {
            alert("Both a 'Brand Manual' and 'Standard Title / Code / Page & Paragraph' are required.");
        }
        
        return false;
	
	});

    /* Delete manual reference*/ 
    var urlDelArray = new Array();
    jQuery("table").delegate("tr td img.delete_manual_reference", "click", function(event){
    	
    	var theId = jQuery(this).parent('td').parent('tr').children().children('input').val();
    	var value;
        var indx;
        var id;
        
    	if(theId.length > 6 && theId.substring(0, 6) === "~~~id:") {
    		theId = theId.split('~~~id:')[1];
    		id='region_'+theId;
    		value=document.getElementById(id).value;
    	}
    	 if(id!="region_0")
         { 
    		 if(value=="false"){
             	alert("You can not delete a reference entered by another region.");
         	    return false;
             }
         }
    	
    	var answer = confirm("Are you sure you want to delete this?");
        if (answer){
                urlDelArray.push(theId);
                if(theId > 0) {
                    jQuery("#hidden_del_manual_references").val(urlDelArray);
                }
            jQuery(this).parent('td').parent('tr').remove();

            /* update hidden hidden_manual_references varible*/
            var referencesArray = new Array();
            jQuery('table#reg_references tr.table_links_list').children('td.this_link').each(function(){
                var reference = jQuery(this).children('input').val();
                referencesArray.push(reference + "~~");
            });
            jQuery("#hidden_manual_references").val(referencesArray);
        }
        return false;
    });
	
	
    jQuery("select#brand_manual").change(function(){
        var thisValue = jQuery(this).val();
        
        jQuery("#change_type>option:selected").removeAttr("selected");
        jQuery("#change_type option").each(function() {
            if(jQuery(this).val() == "NEW")
            {
                jQuery(this).attr('selected', 'selected');
                return false;
            }
        });
	});
    
    
	jQuery(".filter_contents").click(function(){
		var brandArray = jQuery("select#manuals_brand").multiselect("getChecked").map(function(){
           return this.value;	
        }).get().toString();
        var regionsArray = jQuery("#hidden_regions").val();
        var manualTypeArray = jQuery("select#manual_type").multiselect("getChecked").map(function(){
           return this.value;	
        }).get().toString();

        var url = jQuery("#historical_manual_url").val();
        jQuery.post(url, {brandArray:brandArray, regionsArray:regionsArray, manualTypeArray:manualTypeArray}, function(data){

            if(data.message == "Success") {
            
                delete data["message"];
                var recordCnt = data.recordCnt;
                delete data["recordCnt"];
                
                if(showAlert)
                {
                alert("Search returned " + recordCnt + " records");
                }
                showAlert=true; 
                /*clear previous values*/
                jQuery("select#brand_manual").empty().append('<option value="">Select</option>');
                
                var theSelect = jQuery('select#brand_manual');
                jQuery.each(data, function(id, obj) {
                    theSelect.append(
                        jQuery('<option></option>').attr("id", id).attr("region", obj.region).attr("brand", obj.brand).val(obj.type).html(obj.title)
                    );
                });
            } else if(data.message == "Search failed") {
                alert("Error occur during search");
            } else {
            	 if(showAlert)
                 {
                   alert("There are no historical manuals for this brand / regional / Manual Type combination.  Please change your selection or contact your local administrator and request that the manual is uploaded to the CMS.");
                 }
            	 showAlert=true; 
            }
        }, "json");    
		return false; /*do not refresh the page with default click behavior - return false instead;*/
	});
	
 });
