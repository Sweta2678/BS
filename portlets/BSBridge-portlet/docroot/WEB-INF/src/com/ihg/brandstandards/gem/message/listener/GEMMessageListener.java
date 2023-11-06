package com.ihg.brandstandards.gem.message.listener;

import com.ihg.brandstandards.bridge.util.BridgeConstants;
import com.ihg.brandstandards.custom.model.Preferences;
import com.ihg.brandstandards.db.model.ErrNotification;
import com.ihg.brandstandards.db.service.ErrNotificationLocalServiceUtil;
import com.ihg.brandstandards.db.service.PublishQueueLocalServiceUtil;
import com.ihg.brandstandards.gem.util.GemConstants;
import com.ihg.brandstandards.util.BSCommonUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 
 * @author akhanic
 *
 */
public class GEMMessageListener implements MessageListener 
{
    private static Log LOG = LogFactoryUtil.getLog(GEMMessageListener.class);

    public void receive(Message message)
    {
        try {
            //Check message type first.
            String requestType = GetterUtil.getString(message.get("requestType"));
            if (Validator.isNotNull(requestType) && GemConstants.JOB_TYPE_COUNTRY_GROUP.equals(requestType))
            {
                createUniqueGroupRequest(message);
            }
            LOG.debug("inside message listner...");
        } catch (Exception e) {
            LOG.error("Unable to process message " + message, e);
        }
    }
    
    /**
     * 
     * @param message
     */
    private void createUniqueGroupRequest(Message message)
    {
        // Get preferences, user object and publication id from message
        LOG.debug("------- Get attributes -----");
        Preferences preferences = (Preferences) message.get("preferences");
        User user = (User) message.get("user");
        long publishId = message.getLong("publishId");
        long regionId = message.getLong("regionId");
        
        String groupType = message.getString("groupType");
        String manualType = message.getString("manualType");
        //Create an entry into error notification table
        Boolean isFromCopyToBrand = message.getBoolean("isFromCopyToBrand");
        String brand ;
        if(isFromCopyToBrand){
        	brand=message.getString("targetBrand");
        }else{
        	brand=preferences.getBrand();
        }
        if (createNotification(publishId, regionId, user, GemConstants.JOB_TYPE_COUNTRY_GROUP, groupType))
        {
            //Create a job queue entry 
            submitGroupRequest(brand, preferences.getRegionCode(), regionId, publishId, 
            		user.getFullName(), user.getScreenName(), user.getEmailAddress(), groupType, manualType);
            LOG.debug(" --- Job queue entry added ---");
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
     * @param groupType
     * @param manualType
     * @return String
     */
    protected String submitGroupRequest(String brandCode, String regionCode, long regionId, long publishId, String userFullName,
            String screenName, String email, String groupType, String manualType)
    {
        String returnMsg = "Success";
        String metadata = generateMetadata(brandCode, regionCode, regionId, publishId, userFullName, 
        		screenName, email, groupType, manualType);
        try {
            PublishQueueLocalServiceUtil.createReport(metadata, screenName, email, null, GemConstants.JOB_TYPE_COUNTRY_GROUP);
        } catch (Exception e) {
            LOG.error(StackTraceUtil.getStackTrace(e));
            returnMsg = "ERROR";
        }
        return returnMsg;
    }
    
    /**
     * 
     * @param publishId
     * @param preferences
     * @param user
     * @param componentName
     * @return boolean
     */
    protected boolean createNotification(long publishId, long regionId,User user, String componentName,
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
            } else if (GemConstants.WAIVER_REPORT_TYPE.equals(groupType))
            {
           	 notification.setTitle(GemConstants.WAIVER_NOTIFICATION_MESSAGE);
                notification.setDescription(GemConstants.WAIVER_NOTIFICATION_MESSAGE);
           } else {
            	 notification.setTitle(GemConstants.PRE_STAGING_ENVIRONMENT);
                 notification.setDescription(GemConstants.BRIDGE_NOTIFICATION_MESSAGE);
            }

            notification.setPublishId(publishId);
            notification.setSeverity(GemConstants.NOTIFICATION_SEVERITY);
            ErrNotificationLocalServiceUtil.updateErrNotification(notification);
        } catch (SystemException e) {
            LOG.error(e.getMessage(), e);
            isAdded = false;
        }
        return isAdded;
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
    protected String generateMetadata(String brandCode, String regionCode, long regionId, long publishId, String userFullName,
            String screenName, String email, String groupType, String manualType)
    {
        Map<String, String> metadataParams = new LinkedHashMap<String, String>();
        //Generate Map
        metadataParams.put(BridgeConstants.METADATA_PARAM_ENVIRONMENT, BridgeConstants.BRIDGE_GROUPS_TYPE.equals(groupType) ? BridgeConstants.BRIDGE_ENVIRONMENT : GemConstants.GEM_ENVIRONMENT);
        metadataParams.put(BridgeConstants.BRIDGE_GROUPS_TYPE.equals(groupType) ? BridgeConstants.METADATA_PARAM_BRIDGE_PUBLISH_ID : BridgeConstants.METADATA_PARAM_GEM_PUBLISH_ID, String.valueOf(publishId));
        metadataParams.put(BridgeConstants.METADATA_PARAM_CHAIN_CD, brandCode);
        metadataParams.put(BridgeConstants.METADATA_PARAM_PUBLISH_CONTENT_TYPE, manualType);
        metadataParams.put(BridgeConstants.METADATA_PARAM_REGION_CD, regionCode);
        metadataParams.put(BridgeConstants.METADATA_PARAM_REGION_ID, String.valueOf(regionId));
        metadataParams.put(BridgeConstants.METADATA_PARAM_GROUP_TYPE, groupType);
        metadataParams.put(BridgeConstants.METADATA_PARAM_USER_NAME, userFullName);
        return BSCommonUtil.buildJobQueueMetadataXML(GemConstants.JOB_TYPE_COUNTRY_GROUP, metadataParams, null, null);
    }
}