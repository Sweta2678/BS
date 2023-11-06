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

import com.ihg.brandstandards.db.model.StandardsTranslate;
import com.ihg.brandstandards.db.service.base.StandardsTranslateLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the standards translate local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ihg.brandstandards.db.service.StandardsTranslateLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.StandardsTranslateLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.StandardsTranslateLocalServiceUtil
 */
public class StandardsTranslateLocalServiceImpl
	extends StandardsTranslateLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.StandardsTranslateLocalServiceUtil} to access the standards translate local service.
	 */

	public void clearCache()
    {
        try
        {
            standardsTranslatePersistence.clearCache();
        }
        catch (Exception e)
        {
        }
    }
	
    public List<StandardsTranslate> getStandardTranslateByStdId(long stdId) throws SystemException
    {
        return standardsTranslatePersistence.findByStdId(stdId);
    }
}