package com.ihg.brandstandards.portlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.ihg.brandstandards.db.model.Image;
import com.ihg.brandstandards.db.service.ImageLocalServiceUtil;
import com.ihg.brandstandards.util.BrandStandardsUtil;
import com.ihg.brandstandards.util.ImageAdminUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.NoSuchFolderException;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.liferay.portlet.dynamicdatamapping.storage.Fields;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class ImageAdminPortlet extends MVCPortlet
{
    private static final Log LOG = LogFactoryUtil.getLog(ImageAdminPortlet.class);

    public void doView(final RenderRequest request, final RenderResponse renderResponse) throws IOException, PortletException
    {
        String command = request.getParameter(ImageAdminUtil.CMD);
        if (command == null)
        {
            command = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request)).getParameter(ImageAdminUtil.CMD);
        }

        String pageName = viewTemplate;
        if (!ImageAdminUtil.IsNullOrBlank(command) && (command.equals(ImageAdminUtil.CMD_ADD_FOLDER) || command.equals(ImageAdminUtil.CMD_EDIT_FOLDER)))
        {
            request.setAttribute(ImageAdminUtil.CURR_FOLDER, request.getParameter(ImageAdminUtil.CURR_FOLDER));
            request.setAttribute(ImageAdminUtil.FOLDER_ID, request.getParameter(ImageAdminUtil.FOLDER_ID));
            request.setAttribute(ImageAdminUtil.CMD, request.getParameter(ImageAdminUtil.CMD));
            if (command.equals(ImageAdminUtil.CMD_EDIT_FOLDER))
            {
                String folderId = request.getParameter(ImageAdminUtil.FOLDER_ID);
                DLFolder igFolder;
                try
                {
                    igFolder = DLFolderLocalServiceUtil.getFolder(Long.valueOf(folderId));
                    request.setAttribute("name", igFolder.getName());
                    request.setAttribute("description", igFolder.getDescription());
                }
                catch (Exception e)
                {
                    LOG.error(e);
                }
            }
            pageName = "/html/imageadmin/folder.jsp";
        }
        else if (!ImageAdminUtil.IsNullOrBlank(command) && (command.equals(ImageAdminUtil.CMD_ADD_IMAGE) || command.equals(ImageAdminUtil.CMD_EDIT_IMAGE)))
        {
            request.setAttribute(ImageAdminUtil.CURR_FOLDER, request.getParameter(ImageAdminUtil.CURR_FOLDER));
            request.setAttribute(ImageAdminUtil.FOLDER_ID, request.getParameter(ImageAdminUtil.FOLDER_ID));
            request.setAttribute(ImageAdminUtil.CMD, request.getParameter(ImageAdminUtil.CMD));
            request.setAttribute(ImageAdminUtil.IMAGE_ID, request.getParameter(ImageAdminUtil.IMAGE_ID));
            if (command.equals(ImageAdminUtil.CMD_EDIT_IMAGE))
            {
                String folderId = request.getParameter(ImageAdminUtil.FOLDER_ID);
                DLFolder igFolder;
                DLFileEntry igImage;
                String imageId = request.getParameter(ImageAdminUtil.IMAGE_ID);
                try
                {
                    igFolder = DLFolderLocalServiceUtil.getFolder(Long.valueOf(folderId));
                    igImage = DLFileEntryLocalServiceUtil.getFileEntry(Long.parseLong(imageId));
                    if(LOG.isDebugEnabled()){
                    	LOG.debug("Edit Image Details========>"+igImage.getName()+"----"+igImage.getTitle()+"-------"+igImage.getDescription());
                    }
                    request.setAttribute("igImage", igImage);
                    request.setAttribute("folderName", igFolder.getName());
                    request.setAttribute("folderDesc", igFolder.getDescription());

                }
                catch (Exception e)
                {
                    LOG.error(e);
                }
                pageName = "/html/imageadmin/editImage.jsp";
            }
            else
            {
                pageName = "/html/imageadmin/addImage.jsp";
            }
        }
        else if (ImageAdminUtil.CMD_GUEST_SEARCH_IMAGE.equals(command))
        {
            getFoldersImages(request);
            request.setAttribute(ImageAdminUtil.CMD, command);
            pageName = "/html/imageadmin/viewSearch.jsp";
        }
        else if (ImageAdminUtil.CMD_SEARCH_IMAGE.equals(command))
        {
            getFoldersImages(request);
            pageName = "/html/imageadmin/searchImage.jsp";
        }
        else if (ImageAdminUtil.CMD_SEARCH_TRANS_IMAGE.equals(command))
        {
            getFoldersImages(request);
            request.setAttribute("isTranslated", true);
            request.setAttribute(ImageAdminUtil.CMD, command);
            pageName = "/html/imageadmin/viewSearch.jsp";
        }
        else
        {
            getFoldersImages(request);
        }
        final PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher(pageName);
        dispatcher.include(request, renderResponse);
    }

    /**
     * Get folder and images from Image Gallery.
     * 
     * @param request RenderRequest
     */
    private void getFoldersImages(final RenderRequest request)
    {
        long folderId = 0;
        long parentFolderId = 0;
        List<DLFolder> arlFolders = null;
        List<DLFileEntry> arlImages = null;
        String rootFolderId = null;
        String folderName = "";
        String parentFolderName = "";
        try
        {
            ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
            rootFolderId = (String) request.getPreferences().getValue(BrandStandardsUtil.BS_IMG_GALLERY_FOLDER, "");
            if (!ImageAdminUtil.IsNullOrBlank(request.getParameter(ImageAdminUtil.CURR_FOLDER)))
            {
                folderId = Long.parseLong(request.getParameter(ImageAdminUtil.CURR_FOLDER));
                DLFolder igFolder = DLFolderLocalServiceUtil.getFolder(folderId);
                folderName = igFolder.getName();
                if (folderId != Long.parseLong(rootFolderId))
                {
                    parentFolderId = igFolder.getParentFolderId();
                    parentFolderName = DLFolderLocalServiceUtil.getFolder(parentFolderId).getName();
                }
            }
            else
            {
                folderId = Long.valueOf(rootFolderId);
                parentFolderId = folderId;
                folderName = DLFolderLocalServiceUtil.getFolder(parentFolderId).getName();
                parentFolderName = folderName;
            }
            LOG.info("Search for folders and images for folderId = " + folderId + " group id = " + themeDisplay.getLayout().getGroupId());
            arlFolders = DLFolderLocalServiceUtil.getFolders(themeDisplay.getLayout().getGroupId(), folderId);
            arlImages = ImageAdminUtil.getImages(themeDisplay.getLayout().getGroupId(), folderId);
            if (parentFolderId == 0)
            {
                parentFolderId = Long.parseLong((String) request.getParameter(ImageAdminUtil.CURR_FOLDER));
            }
        }
        catch(NoSuchFolderException fe)
        {
        	LOG.error(fe.getMessage());
        }
        catch (Exception e)
        {
            LOG.error(e);
        }
        LOG.info("getFoldersImages: Found " + (arlImages != null ? arlImages.size() : 0) + " images and " + 
                                              (arlFolders != null ? arlFolders.size() : 0) + " folders");
        
        request.setAttribute("arlFolders", arlFolders != null ? arlFolders : new ArrayList<DLFolder>());
        request.setAttribute("arlImages", arlImages != null ? arlImages : new ArrayList<DLFileEntry>());
        request.setAttribute(ImageAdminUtil.CURR_FOLDER, folderId + "");
        request.setAttribute(ImageAdminUtil.PARENT_FOLDER_ID, parentFolderId + "");
        request.setAttribute(ImageAdminUtil.FOLDER_NAME, folderName);
        request.setAttribute(ImageAdminUtil.PRNT_FOLDER_NAME, parentFolderName);
    }

    @ProcessAction(name = "addSubFolder")
    public void addSubFolder(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException
    {
        actionResponse.setRenderParameter(ImageAdminUtil.CURR_FOLDER, actionRequest.getParameter(ImageAdminUtil.CURR_FOLDER));
        actionResponse.setRenderParameter(ImageAdminUtil.FOLDER_ID, actionRequest.getParameter(ImageAdminUtil.FOLDER_ID));
        actionResponse.setRenderParameter(ImageAdminUtil.CMD, ImageAdminUtil.CMD_ADD_FOLDER);
    }

    @ProcessAction(name = "editFolder")
    public void editFolder(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException
    {
        actionResponse.setRenderParameter(ImageAdminUtil.CURR_FOLDER, actionRequest.getParameter(ImageAdminUtil.CURR_FOLDER));
        actionResponse.setRenderParameter(ImageAdminUtil.FOLDER_ID, actionRequest.getParameter(ImageAdminUtil.FOLDER_ID));
        actionResponse.setRenderParameter(ImageAdminUtil.CMD, ImageAdminUtil.CMD_EDIT_FOLDER);
    }

    @ProcessAction(name = "saveFolder")
    public void saveFolder(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException, PortalException, SystemException
    {
    	ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        String command = actionRequest.getParameter(ImageAdminUtil.CMD);
        actionResponse.setRenderParameter(ImageAdminUtil.CURR_FOLDER, actionRequest.getParameter(ImageAdminUtil.CURR_FOLDER));
        String name = actionRequest.getParameter("name");
        String description = actionRequest.getParameter("description");
        String folderId = actionRequest.getParameter(ImageAdminUtil.FOLDER_ID);
        if(folderId == null){
        	folderId = "0";
        }
        if (command.equals(ImageAdminUtil.CMD_EDIT_FOLDER))
        {
            ImageAdminUtil.updateFolder(Long.valueOf(folderId), name, description,ServiceContextFactory.getInstance(DLFolder.class.getName(),actionRequest));
        }
        else if (command.equals(ImageAdminUtil.CMD_ADD_FOLDER))
        {
            try
            {
                User user = PortalUtil.getUser(actionRequest);
                final ServiceContext serviceContext = ServiceContextFactory.getInstance(actionRequest);
                ImageAdminUtil.addSubFolder(user, themeDisplay.getScopeGroupId(), Long.valueOf(folderId), name, description, serviceContext);
            }
            catch (Exception exc)
            {
                LOG.error(exc);
            }
        }
    }

    @ProcessAction(name = "savePrefs")
    public void savePrefs(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException
    {
        PortletPreferences portletPreferences = actionRequest.getPreferences();
        if (actionRequest.getParameter(BrandStandardsUtil.BS_IMG_GALLERY_FOLDER) != null)
        {
            portletPreferences.setValue(BrandStandardsUtil.BS_IMG_GALLERY_FOLDER, actionRequest.getParameter(BrandStandardsUtil.BS_IMG_GALLERY_FOLDER));
        }
        portletPreferences.store();
    }

    @ProcessAction(name = "cancel")
    public void cancel(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException
    {
        actionResponse.setPortletMode(PortletMode.VIEW);
    }

    @ProcessAction(name = "deleteFolder")
    public void deleteFolder(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException
    {
        actionResponse.setRenderParameter(ImageAdminUtil.CURR_FOLDER, actionRequest.getParameter(ImageAdminUtil.CURR_FOLDER));
        ImageAdminUtil.deleteFolder(actionRequest.getParameter(ImageAdminUtil.FOLDER_ID));
    }

    @ProcessAction(name = "addImage")
    public void addImage(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException
    {
        actionResponse.setRenderParameter(ImageAdminUtil.CURR_FOLDER, actionRequest.getParameter(ImageAdminUtil.CURR_FOLDER));
        actionResponse.setRenderParameter(ImageAdminUtil.FOLDER_ID, actionRequest.getParameter(ImageAdminUtil.FOLDER_ID));
        actionResponse.setRenderParameter(ImageAdminUtil.CMD, ImageAdminUtil.CMD_ADD_IMAGE);
    }

    @ProcessAction(name = "editImage")
    public void editImage(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException
    {
        actionResponse.setRenderParameter(ImageAdminUtil.CURR_FOLDER, actionRequest.getParameter(ImageAdminUtil.CURR_FOLDER));
        actionResponse.setRenderParameter(ImageAdminUtil.FOLDER_ID, actionRequest.getParameter(ImageAdminUtil.FOLDER_ID));
        actionResponse.setRenderParameter(ImageAdminUtil.CMD, ImageAdminUtil.CMD_EDIT_IMAGE);
        actionResponse.setRenderParameter(ImageAdminUtil.IMAGE_ID, actionRequest.getParameter(ImageAdminUtil.IMAGE_ID));
    }

    @ProcessAction(name = "updateImage")
    public void updateImage(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException
    {
        UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        long userId = themeDisplay.getUserId();
        long imageId = ParamUtil.getLong(uploadRequest, "imageId");
        long groupId = themeDisplay.getScopeGroupId();
        long folderId = ParamUtil.getLong(uploadRequest, "folderId");
        String title = ParamUtil.getString(uploadRequest, "title");
        String sourceFileName = uploadRequest.getFileName("file");
        String description = ParamUtil.getString(uploadRequest, "description", sourceFileName);
        File file = uploadRequest.getFile("file");
        try
        {
            long fileEntryTypeId = -1L;
            Map<String, Fields> fieldsMap = null;
            ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), actionRequest);
            String mimeType = MimeTypesUtil.getContentType(sourceFileName);
            String contentType = uploadRequest.getContentType("file");
            String ext = GetterUtil.getString(FileUtil.getExtension(file.getName())).toLowerCase();
            
            LOG.debug("Add/Update Image: File Name = " + sourceFileName + " title = " + title + " mimeType = " + mimeType + " ext = '" + ext + "' ");

            if (imageId <= 0)
            {
                // Add image
                if (Validator.isNull(title))
                {
                    title = sourceFileName;
                }
                serviceContext.setAddGroupPermissions(true);
                serviceContext.setAddGuestPermissions(false);
                /*DLFileEntry igImage = DLFileEntryLocalServiceUtil.addFileEntry(userId, groupId, groupId, folderId, sourceFileName, mimeType, title, 
                        description, "", fileEntryTypeId, fieldsMap, file, null , file.length(), serviceContext);*/
                FileEntry fileEntry = DLAppLocalServiceUtil.addFileEntry(userId, groupId, folderId, sourceFileName, mimeType, title, description, "", file, serviceContext);
                DLFileEntry igImage = DLFileEntryLocalServiceUtil.getFileEntry(fileEntry.getFileEntryId());
                
                igImage.setExtension(igImage.getExtension());
                ImageLocalServiceUtil.addImage(igImage, userId);
                
//                AddDefaultDocumentLibraryStructuresAction
//                addDLFileEntryType(
//                        userId, groupId, DLFileEntryTypeConstants.NAME_IG_IMAGE,
//                        ddmStructureNames, serviceContext);
            }
            else
            {
                // Update image
                if (Validator.isNull(sourceFileName))
                {
                    file = null;
                }
                serviceContext.setAddGroupPermissions(true);
                serviceContext.setAddGuestPermissions(false);
                long size = uploadRequest.getSize("file");
                InputStream inputStream = uploadRequest.getFileAsStream("file");
                boolean majorVersion = ParamUtil.getBoolean(uploadRequest, "majorVersion");
                
                /*DLFileEntry igImage = DLFileEntryLocalServiceUtil.updateFileEntry(userId, imageId, sourceFileName, mimeType, title, 
                        description, "", false, fileEntryTypeId, fieldsMap, file, null, (file != null ? file.length() : 0), serviceContext);*/
                
                FileEntry fileEntry = DLAppLocalServiceUtil.updateFileEntry(userId, imageId, sourceFileName, mimeType, title, description, "", majorVersion, inputStream, size, serviceContext);
                
                DLFileEntry igImage = DLFileEntryLocalServiceUtil.getFileEntry(fileEntry.getFileEntryId());
                
                igImage.setExtension(ext);
                ImageLocalServiceUtil.updateImage(igImage, userId, imageId);
            }
        }
        catch (Exception e)
        {
            LOG.error(e);
        }
        actionResponse.setRenderParameter(ImageAdminUtil.CURR_FOLDER, String.valueOf(folderId));
        actionResponse.setRenderParameter(ImageAdminUtil.FOLDER_ID, String.valueOf(folderId));
    }

    protected String getContentType(UploadPortletRequest uploadRequest, File file)
    {
        String contentType = GetterUtil.getString(uploadRequest.getContentType("file"));

        if (contentType.equals(ContentTypes.APPLICATION_OCTET_STREAM))
        {
            String ext = GetterUtil.getString(FileUtil.getExtension(file.getName())).toLowerCase();

            if (Validator.isNotNull(ext))
            {
                contentType = MimeTypesUtil.getContentType(ext);
            }
        }

        return contentType;
    }

    @ProcessAction(name = "deleteImage")
    public void deleteImage(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception
    {
        actionResponse.setRenderParameter(ImageAdminUtil.CURR_FOLDER, actionRequest.getParameter(ImageAdminUtil.CURR_FOLDER));
        actionResponse.setRenderParameter(ImageAdminUtil.FOLDER_ID, actionRequest.getParameter(ImageAdminUtil.FOLDER_ID));
        actionResponse.setRenderParameter(ImageAdminUtil.CMD, ImageAdminUtil.CMD_DELETE_IMAGE);
        long imageId = ParamUtil.getLong(actionRequest, ImageAdminUtil.IMAGE_ID);
        List<String> arlStdImages = ImageAdminUtil.getStandardsImagesCount(imageId);
        if (arlStdImages != null && arlStdImages.size() == 0)
        {
            //DLFileEntryLocalServiceUtil.deleteDLFileEntry(imageId);
            DLAppServiceUtil.deleteFileEntry(imageId);
            ImageLocalServiceUtil.deleteImage(imageId);
        }
    }

    @ProcessAction(name = "searchImage")
    public void searchImage(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, SystemException, PortalException
    {
        doSearchImage(actionRequest);
        actionResponse.setRenderParameter(ImageAdminUtil.CMD, ImageAdminUtil.CMD_SEARCH_IMAGE);
    }

    private void doSearchImage(ActionRequest actionRequest) //throws SystemException, PortalException
    {
        List<DLFileEntry> arlIGImages = new ArrayList<DLFileEntry>();
        List<Image> arlImages = new ArrayList<Image>();
        try
        {
            ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
            String imgDesAndTit = actionRequest.getParameter(ImageAdminUtil.SEARCH_TXT);
            arlImages = ImageLocalServiceUtil.findImageByDescAndTitle(imgDesAndTit, imgDesAndTit);
            arlIGImages = ImageAdminUtil.getAllSearchImages(themeDisplay.getLayout().getGroupId(), arlImages);
            actionRequest.setAttribute("arlIGImages", arlIGImages);
            actionRequest.setAttribute(ImageAdminUtil.CURR_FOLDER, actionRequest.getParameter(ImageAdminUtil.CURR_FOLDER));
            actionRequest.setAttribute(ImageAdminUtil.PARENT_FOLDER_ID, actionRequest.getParameter(ImageAdminUtil.PARENT_FOLDER_ID));
            LOG.info("doSearchImage: Found " + (arlIGImages != null ? arlIGImages.size() : 0) + " images");
        }
        catch (SystemException e)
        {
            LOG.error(e);
        }
    }

    @ProcessAction(name = "guestSearchImage")
    public void guestSearchImage(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, SystemException, PortalException
    {
        doSearchImage(actionRequest);
        actionResponse.setRenderParameter(ImageAdminUtil.CMD, actionRequest.getParameter(ImageAdminUtil.CMD));
    }
}
