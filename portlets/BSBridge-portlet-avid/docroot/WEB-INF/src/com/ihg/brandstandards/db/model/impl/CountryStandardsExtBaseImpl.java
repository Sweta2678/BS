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

import com.ihg.brandstandards.db.model.CountryStandardsExt;
import com.ihg.brandstandards.db.service.CountryStandardsExtLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

/**
 * The extended model base implementation for the CountryStandardsExt service. Represents a row in the &quot;CTRY_STD&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CountryStandardsExtImpl}.
 * </p>
 *
 * @author Mummanedi
 * @see CountryStandardsExtImpl
 * @see com.ihg.brandstandards.db.model.CountryStandardsExt
 * @generated
 */
public abstract class CountryStandardsExtBaseImpl
	extends CountryStandardsExtModelImpl implements CountryStandardsExt {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a country standards ext model instance should use the {@link CountryStandardsExt} interface instead.
	 */
	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CountryStandardsExtLocalServiceUtil.addCountryStandardsExt(this);
		}
		else {
			CountryStandardsExtLocalServiceUtil.updateCountryStandardsExt(this);
		}
	}
}