<%--
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */
--%>

<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portlet.documentlibrary.util.DLUtil"%>
<%@ include file="/html/portlet/document_library/init.jsp" %>

<%
String cmd = ParamUtil.getString(request, Constants.CMD, Constants.EDIT);

String redirect = ParamUtil.getString(request, "redirect");

String referringPortletResource = ParamUtil.getString(request, "referringPortletResource");

String referringPortletResourceRootPortletId = PortletConstants.getRootPortletId(referringPortletResource);

String uploadProgressId = "dlFileEntryUploadProgress";

FileEntry fileEntry = (FileEntry)request.getAttribute(WebKeys.DOCUMENT_LIBRARY_FILE_ENTRY);

long fileEntryId = BeanParamUtil.getLong(fileEntry, request, "fileEntryId");

long repositoryId = BeanParamUtil.getLong(fileEntry, request, "repositoryId");

if (repositoryId <= 0) {

	// add_asset.jspf only passes in groupId

	repositoryId = BeanParamUtil.getLong(fileEntry, request, "groupId");
}

long folderId = BeanParamUtil.getLong(fileEntry, request, "folderId");
String extension = BeanParamUtil.getString(fileEntry, request, "extension");

Folder folder = null;

if (fileEntry != null) {
	folder = fileEntry.getFolder();
}

if ((folder == null) && (folderId != DLFolderConstants.DEFAULT_PARENT_FOLDER_ID)) {
	try {
		folder = DLAppServiceUtil.getFolder(folderId);
	}
	catch (NoSuchFolderException nsfe) {
		folderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
	}
}

FileVersion fileVersion = null;

long fileVersionId = 0;

long fileEntryTypeId = ParamUtil.getLong(request, "fileEntryTypeId", -1);

if (fileEntry != null) {
	fileVersion = fileEntry.getLatestFileVersion();

	fileVersionId = fileVersion.getFileVersionId();

	if ((fileEntryTypeId == -1) && (fileVersion.getModel() instanceof DLFileVersion)) {
		DLFileVersion dlFileVersion = (DLFileVersion)fileVersion.getModel();

		fileEntryTypeId = dlFileVersion.getFileEntryTypeId();
	}
}

DLFileEntryType dlFileEntryType = null;

if (fileEntryTypeId > 0) {
	dlFileEntryType = DLFileEntryTypeLocalServiceUtil.getFileEntryType(fileEntryTypeId);
}

long assetClassPK = 0;

if ((fileVersion != null) && !fileVersion.isApproved() && Validator.isNotNull(fileVersion.getVersion()) && !fileVersion.getVersion().equals(DLFileEntryConstants.VERSION_DEFAULT)) {
	assetClassPK = fileVersion.getFileVersionId();
}
else if (fileEntry != null) {
	assetClassPK = fileEntry.getFileEntryId();
}

boolean approved = false;
boolean checkedOut = false;
boolean draft = false;
boolean hasLock = false;
boolean pending = false;

Lock lock = null;

if (fileEntry != null) {
	approved = fileVersion.isApproved();
	checkedOut = fileEntry.isCheckedOut();
	draft = fileVersion.isDraft();
	hasLock = fileEntry.hasLock();
	lock = fileEntry.getLock();
	pending = fileVersion.isPending();
}

boolean saveAsDraft = false;

if ((checkedOut || pending) && !PropsValues.DL_FILE_ENTRY_DRAFTS_ENABLED) {
	saveAsDraft = true;
}

String value=request.getParameter("newroomvar");

%>
<script>
var folderId = '<%=folderId%>';
</script>

<c:if test="<%= Validator.isNull(referringPortletResource) %>">
	<liferay-util:include page="/html/portlet/document_library/top_links.jsp" />
</c:if>

<c:if test="<%= checkedOut %>">
	<c:choose>
		<c:when test="<%= hasLock %>">
			<div class="alert alert-success">
				<c:choose>
					<c:when test="<%= lock.isNeverExpires() %>">
						<liferay-ui:message key="you-now-have-an-indefinite-lock-on-this-document" />
					</c:when>
					<c:otherwise>

						<%
						String lockExpirationTime = StringUtil.toLowerCase(LanguageUtil.getTimeDescription(pageContext, DLFileEntryConstants.LOCK_EXPIRATION_TIME));
						%>

						<%= LanguageUtil.format(pageContext, "you-now-have-a-lock-on-this-document", lockExpirationTime, false) %>
					</c:otherwise>
				</c:choose>
			</div>
		</c:when>
		<c:otherwise>
			<div class="alert alert-error">
				<%= LanguageUtil.format(pageContext, "you-cannot-modify-this-document-because-it-was-checked-out-by-x-on-x", new Object[] {HtmlUtil.escape(PortalUtil.getUserName(lock.getUserId(), String.valueOf(lock.getUserId()))), dateFormatDateTime.format(lock.getCreateDate())}, false) %>
			</div>
		</c:otherwise>
	</c:choose>
