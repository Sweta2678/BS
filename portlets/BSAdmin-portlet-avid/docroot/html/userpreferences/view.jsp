<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.util.portlet.PortletProps"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="com.liferay.portal.service.RoleLocalServiceUtil" %>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil" %>
<%@page import="com.ihg.brandstandards.custom.model.Preferences"%>
<%@page import="com.liferay.portal.model.Role" %>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.util.PortalUtil" %>
<%@page import="java.util.Map"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="com.ihg.brandstandards.util.StandardsUtil" %>
<%@page import="com.ihg.brandstandards.util.BrandStandardsUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript" src="/BSTheme-theme/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/jquery-ui-1.10.1.custom.min.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/jquery.nyroModal.custom.min.js"></script>
<link rel="stylesheet" type="text/css" href="/BSTheme-theme/css/other/jquery-ui-1.10.1/themes/base/jquery.ui.all.css"/>
<link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/bsstyle.css"/>
<link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/userPreferenceModel.css"/>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
long companyId = themeDisplay.getCompanyId();
long currentUserId = themeDisplay.getUser().getUserId();
List<Role> arlCurrentUserRoles = RoleLocalServiceUtil.getUserRoles(currentUserId);
boolean superAdmin = false;
superAdmin = StandardsUtil.isSuperAdmin(arlCurrentUserRoles);
Preferences preferences = (Preferences)session.getAttribute("Preferences");
	
String regionCode = "";
String discontinuedFilter = "";
String chainCode = "";
String region = "";
if(preferences!=null)
{
	regionCode = preferences.getRegionCode();
	discontinuedFilter = preferences.getDiscontinuedFilter();
	chainCode = preferences.getBrand();
	region = preferences.getRegion();
}
Map<String, String> chnCdMap = BrandStandardsUtil.chainCodeMap();
if(Validator.isNull(chainCode)||!chnCdMap.containsKey(chainCode)){
	chainCode="GL";
}

String itemsPerPage = "50";
String defaultBrand = "GL";
int counter=0;
%>
<script type="text/javascript">
var $jq = jQuery.noConflict();
var brandCd = '<%= chainCode %>';
var regCode = '<%= region %>';
var dFilter = '<%= discontinuedFilter%>';

$jq(function() {
	$jq(".perspective_cms").nyroModal({closeOnClick: false});

	$jq(".perspective_cms_cancel_a,a.nyroModalClose").bind("click", function(e){
		$jq('.perspective_radio_cont input[value='+brandCd+']').prop('checked',true);
		$jq('.perspective_radio_cont input[value='+regCode+']').prop('checked',true);
		if(dFilter == 'true'){
			$jq('input[name="discontinuedFilter"]').prop('checked',true);
		}
		else{
			$jq('input[name="discontinuedFilter"]').prop('checked',false);
		}
		if($jq(this).hasClass('perspective_cms_cancel_a'))
		{
			$jq.nmTop().close();
		}
	});
	
	
});




function changeSettings(event)
{
	event.preventDefault();
	var hidFilter = document.getElementById('<portlet:namespace/>autofilter');
	var hidBrand = document.getElementById('<portlet:namespace/>chnCd');
	var hidRgn = document.getElementById('<portlet:namespace/>rgnCd');
	hidBrand.value = jQuery( "input:radio[name=perspective_radios]:checked" ).val();
	hidRgn.value = jQuery( "input:radio[name=role_radios]:checked" ).val();
	if(jQuery('#discontinuedFilter:checked').length == 1)
	{
		hidFilter.value = 'true';
	}
	else
	{
		hidFilter.value = 'false';
	}
	if(jQuery( "input:radio[name=role_radios]:checked" ).val()==undefined || jQuery( "input:radio[name=role_radios]:checked" ).val()=='undefined')
	{
	                hidRgn.value = "";
	}
	else
	{
	                hidRgn.value = jQuery( "input:radio[name=role_radios]:checked" ).val();
	}

	var frm  = document.getElementById('<portlet:namespace/>preferenceForm');
	frm.submit();
}
</script>

<portlet:actionURL var="preferenceURL" name="setPreference">
	<portlet:param name="redirect" value="<%=PortalUtil.getCurrentURL(request)%>"/>
</portlet:actionURL>

<aui:form  title="User Preferences Form"  action="<%= preferenceURL %>" method="post" name="preferenceForm" id="preferenceForm" class="nomargin">
<aui:input type="hidden" id="chnCd" name="chnCd" value=""/>
<aui:input type="hidden" id="rgnCd" name="rgnCd" value=""/>
<aui:input type="hidden" id="autofilter" name="autofilter" value=""/>
<div class="welcome_text">
    <c:choose>
        <c:when test="<%=superAdmin==true%>"><span style="color:red"><B><%=regionCode%></B>&nbsp;Role</span>&nbsp;&nbsp;|&nbsp;&nbsp;</c:when>
        <c:otherwise></c:otherwise>
    </c:choose>
    <c:choose>
        <c:when test="<%=defaultBrand.equalsIgnoreCase(chainCode)%>"><B>All Brands</B> Perspective</c:when>
        <c:otherwise><B><%=chnCdMap.get(chainCode)%></B> Perspective</c:otherwise>
    </c:choose> 
    <span class="spacer">&nbsp;</span>
    <div class="ie7_container">
        <div class="button"><a href="#perspective_cms" class="perspective_cms">change</a><span></span></div>
    </div>
