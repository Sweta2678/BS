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

import com.ihg.brandstandards.db.model.HistManualChain;
import com.ihg.brandstandards.db.model.impl.HistManualChainImpl;
import com.ihg.brandstandards.db.service.base.HistManualChainLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the hist manual chain local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ihg.brandstandards.db.service.HistManualChainLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.HistManualChainLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.HistManualChainLocalServiceUtil
 */
public class HistManualChainLocalServiceImpl
	extends HistManualChainLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.HistManualChainLocalServiceUtil} to access the hist manual chain local service.
	 */
    public HistManualChain getHistManualChainObject(){
        return new HistManualChainImpl();
    }
    
    public List<HistManualChain> getManualChainById(long manualId) throws SystemException
    {
        return histManualChainPersistence.findByhistManualId(manualId);
    }
    public void clearCache()
    {
        try
        {
            histManualChainPersistence.clearCache();
        }
        catch (Exception e)
        {
        }
    }
}