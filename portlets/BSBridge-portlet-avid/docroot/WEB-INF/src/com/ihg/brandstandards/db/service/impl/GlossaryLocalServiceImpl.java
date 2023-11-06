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

import com.ihg.brandstandards.db.model.Glossary;
import com.ihg.brandstandards.db.service.base.GlossaryLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * The implementation of the glossary local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their
 * definitions into the {@link com.ihg.brandstandards.db.service.GlossaryLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because
 * this service can only be accessed from within the same VM.
 * </p>
 * 
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.GlossaryLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.GlossaryLocalServiceUtil
 */
public class GlossaryLocalServiceImpl extends GlossaryLocalServiceBaseImpl
{
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.GlossaryLocalServiceUtil} to access the glossary local service.
     */

    private static final Log LOG = LogFactoryUtil.getLog(GlossaryLocalServiceImpl.class);

    public Glossary getGlossaries(String startChar, long glossaryId)
    {
        String likeChar = startChar + "%";
        Glossary glossary = null;
        List<Glossary> glossaryList = null;
        try
        {
        	glossaryList = glossaryPersistence.findByglossaryId(glossaryId, likeChar);
        }
        catch (Exception e)
        {
            LOG.error(e.getMessage(), e);
        }
        if(glossaryList != null && glossaryList.size() > 0){
        	glossary = glossaryList.get(0);
        }
        return glossary;
    }

    public Glossary getGlossaryByTermText(String termTxt) throws SystemException
    {
        return glossaryPersistence.fetchByglossaryTermText(termTxt, false);
    }

    /**
     * Get Glossary by brandCode.
     * 
     * @see com.ihg.brandstandards.db.service.GlossaryLocalService#getGlossaryIdByBrandCode(java.lang.String)
     * @param brandCode BrandCode.
     * @return List<Glossary> List of Glossary.
     */
    public List<Glossary> getGlossaryIdByBrandCode(String brandCode)
    {
        return glossaryFinder.getGlossaryIdByBrandCode(brandCode);
    }

    public void clearCache()
    {
        try
        {
            glossaryPersistence.clearCache();
        }
        catch (Exception e)
        {
        }
    }
}