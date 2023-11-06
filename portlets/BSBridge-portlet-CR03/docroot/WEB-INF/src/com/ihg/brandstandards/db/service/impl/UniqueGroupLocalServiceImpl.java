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
import java.util.Map;

import com.ihg.brandstandards.custom.model.GroupCountryDetails;
import com.ihg.brandstandards.db.model.BridgePublishPreview;
import com.ihg.brandstandards.db.model.GEMUniqueGroup;
import com.ihg.brandstandards.db.model.UniqueGroup;
import com.ihg.brandstandards.db.service.base.UniqueGroupLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * The implementation of the unique group local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ihg.brandstandards.db.service.UniqueGroupLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Akhani
 * @see com.ihg.brandstandards.db.service.base.UniqueGroupLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.UniqueGroupLocalServiceUtil
 */
public class UniqueGroupLocalServiceImpl extends UniqueGroupLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.UniqueGroupLocalServiceUtil} to access the unique group local service.
	 */
	
	private Log LOGGER = LogFactoryUtil.getLog(GEMUniqueGroupLocalServiceImpl.class);
	public void clearCache(){
		try {
			uniqueGroupPersistence.clearCache();
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
	}
	
	/**
	 * Get all unique country groups for current publication and region
	 * @param publishId
	 * @param regionId
	 * @return List<GEMUniqueGroup>
	 * @throws SystemException 
	 */
	public List<UniqueGroup> getUniqueGroupsByRegionAndPublication(long publishId, long regionId) throws SystemException {
		try {
			//Clear cache
			clearCache();
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		return uniqueGroupPersistence.findBypublicationAndRegion(publishId, regionId);
	}
	
	
	/**
	 * 
	 * @param publishId
	 * @param regionId
	 * @return List<GroupCountryDetails>
	 */
	public List<GroupCountryDetails> getGroupAndCountryDetails (long publishId, long regionId, String groupType) {
		return uniqueGroupFinder.getGroupAndCountryDetails(publishId, regionId, groupType);
	}

	/**
     * This method return a map of Groups and Group Countries where the standard belongs to.
     * @param publishId
     * @param regionId
     * @param groupType
     * @param stdId
     * @return Map<String, String>
     */
    public Map<String, String> getStdUniqueGrpAndCtrys(long publishId, long regionId, String groupType, String stdId){
    	return uniqueGroupFinder.getStdUniqueGrpAndCtrys(publishId, regionId, groupType, stdId);
    }
}