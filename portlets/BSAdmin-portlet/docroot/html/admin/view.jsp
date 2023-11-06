<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"> 

<%@page import="javax.portlet.*"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.ihg.brandstandards.db.service.StandardsLocaleLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="com.ihg.brandstandards.db.model.StandardsLocale"%>
<%@taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@page import="com.ihg.brandstandards.util.BrandStandardsUtil"%>
<%@page import="com.ihg.brandstandards.custom.model.Preferences"%>
<portlet:defineObjects />
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<script type="text/javascript" src="/BSTheme-theme/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="/BSTheme-theme/js/jquery-ui-1.8.10.custom.min.js"></script>
    <script type="text/javascript" src="/BSTheme-theme/js/treeAdmin/jquery-ui.js"></script>
	<script type="text/javascript" src="/BSTheme-theme/js/treeAdmin/jquery.cookie.js"></script>
	<script type="text/javascript" src="/BSTheme-theme/js/treeAdmin/jquery.hotkeys.js"></script>
	<script type="text/javascript" src="/BSTheme-theme/js/treeAdmin/jquery.jstree.js"></script>
	<script type="text/javascript" src="/BSTheme-theme/js/treeAdmin/!script.js"></script>
	<script type="text/javascript" src="/BSTheme-theme/js/ajaxObject.js"></script>
    <script type="text/javascript" src="/BSTheme-theme/js/yahoo-dom-event.js"></script>
    <script type="text/javascript" src="/BSTheme-theme/js/connection-min.js"></script>
    <script type="text/javascript" src="/BSTheme-theme/js/json2.js"></script>
    <script type="text/javascript" src="/BSTheme-theme/js/treeAdmin/jquery.msgBox.js"></script>
    <script type="text/javascript" src="/BSTheme-theme/js/treeAdmin/jquery.blockUI.js"></script>

    <%@include file="/html/common/initmenu.jsp" %>
    <link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/tree/!style.css"/>
	<link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/tree/custom/!style.css"/>
	<link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/msgBoxLight.css"/>
    <link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/other/jquery-ui-1.10.1/themes/smoothness/jquery-ui.css"/>


