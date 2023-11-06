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
public class GEMUniqueGroupCountryFinderUtil {
	public static java.lang.String getCountryListOfUniqueGroup(
		java.lang.String groupName, java.lang.String groupType, long publishId,
		long regionId) {
		return getFinder()
				   .getCountryListOfUniqueGroup(groupName, groupType,
			publishId, regionId);
	}

	public static java.lang.String getCountryListOfUniqueGroup(long groupId) {
		return getFinder().getCountryListOfUniqueGroup(groupId);
	}

	public static GEMUniqueGroupCountryFinder getFinder() {
		if (_finder == null) {
			_finder = (GEMUniqueGroupCountryFinder)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					GEMUniqueGroupCountryFinder.class.getName());

			ReferenceRegistry.registerReference(GEMUniqueGroupCountryFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(GEMUniqueGroupCountryFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(GEMUniqueGroupCountryFinderUtil.class,
			"_finder");
	}

	private static GEMUniqueGroupCountryFinder _finder;
}