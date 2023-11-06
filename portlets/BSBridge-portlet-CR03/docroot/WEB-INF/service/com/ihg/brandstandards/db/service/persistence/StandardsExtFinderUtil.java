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
public class StandardsExtFinderUtil {
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsExt> getStandards(
		java.util.Map<java.lang.String, ?> criteriaMap)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().getStandards(criteriaMap);
	}

	public static void addChildIndexes(long index,
		java.util.List<java.lang.String> indexes)
		throws com.liferay.portal.kernel.exception.SystemException {
		getFinder().addChildIndexes(index, indexes);
	}

	public static java.util.List<java.lang.Long> getStandardsByChain(
		java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().getStandardsByChain(chainCode);
	}

	public static StandardsExtFinder getFinder() {
		if (_finder == null) {
			_finder = (StandardsExtFinder)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					StandardsExtFinder.class.getName());

			ReferenceRegistry.registerReference(StandardsExtFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(StandardsExtFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(StandardsExtFinderUtil.class,
			"_finder");
	}

	private static StandardsExtFinder _finder;
}