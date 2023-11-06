<script type="text/javascript" src="/BSTheme-theme/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/treeAdmin/jquery.msgBox.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/treeAdmin/jquery.blockUI.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/jquery.nyroModal.custom.min.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/jquery-ui-1.10.1.custom.min.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/jquery.multiselect.min.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/jquery.validate.min-1.11.0.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/jquery.form.3.28.0.js"></script>

<link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/msgBoxLight.css"/>
<link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/bsstyle.css"/>
<link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/jquery.multiselect.css"/>
<link href="/BSTheme-theme/css/other/jquery-ui-1.10.1/themes/base/jquery.ui.all.css" rel="stylesheet" type="text/css" />

<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@page import="com.ihg.brandstandards.util.StandardsCountryManagementUtil"%>
<%@page import="com.ihg.brandstandards.db.model.StandardsCountryExt" %> 
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.ihg.brandstandards.util.BrandStandardsUtil"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>

<%@include file="/html/init.jsp" %>

<%
Map <String, String> ctrymap = StandardsCountryManagementUtil.getCtryMap();

List<StandardsCountryExt> list = (List<StandardsCountryExt>)renderRequest.getAttribute("standardsCountryRegionList");

long userId = PortalUtil.getUserId(renderRequest);
if (userId > 1)
{ 
	boolean flag = request.isUserInRole(BrandStandardsUtil.MANAGE_COUNTRIES_ROLE); 
    if(flag){
%>

<portlet:resourceURL var="createCountryRegionPopup" id="createCountryRegionPopupURL" />
<portlet:resourceURL var="editCountryRegionPopup" id="editCountryRegionPopupURL"></portlet:resourceURL>
<portlet:resourceURL var="createAttributeContentPopup" id="createAttributeContentPopupURL" />
<portlet:resourceURL var="unAttributeContentPopup" id="unAttributeContentPopupURL" />
<div class="rounded_container">
	<div class="rounded_container_contents">
	<h4 class="short_page_subtitle">Manage Countries/Region</h4>
	<div class="report_container">
			
		<div class="button uielem_btn">
			<a class="results_filter" title="Un-Attribute Content" href="javascript: void(0)" onclick="unAttributeContentPopup('${unAttributeContentPopup}')">Un-Attribute Content</a>
			<span></span>
		</div>

		<div class="button uielem_btn">
			<a class="results_filter" title="Attribute Content" href="javascript: void(0)" onclick="createAttributeContentPopup('${createAttributeContentPopup}')">Attribute Content</a>
			<span></span>
		</div>

		<div class="button uielem_btn">
			<a class="results_filter" title="Add New Country/Region" href="javascript: void(0)" onclick="createCountryRegionPopup('${createCountryRegionPopup}')">Add New Country/Region</a>
			<span></span>
		</div>
		
	</div>
	<div class="clear"></div>
	<div class="divider">&nbsp;</div>
	<div class="clear"></div>
	<table class="results_table">
		<thead>
			<tr class="results_header_bar">
				<th width="10%">Id</th>
				<th width="20%">Name</th>
				<th width="20%">Code</th>
				<th width="20%">Region Name</th>
				<th width="20%">Sub Region</th>
				<th width="10%">Actions</th>
			</tr>
		</thead>
		<tbody>
		<liferay-ui:search-container hover="false" searchContainer="${searchContainer}">
			<liferay-ui:search-container-results>
				<%
					pageContext.setAttribute("results", searchContainer.getResults());
					pageContext.setAttribute("total", searchContainer.getTotal());
					int currPage = searchContainer.getCur();
		    	%>
		    </liferay-ui:search-container-results>
		    <liferay-ui:search-container-row className="com.ihg.brandstandards.db.model.StandardsCountryExt" 
					keyProperty="countryCode" modelVar="countryModel" indexVar="ctryId">
			<portlet:resourceURL id='editCountryRegionPopupURL' var ="editCountryRegionPopup" />
				
			<tr>
				<c:set var="countryCode" value="${countryModel.countryCode}"></c:set>
				<td><%=String.valueOf(searchContainer.getStart()+1+ctryId) %></td>
				<td><%= ctrymap.get(pageContext.getAttribute("countryCode")) != null ? ctrymap.get(pageContext.getAttribute("countryCode")) : "bs.country.name.cd."+pageContext.getAttribute("countryCode")%></td>
				<td>${countryModel.countryCode}</td>
				<td>${countryModel.getRegionCode()}</td>
				<td>${countryModel.getSubRegionCode()}</td>
				<td><a title="Edit Country/Region" href="#" onclick="editCountryRegionPopup('${editCountryRegionPopup}', this)" > <img alt="Edit Country/Region" title="Edit Country/Region" src="/BSTheme-theme/images/edit_pencil_icon.png"> </a></td>
			</tr>
			</liferay-ui:search-container-row>
			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</tbody>
	</table>
	<div class="rounded_container_bottom"></div>
	</div>
</div>

<div id="createCountryRegion_popup" style="display:none;"> </div>

<div id="createAttributeContent_popup" style="display:none;"> </div>

<div id="unAttributeContent_popup" style="display:none;"> </div>

<%}else{%>
	
	You don't have admin access.
	
<%}	} else {
%>
	Not logged in !!
<%
	}
