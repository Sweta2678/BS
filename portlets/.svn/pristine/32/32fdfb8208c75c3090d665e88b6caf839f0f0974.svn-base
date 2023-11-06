<%@include file="/html/imageadmin/init.jsp" %>
<%@page import="com.liferay.portlet.asset.service.AssetTagServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.PropsKeys"%>
<%@page import="com.liferay.portal.kernel.util.PrefsPropsUtil"%>
<%@page import="com.ihg.brandstandards.db.service.StandardsImagesLocalServiceUtil"%>
<%@page import="com.ihg.brandstandards.util.ImageAdminUtil"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<script type="text/javascript" src="/BSTheme-theme/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/jquery-ui-1.10.1.custom.min.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/treeAdmin/jquery.msgBox.js"></script>
<link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/msgBoxLight.css"/>
<script type="text/javascript" src="/BSTheme-theme/js/image_search.js"></script>

<%
List<DLFileEntry> arlImages = new ArrayList<DLFileEntry>();
arlImages = (List<DLFileEntry>) request.getAttribute("arlIGImages");
String prntFolderId = (String) request.getAttribute(ImageAdminUtil.PARENT_FOLDER_ID);
String currFolderId = (String) request.getAttribute(ImageAdminUtil.CURR_FOLDER);
//ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
%>

<portlet:actionURL var="cancel" name="cancel"/>
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
.bsimagegallery {
	left: 100px;
	top:20px;
	width: 90% !important;
}
.bsimagegallery-content .yui3-widget-ft{
	width:auto !important;
}
</style>

    <div class="img_search_rounded_container">
    	<div class="img_search_rounded_container_contents">
        <div class="clear"></div>
        
        <div class="clear"></div>

<div align="left"></div>
<div align="right">
<a href="<%= cancel.toString() %>">&lt;&lt;Go back</a> 
</div>
      
    <table style="width:100%">
    
    <tr class="clear"><td class="clear"></td></tr>
    <tr>
    <td width="95%">
        <div id="imageGalleryAssetInfoPanelContainer">
        <%  
        List<DLFileEntry> results = arlImages;
        
        if(results.size()>0)
        {
        
	        for (int i = 0; i < results.size(); i++) 
	        {
	        	DLFileEntry image = (DLFileEntry)results.get(i);
	        %>
	            <c:choose>
	                <c:when test="true">
	                    <%
	                    FileEntry fileEntry = null;
	                    String smallImageURL = "";
	                    String largeImageURL = "";
	                    String largePreviewImageURL = ""; 
	                    try{
	                    	fileEntry = DLAppLocalServiceUtil.getFileEntry(image.getFileEntryId());
	                    	//String smallImageURL = DLUtil.getImagePreviewURL(fileEntry, themeDisplay);
	                    	smallImageURL = DLUtil.getThumbnailSrc(fileEntry, null, themeDisplay);
	                    	largeImageURL = DLUtil.getPreviewURL(fileEntry, fileEntry.getLatestFileVersion(), themeDisplay, "");
	                    	largePreviewImageURL = DLUtil.getImagePreviewURL(fileEntry, themeDisplay);
	                    } catch(Exception e){
	                    	System.out.println("Failed to get image"+e.getMessage());
	                    }
	                    int smallImageHeight = 128;
	                    int smallImageWidth = 128;
	                    int topMargin = 150 - smallImageHeight;
	                    int sideMargin = (150 - smallImageWidth) / 2;
	                    %>
	                    <div id="imgdetail_<%=image.getFileEntryId() %>" class="add_selected_image">
	                    	<a class="image-thumbnail" href="<%= largePreviewImageURL %>" largeImageId="<%= image.getFileEntryId() %>" title="<%= HtmlUtil.escape(image.getTitle()) + " - " + HtmlUtil.escape(image.getDescription()) %>">
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
	                        for(int j=0;j<arlStandardsImagesCount.size();j++)
	                        {
	                        	String strCount = arlStandardsImagesCount.get(j);
	                        	String[] newString = strCount.split(",");
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
	                        }
					        SimpleDateFormat outputDf = new SimpleDateFormat("d MMM yyyy");
					       	String displayDate = outputDf.format(image.getCreateDate());
	                        %><br/>
	                        <div class="image-title"><%=HtmlUtil.escape(image.getName()) %></div><br/>
	                        <span class="image_id" value="<%=image.getFileEntryId() %>" >ID:&nbsp;<%=image.getFileEntryId() %><br/></span>
	                        <span class="image_date" value="<%=image.getCreateDate() %>">Uploaded :&nbsp;<%=displayDate%><br></span>
	                        <span class="image_author" value="<%=fullName %>" >Author :&nbsp;<%=fullName %><br/></span>
	                        <span class="image_desc" style="display:none;"><%=image.getDescription() %></span>
	                        <span class="image_uuid" style="display:none;"><%=image.getUuid() %></span>
	                        <span class="image_groupid" style="display:none;"><%=image.getGroupId() %></span>
	                        <span class="small_image_id" style="display:none;"><%=image.getSmallImageId() %></span>
	                        <span class="image_std_cnt">Standards:&nbsp;<%=stdCount %><br/></span>
	                        <span class="image_spec_cnt">Specifications:&nbsp;<%=specCount %><br/></span>
	                        <span class="image_gdln_cnt">Guidelines:&nbsp;<%=gdlnCount %><br/></span>
	                    </div>
	                </c:when>
	                <c:otherwise>
	                    <div style="float: left; margin: 100px 10px 0px;">
	                    	<img alt="<liferay-ui:message key="image" />" border="no" src="<%= themeDisplay.getPathThemeImages() %>/application/forbidden_action.png" />
	                    </div>
	                </c:otherwise>
	            </c:choose>
	        <% }  } else {  %>
	        <b>No Result Found</b>
	       <% }%>
	        
	        </div> 
    
        <aui:script use="aui-image-viewer-gallery">
        	var viewportRegion = A.getDoc().get('viewportRegion');
        	var maxHeight = (viewportRegion.height * 0.5);
        	var maxWidth = (viewportRegion.width * 0.5);
        
        	var imageGallery = new A.ImageGallery(
        		{
        			after: {
        				render: function(event) {
        					var instance = this;
        					var footerNode = instance.footerNode;
        
        					instance._actions = A.Node.create('<div class="lfr-image-gallery-actions"></div>');
        
        					if (footerNode) {
        						footerNode.append(
        							instance._actions
        						);
        					}
        				},
        				request: function(event) {
        					var instance = this;
        
        					var currentLink = instance.getCurrentLink();
        					var largeImageId = currentLink.attr('largeImageId');
        					var actions = instance._actions;
        
        					if (actions) {
        						var action = A.one('#<portlet:namespace />buttonsContainer_' + largeImageId);
        
        						actions.empty();
        
        						actions.append(
        							action.clone().show()
        						);
        					}
        				}
        			},
        			delay: 5000,
        			links: '#imageGalleryAssetInfoPanelContainer .add_selected_image .image-thumbnail',
        			maxHeight: maxHeight,
        			maxWidth: maxWidth,
        			cssClass: 'bsimagegallery',
        			playingLabel: '(<liferay-ui:message key="playing" />)'
        		}
        	).render();
        </aui:script>
    </td>
    </tr>
    </table>	

    </div>
    <div class="img_search_rounded_container_bottom"> &nbsp;</div>
<%!
	private static Log _log = LogFactoryUtil.getLog("BSAdmin-portlet.docroot.html.imageadmin.searchImage_jsp");
%>