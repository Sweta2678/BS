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


import com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException;
import com.ihg.brandstandards.db.model.ChainExternalLinkStandards;
import com.ihg.brandstandards.db.model.ExternalLinkStandards;
import com.ihg.brandstandards.db.service.ChainExternalLinkStandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.base.ExternalLinkStandardsLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * The implementation of the external link standards local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ihg.brandstandards.db.service.ExternalLinkStandardsLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.ExternalLinkStandardsLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.ExternalLinkStandardsLocalServiceUtil
 */
public class ExternalLinkStandardsLocalServiceImpl
	extends ExternalLinkStandardsLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.ExternalLinkStandardsLocalServiceUtil} to access the external link standards local service.
	 */
    
    private static final Log LOG = LogFactoryUtil.getLog(ExternalLinkStandardsLocalServiceImpl.class);
    
    public void clearCache()
    {
        try
        {
            externalLinkStandardsPersistence.clearCache();
        }
        catch (Exception e)
        {
        }
    }
    public List<ExternalLinkStandards> getExternalLinkStandardsByStandardId(long stdId) throws SystemException
    {
        return externalLinkStandardsPersistence.findByStdId(stdId);
    }

    public List<ExternalLinkStandards> getExternalLinkStandardsByParentId(long parentId) throws SystemException
    {
        return externalLinkStandardsPersistence.findByParentExtLinkId(parentId);
    }

    public List<ExternalLinkStandards> getExternalLinksStandardsByParentIdStdIdLangId(long parentId, long stdId, String langCd)
            throws SystemException
    {
        return externalLinkStandardsPersistence.findByparentIdStdIdLocaleCd(parentId, stdId, langCd);
    }

    public List<ExternalLinkStandards> getExternalLinkStandardsByLocaleCdStdId(String localeCd, long stdId)
            throws SystemException
    {
        return externalLinkStandardsPersistence.findByStdIdLocaleCd(stdId, localeCd);
    }

    public List<ExternalLinkStandards> getExternalLinkStandardsByParentIdStdId(long parentId, long stdId) throws SystemException
    {
        return externalLinkStandardsPersistence.findByParentIdStdId(parentId, stdId);
    }

    public List<ExternalLinkStandards> getExternalLinksStandardsParentsByStdId(long standardId) throws SystemException
    {
        return externalLinkStandardsPersistence.findBystdParents(standardId);
    }
    public List<ExternalLinkStandards> getExternalLinksStandardsParentsByStdIdLocaleCd(long standardId, String localeCode) throws SystemException
    {
        return externalLinkStandardsPersistence.findBystdParentsLocaleCode(standardId, localeCode);
    }
    
    public ExternalLinkStandards deleteExternalLinkStandards(long extLinkId) throws SystemException
    {
        List<ChainExternalLinkStandards> chainExtLinks = ChainExternalLinkStandardsLocalServiceUtil.getChainExternalLinkStandardsByLinkId(extLinkId);
        for(ChainExternalLinkStandards chainExtLink : chainExtLinks)
        {
            chainExternalLinkStandardsPersistence.remove(chainExtLink);
        }
        try
        {
            externalLinkStandardsPersistence.remove(extLinkId);
        }
        catch (NoSuchExternalLinkStandardsException e)
        {
            LOG.error("No external link found with external link id " + extLinkId);
        }
        return null;
    }

    /* (non-Javadoc)
     * Get External Links by passing  stdId, regionId and locales.
     * 
     * @see com.ihg.brandstandards.db.service.ExternalLinkStandardsLocalService#getExternalLinkStandardsByRegionCode(long, java.lang.String, java.util.List)
     */
    public List<ExternalLinkStandards> getExtLinkStandardsByStdIdAndRgnIdAndLocale(long stdId, String regionId, List<String> locales)
    {
    	
    	return externalLinkStandardsFinder.getExtLinkStandardsByStdIdAndRgnIdAndLocale(stdId, regionId, locales);
    }
}