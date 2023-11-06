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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate;
import com.ihg.brandstandards.db.service.base.SpreadSheetAttributeUpdateLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.User;

/**
 * The implementation of the spread sheet attribute update local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their
 * definitions into the {@link com.ihg.brandstandards.db.service.SpreadSheetAttributeUpdateLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because
 * this service can only be accessed from within the same VM.
 * </p>
 * 
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.SpreadSheetAttributeUpdateLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.SpreadSheetAttributeUpdateLocalServiceUtil
 */
public class SpreadSheetAttributeUpdateLocalServiceImpl extends SpreadSheetAttributeUpdateLocalServiceBaseImpl
{
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.SpreadSheetAttributeUpdateLocalServiceUtil} to access the spread sheet attribute update local service.
     */
	private static final Log LOG = LogFactoryUtil.getLog(SpreadSheetAttributeUpdateLocalServiceImpl.class);
	
	@Override
    public SpreadSheetAttributeUpdate addSpreadSheetAttributeUpdate(SpreadSheetAttributeUpdate spreadSheetAttributeUpdate)
            throws SystemException
    {
	    SpreadSheetAttributeUpdate attribute = super.addSpreadSheetAttributeUpdate(spreadSheetAttributeUpdate); 
	    return attribute;
    }

    @Override
    public SpreadSheetAttributeUpdate createSpreadSheetAttributeUpdate(long speardSheetId)
    {
        SpreadSheetAttributeUpdate attribute = super.createSpreadSheetAttributeUpdate(speardSheetId);
        return attribute;
    }

    @Override
    public SpreadSheetAttributeUpdate deleteSpreadSheetAttributeUpdate(long speardSheetId) throws PortalException, SystemException
    {
        return super.deleteSpreadSheetAttributeUpdate(speardSheetId);
    }

    @Override
    public SpreadSheetAttributeUpdate deleteSpreadSheetAttributeUpdate(SpreadSheetAttributeUpdate spreadSheetAttributeUpdate) throws SystemException
    {
        return super.deleteSpreadSheetAttributeUpdate(spreadSheetAttributeUpdate);
    }

    @Override
    public SpreadSheetAttributeUpdate updateSpreadSheetAttributeUpdate(SpreadSheetAttributeUpdate spreadSheetAttributeUpdate) throws SystemException
    {
        SpreadSheetAttributeUpdate attribute = super.updateSpreadSheetAttributeUpdate(spreadSheetAttributeUpdate); 
        return attribute;
    }

    public String recordsNotAvailable (List<Long> allStdIds, Map<String, List<Long>> stdIdsMap, User user, String region, String environment) {
		return spreadSheetAttributeUpdateFinder.recordsNotAvailable(allStdIds, stdIdsMap, user, region, environment);
	}
	
	/**
	 * 
	 * @param stdIds This is a list of Long values
	 * @return List This method will return an object of List
	 */
	public List getStandardDetails (List<Long> stdIds) {
		return spreadSheetAttributeUpdateFinder.getStandardDetails(stdIds);
	}
	
	/**
	 * @param status
	 */
	public List<SpreadSheetAttributeUpdate> getAttributeRequestList (String status) {
		List<SpreadSheetAttributeUpdate> attributeUpdates = new ArrayList<SpreadSheetAttributeUpdate>();
		try {
			attributeUpdates = spreadSheetAttributeUpdatePersistence.findBystatus(status);
		} catch (SystemException e) {
			LOG.error(e.getMessage(), e);
		}
		return attributeUpdates;
	}
	
	/**
	 * @param stdId
	 */
	public List<Long> getFlagCategoryIdForStandard (long stdId) {
		return spreadSheetAttributeUpdateFinder.getFlagStdId(stdId);
	}
	
	/**
	 * 
	 */
	public Map<String,Long> getFlagCategories () {
		return spreadSheetAttributeUpdateFinder.getFlagCategories();
	}
	
	/**
	 * @param userId
	 * @param environment
	 * @param template
	 * @param message
	 * @param log
	 * @param requestId
	 */
	public void sendEmailNotification (long userId, String environment, String template, String message, String log, String requestId) {
		try {
			spreadSheetAttributeUpdateFinder.sendEmailNotification(userId, environment, template, message, log, requestId);
		} catch (SystemException e) {
			LOG.error(e.getMessage(), e);
		}
	}
	
	/**
	 * 
	 * @param stdIds
	 * @return Map
	 */
	public Map<Long,List<Long>> getStandardFlagCaterogies (List<Long> stdIds) {
	    return spreadSheetAttributeUpdateFinder.getStandardFlagCaterogies(stdIds);
	}
	
	/**
	 * 
	 */
	public void clearCache () {
	    spreadSheetAttributeUpdatePersistence.clearCache();
	}
	
	/**
	 * 
	 * @param user
	 * @param metadata
	 * @param jobType
	 * @return boolean
	 */
	public boolean addToJobQueue(User user, String metadata, String jobType) {
		boolean isAddtoJobQueue = false;
		try {
			isAddtoJobQueue = spreadSheetAttributeUpdateFinder.addToJobQueue(user, metadata, jobType);
		} catch (SystemException e) {
			LOG.error(e.getMessage(), e);
		}
		return isAddtoJobQueue;
	}
}