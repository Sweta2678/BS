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
public interface StandardsCountryImagesFinder {
	public java.lang.String assignImageAttributeToCountry(
		java.lang.String fromCountryCode, java.lang.String toCountryCode);

	public java.lang.String deleteCountryImagesAttribute(
		java.lang.String ctryNameCode);
}