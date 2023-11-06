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

import com.ihg.brandstandards.db.model.PublishCountryStandard;
import com.ihg.brandstandards.db.service.base.PublishCountryStandardLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the publish country standard local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ihg.brandstandards.db.service.PublishCountryStandardLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.PublishCountryStandardLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.PublishCountryStandardLocalServiceUtil
 */
public class PublishCountryStandardLocalServiceImpl
	extends PublishCountryStandardLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.PublishCountryStandardLocalServiceUtil} to access the publish country standard local service.
	 */
    
    public PublishCountryStandard getPublishCountryStandardByVerIdStdId(long publishVerId, String countryCode) throws SystemException {     
        return publishCountryStandardPersistence.fetchBypublishVerIdCountry(publishVerId, countryCode);
    }
    
    public void clearCache()
    {
        try
        {
            publishCountryStandardPersistence.clearCache();
        }
        catch (Exception e)
        {
        }
    }
}