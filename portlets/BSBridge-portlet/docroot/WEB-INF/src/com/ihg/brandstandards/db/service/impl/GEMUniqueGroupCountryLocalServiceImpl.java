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

import com.ihg.brandstandards.db.service.base.GEMUniqueGroupCountryLocalServiceBaseImpl;

/**
 * The implementation of the g e m unique group country local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ihg.brandstandards.db.service.GEMUniqueGroupCountryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.GEMUniqueGroupCountryLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.GEMUniqueGroupCountryLocalServiceUtil
 */
public class GEMUniqueGroupCountryLocalServiceImpl
	extends GEMUniqueGroupCountryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.GEMUniqueGroupCountryLocalServiceUtil} to access the g e m unique group country local service.
	 */
	
	public void clearCache(){
		try {
			gemUniqueGroupCountryPersistence.clearCache();
		} catch (Exception e) {
		}
	}
	
	/**
	 * 
	 * @param groupName
	 * @param publishId
	 * @param regionId
	 * @return String
	 */
	public String getCountryListOfUniqueGroup (String groupName, String groupType, long publishId, long regionId) {
		return gemUniqueGroupCountryFinder.getCountryListOfUniqueGroup(groupName, groupType, publishId, regionId);
	}
	
	/**
	 * 
	 * @param groupId
	 * @return String
	 */
	public String getCountryListOfUniqueGroup (long groupId) {
		return gemUniqueGroupCountryFinder.getCountryListOfUniqueGroup(groupId);
	}
}