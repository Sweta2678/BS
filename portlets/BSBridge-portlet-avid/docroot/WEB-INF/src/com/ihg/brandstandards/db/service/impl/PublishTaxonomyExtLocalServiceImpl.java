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

import com.ihg.brandstandards.db.model.PublishTaxonomyExt;
import com.ihg.brandstandards.db.service.base.PublishTaxonomyExtLocalServiceBaseImpl;
import com.ihg.brandstandards.db.service.persistence.PublishTaxonomyExtFinderUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;

/**
 * The implementation of the Custom Query mapping to create index path. local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their
 * definitions into the {@link com.ihg.brandstandards.db.service.PublishTaxonomyExtLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because
 * this service can only be accessed from within the same VM.
 * </p>
 * 
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.PublishTaxonomyExtLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.PublishTaxonomyExtLocalServiceUtil
 */
public class PublishTaxonomyExtLocalServiceImpl extends PublishTaxonomyExtLocalServiceBaseImpl
{
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.PublishTaxonomyExtLocalServiceUtil} to access the Custom Query mapping to create index path. local service.
     */
    private static final Log LOG = LogFactoryUtil.getLog(PublishTaxonomyExtLocalServiceImpl.class);

    public void clearCache()
    {
        try
        {
            publishTaxonomyExtPersistence.clearCache();
        }
        catch (Exception e)
        {
        }
    }
    
    public String getIndexPathByPublishStandardsId(long publishStandardId)
    {
        String path = "";
        try
        {
            final List<PublishTaxonomyExt> arlResults = PublishTaxonomyExtFinderUtil.getIndexPathByStandardsId(publishStandardId);
            for (PublishTaxonomyExt taxonomyext : arlResults)
            {
                path = taxonomyext.getPath();
            }
            LOG.debug("breadcrum :::" + path);
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        return path;
    }

    public List<PublishTaxonomyExt> getIndexByChain(String chain, String query) throws SystemException
    {
        List<PublishTaxonomyExt> arlIndexes = new ArrayList<PublishTaxonomyExt>();
        try
        {
            arlIndexes = PublishTaxonomyExtFinderUtil.getIndexPathByChainCode(chain, query);

        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        return arlIndexes;
    }
}