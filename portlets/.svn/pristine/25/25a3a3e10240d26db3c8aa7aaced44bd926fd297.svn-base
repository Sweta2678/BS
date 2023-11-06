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

import com.ihg.brandstandards.custom.model.CountryList;
import com.ihg.brandstandards.db.model.BridgePublishPreview;
import com.ihg.brandstandards.db.service.base.BridgePublishPreviewLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the bridge publish preview local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ihg.brandstandards.db.service.BridgePublishPreviewLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.BridgePublishPreviewLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.BridgePublishPreviewLocalServiceUtil
 */
public class BridgePublishPreviewLocalServiceImpl
	extends BridgePublishPreviewLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.BridgePublishPreviewLocalServiceUtil} to access the bridge publish preview local service.
	 */
    
    public List<BridgePublishPreview> getBridgePublishPreviewByRegionBrand(String chainCd, long regionCd) throws SystemException
    {
        return null;//getBridgePublishPreviewByRegionBrand(chainCd, regionCd, null, null, null, null, null);
    }
    
    public List<BridgePublishPreview> getBridgePublishPreview(String groupName, String chainCd, long regionId, String filterIds, String searchIds, String selByState, 
			String locale, long bridgePublishId, String groupType)
    {
        return bridgePublishPreviewFinder.getBridgePublishPreview(groupName, chainCd, regionId, filterIds, 
        		searchIds, selByState, locale, bridgePublishId, groupType);
    }

	public List<BridgePublishPreview> searchStandardsById(String stdIds,String brand,boolean isMust) throws SystemException
	{
	    return bridgePublishPreviewFinder.getStandardsById(stdIds,brand,isMust);
	    
	}
	
	public List<CountryList> getGroupsByCountryStatus (String query) {
		return bridgePublishPreviewFinder.getGroupsByCountryStatus(query);
	}
}