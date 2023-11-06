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

import com.ihg.brandstandards.db.model.ExternalLinkStandardsCountry;
import com.ihg.brandstandards.db.service.base.ExternalLinkStandardsCountryLocalServiceBaseImpl;
import com.ihg.brandstandards.db.service.persistence.ExternalLinkStandardsCountryUtil;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the external link standards country local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ihg.brandstandards.db.service.ExternalLinkStandardsCountryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.ExternalLinkStandardsCountryLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.ExternalLinkStandardsCountryLocalServiceUtil
 */
public class ExternalLinkStandardsCountryLocalServiceImpl
	extends ExternalLinkStandardsCountryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.ExternalLinkStandardsCountryLocalServiceUtil} to access the external link standards country local service.
	 */
	public List<ExternalLinkStandardsCountry> getExternalLinkStandardsCountryByextlLinkId(long extlLinkId) throws SystemException{
		return ExternalLinkStandardsCountryUtil.findByextLinkId(extlLinkId);
	}
	
	public void clearCache()
    {
        try
        {
            externalLinkStandardsCountryPersistence.clearCache();
        }
        catch (Exception e)
        {
        }
    }
}