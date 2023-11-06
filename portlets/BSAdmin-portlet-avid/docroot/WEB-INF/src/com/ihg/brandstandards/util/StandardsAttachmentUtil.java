package com.ihg.brandstandards.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ResourceRequest;

import com.ihg.brandstandards.db.model.AttachmentsStandards;
import com.ihg.brandstandards.db.model.AttachmentsStandardsCountry;
import com.ihg.brandstandards.db.model.ChainAttachmentsStandards;
import com.ihg.brandstandards.db.model.Standards;
import com.ihg.brandstandards.db.service.AttachmentsStandardsCountryLocalServiceUtil;
import com.ihg.brandstandards.db.service.AttachmentsStandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.ChainAttachmentsStandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.persistence.AttachmentsStandardsCountryPK;
import com.ihg.brandstandards.db.service.persistence.AttachmentsStandardsPK;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.documentlibrary.DuplicateFileException;
import com.liferay.portlet.documentlibrary.NoSuchFolderException;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.liferay.portlet.dynamicdatamapping.storage.Fields;

/**
 * Utility class to upload multiple files into Liferay Document Library.
 * 
 * @author KryvorA
 */
public final class StandardsAttachmentUtil extends BrandStandardsUtil
{

    public static final int ATTACHMENT_TOCKENS_NUM = 8;

    public static final int ATTACHMENT_ID_INDX = 0;

    public static final int ATTACHMENT_TYPE_INDX = 1;

    public static final int ATTACHMENT_TITLE_INDX = 2;

    public static final int ATTACHMENT_NAME_INDX = 3;
    
    private static final Log LOG = LogFactoryUtil.getLog(StandardsAttachmentUtil.class);

    private static final boolean COMMUNITY_PERM = true;
    
    private static final boolean GUEST_PERM = false;

    /**
     * Private constructor.
     */
    private StandardsAttachmentUtil()
    {
    }

    /**
     * Process new and deleted supporting files.
     * 
     * @param resourceRequest - request
     * @param std - standard
     * @param userId - user id
     * @throws PortalException - exception
     * @throws SystemException - exception
     */
    public static void proseccSupportingFiles(final ResourceRequest resourceRequest, final Standards std, final long userId)
            throws PortalException, SystemException
    {

        final String delFileLinks = resourceRequest.getParameter("hidden_file_del_links");
        final List<Long> delAttachmentIds = getDeleteAttachments(delFileLinks);

        if (!StandardsUtil.isNullOrBlank(delAttachmentIds))
        {
            final ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
            deleteAttachments(delAttachmentIds, themeDisplay.getScopeGroupId(), std.getStdId());
        }
    }

    /**
     * Process new and deleted supporting files.
     * 
     * @param resourceRequest - request
     * @param request - upload request
     * @param std - standard
     * @param userId - user id
     * @throws PortalException - exception
     * @throws SystemException - exception
     */
    public static void proseccSupportingFiles(final ResourceRequest resourceRequest, final UploadPortletRequest request,
            final Standards std, final long userId) throws PortalException, SystemException
    {

        final String newFileLinks = request.getParameter("hidden_file_links");
        final String delFileLinks = request.getParameter("hidden_file_del_links");
        final String editFileLinks = request.getParameter(StandardsUtil.REQUEST_PARAM_HIDDEN_FILE_EDIT_LINKS);

        final Map<AttachmentsStandards, List<List>> newAttachments = getNewAttachments(newFileLinks, std.getStdId(), userId);
        final List<Long> delAttachmentIds = getDeleteAttachments(delFileLinks);
        final ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        if (!StandardsUtil.isNullOrBlank(newAttachments))
        {
            addStandardAttachments(resourceRequest, request, newAttachments, std, userId, themeDisplay.getScopeGroupId());
        }
        if (!StandardsUtil.isNullOrBlank(delAttachmentIds))
        {
            deleteAttachments(delAttachmentIds, themeDisplay.getScopeGroupId(), std.getStdId());
        }
        
        if(!editFileLinks.equals(StringPool.BLANK))
        {
        	updateAttachmentChainAndCountry(editFileLinks, userId);
        }
    }

