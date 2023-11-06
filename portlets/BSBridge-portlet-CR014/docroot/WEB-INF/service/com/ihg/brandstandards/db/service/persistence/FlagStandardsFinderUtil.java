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
public class FlagStandardsFinderUtil {
	public static java.util.List<java.lang.Long> getFlagStdId(long stdId) {
		return getFinder().getFlagStdId(stdId);
	}

	public static java.util.List<java.lang.Long> getFlagIdByStdIdAndCategoryId(
		long stdId, java.util.List<java.lang.String> categories) {
		return getFinder().getFlagIdByStdIdAndCategoryId(stdId, categories);
	}

	public static FlagStandardsFinder getFinder() {
		if (_finder == null) {
			_finder = (FlagStandardsFinder)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					FlagStandardsFinder.class.getName());

			ReferenceRegistry.registerReference(FlagStandardsFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(FlagStandardsFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(FlagStandardsFinderUtil.class,
			"_finder");
	}

	private static FlagStandardsFinder _finder;
}