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

import com.ihg.brandstandards.db.model.StandardsCountryExt;
import com.ihg.brandstandards.db.service.base.StandardsCountryExtLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

/**
 * The implementation of the standards country ext local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ihg.brandstandards.db.service.StandardsCountryExtLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.StandardsCountryExtLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.StandardsCountryExtLocalServiceUtil
 */
public class StandardsCountryExtLocalServiceImpl
	extends StandardsCountryExtLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.StandardsCountryExtLocalServiceUtil} to access the standards country ext local service.
	 */
	public void clearCache()
    {
        try
        {
            standardsCountryExtPersistence.clearCache();
        }
        catch (Exception e)
        {
        }
    }
	
	public List<StandardsCountryExt> getCountryListByStdIdAndRegionId(long stdId, long regionId, long publishId)
            throws SystemException
    {
	    return standardsCountryExtFinder.getCountryListByStdIdAndRegionId(stdId, regionId, publishId);
    }
	
	public List<StandardsCountryExt> getCountryListByStdIdAndRegionIdForMyPublication(long stdId, long regionId, long publishId) throws SystemException
	{
		 return standardsCountryExtFinder.getCountryListByStdIdAndRegionIdForMyPublication(stdId, regionId, publishId);
	}
	
	public List<StandardsCountryExt> getRegionBasedCountryStatus(long stdId, String chainCd, long regionId) throws SystemException
	{
		 return standardsCountryExtFinder.getRegionBasedCountryStatus(stdId, chainCd, regionId);
	}
	
	public String getRegionCodeByCountryCode(String ctryCode){
		
		return standardsCountryExtFinder.getRegionCodeByCountryCode(ctryCode);
	}
	
	public List<StandardsCountryExt> getCountryRegionList(){
		
		return standardsCountryExtFinder.getCountryRegionList();
	}
	
	public List<String> getCountryListByRegionCode(String regionCode){
		
		return standardsCountryExtFinder.getCountryListByRegionCode(regionCode);
	}
	
	public List<String> getCountryListBySubRegionCode(String subRegionCode){
		
		return standardsCountryExtFinder.getCountryListBySubRegionCode(subRegionCode);
	}
	
	public List<String> getAllStdCountryList(){
		
		return standardsCountryExtFinder.getAllStdCountryList();
	}
}