    /**
     * Get new attachment from string.
     * 
     * @param attachments list of "~~~id:" separated attachments.
     * @param stdId - standard id
     * @param userId - user id
     * @return list of AttachmentsStandards
     * @throws SystemException 
     * @throws PortalException 
     */
    public static Map<AttachmentsStandards, List<List>> getNewAttachments(final String attachments, final long stdId, final long userId) throws PortalException, SystemException
    {

        Map<AttachmentsStandards, List<List>> newAttachments = null;
        if (!StandardsUtil.IsNullOrBlank(attachments))
        {
            newAttachments = new HashMap<AttachmentsStandards, List<List>>();
            final String[] attachmentArray = attachments.split("~~~id:");
            for (int i = 0; i < attachmentArray.length; i++)
            {
                getNewSubmittedAttachments(attachmentArray[i], newAttachments, stdId, userId);
            }
        }
        return newAttachments;
    }

    /**
     * Get "~~,|~~" separated attachments.
     * 
     * @param newAttachment - attachments
     * @param newAttachments - list of attachments
     * @param stdId - Standard Id
     * @param userId - user id
     * @throws SystemException 
     * @throws PortalException 
     */
    public static void getNewSubmittedAttachments(final String newAttachment, final Map<AttachmentsStandards, List<List>> newAttachments,
            final long stdId, final long userId) throws PortalException, SystemException
    {

        if (newAttachment != null && !newAttachment.isEmpty())
        {
            final String[] attachmentArray = newAttachment.split("~~,|~~");
			if (LOG.isDebugEnabled()) {
            	LOG.debug("newAttachment   " + newAttachment);
            	LOG.debug("attachmentArray  " + attachmentArray);
            	LOG.debug("attachmentArray Length  " + attachmentArray.length);
            }
            if (attachmentArray.length == ATTACHMENT_TOCKENS_NUM)
            {
                addAttachmentEntry(newAttachments, stdId, userId, attachmentArray);
            }
        }
    }

    /**
     * Add new attachment.
     * 
     * @param newAttachments - new attachments
     * @param stdId - record id
     * @param userId - user id
     * @param attachmentArray - array of attachments.
     * @throws SystemException 
     * @throws PortalException 
     */
    private static void addAttachmentEntry(final Map<AttachmentsStandards, List<List>> newAttachments, final long stdId, final long userId,
            final String[] attachmentArray) throws PortalException, SystemException
    {
        final Long extLinkId = Long.valueOf(attachmentArray[ATTACHMENT_ID_INDX]);
        if (extLinkId <= 0L)
        {
            final String type = attachmentArray[ATTACHMENT_TYPE_INDX];
            final String title = attachmentArray[ATTACHMENT_TITLE_INDX];
            if (!StandardsUtil.IsNullOrBlank(type) && !StandardsUtil.IsNullOrBlank(title))
            {

                final String langCode = attachmentArray[7];
                final AttachmentsStandards attachment = AttachmentsStandardsLocalServiceUtil
                        .createAttachmentsStandards(new AttachmentsStandardsPK(extLinkId, langCode));
                attachment.setType(type);
                attachment.setTitle(title);
                attachment.setTranslationIndicator("Y");
                attachment.setStdId(stdId);
                final String name = attachmentArray[ATTACHMENT_NAME_INDX];
                attachment.setAttachmentPath(name);
                attachment.setCreatorId(String.valueOf(userId));
                attachment.setCreatedDate(new Date());
                attachment.setUpdatedBy(String.valueOf(userId));
                attachment.setUpdatedDate(new Date());

                // Insert Chains Attachments.
                List<List> chainCountryList = new ArrayList<List>();
                final String chains = attachmentArray[4];
                if(!IsNullOrBlank(chains)) 
                {
                	List<ChainAttachmentsStandards> chainList = new ArrayList<ChainAttachmentsStandards>();
                	ChainAttachmentsStandards chainAttachmentsStandards = null;
                    String[] chainsArray = chains.split(StringPool.COMMA);
                    for(String chain : chainsArray)
                    {
                        chainAttachmentsStandards = getChainAttachmentsStandardsObject(0L, chain, langCode, userId) ;
                        chainList.add(chainAttachmentsStandards);
                    }
                    chainCountryList.add(chainList);
                }
                
                // Insert Country Attachments.
                final String country = attachmentArray[6];
                if(!IsNullOrBlank(country)) 
                {
                	List<AttachmentsStandardsCountry> countryList = new ArrayList<AttachmentsStandardsCountry>();
                	AttachmentsStandardsCountry countryAttachment =null;
                    String[] countryArray = country.split(StringPool.COMMA);
                    for(String countryCode : countryArray)
                    {
                    	countryAttachment = getAttachmentsStandardsCountryObject(0l, countryCode, langCode, userId) ;
                        countryList.add(countryAttachment);
                    }
                    chainCountryList.add(countryList);
                }
                
                newAttachments.put(attachment, chainCountryList);
            }
        }
    }

