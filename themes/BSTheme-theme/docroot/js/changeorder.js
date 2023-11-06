var nodeId = '';
var nodeText = '';

function initDragNDrop(tableId)
{
	jQuery(tableId).tableDnD({
			onDragClass: "assignImgDrag",
			onDrop: function(table, row) {
			   jQuery("#copyBtn").hide();
			},
			onDragStart: function(table, row) {
			}
	});
	return false;
		
}
function processIds(tableId, hiddenFldId)
{
	var strStndIds ="";
	var rowCount = 0;
	var addComma = false;
	jQuery(tableId+" tr").each(function() {
		if(rowCount>0)
		{
			var standId = jQuery(this).find("td:first").text();    
			if(addComma && standId != ''){
				strStndIds = strStndIds + "," + standId;
			} else if(standId != ''){
				strStndIds = strStndIds + standId;
				addComma = true;
			}
		}
		rowCount++;
	});
	jQuery(hiddenFldId).val(strStndIds);
}

function callAjax(theUrl, divname, inData)
{
	jQuery.ajax({
        type: "POST",
        url: theUrl,
        data: inData
    }).done( function(data) {
         jQuery(divname).html(data);
    }).fail( function(jqXHR, textStatus) {
        alert("AJAX request failed with status:" + textStatus);
    }); 
}

function getTreeData(theUrl, callStd)
{
	jQuery("#Taxonomy").jstree("close_all",-1);
	
	jQuery("#Taxonomy").jstree({  
		"types" :{
			"max_depth": 4
		},
		"xml_data" : {
            "ajax" : {
            	"type" : "POST",
                "url" : theUrl, 
                "async": false,
                "cache": false,
                "data" : function (n) {
                		      return {
                		      	 action : "xmlTaxonomy"
                		      };
                           }
            },
            "xsl" : "nest"
        },
        "plugins" : [ "themes", "xml_data","ui"],
        "ui" : {
            "select_multiple_modifier" : "false",
             "select_limit" : 1
         },
         "themes" : {
        	 "icons" : false
         },
         "core" : { "initially_open" : [ "1" ] } 
	}) 
	.delegate(".tree_node", "click", function (event, data) {
		
		nodeId = jQuery(this).parent().attr("id");
		nodeText = jQuery(this).text();
		jQuery("#taxonomyId").val(nodeId);
		jQuery(".selected_tree_node").text(nodeText);
		jQuery('.close_page').show();
		
	}) 
	.bind("loaded.jstree", function(e,data) {
 	    jQuery("ul:contains('Root Of Tree')").css('position','relative');
		jQuery("ul:contains('Root Of Tree')").css('top','-20px');
		jQuery("ul:contains('Root Of Tree')").css('left','-20px');
 		  
 		jQuery("a:contains('Root Of Tree')").css("visibility","hidden");
 		jQuery(".jstree-last .jstree-icon").first().hide();
 		jQuery(".tree_item").first().hide();
 		/*End Hiding root node*/ 
 	    });
	
	jQuery('.close_page').click(function(){
		jQuery("#tree_selection").val(nodeText);
		if(callStd && nodeId!='') {
			getStandards(nodeId);
		}
		jQuery(".nyroModalClose").click(); 
	});
}



function getStandards(indexId)
{
	var selectedBrand  = $("#brandList").val();
    var theUrl = getStandardURL;
    var divname = "#standards_div";
    var inData = {indexId:indexId, selectedBrand:selectedBrand};
	callAjax(theUrl, divname, inData);
}

/*function loadStandardsOrdering(theUrl)
{
  
    jQuery('.nyroModal').nyroModal({closeOnClick: false});
    
    jQuery('.open_tree_selection').click(function(){
		jQuery('#p_p_id_ChangeOrder_WAR_BSAdminportlet_ .portlet-msg-success').hide();
        nodeId = '';
        nodeText = '';
        jQuery(".selected_tree_node").text('nothing yet'); 
        jQuery("#taxonomy_tree_details").click();
        jQuery('.modal_title_text').html("description");
        getTreeData(theUrl, true);
        return false;
    });
}*/

