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
public class StandardsComplianceExtFinderUtil {
	public static java.util.List<com.ihg.brandstandards.db.model.StandardsComplianceExt> getComplianceByRegion(
		java.lang.String sqlQuery, long stdId, java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().getComplianceByRegion(sqlQuery, stdId, chainCode);
	}

	public static java.util.List<java.lang.Object> getRegionStatus(long stdId,
		java.lang.String chainCd) {
		return getFinder().getRegionStatus(stdId, chainCd);
	}

	public static java.util.List<java.lang.Object> getRegionCmplyExprCount(
		long stdId, java.lang.String chainCd, java.lang.String rgnName,
		java.lang.String cmply_expr_value, java.lang.String rule_cd) {
		return getFinder()
				   .getRegionCmplyExprCount(stdId, chainCd, rgnName,
			cmply_expr_value, rule_cd);
	}

	public static StandardsComplianceExtFinder getFinder() {
		if (_finder == null) {
			_finder = (StandardsComplianceExtFinder)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					StandardsComplianceExtFinder.class.getName());

			ReferenceRegistry.registerReference(StandardsComplianceExtFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(StandardsComplianceExtFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(StandardsComplianceExtFinderUtil.class,
			"_finder");
	}

	private static StandardsComplianceExtFinder _finder;
}