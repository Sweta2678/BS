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
public class StandardsComplianceFinderUtil {
	public static void saveStandardCompliance(long stdId,
		java.lang.String chainCode, java.lang.String ruleDate,
		java.lang.String complianceExpiry, java.lang.String stdCompliance)
		throws com.liferay.portal.kernel.exception.SystemException {
		getFinder()
			.saveStandardCompliance(stdId, chainCode, ruleDate,
			complianceExpiry, stdCompliance);
	}

	public static com.ihg.brandstandards.db.model.StandardsCompliance createOraSequence()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().createOraSequence();
	}

	public static void saveStandardsCompliance(
		com.ihg.brandstandards.db.model.StandardsCompliance stdCompliance)
		throws com.liferay.portal.kernel.exception.SystemException {
		getFinder().saveStandardsCompliance(stdCompliance);
	}

	public static StandardsComplianceFinder getFinder() {
		if (_finder == null) {
			_finder = (StandardsComplianceFinder)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					StandardsComplianceFinder.class.getName());

			ReferenceRegistry.registerReference(StandardsComplianceFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(StandardsComplianceFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(StandardsComplianceFinderUtil.class,
			"_finder");
	}

	private static StandardsComplianceFinder _finder;
}