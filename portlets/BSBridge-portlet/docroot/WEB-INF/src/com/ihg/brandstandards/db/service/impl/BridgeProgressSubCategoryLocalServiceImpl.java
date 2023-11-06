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

import java.util.List;

import com.ihg.brandstandards.db.NoSuchPublicationException;
import com.ihg.brandstandards.db.model.BridgeProgressSubCategory;
import com.ihg.brandstandards.db.service.base.BridgeProgressSubCategoryLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the bridge progress sub category local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ihg.brandstandards.db.service.BridgeProgressSubCategoryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.BridgeProgressSubCategoryLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.BridgeProgressSubCategoryLocalServiceUtil
 */
public class BridgeProgressSubCategoryLocalServiceImpl
	extends BridgeProgressSubCategoryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.BridgeProgressSubCategoryLocalServiceUtil} to access the bridge progress sub category local service.
	 */
	
	 public List<BridgeProgressSubCategory> findByprogressCategoryId(long categoryId)
	            throws SystemException
	    {
	        return bridgeProgressSubCategoryPersistence.findByprogressCategoryId(categoryId);
	    }
}