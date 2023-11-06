
jQuery("#"+portletNamepsace+"name").bind("keyup",function() {
		checkFieldValues();
	});
jQuery("#"+portletNamepsace+"file").bind("keyup",function() {
		checkFieldValues();
	});
function checkFieldValues() {

	var fileName = jQuery("#"+portletNamepsace+"name").val();
	var filePath = jQuery("#"+portletNamepsace+"file").val();
	var igImageCMD = jQuery("#"+portletNamepsace+"COMMAND").val();
	if((igImageCMD != null && igImageCMD != '' && igImageCMD != ' ' && igImageCMD == 'EDIT_IMAGE') && (filePath == null || filePath == '' || filePath == ' ')) {
			filePath = fileName;
	}

	if ((fileName != '' && fileName != ' ' && fileName != null) && (filePath != '' && filePath != ' ' && filePath != null)) {		
		jQuery("#addUpdateImage").closest("span[class='aui-button aui-button-submit aui-button-disabled']").removeClass('aui-button-disabled');
		jQuery("#addUpdateImage").removeAttr('disabled');
	} else {
		jQuery("#addUpdateImage").closest("span[class='aui-button aui-button-submit']").addClass('aui-button-disabled');
		jQuery("#addUpdateImage").attr('disabled', 'disabled');
	}
}

function checkAllFields(uploadedFile) {
	checkFieldValues();
}
