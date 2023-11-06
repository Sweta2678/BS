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

package com.ihg.brandstandards.db.service.base;

import com.ihg.brandstandards.db.service.GEMQlReportLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Mummanedi
 * @generated
 */
public class GEMQlReportLocalServiceClpInvoker {
	public GEMQlReportLocalServiceClpInvoker() {
		_methodName0 = "addGEMQlReport";

		_methodParameterTypes0 = new String[] {
				"com.ihg.brandstandards.db.model.GEMQlReport"
			};

		_methodName1 = "createGEMQlReport";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteGEMQlReport";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteGEMQlReport";

		_methodParameterTypes3 = new String[] {
				"com.ihg.brandstandards.db.model.GEMQlReport"
			};

		_methodName4 = "dynamicQuery";

		_methodParameterTypes4 = new String[] {  };

		_methodName5 = "dynamicQuery";

		_methodParameterTypes5 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName6 = "dynamicQuery";

		_methodParameterTypes6 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
			};

		_methodName7 = "dynamicQuery";

		_methodParameterTypes7 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName8 = "dynamicQueryCount";

		_methodParameterTypes8 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName9 = "dynamicQueryCount";

		_methodParameterTypes9 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery",
				"com.liferay.portal.kernel.dao.orm.Projection"
			};

		_methodName10 = "fetchGEMQlReport";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getGEMQlReport";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getGEMQlReports";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getGEMQlReportsCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateGEMQlReport";

		_methodParameterTypes15 = new String[] {
				"com.ihg.brandstandards.db.model.GEMQlReport"
			};

		_methodName590 = "getBeanIdentifier";

		_methodParameterTypes590 = new String[] {  };

		_methodName591 = "setBeanIdentifier";

		_methodParameterTypes591 = new String[] { "java.lang.String" };

		_methodName596 = "clearCache";

		_methodParameterTypes596 = new String[] {  };

		_methodName597 = "getGEMQlReport";

		_methodParameterTypes597 = new String[] {
				"long", "long", "long", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long", "java.lang.String", "boolean"
			};

		_methodName598 = "getGEMQlReport";

		_methodParameterTypes598 = new String[] { "java.lang.String" };

		_methodName599 = "saveGEMQlReport";

		_methodParameterTypes599 = new String[] {
				"java.util.List", "long", "long", "long", "long",
				"java.lang.String", "boolean", "boolean"
			};

		_methodName600 = "populateScoringCounts";

		_methodParameterTypes600 = new String[] {
				"long", "long", "long", "long", "long", "java.lang.String"
			};

		_methodName601 = "syncBridgeGEMQlReport";

		_methodParameterTypes601 = new String[] {
				"long", "long", "long", "long", "long", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"boolean"
			};

		_methodName602 = "updateQlWithDataFromLastPublication";

		_methodParameterTypes602 = new String[] { "long", "long" };

		_methodName603 = "updateQlWithDataFromPublication";

		_methodParameterTypes603 = new String[] { "long", "long", "long" };

		_methodName604 = "getQlCountByPublishIdRegionId";

		_methodParameterTypes604 = new String[] { "long", "long" };

		_methodName605 = "getStdOwners";

		_methodParameterTypes605 = new String[] {
				"long", "long", "java.lang.String"
			};

		_methodName606 = "getGemBktSeverityCatgyCounts";

		_methodParameterTypes606 = new String[] { "long" };

		_methodName607 = "getScoringHeaderCounts";

		_methodParameterTypes607 = new String[] { "long", "long" };

		_methodName608 = "getGemBktSeverityCatgyTotalCounts";

		_methodParameterTypes608 = new String[] { "long" };

		_methodName609 = "getScoringPoints";

		_methodParameterTypes609 = new String[] { "long", "long" };

		_methodName610 = "setScoringPoints";

		_methodParameterTypes610 = new String[] { "java.util.List" };

		_methodName611 = "isGlobalMustNotSelectedForMeasurement";

		_methodParameterTypes611 = new String[] { "long", "long" };

		_methodName612 = "getReportManualTypes";

		_methodParameterTypes612 = new String[] { "java.lang.String" };

		_methodName613 = "getGemPathFilterData";

		_methodParameterTypes613 = new String[] { "java.lang.String" };

		_methodName614 = "getApplicableBrandsByStdId";

		_methodParameterTypes614 = new String[] { "long", "long", "long" };

		_methodName615 = "getByPrntQlReportId";

		_methodParameterTypes615 = new String[] { "long" };

		_methodName616 = "getByStdIdDuplicatePublishId";

		_methodParameterTypes616 = new String[] {
				"long", "long", "long", "java.lang.String"
			};

		_methodName617 = "getGEMDuplicatesReport";

		_methodParameterTypes617 = new String[] { "java.lang.String" };

		_methodName618 = "getSpecGdlnByStdIdPublishIdDuplicate";

		_methodParameterTypes618 = new String[] {
				"long", "long", "long", "java.lang.String", "java.lang.String"
			};

		_methodName619 = "executeSelectImportProcedure";

		_methodParameterTypes619 = new String[] { "java.lang.String" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return GEMQlReportLocalServiceUtil.addGEMQlReport((com.ihg.brandstandards.db.model.GEMQlReport)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return GEMQlReportLocalServiceUtil.createGEMQlReport(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return GEMQlReportLocalServiceUtil.deleteGEMQlReport(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return GEMQlReportLocalServiceUtil.deleteGEMQlReport((com.ihg.brandstandards.db.model.GEMQlReport)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return GEMQlReportLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return GEMQlReportLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return GEMQlReportLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return GEMQlReportLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return GEMQlReportLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return GEMQlReportLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return GEMQlReportLocalServiceUtil.fetchGEMQlReport(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return GEMQlReportLocalServiceUtil.getGEMQlReport(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return GEMQlReportLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return GEMQlReportLocalServiceUtil.getGEMQlReports(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return GEMQlReportLocalServiceUtil.getGEMQlReportsCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return GEMQlReportLocalServiceUtil.updateGEMQlReport((com.ihg.brandstandards.db.model.GEMQlReport)arguments[0]);
		}

		if (_methodName590.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes590, parameterTypes)) {
			return GEMQlReportLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName591.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes591, parameterTypes)) {
			GEMQlReportLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName596.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes596, parameterTypes)) {
			GEMQlReportLocalServiceUtil.clearCache();

			return null;
		}

		if (_methodName597.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes597, parameterTypes)) {
			return GEMQlReportLocalServiceUtil.getGEMQlReport(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				(java.lang.String)arguments[5], (java.lang.String)arguments[6],
				(java.lang.String)arguments[7],
				((Long)arguments[8]).longValue(),
				(java.lang.String)arguments[9],
				((Boolean)arguments[10]).booleanValue());
		}

		if (_methodName598.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes598, parameterTypes)) {
			return GEMQlReportLocalServiceUtil.getGEMQlReport((java.lang.String)arguments[0]);
		}

		if (_methodName599.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes599, parameterTypes)) {
			return GEMQlReportLocalServiceUtil.saveGEMQlReport((java.util.List<com.ihg.brandstandards.custom.gem.model.QualityLeadModel>)arguments[0],
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				((Long)arguments[4]).longValue(),
				(java.lang.String)arguments[5],
				((Boolean)arguments[6]).booleanValue(),
				((Boolean)arguments[7]).booleanValue());
		}

		if (_methodName600.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes600, parameterTypes)) {
			return GEMQlReportLocalServiceUtil.populateScoringCounts(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				((Long)arguments[4]).longValue(), (java.lang.String)arguments[5]);
		}

		if (_methodName601.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes601, parameterTypes)) {
			return GEMQlReportLocalServiceUtil.syncBridgeGEMQlReport(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				((Long)arguments[4]).longValue(),
				(java.lang.String)arguments[5], (java.lang.String)arguments[6],
				(java.lang.String)arguments[7], (java.lang.String)arguments[8],
				(java.lang.String)arguments[9],
				(java.lang.String)arguments[10],
				(java.lang.String)arguments[11],
				((Boolean)arguments[12]).booleanValue());
		}

		if (_methodName602.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes602, parameterTypes)) {
			return GEMQlReportLocalServiceUtil.updateQlWithDataFromLastPublication(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName603.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes603, parameterTypes)) {
			return GEMQlReportLocalServiceUtil.updateQlWithDataFromPublication(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue());
		}

		if (_methodName604.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes604, parameterTypes)) {
			return GEMQlReportLocalServiceUtil.getQlCountByPublishIdRegionId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName605.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes605, parameterTypes)) {
			return GEMQlReportLocalServiceUtil.getStdOwners(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(), (java.lang.String)arguments[2]);
		}

		if (_methodName606.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes606, parameterTypes)) {
			return GEMQlReportLocalServiceUtil.getGemBktSeverityCatgyCounts(((Long)arguments[0]).longValue());
		}

		if (_methodName607.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes607, parameterTypes)) {
			return GEMQlReportLocalServiceUtil.getScoringHeaderCounts(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName608.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes608, parameterTypes)) {
			return GEMQlReportLocalServiceUtil.getGemBktSeverityCatgyTotalCounts(((Long)arguments[0]).longValue());
		}

		if (_methodName609.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes609, parameterTypes)) {
			return GEMQlReportLocalServiceUtil.getScoringPoints(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName610.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes610, parameterTypes)) {
			return GEMQlReportLocalServiceUtil.setScoringPoints((java.util.List<com.ihg.brandstandards.custom.gem.model.GEMScoreModel>)arguments[0]);
		}

		if (_methodName611.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes611, parameterTypes)) {
			return GEMQlReportLocalServiceUtil.isGlobalMustNotSelectedForMeasurement(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName612.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes612, parameterTypes)) {
			return GEMQlReportLocalServiceUtil.getReportManualTypes((java.lang.String)arguments[0]);
		}

		if (_methodName613.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes613, parameterTypes)) {
			return GEMQlReportLocalServiceUtil.getGemPathFilterData((java.lang.String)arguments[0]);
		}

		if (_methodName614.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes614, parameterTypes)) {
			return GEMQlReportLocalServiceUtil.getApplicableBrandsByStdId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue());
		}

		if (_methodName615.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes615, parameterTypes)) {
			return GEMQlReportLocalServiceUtil.getByPrntQlReportId(((Long)arguments[0]).longValue());
		}

		if (_methodName616.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes616, parameterTypes)) {
			return GEMQlReportLocalServiceUtil.getByStdIdDuplicatePublishId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(), (java.lang.String)arguments[3]);
		}

		if (_methodName617.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes617, parameterTypes)) {
			return GEMQlReportLocalServiceUtil.getGEMDuplicatesReport((java.lang.String)arguments[0]);
		}

		if (_methodName618.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes618, parameterTypes)) {
			return GEMQlReportLocalServiceUtil.getSpecGdlnByStdIdPublishIdDuplicate(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				(java.lang.String)arguments[3], (java.lang.String)arguments[4]);
		}

		if (_methodName619.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes619, parameterTypes)) {
			return GEMQlReportLocalServiceUtil.executeSelectImportProcedure((java.lang.String)arguments[0]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName2;
	private String[] _methodParameterTypes2;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
	private String _methodName7;
	private String[] _methodParameterTypes7;
	private String _methodName8;
	private String[] _methodParameterTypes8;
	private String _methodName9;
	private String[] _methodParameterTypes9;
	private String _methodName10;
	private String[] _methodParameterTypes10;
	private String _methodName11;
	private String[] _methodParameterTypes11;
	private String _methodName12;
	private String[] _methodParameterTypes12;
	private String _methodName13;
	private String[] _methodParameterTypes13;
	private String _methodName14;
	private String[] _methodParameterTypes14;
	private String _methodName15;
	private String[] _methodParameterTypes15;
	private String _methodName590;
	private String[] _methodParameterTypes590;
	private String _methodName591;
	private String[] _methodParameterTypes591;
	private String _methodName596;
	private String[] _methodParameterTypes596;
	private String _methodName597;
	private String[] _methodParameterTypes597;
	private String _methodName598;
	private String[] _methodParameterTypes598;
	private String _methodName599;
	private String[] _methodParameterTypes599;
	private String _methodName600;
	private String[] _methodParameterTypes600;
	private String _methodName601;
	private String[] _methodParameterTypes601;
	private String _methodName602;
	private String[] _methodParameterTypes602;
	private String _methodName603;
	private String[] _methodParameterTypes603;
	private String _methodName604;
	private String[] _methodParameterTypes604;
	private String _methodName605;
	private String[] _methodParameterTypes605;
	private String _methodName606;
	private String[] _methodParameterTypes606;
	private String _methodName607;
	private String[] _methodParameterTypes607;
	private String _methodName608;
	private String[] _methodParameterTypes608;
	private String _methodName609;
	private String[] _methodParameterTypes609;
	private String _methodName610;
	private String[] _methodParameterTypes610;
	private String _methodName611;
	private String[] _methodParameterTypes611;
	private String _methodName612;
	private String[] _methodParameterTypes612;
	private String _methodName613;
	private String[] _methodParameterTypes613;
	private String _methodName614;
	private String[] _methodParameterTypes614;
	private String _methodName615;
	private String[] _methodParameterTypes615;
	private String _methodName616;
	private String[] _methodParameterTypes616;
	private String _methodName617;
	private String[] _methodParameterTypes617;
	private String _methodName618;
	private String[] _methodParameterTypes618;
	private String _methodName619;
	private String[] _methodParameterTypes619;
}