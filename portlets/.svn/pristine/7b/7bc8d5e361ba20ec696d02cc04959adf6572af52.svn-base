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
import java.util.Map;

import com.ihg.brandstandards.db.model.StandardsLocale;
import com.ihg.brandstandards.db.service.base.StandardsLocaleLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;

/**
 * The implementation of the standards locale local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ihg.brandstandards.db.service.StandardsLocaleLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.StandardsLocaleLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.StandardsLocaleLocalServiceUtil
 */
public class StandardsLocaleLocalServiceImpl extends StandardsLocaleLocalServiceBaseImpl 
{
    private static final Log LOG = LogFactoryUtil.getLog(StandardsLocaleLocalServiceImpl.class);
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.StandardsLocaleLocalServiceUtil} to access the standards locale local service.
	 */
    
    public void clearCache()
    {
        try
        {
        	standardsLocalePersistence.clearCache();
        }
        catch (Exception e)
        {
        }
    }
    
    public List<StandardsLocale> getBrandStandardsLocale()throws SystemException 
    {
        return standardsLocalePersistence.findByActiveStatus("Y");
    }
    
    public List<StandardsLocale> getLanguagesByRegion(String regionCode) throws SystemException
    {
        List<StandardsLocale> arlLanguages = new ArrayList<StandardsLocale>();
        try
        {
            arlLanguages = standardsLocaleFinder.getLanguagesByRegion(regionCode);
        }
        catch(Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        return arlLanguages;
    }
    
    public Map<String, String> getActiveLanguages(String query) throws SystemException
    {
        return standardsLocaleFinder.getActiveLanguages(query);
    }
}