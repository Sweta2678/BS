/**
 * ©2014 IHG. All rights reserved.
 */
package com.ihg.brandstandards.bridge.application.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;

import com.ihg.brandstandards.application.impl.CommonApplicationImpl;
import com.ihg.brandstandards.bridge.application.BridgeApplication;
import com.ihg.brandstandards.bridge.util.BrandStandardsUtil;
import com.ihg.brandstandards.bridge.util.BridgeConstants;
import com.ihg.brandstandards.bridge.util.BridgeQueryUtils;
import com.ihg.brandstandards.custom.model.ExternalLinks;
import com.ihg.brandstandards.custom.model.Standard;
import com.ihg.brandstandards.custom.model.StdAttachments;
import com.ihg.brandstandards.custom.model.StdImage;
import com.ihg.brandstandards.db.NoSuchPublishQueueException;
import com.ihg.brandstandards.db.model.Publication;
import com.ihg.brandstandards.db.model.PublishQueue;
import com.ihg.brandstandards.db.model.PublishStandardsExt;
import com.ihg.brandstandards.db.service.BridgePublishLangLocalServiceUtil;
import com.ihg.brandstandards.db.service.BridgePublishLocalServiceUtil;
import com.ihg.brandstandards.db.service.PublicationLocalServiceUtil;
import com.ihg.brandstandards.db.service.PublishQueueLocalServiceUtil;
import com.ihg.brandstandards.db.service.PublishStandardsExtLocalServiceUtil;
import com.ihg.brandstandards.db.service.PublishStdLocalServiceUtil;
import com.ihg.brandstandards.util.BSCommonConstants;
import com.ihg.brandstandards.util.StandardsSortableUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;

/**
 * <a href="BridgeApplicationImpl.java.html"><b><i>View Source</i></b></a>.
 * 
 * @project: Brand Standards Bridge.
 * @author MUMMANL
 */
public class BridgeApplicationImpl extends CommonApplicationImpl implements BridgeApplication
{
    private static final Log LOG = LogFactoryUtil.getLog(BridgeApplicationImpl.class);
    
    /**
     * @param brandCode String object
     * @param request PortletRequest object
     * @return Map<String,List<Publish>
     */
    public Map<String,List<Publication>> getAllPublicationRecords(String brandCode, PortletRequest request)
    {
        List<Publication> publishList = PublicationLocalServiceUtil.getAllPublicationsByBrand(brandCode);
        Map<String,List<Publication>> publishMap = new HashMap<String, List<Publication>>();
        publishMap.put("bridge", new ArrayList<Publication>());
        publishMap.put("bridgeArchive", new ArrayList<Publication>());
        publishMap.put("staging", new ArrayList<Publication>());
        publishMap.put("production", new ArrayList<Publication>());
        PublishQueue  publishQueue = null;
        //Sort publication list, make a copy of read only list to a new list
        List<Publication> sortPublishList = new ArrayList<Publication>();
        if (Validator.isNotNull(publishList)) {
        	sortPublishList.addAll(publishList);
        }
        Collections.sort(sortPublishList, new PublicationSortById());
        for (Publication publish : sortPublishList) 
        {
        	publishQueue = null;
        	
        	if (!BridgeConstants.PUBLISH_ACTIVE_STATUS_CODE.equals(publish.getPublishStatCd()) && BSCommonConstants.PUBLISH_ENV_STAGING.equals(publish.getPublishEnvName())) 
        	{
        		publishMap.get("staging").add(publish);
        	}
        	else if (BridgeConstants.PUBLISH_ARCHIVE_STATUS_CODE.equals(publish.getPublishStatCd()) && BSCommonConstants.PUBLISH_ENV_BRIDGE.equals(publish.getPublishEnvName()))
        	{
        	    publishMap.get("bridgeArchive").add(publish);
        	}
        	else if (BridgeConstants.PUBLISH_ACTIVE_STATUS_CODE.equals(publish.getPublishStatCd()) && !BSCommonConstants.PUBLISH_ENV_PROD.equals(publish.getPublishEnvName()))
            {
                if (BSCommonConstants.PUBLISH_ENV_BRIDGE.equals(publish.getPublishEnvName())) 
                {
                    publishMap.get("bridge").add(publish);
                }
                else if (BSCommonConstants.PUBLISH_ENV_STAGING.equals(publish.getPublishEnvName())) 
                {
                	publishQueue = getPublishQueueObject(publish.getPublishId(), 0l);
                	if (publishQueue != null && BridgeConstants.QUEUE_NEW_STATUS.equals(publishQueue.getQueueStatCd()))
                	{
                		request.setAttribute("isRecordInProcess", true);
                	} 
                	else 
                	{
                		request.setAttribute("isRecordInProcess", false);
                	}
                	publishMap.get("staging").add(publish);
                }
            }
        	else if (BSCommonConstants.PUBLISH_ENV_PROD.equals(publish.getPublishEnvName()) && !BridgeConstants.PUBLISH_PURGE_STATUS_CODE.equals(publish.getPublishStatCd())) 
            {
            		publishQueue = getPublishQueueObject(publish.getPublishId(), 0l);
            		if (publishQueue != null) 
            		{
            			publish.setPublishDate(publishQueue.getSchedulePublish());
            		}
            		publishMap.get("production").add(publish);
            } 
        }
        return publishMap;
    }

