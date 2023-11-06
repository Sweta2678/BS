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

import com.ihg.brandstandards.db.service.BridgePublishLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Mummanedi
 * @generated
 */
public class BridgePublishLocalServiceClpInvoker {
	public BridgePublishLocalServiceClpInvoker() {
		_methodName0 = "addBridgePublish";

		_methodParameterTypes0 = new String[] {
				"com.ihg.brandstandards.db.model.BridgePublish"
			};

		_methodName1 = "createBridgePublish";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteBridgePublish";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteBridgePublish";

		_methodParameterTypes3 = new String[] {
				"com.ihg.brandstandards.db.model.BridgePublish"
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

		_methodName10 = "fetchBridgePublish";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getBridgePublish";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getBridgePublishs";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getBridgePublishsCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateBridgePublish";

		_methodParameterTypes15 = new String[] {
				"com.ihg.brandstandards.db.model.BridgePublish"
			};

		_methodName590 = "getBeanIdentifier";

		_methodParameterTypes590 = new String[] {  };

		_methodName591 = "setBeanIdentifier";

		_methodParameterTypes591 = new String[] { "java.lang.String" };

		_methodName596 = "clearCache";

		_methodParameterTypes596 = new String[] {  };

		_methodName597 = "getByPublish";

		_methodParameterTypes597 = new String[] { "long" };

		_methodName598 = "getByPublishIdAndStdId";

		_methodParameterTypes598 = new String[] { "long", "long" };

		_methodName599 = "getByPublishIdAndRegionId";

		_methodParameterTypes599 = new String[] { "long", "long" };

		_methodName600 = "getByPublishIdRegionIdAndStdId";

		_methodParameterTypes600 = new String[] { "long", "long", "long" };

		_methodName601 = "getStandardIds";

		_methodParameterTypes601 = new String[] { "long" };

		_methodName602 = "getBridgeProgress";

		_methodParameterTypes602 = new String[] {
				"long", "java.lang.String", "java.util.Date", "long", "boolean",
				"java.lang.String"
			};

		_methodName603 = "getOverallProgress";

		_methodParameterTypes603 = new String[] { "long", "long", "boolean" };

		_methodName604 = "getTranslationProgress";

		_methodParameterTypes604 = new String[] { "long", "long", "boolean" };

		_methodName605 = "getIndexTranslationProgress";

		_methodParameterTypes605 = new String[] {
				"long", "java.lang.String", "long", "boolean"
			};

		_methodName606 = "getProgressViewDetailsStandards";

		_methodParameterTypes606 = new String[] {
				"long", "long", "java.lang.String", "java.util.Date",
				"java.lang.String", "java.lang.String"
			};

		_methodName607 = "getUnpublishedDetailsStandards";

		_methodParameterTypes607 = new String[] {
				"long", "long", "java.lang.String", "java.lang.String",
				"java.lang.String"
			};

		_methodName608 = "getTranslationViewDetailsStandards";

		_methodParameterTypes608 = new String[] {
				"long", "long", "java.lang.String"
			};

		_methodName609 = "getPublishQueueRecords";

		_methodParameterTypes609 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String"
			};

		_methodName610 = "resetBridgePublication";

		_methodParameterTypes610 = new String[] {
				"long", "long", "java.lang.String", "java.lang.String"
			};

		_methodName611 = "updateUnpublishedToPublishedRecords";

		_methodParameterTypes611 = new String[] {
				"long", "java.lang.String", "long", "java.lang.String",
				"java.lang.String"
			};

		_methodName612 = "createDraftPublication";

		_methodParameterTypes612 = new String[] {
				"long", "java.lang.String", "java.lang.String"
			};

		_methodName613 = "getMyPublicationByBrand";

		_methodParameterTypes613 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String"
			};

		_methodName614 = "getStandardCountForPublication";

		_methodParameterTypes614 = new String[] { "long" };

		_methodName615 = "createOraSequence";

		_methodParameterTypes615 = new String[] {  };

		_methodName616 = "updateBridgePublishAndCountryFromImport";

		_methodParameterTypes616 = new String[] {
				"long", "long", "java.lang.String", "long", "java.lang.String"
			};

		_methodName617 = "getBridgePublishStandardsByParent";

		_methodParameterTypes617 = new String[] { "java.lang.String" };

		_methodName618 = "getBridgePublishStandardsById";

		_methodParameterTypes618 = new String[] { "java.lang.String" };

		_methodName619 = "getStandardDetails";

		_methodParameterTypes619 = new String[] { "java.lang.String" };

		_methodName620 = "getPublishedStandardsCompliance";

