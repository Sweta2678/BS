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

import com.ihg.brandstandards.db.NoSuchFlagCategoryException;
import com.ihg.brandstandards.db.model.FlagCategory;
import com.ihg.brandstandards.db.service.base.FlagCategoryLocalServiceBaseImpl;
import com.ihg.brandstandards.db.service.persistence.FlagCategoryPK;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the flag category local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their
 * definitions into the {@link com.ihg.brandstandards.db.service.FlagCategoryLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because
 * this service can only be accessed from within the same VM.
 * </p>
 * 
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.FlagCategoryLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.FlagCategoryLocalServiceUtil
 */
public class FlagCategoryLocalServiceImpl extends FlagCategoryLocalServiceBaseImpl
{
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.FlagCategoryLocalServiceUtil} to access the flag category local service.
     */
	
	public void clearCache()
    {
        try
        {
            flagCategoryPersistence.clearCache();
        }
        catch (Exception e)
        {
        }
    }
	
    public List<FlagCategory> getFlagCategoryByParentId(long parentId) throws SystemException
    {
        return flagCategoryPersistence.findByparentCatId(parentId, "Y");
    }
    
    public List<FlagCategory> getFlagCategoriesForParentIds(String commaSeparateParentIds)
    {
        return flagCategoryFinder.getFlagCategoriesForParentIds(commaSeparateParentIds);
    }

    public List<FlagCategory> getFlagCategoryByType(String type) throws SystemException
    {
        return flagCategoryPersistence.findBycatOrField(type, "Y");
    }

    public FlagCategory getFlagCategory(long categoryId) throws SystemException, NoSuchFlagCategoryException
    {
        FlagCategoryPK flagCategoryPK = new FlagCategoryPK(categoryId, "Y");
        return flagCategoryPersistence.findByPrimaryKey(flagCategoryPK);
    }
    
    public List<FlagCategory> getFlagCategories(String query) {
    	return flagCategoryFinder.getFlagCategories(query);
    }

}