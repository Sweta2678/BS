if (typeof console == "undefined") { console = { };console.log=function(s) { return true; } };

var browser = "";
function detectBrowser() { 
	if (browser != "") { return browser; }
	if (navigator.userAgent.match(/Firefox/i)) {
		return "firefox";
	} else if (navigator.userAgent.match(/iPhone/i)) {
		return "iphone";
	} else if (navigator.userAgent.match(/iPod/i)) {
		return "ipod";
	} else if (navigator.userAgent.match(/iPad/i)) {
		return "ipad";
	} else if (/MSIE (\d+\.\d+);/.test(navigator.userAgent)) { return Number(RegExp.$1); } else { if (window.devicePixelRatio) { return "safari"; } else { return 0; } } }
	
		
	$(function () {
		$("#postCodeControl").click(function () {
		$(this).toggleClass("active");
		$("#postcodeContainer").toggle(0);
		$("#current-city-postcode").focus();
		return false;
	})
	});
	
//Global Home page tabs
$(function() {
	$("#db_inside-tab div").hide();
	$("#apps").show(); 
	$("#apps div").show();
	
$('#dashboard-tabs a').click(function(e) {
	e.preventDefault();        
	$("#db_inside-tab div").hide(); 
	$("#db_inside-tab div div").show(); 
	 var showCont = $(this).parent('li').attr('id');
	 $("#dashboard-tabs li").removeClass('current');
	 $(this).parent('li').addClass('current');
	 $("."+showCont).show();
	});
});

//drag and drop script
  $(function() {
    $( ".db_sortable" ).sortable();
    $( ".db_sortable" ).disableSelection();
  });
  
  /*secondary links
  $(function(){
	$('nav ul li').click(function(){
		$('ul', $(this)).show();	
	});
	$('body').mouseup(function (e) {
			var $targ = $(e.target);									
			if ($targ.closest('nav ul li ul li').length) return;
			$('nav ul li ul').hide();
		});
})*/


//Carousel script
$(document).ready(function(){                
	 $('.db_cont_slider').tinycarousel({ pager: true }); 
	 $('#db_topmain_slider').tinycarousel({ pager: true });   
	 $('#db_topright_slider').tinycarousel({ pager: true });
	 $('#db_bottom_carousel').tinycarousel({ pager: true });
    });

// set cookie
function setCookie(c_name,value,exsecs)
{
	var exdate=new Date();
	exdate.setTime(exdate.getTime() + (exsecs * 1000));
	var c_value=escape(value) + ((exsecs==null) ? "" : "; expires="+exdate.toUTCString());
	// if it is a secure connection than secure should get added
	if (window.location.protocol == "https:") {
		c_value = c_value +  "; secure";
	}
	//var c_value=escape(value);
	document.cookie=c_name + "=" + c_value;
}

// get cookie
function getCookie(c_name)
{
	var i,x,y,ARRcookies=document.cookie.split(";");
	for (i=0;i<ARRcookies.length;i++)
	{
		x=ARRcookies[i].substr(0,ARRcookies[i].indexOf("="));
		y=ARRcookies[i].substr(ARRcookies[i].indexOf("=")+1);
		x=x.replace(/^\s+|\s+$/g,"");
		if (x==c_name)
		{
		return unescape(y);
		}
	}
}
$(function(){	
		jQuery('#current-city-postcode').attr('value','Start typing your post/zip code');
	})
/* Overlay Teamspace: Going maps Overlay*/
jQuery(function ($) {
	// Load dialog on page load
	//$('#basic-modal-content').modal();

	// Load dialog on click
	$('#overlay-modal .over-link').click(function (e) {
		$('#ts-overlay-content').modal();

		return false;
	});
	
});



