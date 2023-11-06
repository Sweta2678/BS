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
public class StandardsHistoricalManualFinderUtil {
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsHistoricalManual> findStdHistoricalManualsByStdId(
		long stdId) throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findStdHistoricalManualsByStdId(stdId);
	}

	public static boolean isNullOrBlank(java.util.List<?> obj) {
		return getFinder().isNullOrBlank(obj);
	}

	public static boolean isNullOrBlank(java.lang.String obj) {
		return getFinder().isNullOrBlank(obj);
	}

	public static StandardsHistoricalManualFinder getFinder() {
		if (_finder == null) {
			_finder = (StandardsHistoricalManualFinder)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					StandardsHistoricalManualFinder.class.getName());

			ReferenceRegistry.registerReference(StandardsHistoricalManualFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(StandardsHistoricalManualFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(StandardsHistoricalManualFinderUtil.class,
			"_finder");
	}

	private static StandardsHistoricalManualFinder _finder;
}