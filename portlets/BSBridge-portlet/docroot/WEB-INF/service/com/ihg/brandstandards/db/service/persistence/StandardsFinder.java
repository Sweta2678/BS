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
public interface StandardsFinder {
	public java.util.List<com.ihg.brandstandards.db.model.Standards> getStandardsAdvancedFilterResults(
		java.util.Map<java.lang.String, ?> criteriaMap, boolean approverFlag,
		java.lang.String standardId, java.lang.String stdType,
		java.lang.String preferBrand, java.lang.String discontFilter)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void addChildTaxonomies(long index, java.util.List arlIndex)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.ihg.brandstandards.db.model.Standards> findByStandardId(
		long standardId, java.lang.String regionCode, java.lang.String[] brands)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.ihg.brandstandards.db.model.Standards> getStandards(
		long stdId) throws com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.brandstandards.db.model.Standards getStdByStdId(long stdId,
		java.lang.String chainCode, java.lang.String discontFilter)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.ihg.brandstandards.db.model.Standards> getStandardsByStdId(
		java.util.List<java.lang.Long> stdIds, java.lang.String chainCode,
		java.lang.String discontFilter)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.ihg.brandstandards.db.model.Standards> getStdsByBrand(
		long stdId, java.lang.String chainCode, java.lang.String stdType,
		boolean fetchAll, java.lang.String discontFilter)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.ihg.brandstandards.db.model.PublishExtStd> getPublishedStandards(
		long stdId, java.lang.String stdType, java.lang.String brandCd,
		java.lang.String filterOn, java.lang.String isNonMatch,
		java.lang.String fromDate, java.lang.String toDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.ihg.brandstandards.db.model.PublishExtStd> getPublishedStandards(
		java.lang.String brandCd, java.lang.String filterOn,
		java.lang.String isNonMatch, java.lang.String fromDate,
		java.lang.String toDate, java.lang.String filterIds)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.ihg.brandstandards.db.model.PublishExtStd> getPublishedSpecs(
		java.lang.String stdType, java.lang.String brandCd,
		java.lang.String fromDate, java.lang.String toDate)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void unLockRecords(java.lang.String stdIds,
		java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void lockRecords(java.lang.String stdIds, java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	public void setStandardsStatusUnlock(java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	public long getLockedStandardsCount(java.lang.String chainCode);

	public java.util.List<com.ihg.brandstandards.db.model.Standards> getStandardsByChainAndRegion(
		long stdId, long regionId, java.lang.String regionCode,
		java.lang.String chainCode, java.lang.String stdType);

	public long getTableSequenceEntryCount(java.lang.String query);
}