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
import java.util.List;

import com.ihg.brandstandards.db.NoSuchPublishStdException;
import com.ihg.brandstandards.db.model.PublishStd;
import com.ihg.brandstandards.db.model.impl.PublishStdImpl;
import com.ihg.brandstandards.db.service.ClpSerializer;
import com.ihg.brandstandards.db.service.PublishStdLocalServiceUtil;
import com.ihg.brandstandards.db.service.base.PublishStdLocalServiceBaseImpl;
import com.ihg.brandstandards.db.service.persistence.PublishStdFinderUtil;
import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;

/**
 * The implementation of the publish std local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ihg.brandstandards.db.service.PublishStdLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.PublishStdLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.PublishStdLocalServiceUtil
 */
public class PublishStdLocalServiceImpl extends PublishStdLocalServiceBaseImpl 
{
    private static final Log LOG = LogFactoryUtil.getLog(PublishStdLocalServiceImpl.class);
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.PublishStdLocalServiceUtil} to access the publish std local service.
	 */
    
    public void clearCache()
    {
        try
        {
            publishStdPersistence.clearCache();
        }
        catch (Exception e)
        {
        }
    }
    
    public PublishStd getPublishForStdId (long publishId, long standardId) throws NoSuchPublishStdException, SystemException 
    {
        return publishStdPersistence.findBypublishForStdId(publishId, standardId);
    }
    
    public List<PublishStd> getAssociatedStandards (long parentStdId) throws SystemException
    {
        return publishStdPersistence.findByparentPublishId(parentStdId);
    }
    
    public List getAssociatedStds (String query) 
    {
        List results;
        
        try
        {
            results = PublishStdFinderUtil.getAssociatedStds(query);
        }
        catch(Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
            results = new ArrayList();
        }
        return results;
    }
    
    public List<PublishStd> getStandardsByCountryAndBrand(long publishId, long taxonomyId, String chainCode, String countryCode, String stdType) throws SystemException
    {
        List<PublishStd> arlStandards = new ArrayList<PublishStd>();
        try
        {
            arlStandards = PublishStdFinderUtil.getStandardsByCountryAndBrand(publishId, taxonomyId, chainCode, countryCode, stdType);
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        return arlStandards;
    }
    
    public PublishStd getStandardByBrand( long standardId, long publishId) throws SystemException
    {
    	PublishStd publishStd = new PublishStdImpl();
    	List<PublishStd> arlPublishStd = new ArrayList<PublishStd>();
    	try
    	{
    	    ClassLoader portletClassLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader");
            DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(PublishStd.class, portletClassLoader);
            Criterion stdCriterion = RestrictionsFactoryUtil.eq("stdId", standardId);
            Criterion publishIdCriterion = RestrictionsFactoryUtil.eq("publishId", publishId);
            dynamicQuery.add(stdCriterion);
            dynamicQuery.add(publishIdCriterion);
            arlPublishStd = PublishStdLocalServiceUtil.dynamicQuery(dynamicQuery);
            for(PublishStd publishStandard:arlPublishStd)
            {
            	publishStd = publishStandard;
            }
    	}
    	catch(Exception e)
    	{
    		LOG.error(StackTraceUtil.getStackTrace(e));
    	}
    	return publishStd;
    }
}