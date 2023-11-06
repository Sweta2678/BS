<%@page import="com.liferay.portlet.documentlibrary.DuplicateFileException"%>
<%@page import="com.liferay.portlet.documentlibrary.FileExtensionException"%>
<%@page import="com.liferay.portlet.documentlibrary.FileMimeTypeException"%>
<%@page import="com.liferay.portlet.documentlibrary.SourceFileNameException"%>
<%@include file="/html/imageadmin/init.jsp" %>
<script type="text/javascript" src="/BSTheme-theme/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/jquery-ui-1.10.1.custom.min.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/treeAdmin/jquery.msgBox.js"></script>
<script type="text/javascript">
	var portletNamepsace = '<portlet:namespace />';
</script>

<%
	String redirect = ParamUtil.getString(request, "redirect");
	String referringPortletResource = ParamUtil.getString(request, "referringPortletResource");
	String uploadProgressId = "igImageUploadProgress";
	DLFileEntry image = (DLFileEntry)request.getAttribute("igImage");
	User currUser = (User) request.getAttribute(WebKeys.USER);
	long imageId = BeanParamUtil.getLong(image, request, ImageAdminUtil.IMAGE_ID);
	long folderId = Long.parseLong((String)request.getAttribute(ImageAdminUtil.FOLDER_ID));
	String prntFolderId = (String) request.getAttribute("prntFolderId");
	String currFolderId = (String) request.getAttribute(ImageAdminUtil.CURR_FOLDER);
	long imageMaxSize = 10240000 / 1024;
%>
<script type="text/javascript">
	function <portlet:namespace />saveImage() {
		<%= HtmlUtil.escape(uploadProgressId) %>.startProgress();

		document.<portlet:namespace />fm.<portlet:namespace /><%= ImageAdminUtil.CMD %>.value = "<%= (image == null) ? ImageAdminUtil.CMD_ADD_IMAGE : ImageAdminUtil.CMD_EDIT_IMAGE %>";
		submitForm(document.<portlet:namespace />fm);
	}
	function showFolder(folderId)
	{
		var currFolder = document.getElementById('<portlet:namespace/>'+'<%=ImageAdminUtil.CURR_FOLDER%>');
		currFolder.value = folderId;
		var frm  = document.getElementById('<portlet:namespace/>fm');
		frm.submit();
	}
</script>

<portlet:renderURL var="cancelImageEdit">
	<portlet:param name="CURR_FOLDER" value="<%=currFolderId%>"></portlet:param>
</portlet:renderURL>

<c:if test="<%= image == null %>">
	<aui:script use="liferay-upload">
		new Liferay.Upload({
			allowedFileTypes: '.bmp,.gif,.jpeg,.jpg,.png,.tif,.tiff',
			container: '#<portlet:namespace />fileUpload',
			fileDescription: '.bmp,.gif,.jpeg,.jpg,.png,.tif,.tiff',
			fallbackContainer: '#<portlet:namespace />fallback',
			maxFileSize: 10240000 / 1024,
			namespace: '<portlet:namespace />',
			uploadFile: '<liferay-portlet:actionURL windowState="<%= LiferayWindowState.POP_UP.toString() %>" doAsUserId="<%= currUser.getUserId() %>"><portlet:param name="struts_action" value="/image_gallery/edit_image" /><portlet:param name="<%= ImageAdminUtil.CMD %>" value="<%= ImageAdminUtil.CMD_EDIT_IMAGE %>" /><portlet:param name="folderId" value="<%= String.valueOf(folderId) %>" /></liferay-portlet:actionURL><liferay-ui:input-permissions-params modelName="<%= DLFileEntry.class.getName() %>" />'
		});
	</aui:script>
</c:if>


<portlet:actionURL var="updateImageUrl"  name="updateImage" ></portlet:actionURL>

<aui:form action="<%= updateImageUrl %>" enctype="multipart/form-data" method="post" name="fm" onSubmit="saveImage()">
	<aui:input name="<%= ImageAdminUtil.CMD %>" type="hidden" />
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="referringPortletResource" type="hidden" value="<%= referringPortletResource %>" />
	<aui:input name="uploadProgressId" type="hidden" value="<%= uploadProgressId %>" />
	<aui:input name="imageId" type="hidden" value="<%= imageId %>" id="currentImageId"/>
	<aui:input name="folderId" type="hidden" value="<%= folderId %>" />
	<aui:input type="hidden" id="<%=ImageAdminUtil.CURR_FOLDER%>" name="<%=ImageAdminUtil.CURR_FOLDER%>" value="<%=folderId%>"/>

	<liferay-ui:error exception="<%= DuplicateFileException.class %>" message="please-enter-a-unique-document-name" />
	<liferay-ui:error exception="<%= DuplicateFolderNameException.class %>" message="please-enter-a-unique-document-name" />

	<liferay-ui:error exception="<%= FileExtensionException.class %>">
		<liferay-ui:message key="document-names-must-end-with-one-of-the-following-extensions" /> 
		<%= StringUtil.merge(PrefsPropsUtil.getStringArray(PropsKeys.DL_FILE_EXTENSIONS, StringPool.COMMA), StringPool.COMMA_AND_SPACE) %>.
	</liferay-ui:error>

	<liferay-ui:error exception="<%= FileMimeTypeException.class %>">
		<liferay-ui:message key="media-files-must-be-one-of-the-following-formats" /> <%= StringUtil.merge(DLUtil.getMediaGalleryMimeTypes(portletPreferences, renderRequest), StringPool.COMMA_AND_SPACE) %>.
	</liferay-ui:error>

	<liferay-ui:error exception="<%= FileNameException.class %>" message="please-enter-a-file-with-a-valid-file-name" />
	<liferay-ui:error exception="<%= NoSuchFolderException.class %>" message="please-enter-a-valid-folder" />

	<liferay-ui:error exception="<%= SourceFileNameException.class %>">
		<liferay-ui:message key="the-source-file-does-not-have-the-same-extension-as-the-original-file" />
	</liferay-ui:error>

	<liferay-ui:asset-tags-error />

	<aui:model-context bean="<%= image %>" model="<%= DLFileEntry.class %>" />