function loadStandardsOrdering(theUrl)
{
  
    jQuery('.nyroModal').nyroModal({closeOnClick: false});
    
    jQuery('.open_tree_selection').click(function(){
		var stdIdsOrder = getStandardIdsOrder('#ordering_table', '#std_ids');
		if(stdIdsOrder == originalStandardIdsOrder) {
			jQuery('#p_p_id_ChangeOrder_WAR_BSAdminportlet_ .portlet-msg-success').hide();
			nodeId = '';
			nodeText = '';
			jQuery(".selected_tree_node").text('nothing yet'); 
			jQuery("#taxonomy_tree_details").click();
			jQuery('.modal_title_text').html("description");
			getTreeData(theUrl, true);
			return false;
		} else {
			/*alert("loadStandardsOrdering"+originalStandardIdsOrder+"==="+stdIdsOrder);*/			
			jQuery.msgBox({
				title: "Are You Sure",
				content: "You want to ignore changes?",
				type: "confirm",
				buttons: [{ value: "Yes" }, { value: "No" }],
				success: function (importConfirmation) {
					if (importConfirmation == "Yes") {
						jQuery('#p_p_id_ChangeOrder_WAR_BSAdminportlet_ .portlet-msg-success').hide();
						nodeId = '';
						nodeText = '';
						jQuery(".selected_tree_node").text('nothing yet'); 
						jQuery("#taxonomy_tree_details").click();
						jQuery('.modal_title_text').html("description");
						getTreeData(theUrl, true);
						return false;
					} else{
						return false;
					}
				}
			});
		}
    });
}

function getStandardIdsOrder(tableId, hiddenFldId)
{
	var strStndIds = "";
	var rowCount = 0;
	var addComma = false;
	jQuery(tableId+" tr").each(function() {
		if(rowCount > 0)
		{
			var standId = jQuery(this).find("td:first").text();
			if(addComma && standId != ''){
				strStndIds = strStndIds + "," + standId;
			} else if(standId != ''){
				strStndIds = strStndIds + standId;
				addComma = true;
			}
		}
		rowCount++;
	});
	return strStndIds;
}
/* CR 29-2 changes 
function filterByBrand()
{
	var selectedBrand  = $("#brandList").val();
	var indexId = $("#taxonomyId").val();
	var divname = "#standards_div";
	if((indexId != null && indexId != "") && selectedBrand != null)
	{
		var inData = {indexId:indexId, selectedBrand:selectedBrand};
		callAjax(getFilterURL, divname, inData);
	}
}*/

function checkUserBrand(usrPrefChainCode)
{
	if(usrPrefChainCode == 'GL')
	{
		jQuery.msgBox({
			content: "In order to specify Standard Sort order, please select a Brands in Perspective !!",
		});
	}
	return false;
}

/*function copyStdOrders(copyURL)
{

	jQuery("#copy_button").click(function()
	{
	   jQuery(".copyPopupContainer").show();
		var selectedStdIds = getStandardIdsOrder('#ordering_table', '#std_ids');
		if(selectedStdIds == originalStandardIdsOrder) 
		{
		 jQuery('#copyBtn').show();
			jQuery('#copySaveBtn').click(function(){
			 var varBrand = jQuery("#copyBrands").multiselect("getChecked").map(function(){
								return this.value;	
							}).get().toString();
				if(varBrand)
				{
					jQuery.msgBox({
						title:"Are You Sure",
						content:"Are you sure you want to copy Standards order?" ,
						type:"confirm",
						buttons: [{ value: "Yes" }, { value: "No" }],
						success: function (result) {
							if (result == "Yes") {
								//loadProgressBar();
								var varBrand = jQuery("#copyBrands").multiselect("getChecked").map(function(){
									return this.value;	
								}).get().toString();
								var inData = {std_ids:selectedStdIds, brands:varBrand};
								jQuery.ajax({
										type: "POST",
										url: copyURL,
										data: inData
								}).done( function(data) {
										jQuery.msgBox({
											title:"Success",
											content:"Standards order copied successfully.",
											type:"info",
											autoClose: false
										});
								}).fail( function(jqXHR, textStatus) {
										alert("AJAX request failed with status:" + textStatus);
								}); 
								
							}
						}
					});
				}else
				{
					jQuery.msgBox({
						title:"Error!!",
						content:"Please select atleast one brand for copy !!" ,
						type:"error",
					});
				}
				return false;
			});
		}
	});
	jQuery("#cancelBtn").click(function(){
        jQuery(".copyPopupContainer").hide();
    });
}
*/