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
public class StandardsCountryChainFinderUtil {
	public static java.lang.String updateComplianceDeadline(
		java.lang.Long stdId,
		java.util.Map<java.lang.String, java.util.Date> compDatesMap,
		java.lang.String brandCode, java.lang.String regionCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .updateComplianceDeadline(stdId, compDatesMap, brandCode,
			regionCode);
	}

	public static java.lang.String getDefaultComplianceDate(long stdId,
		java.lang.String chainCD, java.lang.String regionCd) {
		return getFinder().getDefaultComplianceDate(stdId, chainCD, regionCd);
	}

	public static java.lang.String getDefaulExpiryDate(long stdId,
		java.lang.String chainCD, java.lang.String regionCd) {
		return getFinder().getDefaulExpiryDate(stdId, chainCD, regionCd);
	}

	public static StandardsCountryChainFinder getFinder() {
		if (_finder == null) {
			_finder = (StandardsCountryChainFinder)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					StandardsCountryChainFinder.class.getName());

			ReferenceRegistry.registerReference(StandardsCountryChainFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(StandardsCountryChainFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(StandardsCountryChainFinderUtil.class,
			"_finder");
	}

	private static StandardsCountryChainFinder _finder;
}