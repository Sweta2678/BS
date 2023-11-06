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

import com.ihg.brandstandards.db.NoSuchGEMManagementIdException;
import com.ihg.brandstandards.db.model.GEMManagementId;
import com.ihg.brandstandards.db.service.base.GEMManagementIdLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the g e m management ID local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ihg.brandstandards.db.service.GEMManagementIdLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.GEMManagementIdLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.GEMManagementIdLocalServiceUtil
 */
public class GEMManagementIdLocalServiceImpl
	extends GEMManagementIdLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.GEMManagementIdLocalServiceUtil} to access the g e m management ID local service.
	 */
	
	/**
	 * 
	 * @param regionId
	 * @param subBrandCode
	 * @return Map<String, Map<Stirng, String>>
	 */
	public List<GEMManagementId> getManagementIdsByRegionAndBrand(long regionId, String subBrandCodes) {
		return gemManagementIdFinder.getManagementIdsByRegionAndBrand(regionId, subBrandCodes);
	}

	/**
	 * 
	 * @param countryCode
	 * @param chainCode
	 * @return Map<String, Map<Stirng, String>>
	 * @throws SystemException 
	 * @throws NoSuchGEMManagementIdException 
	 */
	public GEMManagementId getManagementIdsByCountryAndBrand(String countryCode, String chainCode) throws SystemException, NoSuchGEMManagementIdException {
		return gemManagementIdPersistence.findByCountryCodeAndChainCode(countryCode, chainCode);
	}
	
	public void clearCache()
    {
        try
        {
            gemManagementIdPersistence.clearCache();
        }
        catch (Exception e)
        {
        }
    }

}