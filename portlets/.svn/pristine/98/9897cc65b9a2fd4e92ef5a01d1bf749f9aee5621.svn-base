/**
 * 
 */
package com.ihg.brandstandards.portlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.portlet.PortletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;

import com.ihg.brandstandards.bsadmin.model.TranslationsView;
import com.ihg.brandstandards.custom.model.Preferences;
import com.ihg.brandstandards.db.NoSuchStandardsTranslateException;
import com.ihg.brandstandards.db.model.AttachmentsStandards;
import com.ihg.brandstandards.db.model.ExternalLinkStandards;
import com.ihg.brandstandards.db.model.Standards;
import com.ihg.brandstandards.db.model.StandardsImages;
import com.ihg.brandstandards.db.model.StandardsTranslate;
import com.ihg.brandstandards.db.model.Workflow;
import com.ihg.brandstandards.db.service.AttachmentsStandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.ExternalLinkStandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsImagesLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsTranslateLocalServiceUtil;
import com.ihg.brandstandards.db.service.WorkflowLocalServiceUtil;
import com.ihg.brandstandards.db.service.persistence.AttachmentsStandardsPK;
import com.ihg.brandstandards.db.service.persistence.StandardsTranslatePK;
import com.ihg.brandstandards.util.BSAdminConstants;
import com.ihg.brandstandards.util.BrandStandardsUtil;
import com.ihg.brandstandards.util.StandardsUtil;
import com.ihg.brandstandards.util.TranslationsUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.NoSuchFileEntryException;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.dynamicdatamapping.storage.Fields;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * @author hitesh.methani
 * Controller class for manage translations portlet
 */
public class ManageTranslationsPortlet extends MVCPortlet
{
    private static final Log LOG = LogFactoryUtil.getLog(ManageTranslationsPortlet.class);

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException
    {
        final long userId = PortalUtil.getUserId(renderRequest);
        try
        {
            HttpServletRequest hsrw = null;
            final User user = UserLocalServiceUtil.getUserById(userId);
            hsrw = PortalUtil.getHttpServletRequest(renderRequest);
            
            HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(hsrw);
            //Aded for CR 142 - Krunal
            final HttpSession session = httpRequest.getSession();
            Preferences preferences = (Preferences)session.getAttribute("Preferences");
            boolean isSuperAdmin = StandardsUtil.isSuperAdmin(user.getRoles());
            String regionCode = StringPool.BLANK;
            
            if (preferences != null) 
            {
                regionCode = preferences.getRegionCode();
            }
            
            long expandStdId =  ParamUtil.getLong(httpRequest, BrandStandardsUtil.REQUEST_PARAM_STD_ID, 0L);
            int pageNum = ParamUtil.getInteger(httpRequest, BrandStandardsUtil.REQUEST_PARAM_PAGE_NUM, 0);
            int recPerPage = ParamUtil.getInteger(httpRequest, BrandStandardsUtil.REQUEST_PARAM_REC_PER_PAGE, 0);
            long stdId = ParamUtil.getLong(httpRequest, BSAdminConstants.STD_ID);
            
            TranslationsView transView = new TranslationsView();
            // The order of the method calls should not be changed as they are interlinked
            
            // set regionCode
            if (isSuperAdmin) 
            {
            	transView.setRegionCode(regionCode);
            	LOG.info("Super User Region::: "+transView.getRegionCode());
            }  
            else 
            {
            	regionCode = StandardsController.getRegionCodeFromUserRole(user.getRoles());
				transView.setRegionCode(regionCode);
            	
				LOG.info("Regional User Region::: "+transView.getRegionCode());
            }
            
            //Set regionId
            transView.setRegionId(TranslationsUtil.getRegionIdByRegionCode(regionCode));

            // set languages
            transView.setLanguages(TranslationsUtil.getRegionLanguages(regionCode));
            // set defaultLanguage
            transView.setDefaultLocale(TranslationsUtil.getDefaultLocale(regionCode));
            // set std
            transView.setStandard(StandardsLocalServiceUtil.getStandards(stdId));
            
            // set backURL
            String urlQuery = "?pageNum=" + pageNum;
            if(recPerPage > 0)
            {
                urlQuery = urlQuery + "&" + BrandStandardsUtil.REQUEST_PARAM_REC_PER_PAGE + "=" + recPerPage;
            }
            if(!transView.getStandard().getStdTyp().equals(BrandStandardsUtil.STD_TYPE_STANDARD)) {
                urlQuery = urlQuery + "&prntid=" + expandStdId;
            }
            
            // set translations
            Map<String, StandardsTranslate> translations = TranslationsUtil.getTranslations(stdId);
            if (Validator.isNotNull(translations))
            {
                transView.setStdTranslates(translations);
            }
            // set extLinks
            TranslationsUtil.setLinkTranslations(transView);
            // set stdImages
            TranslationsUtil.setStdImages(transView);

            // set attachmentsStandards
            TranslationsUtil.setAttachmentsStandards(transView);
            
            // set Brands
            TranslationsUtil.setTranslationChains(transView);
            
            renderRequest.setAttribute("transView", transView);
            renderRequest.setAttribute("urlQuery", urlQuery);
            super.doView(renderRequest, renderResponse);
        }
        catch (PortalException e)
        {
            LOG.error("PortalException in manage Translation " + e.getMessage());
        }
        catch (SystemException e)
        {
            LOG.error("SystemException in manage Translation " + e.getMessage());
        }
    }

