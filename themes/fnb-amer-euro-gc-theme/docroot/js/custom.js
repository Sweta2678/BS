jQuery(document)
		.ready(
				function() {
					jQuery(
							'li:last-child,#navigation li:last-child,.tab_content li:last-child,.module:last-child,.affection_bar li:last-child,.block_content:last-child .inner,.block_content:last-child,.main-content .wrap:last-child,#bottom .wrap:last-child,.metadata .title_meta:last-child,.sbOptions li:last-child,.footer_links_bar li:last-child,#tabs .tab-content li:last-child,.post:last-child')
							.addClass('last');
					jQuery('#home-tabs .block:nth-child(3n+3)').addClass(
							'third');
					jQuery(
							'.blocks.cols_2 .block:nth-child(2n+2), .award:nth-child(2n+2)')
							.addClass('second');
					jQuery('.affection_bar li:first-child').addClass('first');

					//jQuery("select").selectbox();
				});

//KU Table classes
(function( $ ) {
    $.fn.tableClasses = function(options) {
		return this.each(function() {
			
			//common variables
			var tHeader = $("tr:first-child th",this);
			var tdHeader = $("tr:first-child td",this);
			var tbHeader = $("tr:last-child",this);
			var tData = $("td:last-child",this);
			
			//incrementing class to make it unique in 1st TR
			for (var i=0; i <= tHeader.length; i++) {
				tHeader.eq(i).addClass('col'+i);
			}
			
			for (var i=0; i <= tdHeader.length; i++) {
				tdHeader.eq(i).addClass('col'+i);
			}
			
			//add class to last TR if the same TR has TH
			if($(tbHeader,this)){
				tbHeader.has("th").addClass("last");
			}
			
			//add class "last" to last TD od each TR
			tData.addClass("last");
			
		});
	};
}( jQuery ));