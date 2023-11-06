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
public class StandardsCountryExtFinderUtil {
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsCountryExt> getCountryListByStdIdAndRegionId(
		long stdId, long regionId, long publishId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getCountryListByStdIdAndRegionId(stdId, regionId, publishId);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.StandardsCountryExt> getCountryListByStdIdAndRegionIdForMyPublication(
		long stdId, long regionId, long publishId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getCountryListByStdIdAndRegionIdForMyPublication(stdId,
			regionId, publishId);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.StandardsCountryExt> getRegionBasedCountryStatus(
		long stdId, java.lang.String chainCd, long regionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().getRegionBasedCountryStatus(stdId, chainCd, regionId);
	}

	public static java.lang.String getRegionCodeByCountryCode(
		java.lang.String ctryCode) {
		return getFinder().getRegionCodeByCountryCode(ctryCode);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.StandardsCountryExt> getCountryRegionList() {
		return getFinder().getCountryRegionList();
	}

	public static java.util.List<java.lang.String> getCountryListByRegionCode(
		java.lang.String regionCode) {
		return getFinder().getCountryListByRegionCode(regionCode);
	}

	public static java.util.List<java.lang.String> getCountryListBySubRegionCode(
		java.lang.String subRegionCode) {
		return getFinder().getCountryListBySubRegionCode(subRegionCode);
	}

	public static java.util.List<java.lang.String> getAllStdCountryList() {
		return getFinder().getAllStdCountryList();
	}

	public static StandardsCountryExtFinder getFinder() {
		if (_finder == null) {
			_finder = (StandardsCountryExtFinder)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					StandardsCountryExtFinder.class.getName());

			ReferenceRegistry.registerReference(StandardsCountryExtFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(StandardsCountryExtFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(StandardsCountryExtFinderUtil.class,
			"_finder");
	}

	private static StandardsCountryExtFinder _finder;
}