<table ><tr ><td width="75%">
	<aui:field-wrapper>
		<c:if test="<%= imageMaxSize != 0 %>">
			<div class="portlet-msg-info">
				<%= LanguageUtil.format(pageContext, "upload-images-no-larger-than-x-k", String.valueOf(imageMaxSize), false) %>
			</div>
		</c:if>
	</aui:field-wrapper>

	<aui:fieldset>
		<aui:input name="file" type="file" onchange="javascript:checkAllFields(this.value)"/>
		<aui:input name="name" size="300" type="hidden"/>
		<aui:input name="title" size="300" />
		<aui:input name="description" size="2000"/>
		<liferay-ui:custom-attributes-available className="<%= DLFileEntry.class.getName() %>">
			<liferay-ui:custom-attribute-list className="<%= DLFileEntry.class.getName() %>" classPK="<%= imageId %>" editable="<%= true %>" label="<%= true %>" />
		</liferay-ui:custom-attributes-available>
		<c:if test="<%= image == null %>">
			<aui:field-wrapper label="permissions">
				<liferay-ui:input-permissions modelName="<%= DLFileEntry.class.getName() %>" />
			</aui:field-wrapper>
		</c:if>
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" id="addUpdateImage" disabled="false"/>
		<aui:button onClick="<%= cancelImageEdit %>" type="cancel" />
	</aui:button-row>
</td>
<td width="25%">
	<table  align="right" class="results_table">
		<tr class="results_header_bar">
			<td class="result_table_cell2"><strong>Admin</strong></td>
		</tr>
		<tr><td>
		<%
       		FileEntry fileEntry = DLAppLocalServiceUtil.getFileEntry(image.getFileEntryId());
            //String smallImageURL = DLUtil.getImagePreviewURL(fileEntry, themeDisplay);
            String smallImageURL = DLUtil.getThumbnailSrc(fileEntry, null, themeDisplay);
            String largeImageURL = DLUtil.getPreviewURL(fileEntry, fileEntry.getLatestFileVersion(), themeDisplay, "");

			int smallImageHeight = 128;
			int smallImageWidth = 128;
			int topMargin = 150 - smallImageHeight;
			int sideMargin = (150 - smallImageWidth) / 2;
		%>
			<a class="image-thumbnail" href="<%= largeImageURL %>" largeImageId="<%= image.getFileEntryId() %>" title="<%= HtmlUtil.escape(image.getTitle()) + " - " + HtmlUtil.escape(image.getDescription()) %>">
				<img alt="<%= HtmlUtil.escape(image.getTitle()) + " - " + HtmlUtil.escape(image.getDescription()) %>" border="no" 
                    src="<%= smallImageURL %>"  
                    style="max-height:128px;max-width:128px;height: <%= smallImageHeight %>; margin: <%= topMargin %>px <%= sideMargin %>px 0px <%= sideMargin %>px; width: <%= smallImageWidth %>;" />
			</a>
		</td></tr>
		<tr><td>
		<liferay-ui:icon-menu showExpanded="true" showWhenSingleIcon="true">
		<%
			String downloadURL = largeImageURL;
		%>

		<liferay-ui:icon image="download" 	url="<%= downloadURL %>"/>
		<portlet:actionURL name="deleteImage" var="deleteImageURL">
	      <portlet:param name="<%=ImageAdminUtil.FOLDER_ID%>" value="<%=currFolderId %>" />
	      <portlet:param name="<%=ImageAdminUtil.CURR_FOLDER%>" value="<%=currFolderId %>" />
	      <portlet:param name="<%=ImageAdminUtil.IMAGE_ID%>" value="<%=String.valueOf(image.getFileEntryId()) %>" />
	    </portlet:actionURL>
	    <liferay-ui:icon-delete url="<%=deleteImageURL.toString() %>" />
	    
	    </liferay-ui:icon-menu>
	  	</td></tr>
	</table>
</td>
</tr></table>
</aui:form>

<liferay-ui:upload-progress id="<%= uploadProgressId %>" message="uploading" redirect="<%= redirect %>" />

<c:if test="<%= image == null %>">
	</div>
</c:if>


<aui:script use="aui-base">
	var validateFile = function(fileField) {
		var value = fileField.val();

		if (value) {
			var extension = value.substring(value.lastIndexOf('.')).toLowerCase();
			var validExtensions = ['.bmp','.gif','.jpeg','.jpg','.png','.tif','.tiff'];

			if ((A.Array.indexOf(validExtensions, '*') == -1) &&
				(A.Array.indexOf(validExtensions, extension) == -1)) {

				alert('Only files with following extensions are allowed: bmp, gif, jpeg, jpg, png, tif, tiff');

				fileField.val('');
			}
		}
	};

	var onFileChange = function(event) {
		validateFile(event.currentTarget);
	};

	var fileField = A.one('#<portlet:namespace />file')

	if (fileField) {
		fileField.on('change', onFileChange);

		validateFile(fileField);
	}
AUI().ready('node', 'aui-char-counter', function(A) {
   var portletNamepsace = '<portlet:namespace />';
   var auiinputDesc = '#' + portletNamepsace + 'description';
   var auiTextCounter1 = new A.CharCounter( {
                             input: auiinputDesc,
                             maxLength: 2000
	});
});
</aui:script>
<script type="text/javascript" src="/BSTheme-theme/js/imageAdmin.js"></script>