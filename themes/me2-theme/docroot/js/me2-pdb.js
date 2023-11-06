/**
 * @author sanketh.iyer
 */

/**
 * @param pathImage
 * @param dynamicId
 * @param userId
 * @return
 * 
 * Used to open a tool-tip to display User Information
 */
function showUserProfile(userId, dynamicId, pathImage, editPortraitURL, isLoggedInUser) {
		
	// Initially closing the existing pop-ups
	var userDivWrapper = ".people-db-popup"; 
	
	if (jQuery(userDivWrapper).length){
	    jQuery(userDivWrapper).empty();
	}
	/*if (jQuery.browser.msie && parseInt($.browser.version) ===7 ) {
		jQuery('.portlet-borderless-container').css('position', 'static');
		}*/
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
	            },
	            error: function() {
	            	console.log('failed to display the links');
	    		}
	}); 
}
jQuery(function(){
	
	/*if (!jQuery.browser.msie) {
		var env = $$.environment();
		if (env.isMobile) {
			$$("body").on("tap", function() {
												
				if (jQuery(".contact_box").length){
					jQuery('.people-db-popup').empty();
				}
				
			});
		}
	}*/
	jQuery('body').mouseup(function(e) {
					var $targ = $(e.target);
					if($targ.closest(".people-db-popup").length) return false;
					jQuery('.people-db-popup').empty();
			});
	/*jQuery("body").on("click", function(){
		
		if (navigator.userAgent.msie && parseInt(navigator.userAgentr.version) ===7 ) {
			jQuery('.portlet-borderless-container').css('position', 'relative');
			}
	});*/
	jQuery(document).on('click','.contact_box .closeIcon',function(){
			jQuery(this).parent().remove();
		});
});

/**
 * Used to close the user info tool-tip
 * 
 * @param dynamicId
 */
function closeUserProfile(dynamicId) {
	var userDivWrapperStr = ".userProfileDiv" + dynamicId; 
	jQuery(userDivWrapperStr).empty();
	
	
}

 