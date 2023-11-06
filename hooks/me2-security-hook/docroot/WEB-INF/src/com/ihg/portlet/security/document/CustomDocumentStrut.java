package com.ihg.portlet.security.document;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Arrays;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.struts.BaseStrutsPortletAction;
import com.liferay.portal.kernel.struts.StrutsPortletAction;
import com.liferay.portal.kernel.upload.UploadException;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StreamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.PortletPreferences;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portlet.assetpublisher.util.AssetPublisherUtil;
import com.liferay.portlet.bookmarks.NoSuchFolderException;
import com.liferay.portlet.documentlibrary.FileMimeTypeException;
import com.liferay.portlet.documentlibrary.FileSizeException;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.util.DLUtil;



public class CustomDocumentStrut extends BaseStrutsPortletAction {
	
	private final static Log LOG_4 = LogFactoryUtil.getLog(CustomDocumentStrut.class);
	
	@Override
	public void processAction(
			StrutsPortletAction originalStrutsPortletAction,
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse)
		throws Exception {
		
		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);
		FileEntry fileEntry = null;
		//Starts Here
		if (cmd.equals(Constants.ADD) ||
				 cmd.equals(Constants.ADD_DYNAMIC) ||
				 cmd.equals(Constants.UPDATE) ||
				 cmd.equals(Constants.UPDATE_AND_CHECKIN)) {

		
		fileEntry = updateFileEntry(
				portletConfig, actionRequest, actionResponse);
		actionResponse.sendRedirect(ParamUtil.getString(actionRequest, "redirect"));
		}else{
				
		originalStrutsPortletAction.processAction(
	            originalStrutsPortletAction, portletConfig, actionRequest,
	            actionResponse);
		}
		super.processAction(
	            originalStrutsPortletAction, portletConfig, actionRequest,
	            actionResponse);
		
		
		//Ends Here
	}
			
	@Override
	public String render(
			StrutsPortletAction originalStrutsPortletAction,
			PortletConfig portletConfig, RenderRequest renderRequest,
			RenderResponse renderResponse)
		throws Exception {
		
		return originalStrutsPortletAction.render(
	            null, portletConfig, renderRequest, renderResponse); 
	}
	
	public void serveResource(
            StrutsPortletAction originalStrutsPortletAction,
            PortletConfig portletConfig, ResourceRequest resourceRequest,
            ResourceResponse resourceResponse)
        throws Exception {

        originalStrutsPortletAction.serveResource(
            originalStrutsPortletAction, portletConfig, resourceRequest,
            resourceResponse);

    }
	
	protected void addTempFileEntry(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {
	
	}
	
	protected FileEntry updateFileEntry(
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse)
		throws Exception {

		UploadPortletRequest uploadPortletRequest =
			PortalUtil.getUploadPortletRequest(actionRequest);

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		String cmd = ParamUtil.getString(uploadPortletRequest, Constants.CMD);

		long fileEntryId = ParamUtil.getLong(
			uploadPortletRequest, "fileEntryId");

		long repositoryId = ParamUtil.getLong(
			uploadPortletRequest, "repositoryId");
		long folderId = ParamUtil.getLong(uploadPortletRequest, "folderId");
		String sourceFileName = uploadPortletRequest.getFileName("file");
		String title = ParamUtil.getString(uploadPortletRequest, "title");
		String description = ParamUtil.getString(
			uploadPortletRequest, "description");
		String changeLog = ParamUtil.getString(
			uploadPortletRequest, "changeLog");
		boolean majorVersion = ParamUtil.getBoolean(
			uploadPortletRequest, "majorVersion");

		if (folderId > 0) {
			Folder folder = DLAppServiceUtil.getFolder(folderId);

			if (folder.getGroupId() != themeDisplay.getScopeGroupId()) {
				throw new NoSuchFolderException("{folderId=" + folderId + "}");
			}
		}

		InputStream inputStream = null;

		try {
			String contentType = uploadPortletRequest.getContentType("file");

			long size = uploadPortletRequest.getSize("file");

			if ((cmd.equals(Constants.ADD) ||
				 cmd.equals(Constants.ADD_DYNAMIC)) &&
				(size == 0)) {

				contentType = MimeTypesUtil.getContentType(title);
			}

			if (cmd.equals(Constants.ADD) ||
				cmd.equals(Constants.ADD_DYNAMIC) || (size > 0)) {

				String portletName = portletConfig.getPortletName();

				if (portletName.equals(PortletKeys.MEDIA_GALLERY_DISPLAY)) {
					PortletPreferences portletPreferences =
						getStrictPortletSetup(actionRequest);

					if (portletPreferences == null) {
						portletPreferences = (PortletPreferences) actionRequest.getPreferences();
					}

					String[] mimeTypes = DLUtil.getMediaGalleryMimeTypes(
						(javax.portlet.PortletPreferences) portletPreferences, actionRequest);

					if (Arrays.binarySearch(mimeTypes, contentType) < 0) {
						throw new FileMimeTypeException(contentType);
					}
				}
			}

			//File file = uploadPortletRequest.getFile("file");
			
			inputStream = uploadPortletRequest.getFileAsStream("file");
			
			/**Image Compression code START------------ **/
					File compressedImageFile = null;
					try
					{
						//long groupId =RepositoryLocalServiceUtil.getRepository(repositoryId).getGroupId();
						long groupId = themeDisplay.getScopeGroupId();
						
						if(Validator.isNotNull(groupId) && groupId!=0)
						{
							Group group = GroupLocalServiceUtil.getGroup(groupId);
							
							long st = System.currentTimeMillis();
							
							if(ImageCompressionUtil.isOrgOrMerlinCommunity(group) && ImageCompressionUtil.isVideoOrImage(contentType))
							{
								if(LOG_4.isDebugEnabled())
								{
									LOG_4.debug("It's a Merlin site or Organization hence start compressing Image for groupId:-"+ groupId);
								}
								
								compressedImageFile = ImageCompressionUtil.compressImageOrVideo(contentType, inputStream) ;
								
								long et = System.currentTimeMillis();
								
								if(LOG_4.isDebugEnabled())
								{
									LOG_4.debug("Time to process video/file is:-- "+ (et-st) +" in ms from groupId:-"+ groupId);
								}
							}
						}else
						{
							if(LOG_4.isDebugEnabled())
							{
									LOG_4.debug("GroupId is not valid ---"+ groupId +"  Hence not compressing Image");
							}
						}
						
					}catch(Exception e)
					{
						LOG_4.error("Problem in  compressing Image or Video for Merlin sites ....."+ e.getMessage());
					}
					
					if(Validator.isNotNull(compressedImageFile))
					{
						//file= compressedImageFile;
						
						// Converting file back to InputStream
						try 
						{
							inputStream = new FileInputStream(compressedImageFile);
							size=compressedImageFile.length();
						} catch (FileNotFoundException e) 
						{
							e.printStackTrace();
						}
					}
										
			/**Image Compression code END------------ **/
			
			
			//inputStream = uploadPortletRequest.getFileAsStream("file");
					
			//inputStream = new FileInputStream(file);

			ServiceContext serviceContext = ServiceContextFactory.getInstance(
				DLFileEntry.class.getName(), uploadPortletRequest);

			FileEntry fileEntry = null;

			if (cmd.equals(Constants.ADD) ||
				cmd.equals(Constants.ADD_DYNAMIC)) {

				// Add file entry
				
				//size = file.length();
								
				
				fileEntry = DLAppServiceUtil.addFileEntry(
					repositoryId, folderId, sourceFileName, contentType, title,
					description, changeLog, inputStream, size, serviceContext);

				AssetPublisherUtil.addAndStoreSelection(
					actionRequest, DLFileEntry.class.getName(),
					fileEntry.getFileEntryId(), -1);
				
			}
			else if (cmd.equals(Constants.UPDATE_AND_CHECKIN)) {

				// Update file entry and checkin

				fileEntry = DLAppServiceUtil.updateFileEntryAndCheckIn(
					fileEntryId, sourceFileName, contentType, title,
					description, changeLog, majorVersion, inputStream, size,
					serviceContext);
			}
			else {

				// Update file entry

				fileEntry = DLAppServiceUtil.updateFileEntry(
					fileEntryId, sourceFileName, contentType, title,
					description, changeLog, majorVersion, inputStream, size,
					serviceContext);
			}

			AssetPublisherUtil.addRecentFolderId(
				actionRequest, DLFileEntry.class.getName(), folderId);

			return fileEntry;
		}
		catch (Exception e) {
			UploadException uploadException =
				(UploadException)actionRequest.getAttribute(
					WebKeys.UPLOAD_EXCEPTION);

			if ((uploadException != null) &&
				uploadException.isExceededSizeLimit()) {

				throw new FileSizeException(uploadException.getCause());
			}

			throw e;
		}
		finally {
			StreamUtil.cleanUp(inputStream);
		}
	}

	private PortletPreferences getStrictPortletSetup(ActionRequest actionRequest) {
	// TODO Auto-generated method stub
	return null;
}
}
