/* <![CDATA[ */
( function( $ ) {
   $( 'a[href="#"]' ).click( function(e) {
      e.preventDefault();
   } );
} )( jQuery );
/* ]]> */

function changeGoogleTranslate() {
if ($('.goog-te-combo option:first-child').text() == "Select Language") {
$('.goog-te-combo').selectmenu({ style:'dropdown', width:110 }).change(function () {
	var gObj = $('.goog-te-combo');
	var db = gObj.get(0);
	gObj.val($(this).val());
	fireEvent(db, 'change');
	});
} else {
setTimeout(changeGoogleTranslate, 50);
}
}
changeGoogleTranslate();

/*function fireEvent(el,e){
if (document.createEventObject){
//for IE
var evt = document.createEventObject();
return el.fireEvent('on'+e,evt);
}
else{
// For other browsers
var evt = document.createEvent("HTMLEvents");
evt.initEvent(e, true, true );
return !el.dispatchEvent(evt);
}
}*/



function fireEvent(el, e) {
	try {
		if (document.createEventObject) {
			// for IE
			if (navigator.appVersion.indexOf("MSIE 9.") != -1
					|| navigator.appVersion.indexOf("MSIE 10.") != -1) {
				var evt = document.createEvent("HTMLEvents");
				evt.initEvent(e, true, true);
				return !el.dispatchEvent(evt);
			} else {
				var evt = document.createEventObject();
				return el.fireEvent('on' + e, evt);
			}
		} else {
			// For other browsers
			var evt = document.createEvent("HTMLEvents");
			evt.initEvent(e, true, true);
			return !el.dispatchEvent(evt);
		}
	} catch (ex) {
		// TODO: handle exception
	}
}



