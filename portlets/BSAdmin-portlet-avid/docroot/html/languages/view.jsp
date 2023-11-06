<%@include file="/html/init.jsp" %>
<%@page import="com.ihg.brandstandards.util.BrandStandardsCacheUtil"%>
<%@page import="java.util.Map"%>
<%@page import="com.ihg.brandstandards.util.BrandStandardsUtil"%>
<%@page import="com.liferay.portal.kernel.cache.MultiVMPoolUtil"%>
<%@page import="com.ihg.brandstandards.db.service.StandardsRegionLocalServiceUtil"%>
<%@page import="com.ihg.brandstandards.db.service.StandardsLocaleLocalServiceUtil"%>
<%@page import="com.ihg.brandstandards.db.model.StandardsLocale"%>
<%@page import="com.ihg.brandstandards.db.model.StandardsRegion"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="java.util.List"%>
<portlet:actionURL  name="saveLanguages" var="saveLanguages"/>

<script type="text/javascript" src="/BSTheme-theme/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" charset="utf-8">
    function getCheckedLanguages(){
    	var selected = new Array();
    	  $("input:checkbox[name=LangReg]:checked").each(function() {
    	       selected.push($(this).attr("id"));
    	  });
    	  $('#selectedLang').val(selected);
    	  $('form#lang_reg_form').submit();
    }
    
    jQuery(document).ready(function(){
    	jQuery('.breadcrumbs a').text('Languages - Assigning');
    	jQuery(' .page_title h2').text('Languages - Assigning');
    });
</script>

<%
long userId = PortalUtil.getUserId(renderRequest);
if (userId > 1)
{
%>
<form id="lang_reg_form" name="lang_reg_form" method="post" action="<%=saveLanguages%>">
	<div class="grid_12">

	<div class="rounded_container">

        <div class="rounded_container_contents">

            <p class="page_help_text">Use this screen to maintain the languages available in the system and for controlling regional access to the languages for translation purposes. Click 'Save' to save changes.</p>

			
            	<%
            	List<StandardsRegion> regionList = StandardsRegionLocalServiceUtil.getStandardsParentRegionsList();
            	List<StandardsLocale> localeList = StandardsLocaleLocalServiceUtil.getStandardsLocales(-1,-1);
                
            	for(StandardsRegion region : regionList){	
            	%>
            	<div class="assigning_container">
            	<div class="region_assign">
                	<div class="region_assign_title"><%=region.getRegionName() %></div>
	                    <div class="region_assign_content">
	                    	<%
	                    	for(StandardsLocale localeItem :localeList ) {
	                    	    if("Y".equalsIgnoreCase(localeItem.getIsActive()))
	                    	    {
			      					if(Validator.isNotNull(renderRequest.getAttribute("showCheckedVals")) &&
			      							(renderRequest.getAttribute("showCheckedVals")).toString().contains(region.getRegionId()+"-"+localeItem.getLocaleCode())){
			      				%>
			        				<input type="checkbox"  id="<%=region.getRegionId()%>-<%=localeItem.getLocaleCode() %>" name="LangReg" checked="checked"/>&nbsp;<%=localeItem.getLocaleName() %><br/>
			        				<%}else{ %>
			        				<input type="checkbox"  id="<%=region.getRegionId() %>-<%=localeItem.getLocaleCode() %>" name="LangReg" />&nbsp;<%=localeItem.getLocaleName() %><br/>
			        				<%} 
			        				}
	                    		}
		        				%>
		        				<input type="hidden" id="selectedLang" name="selectedLang" value=""/>
	                    </div><!-- End of region assign content -->
                	</div><!-- End of region assign -->
                	
		  
                </div><!-- End of assigning container -->
              <%} //Region for loop end %>
              <div class="clear"></div>
              	<div class="button save_lang_region_assign"><a href="#" onclick="getCheckedLanguages();">save</a><span></span></div>
				 <div class="clear"></div>
          </div><!-- End of rounded container contents -->
          <div class="clear"></div>
     </div><!-- End of rounded container -->
   </div><!-- End of grid 12 -->
   <div class="clear"></div>
</form>


<% } else {
%>
	Not logged in !!
<%  }
%>