/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.ihg.brandstandards.db.service.impl;

import java.util.List;
import java.util.Map;

import com.ihg.brandstandards.db.NoSuchPublishQueueException;
import com.ihg.brandstandards.db.model.PublishQueue;
import com.ihg.brandstandards.db.model.StandardsExt;
import com.ihg.brandstandards.db.service.base.PublishQueueLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * The implementation of the publish queue local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their
 * definitions into the {@link com.ihg.brandstandards.db.service.PublishQueueLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because
 * this service can only be accessed from within the same VM.
 * </p>
 * 
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.PublishQueueLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.PublishQueueLocalServiceUtil
 */
public class PublishQueueLocalServiceImpl extends PublishQueueLocalServiceBaseImpl
{
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.PublishQueueLocalServiceUtil} to access the publish queue local service.
     */
    private static final Log LOG = LogFactoryUtil.getLog(PublishQueueLocalServiceImpl.class);

    public PublishQueue createPublishQueueOraSecuence() throws SystemException
    {
        return publishQueueFinder.getNewPublishQueue();
    }

    public PublishQueue clonePublishQueue(long publishQueueId) throws SystemException
    {
        return publishQueueFinder.clonePublishQueue(publishQueueId);
    }

    public PublishQueue findPublishQueueByPublishId(long publishId) throws NoSuchPublishQueueException, SystemException
    {
        return publishQueuePersistence.findByPublishQueueByPublishId(publishId);
    }

    public void clearCache()
    {
        publishQueuePersistence.clearCache();
    }

    public String validateStdIds(final String stdIds, final String chainCd) throws SystemException
    {
        return publishQueueFinder.validateStdIds(stdIds, chainCd);
    }

    public List<PublishQueue> findPublishQueueByEnvironment(String envType, int count) throws SystemException
    {
        //return publishQueuePersistence.findByPublishQueueByEnvironment(envType, 0, count);
        return publishQueueFinder.findPublishQueueByEnvironment(envType, count);
    }

    public int updatePublishQueueStatus(long publishQueueId, String status) throws SystemException
    {
        return publishQueueFinder.updatePublishQueueStatus(publishQueueId, status);
    }

    public List<StandardsExt> getStandards(final Map<String, ?> criteriaMap) throws SystemException
    {
        return publishQueueFinder.getStandards(criteriaMap);
    }

    public void createManuals(long publishQueueId, String environment) throws SystemException
    {
    	publishQueueFinder.createManuals(publishQueueId, environment);
    }

    public void createReport(final String metaData, final String userId, final String emailAddr) throws SystemException
    {
    	publishQueueFinder.createReport(metaData, userId, emailAddr);
    }

    public void createReport(final String metaData, final String userId, final String emailAddr, final String link,
            final String jobType) throws SystemException
    {
    	publishQueueFinder.createReport(metaData, userId, emailAddr, link, jobType);
    }

    public Map<String, String> getLocalesByStdId(final List<Long> stdIds, final String brand) throws SystemException
    {
        return publishQueueFinder.getLocalesByStdId(stdIds, brand);
    }

    public Map<String, String> getLocalesByBrand(String brand) throws SystemException
    {
        return publishQueueFinder.getLocalesByBrand(brand);
    }
   
}