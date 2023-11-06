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

import com.ihg.brandstandards.db.NoSuchGlossaryTranslateException;
import com.ihg.brandstandards.db.model.GlossaryTranslate;
import com.ihg.brandstandards.db.model.impl.GlossaryTranslateImpl;
import com.ihg.brandstandards.db.service.base.GlossaryTranslateLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * The implementation of the glossary translate local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their
 * definitions into the {@link com.ihg.brandstandards.db.service.GlossaryTranslateLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because
 * this service can only be accessed from within the same VM.
 * </p>
 * 
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.GlossaryTranslateLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.GlossaryTranslateLocalServiceUtil
 */
public class GlossaryTranslateLocalServiceImpl extends GlossaryTranslateLocalServiceBaseImpl
{
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.GlossaryTranslateLocalServiceUtil} to access the glossary translate local service.
     */
    private static final Log LOG = LogFactoryUtil.getLog(GlossaryTranslateLocalServiceImpl.class);
    
    public void clearCache()
    {
        try
        {
            glossaryTranslatePersistence.clearCache();
        }
        catch (Exception e)
        {
        }
    }
    
    public GlossaryTranslate getGlossaryTranslateObject(){
        return new GlossaryTranslateImpl();
    }
    public List<GlossaryTranslate> getGlossarriesByGlossaryId(long glossaryId) throws SystemException
    {
        List<GlossaryTranslate> glossarries = null;
        try
        {
            glossarries = glossaryTranslatePersistence.findByGlossaryId(glossaryId);
        } catch(Exception e)
        {
            LOG.error(e.getMessage(), e);
        }
        return glossarries;
    }

    /**
     * Get GlosasryTranslate by glossaryId, localeCode.
     * 
     * @param glossaryId Glossaryid.
     * @param localeCode localeCode.
     * @throws SystemException SystemException.
     * @throws NoSuchGlossaryTranslateException NoSuchGlossaryTranslateException.
     * @return GlosasryTranslate GlosasryTranslate.
     */
    public GlossaryTranslate getByGlossaryIdLocaleCode(long glossaryId, String localeCode)
            throws NoSuchGlossaryTranslateException, SystemException
    {
        // return GlossaryTranslateUtil.findByglossaryIdLocaleCode(glossaryId, localeCode);
        // return glossaryTranslatePersistence.fetchByglossaryIdLocaleCode(glossaryId, localeCode, false);
        return glossaryTranslatePersistence.fetchByglossaryIdLocaleCode(glossaryId, localeCode, false);
    }
    
    public GlossaryTranslate getGlossaryByLangCd(long glossaryId, String langCode)
    {
        GlossaryTranslate glossaryTranslate = null;
        try
        {
            glossaryTranslate = glossaryTranslatePersistence.fetchByglossaryIdLocaleCode(glossaryId, langCode);
        }
        catch (Exception e)
        {
            LOG.error(e.getMessage(), e);
        }
        return glossaryTranslate;
    }

    /**
     * Get lsit GlosasryTranslate by localeCode.
     * 
     * @param regionId Regionid.
     * @return List<GlossaryTranslate> List<GlossaryTranslate>.
     */
    public List<GlossaryTranslate> getByLocaleCode(String localeCode) throws SystemException
    {
        return glossaryTranslatePersistence.findBylangCode(localeCode);
    }

    /**
     * Remove Glossay translate entry from database by passing glossary Id
     * 
     * @param glossaryId Glossary Id to passed for which translate need to delete.
     * 
     * @throws SystemException SystemException throws if system request is fail.
     * */
    public void removeGlossaryTranslateByGlossaryId(long glossaryId) throws SystemException
    {
        glossaryTranslatePersistence.removeByGlossaryId(glossaryId);
    }
}