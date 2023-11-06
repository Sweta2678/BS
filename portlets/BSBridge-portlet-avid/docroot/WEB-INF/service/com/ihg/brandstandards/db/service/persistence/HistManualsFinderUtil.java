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
public class HistManualsFinderUtil {
	public static java.util.List<com.ihg.brandstandards.db.model.HistManuals> findHistoricalManualsByFilter(
		java.util.List<java.lang.String> brand,
		java.util.List<java.lang.String> region,
		java.util.List<java.lang.String> manualType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findHistoricalManualsByFilter(brand, region, manualType);
	}

	public static boolean isNullOrBlank(java.util.List<?> obj) {
		return getFinder().isNullOrBlank(obj);
	}

	public static boolean isNullOrBlank(java.lang.String obj) {
		return getFinder().isNullOrBlank(obj);
	}

	public static HistManualsFinder getFinder() {
		if (_finder == null) {
			_finder = (HistManualsFinder)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					HistManualsFinder.class.getName());

			ReferenceRegistry.registerReference(HistManualsFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(HistManualsFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(HistManualsFinderUtil.class,
			"_finder");
	}

	private static HistManualsFinder _finder;
}