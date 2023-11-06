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

import com.ihg.brandstandards.db.model.CountryStandards;
import com.ihg.brandstandards.db.model.impl.CountryStandardsImpl;
import com.ihg.brandstandards.db.service.base.CountryStandardsLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the country standards local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ihg.brandstandards.db.service.CountryStandardsLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.CountryStandardsLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.CountryStandardsLocalServiceUtil
 */
public class CountryStandardsLocalServiceImpl
	extends CountryStandardsLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.CountryStandardsLocalServiceUtil} to access the country standards local service.
	 */
    public CountryStandards getCountryStandardsObject(){
        return new CountryStandardsImpl();
    }
    
    public List<CountryStandards> getCountryStandardsByStdId(long stdId) throws SystemException
    {
    	countryStandardsPersistence.clearCache();
    	
        return countryStandardsPersistence.findByStdId(stdId);
    }
    public void clearCache()
    {
        try
        {
            countryStandardsPersistence.clearCache();
        }
        catch (Exception e)
        {
        }
    }
    
    public String assignStandardsAttributToCountry(String fromCountryCode, String toCountryCode){
    	
    	return countryStandardsFinder.assignStandardsAttributToCountry(fromCountryCode, toCountryCode);
    }
    
    public String deleteCountryStandardAttribute(String ctryNameCode){

    	return countryStandardsFinder.deleteCountryStandardAttribute(ctryNameCode);
    }
    
    public int getCommonStdCount(String fromCountryCode, String toCountryCode){
    	
    	return countryStandardsFinder.getCommonStdCount(fromCountryCode, toCountryCode);
    }
}