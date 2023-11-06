package com.ihg.brandstandards.bridge.processor.impl;

import java.util.List;
import java.util.Map;

import com.ihg.brandstandards.bridge.processor.Processor;
import com.ihg.brandstandards.db.model.ErrNotification;
import com.ihg.brandstandards.db.service.ErrNotificationLocalServiceUtil;
import com.ihg.brandstandards.util.BSCommonConstants;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;

public class CMSToBridgeUpdateProcessor extends CMSToBridgeUpdater implements Processor
{
    private static final Log LOG = LogFactoryUtil.getLog(CMSToBridgeUpdateProcessor.class); 

    @Override
    public void process(Message message)
    {
        Map<String, Object> params = message.getValues();
        
        long stdId = (Long)params.get("stdId");
        String userId = (String)message.get("userId");
        
        LOG.debug("Received message to update Bridge for STD_ID: " + stdId + " user id: " + userId);
        
        List<ErrNotification> notifications = 
                ErrNotificationLocalServiceUtil.getNewNotificationsForProcessing(BSCommonConstants.ERR_NOTIFICATION_COMPONENT_CMS_BRIDGE_SYNC, stdId, userId);
        processNotifications(notifications);
    }
}