    @Override
    public void serveResource(ResourceRequest request, ResourceResponse response) throws IOException, PortletException
    {
        final String resourceID = request.getResourceID();
        if ("saveTranslation".equals(resourceID))
        {
            saveTranslation(request, response);
        }
        else if("refreshTranslationView".equals(resourceID))
        {
            getManageTranslationsData(request, response);
        }
        else
        {
            LOG.error("Unknown Resource ID: " + resourceID);
        }
    }
    
    /**
     * 
     * @author hitesh.methani
     * @param request
     * @param response
     * @throws PortletException 
     * @throws IOException 
     */
    public void getManageTranslationsData(ResourceRequest request, ResourceResponse response) throws IOException, PortletException
    {
        final long userId = PortalUtil.getUserId(request);
        try
        {
            final User user = UserLocalServiceUtil.getUserById(userId);
            long stdId = ParamUtil.getLong(request, BSAdminConstants.STD_ID);
            String urlQuery = ParamUtil.get(request, "urlQuery", StringPool.BLANK);
            String regionCode = StandardsController.getRegionCodeFromUserRole(user.getRoles());
            TranslationsView transView = new TranslationsView();

            // set regionCode
            transView.setRegionCode(regionCode);

            // set languages
            transView.setLanguages(TranslationsUtil.getRegionLanguages(regionCode));
            // set defaultLanguage
            transView.setDefaultLocale(TranslationsUtil.getDefaultLocale(regionCode));
            // set std
            transView.setStandard(StandardsLocalServiceUtil.getStandards(stdId));
            // set translations
            Map<String, StandardsTranslate> translations = TranslationsUtil.getTranslations(stdId);
            if (Validator.isNotNull(translations))
            {
                transView.setStdTranslates(translations);
            }
            // set extLinks
            TranslationsUtil.setLinkTranslations(transView);
            // set stdImages
            TranslationsUtil.setStdImages(transView);

            // set attachmentsStandards
            TranslationsUtil.setAttachmentsStandards(transView);
            
            // set Brands
            TranslationsUtil.setTranslationChains(transView);
            
            request.setAttribute("transView", transView);
            request.setAttribute("urlQuery", urlQuery);
            include(viewTemplate, request, response);
        }
        catch (PortalException e)
        {
            LOG.error("PortalException in manage Translation " + e.getMessage());
        }
        catch (SystemException e)
        {
            LOG.error("SystemException in manage Translation " + e.getMessage());
        }
    }
    
