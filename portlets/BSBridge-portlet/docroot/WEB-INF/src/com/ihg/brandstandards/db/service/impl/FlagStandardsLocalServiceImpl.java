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

import com.ihg.brandstandards.db.NoSuchFlagStandardsException;
import com.ihg.brandstandards.db.model.FlagStandards;
import com.ihg.brandstandards.db.model.impl.FlagStandardsImpl;
import com.ihg.brandstandards.db.service.base.FlagStandardsLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the flag standards local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their
 * definitions into the {@link com.ihg.brandstandards.db.service.FlagStandardsLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because
 * this service can only be accessed from within the same VM.
 * </p>
 * 
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.FlagStandardsLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.FlagStandardsLocalServiceUtil
 */
public class FlagStandardsLocalServiceImpl extends FlagStandardsLocalServiceBaseImpl
{
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.FlagStandardsLocalServiceUtil} to access the flag standards local service.
     */

    public FlagStandards getFlagStandardsObject()
    {
        return new FlagStandardsImpl();
    }
    
    public List<FlagStandards> getFlagStandardsByStdId(long stdId) throws SystemException
    {
        return flagStandardsPersistence.findByStdId(stdId);
    }

    public FlagStandards getFlagStandardByFlagId(long flagId) throws NoSuchFlagStandardsException, SystemException
    {
        return flagStandardsPersistence.findByFlagCatId(flagId);
    }

    public FlagStandards getFlagStandardByStandardAndCategoryId(long stdId, long flagCategoryId) throws SystemException
    {
        return flagStandardsPersistence.fetchByStandardAndCategoryId(stdId, flagCategoryId);
    }

    public List<Long> getFlagIdsByStandardAndCategoryId(long stdId, List<String> flagCategories) throws SystemException
    {
        return flagStandardsFinder.getFlagIdByStdIdAndCategoryId(stdId, flagCategories);
    }

    public List<Long> getFlagIdsByStdId(long stdId)
    {
        return flagStandardsFinder.getFlagStdId(stdId);
    }
    
    public void clearCache()
    {
        flagStandardsPersistence.clearCache();
    }    
}