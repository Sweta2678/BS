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
import java.util.Map;

import com.ihg.brandstandards.db.NoSuchBridgePublishLangException;
import com.ihg.brandstandards.db.model.BridgePublishLang;
import com.ihg.brandstandards.db.service.base.BridgePublishLangLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the bridge publish lang local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their
 * definitions into the {@link com.ihg.brandstandards.db.service.BridgePublishLangLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because
 * this service can only be accessed from within the same VM.
 * </p>
 * 
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.BridgePublishLangLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.BridgePublishLangLocalServiceUtil
 */
public class BridgePublishLangLocalServiceImpl extends BridgePublishLangLocalServiceBaseImpl
{
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.BridgePublishLangLocalServiceUtil} to access the bridge publish lang local service.
     */
    public void clearCache()
    {
        bridgePublishLangPersistence.clearCache();
    }

    public BridgePublishLang getByRegionAndLocale(long publishId, long regionId, String localeCode) throws SystemException,
            NoSuchBridgePublishLangException
    {
        bridgePublishLangPersistence.clearCache();
        return bridgePublishLangPersistence.findByRegionAndLocale(publishId, regionId, localeCode);
    }

    public List<BridgePublishLang> getByRegion(long publishId, long regionId) throws SystemException
    {
        return bridgePublishLangPersistence.findByRegion(publishId, regionId);
    }

    /**
     * @param query
     */
    public Map<String, String> getAllLanguagesForPublication(long publishId)
    {
        return this.bridgePublishLangFinder.getAllLanguagesForPublication(publishId);
    }
}