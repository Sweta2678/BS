(function($) {
    $(function() {
        $('.jcarousel').jcarousel();

        $('.jcarousel-control-prev')
            .on('jcarouselcontrol:active', function() {
                $(this).removeClass('inactive');
            })
            .on('jcarouselcontrol:inactive', function() {
                $(this).addClass('inactive');
            })
            .jcarouselControl({
                target: '-=1'
            });

        $('.jcarousel-control-next')
            .on('jcarouselcontrol:active', function() {
                $(this).removeClass('inactive');
            })
            .on('jcarouselcontrol:inactive', function() {
                $(this).addClass('inactive');
            })
            .jcarouselControl({
                target: '+=1'
            });

        $('.jcarousel-pagination')
            .on('jcarouselpagination:active', 'a', function() {
                $(this).addClass('active');
            })
            .on('jcarouselpagination:inactive', 'a', function() {
                $(this).removeClass('active');
            })
            .jcarouselPagination();
    });
})(jQuery);

		function DropDown(el) {
				this.dd = el;
				this.initEvents();
			}
			DropDown.prototype = {
				initEvents : function() {
					var obj = this;

					obj.dd.on('click', function(event){
						$(this).toggleClass('active');
						event.stopPropagation();
					});	
				}
			}

			$(function() {

				var dd = new DropDown( $('#dd') );

				$(document).click(function() {
					// all dropdowns
					$('.wrapper-dropdown-3').removeClass('active');
				});

			});
			
			$('document').keypress(function(e) {
			    if(e.which == 13) {
			   if($('#grsGlobalSiteSearchKeywords:focus').size()>0 && $('#grsGlobalSiteSearchKeywords').val()!="" ){
			    grsSiteSearchFormSubmit();
			      }
			    }
			});

			function grsGlobalSiteSearchFormSubmit(){
			    var searchString = document.getElementById("grsGlobalSiteSearchKeywords").value ;
			    if (searchString != 'search...') {
			  if (!/\d/.test(searchString) && !/[a-zA-Z]/.test(searchString)){
			   return false;
			  }else{
			   searchString= searchString.replace(/&/g,"%26amp;").replace(/>/g,"%26gt;").replace(/</g,"%26lt;").replace(/\'/g,"%26apos;").replace(/\"/g,"%26quot;").toLowerCase();
			   var url = "/web/grs-communications/search-results?q=" + searchString;
			   window.location.href = url;
			  }
			 }else{
			     return false;
			 }
			}
			
$('document').ready(function(){
	var customChk = $('input.customChk').length;
	if(customChk > 0){
		$('input.customChk').prettyCheckable({
	    color: 'red'
		});
	  }
	
	var grsPollBtn = $('input.grsPollVoteRadioBtn').length;
	if(grsPollBtn > 0){
		$('input.grsPollVoteRadioBtn').prettyCheckable({
	color: 'red'
	  });
	}
  
  
$("iframe#glossary").load(function() {
var frameContents;
frameContents = $("#glossary").contents(); 
frameContents.find("body").css({"margin":"0", "font-family":"Calibri,Arial,Helvetica,sans-serif"});
frameContents.find("h1").css({"display":"block", "padding":"0", "margin":"15px 0 0px 0","line-height":"1"});
frameContents.find("table").css({ "max-width": "100%", "background-color": "transparent", "border-collapse":"collapse", "border-spacing": "0", "width": "100%", "margin-bottom": "20px", "margin-top": "10px","font-family":"Calibri,Arial,Helvetica,sans-serif"});
frameContents.find("tr").css('height','auto');
frameContents.find("td").css({"border": "0px", "line-height":"1", "padding": "15px 10px",	"text-align": "left", "vertical-align": "top"});
frameContents.find("tr:nth-child(odd)").find('td').css({"display":"table-cell", "background": "#f2f2f2", "font-family":"Calibri,Arial,Helvetica,sans-serif"});
frameContents.find("p").css({"margin":"0px","font-size":"14px"});
});
$('.right-bottmup').click(function(){
$("html, body").animate({ scrollTop: 0 }, 600);
return false;
 });

var currentUrl = Liferay.ThemeDisplay.getLayoutURL();
if(currentUrl.indexOf('/web/grs-communications/about') != -1){
	$("#aboutGRSPage").addClass("active");
}
else if(currentUrl.indexOf('/web/grs-communications/roadmap') != -1){
	$("#timeLinePage").addClass("active");
}
else if(currentUrl.indexOf('/web/grs-communications/calendar') != -1){
	$("#calendarPage").addClass("active");
}
else if(currentUrl.indexOf('/web/grs-communications/blog') != -1){
	$("#craigBlogPage").addClass("active");
}
else if(currentUrl.indexOf('/web/grs-communications/articles') != -1){
	$("#articlePage").addClass("active");
}
else if(currentUrl.indexOf('/web/grs-communications/discussions') != -1){
	$("#discussionPage").addClass("active");
}
else if(currentUrl.indexOf('/web/grs-communications/document-repository') != -1){
	$("#assetLibraryPage").addClass("active");
}
else if(currentUrl.indexOf('/web/grs-communications/terminology') != -1){
	$("#terminologyPage").addClass("active");
}
else if(currentUrl.indexOf('/web/grs-communications/training') != -1){
	$("#trainingPage").addClass("active");
}
else if(currentUrl.indexOf('/web/grs-communications/faq') != -1){
	$("#faqPage").addClass("active");
}
else if(currentUrl.indexOf('/web/grs-communications/feedback') != -1){
	$("#feedbackFormPage").addClass("active");
}else{
	$(".hambarger li").removeClass("active");
}
});
	