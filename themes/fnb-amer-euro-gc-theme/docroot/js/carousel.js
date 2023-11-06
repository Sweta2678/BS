var initSlider = function() {

    jQuery('#rounded_sllider li').bind({
        reposition: function() {
            var degrees = jQuery(this).data('roundabout').degrees,
                roundaboutBearing = jQuery(this).parent().data('roundabout').bearing,
                rotateY = Math.sin((roundaboutBearing - degrees) * (Math.PI/180)) * 9;

            /*jQuery(this).css({
                "-webkit-transform": 'rotate(' + rotateY + 'deg)',
                "-moz-transform": 'rotate(' + rotateY + 'deg)',
                "-ms-transform": 'rotate(' + rotateY + 'deg)',
                "-o-transform": 'rotate(' + rotateY + 'deg)',
                "transform": 'rotate(' + rotateY + 'deg)'
            });*/
        }
    });

    jQuery('.rounded_prev').on('click', function(){
        jQuery('#rounded_sllider').roundabout('animateToNextChild');

        return false;
    });

    jQuery('.rounded_next').on('click', function(){
        jQuery('#rounded_sllider').roundabout('animateToPreviousChild');

        return false;
    });

    jQuery('body').on('keyup', function(e) {
        var keyCode = e.which || e.keyCode;

        if(keyCode == 37) {
            jQuery('#rounded_sllider').roundabout('animateToPreviousChild');
            e.preventDefault();
            return false;
        } else if(keyCode == 39) {
            jQuery('#rounded_sllider').roundabout('animateToNextChild');
            e.preventDefault();
            return false;
        }
    });

    jQuery('.dotcontrols li').on('click', function() {
        var jQueryelem = jQuery(this);
        var index = jQueryelem.index();

        jQuery('#rounded_sllider').roundabout('animateToChild', index);

        return false;
    });

    jQuery('#rounded_sllider').roundabout({
        minScale: 0.8,
        maxScale: 1,
        duration: 750
    }).bind({
        animationEnd: function(e) {
            var index = jQuery('#rounded_sllider').roundabout('getChildInFocus');
            jQuery('.dotcontrols li').removeClass('active');
            jQuery('.dotcontrols li').eq(index).addClass('active');
        }
    });



    jQuery('#text-slider').roundabout({
        minOpacity: 0,
        minScale: 1,
		autoplay: false,
		autoplayDuration: 10000,
		autoplayPauseOnHover: true,
        duration: 1000
    }).bind({
        animationEnd: function(e) {
            var index = jQuery('#text-slider').roundabout('getChildInFocus');
            jQuery('.jQ_sliderTextSwitch li').removeClass('active');
            jQuery('.jQ_sliderTextSwitch li').eq(index).addClass('active');
        }
    });

    jQuery('.jQ_sliderTextPrev').on('click', function(){
        jQuery('#text-slider').roundabout('animateToNextChild');

        return false;
    });

    jQuery('.jQ_sliderTextNext').on('click', function(){
        jQuery('#text-slider').roundabout('animateToPreviousChild');

        return false;
    });

    jQuery('.jQ_sliderTextSwitch li').on('click', function() {
        var jQueryelem = jQuery(this);
        var index = jQueryelem.index();

        jQuery('#text-slider').roundabout('animateToChild', index);

        return false;
    });



};
jQuery(document).ready(function(){
	// home carousel
    initSlider();
});