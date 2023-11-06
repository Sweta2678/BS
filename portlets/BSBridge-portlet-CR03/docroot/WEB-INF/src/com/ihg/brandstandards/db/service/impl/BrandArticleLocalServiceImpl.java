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

import com.ihg.brandstandards.db.service.base.BrandArticleLocalServiceBaseImpl;
import com.ihg.brandstandards.db.service.persistence.BrandArticleFinderUtil;

/**
 * The implementation of the brand article local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ihg.brandstandards.db.service.BrandArticleLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.BrandArticleLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.BrandArticleLocalServiceUtil
 */
public class BrandArticleLocalServiceImpl
	extends BrandArticleLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.BrandArticleLocalServiceUtil} to access the brand article local service.
	 */
    public List getJournalArticleResourcPrimKey (String query) {
        List resourceKey = new ArrayList<Long>();
        resourceKey = BrandArticleFinderUtil.getAssociatedStds(query);
        return resourceKey;
        
    }
}