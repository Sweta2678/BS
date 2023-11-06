<%@ include file="/html/standlist/init.jsp" %> 
<%@page import="com.ihg.brandstandards.util.ComplianceUtil"%>
<%@page import="com.ihg.brandstandards.util.UserPreferencesUtil"%>
<%@page import="com.ihg.brandstandards.db.model.StandardsStatus"%>
<%@page import="com.liferay.portal.service.ImageLocalServiceUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFileEntry"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.Image"%>
<%@page import="com.ihg.brandstandards.db.service.StandardsImagesLocalServiceUtil"%>
<%@page import="com.liferay.portal.webserver.WebServerServletTokenUtil"%>
<%@page import="com.ihg.brandstandards.db.model.StandardsImages"%>
<%@page import="com.ihg.brandstandards.util.StandardsStatusUtil"%>
<%@page import="com.ihg.brandstandards.util.RegionalUtil"%>
<%@page import="com.ihg.brandstandards.custom.model.Preferences"%>

<script type="text/javascript" src="/BSTheme-theme/js/jquery.nyroModal.custom.min.js"></script>

<script type="text/javascript">
	jQuery(function() {
	    jQuery('.nyroModal').nyroModal();
	});

	jQuery('.toggle').text('..more');
	
	jQuery('.toggle').click(function(){
        if(jQuery(this).prev().prev().is(':visible')) {
            jQuery(this).prev().prev().hide();
            jQuery(this).prev().toggle(1, function() {
                jQuery(this).next().text(function (index, text) {
                    return (text == '..more' ? '..less' : '..more');
                });
            });
        }
        else
        {
            jQuery(this).prev().toggle(1, function() {
                jQuery(this).next().text(function (index, text) {
                    return (text == '..more' ? '..less' : '..more');
                });
            });
            jQuery(this).prev().prev().show();
        }
        return false;
    });
</script>
<table  class="results_table" summary="Data table showing Specifications for a Standard.">
<%
long expandStdId = request.getParameter("prntid") == null ? -111 : Long.parseLong(request.getParameter("prntid"));
String recPerPage = request.getParameter(BrandStandardsUtil.REQUEST_PARAM_REC_PER_PAGE);
long companyId = themeDisplay.getCompanyId();
long currentUserId = themeDisplay.getUser().getUserId();
List<Role> arlCurrentUserRoles = RoleLocalServiceUtil.getUserRoles(currentUserId);
boolean isPublishAdmin = StandardsUtil.isPublishAdmin(arlCurrentUserRoles);
boolean allowExportReport = StandardsUtil.validAuthor(arlCurrentUserRoles);
boolean isSuperAdmin = StandardsUtil.isSuperAdmin(arlCurrentUserRoles);
List<Standards> arlSpecifications = (List<Standards>)request.getAttribute("arlSpecifications");
List<Standards> arlGuidelines = (List<Standards>)request.getAttribute("arlGuidelines");
String standardId = (String)request.getAttribute("standardsId");
String pageNum = (String)request.getAttribute("pageNum");
//String brandCode = (String)request.getAttribute("preferBrand");
Preferences preferences = (Preferences)session.getAttribute("Preferences");
	
