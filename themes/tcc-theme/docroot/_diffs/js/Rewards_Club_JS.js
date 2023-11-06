function timeout_trigger() {
		$(".rewardsClub_Box_BG").fadeOut("fast");
	}
	
$(document).ready(function() {
	$(".rewardsClub_Box_BG").css('display', 'block');
	//$(".rewardsClub_Box_BG").delay(10000).hide(400);
	timeout = setTimeout('timeout_trigger()', 10000);
	//clearTimeout(timeout);
	

	$(document).click(function(e){
		clearTimeout(timeout);
		var ihgClub_Box = $("#ihgrClub_Link");

		if (!ihgClub_Box.is(e.target) // if the target of the click isn't the container...
		 && ihgClub_Box.has(e.target).length === 0) // ... nor a descendant of the container
		{
			$(".rewardsClub_Box_BG").fadeOut("fast");
		}

	});

});