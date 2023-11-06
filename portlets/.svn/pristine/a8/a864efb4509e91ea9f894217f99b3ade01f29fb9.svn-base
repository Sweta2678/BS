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

import java.util.Collections;
import java.util.List;

import com.ihg.brandstandards.db.NoSuchGlossaryRegionNavException;
import com.ihg.brandstandards.db.model.GlossaryRegionNav;
import com.ihg.brandstandards.db.service.base.GlossaryRegionNavLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;

/**
 * The implementation of the glossary region nav local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their
 * definitions into the {@link com.ihg.brandstandards.db.service.GlossaryRegionNavLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because
 * this service can only be accessed from within the same VM.
 * </p>
 * 
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.GlossaryRegionNavLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.GlossaryRegionNavLocalServiceUtil
 */
public class GlossaryRegionNavLocalServiceImpl extends GlossaryRegionNavLocalServiceBaseImpl
{
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.GlossaryRegionNavLocalServiceUtil} to access the glossary region nav local service.
     */

    private static final Log LOG = LogFactoryUtil.getLog(GlossaryRegionNavLocalServiceImpl.class);
    
    public void clearCache()
    {
        try
        {
        	glossaryRegionNavPersistence.clearCache();
        }
        catch (Exception e)
        {
        }
    }
    
    /**
     * Get list of @GlossaryRegionNav object by glossaryId.
     * 
     * @param glossaryId GlossaryId of selected Glossary.
     * 
     * @return List of @GlossaryRegionNav object.
     * @throws SystemException SystemException throws if system request is fail.
     * */
    public List<GlossaryRegionNav> getRegionNavsByGlossaryId(long glossaryId) throws SystemException
    {
        return glossaryRegionNavPersistence.findByglossaryId(glossaryId);
    }

    public List<GlossaryRegionNav> getAllRegionNavs(long regionId, String status, String termChar)
    {
        return getAllRegionNavs(regionId, "CP", status, termChar);
    }

    public List<GlossaryRegionNav> getAllRegionNavs(long regionId, String chainCode, String status, String termChar)
    {
        List<GlossaryRegionNav> glossaryRegionNavs = Collections.emptyList();
        try
        {
            glossaryRegionNavs = glossaryRegionNavPersistence.findByglossaryRegionId(regionId, chainCode, status, termChar);
        }
        catch (SystemException e)
        {
            LOG.error(e.getMessage(), e);
        }

        return glossaryRegionNavs;
    }

    public List<GlossaryRegionNav> getAllRegionGlossaries(long regionId, String chainCode, String status)
    {
        List<GlossaryRegionNav> allGlossaryNavs = Collections.emptyList();
        try
        {
            allGlossaryNavs = glossaryRegionNavPersistence.findByallGlossaryRegionId(regionId, chainCode, status);
        }
        catch (SystemException e)
        {
            LOG.error(e.getMessage(), e);
        }

        return allGlossaryNavs;
    }

    public List<GlossaryRegionNav> getAllRegionGlossaries(long regionId, String status)
    {
        return getAllRegionGlossaries(regionId, "CP", status);
    }

    /**
     * Get List<GlossaryRegionNav> by Glossaryid, RegionId.
     * 
     * @param glossaryId Glossaryid.
     * @param regionId Regionid.
     * @throws SystemException SystemException.
     * @return List<GlossaryRegionNav> List<GlossaryRegionNav>.
     **/
    public List<GlossaryRegionNav> getListByGlossaryIdAndReginoId(long glossaryId, long regionId) throws SystemException
    {
        return glossaryRegionNavPersistence.findByglossaryIdAndRegionId(glossaryId, regionId);
    }

    /**
     * Get Brand comma seprate by Glossaryid and Regionid.
     * 
     * @param glossaryId Glossaryid.
     * @param regionId Regionid.
     * @throws SystemException SystemException.
     * @return String String.
     */
    public String getRegionCodesByglossaryIdAndRegionId(long glossaryId, long regionId) throws SystemException
    {
        String regionCodes = StringPool.BLANK;
        List<GlossaryRegionNav> list = getListByGlossaryIdAndReginoId(glossaryId, regionId);
        for (GlossaryRegionNav glossaryRegionNav : list)
        {
            regionCodes = regionCodes.concat(glossaryRegionNav.getChainCode()).concat(StringPool.COMMA_AND_SPACE);
        }
        if (regionCodes.length() > 0)
        {
            regionCodes = regionCodes.substring(0, regionCodes.length() - 2);
        }
        return regionCodes;
    }

    /**
     * Get GlossaryRegionNav by Glossaryid, Regionid, and ChainCode.
     * 
     * @param glossaryId Glossaryid.
     * @param regionId Regionid.
     * @param chainCode ChainCode.
     * @throws NoSuchGlossaryRegionNavException NoSuchGlossaryRegionNavException.
     * @throws SystemException SystemException.
     * @return GlossaryRegionNav GlossaryRegionNav.
     * 
     */
    public GlossaryRegionNav getGlossaryRegionNavByGlossaryIdRegionIdChainCode(long glossaryId, long regionId, String chainCode)
            throws NoSuchGlossaryRegionNavException, SystemException
    {
        return glossaryRegionNavPersistence.findByglossaryIdRegionIdChainCode(glossaryId, regionId, chainCode);
    }

    /**
     * Delete GlossaryRegionNav by Glossaryid, Regionid, and ChainCode.
     * 
     * @see com.ihg.brandstandards.db.service.GlossaryRegionNavLocalService#removeByGlossaryIdRegionIdChainCode(long,
     *      long, java.lang.String)
     * @param glossaryId Glossaryid.
     * @param regionId Regionid.
     * @param chainCode ChainCode.
     * @throws NoSuchGlossaryRegionNavException NoSuchGlossaryRegionNavException.
     * @throws SystemException SystemException.
     * @return void void.
     */
    public void removeByGlossaryIdRegionIdChainCode(long glossaryId, long regionId, String chainCode)
            throws NoSuchGlossaryRegionNavException, SystemException
    {
        glossaryRegionNavPersistence.removeByglossaryIdRegionIdChainCode(glossaryId, regionId, chainCode);
    }

    /**
     * Get list of object of @GlossaryRegionNav by passing chaincode, navItemText.
     * 
     * @param chainCode User selected chain code.
     * @param navItemText User selected glossary Nav text.
     * 
     * @return List of @GlossaryRegionNav object.
     * @throws SystemException SystemException throws if system request is fail.
     * */
    public List<GlossaryRegionNav> getGlossayByBrand(String chainCode, String navItemText) throws SystemException
    {
        return glossaryRegionNavPersistence.findByglossaryByChainCode(chainCode, navItemText);
    }

    /**
     * Remove Glossay Region Nav entry from database by passing glossary Id
     * 
     * @param glossaryId Glossary Id to passed for which region nav entry need to delete.
     * 
     * @throws SystemException SystemException throws if system request is fail.
     * */
    public void removeGlossayRegionByGlossayId(long glossaryId) throws SystemException
    {
        glossaryRegionNavPersistence.removeByglossaryId(glossaryId);
    }
}