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
public class SpreadSheetAttributeUpdateFinderUtil {
	public static java.lang.String recordsNotAvailable(
		java.util.List<java.lang.Long> allStdIds,
		java.util.Map<java.lang.String, java.util.List<java.lang.Long>> stdIdsMap,
		com.liferay.portal.model.User user, java.lang.String region,
		java.lang.String environment) {
		return getFinder()
				   .recordsNotAvailable(allStdIds, stdIdsMap, user, region,
			environment);
	}

	public static java.util.List getStandardDetails(
		java.util.List<java.lang.Long> standardIds) {
		return getFinder().getStandardDetails(standardIds);
	}

	public static java.util.List<java.lang.Long> getFlagStdId(long stdId) {
		return getFinder().getFlagStdId(stdId);
	}

	public static java.util.Map<java.lang.String, java.lang.Long> getFlagCategories() {
		return getFinder().getFlagCategories();
	}

	public static java.util.Map<java.lang.Long, java.util.List<java.lang.Long>> getStandardFlagCaterogies(
		java.util.List<java.lang.Long> standardIds) {
		return getFinder().getStandardFlagCaterogies(standardIds);
	}

	public static void sendEmailNotification(long userId,
		java.lang.String environment, java.lang.String template,
		java.lang.String message, java.lang.String log,
		java.lang.String requestId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getFinder()
			.sendEmailNotification(userId, environment, template, message, log,
			requestId);
	}

	public static boolean addToJobQueue(com.liferay.portal.model.User user,
		java.lang.String metadata, java.lang.String jobType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().addToJobQueue(user, metadata, jobType);
	}

	public static SpreadSheetAttributeUpdateFinder getFinder() {
		if (_finder == null) {
			_finder = (SpreadSheetAttributeUpdateFinder)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					SpreadSheetAttributeUpdateFinder.class.getName());

			ReferenceRegistry.registerReference(SpreadSheetAttributeUpdateFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(SpreadSheetAttributeUpdateFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(SpreadSheetAttributeUpdateFinderUtil.class,
			"_finder");
	}

	private static SpreadSheetAttributeUpdateFinder _finder;
}