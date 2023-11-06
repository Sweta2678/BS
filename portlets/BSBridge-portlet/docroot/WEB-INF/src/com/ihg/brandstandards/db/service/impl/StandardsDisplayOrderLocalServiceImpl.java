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

import com.ihg.brandstandards.db.model.StandardsDisplayOrder;
import com.ihg.brandstandards.db.service.base.StandardsDisplayOrderLocalServiceBaseImpl;
import com.ihg.brandstandards.db.service.persistence.StandardsDisplayOrderPK;
import com.ihg.brandstandards.db.service.persistence.StandardsDisplayOrderUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * The implementation of the standards display order local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ihg.brandstandards.db.service.StandardsDisplayOrderLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.StandardsDisplayOrderLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.StandardsDisplayOrderLocalServiceUtil
 */
public class StandardsDisplayOrderLocalServiceImpl
	extends StandardsDisplayOrderLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.StandardsDisplayOrderLocalServiceUtil} to access the standards display order local service.
	 */
	private static final Log LOG = LogFactoryUtil.getLog(StandardsDisplayOrderLocalServiceImpl.class);
	public void clearCache()
    {
        try
        {
            standardsDisplayOrderPersistence.clearCache();
        }
        catch (Exception e)
        {
        }
    }
	
	/* (non-Javadoc)
	 * @see com.ihg.brandstandards.db.service.StandardsDisplayOrderLocalService#getStandardsDispalyOrder(long, java.lang.String, java.lang.String)
	 */
	public StandardsDisplayOrder getStandardsDispalyOrder(long stdId, String chainCode, String regionCode) 
	{
		StandardsDisplayOrder standardsDisplayOrder = null;
		
			try 
			{
				standardsDisplayOrder = StandardsDisplayOrderUtil.fetchByStdIdChainIdRegionCode(stdId, chainCode, regionCode, false);
			} 
			catch (SystemException e) 
			{
				LOG.error(e);
			}
		
		return  standardsDisplayOrder;
	}
	
	/**
	 * Add Standard display order in db.
	 * @param stdId  Standard id.
	 * @param chainCode Chain code.
	 * @param regionCode Region code.
	 * @return {@link StandardsDisplayOrder}
	 */
	public StandardsDisplayOrder addStandardsDisplayOrder(long stdId, String chainCode, String regionCode) 
	{
		StandardsDisplayOrderPK standardsDisplayOrderPK = new StandardsDisplayOrderPK(Long.valueOf(stdId), regionCode, chainCode);
		return standardsDisplayOrderPersistence.create(standardsDisplayOrderPK);
	}
	
	
}