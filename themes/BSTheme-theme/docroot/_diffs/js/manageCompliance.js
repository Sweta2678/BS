var backupHTML;
$(function() {
	
	backupHTML = jQuery('.comp_hidden').html();
	bindComplianceEvents();
	
});
function bindComplianceEvents()
{
	jQuery(".comp_regional").click(function(){
		/*show the hidden regional compliance sections*/
		$(this).parent().parent().parent("tr").next("tr").show();
	});	
	jQuery(".comp_reg_cancel").click(function(){
		$(this).parents('.comp_hidden').hide();
		jQuery('.comp_hidden').html(backupHTML);
		bindComplianceEvents();
	});
	
	
	/* compliance table first td should have text align left*/
	
	jQuery("#compliance_table tr td:first-child").css("text-align","left");
	
	/*tooltip call*/
	jQuery( ".expire_id" ).tooltip();

	jQuery("#SearchStd").click(
		function()
		{
			searchExprieAction();
		}
	);
	$('#crs_std_id').on("keypress", function(e) {
        if (e.keyCode == 13) {
            searchExprieAction();
            return false;
        }
	});
}
function searchExprieAction(){
	var searchStdId = jQuery("#crs_std_id").val();

	var inData = {searchStdId:searchStdId};
	jQuery.ajax({
		type: "POST",
		url: searchExpireURL,
		data: inData,
		datatype: "json",
	}).done(function(data){
		if(!jQuery.isEmptyObject(data)){
			var html = '<div class="expire_search_items"><p>'+data.stdType+': <span class="cross_search_id">'+searchStdId+'</span></p><p class="cross_search_text">'+data.stdTitle+'</p></div><input type="button" id="addButton" value="Add Expiry" onclick="addReference('+searchStdId+',\''+data.stdType+'\',\''+escape(data.stdTitle)+'\')">';
			jQuery("#resultSearchDiv").show();
			jQuery("#results").html(html);
		}else{
			jQuery("#resultSearchDiv").show();
			jQuery("#results").html('<div class="expire_search_items">No Record Found</div>');
		}
		
	}).fail(function(jqXHR, textStatus){
		alert("AJAX request failed with status:" + textStatus);
	});
}
function deleteRecord(stdId){
	var isDeleted = false;
	jQuery('#searchedContentTable #'+stdId).remove();
	return false;
}
function addReference(searchStdId,type,title){
	var validmsg = validExpiryMsg(searchStdId)
	if(validmsg!='valid')
	{
		jQuery.msgBox({
			title: "Error!",
		    content: validmsg,
		    type: "error"
	    });
		return false;
	}
	var actualTitle = unescape(title);
	var htmlTr = '<tr id='+searchStdId+' class="expiryRow"><td>'+searchStdId+'</td><td>'+type+'</td><td>'+actualTitle+'</td><td><a class="delete_cross_item"><img style="cursor:pointer;" src="/BSTheme-theme/images/delete.png" alt="delete" title="delete" onclick="deleteRecord('+searchStdId+')"/></a></td></tr>';
	var refObject = new Object();
	var isDeleted = false;
	jQuery('#myreferences').show();
	jQuery('#searchedContentTable tbody').append(htmlTr);
	
}

function validExpiryMsg(searchStdId)
{
	var existExpireIds = [];
	var currentBrand = jQuery('#brandEdit').val();
	jQuery('.expiryRow').each(function()
	{
		existExpireIds.push(jQuery(this).attr('id'));
	}
	);
	var inData = {searchStdId:searchStdId, existExpireIds:existExpireIds,currentBrand:currentBrand};
	var returnmsg = 'invalid';
	jQuery.ajax({
		type: "POST",
		url: validateExpiryURL,
		data: inData,
		async: false
	}).done(function(data){
		returnmsg = data;
	}).fail(function(jqXHR, textStatus){
		alert("AJAX request failed with status:" + textStatus);
	});
	return returnmsg;
}

function isNumberKey(evt){
    var charCode = (evt.which) ? evt.which : event.keyCode
    if (charCode > 31 && (charCode < 48 || charCode > 57))
        return false;
    return true;
}

function validateComplianceForm()
{
	if(jQuery('#complianceComment').val() == '')
	{
		jQuery.msgBox({
			title: "Error!",
		    content: "Please enter a comment",
		    type: "error"
	    });
		return false;
	}
	var existExpireIds = [];
	jQuery('.expiryRow').each(function()
	{
		existExpireIds.push(jQuery(this).attr('id'));
	}
	);
	jQuery('#expireIds').val(existExpireIds);
	jQuery('#complianceForm').submit();
}
