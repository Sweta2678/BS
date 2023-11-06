package com.ihg.brandstandards.bridge.processor.impl;

import java.util.List;

import com.ihg.brandstandards.db.model.ErrNotification;
import com.ihg.brandstandards.db.service.ErrNotificationLocalServiceUtil;
import com.ihg.brandstandards.util.BSCommonConstants;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;

public class CMSToBridgeUpdateScheduler extends CMSToBridgeUpdater implements MessageListener
{
    private static final Log LOG = LogFactoryUtil.getLog(CMSToBridgeUpdateScheduler.class);

    @Override
    public void receive(Message message) throws MessageListenerException
    {
        if(LOG.isDebugEnabled())
        {
            LOG.debug("Run scheduler now!");
        }
        
        processNotifications();
        
        if(LOG.isDebugEnabled())
        {
            LOG.debug("Scheduler completed job!");
        }
    }

    private void processNotifications()
    {
        List<ErrNotification> notifications = ErrNotificationLocalServiceUtil.getUnprocessedNewNotifications(BSCommonConstants.ERR_NOTIFICATION_COMPONENT_CMS_BRIDGE_SYNC);
        processNotifications(notifications);
    }
}
