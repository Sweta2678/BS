<%@include file="/html/imageadmin/init.jsp" %>
<%@page import="com.liferay.portlet.asset.service.AssetTagServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.PropsKeys"%>
<%@page import="com.liferay.portal.kernel.util.PrefsPropsUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFileEntry"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFolder"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil"%>
<%@page import="com.ihg.brandstandards.db.service.StandardsImagesLocalServiceUtil"%>
<%@page import="com.liferay.portal.webserver.WebServerServletTokenUtil"%>
<%@page import="com.ihg.brandstandards.util.ImageAdminUtil"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<script type="text/javascript" src="/BSTheme-theme/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/jquery-ui-1.10.1.custom.min.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/treeAdmin/jquery.msgBox.js"></script>
<link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/msgBoxLight.css"/>
<script type="text/javascript" src="/BSTheme-theme/js/image_search.js"></script>

<%
List<DLFolder> arlFolders = (List<DLFolder>) request.getAttribute("arlFolders");
List<DLFileEntry> arlImages = (List<DLFileEntry>) request.getAttribute("arlImages");
List<DLFileEntry> foundImages = (List<DLFileEntry>) request.getAttribute("arlIGImages");
//ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
String prntFolderId = (String) request.getAttribute(ImageAdminUtil.PARENT_FOLDER_ID);
String currFolderId = (String) request.getAttribute(ImageAdminUtil.CURR_FOLDER);
String prevFolderId = (String) request.getAttribute(ImageAdminUtil.FOLDER_ID);
boolean isTranslated = false;
if(Validator.isNotNull(request.getAttribute("isTranslated"))) {
	isTranslated = true;
}
String folderId = "";
String folderName = (String) request.getAttribute(ImageAdminUtil.FOLDER_NAME);
String parentFolderName = (String) request.getAttribute(ImageAdminUtil.PRNT_FOLDER_NAME);
%>
<script type="text/javascript">

function showFolder(folderId)
{
    var currFolder = document.getElementById('<portlet:namespace/>'+'<%=ImageAdminUtil.CURR_FOLDER%>');
    currFolder.value = folderId;
    var frm  = document.getElementById('<portlet:namespace/>imageForm');
    frm.submit();
}
</script>

<style type="text/css">
.portlet-msg-success
{
    display : none;
}
.add_selected_image 
{
    float:left; 
    margin: 0 4px 4px 0; 
    border: 2px double;
    border-color: #A9A9A9;
    padding: 8px;
    width: 29%;
	height: 400px;
}
.image-title
{
    color : #E15F26;
    text-align : center;
}
.search_gallery 
{
    background-color: #EB9900; 
    font-family: verdana; 
    font-size: 11px; 
    padding-top: 2px;
    height: 30px;
}
.disp_search_lbl {
    font-weight: bold;
    padding-left: 5px;
    padding-right: 5px;
    vertical-align: 2px;
}
.disp_res_all_spec_desc {
    color: white;
    vertical-align: 2px;
}
</style>

<portlet:actionURL name="guestSearchImage" var="searchImageURL" >
	<portlet:param name="COMMAND" value="${COMMAND}"></portlet:param>
</portlet:actionURL>
<aui:form name="searchImage" action="<%=searchImageURL.toString() %>" method="post" >
    <div id="searchImgGallery" class="search_gallery">
        <span class="disp_search_lbl">Search the Gallery:</span>
        <input type="text" class="search_text_box" name="<%=ImageAdminUtil.SEARCH_TXT%>" id="<%=ImageAdminUtil.SEARCH_TXT%>" value="" size="78" maxlength="300" title="Search Images" />
        <button type="submit" value="Search">Search</button>
    </div>
</aui:form>

<liferay-portlet:renderURL varImpl="imageAdminURL">
    <portlet:param name="<%=ImageAdminUtil.CMD%>" value="${COMMAND}" />
</liferay-portlet:renderURL>

