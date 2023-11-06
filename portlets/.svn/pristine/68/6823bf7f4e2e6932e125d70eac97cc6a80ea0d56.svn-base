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
public class StandardsFinderUtil {
	public static java.util.List<com.ihg.brandstandards.db.model.Standards> getStandardsAdvancedFilterResults(
		java.util.Map<java.lang.String, ?> criteriaMap, boolean approverFlag,
		java.lang.String standardId, java.lang.String stdType,
		java.lang.String preferBrand, java.lang.String discontFilter)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getStandardsAdvancedFilterResults(criteriaMap,
			approverFlag, standardId, stdType, preferBrand, discontFilter);
	}

	public static void addChildTaxonomies(long index, java.util.List arlIndex)
		throws com.liferay.portal.kernel.exception.SystemException {
		getFinder().addChildTaxonomies(index, arlIndex);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.Standards> findByStandardId(
		long standardId, java.lang.String regionCode, java.lang.String[] brands)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().findByStandardId(standardId, regionCode, brands);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.Standards> getStandards(
		long stdId) throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().getStandards(stdId);
	}

	public static com.ihg.brandstandards.db.model.Standards getStdByStdId(
		long stdId, java.lang.String chainCode, java.lang.String discontFilter)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().getStdByStdId(stdId, chainCode, discontFilter);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.Standards> getStandardsByStdId(
		java.util.List<java.lang.Long> stdIds, java.lang.String chainCode,
		java.lang.String discontFilter)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().getStandardsByStdId(stdIds, chainCode, discontFilter);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.Standards> getStdsByBrand(
		long stdId, java.lang.String chainCode, java.lang.String stdType,
		boolean fetchAll, java.lang.String discontFilter)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getStdsByBrand(stdId, chainCode, stdType, fetchAll,
			discontFilter);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.PublishExtStd> getPublishedStandards(
		long stdId, java.lang.String stdType, java.lang.String brandCd,
		java.lang.String filterOn, java.lang.String isNonMatch,
		java.lang.String fromDate, java.lang.String toDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getPublishedStandards(stdId, stdType, brandCd, filterOn,
			isNonMatch, fromDate, toDate);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.PublishExtStd> getPublishedStandards(
		java.lang.String brandCd, java.lang.String filterOn,
		java.lang.String isNonMatch, java.lang.String fromDate,
		java.lang.String toDate, java.lang.String filterIds)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .getPublishedStandards(brandCd, filterOn, isNonMatch,
			fromDate, toDate, filterIds);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.PublishExtStd> getPublishedSpecs(
		java.lang.String stdType, java.lang.String brandCd,
		java.lang.String fromDate, java.lang.String toDate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder().getPublishedSpecs(stdType, brandCd, fromDate, toDate);
	}

	public static void unLockRecords(java.lang.String stdIds,
		java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		getFinder().unLockRecords(stdIds, chainCode);
	}

	public static void lockRecords(java.lang.String stdIds,
		java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		getFinder().lockRecords(stdIds, chainCode);
	}

	public static void setStandardsStatusUnlock(java.lang.String chainCode)
		throws com.liferay.portal.kernel.exception.SystemException {
		getFinder().setStandardsStatusUnlock(chainCode);
	}

	public static long getLockedStandardsCount(java.lang.String chainCode) {
		return getFinder().getLockedStandardsCount(chainCode);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.Standards> getStandardsByChainAndRegion(
		long stdId, long regionId, java.lang.String regionCode,
		java.lang.String chainCode, java.lang.String stdType) {
		return getFinder()
				   .getStandardsByChainAndRegion(stdId, regionId, regionCode,
			chainCode, stdType);
	}

	public static long getTableSequenceEntryCount(java.lang.String query) {
		return getFinder().getTableSequenceEntryCount(query);
	}

	public static StandardsFinder getFinder() {
		if (_finder == null) {
			_finder = (StandardsFinder)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					StandardsFinder.class.getName());

			ReferenceRegistry.registerReference(StandardsFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(StandardsFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(StandardsFinderUtil.class, "_finder");
	}

	private static StandardsFinder _finder;
}