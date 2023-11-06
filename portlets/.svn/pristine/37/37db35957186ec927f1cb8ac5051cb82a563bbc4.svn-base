<%@include file="/html/userprefs/init.jsp" %>
<portlet:resourceURL id='viewAccessModal' var="viewAccessModal">
	<portlet:param name="modalType" value="viewAccess"></portlet:param>
</portlet:resourceURL>
<portlet:resourceURL id='viewNoAccessModal' var="viewNoAccessModal">
	<portlet:param name="modalType" value="viewNoAccess"></portlet:param>
</portlet:resourceURL>
<%
	AccessAndPreferences accessPrefs = (AccessAndPreferences) session.getAttribute("UserPreferences");
	String userName = "";
	String countryName = "";
	String languageName = "";
	String brandName = "";
	if(accessPrefs != null)
	{
		userName = accessPrefs.getUser().getFullName();
		countryName = accessPrefs.getCountryName();
		languageName = accessPrefs.getLangName();
		brandName = accessPrefs.getChainName();
	}
%>
	<small>
		${youAreViewing}&nbsp;
		<u id="<%=brandName %>"><%=brandName %></u> ${yourViewFor}&nbsp;
		<u id="<%=countryName %>"><%=countryName %></u> ${yourViewIn}&nbsp; 
		<u id="<%=languageName %>"><%=languageName %></u>
		<a href="#" onmousedown="_gaq.push(['_trackEvent', 'Header', 'BS_ChangePrefClick', 'User Preference Dialog']);" class="btn btn-mini changebtn">
			<i class="icon-cog"></i> ${change} 
		</a>
	</small>
<%-- </c:if> --%>

<div id="yourviewModal" title="${yourView}" style="display:none;">	</div>
<div id="noAccessModal" title="${noAccess}" style="display:none;">	</div>

<script type="text/javascript">
	var viewAccessModal = '${viewAccessModal}';
	var isBrandNotActive = '${isBrandNotActive}';
	var viewNoAccessModal = '${viewNoAccessModal}'+'&isBrandNotActive='+isBrandNotActive;
	var showAccessDialog = '${showAccessDialog}';
	var showNoAccessDialog = '${showNoAccessDialog}';
	var selectedBrandName = '<%=brandName%>';
	
	$(document).ready(function(){
	 
		var createAccessDialog = jQuery( "#yourviewModal" ).dialog({
			autoOpen: false,
			width: 560,
			resizable:false,
			modal: true,
			close: function() {
				if (selectedBrandName == null || selectedBrandName == '' || selectedBrandName == 'null' || typeof selectedBrandName == 'undefined') {
					window.location.reload();
				}
			}
		});
		jQuery( "#noaccessModal" ).dialog({
			autoOpen: true,
			width: 560,
			resizable:false,
			close: function(event, ui) {
				if (selectedBrandName == null || selectedBrandName == '' || selectedBrandName == 'null' || typeof selectedBrandName == 'undefined') {
					window.location.assign("/web/brand-standards/hotel/home");
				}
			  },
			modal: true,
			closeOnEscape: false,
			draggable: false,
			dialogClass: 'no-close' 
		});
		var createNoAccessDialog = jQuery( "#noAccessModal" ).dialog({
			autoOpen: false,
			width: 560,
			resizable:false,
			close: function(event, ui) {
				if (selectedBrandName == null || selectedBrandName == '' || selectedBrandName == 'null' || typeof selectedBrandName == 'undefined') {
					window.location.assign("/web/brand-standards/hotel/home");
				}
			  },
			modal: true,
			closeOnEscape: false,
			draggable: false,
			dialogClass: 'no-close'
		});
		
		$( ".changebtn" ).click(function() {
			$.ajax({
			  	url :viewAccessModal,
			  	type: "POST",
			  	dataType: "text",
			    success: function(data) {
			    	if (data != null && data != '' && typeof data != 'undefined') {
			    		$('#yourviewModal').html(data);
			    		createAccessDialog.dialog( "open" );
			    	}
			    },
				error: function(error) {
		 			window.location.assign("/web/brand-standards/hotel/home");
		 		}
			 });
		});
		if(showAccessDialog == 'true'){
			 $.ajax({
			  	url :viewAccessModal,
			  	type: "POST",
			  	dataType: "text",
			    success: function(data) {
			    	if (data != null && data != '' && typeof data != 'undefined') {
			    		$('#yourviewModal').html(data);
			    		createAccessDialog.dialog( "open" );
			    	}
			    }
			 });
		}
	
		if(showNoAccessDialog == 'true'){
			 $.ajax({
			  	url :viewNoAccessModal,
			  	type: "POST",
			  	dataType: "text",
			    success: function(data) {
			    	if (data != null && data != '' && typeof data != 'undefined') {
			    		$('#noAccessModal').html(data);
			    		createNoAccessDialog.dialog( "open" );
			    	}
			    }
			 });
		}
 	});
</script> 