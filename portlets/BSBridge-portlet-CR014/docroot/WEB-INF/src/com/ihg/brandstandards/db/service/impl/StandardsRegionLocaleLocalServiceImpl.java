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

import com.ihg.brandstandards.db.NoSuchStandardsRegionLocaleException;
import com.ihg.brandstandards.db.model.StandardsRegionLocale;
import com.ihg.brandstandards.db.model.impl.StandardsRegionLocaleImpl;
import com.ihg.brandstandards.db.service.base.StandardsRegionLocaleLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the standards region locale local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their
 * definitions into the {@link com.ihg.brandstandards.db.service.StandardsRegionLocaleLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because
 * this service can only be accessed from within the same VM.
 * </p>
 * 
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.StandardsRegionLocaleLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.StandardsRegionLocaleLocalServiceUtil
 */
public class StandardsRegionLocaleLocalServiceImpl extends StandardsRegionLocaleLocalServiceBaseImpl
{
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.StandardsRegionLocaleLocalServiceUtil} to access the standards region locale local service.
     */
    public StandardsRegionLocale getStandardsRegionLocaleObject(){
        return new StandardsRegionLocaleImpl();
    }
    
    public void clearCache()
    {
        try
        {
            standardsRegionLocalePersistence.clearCache();
        }
        catch (Exception e)
        {
        }
    }
    
    public List<StandardsRegionLocale> getStandardsRegionLocaleByRegionId(long regionId) throws SystemException
    {
        return standardsRegionLocalePersistence.findByregionId(regionId);
    }

    public StandardsRegionLocale getDefaultRegionLocale(long regionId, String isDefault)
            throws NoSuchStandardsRegionLocaleException, SystemException
    {
        return standardsRegionLocalePersistence.findByregionIdIsDefault(isDefault, regionId);
    }

    public StandardsRegionLocale getLocaleByRegId(String localeId, long rgnId) throws SystemException,
            NoSuchStandardsRegionLocaleException
    {
        return standardsRegionLocalePersistence.findBylocaleCodeRegionId(localeId, rgnId);
    }

    public void delAllRegionLocale() throws SystemException
    {
        standardsRegionLocalePersistence.removeAll();
    }
}