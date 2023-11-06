/**
 * ©2014 IHG. All rights reserved.
 */
package com.ihg.me2.brandstandards.custom.application;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ihg.brandstandards.custom.model.ExternalLinks;
import com.ihg.brandstandards.custom.model.Standard;
import com.ihg.brandstandards.custom.model.StdAttachments;
import com.ihg.brandstandards.custom.model.StdImage;
import com.ihg.brandstandards.db.service.PublishStdLocalServiceUtil;
import com.ihg.me2.brandstandards.custom.pojo.StandardsSearchCriteria;
import com.ihg.me2.brandstandards.custom.util.BrandStandardsConstant;
import com.ihg.me2.brandstandards.custom.util.QueryUtils;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;

/**
 * <a href="AttachmentApplicationImpl.java.html"><b><i>View Source</i></b></a>.
 * 
 * @project: Brand Standards.
 * @author chintan.akhani
 */
public class AttachmentApplicationImpl extends ApplicationImpl implements AttachmentsApplication
{

    private static final Log LOG = LogFactoryUtil.getLog(AttachmentApplicationImpl.class);

    /**
     * @param stdId - long object
     * @param locale - String object
     * @param brand - String object
     * @param countryCode - String object
     * @param environment - String object
     * @param criteria - StandardsSearchCriteria object
     * @return List<StdImage>
     */
    public List<StdImage> getAssociatedImages(long stdId, String locale, String brand, String countryCode, String environment,
            StandardsSearchCriteria criteria)
    {

        String query;
        if (BrandStandardsConstant.ENVIRONMENT_PROD.equalsIgnoreCase(environment))
        {
            query = QueryUtils.getRelatedImages(stdId, locale, countryCode);
        }
        else
        {
            query = QueryUtils.getRelatedImagesForStaging(stdId, locale, countryCode);
        }
        List results = PublishStdLocalServiceUtil.getAssociatedStds(query);
        List<StdImage> images = new ArrayList<StdImage>();
        StdImage image = null;
        for (int i = 0; i < results.size(); i++)
        {
            image = new StdImage();
            Object[] obj = (Object[]) results.get(i);
            long stdImageId = ((BigDecimal) obj[0]).longValue();
            long igImageId = ((BigDecimal) obj[1]).longValue();
            String imageName = (String) obj[2];
            long parentImageId = GetterUtil.getLong(StringPool.BLANK + obj[3]);
            String imageStatus = (String) obj[4];
            String imageLocale = (String) obj[6];
            image.setImageTitle(imageName);
            try
            {
                //IGImage igImage = IGImageLocalServiceUtil.getIGImage(igImageId);
                DLFileEntry igImage = DLFileEntryLocalServiceUtil.getDLFileEntry(igImageId);
                image.setImageDescription(igImage.getDescription());
                //image.setImageSize(StringPool.BLANK + igImage.getImageSize());
                image.setImageSize(StringPool.BLANK + igImage.getSize());
                image.setImageId(igImageId);
                image.setStdImageId(stdImageId);
                image.setUuid(igImage.getUuid());
                image.setGroupId(igImage.getGroupId());
                image.setImageStatus(imageStatus);
                image.setImageParentId(parentImageId);
                image.setLocale(imageLocale);
                addStandardImage(images, image, parentImageId, imageLocale);
            }
            catch (PortalException e)
            {
                LOG.error(e.getMessage(), e);
            }
            catch (SystemException e)
            {
                LOG.error(e.getMessage(), e);
            }
        }
        return images;
    }

    /**
     * @param stdId - long object
     * @param locale - String object
     * @param brand - String object
     * @param countryCode - String object
     * @param environment - String object
     * @param criteria - StandardsSearchCriteria object
     * @return Standard
     */
    public Standard getAllsupportingMaterial(long publishId, long stdId, String locale, String brand, String countryCode, String environment,
            StandardsSearchCriteria criteria)
    {

        String query = generateSupportingMaterialQuery(publishId, stdId, locale, brand, countryCode, environment, criteria);
        Standard standard = new Standard();
        if (Validator.isNotNull(query))
        {
            List results = PublishStdLocalServiceUtil.getAssociatedStds(query);

            Map<String, List<StdAttachments>> attachments = new HashMap<String, List<StdAttachments>>();
            List<Long> attachParentId = new ArrayList<Long>();
            List<ExternalLinks> links = new ArrayList<ExternalLinks>();
            List<Long> linksParentId = new ArrayList<Long>();
            StdAttachments stdAttachment = null;
            ExternalLinks extLinks = null;
            if (Validator.isNotNull(results))
            {
                for (int i = 0; i < results.size(); i++)
                {
                    Object[] obj = (Object[]) results.get(i);
                    if (obj[2] != null)
                    {
                        stdAttachment = new StdAttachments();
                        setAttachments(obj, stdAttachment, attachments, locale, attachParentId);
                    }
                    if (obj[10] != null)
                    {
                        extLinks = new ExternalLinks();
                        setExtLinks(obj, extLinks, links, locale, linksParentId);
                    }
                }
                standard.setAttachments(attachments);
                standard.setExternalLinks(links);
            }
            if (LOG.isDebugEnabled())
            {
                LOG.debug("attachments :" + attachments.size());
                LOG.debug("externalLinks :" + links.size());
            }
        }
        return standard;
    }