</c:if>

<c:if test="<%= showHeader %>">

	<%
	boolean localizeTitle = true;
	String headerTitle = LanguageUtil.get(pageContext, "new-document");

	if (fileVersion != null) {
		headerTitle = fileVersion.getTitle();
		localizeTitle= false;
	}
	else if (dlFileEntryType != null) {
		headerTitle = LanguageUtil.format(pageContext, "new-x", new Object[] {dlFileEntryType.getName(locale)});
	}
	%>

	<liferay-ui:header
		backURL="<%= redirect %>"
		localizeTitle="<%= localizeTitle %>"
		title="<%= headerTitle %>"
	/>
</c:if>

<liferay-portlet:actionURL varImpl="editFileEntryURL">
	<liferay-portlet:param name="struts_action" value="/document_library/edit_file_entry" />
	<liferay-portlet:param name="uploadExceptionRedirect" value="<%= currentURL %>" />
</liferay-portlet:actionURL>

<% if(value != null){
	
%>

	<link href="/html/portlet/document_library/bootstrap.min.newsRoomImgCrop-hook.css" rel="stylesheet">
  	<link href="/html/portlet/document_library/cropper.newsRoomImgCrop-hook.css" rel="stylesheet">
  	<link href="/html/portlet/document_library/mainsss.newsRoomImgCrop-hook.css" rel="stylesheet">

	<!-- Start here -->
	<script src="/html/portlet/document_library/jquery.min.newsRoomImgCrop-hook.js"></script>
	<script src="/html/portlet/document_library/cropper.newsRoomImgCrop-hook.js"></script>
  
   	
<div id="newsRoomImgTitle"><h3>Newsroom Image</h3></div>

<portlet:actionURL name="cropUpload" var="cropNUpload">
	<param name="testVar" value="testing"/>
</portlet:actionURL>

<portlet:renderURL var="somePage">
 <portlet:param name="jspPage" value="/html/portlet/document_library/newsroomImage.jsp"></portlet:param>
</portlet:renderURL>



<!-- AJAX Sort of thing -->
<aui:row>
			<aui:col width="<%= 50 %>">
			<div id="deleteMeAfter">
				<aui:form name="fm1">
					<div class="lfr-dynamic-uploader">
						<div class="lfr-upload-container" id="<portlet:namespace />fileUpload"></div>
					</div>
				</aui:form>

				<%
				Date expirationDate = new Date(System.currentTimeMillis() + PropsValues.SESSION_TIMEOUT * Time.MINUTE);

				Ticket ticket = TicketLocalServiceUtil.addTicket(user.getCompanyId(), User.class.getName(), user.getUserId(), TicketConstants.TYPE_IMPERSONATE, null, expirationDate, new ServiceContext());
				%>

				<aui:script use="liferay-upload">
					new Liferay.Upload(
						{
							boundingBox: '#<portlet:namespace />fileUpload',
							deleteFile: '<liferay-portlet:actionURL doAsUserId="<%= user.getUserId() %>"><portlet:param name="struts_action" value="/document_library/edit_file_entry" /><portlet:param name="<%= Constants.CMD %>" value="<%= Constants.DELETE_TEMP %>" /><portlet:param name="folderId" value="<%= String.valueOf(folderId) %>" /></liferay-portlet:actionURL>&ticketKey=<%= ticket.getKey() %><liferay-ui:input-permissions-params modelName="<%= DLFileEntryConstants.getClassName() %>" />',
							fileDescription: '<%= StringUtil.merge(PrefsPropsUtil.getStringArray(PropsKeys.DL_FILE_EXTENSIONS, StringPool.COMMA)) %>',
							maxFileSize: '<%= PrefsPropsUtil.getLong(PropsKeys.DL_FILE_MAX_SIZE) %> B',
							metadataContainer: '#<portlet:namespace />commonFileMetadataContainer',
							metadataExplanationContainer: '#<portlet:namespace />metadataExplanationContainer',
							namespace: '<portlet:namespace />',
							tempFileURL: {
								method: Liferay.Service.bind('/dlapp/get-temp-file-entry-names'),
								params: {
									groupId: <%= scopeGroupId %>,
									folderId: <%= folderId %>,
									tempFolderName: 'com.liferay.portlet.documentlibrary.action.EditFileEntryAction'
								}
							},
							tempRandomSuffix: '<%= EditFileEntryAction.TEMP_RANDOM_SUFFIX %>',
							uploadFile: '<liferay-portlet:actionURL doAsUserId="<%= user.getUserId() %>"><portlet:param name="struts_action" value="/document_library/edit_file_entry" /><portlet:param name="<%= Constants.CMD %>" value="<%= Constants.ADD_TEMP %>" /><portlet:param name="folderId" value="<%= String.valueOf(folderId) %>" /></liferay-portlet:actionURL>&ticketKey=<%= ticket.getKey() %><liferay-ui:input-permissions-params modelName="<%= DLFileEntryConstants.getClassName() %>" />'
						}
					);
				</aui:script>
				</div>
			</aui:col>
			<aui:col width="<%= 50 %>">
				<div class="common-file-metadata-container hide selected" id="<portlet:namespace />commonFileMetadataContainer">
					<liferay-util:include page="/html/portlet/document_library/upload_multiple_file_entries_resources.jsp" />
				</div>

				<%
				DLUtil.addPortletBreadcrumbEntries(folderId, request, renderResponse);

				PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(pageContext, "add-multiple-file-entries"), currentURL);
				%>

				<aui:script>
					Liferay.provide(
						window,
						'<portlet:namespace />updateMultipleFiles',
						function() {
							var A = AUI();
							var Lang = A.Lang;

							var commonFileMetadataContainer = A.one('#<portlet:namespace />commonFileMetadataContainer');
							var selectedFileNameContainer = A.one('#<portlet:namespace />selectedFileNameContainer');

							var inputTpl = '<input id="<portlet:namespace />selectedFileName{0}" name="<portlet:namespace />selectedFileName" type="hidden" value="{1}" />';

							var values = A.all('input[name=<portlet:namespace />selectUploadedFileCheckbox]:checked').val();

							var buffer = [];
							var dataBuffer = [];
							var length = values.length;

							for (var i = 0; i < length; i++) {
								dataBuffer[0] = i;
								dataBuffer[1] = values[i];

								buffer[i] = Lang.sub(inputTpl, dataBuffer);
							}

							selectedFileNameContainer.html(buffer.join(''));

							commonFileMetadataContainer.plug(A.LoadingMask);

							commonFileMetadataContainer.loadingmask.show();

							A.io.request(
								document.<portlet:namespace />fm2.action,
								{
									dataType: 'json',
									form: {
										id: document.<portlet:namespace />fm2
									},
									after: {
										success: function(event, id, obj) {
											var jsonArray = this.get('responseData');

											for (var i = 0; i < jsonArray.length; i++) {
												var item = jsonArray[i];

												var checkBox = A.one('input[data-fileName="' + item.originalFileName + '"]');

												var li = checkBox.ancestor();

												checkBox.remove(true);

												li.removeClass('selectable').removeClass('selected');

												var cssClass = null;
												var childHTML = null;
												var ammendme = '<span class="myMessage">Look the file is successfully been uploaded in the system....</span>';
												var imgsrc = "/documents/"+<%= repositoryId %>+"/<%=folderId%>/"+item.fileName+"";
												
																								
												var image='<img id="imageToCrop" src="'+imgsrc+'" alt="Picture" />';
																							
												var scrpt = document.createElement('script');
												scrpt.src='/html/portlet/document_library/mainss.newsRoomImgCrop-hook.js';
												document.head.appendChild(scrpt);
												
												
												if (item.added) {
													cssClass = 'file-saved';

													var originalFileName = item.originalFileName;

													var pos = originalFileName.indexOf('<%= EditFileEntryAction.TEMP_RANDOM_SUFFIX %>');

													if (pos != -1) {
														originalFileName = originalFileName.substr(0, pos);
													}

													if (originalFileName === item.fileName) {
														childHTML = '<span class="success-message"><%= UnicodeLanguageUtil.get(pageContext, "successfully-saved") %></span>';
													}
													else {
														childHTML = '<span class="success-message"><%= UnicodeLanguageUtil.get(pageContext, "successfully-saved") %> (' + item.fileName + ')</span>';
													}
												}
												else {
													cssClass = 'upload-error';

													childHTML = '<span class="error-message">' + item.errorMessage + '</span>';
												}
												
												var nodeObjectContainer = A.once('#contentHolder');	
												
												li.addClass(cssClass);
												/*li.append(childHTML);*/
												/*li.append(ammendme);*/
																						
												var imageURL = window.location.protocol+"//"+window.location.host+imgsrc;
												var fileNameExt = imageURL.substring(imageURL.lastIndexOf('/')+1);
												var fileName = fileNameExt.substr(0, fileNameExt.lastIndexOf('.'));
												
												var nodeObjectURL = A.one('#filelink');
												var nodeObjectFileName = A.one('#sourceFileName');
												var nodeObjectFileNameExt = A.one('#sourceFileNameExt');
												
												nodeObjectURL.val(imageURL);
												nodeObjectFileNameExt.val(fileNameExt);
												nodeObjectFileName.val(fileName);
												
												var nodeObject = A.one('#deleteMeAfter');
														
												var nodeObjectFileHolder = A.one('.img-container');
												nodeObjectFileHolder.html(image);		
																								
												var noCroppingNeed = '<div id="noCroppingNeed">The image you have uploaded is 585px wide, you dont have to crop this image. Your image is been uploaded anyway.</div><div class="okButton"><a href="<%= redirect %>">OK Take me back</a></div>';
												var cantCrop = '<div id="noCroppingNeed"><h4>The image you have uploaded is less than 585px wide, you cannot use this image. Your image is been uploaded anyway.</h4></div><div class="okButton"><a href="<%= redirect %>">OK Take me back</a></div>';
												
												var img = new Image();
												img.onload = function() {
												  
												  if(this.width >= '585'){

												  											   
												   nodeObject.html('');
												   nodeObject.html(nodeObjectContainer);
												 
												  }else if(this.width<'585'){
												  var submitBtn = A.one('#coords');
												  submitBtn.html('');
												   var nodeObjectFileHolder = A.one('.img-container');
												   var imgPreview = A.one ('.docs-preview');
												   imgPreview.html('');
												   imgPreview.append('');
												   nodeObjectFileHolder.html('');
												   nodeObjectFileHolder.html(cantCrop);
												   nodeObject.html('');
												   nodeObject.html(nodeObjectContainer);
												  }
												 }
												 img.src=imgsrc;
												
												var link = document.createElement('link');
												link.href='/html/portlet/document_library/customstyle.newsRoomImgCrop-hook.css';
												link.rel='stylesheet';
												document.head.appendChild(link);
																																																																						
												var isDragging = false;
												$(".cropper-drag-box").click(function() {
											        isDragging = false;
											    });
											  											
												}

											<liferay-portlet:resourceURL copyCurrentRenderParameters="<%= false %>" var="uploadMultipleFileEntries">
												<portlet:param name="struts_action" value="/document_library/edit_file_entry" />
												<portlet:param name="repositoryId" value="<%= String.valueOf(repositoryId) %>" />
												<portlet:param name="folderId" value="<%= String.valueOf(folderId) %>" />
											</liferay-portlet:resourceURL>

											if (commonFileMetadataContainer.io) {
												commonFileMetadataContainer.io.start();
											}
											else {
												commonFileMetadataContainer.load('<%= uploadMultipleFileEntries %>');
											}

											Liferay.fire('filesSaved');
										},
										failure: function(event, id, obj) {
											var selectedItems = A.all('#<portlet:namespace />fileUpload li.selected');

											selectedItems.removeClass('selectable').removeClass('selected').addClass('upload-error');

											selectedItems.append('<span class="error-message"><%= UnicodeLanguageUtil.get(pageContext, "an-unexpected-error-occurred-while-deleting-the-file") %></span>');

											selectedItems.all('input').remove(true);

											commonFileMetadataContainer.loadingmask.hide();
										}
									}
								}
							);
						},
						['aui-base']
					);
				</aui:script>
				<!-- Buttons start here -->
				<liferay-portlet:actionURL varImpl="editFileEntryURL">
					<liferay-portlet:param name="struts_action" value="/document_library/newsroomImage" />
					<liferay-portlet:param name="uploadExceptionRedirect" value="<%= currentURL %>" />
					<liferay-portlet:param name="uploadedFileName" value="" />
				</liferay-portlet:actionURL>
				
				
				
	<div id="contentHolder" class="container hideDiv">
    <div class="row">
      <div class="col-md-9">
       
        <div class="img-container">
         
          
        </div>
      </div>
      <div class="col-md-3">
    
        <div class="docs-preview clearfix">
          <div class="img-preview preview-lg"></div>
    
        </div>

        <!-- <h3 class="page-header">Data:</h3> -->
        
      </div>
    </div>


    <div class="row">
      <div class="col-md-9 docs-buttons">
        <!-- <h3 class="page-header">Toolbar:</h3> -->
        <form id="coords" class="coords" action="<%=editFileEntryURL %>" enctype="multipart/form-data" method="post">
					<input type="hidden" size="4" id="dataX" name="dataX" />
    				<input type="hidden" size="4" id="dataY" name="dataY" />
    				<input type="hidden" size="4" id="x2" name="x2" />
    				<input type="hidden" size="4" id="y2" name="y2" />
    				<input type="hidden" size="4" id="dataWidth" name="dataWidth" />
    				<input type="hidden" size="4" id="dataHeight" name="dataHeight" />
    				
    				<input type="hidden" size="4" id="filelink" name="filelink"/>
    				<input type="hidden" size="4" id="sourceFileName" name="sourceFileName"/>
    				<input type="hidden" size="4" id="sourceFileNameExt" name="sourceFileNameExt"/>
    				<input type="hidden" size="4" name="repositoryId" value="<%=repositoryId%>"/>
    				<input type="hidden" size="4" name="folderId" value="<%=folderId%>"/>
    				<input type="hidden" size="4" name="folder" value="<%=folder%>"/>
    				<input type="hidden" size="4" name="extension" value="<%=extension%>"/>
    				<input type="hidden" size="4" name="redirect" value="<%=redirect%>"/>
    				<input type="hidden" size="4" name="fileEntryId" value="<%=fileEntryId %>"/>
    				<input type="hidden" size="4" name="fileEntryId" value="<%=fileEntryId %>"/>
    				
             
		    <button class="btn btn-primary" id="submitBtn" data-method="" data-option="0.1" type="Submit" title="Submit">Crop it !!!</button><div style="clear:both;" class="messageAbtCrop"></div>
		    </form>
		    </div>
		    </div>
		    </div>
			</aui:col>
			</aui:row>