    /**
     * @param publishId The bridge publish id
     * @param regionId The region id
     * @param statIndText The status indicator text
     */
    public List<Standard> getStandardsForProgressViewDetails(Publication publish, long regionId, String viewType, String localeCode, String statIndText)
    {
    	List<PublishStandardsExt> arlDisplayResults = BridgePublishLocalServiceUtil.getProgressViewDetailsStandards(publish.getPublishId(),
                regionId, publish.getChainCode(), publish.getPublishDate(), localeCode, statIndText);
        if("IndexTranslationView".equals(viewType)){
        	return populateIndexesIntoStandards(arlDisplayResults);
        } if(BridgeConstants.VIEW_TYP_NOFITICATION.equals(viewType)){
        	return populateNotificationsIntoStandards(arlDisplayResults, statIndText);
        } else {
        	return getProgressViewDetailSortedStandards(arlDisplayResults, statIndText);
        }
    }
    
    public List<Standard> populateNotificationsIntoStandards(List<PublishStandardsExt> errNotifications, String statIndText)
    {
    	List<Standard> displayErrNotifications = new ArrayList<Standard>();
    	for (PublishStandardsExt notification : errNotifications)
        {
    		Standard std = getStandardsModel(notification);
    		if(!BridgeConstants.STAT_IND_ALL_NOFITICATION.equals(statIndText)) {
	    		/**Replacing new line characters with <br> html tag to display on web*/
	    		std.setTaxonomyDesc(std.getTaxonomyDesc().replaceAll("\\r\\n|\\r|\\n", "<br>"));
    		}
    		displayErrNotifications.add(std);
        }
    	return displayErrNotifications;
    }
    
    public List<Standard> populateIndexesIntoStandards(List<PublishStandardsExt> arlDisplayResults)
    {
    	List<Standard> indexList = new ArrayList<Standard>();
    	for (PublishStandardsExt stdExt : arlDisplayResults)
        {
    		Standard std = getStandardsModel(stdExt);
    		indexList.add(std);
        }
    	return indexList;
    }
    
    
    /**
     * @param publishId The bridge publish id
     * @param regionId The region id
     * @param statIndText The status indicator text
     */
    public List<Standard> getProgressViewDetailSortedStandards(List<PublishStandardsExt> arlDisplayResults, String statIndText)
    {
        if (arlDisplayResults.isEmpty())
        {
            return new ArrayList<Standard>();
        }
        
        List<Standard> standardsLst = new ArrayList<Standard>();
        List<Standard> stdSpecGdln = new ArrayList<Standard>();
        List<Long> stdIdLst = new ArrayList<Long>();

        for (PublishStandardsExt stdExt : arlDisplayResults)
        {
            if (!stdIdLst.contains(stdExt.getStdId()))
            {
                stdIdLst.add(stdExt.getStdId());
                Standard std = getStandardsModel(stdExt);
                if (BSCommonConstants.STD_TYPE_STANDARD.equals(stdExt.getStdTyp()))
                {
                    standardsLst.add(std);
                }
                else //if (BrandStandardsUtil.STD_TYPE_SPEC.equals(stdExt.getStdTyp()))
                {
                    stdSpecGdln.add(std);
                }
            } else {
            	if(Validator.isNotNull(statIndText)){
            		if(BSCommonConstants.STD_TYPE_STANDARD.equals(stdExt.getStdTyp())){
            			for(Standard std : standardsLst){
    	            		if(updateStdMetadata(statIndText, stdExt, std)){
    	            			break;
    	            		}
                		}
            		} else {
            			for(Standard std : stdSpecGdln){
            				if(updateStdMetadata(statIndText, stdExt, std)){
            					break;
            				}
                		}
            		}
            		
            	}
            }
        }

        updateIndexOrder(standardsLst);
        List<Standard> sortedStandards = sortRecords(standardsLst);
        for (Standard std : sortedStandards)
        {
            List<Standard> specLst = std.getSpecifications();
            List<Standard> gdlnLst = std.getGuidelines();
            boolean recAdded = false;
            
            for (Standard item : stdSpecGdln)
            {
                if (std.getStdId() == item.getParentStdId())
                {
                    if (BSCommonConstants.STD_TYPE_SPEC.equals(item.getStdType()))
                    {
                        specLst.add(item);
                    }
                    else if (BSCommonConstants.STD_TYPE_GDLN.equals(item.getStdType()))
                    {
                        gdlnLst.add(item);
                    }
                    recAdded = true;
                }
            }
            
            if (recAdded)
            {
                cleanup(stdSpecGdln, specLst);
                cleanup(stdSpecGdln, gdlnLst);
            }
            Collections.sort(specLst, new StandardsSortableUtil.StandardSortBySTDId());
            Collections.sort(gdlnLst, new StandardsSortableUtil.StandardSortBySTDId());
        }
            
        return sortedStandards;
    }

