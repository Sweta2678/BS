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
public class GEMManagementIdFinderUtil {
	public static java.util.List<com.ihg.brandstandards.db.model.GEMManagementId> getManagementIdsByRegionAndBrand(
		long regionId, java.lang.String subBrandCodes) {
		return getFinder()
				   .getManagementIdsByRegionAndBrand(regionId, subBrandCodes);
	}

	public static GEMManagementIdFinder getFinder() {
		if (_finder == null) {
			_finder = (GEMManagementIdFinder)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					GEMManagementIdFinder.class.getName());

			ReferenceRegistry.registerReference(GEMManagementIdFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(GEMManagementIdFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(GEMManagementIdFinderUtil.class,
			"_finder");
	}

	private static GEMManagementIdFinder _finder;
}