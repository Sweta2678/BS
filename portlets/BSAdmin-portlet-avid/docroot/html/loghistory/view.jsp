<%@include file="/html/loghistory/init.jsp" %>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.ihg.brandstandards.util.BSAdminConstants"%>
<%@page import="com.ihg.brandstandards.util.BrandStandardsCacheUtil"%>
<%@page import="com.ihg.brandstandards.util.UserPreferencesUtil"%>
<%@page import="com.itextpdf.text.log.Logger"%>
<%@page import="com.ihg.brandstandards.db.NoSuchChainStandardsException"%>
<%@page import="com.ihg.brandstandards.db.model.StandardsStatus"%>
<%@page import="com.ihg.brandstandards.db.service.ChainStandardsLocalServiceUtil"%>
<%@page import="com.ihg.brandstandards.db.service.StandardsStatusLocalServiceUtil"%>
<%@page import="com.ihg.brandstandards.custom.model.Preferences"%>
<liferay-portlet:renderURL varImpl="logHistory" />
<link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/tree/!style.css"/>
<link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/tree/custom/!style.css"/>
<style>
	.container_12 {
	    width:100% !important;
	}
</style>    
<aui:form name="selectForm" action="<%=logHistory %>" method="post">	
<%
	String standardId = (String)request.getAttribute("standardsId");
	String logStdType = (String)request.getAttribute("logStdType");
	String strStdId = request.getParameter("stdId");
	ArrayList<Workflow> arlStandardsLog = (ArrayList<Workflow>)request.getAttribute("arlStandards");
	long stdId = 0;
	if(standardId!=null)
	{
		stdId = Long.parseLong(standardId);
	}
	String path = TaxonomyExtLocalServiceUtil.getIndexPathByStandardId(stdId);
	StandardsView standView = (StandardsView) request.getAttribute("StandardsView");
	String stdType = "";
	if(logStdType.equals(StandardsUtil.STD_TYPE_STANDARD))
	{
		stdType = "Standard";
	}
	else if(logStdType.equals(StandardsUtil.STD_TYPE_SPEC))
	{
		stdType = "Specification";
	}
	else if(logStdType.equals(StandardsUtil.STD_TYPE_GDLN))
	{
		stdType = "Guideline";
	}
%>
<input type="hidden" id="stdId" name="stdId" value = "<%=stdId%>"/>
<input type="hidden" name="stdType" value="<%=logStdType%> %>"/>
	<p class="log_info"><strong>Index Path: </strong><%=path %><br/></p>
	<p class="log_info"><strong>ID: </strong><%=standardId %><br/></p>
    <div class="clear"></div>
	<table class="results_table" summary="Data table for all results">
		<tr class="results_header_bar">
			<td class="log_table_cell1"><strong>Author / Approver</strong></td>
			<td class="log_table_cell2"><strong>Date / Time</strong></td>
			<td class="log_table_cell3"><strong><%=stdType %> Text</strong></td>
			<td class="log_table_cell4"><strong>Status/Translation</strong></td>
			<td class="log_table_cell5"><strong>Comments</strong></td>
			<td class="log_table_cell5"><strong>Brand</strong></td>
		</tr>
	  	<% 
	  		for(Workflow workflow: arlStandardsLog) {
				User usr = null;
				String fullName = "Does not exist";
				try {
				    usr = UserLocalServiceUtil.getUser(Long.parseLong(workflow.getUpdatedBy()));
				} catch(Exception e){
				    _log.error(e.getMessage());
				}
				if(usr != null) {
					fullName = usr.getFullName();
				}
	  	%>
		<tr>
       		<td><%=fullName%></td>
           	<td><%=workflow.getUpdatedDate() %></td>
           	<td><%=workflow.getTitle() %></td>
    		<% 
				String chainCode = workflow.getChainCode();
				String statusTitle = null;
				String workFlowStatus = workflow.getStatus();
				boolean isTranslation = workflow.getObjectType()!=null && workflow.getObjectType().equalsIgnoreCase(BrandStandardsUtil.STANDARDS_TRANSLATE_OBJ_TYPE); 
				if (!isTranslation && !StandardsStatusUtil.IsNullOrBlank(chainCode)&& !StandardsStatusUtil.IsNullOrBlank(workFlowStatus))
				{
					
					if (!StandardsStatusUtil.isNullOrBlank(StandardsStatusLocalServiceUtil.getStatusesByStatusCode(workFlowStatus)))
					{
						statusTitle = StandardsStatusLocalServiceUtil.getStatusesByStatusCode(workFlowStatus).get(0).getTitle();	
					}
					else
					{
						statusTitle = workflow.getStatus();
					}
				}
				Map<String, String> chnCdMap = BrandStandardsUtil.chainCodeMap();
				String brand = chnCdMap.get(workflow.getChainCode());
				//String preferedBrand = UserPreferencesUtil.getUserpreferences(renderRequest);
				Preferences preferences = (Preferences)session.getAttribute("Preferences");
		        String regionCode = preferences.getRegionCode();
		        String preferedBrand = preferences.getBrand();
				if(BSAdminConstants.ALL_BRAND.equalsIgnoreCase(preferedBrand) || StandardsStatusUtil.IsNullOrBlank(brand)){
				    brand="All Brands";
				    statusTitle= "Not Applicable";
				}
			%>
			<td>
			<% 	if(workflow.getObjectType().equals(BrandStandardsUtil.STANDARDS_TRANSLATE_OBJ_TYPE) && BrandStandardsCacheUtil.getStandardsLocaleByLocaleCd(workflow.getStatus()) != null) { %>
					<%=BrandStandardsCacheUtil.getStandardsLocaleByLocaleCd(workflow.getStatus()).getLocaleName()%> Translation
			<% 	} else if(!StandardsStatusUtil.IsNullOrBlank(statusTitle)){ %>
	           	<select class="status_dropdown" disabled="disabled">
	               	<option value="Draft"><%=statusTitle%></option>
	            </select>
	        <% } %>
        	</td>
			<td style="text-align:center;"><%=workflow.getComment() %></td>
			<td style="text-align:center;"><%=brand%></td>
		<% 		 
	  		} 
	  	%>
      	</tr>
	</table>
</aui:form>   
<%!
	private static Log _log = LogFactoryUtil.getLog("BSAdmin-portlet.docroot.html.loghistory.loghistory_view_jsp");
%>