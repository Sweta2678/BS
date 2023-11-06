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
public class TaxonomyFinderUtil {
	public static java.lang.String insertAdminTreeXML(long treeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().insertAdminTreeXML(treeId);
	}

	public static void updateTaxonomyPosition(
		com.ihg.brandstandards.db.model.Taxonomy taxonomyObj,
		com.ihg.brandstandards.db.model.Taxonomy taxonomyRef, long pos)
		throws com.liferay.portal.kernel.exception.SystemException {
		getFinder().updateTaxonomyPosition(taxonomyObj, taxonomyRef, pos);
	}

	public static TaxonomyFinder getFinder() {
		if (_finder == null) {
			_finder = (TaxonomyFinder)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					TaxonomyFinder.class.getName());

			ReferenceRegistry.registerReference(TaxonomyFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(TaxonomyFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(TaxonomyFinderUtil.class, "_finder");
	}

	private static TaxonomyFinder _finder;
}