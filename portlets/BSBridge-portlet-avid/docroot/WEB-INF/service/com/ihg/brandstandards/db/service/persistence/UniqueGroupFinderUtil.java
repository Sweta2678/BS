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
public class UniqueGroupFinderUtil {
	public static java.util.List<com.ihg.brandstandards.custom.model.GroupCountryDetails> getGroupAndCountryDetails(
		long publishId, long regionId, java.lang.String groupType) {
		return getFinder()
				   .getGroupAndCountryDetails(publishId, regionId, groupType);
	}

	public static java.util.Map<java.lang.String, java.lang.String> getStdUniqueGrpAndCtrys(
		long publishId, long regionId, java.lang.String groupType,
		java.lang.String stdId) {
		return getFinder()
				   .getStdUniqueGrpAndCtrys(publishId, regionId, groupType,
			stdId);
	}

	public static UniqueGroupFinder getFinder() {
		if (_finder == null) {
			_finder = (UniqueGroupFinder)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					UniqueGroupFinder.class.getName());

			ReferenceRegistry.registerReference(UniqueGroupFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(UniqueGroupFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(UniqueGroupFinderUtil.class,
			"_finder");
	}

	private static UniqueGroupFinder _finder;
}