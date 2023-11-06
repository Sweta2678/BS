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
public interface SpreadSheetAttributeUpdateFinder {
	public java.lang.String recordsNotAvailable(
		java.util.List<java.lang.Long> allStdIds,
		java.util.Map<java.lang.String, java.util.List<java.lang.Long>> stdIdsMap,
		com.liferay.portal.model.User user, java.lang.String region,
		java.lang.String environment);

	public java.util.List getStandardDetails(
		java.util.List<java.lang.Long> standardIds);

	public java.util.List<java.lang.Long> getFlagStdId(long stdId);

	public java.util.Map<java.lang.String, java.lang.Long> getFlagCategories();

	public java.util.Map<java.lang.Long, java.util.List<java.lang.Long>> getStandardFlagCaterogies(
		java.util.List<java.lang.Long> standardIds);

	public void sendEmailNotification(long userId,
		java.lang.String environment, java.lang.String template,
		java.lang.String message, java.lang.String log,
		java.lang.String requestId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public boolean addToJobQueue(com.liferay.portal.model.User user,
		java.lang.String metadata, java.lang.String jobType)
		throws com.liferay.portal.kernel.exception.SystemException;
}