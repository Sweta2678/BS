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
public class GEMCategoryFinderUtil {
	public static long getGEMMappingCMSCategoryId(
		java.lang.String cmsLookupCatgyIds, java.lang.String gemCategoryName) {
		return getFinder()
				   .getGEMMappingCMSCategoryId(cmsLookupCatgyIds,
			gemCategoryName);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.GEMCategory> getGEMTemplateCategories(
		long gemTemplateId) {
		return getFinder().getGEMTemplateCategories(gemTemplateId);
	}

	public static java.util.Map<java.lang.Long, java.lang.String> getGEMTemplateCategoriesInMap(
		long gemTemplateId) {
		return getFinder().getGEMTemplateCategoriesInMap(gemTemplateId);
	}

	public static java.util.Map<java.lang.Long, java.lang.String> getQLFormSAAndSECategories(
		java.lang.String gemSESATemplateIds) {
		return getFinder().getQLFormSAAndSECategories(gemSESATemplateIds);
	}

	public static java.util.Map<java.lang.Long, java.lang.String> getScoringSECategories(
		long gemSETemplateId) {
		return getFinder().getScoringSECategories(gemSETemplateId);
	}

	public static GEMCategoryFinder getFinder() {
		if (_finder == null) {
			_finder = (GEMCategoryFinder)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					GEMCategoryFinder.class.getName());

			ReferenceRegistry.registerReference(GEMCategoryFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(GEMCategoryFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(GEMCategoryFinderUtil.class,
			"_finder");
	}

	private static GEMCategoryFinder _finder;
}