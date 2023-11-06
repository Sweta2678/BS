<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.ihg.brandstandards.bridge.util.BrandStandardsUtil"%>
<%@include file="/html/preferences/init.jsp" %>
<script type="text/javascript">
	var redirectToBridgeScope = '${redirectToBridgeScope}';
	var redirectBridgePageURL = '${redirectBridgePageURL}';
	
	if(redirectToBridgeScope == 'true' && redirectBridgePageURL != '' ){
		window.location.href = redirectBridgePageURL;
	}
</script>

<portlet:resourceURL id='viewAccessModal' var="viewAccessModal">
	<portlet:param name="modalType" value="editPreferences"></portlet:param>
</portlet:resourceURL>

<%
	Preferences accessPrefs = null; 
	boolean isUserOnGEMScope = GetterUtil.getBoolean(request.getAttribute("isUserOnGEMScope"), false);
    if(isUserOnGEMScope){
    	accessPrefs = (Preferences) session.getAttribute("gemPreferences");
    } else {
    	accessPrefs = (Preferences) session.getAttribute("Preferences");
    }
	String countryName = "";
	String languageName = "";
	String brandName = "";
	String brandCode = "";
	String userName = themeDisplay.getUser().getFullName();
	Map<String, String> chnCdMap = BrandStandardsUtil.chainCodeMap();

	if(accessPrefs != null) {
		countryName = accessPrefs.getRegionName();
		brandCode = accessPrefs.getBrand();
	}
	
	if(chnCdMap != null && brandCode != null) {
		brandName =	chnCdMap.get(brandCode);
	}
%>

<small>
	<c:choose>
		<c:when test="${isUserOnGEMScope}">
			<c:set var="modelTitle" value="Change Brand"></c:set>
			You are selecting
			<u id="<%=brandName %>"><%=brandName %></u> Standards for measurement in the
			<u id="<%=countryName %>"><%=countryName %></u>
			<c:if test="${deptName ne null}">
				<u id="${deptName}">${deptName}</u> department.
			</c:if>
		</c:when>
		<c:otherwise>
			<c:set var="modelTitle" value="Change Publication"></c:set>
			You are adjusting the next
			<u id="<%=countryName %>"><%=countryName %></u> publication for
			<u id="<%=brandName %>"><%=brandName %></u>
		</c:otherwise>
	</c:choose>
	<a href="#" class="btn btn-mini changebtn"><i class="icon-cog"></i>Change</a>
</small>

<div id="yourviewModal" title="${modelTitle}" style="display:none;">	</div>
<div id="noAccessModal" title="${noAccess}" style="display:none;">	</div>

<script type="text/javascript">
	var viewAccessModal = '${viewAccessModal}';
	var viewNoAccessModal = '${viewNoAccessModal}';
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
		
		$( ".changebtn" ).click(function() {
			$.ajax({
			  	url :viewAccessModal,
			  	type: "POST",
			  	dataType: "text",
			    success: function(data) {
		    		$('#yourviewModal').html(data);
		    		createAccessDialog.dialog( "open" );
			    },
				error: function(error) {
		 			window.location.assign("/web/brand-standards/bridge");
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
		
 	});
</script> 