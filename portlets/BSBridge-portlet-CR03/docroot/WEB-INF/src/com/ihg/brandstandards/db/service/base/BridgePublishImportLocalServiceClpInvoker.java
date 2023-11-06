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

import com.ihg.brandstandards.db.service.BridgePublishImportLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Mummanedi
 * @generated
 */
public class BridgePublishImportLocalServiceClpInvoker {
	public BridgePublishImportLocalServiceClpInvoker() {
		_methodName0 = "addBridgePublishImport";

		_methodParameterTypes0 = new String[] {
				"com.ihg.brandstandards.db.model.BridgePublishImport"
			};

		_methodName1 = "createBridgePublishImport";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteBridgePublishImport";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteBridgePublishImport";

		_methodParameterTypes3 = new String[] {
				"com.ihg.brandstandards.db.model.BridgePublishImport"
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

		_methodName10 = "fetchBridgePublishImport";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getBridgePublishImport";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getBridgePublishImports";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getBridgePublishImportsCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateBridgePublishImport";

		_methodParameterTypes15 = new String[] {
				"com.ihg.brandstandards.db.model.BridgePublishImport"
			};

		_methodName590 = "getBeanIdentifier";

		_methodParameterTypes590 = new String[] {  };

		_methodName591 = "setBeanIdentifier";

		_methodParameterTypes591 = new String[] { "java.lang.String" };

		_methodName596 = "createOraSequence";

		_methodParameterTypes596 = new String[] {  };

		_methodName597 = "addBridgePublishImport";

		_methodParameterTypes597 = new String[] {
				"java.util.List", "long", "java.lang.String", "long",
				"java.lang.String"
			};

		_methodName598 = "findByPublishIdAndStdId";

		_methodParameterTypes598 = new String[] { "long", "long" };

		_methodName599 = "getBridgeImportedRecordsCount";

		_methodParameterTypes599 = new String[] { "long", "long" };

		_methodName600 = "findByPublishIdAndRegionId";

		_methodParameterTypes600 = new String[] { "long", "long" };

		_methodName601 = "findByPublishIdRegionIdandSelectionInd";

		_methodParameterTypes601 = new String[] { "long", "long" };

		_methodName602 = "deleteBridgeImportByPublishIdAndRegionId";

		_methodParameterTypes602 = new String[] { "long", "long" };

		_methodName603 = "updateBridgePublishImport";

		_methodParameterTypes603 = new String[] {
				"long", "java.util.List", "java.util.List", "java.util.List",
				"java.util.List", "java.util.List", "java.util.List",
				"java.util.List", "java.util.List", "java.util.List"
			};

		_methodName604 = "getStandardsByRegion";

		_methodParameterTypes604 = new String[] { "long", "long" };

		_methodName605 = "getDiscountinuedStandards";

		_methodParameterTypes605 = new String[] {
				"java.util.List", "java.lang.String"
			};

		_methodName606 = "getMyPublicationIssuesCount";

		_methodParameterTypes606 = new String[] {
				"long", "long", "java.lang.String"
			};

		_methodName607 = "clearCache";

		_methodParameterTypes607 = new String[] {  };

		_methodName608 = "updateGlobalRegionalStdCountries";

		_methodParameterTypes608 = new String[] {
				"long", "long", "long", "java.lang.String"
			};

		_methodName609 = "updateStdCountriesState";

		_methodParameterTypes609 = new String[] {
				"long", "long", "long", "java.lang.String"
			};

		_methodName610 = "setBridgePublishForImport";

		_methodParameterTypes610 = new String[] { "long", "long", "java.util.Map" };

		_methodName611 = "getSTDToBeAddedCount";

		_methodParameterTypes611 = new String[] { "long", "long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return BridgePublishImportLocalServiceUtil.addBridgePublishImport((com.ihg.brandstandards.db.model.BridgePublishImport)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return BridgePublishImportLocalServiceUtil.createBridgePublishImport(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return BridgePublishImportLocalServiceUtil.deleteBridgePublishImport(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return BridgePublishImportLocalServiceUtil.deleteBridgePublishImport((com.ihg.brandstandards.db.model.BridgePublishImport)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return BridgePublishImportLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return BridgePublishImportLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return BridgePublishImportLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return BridgePublishImportLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return BridgePublishImportLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return BridgePublishImportLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return BridgePublishImportLocalServiceUtil.fetchBridgePublishImport(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return BridgePublishImportLocalServiceUtil.getBridgePublishImport(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return BridgePublishImportLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return BridgePublishImportLocalServiceUtil.getBridgePublishImports(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return BridgePublishImportLocalServiceUtil.getBridgePublishImportsCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return BridgePublishImportLocalServiceUtil.updateBridgePublishImport((com.ihg.brandstandards.db.model.BridgePublishImport)arguments[0]);
		}

		if (_methodName590.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes590, parameterTypes)) {
			return BridgePublishImportLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName591.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes591, parameterTypes)) {
			BridgePublishImportLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName596.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes596, parameterTypes)) {
			return BridgePublishImportLocalServiceUtil.createOraSequence();
		}

		if (_methodName597.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes597, parameterTypes)) {
			return BridgePublishImportLocalServiceUtil.addBridgePublishImport((java.util.List<java.lang.Long>)arguments[0],
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2],
				((Long)arguments[3]).longValue(), (java.lang.String)arguments[4]);
		}

		if (_methodName598.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes598, parameterTypes)) {
			return BridgePublishImportLocalServiceUtil.findByPublishIdAndStdId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName599.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes599, parameterTypes)) {
			return BridgePublishImportLocalServiceUtil.getBridgeImportedRecordsCount(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName600.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes600, parameterTypes)) {
			return BridgePublishImportLocalServiceUtil.findByPublishIdAndRegionId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName601.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes601, parameterTypes)) {
			return BridgePublishImportLocalServiceUtil.findByPublishIdRegionIdandSelectionInd(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName602.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes602, parameterTypes)) {
			BridgePublishImportLocalServiceUtil.deleteBridgeImportByPublishIdAndRegionId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());

			return null;
		}

		if (_methodName603.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes603, parameterTypes)) {
			BridgePublishImportLocalServiceUtil.updateBridgePublishImport(((Long)arguments[0]).longValue(),
				(java.util.List<java.lang.Long>)arguments[1],
				(java.util.List<java.lang.Long>)arguments[2],
				(java.util.List<java.lang.Long>)arguments[3],
				(java.util.List<java.lang.Long>)arguments[4],
				(java.util.List<java.lang.Long>)arguments[5],
				(java.util.List<java.lang.Long>)arguments[6],
				(java.util.List<java.lang.Long>)arguments[7],
				(java.util.List<java.lang.Long>)arguments[8],
				(java.util.List<java.lang.Long>)arguments[9]);

			return null;
		}

		if (_methodName604.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes604, parameterTypes)) {
			return BridgePublishImportLocalServiceUtil.getStandardsByRegion(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName605.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes605, parameterTypes)) {
			return BridgePublishImportLocalServiceUtil.getDiscountinuedStandards((java.util.List<java.lang.Long>)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName606.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes606, parameterTypes)) {
			return BridgePublishImportLocalServiceUtil.getMyPublicationIssuesCount(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(), (java.lang.String)arguments[2]);
		}

		if (_methodName607.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes607, parameterTypes)) {
			BridgePublishImportLocalServiceUtil.clearCache();

			return null;
		}

		if (_methodName608.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes608, parameterTypes)) {
			BridgePublishImportLocalServiceUtil.updateGlobalRegionalStdCountries(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(), (java.lang.String)arguments[3]);

			return null;
		}

		if (_methodName609.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes609, parameterTypes)) {
			BridgePublishImportLocalServiceUtil.updateStdCountriesState(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(), (java.lang.String)arguments[3]);

			return null;
		}

		if (_methodName610.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes610, parameterTypes)) {
			BridgePublishImportLocalServiceUtil.setBridgePublishForImport(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.util.Map<java.lang.Long, java.lang.String>)arguments[2]);

			return null;
		}

		if (_methodName611.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes611, parameterTypes)) {
			return BridgePublishImportLocalServiceUtil.getSTDToBeAddedCount(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
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
}