<!-- End AJAX sort of thing -->


<%}else{%>


<aui:form action="<%= editFileEntryURL %>" cssClass="lfr-dynamic-form" enctype="multipart/form-data" method="post" name="fm" onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "saveFileEntry(" + saveAsDraft + ");" %>'>
	<aui:input name="<%= Constants.CMD %>" type="hidden" />
	<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
	<aui:input name="referringPortletResource" type="hidden" value="<%= referringPortletResource %>" />
	<aui:input name="uploadProgressId" type="hidden" value="<%= uploadProgressId %>" />
	<aui:input name="repositoryId" type="hidden" value="<%= repositoryId %>" />
	<aui:input name="folderId" type="hidden" value="<%= folderId %>" />
	<aui:input name="fileEntryId" type="hidden" value="<%= fileEntryId %>" />
	<aui:input name="workflowAction" type="hidden" value="<%= String.valueOf(WorkflowConstants.ACTION_PUBLISH) %>" />

	<liferay-ui:error exception="<%= DuplicateFileException.class %>" message="please-enter-a-unique-document-name" />
	<liferay-ui:error exception="<%= DuplicateFolderNameException.class %>" message="please-enter-a-unique-document-name" />

	<liferay-ui:error exception="<%= FileExtensionException.class %>">
		<liferay-ui:message key="document-names-must-end-with-one-of-the-following-extensions" /> <%= StringUtil.merge(PrefsPropsUtil.getStringArray(PropsKeys.DL_FILE_EXTENSIONS, StringPool.COMMA), StringPool.COMMA_AND_SPACE) %>.
	</liferay-ui:error>

	<liferay-ui:error exception="<%= FileMimeTypeException.class %>">
		<liferay-ui:message key="media-files-must-be-one-of-the-following-formats" /> <%= StringUtil.merge(DLUtil.getMediaGalleryMimeTypes(portletPreferences, renderRequest), StringPool.COMMA_AND_SPACE) %>.
	</liferay-ui:error>

	<liferay-ui:error exception="<%= FileNameException.class %>" message="please-enter-a-file-with-a-valid-file-name" />
	<liferay-ui:error exception="<%= NoSuchFolderException.class %>" message="please-enter-a-valid-folder" />

	<liferay-ui:error exception="<%= SourceFileNameException.class %>">
		<liferay-ui:message key="the-source-file-does-not-have-the-same-extension-as-the-original-file" />
	</liferay-ui:error>

	<%
	long fileMaxSize = PrefsPropsUtil.getLong(PropsKeys.DL_FILE_MAX_SIZE);

	if (fileMaxSize == 0) {
		fileMaxSize = PrefsPropsUtil.getLong(PropsKeys.UPLOAD_SERVLET_REQUEST_IMPL_MAX_SIZE);
	}

	fileMaxSize /= 1024;
	%>

	<liferay-ui:error exception="<%= FileSizeException.class %>">
		<liferay-ui:message arguments="<%= fileMaxSize %>" key="please-enter-a-file-with-a-valid-file-size-no-larger-than-x" />
	</liferay-ui:error>

	<liferay-ui:asset-categories-error />

	<liferay-ui:asset-tags-error />

	<aui:model-context bean="<%= fileVersion %>" model="<%= DLFileVersion.class %>" />

	<c:if test="<%= fileVersion != null %>">
		<aui:workflow-status model="<%= DLFileEntry.class %>" status="<%= fileVersion.getStatus() %>" version="<%= fileVersion.getVersion() %>" />
	</c:if>

	<aui:fieldset>
		<aui:field-wrapper>
			<c:if test="<%= fileMaxSize != 0 %>">
				<div class="alert alert-info">
					<%= LanguageUtil.format(pageContext, "upload-documents-no-larger-than-x-k", String.valueOf(fileMaxSize), false) %>
				</div>
			</c:if>
		</aui:field-wrapper>

		<%
		String folderName = StringPool.BLANK;

		if (folderId > 0) {
			folder = DLAppLocalServiceUtil.getFolder(folderId);

			folder = folder.toEscapedModel();

			folderId = folder.getFolderId();
			folderName = folder.getName();
		}
		else {
			folderName = LanguageUtil.get(pageContext, "home");
		}
		%>

		<aui:field-wrapper label="folder">
			<div class="input-append">
				<liferay-ui:input-resource id="folderName" url="<%= folderName %>" />

				<c:if test="<%= referringPortletResourceRootPortletId.equals(PortletKeys.ASSET_PUBLISHER) && (fileEntryId == 0) %>">
					<aui:button name="selectFolderButton" value="select" />

					<%
					String taglibRemoveFolder = "Liferay.Util.removeFolderSelection('folderId', 'folderName', '" + renderResponse.getNamespace() + "');";
					%>

					<aui:button disabled="<%= folderId <= 0 %>" name="removeFolderButton" onClick="<%= taglibRemoveFolder %>" value="remove" />

					<liferay-portlet:renderURL var="selectFolderURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
						<portlet:param name="struts_action" value='<%= "/document_library/select_folder" %>' />
					</liferay-portlet:renderURL>

					<aui:script use="aui-base">
						A.one('#<portlet:namespace />selectFolderButton').on(
							'click',
							function(event) {
								Liferay.Util.selectEntity(
									{
										dialog: {
											constrain: true,
											modal: true,
											width: 680
										},
										id: '<portlet:namespace />selectFolder',
										title: '<liferay-ui:message arguments="folder" key="select-x" />',
										uri: '<%= selectFolderURL.toString() %>'
									},
									function(event) {
										var folderData = {
											idString: 'folderId',
											idValue: event.folderid,
											nameString: 'folderName',
											nameValue: event.foldername
										};

										Liferay.Util.selectFolder(folderData, '<portlet:namespace />');
									}
								);
							}
						);
					</aui:script>
				</c:if>
			</div>
		</aui:field-wrapper>

		<aui:input autoFocus="<%= windowState.equals(WindowState.MAXIMIZED) %>" name="file" onChange='<%= renderResponse.getNamespace() + "validateTitle();" %>' style="width: auto;" type="file">
			<aui:validator name="acceptFiles">
				'<%= StringUtil.merge(PrefsPropsUtil.getStringArray(PropsKeys.DL_FILE_EXTENSIONS, StringPool.COMMA)) %>'
			</aui:validator>
		</aui:input>

		<aui:input name="title">
			<aui:validator errorMessage="you-must-specify-a-file-or-a-title" name="custom">
				function(val, fieldNode, ruleValue) {
					return ((val != '') || A.one('#<portlet:namespace />file').val() != '');
				}
			</aui:validator>
		</aui:input>

		<c:if test="<%= ((folder == null) || folder.isSupportsMetadata()) %>">
			<aui:input name="description" />

			<c:if test="<%= (folder == null) || (folder.getModel() instanceof DLFolder) %>">

				<%
				boolean inherited = false;

				if (folder != null) {
					DLFolder dlFolder = (DLFolder)folder.getModel();

					inherited = !dlFolder.isOverrideFileEntryTypes();
				}

				List<DLFileEntryType> dlFileEntryTypes = DLFileEntryTypeLocalServiceUtil.getFolderFileEntryTypes(PortalUtil.getSiteAndCompanyGroupIds(themeDisplay), folderId, inherited);
				%>

				<c:choose>
					<c:when test="<%= !cmd.equals(Constants.ADD) && (dlFileEntryTypes.size() > 1) %>">
						<aui:select changesContext="<%= true %>" label="document-type" name="fileEntryTypeId" onChange='<%= renderResponse.getNamespace() + "changeFileEntryType();" %>'>

							<%
							for (DLFileEntryType curDLFileEntryType : dlFileEntryTypes) {
								if ((curDLFileEntryType.getFileEntryTypeId() == DLFileEntryTypeConstants.FILE_ENTRY_TYPE_ID_BASIC_DOCUMENT) || (fileEntryTypeId == curDLFileEntryType.getFileEntryTypeId()) || DLFileEntryTypePermission.contains(permissionChecker, curDLFileEntryType, ActionKeys.VIEW)) {
							%>

								<aui:option label="<%= HtmlUtil.escape(curDLFileEntryType.getName(locale)) %>" selected="<%= (fileEntryTypeId == curDLFileEntryType.getPrimaryKey()) %>" value="<%= curDLFileEntryType.getPrimaryKey() %>" />

							<%
								}
							}
							%>

						</aui:select>
					</c:when>
					<c:otherwise>
						<aui:input name="fileEntryTypeId" type="hidden" value="<%= fileEntryTypeId %>" />
					</c:otherwise>
				</c:choose>

				<aui:input name="defaultLanguageId" type="hidden" value="<%= themeDisplay.getLanguageId() %>" />

				<%
				if (fileEntryTypeId > 0) {
					try {
						List<DDMStructure> ddmStructures = dlFileEntryType.getDDMStructures();

						for (DDMStructure ddmStructure : ddmStructures) {
							Fields fields = null;

							try {
								DLFileEntryMetadata fileEntryMetadata = DLFileEntryMetadataLocalServiceUtil.getFileEntryMetadata(ddmStructure.getStructureId(), fileVersionId);

								fields = StorageEngineUtil.getFields(fileEntryMetadata.getDDMStorageId());
							}
							catch (Exception e) {
							}
				%>

							<liferay-ddm:html
								classNameId="<%= PortalUtil.getClassNameId(DDMStructure.class) %>"
								classPK="<%= ddmStructure.getPrimaryKey() %>"
								fields="<%= fields %>"
								fieldsNamespace="<%= String.valueOf(ddmStructure.getPrimaryKey()) %>"
								requestedLocale="<%= locale %>"
							/>

				<%
						}
					}
					catch (Exception e) {
						_log.error(e, e);
					}
				}
				%>

			</c:if>

			<liferay-ui:custom-attributes-available className="<%= DLFileEntryConstants.getClassName() %>">
				<liferay-ui:custom-attribute-list
					className="<%= DLFileEntryConstants.getClassName() %>"
					classPK="<%= fileVersionId %>"
					editable="<%= true %>"
					label="<%= true %>"
				/>
			</liferay-ui:custom-attributes-available>
		</c:if>

		<c:if test="<%= ((folder == null) || folder.isSupportsSocial()) %>">
			<liferay-ui:panel defaultState="closed" extended="<%= false %>" id="dlFileEntryCategorizationPanel" persistState="<%= true %>" title="categorization">
				<aui:fieldset>
					<aui:input classPK="<%= assetClassPK %>" model="<%= DLFileEntry.class %>" name="categories" type="assetCategories" />

					<aui:input classPK="<%= assetClassPK %>" model="<%= DLFileEntry.class %>" name="tags" type="assetTags" />
				</aui:fieldset>
			</liferay-ui:panel>

			<liferay-ui:panel defaultState="closed" extended="<%= false %>" id="dlFileEntryAssetLinksPanel" persistState="<%= true %>" title="related-assets">
				<aui:fieldset>
					<liferay-ui:input-asset-links
						className="<%= DLFileEntry.class.getName() %>"
						classPK="<%= assetClassPK %>"
					/>
				</aui:fieldset>
			</liferay-ui:panel>
		</c:if>

		<c:if test="<%= fileEntry == null %>">
			<aui:field-wrapper label="permissions">
				<liferay-ui:input-permissions
					modelName="<%= DLFileEntryConstants.getClassName() %>"
				/>
			</aui:field-wrapper>
		</c:if>

		<c:if test="<%= approved %>">
			<div class="alert alert-info">
				<liferay-ui:message key="a-new-version-will-be-created-automatically-if-this-content-is-modified" />
			</div>
		</c:if>

		<c:if test="<%= pending %>">
			<div class="alert alert-info">
				<liferay-ui:message key="there-is-a-publication-workflow-in-process" />
			</div>
		</c:if>

		<aui:button-row>

			<%
			String saveButtonLabel = "save";

			if ((fileVersion == null) || draft || approved) {
				saveButtonLabel = "save-as-draft";
			}
			%>

			<c:if test="<%= PropsValues.DL_FILE_ENTRY_DRAFTS_ENABLED %>">
				<aui:button disabled="<%= checkedOut && !hasLock %>" name="saveButton" onClick='<%= renderResponse.getNamespace() + "saveFileEntry(true);" %>' value="<%= saveButtonLabel %>" />
			</c:if>

			<%
			String publishButtonLabel = "publish";

			if (DLUtil.hasWorkflowDefinitionLink(themeDisplay.getCompanyId(), scopeGroupId, folderId, fileEntryTypeId)) {
				publishButtonLabel = "submit-for-publication";
			}

			if (saveAsDraft) {
				publishButtonLabel = "save";
			}
			%>

			<aui:button disabled="<%= checkedOut && !hasLock || (pending && PropsValues.DL_FILE_ENTRY_DRAFTS_ENABLED) %>" name="publishButton" type="submit" value="<%= publishButtonLabel %>" />

			<c:if test="<%= (fileEntry != null) && ((checkedOut && hasLock) || !checkedOut) %>">
				<c:choose>
					<c:when test="<%= !hasLock %>">
						<aui:button onClick='<%= renderResponse.getNamespace() + "checkOut();" %>' value="checkout[document]" />
					</c:when>
					<c:otherwise>
						<aui:button onClick='<%= renderResponse.getNamespace() + "checkIn();" %>' value="save-and-checkin" />

						<aui:button onClick='<%= renderResponse.getNamespace() + "cancelCheckOut();" %>' value="cancel-checkout[document]" />
					</c:otherwise>
				</c:choose>
			</c:if>
			<aui:button href="<%= redirect %>" type="cancel" />
		</aui:button-row>
	</aui:fieldset>
</aui:form>
<%} %>
<liferay-ui:upload-progress
	id="<%= uploadProgressId %>"
	message="uploading"
	redirect="<%= redirect %>"