String regionCode = "";
String discontinuedFilter = "";
String chainCode = "";
if(preferences!=null)
{
	regionCode = preferences.getRegionCode();
	discontinuedFilter = preferences.getDiscontinuedFilter();
	chainCode = preferences.getBrand();
}
Standards standard = StandardsLocalServiceUtil.getStandards(Long.parseLong(standardId));
User userObj = themeDisplay.getUser();
if(arlSpecifications!=null  && arlSpecifications.size() > 0)
{
	for(int i=0;i<arlSpecifications.size();i++)
	{
		Standards specification = (Standards)arlSpecifications.get(i);
   		String userId = specification.getCreatorId();
   		List<Role> arlRoles = RoleLocalServiceUtil.getUserRoles(Long.parseLong(userId));
   		boolean isRole = false;
   		for(Role roles:arlRoles)
   		{
   			for(Role curUserRole: arlCurrentUserRoles)
   			{
   				if(roles.getName().equals(curUserRole.getName()))
   				{
   					isRole = true;
   				}
   			}
   		}
   		String selectStatusDiv = "statusDiv_"+specification.getStdId();
   		String selectStatusId = "status_"+specification.getStdId();
%>
        <tr style="background: none repeat scroll 0 0 #EEEEEE;">
       
        <td class="result_table_cell1"><img src="/BSTheme-theme/images/solo_branch.png" title="sub item" alt="sub item icon"/><%=specification.getStdId() %></td>

        <td class="result_table_cell2">
        <%
			List<StandardsImages> stdImgs = StandardsImagesLocalServiceUtil.getStandardsImagesByStdId(specification.getStdId());
			if(!BrandStandardsUtil.isNullOrBlank(stdImgs))
			{
		%>
				<a onclick="showImages(<%=specification.getStdId()%>);" >
					<img src="/BSTheme-theme/images/camera_icon.jpg" class="global_icon" title="Has Images" alt="Has Images" />
				</a>
				<div id="cameraIconDiv<%=specification.getStdId()%>" style="display:none">
					<%  for(StandardsImages stdImg : stdImgs) {
					    	DLFileEntry igImage = null;
                            String largeImage = "";
                            String imageId = "";
                        	try{
                        		imageId = stdImg.getImageId()+"";
                            	igImage = DLFileEntryLocalServiceUtil.getDLFileEntry(stdImg.getImageId());
                            	FileEntry fileEntry = DLAppLocalServiceUtil.getFileEntry(igImage.getFileEntryId());
                                largeImage = DLUtil.getPreviewURL(fileEntry, fileEntry.getLatestFileVersion(), themeDisplay, "");
                        	} catch(Exception e){
                            	_log.error(e.getMessage());
                        	}
					%>
							<img src="<%=largeImage %>" alt="Standards Image" id="<%=imageId %>"/><br/>
					<%		
						}
					%>
				</div>
		<%  } %>
        <%
        if("GLBL".equals(specification.getRegionCode())) 
        {
            if("G".equals(specification.getIsGlobal())) 
            {
                if("Y".equals(specification.getFramework())) 
                {
                %>
                <img src="/BSTheme-theme/images/global_icon_red.png" class="global_icon" title="Global Framework standard icon" alt="Global Framework standard icon" />
                <%
                }
                else
                {
                %>
                <img src="/BSTheme-theme/images/global_icon.png" class="global_icon" title="Global standard icon" alt="Global standard icon" />
                <%
                }
            } 
            else 
            {
                if("Y".equals(specification.getFramework())) 
                {
                %>
                <img src="/BSTheme-theme/images/global_icon_halfred.png" class="global_icon" title="Multi-region Framework standard icon" alt="Multi-region Framework standard icon" />
                <%
                }
                else
                {
                %>
                <img src="/BSTheme-theme/images/multi_region_icon.png" class="global_icon" title="Multi-region standard icon" alt="Multi-region standard icon" />
                <%
                }
            }
        }
        %>
       <%=specification.getTitle() %></td>
       <c:if test="<%=!\"GL\".equalsIgnoreCase(chainCode) %>">
		<td class="result_table_cell3">
	<%	if( (StandardsStatusUtil.hasApproverRole(userObj, specification) && !StandardsStatusUtil.PUBLISH_LOCK_STATUS.equals(specification.getStatus())) || isPublishAdmin || isSuperAdmin)	{
        
			List<StandardsStatus> statusList; // = StandardsStatusUtil.getStatuses(specification);
            if (isPublishAdmin || isSuperAdmin)
            {
                if ( (!"GLBL".equals(specification.getRegionCode())) && specification.getRegionCode().equals(regionCode) )
                {
                    statusList = StandardsStatusUtil.getStatuses(userObj, isSuperAdmin, regionCode);
            %>
                <div id="<%=selectStatusDiv %>">
                <c:choose>
                <c:when test="<%=specification.getStatusId() != 0 %>">
                <select class="status_select" name="status" inlineLabel="left" id="<%=selectStatusId %>" onChange="showComments(<%=specification.getStdId() %>)" title="Status" onfocus="getCurrentValue(<%=standard.getStdId() %>, this)">
            <%      for(StandardsStatus stdStatus : statusList) { %>
                    <option id="<%=stdStatus.getStatusId()%>" value="<%=stdStatus.getStatusId()%>" <%=(specification.getStatusId()==stdStatus.getStatusId())?"selected='true'":""%>><%=stdStatus.getTitle()%></option>
            <%      }    %>
                </select>
                </c:when>
                <c:otherwise>
                    <label class="wrapper_label status_val_label" style="padding: 0px !important;" for="<%=selectStatusDiv%>">Not Applicable</label>
                </c:otherwise>
                </c:choose>
                </div>
            <%
                }
                else if ("GLBL".equals(specification.getRegionCode()))
                {
                    statusList = StandardsStatusUtil.getStatuses(specification);
            %>
                <div id="<%=selectStatusDiv %>">
                <c:choose>
                <c:when test="<%=specification.getStatusId() != 0 %>">
                <select class="status_select" name="status" inlineLabel="left" id="<%=selectStatusId %>" onChange="showComments(<%=specification.getStdId() %>)" title="Status" onfocus="getCurrentValue(<%=standard.getStdId() %>, this)">
            <%      for(StandardsStatus stdStatus : statusList) { %>
                    <option id="<%=stdStatus.getStatusId()%>" value="<%=stdStatus.getStatusId()%>" <%=(specification.getStatusId()==stdStatus.getStatusId())?"selected='true'":""%>><%=stdStatus.getTitle()%></option>
            <%      }    %>
                </select>
                </c:when>
                <c:otherwise>
                    <label class="wrapper_label status_val_label" style="padding: 0px !important;" for="<%=selectStatusDiv%>">Not Applicable</label>
                </c:otherwise>
                </c:choose>
                </div>
            <%
                }
                else
                {
            %>
                <c:choose>
                <c:when test="<%=specification.getStatusId() != 0 %>">
                        <label class="wrapper_label status_val_label" style="padding: 0px !important;" for="<%=selectStatusDiv %>"><%=StandardsStatusUtil.getStatusById(specification.getStatusId()).getTitle()%></label>
                </c:when>
                <c:otherwise>
                    <label class="wrapper_label status_val_label" style="padding: 0px !important;" for="<%=selectStatusDiv%>">Not Applicable</label>
                </c:otherwise>
                </c:choose>
          <%   
                }
            }
            else
            {
                statusList = StandardsStatusUtil.getStatuses(specification);
        %>
		<div id="<%=selectStatusDiv %>">
		<c:choose>
		<c:when test="<%=specification.getStatusId() != 0 %>">
		<select class="status_select" name="status" inlineLabel="left" id="<%=selectStatusId %>" onChange="showComments(<%=specification.getStdId() %>)" title="Status" onfocus="getCurrentValue(<%=standard.getStdId() %>, this)">
	<%		for(StandardsStatus stdStatus : statusList)	{ %>
			<option id="<%=stdStatus.getStatusId()%>" value="<%=stdStatus.getStatusId()%>" <%=(specification.getStatusId()==stdStatus.getStatusId())?"selected='true'":""%>><%=stdStatus.getTitle()%></option>
	<%		}	 %>
		</select>
		</c:when>
		<c:otherwise>
			<label class="wrapper_label status_val_label" style="padding: 0px !important;" for="<%=selectStatusDiv%>">Not Applicable</label>
		</c:otherwise>
		</c:choose>
		</div>
        
        <%  }%>
        
		<% } else {
		%>
		<c:choose>
		<c:when test="<%=specification.getStatusId() != 0 %>">
				<label class="wrapper_label status_val_label" style="padding: 0px !important;" for="<%=selectStatusDiv %>"><%=StandardsStatusUtil.getStatusById(specification.getStatusId()).getTitle()%></label>
		</c:when>
		<c:otherwise>
			<label class="wrapper_label status_val_label" style="padding: 0px !important;" for="<%=selectStatusDiv%>">Not Applicable</label>
		</c:otherwise>
		</c:choose>
        <%} %>
		</td>
		</c:if>
		<td class="result_table_cell4"> <%=specification.getAuthor() %></td>

		<td class="result_table_spec_cell5">
			<c:if test='<%= StandardsUtil.hasEditAccess(user, specification) || ("GLBL".equals(specification.getRegionCode()) && StandardsUtil.validAuthor(user.getRoles()) || isSuperAdmin || isPublishAdmin) %>' >
                <%  if(StandardsStatusUtil.PUBLISH_LOCK_STATUS.equals(specification.getStatus()) && !isPublishAdmin && !isSuperAdmin)
                {%>
                    <img src="/BSTheme-theme/images/no_entry.png" alt="Record Locked by Publishing Icon" title="Record Locked by Publishing" />
                <%} else { %>
								<a href="/web/brand-standards/manage-translations?standardsId=<%=specification.getStdId()%>&prntid=<%=specification.getParentId()%>&<%=StandardsUtil.REQUEST_PARAM_PAGE_NUM%>=<%=pageNum %>&<%=StandardsUtil.REQUEST_PARAM_REC_PER_PAGE %>=<%=recPerPage %>" title="Manage Translations" ><img class="log_icon" alt="Manage Translations" src="/BSTheme-theme/images/translate_icon.png" /></a>
                <%} %>
			</c:if>
			
			<a class="view_log" href="#"><img class="log_icon" alt="View And Print" title="View And Print" src="/BSTheme-theme/images/view_icon.png" onclick="showPopup(<%=specification.getStdId()%>, 'View')"/></a>
			<a class="view_log" href="#"><img class="log_icon" alt="View Log" title="View Log" src="/BSTheme-theme/images/log_icon.png" onclick="showPopup(<%=specification.getStdId()%>, 'Log')"/></a>
            <%  if(StandardsStatusUtil.PUBLISH_LOCK_STATUS.equals(specification.getStatus()) && !isPublishAdmin && !isSuperAdmin)
            { %>
                <img src="/BSTheme-theme/images/no_entry.png" alt="Record Locked by Publishing Icon" title="Record Locked by Publishing" />
            <%} else { %>
			<% if(StandardsUtil.hasEditAccess(userObj, specification) || isSuperAdmin) { %>
			<a title="Edit tooltip" href="/web/brand-standards/standard_wizard?id=<%=specification.getStdId()%>&prntid=<%=specification.getParentId()%>&<%=StandardsUtil.REQUEST_PARAM_PAGE_NUM%>=<%=pageNum %>&<%=StandardsUtil.REQUEST_PARAM_REC_PER_PAGE %>=<%=recPerPage %>"><img alt="Edit icon" title="Edit" src="/BSTheme-theme/images/edit_pencil_icon.png" /></a>
			<% } else if("GLBL".equals(specification.getRegionCode()) && RegionalUtil.hasEditAccess(userObj, specification)  || isSuperAdmin) { %>
	              <a title="Edit Tooltip" href="/web/brand-standards/regional_manual?id=<%=specification.getStdId() %>&prntid=<%=specification.getParentId()%>&<%=StandardsUtil.REQUEST_PARAM_PAGE_NUM%>=<%=pageNum %>&<%=StandardsUtil.REQUEST_PARAM_REC_PER_PAGE %>=<%=recPerPage %>">
						<img alt="Edit Icon" title="Link to Regional Manual" src="/BSTheme-theme/images/edit_reg_manual_icon.png" /> 
				  </a>
             <% } else { %>
              <div class="icon_placeholder">&nbsp;</div>
             <% }%>
             <% }%>
            <% if(StandardsStatusUtil.PUBLISH_LOCK_STATUS.equals(specification.getStatus()) && !isPublishAdmin && !isSuperAdmin)
            {%>
                <img src="/BSTheme-theme/images/no_entry.png" alt="Record Locked by Publishing Icon" title="Record Locked by Publishing" />
            <%} else if (StandardsUtil.showComplianceIcon(specification.getStdId())){ %><!-- This condition done in CR 50.3 -->
                <a href="/web/brand-standards/manage-compliance?id=<%=specification.getStdId()%>&prntid=<%=specification.getParentId()%>&<%=StandardsUtil.REQUEST_PARAM_PAGE_NUM%>=<%=pageNum %>&<%=StandardsUtil.REQUEST_PARAM_REC_PER_PAGE %>=<%=recPerPage %>" title="Manage Compliance" ><img class="edit_icon" style="margin-right: 4px;" alt="Manage Compliance" src="/BSTheme-theme/images/calendar_small_icon.png" /></a>
            <% } %>

		</td>
	</tr>
	<%
	}
}
%>

