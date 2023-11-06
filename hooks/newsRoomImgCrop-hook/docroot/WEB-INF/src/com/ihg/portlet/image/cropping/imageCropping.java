package com.ihg.portlet.image.cropping;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.model.DLFolderConstants;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.imageio.ImageIO;

import javax.portlet.PortletConfig;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.image.ImageToolUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.struts.BaseStrutsPortletAction;
import com.liferay.portal.kernel.struts.StrutsPortletAction;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;

public class imageCropping extends BaseStrutsPortletAction {

		private String redirectURL = "";
		private String imgURL = "";
		@Override
		public void processAction(
				StrutsPortletAction originalStrutsPortletAction,
				PortletConfig portletConfig, ActionRequest actionRequest,
				ActionResponse actionResponse)
			throws Exception {
			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);

			String fileInputName = ParamUtil.getString(uploadRequest, "sourceFileName");
			String filetoCrop = ParamUtil.getString(uploadRequest, "filelink");// uploadRequest.getFileName("filetoCrop");//uploaded filename
			String xVal = ParamUtil.getString(uploadRequest, "dataX");
			String yVal = ParamUtil.getString(uploadRequest, "dataY");
			String widthVal = ParamUtil.getString(uploadRequest, "dataWidth");
			String heightValue = ParamUtil.getString(uploadRequest, "dataHeight");
			long fileEntryId = ParamUtil.getLong(uploadRequest, "fileEntryId");
		
			String height= actionRequest.getParameter("heightValue");
			
			long repositoryId = ParamUtil.getLong(uploadRequest, "repositoryId");
			long folderId = ParamUtil.getLong(uploadRequest, "folderId");
			
			String sourceFileNameExt = ParamUtil.getString(uploadRequest, "sourceFileNameExt");
			String sourceFileName = ParamUtil.getString(uploadRequest, "sourceFileName");
			
			String contentType = ParamUtil.getString(uploadRequest, "contentType");
			String title = ParamUtil.getString(uploadRequest, "title");
			String description = ParamUtil.getString(uploadRequest, "description");
			String changeLog = ParamUtil.getString(uploadRequest, "changeLog");
			redirectURL = ParamUtil.getString(uploadRequest, "redirect");
	
			Long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
		
			ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			
			com.liferay.portlet.documentlibrary.model.DLFileEntry dlFileEntryEx = com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil
					.getFileEntry(themeDisplay.getScopeGroupId(), folderId, sourceFileNameExt);
			
			java.io.File file = (java.io.File) com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil
			.getFile(dlFileEntryEx.getUserId(), dlFileEntryEx.getFileEntryId(), dlFileEntryEx.getVersion(), false);
		
			BufferedImage uploadFile = ImageIO.read(file);
	
			int startX, startY, endX, endY;
					
			startX = Integer.parseInt(xVal);
			startY = Integer.parseInt(yVal);
			endX = Integer.parseInt(widthVal);
			endY = Integer.parseInt(heightValue);
			
			BufferedImage img = uploadFile.getSubimage(startX, startY, endX, endY); //fill in the corners of the desired crop location here
	
			int widthForNewsroom = 585;
			img = (BufferedImage) ImageToolUtil.scale(img, widthForNewsroom);
			
			File outputfile = new File(fileInputName+"_crop.jpg");
			ImageIO.write(img, "jpg", outputfile);
			
			long fileSize = outputfile.length();
			InputStream is = new FileInputStream(outputfile);
			
			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					DLFileEntry.class.getName(), actionRequest);
			long size = fileSize;

			User currentUser = PortalUtil.getUser(actionRequest);
			long userId = currentUser.getUserId(); 
			String mimeType = contentType;
			sourceFileName = fileInputName+"_crop.jpg";
			imgURL = "/documents/"+ repositoryId+"/"+ folderId+"/"+sourceFileName;
			
			FileEntry fileEntry = DLAppLocalServiceUtil.addFileEntry(userId, repositoryId, folderId, sourceFileName, mimeType, title, description, changeLog, is, size, serviceContext);

			FileEntry deleteFile = DLAppLocalServiceUtil.getFileEntry(repositoryId, folderId, sourceFileNameExt);
			long entryID = deleteFile.getFileEntryId();
			DLAppLocalServiceUtil.deleteFileEntry(entryID);
			
			super.processAction(
		            originalStrutsPortletAction, portletConfig, actionRequest,
		            actionResponse);
		}
				
		@Override
		public String render(
				StrutsPortletAction originalStrutsPortletAction,
				PortletConfig portletConfig, RenderRequest renderRequest,
				RenderResponse renderResponse)
			throws Exception {
			
			renderRequest.setAttribute("redirectURL",redirectURL);
			renderRequest.setAttribute("imgURL", imgURL);
			String redirectURL = "/portlet/document_library/newsroomImage.newsRoomImgCrop-hook.jsp";
			return redirectURL;
			 
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

}
