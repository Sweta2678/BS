/* Overlay Teamspace: Going maps Overlay*/
jQuery(function ($) {
	// Load dialog on page load
	//$('#basic-modal-content').modal();

	// Load dialog on click
	$('#overlay-modal .over-link').click(function (e) {
		$('#ts-overlay-content').modal();

		return false;
	});
	
	$('.overlay-modal .over-link').click(function (e) {
		$('#ts-overlay-content').modal();

		return false;
	});
});


