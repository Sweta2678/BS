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
public class BridgePublishStateExFinderUtil {
	public static java.util.List<com.ihg.brandstandards.db.model.BridgePublishStateEx> getBridgePublishStateEx(
		java.lang.String chainCd, long regionCd)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().getBridgePublishStateEx(chainCd, regionCd);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.BridgePublishStateEx> getBridgePublishStateEx(
		java.lang.String chainCd, long regionId, java.lang.String filterState,
		java.lang.String filterId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getBridgePublishStateEx(chainCd, regionId, filterState,
			filterId);
	}

	public static BridgePublishStateExFinder getFinder() {
		if (_finder == null) {
			_finder = (BridgePublishStateExFinder)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					BridgePublishStateExFinder.class.getName());

			ReferenceRegistry.registerReference(BridgePublishStateExFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(BridgePublishStateExFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(BridgePublishStateExFinderUtil.class,
			"_finder");
	}

	private static BridgePublishStateExFinder _finder;
}