	private boolean updateStdMetadata(String statIndText,
			PublishStandardsExt stdExt, Standard std) {
		boolean updated = false;
		if(std.getStdId() == stdExt.getStdId()){
			if(BridgeConstants.STAT_IND_MISS_TRANS_ATTACH.equalsIgnoreCase(statIndText)){
				String attachmentList = std.getAttachmentList();
				if(Validator.isNotNull(attachmentList)){
					attachmentList = attachmentList+";;; "+stdExt.getAttachmentList();
				} else {
					attachmentList = stdExt.getAttachmentList();
				}
				
				String attachmentListXlat = std.getAttachmentListXlat();
				if(Validator.isNotNull(attachmentListXlat)){
					attachmentListXlat = attachmentListXlat + ";;; "+stdExt.getAttachmentListXlat();
				} else {
					attachmentListXlat = stdExt.getAttachmentListXlat();
				}
				
				std.setAttachmentList(attachmentList);
				std.setAttachmentListXlat(attachmentListXlat);
				updated = true;
			} else if(BridgeConstants.STAT_IND_MISS_TRANS_LINKS.equalsIgnoreCase(statIndText)){
				String linkList = std.getLinkList();
				if(Validator.isNotNull(linkList)){
					linkList = linkList+";;; "+stdExt.getLinkList();
				} else {
					linkList = stdExt.getLinkList();
				}
				
				String linkListXlat = std.getLinkListXlat();
				if(Validator.isNotNull(linkListXlat)){
					linkListXlat = linkListXlat + ";;; "+stdExt.getLinkListXlat();
				} else {
					linkListXlat = stdExt.getLinkListXlat();
				}
				
				std.setLinkList(linkList);
				std.setLinkListXlat(linkListXlat);
				updated = true;
			} else if(BridgeConstants.STAT_IND_MISS_TRANS_IMAGES.equalsIgnoreCase(statIndText)){
				String imageList = std.getImageList();
				if(Validator.isNotNull(imageList)){
					imageList = imageList+";;; "+stdExt.getImageList();
				} else {
					imageList = stdExt.getImageList();
				}
				
				String imageListXlat = std.getImageListXlat();
				if(Validator.isNotNull(imageListXlat)){
					imageListXlat = imageListXlat + ";;; "+stdExt.getImageListXlat();
				} else {
					imageListXlat = stdExt.getImageListXlat();
				}
				
				std.setImageList(imageList);
				std.setImageListXlat(imageListXlat);
				updated = true;
			}
		}
		return  updated;
	}
    
    /**
     * @param publishId The bridge publish id
     * @param regionId The region id
     * @param statIndText The status indicator text
     */
    public List<Standard> getSortedStandards(List<PublishStandardsExt> arlDisplayResults)
    {
        if (arlDisplayResults.isEmpty())
        {
            return new ArrayList<Standard>();
        }
        
        List<Standard> standardsLst = new ArrayList<Standard>();
        List<Standard> stdSpecGdln = new ArrayList<Standard>();
        List<Long> stdIdLst = new ArrayList<Long>();

        for (PublishStandardsExt stdExt : arlDisplayResults)
        {
            if (!stdIdLst.contains(stdExt.getStdId()))
            {
                stdIdLst.add(stdExt.getStdId());
                Standard std = getStandardsModel(stdExt);
                if (BSCommonConstants.STD_TYPE_STANDARD.equals(stdExt.getStdTyp()))
                {
                    standardsLst.add(std);
                }
                else //if (BrandStandardsUtil.STD_TYPE_SPEC.equals(stdExt.getStdTyp()))
                {
                    stdSpecGdln.add(std);
                }
            }
        }

        updateIndexOrder(standardsLst);
        List<Standard> sortedStandards = sortRecords(standardsLst);
        for (Standard std : sortedStandards)
        {
            List<Standard> specLst = std.getSpecifications();
            List<Standard> gdlnLst = std.getGuidelines();
            boolean recAdded = false;
            
            for (Standard item : stdSpecGdln)
            {
                if (std.getStdId() == item.getParentStdId())
                {
                    if (BSCommonConstants.STD_TYPE_SPEC.equals(item.getStdType()))
                    {
                        specLst.add(item);
                    }
                    else if (BSCommonConstants.STD_TYPE_GDLN.equals(item.getStdType()))
                    {
                        gdlnLst.add(item);
                    }
                    recAdded = true;
                }
            }
            
            if (recAdded)
            {
                cleanup(stdSpecGdln, specLst);
                cleanup(stdSpecGdln, gdlnLst);
            }
            Collections.sort(specLst, new StandardsSortableUtil.StandardSortBySTDId());
            Collections.sort(gdlnLst, new StandardsSortableUtil.StandardSortBySTDId());
        }
            
        return sortedStandards;
    }
    
    /**
     * Remove unwanted items from collection.
     * @param stdLst original list
     * @param rmStdLst unwanted items list
     */
    private void cleanup(List<Standard> stdLst, List<Standard> rmStdLst)
    {
        for (Standard item : rmStdLst)
        {
            stdLst.remove(item);
        }
    }