    /**
     * Get attachment ids to be deleted.
     * 
     * @param deleteAttachments - string with attachment ids
     * @return attachment ids to be deleted.
     */
    public static List<Long> getDeleteAttachments(final String deleteAttachments)
    {

        List<Long> deleteUrl = null;
        if (!StandardsUtil.IsNullOrBlank(deleteAttachments))
        {
            deleteUrl = new ArrayList<Long>();
            final String[] attachmentArray = deleteAttachments.split(StringPool.COMMA);
            for (int i = 0; i < attachmentArray.length; i++)
            {
                deleteUrl.add(Long.valueOf(attachmentArray[i]));
            }
        }
        return deleteUrl;
    }

    /**
     * Add attachment to a Standard.
     * 
     * @param resourceRequest -request
     * @param uploadRequest - upload request
     * @param newAttachments - new attachments
     * @param std - record
     * @param userId - user id
     * @param groupId - group id
     * @throws PortalException - exception
     * @throws SystemException - exception
     */
    public static void addStandardAttachments(final ResourceRequest resourceRequest, final UploadPortletRequest uploadRequest,
            final Map<AttachmentsStandards, List<List>> newAttachments, final Standards std, final long userId, final long groupId)
            throws PortalException, SystemException
    {
        //final char[] INVALID_CHARACTERS = 
        final ServiceContext serviceContext = ServiceContextFactory.getInstance(resourceRequest);
        
        for (AttachmentsStandards attachment : newAttachments.keySet())
        {
        	List<ChainAttachmentsStandards> chains = new ArrayList<ChainAttachmentsStandards>();
        	List<AttachmentsStandardsCountry> countries = new ArrayList<AttachmentsStandardsCountry>();
        	
        	if( newAttachments.get(attachment).size()>0)
        	{
        		chains = newAttachments.get(attachment).get(0);
        	}
        	if(newAttachments.get(attachment).size()>1)
        	{
        		countries = newAttachments.get(attachment).get(1);
        	}
            final String fileNameParam = attachment.getAttachmentPath();
            String fileName = uploadRequest.getFileName(fileNameParam);
            if (fileName != null)
            {
                final File file = uploadRequest.getFile(fileNameParam);
                if (LOG.isDebugEnabled()) {
                    LOG.debug("Supporting File Name = " + fileName + "  File size is " + (file == null ? "0" : file.length()));
                }
                // Change log must NOT exceed 75 characters. This is size of the CHANGELOG column in DLFILEVERSION table.
                String changeLog = "Added file: " + fileName;
                if (changeLog.length() > 75)
                {
                    changeLog = changeLog.substring(0, 74);
                }
                
                final String description = "Supporting file " + fileName;
                final DLFolder standardFolder = getDLFolder(groupId, userId, std, attachment.getType(), serviceContext);
                final long folderId = standardFolder.getFolderId();
                DLFileEntry dlfileEntry = null;
                FileEntry fileEntry = null;
                String mimeType = MimeTypesUtil.getContentType(file);
                long fileEntryTypeId = -1L;
                Map<String, Fields> fieldsMap = null;
                long size = uploadRequest.getSize("file");
                try{
                    serviceContext.setAddGroupPermissions(COMMUNITY_PERM);
                    //set guest permission to true
                    serviceContext.setAddGuestPermissions(true);
                    /*dlfileEntry = DLFileEntryLocalServiceUtil.addFileEntry(userId, groupId,
                            groupId, folderId, fileName, mimeType, fileName, description, changeLog,
                            fileEntryTypeId, fieldsMap, file,null ,file.length(), serviceContext);*/
                    fileEntry = DLAppLocalServiceUtil.addFileEntry(userId, groupId, folderId, fileName, mimeType, fileName,
                    		description, changeLog, file, serviceContext);
	                final String attachmentPath = "/documents/" + groupId + "/" + folderId + "/" + fileName;
	                attachment.setAttachmentPath(attachmentPath);
                } catch(DuplicateFileException dfe){                	
                    dlfileEntry= DLFileEntryLocalServiceUtil.getFileEntry(groupId, folderId, fileName); 
                    serviceContext.setAddGroupPermissions(COMMUNITY_PERM);
                    //set guest permission to true
                    serviceContext.setAddGuestPermissions(true);
                    DLAppLocalServiceUtil.updateFileEntry(userId, dlfileEntry.getFileEntryId(), fileName, mimeType, fileName, description, changeLog, false, file, serviceContext);
                    /*DLFileEntryLocalServiceUtil.updateFileEntry(userId, 
                            dlfileEntry.getFileEntryId(), fileName, mimeType, fileName, description, changeLog, false, fileEntryTypeId, fieldsMap, file, null, size, serviceContext);
                    */
                    final String attachmentPath = "/documents/" + groupId + "/" + folderId + "/" + fileName;
                    attachment.setAttachmentPath(attachmentPath);
                }
				//Change attachment type from 'GDLN' to 'GUIDELINE'
                if (StandardsUtil.STD_TYPE_GDLN.equals(attachment.getType())) {
                	attachment.setType(StandardsUtil.GUIDELINE_TYPE);
                }
                //End
                addFile(attachment);
            }
            // Check brands and add them.
            if(!isNullOrBlank(chains)){
                for(ChainAttachmentsStandards chain : chains)
                {
                    final long chainAttachmentId = CounterLocalServiceUtil.increment("ChainAttachmentsStandards");
                    chain.setChainAttachmentId(chainAttachmentId);
                    chain.setAttachmentId(attachment.getAttachmentId());
                    ChainAttachmentsStandardsLocalServiceUtil.addChainAttachmentsStandards(chain);
                }
            }
            
            // Check country and add them.
            if(!isNullOrBlank(countries)){
                for(AttachmentsStandardsCountry country : countries)
                {
                    country.setAttachmentId(attachment.getAttachmentId());
                    AttachmentsStandardsCountryLocalServiceUtil.addAttachmentsStandardsCountry(country);
                }
            }
            
        }
    }

