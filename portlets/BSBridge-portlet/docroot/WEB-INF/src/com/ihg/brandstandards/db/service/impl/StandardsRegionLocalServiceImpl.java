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

import com.ihg.brandstandards.db.NoSuchStandardsRegionException;
import com.ihg.brandstandards.db.model.StandardsRegion;
import com.ihg.brandstandards.db.service.base.StandardsRegionLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.List;

/**
 * The implementation of the standards region local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their
 * definitions into the {@link com.ihg.brandstandards.db.service.StandardsRegionLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because
 * this service can only be accessed from within the same VM.
 * </p>
 * 
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.StandardsRegionLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.StandardsRegionLocalServiceUtil
 */
public class StandardsRegionLocalServiceImpl extends StandardsRegionLocalServiceBaseImpl
{
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.StandardsRegionLocalServiceUtil} to access the standards region local service.
     */
    private static final Log LOG = LogFactoryUtil.getLog(StandardsRegionLocalServiceImpl.class);

    public void clearCache()
    {
        try
        {
            standardsRegionPersistence.clearCache();
        }
        catch (Exception e)
        {
        }
    }
    
    public long getRegionIdByCode(String rgnCd)
    {
        long regionId = -1;
        try
        {
            StandardsRegion rgn = standardsRegionPersistence.findByRegionCode(rgnCd);
            if(rgn != null){
                regionId = rgn.getRegionId();
            }
        }
        catch (NoSuchStandardsRegionException e)
        {
            LOG.error(e.getMessage(), e);
        }
        catch (SystemException e)
        {
            LOG.error(e.getMessage(), e);
        }
        return regionId;
    }
    
    public StandardsRegion getStandardsRegionByRegionCode(String regionCode) throws SystemException,
            NoSuchStandardsRegionException
    {
        return standardsRegionPersistence.findByRegionCode(regionCode);
    }
    
    public List<StandardsRegion> getSubRegionsListByParentId(long parentRegionId){
    	
    	return standardsRegionFinder.getSubRegionsListByParentId(parentRegionId);
    }
    
    public List<StandardsRegion> getStandardsParentRegionsList(){
    	
    	return standardsRegionFinder.getStandardsParentRegionsList();
    }
    
}