    /**
     * Populate Standards model.
     * @param stdExt model
     * @return Standards model.
     */
    private Standard getStandardsModel(PublishStandardsExt stdExt)
    {
        Standard std = new Standard();
        std.setIndexOrder(stdExt.getIndexOrder());
        std.setTaxonomyId(stdExt.getTaxonomyId());
        std.setParentTaxonomyId(stdExt.getParentTaxonomyId());
        std.setLevel(stdExt.getIndexLvl());
        std.setIndexSortOrder(stdExt.getLevelSortOrder());
        std.setTaxonomyPath(stdExt.getTaxonomyPath());
        std.setTaxonomyText(stdExt.getIndexTitle());
        std.setIndexTitleXlat(stdExt.getIndexTitleXlat());
        std.setTaxonomyDesc(stdExt.getIndexDescription());
        std.setPublishStdId(stdExt.getStdId());
        std.setPublishId(stdExt.getPublishId());
        std.setStdId(stdExt.getStdId());
        std.setParentStdId(stdExt.getParentPublishId());
        std.setTitle(stdExt.getTitle());
        std.setStdTitleXlat(stdExt.getStdTitleXlat());
        std.setDescription(stdExt.getDescription());
        std.setStdType(stdExt.getStdTyp());
        std.setStatus(stdExt.getStatus());
        std.setDisplayOrder(stdExt.getSortOrder());
        std.setCategory(stdExt.getCategory());
        std.setManual(stdExt.getManual());
        std.setRemovable(stdExt.isRemovable());

        std.setAttachmentList(stdExt.getAttachmentList());
        std.setAttachmentListXlat(stdExt.getAttachmentListXlat());
        std.setLinkList(stdExt.getLinkList());
        std.setLinkListXlat(stdExt.getLinkListXlat());
        std.setImageList(stdExt.getImageList());
        std.setImageListXlat(stdExt.getImageListXlat());
        
        String indexPath = stdExt.getTaxonomyPath();
        if (indexPath != null && indexPath.contains(stdExt.getIndexTitle())) 
        {
            indexPath = indexPath.replace(stdExt.getIndexTitle(), "");
        }
        std.setCurrentPath(indexPath);
        std.setCurrentTitle(stdExt.getIndexTitle());
        std.setExpiredStdId(stdExt.getExpiredStdId());
        std.setRegionCode(stdExt.getRegionCode());
        std.setIsGlobal(stdExt.getIsGlobal());
        std.setFramework(stdExt.getFramework());
        std.setComplDate(stdExt.getImplDate());
       
        String date = stdExt.getCmplDateStr();
        if (!BrandStandardsUtil.IsNullOrBlank(date))
        {
            std.setComplDateStr(date);
        }
        else if (stdExt.getImplDate() != null)
        {
            date = BridgeConstants.DEFAULT_DATE_FORMATTER.format(stdExt.getImplDate());
            std.setComplDateStr(date);
        }
        
        date = stdExt.getExpiryDateStr();
        if (!BrandStandardsUtil.IsNullOrBlank(date))
        {
            std.setExpiryDate(date);
        }
        else if (stdExt.getExpiryDate() != null)
        {
            date = BridgeConstants.DEFAULT_DATE_FORMATTER.format(stdExt.getExpiryDate());
            std.setExpiryDate(date);
        }

        return std;
    }

    /**
     * @param standards -Standards List
     * @param chainCd -Brand Code
     * @param environment - Environment information
     * @throws SystemException throws System Exception
     */
    public void updateIndexOrder(List<Standard> standards)
    {
        final List<PublishStandardsExt> indexes = PublishStandardsExtLocalServiceUtil.getCMSAllIndexes();
        final Map<Long, PublishStandardsExt> indexMap = new HashMap<Long, PublishStandardsExt>();
        for (PublishStandardsExt indx : indexes)
        {
            if (indx.getPublishTaxonomyId() > 1L)
            {
                indexMap.put(indx.getPublishTaxonomyId(), indx);
            }
        }
        if (LOG.isDebugEnabled())
        {
            LOG.debug("indexMap contains : " + indexMap.size());
        }

        for (Standard std : standards)
        {
            PublishStandardsExt rec = indexMap.get(std.getTaxonomyId());
            if (rec != null)
            {
                std.setIndexOrder(rec.getIndexOrder());
            }
        }
    }

    /**
     * Sort records.
     * 
     * @param standards -Standard List
     * @return returns List of standards
     */
    public List<Standard> sortRecords(List<Standard> standards)
    {
        sortRecordsByIndex(standards);
        return sortStdRecordsUnderIndex(standards);
    }