/>

<aui:script>
	function <portlet:namespace />changeFileEntryType() {
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= Constants.PREVIEW %>";

		submitForm(document.<portlet:namespace />fm);
	}

	function <portlet:namespace />cancelCheckOut() {
		submitForm(document.hrefFm, "<portlet:actionURL><portlet:param name="struts_action" value="/document_library/edit_file_entry" /><portlet:param name="<%= Constants.CMD %>" value="<%= Constants.CANCEL_CHECKOUT %>" /><portlet:param name="redirect" value="<%= redirect %>" /><portlet:param name="fileEntryId" value="<%= String.valueOf(fileEntryId) %>" /></portlet:actionURL>");
	}

	function <portlet:namespace />checkIn() {
		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= Constants.UPDATE_AND_CHECKIN %>";

		submitForm(document.<portlet:namespace />fm);
	}

	function <portlet:namespace />checkOut() {
		submitForm(document.hrefFm, "<portlet:actionURL><portlet:param name="struts_action" value="/document_library/edit_file_entry" /><portlet:param name="<%= Constants.CMD %>" value="<%= Constants.CHECKOUT %>" /><portlet:param name="redirect" value="<%= redirect %>" /><portlet:param name="fileEntryId" value="<%= String.valueOf(fileEntryId) %>" /></portlet:actionURL>");
	}

	function <portlet:namespace />getSuggestionsContent() {
		return document.<portlet:namespace />fm.<portlet:namespace />title.value + ' ' + document.<portlet:namespace />fm.<portlet:namespace />description.value;
	}

	function <portlet:namespace />saveFileEntry(draft) {
		<%= HtmlUtil.escape(uploadProgressId) %>.startProgress();

		if (!draft) {
			document.<portlet:namespace />fm.action = "<%= editFileEntryURL.toString() %>";
		}
		else {

			<%
			editFileEntryURL.setParameter("workflowAction", String.valueOf(WorkflowConstants.ACTION_SAVE_DRAFT));
			%>

			document.<portlet:namespace />fm.action = "<%= editFileEntryURL.toString() %>";
		}

		document.<portlet:namespace />fm.<portlet:namespace /><%= Constants.CMD %>.value = "<%= (fileEntry == null) ? Constants.ADD : Constants.UPDATE %>";

		submitForm(document.<portlet:namespace />fm);
	}

	function <portlet:namespace />validateTitle() {
		Liferay.Form.get('<portlet:namespace />fm').formValidator.validateField('<portlet:namespace />title');
	}
</aui:script>

<%
if (fileEntry != null) {
	DLUtil.addPortletBreadcrumbEntries(fileEntry, request, renderResponse);

	PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(pageContext, "edit"), currentURL);
}
else {
	DLUtil.addPortletBreadcrumbEntries(folderId, request, renderResponse);

	PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(pageContext, "add-file-entry"), currentURL);
}
%>

<%!
private static Log _log = LogFactoryUtil.getLog("portal-web.docroot.html.portlet.document_library.edit_file_entry_jsp");
%>