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

import com.ihg.brandstandards.db.NoSuchBrandTaxonomyException;
import com.ihg.brandstandards.db.model.BrandTaxonomy;
import com.ihg.brandstandards.db.service.base.BrandTaxonomyLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the brand taxonomy local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their
 * definitions into the {@link com.ihg.brandstandards.db.service.BrandTaxonomyLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because
 * this service can only be accessed from within the same VM.
 * </p>
 * 
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.BrandTaxonomyLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.BrandTaxonomyLocalServiceUtil
 */
public class BrandTaxonomyLocalServiceImpl extends BrandTaxonomyLocalServiceBaseImpl
{
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.BrandTaxonomyLocalServiceUtil} to access the brand taxonomy local service.
     */
    public BrandTaxonomy getByTaxIdAndChainCd(long taxId, String chainCd) throws NoSuchBrandTaxonomyException, SystemException
    {
        return brandTaxonomyPersistence.findByTaxIdAndChainCd(taxId, chainCd);
    }
    
    public void clearCache()
    {
        try
        {
            brandTaxonomyPersistence.clearCache();
        }
        catch (Exception e)
        {
        }
    }
}