    /**
     * Sort records.
     * 
     * @param standards -Standard List
     */
    public void sortRecordsByIndex(List<Standard> standards)
    {
        Collections.sort(standards, new Comparator<Standard>()
        {
            public int compare(Standard s1, Standard s2)
            {
                int res = compareLong(s1.getIndexOrder(), s2.getIndexOrder());
                if (res == 0)
                {
                    if (s1.getStdId() == 0 && s2.getStdId() == 0)
                    {
                        return 0;
                    }
                    res = compareLong(s1.getParentStdId(), s2.getParentStdId());
                    if (res == 0)
                    {
                        res = compareRecordType(s2.getStdType(), s1.getStdType());
                        if (res == 0)
                        {
                            if (s1.getDisplayOrder() > 0L || s2.getDisplayOrder() > 0L)
                            {
                                res = compareLong(s1.getDisplayOrder(), s2.getDisplayOrder());
                            }
                            else
                            {
                                res = compareLong(s1.getStdId(), s2.getStdId());
                            }
                        }
                    }
                }
                return res;
            }

            /**
             * Compare long values.
             * 
             * @param v1 - value 1
             * @param v2 - value 2
             * @return 1, 0, -1
             */
            private int compareLong(long v1, long v2)
            {
                if (v1 > v2)
                {
                    return 1;
                }
                else if (v1 < v2)
                {
                    return -1;
                }
                else
                {
                    return 0;
                }
            }

            /**
             * Compare long values.
             * 
             * @param t1 - record type 1
             * @param t2 - record type 2
             * @return 1, 0, -1
             */
            private int compareRecordType(String t1, String t2)
            {
                if (t1 != null && t2 != null)
                {
                    if (BSCommonConstants.STD_TYPE_STANDARD.equals(t1) && !BSCommonConstants.STD_TYPE_STANDARD.equals(t2))
                    {
                        return 1;
                    }
                    else if (!BSCommonConstants.STD_TYPE_STANDARD.equals(t1) && BSCommonConstants.STD_TYPE_STANDARD.equals(t2))
                    {
                        return -1;
                    }
                    else if (BSCommonConstants.STD_TYPE_STANDARD.equals(t1) && BSCommonConstants.STD_TYPE_STANDARD.equals(t2))
                    {
                        return 0;
                    }
                    else if (BSCommonConstants.STD_TYPE_SPEC.equals(t1) && !BSCommonConstants.STD_TYPE_SPEC.equals(t2))
                    {
                        return 1;
                    }
                    else if (!BSCommonConstants.STD_TYPE_SPEC.equals(t1) && BSCommonConstants.STD_TYPE_SPEC.equals(t2))
                    {
                        return -1;
                    }
                    else if (BSCommonConstants.STD_TYPE_SPEC.equals(t1) && BSCommonConstants.STD_TYPE_SPEC.equals(t2))
                    {
                        return 0;
                    }
                    else if (BSCommonConstants.STD_TYPE_GDLN.equals(t1) && BSCommonConstants.STD_TYPE_GDLN.equals(t2))
                    {
                        return 0;
                    }
                    else if (BSCommonConstants.STD_TYPE_GDLN.equals(t1) && !BSCommonConstants.STD_TYPE_GDLN.equals(t2))
                    {
                        return 1;
                    }
                    else if (!BSCommonConstants.STD_TYPE_GDLN.equals(t1) && BSCommonConstants.STD_TYPE_GDLN.equals(t2))
                    {
                        return -1;
                    }
                }
                else if (t1 != null && t2 == null)
                {
                    return 1;
                }
                else if (t1 == null && t2 != null)
                {
                    return -1;
                }
                return 0;
            }
        });
    }

    /**
     * Sort Standards Under each Index by specified sort order.
     * 
     * @param standards -Standard List
     * @return returns List of standards
     */
    public List<Standard> sortStdRecordsUnderIndex(List<Standard> standards)
    {
        Map<Long, Map<Long, List<Standard>>> indexRecords = new LinkedHashMap<Long, Map<Long, List<Standard>>>();

        for (Standard std : standards)
        {
            Map<Long, List<Standard>> indexItem = indexRecords.get(std.getTaxonomyId());
            // no Index found
            if (indexItem == null)
            {
                // create map to store Standard
                indexItem = new LinkedHashMap<Long, List<Standard>>();
                List<Standard> stdItem = new ArrayList<Standard>();
                stdItem.add(std);
                indexItem.put(std.getStdId(), stdItem);
                // create Index item with Standard
                indexRecords.put(std.getTaxonomyId(), indexItem);
            }
            // found Index; add Standard, Specification or Guideline
            else
            {
                List<Standard> stdItem = indexItem.get(std.getParentStdId());
                // this is should be Standard. For Specification and Guideline stdItem should NOT be null
                if (stdItem == null)
                {
                    stdItem = new ArrayList<Standard>();
                    indexItem.put(std.getStdId(), stdItem);
                }
                stdItem.add(std);
            }
        }

        List<Standard> sortedList = new ArrayList<Standard>();
        List<Standard> tmpList = new ArrayList<Standard>();
        for (Map.Entry<Long, Map<Long, List<Standard>>> indexEntry : indexRecords.entrySet())
        {
            tmpList.clear();
            // Standards for Index  === <prnt_std_id, list of Records> first records is a Standard
            Map<Long, List<Standard>> stdRecords = indexEntry.getValue();
            for (Map.Entry<Long, List<Standard>> stdEntry : stdRecords.entrySet())
            {
                List<Standard> recordsList = stdEntry.getValue();
                if (recordsList != null && !recordsList.isEmpty())
                {
                    for (Standard rec : recordsList)
                    {
                        //Standards rec = recordsList.get(0);
                        if (BSCommonConstants.STD_TYPE_STANDARD.equals(rec.getStdType()))
                        {
                            tmpList.add(rec);
                        }
                        else
                        {
                            LOG.error("Found ==" + rec.getStdType() + " in index 0, publish std id=" + rec.getStdId());
                        }
                    }
                }
            }

            sortStdBySortOrder(tmpList);
            for (Standard std : tmpList)
            {
                List<Standard> stdItems = stdRecords.get(std.getStdId());
                sortedList.addAll(stdItems);
            }
        }
        return sortedList;
    }

