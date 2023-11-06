package com.ihg.brandstandards.bridge.processor.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ihg.brandstandards.bridge.util.BridgeConstants;
import com.ihg.brandstandards.db.model.ErrNotification;
import com.ihg.brandstandards.db.model.Publication;
import com.ihg.brandstandards.db.service.BridgePublishImportLocalServiceUtil;
import com.ihg.brandstandards.db.service.BridgePublishLocalServiceUtil;
import com.ihg.brandstandards.db.service.ErrNotificationLocalServiceUtil;
import com.ihg.brandstandards.db.service.JobQueueLocalServiceUtil;
import com.ihg.brandstandards.db.service.PublicationLocalServiceUtil;
import com.ihg.brandstandards.db.service.PublishQueueLocalServiceUtil;
import com.ihg.brandstandards.gem.util.GemConstants;
import com.ihg.brandstandards.util.BSCommonConstants;
import com.ihg.brandstandards.util.BSCommonUtil;
import com.ihg.brandstandards.util.BrandStandardsUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;

public class CMSToBridgeUpdater
{
    private static final Log LOG = LogFactoryUtil.getLog(CMSToBridgeUpdater.class); 

    public void processNotifications(List<ErrNotification> notifications)
    {
        Map<Long,Set<Long>> modifiedPublications = new HashMap<Long, Set<Long>>();
    	// process notifications 
        for (ErrNotification notification : notifications)
        {
            String type = notification.getTitle();
            long stdId = notification.getReferenceId();

            LOG.debug("Processing notification id: " + notification.getNotificationId() + " STD_ID: " + stdId + " type: " + type);

            if (BSCommonConstants.REQ_TYPE_UPD_COUNTRIES.equals(type))
            {
                updateBridgeCountries(stdId, notification, modifiedPublications);
                deleteNotification(notification);
            }
            else if (BSCommonConstants.REQ_TYPE_UPD_STATE.equals(type))
            {
                updateBridgeState(stdId, notification, modifiedPublications);
                deleteNotification(notification);
            }
            else if (BSCommonConstants.REQ_TYPE_UPD_COUNTRIES_AND_STATE.equals(type))
            {
                updateBridgeCountries(stdId, notification, modifiedPublications);
                updateBridgeState(stdId, notification, modifiedPublications);
                deleteNotification(notification);
            }
            else
            {
                LOG.warn("UNKNOWN NOTIFICATION type: " + type + " on notification id: " + notification.getNotificationId());
            }
        }
        //Create a request to re-generate unique groups
        if (modifiedPublications.size() > 0) {
        	createUniqueGroupRequest(modifiedPublications);
        }
    }

    /**
     * Update state for specified Standard.
     * @param stdId  standard id
     * @param notification ErrNotification
     */
    private void updateBridgeState(long stdId, ErrNotification notification, Map<Long, Set<Long>> modifiedPublications)
    {
        long publishId = notification.getPublishId(); 
        long regionId = notification.getRegionId();
        //Add publication and region into map
        updatePublicationRegionMapping(publishId, regionId, stdId, modifiedPublications);
        LOG.debug("Update Bridge COUNTRIES STATE for notification id: " + notification.getNotificationId() + " STD_ID: " + stdId + 
                " publishId: " + publishId + " regionId: " + regionId);
        BridgePublishImportLocalServiceUtil.updateStdCountriesState(publishId, stdId, regionId, notification.getCreatorId());
    }

    /**
     * Update countries for specified Standard.
     * @param stdId standard id
     * @param notification ErrNotification
     */
    private void updateBridgeCountries(long stdId, ErrNotification notification, Map<Long, Set<Long>> modifiedPublications)
    {
        long publishId = notification.getPublishId(); 
        long regionId = notification.getRegionId();
        //Add publication and region into map
        updatePublicationRegionMapping(publishId, regionId, stdId, modifiedPublications);
        LOG.debug("Update Bridge COUNTRIES for notification id: " + notification.getNotificationId() + " STD_ID: " + stdId + 
                " publishId: " + publishId + " regionId: " + regionId);
        BridgePublishImportLocalServiceUtil.updateGlobalRegionalStdCountries(publishId, stdId, regionId, notification.getCreatorId());
    }

    /**
     * Delete notification.
     * @param notification ErrNotification
     */
    private void deleteNotification(ErrNotification notification)
    {
        LOG.debug("Deleting notification id: " + notification.getNotificationId() + " type: " + notification.getComponentName());
        try
        {
            ErrNotificationLocalServiceUtil.deleteErrNotification(notification);
        }
        catch (SystemException e)
        {
            LOG.error("Failed to delete notification id: " + notification.getNotificationId(), e);
        }
    }
    
