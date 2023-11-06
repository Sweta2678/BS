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
public class StandardsCountryImagesFinderUtil {
	public static java.lang.String assignImageAttributeToCountry(
		java.lang.String fromCountryCode, java.lang.String toCountryCode) {
		return getFinder()
				   .assignImageAttributeToCountry(fromCountryCode, toCountryCode);
	}

	public static java.lang.String deleteCountryImagesAttribute(
		java.lang.String ctryNameCode) {
		return getFinder().deleteCountryImagesAttribute(ctryNameCode);
	}

	public static StandardsCountryImagesFinder getFinder() {
		if (_finder == null) {
			_finder = (StandardsCountryImagesFinder)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					StandardsCountryImagesFinder.class.getName());

			ReferenceRegistry.registerReference(StandardsCountryImagesFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(StandardsCountryImagesFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(StandardsCountryImagesFinderUtil.class,
			"_finder");
	}

	private static StandardsCountryImagesFinder _finder;
}