$(document).ready(function() {	

	$("#lista1").als({
		visible_items: 5,
		scrolling_items: 5,
		orientation: "horizontal",
		circular: "no",
		autoscroll: "no",
		interval: 5000,
		speed: 500,
		easing: "linear",
		direction: "right",
		start_from: 0
	});
	
	$("#lista2").als1({
		visible_items: 3,
		scrolling_items: 1,
		orientation: "horizontal",
		circular: "no",
		autoscroll: "no",
		interval: 5000,
		speed: 500,
		easing: "linear",
		direction: "right",
		start_from: 0
	});
	
	$("#lista3").als2({
		visible_items: 2,
		scrolling_items: 1,
		orientation: "horizontal",
		circular: "no",
		autoscroll: "no",
		interval: 5000,
		speed: 500,
		easing: "linear",
		direction: "right",
		start_from: 0
	});

	//select all the a tag with name equal to modal
	$('a[name=modal], input[name=modal], button[name=modal]').on('click', function(e) {
		//Cancel the link behavior
		e.preventDefault();
		//Get the A tag
		var id = $(this).attr('href');
	
		//Get the screen height and width
		var maskHeight = $(document).height();
		var maskWidth = $(window).width();
	
		//Set height and width to mask to fill up the whole screen
		$('body').append('<div id="mask"></div>');
		$('#mask').css({'width':maskWidth,'height':maskHeight});
		
		//transition effect		
		//$('#mask').fadeIn(150);	
		$('#mask').fadeTo("fast",0.3);	
	
		//Get the window height and width
		var winH = $(window).height();
		var winW = $(window).width();
              
		//Set the popup window to center
		$(id).css('top',  winH/2-$(id).height()/2);
		$(id).css('left', winW/2-$(id).width()/2);
	
		//transition effect
		$('.dialog').fadeOut('fast');
		$(id).fadeIn(600); 
		$(id).fadeTo("slow",1);
	
	});
	
	//if close button is clicked
	$('.window .close').click(function (e) {
		//Cancel the link behavior
		e.preventDefault();
		$('.window').hide();
		$('#mask').remove();
	});		
	
	//if mask is clicked
	$('body').on('click', '#mask', function () {
		$('.window').hide();
		$('#mask').remove();
        
    }); 
	
	
	$('select.styled').customSelect();
	
	//JS for Nav Menu
	
	$('.tcc_Mainmenu > li').bind('mouseover', openSubMenu);
		$('.tcc_Mainmenu > li').bind('mouseout', closeSubMenu);
		
		function openSubMenu() {
			$(this).find('ul').css('visibility', 'visible');	
		};
		
		function closeSubMenu() {
		$(this).find('ul').css('visibility', 'hidden');	
	};
	
	
	
	//JS for TABS
	
	$(".brands_Tabs div").click(function() {
		//	First remove class "active" from currently active tab
		$(".brands_Tabs div").removeClass('active');

		//	Now add class "active" to the selected/clicked tab
		$(this).addClass("active");
		
		//	Here we get the href value of the selected tab
		var selected_tab = $(this).find("a").attr("href");

		//	Hide all tab content
		$(".tab_content").hide();
		$(".tab_content").removeClass('active');

		//	Show the selected tab content
		$(selected_tab).show();
		$(selected_tab).addClass('active');

		//	At the end, we add return false so that the click on the link is not executed
		return false;
	});
	
	
	//JS for Promotional Accordion
	$(".promo_Avail_Tab").click(function(){
		$(this).parent().find(".pat_Content").toggle("fast");
		$(this).toggleClass("active");
		$(this).parent().find(".hotl_Promtns").removeClass("active");
	});
	
	//JS for Agent Promotion Select Options
	$(".AP_SlctBox").click(function(){
		$(this).parent().find(".AP_OpsCont").toggle("fast");
	});
	
	
	//JS for input elements
	$(".spl_Labels").click(function(){
		$(this).css('display' , 'none');
		$(this).parent().find("input").focus();
		$(this).parent().find("textarea").focus();
	});
	
	$("input[type=reset]").click(function(){
		$(".spl_Labels").css('display' , 'block');
		changeDefValue();

		// remove "selected" from any options that might already be selected
		/*$('.styled option[selected="selected"]').each(
			function() {
				$(this).removeAttr('selected');
			}
		);*/


		// mark the first option as selected
		//$(".styled option:first").attr('selected','selected');
		
	});
	
	function changeDefValue() {
	
		$(".styled.hasCustomSelect").each(
			function() {
				//alert("Hi");
				//$(this).find("option:first").attr('selected','selected');
				var defSelValue = $(this).find("option:first").text();
				//alert(defSelValue);
				$(this).parent().find(".customSelectInner").html(defSelValue);
			}
		);
	}
	
	$('input').filter(function() {
		return this.value;
	}).parent().find(".spl_Labels").css('display' , 'none');
	
	$('textarea').filter(function() {
		return this.value;
	}).parent().find(".spl_Labels").css('display' , 'none');
	
	$('input').each(function() {
    //var default_value = this.value;
	

    $(this).focus(function() {
		$(this).parent().find(".spl_Labels").css('display' , 'none');
    });
	
	$(this).blur(function() {
        if(this.value == '') {
            $(this).parent().find(".spl_Labels").css('display' , 'block');
        }
    });
	});
	
	$('textarea').each(function() {
    //var default_value = this.value;
    $(this).focus(function() {
		$(this).parent().find(".spl_Labels").css('display' , 'none');
    });
	
	$(this).blur(function() {
        if(this.value == '') {
            $(this).parent().find(".spl_Labels").css('display' , 'block');
        }
    });
	});
	
	
	//JS for Home Promotional Tabs
	$(".clkbl_Tab").click(function(){
		$(".hmPrmo_Tb_Bg_Large").addClass("hmPrmo_Tb_Bg_Large_BG");
		$(".hmPrmo_Tb_Bg_Small").css('background', 'transparent');
		
		$(".clkbl_Tab").find(".prpl_Arrw").removeClass("active");
		$(".clkbl_Tab").find(".hmPromo_Tb_Txt").removeClass("active");
		$(this).find(".prpl_Arrw").addClass("active");
		$(this).find(".hmPromo_Tb_Txt").addClass("active");	
		
		var tabId = $(this).attr("id");
		var tabClass = "." + tabId;
		$(".cbt_Con").fadeOut("fast");
		$(tabClass).fadeIn("fast");
	});
	
	$(document).click(function(e){
		var container = $(".hmPrmo_Tb_Bg_Large");
		var CP_Box = $(".AP_Cont_Box");
		//var inputLabels = $(".spl_Labels");
		var ihgClub_Box = $("#ihgrClub_Link");
			
		 if (!container.is(e.target) // if the target of the click isn't the container...
		 && container.has(e.target).length === 0) // ... nor a descendant of the container
		{
			$(".hmPrmo_Tb_Bg_Large").removeClass("hmPrmo_Tb_Bg_Large_BG");
			$(".hmPrmo_Tb_Bg_Small").css('background', '#fff');
			$(".clkbl_Tab").find(".prpl_Arrw").removeClass("active");
			$(".clkbl_Tab").find(".hmPromo_Tb_Txt").removeClass("active");
			$(".cbt_Con").fadeOut("fast");
		}
		
		if (!CP_Box.is(e.target) // if the target of the click isn't the container...
		 && CP_Box.has(e.target).length === 0) // ... nor a descendant of the container
		{
			$(".AP_OpsCont").fadeOut("fast");
		}
		
		if (!ihgClub_Box.is(e.target) // if the target of the click isn't the container...
		 && ihgClub_Box.has(e.target).length === 0) // ... nor a descendant of the container
		{
			$(".rewardsClub_Box_BG").fadeOut("fast");
		}

	});
	
	
	//JS for tcc_Praise Box
	$(".tccp_Close").click(function(){
		$("#tcc_Praise").fadeOut("1");
	});
	
	
	//JS for Pagination
	var prev = {start: 0, stop: 0},
	cont = $('#npg_Height div.z');
	
	$(".tcc_pagination").paging(cont.length, {
		format: '*',
		perpage: getRecordsPerPageInPagination(),
		lapping: 0,
		onSelect: function (page) {
			//alert(window.totalPages);
			//alert(page);
			
			var data = this.slice;
			
			cont.slice(prev[0], prev[1]).css('display', 'none');
			cont.slice(data[0], data[1]).fadeIn("slow");

			prev = data;
			//alert(data);
			
			var EleCont = $('#npg_Height div.z').find(".nHotel_Element");
			
			$(".nh_Results").find(".mycut").remove();
			$(".nh_Results").append('<span class="mycut">' + "Your search returned " + EleCont.length + " results. " + " You are on page " + page + " of " + window.totalPages + '</span>');
			
		},
		onFormat: function(type) {
			
			window.totalPages = this.value;

			switch (type) {

			case 'block':

			if (!this.active)
				return '<span class="disabled">' + this.value + '</span>';
			else if (this.value != this.page)
				return '<em class="pgn_Link"><a href="#' + this.value + '">' + this.value + '</a></em>';
			return '<span class="pgn_current">' + this.value + '</span>';
				
			
			}
		}
		
	});
	
	//JS for Text Area Limit
	$('#TA_Commnt').keyup(function () {
    var left = 1000 - $(this).val().length;
    if (left < 0) {
        left = 0;
    }
    if($(this).val().length > 1000){
        //Truncate the text if necessary
        $(this).val($(this).val().substr(0, 1000));  
    }
    $('#TA_Counter').text(left + ' characters remaining');
});

	function getRecordsPerPageInPagination()
	{
	 var defaultPaginationValue = 5;
	 var paginationRecordsPerPage = defaultPaginationValue;
	 try {
	  paginationRecordsPerPage = $('#paginationRecordsPerPage').val();
	  if(typeof(paginationRecordsPerPage) == "undefined" || paginationRecordsPerPage == "" || isNaN(paginationRecordsPerPage))
	  { 
	   paginationRecordsPerPage = defaultPaginationValue;   
	  }
	 }
	 catch(e) {
	  paginationRecordsPerPage = defaultPaginationValue;
	 }
	 return paginationRecordsPerPage;
	}

 //JS for Image Gallery
 $(".gallery a[rel^='imageGallery']").imageGallery({animation_speed:'normal',theme:'light_square',slideshow:3000, autoplay_slideshow: false});
 
 
 //JS for IHG Reward Club Drop Down Box
 $("#ihgrClub_Link").click(function(){
	$(".rewardsClub_Box_BG").toggle();
 });
 
 $(".IC-logo-container a, .hualuxe-logo-container a, .CP-logo-container a, .HI-logo-container a, .EvenH-logo-container a .H-Inn-logo-container a, .H-Exp-logo-container a, .H-Resort-logo-container a, .H-Club-logo-container a, .SB-logo-container a, .CW-logo-container a,.Kimpton-logo-container a,.avid-logo-container a").hover(
		 function() {
			 
			 $(".rewardsClub_Box_BG").hide();
		 }
 );
 
 
 //JS for Height adjustment of Brand,Glossary,agent-promo,book-client-travel pages
  var highestBox_G = 0;
  $('.gl_Com_Width').each(function(){
  
   if($(this).height() > highestBox_G) 
      highestBox_G = $(this).height(); 
  });  
  
  $('.gl_Com_Width').height(highestBox_G);
  
  $("#tc_Amen_Tab").on('click', function(){
	var highestBox_B = 0;
	$('.amen_Box').each(function(){
  
   if($(this).height() > highestBox_B) 
      highestBox_B = $(this).height(); 
  });  
  
  $('.amen_Box').height(highestBox_B);
  });
});