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
	String name = BeanParamUtil.getString(image, request, "name");
	String extension = StringPool.BLANK;
	String assetTagNames = ParamUtil.getString(request, "assetTagNames");
	DLFolder folder = null;
	Image largeImage = null;
	if (image != null) {
		folder = image.getFolder();
		largeImage = ImageLocalServiceUtil.getImage(image.getLargeImageId());
	    extension = StringPool.PERIOD + largeImage.getType();
	}
	long imageMaxSize = 10240000 / 1024;
%>
<script>
	function <portlet:namespace />saveImage() {
		<%= HtmlUtil.escape(uploadProgressId) %>.startProgress();
		document.<portlet:namespace />fm.<portlet:namespace /><%= ImageAdminUtil.CMD %>.value = "<%= (image == null) ? ImageAdminUtil.CMD_ADD_IMAGE : ImageAdminUtil.CMD_EDIT_IMAGE %>";
		submitForm(document.<portlet:namespace />fm);
	}
</script>

<script type="text/javascript">
	function showFolder(folderId) {
		var currFolder = document.getElementById('<portlet:namespace/>'+'<%=ImageAdminUtil.CURR_FOLDER%>');
		currFolder.value = folderId;
		var frm  = document.getElementById('<portlet:namespace/>fm');
		frm.submit();
	}
</script>

<portlet:actionURL var="updateImageUrl"  name="updateImage" ></portlet:actionURL>

<aui:form action="<%= updateImageUrl %>" enctype="multipart/form-data" method="post" name="fm" onSubmit="saveImage()">
	<aui:input name="<%= ImageAdminUtil.CMD %>" type="hidden" />
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="referringPortletResource" type="hidden" value="<%= referringPortletResource %>" />
	<aui:input name="uploadProgressId" type="hidden" value="<%= uploadProgressId %>" />
	<aui:input name="imageId" type="hidden" value="<%= imageId %>" id="currentImageId" />
	<aui:input name="folderId" type="hidden" value="<%= folderId %>" />
	<aui:input type="hidden" id="<%=ImageAdminUtil.CURR_FOLDER%>" name="<%=ImageAdminUtil.CURR_FOLDER%>" value="<%=folderId%>"/>
	<liferay-ui:error exception="<%= DuplicateFileEntryTypeException.class %>" message="please-enter-a-unique-image-name" />

	<liferay-ui:error exception="<%= FileNameException.class %>">
		<liferay-ui:message key="image-names-must-end-with-one-of-the-following-extensions" /> .
	</liferay-ui:error>
	<liferay-ui:error exception="<%= FileSizeException.class %>" message="please-enter-a-file-with-a-valid-file-size" />
	<liferay-ui:error exception="<%= NoSuchFolderException.class %>" message="please-enter-a-valid-folder" />
	<liferay-ui:asset-tags-error />

	<aui:model-context bean="<%= image %>" model="<%= DLFileEntry.class %>" />
	<aui:field-wrapper>
		<c:if test="<%= imageMaxSize != 0 %>">
			<div class="portlet-msg-info">
				<%= LanguageUtil.format(pageContext, "upload-images-no-larger-than-x-k", String.valueOf(imageMaxSize), false) %>
			</div>
		</c:if>
	</aui:field-wrapper>

	<aui:fieldset>
		<aui:input name="file" type="file" onchange="javascript:checkAllFields(this.value)"/>
		<aui:input name="name" size="300"  id="name" />
		<aui:input name="description" id="description" size="2000"/>
		<liferay-ui:custom-attributes-available className="<%= DLFileEntry.class.getName() %>">
			<liferay-ui:custom-attribute-list
				className="<%= DLFileEntry.class.getName() %>"
				classPK="<%= imageId %>"
				editable="<%= true %>"
				label="<%= true %>"
			/>
		</liferay-ui:custom-attributes-available>
		<c:if test="<%= image == null %>">
			<aui:field-wrapper label="permissions">
				<liferay-ui:input-permissions
					modelName="<%= DLFileEntry.class.getName() %>"
				/>
			</aui:field-wrapper>
		</c:if>
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" id="addUpdateImage" disabled="true"/>

		<aui:button onClick="showFolder('<%=folderId %>')" type="cancel" />
	</aui:button-row>
</aui:form>

<liferay-ui:upload-progress
	id="<%= uploadProgressId %>"
	message="uploading"
	redirect="<%= redirect %>"
/>

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