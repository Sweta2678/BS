jQuery("#folderName").bind("keyup",function() {
		checkFolderName();
	});
function checkFolderName() {

var folderName = jQuery("#folderName").val();
if (folderName != '' && folderName != ' ' && folderName != null) {		
		jQuery("#addUpdateImage").closest("span[class='aui-button aui-button-submit aui-button-disabled']").removeClass('aui-button-disabled');
		jQuery("#addUpdateImage").removeAttr('disabled');
	} else {
		jQuery("#addUpdateImage").closest("span[class='aui-button aui-button-submit']").addClass('aui-button-disabled');
		jQuery("#addUpdateImage").attr('disabled', 'disabled');
	}
}
