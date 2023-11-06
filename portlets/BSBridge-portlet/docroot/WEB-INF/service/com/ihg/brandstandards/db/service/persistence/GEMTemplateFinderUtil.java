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
public class GEMTemplateFinderUtil {
	public static void deleteTemplateConfigurations(long templateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getFinder().deleteTemplateConfigurations(templateId);
	}

	public static long getSequenceNumber(java.lang.String sequenceName) {
		return getFinder().getSequenceNumber(sequenceName);
	}

	public static boolean insertTemplateValueUsingSequence(long columnId,
		java.lang.String columnValue, long categoryId, long orderNumber,
		java.lang.String createUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .insertTemplateValueUsingSequence(columnId, columnValue,
			categoryId, orderNumber, createUserId);
	}

	public static GEMTemplateFinder getFinder() {
		if (_finder == null) {
			_finder = (GEMTemplateFinder)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					GEMTemplateFinder.class.getName());

			ReferenceRegistry.registerReference(GEMTemplateFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(GEMTemplateFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(GEMTemplateFinderUtil.class,
			"_finder");
	}

	private static GEMTemplateFinder _finder;
}