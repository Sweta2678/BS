function showPopup(id){
		//Get the A tag
	if(id == null || id == ''){
		id = '#popup';
	}
	
		//Get the screen height and width
		var maskHeight = $(document).height();
		var maskWidth = $(window).width();
	
		//Set height and width to mask to fill up the whole screen
		$('body').append('<div id="mask"></div>');
		$('#mask').css({'width':maskWidth,'height':maskHeight});
		
		//transition effect		
		$('#mask').fadeTo("slow",0.3);	
	
		//Get the window height and width
		var winH = $(window).height();
		var winW = $(window).width();
              
		var popupH = $(id).height();
		var popupW = $(id).width();
		
		var top = 5, left = 5;
		//Set the popup window to center
		if(winH > popupH ){
			top = winH/2-$(id).height()/2;
		}
		if(winW > popupW){
			left = winW/2-$(id).width()/2;
		}
		$(id).css('top', top);
		$(id).css('left', left);
	
		//transition effect
		$(id).fadeIn(500); 
}

function hidePopup(){
	$('.window').hide();
	$('#mask').remove();
	removePopupContent();
}

function setPopupContent(content){
	$('#popupContent').html(content);
}

function removePopupContent(){
	$('#popupContent').empty();
}

function setPopupHeight(height, id){
	if(id == null || id == ''){
		id = '#popup';
	}
	$(id).height(height);
}

function setPopupWidth(width, id){
	if(id == null || id == ''){
		id = '#popup';
	}
	$(id).width(width);
}

function setPopupDimentions(height, width, id){
	if(id == null || id == ''){
		id = '#popup';
	}
	
	if(height != null && height != 'undefined'){
		$(id).height(height);
	}
	
	if(width != null && width != 'undefined'){
		$(id).width(width);
	}
}
$(document).ready(function() {	
	//if close button is clicked
	$('.window .close').click(function (e) {
		//Cancel the link behavior
		e.preventDefault();
		$('.window').hide();
		$('#mask').remove();
	});		
	
	//if mask is clicked
	$('body').on('click', '#mask', function () {
        $(this).remove();
        $('.window').hide();
    }); 
	
	
});


function alertsize(height, width){
//	alert('Adjust Popup size height:'+ height + 'px , width:'+ width +'px');
	setPopupDimentions(height, width);
	setFrameDimentions('#tccFrame',height, width);
	
	var id = '#popup';
	//Get the window height and width
	var winH = $(window).height();
	var winW = $(window).width();
          
	var popupH = $(id).height();
	var popupW = $(id).width();
	
	var top = 5, left = 5;
	//Set the popup window to center
	if(winH > popupH ){
		top = winH/2-$(id).height()/2;
	}
	if(winW > popupW){
		left = winW/2-$(id).width()/2;
	}
	$(id).css('top', top);
	$(id).css('left', left);
	
}

function setFrameDimentions(frameId, height, width){
	$(frameId).height(height);
	$(frameId).width(width);
}
