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

/**
 * @author Mummanedi
 */
public interface StandardsComplianceFinder {
	public void saveStandardCompliance(long stdId, java.lang.String chainCode,
		java.lang.String ruleDate, java.lang.String complianceExpiry,
		java.lang.String stdCompliance)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.StandardsCompliance createOraSequence()
		throws com.liferay.portal.kernel.exception.SystemException;

	public void saveStandardsCompliance(
		com.ihg.brandstandards.db.model.StandardsCompliance stdCompliance)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.lang.String assignExpiryDateToCountry(
		java.lang.String fromCountryCode, java.lang.String toCountryCode);

	public java.lang.String assignComplianceDateToCountry(
		java.lang.String fromCountryCode, java.lang.String toCountryCode);

	public java.lang.String deleteComplianceExpiryDateAttribute(
		java.lang.String ctryNameCode, java.lang.String cmplExprRuleCd);
}