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
public class ErrNotificationFinderUtil {
	public static com.ihg.brandstandards.db.model.ErrNotification createErrNotificationOraSequence()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().createErrNotificationOraSequence();
	}

	public static boolean acknowledgeNotifications(
		java.lang.String notifcationIds) {
		return getFinder().acknowledgeNotifications(notifcationIds);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.ErrNotification> getUnprocessedNewNotifications(
		java.lang.String componentName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().getUnprocessedNewNotifications(componentName);
	}

	public static ErrNotificationFinder getFinder() {
		if (_finder == null) {
			_finder = (ErrNotificationFinder)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					ErrNotificationFinder.class.getName());

			ReferenceRegistry.registerReference(ErrNotificationFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(ErrNotificationFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(ErrNotificationFinderUtil.class,
			"_finder");
	}

	private static ErrNotificationFinder _finder;
}