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
public interface UIElementFinder {
	public java.util.List<java.lang.Object> searchUIElement(
		java.lang.String elementValue, java.lang.String searchLanguage,
		java.lang.String elementKey, java.lang.String secondLanguage,
		java.lang.String[] usedIn);

	public java.util.List<java.lang.String> getElementsKeyList(
		java.lang.String sqlQuery);

	public java.util.Map<java.lang.String, java.lang.String> loadUIElements(
		java.lang.String localeCode);

	public java.util.Map<java.lang.String, java.lang.String> loadUIElements(
		java.lang.String localeCode, java.lang.String moduleUsedIn);

	public java.lang.String loadAutoCompleteKeys(java.lang.String sqlQuery);
}