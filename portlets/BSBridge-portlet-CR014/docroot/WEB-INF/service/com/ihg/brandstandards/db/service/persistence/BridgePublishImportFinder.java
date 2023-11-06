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
public interface BridgePublishImportFinder {
	public com.ihg.brandstandards.db.model.BridgePublishImport createOraSequence()
		throws com.liferay.portal.kernel.exception.SystemException;

	public int addBridgePublishImport(java.util.List<java.lang.Long> stdIds,
		long publishId, java.lang.String chainCode, long rgnId,
		java.lang.String screenName)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void updateBridgePublishImport(long publishId,
		java.util.List<java.lang.Long> mustPublish,
		java.util.List<java.lang.Long> mustNotPublish,
		java.util.List<java.lang.Long> unPublish,
		java.util.List<java.lang.Long> wrongBrand,
		java.util.List<java.lang.Long> wrongRgn,
		java.util.List<java.lang.Long> doPublish,
		java.util.List<java.lang.Long> discont,
		java.util.List<java.lang.Long> missing,
		java.util.List<java.lang.Long> orphan)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void setBridgePublishForImport(long publishId, long rgnId,
		java.util.Map<java.lang.Long, java.lang.String> importSelection)
		throws com.liferay.portal.kernel.exception.SystemException;

	public int getBridgeImportedRecordsCount(long publishId, long regionId);

	public void deleteBridgeImportByPublishIdAndRegionId(long publishId,
		long regionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<java.lang.Long> getStandardsByRegion(long publishId,
		long regionId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public long getMyPublicationIssuesCount(long publishId, long regionId,
		java.lang.String vldStatusExclude);

	public java.util.List<java.lang.Long> getDiscountinuedStandards(
		java.util.List<java.lang.Long> stdIds, java.lang.String chainCode);

	public void updateGlobalRegionalStdCountries(long publishId, long stdId,
		long cmsRegionId, java.lang.String userScreenName);

	public void updateStdCountriesState(long publishId, long stdId,
		long cmsRegionId, java.lang.String userScreenName);

	public long getSTDToBeAddedCount(long publishId, long rgnId);
}