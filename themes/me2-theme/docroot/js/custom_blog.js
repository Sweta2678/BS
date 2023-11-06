$(document).ready(function() {   

    //select all the a tag with name equal to modal
    $('a.modal').click(function(e) {
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
        $(this).remove();
       
    });
   
   
});