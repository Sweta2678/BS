<%@include file="/html/imageadmin/init.jsp" %>
<script type="text/javascript" src="/BSTheme-theme/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/jquery-ui-1.10.1.custom.min.js"></script>

<%
    List<DLFolder> arlFolders = (List<DLFolder>) request.getAttribute("arlFolders");
	List<DLFileEntry> arlImages = (List<DLFileEntry>) request.getAttribute("arlImages");
	String prntFolderId = (String) request.getAttribute(ImageAdminUtil.PARENT_FOLDER_ID);
	String currFolderId = (String) request.getAttribute(ImageAdminUtil.CURR_FOLDER);
	String prevFolderId = (String) request.getAttribute(ImageAdminUtil.FOLDER_ID);
	String folderId = "";
	String folderName = (String) request.getAttribute(ImageAdminUtil.FOLDER_NAME);
	String parentFolderName = (String) request.getAttribute(ImageAdminUtil.PRNT_FOLDER_NAME);
	String addFolderTxt = "Add Folder";	
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
#imgdetail 
{
	float:left; 
	margin-right:4px; 
	border:1px solid;
	padding: 8px;
	width: 30%;
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
    width:930px;
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
.bsimagegallery {
	left: 100px;
	top:20px;
	width: 90% !important;
}
.bsimagegallery-content .yui3-widget-ft{
	width:auto !important;
}
</style>

<portlet:actionURL name="searchImage" var="searchImageURL" />
<liferay-portlet:renderURL varImpl="imageAdminURL"></liferay-portlet:renderURL>

<aui:form name="searchImage" action="<%=searchImageURL.toString() %>" method="post" >
    <div id="searchImgGallery" class="search_gallery">
        <span class="disp_search_lbl">Search the Gallery:</span>
        <input type="text" class="search_text_box" name="<%=ImageAdminUtil.SEARCH_TXT%>" id="<%=ImageAdminUtil.SEARCH_TXT%>" value="" size="115" maxlength="300" title="Search Images" />
        <aui:button type="submit" value="Search" />
    </div>
</aui:form>

<aui:form action="<%= imageAdminURL %>" method="post" name="imageForm" >
  <aui:input type="hidden" id="<%=ImageAdminUtil.CURR_FOLDER%>" name="<%=ImageAdminUtil.CURR_FOLDER%>" value="<%=currFolderId%>"/>
  <aui:input type="hidden" id="<%=ImageAdminUtil.PARENT_FOLDER_ID%>" name="<%=ImageAdminUtil.PARENT_FOLDER_ID%>" value="<%=prntFolderId%>"/>
<div class="rounded_container">
	<div class="rounded_container_contents">
<div class="clear"></div>

<div align="left"><%=folderName %></div>
<div align="right">
	<% if (!ImageAdminUtil.IsNullOrBlank(prntFolderId) && !prntFolderId.equals(currFolderId)) {
		addFolderTxt = "Add Sub Folder";
	%>
	<a href="#" onclick="showFolder('<%=prntFolderId%>')"><B>&lt;&lt;Back to <%=parentFolderName %></B></a> 
	<% } %>
</div>
<table width="100%">
<tr><td width="74%">
<table class="results_table" summary="Data table for all results" width="100%">
	<tr class="results_header_bar">
		<td class="result_table_cell2"><strong>Folder</strong></td>
	   	<td class="result_table_cell4"><strong># of Folders</strong></td>
	  	<td class="result_table_cell4"><strong># of Entries</strong></td>
	   	<td class="result_table_cell4"><strong>&nbsp;</strong></td>
	</tr>
	<%
	    for (DLFolder igFolder : arlFolders) {
            List<DLFolder> arlSubFolders = DLFolderLocalServiceUtil.getFolders(themeDisplay.getLayout().getGroupId(), igFolder.getFolderId());
            folderId = String.valueOf(igFolder.getFolderId());
	%>
	<tr>
	<td><a href="#" onclick="showFolder('<%=igFolder.getFolderId()%>')"><%=igFolder.getName()%></a><br/>
	<b>Sub-Folders:</b><br/>
	<% 	for (DLFolder igSubFolders : arlSubFolders) {
			String subFolderName = igSubFolders.getName();
	%>
			<a href="#"  onclick="showFolder('<%=igSubFolders.getFolderId()%>')"><%=subFolderName%></a>,&nbsp;
	<%
		}
	%>
	</td>
	<td ><%=arlSubFolders.size()%></td>
	<td ><%=DLFileEntryLocalServiceUtil.getFileEntriesCount(themeDisplay.getLayout().getGroupId(), igFolder.getFolderId())%></td>
	<td >
		<liferay-ui:icon-menu>
		    <portlet:actionURL name="editFolder" var="editURL">
		      <portlet:param name="<%=ImageAdminUtil.FOLDER_ID%>" value="<%=folderId %>" />
		      <portlet:param name="<%=ImageAdminUtil.CURR_FOLDER%>" value="<%=currFolderId %>" />
		    </portlet:actionURL>
    		<liferay-ui:icon image="edit" message="Edit" url="<%=editURL.toString() %>" />
 
			<% if(ImageAdminUtil.canDelete(themeDisplay.getLayout().getGroupId(), folderId)) {%>
			    <portlet:actionURL name="deleteFolder" var="deleteURL">
			      <portlet:param name="<%=ImageAdminUtil.FOLDER_ID%>" value="<%=folderId %>" />
			      <portlet:param name="<%=ImageAdminUtil.CURR_FOLDER%>" value="<%=currFolderId %>" />
			    </portlet:actionURL>
			    <liferay-ui:icon-delete url="<%=deleteURL.toString() %>" />
			 <% } %>
	
			<portlet:actionURL name="addSubFolder" var="addSubFolderURL">
		      <portlet:param name="<%=ImageAdminUtil.FOLDER_ID%>" value="<%=folderId %>" />
		      <portlet:param name="<%=ImageAdminUtil.CURR_FOLDER%>" value="<%=currFolderId %>" />
		    </portlet:actionURL>
		    <liferay-ui:icon image="add_folder" message='Add Sub Folder'	url="<%= addSubFolderURL %>"/>
  
		    <portlet:actionURL name="addImage" var="addImageURL">
		      <portlet:param name="<%=ImageAdminUtil.FOLDER_ID%>" value="<%=folderId %>" />
		      <portlet:param name="<%=ImageAdminUtil.CURR_FOLDER%>" value="<%=currFolderId %>" />
		    </portlet:actionURL>
		    <liferay-ui:icon image="../image_gallery/add_image"  message="add-image" url="<%= addImageURL %>" />
		</liferay-ui:icon-menu></td>
	</tr>
	<% } %>
</table>
</td>
<td width="2%" > &nbsp;</td>
<td width="24%" align = "right">
<table  align="right" class="results_table">
	<tr class="results_header_bar">
		<td class="result_table_cell2"><strong>Admin</strong></td>
	</tr>
	<tr><td>
	<liferay-ui:icon-menu showExpanded="true" showWhenSingleIcon="true">
	<%
	if (!ImageAdminUtil.IsNullOrBlank(prntFolderId) && !prntFolderId.equals(currFolderId)) {
%>
	<portlet:actionURL name="editFolder" var="editURL">
      <portlet:param name="<%=ImageAdminUtil.FOLDER_ID%>" value="<%=currFolderId %>" />
      <portlet:param name="<%=ImageAdminUtil.CURR_FOLDER%>" value="<%=currFolderId %>" />
    </portlet:actionURL>
    <liferay-ui:icon image="edit" message="Edit" url="<%=editURL.toString() %>" />
    <%} %>
  
<% if(!ImageAdminUtil.IsNullOrBlank(prntFolderId) && !prntFolderId.equals(currFolderId) && ImageAdminUtil.canDelete(themeDisplay.getLayout().getGroupId(), currFolderId)) {	%>
    <portlet:actionURL name="deleteFolder" var="deleteURL">
      <portlet:param name="<%=ImageAdminUtil.FOLDER_ID%>" value="<%=currFolderId %>" />
      <portlet:param name="<%=ImageAdminUtil.CURR_FOLDER%>" value="<%=currFolderId %>" />
    </portlet:actionURL>
    <liferay-ui:icon-delete url="<%=deleteURL.toString() %>" />
<% } %>
	<portlet:actionURL name="addSubFolder" var="addSubFolderURL">
      <portlet:param name="<%=ImageAdminUtil.FOLDER_ID%>" value="<%=currFolderId %>" />
      <portlet:param name="<%=ImageAdminUtil.CURR_FOLDER%>" value="<%=currFolderId %>" />
    </portlet:actionURL>
    <liferay-ui:icon image="add_folder" message='<%=addFolderTxt%>'	url="<%= addSubFolderURL %>"/>
 <%
	if (!ImageAdminUtil.IsNullOrBlank(prntFolderId) && !prntFolderId.equals(currFolderId)) {
%> 
    <portlet:actionURL name="addImage" var="addImageURL">
      <portlet:param name="<%=ImageAdminUtil.FOLDER_ID%>" value="<%=currFolderId %>" />
      <portlet:param name="<%=ImageAdminUtil.CURR_FOLDER%>" value="<%=currFolderId %>" />
    </portlet:actionURL>
    <liferay-ui:icon image="../image_gallery/add_image"  message="add-image" url="<%= addImageURL %>" />
    <%} %>
    </liferay-ui:icon-menu>
  	</td></tr>
</table>
</td>
</tr>
<tr class="clear"><td class="clear"></td></tr>
<tr><td width="80%">
<div id="imageGalleryAssetInfoPanelContainer">

	<%  List<DLFileEntry> results = arlImages;
	for (int i = 0; i < results.size(); i++) {
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
				<div id="imgdetail" class="add_selected_image">
				<a class="image-thumbnail" href="<%= largePreviewImageURL %>" largeImageId="<%= image.getFileEntryId() %>" title="<%= HtmlUtil.escape(image.getTitle()) + " - " + HtmlUtil.escape(image.getDescription()) %>">
						<img alt="<%= HtmlUtil.escape(image.getTitle()) + " - " + HtmlUtil.escape(image.getDescription()) %>" border="no" 
                             src="<%= smallImageURL %>" 
                             style="max-height:128px;max-width:128px;height: <%= smallImageHeight %>; margin: <%= topMargin %>px <%= sideMargin %>px 0px <%= sideMargin %>px; width: <%= smallImageWidth %>;" />

					<div class="aui-helper-hidden" id="<portlet:namespace />buttonsContainer_<%= image.getFileEntryId() %>">
						<div class="buttons-container float-container" id="<portlet:namespace />buttons_<%= image.getFileEntryId() %>">
							<!--  %@ include file="/html/portlet/image_gallery/image_action.jspf" %  -->
						</div>
					</div>
					<% 	User userObj = null;
						String fullName = "Does not exist";
						try {
							userObj = UserLocalServiceUtil.getUserById(PortalUtil.getCompanyId(request), image.getUserId());
						} catch(Exception e) { }
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
						ID:&nbsp;<%=image.getFileEntryId() %><br/>
						Uploaded :&nbsp;<%=displayDate %><br/>
						Author : &nbsp;<%=fullName %><br/>
						Standards:&nbsp;<%=stdCount %><br/>
						Specifications:&nbsp;<%=specCount %><br/>
						Guidelines:&nbsp;<%=gdlnCount %><br/>
						<portlet:actionURL name="editImage" var="editImageURL">
					      <portlet:param name="<%=ImageAdminUtil.FOLDER_ID%>" value="<%=currFolderId %>" />
					      <portlet:param name="<%=ImageAdminUtil.CURR_FOLDER%>" value="<%=currFolderId %>" />
					      <portlet:param name="<%=ImageAdminUtil.IMAGE_ID%>" value="<%=String.valueOf(image.getFileEntryId()) %>" />
					    </portlet:actionURL>
					    <liferay-ui:icon image="edit" message="Edit" url="<%=editImageURL.toString() %>" />
					     <portlet:actionURL name="deleteImage" var="deleteImageURL">
					      <portlet:param name="<%=ImageAdminUtil.FOLDER_ID%>" value="<%=currFolderId %>" />
					      <portlet:param name="<%=ImageAdminUtil.CURR_FOLDER%>" value="<%=currFolderId %>" />
					      <portlet:param name="<%=ImageAdminUtil.IMAGE_ID%>" value="<%=String.valueOf(image.getFileEntryId()) %>" />
					    </portlet:actionURL>
					    <liferay-ui:icon-delete url="<%=deleteImageURL.toString() %>" />
					</div>
			</c:when>
			<c:otherwise>
				<div style="float: left; margin: 100px 10px 0px;">
					<img alt="<liferay-ui:message key="image" />" border="no" src="<%= themeDisplay.getPathThemeImages() %>/application/forbidden_action.png" />
				</div>
			</c:otherwise>
		</c:choose>

	<%
	}
	%>

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
			links: '#imageGalleryAssetInfoPanelContainer #imgdetail .image-thumbnail',
			maxHeight: maxHeight,
			maxWidth: maxWidth,
			cssClass: 'bsimagegallery',
			playingLabel: '(<liferay-ui:message key="playing" />)'
		}
	).render();
</aui:script>
</td></tr></table>	
</div><div class="rounded_container_bottom">
		&nbsp;</div></div>
</aui:form>