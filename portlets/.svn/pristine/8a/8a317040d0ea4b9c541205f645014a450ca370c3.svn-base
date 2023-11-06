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
public class PublicationFinderUtil {
	public static java.util.List<com.ihg.brandstandards.db.model.Publication> getPublishRecords(
		java.lang.String query) {
		return getFinder().getPublishRecords(query);
	}

	public static com.ihg.brandstandards.db.model.Publication createPublication()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().createPublication();
	}

	public static java.util.List<java.lang.String> fetchUniquePublishedBrandCodes() {
		return getFinder().fetchUniquePublishedBrandCodes();
	}

	public static java.util.List<java.lang.String> getPublicationDatesByEnv(
		java.lang.String env) {
		return getFinder().getPublicationDatesByEnv(env);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.Publication> getWhatChangedOnCustom(
		java.lang.String chainCode, java.lang.String publishEnv) {
		return getFinder().getWhatChangedOnCustom(chainCode, publishEnv);
	}

	public static PublicationFinder getFinder() {
		if (_finder == null) {
			_finder = (PublicationFinder)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					PublicationFinder.class.getName());

			ReferenceRegistry.registerReference(PublicationFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(PublicationFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(PublicationFinderUtil.class,
			"_finder");
	}

	private static PublicationFinder _finder;
}