    /**
     * Sort records by Display order.
     * 
     * @param standards -Standard List
     */
    private void sortStdBySortOrder(List<Standard> standards)
    {
        Collections.sort(standards, new Comparator<Standard>()
        {
        	public int compare(Standard s1, Standard s2)
            {
            	int res = 0;
            	if (s1.getDisplayOrder() ==  s2.getDisplayOrder() && s1.getDisplayOrder() > 0 && s2.getDisplayOrder() > 0)
                {
                    res = 0;
                }
                else if (s1.getDisplayOrder() > s2.getDisplayOrder() && s1.getDisplayOrder() > 0 && s2.getDisplayOrder() > 0)
                {
                	res = 1;
                } else if (s1.getDisplayOrder() == 0 && s2.getDisplayOrder() == 0){
                	res = compareLong(s1.getStdId(), s2.getStdId());
                } else if (s1.getDisplayOrder() > s2.getDisplayOrder() && s2.getDisplayOrder()  == 0)
                {
                	res = compareLong(s2.getDisplayOrder(), s1.getDisplayOrder());
                } else if (s2.getDisplayOrder() > s1.getDisplayOrder() && s1.getDisplayOrder()  == 0)
                {
                	res = compareLong(s2.getDisplayOrder(), s1.getDisplayOrder());
                } 
                else {
                	res = -1;
                }
            	
            	return res;
            }

            /**
             * Compare long values.
             * 
             * @param v1 - value 1
             * @param v2 - value 2
             * @return 1, 0, -1
             */
            private int compareLong(long v1, long v2)
            {
                if (v1 > v2)
                {
                    return 1;
                }
                else if (v1 < v2)
                {
                    return -1;
                }
                else
                {
                    return 0;
                }
            }

        });
    }

    /**
     * This method will a list of standards which are not translated.
     * @param publishId The bridge publish id.
     * @param regionId The region id.
     * @param localeCode The slocale code.
     */
    public List<Standard> getStandardsForTranslationViewDetails(long publishId, long regionId, String localeCode)
    {
        @SuppressWarnings("rawtypes")
        List displayResults = BridgePublishLocalServiceUtil.getTranslationViewDetailsStandards(publishId, regionId, localeCode);
        List<Standard> standardDisplayList = new ArrayList<Standard>();
        List<Standard> queryResultList = new ArrayList<Standard>();
        if(displayResults != null && !displayResults.isEmpty())
        {
            for (int i = 0; i < displayResults.size(); i++)
            {
                Object[] obj = (Object[]) displayResults.get(i);
                if (obj != null && obj.length > 0)
                {
                    Standard standard = new Standard();
                    standard.setIndexOrder(((BigDecimal) obj[0]).longValue());
                    standard.setTaxonomyId(((BigDecimal) obj[1]).longValue());
                    standard.setParentTaxonomyId(((BigDecimal) obj[2]).longValue());
                    standard.setLevel(((BigDecimal) obj[3]).longValue());
                    standard.setIndexSortOrder(((BigDecimal) obj[4]).longValue());
                    standard.setStdId(((BigDecimal) obj[5]).longValue());
                    standard.setParentStdId(((BigDecimal) obj[6]).longValue());
                    standard.setStdType((String) obj[7]);
                    standard.setDisplayOrder(((BigDecimal) obj[8]).longValue());
                    standard.setTextTranslated(((BigDecimal) obj[9]).longValue() > 0 ? false : true);
                    standard.setAttchmentsTranslated(((BigDecimal) obj[10]).longValue() > 0 ? false : true);
                    standard.setImagesTranslated(((BigDecimal) obj[11]).longValue() > 0 ? false : true);
                    standard.setLinksTranslated(((BigDecimal) obj[12]).longValue() > 0 ? false : true);
                    queryResultList.add(standard);
                    if (BSCommonConstants.STD_TYPE_STANDARD.equals(standard.getStdType()))
                    {
                        standardDisplayList.add(standard);
                    }
                }
            }
        }
        
        updateIndexOrder(standardDisplayList);
        List<Standard> sortedStandards = sortRecords(standardDisplayList);
        
        for (Standard sortedStandard : sortedStandards)
        {
            List<Standard> arlSpecs = new ArrayList<Standard>();
            List<Standard> arlGdlns = new ArrayList<Standard>();
            for (Standard standard : queryResultList)
            {
                if (standard.getParentStdId() == sortedStandard.getStdId())
                {
                    Standard specsOrGdln = new Standard();
                    specsOrGdln.setPublishStdId(standard.getStdId());
                    specsOrGdln.setStdId(standard.getStdId());
                    specsOrGdln.setParentStdId(standard.getParentStdId());
                    specsOrGdln.setStdType(standard.getStdType());
                    specsOrGdln.setDisplayOrder(standard.getIndexSortOrder());
                    specsOrGdln.setTextTranslated(standard.isTextTranslated());
                    specsOrGdln.setImagesTranslated(standard.isImagesTranslated());
                    specsOrGdln.setAttchmentsTranslated(standard.isAttchmentsTranslated());
                    specsOrGdln.setLinksTranslated(standard.isLinksTranslated());
                    if (BSCommonConstants.STD_TYPE_SPEC.equals(standard.getStdType()))
                    {
                        arlSpecs.add(specsOrGdln);
                    }
                    else if (BSCommonConstants.STD_TYPE_GDLN.equals(standard.getStdType()))
                    {
                        arlGdlns.add(specsOrGdln);
                    }
                }
            }
            Collections.sort(arlSpecs, new StandardsSortableUtil.StandardSortBySTDId());
            Collections.sort(arlGdlns, new StandardsSortableUtil.StandardSortBySTDId());
            sortedStandard.setSpecifications(arlSpecs);
            sortedStandard.setGuidelines(arlGdlns);
        }
        return sortedStandards;
    }
    
