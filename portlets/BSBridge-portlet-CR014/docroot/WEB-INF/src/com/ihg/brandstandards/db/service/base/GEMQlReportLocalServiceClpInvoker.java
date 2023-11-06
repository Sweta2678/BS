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

		_methodName580 = "getBeanIdentifier";

		_methodParameterTypes580 = new String[] {  };

		_methodName581 = "setBeanIdentifier";

		_methodParameterTypes581 = new String[] { "java.lang.String" };

		_methodName586 = "clearCache";

		_methodParameterTypes586 = new String[] {  };

		_methodName587 = "getGEMQlReport";

		_methodParameterTypes587 = new String[] {
				"long", "long", "long", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"long", "java.lang.String", "boolean"
			};

		_methodName588 = "getGEMQlReport";

		_methodParameterTypes588 = new String[] { "java.lang.String" };

		_methodName589 = "saveGEMQlReport";

		_methodParameterTypes589 = new String[] {
				"java.util.List", "long", "long", "long", "long",
				"java.lang.String", "boolean", "boolean"
			};

		_methodName590 = "populateScoringCounts";

		_methodParameterTypes590 = new String[] {
				"long", "long", "long", "long", "long", "java.lang.String"
			};

		_methodName591 = "syncBridgeGEMQlReport";

		_methodParameterTypes591 = new String[] {
				"long", "long", "long", "long", "long", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String",
				"boolean"
			};

		_methodName592 = "updateQlWithDataFromLastPublication";

		_methodParameterTypes592 = new String[] { "long", "long" };

		_methodName593 = "updateQlWithDataFromPublication";

		_methodParameterTypes593 = new String[] { "long", "long", "long" };

		_methodName594 = "getQlCountByPublishIdRegionId";

		_methodParameterTypes594 = new String[] { "long", "long" };

		_methodName595 = "getStdOwners";

		_methodParameterTypes595 = new String[] {
				"long", "long", "java.lang.String"
			};

		_methodName596 = "getGemBktSeverityCatgyCounts";

		_methodParameterTypes596 = new String[] { "long" };

		_methodName597 = "getScoringHeaderCounts";

		_methodParameterTypes597 = new String[] { "long", "long" };

		_methodName598 = "getGemBktSeverityCatgyTotalCounts";

		_methodParameterTypes598 = new String[] { "long" };

		_methodName599 = "getScoringPoints";

		_methodParameterTypes599 = new String[] { "long", "long" };

		_methodName600 = "setScoringPoints";

		_methodParameterTypes600 = new String[] { "java.util.List" };

		_methodName601 = "isGlobalMustNotSelectedForMeasurement";

		_methodParameterTypes601 = new String[] { "long", "long" };

		_methodName602 = "getReportManualTypes";

		_methodParameterTypes602 = new String[] { "java.lang.String" };

		_methodName603 = "getGemPathFilterData";

		_methodParameterTypes603 = new String[] { "java.lang.String" };

		_methodName604 = "getApplicableBrandsByStdId";

		_methodParameterTypes604 = new String[] { "long", "long", "long" };
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

		if (_methodName580.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes580, parameterTypes)) {
			return GEMQlReportLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName581.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes581, parameterTypes)) {
			GEMQlReportLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName586.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes586, parameterTypes)) {
			GEMQlReportLocalServiceUtil.clearCache();

			return null;
		}

		if (_methodName587.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes587, parameterTypes)) {
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

		if (_methodName588.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes588, parameterTypes)) {
			return GEMQlReportLocalServiceUtil.getGEMQlReport((java.lang.String)arguments[0]);
		}

		if (_methodName589.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes589, parameterTypes)) {
			return GEMQlReportLocalServiceUtil.saveGEMQlReport((java.util.List<com.ihg.brandstandards.custom.gem.model.QualityLeadModel>)arguments[0],
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				((Long)arguments[4]).longValue(),
				(java.lang.String)arguments[5],
				((Boolean)arguments[6]).booleanValue(),
				((Boolean)arguments[7]).booleanValue());
		}

		if (_methodName590.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes590, parameterTypes)) {
			return GEMQlReportLocalServiceUtil.populateScoringCounts(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				((Long)arguments[4]).longValue(), (java.lang.String)arguments[5]);
		}

		if (_methodName591.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes591, parameterTypes)) {
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

		if (_methodName592.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes592, parameterTypes)) {
			return GEMQlReportLocalServiceUtil.updateQlWithDataFromLastPublication(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName593.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes593, parameterTypes)) {
			return GEMQlReportLocalServiceUtil.updateQlWithDataFromPublication(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue());
		}

		if (_methodName594.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes594, parameterTypes)) {
			return GEMQlReportLocalServiceUtil.getQlCountByPublishIdRegionId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName595.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes595, parameterTypes)) {
			return GEMQlReportLocalServiceUtil.getStdOwners(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(), (java.lang.String)arguments[2]);
		}

		if (_methodName596.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes596, parameterTypes)) {
			return GEMQlReportLocalServiceUtil.getGemBktSeverityCatgyCounts(((Long)arguments[0]).longValue());
		}

		if (_methodName597.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes597, parameterTypes)) {
			return GEMQlReportLocalServiceUtil.getScoringHeaderCounts(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName598.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes598, parameterTypes)) {
			return GEMQlReportLocalServiceUtil.getGemBktSeverityCatgyTotalCounts(((Long)arguments[0]).longValue());
		}

		if (_methodName599.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes599, parameterTypes)) {
			return GEMQlReportLocalServiceUtil.getScoringPoints(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName600.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes600, parameterTypes)) {
			return GEMQlReportLocalServiceUtil.setScoringPoints((java.util.List<com.ihg.brandstandards.custom.gem.model.GEMScoreModel>)arguments[0]);
		}

		if (_methodName601.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes601, parameterTypes)) {
			return GEMQlReportLocalServiceUtil.isGlobalMustNotSelectedForMeasurement(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName602.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes602, parameterTypes)) {
			return GEMQlReportLocalServiceUtil.getReportManualTypes((java.lang.String)arguments[0]);
		}

		if (_methodName603.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes603, parameterTypes)) {
			return GEMQlReportLocalServiceUtil.getGemPathFilterData((java.lang.String)arguments[0]);
		}

		if (_methodName604.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes604, parameterTypes)) {
			return GEMQlReportLocalServiceUtil.getApplicableBrandsByStdId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue());
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
	private String _methodName580;
	private String[] _methodParameterTypes580;
	private String _methodName581;
	private String[] _methodParameterTypes581;
	private String _methodName586;
	private String[] _methodParameterTypes586;
	private String _methodName587;
	private String[] _methodParameterTypes587;
	private String _methodName588;
	private String[] _methodParameterTypes588;
	private String _methodName589;
	private String[] _methodParameterTypes589;
	private String _methodName590;
	private String[] _methodParameterTypes590;
	private String _methodName591;
	private String[] _methodParameterTypes591;
	private String _methodName592;
	private String[] _methodParameterTypes592;
	private String _methodName593;
	private String[] _methodParameterTypes593;
	private String _methodName594;
	private String[] _methodParameterTypes594;
	private String _methodName595;
	private String[] _methodParameterTypes595;
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
}