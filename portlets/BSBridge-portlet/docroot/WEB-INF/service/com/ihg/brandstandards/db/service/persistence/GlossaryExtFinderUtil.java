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
public class GlossaryExtFinderUtil {
	public static java.util.List<com.ihg.brandstandards.db.model.GlossaryExt> getGlossaryByBrandCodeAndVisibleChar(
		java.lang.String brandCode, java.lang.String visibleChar) {
		return getFinder()
				   .getGlossaryByBrandCodeAndVisibleChar(brandCode, visibleChar);
	}

	public static GlossaryExtFinder getFinder() {
		if (_finder == null) {
			_finder = (GlossaryExtFinder)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					GlossaryExtFinder.class.getName());

			ReferenceRegistry.registerReference(GlossaryExtFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(GlossaryExtFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(GlossaryExtFinderUtil.class,
			"_finder");
	}

	private static GlossaryExtFinder _finder;
}