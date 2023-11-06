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

import com.ihg.brandstandards.bridge.util.BridgeQueryUtils;
import com.ihg.brandstandards.db.model.PublishStandardsExt;
import com.ihg.brandstandards.db.service.base.PublishStandardsExtLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;

/**
 * The implementation of the Custom Query mapping to createlist of standards with translations. local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their
 * definitions into the {@link com.ihg.brandstandards.db.service.PublishStandardsExtLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because
 * this service can only be accessed from within the same VM.
 * </p>
 * 
 * @author Lakshminarayana Mummanedi
 * @see com.ihg.brandstandards.db.service.base.PublishStandardsExtLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.PublishStandardsExtLocalServiceUtil
 */
public class PublishStandardsExtLocalServiceImpl extends PublishStandardsExtLocalServiceBaseImpl
{
    private static final Log LOG = LogFactoryUtil.getLog(PublishStandardsExtLocalServiceImpl.class);
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.PublishStandardsExtLocalServiceUtil} to access the Custom Query mapping to createlist of standards with translations. local service.
     */
    public List<PublishStandardsExt> getStandardsByBrandAndCountry(String localeCode, String chainCode, String countryCode,
            String stdType, String query) throws SystemException
    {
        List<PublishStandardsExt> arlStandards;
        try
        {
            arlStandards = publishStandardsExtFinder.getStandardsByCountryAndBrand(localeCode, chainCode, countryCode, stdType, query);
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
            arlStandards = new ArrayList<PublishStandardsExt>();
        }

        return arlStandards;
    }

    public List<PublishStandardsExt> getSearchResults(String localeCode, String chainCode, String countryCode, String stdType,
            String query) throws SystemException
    {
        List<PublishStandardsExt> arlStandards;
        try
        {
            arlStandards = publishStandardsExtFinder.getSearchResults(localeCode, chainCode, countryCode, stdType, query);
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
            arlStandards = new ArrayList<PublishStandardsExt>();
        }
        return arlStandards;
    }

    public List<PublishStandardsExt> getAllIndexes(String query)
    {
        return publishStandardsExtFinder.getAllIndexes(query);
    }
    
    public List<PublishStandardsExt> getCMSAllIndexes()
    {
        String query = BridgeQueryUtils.getCMSAllIndexQuery();
        return publishStandardsExtFinder.getCMSAllIndexes(query);
    }

    public List<PublishStandardsExt> getWhatChangedOnList(String query, boolean indexQuery) throws SystemException
    {
        List<PublishStandardsExt> arlStandards;
        try
        {
            arlStandards = publishStandardsExtFinder.getWhatChangedOnList(query, indexQuery);
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
            arlStandards = new ArrayList<PublishStandardsExt>();
        }
        return arlStandards;
    }
    
    public void clearCache()
    {
        try
        {
            publishStandardsExtPersistence.clearCache();
        }
        catch (Exception e)
        {
        }
    }
}