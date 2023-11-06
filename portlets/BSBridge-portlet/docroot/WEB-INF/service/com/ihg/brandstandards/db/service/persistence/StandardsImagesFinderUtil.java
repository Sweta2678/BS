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
public class StandardsImagesFinderUtil {
	public static java.util.List<java.lang.String> getStandardsImagesCount(
		long imageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().getStandardsImagesCount(imageId);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.StandardsImages> getStandardImagesByStdIdAndRgnIdAndLocale(
		long stdId, java.lang.String regionId,
		java.util.List<java.lang.String> secondLocales) {
		return getFinder()
				   .getStandardImagesByStdIdAndRgnIdAndLocale(stdId, regionId,
			secondLocales);
	}

	public static StandardsImagesFinder getFinder() {
		if (_finder == null) {
			_finder = (StandardsImagesFinder)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					StandardsImagesFinder.class.getName());

			ReferenceRegistry.registerReference(StandardsImagesFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(StandardsImagesFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(StandardsImagesFinderUtil.class,
			"_finder");
	}

	private static StandardsImagesFinder _finder;
}