    /**
     * Get Document Library Folder.
     * 
     * @param groupId - group id
     * @param userId - user id
     * @param std - Standard
     * @param attachmentType - attachment type
     * @param serviceContext - ServiceContext
     * @return Document Library Folder.
     * @throws PortalException - exception
     * @throws SystemException - exception
     */
    public static DLFolder getDLFolder(final long groupId, final long userId, final Standards std, final String attachmentType,
            final ServiceContext serviceContext) throws PortalException, SystemException
    {

        final DLFolder stdRootFolder = DLFolderLocalServiceUtil.getFolder(groupId, StandardsUtil.STANDARD_ROOT_PARENT_FOLDER_ID,
                StandardsUtil.STANDARD_ROOT_FOLDER_NAME);
        DLFolder folder;

        if (std.getStdTyp().equalsIgnoreCase(StandardsUtil.STD_TYPE_STANDARD))
        {
            folder = getFolder(groupId, userId, String.valueOf(std.getStdId()), serviceContext, stdRootFolder);
        }
        else
        {
            folder = getFolder(groupId, userId, String.valueOf(std.getParentId()), serviceContext, stdRootFolder);
            folder = getFolder(groupId, userId, String.valueOf(std.getStdId()), serviceContext, folder);
        }
        if (!std.getStdTyp().equalsIgnoreCase(StandardsUtil.STD_TYPE_GDLN))
        {
            folder = getFolder(groupId, userId, attachmentType, serviceContext, folder);
        }
        return folder;
    }

