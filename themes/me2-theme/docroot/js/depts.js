$(function() {
        $("#inside-tab div").hide();
         $("#about").show(); 
        $("#about div").show();
    
    $('#dept-tabs a').click(function(e) {
        e.preventDefault();        
        $("#inside-tab div").hide(); 
         $("#inside-tab div div").show(); 
         var showCont = $(this).parent('li').attr('id');
         $("#dept-tabs li").removeClass('current');
         $(this).parent('li').addClass('current');
          $("."+showCont).show();
      
    });
});