    /**
     * Method to save translation
     * 
     * @author hitesh.methani
     * @param request
     * @param response
     * @throws SystemException
     * @throws PortalException
     * @throws IOException
     */
    private void saveTranslation(ResourceRequest request, ResourceResponse response) throws IOException
    {
        PrintWriter pw = response.getWriter();
        final Date currDate = new Date();
        
        HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request));
        final boolean isMultipart = PortletFileUpload.isMultipartContent(new ServletRequestContext(httpRequest));
        if (isMultipart)
        {
            httpRequest = PortalUtil.getUploadPortletRequest(request);
        }
        if (Validator.isNotNull(httpRequest.getParameter(BSAdminConstants.STD_ID)) && Validator.isNotNull(httpRequest.getParameter(BSAdminConstants.LANG_ID)))
        {
            final long userId = PortalUtil.getUserId(request);
            
            // Translate StdText and StdContext
            try
            {
                saveStdTranslate(httpRequest, userId, currDate);

                saveWorkflowEntry(httpRequest, currDate);
                
                // Translating External Links
                saveExtLink(httpRequest, userId, currDate);

                // Tranlsating StdImages
                saveStdImages(httpRequest, userId, currDate);

                // Translating attachments
                saveStdAttachments(request, httpRequest, currDate);
            }
            catch (SystemException e)
            {
                LOG.error("SystemException in saving translation "+ e.getMessage());
                pw.write("SystemException in saving translation "+ e.getMessage());
                return;
            }
            catch (PortalException e)
            {
                LOG.error("PortalException in saving translation "+ e.getMessage());
                pw.write("PortalException in saving translation "+ e.getMessage());
                return;
            }
            pw.append("Translation data successfully submitted");
        }
        else
        {
            pw.append("Error in saving translation");
        }
    }
    
    /**
     * Update Workflow.
     * 
     * @param userId - user id
     * @param user - user
     * @param std - record
     * @param prevStatus - previous status
     * @param currDate - date
     * @param comments - comments
     * @throws SystemException - exception on addWorkflow.
     * @throws PortalException 
     */
    private void saveWorkflowEntry(HttpServletRequest request, Date currDate)
            throws SystemException, PortalException
    {
        final long wrkflowId = CounterLocalServiceUtil.increment(Workflow.class.getName());
        final Workflow workflow = WorkflowLocalServiceUtil.createWorkflow(wrkflowId);
        String localeCd = request.getParameter(BSAdminConstants.LANG_ID);
        final User user = PortalUtil.getUser(request);
        Standards std = StandardsLocalServiceUtil.getStandards(ParamUtil.getLong(request, BSAdminConstants.STD_ID,0L ));
        workflow.setStatus(localeCd);
        workflow.setObjectId(std.getStdId());
        workflow.setObjectType(BrandStandardsUtil.STANDARDS_TRANSLATE_OBJ_TYPE);
        workflow.setCreatedBy(user.getScreenName());
        workflow.setUpdatedBy(String.valueOf(user.getUserId()));
        workflow.setUpdatedDate(currDate);
        workflow.setCreatedDate(currDate);
        workflow.setCreatorId(String.valueOf(user.getUserId()));
        workflow.setComment(ParamUtil.getString(request, BSAdminConstants.TRANS_COMMENT));
        workflow.setTitle(ParamUtil.get(request, BSAdminConstants.TRANS_TITLE, StringPool.BLANK));
        
        //workflow.setStatus(std.getStatus());
        WorkflowLocalServiceUtil.addWorkflow(workflow);
    }

    /**
     * 
     * @param request
     * @param httpRequest
     * @param currDate
     * @throws SystemException
     * @throws PortalException
     */
    private void saveStdAttachments(ResourceRequest request, HttpServletRequest httpRequest, Date currDate)
            throws SystemException, PortalException
    {
        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        long stdId = ParamUtil.getLong(httpRequest, BSAdminConstants.STD_ID);
        String localeCd = ParamUtil.getString(httpRequest, BSAdminConstants.LANG_ID);
        String[] newAttachAdded = StringUtil.split(ParamUtil.get(httpRequest, BSAdminConstants.NEW_ATTACH_ADDED, StringPool.BLANK));
        String[] deletedAttachments = StringUtil.split(ParamUtil.get(httpRequest, localeCd +"deletedAttachments", StringPool.BLANK));
        String[] noneAttachCheck = StringUtil.split(ParamUtil.get(httpRequest, "noneAttachCheck", StringPool.BLANK));
        String[] noneAttachUnCheck = StringUtil.split(ParamUtil.get(httpRequest, "noneAttachUnCheck", StringPool.BLANK));
        String[] newAttachmentsNames = StringUtil.split(ParamUtil.get(httpRequest, "newAttachmentsNames", StringPool.BLANK));
        Standards std = StandardsLocalServiceUtil.getStandards(stdId);
        final ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
        // Deleting Attachments
        if(ArrayUtil.isNotEmpty(deletedAttachments) && deletedAttachments.length > 0)
        {
        	LOG.info("IF  deleteattachemnts ::: " + deletedAttachments.length);
            for (String deletedAttach : deletedAttachments)
            {
                AttachmentsStandards parentAttach = TranslationsUtil.getParentAttachment(deletedAttach);
                if (Validator.isNull(parentAttach))
                {
                	LOG.info("parent is available.");
                    continue;
                }
                List<AttachmentsStandards> toDelete = AttachmentsStandardsLocalServiceUtil
                        .getAttachmentsStandardsByParentIdStdIdLangId(parentAttach.getAttachmentId(), stdId, localeCd);
                for (AttachmentsStandards existing : toDelete)
                {
                	LOG.info("DElete attachement 1 ");
                	String fileName = existing.getAttachmentPath();
                    fileName = fileName.substring(fileName.lastIndexOf('/') + 1);
                    final DLFolder standardFolder = TranslationsUtil.getDLFolder(themeDisplay.getScopeGroupId(),
                            themeDisplay.getUserId(), std, parentAttach.getType(), serviceContext, localeCd);
                    final long folderId = standardFolder.getFolderId();
                    DLFileEntry dfEntry = null;
                    try 
                    {
                        dfEntry = DLFileEntryLocalServiceUtil.getFileEntry(themeDisplay.getScopeGroupId(), folderId, fileName);
                        LOG.info("Get dl file entry ::: :"+dfEntry.getFileEntryId());
                    }
                    catch(NoSuchFileEntryException nsfe)
                    {
                        LOG.error("No file entry found with folderId" + folderId + "for localeCd "+localeCd + "with title " + fileName +". Please delete manually");
                    }
                    if (Validator.isNotNull(dfEntry))
                    {
                        //DLFileEntryLocalServiceUtil.deleteDLFileEntry(dfEntry);
                    	LOG.info("Comming for delet entry 1 ");
                    	DLAppServiceUtil.deleteFileEntry(dfEntry.getFileEntryId());
                    }
                    AttachmentsStandardsLocalServiceUtil.deleteAttachmentsStandards(existing);
                    LOG.info("Delete attachment reference ");
                }
            }
        }
        // Adding new Attachments
        if (ArrayUtil.isNotEmpty(newAttachAdded) && newAttachAdded.length > 0 && ArrayUtil.isNotEmpty(newAttachmentsNames) && newAttachmentsNames.length > 0 && newAttachAdded.length == newAttachmentsNames.length)
        {
        	LOG.info("Adding new attachment ");
            File file;
            for (int i = 0 ; i< newAttachAdded.length ; i++)
            {
                String newAttachedFile = newAttachAdded[i];
                AttachmentsStandards parentAttachment = TranslationsUtil.getParentAttachment(newAttachedFile);
                LOG.info("Fetching parent attachmetn "  );
                if (Validator.isNull(parentAttachment))
                { 
                	LOG.info("Parent attachement null means continue ");
                
                    continue;
                   
                }
                UploadPortletRequest uploadRequest = (UploadPortletRequest) httpRequest;
                //String fileName = uploadRequest.getFileName(newAttachedFile);
                file = uploadRequest.getFile(newAttachedFile);
                LOG.debug("Supporting File Name = " + file.getName() + "  File size is " + (file == null ? "0" : file.length()));
                final DLFolder standardFolder = TranslationsUtil.getDLFolder(themeDisplay.getScopeGroupId(),
                        themeDisplay.getUserId(), std, parentAttachment.getType(), serviceContext, localeCd);
                final long folderId = standardFolder.getFolderId();
                
                LOG.info("Folder id  "+folderId);
                // Remove existing attachment for same standard and locale
                List<AttachmentsStandards> existingAttach = AttachmentsStandardsLocalServiceUtil
                        .getAttachmentsStandardsByParentIdStdIdLangId(parentAttachment.getAttachmentId(), stdId, localeCd);
                LOG.info("fidning existing attahcment for same statnadrds ");
                for (AttachmentsStandards existing : existingAttach)
                {
                    String fileName = existing.getAttachmentPath();
                    fileName = fileName.substring(fileName.lastIndexOf('/') + 1);
                    DLFileEntry dfEntry = null;
                    try
                    {
                        dfEntry = DLFileEntryLocalServiceUtil.getFileEntry(themeDisplay.getScopeGroupId(), folderId, fileName);
                        LOG.info("Get entry when add ::: :"+dfEntry.getFileEntryId());
                    }
                    catch(NoSuchFileEntryException nsfe)
                    {
                        LOG.error("No file entry found with folderId" + folderId + "for localeCd "+localeCd + "with title " + fileName +". Please delete manually");
                    }
                    if (Validator.isNotNull(dfEntry))
                    {
                        //DLFileEntryLocalServiceUtil.deleteDLFileEntry(dfEntry);
                        DLAppServiceUtil.deleteFileEntry(dfEntry.getFileEntryId());
                        LOG.info("Delete if not null dl file entry ");
                    }
                    AttachmentsStandardsLocalServiceUtil.deleteAttachmentsStandards(existing);
                }
                // Add file start
                newAttachmentsNames[i] = newAttachmentsNames[i].replaceAll("[&@\\]}:,=>/<\n\\[{%|\\+#\\?'\r;\\*~]", "");
                String mimeType = MimeTypesUtil.getContentType(newAttachmentsNames[i]);

                long fileEntryTypeId = -1L;
                Map<String, Fields> fieldsMap = null;
                serviceContext.setAddGroupPermissions(true);
                serviceContext.setAddGuestPermissions(false);
                /*DLFileEntry dlFileEntry = DLFileEntryLocalServiceUtil.addFileEntry(themeDisplay.getUserId(), themeDisplay.getScopeGroupId(),
                        themeDisplay.getScopeGroupId(), folderId, newAttachmentsNames[i], mimeType, newAttachmentsNames[i], "", "",
                        fileEntryTypeId, fieldsMap, file,null ,file.length(), serviceContext);*/
                LOG.info("New attachment  Length  "+newAttachmentsNames.length);
                FileEntry fileEntry = DLAppLocalServiceUtil.addFileEntry(themeDisplay.getUserId(), themeDisplay.getScopeGroupId(), folderId, newAttachmentsNames[i], mimeType, newAttachmentsNames[i], "", "", file, serviceContext);
                
                // Add file end
                LOG.info("File add 1");
                
                //  Add StdAttachment
                AttachmentsStandards attachmentsStandards = AttachmentsStandardsLocalServiceUtil
                        .createAttachmentsStandards(new AttachmentsStandardsPK(CounterLocalServiceUtil
                                .increment("AttachmentsStandards"), localeCd));
                final String attachmentPath = "/documents/" + themeDisplay.getScopeGroupId() + "/" + folderId + "/"
                        + newAttachmentsNames[i];
                attachmentsStandards.setAttachmentPath(attachmentPath);
                attachmentsStandards.setCreatedDate(currDate);
                attachmentsStandards.setCreatorId(String.valueOf(themeDisplay.getUserId()));
                attachmentsStandards.setParentAttachmentId(parentAttachment.getAttachmentId());
                attachmentsStandards.setStdId(stdId);
                attachmentsStandards.setTitle(ParamUtil.get(httpRequest, newAttachedFile +"Title", file.getName()));
                attachmentsStandards.setTranslationIndicator("Y");
                
                attachmentsStandards.setType(parentAttachment.getType());
                attachmentsStandards.setUpdatedBy(String.valueOf(themeDisplay.getUserId()));
                attachmentsStandards.setUpdatedDate(currDate);
                AttachmentsStandardsLocalServiceUtil.updateAttachmentsStandards(attachmentsStandards);
                LOG.info("After Updateing attachemnt");
            }
        }
        
        // none checkbox process
        if(ArrayUtil.isNotEmpty(noneAttachCheck) && noneAttachCheck.length > 0)
        {
        	LOG.info("Check box. none");
        	for(String noneAttachId : noneAttachCheck)
            {
                boolean doNotInsert = false;
                List<AttachmentsStandards> childAttach = AttachmentsStandardsLocalServiceUtil.getAttachmentsStandardsByParentIdStdIdLangId(GetterUtil.getLong(noneAttachId, 0L), stdId, localeCd);
                if(Validator.isNotNull(childAttach) && childAttach.size() > 0)
                {
                	LOG.info("if child attach not null");
                    for(AttachmentsStandards attachment : childAttach)
                    {
                        if(!TranslationsUtil.NOT_APPLICABLE.equals(attachment.getTranslationIndicator()))
                        {
                        	LOG.info("Delete this attache");
                            AttachmentsStandardsLocalServiceUtil.deleteAttachmentsStandards(attachment);
                        }
                        else
                        {
                            doNotInsert = true;
                            LOG.info("Do not insert");
                        }
                    }
                }
                if(!doNotInsert)
                {
                
                    AttachmentsStandards parentAttach = AttachmentsStandardsLocalServiceUtil.getAttachmentsStandards(new AttachmentsStandardsPK(GetterUtil.getLong(noneAttachId, 0L), BrandStandardsUtil.DEFAULT_LOCALE));
                    AttachmentsStandards attachmentsStandards = AttachmentsStandardsLocalServiceUtil
                            .createAttachmentsStandards(new AttachmentsStandardsPK(CounterLocalServiceUtil
                                    .increment("AttachmentsStandards"), localeCd));
                    final String attachmentPath = parentAttach.getAttachmentPath();
                    LOG.info("Get parent and add attachment"+attachmentPath);
                    attachmentsStandards.setAttachmentPath(attachmentPath);
                    attachmentsStandards.setCreatedDate(currDate);
                    attachmentsStandards.setCreatorId(String.valueOf(themeDisplay.getUserId()));
                    attachmentsStandards.setParentAttachmentId(parentAttach.getAttachmentId());
                    attachmentsStandards.setStdId(stdId);
                    attachmentsStandards.setTitle(parentAttach.getTitle());
                    attachmentsStandards.setTranslationIndicator(TranslationsUtil.NOT_APPLICABLE);
                    attachmentsStandards.setType(parentAttach.getType());
                    attachmentsStandards.setUpdatedBy(String.valueOf(themeDisplay.getUserId()));
                    attachmentsStandards.setUpdatedDate(currDate);
                    AttachmentsStandardsLocalServiceUtil.updateAttachmentsStandards(attachmentsStandards);
                }
            }
        }
        // none uncheck process
        if(ArrayUtil.isNotEmpty(noneAttachUnCheck) && noneAttachUnCheck.length > 0)
        {
            for(String noneAttachId : noneAttachUnCheck)
            {
            	LOG.info("non attachment "+noneAttachId);
                List<AttachmentsStandards> childAttach = AttachmentsStandardsLocalServiceUtil.getAttachmentsStandardsByParentIdStdIdLangId(GetterUtil.getLong(noneAttachId, 0L), stdId, localeCd);
                if(Validator.isNotNull(childAttach) && childAttach.size() > 0)
                {
                    for(AttachmentsStandards attachment : childAttach)
                    {
                        AttachmentsStandardsLocalServiceUtil.deleteAttachmentsStandards(attachment);
                        LOG.info("Delete none un check");
                    }
                }
            }
        }
    }
    
    /**
     * 
     * @param httpRequest
     * @param userId
     * @param currDate
     * @throws SystemException
     * @throws PortalException
     */
    private void saveStdImages(HttpServletRequest httpRequest, long userId, Date currDate) throws SystemException,
            PortalException
    {
        long stdId = ParamUtil.getLong(httpRequest, BSAdminConstants.STD_ID);
        String localeCd = ParamUtil.getString(httpRequest, BSAdminConstants.LANG_ID);
        String parentStdImageIdsParam = ParamUtil.get(httpRequest, BSAdminConstants.PRNTSTDIMG, StringPool.BLANK);
        long[] parentStdImageIds = StringUtil.split(parentStdImageIdsParam, 0L);
        String translatedImagesParam = ParamUtil.get(httpRequest, BSAdminConstants.TRANSIMAGES, StringPool.BLANK);
        long[] translatedImages = StringUtil.split(translatedImagesParam, 0L);
        String translatedImagesTitleParam = ParamUtil.get(httpRequest, BSAdminConstants.TRANSIMAGETITLE, StringPool.BLANK);
        String[] translatedImagesTitle = StringUtil.split(translatedImagesTitleParam);
        String[] imageDefaultChecked = StringUtil.split(ParamUtil.get(httpRequest, BSAdminConstants.IMAGE_DEFAULT_CHECKED, StringPool.BLANK));
        String[] imageDefaultUnchecked = StringUtil.split(ParamUtil.get(httpRequest, BSAdminConstants.IMAGE_DEFAULT_UNCHECKED, StringPool.BLANK));
        String defaultLocaleCode = ParamUtil.getString(httpRequest, BSAdminConstants.DEFAULTLOCALECODE);
        // choose default checked
        if (ArrayUtil.isNotEmpty(imageDefaultChecked) && imageDefaultChecked.length > 0)
        {
            List<StandardsImages> stdImages;
            List<StandardsImages> parentStdImages;
            for (String checkBoxId : imageDefaultChecked)
            {
                String[] idArr = checkBoxId.split(StringPool.DASH + StringPool.DASH);
                if (idArr.length == 3)
                {
                    stdImages = StandardsImagesLocalServiceUtil.getStdImagesByParentImageIdStdIdLocaleCd(
                            Long.parseLong(idArr[0]), stdId, localeCd);
                    StandardsImages stdImage;
                    if (Validator.isNotNull(stdImages) && stdImages.size() > 0)
                    {
                        stdImage = stdImages.get(0);
                    }
                    else
                    {
                        stdImage = StandardsImagesLocalServiceUtil.createStandardsImages(CounterLocalServiceUtil
                                .increment(StandardsImages.class.getName()));
                        stdImage.setCreatedDate(currDate);
                        stdImage.setCreatorId(String.valueOf(userId));
                        stdImage.setParentImageId((Long.parseLong(idArr[0])));
                        stdImage.setStdId(stdId);
                        stdImage.setLocaleCode(localeCd);
                        stdImage.setImageSortOrder(1L);
                    }
                    parentStdImages = StandardsImagesLocalServiceUtil.getStdImagesByParentImageIdStdIdLocaleCd(
                            Long.parseLong(idArr[0]), stdId, defaultLocaleCode);
                    if (Validator.isNotNull(parentStdImages) && parentStdImages.size() > 0)
                    {
                        stdImage.setImageId(parentStdImages.get(0).getImageId());
                        stdImage.setUpdatedDate(currDate);
                        stdImage.setUpdatedBy(String.valueOf(userId));
                        stdImage.setImageTitle(parentStdImages.get(0).getImageTitle());
                        StandardsImagesLocalServiceUtil.updateStandardsImages(stdImage);
                    }

                }
            }
        }
        // choose default unchecked
        if (ArrayUtil.isNotEmpty(imageDefaultUnchecked) && imageDefaultUnchecked.length > 0)
        {
            List<StandardsImages> stdImages;
            for (String checkBoxId : imageDefaultUnchecked)
            {
                String[] idArr = checkBoxId.split(StringPool.DASH + StringPool.DASH);
                if (idArr.length == 3)
                {
                    stdImages = StandardsImagesLocalServiceUtil.getStdImagesByParentImageIdStdIdLocaleCd(
                            Long.parseLong(idArr[0]), stdId, localeCd);
                    StandardsImages stdImage;
                    if (Validator.isNotNull(stdImages) && stdImages.size() > 0)
                    {
                        stdImage = stdImages.get(0);
                        StandardsImagesLocalServiceUtil.deleteStandardsImages(stdImage.getStdImageId());
                    }
                }
            }
        }
        if (ArrayUtil.isNotEmpty(parentStdImageIds) && ArrayUtil.isNotEmpty(translatedImages)
                && ArrayUtil.isNotEmpty(translatedImagesTitle) && translatedImages.length == parentStdImageIds.length
                && translatedImagesTitle.length == parentStdImageIds.length)
        {
            List<StandardsImages> stdImages;
            for (int counter = 0; counter < parentStdImageIds.length; counter++)
            {
                stdImages = StandardsImagesLocalServiceUtil.getStdImagesByParentImageIdStdIdLocaleCd(parentStdImageIds[counter],
                        stdId, localeCd);
                StandardsImages stdImage;
                if (Validator.isNotNull(stdImages) && stdImages.size() > 0)
                {
                    stdImage = stdImages.get(0);
                }
                else
                {
                    stdImage = StandardsImagesLocalServiceUtil.createStandardsImages(CounterLocalServiceUtil
                            .increment(StandardsImages.class.getName()));
                    stdImage.setCreatedDate(currDate);
                    stdImage.setCreatorId(String.valueOf(userId));
                    stdImage.setParentImageId(parentStdImageIds[counter]);
                    stdImage.setStdId(stdId);
                    stdImage.setLocaleCode(localeCd);
                    stdImage.setImageSortOrder(1L);
                }
                stdImage.setImageId(translatedImages[counter]);
                stdImage.setUpdatedDate(currDate);
                stdImage.setUpdatedBy(String.valueOf(userId));
                stdImage.setImageTitle(translatedImagesTitle[counter]);
                StandardsImagesLocalServiceUtil.updateStandardsImages(stdImage);
            }
        }

    }
    
    
    /**
     * 
     * @param httpRequest
     * @param userId
     * @param currDate
     * @throws SystemException
     * @throws PortalException 
     */
    private void saveExtLink(HttpServletRequest httpRequest, long userId, Date currDate) throws SystemException, PortalException
    {
        long stdId = ParamUtil.getLong(httpRequest, BSAdminConstants.STD_ID);
        String localeCd = ParamUtil.getString(httpRequest, BSAdminConstants.LANG_ID);
        String parentsParam = ParamUtil.get(httpRequest, BSAdminConstants.PARENTS, StringPool.BLANK);
        long[] parents = StringUtil.split(parentsParam, 0L);
        String transUrlsParam = ParamUtil.get(httpRequest, BSAdminConstants.TRANS_URLS, StringPool.BLANK);
        String[] transUrls = StringUtil.split(transUrlsParam, StringPool.COMMA);
        String transTitlesParam = ParamUtil.get(httpRequest, BSAdminConstants.TRANS_URL_TITLE, StringPool.BLANK);
        String[] transTitles = StringUtil.split(transTitlesParam);
        String deletedTransLinksParam = ParamUtil.get(httpRequest, localeCd +"deletedExtLinks", StringPool.BLANK);
        long[] deletedTransLinks = StringUtil.split(deletedTransLinksParam, 0L);
        // converting it to arrayList as elements need to be added dynamically
        List<Long> deletedLinks = ListUtil.toList(deletedTransLinks);
        String noneCheckedParam = ParamUtil.get(httpRequest, BSAdminConstants.NONECHECKED, StringPool.BLANK);
        long[] noneChecked = StringUtil.split(noneCheckedParam, 0L);
        String noneUncheckedParam = ParamUtil.get(httpRequest,BSAdminConstants.NONEUNCHECKED, StringPool.BLANK);
        long[] noneUnChecked = StringUtil.split(noneUncheckedParam, 0L);
        // Inserting data for none checkbox unchecked
        for (long noneUnCheckedParent : noneUnChecked)
        {
            if (Arrays.asList(parents).contains(noneUnCheckedParent) || deletedLinks.contains(noneUnCheckedParent))
            {
                continue;
            }
            else
            {
                deletedLinks.add(noneUnCheckedParent);
            }
        }

        // Inserting data for none checkbox checked

        for (long noneCheckedParent : noneChecked)
        {
            List<ExternalLinkStandards> extLinks;
            ExternalLinkStandards extLink;
            extLinks = ExternalLinkStandardsLocalServiceUtil.getExternalLinksStandardsByParentIdStdIdLangId(noneCheckedParent,
                    stdId, String.valueOf(localeCd));
            ExternalLinkStandards parentLink = ExternalLinkStandardsLocalServiceUtil.getExternalLinkStandards(noneCheckedParent);
            if (Validator.isNotNull(extLinks) && extLinks.size() > 0)
            {
                extLink = extLinks.get(0);
                extLink.setUrl(parentLink.getRealUrl());
                extLink.setTitle(parentLink.getTitle());
                extLink.setTranslationIndicator(TranslationsUtil.NOT_APPLICABLE);
            }
            else
            {
                extLink = ExternalLinkStandardsLocalServiceUtil.createExternalLinkStandards(CounterLocalServiceUtil
                        .increment("ExternalLink"));
                extLink.setStdId(stdId);
                extLink.setCreatedDate(currDate);
                extLink.setCreatorId(String.valueOf(userId));
                extLink.setUrl(parentLink.getRealUrl());
                extLink.setTitle(parentLink.getTitle());
                extLink.setTranslationIndicator(TranslationsUtil.NOT_APPLICABLE);
                extLink.setLocaleCode(String.valueOf(localeCd));
                extLink.setParentExtLinkId(noneCheckedParent);
            }
            if (Validator.isNotNull(extLink))
            {
                extLink.setUpdatedBy(String.valueOf(userId));
                extLink.setUpdatedDate(currDate);
                ExternalLinkStandardsLocalServiceUtil.updateExternalLinkStandards(extLink);
            }
        }
        // Deleting required links
        for (long deletedTransLink : deletedLinks)
        {
            List<ExternalLinkStandards> extLinks = ExternalLinkStandardsLocalServiceUtil
                    .getExternalLinksStandardsByParentIdStdIdLangId(deletedTransLink, stdId, String.valueOf(localeCd));
            if (Validator.isNotNull(extLinks) && extLinks.size() > 0)
            {
                ExternalLinkStandardsLocalServiceUtil.deleteExternalLinkStandards(extLinks.get(0));
            }
        }
        if (ArrayUtil.isNotEmpty(parents) && ArrayUtil.isNotEmpty(transUrls) && ArrayUtil.isNotEmpty(transTitles)
                && parents.length == transUrls.length && parents.length == transTitles.length)
        {
            for (int i = 0; i < parents.length; i++)
            {
                List<ExternalLinkStandards> extLinkStds;
                ExternalLinkStandards extLinkStd;
                extLinkStds = ExternalLinkStandardsLocalServiceUtil.getExternalLinksStandardsByParentIdStdIdLangId(parents[i],
                        stdId, String.valueOf(localeCd));
                if (Validator.isNotNull(extLinkStds) && extLinkStds.size() > 0)
                {
                    extLinkStd = extLinkStds.get(0);
                }
                else
                {
                    extLinkStd = ExternalLinkStandardsLocalServiceUtil.createExternalLinkStandards(CounterLocalServiceUtil
                            .increment("ExternalLink"));
                    extLinkStd.setStdId(stdId);
                    extLinkStd.setCreatedDate(currDate);
                    extLinkStd.setCreatorId(String.valueOf(userId));
                }
                extLinkStd.setUrl(transUrls[i]);
                String decodedTitle = transTitles[i].replace("~~!~~", StringPool.COMMA);
                extLinkStd.setTitle(decodedTitle);
                extLinkStd.setTranslationIndicator("Y");
                extLinkStd.setLocaleCode(localeCd);
                extLinkStd.setParentExtLinkId(parents[i]);
                extLinkStd.setStdId(stdId);
                extLinkStd.setUpdatedBy(String.valueOf(userId));
                extLinkStd.setUpdatedDate(currDate);
                ExternalLinkStandardsLocalServiceUtil.updateExternalLinkStandards(extLinkStd);
            }
        }

    }

    
    /**
     * 
     * @param httpRequest
     * @param userId
     * @param currDate
     * @throws SystemException
     * @throws PortalException
     */
    private void saveStdTranslate(HttpServletRequest httpRequest, long userId, Date currDate) throws SystemException,
            PortalException
    {
        long stdId = ParamUtil.getLong(httpRequest, BSAdminConstants.STD_ID);
        String localeCd = ParamUtil.getString(httpRequest, BSAdminConstants.LANG_ID);
        StandardsTranslate stdTranslate = null;
        try
        {
            StandardsTranslatePK standardsTranslatePK = new StandardsTranslatePK(stdId, localeCd);
            stdTranslate = StandardsTranslateLocalServiceUtil.getStandardsTranslate(standardsTranslatePK);
        }
        catch (NoSuchStandardsTranslateException e)
        {
            LOG.info("Existing translation not found, adding new translation");
        }
        catch (SystemException e)
        {
            LOG.error("SystemException in fetching StdTranslate " + e.getMessage());
        }

        // Translating StdTranslate Fields
        if (Validator.isNull(stdTranslate))
        {
            StandardsTranslatePK stdXlatPK = new StandardsTranslatePK(stdId, localeCd);
            stdTranslate = StandardsTranslateLocalServiceUtil.createStandardsTranslate(stdXlatPK);
            stdTranslate.setCreatorId(String.valueOf(userId));
            stdTranslate.setCreatedDate(currDate);
        }
        stdTranslate.setStdId(stdId);
        stdTranslate.setLocaleCode(localeCd);
        stdTranslate.setTitle(ParamUtil.get(httpRequest, BSAdminConstants.TRANS_TITLE, StringPool.BLANK));
        stdTranslate.setNote(StringPool.DASH);
        stdTranslate.setDescription(ParamUtil.get(httpRequest, BSAdminConstants.STD_CONTEXT, StringPool.BLANK));
        stdTranslate.setComment(ParamUtil.get(httpRequest, BSAdminConstants.TRANS_COMMENT, StringPool.SPACE));
        if(stdTranslate.getComment().equals(StringPool.BLANK))
        {
            stdTranslate.setComment(StringPool.SPACE);
        }
        stdTranslate.setUpdatedBy(String.valueOf(userId));
        stdTranslate.setUpdatedDate(currDate);
        if(stdTranslate.getTitle().equals(StringPool.BLANK))
        {
            stdTranslate.setIsValidTxt("N");
        }
        else
        {
            stdTranslate.setIsValidTxt("Y");
        }
        if(stdTranslate.getDescription().equals(StringPool.BLANK))
        {
            stdTranslate.setIsValidCntxt("N");
        }
        else
        {
            stdTranslate.setIsValidCntxt("Y");
        }
        StandardsTranslateLocalServiceUtil.updateStandardsTranslate(stdTranslate);
    }

}