		_methodParameterTypes620 = new String[] {
				"java.util.List", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String"
			};

		_methodName621 = "getPublishedStandardComplianceDetails";

		_methodParameterTypes621 = new String[] {
				"long", "java.lang.String", "java.lang.String"
			};

		_methodName622 = "getBridgeStandardsCompliance";

		_methodParameterTypes622 = new String[] {
				"java.util.List", "java.lang.String", "java.lang.String",
				"java.lang.String", "java.lang.String", "java.lang.String"
			};

		_methodName623 = "getBridgeStandardComplianceDetails";

		_methodParameterTypes623 = new String[] {
				"long", "java.lang.String", "java.lang.String"
			};

		_methodName624 = "createManuals";

		_methodParameterTypes624 = new String[] {
				"long", "long", "java.lang.String", "java.lang.String"
			};

		_methodName625 = "getMissingReferences";

		_methodParameterTypes625 = new String[] { "long", "long" };

		_methodName626 = "addStdToBridgeForAddById";

		_methodParameterTypes626 = new String[] {
				"long", "long", "java.lang.String", "long", "java.util.List",
				"java.lang.String"
			};

		_methodName627 = "getBridgePublishIdsByStdId";

		_methodParameterTypes627 = new String[] { "long" };

		_methodName628 = "getRegionsByPublishIdAndStdId";

