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
public class UIElementFinderUtil {
	public static java.util.List<java.lang.Object> searchUIElement(
		java.lang.String elementValue, java.lang.String searchLanguage,
		java.lang.String elementKey, java.lang.String secondLanguage,
		java.lang.String[] usedIn) {
		return getFinder()
				   .searchUIElement(elementValue, searchLanguage, elementKey,
			secondLanguage, usedIn);
	}

	public static java.util.List<java.lang.String> getElementsKeyList(
		java.lang.String sqlQuery) {
		return getFinder().getElementsKeyList(sqlQuery);
	}

	public static java.util.Map<java.lang.String, java.lang.String> loadUIElements(
		java.lang.String localeCode) {
		return getFinder().loadUIElements(localeCode);
	}

	public static java.util.Map<java.lang.String, java.lang.String> loadUIElements(
		java.lang.String localeCode, java.lang.String moduleUsedIn) {
		return getFinder().loadUIElements(localeCode, moduleUsedIn);
	}

	public static java.lang.String loadAutoCompleteKeys(
		java.lang.String sqlQuery) {
		return getFinder().loadAutoCompleteKeys(sqlQuery);
	}

	public static UIElementFinder getFinder() {
		if (_finder == null) {
			_finder = (UIElementFinder)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					UIElementFinder.class.getName());

			ReferenceRegistry.registerReference(UIElementFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(UIElementFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(UIElementFinderUtil.class, "_finder");
	}

	private static UIElementFinder _finder;
}