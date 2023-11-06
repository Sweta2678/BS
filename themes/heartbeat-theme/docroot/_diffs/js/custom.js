// JavaScript Document

$(function() {
/* checkbox script */
		
			/* add the checbox name with function name in the document.ready
				eg:  customCheckbox("sex");
			*/
		function customCheckbox(checkboxName){
			var checkBox = $('input[name="'+ checkboxName +'"]');
			$(checkBox).each(function(){
				$(this).wrap( "<span class='custom-checkbox'></span>" );
				if($(this).is(':checked')){
					$(this).parent().addClass("selected");
				}
			});
			$(checkBox).click(function(){
				$(this).parent().toggleClass("selected");
			});
		}
		customCheckbox("subscribe");
		
		// carousel
	$('.jcarousel')
		.jcarousel({
			wrap: 'circular'
	})
.jcarouselAutoscroll({
    interval: 2000,
    target: '+=1',
    autostart: true
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
/* commented for next and prev buttons which are not required in this project
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
            });*/


$(function() {
$("#search-site").focus(function() {
		if($(this).val() == "SEARCH") {
			$(this).val("");
		}
	});
$("#search-site").blur(function() {
		if($(this).val() == "") {
			$(this).val("SEARCH");
		}
	});
$("#searchBtn").click(function() {
	heartBeatGlobalSiteSearchSubmit();
});
$("#search-site").keypress(function(e) {
    if(e.which == 13) {
   if($('#search-site:focus').size()>0 && $('#search-site').val()!="" ){
	   heartBeatGlobalSiteSearchSubmit();
      }
    }
});
	function heartBeatGlobalSiteSearchSubmit(){
	    var searchString = document.getElementById("search-site").value ;
	    if (searchString != 'SEARCH') {
	    		if (!/\d/.test(searchString) && !/[a-zA-Z]/.test(searchString)){
	    			return false;
	    		}else{
	    			searchString= searchString.replace(/&/g,"%26amp;").replace(/>/g,"%26gt;").replace(/</g,"%26lt;").replace(/\'/g,"%26apos;").replace(/\"/g,"%26quot;");	   
	    			window.location.href = siteSerachURL +"?q=" + searchString;
	    		}
	    }else{
	    	return false;
	    }
	}

  });
   //Search Textbox value ends
   
 $(".custom-select").selectmenu();