    /**
     * Get Document Library Folder.
     * 
     * @param groupId - group id
     * @param userId - user id
     * @param stdFolderName - folder name
     * @param serviceContext - ServiceContext
     * @param rootFolder - root folder
     * @return Document Library Folder.
     * @throws PortalException - exception
     * @throws SystemException - exception
     */
    public static DLFolder getFolder(final long groupId, final long userId, final String stdFolderName,
            final ServiceContext serviceContext, final DLFolder rootFolder) throws PortalException, SystemException
    {

        DLFolder folder;
        try
        {
            folder = DLFolderLocalServiceUtil.getFolder(groupId, rootFolder.getFolderId(), stdFolderName);
        }
        catch (NoSuchFolderException e)
        {
            final String stdFolderDesc = "Folder for Standard " + stdFolderName;
            serviceContext.setAddGroupPermissions(COMMUNITY_PERM);
            //set guest permission to true
            serviceContext.setAddGuestPermissions(true);
            folder = DLFolderLocalServiceUtil.addFolder(userId, groupId,groupId,false, rootFolder.getFolderId(), stdFolderName, stdFolderDesc,
                    false,serviceContext);
        }
        return folder;
    }

    /**
     * Add attachment to a Standard.
     * 
     * @param attchmntStandards - AttachmentsStandards
     * @throws SystemException - exception
     */
    public static void addFile(final AttachmentsStandards attchmntStandards) throws SystemException
    {

        final long attachmentId = CounterLocalServiceUtil.increment("AttachmentsStandards");
        attchmntStandards.setAttachmentId(attachmentId);
        attchmntStandards.setParentAttachmentId(attachmentId);
        AttachmentsStandardsLocalServiceUtil.addAttachmentsStandards(attchmntStandards);
    }

    /**
     * Delete attachment from a Standard.
     * 
     * @param delAttachmentIds - list of Delete attachment from a Standard. ids.
     * @param groupId - group id
     * @param stdId - Standard id
     * @throws PortalException - exception
     * @throws SystemException - exception
     */
    public static void deleteAttachments(final List<Long> delAttachmentIds, final long groupId, final long stdId)
            throws PortalException, SystemException
    {

        List<DLFileEntry> fileEntryList = null;
        final List<AttachmentsStandards> attchmntStandards = AttachmentsStandardsLocalServiceUtil
                .getAttachmentsStandardsByStandardId(stdId);

        for (Long attachmentId : delAttachmentIds)
        {
            final AttachmentsStandards attachment = getAttachment(attchmntStandards, attachmentId);
            final long folderId = getFolderId(attachment);
            String fileName = attachment.getAttachmentPath();
            fileName = fileName.substring(fileName.lastIndexOf('/') + 1);

            if (LOG.isDebugEnabled()) {
                LOG.debug("Delete file: groupId=" + groupId + " folderId=" + folderId + " fileName=" + fileName);
            }
            // folder Id will be same for all files, so we have to fetch it only ones
            if (fileEntryList == null)
            {
                fileEntryList = DLFileEntryLocalServiceUtil.getFileEntries(groupId, folderId);
            }
            final DLFileEntry fileEntry = getDLFileEntry(fileEntryList, fileName);
            deleteAttachment(attachment, fileEntry);
        }
    }

    /**
     * Delete attachment from a Standard.
     * 
     * @param attachment - attachment
     * @param fileEntry - Document Library file entry
     * @throws PortalException - exception
     * @throws SystemException - exception
     */
    public static void deleteAttachment(final AttachmentsStandards attachment, final DLFileEntry fileEntry)
            throws PortalException, SystemException
    {

//        if (fileEntry != null)
//        {
//            DLFileEntryLocalServiceUtil.deleteFileEntry(fileEntry);
//        }
    	List< AttachmentsStandardsCountry> countryList =  AttachmentsStandardsCountryLocalServiceUtil.getAttachmentsStandardsCountryByAttachmentId(attachment.getAttachmentId());
    	for ( AttachmentsStandardsCountry countryAttachment : countryList)
    	{
    		AttachmentsStandardsCountryLocalServiceUtil.deleteAttachmentsStandardsCountry(countryAttachment);
    	}
        AttachmentsStandardsLocalServiceUtil.deleteAttachmentsStandards(attachment);
    }

