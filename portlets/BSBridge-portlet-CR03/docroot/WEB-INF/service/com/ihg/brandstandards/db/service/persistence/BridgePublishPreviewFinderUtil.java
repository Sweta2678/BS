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
public class BridgePublishPreviewFinderUtil {
	public static java.util.List<com.ihg.brandstandards.db.model.BridgePublishPreview> getBridgePublishPreview(
		java.lang.String chainCd, long regionCd)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().getBridgePublishPreview(chainCd, regionCd);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.BridgePublishPreview> getBridgePublishPreview(
		java.lang.String groupName, java.lang.String chainCd, long regionId,
		java.lang.String filterIds, java.lang.String searchIds,
		java.lang.String selByState, java.lang.String locale,
		long bridgePublishId, java.lang.String groupType) {
		return getFinder()
				   .getBridgePublishPreview(groupName, chainCd, regionId,
			filterIds, searchIds, selByState, locale, bridgePublishId, groupType);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.BridgePublishPreview> getStandardsById(
		java.lang.String stdIds, java.lang.String brand, boolean isMust)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().getStandardsById(stdIds, brand, isMust);
	}

	public static java.util.List<com.ihg.brandstandards.custom.model.CountryList> getGroupsByCountryStatus(
		java.lang.String query) {
		return getFinder().getGroupsByCountryStatus(query);
	}

	public static BridgePublishPreviewFinder getFinder() {
		if (_finder == null) {
			_finder = (BridgePublishPreviewFinder)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					BridgePublishPreviewFinder.class.getName());

			ReferenceRegistry.registerReference(BridgePublishPreviewFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(BridgePublishPreviewFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(BridgePublishPreviewFinderUtil.class,
			"_finder");
	}

	private static BridgePublishPreviewFinder _finder;
}