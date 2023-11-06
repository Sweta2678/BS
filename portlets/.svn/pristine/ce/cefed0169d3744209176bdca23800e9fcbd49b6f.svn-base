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
public class BridgeProgressDiscrepancyFinderUtil {
	public static void deleteDeactivatedBridgePublishProgress(
		java.util.List<java.lang.Long> deactivatedBridgePublishIds) {
		getFinder()
			.deleteDeactivatedBridgePublishProgress(deactivatedBridgePublishIds);
	}

	public static void addBridgeProgressValues(
		java.util.List<com.ihg.brandstandards.custom.model.BridgeProgressCount> progressDiscrepancy,
		java.lang.String screenName, javax.sql.DataSource datasource) {
		getFinder()
			.addBridgeProgressValues(progressDiscrepancy, screenName, datasource);
	}

	public static BridgeProgressDiscrepancyFinder getFinder() {
		if (_finder == null) {
			_finder = (BridgeProgressDiscrepancyFinder)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					BridgeProgressDiscrepancyFinder.class.getName());

			ReferenceRegistry.registerReference(BridgeProgressDiscrepancyFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(BridgeProgressDiscrepancyFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(BridgeProgressDiscrepancyFinderUtil.class,
			"_finder");
	}

	private static BridgeProgressDiscrepancyFinder _finder;
}