		_methodParameterTypes628 = new String[] { "long", "long" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return BridgePublishLocalServiceUtil.addBridgePublish((com.ihg.brandstandards.db.model.BridgePublish)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return BridgePublishLocalServiceUtil.createBridgePublish(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return BridgePublishLocalServiceUtil.deleteBridgePublish(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return BridgePublishLocalServiceUtil.deleteBridgePublish((com.ihg.brandstandards.db.model.BridgePublish)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return BridgePublishLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return BridgePublishLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return BridgePublishLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return BridgePublishLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return BridgePublishLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return BridgePublishLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return BridgePublishLocalServiceUtil.fetchBridgePublish(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return BridgePublishLocalServiceUtil.getBridgePublish(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return BridgePublishLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return BridgePublishLocalServiceUtil.getBridgePublishs(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return BridgePublishLocalServiceUtil.getBridgePublishsCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return BridgePublishLocalServiceUtil.updateBridgePublish((com.ihg.brandstandards.db.model.BridgePublish)arguments[0]);
		}

		if (_methodName590.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes590, parameterTypes)) {
			return BridgePublishLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName591.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes591, parameterTypes)) {
			BridgePublishLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName596.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes596, parameterTypes)) {
			BridgePublishLocalServiceUtil.clearCache();

			return null;
		}

		if (_methodName597.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes597, parameterTypes)) {
			return BridgePublishLocalServiceUtil.getByPublish(((Long)arguments[0]).longValue());
		}

		if (_methodName598.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes598, parameterTypes)) {
			return BridgePublishLocalServiceUtil.getByPublishIdAndStdId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName599.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes599, parameterTypes)) {
			return BridgePublishLocalServiceUtil.getByPublishIdAndRegionId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName600.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes600, parameterTypes)) {
			return BridgePublishLocalServiceUtil.getByPublishIdRegionIdAndStdId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue());
		}

		if (_methodName601.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes601, parameterTypes)) {
			return BridgePublishLocalServiceUtil.getStandardIds(((Long)arguments[0]).longValue());
		}

		if (_methodName602.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes602, parameterTypes)) {
			return BridgePublishLocalServiceUtil.getBridgeProgress(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.util.Date)arguments[2],
				((Long)arguments[3]).longValue(),
				((Boolean)arguments[4]).booleanValue(),
				(java.lang.String)arguments[5]);
		}

		if (_methodName603.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes603, parameterTypes)) {
			return BridgePublishLocalServiceUtil.getOverallProgress(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Boolean)arguments[2]).booleanValue());
		}

		if (_methodName604.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes604, parameterTypes)) {
			return BridgePublishLocalServiceUtil.getTranslationProgress(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Boolean)arguments[2]).booleanValue());
		}

		if (_methodName605.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes605, parameterTypes)) {
			return BridgePublishLocalServiceUtil.getIndexTranslationProgress(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				((Boolean)arguments[3]).booleanValue());
		}

		if (_methodName606.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes606, parameterTypes)) {
			return BridgePublishLocalServiceUtil.getProgressViewDetailsStandards(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2], (java.util.Date)arguments[3],
				(java.lang.String)arguments[4], (java.lang.String)arguments[5]);
		}

		if (_methodName607.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes607, parameterTypes)) {
			return BridgePublishLocalServiceUtil.getUnpublishedDetailsStandards(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3],
				(java.lang.String)arguments[4]);
		}

		if (_methodName608.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes608, parameterTypes)) {
			return BridgePublishLocalServiceUtil.getTranslationViewDetailsStandards(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(), (java.lang.String)arguments[2]);
		}

		if (_methodName609.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes609, parameterTypes)) {
			return BridgePublishLocalServiceUtil.getPublishQueueRecords((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName610.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes610, parameterTypes)) {
			BridgePublishLocalServiceUtil.resetBridgePublication(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3]);

			return null;
		}

		if (_methodName611.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes611, parameterTypes)) {
			BridgePublishLocalServiceUtil.updateUnpublishedToPublishedRecords(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				((Long)arguments[2]).longValue(),
				(java.lang.String)arguments[3], (java.lang.String)arguments[4]);

			return null;
		}

		if (_methodName612.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes612, parameterTypes)) {
			BridgePublishLocalServiceUtil.createDraftPublication(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);

			return null;
		}

		if (_methodName613.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes613, parameterTypes)) {
			return BridgePublishLocalServiceUtil.getMyPublicationByBrand((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName614.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes614, parameterTypes)) {
			return BridgePublishLocalServiceUtil.getStandardCountForPublication(((Long)arguments[0]).longValue());
		}

		if (_methodName615.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes615, parameterTypes)) {
			return BridgePublishLocalServiceUtil.createOraSequence();
		}

		if (_methodName616.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes616, parameterTypes)) {
			return BridgePublishLocalServiceUtil.updateBridgePublishAndCountryFromImport(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2],
				((Long)arguments[3]).longValue(), (java.lang.String)arguments[4]);
		}

		if (_methodName617.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes617, parameterTypes)) {
			return BridgePublishLocalServiceUtil.getBridgePublishStandardsByParent((java.lang.String)arguments[0]);
		}

		if (_methodName618.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes618, parameterTypes)) {
			return BridgePublishLocalServiceUtil.getBridgePublishStandardsById((java.lang.String)arguments[0]);
		}

		if (_methodName619.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes619, parameterTypes)) {
			return BridgePublishLocalServiceUtil.getStandardDetails((java.lang.String)arguments[0]);
		}

		if (_methodName620.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes620, parameterTypes)) {
			return BridgePublishLocalServiceUtil.getPublishedStandardsCompliance((java.util.List<java.lang.Long>)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				(java.lang.String)arguments[5]);
		}

		if (_methodName621.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes621, parameterTypes)) {
			return BridgePublishLocalServiceUtil.getPublishedStandardComplianceDetails(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName622.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes622, parameterTypes)) {
			return BridgePublishLocalServiceUtil.getBridgeStandardsCompliance((java.util.List<java.lang.Long>)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3], (java.lang.String)arguments[4],
				(java.lang.String)arguments[5]);
		}

		if (_methodName623.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes623, parameterTypes)) {
			return BridgePublishLocalServiceUtil.getBridgeStandardComplianceDetails(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName624.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes624, parameterTypes)) {
			BridgePublishLocalServiceUtil.createManuals(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2], (java.lang.String)arguments[3]);

			return null;
		}

		if (_methodName625.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes625, parameterTypes)) {
			return BridgePublishLocalServiceUtil.getMissingReferences(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName626.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes626, parameterTypes)) {
			BridgePublishLocalServiceUtil.addStdToBridgeForAddById(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				(java.lang.String)arguments[2],
				((Long)arguments[3]).longValue(),
				(java.util.List<java.lang.Long>)arguments[4],
				(java.lang.String)arguments[5]);

			return null;
		}

		if (_methodName627.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes627, parameterTypes)) {
			return BridgePublishLocalServiceUtil.getBridgePublishIdsByStdId(((Long)arguments[0]).longValue());
		}

		if (_methodName628.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes628, parameterTypes)) {
			return BridgePublishLocalServiceUtil.getRegionsByPublishIdAndStdId(((Long)arguments[0]).longValue(),
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
	private String _methodName620;
	private String[] _methodParameterTypes620;
	private String _methodName621;
	private String[] _methodParameterTypes621;
	private String _methodName622;
	private String[] _methodParameterTypes622;
	private String _methodName623;
	private String[] _methodParameterTypes623;
	private String _methodName624;
	private String[] _methodParameterTypes624;
	private String _methodName625;
	private String[] _methodParameterTypes625;
	private String _methodName626;
	private String[] _methodParameterTypes626;
	private String _methodName627;
	private String[] _methodParameterTypes627;
	private String _methodName628;
	private String[] _methodParameterTypes628;
}