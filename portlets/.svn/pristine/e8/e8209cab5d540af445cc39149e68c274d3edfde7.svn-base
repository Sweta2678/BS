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

import com.ihg.brandstandards.db.model.BridgePublishCountryStateEx;
import com.ihg.brandstandards.db.service.base.BridgePublishCountryStateExLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the bridge publish country state ex local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ihg.brandstandards.db.service.BridgePublishCountryStateExLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.BridgePublishCountryStateExLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.BridgePublishCountryStateExLocalServiceUtil
 */
public class BridgePublishCountryStateExLocalServiceImpl
	extends BridgePublishCountryStateExLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.BridgePublishCountryStateExLocalServiceUtil} to access the bridge publish country state ex local service.
	 */
    
    public List<BridgePublishCountryStateEx> getBridgePublishCountryStateEx(String chainCd, long regionCd) throws SystemException
    {
        return bridgePublishCountryStateExFinder.getBridgePublishCountryStateEx(chainCd, regionCd);
    }
    public void clearCache()
    {
        try
        {
            bridgePublishCountryStateExPersistence.clearCache();
        }
        catch (Exception e)
        {
        }
    }
}