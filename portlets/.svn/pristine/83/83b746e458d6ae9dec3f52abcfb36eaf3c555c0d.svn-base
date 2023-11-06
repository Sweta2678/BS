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
public class GEMRoleFinderUtil {
	public static boolean refreshGemRoles(java.lang.String userName) {
		return getFinder().refreshGemRoles(userName);
	}

	public static GEMRoleFinder getFinder() {
		if (_finder == null) {
			_finder = (GEMRoleFinder)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					GEMRoleFinder.class.getName());

			ReferenceRegistry.registerReference(GEMRoleFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(GEMRoleFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(GEMRoleFinderUtil.class, "_finder");
	}

	private static GEMRoleFinder _finder;
}