    /**
     * 
     * @param modifiedPublications
     */
    private void createUniqueGroupRequest (Map<Long, Set<Long>> modifiedPublications) {
    	
    	String groupType = BridgeConstants.BRIDGE_GROUPS_TYPE;
    	long publishId = 0l;
    	Set <Long> regionList = null;
    	if (LOG.isDebugEnabled()) {
    		LOG.debug("Re-generate unique groups :"+modifiedPublications);
    	}
    	for (Map.Entry<Long, Set<Long>> entry : modifiedPublications.entrySet()) {
    		publishId = entry.getKey();
    		regionList = entry.getValue();
    		for (long regionId : regionList) {
    			String regionCode = BrandStandardsUtil.getRegionCode(regionId);
    			try {
    				Publication publication  = PublicationLocalServiceUtil.getPublication(publishId);
    				long userId = GetterUtil.getLong(publication.getCreatorId());
    				String compareMetadata = generateMetadata(publication.getChainCode(), regionCode, 
    	                regionId, publishId, groupType, StringPool.PERCENT);
    				//If job queue request is in queue then do not create new request
    				if (!JobQueueLocalServiceUtil.isJobQueueExistWithSameMetadata(compareMetadata, StringPool.PERCENT, 
    						BridgeConstants.JOB_TYPE_COUNTRY_GROUP, BridgeConstants.QUEUE_NEW_STATUS)) {
    						User user = UserLocalServiceUtil.getUser(userId);
    						createNotification(publishId, regionId, user, GemConstants.JOB_TYPE_COUNTRY_GROUP, groupType);
    						PublishQueueLocalServiceUtil.createReport(compareMetadata, user.getScreenName(), 
    	                		user.getEmailAddress(), null, GemConstants.JOB_TYPE_COUNTRY_GROUP);
    	            } 
    			}
    	        catch (Exception e) {
    	                LOG.error(StackTraceUtil.getStackTrace(e));
    	        }
    	      }
    			
    		}
    	}
    
    /**
     * 
     * @param brandCode
     * @param regionCode
     * @param regionId
     * @param publishId
     * @param userFullName
     * @param screenName
     * @param email
     * @return StringBuilder
     */
    protected String generateMetadata(String brandCode, String regionCode, long regionId, long publishId, String groupType, String userFullName)
    {
        Map<String, String> metadataParams = new LinkedHashMap<String, String>();
        //Generate Map
        metadataParams.put(BridgeConstants.METADATA_PARAM_ENVIRONMENT, BridgeConstants.BRIDGE_ENVIRONMENT);
        metadataParams.put(BridgeConstants.METADATA_PARAM_BRIDGE_PUBLISH_ID, String.valueOf(publishId));
        metadataParams.put(BridgeConstants.METADATA_PARAM_CHAIN_CD, brandCode);
        metadataParams.put(BridgeConstants.METADATA_PARAM_REGION_CD, regionCode);
        metadataParams.put(BridgeConstants.METADATA_PARAM_REGION_ID, String.valueOf(regionId));
        metadataParams.put(BridgeConstants.METADATA_PARAM_GROUP_TYPE, groupType);
        metadataParams.put(BridgeConstants.METADATA_PARAM_USER_NAME, userFullName);
        return BSCommonUtil.buildJobQueueMetadataXML(GemConstants.JOB_TYPE_COUNTRY_GROUP, metadataParams, null, null);
    }
    
    /**
     * 
     * @param publishId
     * @param preferences
     * @param user
     * @param componentName
     * @return boolean
     */
    protected boolean createNotification(long publishId, long regionId, User user, String componentName,
            String groupType)
    {
        boolean isAdded = true;
        try {
            ErrNotification notification = ErrNotificationLocalServiceUtil.createErrNotificationOraSequence();
            notification.setPublishId(publishId);
            notification.setComponentName(componentName);
            notification.setReferenceId(regionId);
            notification.setRegionId(regionId);
            notification.setCreatorId(String.valueOf(user.getUserId()));
            notification.setUpdatedBy(String.valueOf(user.getUserId()));
            //Store message into constant class or property file or use UI element
            if (GemConstants.SA_REPORT_TYPE.equals(groupType))
            {
                notification.setTitle(GemConstants.SA_NOTIFICATION_MESSAGE);
                notification.setDescription(GemConstants.SA_NOTIFICATION_MESSAGE);
            } else if (GemConstants.SE_REPORT_TYPE.equals(groupType))
            {
            	 notification.setTitle(GemConstants.SE_NOTIFICATION_MESSAGE);
                 notification.setDescription(GemConstants.SE_NOTIFICATION_MESSAGE);
            } else {
            	 notification.setTitle(GemConstants.PRE_STAGING_ENVIRONMENT);
                 notification.setDescription(GemConstants.BRIDGE_NOTIFICATION_MESSAGE);
            }

            notification.setSeverity(GemConstants.NOTIFICATION_SEVERITY);
            ErrNotificationLocalServiceUtil.updateErrNotification(notification);
        } catch (SystemException e) {
            LOG.error(e.getMessage(), e);
            isAdded = false;
        }
        return isAdded;
    }
    
    /**
     * Get all regions associated with publish id and standard id
     * @param publishId
     * @param stdId
     * @return regions Set<Long>
     */
    private Set<Long> getAllRegions (long publishId, long stdId) {
    	List<Long> regionList = BridgePublishLocalServiceUtil.getRegionsByPublishIdAndStdId(publishId, stdId);
    	Set<Long> regions = new HashSet<Long>(regionList);    	
    	return regions;
    }
    
    /**
     * 
     * @param publishId
     * @param regionId
     * @param stdId
     * @param modifiedPublications
     */
    private void updatePublicationRegionMapping (long publishId, long regionId, long stdId, Map<Long, Set<Long>> modifiedPublications) {
    	//If it is an global entry
        if (regionId == 1l) {
        	modifiedPublications.put(publishId, getAllRegions(publishId, stdId));
        } else if (!modifiedPublications.containsKey(publishId)) {
        	Set<Long> regions = new HashSet<Long>();
        	regions.add(regionId);
        	modifiedPublications.put(publishId, regions);
        } else {
        	Set<Long> regions = modifiedPublications.get(publishId);
        	regions.add(regionId);
        	modifiedPublications.put(publishId, regions);
        }
    }
    
}
