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
public class BridgePublishImportFinderUtil {
	public static com.ihg.brandstandards.db.model.BridgePublishImport createOraSequence()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().createOraSequence();
	}

	public static int addBridgePublishImport(
		java.util.List<java.lang.Long> stdIds, long publishId,
		java.lang.String chainCode, long rgnId, java.lang.String screenName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .addBridgePublishImport(stdIds, publishId, chainCode, rgnId,
			screenName);
	}

	public static void updateBridgePublishImport(long publishId,
		java.util.List<java.lang.Long> mustPublish,
		java.util.List<java.lang.Long> mustNotPublish,
		java.util.List<java.lang.Long> unPublish,
		java.util.List<java.lang.Long> wrongBrand,
		java.util.List<java.lang.Long> wrongRgn,
		java.util.List<java.lang.Long> doPublish,
		java.util.List<java.lang.Long> discont,
		java.util.List<java.lang.Long> missing,
		java.util.List<java.lang.Long> orphan)
		throws com.liferay.portal.kernel.exception.SystemException {
		getFinder()
			.updateBridgePublishImport(publishId, mustPublish, mustNotPublish,
			unPublish, wrongBrand, wrongRgn, doPublish, discont, missing, orphan);
	}

	public static void setBridgePublishForImport(long publishId, long rgnId,
		java.util.Map<java.lang.Long, java.lang.String> importSelection)
		throws com.liferay.portal.kernel.exception.SystemException {
		getFinder().setBridgePublishForImport(publishId, rgnId, importSelection);
	}

	public static int getBridgeImportedRecordsCount(long publishId,
		long regionId) {
		return getFinder().getBridgeImportedRecordsCount(publishId, regionId);
	}

	public static void deleteBridgeImportByPublishIdAndRegionId(
		long publishId, long regionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getFinder().deleteBridgeImportByPublishIdAndRegionId(publishId, regionId);
	}

	public static java.util.List<java.lang.Long> getStandardsByRegion(
		long publishId, long regionId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().getStandardsByRegion(publishId, regionId);
	}

	public static long getMyPublicationIssuesCount(long publishId,
		long regionId, java.lang.String vldStatusExclude) {
		return getFinder()
				   .getMyPublicationIssuesCount(publishId, regionId,
			vldStatusExclude);
	}

	public static java.util.List<java.lang.Long> getDiscountinuedStandards(
		java.util.List<java.lang.Long> stdIds, java.lang.String chainCode) {
		return getFinder().getDiscountinuedStandards(stdIds, chainCode);
	}

	public static void updateGlobalRegionalStdCountries(long publishId,
		long stdId, long cmsRegionId, java.lang.String userScreenName) {
		getFinder()
			.updateGlobalRegionalStdCountries(publishId, stdId, cmsRegionId,
			userScreenName);
	}

	public static void updateStdCountriesState(long publishId, long stdId,
		long cmsRegionId, java.lang.String userScreenName) {
		getFinder()
			.updateStdCountriesState(publishId, stdId, cmsRegionId,
			userScreenName);
	}

	public static long getSTDToBeAddedCount(long publishId, long rgnId) {
		return getFinder().getSTDToBeAddedCount(publishId, rgnId);
	}

	public static BridgePublishImportFinder getFinder() {
		if (_finder == null) {
			_finder = (BridgePublishImportFinder)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					BridgePublishImportFinder.class.getName());

			ReferenceRegistry.registerReference(BridgePublishImportFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(BridgePublishImportFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(BridgePublishImportFinderUtil.class,
			"_finder");
	}

	private static BridgePublishImportFinder _finder;
}