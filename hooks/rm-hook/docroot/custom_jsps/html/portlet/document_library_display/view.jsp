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
<script>

	jQuery(document).ready(function(){
	  var pgID = $('#data_doc').attr('data-rel');
	  
		if(pgID == 'documents-home'){
			
			$('.rm_tabs li:nth-child(1)').find('a').addClass('selected').parent().addClass('dropdown');
			
		}else if(pgID == 'recent-documents'){
			$('.rm_tabs li:nth-child(2)').find('a').addClass('selected').parent().addClass('dropdown');
			
		} else if(pgID == 'my-documents'){
			
			$('.rm_tabs li:nth-child(3)').find('a').addClass('selected').parent().addClass('dropdown');
			
		}
	});
</script>

<%@ include file="/html/portlet/document_library_display/init.jsp" %>

<%
String topLink = ParamUtil.getString(request, "topLink", "home");

String redirect = ParamUtil.getString(request, "redirect");

Folder folder = (Folder)request.getAttribute(WebKeys.DOCUMENT_LIBRARY_FOLDER);

long defaultFolderId = GetterUtil.getLong(portletPreferences.getValue("rootFolderId", StringPool.BLANK), DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);

long folderId = BeanParamUtil.getLong(folder, request, "folderId", defaultFolderId);

boolean defaultFolderView = false;

if ((folder == null) && (defaultFolderId != DLFolderConstants.DEFAULT_PARENT_FOLDER_ID)) {
	defaultFolderView = true;
}

if (defaultFolderView) {
	try {
		folder = DLAppLocalServiceUtil.getFolder(folderId);
	}
	catch (NoSuchFolderException nsfe) {
		folderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
	}
}

long repositoryId = scopeGroupId;

if (folder != null) {
	repositoryId = folder.getRepositoryId();
}

int status = WorkflowConstants.STATUS_APPROVED;

if (permissionChecker.isContentReviewer(user.getCompanyId(), scopeGroupId)) {
	status = WorkflowConstants.STATUS_ANY;
}

int foldersCount = DLAppServiceUtil.getFoldersCount(repositoryId, folderId);
int fileEntriesCount = DLAppServiceUtil.getFileEntriesAndFileShortcutsCount(repositoryId, folderId, status);

long assetCategoryId = ParamUtil.getLong(request, "categoryId");
String assetTagName = ParamUtil.getString(request, "tag");

boolean useAssetEntryQuery = (assetCategoryId > 0) || Validator.isNotNull(assetTagName);

PortletURL portletURL = renderResponse.createRenderURL();

portletURL.setParameter("struts_action", "/document_library_display/view");
portletURL.setParameter("topLink", topLink);
portletURL.setParameter("folderId", String.valueOf(folderId));

request.setAttribute("view.jsp-folder", folder);

request.setAttribute("view.jsp-defaultFolderId", String.valueOf(defaultFolderId));

request.setAttribute("view.jsp-folderId", String.valueOf(folderId));

request.setAttribute("view.jsp-repositoryId", String.valueOf(repositoryId));

request.setAttribute("view.jsp-viewFolder", Boolean.TRUE.toString());

