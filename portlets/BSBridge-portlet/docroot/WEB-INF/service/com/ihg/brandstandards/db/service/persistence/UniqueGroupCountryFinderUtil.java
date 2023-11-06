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
public class UniqueGroupCountryFinderUtil {
	public static java.lang.String getCountryListOfUniqueGroup(
		java.lang.String groupName, long publishId, long regionId) {
		return getFinder()
				   .getCountryListOfUniqueGroup(groupName, publishId, regionId);
	}

	public static UniqueGroupCountryFinder getFinder() {
		if (_finder == null) {
			_finder = (UniqueGroupCountryFinder)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					UniqueGroupCountryFinder.class.getName());

			ReferenceRegistry.registerReference(UniqueGroupCountryFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(UniqueGroupCountryFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(UniqueGroupCountryFinderUtil.class,
			"_finder");
	}

	private static UniqueGroupCountryFinder _finder;
}