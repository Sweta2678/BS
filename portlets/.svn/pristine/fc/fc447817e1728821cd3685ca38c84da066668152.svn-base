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
public class BridgePublishFinderUtil {
	public static java.util.List<java.lang.Long> getStandardIds(long publishId) {
		return getFinder().getStandardIds(publishId);
	}

	public static java.util.Map<java.lang.String, java.lang.Long> getBridgeProgress(
		long publishId, java.lang.String chainCode, java.util.Date publishDate,
		long regionId, boolean allRegions, java.lang.String progressType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getBridgeProgress(publishId, chainCode, publishDate,
			regionId, allRegions, progressType);
	}

	public static java.util.Map<java.lang.String, java.lang.Long> getOverallProgress(
		long publishId, long regionId, boolean allRegions) {
		return getFinder().getOverallProgress(publishId, regionId, allRegions);
	}

	public static java.util.Map<java.lang.String, java.lang.Long> getComplianceProgress(
		long publishId, long regionId, java.lang.String chainCode,
		java.util.Date publishDate, boolean allRegions) {
		return getFinder()
				   .getComplianceProgress(publishId, regionId, chainCode,
			publishDate, allRegions);
	}

	public static java.util.Map<java.lang.String, java.lang.Long> getNotificationsProgress(
		long publishId, long regionId, java.lang.String chainCode,
		java.util.Date publishDate, boolean allRegions) {
		return getFinder()
				   .getNotificationsProgress(publishId, regionId, chainCode,
			publishDate, allRegions);
	}

