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

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ihg.brandstandards.db.NoSuchStandardsRegionChainException;
import com.ihg.brandstandards.db.model.CountryStandards;
import com.ihg.brandstandards.db.model.Standards;
import com.ihg.brandstandards.db.model.StandardsRegionChain;
import com.ihg.brandstandards.db.service.base.StandardsRegionChainLocalServiceBaseImpl;
import com.ihg.brandstandards.db.service.persistence.StandardsRegionChainPK;
import com.ihg.brandstandards.util.BSCommonConstants;
import com.ihg.brandstandards.util.BSCommonUtil;
import com.ihg.brandstandards.util.BrandStandardsUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

/**
 * The implementation of the standards region chain local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their
 * definitions into the {@link com.ihg.brandstandards.db.service.StandardsRegionChainLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because
 * this service can only be accessed from within the same VM.
 * </p>
 * 
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.StandardsRegionChainLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.StandardsRegionChainLocalServiceUtil
 */
public class StandardsRegionChainLocalServiceImpl extends StandardsRegionChainLocalServiceBaseImpl
{
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.StandardsRegionChainLocalServiceUtil} to access the standards region chain local service.
     */
    private static final Log LOG = LogFactoryUtil.getLog(StandardsRegionChain.class);

    public void clearCache()
    {
        try
        {
            standardsRegionChainPersistence.clearCache();
        }
        catch (Exception e)
        {
        }
    }
    
    public void deleteStandardsRegionChainByStdIdChnCd(long stdId, String chainCode) throws SystemException
    {
        standardsRegionChainPersistence.removeBystdIdChnCd(stdId, chainCode);
    }

    public List<StandardsRegionChain> getStandardsRgnchainByStdId(long stdId, String chainCode) throws SystemException
    {
        return standardsRegionChainPersistence.findBystdIdChnCd(stdId, chainCode);
    }

    public void cleanUpDataUtility()
    {
        List<Standards> allStandards = new ArrayList<Standards>();
        try
        {
            allStandards = standardsPersistence.findAll();
        }
        catch (SystemException e)
        {
            LOG.error("SystemException in getting all standards" + e.getMessage());
        }
        for (Standards standard : allStandards)
        {
            Set<String> allRegions = new HashSet<String>();
            Set<String> assignedRegions = new HashSet<String>();
            try
            {
                assignedRegions = getRegions(standard, allRegions);
            }
            catch (SystemException e)
            {
                LOG.error("SystemException in getting assigned regions " + e.getMessage());
            }
            Map<String, String> chnCdMap = BrandStandardsUtil.chainCodeMap();
            Set<String> chainCodes = chnCdMap.keySet();

            Date currDate = new Date();
            for (String chainCode : chainCodes)
            {
                try
                {
                    if (BSCommonUtil.isBrandAssigned(standard, chainCode)
                            || BSCommonUtil.isStandardPublished(standard.getStdId(), chainCode))
                    {
                        for (String region : allRegions)
                        {
                            StandardsRegionChainPK stdRgnChainPK = new StandardsRegionChainPK();
                            stdRgnChainPK.setChainCode(chainCode);
                            stdRgnChainPK.setStdId(standard.getStdId());
                            stdRgnChainPK.setRegionCode(region);
                            StandardsRegionChain stdRgnChain;
                            try
                            {
                                stdRgnChain = standardsRegionChainPersistence.findByPrimaryKey(stdRgnChainPK);
                                if (Validator.isNotNull(stdRgnChain))
                                {
                                    if (stdRgnChain.getComplianceRule() == -1L && assignedRegions.contains(region))
                                    {
                                        stdRgnChain.setComplianceRule(0L);
                                        standardsRegionChainPersistence.update(stdRgnChain);
                                    }
                                    else if (stdRgnChain.getComplianceRule() != -1L && !assignedRegions.contains(region))
                                    {
                                        stdRgnChain.setComplianceRule(-1L);
                                        standardsRegionChainPersistence.update(stdRgnChain);
                                    }
                                }
                            }
                            catch (NoSuchStandardsRegionChainException e)
                            {
                                stdRgnChain = standardsRegionChainPersistence.create(stdRgnChainPK);
                                if (assignedRegions.contains(region))
                                {
                                    stdRgnChain.setComplianceRule(0L);
                                }
                                else
                                {
                                    stdRgnChain.setComplianceRule(-1L);
                                }
                                stdRgnChain.setCreatedDate(currDate);
                                stdRgnChain.setCreatorId(standard.getCreatedBy());
                                stdRgnChain.setUpdatedBy(standard.getCreatedBy());
                                stdRgnChain.setUpdatedDate(currDate);
                                standardsRegionChainPersistence.update(stdRgnChain);
                            }
                        }
                    }
                    else
                    {
                        for (String region : allRegions)
                        {
                            StandardsRegionChainPK stdRgnChainPK = new StandardsRegionChainPK();
                            stdRgnChainPK.setChainCode(chainCode);
                            stdRgnChainPK.setStdId(standard.getStdId());
                            stdRgnChainPK.setRegionCode(region);
                            StandardsRegionChain stdRgnChain;
                            try
                            {
                                stdRgnChain = standardsRegionChainPersistence.findByPrimaryKey(stdRgnChainPK);
                                if (Validator.isNotNull(stdRgnChain))
                                {
                                    if (stdRgnChain.getComplianceRule() != -1L)
                                    {
                                        stdRgnChain.setComplianceRule(-1L);
                                        stdRgnChain.setUpdatedBy(standard.getCreatedBy());
                                        stdRgnChain.setUpdatedDate(currDate);
                                        standardsRegionChainPersistence.update(stdRgnChain);
                                    }
                                }
                            }
                            catch (NoSuchStandardsRegionChainException e)
                            {
                                stdRgnChain = standardsRegionChainPersistence.create(stdRgnChainPK);
                                stdRgnChain.setComplianceRule(-1L);
                                stdRgnChain.setCreatedDate(currDate);
                                stdRgnChain.setCreatorId(standard.getCreatedBy());
                                stdRgnChain.setUpdatedBy(standard.getCreatedBy());
                                stdRgnChain.setUpdatedDate(currDate);
                                standardsRegionChainPersistence.update(stdRgnChain);
                            }
                        }
                    }
                }
                catch (SystemException e)
                {
                    LOG.error("SystemException in getting assigned brands " + e.getMessage());
                }
            }

        }
    }

    public Set<String> getRegions(Standards standard, Set<String> allRegions) throws SystemException
    {
        List<CountryStandards> countryStd = countryStandardsPersistence.findByStdId(standard.getStdId());
        Set<String> assignedRegions = new HashSet<String>();
        allRegions.add(BSCommonConstants.REGION_AMEA);
        allRegions.add(BSCommonConstants.REGION_AMER);
        allRegions.add(BSCommonConstants.REGION_GC);
        allRegions.add(BSCommonConstants.REGION_EUROPE);
        allRegions.add(BSCommonConstants.REGION_GLBL);
        Map<String, Map<String, String>> allCountries = BSCommonUtil.getCountries();
        if (Validator.isNotNull(countryStd))
        {
            for (CountryStandards assignedCountry : countryStd)
            {
                if (Validator.isNotNull(allCountries.get(BSCommonConstants.REGION_AMEA))
                        && allCountries.get(BSCommonConstants.REGION_AMEA).containsKey(assignedCountry.getCountry()))
                {
                    assignedRegions.add(BSCommonConstants.REGION_AMEA);
                }
                else if (Validator.isNotNull(allCountries.get(BSCommonConstants.REGION_AMER))
                        && allCountries.get(BSCommonConstants.REGION_AMER).containsKey(assignedCountry.getCountry()))
                {
                    assignedRegions.add(BSCommonConstants.REGION_AMER);
                }
                else if (Validator.isNotNull(allCountries.get(BSCommonConstants.REGION_GC))
                        && allCountries.get(BSCommonConstants.REGION_GC).containsKey(assignedCountry.getCountry()))
                {
                    assignedRegions.add(BSCommonConstants.REGION_GC);
                }
                else if (Validator.isNotNull(allCountries.get(BSCommonConstants.REGION_EUROPE))
                        && allCountries.get(BSCommonConstants.REGION_EUROPE).containsKey(assignedCountry.getCountry()))
                {
                    assignedRegions.add(BSCommonConstants.REGION_EUROPE);
                }
            }
        }
        // Adding GLBL region for GLBL standard
        if (standard.getRegionCode().equals(BSCommonConstants.REGION_GLBL))
        {
            assignedRegions.add(BSCommonConstants.REGION_GLBL);
        }
        return assignedRegions;
    }

    public StandardsRegionChain getByStandardsRegionChain(long stdId, String regionCode, String chainCode){
        StandardsRegionChain standardsRegionChain = null;
        try
        {
            standardsRegionChain = standardsRegionChainPersistence.findBystdIdRgnCdChnCd(stdId, regionCode, chainCode);
        }
        catch (Exception e)
        {
            LOG.error(e);
        }
        return standardsRegionChain;
    }
}