request.setAttribute("view.jsp-useAssetEntryQuery", String.valueOf(useAssetEntryQuery));
%>
<div class="rm_resource_div">
	<portlet:actionURL var="undoTrashURL">
		<portlet:param name="struts_action" value="/document_library/edit_entry" />
		<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.RESTORE %>" />
	</portlet:actionURL>
	
	<liferay-ui:trash-undo portletURL="<%= undoTrashURL %>" />
	
	<liferay-util:include page="/html/portlet/document_library/top_links.jsp" />
	<!----------------------------------------- for top icons start--------------------------------------->
		
			<%
	
				String redirect = currentURL;
				
				ResultRow rowTopIcons = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
				
				DLFolder folderTopIcons = null;
				
				long folderIdTopIcons = 0;
					
				if (rowTopIcons != null) {
					folderTopIcons = (DLFolder)rowTopIcons.getObject();
				
					folderIdTopIcons = folderTopIcons.getFolderId();
				}
				else {
					
					folderTopIcons = (DLFolder)request.getAttribute("view.jsp-folder");
				
					folderIdTopIcons = GetterUtil.getLong((String)request.getAttribute("view.jsp-folderId"));
				}
	
			%>			
	<!-- ---------------------------------------for top icons end----------------------------------------- -->
	<c:choose>
		<c:when test="<%= useAssetEntryQuery %>">
			<liferay-ui:categorization-filter
				assetType="documents"
				portletURL="<%= portletURL %>"
			/>
	
			<%@ include file="/html/portlet/document_library/view_file_entries.jspf" %>
	
		</c:when>
		<c:when test='<%= topLink.equals("home") %>'>
		
			<!----------------------------------------- for top icons start--------------------------------------->		
				<div class="top-icons" >
						<c:if test="<%= DLFolderPermission.contains(permissionChecker, scopeGroupId, folderIdTopIcons, ActionKeys.ADD_FOLDER) %>">
						<portlet:renderURL var="addFolderURL">
							<portlet:param name="struts_action" value="/document_library/edit_folder" />
							<portlet:param name="redirect" value="<%= currentURL %>" />
							<portlet:param name="parentFolderId" value="<%= String.valueOf(folderIdTopIcons) %>" />
						</portlet:renderURL>
						
						<a href="<%= addFolderURL %>" ><img src="/rm-theme/images/common/addfoldertop.png" title='<%= (folderTopIcons != null) ? "Add Subfolder" : "Add Folder" %>'></img></a>
						<%-- <liferay-ui:icon image="addfoldertop" message='<%= (folderTopIcons != null) ? "add-subfolder" : "add-folder" %>' url="<%= addFolderURL %>" /> --%>
					</c:if>
					
					<c:if test="<%= DLFolderPermission.contains(permissionChecker, scopeGroupId, folderIdTopIcons, ActionKeys.ADD_DOCUMENT) %>">
						<portlet:renderURL var="editFileEntryURL">
							<portlet:param name="struts_action" value="/document_library/edit_file_entry" />
							<portlet:param name="redirect" value="<%= currentURL %>" />
							<portlet:param name="folderId" value="<%= String.valueOf(folderIdTopIcons) %>" />
						</portlet:renderURL>
		
						<a href="<%= editFileEntryURL %>" ><img src="/rm-theme/images/common/adddoctop.png" title="Add Document"></img></a>
						<%-- <liferay-ui:icon image="adddoctop" message="add-document" url="<%= editFileEntryURL %>" /> --%>
					</c:if>
						
					
				</div>
		<!------------------------------------------for top icons end------------------------------------------------------->		
		
			<c:if test="<%= (folder != null) %>">
				<liferay-ui:header
					backURL="<%= redirect %>"
					localizeTitle="<%= false %>"
					title="<%= folder.getName() %>"
				/>
			</c:if>
	
			<aui:row>
				<div class="rm_doc_lib"  id="data_doc" data-rel="documents-home">
					<aui:col cssClass="lfr-asset-column lfr-asset-column-details" width="<%= showFolderMenu ? 100 : 100 %>">
						<liferay-ui:panel-container extended="<%= false %>" id='<%= renderResponse.getNamespace() + "documentLibraryDisplayInfoPanelContainer" %>' persistState="<%= true %>">
							<c:if test="<%= folder != null %>">
								<c:if test="<%= Validator.isNotNull(folder.getDescription()) %>">
									<div class="lfr-asset-description">
										<%= HtmlUtil.escape(folder.getDescription()) %>
									</div>
								</c:if>
		
								<div class="lfr-asset-metadata">
									<div class="lfr-asset-icon lfr-asset-date">
										<%= LanguageUtil.format(pageContext, "last-updated-x", dateFormatDateTime.format(folder.getModifiedDate())) %>
									</div>
		
									<div class="lfr-asset-icon lfr-asset-subfolders">
										<%= foldersCount %> <liferay-ui:message key='<%= (foldersCount == 1) ? "subfolder" : "subfolders" %>' />
									</div>
		
									<div class="lfr-asset-icon lfr-asset-items last">
										<%= fileEntriesCount %> <liferay-ui:message key='<%= (fileEntriesCount == 1) ? "document" : "documents" %>' />
									</div>
								</div>
		
								<liferay-ui:custom-attributes-available className="<%= DLFolderConstants.getClassName() %>">
									<liferay-ui:custom-attribute-list
										className="<%= DLFolderConstants.getClassName() %>"
										classPK="<%= (folder != null) ? folder.getFolderId() : 0 %>"
										editable="<%= false %>"
										label="<%= true %>"
									/>
								</liferay-ui:custom-attributes-available>
							</c:if>
		
							<c:if test="<%= foldersCount > 0 %>">
								<liferay-ui:panel collapsible="<%= true %>" cssClass="view-folders" extended="<%= true %>" id='<%= renderResponse.getNamespace() + "documentLibraryDisplayFoldersListingPanel" %>' persistState="<%= true %>" title='<%= (folder != null) ? "subfolders" : "folders" %>'>
									<liferay-ui:search-container
										curParam="cur1"
										delta="<%= foldersPerPage %>"
										deltaConfigurable="<%= false %>"
										headerNames="<%= StringUtil.merge(folderColumns) %>"
										iteratorURL="<%= portletURL %>"
										total="<%= foldersCount %>"
									>
										<liferay-ui:search-container-results
											results="<%= DLAppServiceUtil.getFolders(repositoryId, folderId, searchContainer.getStart(), searchContainer.getEnd()) %>"
										/>
		
										<liferay-ui:search-container-row
											className="com.liferay.portal.kernel.repository.model.Folder"
											keyProperty="folderId"
											modelVar="curFolder"
											rowVar="row"
										>
											<liferay-portlet:renderURL varImpl="rowURL">
												<portlet:param name="struts_action" value="/document_library_display/view" />
												<portlet:param name="redirect" value="<%= currentURL %>" />
												<portlet:param name="folderId" value="<%= String.valueOf(curFolder.getFolderId()) %>" />
											</liferay-portlet:renderURL>
	<!----------------------------------------------- remove subfolder in DL home page ---------------------------------------------------------------->
											<%@ include file="/html/portlet/document_library/folder_columns.rm-hook.jspf" %>
	<!----------------------------------------------- remove subfolder in DL home page ---------------------------------------------------------------->
										</liferay-ui:search-container-row>
		
										<liferay-ui:search-iterator />
									</liferay-ui:search-container>
								</liferay-ui:panel>
							</c:if>
		
							<liferay-ui:panel collapsible="<%= true %>" extended="<%= true %>" id='<%= renderResponse.getNamespace() + "documentLibraryDisplayDocumentsListingPanel" %>' persistState="<%= true %>" title="documents">
								<!------------------------------- calling view_file_entries.rm-hook.jspf ------------------------------------------->
								<%@ include file="/html/portlet/document_library/view_file_entries.rm-hook.jspf" %>
								<!------------------------------- calling view_file_entries.rm-hook.jspf -----------------------------------------  -->
							</liferay-ui:panel>
						</liferay-ui:panel-container>
					</aui:col>
				</div>
	
				<c:if test="<%= showFolderMenu %>">
					<aui:col cssClass="lfr-asset-column lfr-asset-column-actions" last="<%= true %>" width="<%= 25 %>">
						<div class="lfr-asset-summary">
							<liferay-ui:icon
								cssClass="lfr-asset-avatar"
								image='<%= "../file_system/large/" + (((foldersCount + fileEntriesCount) > 0) ? "folder_full_document" : "folder_empty_document") %>'
								message=""
							/>
	
							<div class="lfr-asset-name">
								<h4><%= (folder != null) ? HtmlUtil.escape(folder.getName()) : LanguageUtil.get(pageContext, "home") %></h4>
							</div>
						</div>
	
						<%
						request.removeAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
						%>
	
						<liferay-util:include page="/html/portlet/document_library/folder_action.jsp" />
					</aui:col>
				</c:if>
			</aui:row>
	
			<%
			if (folder != null) {
				DLUtil.addPortletBreadcrumbEntries(folder, request, renderResponse);
	
				if (!defaultFolderView) {
					PortalUtil.setPageSubtitle(folder.getName(), request);
					PortalUtil.setPageDescription(folder.getDescription(), request);
				}
			}
			%>
	
		</c:when>
		<c:when test='<%= topLink.equals("mine") || topLink.equals("recent") %>'>
			<aui:row>
				<liferay-ui:header
					backURL="<%= redirect %>"
					title="<%= topLink %>"
				/>
	
				<%
				long groupFileEntriesUserId = 0;
	
				if (topLink.equals("mine") && themeDisplay.isSignedIn()) {
					groupFileEntriesUserId = user.getUserId();
	
					status = WorkflowConstants.STATUS_ANY;
					
					%>
						<div class="rm_doc_lib" id="data_doc" data-rel="my-documents" >
					<%
				}
				else
				{
				%>
						<div class="rm_doc_lib"  id="data_doc"  data-rel="recent-documents">
						
				<%
				}
				%>
	
				<liferay-ui:search-container
					delta="<%= fileEntriesPerPage %>"
					deltaConfigurable="<%= false %>"
					emptyResultsMessage="there-are-no-documents"
					iteratorURL="<%= portletURL %>"
					total="<%= DLAppServiceUtil.getGroupFileEntriesCount(repositoryId, groupFileEntriesUserId, defaultFolderId, null, status) %>"
				>
	
					<liferay-ui:search-container-results
						results="<%= DLAppServiceUtil.getGroupFileEntries(repositoryId, groupFileEntriesUserId, defaultFolderId, null, status, searchContainer.getStart(), searchContainer.getEnd(), null) %>"
					/>
	
					<liferay-ui:search-container-row
						className="com.liferay.portal.kernel.repository.model.FileEntry"
						escapedModel="<%= true %>"
						keyProperty="fileEntryId"
						modelVar="fileEntry"
					>
	
						<%
						DLFileShortcut fileShortcut = null;
	
						String rowHREF = null;
	
						if (DLFileEntryPermission.contains(permissionChecker, fileEntry, ActionKeys.VIEW)) {
							PortletURL viewFileEntryURL = renderResponse.createRenderURL();
	
							viewFileEntryURL.setParameter("struts_action", "/document_library_display/view_file_entry");
							viewFileEntryURL.setParameter("redirect", currentURL);
							viewFileEntryURL.setParameter("fileEntryId", String.valueOf(fileEntry.getFileEntryId()));
	
							rowHREF = viewFileEntryURL.toString();
						}
						%>
	
						<%@ include file="/html/portlet/document_library/file_entry_columns.jspf" %>
					</liferay-ui:search-container-row>
	
					<liferay-ui:search-iterator />
					</div>
				</liferay-ui:search-container>
			</aui:row>
	
			<%
			PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(pageContext, topLink), currentURL);
	
			PortalUtil.setPageSubtitle(LanguageUtil.get(pageContext, topLink), request);
			%>
	
		</c:when>
	</c:choose>
</div>

<%!
private static Log _log = LogFactoryUtil.getLog("portal-web.docroot.html.portlet.document_library.view_jsp");
%>