<%if(StandardsUtil.hasAddChildAccess(userObj, standard) || isSuperAdmin) 
  {%>
	<tr>
	<td colspan="5">
	    	<a class="add_new_spec" href="/web/brand-standards/standard_wizard?prntid=<%=standardId%>&<%=StandardsUtil.REQUEST_PARAM_PAGE_NUM%>=<%=pageNum %>&<%=StandardsUtil.REQUEST_PARAM_REC_PER_PAGE %>=<%=recPerPage %>&<%=StandardsUtil.REQUEST_PARAM_OBJ_TYP %>=<%=StandardsUtil.STD_TYPE_SPEC %>" title="add new specification tooltip"><img class="add_icon" src="/BSTheme-theme/images/plus_icon.png" alt="add new specification icon" title="add new specification" />  Add New Specification</a>
			&nbsp;
			<%if(arlGuidelines == null || arlGuidelines.size() == 0){ %>
			<a class="add_new_guide" href="/web/brand-standards/standard_wizard?prntid=<%=standardId%>&<%=StandardsUtil.REQUEST_PARAM_PAGE_NUM%>=<%=pageNum %>&<%=StandardsUtil.REQUEST_PARAM_REC_PER_PAGE %>=<%=recPerPage %>&<%=StandardsUtil.REQUEST_PARAM_OBJ_TYP %>=<%=StandardsUtil.STD_TYPE_GDLN %>" title="add new specification tooltip"><img class="add_icon" src="/BSTheme-theme/images/plus_icon.png" alt="add new guideline icon" title="add new guideline" />  Add New Guideline</a>
			<%} %>
	</td>
	</tr>
<%} %>

