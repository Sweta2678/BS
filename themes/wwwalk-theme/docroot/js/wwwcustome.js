jQuery(document).ready(function(){
    /*jQuery('.account_view_fields select').selectmenu({ style:'dropdown', width:220 });*/
   /* jQuery('.www_account_view .www_table select').selectmenu({ style:'dropdown', width:45 });*/
	/*jQuery('.property_view .www_table select').selectmenu({ style:'dropdown', width:45 });*/
    jQuery('.street_corner_content .fields select').selectmenu({ style:'dropdown', width:300 });
    jQuery('.home_page .fields select').selectmenu({ style:'dropdown', width:220 });
    jQuery('.home_page2 .fields select').selectmenu({ style:'dropdown', width:220 });
	jQuery('select.AC_regionSelect').selectmenu({ style:'dropdown', width:220 });
    //var txt = $('.www_table select :selected').text();
    //alert("selected value" +  txt);
    
    // alert("You have Selected  :: "+$(this).val());
        
    //alert("After" + $txt);
    /*var loop = $('.www_table select').length;
    for( i=0; i<=loop; i++ ){
    if ($('.www_table select :selected').val() == "Y")
        {
           $('.www_table select').next().css( "color", "green" );
        }
        else{
            $('.www_table select').next().css({'color':'red'});
        }

    }*/
    
            
    jQuery(".www_account_view .www_table select").change(function (event) {
        var jQuerytxt = jQuery(this).val();
        if (jQuerytxt == "Y")
        {
           jQuery( this ).next().css( "color", "#25bb07" );
        }
        else{
            jQuery( this ).next().css('color', '#ff0000');
        }
    });
	
	jQuery(".property_view .www_table select").change(function (event) {
        var jQuerytxt = jQuery(this).val();
        if (jQuerytxt == "Y")
        {
           jQuery( this ).next().css( "color", "#25bb07" );
        }
        else{
            jQuery( this ).next().css('color', '#ff0000');
        }
    });
	
	//Script for adding table alternate bg color
    //jQuery(".leftpanel .table_container .www_table tr:even").addClass("alt_color");
    jQuery(".rightpanel .art_div div:odd").addClass("art_bgcolor");
    jQuery(".rightpanel .room_rates tr:even").addClass("roomrates_bgcolor");
    jQuery(".rightpanel .room_rates tr:odd").addClass("border_gray");
    jQuery("#accountviewtable").tablesorter({headers: { 5:{sorter: false}}, widgets: ['zebra']});
    jQuery("#propertyviewtable").tablesorter({headers: { 3:{sorter: false},4:{sorter: false},5:{sorter: false}}, widgets: ['zebra']});
  
    jQuery('#reviewer_todo #reviewer_todo_table').DataTable({
    	 "info":     false,
    	 "searching": false,
    	 "dom": '<pf<t>i>',
    	 "columnDefs": [ { "targets": 3, "orderable": false } ],
    	 "oLanguage": {
    	      "sEmptyTable": "No data available"
    	 }
    });
    
    jQuery('#reviewer_dashbaord #reviewer_todo_table').DataTable({
   	 "info":     false,
   	 "searching": false,
   	 "columnDefs": [ { "targets":  [ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10], "orderable": false } ], 	
   	 "dom": '<pf<t>i>',
   	 "oLanguage": { 	 		
   	      "sEmptyTable": "No data available"
   	 }
   });
    
    jQuery('#kad_dashbaord #reviewer_todo_table,#super_dashbaord #reviewer_todo_table').DataTable({
      	 "info":     false,
      	 "searching": false,
      	 "columnDefs": [ { "targets":  [ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,11], "orderable": false } ], 	
      	 "dom": '<pf<t>i>',
      	 "oLanguage": { 	 		
      	      "sEmptyTable": "No data available"
      	 }
      });
});