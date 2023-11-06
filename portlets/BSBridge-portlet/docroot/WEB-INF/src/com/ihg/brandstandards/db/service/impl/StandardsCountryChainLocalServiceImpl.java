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

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ihg.brandstandards.db.model.StandardsCountryChain;
import com.ihg.brandstandards.db.service.ClpSerializer;
import com.ihg.brandstandards.db.service.StandardsCountryChainLocalServiceUtil;
import com.ihg.brandstandards.db.service.base.StandardsCountryChainLocalServiceBaseImpl;
import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * The implementation of the standards country chain local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their
 * definitions into the {@link com.ihg.brandstandards.db.service.StandardsCountryChainLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because
 * this service can only be accessed from within the same VM.
 * </p>
 * 
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.StandardsCountryChainLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.StandardsCountryChainLocalServiceUtil
 */
public class StandardsCountryChainLocalServiceImpl extends StandardsCountryChainLocalServiceBaseImpl
{
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.StandardsCountryChainLocalServiceUtil} to access the standards country chain local service.
     */
    private static final Log LOG = LogFactoryUtil.getLog(StandardsCountryChainLocalServiceImpl.class);

    public void clearCache()
    {
        try
        {
            standardsCountryChainPersistence.clearCache();
        }
        catch (Exception e)
        {
        }
    }
    
    public List<StandardsCountryChain> getStandardsCountryChain(long stdId, String chainCode, Date compDate)
            throws SystemException
    {
        return standardsCountryChainPersistence.findBystdIdDateChCode(stdId, chainCode, compDate);
    }

    public List<StandardsCountryChain> getStandardsCountryChains(long stdId, String chainCode, Date startDate)
    {
        List<StandardsCountryChain> stdCountries = Collections.emptyList();
        Calendar c = Calendar.getInstance();
        c.setTime(startDate);
        c.add(Calendar.DATE, 1);
        Date endDate = c.getTime();
        ClassLoader portletClassLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader");
        DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(StandardsCountryChain.class, portletClassLoader);
        dynamicQuery.add(RestrictionsFactoryUtil.between("compDate", startDate, endDate));
        dynamicQuery.add(PropertyFactoryUtil.forName("primaryKey.stdId").eq(new Long(stdId)));
        dynamicQuery.add(PropertyFactoryUtil.forName("primaryKey.chainCode").eq(chainCode));
        try
        {
            stdCountries = StandardsCountryChainLocalServiceUtil.dynamicQuery(dynamicQuery);
        }
        catch (SystemException e)
        {
            LOG.error("Error while fetching standards country chain records" + e.getMessage());
        }
        return stdCountries;
    }
    
    public List<StandardsCountryChain> getStandardsChainRegion(long stdId, String chainCode, String regionCode) throws SystemException
    {
        return standardsCountryChainPersistence.findByStdIdChainRegion(stdId, chainCode, regionCode);
    }
    
    public List<StandardsCountryChain> getStandardsChain(long stdId, String chainCode) throws SystemException
    {
        return standardsCountryChainPersistence.findByStdIdChain(stdId, chainCode);
    }
    
    /**
     * Update Compliance Deadline for specified countries or whole region.
     * @param stdId standard id
     * @param compDatesMap country code / compliance deadline map
     * @param brandCode brand code
     * @param regionCode region code
     */
    public String updateComplianceDeadline(Long stdId, Map<String, Date> compDatesMap, String brandCode, String regionCode)  throws SystemException
    {
        return standardsCountryChainFinder.updateComplianceDeadline(stdId, compDatesMap, brandCode, regionCode);
    }
    
    
    public String  getDefaultComplianceDate(long stdId,String chainCD,String regionCd){
    	
    	return standardsCountryChainFinder.getDefaultComplianceDate(stdId,chainCD,regionCd);
    }
    
 public String  getDefaulExpiryDate(long stdId,String chainCD,String regionCd){
    	
    	return standardsCountryChainFinder.getDefaulExpiryDate(stdId,chainCD,regionCd);
    }
}