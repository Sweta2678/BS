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

package com.ihg.brandstandards.db.model.impl;

import com.ihg.brandstandards.db.model.UserSearchCriteria;
import com.ihg.brandstandards.db.service.UserSearchCriteriaLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the UserSearchCriteria service. Represents a row in the &quot;USR_SEARCH_CRIT&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link UserSearchCriteriaImpl}.
 * </p>
 *
 * @author Mummanedi
 * @see UserSearchCriteriaImpl
 * @see com.ihg.brandstandards.db.model.UserSearchCriteria
 * @generated
 */
public abstract class UserSearchCriteriaBaseImpl
	extends UserSearchCriteriaModelImpl implements UserSearchCriteria {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a user search criteria model instance should use the {@link UserSearchCriteria} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			UserSearchCriteriaLocalServiceUtil.addUserSearchCriteria(this);
		}
		else {
			UserSearchCriteriaLocalServiceUtil.updateUserSearchCriteria(this);
		}
	}
}