    /**
     * Get Document Library folder id.
     * 
     * @param attachment - attachment.
     * @return folder id.
     */
    public static long getFolderId(final AttachmentsStandards attachment)
    {

        // Path = "/documents/" + groupId + "/" + folderId + "/" + fileName;
        final String path = attachment.getAttachmentPath().replaceAll("^[*]*/?documents/[0-9]*/", "");
        final String folderId = path.substring(0, path.indexOf('/'));
        return Long.valueOf(folderId);
    }

    /**
     * Get Document Library File Entry.
     * 
     * @param fileEntries - list of DLFileEntry
     * @param fileName - file name
     * @return DLFileEntry
     */
    public static DLFileEntry getDLFileEntry(final List<DLFileEntry> fileEntries, final String fileName)
    {

        DLFileEntry fileEntry = null;
        if (fileEntries != null)
        {
            for (DLFileEntry entry : fileEntries)
            {
                if (fileName.equals(entry.getTitle()))
                {
                    fileEntry = entry;
                    break;
                }
            }
        }
        return fileEntry;
    }

    /**
     * Get attachments.
     * 
     * @param attchmntStandards - list of attachments.
     * @param attachmentId - attachment id
     * @return AttachmentsStandards
     */
    public static AttachmentsStandards getAttachment(final List<AttachmentsStandards> attchmntStandards, final Long attachmentId)
    {

        AttachmentsStandards attachment = null;
        for (AttachmentsStandards att : attchmntStandards)
        {
            if (att.getAttachmentId() == attachmentId)
            {
                attachment = att;
                break;
            }
        }
        return attachment;
    }
    
    /**
     * Update Attachment Brand and Country
     * @param editFileLinks
     * @param userId
     * @throws NumberFormatException
     * @throws SystemException
     * @throws PortalException 
     */
    private static void updateAttachmentChainAndCountry(String editFileLinks, long userId) throws NumberFormatException, SystemException, PortalException
    {
    	String fileArray[] = editFileLinks.split(StringPool.COMMA+StringPool.COMMA+StringPool.COMMA);
    	
    	
    	for(String fileAttchment : fileArray){
    		String row[] = fileAttchment.split("~~");
    		if (!row[1].equals("##")){ //for title
    			updateAttachmentTitle(row, userId);
    		}
    		if (!row[2].equals("##")){ //for Brand
    			updateAttachmentChain(row, userId);
    		}
    		if (!row[3].equals("##")) //for country
    		{
    			updateAttachmentCountry(row, userId);
    		}
    	}
    }
    
    /**
     * Update Attachment Brand
     * @param row
     * @param userId
     * @throws NumberFormatException
     * @throws SystemException
     */
    private static void updateAttachmentTitle(String row[], long userId) throws NumberFormatException, SystemException
    {
		System.out.println("Updating attachment  title :  " + row[0] + " :  " + row[1]);
		AttachmentsStandards attachment = AttachmentsStandardsLocalServiceUtil.getAttchmentByAttachmendId(Long.valueOf(row[0]));
		attachment.setTitle(row[1]);
		AttachmentsStandardsLocalServiceUtil.updateAttachmentsStandards(attachment);
		System.out.println("Done Updating attachment  title :  ");
		
    }
    
    /**
     * Update Attachment Brand
     * @param row
     * @param userId
     * @throws NumberFormatException
     * @throws SystemException
     */
    private static void updateAttachmentChain(String row[], long userId) throws NumberFormatException, SystemException
    {
    	List<ChainAttachmentsStandards> attachmentChainList = new ArrayList<ChainAttachmentsStandards>();
    	ChainAttachmentsStandards chainAttachment = ChainAttachmentsStandardsLocalServiceUtil.getChainAttachmentsStandardsObject();
    	attachmentChainList = ChainAttachmentsStandardsLocalServiceUtil.getChainAttachmentsStandardsByAttachmentId(Long.valueOf(row[0]));
		for(ChainAttachmentsStandards stdChainAttachment : attachmentChainList){
    			if (row[2].contains(stdChainAttachment.getChainCode())){
    				row[2] = row[2].replace(stdChainAttachment.getChainCode(), "##");
    			} else {
    				ChainAttachmentsStandardsLocalServiceUtil.deleteChainAttachmentsStandards(stdChainAttachment);
    			}
		}
		for(String chain :  row[2].split(StringPool.COMMA)){
			if (!chain.equals("##")){
				chainAttachment = getChainAttachmentsStandardsObject(Long.valueOf(row[0]), chain, BrandStandardsUtil.DEFAULT_LOCALE, userId) ;
				chainAttachment.setChainAttachmentId(CounterLocalServiceUtil.increment("ChainAttachmentsStandards"));
    			ChainAttachmentsStandardsLocalServiceUtil.addChainAttachmentsStandards(chainAttachment);
			}
		}
    }
    
