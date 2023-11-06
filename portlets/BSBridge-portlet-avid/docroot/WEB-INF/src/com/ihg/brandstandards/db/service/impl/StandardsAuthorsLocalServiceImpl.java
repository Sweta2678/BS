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

import com.ihg.brandstandards.db.model.StandardsAuthors;
import com.ihg.brandstandards.db.service.base.StandardsAuthorsLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the standards authors local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ihg.brandstandards.db.service.StandardsAuthorsLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.StandardsAuthorsLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.StandardsAuthorsLocalServiceUtil
 */
public class StandardsAuthorsLocalServiceImpl
	extends StandardsAuthorsLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.StandardsAuthorsLocalServiceUtil} to access the standards authors local service.
	 */
    
	public void clearCache()
    {
        try
        {
            standardsAuthorsPersistence.clearCache();
        }
        catch (Exception e)
        {
        }
    }
	
	public List<StandardsAuthors> getStandardsAuthorsByStdId(long stdId) throws SystemException
    {
        return standardsAuthorsPersistence.findByStdId(stdId);
    }
    
    /**
     * Find Authors by Author Name and Primary flag.
     * @param authorName author name
     * @param primary is primary flag 
     */
    public List<StandardsAuthors> getStandardsAuthorsByAuthor(String authorName, String primary) throws SystemException
    {
        return standardsAuthorsPersistence.findByStdAuthor(authorName, primary);
    }
    
    /**
     * Find Authors by Author Name and Primary flag.
     * @param stdId Standard Id
     * @param primary is primary flag 
     */
    public List<StandardsAuthors> getAuthorStdIdPrimary(long stdId, String primary) throws SystemException
    {
        return standardsAuthorsPersistence.findByAuthorStdIdPrimary(stdId, primary);
    }
    
    /**
     * Remove Authors by Author Name and Primary flag.
     * @param authorName author name
     * @param primary is primary flag 
     */
    public void removeByStdAuthor(String authorName, String primary) throws SystemException
    {
        standardsAuthorsPersistence.removeByStdAuthor(authorName, primary);
    }
}