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
public class PublishParmFinderUtil {
	public static com.ihg.brandstandards.db.model.PublishParm createPublishParam()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().createPublishParam();
	}

	public static PublishParmFinder getFinder() {
		if (_finder == null) {
			_finder = (PublishParmFinder)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					PublishParmFinder.class.getName());

			ReferenceRegistry.registerReference(PublishParmFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(PublishParmFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(PublishParmFinderUtil.class,
			"_finder");
	}

	private static PublishParmFinder _finder;
}