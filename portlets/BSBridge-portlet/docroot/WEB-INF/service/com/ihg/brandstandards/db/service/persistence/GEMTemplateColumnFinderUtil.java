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
public class GEMTemplateColumnFinderUtil {
	public static boolean addConfigurationDetails(long templateId,
		java.util.Iterator<org.apache.poi.ss.usermodel.Cell> columns) {
		return getFinder().addConfigurationDetails(templateId, columns);
	}

	public static GEMTemplateColumnFinder getFinder() {
		if (_finder == null) {
			_finder = (GEMTemplateColumnFinder)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					GEMTemplateColumnFinder.class.getName());

			ReferenceRegistry.registerReference(GEMTemplateColumnFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(GEMTemplateColumnFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(GEMTemplateColumnFinderUtil.class,
			"_finder");
	}

	private static GEMTemplateColumnFinder _finder;
}