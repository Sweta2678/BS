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

import com.ihg.brandstandards.db.model.PublishExtStd;
import com.ihg.brandstandards.db.service.base.PublishExtStdLocalServiceBaseImpl;
import com.ihg.brandstandards.db.service.persistence.StandardsFinderUtil;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables. local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their
 * definitions into the {@link com.ihg.brandstandards.db.service.PublishExtStdLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because
 * this service can only be accessed from within the same VM.
 * </p>
 * 
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.PublishExtStdLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.PublishExtStdLocalServiceUtil
 */
public class PublishExtStdLocalServiceImpl extends PublishExtStdLocalServiceBaseImpl
{
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.PublishExtStdLocalServiceUtil} to access the Custom Query mapping between PUBLISH_STD and STD_CTRY_CHAIN tables. local service.
     */
	
	public void clearCache()
    {
        try
        {
            publishExtStdPersistence.clearCache();
        }
        catch (Exception e)
        {
        }
    }
	
    public List<PublishExtStd> getPublishedStandards(long stdId, String stdType, String brandCd, String filterOn,
            String isNonMatch, String fromDate, String toDate) throws SystemException
    {
        return standardsFinder.getPublishedStandards(stdId, stdType, brandCd, filterOn, isNonMatch, fromDate, toDate);
    }
    
    public List<PublishExtStd> getPublishedStandards(String brandCd, String filterOn,
            String isNonMatch, String fromDate, String toDate, String filterIds) throws SystemException
    {
        return standardsFinder.getPublishedStandards(brandCd, filterOn, isNonMatch, fromDate, toDate, filterIds);
    }

    public List<PublishExtStd> getPublishedSpecs(String stdType, String brandCd, String fromDate, String toDate)
            throws SystemException
    {
        return standardsFinder.getPublishedSpecs(stdType, brandCd, fromDate, toDate);
    }
}