    public List<Standard> getUnpublishedStandardsViewDetails(long publishId, long regionId, String chainCode, String regionCode, String stdIds)
    {
        List<Standard> arlDisplayStandards = new ArrayList<Standard>();
        List<PublishStandardsExt> arlDisplayResults = new ArrayList<PublishStandardsExt>();
        try
        {
            BridgePublishLangLocalServiceUtil.clearCache();
        }
        catch (Exception e)
        {
            LOG.warn("Failed to clear Bridge Publish Cache !");
        }
        arlDisplayResults = BridgePublishLocalServiceUtil.getUnpublishedDetailsStandards(publishId, regionId, chainCode, regionCode, stdIds);

        for (PublishStandardsExt publishStd : arlDisplayResults)
        {
            Standard standards = new Standard();
            if (BSCommonConstants.STD_TYPE_STANDARD.equals(publishStd.getStdTyp()))
            {
                standards.setTaxonomyId(publishStd.getTaxonomyId());
                standards.setTaxonomyPath(publishStd.getTaxonomyPath());
                standards.setTaxonomyText(publishStd.getIndexTitle());
                standards.setIndexOrder(publishStd.getIndexOrder());
                standards.setParentTaxonomyId(publishStd.getParentTaxonomyId());
                standards.setIndexSortOrder(publishStd.getLevelSortOrder());
                standards.setLevel(publishStd.getIndexLvl());
                standards.setPublishStdId(publishStd.getStdId());
                standards.setStdId(publishStd.getStdId());
                standards.setPubParentStdId(publishStd.getParentPublishId());
                standards.setTitle(publishStd.getTitle());
                standards.setDescription(publishStd.getDescription());
                standards.setStdType(publishStd.getStdTyp());
                standards.setStatus(publishStd.getStatus());
                standards.setDisplayOrder(publishStd.getSortOrder());
                standards.setFramework(publishStd.getFramework());
                standards.setIsGlobal(publishStd.getIsGlobal());
                standards.setRegionCode(publishStd.getRegionCode());
                standards.setCurRegion(publishStd.getRegion());
                arlDisplayStandards.add(standards);
                
            }
        }

        updateIndexOrder(arlDisplayStandards);
        List<Standard> sortedStandards = sortRecords(arlDisplayStandards);
        for (Standard standards : sortedStandards)
        {
            List<Standard> arlSpecs = new ArrayList<Standard>();
            List<Standard> arlGdlns = new ArrayList<Standard>();
            for (PublishStandardsExt publishStd : arlDisplayResults)
            {
                if (standards.getPublishStdId() == publishStd.getParentPublishId())
                {
                    Standard specs = new Standard();
                    specs.setPublishStdId(publishStd.getStdId());
                    specs.setStdId(publishStd.getStdId());
                    specs.setParentStdId(publishStd.getParentPublishId());
                    specs.setTitle(publishStd.getTitle());
                    specs.setDescription(publishStd.getDescription());
                    specs.setStdType(publishStd.getStdTyp());
                    specs.setStatus(publishStd.getStatus());
                    specs.setDisplayOrder(publishStd.getSortOrder());
                    specs.setFramework(publishStd.getFramework());
                    specs.setIsGlobal(publishStd.getIsGlobal());
                    specs.setRegionCode(publishStd.getRegionCode());
                    specs.setCurRegion(publishStd.getRegion());
                    if (BSCommonConstants.STD_TYPE_SPEC.equals(publishStd.getStdTyp()))
                    {
                        arlSpecs.add(specs);
                    }
                    else if (BSCommonConstants.STD_TYPE_GDLN.equals(publishStd.getStdTyp()))
                    {
                        arlGdlns.add(specs);
                    }
                }
            }
            Collections.sort(arlSpecs, new StandardsSortableUtil.StandardSortBySTDId());
            Collections.sort(arlGdlns, new StandardsSortableUtil.StandardSortBySTDId());
            standards.setSpecifications(arlSpecs);
            standards.setGuidelines(arlGdlns);
        }
        return sortedStandards;
    }
    
    /**
     * 
     * @param publishId
     * @return PublishQueue
     */
    public PublishQueue getPublishQueueObject (long publishId, long publishQueueId) {
    	PublishQueue publishQueue = null;
    	try {
			if (publishId != 0l) {
				publishQueue = PublishQueueLocalServiceUtil.findPublishQueueByPublishId(publishId);
			} else if (publishQueueId != 0l) {
				publishQueue = PublishQueueLocalServiceUtil.getPublishQueue(publishQueueId);
			}
		} catch (NoSuchPublishQueueException e) {
			LOG.debug("No Publication found for publishId = " + publishId + " publishQueueId = " + publishQueueId);
		} catch (SystemException e) {
			LOG.error(StackTraceUtil.getStackTrace(e));
		} catch (PortalException e) {
			LOG.error(StackTraceUtil.getStackTrace(e));
		}
    	return publishQueue;
    }
    
    /**
     * @author Chintan
     */
    class PublicationSortById implements Comparator<Publication>
    {
        /**
         * @param o1 - Publication objects.
         * @param o2 - Publication objects.
         * @return integer.
         */
        public int compare(Publication o1, Publication o2)
        {
        	return o2.getCreatedDate().compareTo(o1.getCreatedDate());
        }
    }


