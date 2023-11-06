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
public class ExternalLinkStandardsFinderUtil {
	public static java.util.List<com.ihg.brandstandards.db.model.ExternalLinkStandards> getExtLinkStandardsByStdIdAndRgnIdAndLocale(
		long stdId, java.lang.String regionId,
		java.util.List<java.lang.String> secondLocales) {
		return getFinder()
				   .getExtLinkStandardsByStdIdAndRgnIdAndLocale(stdId,
			regionId, secondLocales);
	}

	public static ExternalLinkStandardsFinder getFinder() {
		if (_finder == null) {
			_finder = (ExternalLinkStandardsFinder)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					ExternalLinkStandardsFinder.class.getName());

			ReferenceRegistry.registerReference(ExternalLinkStandardsFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(ExternalLinkStandardsFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(ExternalLinkStandardsFinderUtil.class,
			"_finder");
	}

	private static ExternalLinkStandardsFinder _finder;
}