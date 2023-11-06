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

import java.util.Collections;
import java.util.List;

import com.ihg.brandstandards.db.model.StandardsDisplayOrderExt;
import com.ihg.brandstandards.db.service.base.StandardsDisplayOrderExtLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;

/**
 * The implementation of the standards display order ext local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ihg.brandstandards.db.service.StandardsDisplayOrderExtLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.StandardsDisplayOrderExtLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.StandardsDisplayOrderExtLocalServiceUtil
 */
public class StandardsDisplayOrderExtLocalServiceImpl
	extends StandardsDisplayOrderExtLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.StandardsDisplayOrderExtLocalServiceUtil} to access the standards display order ext local service.
	 */
	private static final Log LOG = LogFactoryUtil.getLog(StandardsDisplayOrderExtLocalServiceImpl.class);
	
	public void clearCache()
    {
        try
        {
            standardsDisplayOrderExtPersistence.clearCache();
        }
        catch (Exception e)
        {
        }
    }
	
	/**
     * Fetch Standards based on taxanomy id, brand code and region code.
     * 
     * @return List of Specifications
     */
    public List<StandardsDisplayOrderExt> getStandardsByTaxonomyIdChainCodeRegionCode(long taxonomyId, String chainCode, String regionCode) throws SystemException
    {
        List<StandardsDisplayOrderExt> standardsDisplayOrderExt = Collections.emptyList();
        
        try
        {
        	standardsDisplayOrderExt = standardsDisplayOrderExtFinder.getStandardsOrderByChnCodeAndRgnCode(taxonomyId, chainCode, regionCode);
        }
        catch (SystemException e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        return standardsDisplayOrderExt;
    }
}