    /**
     * @param publishId - publication id
     * @param stdId - long object
     * @param locale - String object
     * @param brand - String object
     * @param countryCode - String object
     * @param environment - String object
     * @param criteria - StandardsSearchCriteria object
     * @return String
     */
    public static String generateSupportingMaterialQuery(long publishId, long stdId, String locale, String brand, String countryCode,
            String environment, StandardsSearchCriteria criteria)
    {
        String query = null;
        if (BrandStandardsConstant.ENVIRONMENT_PROD.equalsIgnoreCase(environment))
        {
            if (stdId != 0l)
            {
                query = QueryUtils.getSupportingMaterial(publishId, stdId, locale, countryCode);
            }
            else
            {
                query = QueryUtils.generateSearchQueryForAllSupportingMaterial(publishId, locale, brand, countryCode, criteria);
            }
        }
        else
        {
            if (stdId != 0l)
            {
                query = QueryUtils.getStagingSupportingMaterial(publishId, stdId, locale, countryCode);
            }
            else
            {
                query = QueryUtils.generateSearchQueryForStagingSupportingMaterial(publishId, locale, brand, countryCode, criteria);
            }
        }
        return query;
    }

    /**
     * @param obj - Object[]
     * @param externalLink - ExternalLinks object
     * @param links - List<ExternalLinks> object
     */
    private void setExtLinks(Object[] obj, ExternalLinks externalLink, List<ExternalLinks> links, String userLocale, List<Long> linkParentId)
    {

        long extlLinkId = ((BigDecimal) obj[10]).longValue();
        String extlLinkTitle = (String) obj[11];
        String extlLinkURL = (String) obj[12];
        String extLinkStatus = (String) obj[14];
        String locale = (String) obj[15];
        long standardId = ((BigDecimal) obj[9]).longValue();
        long parentId = GetterUtil.getLong(StringPool.BLANK + obj[13]);
        if (LOG.isDebugEnabled())
        {
            LOG.debug("parent id of externallink is :" + parentId);
        }
        if (Validator.isNotNull(extlLinkTitle) && Validator.isNotNull(extlLinkURL))
        {
            externalLink.setExternalLinkId(extlLinkId);
            externalLink.setExternalLink(extlLinkTitle);
            externalLink.setExternalURL(extlLinkURL);
            externalLink.setExternalLinkStatus(extLinkStatus);
            externalLink.setStandardId(standardId);
            externalLink.setExternalLinkParentId(parentId);
            externalLink.setLocale(locale);
            addExternalLink(links, externalLink, parentId, locale, extlLinkId, userLocale, linkParentId);
        }
    }

    /**
     * @param obj - Object[]
     * @param attachment - StdAttachments object
     * @param attachmentList - List<StdAttachments>> object
     */
    private void setAttachments(Object[] obj, StdAttachments attachment, Map<String, List<StdAttachments>> attachmentList, String userLocale, List<Long> attachParentId)
    {

        List<StdAttachments> attachments = null;
        String attachmentPath = (String) obj[5];
        long attachmentId = ((BigDecimal) obj[2]).longValue();
        String attachmentType = (String) obj[3];
        String attachmentName = (String) obj[4];
        String status = (String) obj[7];
        String locale = (String) obj[8];
        long standardID = ((BigDecimal) obj[1]).longValue();
        long parentId = GetterUtil.getLong(StringPool.BLANK + obj[6]);
        if (LOG.isDebugEnabled())
        {
            LOG.debug("parent id of attachment is :" + parentId);
        }
        if (Validator.isNotNull(attachmentName))
        {
            String attachmentExt = StringPool.BLANK;
            if (Validator.isNotNull(attachmentPath))
            {
            	attachment.setAttachmentLink(attachmentPath);
            	DLFileEntry fileEntry = getDocumentObject(attachmentPath);
                if (Validator.isNotNull(fileEntry))
                {
                    attachmentExt = fileEntry.getExtension().toUpperCase();
                    attachment.setDlFileEntryId(fileEntry.getFileEntryId());
                    attachment.setFileSize(fileEntry.getSize() / BrandStandardsConstant.FILE_SIZE_MB);
                    attachment.setAttachmentLink(generateDownloadURL(fileEntry));
                }
            }
            attachment.setAttachmentName(attachmentName);
            attachment.setAttachmentId(attachmentId);
            attachment.setAttachmentStatus(status);
            attachment.setLocale(locale);
            attachment.setAttachmentType(attachmentType);
            attachment.setAttachmentExt(attachmentExt);
            attachment.setStandardId(standardID);
            attachment.setAttachmentParentId(parentId);

            if (attachmentList.containsKey(attachmentType))
            {
            	if(!isAttachmentExist(attachmentList.get(attachmentType), parentId, locale, attachmentId, userLocale, attachParentId)){
            		attachmentList.get(attachmentType).add(attachment);
            		attachParentId.add(parentId);
            	}
            }
            else
            {
                attachments = new ArrayList<StdAttachments>();
                attachments.add(attachment);
                attachmentList.put(attachmentType, attachments);
                attachParentId.add(parentId);
            }
        }
    }