<style>
.ui-accordion .ui-accordion-header {padding-left: 3px; border-radius: 0; height: 17px;}
.ui-accordion .ui-accordion-content {padding: 0;}
.ui-accordion .ui-accordion-header .ui-icon {display: none;}
.ui-state-active {background: #FCBB17;border: 1px solid #FCBB17;}
.ui-accordion-content-active {border: 0;}
.ui-state-hover {border: 1px solid #d3d3d3}
.all_brands_pop_up {
    padding: 0 20px 20px;
	display:none;
	width:300px;
	height:430px;
	border:1px solid #ccc;
	z-index:9999;
	position:fixed;
	top:30px;
	right:40px;
	background-color:#fff;
	-moz-box-shadow:4px 4px 7px #444;
    -webkit-box-shadow:4px 4px 7px #444;
    box-shadow:4px 4px 7px #444;
    -ms-filter:"progid:DXImageTransform.Microsoft.Shadow(Strength=3, Direction=135, Color='#444444')";
    filter:progid:DXImageTransform.Microsoft.Shadow(Strength=3, Direction=135, Color='#444444');
}
.accordion-expand-holder {text-align: right;}
.accordion-expand-all {font-size: 12px; background-position: right top; color: #F90B0B;}
div.ui-accordion-content {height: 40% !important;}
.accordion-expand-all img {margin-right: 3px;}
.bottom_buttons {margin-top: 10px;}
.button_right_margin { margin-right: 10px;}
.all_brands_content {width:280px; height: 300px; overflow:auto;}
form.popup_ajax_form {width:248px;}

.ui-accordion .ui-accordion-header-purple {
   background: none repeat scroll 0 0 #e13301 !important ;
   border: 1px solid #e13301 !important ;
}
.ui-widget {
    font-family: Verdana,Arial,sans-serif;
    font-size: 1.1em;
}

.ui-helper-reset {
    margin: 0px;
    padding: 0px;
    border: 0px none;
    outline: 0px none;
    line-height: 1.3;
    text-decoration: none;
    font-size: 100%;
    list-style: none outside none;
}

.ui-accordion .ui-accordion-icons {
    padding-left: 2.2em;
}

.ui-corner-all, .ui-corner-bottom, .ui-corner-right, .ui-corner-br {
    border-bottom-right-radius: 4px;
}

.ui-corner-all, .ui-corner-bottom, .ui-corner-left, .ui-corner-bl {
    border-bottom-left-radius: 4px;
}

.ui-corner-all, .ui-corner-top, .ui-corner-right, .ui-corner-tr {
    border-top-right-radius: 4px;
}

.ui-corner-all, .ui-corner-top, .ui-corner-left, .ui-corner-tl {
    border-top-left-radius: 4px;
}

.ui-state-default, .ui-widget-content .ui-state-default, .ui-widget-header .ui-state-default {
    border: 1px solid #D3D3D3;
    background: url('/BSTheme-theme/css/other/jquery-ui-1.10.1/themes/base/images/ui-bg_glass_75_e6e6e6_1x400.png') repeat-x scroll 50% 50% #E6E6E6;
    font-weight: normal;
    color: #555;
}

.ui-accordion .ui-accordion-header .ui-accordion-header-icon {
    display: none;
}

.ui-accordion .ui-accordion-header .ui-accordion-header-icon {
    position: absolute;
    left: 0.5em;
    top: 50%;
    margin-top: -8px;
}

.ui-state-default .ui-icon {
    background-image: url('/BSTheme-theme/css/other/jquery-ui-1.10.1/themes/base/images/ui-icons_888888_256x240.png');
}

.ui-icon-triangle-1-e {
    background-position: -32px -16px;
}

.ui-icon, .ui-widget-content .ui-icon {
    background-image: url('/BSTheme-theme/css/other/jquery-ui-1.10.1/themes/base/images/ui-icons_222222_256x240.png');
}

.ui-icon {
    width: 16px;
    height: 16px;
}

.ui-icon {
    display: block;
    text-indent: -99999px;
    overflow: hidden;
    background-repeat: no-repeat;
}

.ui-accordion .ui-accordion-header {
    cursor: pointer;
}

.ui-state-default, .ui-widget-content .ui-state-default, .ui-widget-header .ui-state-default {
    font-weight: normal;
    color: #555;
}

.button {
    background-image: url('/BSTheme-theme/images/button_left.png');
    background-repeat: no-repeat;
    float: left;
    padding-left: 5px;
}

.bottom_buttons {
    margin-top: 10px;
}

body {
    font-size: 12px;
    font-family: verdana;
}

.button a {
    background-image: url('/BSTheme-theme/images/button_middle.png');
    background-position: left top;
    background-repeat: repeat-x;
    color: #FFF;
    float: left;
    font: bold 11px Verdana,Geneva,sans-serif;
    height: 21px;
    padding: 2px 5px 0px;
    text-decoration: none;
    text-shadow: none;
}

a {
    text-decoration: none;
    color: #E15F26;
    border: medium none;
    outline: medium none;
}
	
</style>
</head>
<body>
<%
List<StandardsLocale> localeList = StandardsLocaleLocalServiceUtil.getStandardsLocales(-1,  -1);
Map<String, String> brandList = BrandStandardsUtil.chainCodeMap();
request.setAttribute("localeList", localeList);
request.setAttribute("brandList", brandList);
Preferences preferences = (Preferences)session.getAttribute("Preferences");
String chainCode = "";
if(preferences!=null)
{
    chainCode = preferences.getBrand();  
}
long userId = PortalUtil.getUserId(renderRequest);
if (userId > 1)
{ 
	boolean flag = request.isUserInRole(BrandStandardsUtil.INDEX_ADMIN_ROLE); 
    if(flag){
%>

<portlet:resourceURL var="ajaxURL" id="adminTaxonomy.jsp" escapeXml="false" />
<div id="response"></div>

<div>
	<div style="float: right; display: none;" id="popUpUI" class="all_brands_pop_up"><br></br>
	<p class="accordion-expand-holder">
		<select id="standard_regions" style="float: left; width: 165px; height: 22px">
			<c:forEach var="standardsLocales" items="${localeList}">
				<c:if test="${standardsLocales.getIsActive() == 'Y'}">
					<c:choose>
						<c:when test="${standardsLocales.getLocaleCode() == 'en_GB'}">
							<option value="${standardsLocales.getLocaleCode()}" selected="selected">${standardsLocales.getLocaleName()}</option>
						</c:when>
						<c:otherwise>
							<option value="${standardsLocales.getLocaleCode()}">${standardsLocales.getLocaleName()}</option>
						</c:otherwise>
					</c:choose>
				</c:if>
			</c:forEach>
		</select>
		<%-- <select id="standard_regions" name="standard_regions" style="float: left; width: 165px; height: 25px">
			<c:forEach var="langOpt" items="${activeLanguages}">
				<option value="${langOpt.key}">${langOpt.value}</option>
			</c:forEach>
		</select> --%>
		
		<a class="accordion-expand-all open" href="#"><img src='/BSTheme-theme/images/plus_color.png'/>Expand all</a>
	</p>
	
	<div class="all_brands_content ui-accordion ui-widget ui-helper-reset" id="brandSection" role="tablist">
		<c:forEach var="brandCode" items="${brandList}" varStatus="count">
			<h3 aria-expanded="false" aria-selected="false" aria-controls="ui-accordion-1-panel-${count.index}" id="ui-accordion-1-header-${count.index}" role="tab" class="ui-accordion-header ui-helper-reset ui-state-default ui-corner-all ui-accordion-icons">
			<span class="ui-accordion-header-icon ui-icon ui-icon-triangle-1-e" id="${brandCode.key}Brand" ></span>${brandCode.value}</h3>
			<div aria-hidden="true" role="tabpanel" aria-labelledby="ui-accordion-1-header-${count.index}" id="ui-accordion-1-panel-${count.index}" style="display: none;" class="ui-accordion-content ui-helper-reset ui-widget-content ui-corner-bottom">
			<textarea style="width:248px;" rows="4" class="popup_ajax_form edit" id="${brandCode.key}Desc"></textarea>
			</div>
		</c:forEach>
	</div>
	<div class="bottom_buttons button button_right_margin">
	<a title="cancel" class="results_filter cancel_link" href="#" id="cancelPopUp">Cancel</a><span></span></div>
	<div class="bottom_buttons button" >
	<a title="submit" class="results_filter submit_link" href="#" id="submitPopUp">Submit</a><span></span></div>
</div>
</div>

<script type="text/javascript">
console.log("css style deployed.");
console.log("added preferences.");
console.log("Added UI for pop up");
console.log("Added jquery functionality for pop up");
console.log("Added cancel & submit button functionality for pop up");
console.log("Added empty updateTextForPopUp method in if statement");
console.log("Added code for updateTextForPopUp");
console.log("Testing pop up");
console.log("empty origText and NewText when pop up");
var click=false;
var upload=false;
var stdCountGlobal='';

var cogHtml="<img src='/BSTheme-theme/images/cog_icon.png' href='#' alt='Taxonomy Title' title='Taxonomy Title' class='tree_item'>";

$(function() {
	/* accordion open */
		$( ".all_brands_content" ).accordion({
	      collapsible: true,
		  heightStyle: "content", 
		  active : 'none'
	    });
		
	/* expand all / collapse all*/	
		var icons = $( "#accordion" ).accordion( "option", "icons" );
	    $('.accordion-expand-all').click(function () {
			if($(this).hasClass("open")){
				$('.ui-accordion-header').removeClass('ui-corner-all').addClass('ui-accordion-header-active ui-state-active ui-corner-top').attr({
					'aria-selected': 'true',
					'tabindex': '0'
				});
				$('.ui-accordion-header-icon').removeClass(icons.header).addClass(icons.headerSelected);
				$('.ui-accordion-content').addClass('ui-accordion-content-active').attr({
					'aria-expanded': 'true',
					'aria-hidden': 'false'
				}).show();
				$(this).removeClass('open').addClass('close');
				$(this).html('<img src="/BSTheme-theme/images/minus_color.png" class="plus_minus_icon" />Collapse All');
			}
			else if($(this).hasClass("close")){		
				$('.ui-accordion-header').removeClass('ui-accordion-header-active ui-state-active ui-corner-top').addClass('ui-corner-all').attr({
					'aria-selected': 'false',
					'tabindex': '-1'
				});
				$('.ui-accordion-header-icon').removeClass(icons.headerSelected).addClass(icons.header);
				$('.ui-accordion-content').removeClass('ui-accordion-content-active').attr({
					'aria-expanded': 'false',
					'aria-hidden': 'true'
				}).hide();
				$(this).removeClass('close').addClass('open');
				$(this).html('<img src="/BSTheme-theme/images/plus_color.png" class="plus_minus_icon" />Expand All');
			}
			
	    });
	      
	  });
	  
function addHiddenTreeData(text,id)
{
	var hiddenTreeData="<div class='hidden_tree_data'><div class='hidden_tree_topbar'>"+
	"<p class='hidden_title_bar'>"+text+"<span class='instructional_text'>Click the text below to edit.</span></p>"+
	"<a href='#' alt='close' title='close' class='close_hidden_tree_data'><img alt='close' title='close' class='close_icon_within_tree' src='/BSTheme-theme/images/close.png'></a></div><div class='hidden_tree_content'><p class='hidden_description inlineEdit ajaxedit' id='tree9'>Enter Taxonomy Description</p></div><div><img vspace='4' class='hidden_icon' href='#' src='/BSTheme-theme/images/placeholder_icon.jpg' alt='Taxonomy Image' title='Taxonomy Image' style='float:left;'>"+
	"Thumbnail Attachment:<span class='span_vertical_space'><form id='uploadformTOKEN"+id+"' name='uploadformTOKEN' enctype='multipart/form-data'><input type='file' name='document' id='document_"+id+"' alt='Browse Image' title='Browse Image' class='formField"+id+" label='File'><input type='button' class='sendMe' name='uploadSubmit__TOKEN__' id='uploadSubmit__TOKEN__' value='Upload Document' alt='Upload Image' title='Upload Image'><input type='hidden' class='hideMe' name='taxonomyId'><input type='hidden' id='stdCount"+id+" class='stdCount"+id+" value='0'>"+
	"</form></span><span class='span_vertical_space_summary_second'><u>Standard Summary :</u></span>"+
	"<span class='span_vertical_space_summary'>"+
	"Under Development(0)<span class='span_space'></span> In Testing (0)<span class='span_space'></span>Awaiting approval(0)</span>"+
	"<span class='span_vertical_space_summary_bottom'>Approved(0)<span class='span_space'></span>Launched(0)<span class='span_space'></span>Discontinued(0)</span></div></div>";
    return hiddenTreeData;
}

jQuery(function(){
    function slideout() {
        setTimeout(function () {
            jQuery("#response").slideUp("slow", function () {});
        },
        2000);
    }
    var UploadHandlerTaxonomy ='<%=renderResponse.encodeURL(ajaxURL.toString())%>' ;
    
	function sendUploadTOKEN()
	{
		var id = jQuery(this).parent().parent().parent().parent().parent().attr("id");
		jQuery("#Taxonomy").jstree("select_node", "#"+id,true); 
		var allow = new Array('gif','png','jpg','jpeg'); 		
		var ext = jQuery('.formField'+id).val().split('.').pop().toLowerCase(); 
		
		if(jQuery(".formField"+id).val() == '') {
			jQuery.msgBox({
	    	    title:"Alert",
	    	    content:"Please browse image first!"
	    	});
	    	return;
		}
		
		if(jQuery.inArray(ext, allow) == -1) {
			jQuery.msgBox({
	    	    title:"Alert",
	    	    content:"Allowed format is gif|jpg|png|jpeg !"
	    	});
	    	return;
		}
		
		//jQuery("#loading").fadeIn('slow');
		jQuery.blockUI({ message: '<h3><img src="/BSTheme-theme/images/busy.gif" /> Please wait...</h3>' });
	      			 
		jQuery(".hideMe").val(id);
		upload=true;
		var formName="uploadformTOKEN"+id;
		//if(validate(form))
		//{
			//the second argument of setForm is crucial,
	    	//which tells Connection Manager this is a file upload form
	    	YAHOO.util.Connect.setForm(formName, true);
			var uploadHandler = {
	      		upload: function(msg) {
	      			var message = JSON.parse(msg.responseText);
	      			//document.getElementById("uploadSubmit__TOKEN__").disabled = false;
	      			//document.getElementById("uploadSubmit__TOKEN__").value = "Upload Document";
	      			if(message.response=="Success")
	      			{
	      				jQuery("#"+id).find(".hidden_icon").first().attr("src", message.imageUrl);
	      				//jQuery("#response").html(message.response+": "+message.message);
	      				 jQuery.blockUI({ message: '<h3><img src="/BSTheme-theme/images/busy.gif" /> '+message.response+': '+message.message+'</h3>' });
	    
	      				//jQuery("#response").slideDown('slow');
	      				
	      				setTimeout(function () {
	      					jQuery.unblockUI();
	      	            },
	      	            2000);
	      	           /*  setTimeout(function () {
	      	                jQuery("#response").slideUp("slow", function () {});
	      	            },
	      	            2000); */
	      	    	 //jQuery("#loading").fadeOut('slow');
	      	          jQuery('#document_'+id).val(''); 
	      	          
	      			 // jQuery("#Taxonomy").jstree("refresh"); 
	      			 // jQuery('#Taxonomy').jstree('get_selected').data('jstree').siblings("div.hidden_tree_data").show(200);
	      			}
	        		else
	        		{
	        			/* jQuery("#response").html(message.response+": "+message.message);
	      	            jQuery("#response").slideDown('slow');
	      	            setTimeout(function () {
	      	                jQuery("#response").slideUp("slow", function () {});
	      	            },
	      	            2000);
	      	            jQuery("#loading").fadeOut('slow'); */
	        			jQuery.blockUI({ message: '<h1><img src="/BSTheme-theme/images/busy.gif" /> '+message.response+': '+message.message+'</h1>' });
	        			setTimeout(function () {
	      					jQuery.unblockUI();
	      	            },
	      	            2000);
	        		}
	    		}
	    	};
	    	document.getElementById("uploadSubmit__TOKEN__").disabled = true;
	    	document.getElementById("uploadSubmit__TOKEN__").value = "Please wait...";    	
	  		YAHOO.util.Connect.asyncRequest('POST',UploadHandlerTaxonomy,uploadHandler);
	  	//}
  	}
	
    var OrigText, NewText;
    jQuery(".save").live("click", function () {
       // jQuery("#loading").fadeIn('slow');
       jQuery.blockUI({ message: '<h3><img src="/BSTheme-theme/images/busy.gif" /> Please wait...</h3>' });
	  
        NewText = jQuery(this).siblings("form").children(".edit").val();
        var id = jQuery(this).parent().parent().parent().parent().attr("id");
        var chainCd = '<%=chainCode%>';
	 	jQuery.trim(chainCd);
	 	 
      if (!jQuery.trim(NewText)) {
    	    jQuery(this).parent().html("&nbsp;").removeClass("selectedT").bind("click", updateText);
    	}
    	
        jQuery.post("<%=renderResponse.encodeURL(ajaxURL.toString())%>", {action:"editDescTaxonomy",taxonomyId: id,description: NewText, brand: chainCd}, 
       		function(msg){
        	var message = JSON.parse(msg);
    	      if(message.response=="Success")
    			{
   	    	  jQuery.blockUI({ message: '<h3><img src="/BSTheme-theme/images/busy.gif" /> '+message.response+': '+message.message+'</h3>' });
   	    	   setTimeout(function () {
					jQuery.unblockUI();
	            },
	            2000);
  	    	  /* jQuery("#response").html(message.response+": "+message.message);
  	            jQuery("#response").slideDown('slow');
  	            setTimeout(function () {
  	                jQuery("#response").slideUp("slow", function () {});
  	            },
  	            2000);
  	    	  jQuery("#loading").fadeOut('slow'); */
  			}
      		else
      		{
      			/* jQuery("#response").html(message.response+": "+message.message);
  	            jQuery("#response").slideDown('slow');
  	            setTimeout(function () {
  	                jQuery("#response").slideUp("slow", function () {});
  	            },
  	            2000);
  	            jQuery("#loading").fadeOut('slow'); */
      			jQuery.blockUI({ message: '<h1><img src="/BSTheme-theme/images/busy.gif" /> '+message.response+': '+message.message+'</h1>' });
    			setTimeout(function () {
  					jQuery.unblockUI();
  	            },
  	            2000);
      		}   
		}); 	       	 

        jQuery(this).parent().html(NewText).removeClass("selectedT").bind("click", updateText);
        
    });

    jQuery(".revert").live("click", function () {
        jQuery(this).parent().html(OrigText).removeClass("selectedT").bind("click", updateText);
    });

		function updateText() {
			
			var chainCd = '<%=chainCode%>';
	 		jQuery.trim(chainCd);
	 		
		 		if(chainCd=="GL")
	    	    {
		 			jQuery('p.hidden_description').html("Enter Taxonomy Description");
		 			updateTextForPopUp();
	    	    }
		 		else
	   	    	{
			 			//var id = jQuery(this).parent().parent().parent().attr("id");
						//alert("id==>"+id);
					jQuery('p.hidden_description').removeClass("inlineEdit");
			        OrigText = jQuery(this).html();
			        jQuery(this).addClass("selectedT").html('<form class="ajax_form"><textarea class="edit" maxlength="4000">' + OrigText + '</textarea></form><a title="save tooltip" href="#" class="save"><img src="/BSTheme-theme/images/save.png" border="0" width="48" height="15" alt="save icon" title="save"/></a> <a href="#" title="cancel tooltip" class="revert"><img src="/BSTheme-theme/images/cancel.png" alt="cancel icon" title="cancel" border="0" width="58" height="15"/></a>').unbind('click', updateText);
			        
	   	    	}
			}
		
		function updateTextForPopUp(){
			
			var   taxId = jQuery("a.jstree-clicked").parent().attr("id");
		    jQuery.trim(taxId);
		    var   localeCd = document.getElementById("standard_regions").value;
	        jQuery.trim(localeCd);
	        OrigText = "";
	        NewText = "";
	        
	        jQuery("div.all_brands_pop_up").show();
	        
		    jQuery.post("<%=renderResponse.encodeURL(ajaxURL.toString())%>",{action: "getBrandDescData",taxonomyId: taxId, locale: localeCd},
		    	function(msg)
		    	{
		    		var message = JSON.parse(msg);
			    	if (message != null && message != '' && typeof message != 'undefined') 
			    	{
			    		jQuery('textarea#ICDesc').val(message.msg0);
 			    		if(message.msg0 != null && message.msg0 != '' && typeof message.msg0 != 'undefined' && message.msg0 != " ")
 			    		{
			    			jQuery('#ui-accordion-1-header-0').removeClass('ui-state-default');
			    			jQuery('#ui-accordion-1-header-0').addClass('ui-accordion-header-purple');
                         }else
                    	 {
                        	 jQuery('#ui-accordion-1-header-0').removeClass('ui-accordion-header-purple');
 			    			jQuery('#ui-accordion-1-header-0').addClass('ui-state-default');
                    	 }
 			    		
 			    		jQuery('textarea#IRDesc').val(message.msg1);
 			    		if(message.msg1 != null && message.msg1 != '' && typeof message.msg1 != 'undefined' && message.msg1 != " ")
			    		 	{
			    			jQuery('#ui-accordion-1-header-1').removeClass('ui-state-default');
			    			jQuery('#ui-accordion-1-header-1').addClass('ui-accordion-header-purple');
                         }else
                    	 {
                        	 jQuery('#ui-accordion-1-header-1').removeClass('ui-accordion-header-purple');
 			    			jQuery('#ui-accordion-1-header-1').addClass('ui-state-default');
                    	 }
 			    		
 			    		jQuery('textarea#HIDesc').val(message.msg2);
 			    		if(message.msg2 != null && message.msg2 != '' && typeof message.msg2 != 'undefined' && message.msg2 != " ")
			    		 	{
			    			jQuery('#ui-accordion-1-header-2').removeClass('ui-state-default');
			    			jQuery('#ui-accordion-1-header-2').addClass('ui-accordion-header-purple');
                         }else
                    	 {
                        	 jQuery('#ui-accordion-1-header-2').removeClass('ui-accordion-header-purple');
 			    			jQuery('#ui-accordion-1-header-2').addClass('ui-state-default');
                    	 }
 			    		
 			    		jQuery('textarea#EXDesc').val(message.msg3);
 			    		if(message.msg3 != null && message.msg3 != '' && typeof message.msg3 != 'undefined' && message.msg3 != " ")
			    		 	{
			    			jQuery('#ui-accordion-1-header-3').removeClass('ui-state-default');
			    			jQuery('#ui-accordion-1-header-3').addClass('ui-accordion-header-purple');
                         }else
                    	 {
                        	 jQuery('#ui-accordion-1-header-3').removeClass('ui-accordion-header-purple');
 			    			jQuery('#ui-accordion-1-header-3').addClass('ui-state-default');
                    	 }
 			    		
 			    		jQuery('textarea#RSDesc').val(message.msg4);
 			    		if(message.msg4 != null && message.msg4 != '' && typeof message.msg4 != 'undefined' && message.msg4 != " ")
			    		 	{
			    			jQuery('#ui-accordion-1-header-4').removeClass('ui-state-default');
			    			jQuery('#ui-accordion-1-header-4').addClass('ui-accordion-header-purple');
                         }else
                    	 {
                        	 jQuery('#ui-accordion-1-header-4').removeClass('ui-accordion-header-purple');
 			    			jQuery('#ui-accordion-1-header-4').addClass('ui-state-default');
                    	 }
 			    		
 			    		jQuery('textarea#CVDesc').val(message.msg5);
 			    		if(message.msg5 != null && message.msg5 != '' && typeof message.msg5 != 'undefined' && message.msg5 != " ")
			    		 	{
			    			jQuery('#ui-accordion-1-header-5').removeClass('ui-state-default');
			    			jQuery('#ui-accordion-1-header-5').addClass('ui-accordion-header-purple');
                         }else
                    	 {
                        	 jQuery('#ui-accordion-1-header-5').removeClass('ui-accordion-header-purple');
 			    			jQuery('#ui-accordion-1-header-5').addClass('ui-state-default');
                    	 }
 			    		
 			    		jQuery('textarea#CPDesc').val(message.msg6);
 			    		if(message.msg6 != null && message.msg6 != '' && typeof message.msg6 != 'undefined' && message.msg6 != " ")
			    		 	{
			    			jQuery('#ui-accordion-1-header-6').removeClass('ui-state-default');
			    			jQuery('#ui-accordion-1-header-6').addClass('ui-accordion-header-purple');
                         }else
                    	 {
                        	 jQuery('#ui-accordion-1-header-6').removeClass('ui-accordion-header-purple');
 			    			jQuery('#ui-accordion-1-header-6').addClass('ui-state-default');
                    	 }
 			    		
 			    		jQuery('textarea#CRDesc').val(message.msg7);
 			    		if(message.msg7 != null && message.msg7 != '' && typeof message.msg7 != 'undefined' && message.msg7 != " ")
			    		 	{
			    			jQuery('#ui-accordion-1-header-7').removeClass('ui-state-default');
			    			jQuery('#ui-accordion-1-header-7').addClass('ui-accordion-header-purple');
                         }else
                    	 {
                        	 jQuery('#ui-accordion-1-header-7').removeClass('ui-accordion-header-purple');
 			    			jQuery('#ui-accordion-1-header-7').addClass('ui-state-default');
                    	 }
 			    		
 			    		jQuery('textarea#ULDesc').val(message.msg8);
 			    		if(message.msg8 != null && message.msg8 != '' && typeof message.msg8 != 'undefined' && message.msg8 != " ")
			    		 	{
			    			jQuery('#ui-accordion-1-header-8').removeClass('ui-state-default');
			    			jQuery('#ui-accordion-1-header-8').addClass('ui-accordion-header-purple');
                         }else
                    	 {
                        	 jQuery('#ui-accordion-1-header-8').removeClass('ui-accordion-header-purple');
 			    			jQuery('#ui-accordion-1-header-8').addClass('ui-state-default');
                    	 }
 			    		
 			    		jQuery('textarea#INDesc').val(message.msg9);
 			    		if(message.msg9 != null && message.msg9 != '' && typeof message.msg9 != 'undefined' && message.msg9 != " ")
			    		 	{
			    			jQuery('#ui-accordion-1-header-9').removeClass('ui-state-default');
			    			jQuery('#ui-accordion-1-header-9').addClass('ui-accordion-header-purple');
                         }else
                    	 {
                        	 jQuery('#ui-accordion-1-header-9').removeClass('ui-accordion-header-purple');
 			    			jQuery('#ui-accordion-1-header-9').addClass('ui-state-default');
                    	 }
 			    		
 			    		jQuery('textarea#VNDesc').val(message.msg10);
 			    		if(message.msg10 != null && message.msg10 != '' && typeof message.msg10 != 'undefined' && message.msg10 != " ")
			    		 	{
			    			jQuery('#ui-accordion-1-header-10').removeClass('ui-state-default');
			    			jQuery('#ui-accordion-1-header-10').addClass('ui-accordion-header-purple');
                         }else
                    	 {
                        	 jQuery('#ui-accordion-1-header-10').removeClass('ui-accordion-header-purple');
 			    			jQuery('#ui-accordion-1-header-10').addClass('ui-state-default');
                    	 }
 			    		
 			    		jQuery('textarea#SBDesc').val(message.msg11);
 			    		if(message.msg11 != null && message.msg11 != '' && typeof message.msg11 != 'undefined' && message.msg11 != " ")
			    		 	{
			    			jQuery('#ui-accordion-1-header-11').removeClass('ui-state-default');
			    			jQuery('#ui-accordion-1-header-11').addClass('ui-accordion-header-purple');
                         }else
                    	 {
                        	 jQuery('#ui-accordion-1-header-11').removeClass('ui-accordion-header-purple');
 			    			jQuery('#ui-accordion-1-header-11').addClass('ui-state-default');
                    	 }
 			    		
 			    		jQuery('textarea#CWDesc').val(message.msg12);
 			    		if(message.msg12 != null && message.msg12 != '' && typeof message.msg12 != 'undefined' && message.msg12 != " ")
			    		 	{
			    			jQuery('#ui-accordion-1-header-12').removeClass('ui-state-default');
			    			jQuery('#ui-accordion-1-header-12').addClass('ui-accordion-header-purple');
                         }else
                    	 {
                        	 jQuery('#ui-accordion-1-header-12').removeClass('ui-accordion-header-purple');
 			    			jQuery('#ui-accordion-1-header-12').addClass('ui-state-default');
                    	 }
 			    		
 			    		jQuery('textarea#VADesc').val(message.msg13);
 			    		if(message.msg13 != null && message.msg13 != '' && typeof message.msg13 != 'undefined' && message.msg13 != " ")
			    		 	{
			    			jQuery('#ui-accordion-1-header-13').removeClass('ui-state-default');
			    			jQuery('#ui-accordion-1-header-13').addClass('ui-accordion-header-purple');
                         }else
                    	 {
                        	 jQuery('#ui-accordion-1-header-13').removeClass('ui-accordion-header-purple');
 			    			jQuery('#ui-accordion-1-header-13').addClass('ui-state-default');
                    	 }
 			    		
 			    		
 			    		jQuery('textarea#KIDesc').val(message.msg14);
 			    		if(message.msg14 != null && message.msg14 != '' && typeof message.msg14 != 'undefined' && message.msg14 != " ")
			    		 	{
			    			jQuery('#ui-accordion-1-header-14').removeClass('ui-state-default');
			    			jQuery('#ui-accordion-1-header-14').addClass('ui-accordion-header-purple');
                         }else
                    	 {
                        	 jQuery('#ui-accordion-1-header-14').removeClass('ui-accordion-header-purple');
 			    			jQuery('#ui-accordion-1-header-14').addClass('ui-state-default');
                    	 }
 			    		
 			    		jQuery('textarea#REDesc').val(message.msg15);
 			    		if(message.msg15 != null && message.msg15 != '' && typeof message.msg15 != 'undefined' && message.msg15 != " ")
			    		 	{
			    			jQuery('#ui-accordion-1-header-15').removeClass('ui-state-default');
			    			jQuery('#ui-accordion-1-header-15').addClass('ui-accordion-header-purple');
                         }else
                    	 {
                        	 jQuery('#ui-accordion-1-header-15').removeClass('ui-accordion-header-purple');
 			    			jQuery('#ui-accordion-1-header-15').addClass('ui-state-default');
                    	 }
 			    		
 			    		jQuery('textarea#VXDesc').val(message.msg16);
 			    		if(message.msg16 != null && message.msg16 != '' && typeof message.msg16 != 'undefined' && message.msg16 != " ")
			    		 	{
			    			jQuery('#ui-accordion-1-header-16').removeClass('ui-state-default');
			    			jQuery('#ui-accordion-1-header-16').addClass('ui-accordion-header-purple');
                         }else
                    	 {
                        	 jQuery('#ui-accordion-1-header-16').removeClass('ui-accordion-header-purple');
 			    			jQuery('#ui-accordion-1-header-16').addClass('ui-state-default');
                    	 }
			    	}
		        }); 
		    
		    jQuery('select#standard_regions').on('change', function() 
	       		{
		    	   taxId = jQuery("a.jstree-clicked").parent().attr("id");
			       jQuery.trim(taxId);
			       localeCd = document.getElementById("standard_regions").value;
		           jQuery.trim(localeCd);
		           
	        	   jQuery.post("<%=renderResponse.encodeURL(ajaxURL.toString())%>",{action: "getBrandDescData",taxonomyId: taxId, locale: localeCd},
     		    	function(msg)
     		    	{
     		    		var message = JSON.parse(msg);
     			    	if (message != null && message != '' && typeof message != 'undefined') 
     			    	{
     			    		jQuery('textarea#ICDesc').val(message.msg0);
     			    		if(message.msg0 != null && message.msg0 != '' && typeof message.msg0 != 'undefined' && message.msg0 != " ")
     			    		{
    			    			jQuery('#ui-accordion-1-header-0').removeClass('ui-state-default');
    			    			jQuery('#ui-accordion-1-header-0').addClass('ui-accordion-header-purple');
                             }else
                        	 {
                            	 jQuery('#ui-accordion-1-header-0').removeClass('ui-accordion-header-purple');
     			    			jQuery('#ui-accordion-1-header-0').addClass('ui-state-default');
                        	 }
     			    		
     			    		jQuery('textarea#IRDesc').val(message.msg1);
     			    		if(message.msg1 != null && message.msg1 != '' && typeof message.msg1 != 'undefined' && message.msg1 != " ")
    			    		 	{
    			    			jQuery('#ui-accordion-1-header-1').removeClass('ui-state-default');
    			    			jQuery('#ui-accordion-1-header-1').addClass('ui-accordion-header-purple');
                             }else
                        	 {
                            	 jQuery('#ui-accordion-1-header-1').removeClass('ui-accordion-header-purple');
     			    			jQuery('#ui-accordion-1-header-1').addClass('ui-state-default');
                        	 }
     			    		
     			    		jQuery('textarea#HIDesc').val(message.msg2);
     			    		if(message.msg2 != null && message.msg2 != '' && typeof message.msg2 != 'undefined' && message.msg2 != " ")
    			    		 	{
    			    			jQuery('#ui-accordion-1-header-2').removeClass('ui-state-default');
    			    			jQuery('#ui-accordion-1-header-2').addClass('ui-accordion-header-purple');
                             }else
                        	 {
                            	 jQuery('#ui-accordion-1-header-2').removeClass('ui-accordion-header-purple');
     			    			jQuery('#ui-accordion-1-header-2').addClass('ui-state-default');
                        	 }
     			    		
     			    		jQuery('textarea#EXDesc').val(message.msg3);
     			    		if(message.msg3 != null && message.msg3 != '' && typeof message.msg3 != 'undefined' && message.msg3 != " ")
    			    		 	{
    			    			jQuery('#ui-accordion-1-header-3').removeClass('ui-state-default');
    			    			jQuery('#ui-accordion-1-header-3').addClass('ui-accordion-header-purple');
                             }else
                        	 {
                            	 jQuery('#ui-accordion-1-header-3').removeClass('ui-accordion-header-purple');
     			    			jQuery('#ui-accordion-1-header-3').addClass('ui-state-default');
                        	 }
     			    		
     			    		jQuery('textarea#RSDesc').val(message.msg4);
     			    		if(message.msg4 != null && message.msg4 != '' && typeof message.msg4 != 'undefined' && message.msg4 != " ")
    			    		 	{
    			    			jQuery('#ui-accordion-1-header-4').removeClass('ui-state-default');
    			    			jQuery('#ui-accordion-1-header-4').addClass('ui-accordion-header-purple');
                             }else
                        	 {
                            	 jQuery('#ui-accordion-1-header-4').removeClass('ui-accordion-header-purple');
     			    			jQuery('#ui-accordion-1-header-4').addClass('ui-state-default');
                        	 }
     			    		
     			    		jQuery('textarea#CVDesc').val(message.msg5);
     			    		if(message.msg5 != null && message.msg5 != '' && typeof message.msg5 != 'undefined' && message.msg5 != " ")
    			    		 	{
    			    			jQuery('#ui-accordion-1-header-5').removeClass('ui-state-default');
    			    			jQuery('#ui-accordion-1-header-5').addClass('ui-accordion-header-purple');
                             }else
                        	 {
                            	 jQuery('#ui-accordion-1-header-5').removeClass('ui-accordion-header-purple');
     			    			jQuery('#ui-accordion-1-header-5').addClass('ui-state-default');
                        	 }
     			    		
     			    		jQuery('textarea#CPDesc').val(message.msg6);
     			    		if(message.msg6 != null && message.msg6 != '' && typeof message.msg6 != 'undefined' && message.msg6 != " ")
    			    		 	{
    			    			jQuery('#ui-accordion-1-header-6').removeClass('ui-state-default');
    			    			jQuery('#ui-accordion-1-header-6').addClass('ui-accordion-header-purple');
                             }else
                        	 {
                            	 jQuery('#ui-accordion-1-header-6').removeClass('ui-accordion-header-purple');
     			    			jQuery('#ui-accordion-1-header-6').addClass('ui-state-default');
                        	 }
     			    		
     			    		jQuery('textarea#CRDesc').val(message.msg7);
     			    		if(message.msg7 != null && message.msg7 != '' && typeof message.msg7 != 'undefined' && message.msg7 != " ")
    			    		 	{
    			    			jQuery('#ui-accordion-1-header-7').removeClass('ui-state-default');
    			    			jQuery('#ui-accordion-1-header-7').addClass('ui-accordion-header-purple');
                             }else
                        	 {
                            	 jQuery('#ui-accordion-1-header-7').removeClass('ui-accordion-header-purple');
     			    			jQuery('#ui-accordion-1-header-7').addClass('ui-state-default');
                        	 }
     			    		
     			    		jQuery('textarea#ULDesc').val(message.msg8);
     			    		if(message.msg8 != null && message.msg8 != '' && typeof message.msg8 != 'undefined' && message.msg8 != " ")
    			    		 	{
    			    			jQuery('#ui-accordion-1-header-8').removeClass('ui-state-default');
    			    			jQuery('#ui-accordion-1-header-8').addClass('ui-accordion-header-purple');
                             }else
                        	 {
                            	 jQuery('#ui-accordion-1-header-8').removeClass('ui-accordion-header-purple');
     			    			jQuery('#ui-accordion-1-header-8').addClass('ui-state-default');
                        	 }
     			    		
     			    		jQuery('textarea#INDesc').val(message.msg9);
     			    		if(message.msg9 != null && message.msg9 != '' && typeof message.msg9 != 'undefined' && message.msg9 != " ")
    			    		 	{
    			    			jQuery('#ui-accordion-1-header-9').removeClass('ui-state-default');
    			    			jQuery('#ui-accordion-1-header-9').addClass('ui-accordion-header-purple');
                             }else
                        	 {
                            	 jQuery('#ui-accordion-1-header-9').removeClass('ui-accordion-header-purple');
     			    			jQuery('#ui-accordion-1-header-9').addClass('ui-state-default');
                        	 }
     			    		
     			    		jQuery('textarea#VNDesc').val(message.msg10);
     			    		if(message.msg10 != null && message.msg10 != '' && typeof message.msg10 != 'undefined' && message.msg10 != " ")
    			    		 	{
    			    			jQuery('#ui-accordion-1-header-10').removeClass('ui-state-default');
    			    			jQuery('#ui-accordion-1-header-10').addClass('ui-accordion-header-purple');
                             }else
                        	 {
                            	 jQuery('#ui-accordion-1-header-10').removeClass('ui-accordion-header-purple');
     			    			jQuery('#ui-accordion-1-header-10').addClass('ui-state-default');
                        	 }
     			    		
     			    		jQuery('textarea#SBDesc').val(message.msg11);
     			    		if(message.msg11 != null && message.msg11 != '' && typeof message.msg11 != 'undefined' && message.msg11 != " ")
    			    		 	{
    			    			jQuery('#ui-accordion-1-header-11').removeClass('ui-state-default');
    			    			jQuery('#ui-accordion-1-header-11').addClass('ui-accordion-header-purple');
                             }else
                        	 {
                            	 jQuery('#ui-accordion-1-header-11').removeClass('ui-accordion-header-purple');
     			    			jQuery('#ui-accordion-1-header-11').addClass('ui-state-default');
                        	 }
     			    		
     			    		jQuery('textarea#CWDesc').val(message.msg12);
     			    		if(message.msg12 != null && message.msg12 != '' && typeof message.msg12 != 'undefined' && message.msg12 != " ")
    			    		 	{
    			    			jQuery('#ui-accordion-1-header-12').removeClass('ui-state-default');
    			    			jQuery('#ui-accordion-1-header-12').addClass('ui-accordion-header-purple');
                             }else
                        	 {
                            	 jQuery('#ui-accordion-1-header-12').removeClass('ui-accordion-header-purple');
     			    			jQuery('#ui-accordion-1-header-12').addClass('ui-state-default');
                        	 }
     			    		
     			    		jQuery('textarea#VADesc').val(message.msg13);
     			    		if(message.msg13 != null && message.msg13 != '' && typeof message.msg13 != 'undefined' && message.msg13 != " ")
    			    		 	{
    			    			jQuery('#ui-accordion-1-header-13').removeClass('ui-state-default');
    			    			jQuery('#ui-accordion-1-header-13').addClass('ui-accordion-header-purple');
                             }else
                        	 {
                            	 jQuery('#ui-accordion-1-header-13').removeClass('ui-accordion-header-purple');
     			    			jQuery('#ui-accordion-1-header-13').addClass('ui-state-default');
                        	 }
     			    		
     			    		jQuery('textarea#KIDesc').val(message.msg14);
     			    		if(message.msg14 != null && message.msg14 != '' && typeof message.msg14 != 'undefined' && message.msg14 != " ")
    			    		 	{
    			    			jQuery('#ui-accordion-1-header-14').removeClass('ui-state-default');
    			    			jQuery('#ui-accordion-1-header-14').addClass('ui-accordion-header-purple');
                             }else
                        	 {
                            	 jQuery('#ui-accordion-1-header-14').removeClass('ui-accordion-header-purple');
     			    			jQuery('#ui-accordion-1-header-14').addClass('ui-state-default');
                        	 }
     			    		
     			    		jQuery('textarea#REDesc').val(message.msg15);
     			    		if(message.msg15 != null && message.msg15 != '' && typeof message.msg15 != 'undefined' && message.msg15 != " ")
    			    		 	{
    			    			jQuery('#ui-accordion-1-header-15').removeClass('ui-state-default');
    			    			jQuery('#ui-accordion-1-header-15').addClass('ui-accordion-header-purple');
                             }else
                        	 {
                            	 jQuery('#ui-accordion-1-header-15').removeClass('ui-accordion-header-purple');
     			    			jQuery('#ui-accordion-1-header-15').addClass('ui-state-default');
                        	 }
     			    		
     			    		jQuery('textarea#VXDesc').val(message.msg16);
     			    		if(message.msg16 != null && message.msg16 != '' && typeof message.msg16 != 'undefined' && message.msg16 != " ")
    			    		 	{
    			    			jQuery('#ui-accordion-1-header-16').removeClass('ui-state-default');
    			    			jQuery('#ui-accordion-1-header-16').addClass('ui-accordion-header-purple');
                             }else
                        	 {
                            	 jQuery('#ui-accordion-1-header-16').removeClass('ui-accordion-header-purple');
     			    			jQuery('#ui-accordion-1-header-16').addClass('ui-state-default');
                        	 }
     			    	}
     		        }); 
		        });
			
		}
	
		/* jQuery('#Taxonomy').bind('load_node.jstree',function(e, data){
			jQuery(".inlineEdit").bind("click",updateText);
			 jQuery(".sendMe").bind("click", sendUploadTOKEN);
		}); */
		
		
		 jQuery("#cancelPopUp").on('click', function() {
	        	jQuery("div.all_brands_pop_up").hide();
	        	
	        	});
	        
	        jQuery("#submitPopUp").live('click', function() {
	          jQuery.blockUI({ message: '<h3><img src="/BSTheme-theme/images/busy.gif" /> Please wait...</h3>' });
	          var   taxId = jQuery("a.jstree-clicked").parent().attr("id");
	          jQuery.trim(taxId);
	          var   localeCd = document.getElementById("standard_regions").value;
	          jQuery.trim(localeCd);
	         
	          var   brandIC = document.getElementById("ICDesc").value;
	          var   brandIR = document.getElementById("IRDesc").value;
	          var   brandHI = document.getElementById("HIDesc").value;
	          var   brandEX = document.getElementById("EXDesc").value;
	          var   brandHIR = document.getElementById("RSDesc").value;
	          var   brandCV = document.getElementById("CVDesc").value;
	          var   brandCP = document.getElementById("CPDesc").value;
	          var   brandCR = document.getElementById("CRDesc").value;
	          var   brandUX = document.getElementById("ULDesc").value;
	          var   brandIN = document.getElementById("INDesc").value;
	          var   brandVN = document.getElementById("VNDesc").value;
	          var   brandSB = document.getElementById("SBDesc").value;
	          var   brandCW = document.getElementById("CWDesc").value;
	          var   brandVA = document.getElementById("VADesc").value;
	          var   brandKI = document.getElementById("KIDesc").value;
	          var   brandRE = document.getElementById("REDesc").value;
			  var   brandVX = document.getElementById("VXDesc").value;
	          
	            
	          
	             jQuery.post("<%=renderResponse.encodeURL(ajaxURL.toString())%>",{action: "editDescTaxonomy",taxonomyId: taxId,locale: localeCd,brand: "GL",brandDescIC : brandIC,brandDescIR : brandIR,brandDescHI : brandHI,brandDescEX : brandEX,brandDescHIR : brandHIR,brandDescCV : brandCV,brandDescCP : brandCP,brandDescCR : brandCR,brandDescUX : brandUX,brandDescIN : brandIN,brandDescVN : brandVN,brandDescSB : brandSB,brandDescCW : brandCW, brandDescVA : brandVA, brandDescKI : brandKI,brandDescRE : brandRE,brandDescVX : brandVX},
	            		function(msg){
	            	var message = JSON.parse(msg);
	        	    if(message.response=="Success")
	        		{
	       	    	  	jQuery.blockUI({ message: '<h3><img src="/BSTheme-theme/images/busy.gif" /> '+message.response+': '+message.message+'</h3>' });
	       	    	    setTimeout(function () {
	    					jQuery.unblockUI();
	    	            },
	    	            2000);
	      			}
	          		else
	          		{
	          			jQuery.blockUI({ message: '<h3><img src="/BSTheme-theme/images/busy.gif" /> '+message.response+': '+message.message+'</h3>' });
	        			setTimeout(function () {
	      					jQuery.unblockUI();
	      	            },
	      	            2000);
	          		}   
	    		}); 	  
	             
	             jQuery("div.all_brands_pop_up").hide();
	        }); 
	        
	        
	        
		jQuery('#Taxonomy').bind('select_node.jstree',function(e, data){
			// alert("node selected");
			 jQuery(".inlineEdit").unbind('click');
			 jQuery(".inlineEdit").bind("click",updateText);
			 jQuery(".sendMe").unbind('click');
			 jQuery(".sendMe").bind("click", sendUploadTOKEN);
		});
		
		
});

function getExcelReport()
{
	jQuery.msgBox({
	    title: "Are You Sure",
	    content: "you want to do an export?",
	    type: "confirm",
	    buttons: [{ value: "Yes" }, { value: "No" }],
	    success: function (result) {
	        if (result == "Yes") {
	        	location.href = '<portlet:resourceURL><portlet:param name="action" value="xmlExcelExportTaxonomy" /></portlet:resourceURL>';
	        }
	        if(result == "No" || result == "Cancel")
	        {
	          return false;
	        }
	    }
	 }); 
}


</script>
<!--ends ajax on tree -->

<div>
<div>
<h3>Admin Tree Maintenance</h3> 
<input type="button"  value="Add Node"  alt="Add Node" title="Add Node" id="create_1"  />
<input type="button" id="rename" alt="Rename Node" title="Rename Node" value="Rename Node" />
<input type="button" id="remove" alt="Remove Node" title="Remove Node"  value="Remove Node"/>
<!--
<input type="button" id="clear" alt="Clear" type="button" style="display:block; float:right;" value="clear"/>
<input type="button" id="search" alt="Search" style="display:block; float:right;" value="search"/>
<input type="text"  id="text" alt="Search Text" style="display:block; float:right;" value=""/>
-->

<div class="button filter_results_button" style="display:block; float:right;"><a href="#" onClick="javascript: getExcelReport();"  class="results_filter" title="Export Report">Export Report</a><span></span></div>

</div>
<br/>
<div class="rounded_container">


<div class="rounded_container_contents">

<img id="loading" src="/BSTheme-theme/images/loading.gif" alt="loading" title="loading"/>
<div id="Taxonomy" class=" jstree jstree-4 jstree-default jstree-focused">
</div>	
<script type="text/javascript">
var noNode=false;
jQuery(function () {
	 jQuery("div.hidden_tree_data").hide();
	 
	 jQuery("#create_1").click(function () { 
		 
		// jQuery('#Taxonomy').jstree('get_parent').attr('id'); 
		// alert("noNode===>>"+noNode);
		 /* if (jQuery("#Taxonomy").length > 0){
			  // do something here
			} */
			var treeLen=jQuery("#Taxonomy").find("li").length;
			//alert(treeLen);
		if(noNode ||treeLen==0 )
		{
			  jQuery.msgBox({
				    title: "Are You Sure",
				    content: "Would you like to create Parent Node?",
				    type: "confirm",
				    buttons: [{ value: "Yes" }, { value: "No" }, { value: "Cancel"}],
				    success: function (result) {
				        if (result == "Yes") {
				        noNode=false;
				        jQuery("#Taxonomy").jstree("create", -1, "last", { "attr": { "rel": "1"} });
				       
				        }
				        if(result == "No" || result == "Cancel")
				        {
				          return false;
				        }
				    }
				 }); 
	    }
		else
		{
			var selectedNode=jQuery('#Taxonomy').jstree('get_selected').attr('id');

	        if(typeof selectedNode == 'undefined')
			{
		    	jQuery.msgBox({
		    	    title:"Alert",
		    	    content:"Please Select Taxonomy Node!"
		    	});
		    	return;
			}
	       
	       var nodInfo = jQuery("#" + selectedNode);
	       var node_name  = nodInfo.children("a").text();
	      
	       var level = jQuery('#Taxonomy').jstree('get_selected').attr('rel');
       	   if(level=="9")
       		{
       		  jQuery.msgBox({
	    	    title:"You have reached the final level",
	    	    content:"You cannot add a new node.",
	    	    type:"info",
	    	    }); 
       		}
       	    else
       		{
	            jQuery.msgBox({
				    title: "Are You Sure",
				    content: "Would you like to create new node under "+node_name+"?",
				    type: "confirm",
				    buttons: [{ value: "Yes" }, { value: "No" }, { value: "Cancel"}],
				    success: function (result) {
				        if (result == "Yes") {
				        noNode=false;		
				        jQuery("#Taxonomy").jstree("create"); 
				        
				        }
				        if(result == "No" || result == "Cancel")
				        {
				          return false;
				        }
				    }
				 }); 
       		}//end else
	  }
		
	});

	 jQuery("#rename").click(function () {
		
		  var selectedNode=jQuery('#Taxonomy').jstree('get_selected').attr('id');

	        if(typeof selectedNode == 'undefined')
			{
		    	jQuery.msgBox({
		    	    title:"Alert",
		    	    content:"Please Select Taxonomy Node!"
		    	});
		    	return;
			} 

	       var nodInfo = jQuery("#" + selectedNode);
	       var node_name  = nodInfo.children("a").text();
	       
		  jQuery.msgBox({
			    title: "Are You Sure",
			    content: "Would you like to rename "+node_name+"?",
			    type: "confirm",
			    buttons: [{ value: "Yes" }, { value: "No" }, { value: "Cancel"}],
			    success: function (result) {
			        if (result == "Yes") {
			        	jQuery("#Taxonomy").jstree('rename');
			        }
			        if(result == "No" || result == "Cancel")
			        {
			        	return;
			        }
			    }
			}); 
		    //jQuery("#Taxonomy").jstree(this.id);
		 });
	 
	 jQuery("#remove").click(function () {
		 
		// alert(jQuery('#Taxonomy').jstree('get_selected').attr('id'));
        var selectedNode=jQuery('#Taxonomy').jstree('get_selected').attr('id');

        if(typeof selectedNode == 'undefined')
		{
	    	jQuery.msgBox({
	    	    title:"Alert",
	    	    content:"Please Select Taxonomy Node!"
	    	});
	    	return;
		}
        
        var nodInfo = jQuery("#" + selectedNode);
	    var node_name  = nodInfo.children("a").text();
        
	    if(!isNaN(stdCountGlobal))
        {
       	 if(stdCountGlobal>0)
       	 {
       		 //alert("Standard Associated to Node");
       		 var textAdd;
       		 if(stdCountGlobal=='1')
       		 {
       			 textAdd="is " + stdCountGlobal+" Standard";
       		 }
       		 else
       		 {
       			 textAdd="are " + stdCountGlobal+" Standards";
       		 }
       		 jQuery.msgBox({
    	    	    title:"Can't remove!!!",
    	    	    content:"There "+textAdd+" associated.",
    	    	    type:"info",
    	    	    }); 
       		 return;
       	 }
       	
        }
	    
	    
	    
		 jQuery.msgBox({
			    title: "Are You Sure",
			    content: "Would you like to remove "+node_name+"?",
			    type: "confirm",
			    buttons: [{ value: "Yes" }, { value: "No" }, { value: "Cancel"}],
			    success: function (result) {
			        if (result == "Yes") {
			        	jQuery("#Taxonomy").jstree('remove');
			        	return;
			        }
			        if(result == "No" || result == "Cancel")
			        {
			          return false;
			        }
			    }
			});
		    //jQuery("#Taxonomy").jstree(this.id);
		 });
	    if(!noNode)
		{
		callme();
		}
});

jQuery("#clear").click(function () {
	document.getElementById("text").value="";
	jQuery("#Taxonomy").jstree("clear_search");
	jQuery("#Taxonomy").jstree("close_all", -1);
	jQuery("#Taxonomy").jstree("open_node","#1");
});

jQuery("#search").click(function () {
	
	var searchString=document.getElementById("text").value;
	if(searchString=='')
	{
		jQuery.msgBox({
	 	    title:"Can't Search!!!",
	 	    content:"Please provide search string.",
	 	    type:"info",
	 	    }); 
		return;
	}
	jQuery("#Taxonomy").jstree("search", searchString);
});


function callme()
{
	
	var tree = jQuery("#Taxonomy");
    tree.bind("loaded.jstree", function (event, data) {
      //  tree.jstree("open_all");
    });
	jQuery("#Taxonomy").jstree({  
		"types" :{
			"max_depth": 9,
			"valid_children" : [ "1" ]
		},
		"xml_data" : {
            "ajax" : {
            	"type" : "POST",
                "url" : "<%=renderResponse.encodeURL(ajaxURL.toString())%>", 
                "async": false,
                "cache": false,
                "data" : function (n) {
                		                    return {
                		                        action : "xmlTaxonomy"
                		                    };
                           }
            },
            "xsl" : "nest"
        },
        "plugins" : [ "themes", "xml_data" ,"ui", "crrm" ,"cookies","dnd","contextmenu","types","search"],
        "ui" : {
            "select_multiple_modifier" : "false",
             "select_limit" : 1,
        	 "selected_parent_close" : "select_parent",
        	 "initially_select" : [ "phtml_1" ]
         },
         
         "themes" : {
        	 "icons" : false
         },
          "contextmenu" : {
        	  select_node: true,
        	  show_at_node: false,
        	  items: {
        		    "ccp" : false,
        		    "remove": false,
        		    "rename": false,
        		    "create" : {
        		        // The item label
        		        "label" : "Add Node",
    		       	    "action" : function( node ) { 
    		       	   var title=jQuery(this._get_node(node)).find("a:first").text();
    		       	   var level = node.attr('rel');
    		       	   if(level=="9")
    		       		{
    		       		  jQuery.msgBox({
    			    	    title:"You have reached the final level",
    			    	    content:"You cannot add a new node.",
    			    	    type:"info",
    			    	    }); 
    		       		}
    		       	    else
    		       		{
		    		       	   jQuery.msgBox({
		    					    title: "Are You Sure",
		    					    content: "Would you like to create new node under "+title+"?",
		    					    type: "confirm",
		    					    buttons: [{ value: "Yes" }, { value: "No" }, { value: "Cancel"}],
		    					    success: function (result) {
		    					        if (result == "Yes") {
		    					        
		    					        	return {createItem: jQuery("#Taxonomy").jstree("create")}; 
		    					        	
		    					        }
		    					        if(result == "No" || result == "Cancel")
		    					        {
		    					          return false;
		    					        }
		    					    }
		    					 });
    		       		  }//end else
    			   	    }//action
        		    },
        		    "renameItem": { 
			             label: "Rename Node",
			             action: function (node) {
		         
			           	 var title=jQuery(this._get_node(node)).find("a:first").text();
		                 jQuery.msgBox({
	    					    title: "Are You Sure",
	    					    content: "Would you like to rename "+title+" ?",
	    					    type: "confirm",
	    					    buttons: [{ value: "Yes" }, { value: "No" }, { value: "Cancel"}],
	    					    success: function (result) {
	    					        if (result == "Yes") {
	    					        
	    					        	return {renameItem: jQuery("#Taxonomy").jstree("rename")}; 
	    					        	
	    					        }
	    					        if(result == "No" || result == "Cancel")
	    					        {
	    					          return false;
	    					        }
	    					    }
	    					 });
			             }//action
			         },//rename
			         
			         "deleteItem": { 
			             label: "Remove Node",
			             action: function (node) {
			             var title=jQuery(this._get_node(node)).find("a:first").text();
			            
			            // alert("stdCountGlobal====>>>>"+stdCountGlobal);
			             if(!isNaN(stdCountGlobal))
			             {
			            	 if(stdCountGlobal>0)
			            	 {
			            		 //alert("Standard Associated to Node");
			            		 var textAdd;
			            		 if(stdCountGlobal=='1')
			            		 {
			            			 textAdd="is " + stdCountGlobal+" Standard";
			            		 }
			            		 else
			            		 {
			            			 textAdd="are " + stdCountGlobal+" Standards";
			            		 }
			            		 jQuery.msgBox({
			         	    	    title:"Can't remove!!!",
			         	    	    content:"There "+textAdd+" associated.",
			         	    	    type:"info",
			         	    	    }); 
			            		 return;
			            	 }
			            	
			             }
			              
			             jQuery.msgBox({
	    					    title: "Are You Sure",
	    					    content: "Would you like to remove "+title+"?",
	    					    type: "confirm",
	    					    buttons: [{ value: "Yes" }, { value: "No" }, { value: "Cancel"}],
	    					    success: function (result) {
	    					        if (result == "Yes") {
	    					        
	    					        	return {deleteItem: jQuery("#Taxonomy").jstree("remove")}; 
	    					        	
	    					        }
	    					        if(result == "No" || result == "Cancel")
	    					        {
	    					          return false;
	    					        }
	    					    }
	    					 });
			             }//action
			         }//delete
			         
			        
         
        		}
        	} ,
         "core" : { "initially_open" : [ "1" ] },
         "crrm" : {
             "move" : {
                 "check_move" : function (data) {
                     //alert("1===>>>>"+data.r.attr("id"));
 				    //alert("2===>>>>"+data.o.attr("id")); 
 					//alert("3===>>>>"+data.op.attr("id")); 
 					
                     if(data.r.attr("id") == data.op.attr("id")) //can not move inside own parent
 					{
                         return false;
                     }else
 					{
 					   return true;
 					}
 					return true;
                 }
             }
         }		 
	})
	.delegate(".tree_item", "click", function (event, data) {
				jQuery("div.hidden_tree_data").hide(200);
				jQuery("div.all_brands_pop_up").hide();
				var id=jQuery(this).parent().attr("id");
				var chainCd = '<%=chainCode%>';
    			jQuery.trim(chainCd);
    		    jQuery('#Taxonomy').jstree("select_node", "#" + id,true);
    	 		if(chainCd=="GL")
    		    {
    	 			jQuery('p.hidden_description').html("Enter Taxonomy Description");
    		    }else
    		    {
    		    	jQuery.post("<%=renderResponse.encodeURL(ajaxURL.toString())%>",{action: "getDescData",taxonomyId: id, brand: chainCd},
    	   		    	function(msg){
    	   		    		var message = JSON.parse(msg);
    			    		var descriptionData = message.singleBrandDesc;
    			    		console.log("descriptionData::: for id & brand :: "+descriptionData+" -"+id+"- "+chainCd);
    			    		
    			    		if(descriptionData == 'undefined')
 			    			{
   			    				jQuery('p.hidden_description').html("Enter Taxonomy Description");
   			    			}
    			    		else if(typeof descriptionData == 'undefined' )
   			    			{
    			    			jQuery('p.hidden_description').html("Enter Taxonomy Description");
   			    			}
    			    		else if(descriptionData == ' ')
		    				{
    			    			jQuery('p.hidden_description').html("Enter Taxonomy Description");
		    				}
    			    		else if(descriptionData == null)
	    					{
    			    			jQuery('p.hidden_description').html("Enter Taxonomy Description");
	    					}
    			    		else if(descriptionData == '')
   			    			{
    			    			jQuery('p.hidden_description').html("Enter Taxonomy Description");
   			    			}
    			    		else
   			    			{
   	   			    			jQuery('p.hidden_description').html(descriptionData);
   			    			}
    	   		        });
    	 		}
				// event.preventDefault(); 
				
    	 		
    			jQuery(this).siblings("div.hidden_tree_data").show(200);
				 })
				 
    .delegate(".close_hidden_tree_data", "click", function (event, data) {
    				 /* jQuery('p.hidden_description').html("Enter Taxonomy Description"); */
    				 jQuery("div.all_brands_pop_up").hide();
    				 jQuery(this).parent().parent("div.hidden_tree_data").hide(200);
    				 jQuery("#Taxonomy").jstree("refresh"); 
    				// event.preventDefault(); 
				 }) 
	.bind("rename.jstree", function (e, data) {
		 var node = jQuery(data.rslt.obj);
		 var nodeID = node.attr('id');
		 //jQuery("#loading").fadeIn('slow');
		 jQuery.blockUI({ message: '<h3><img src="/BSTheme-theme/images/busy.gif" /> Please wait...</h3>' });
	   jQuery.post("<%=renderResponse.encodeURL(ajaxURL.toString())%>", {action:"renameTaxonomy",taxonomyId: data.rslt.obj.attr("id"),newName:data.rslt.new_name,oldName:data.rslt.old_name }, 
	    		function(msg){
		        var message = JSON.parse(msg);
		        if(message.response=="Success")
      			{
		       	 jQuery("#"+nodeID).find("p:first").html(data.rslt.new_name+"<span class='instructional_text'>Click the text below to edit.</span>");
		       	jQuery.blockUI({ message: '<h3><img src="/BSTheme-theme/images/busy.gif" /> '+message.response+': '+message.message+'</h3>' });
    			setTimeout(function () {
  					jQuery.unblockUI();
  	            },
  	            2000);
	    		/*  jQuery("#response").html(message.response+": "+message.message);
    	            jQuery("#response").slideDown('slow');
    	            setTimeout(function () {
    	                jQuery("#response").slideUp("slow", function () {});
    	            },
    	            2000);
    	    	  jQuery("#loading").fadeOut('slow'); */ 
    	    	 /*  jQuery("#Taxonomy").jstree("refresh"); 
		    	  tree.bind("loaded.jstree", function (event, data) {
		    	   //  tree.jstree("open_all");
		    	  });   */ 
      			}
        		else
        		{
        			/* jQuery("#response").html(message.response+": "+message.message);
    	            jQuery("#response").slideDown('slow');
    	            setTimeout(function () {
    	                jQuery("#response").slideUp("slow", function () {});
    	            },
    	            2000);
    	            jQuery("#loading").fadeOut('slow'); */
    	            jQuery.blockUI({ message: '<h3><img src="/BSTheme-theme/images/busy.gif" /> '+message.response+': '+message.message+'</h3>' });
        			setTimeout(function () {
      					jQuery.unblockUI();
      	            },
      	            2000);
    	            jQuery.jstree.rollback(data.rlbk);
        		}  
	    	})
	   
	 })
	  .bind("remove.jstree", function (e, data) {
		  
		  var node = jQuery(data.rslt.obj);
		  var nodeID = node.attr('id');
		  var title=data.inst.get_text(data.rslt.obj);
		   // alert("===>>"+title);
             //alert("nodeID=====>>>>"+nodeID);
		    var children = jQuery.jstree._reference('#Taxonomy')._get_children(node);
		   // alert(children.length);
		    if (children.length>=1){
		    	jQuery.msgBox({
	    	    title:"This is Parent Node !!!",
	    	    content:"You can not remove "+title+".",
	    	    type:"info",
	    	    param:"removeTaxonomy"
	    	    }); 
		    	
		        jQuery.jstree.rollback(data.rlbk);
		      //  jQuery.jstree.focused().select_node("#"+nodeID); 
		        jQuery("#Taxonomy").jstree("deselect_all");  
		        jQuery("#Taxonomy").jstree("select_node", "#"+nodeID); 
		     //jQuery("selector > .to #Taxonomy").jstree("select_node","#"+nodeID); 
		     return;
		    }
		    /* if (children.length==0){
		    	jQuery.msgBox({
		    	    title:"This is Parent Taxonomy !!!",
		    	    content:"You can not remove "+title+".",
		    	    type:"info"
		    	});
		    jQuery.jstree.rollback(data.rlbk);
		    return false;
		    } */
			
		  //jQuery("#loading").fadeIn('slow');
		    jQuery.blockUI({ message: '<h3><img src="/BSTheme-theme/images/busy.gif" /> Please wait...</h3>' });
		    data.rslt.obj.each(function () {
		    	
		    	if(data.rslt.parent==-1)
                {
		    	   noNode=true;
		    	}
	        	jQuery.post("<%=renderResponse.encodeURL(ajaxURL.toString())%>", {action:"removeTaxonomy",taxonomyId: this.id.replace("node_","")}, 
	        	 		function(msg){
		              var message = JSON.parse(msg);
		    	      if(message.response=="Success")
		      			{
		    	    	  /* jQuery("#response").html(message.response+": "+message.message);
		    	            jQuery("#response").slideDown('slow');
		    	            setTimeout(function () {
		    	                jQuery("#response").slideUp("slow", function () {});
		    	            },
		    	            2000);
		    	    	  jQuery("#loading").fadeOut('slow'); */
		    	    	  jQuery.blockUI({ message: '<h3><img src="/BSTheme-theme/images/busy.gif" /> '+message.response+': '+message.message+'</h3>' });
		        			setTimeout(function () {
		      					jQuery.unblockUI();
		      	            },
		      	            2000);
		    	    	   if(data.rslt.parent==-1)
			                {
					    	   //alert("parent");	
					    	   noNode=true;
					    	}
		      			}
		        		else
		        		{
		        			/* jQuery("#response").html(message.response+": "+message.message);
		    	            jQuery("#response").slideDown('slow');
		    	            setTimeout(function () {
		    	                jQuery("#response").slideUp("slow", function () {});
		    	            },
		    	            2000);
		    	            jQuery("#loading").fadeOut('slow'); */
		    	            jQuery.blockUI({ message: '<h3><img src="/BSTheme-theme/images/busy.gif" /> '+message.response+': '+message.message+'</h3>' });
		        			setTimeout(function () {
		      					jQuery.unblockUI();
		      	            },
		      	            2000);
		        		  jQuery.jstree.rollback(data.rlbk);
		        		}   
				}); 
	        });
     })
	 .bind("create.jstree", function (e, data) {
		 
		//jQuery("#loading").fadeIn('slow');
		jQuery.blockUI({ message: '<h3><img src="/BSTheme-theme/images/busy.gif" /> Please wait...</h3>' });
	  
		if (data.rslt.parent==-1)//starting of Node
		{
				jQuery.post("<%=renderResponse.encodeURL(ajaxURL.toString())%>", {action: "createTaxonomy",parentId: 0,position: 0,title:data.rslt.name }, 
			    		function(msg){
					var message = JSON.parse(msg);
					if(message.response=="Success")
	      			{
					//alert(message.id);
					jQuery(data.rslt.obj).attr("id", message.id);
	    	    	 /*  jQuery("#response").html(message.response+": "+message.message);
	    	            jQuery("#response").slideDown('slow');
	    	            setTimeout(function () {
	    	                jQuery("#response").slideUp("slow", function () {});
	    	            },
	    	            2000);
	    	    	  jQuery("#loading").fadeOut('slow'); */
	    	    	  jQuery.blockUI({ message: '<h3><img src="/BSTheme-theme/images/busy.gif" /> '+message.response+': '+message.message+'</h3>' });
	        			setTimeout(function () {
	      					jQuery.unblockUI();
	      	            },
	      	            2000);
	    	    	  jQuery("#Taxonomy").jstree("refresh",-1); 
			    	}
	        		else
	        		{
	        			/* jQuery("#response").html(message.response+": "+message.message);
	    	            jQuery("#response").slideDown('slow');
	    	            setTimeout(function () {
	    	                jQuery("#response").slideUp("slow", function () {});
	    	            },
	    	            2000);
	    	            jQuery("#loading").fadeOut('slow'); */
	    	            jQuery.blockUI({ message: '<h3><img src="/BSTheme-theme/images/busy.gif" /> '+message.response+': '+message.message+'</h3>' });
	        			setTimeout(function () {
	      					jQuery.unblockUI();
	      	            },
	      	            2000);
	    	           jQuery.jstree.rollback(data.rlbk);
	        		}   
					   
			    	})
		}else
		{ 
			rel=Number(data.rslt.parent.attr("rel"));
			relInc=rel+1;
			    jQuery.post("<%=renderResponse.encodeURL(ajaxURL.toString())%>", {action: "createTaxonomy",parentId: data.rslt.parent.attr("id"),position:  data.rslt.position,title:data.rslt.name }, 
			    	function(msg){
			    	var message = JSON.parse(msg);
			    	 if(message.response=="Success")
		      			{
			    		jQuery(data.rslt.obj).attr("id", message.id);
			    		jQuery(data.rslt.obj).attr("rel",relInc);
			    		 jQuery("#"+message.id).append(cogHtml);
			    		 jQuery("#"+message.id).append(addHiddenTreeData(data.rslt.name,message.id));
			    		 
			    		 jQuery.blockUI({ message: '<h3><img src="/BSTheme-theme/images/busy.gif" /> '+message.response+': '+message.message+'</h3>' });
			   	    	   setTimeout(function () {
								jQuery.unblockUI();
				            },
				            2000);
			    		/*  jQuery("#response").html(message.response+": "+message.message);
		    	            jQuery("#response").slideDown('slow');
		    	            setTimeout(function () {
		    	                jQuery("#response").slideUp("slow", function () {});
		    	            },
		    	            2000);
		    	    	  jQuery("#loading").fadeOut('slow');  */
		    	    	}
		        		else
		        		{
		        			/* jQuery("#response").html(message.response+": "+message.message);
		    	            jQuery("#response").slideDown('slow');
		    	            setTimeout(function () {
		    	                jQuery("#response").slideUp("slow", function () {});
		    	            },
		    	            2000);
		    	            jQuery("#loading").fadeOut('slow'); */
		    	            jQuery.blockUI({ message: '<h3><img src="/BSTheme-theme/images/busy.gif" /> '+message.response+': '+message.message+'</h3>' });
		        			setTimeout(function () {
		      					jQuery.unblockUI();
		      	            },
		      	            2000);
		    	            jQuery.jstree.rollback(data.rlbk);
		        		}   
			    	})
		}
		})
		 .bind("move_node.jstree", function (e, data) {
			  var title=data.inst.get_text(data.rslt.o);
			  
			  //alert(data.inst._get_parent(data.rslt.obj).attr('id')); 
			  //var refId=data.rslt.np.attr("id").replace("node_","");
			  /* if(isNaN(refId))
			  {
				  jQuery.msgBox({
			    	    title:"Alert",
			    	    content:"This move is not valid!"
			    	});
				    jQuery.jstree.rollback(data.rlbk);
			    	return;	  
			   } */
			  
			 jQuery.msgBox({
				    title: "Are You Sure",
				    content: "Would you like to move "+title+"?",
				    type: "confirm",
				    buttons: [{ value: "Yes" }, { value: "No" }, { value: "Cancel"}],
				    success: function (result) {
				        if (result == "Yes") {
				        	
				        	 data.rslt.o.each(function (i) {
				        		 
				        		// alert("Position===="+data.rslt.cp);
									//alert("id========"+jQuery(this).attr("id"));
									//alert("ref======"+data.rslt.np.attr("id"));
				        		 
						 	        //jQuery("#loading").fadeIn('slow');
						 	        jQuery.blockUI({ message: '<h3><img src="/BSTheme-theme/images/busy.gif" /> Please wait...</h3>' });
									jQuery.post("<%=renderResponse.encodeURL(ajaxURL.toString())%>", {action: "moveTaxonomy" ,taxonomyId: jQuery(this).attr("id").replace("node_",""),position: data.rslt.cp + i,referenceId: data.rslt.np.attr("id").replace("node_","")}, 
										    		function(msg){
										              var message = JSON.parse(msg);
										    	      if(message.response=="Success")
										      			{
										    	    	 // jQuery(data.rslt.oc).attr("id", "node_" + '11');
										    	    	 /*  jQuery("#response").html(message.response+": "+message.message);
										    	            jQuery("#response").slideDown('slow');
										    	            setTimeout(function () {
										    	                jQuery("#response").slideUp("slow", function () {});
										    	            },
										    	            2000);
										    	    	  jQuery("#loading").fadeOut('slow'); */
										    	    	  jQuery.blockUI({ message: '<h3><img src="/BSTheme-theme/images/busy.gif" /> '+message.response+': '+message.message+'</h3>' });
										        			setTimeout(function () {
										      					jQuery.unblockUI();
										      	            },
										      	            2000);
										    	    	 // jQuery("#Taxonomy").jstree("refresh"); 
										    	    	//  tree.jstree("open_all",-1);
													      /*  tree.bind("loaded.jstree", function (event, data) {
													    	  tree.jstree("open_all");
													       });  */
										      			}
										        		else
										        		{
										        			/* jQuery("#response").html(message.response+": "+message.message);
										    	            jQuery("#response").slideDown('slow');
										    	            setTimeout(function () {
										    	                jQuery("#response").slideUp("slow", function () {});
										    	            },
										    	            2000);
										    	            jQuery("#loading").fadeOut('slow'); */
										    	            jQuery.blockUI({ message: '<h3><img src="/BSTheme-theme/images/busy.gif" /> '+message.response+': '+message.message+'</h3>' });
										        			setTimeout(function () {
										      					jQuery.unblockUI();
										      	            },
										      	            2000);
										        		  jQuery.jstree.rollback(data.rlbk);
										        		}   
												}); 	       	  
						 	        }); 
				        	
				        }
				        if(result == "No" || result == "Cancel")
				        {
				        	e.stopImmediatePropagation();
				        	jQuery.jstree.rollback(data.rlbk);
				        	jQuery("#Taxonomy").jstree("deselect_all");
				        	//jQuery("#Taxonomy").jstree("refresh",-1);
				        	return false;
				         /* 
				         jQuery("#Taxonomy").jstree("refresh") */
				         //jQuery("#Taxonomy").jstree("refresh",-1);
				         //jQuery.jstree._reference(jQuery("#Taxonomy")).refresh(-1);
				         //e.stopImmediatePropagation();
			 	         //return false; 
				          //return;
				        }
				    }
				});
			
	 	    })
			 	   .bind("loaded.jstree", function(e,data) {
			 	        /* handler  code */
			 	        //alert("Tree loaded");
			 	        
			 	    })
			 	    .bind("select_node.jstree", function(evt, data){
					            //selected node object: data.inst.get_json()[0];
					            //selected node text: data.inst.get_json()[0].data
					           // alert("selected");
					            var node_id =data.rslt.obj.attr("id");
					           // alert('you selected the node '+node_id);
					          // alert("====>>>>"+upload);
					           if(upload)
					            {
					        	   var a = jQuery.jstree._focused().get_selected();
					               jQuery(a).children("div.hidden_tree_data").show(200);
					               upload=false;
			 	                }
					           
					           
					           //code for standard count validation part
					           var textBoxName="stdCount"+node_id;
					  		   //alert(jQuery("#"+textBoxName).val());
					  		   stdCountGlobal=jQuery("#"+textBoxName).val();
					  		}) 
					  		.bind("search.jstree", function (e, data) {
					  		  var searchCount=data.rslt.nodes.length;
						       if(searchCount>0){
									  var textAdd;
									  if(searchCount=='1')
							       		 {
							       			 textAdd="Found <b>" + data.rslt.nodes.length + "</b> node matching keyword <b>'" + data.rslt.str + "'</b>.";
							       		 }
							       		 else
							       		 {
							       			 textAdd="Found <b>" + data.rslt.nodes.length + "</b> nodes matching keyword <b>'" + data.rslt.str + "'</b>.";
							       		 }
									  jQuery.msgBox({
									 	    title:"Search Result:",
									 	    content:textAdd,
									 	    type:"info",
									 	    }); 
									  
								  }else
								  {
									  jQuery.msgBox({
									 	    title:"Search Result:",
									 	    content:"Found <b>" + 0 + "</b> nodes matching keyword <b>'" + data.rslt.str + "'</b>.",
									 	    type:"info",
									 	    });  
									    jQuery("#Taxonomy").jstree("close_all", -1);
										jQuery("#Taxonomy").jstree("open_node","#1");
								  }
						  		    })/* .bind("before.jstree", function (e, data) {
						  		    	
						  		      if(data.func == "move_node" && data.args[1] == false && data.plugin
						  		    		== "core") {
									  		    var r=confirm("Press a button!");
									  			if (r==true)
									  			  {
									  			  alert("You pressed OK!");
									  			  }
									  			else
									  			  {
									  			  
									  			  e.stopImmediatePropagation();
									  			   return false
									  			  } }
						  		    }) */ ;
	
	
	
	
}
 
</script>
   </div><!--ends rounded_container -->
    <div class="rounded_container_bottom"></div>
 </div>
</div>
<%}else{%>
	
	You don't have admin access.
	
<%}	} else {
%>
	Not logged in !!
<%
	}
%>
</body>
</html>


<!-- 
Here is the structure of data.rslt:

.o - the node being moved
.r - the reference node in the move
.ot - the origin tree instance
.rt - the reference tree instance
.p - the position to move to (may be a string - "last", "first", etc)
.cp - the calculated position to move to (always a number)
.np - the new parent
.oc - the original node (if there was a copy)
.cy - boolen indicating if the move was a copy
.cr - same as np, but if a root node is created this is -1
.op - the former parent
.or - the node that was previously in the position of the moved node

 -->