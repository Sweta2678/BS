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

<%
String redirectURL = (String)request.getAttribute("redirectURL");
String imgURL = (String)request.getAttribute("imgURL");
%>
<h3>Your image is now ready to use, copy the URL from below: </h3>
<h5>https://me2.ihgmerlin.com<%=imgURL %></h5>
<a class="btn btn-default" href="<%=redirectURL %>>">Go back</a>