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
public class TaxonomyExtFinderUtil {
	public static java.util.List<com.ihg.brandstandards.db.model.TaxonomyExt> getIndexPathByStandardsId(
		long standardsId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().getIndexPathByStandardsId(standardsId);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.TaxonomyExt> getAllIndexes()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().getAllIndexes();
	}

	public static java.util.List<com.ihg.brandstandards.db.model.TaxonomyExt> getAllIndexesOdrByIdxId()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().getAllIndexesOdrByIdxId();
	}

	public static TaxonomyExtFinder getFinder() {
		if (_finder == null) {
			_finder = (TaxonomyExtFinder)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					TaxonomyExtFinder.class.getName());

			ReferenceRegistry.registerReference(TaxonomyExtFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(TaxonomyExtFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(TaxonomyExtFinderUtil.class,
			"_finder");
	}

	private static TaxonomyExtFinder _finder;
}