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

import com.ihg.brandstandards.db.model.StandardsHistoricalManual;
import com.ihg.brandstandards.db.service.base.StandardsHistoricalManualLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the standards historical manual local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their
 * definitions into the {@link com.ihg.brandstandards.db.service.StandardsHistoricalManualLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because
 * this service can only be accessed from within the same VM.
 * </p>
 * 
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.StandardsHistoricalManualLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.StandardsHistoricalManualLocalServiceUtil
 */
public class StandardsHistoricalManualLocalServiceImpl extends StandardsHistoricalManualLocalServiceBaseImpl
{
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.StandardsHistoricalManualLocalServiceUtil} to access the standards historical manual local service.
     */

	public void clearCache()
    {
        try
        {
            standardsHistoricalManualPersistence.clearCache();
        }
        catch (Exception e)
        {
        }
    }
	
    public List<StandardsHistoricalManual> getStandardsHistoricalManualByStandardId(long stdId) throws SystemException
    {
        return standardsHistoricalManualPersistence.findByStdId(stdId);
    }

    public List<StandardsHistoricalManual> findStdHistoricalManualsByStdId(long stdId) throws SystemException
    {
        return standardsHistoricalManualFinder.findStdHistoricalManualsByStdId(stdId);
    }

    public long getCountByHistMan(long histManualId) throws SystemException
    {
        return standardsHistoricalManualPersistence.countByHistManualId(histManualId);
    }
}