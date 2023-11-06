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
public class AttachmentsStandardsCountryFinderUtil {
	public static java.lang.String assignAttachementAttributeToCountry(
		java.lang.String fromCountryCode, java.lang.String toCountryCode) {
		return getFinder()
				   .assignAttachementAttributeToCountry(fromCountryCode,
			toCountryCode);
	}

	public static java.lang.String deleteCountryAttachementAttribute(
		java.lang.String ctryNameCode) {
		return getFinder().deleteCountryAttachementAttribute(ctryNameCode);
	}

	public static AttachmentsStandardsCountryFinder getFinder() {
		if (_finder == null) {
			_finder = (AttachmentsStandardsCountryFinder)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					AttachmentsStandardsCountryFinder.class.getName());

			ReferenceRegistry.registerReference(AttachmentsStandardsCountryFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(AttachmentsStandardsCountryFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(AttachmentsStandardsCountryFinderUtil.class,
			"_finder");
	}

	private static AttachmentsStandardsCountryFinder _finder;
}