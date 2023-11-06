package com.ihg.brandstandards.portlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.UnavailableException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import com.ihg.brandstandards.bsadmin.model.ManualView;
import com.ihg.brandstandards.db.model.HistManualAttachment;
import com.ihg.brandstandards.db.model.HistManualChain;
import com.ihg.brandstandards.db.model.HistManualRegion;
import com.ihg.brandstandards.db.model.HistManuals;
import com.ihg.brandstandards.db.model.Workflow;
import com.ihg.brandstandards.db.service.HistManualAttachmentLocalServiceUtil;
import com.ihg.brandstandards.db.service.HistManualChainLocalServiceUtil;
import com.ihg.brandstandards.db.service.HistManualRegionLocalServiceUtil;
import com.ihg.brandstandards.db.service.HistManualsLocalServiceUtil;
import com.ihg.brandstandards.db.service.WorkflowLocalServiceUtil;
import com.ihg.brandstandards.db.service.persistence.HistManualChainPK;
import com.ihg.brandstandards.db.service.persistence.HistManualRegionPK;
import com.ihg.brandstandards.util.ManualsUtil;
import com.ihg.brandstandards.util.StandardsUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.NoSuchFolderException;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.liferay.portlet.dynamicdatamapping.storage.Fields;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class ManualsController extends MVCPortlet
{
    private static final Log LOG = LogFactoryUtil.getLog(ManualsController.class);

    @Override
    public void init(PortletConfig portletConfig) throws UnavailableException, PortletException
    {
        super.init(portletConfig);
    }

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException, IOException
    {
        try
        {
            final long userId = PortalUtil.getUserId(renderRequest);
            if (userId < 1)
            {
                renderRequest.setAttribute("NotLoggedIn", true);
            }
            else
            {
                final ManualView manualView = prepareRequest(renderRequest);
                renderRequest.setAttribute("ManualView", manualView);
            }

            final PortletRequestDispatcher reqDisp = getPortletContext().getRequestDispatcher(viewTemplate);
            reqDisp.include(renderRequest, renderResponse);
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
    }

    public ManualView prepareRequest(RenderRequest renderRequest) throws PortalException, SystemException
    {
        ManualView manualView = new ManualView();
        HistManuals manual = null;
        final HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
        final String objId = httpReq.getParameter(ManualsUtil.REQUEST_PARAM_ID);
        final long userId = PortalUtil.getUserId(renderRequest);
        final User user = UserLocalServiceUtil.getUserById(userId);
        if (ManualsUtil.IsNullOrBlank(objId))
        {
            manual = HistManualsLocalServiceUtil.createHistManuals(-111);
            manual.setType("");
            manualView.setHasAccess(ManualsUtil.hasCreateRights(user));
        }
        else
        {
            final long manualId = Long.valueOf(objId);
            manual = HistManualsLocalServiceUtil.getHistManuals(manualId);
            manualView.setManualChain(HistManualChainLocalServiceUtil.getManualChainById(manual.getHistManualId()));
            manualView.setManualRegions(HistManualRegionLocalServiceUtil.getManualRegionById(manual.getHistManualId()));
            manualView.setAttachment(HistManualAttachmentLocalServiceUtil.getHistManualAttachment(manual.getHistManualId()));
            manualView.setHasAccess(ManualsUtil.hasEditDeleteRigths(user, manual));
        }
        manualView.setManual(manual);
        return manualView;
    }

    public void serveResource(ResourceRequest request, ResourceResponse response) throws IOException, PortletException
    {

        final String resourceID = request.getResourceID();
        String message = StandardsUtil.SUCCESS_MESSAGE;
        if (resourceID.equals("SaveManual"))
        {
            LOG.debug("--- Serve Resource ---:  " + request.getParameter("manual_file_title"));
            try
            {
                processRequest(request);
            }
            catch (Exception e)
            {
                message = e.getLocalizedMessage() + " : " + e.getMessage();
                LOG.error(StackTraceUtil.getStackTrace(e));
            }
            PrintWriter writer = response.getWriter();
            writer.print(message);
        }
    }

    public HistManuals processRequest(ResourceRequest resourceRequest) throws Exception
    {

        UploadPortletRequest request = PortalUtil.getUploadPortletRequest(resourceRequest);
        LOG.debug("Yes it is multipart..");
        LOG.debug("HttpRequest : " + request.getParameter("manual_file_title"));
        LOG.debug("UploadRequest File : " + request.getFile("manual_file"));
        long userId = PortalUtil.getUserId(request);
        User user = UserLocalServiceUtil.getUserById(userId);
        HistManuals manual = null;
        long objId = -100;
        String prevStatus = ManualsUtil.MANUAL_STATUS_NOT_EXISTS;
        Date currDate = new Date();
        if (!ManualsUtil.IsNullOrBlank(request.getParameter(ManualsUtil.REQUEST_PARAM_ID)))
        {
            objId = Long.valueOf(request.getParameter(ManualsUtil.REQUEST_PARAM_ID));
        }
        if (objId < 0)
        {
            objId = CounterLocalServiceUtil.increment(HistManuals.class.getName());
            manual = HistManualsLocalServiceUtil.createHistManuals(objId);
            manual.setCreatorId(String.valueOf(userId));
            manual.setCreatedDate(currDate);
            manual.setStatus(ManualsUtil.MANUAL_STATUS_NEW);
        }
        else
        // Edit Mode.
        {
            manual = HistManualsLocalServiceUtil.getHistManuals(objId);
            prevStatus = manual.getStatus();
        }
        manual.setTitle(request.getParameter("manual_file_title"));
        manual.setType(request.getParameter("manual_type"));
        String str_date = request.getParameter("manual_pub_date");
        DateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        if (!ManualsUtil.IsNullOrBlank(request.getParameter("manual_pub_date")))
        {
            Date publishDate = (Date) formatter.parse(str_date);
            manual.setPubDate(publishDate);
        }
        HistManualsLocalServiceUtil.updateHistManuals(manual);

        // Update Countries.
        String regions[] = request.getParameterValues("manuals_regions");
        LOG.debug(StringUtils.join(regions));
        if (!StandardsUtil.IsNullOrBlank(regions))
        {
            for (String region : regions)
            {
                if (!regionExists(region, manual.getHistManualId()))
                {
                    LOG.debug(region);
                    HistManualRegion manualRegion = HistManualRegionLocalServiceUtil.getHistManualRegionObject();
                    manualRegion.setHistManualId(manual.getHistManualId());
                    manualRegion.setRegionCode(region);
                    manualRegion.setCreatorId(String.valueOf(userId));
                    manualRegion.setCreatedDate(currDate);
                    manualRegion.setUpdatedBy(String.valueOf(userId));
                    manualRegion.setUpdatedDate(currDate);
                    HistManualRegionLocalServiceUtil.addHistManualRegion(manualRegion);
                }
            }
            removeRegions(regions, manual.getHistManualId());
        }

        // Process Brands
        if (!StandardsUtil.IsNullOrBlank(request.getParameter("manuals_brand")))
        {
            String chains[] = request.getParameterValues("manuals_brand");
            for (String chain : chains)
            {
                if (!chainExists(chain, manual.getHistManualId()))
                {
                    HistManualChain chnManual = HistManualChainLocalServiceUtil.getHistManualChainObject();
                    chnManual.setChainCode(chain);
                    chnManual.setHistManualId(manual.getHistManualId());
                    chnManual.setUpdatedBy(String.valueOf(userId));
                    chnManual.setUpdatedDate(currDate);
                    chnManual.setCreatedDate(currDate);
                    chnManual.setCreatorId(String.valueOf(userId));
                    HistManualChainLocalServiceUtil.addHistManualChain(chnManual);
                    LOG.debug(chain);
                }
                removeChains(chains, manual.getHistManualId());
            }
        }

        // Add workflow entry. 
        long wrkflowId = CounterLocalServiceUtil.increment(Workflow.class.getName());
        Workflow workflow = WorkflowLocalServiceUtil.createWorkflow(wrkflowId);
        workflow.setStatus(manual.getStatus());
        workflow.setPrevStatus(prevStatus);
        workflow.setObjectId(manual.getHistManualId());
        workflow.setObjectType("MNL");
        workflow.setCreatedBy(user.getScreenName());
        workflow.setUpdatedBy("" + userId);
        workflow.setUpdatedDate(currDate);
        workflow.setCreatedDate(currDate);
        workflow.setCreatorId("" + user.getUserId());
        WorkflowLocalServiceUtil.addWorkflow(workflow);
        LOG.debug("Done Adding workflow");
        //if(isMultipart) {
        processManualFiles(resourceRequest, (UploadPortletRequest) request, manual.getHistManualId());
        //}

        return manual;
    }

    public static void deleteExistingDLFile(long groupId, DLFolder manualFolder) throws SystemException, PortalException
    {
        // delete all file from this folder.
        List<DLFileEntry> fileEntries = DLFileEntryLocalServiceUtil.getFileEntries(groupId, manualFolder.getFolderId());
        if (fileEntries != null && fileEntries.size() > 0)
        {
            for (DLFileEntry dlFileEntry : fileEntries)
            {
                //DLFileEntryLocalServiceUtil.deleteDLFileEntry(dlFileEntry);
            	DLAppLocalServiceUtil.deleteFileEntry(dlFileEntry.getFileEntryId());
            }
        }
    }

    public static void processManualFiles(ResourceRequest resourceRequest, UploadPortletRequest uploadRequest, long manualId)
            throws PortalException, SystemException
    {

        String fileName = uploadRequest.getFileName("manual_file");
        LOG.debug(fileName);
        if (!ManualsUtil.IsNullOrBlank(fileName))
        {
            ThemeDisplay themeDisplay = (ThemeDisplay) uploadRequest.getAttribute(WebKeys.THEME_DISPLAY);
            long groupId = themeDisplay.getScopeGroupId();
            long userId = themeDisplay.getUserId();
            ServiceContext serviceContext = ServiceContextFactory.getInstance(resourceRequest);
            DLFolder rootFolder = getDLFolder(userId, groupId, StandardsUtil.STANDARD_ROOT_PARENT_FOLDER_ID,
                    ManualsUtil.MANUALS_ROOT_FOLDER_NAME, serviceContext);
            DLFolder manualFolder = getDLFolder(userId, groupId, rootFolder.getFolderId(), "" + manualId, serviceContext);
            if (manualId > 0)
            {
                deleteExistingDLFile(groupId, manualFolder);
            }

            File file = uploadRequest.getFile("manual_file");
            LOG.debug("Manual File Name = " + fileName + "  File size is " + (file == null ? "0" : file.length()));
            String changeLog = "Added file: " + fileName;
            String description = "Supporting file " + fileName;
            serviceContext.setAddGroupPermissions(true);
            serviceContext.setAddGuestPermissions(true);
            String mimeType = MimeTypesUtil.getContentType(file);

            /*long fileEntryTypeId = -1L;
            Map<String, Fields> fieldsMap = null;
            DLFileEntry dlFile = DLFileEntryLocalServiceUtil.addFileEntry(userId, groupId,
                    groupId, manualFolder.getFolderId(), fileName, mimeType, fileName, description, changeLog,
                    fileEntryTypeId, fieldsMap, file,null ,file.length(), serviceContext);*/
            
             DLAppLocalServiceUtil.addFileEntry(userId, themeDisplay.getScopeGroupId(),
            		manualFolder.getFolderId(), fileName, mimeType, fileName, description, changeLog, file, serviceContext);
            
            String attachmentPath = "/documents/" + groupId + "/" + manualFolder.getFolderId() + "/" + fileName;
            addFileReference(manualId, attachmentPath, userId);
        }
    }

    public static DLFolder getDLFolder(long userId, long groupId, long parentFolderId, String folderName,
            ServiceContext serviceContext) throws PortalException, SystemException
    {
        DLFolder folder = null;
        try
        {
            folder = DLFolderLocalServiceUtil.getFolder(groupId, parentFolderId, folderName);
        }
        catch (NoSuchFolderException e)
        {
            boolean addCommunityPermissions = true;
            boolean addGuestPermissions = true;
            String manualFolderDescription = "Folder for Manuals " + folderName;
            serviceContext.setAddGroupPermissions(addCommunityPermissions);
            serviceContext.setAddGuestPermissions(addGuestPermissions);
            folder = DLFolderLocalServiceUtil.addFolder(userId, groupId,groupId,false, parentFolderId, folderName, manualFolderDescription,
                    false,serviceContext);
        }
        return folder;
    }

    public static void addFileReference(long manualId, String attachmentPath, long userId) throws SystemException
    {
        HistManualAttachment reference = null;
        Date currDate = new Date();
        try
        {
            reference = HistManualAttachmentLocalServiceUtil.getHistManualAttachment(manualId);
        }
        catch (Exception exc)
        {
            reference = HistManualAttachmentLocalServiceUtil.createHistManualAttachment(manualId);
            reference.setCreatedDate(currDate);
            reference.setCreatorId("" + userId);
        }
        reference.setAttachmentPath(attachmentPath);
        reference.setUpdatedBy("" + userId);
        reference.setUpdatedDate(currDate);
        HistManualAttachmentLocalServiceUtil.updateHistManualAttachment(reference);
    }

    public boolean regionExists(String region, long manualId) throws SystemException
    {
        if (manualId < 0)
        {
            return false;
        }
        try
        {
            HistManualRegionLocalServiceUtil.getHistManualRegion(new HistManualRegionPK(region, manualId));
        }
        catch (PortalException exc)
        {
            return false;
        }
        return true;
    }

    public void removeRegions(final String regionIds[], final long manualId) throws SystemException
    {
        if (manualId < 0 || regionIds == null || regionIds.length < 0)
        {
            return;
        }
        List<HistManualRegion> manualRegions = HistManualRegionLocalServiceUtil.getManualRegionById(manualId);
        for (HistManualRegion manualRegion : manualRegions)
        {
            boolean bFound = false;
            for (String regionId : regionIds)
            {
                if (ManualsUtil.IsNullOrBlank(regionId))
                {
                    bFound = true;
                    break;
                }
                else if (manualRegion.getRegionCode().equals(regionId))
                {
                    LOG.debug(manualRegion.getRegionCode() + "  == " + regionId);
                    bFound = true;
                    break;
                }
            }
            if (!bFound)
            {
                LOG.debug("Deleting : " + manualRegion.getRegionCode());
                HistManualRegionLocalServiceUtil.deleteHistManualRegion(manualRegion);
            }
        }
    }

    public boolean chainExists(final String chain, final long manualId) throws SystemException
    {
        if (manualId < 0)
        {
            return false;
        }
        try
        {
            HistManualChainLocalServiceUtil.getHistManualChain(new HistManualChainPK(chain, manualId));
        }
        catch (PortalException exc)
        {
            return false;
        }
        return true;
    }

    public void removeChains(final String chains[], final long manualId) throws SystemException
    {
        if (manualId < 0 || chains == null || chains.length < 0)
        {
            return;
        }
        List<HistManualChain> manualChains = HistManualChainLocalServiceUtil.getManualChainById(manualId);
        for (HistManualChain manualChain : manualChains)
        {
            boolean bFound = false;
            for (String chain : chains)
            {
                if (ManualsUtil.IsNullOrBlank(chain))
                {
                    bFound = true;
                    break;
                }
                else if (manualChain.getChainCode().equals(chain))
                {
                    LOG.debug(manualChain.getChainCode() + "  == " + chain);
                    bFound = true;
                    break;
                }
            }
            if (!bFound)
            {
                LOG.debug("Deleting : " + manualChain.getChainCode());
                HistManualChainLocalServiceUtil.deleteHistManualChain(manualChain);
            }
        }
    }
}