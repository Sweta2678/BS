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

import com.ihg.brandstandards.db.model.BrandTaxonomyTranslate;
import com.ihg.brandstandards.db.model.impl.BrandTaxonomyTranslateImpl;
import com.ihg.brandstandards.db.service.base.BrandTaxonomyTranslateLocalServiceBaseImpl;
import com.ihg.brandstandards.db.service.persistence.BrandTaxonomyTranslatePK;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the brand taxonomy translate local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their
 * definitions into the {@link com.ihg.brandstandards.db.service.BrandTaxonomyTranslateLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because
 * this service can only be accessed from within the same VM.
 * </p>
 * 
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.BrandTaxonomyTranslateLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.BrandTaxonomyTranslateLocalServiceUtil
 */
public class BrandTaxonomyTranslateLocalServiceImpl extends BrandTaxonomyTranslateLocalServiceBaseImpl
{
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.BrandTaxonomyTranslateLocalServiceUtil} to access the brand taxonomy translate local service.
     */
    public BrandTaxonomyTranslate getBrandTaxonomyTranslateObject(){
       return new BrandTaxonomyTranslateImpl();
    }
    public BrandTaxonomyTranslate getTaxTransByTaxLangId(long taxId, String localeCd) throws SystemException
    {
        BrandTaxonomyTranslatePK brandTaxonomyTranslatePK = new BrandTaxonomyTranslatePK(taxId, localeCd);
        return brandTaxonomyTranslatePersistence.fetchByPrimaryKey(brandTaxonomyTranslatePK);
    }

    public BrandTaxonomyTranslate addTaxonomyTranslation(BrandTaxonomyTranslate brandTaxonomyTranslation) throws SystemException
    {
        return brandTaxonomyTranslatePersistence.update(brandTaxonomyTranslation);
    }
    public void clearCache()
    {
        try
        {
            brandTaxonomyTranslatePersistence.clearCache();
        }
        catch (Exception e)
        {
        }
    }
}