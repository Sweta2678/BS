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

import com.ihg.brandstandards.db.model.TaxonomyExt;
import com.ihg.brandstandards.db.service.base.TaxonomyExtLocalServiceBaseImpl;
import com.ihg.brandstandards.db.service.persistence.TaxonomyExtFinderUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;

/**
 * The implementation of the Custom Query mapping to create index path. local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their
 * definitions into the {@link com.ihg.brandstandards.db.service.TaxonomyExtLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because
 * this service can only be accessed from within the same VM.
 * </p>
 * 
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.TaxonomyExtLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.TaxonomyExtLocalServiceUtil
 */
public class TaxonomyExtLocalServiceImpl extends TaxonomyExtLocalServiceBaseImpl
{
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.TaxonomyExtLocalServiceUtil} to access the Custom Query mapping to create index path. local service.
     */
    private static final Log LOG = LogFactoryUtil.getLog(TaxonomyExtLocalServiceImpl.class);

    public void clearCache()
    {
        try
        {
            taxonomyExtPersistence.clearCache();
        }
        catch (Exception e)
        {
        }
    }
    
    /**
     * Fetch all Indexes for specified Standard from database.
     * 
     * @param standardsId - Standard Id
     * @return - Index path
     * @throws SystemException - exception
     */
    public String getIndexPathByStandardId(final long standardsId) throws SystemException
    {
        String path = "";
        try
        {
            final List<TaxonomyExt> arlResults = TaxonomyExtFinderUtil.getIndexPathByStandardsId(standardsId);
            for (TaxonomyExt taxonomyext : arlResults)
            {
                path = taxonomyext.getPath();
            }
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        return path;
    }

    /**
     * Fetch all Indexes from database.
     * 
     * @return - list of Indexes
     * @throws SystemException - exception
     */
    public List<TaxonomyExt> getAllIndexes() throws SystemException
    {
        return TaxonomyExtFinderUtil.getAllIndexes();
    }

    /**
     * Fetch all Indexes from database order by Index Id.
     * 
     * @return - list of Indexes
     * @throws SystemException - exception
     */
    public List<TaxonomyExt> getAllIndexesOdrById() throws SystemException
    {
        return TaxonomyExtFinderUtil.getAllIndexesOdrByIdxId();
    }
}