<aui:form action="<%= imageAdminURL %>" method="post" name="imageForm"  >
    <aui:input type="hidden" id="<%=ImageAdminUtil.CURR_FOLDER%>" name="<%=ImageAdminUtil.CURR_FOLDER%>" value="<%=currFolderId%>"/>
    <aui:input type="hidden" id="<%=ImageAdminUtil.PARENT_FOLDER_ID%>" name="<%=ImageAdminUtil.PARENT_FOLDER_ID%>" value="<%=prntFolderId%>"/>

    <div class="img_search_rounded_container">
    	<div class="img_search_rounded_container_contents">
        <div class="clear"></div>
         <%if(foundImages == null) {%>
        <div align="left"><%=folderName %></div>
        <%} %>
        <div align="right">
            <%
            if (!ImageAdminUtil.IsNullOrBlank(prntFolderId) && !prntFolderId.equals(currFolderId)) {
            %>
                <a href="#" onclick="showFolder('<%=prntFolderId%>')"><B>&lt;&lt;Back to <%=parentFolderName %></B></a> 
            <%
            } else if (!ImageAdminUtil.IsNullOrBlank(prntFolderId) && foundImages != null) {
            %>
                <a href="#" onclick="showFolder('<%=prntFolderId%>')"><B>&lt;&lt;Go back </B></a> 
            <%
            } 
            %>
        </div>
    <table style="width:100%">
    <%if(foundImages == null)
    {%>
    <tr>
    <td>
        <table class="results_table" summary="Data table for all results">
        	<tr class="results_header_bar">
                <td class="img_result_table_cell1"><strong>Folder</strong></td>
                <td class="img_result_table_cell2"><strong># of Folders</strong></td>
                <td class="img_result_table_cell3"><strong># of Entries</strong></td>
        	</tr>
        	<%
            if (arlFolders != null)
            {
            	for (DLFolder igFolder : arlFolders) 
            	{
            		List<DLFolder> arlSubFolders = DLFolderLocalServiceUtil.getFolders(themeDisplay.getLayout().getGroupId(),igFolder.getFolderId());
            		folderId = String.valueOf(igFolder.getFolderId());
            	%>
                <tr >
                    <td ><a href="#" onclick="showFolder('<%=igFolder.getFolderId()%>')"><%=igFolder.getName()%></a><br/>
                        <b>Sub-Folders:</b><br/>
                        <%
                        	if(arlSubFolders != null && arlSubFolders.size() > 0){
                        		for (DLFolder igSubFolders : arlSubFolders) {
                            		String subFolderName = igSubFolders.getName();
                        %>
                            			<a href="#"  onclick="showFolder('<%=igSubFolders.getFolderId()%>')"><%=subFolderName%></a>,&nbsp;
                        <%
                        		}
                        	} 
                        %>
                    </td>
                    <td><%=arlSubFolders.size()%></td>
                    <td><%=DLFileEntryLocalServiceUtil.getFileEntriesCount(themeDisplay.getLayout().getGroupId(), igFolder.getFolderId())%></td>
                </tr>
        	<%  }
        	}%>
        </table>
    </td>
    </tr>
    <tr class="clear"><td class="clear"></td></tr>
    <%} %>
    <tr>
    <td width="74%">
        <div id="imageGalleryAssetInfoPanelContainer">
        <%  
        if(foundImages != null) 
        {
            arlImages = foundImages;
        }
        
        if (!ImageAdminUtil.isNullOrBlank(arlImages))
        {
            for (DLFileEntry image : arlImages) 
            { %>
                <c:choose>
                    <c:when test="true">
                        <%
                        FileEntry fileEntry = null;
	                    String smallImageURL = "";
	                    String largeImageURL = ""; 
	                    try{
	                    	fileEntry = DLAppLocalServiceUtil.getFileEntry(image.getFileEntryId());
	                        //smallImageURL = DLUtil.getImagePreviewURL(fileEntry, themeDisplay);
	                        smallImageURL = DLUtil.getThumbnailSrc(fileEntry, null, themeDisplay);
	                        largeImageURL = DLUtil.getPreviewURL(fileEntry, fileEntry.getLatestFileVersion(), themeDisplay, "");
			            } catch(Exception e){
			            	System.out.println("Failed to get image"+e.getMessage());
			            }
                        int smallImageHeight = 128;
                        int smallImageWidth = 128;
                        int topMargin = 150 - smallImageHeight;
                        int sideMargin = (150 - smallImageWidth) / 2;
                        %>
                        <c:choose>
                        	<c:when test="<%= isTranslated %>">
                        		<div id="imgdetail_<%=image.getFileEntryId() %>" class="add_selected_image translated_image">
                        	</c:when>
                        	<c:otherwise>
                        		<div id="imgdetail_<%=image.getFileEntryId() %>" class="add_selected_image">
                        	</c:otherwise>
                        </c:choose>
                        	<a class="image-thumbnail" href="<%= largeImageURL %>" largeImageId="<%= image.getFileEntryId() %>" title="<%= HtmlUtil.escape(image.getTitle()) + " - " + HtmlUtil.escape(image.getDescription()) %>" onclick="window.open (this.href, '_blank', 'height = 400, width = 650, resizable = yes'); return false;">
                            	<img alt="<%= HtmlUtil.escape(image.getTitle()) + " - " + HtmlUtil.escape(image.getDescription()) %>" border="no" 
                                 src="<%= smallImageURL %>" 
                                 style="max-height:128px;max-width:128px;height: <%= smallImageHeight %>; margin: <%= topMargin %>px <%= sideMargin %>px 0px <%= sideMargin %>px; width: <%= smallImageWidth %>;" />
                            </a>
                            
                            <div class="aui-helper-hidden" id="<portlet:namespace />buttonsContainer_<%= image.getFileEntryId() %>">
                                <div class="buttons-container float-container" id="<portlet:namespace />buttons_<%= image.getFileEntryId() %>">
                            	</div>
                            </div>
                    <% 
						User userObj = null;
						String fullName = "Does not exist";
						try {
							userObj = UserLocalServiceUtil.getUserById(PortalUtil.getCompanyId(request), image.getUserId());
						} catch(Exception e) {
							_log.error("No User Exist with User Id:"+image.getUserId());
						}
						if(userObj != null) {
							fullName = userObj.getFullName();
						}
                        List<String> arlStandardsImagesCount = ImageAdminUtil.getStandardsImagesCount(image.getFileEntryId());
                        String stdCount = "0"; String specCount = "0"; String gdlnCount="0";
                        if(arlStandardsImagesCount!=null)
                        {
                            for(int j=0;j<arlStandardsImagesCount.size();j++)
                        {
                            String strCount = arlStandardsImagesCount.get(j);
                            String[] newString = strCount.split(",");
                            String stdType = newString[1];
                            String count =  newString[0];
                            if(newString[1].equalsIgnoreCase("STD"))
                            {
                                if(count!=null && count.length()>0)
                                {
                                    stdCount=newString[0];
                                }
                                
                            }
                            else if(newString[1].equalsIgnoreCase("SPEC"))
                            {
                                if(count!=null && count.length()>0)
                                {
                                    specCount=newString[0];
                                }
                            }
                            else if(newString[1].equalsIgnoreCase("GDLN"))
                            {
                                if(count!=null && count.length()>0)
                                {
                                    gdlnCount=newString[0];
                                }
                            }
                        }}
                        SimpleDateFormat outputDf = new SimpleDateFormat("d MMM yyyy");
                        String displayDate = outputDf.format(image.getCreateDate());
                        %><br/>
                            <div class="image-title"><%=HtmlUtil.escape(image.getTitle()) %></div><br/>
                            <span style="color: #E15F26;" class="image_id" value="<%=image.getFileEntryId() %>" >ID:&nbsp;<%=image.getFileEntryId() %><br/></span>
                            <span style="color: #E15F26;" class="image_date" value="<%=image.getCreateDate() %>">Uploaded :&nbsp;<%=displayDate %><br/></span>
                            <span style="color: #E15F26;" class="image_author" value="<%=fullName %>" >Author :&nbsp;<%=fullName %><br/></span>
                            <span class="image_desc" style="display:none;"><%=image.getDescription() %></span>
                            <span class="image_uuid" style="display:none;"><%=image.getUuid() %></span>
                            <span class="image_groupid" style="display:none;"><%=image.getGroupId() %></span>
                            <span class="small_image_id" style="display:none;"><%=image.getSmallImageId() %></span>
                            <span style="color: #E15F26;" class="image_std_cnt">Standards:&nbsp;<%=stdCount %><br/></span>
                            <span style="color: #E15F26;" class="image_spec_cnt">Specifications:&nbsp;<%=specCount %><br/></span>
                            <span style="color: #E15F26;" class="image_gdln_cnt">Guidelines:&nbsp;<%=gdlnCount %><br/></span>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div style="float: left; margin: 100px 10px 0px;">
                        	<img alt="<liferay-ui:message key="image" />" border="no" src="<%= themeDisplay.getPathThemeImages() %>/application/forbidden_action.png" />
                        </div>
                    </c:otherwise>
                </c:choose>
        <%  }
        } else {%>
            <b>No Result Found</b>
        <%} %>
        </div>
    </td>
    </tr>
    </table>	
    
    <div class="clear"></div>
    
    <%if (!ImageAdminUtil.isNullOrBlank(arlImages)) { %>
    <table id="search_assign_images" summary="Data table for selected images from Image Gallery.">
        <tr class="spec_links_header img_search_header">
            <td style="display:none;"></td>
            <td style="display:none;"></td>
            <td style="display:none;"></td>
            <td style="display:none;"></td>
            <td style="display:none;"></td>
            <td style="display:none;"></td>
            <td style="display:none;"></td>
            <td class="img_search_header_lbl"><strong>Your Selections</strong></td>
            <td></td>
            <td></td>
        </tr>
    </table>
    
    <div  class="search_navigation">
    <c:if test="<%= !isTranslated %>">
        <input type="button" id="img_assign_accept" class="navigation_button" title="Accept" value="Accept" />
    </c:if>
    <!-- 
    <c:if test="<%= isTranslated %>">
        <input type="button" id="img_assign_accept_translate" class="navigation_button" title="Accept" value="Accept" />
    </c:if>
     -->
        <span>&nbsp;&nbsp;</span>
        <input type="button" id="img_assign_cancel" class="navigation_button" title="Cancel" value="Cancel" onclick="parent.jQuery.nmTop().close();" />
    </div>
    <%} %>
    </div>
    <div class="img_search_rounded_container_bottom"> &nbsp;</div>
</aui:form>

<%!
	private static Log _log = LogFactoryUtil.getLog("BSAdmin-portlet.docroot.html.imageadmin.viewSearch_jsp");
%>