</div>
<div id="clearDiv" class="clear"></div>

<div id="perspective_cms" style="display:none;">
    <div class="persp_container">
   
        <h3>Edit User Preferences</h3>
        <p class="status_brand_grey">Use the options below to adjust your experience in this application.</p>
        <br/>
        <div class="divider">&nbsp;</div>
        <%-- <p class="perspective_line">Item display per page: 
        	<select name="itemsPerPage" id="itemsPerPage">
        		<%for(String items : defaultItemsPerPage){ %>
        			<option value="<%=items%>" <c:if test="<%= items.equalsIgnoreCase(itemsPerPage)%>">selected</c:if>><%=items%></option>
        		<%} %>
        	</select>
        </p> --%>
        <p class="perspective_line">Choose a perspective: <a class="help_icon tooltip persp_tip" href="javascript:return false;"><img src="/BSTheme-theme/images/help.png" alt="details"/><span class="classic">If selecting 'All Brands' perspective, the status column on the Standard Listing page will not be present and all Brands are automatically selected in the default filter.<br/><br/>

If a particular Brand is selected, the system will include a status column, filter by that Brand, and will show the status relative to that Brand. If the filter is changed to include additional Brands and the standard is not attributed to this additional Brand, then the status "Not applicable" will be seen when viewed with the selected Brand perspective.</span></a></span></p>

		<div class="perspective_radio_cont">
        	<p><input type="radio" name="perspective_radios" id="perspective_radios" value="GL" <c:if test="<%= defaultBrand.equalsIgnoreCase(chainCode)%>">checked</c:if>/> All Brands <span class="perspective_grey">leave as 'All Brands', or select a particular Brand perspective</span></p>
        </div>

			
        <div class="perspective_radio_cont">
        	<div class="perspective_left">
        		<%	for(String brCode : chnCdMap.keySet()) {
        			
        		    if(counter < 7){
        		   %>
        				<input type="radio" name="perspective_radios" id="perspective_radios"  value="<%=brCode%>" <c:if test="<%= brCode.equalsIgnoreCase(chainCode)%>">checked</c:if>/> <%=chnCdMap.get(brCode)%><br/>
        			<%
        		    }else{
        		        if(counter == 7){
        		    %>
        		    	</div>
        		    	<div class="perspective_right">
        		    	<input type="radio" name="perspective_radios" id="perspective_radios"  value="<%=brCode%>" <c:if test="<%= brCode.equalsIgnoreCase(chainCode)%>">checked</c:if>/> <%=chnCdMap.get(brCode)%><br/> 
        		    	<%}else{ %>
        		        <input type="radio" name="perspective_radios"  id="perspective_radios" value="<%=brCode%>" <c:if test="<%= brCode.equalsIgnoreCase(chainCode)%>">checked</c:if>/> <%=chnCdMap.get(brCode)%><br/>
        		        <%}
        		    }
        			counter++;
        			} 
        			%>
            </div>
            <div class="clear"></div>
        </div>
        <%if(superAdmin == true) {%>
        <div >
        	<p>Choose a Role: </p>
        </div>
        <div class="perspective_radio_cont">
        	<div class="perspective_left">
        			<input type="radio" name="role_radios" id="role_radios" value="GLB" <c:if test='<%= regionCode.equalsIgnoreCase("GLBL")%>'>checked</c:if>/> <label>Global</label><br/>
        			<input type="radio" name="role_radios" id="role_radios" value="AMR" <c:if test='<%= regionCode.equalsIgnoreCase("AMER")%>'>checked</c:if>/> <label>Americas</label><br/>
        			<input type="radio" name="role_radios" id="role_radios" value="GC" <c:if test='<%= regionCode.equalsIgnoreCase("GC")%>'>checked</c:if>/> <label>Greater China</label><br/>
        	</div>
  		    <div class="perspective_right">
  		    	<input type="radio" name="role_radios" id="role_radios" value="AME" <c:if test='<%= regionCode.equalsIgnoreCase("AMEA")%>'>checked</c:if>/> <label>Africa, Middle East and Asia</label><br/> 
  		    	
  		        <input type="radio" name="role_radios" id="role_radios" value="EUR" <c:if test='<%= regionCode.equalsIgnoreCase("EURO")%>'>checked</c:if>/> <label>Europe</label><br/>
  		        
            </div>
            <div class="clear"></div>
        </div>
        <%} %>
		<div class="perspective_radio_cont">
        	<p><input type="checkbox" id="discontinuedFilter" name="discontinuedFilter" <c:if test="<%= \"true\".equalsIgnoreCase(discontinuedFilter)%>">checked</c:if>/> Enable Discontinued Auto-Filter <a class="help_icon tooltip persp_tip" href="javascript:return false;"><img src="/BSTheme-theme/images/help.png" alt="details"/>
        		<span class="classic">Checking the 'Enable Discontinued Auto-Filter' means that the system will never show you Discontinued content when conducting a Search or Filter. The 3 Discontinued Statuses will be hidden from you, although you will still be able to discontinue content if your permissions allow you to change statuses.
				</span>
				</a>
			</p>
        </div>
        <div class="button"><a href="javascript;" id="changeSettingsButton" onclick="javascript:changeSettings(event)">Save</a><span></span></div>
        <div class="button perspective_cancel"><a href="#" class="perspective_cms_cancel_a">Cancel</a><span></span></div>
       
    </div>
</div>
</aui:form>