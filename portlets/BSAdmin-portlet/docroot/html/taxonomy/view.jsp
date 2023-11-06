<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"> 

<%@ page import="javax.portlet.*"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<portlet:defineObjects />

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<!-- <script type="text/javascript" src="/BSTheme-theme/js/treeAdmin/jquery-1.4.4.js"></script>
	<script type="text/javascript" src="/BSTheme-theme/js/jquery-1.4.2.min.js"></script>
   -->  
   <script type="text/javascript" src="/BSTheme-theme/js/jquery-1.4.2.min.js"></script>
   <script type="text/javascript" src="/BSTheme-theme/js/treeAdmin/jquery-ui.js"></script>
	<script type="text/javascript" src="/BSTheme-theme/js/treeAdmin/jquery.cookie.js"></script>
	<script type="text/javascript" src="/BSTheme-theme/js/treeAdmin/jquery.hotkeys.js"></script>
	<script type="text/javascript" src="/BSTheme-theme/js/treeAdmin/jquery.jstreeTaxonomy.js"></script>
	<script type="text/javascript" src="/BSTheme-theme/js/treeAdmin/!script.js"></script>
	<script type="text/javascript" src="/BSTheme-theme/js/ajaxObject.js"></script>
    <script type="text/javascript" src="/BSTheme-theme/js/yahoo-dom-event.js"></script>
    <script type="text/javascript" src="/BSTheme-theme/js/connection-min.js"></script>
    <script type="text/javascript" src="/BSTheme-theme/js/json2.js"></script>
    <script type="text/javascript" src="/BSTheme-theme/js/treeAdmin/jquery.msgBox.js"></script>
    <%@include file="/html/common/initmenu.jsp" %>
    <link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/tree/!style.css"/>
	<link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/tree/custom/!style.css"/>
	<link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/msgBoxLight.css"/>
	
	<style>
	#indexTop {position: relative;}
	#title {position: relative; float: left;}
	#btnPosition {position: relative; float: right;}
	</style>
	
</head>
<body>
<%
long userId = PortalUtil.getUserId(renderRequest);
if (userId > 1)
{%>

<portlet:resourceURL var="ajaxURL" id="getTreeData" escapeXml="false" />
<!--ends ajax on tree -->

<div>
	<div class="rounded_container">
		<div class="rounded_container_contents">
			<div id="indexTop">
				<div id="title"><h4>Select Content Group</h4></div>
				<div id="btnPosition">
					<!--
					<input type="button" id="clear" alt="Clear" type="button" style="display:block; float:right;" value="clear"/>
					<input type="button" id="search" alt="Search" style="display:block; float:right;" value="search"/>
					<input type="text"  id="text" alt="Search Text" style="display:block; float:right;" value=""/> 
					-->
				</div>
				<div style="clear: both;"></div>
			</div>

         <p>Click on the arrows to expand the tree. Click on each icon to the right of the labels to view details.</p>
<img id="loading" src="/BSTheme-theme/images/loading.gif" alt="loading" title="loading"/>
<div id="Taxonomy" class=" jstree jstree-4 jstree-default jstree-focused"></div>	
<script type="text/javascript">
jQuery(function () {
	 jQuery("div.hidden_tree_data").hide();
	 	callme();
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
			"max_depth": 5,
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
        "plugins" : [ "themes", "xml_data" ,"crrm" ,"types","search"],
         "themes" : {
        	 "icons" : false
         }, 
         "core" : { "initially_open" : [ "1" ] } 
	})
	.delegate(".tree_item", "click", function (event, data) {
		         var id=jQuery(this).parent().attr("id");
		         jQuery('li.#'+ id).find(".tree_node:first").css("color", "#d21d8e");
    			 jQuery(this).siblings("div.hidden_tree_data").show(200);
				// event.preventDefault(); 
				 })
    .delegate(".close_hidden_tree_data", "click", function (event, data) {
    	         var id=jQuery(this).parent().parent().parent().attr("id");
                 jQuery('li.#'+ id).find(".tree_node:first").css("color", "#000");
    			 jQuery(this).parent().parent("div.hidden_tree_data").hide(200);
    			// event.preventDefault(); 
				 })
    .delegate(".tree_node", "click", function (event, data) {
		         var id=jQuery(this).parent().attr("id");
		         jQuery('li.#'+ id).find(".tree_node:first").css("color", "#d21d8e");
    			 jQuery(this).siblings("div.hidden_tree_data").show(200);
		       // event.preventDefault(); 
				 }) 
	 .bind("loaded.jstree", function(e,data) {
			 	    /* handler  code */
			 	    //Hiding root node
			 	    jQuery("ul:contains('Root Of Tree')").css('position','relative');
					jQuery("ul:contains('Root Of Tree')").css('top','-20px');
					jQuery("ul:contains('Root Of Tree')").css('left','-20px');
			 		  
			 		jQuery("a:contains('Root Of Tree')").css("visibility","hidden");
			 		jQuery(".jstree-last .jstree-icon").first().hide();
			 		jQuery(".tree_item").first().hide();
			 		//End Hiding root node 
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
		  });
}
 
 

</script>
   </div><!--ends rounded_container -->
    <div class="rounded_container_bottom"></div>
    </div>
  </div><!--ends grid_9 -->
<%
	} else {
%>
	Not logged in !!
<%
	}
%>
</body>
</html>