    /**
     * @param path - String object
     * @return DLFileEntry
     */
    private DLFileEntry getDocumentObject(String path)
    {
        String[] parts = StringUtil.split(path, StringPool.FORWARD_SLASH);
        long groupId = Long.parseLong(parts[2]);
        long folderId = Long.parseLong(parts[3]);
        String docName = parts[4];
        DLFileEntry fileEntry = null;
        try
        {
            //fileEntry = DLFileEntryLocalServiceUtil.getFileEntryByTitle(groupId, folderId, docName);
            fileEntry = DLFileEntryLocalServiceUtil.getFileEntry(groupId, folderId, docName);
        }
        catch (PortalException e)
        {
            LOG.error(e.getMessage(), e);
        }
        catch (SystemException e)
        {
            LOG.error(e.getMessage(), e);
        }
        return fileEntry;
    }

    /**
     * get encoded document url.
     * 
     * @param path - String object
     * @return String
     */
    private String generateDownloadURL(DLFileEntry fileEntry)
    {
        StringBuilder fileEntryLink = new StringBuilder();
        fileEntryLink.append(StringPool.SLASH);
        fileEntryLink.append(BrandStandardsConstant.ATTACHMENT_PATH).append(StringPool.SLASH);
        fileEntryLink.append(fileEntry.getGroupId()).append(StringPool.SLASH);
        fileEntryLink.append(fileEntry.getUuid());
        return fileEntryLink.toString();
    }

    /**
     * @param attachments - List<StdAttachments> object
     * @param parentId - long object
     * @param locale - String object
     * @param attachmentId - long object
     * @return boolean
     */
    private boolean isAttachmentExist(List<StdAttachments> attachments, long parentId, String locale, long attachmentId, String userLocale, List<Long> attachParentId)
    {
        boolean isRecordExist = false;
        
        for (StdAttachments attach : attachments)
        {
            if (attach.getAttachmentParentId() == parentId && userLocale.equalsIgnoreCase(attach.getLocale()))
            {
            	isRecordExist = true;
                break;
            }
            else if(attach.getAttachmentParentId() == parentId && userLocale.equalsIgnoreCase(locale))
            {
            	attachments.remove(attach);
            	isRecordExist = false;
            	break;
            }
            else if(!attachParentId.contains(parentId)){
            	isRecordExist = false;
            	break;
            }
        }
        
        return isRecordExist;
    }

    /**
     * @param links - List<ExternalLinks> object
     * @param parentId - long object
     * @param newLink - ExternalLinks object
     * @param locale - String object
     * @param externalLinkId - long object
     */
    private void addExternalLink(List<ExternalLinks> links, ExternalLinks newLink, long parentId, String locale,
            long externalLinkId, String userLocale, List<Long> linkParentId)
    {
        
        if(links.size() > 0 && !links.isEmpty())
        {
        	for (ExternalLinks link : links)
        	{
	            if (link.getExternalLinkParentId() == parentId && link.getLocale().equalsIgnoreCase(userLocale))
	            {
	                break;
	            }
	            else if(link.getExternalLinkParentId() == parentId && locale.equalsIgnoreCase(userLocale)){
	            	links.remove(link);
	            	links.add(newLink);
	            	linkParentId.add(newLink.getExternalLinkParentId());
	            	break;
	            }
	            else if(!linkParentId.contains(parentId)){
	            	links.add(newLink);
	            	linkParentId.add(newLink.getExternalLinkParentId());
	            	break;
	            }
        	}
        }
        else{
        	links.add(newLink);
        	linkParentId.add(newLink.getExternalLinkParentId());
        }
        
    }

    /**
     * @param images - List<StdImage> object
     * @param newImage - StdImage object
     * @param parentId - long object
     * @param locale - String object
     */
    private void addStandardImage(List<StdImage> images, StdImage newImage, long parentId, String locale)
    {
        boolean isRecordExist = false;
        if (!"en_GB".equalsIgnoreCase(locale))
        {
            for (StdImage image : images)
            {
                if (image.getImageParentId() == parentId && "en_GB".equalsIgnoreCase(image.getLocale()))//image.getImageParentId() == image.getStdImageId())
                {
                    images.remove(image);
                    break;
                }
            }
            images.add(newImage);
        }
        else
        {
            for (StdImage image : images)
            {
                if (image.getImageParentId() == parentId)
                {
                    isRecordExist = true;
                    break;
                }
            }
            if (!isRecordExist)
            {
                images.add(newImage);
            }
        }

    }
}
