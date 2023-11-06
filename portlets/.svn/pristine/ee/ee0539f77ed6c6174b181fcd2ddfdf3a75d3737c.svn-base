function startNewThread(portletNamespace, startThreadURL, tsName) {
	
	var editorTextArea = document.getElementById(portletNamespace+"myThreadBody");
	console.log('editorTextArea'+editorTextArea);
	var editorTextAreaValue = editorTextArea.value;
	console.log('editorTextAreaValue'+editorTextAreaValue);

	var threadSubject = document.getElementById(portletNamespace+"add-subject-box");
	console.log('threadSubject'+threadSubject);
	var threadSubjectValue = threadSubject.value;
	console.log('threadSubject'+threadSubjectValue);

	if (editorTextAreaValue.length > 0 && editorTextAreaValue.indexOf("Type message") == -1 && threadSubjectValue.length  > 0) 
	{	
		setTimeout(function() {
		var startThreadFormName = portletNamespace + 'newDiscussion';
		var formObj = document.getElementById(startThreadFormName);
		if (formObj != null) {
			formObj.action = startThreadURL;
			formObj.submit();
		} else {
			console.log("startThread form not found");
		}}
				
				, 150);
			
	} else {
		
		if(threadSubjectValue == 'undefined' || threadSubjectValue == 'null' || threadSubjectValue == ''){
			ErrorMessage.showError("#"+portletNamespace+"add-subject-box","Please enter subject.");
			jQuery("#"+portletNamespace+"add-subject-box").focus();
		}else{
			ErrorMessage.hideError("#"+portletNamespace+"add-subject-box");
		}
		
		if(editorTextAreaValue == 'undefined' || editorTextAreaValue == 'null' || editorTextAreaValue == ''){
			ErrorMessage.showError("#"+portletNamespace+"myThreadBody","Please enter message.");
			jQuery("#"+portletNamespace+"myThreadBody").focus();
		}else{
			ErrorMessage.hideError("#"+portletNamespace+"myThreadBody");
		}
			return false;
	}
	return true;
}

function resetForm(redirectURL) {
	window.location.href = redirectURL;
}

function showUserProfile(userId, dynamicId, pathImage, editPortraitURL, isLoggedInUser, currentObj) {
	
	// Initially closing the existing pop-ups
	var userDivWrapper = ".people-db-popup"; 
	
	if (jQuery(userDivWrapper).length){
	    jQuery(userDivWrapper).empty();
	}
	if (jQuery.browser.msie && parseInt($.browser.version) === 7 ) {
		jQuery('.portlet-borderless-container').css('position', 'static');
	}
	var userDivWrapperStr = ".userProfileDiv" + dynamicId;
	jQuery.ajax({
   	 			url: '/me2-pdb-portlet/servlet/get-peopledb',
	        	type: "POST",
	        	async: 'true',
	        	dataType: "html",
	        	data: {
	        		userId: userId,
	        		pathImage: pathImage,
	        		editPortraitURL: editPortraitURL,
	        		isLoggedInUser: isLoggedInUser
	      		},
	        	success: function(data) {
					
					jQuery(data).appendTo(userDivWrapperStr);
					
					var figureOffset = jQuery(currentObj).parent().offset();
					jQuery('#discussion_profile .contact_box').offset({ top: figureOffset.top, left: figureOffset.left})
					jQuery('#dept-tabcontent').css('position', 'static');
					
					jQuery("body").on("click", function(){
						if (jQuery.browser.msie && parseInt($.browser.version) === 7 ) {
							jQuery('.portlet-borderless-container').css('position', 'relative');
						}
					});
					jQuery('body').mouseup(function(e) {
						var $targ = $(e.target);
						if($targ.closest(".people-db-popup").length) return false;
						jQuery('.people-db-popup').empty();
					});
					jQuery('.contact_box .closeIcon').on('click',function(){
						jQuery(this).parent().remove();
					});
	            },
	            error: function() {
	            	console.log('failed to display the links');
	    		}
	}); 
}
