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
public class GEMQlReportFinderUtil {
	public static java.util.List<com.ihg.brandstandards.custom.gem.model.QualityLeadModel> getGEMQlReport(
		long parentPublishId, long publishId, long regionId,
		java.lang.String regionCd, java.lang.String brandCd,
		java.lang.String stdIdLst, java.lang.String stdStatus,
		java.lang.String stdOwner, long seCategory, java.lang.String stdRegion,
		boolean isGlobalUser) {
		return getFinder()
				   .getGEMQlReport(parentPublishId, publishId, regionId,
			regionCd, brandCd, stdIdLst, stdStatus, stdOwner, seCategory,
			stdRegion, isGlobalUser);
	}

	public static java.util.List<com.ihg.brandstandards.custom.gem.model.QualityLeadModel> getGEMQlReport(
		java.lang.String query) {
		return getFinder().getGEMQlReport(query);
	}

	public static boolean saveGEMQlReport(
		java.util.List<com.ihg.brandstandards.custom.gem.model.QualityLeadModel> records,
		long publishDeptId, long parentPublishId, long publishId,
		long regionId, java.lang.String userName, boolean isGlobalUser,
		boolean isReSequence) {
		return getFinder()
				   .saveGEMQlReport(records, publishDeptId, parentPublishId,
			publishId, regionId, userName, isGlobalUser, isReSequence);
	}

	public static boolean populateScoringCounts(long puiblishDeptId,
		long parentPublishId, long publishId, long seTemplateId, long regionId,
		java.lang.String userName) {
		return getFinder()
				   .populateScoringCounts(puiblishDeptId, parentPublishId,
			publishId, seTemplateId, regionId, userName);
	}

	public static boolean syncBridgeGEMQlReport(long actvGemDeptId,
		long actvGemPublishDeptId, long brdgPublishId, long actvGemPublishId,
		long regionId, java.lang.String regionCd, java.lang.String brandCd,
		java.lang.String screenName, java.lang.String userName,
		java.lang.String seManualType, java.lang.String saManualType,
		java.lang.String wrManualType, boolean isGlobalUser) {
		return getFinder()
				   .syncBridgeGEMQlReport(actvGemDeptId, actvGemPublishDeptId,
			brdgPublishId, actvGemPublishId, regionId, regionCd, brandCd,
			screenName, userName, seManualType, saManualType, wrManualType,
			isGlobalUser);
	}

	public static boolean updateQlWithDataFromLastPublication(
		long curPublishId, long regionId) {
		return getFinder()
				   .updateQlWithDataFromLastPublication(curPublishId, regionId);
	}

	public static boolean updateQlWithDataFromPublication(long curPublishId,
		long lstPublishId, long regionId) {
		return getFinder()
				   .updateQlWithDataFromPublication(curPublishId, lstPublishId,
			regionId);
	}

	public static long getQlCountByPublishIdRegionId(long publishId,
		long regionId) {
		return getFinder().getQlCountByPublishIdRegionId(publishId, regionId);
	}

	public static long getLastGEMPublishId(long publishId) {
		return getFinder().getLastGEMPublishId(publishId);
	}

	public static java.util.List<java.lang.String> getStdOwners(
		long publishId, long regionId, java.lang.String regionCd) {
		return getFinder().getStdOwners(publishId, regionId, regionCd);
	}

	public static java.util.Map<java.lang.String, java.lang.String> getGemBktSeverityCatgyCounts(
		long seTemplateId) {
		return getFinder().getGemBktSeverityCatgyCounts(seTemplateId);
	}

	public static java.util.Map<java.lang.String, java.lang.String> getGemBktSeverityCatgyTotalCounts(
		long seTemplateId) {
		return getFinder().getGemBktSeverityCatgyTotalCounts(seTemplateId);
	}

	public static java.lang.String getScoringHeaderCounts(long seTemplateId,
		long gemDepartmentId) {
		return getFinder().getScoringHeaderCounts(seTemplateId, gemDepartmentId);
	}

	public static java.util.List<com.ihg.brandstandards.custom.gem.model.GEMScoreModel> getScoringPoints(
		long publishId, long regionId) {
		return getFinder().getScoringPoints(publishId, regionId);
	}

	public static boolean setScoringPoints(
		java.util.List<com.ihg.brandstandards.custom.gem.model.GEMScoreModel> scorePoints) {
		return getFinder().setScoringPoints(scorePoints);
	}

	public static boolean isGlobalMustNotSelectedForMeasurement(
		long publishId, long regionId) {
		return getFinder()
				   .isGlobalMustNotSelectedForMeasurement(publishId, regionId);
	}

	public static java.util.Map<java.lang.String, java.lang.String> getReportManualTypes(
		java.lang.String query) {
		return getFinder().getReportManualTypes(query);
	}

	public static java.util.Map<java.lang.String, java.lang.String> getGemPathFilterData(
		java.lang.String query) {
		return getFinder().getGemPathFilterData(query);
	}

	public static java.util.List<com.ihg.brandstandards.custom.gem.model.QualityLeadModel> getApplicableBrandsByStdId(
		long deptId, long stdId, long regionId) {
		return getFinder().getApplicableBrandsByStdId(deptId, stdId, regionId);
	}

	public static java.util.List<com.ihg.brandstandards.custom.gem.model.QualityLeadModel> getGEMDuplicatesReport(
		java.lang.String query) {
		return getFinder().getGEMDuplicatesReport(query);
	}

	public static java.util.List<com.ihg.brandstandards.db.model.GEMQlReport> getSpecGdlnByStdIdPublishIdDuplicate(
		long publishId, long regionId, long stdId,
		java.lang.String duplicateInd, java.lang.String stdType) {
		return getFinder()
				   .getSpecGdlnByStdIdPublishIdDuplicate(publishId, regionId,
			stdId, duplicateInd, stdType);
	}

	public static boolean executeSelectImportProcedure(java.lang.String query) {
		return getFinder().executeSelectImportProcedure(query);
	}

	public static GEMQlReportFinder getFinder() {
		if (_finder == null) {
			_finder = (GEMQlReportFinder)PortletBeanLocatorUtil.locate(com.ihg.brandstandards.db.service.ClpSerializer.getServletContextName(),
					GEMQlReportFinder.class.getName());

			ReferenceRegistry.registerReference(GEMQlReportFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(GEMQlReportFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(GEMQlReportFinderUtil.class,
			"_finder");
	}

	private static GEMQlReportFinder _finder;
}