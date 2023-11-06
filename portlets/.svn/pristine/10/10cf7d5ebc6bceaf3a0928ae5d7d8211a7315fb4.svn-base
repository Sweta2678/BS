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
public class ExternalLinkStandardsCountryFinderUtil {
	public static java.lang.String assignLinkAttributeToCountry(
		java.lang.String fromCountryCode, java.lang.String toCountryCode) {
		return getFinder()
				   .assignLinkAttributeToCountry(fromCountryCode, toCountryCode);
	}

	public static java.lang.String deleteCountryExtLinkAttribute(
		java.lang.String ctryNameCode) {
		return getFinder().deleteCountryExtLinkAttribute(ctryNameCode);
	}

	public static ExternalLinkStandardsCountryFinder getFinder() {
		if (_finder == null) {
			_finder = (ExternalLinkStandardsCountryFinder)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					ExternalLinkStandardsCountryFinder.class.getName());

			ReferenceRegistry.registerReference(ExternalLinkStandardsCountryFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(ExternalLinkStandardsCountryFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(ExternalLinkStandardsCountryFinderUtil.class,
			"_finder");
	}

	private static ExternalLinkStandardsCountryFinder _finder;
}