//tab script
$(function() {
        $("#tab-content div").hide();
		$("#liked").show(); 
		$("#liked div").show();
	
    $('#like-comment-tab a').click(function(e) {
        e.preventDefault();        
        $("#tab-content div").hide(); 
		$("#tab-content div div").show(); 
		 var showCont = $(this).parent('li').attr('id');
		 $("#like-comment-tab li").removeClass('current');
		 $(this).parent('li').addClass('current');
		 $("."+showCont).show();
      
    });
})
/*$(function(){
        $('#subs-btn').click(function(){
            $(this).toggleClass('subscribed');
        });
    })*/
/*$(function(){
        $('#subs-btn').click(function(){
            if($(this).hasClass('subscribe'))
            {
				var subscribe = confirm('Do you want to subscribe?');
				if(subscribe){
                $(this).removeClass('subscribe');
				$(this).addClass('subscribed')
				}
            }
            else if($(this).hasClass('subscribed'))
            {
				var unsubscribe=confirm('Do you want to remove subscription?');
				if(unsubscribe){
				$(this).removeClass('subscribed');
                $(this).addClass('subscribe');
				}
            }
        });
    });*/
	
$(function(){
	$('.dlp-container .category-buttons button:first' ).css( "display", "none" );
	$('.dlp-container .accordion-inner div:nth-child(1)').show();
	$('.dlp-container .checkbox').hide();
	$('.dlp-container .checkbox').next().hide();
	$('.dlp-container .checkbox').next().next().hide();
	$('.dlp-container #mbMessageAttachmentsPanel').show();
//	$('.navbar .container .nav-collapse ul.nav > li').hide();
//	$('.navbar .container .nav-collapse ul.nav > li:nth-child(3)').show();
	
	var clss = $('.header-back-to');
	if(clss.length <= 0){
	$('.dlp-container .category-buttons').hide();
	$('.dlp-container #messageBoardsThreadsPanel').hide();
	}
});

/*$(function(){
var str = $(location).attr("href");
alert(str);

var last = str.substring(str.lastIndexOf("/")-10, str.length);
alert(last);

if (last=='publishing/'){
  $('.category-buttons').css('display','none');
  $('body').addClass('abc');
  
}
var clss = $('.header-back-to');
	if(clss.length > 0){
	}
	else{
	$('.category-buttons').hide();
	$('#messageBoardsThreadsPanel').hide();
	}
	
});*/