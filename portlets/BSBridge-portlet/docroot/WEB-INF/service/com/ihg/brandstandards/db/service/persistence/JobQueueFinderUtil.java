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
public class JobQueueFinderUtil {
	public static boolean isJobQueueExistWithSameMetadata(
		java.lang.String xmlMetadata, java.lang.String jobOwner,
		java.lang.String jobType) {
		return getFinder()
				   .isJobQueueExistWithSameMetadata(xmlMetadata, jobOwner,
			jobType);
	}

	public static boolean isJobQueueExistWithSameMetadata(
		java.lang.String xmlMetadata, java.lang.String jobOwner,
		java.lang.String jobType, java.lang.String jobStatus) {
		return getFinder()
				   .isJobQueueExistWithSameMetadata(xmlMetadata, jobOwner,
			jobType, jobStatus);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.JobQueue> getJobQueuesExceptFullManuals() {
		return getFinder().getJobQueuesExceptFullManuals();
	}

	public static boolean insertJobQueueUsingOraSequence(
		java.lang.String jobOwner, java.lang.String jobType,
		java.lang.String metaData, java.lang.String linkURL,
		java.lang.String notificationEmail, java.lang.String createUserId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .insertJobQueueUsingOraSequence(jobOwner, jobType, metaData,
			linkURL, notificationEmail, createUserId);
	}

	public static JobQueueFinder getFinder() {
		if (_finder == null) {
			_finder = (JobQueueFinder)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					JobQueueFinder.class.getName());

			ReferenceRegistry.registerReference(JobQueueFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(JobQueueFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(JobQueueFinderUtil.class, "_finder");
	}

	private static JobQueueFinder _finder;
}