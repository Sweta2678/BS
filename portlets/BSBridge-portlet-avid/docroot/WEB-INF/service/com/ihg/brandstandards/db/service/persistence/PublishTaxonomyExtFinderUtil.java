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
public class PublishTaxonomyExtFinderUtil {
	public static java.util.List<com.ihg.brandstandards.db.model.PublishTaxonomyExt> getIndexPathByStandardsId(
		long standardsId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().getIndexPathByStandardsId(standardsId);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.PublishTaxonomyExt> getIndexPathByChainCode(
		java.lang.String chainCode, java.lang.String query)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().getIndexPathByChainCode(chainCode, query);
	}

	public static PublishTaxonomyExtFinder getFinder() {
		if (_finder == null) {
			_finder = (PublishTaxonomyExtFinder)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					PublishTaxonomyExtFinder.class.getName());

			ReferenceRegistry.registerReference(PublishTaxonomyExtFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(PublishTaxonomyExtFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(PublishTaxonomyExtFinderUtil.class,
			"_finder");
	}

	private static PublishTaxonomyExtFinder _finder;
}