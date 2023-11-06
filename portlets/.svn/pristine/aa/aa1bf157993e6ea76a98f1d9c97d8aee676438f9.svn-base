/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.ihg.brandstandards.db.service.impl;

import com.ihg.brandstandards.db.NoSuchPublishDeptException;
import com.ihg.brandstandards.db.model.Publication;
import com.ihg.brandstandards.db.model.PublishDept;
import com.ihg.brandstandards.db.service.base.PublishDeptLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the publish dept local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ihg.brandstandards.db.service.PublishDeptLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.PublishDeptLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.PublishDeptLocalServiceUtil
 */
public class PublishDeptLocalServiceImpl extends PublishDeptLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.PublishDeptLocalServiceUtil} to access the publish dept local service.
	 */
	public void clearCache()
    {
        try
        {
        	publishDeptPersistence.clearCache();
        }
        catch (Exception e)
        {
        }
    }
	/**
	 * 
	 * @param publishId
	 * @param departmentId
	 * @return PublishDept
	 * @throws NoSuchPublishDeptException
	 * @throws SystemException
	 */
	public PublishDept getActivePublicationByDept (long publishId, long departmentId) throws NoSuchPublishDeptException, SystemException {
		return publishDeptPersistence.findByPublicationAndDept(publishId, departmentId);
	}
	
	/**
	 * 
	 * @param departmentId
	 * @param brandCode
	 * @return Publication
	 */
	public Publication getAcitveDepartmentPublication (long departmentId, String brandCode) {
		return publishDeptFinder.getAcitveDepartmentPublication(departmentId, brandCode);
	}
	
	/**
	 * 
	 * @return PublishDept
	 * @throws SystemException 
	 */
	public PublishDept createDeptPublication () throws SystemException {
		return publishDeptFinder.createDeptPublication();
	}
}