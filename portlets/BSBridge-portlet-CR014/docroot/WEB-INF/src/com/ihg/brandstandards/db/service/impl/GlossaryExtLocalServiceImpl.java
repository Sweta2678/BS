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

import com.ihg.brandstandards.db.model.GlossaryExt;
import com.ihg.brandstandards.db.service.base.GlossaryExtLocalServiceBaseImpl;
import com.ihg.brandstandards.db.service.persistence.GlossaryExtFinderUtil;

/**
 * The implementation of the glossary ext local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ihg.brandstandards.db.service.GlossaryExtLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.GlossaryExtLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.GlossaryExtLocalServiceUtil
 */
public class GlossaryExtLocalServiceImpl extends GlossaryExtLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.GlossaryExtLocalServiceUtil} to access the glossary ext local service.
	 */
    
    /**
     * Get Glossary By Brand code and char selected as input.
     * 
     * @param brandCode  User selected Brand code.
     * @param visibleChar User Selected first char of Glossary.
     * 
     * @return List of @GlossaryExt object.
     */
    public List<GlossaryExt> getGlossaryByBrandCodeAndVisibleChar(String brandCode, String visibleChar)
    {
        return GlossaryExtFinderUtil.getGlossaryByBrandCodeAndVisibleChar(brandCode, visibleChar);
    }
    public void clearCache()
    {
        try
        {
            glossaryExtPersistence.clearCache();
        }
        catch (Exception e)
        {
        }
    }
}