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

import com.ihg.brandstandards.db.NoSuchBridgePublishCountryException;
import com.ihg.brandstandards.db.model.BridgePublishCountry;
import com.ihg.brandstandards.db.service.base.BridgePublishCountryLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * The implementation of the bridge publish country local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ihg.brandstandards.db.service.BridgePublishCountryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.BridgePublishCountryLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.BridgePublishCountryLocalServiceUtil
 */
public class BridgePublishCountryLocalServiceImpl extends BridgePublishCountryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.BridgePublishCountryLocalServiceUtil} to access the bridge publish country local service.
	 */
	private static final Log LOG = LogFactoryUtil.getLog(BridgePublishCountryLocalServiceImpl.class);
	public void clearCache()
    {
        try
        {
        	bridgePublishCountryPersistence.clearCache();
        }
        catch (Exception e) { }
    }
    public List<BridgePublishCountry> getCountriesByPublishId(long bridgePublishId) throws SystemException
    {
        return bridgePublishCountryPersistence.findByPublishId(bridgePublishId);
    }
    
	public BridgePublishCountry getCountriesByPublishIdAndCountryCode(long bridgePublishId,String countryCode) throws NoSuchBridgePublishCountryException, SystemException
    {
		return bridgePublishCountryPersistence.findByBridgePublishIdAndCountryCode(bridgePublishId,countryCode);
    }
	
	public void saveBridgePublishCountry(long bridgePublishId , List<String> stdCountries) throws SystemException
	{
		
	}
	
	public void deleteBridgePublishCountries(long bridgePublishId){
		try {
			//bridgePublishCountryPersistence.removeByPublishId(bridgePublishId);
			bridgePublishCountryFinder.deleteBridgePublishCountries(bridgePublishId);
		} catch (Exception e) {
			LOG.error("Failed to delete deleteBridgePublishCountries with bridgePublishId:" + bridgePublishId + "  Error Message:"+ e.getMessage());
		}
	}
}