    /**
     * Update Attachment Country
     * @param row
     * @param userId
     * @throws NumberFormatException
     * @throws SystemException
     * @throws PortalException 
     */
    private static void updateAttachmentCountry(String row[], long userId) throws NumberFormatException, SystemException, PortalException
    {
    	List<AttachmentsStandardsCountry> countryList = new ArrayList<AttachmentsStandardsCountry>();
    	AttachmentsStandardsCountry countryAttachment =  null;
    	countryList = AttachmentsStandardsCountryLocalServiceUtil.getAttachmentsStandardsCountryByAttachmentId(Long.valueOf(row[0]));
		for(AttachmentsStandardsCountry countryAttchament : countryList){
    			if (row[3].contains(countryAttchament.getCountryCode())){
    				row[3] = row[3].replace(countryAttchament.getCountryCode(), "##");
    			} else {
    				AttachmentsStandardsCountryLocalServiceUtil.deleteAttachmentsStandardsCountry(countryAttchament);
    			}
		}
		for(String country :  row[3].split(StringPool.COMMA)){
			if (!country.equals("##")){
				countryAttachment = getAttachmentsStandardsCountryObject(Long.valueOf(row[0]), country, BrandStandardsUtil.DEFAULT_LOCALE,userId);  
    			AttachmentsStandardsCountryLocalServiceUtil.addAttachmentsStandardsCountry(countryAttachment);
			}
		}
    }
    
    /**
     * Create AttachmentsStandardsCountry Object
     * @param attachmentId
     * @param country
     * @param localeCode
     * @param userId
     * @return AttachmentsStandardsCountry
     * @throws SystemException 
     * @throws PortalException 
     */
    private static AttachmentsStandardsCountry getAttachmentsStandardsCountryObject(long attachmentId, String country, String localeCode, long userId) throws PortalException, SystemException
    {
    	AttachmentsStandardsCountryPK attachmentsStandardsCountryPK = new AttachmentsStandardsCountryPK(attachmentId, country, localeCode);
    	AttachmentsStandardsCountry countryAttachment =  AttachmentsStandardsCountryLocalServiceUtil.createAttachmentsStandardsCountry(attachmentsStandardsCountryPK);
		countryAttachment.setAttachmentId(attachmentId);
		countryAttachment.setCountryCode(country);
		countryAttachment.setLocaleCode(localeCode);
		countryAttachment.setCreatorId(String.valueOf(userId));
		countryAttachment.setCreatedDate(new Date());
		countryAttachment.setUpdatedBy(String.valueOf(userId));
		countryAttachment.setUpdatedDate(new Date());
		
		return countryAttachment;
    }
    
    /**
     * Create ChainAttachmentsStandards Object
     * @param attachmentId
     * @param chain
     * @param localeCode
     * @param userId
     * @return ChainAttachmentsStandards
     */
    private static ChainAttachmentsStandards getChainAttachmentsStandardsObject(long attachmentId, String chain, String localeCode, long userId)
    {
    	ChainAttachmentsStandards chainAttachment = ChainAttachmentsStandardsLocalServiceUtil.getChainAttachmentsStandardsObject();
		chainAttachment.setAttachmentId(attachmentId);
		chainAttachment.setChainCode(chain);
		chainAttachment.setLocaleCode(localeCode);
		chainAttachment.setCreatorId(String.valueOf(userId));
		chainAttachment.setCreatedDate(new Date());
		chainAttachment.setUpdatedBy(String.valueOf(userId));
		chainAttachment.setUpdatedDate(new Date());
		return chainAttachment;
    }
}