	public static java.util.Map<java.lang.String, java.lang.Long> getTranslationProgress(
		long publishId, long regionId, boolean allRegions)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getTranslationProgress(publishId, regionId, allRegions);
	}

	public static java.util.Map<java.lang.String, java.lang.Long> getAttachTranslationProgress(
		long publishId, java.lang.String chainCode, long regionId,
		boolean allRegions)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getAttachTranslationProgress(publishId, chainCode,
			regionId, allRegions);
	}

	public static java.util.Map<java.lang.String, java.lang.Long> getLinksTranslationProgress(
		long publishId, java.lang.String chainCode, long regionId,
		boolean allRegions)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getLinksTranslationProgress(publishId, chainCode, regionId,
			allRegions);
	}

	public static java.util.Map<java.lang.String, java.lang.Long> getImageTranslationProgress(
		long publishId, java.lang.String chainCode, long regionId,
		boolean allRegions)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getImageTranslationProgress(publishId, chainCode, regionId,
			allRegions);
	}

	public static java.util.Map<java.lang.String, java.lang.Long> getIndexTranslationProgress(
		long publishId, java.lang.String chainCode, long regionId,
		boolean allRegions)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getIndexTranslationProgress(publishId, chainCode, regionId,
			allRegions);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.PublishStandardsExt> getProgressViewDetailsStandards(
		long publishId, long regionId, java.lang.String chainCode,
		java.util.Date publishDate, java.lang.String localeCode,
		java.lang.String statIndText) {
		return getFinder()
				   .getProgressViewDetailsStandards(publishId, regionId,
			chainCode, publishDate, localeCode, statIndText);
	}

	public static java.util.List getTranslationViewDetailsStandards(
		long publishId, long regionId, java.lang.String localeCode) {
		return getFinder()
				   .getTranslationViewDetailsStandards(publishId, regionId,
			localeCode);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.PublishQueue> getPublishQueueRecords(
		java.lang.String brandCode, java.lang.String environment,
		java.lang.String status) {
		return getFinder().getPublishQueueRecords(brandCode, environment, status);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.PublishStandardsExt> getUnpublishedDetailsStandards(
		long publishId, long regionId, java.lang.String chainCode,
		java.lang.String regionCode, java.lang.String stdIds) {
		return getFinder()
				   .getUnpublishedDetailsStandards(publishId, regionId,
			chainCode, regionCode, stdIds);
	}

	public static void resetBridgePublication(long bridgePublishId,
		long regionId, java.lang.String chainCode,
		java.lang.String userScreenName)
		throws com.liferay.portal.kernel.exception.SystemException {
		getFinder()
			.resetBridgePublication(bridgePublishId, regionId, chainCode,
			userScreenName);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.PublishStandardsExt> getMyPublicationByBrand(
		java.lang.String chainCode, java.lang.String regionCode,
		java.lang.String query)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().getMyPublicationByBrand(chainCode, regionCode, query);
	}

	public static void updateUnpublishedToPublishedRecords(long publishId,
		java.lang.String brandCode, long regionId, java.lang.String screenName,
		java.lang.String stdIds) {
		getFinder()
			.updateUnpublishedToPublishedRecords(publishId, brandCode,
			regionId, screenName, stdIds);
	}

	public static void createDraftPublication(long publishId,
		java.lang.String brandCode, java.lang.String screenName) {
		getFinder().createDraftPublication(publishId, brandCode, screenName);
	}

	public static long getStandardCountForPublication(long publishId) {
		return getFinder().getStandardCountForPublication(publishId);
	}

	public static com.ihg.brandstandards.db.model.BridgePublish createOraSequence()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().createOraSequence();
	}

	public static boolean updateBridgePublishAndCountryFromImport(
		long bridgePublishId, long prodPublishId, java.lang.String brandCode,
		long regionId, java.lang.String screenName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .updateBridgePublishAndCountryFromImport(bridgePublishId,
			prodPublishId, brandCode, regionId, screenName);
	}

	public static java.util.List<java.lang.Long> getBridgePublishStandardsByParent(
		java.lang.String query)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().getBridgePublishStandardsByParent(query);
	}

	public static com.ihg.brandstandards.db.model.BridgePublish getBridgePublishStandardsById(
		java.lang.String query)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().getBridgePublishStandardsById(query);
	}

	public static java.util.List<com.ihg.brandstandards.custom.model.Standard> getStandardDetails(
		java.lang.String query) {
		return getFinder().getStandardDetails(query);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.PublishStandardsExt> getPublishedStandardsCompliance(
		java.util.List<java.lang.Long> stdIds, java.lang.String stdType,
		java.lang.String brandCd, java.lang.String regionCode,
		java.lang.String fromDate, java.lang.String toDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getPublishedStandardsCompliance(stdIds, stdType, brandCd,
			regionCode, fromDate, toDate);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.PublishStandardsExt> getBridgeStandardsCompliance(
		java.util.List<java.lang.Long> stdIds, java.lang.String stdType,
		java.lang.String brandCd, java.lang.String regionCode,
		java.lang.String fromDate, java.lang.String toDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getBridgeStandardsCompliance(stdIds, stdType, brandCd,
			regionCode, fromDate, toDate);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.PublishStandardsExt> getStandardsCompliance(
		java.util.List<java.lang.Long> stdIds, java.lang.String stdType,
		java.lang.String environment, java.lang.String brandCd,
		java.lang.String regionCode, java.lang.String fromDate,
		java.lang.String toDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getStandardsCompliance(stdIds, stdType, environment,
			brandCd, regionCode, fromDate, toDate);
	}

	public static java.util.Map<java.lang.String, java.lang.String> getPublishedStandardComplianceDetails(
		long stdId, java.lang.String brandCd, java.lang.String regionCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getPublishedStandardComplianceDetails(stdId, brandCd,
			regionCode);
	}

	public static java.util.Map<java.lang.String, java.lang.String> getBridgeStandardComplianceDetails(
		long stdId, java.lang.String brandCd, java.lang.String regionCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getBridgeStandardComplianceDetails(stdId, brandCd,
			regionCode);
	}

	public static java.util.Map<java.lang.String, java.lang.String> getStandardComplianceDetails(
		long stdId, java.lang.String environment, java.lang.String brandCd,
		java.lang.String regionCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getStandardComplianceDetails(stdId, environment, brandCd,
			regionCode);
	}

	public static void createManuals(long publishQueueId, long publishId,
		java.lang.String emailAddress, java.lang.String userName) {
		getFinder()
			.createManuals(publishQueueId, publishId, emailAddress, userName);
	}

	public static void addStdToBridgeForAddById(long bridgePublishId,
		long prodPublishId, java.lang.String brandCode, long regionId,
		java.util.List<java.lang.Long> stdIds, java.lang.String screenName) {
		getFinder()
			.addStdToBridgeForAddById(bridgePublishId, prodPublishId,
			brandCode, regionId, stdIds, screenName);
	}

	public static java.util.List<java.lang.Long> getMissingReferences(
		long publishId, long regionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().getMissingReferences(publishId, regionId);
	}

	public static java.util.List<java.lang.Long> getBridgePublishIdsByStdId(
		long stdId) throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().getBridgePublishIdsByStdId(stdId);
	}

	public static java.util.List<java.lang.Long> getRegionsByPublishIdAndStdId(
		long publishId, long stdId) {
		return getFinder().getRegionsByPublishIdAndStdId(publishId, stdId);
	}

	public static java.util.List<java.lang.Long> getLongValues(
		java.lang.String query, java.lang.String columnName) {
		return getFinder().getLongValues(query, columnName);
	}

	public static BridgePublishFinder getFinder() {
		if (_finder == null) {
			_finder = (BridgePublishFinder)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					BridgePublishFinder.class.getName());

			ReferenceRegistry.registerReference(BridgePublishFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(BridgePublishFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(BridgePublishFinderUtil.class,
			"_finder");
	}

	private static BridgePublishFinder _finder;
}