%>
<style> 
#attributeOptions input,#unAttributOptions input {
    margin: 0 8px 0 0;
}
</style>
<script type="text/javascript">

	var countryRegionDialog = '';
	var standardsCountryRegion = 'Add Country/Region';
	var closeLabel = 'Cancel';
	
	jQuery(document).ready(function($) {
		countryRegionDialog = jQuery("#createCountryRegion_popup").dialog({
			title: standardsCountryRegion,
			closeText: closeLabel,
			autoOpen: false,
			center: true,
			resizable: false,
			width: 325,
			modal: true,
			open: function() {
				jQuery('.countryRegionPopupClose').bind('click', function() {
					countryRegionDialog.dialog('close');
				});
			}
		});
	});
	
	var attributeContentDialog = '';
	var standardsCountryAttribute = 'Attribute Content';
	var closeDialog = 'Close';
	
	jQuery(document).ready(function($) {
		attributeContentDialog = jQuery("#createAttributeContent_popup").dialog({
			title: standardsCountryAttribute,
			closeText: closeDialog,
			autoOpen: false,
			center: true,
			resizable: false,
			width: 325,
			modal: true,
			open: function() {
				jQuery('.attributeContentPopupClose').bind('click', function() {
						attributeContentDialog.dialog('close');
				});
			}
		});
	});
	
	var unAttributeContentDialog = '';
	var standardsCountryUnAttribute = 'Un Attribute Content';
	var closeDialog = 'Close';
	
	jQuery(document).ready(function($) {
		unAttributeContentDialog = jQuery("#unAttributeContent_popup").dialog({
			title: standardsCountryUnAttribute,
			closeText: closeDialog,
			autoOpen: false,
			center: true,
			resizable: false,
			width: 325,
			modal: true,
			open: function() {
				jQuery('.unAttributeContentPopupClose').bind('click', function() {
					unAttributeContentDialog.dialog('close');
				});
			}
		});
	});
	
	
	function createCountryRegionPopup(createCountryRegionPopupURL) {
		jQuery.ajax({
			url: createCountryRegionPopupURL,
			type: "POST",
			dataType: "text",
			beforeSend : function() {
				jQuery.blockUI({ message: '<h3><img src="/BSTheme-theme/images/busy.gif" /> Please wait...</h3>' });
        	},
			success: function(data) {
				jQuery.unblockUI();
				if (data != null && data != '' && typeof data != 'undefined') {
					jQuery('#createCountryRegion_popup').html(data);
					countryRegionDialog.dialog('option', 'title', 'Add Country/Region');
					countryRegionDialog.dialog("open");
				}
			}
		});
	}
	
	function createAttributeContentPopup(createAttributeContentPopupURL) {
		jQuery.ajax({
			url: createAttributeContentPopupURL,
			type: "POST",
			dataType: "text",
			beforeSend : function() {
				jQuery.blockUI({ message: '<h3><img src="/BSTheme-theme/images/busy.gif" /> Please wait...</h3>' });
        	},
			success: function(data) {
				jQuery.unblockUI();
				if (data != null && data != '' && typeof data != 'undefined') {
					jQuery('#createAttributeContent_popup').html(data);
					attributeContentDialog.dialog("open");
				}
			}
		});
	}
	
	function unAttributeContentPopup(unAttributeContentPopup) {
		jQuery.ajax({
			url: unAttributeContentPopup,
			type: "POST",
			dataType: "text",
			beforeSend : function() {
				jQuery.blockUI({ message: '<h3><img src="/BSTheme-theme/images/busy.gif" /> Please wait...</h3>' });
        	},
			success: function(data) {
				jQuery.unblockUI();
				if (data != null && data != '' && typeof data != 'undefined') {
					jQuery('#unAttributeContent_popup').html(data);
					unAttributeContentDialog.dialog("open");
				}
			}
		});
	}
	
	function editCountryRegionPopup(editCountryRegionPopupURL, editCountryCode) {
		var countryCode = jQuery('td:nth-child(3)',jQuery(editCountryCode).closest('tr')).text();
		jQuery.ajax({
			url: editCountryRegionPopupURL+ '&stdCountryCode='+ countryCode,
			type: "POST",
			dataType: "text",
			beforeSend : function() {
				jQuery.blockUI({ message: '<h3><img src="/BSTheme-theme/images/busy.gif" /> Please wait...</h3>' });
        	},
			success: function(data) {
				jQuery.unblockUI();
				if (data != null && data != '' && typeof data != 'undefined') {
					jQuery('#createCountryRegion_popup').html(data);
					countryRegionDialog.dialog('option', 'title', 'Edit Country/Region');
					countryRegionDialog.dialog("open");
				}
			}
		});
	}

</script>

