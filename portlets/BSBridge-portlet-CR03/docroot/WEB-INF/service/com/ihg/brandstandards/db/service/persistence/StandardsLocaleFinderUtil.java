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
public class StandardsLocaleFinderUtil {
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsLocale> getLanguagesByRegion(
		java.lang.String regionCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().getLanguagesByRegion(regionCode);
	}

	public static java.util.Map<java.lang.String, java.lang.String> getActiveLanguages(
		java.lang.String sqlQuery) {
		return getFinder().getActiveLanguages(sqlQuery);
	}

	public static StandardsLocaleFinder getFinder() {
		if (_finder == null) {
			_finder = (StandardsLocaleFinder)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					StandardsLocaleFinder.class.getName());

			ReferenceRegistry.registerReference(StandardsLocaleFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(StandardsLocaleFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(StandardsLocaleFinderUtil.class,
			"_finder");
	}

	private static StandardsLocaleFinder _finder;
}