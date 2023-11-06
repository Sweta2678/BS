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
public class BridgeGlobalPublishFinderUtil {
	public static java.util.List<com.ihg.brandstandards.db.model.MustPublish> getMustPublishStandardsByIdsAndBrand(
		java.lang.String stdIdsByCommaSeprated, java.lang.String brand,
		boolean mustPublish)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getMustPublishStandardsByIdsAndBrand(stdIdsByCommaSeprated,
			brand, mustPublish);
	}

	public static com.ihg.brandstandards.db.model.BridgeGlobalPublish getNewBridgeGlobalPublish() {
		return getFinder().getNewBridgeGlobalPublish();
	}

	public static com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry getNewBridgeGlobalPublishCountry() {
		return getFinder().getNewBridgeGlobalPublishCountry();
	}

	public static java.util.Map<java.lang.String, java.lang.Long> getTotalIssuesforMustpublish(
		java.lang.String isMustPublish, long publishId, java.lang.String brand) {
		return getFinder()
				   .getTotalIssuesforMustpublish(isMustPublish, publishId, brand);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry> getCountriesByGlobalPublishIdAndRegionId(
		long bridgeGlobalPublishId, long regionId) {
		return getFinder()
				   .getCountriesByGlobalPublishIdAndRegionId(bridgeGlobalPublishId,
			regionId);
	}

	public static java.util.Map<java.lang.String, java.lang.String> importGlobalMustPublishStandards(
		long publishId, java.lang.String chainCode,
		java.lang.String screenName, java.lang.String stdIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .importGlobalMustPublishStandards(publishId, chainCode,
			screenName, stdIds);
	}

	public static BridgeGlobalPublishFinder getFinder() {
		if (_finder == null) {
			_finder = (BridgeGlobalPublishFinder)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					BridgeGlobalPublishFinder.class.getName());

			ReferenceRegistry.registerReference(BridgeGlobalPublishFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(BridgeGlobalPublishFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(BridgeGlobalPublishFinderUtil.class,
			"_finder");
	}

	private static BridgeGlobalPublishFinder _finder;
}