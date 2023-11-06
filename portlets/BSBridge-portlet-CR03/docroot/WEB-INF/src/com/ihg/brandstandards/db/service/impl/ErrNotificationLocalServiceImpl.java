/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.ihg.brandstandards.db.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ihg.brandstandards.db.model.ErrNotification;
import com.ihg.brandstandards.db.service.base.ErrNotificationLocalServiceBaseImpl;
import com.ihg.brandstandards.util.BSCommonConstants;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * The implementation of the err notification local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ihg.brandstandards.db.service.ErrNotificationLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.ErrNotificationLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.ErrNotificationLocalServiceUtil
 */
public class ErrNotificationLocalServiceImpl extends ErrNotificationLocalServiceBaseImpl 
{
	private static final Log LOG = LogFactoryUtil.getLog(ErrNotificationLocalServiceImpl.class);
	
	/**
	 * Clear cache.
	 */
	public void clearCache () {
		try {
			errNotificationPersistence.clearCache();
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
	}
	
	/**
	 * Find notifications.
	 * @param componentName
	 * @param publishId
	 * @param rgnId
	 * @return List<ErrNotification>
	 */
	public List<ErrNotification> getMessagesByComponentTypeAndPublication (String componentName, long publishId, long rgnId) {
		List<ErrNotification> notifications = new ArrayList<ErrNotification>();
		try {
			
			clearCache();
			
			notifications =  errNotificationPersistence.findBycomponentNameAndPublishId(componentName, publishId, rgnId);
		} catch (SystemException e) {
			LOG.error(e.getMessage(), e);
		}
		return notifications;
	}
	
    /**
     * Find notifications.
     * @param componentName
     * @param publishId
     * @param rgnId
     * @return List<ErrNotification>
     */
    public List<ErrNotification> getNotificationsByComponentNameAndReferenceId(String componentName, long refId) 
    {
        List<ErrNotification> notifications;
        try {
            
            clearCache(); 
            notifications =  errNotificationPersistence.findByComponentNameAndReferenceId(componentName, refId);
        } 
        catch (SystemException e) 
        {
            notifications = new ArrayList<ErrNotification>();
            LOG.error("Failed to find notifications: ", e);
        }
        return notifications;
    }
    
    /**
     * Find new notifications for processing.
     * @param componentName
     * @param publishId
     * @param rgnId
     * @return List<ErrNotification>
     */
    public List<ErrNotification> getNewNotificationsForProcessing(String componentName, long refId, String userId) 
    {
        List<ErrNotification> notifications;
        try {
            
            clearCache(); 
            notifications =  errNotificationPersistence.findByComponentNameStatusUserReferenceId(componentName, BSCommonConstants.ERR_NOTIFICATION_STATUS_NEW, userId, refId);
            
            for (ErrNotification notification : notifications)
            {
                notification.setStatus(BSCommonConstants.ERR_NOTIFICATION_STATUS_IN_PROGRESS);
                errNotificationPersistence.update(notification);
            }
        } 
        catch (SystemException e) 
        {
            notifications = new ArrayList<ErrNotification>();
            LOG.error("Failed to find notifications: ", e);
        }
        return notifications;
    }
    
    /**
     * Find new notifications which are more then 1 hour old.
     * @param componentName
     * @param publishId
     * @param rgnId
     * @return List<ErrNotification>
     */
    public List<ErrNotification> getUnprocessedNewNotifications(String componentName) 
    {
        List<ErrNotification> notifications;
        try {
            notifications =  errNotificationFinder.getUnprocessedNewNotifications(componentName);
            
            for (ErrNotification notification : notifications)
            {
                notification.setStatus(BSCommonConstants.ERR_NOTIFICATION_STATUS_IN_PROGRESS);
                errNotificationPersistence.update(notification);
            }
        } 
        catch (SystemException e) 
        {
            notifications = new ArrayList<ErrNotification>();
            LOG.error("Failed to find notifications: ", e);
        }
        return notifications;
    }

    public ErrNotification createErrNotificationOraSequence() throws SystemException
    {
        return errNotificationFinder.createErrNotificationOraSequence();
    }
    
    public boolean acknowledgeNotifications(String notifcationIds)
    {
        return errNotificationFinder.acknowledgeNotifications(notifcationIds);
    }
}