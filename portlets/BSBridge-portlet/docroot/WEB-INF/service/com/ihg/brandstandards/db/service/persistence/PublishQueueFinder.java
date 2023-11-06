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
public interface PublishQueueFinder {
	public com.ihg.brandstandards.db.model.PublishQueue getNewPublishQueue()
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.PublishQueue clonePublishQueue(
		long publishQueueId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.lang.String validateStdIds(java.lang.String stdIds,
		java.lang.String chainCd)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.ihg.brandstandards.db.model.PublishQueue> findPublishQueueByEnvironment(
		java.lang.String envType, int count)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int updatePublishQueueStatus(long publishQueueId,
		java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.lang.String getCountriesForPublication(long publishId,
		long publishQueueId, java.lang.String environment,
		java.lang.String userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void createManuals(long publishQueueId, java.lang.String environment)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void createReport(java.lang.String metaData,
		java.lang.String userId, java.lang.String emailAddr)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void createReport(java.lang.String metaData,
		java.lang.String userId, java.lang.String emailAddr,
		java.lang.String link, java.lang.String jobType)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.ihg.brandstandards.db.model.StandardsExt> getStandards(
		java.util.Map<java.lang.String, ?> criteriaMap)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.Map<java.lang.String, java.lang.String> getLocalesByStdId(
		java.util.List<java.lang.Long> stdIds, java.lang.String brand)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.Map<java.lang.String, java.lang.String> getLocalesByBrand(
		java.lang.String brand)
		throws com.liferay.portal.kernel.exception.SystemException;
}