	@Override
	public List<StdImage> getAssociatedImages(long stdId, String locale,
			String brand, String countryCode) {
		String query = StringPool.BLANK;
        query = BridgeQueryUtils.getRelatedImages(stdId, locale, brand, countryCode);
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
            String imageLocale = (String) obj[5];
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
                image.setImageStatus(StringPool.BLANK);
                image.setImageParentId(parentImageId);
                image.setLocale(imageLocale);
                images.add(image);
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
    public Standard getAllsupportingMaterial(long stdId, String locale, String brand, String countryCode)
    {

        String query = BridgeQueryUtils.getSupportingMaterial(stdId, locale, brand, countryCode);
        Standard standard = new Standard();
        if (Validator.isNotNull(query))
        {
            List results = PublishStdLocalServiceUtil.getAssociatedStds(query);

            Map<String, List<StdAttachments>> attachments = new HashMap<String, List<StdAttachments>>();
            List<ExternalLinks> links = new ArrayList<ExternalLinks>();
            StdAttachments stdAttachment = null;
            ExternalLinks extLinks = null;
            if (Validator.isNotNull(results))
            {
                for (int i = 0; i < results.size(); i++)
                {
                    Object[] obj = (Object[]) results.get(i);
                    if (obj[1] != null)
                    {
                        stdAttachment = new StdAttachments();
                        setAttachments(obj, stdAttachment, attachments);
                    }
                    if (obj[9] != null)
                    {
                        extLinks = new ExternalLinks();
                        setExtLinks(obj, extLinks, links);
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
     * @param obj - Object[]
     * @param attachment - StdAttachments object
     * @param attachmentList - List<StdAttachments>> object
     */
    private void setAttachments(Object[] obj, StdAttachments attachment, Map<String, List<StdAttachments>> attachmentList)
    {

        List<StdAttachments> attachments = null;
        String attachmentPath = (String) obj[4];
        long attachmentId = ((BigDecimal) obj[1]).longValue();
        String attachmentType = (String) obj[2];
        String attachmentName = (String) obj[3];
        String status = StringPool.BLANK;
        String locale = (String) obj[6];
        long standardID = ((BigDecimal) obj[0]).longValue();
        long parentId = GetterUtil.getLong(StringPool.BLANK + obj[5]);
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
                    attachment.setFileSize(fileEntry.getSize() / BridgeConstants.FILE_SIZE_MB);
                    attachment.setAttachmentLink(generateDownloadURL(attachmentPath));
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

            if (attachmentList.containsKey(attachmentType)
                    && !isAttachmentExist(attachmentList.get(attachmentType), parentId, locale, attachmentId))
            {
                attachmentList.get(attachmentType).add(attachment);
            }
            else if (attachmentList.containsKey(attachmentType)
                    && isAttachmentExist(attachmentList.get(attachmentType), parentId, locale, attachmentId))
            {
                if (parentId != attachmentId)
                {
                    attachmentList.get(attachmentType).add(attachment);
                }
            }
            else
            {
                attachments = new ArrayList<StdAttachments>();
                attachments.add(attachment);
                attachmentList.put(attachmentType, attachments);
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
    private String generateDownloadURL(String path)
    {
        String[] parts = StringUtil.split(path, StringPool.FORWARD_SLASH);
        String docName = parts[4];
        StringBuffer fileEntryLink = new StringBuffer();
        if (Validator.isNotNull(docName))
        {
            docName = HttpUtil.encodeURL(HtmlUtil.unescape(docName));
        }
        fileEntryLink.append(parts[0]).append(StringPool.SLASH);
        fileEntryLink.append(parts[1]).append(StringPool.SLASH);
        fileEntryLink.append(parts[2]).append(StringPool.SLASH);
        fileEntryLink.append(parts[3]).append(StringPool.SLASH);
        fileEntryLink.append(docName);
        return fileEntryLink.toString();
    }

    /**
     * @param attachments - List<StdAttachments> object
     * @param parentId - long object
     * @param locale - String object
     * @param attachmentId - long object
     * @return boolean
     */
    private boolean isAttachmentExist(List<StdAttachments> attachments, long parentId, String locale, long attachmentId)
    {
        boolean isRecordExist = false;
        for (StdAttachments attach : attachments)
        {
            if (attach.getAttachmentParentId() == parentId)
            {
                isRecordExist = true;
                if (parentId != attachmentId)
                {
                    attachments.remove(attach);
                }
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
            long externalLinkId)
    {
        boolean isRecordExist = false;
        for (ExternalLinks link : links)
        {
            if (link.getExternalLinkParentId() == parentId)
            {
                isRecordExist = true;
                break;
            }
        }
        if (!isRecordExist)
        {
            links.add(newLink);
        }
    }
    
    /**
     * @param obj - Object[]
     * @param externalLink - ExternalLinks object
     * @param links - List<ExternalLinks> object
     */
    private void setExtLinks(Object[] obj, ExternalLinks externalLink, List<ExternalLinks> links)
    {

        long extlLinkId = ((BigDecimal) obj[8]).longValue();
        String extlLinkTitle = (String) obj[9];
        String extlLinkURL = (String) obj[10];
        String extLinkStatus = StringPool.BLANK;
        String locale = (String) obj[12];
        long standardId = ((BigDecimal) obj[7]).longValue();
        long parentId = GetterUtil.getLong(StringPool.BLANK + obj[11]);
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
            addExternalLink(links, externalLink, parentId, locale, extlLinkId);
        }
    }
    
}