<%
if(arlGuidelines!=null && arlGuidelines.size() > 0)
{	
	for(int i=0;i<arlGuidelines.size();i++)
	{
		Standards guideline = (Standards)arlGuidelines.get(i);
   		String userId = guideline.getCreatorId();
   		List<Role> arlRoles = RoleLocalServiceUtil.getUserRoles(Long.parseLong(userId));
   		boolean isRole = false;
   		for(Role roles:arlRoles)
   		{
   			for(Role curUserRole: arlCurrentUserRoles)
   			{
   				if(roles.getName().equals(curUserRole.getName()))
   				{
   					isRole = true;
   				}
   			}
   		}
   		String selectStatusDiv = "statusDiv_"+guideline.getStdId();
   		String selectStatusId = "status_"+guideline.getStdId();
%>
		<tr class="guideline_table_row">

	    <td class="result_table_cell1"><img src="/BSTheme-theme/images/solo_branch.png" title="sub item" alt="sub item icon"/><%=guideline.getStdId() %></td>
		<%
		String description =  guideline.getDescription();
		String more_desc = "";
		int desc_lngth = description.length();
		if (description.length()>195)
		{
		    more_desc = description;
		    description = description.substring(0, 195);
		} 
	    %>
	   
	   <td class="result_table_cell2">
		    <%	List<StandardsImages> stdImgs = StandardsImagesLocalServiceUtil.getStandardsImagesByStdId(guideline.getStdId());
				if(!BrandStandardsUtil.isNullOrBlank(stdImgs))
				{
			%>
					<a onclick="showImages(<%=guideline.getStdId()%>);" >
						<img src="/BSTheme-theme/images/camera_icon.jpg" class="global_icon" title="Has Images" alt="Has Images" />
					</a>
					<div id="cameraIconDiv<%=guideline.getStdId()%>" style="display:none">
					<%  for(StandardsImages stdImg : stdImgs) {
						    DLFileEntry igImage = null;
                            String largeImage = "";
                            String imageId = "";
                            try{
                            	imageId = stdImg.getImageId()+"";
                            	igImage = DLFileEntryLocalServiceUtil.getDLFileEntry(stdImg.getImageId());
                            	FileEntry fileEntry = DLAppLocalServiceUtil.getFileEntry(igImage.getFileEntryId());
                                largeImage = DLUtil.getPreviewURL(fileEntry, fileEntry.getLatestFileVersion(), themeDisplay, "");
                            } catch(Exception e){
                                _log.error(e.getMessage());
                            }
					%>
							<img src="<%=largeImage %>" alt="Standards Image" id="<%=imageId %>"/><br/>
					<%		
						}
					%>
					</div>
			<%  } %>
            <%
            if("GLBL".equals(guideline.getRegionCode())) 
            {
                if("G".equals(guideline.getIsGlobal())) 
                {
                    if("Y".equals(guideline.getFramework())) 
                    {
                    %>
                    <img src="/BSTheme-theme/images/global_icon_red.png" class="global_icon" title="Global Framework standard icon" alt="Global Framework standard icon" />
                    <%
                    }
                    else
                    {
                    %>
                    <img src="/BSTheme-theme/images/global_icon.png" class="global_icon" title="Global standard icon" alt="Global standard icon" />
                    <%
                    }
                } 
                else 
                {
                    if("Y".equals(guideline.getFramework())) 
                    {
                    %>
                    <img src="/BSTheme-theme/images/global_icon_halfred.png" class="global_icon" title="Multi-region Framework standard icon" alt="Multi-region Framework standard icon" />
                    <%
                    }
                    else
                    {
                    %>
                    <img src="/BSTheme-theme/images/multi_region_icon.png" class="global_icon" title="Multi-region standard icon" alt="Multi-region standard icon" />
                    <%
                    }
                }
            }
            %>
            <span class="short_contnet"><%=description %></span>
            <span class="more_content"><%=more_desc %></span>
            <%if(more_desc.length()>0) {%><a class="toggle" title="toggle"> </a><%} %>
        </td>
        <c:if test="<%=!\"GL\".equalsIgnoreCase(chainCode) %>">
		<td class="result_table_cell3">
		<% if( (StandardsStatusUtil.hasApproverRole(userObj, guideline) && !StandardsStatusUtil.PUBLISH_LOCK_STATUS.equals(guideline.getStatus())) || isPublishAdmin || isSuperAdmin)	{
			List<StandardsStatus> statusList; // = StandardsStatusUtil.getStatuses(guideline);
			if (isPublishAdmin || isSuperAdmin)
            {
                if ( (!"GLBL".equals(standard.getRegionCode())) && standard.getRegionCode().equals(regionCode) )
                {
                    statusList = StandardsStatusUtil.getStatuses(userObj, isSuperAdmin, regionCode);
                %>
                <div id="<%=selectStatusDiv %>">
                <c:choose>
                <c:when test="<%=guideline.getStatusId() != 0 %>">
                <select class="status_select" label="" name="status" inlineLabel="left" id="<%=selectStatusId %>" onChange="showComments(<%=guideline.getStdId() %>)" title="Status" onfocus="getCurrentValue(<%=standard.getStdId() %>, this)">
                    <%  for(StandardsStatus stdStatus : statusList) {   %>
                        <option id="<%=stdStatus.getStatusId()%>" value="<%=stdStatus.getStatusId()%>" <%=(guideline.getStatusId()==stdStatus.getStatusId())?"selected='true'":""%>><%=stdStatus.getTitle()%></option>
                    <%} %>                  
                </select>
                </c:when>
                <c:otherwise>
                    <label class="wrapper_label status_val_label" style="padding: 0px !important;" for="<%=selectStatusDiv%>">Not Applicable</label>
                </c:otherwise>
                </c:choose>
                </div>
            <%
                }
                else if ("GLBL".equals(guideline.getRegionCode()))
                {
                    statusList = StandardsStatusUtil.getStatuses(guideline);
            %>
                <div id="<%=selectStatusDiv %>">
                <c:choose>
                <c:when test="<%=guideline.getStatusId() != 0 %>">
                <select class="status_select" label="" name="status" inlineLabel="left" id="<%=selectStatusId %>" onChange="showComments(<%=guideline.getStdId() %>)" title="Status" onfocus="getCurrentValue(<%=standard.getStdId() %>, this)">
                    <%  for(StandardsStatus stdStatus : statusList) {   %>
                        <option id="<%=stdStatus.getStatusId()%>" value="<%=stdStatus.getStatusId()%>" <%=(guideline.getStatusId()==stdStatus.getStatusId())?"selected='true'":""%>><%=stdStatus.getTitle()%></option>
                    <%} %>                  
                </select>
                </c:when>
                <c:otherwise>
                    <label class="wrapper_label status_val_label" style="padding: 0px !important;" for="<%=selectStatusDiv%>">Not Applicable</label>
                </c:otherwise>
                </c:choose>
                </div>
            <%
                }
                else
                {
            %>
                <c:choose>
                    <c:when test="<%=guideline.getStatusId() != 0 %>">
                        <label class="wrapper_label status_val_label" style="padding: 0px !important;" for="<%=selectStatusDiv %>" ><%=StandardsStatusUtil.getStatusById(guideline.getStatusId()).getTitle()%></label>
                    </c:when>
                    <c:otherwise>
                        <label class="wrapper_label status_val_label" style="padding: 0px !important;" for="<%=selectStatusDiv%>">Not Applicable</label>
                    </c:otherwise>
                </c:choose>
            <%   }
            }
			else 
            {
			    statusList = StandardsStatusUtil.getStatuses(guideline);
           %>
    		<div id="<%=selectStatusDiv %>">
    		<c:choose>
    		<c:when test="<%=guideline.getStatusId() != 0 %>">
    		<select class="status_select" label="" name="status" inlineLabel="left" id="<%=selectStatusId %>" onChange="showComments(<%=guideline.getStdId() %>)" title="Status" onfocus="getCurrentValue(<%=standard.getStdId() %>, this)">
    			<%	for(StandardsStatus stdStatus : statusList)	{	%>
    				<option id="<%=stdStatus.getStatusId()%>" value="<%=stdStatus.getStatusId()%>" <%=(guideline.getStatusId()==stdStatus.getStatusId())?"selected='true'":""%>><%=stdStatus.getTitle()%></option>
    			<%}	%>					
    		</select>
    		</c:when>
    		<c:otherwise>
    			<label class="wrapper_label status_val_label" style="padding: 0px !important;" for="<%=selectStatusDiv%>">Not Applicable</label>
    		</c:otherwise>
    		</c:choose>
    		</div>
		<%  }
		 } else {
		%>	
            <c:choose>
				<c:when test="<%=guideline.getStatusId() != 0 %>">
					<label class="wrapper_label status_val_label" style="padding: 0px !important;" for="<%=selectStatusDiv %>" ><%=StandardsStatusUtil.getStatusById(guideline.getStatusId()).getTitle()%></label>
				</c:when>
				<c:otherwise>
					<label class="wrapper_label status_val_label" style="padding: 0px !important;" for="<%=selectStatusDiv%>">Not Applicable</label>
				</c:otherwise>
			</c:choose>
        <% } %>
		</td>
		</c:if>
		<td class="result_table_cell4"> <%=guideline.getAuthor() %></td>

		<td class="result_table_spec_cell5">	
			<c:if test='<%= StandardsUtil.hasEditAccess(user, guideline) || ("GLBL".equals(guideline.getRegionCode()) && StandardsUtil.validAuthor(user.getRoles()) || isSuperAdmin || isPublishAdmin) %>' >
                <% if(StandardsStatusUtil.PUBLISH_LOCK_STATUS.equals(guideline.getStatus()) && !isPublishAdmin && !isSuperAdmin)
                {%>
                    <img src="/BSTheme-theme/images/no_entry.png" alt="Record Locked by Publishing Icon" title="Record Locked by Publishing" /></a>
                <%} else { %>
								<a href="/web/brand-standards/manage-translations?standardsId=<%=guideline.getStdId()%>&prntid=<%=guideline.getParentId()%>&<%=StandardsUtil.REQUEST_PARAM_PAGE_NUM%>=<%=pageNum %>&<%=StandardsUtil.REQUEST_PARAM_REC_PER_PAGE %>=<%=recPerPage %>" title="Manage Translations" ><img class="log_icon" alt="Manage Translations" src="/BSTheme-theme/images/translate_icon.png" /></a>
			    <%} %>
            </c:if>
            <a class="view_log" href="#"><img class="log_icon" alt="View And Print" title="View And Print" src="/BSTheme-theme/images/view_icon.png" onclick="showPopup(<%=guideline.getStdId()%>, 'View')"/></a>
            <a class="view_log" href="#"><img class="log_icon" alt="View Log" title="View Log" src="/BSTheme-theme/images/log_icon.png" onclick="showPopup(<%=guideline.getStdId()%>)"/></a>
            <%  if(StandardsStatusUtil.PUBLISH_LOCK_STATUS.equals(guideline.getStatus()) && !isPublishAdmin && !isSuperAdmin)
            {%>
                <img src="/BSTheme-theme/images/no_entry.png" alt="Record Locked by Publishing Icon" title="Record Locked by Publishing" /></a>
            <%} else { %>
		    <% if(StandardsUtil.hasEditAccess(userObj, guideline)  || isSuperAdmin) { %>
		    <a title="Edit tooltip" href="/web/brand-standards/standard_wizard?id=<%=guideline.getStdId()%>&prntid=<%=guideline.getParentId()%>&<%=StandardsUtil.REQUEST_PARAM_PAGE_NUM%>=<%=pageNum %>&<%=StandardsUtil.REQUEST_PARAM_REC_PER_PAGE %>=<%=recPerPage %>"><img alt="Edit icon" title="Edit" src="/BSTheme-theme/images/edit_pencil_icon.png" /></a>
		     <% } else if(("GLBL".equals(guideline.getRegionCode()) && RegionalUtil.hasEditAccess(userObj, guideline))  || isSuperAdmin) { %>
	              <a title="Edit Tooltip" href="/web/brand-standards/regional_manual?id=<%=guideline.getStdId() %>&prntid=<%=guideline.getParentId()%>&<%=StandardsUtil.REQUEST_PARAM_PAGE_NUM%>=<%=pageNum %>&<%=StandardsUtil.REQUEST_PARAM_REC_PER_PAGE %>=<%=recPerPage %>">
						<img class="edit_icon" alt="Edit Icon" title="Link to Regional Manual" src="/BSTheme-theme/images/edit_reg_manual_icon.png" /> 
				  </a>
             <% } else { %>
              <div class="icon_placeholder">&nbsp;</div>
             <%}%>
			<%} %>
             <div class="icon_placeholder" style="margin-right: 4px;">&nbsp;</div>
		</td>

	</tr>
	<%
	}
	if(StandardsUtil.hasAddChildAccess(userObj, standard) || isSuperAdmin) 
	{  %>
		<tr>
		<td colspan="5">
		<a class="add_new_guide" href="/web/brand-standards/standard_wizard?prntid=<%=standardId%>&<%=StandardsUtil.REQUEST_PARAM_PAGE_NUM%>=<%=pageNum %>&<%=StandardsUtil.REQUEST_PARAM_REC_PER_PAGE %>=<%=recPerPage %>&<%=StandardsUtil.REQUEST_PARAM_OBJ_TYP %>=<%=StandardsUtil.STD_TYPE_GDLN %>" title="add new specification tooltip"><img class="add_icon" src="/BSTheme-theme/images/plus_icon.png" alt="add new guideline icon" title="add new guideline" />  Add New Guideline</a>
		</td>
		</tr>
  <%} 
}
%>
</table>

<!-- Specification Table content --> 
<a href="#SpecificationTableData" id="spec_table_details" title="DOM Elements" class="nyroModal" style="display:none;">DOM Element (hidden div)</a>

<div id="SpecificationTableData" class="model_content">
    <h4 class="modal_title_text">text here</h4>
        <div id="model_iframe" ></div>
        <div class="clear"></div>
</div>
<!-- End of Specification Table content --> 
<%!
	private static Log _log = LogFactoryUtil.getLog("BSAdmin-portlet.docroot.html.standlist.viewSpecifications_jsp");
%>