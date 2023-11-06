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
public class PublishStdFinderUtil {
	public static java.util.List<com.ihg.brandstandards.db.model.PublishStd> getStandardsByCountryAndBrand(
		long publishId, long taxonomyId, java.lang.String chainCode,
		java.lang.String countryCode, java.lang.String stdType) {
		return getFinder()
				   .getStandardsByCountryAndBrand(publishId, taxonomyId,
			chainCode, countryCode, stdType);
	}

	public static java.util.List getAssociatedStds(java.lang.String query) {
		return getFinder().getAssociatedStds(query);
	}

	public static PublishStdFinder getFinder() {
		if (_finder == null) {
			_finder = (PublishStdFinder)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					PublishStdFinder.class.getName());

			ReferenceRegistry.registerReference(PublishStdFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(PublishStdFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(PublishStdFinderUtil.class,
			"_finder");
	}

	private static PublishStdFinder _finder;
}