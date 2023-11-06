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
public interface BridgePublishFinder {
	public java.util.List<java.lang.Long> getStandardIds(long publishId);

	public java.util.Map<java.lang.String, java.lang.Long> getBridgeProgress(
		long publishId, java.lang.String chainCode, java.util.Date publishDate,
		long regionId, boolean allRegions, java.lang.String progressType)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.Map<java.lang.String, java.lang.Long> getOverallProgress(
		long publishId, long regionId, boolean allRegions);

	public java.util.Map<java.lang.String, java.lang.Long> getComplianceProgress(
		long publishId, long regionId, java.lang.String chainCode,
		java.util.Date publishDate, boolean allRegions);

	public java.util.Map<java.lang.String, java.lang.Long> getNotificationsProgress(
		long publishId, long regionId, java.lang.String chainCode,
		java.util.Date publishDate, boolean allRegions);

	public java.util.Map<java.lang.String, java.lang.Long> getTranslationProgress(
		long publishId, long regionId, boolean allRegions)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.Map<java.lang.String, java.lang.Long> getAttachTranslationProgress(
		long publishId, java.lang.String chainCode, long regionId,
		boolean allRegions)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.Map<java.lang.String, java.lang.Long> getLinksTranslationProgress(
		long publishId, java.lang.String chainCode, long regionId,
		boolean allRegions)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.Map<java.lang.String, java.lang.Long> getImageTranslationProgress(
		long publishId, java.lang.String chainCode, long regionId,
		boolean allRegions)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.Map<java.lang.String, java.lang.Long> getIndexTranslationProgress(
		long publishId, java.lang.String chainCode, long regionId,
		boolean allRegions)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.ihg.brandstandards.db.model.PublishStandardsExt> getProgressViewDetailsStandards(
		long publishId, long regionId, java.lang.String chainCode,
		java.util.Date publishDate, java.lang.String localeCode,
		java.lang.String statIndText);

	public java.util.List getTranslationViewDetailsStandards(long publishId,
		long regionId, java.lang.String localeCode);

	public java.util.List<com.ihg.brandstandards.db.model.PublishQueue> getPublishQueueRecords(
		java.lang.String brandCode, java.lang.String environment,
		java.lang.String status);

	public java.util.List<com.ihg.brandstandards.db.model.PublishStandardsExt> getUnpublishedDetailsStandards(
		long publishId, long regionId, java.lang.String chainCode,
		java.lang.String regionCode, java.lang.String stdIds);

	public void resetBridgePublication(long bridgePublishId, long regionId,
		java.lang.String chainCode, java.lang.String userScreenName)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.ihg.brandstandards.db.model.PublishStandardsExt> getMyPublicationByBrand(
		java.lang.String chainCode, java.lang.String regionCode,
		java.lang.String query)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void updateUnpublishedToPublishedRecords(long publishId,
		java.lang.String brandCode, long regionId, java.lang.String screenName,
		java.lang.String stdIds);

	public void createDraftPublication(long publishId,
		java.lang.String brandCode, java.lang.String screenName);

	public long getStandardCountForPublication(long publishId);

	public com.ihg.brandstandards.db.model.BridgePublish createOraSequence()
		throws com.liferay.portal.kernel.exception.SystemException;

	public boolean updateBridgePublishAndCountryFromImport(
		long bridgePublishId, long prodPublishId, java.lang.String brandCode,
		long regionId, java.lang.String screenName)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<java.lang.Long> getBridgePublishStandardsByParent(
		java.lang.String query)
		throws com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.BridgePublish getBridgePublishStandardsById(
		java.lang.String query)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.ihg.brandstandards.custom.model.Standard> getStandardDetails(
		java.lang.String query);

	public java.util.List<com.ihg.brandstandards.db.model.PublishStandardsExt> getPublishedStandardsCompliance(
		java.util.List<java.lang.Long> stdIds, java.lang.String stdType,
		java.lang.String brandCd, java.lang.String regionCode,
		java.lang.String fromDate, java.lang.String toDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.ihg.brandstandards.db.model.PublishStandardsExt> getBridgeStandardsCompliance(
		java.util.List<java.lang.Long> stdIds, java.lang.String stdType,
		java.lang.String brandCd, java.lang.String regionCode,
		java.lang.String fromDate, java.lang.String toDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.ihg.brandstandards.db.model.PublishStandardsExt> getStandardsCompliance(
		java.util.List<java.lang.Long> stdIds, java.lang.String stdType,
		java.lang.String environment, java.lang.String brandCd,
		java.lang.String regionCode, java.lang.String fromDate,
		java.lang.String toDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.Map<java.lang.String, java.lang.String> getPublishedStandardComplianceDetails(
		long stdId, java.lang.String brandCd, java.lang.String regionCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.Map<java.lang.String, java.lang.String> getBridgeStandardComplianceDetails(
		long stdId, java.lang.String brandCd, java.lang.String regionCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.Map<java.lang.String, java.lang.String> getStandardComplianceDetails(
		long stdId, java.lang.String environment, java.lang.String brandCd,
		java.lang.String regionCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void createManuals(long publishQueueId, long publishId,
		java.lang.String emailAddress, java.lang.String userName);

	public void addStdToBridgeForAddById(long bridgePublishId,
		long prodPublishId, java.lang.String brandCode, long regionId,
		java.util.List<java.lang.Long> stdIds, java.lang.String screenName);

	public java.util.List<java.lang.Long> getMissingReferences(long publishId,
		long regionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<java.lang.Long> getBridgePublishIdsByStdId(long stdId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<java.lang.Long> getRegionsByPublishIdAndStdId(
		long publishId, long stdId);

	public java.util.List<java.lang.Long> getLongValues(
		java.lang.String query, java.lang.String columnName);
}