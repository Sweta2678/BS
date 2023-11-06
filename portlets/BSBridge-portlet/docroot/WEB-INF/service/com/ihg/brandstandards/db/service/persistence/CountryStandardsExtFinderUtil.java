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

package com.ihg.brandstandards.db.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author Mummanedi
 */
public class CountryStandardsExtFinderUtil {
	public static java.util.List<com.ihg.brandstandards.db.model.CountryStandardsExt> getCountriesByStandard(
		long stdId) throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().getCountriesByStandard(stdId);
	}

	public static java.util.List<java.lang.Object> getRegionsCountryCount(
		long stdId) {
		return getFinder().getRegionsCountryCount(stdId);
	}

	public static CountryStandardsExtFinder getFinder() {
		if (_finder == null) {
			_finder = (CountryStandardsExtFinder)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					CountryStandardsExtFinder.class.getName());

			ReferenceRegistry.registerReference(CountryStandardsExtFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(CountryStandardsExtFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(CountryStandardsExtFinderUtil.class,
			"_finder");
	}

	private static CountryStandardsExtFinder _finder;
}