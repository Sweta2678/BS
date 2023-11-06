/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.ihg.brandstandards.db.service.impl;

import java.util.List;

import com.ihg.brandstandards.db.model.CountryStandardsExt;
import com.ihg.brandstandards.db.service.base.CountryStandardsExtLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the country standards ext local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ihg.brandstandards.db.service.CountryStandardsExtLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.CountryStandardsExtLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.CountryStandardsExtLocalServiceUtil
 */
public class CountryStandardsExtLocalServiceImpl
	extends CountryStandardsExtLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.CountryStandardsExtLocalServiceUtil} to access the country standards ext local service.
	 */
	public List<CountryStandardsExt> getCountriesByStandard(long stdId) throws SystemException
	{
		return countryStandardsExtFinder.getCountriesByStandard(stdId);
	}
	
	public List<Object> getRegionsCountryCount(long stdId) 
	{
		return countryStandardsExtFinder.getRegionsCountryCount(stdId);
	}
	public void clearCache()
    {
        try
        {
            countryStandardsExtPersistence.clearCache();
        }
        catch (Exception e)
        {
        }
    }
	
}