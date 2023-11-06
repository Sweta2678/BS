
function getExtension(filename) {
    var parts = filename.split('.');
    return parts[parts.length - 1];
}

function isImage(filename) {
    var ext = getExtension(filename);
    switch (ext.toLowerCase()) {
    case 'jpg':
    case 'gif':
    case 'bmp':
    case 'png':
        return true;
    }
    return false;
}

function isVideo(filename) {
    var ext = getExtension(filename);
    if (ext.toLowerCase() != 'mp4') {
        return false;
    }
    return true;
}

function validate() {
	var title = document.getElementById('ss-title').value;
	var content = document.getElementById('ss-story-text').value;
	
	if(title == 'undefined' || title == 'null' || title == '' ) {
		document.getElementById("errorDiv").style.display = 'block';
		document.getElementById("storyMessage").style.display = 'none';
		document.getElementById("storyImage").style.display = 'none';
		document.getElementById("storyVideo").style.display = 'none';
		document.getElementById("storyName").style.display = 'block';
		return false;
	} else if(content == 'undefined' || content == 'null' || content == '' ) {
		document.getElementById("errorDiv").style.display = 'block';
		document.getElementById("storyName").style.display = 'none';
		document.getElementById("storyImage").style.display = 'none';
		document.getElementById("storyVideo").style.display = 'none';
		document.getElementById("storyMessage").style.display = 'block';
		return false;
	}
	var image = document.getElementById('uploadFile').value;
	
	if (image == null || image == '' || !isImage(image)) {
		document.getElementById("errorDiv").style.display = 'block';
		document.getElementById("storyMessage").style.display = 'none';
		document.getElementById("storyName").style.display = 'none';
		document.getElementById("storyImage").style.display = 'none';
		document.getElementById("storyVideo").style.display = 'none';
		document.getElementById("storyImage").style.display = 'block';
		return false;
	}
	
	var video = document.getElementById('ss-video').value;
	
	if ((video != null && video != '') && !isVideo(video)) {
		document.getElementById("errorDiv").style.display = 'block';
		document.getElementById("storyMessage").style.display = 'none';
		document.getElementById("storyName").style.display = 'none';
		document.getElementById("storyImage").style.display = 'none';
		document.getElementById("storyVideo").style.display = 'block';
		return false;
	}
	return true;
}

jQuery(document).ready(function()
		{	
			jQuery('#ss-first-name').attr('value',firstName);
			jQuery('#ss-last-name').attr('value',lastName);
			jQuery('#ss-holidex').attr('value',userHotelCode);
});
