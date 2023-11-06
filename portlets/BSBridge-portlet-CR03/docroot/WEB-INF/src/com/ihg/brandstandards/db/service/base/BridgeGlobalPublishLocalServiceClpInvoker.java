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

import com.ihg.brandstandards.db.service.BridgeGlobalPublishLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Mummanedi
 * @generated
 */
public class BridgeGlobalPublishLocalServiceClpInvoker {
	public BridgeGlobalPublishLocalServiceClpInvoker() {
		_methodName0 = "addBridgeGlobalPublish";

		_methodParameterTypes0 = new String[] {
				"com.ihg.brandstandards.db.model.BridgeGlobalPublish"
			};

		_methodName1 = "createBridgeGlobalPublish";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteBridgeGlobalPublish";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteBridgeGlobalPublish";

		_methodParameterTypes3 = new String[] {
				"com.ihg.brandstandards.db.model.BridgeGlobalPublish"
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

		_methodName10 = "fetchBridgeGlobalPublish";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getBridgeGlobalPublish";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getBridgeGlobalPublishs";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getBridgeGlobalPublishsCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateBridgeGlobalPublish";

		_methodParameterTypes15 = new String[] {
				"com.ihg.brandstandards.db.model.BridgeGlobalPublish"
			};

		_methodName590 = "getBeanIdentifier";

		_methodParameterTypes590 = new String[] {  };

		_methodName591 = "setBeanIdentifier";

		_methodParameterTypes591 = new String[] { "java.lang.String" };

		_methodName596 = "clearCache";

		_methodParameterTypes596 = new String[] {  };

		_methodName597 = "getMustPublishStandardsByIdsAndBrand";

		_methodParameterTypes597 = new String[] {
				"java.lang.String", "java.lang.String", "boolean"
			};

		_methodName598 = "getTotalIssuesforMustpublish";

		_methodParameterTypes598 = new String[] {
				"java.lang.String", "long", "java.lang.String"
			};

		_methodName599 = "getByPublishIdAndStdId";

		_methodParameterTypes599 = new String[] { "long", "long" };

		_methodName600 = "getByStdIdAndMustPublishInd";

		_methodParameterTypes600 = new String[] {
				"long", "long", "java.lang.String"
			};

		_methodName601 = "getGlobalStandardsByPublishIdAndIndicator";

		_methodParameterTypes601 = new String[] { "java.lang.String", "long" };

		_methodName602 = "getNewBridgeGlobalPublish";

		_methodParameterTypes602 = new String[] {  };

		_methodName603 = "getNewBridgeGlobalPublishCountry";

		_methodParameterTypes603 = new String[] {  };

		_methodName604 = "getBridgeGlobalPublishCountryByGlobalPublishIdAndRegionId";

		_methodParameterTypes604 = new String[] { "long", "long" };

		_methodName605 = "importGlobalMustPublishStandards";

		_methodParameterTypes605 = new String[] {
				"long", "java.lang.String", "java.lang.String",
				"java.lang.String"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return BridgeGlobalPublishLocalServiceUtil.addBridgeGlobalPublish((com.ihg.brandstandards.db.model.BridgeGlobalPublish)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return BridgeGlobalPublishLocalServiceUtil.createBridgeGlobalPublish(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return BridgeGlobalPublishLocalServiceUtil.deleteBridgeGlobalPublish(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return BridgeGlobalPublishLocalServiceUtil.deleteBridgeGlobalPublish((com.ihg.brandstandards.db.model.BridgeGlobalPublish)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return BridgeGlobalPublishLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return BridgeGlobalPublishLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return BridgeGlobalPublishLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return BridgeGlobalPublishLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return BridgeGlobalPublishLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return BridgeGlobalPublishLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return BridgeGlobalPublishLocalServiceUtil.fetchBridgeGlobalPublish(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return BridgeGlobalPublishLocalServiceUtil.getBridgeGlobalPublish(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return BridgeGlobalPublishLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return BridgeGlobalPublishLocalServiceUtil.getBridgeGlobalPublishs(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return BridgeGlobalPublishLocalServiceUtil.getBridgeGlobalPublishsCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return BridgeGlobalPublishLocalServiceUtil.updateBridgeGlobalPublish((com.ihg.brandstandards.db.model.BridgeGlobalPublish)arguments[0]);
		}

		if (_methodName590.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes590, parameterTypes)) {
			return BridgeGlobalPublishLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName591.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes591, parameterTypes)) {
			BridgeGlobalPublishLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName596.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes596, parameterTypes)) {
			BridgeGlobalPublishLocalServiceUtil.clearCache();

			return null;
		}

		if (_methodName597.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes597, parameterTypes)) {
			return BridgeGlobalPublishLocalServiceUtil.getMustPublishStandardsByIdsAndBrand((java.lang.String)arguments[0],
				(java.lang.String)arguments[1],
				((Boolean)arguments[2]).booleanValue());
		}

		if (_methodName598.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes598, parameterTypes)) {
			return BridgeGlobalPublishLocalServiceUtil.getTotalIssuesforMustpublish((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue(), (java.lang.String)arguments[2]);
		}

		if (_methodName599.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes599, parameterTypes)) {
			return BridgeGlobalPublishLocalServiceUtil.getByPublishIdAndStdId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName600.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes600, parameterTypes)) {
			return BridgeGlobalPublishLocalServiceUtil.getByStdIdAndMustPublishInd(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(), (java.lang.String)arguments[2]);
		}

		if (_methodName601.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes601, parameterTypes)) {
			return BridgeGlobalPublishLocalServiceUtil.getGlobalStandardsByPublishIdAndIndicator((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName602.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes602, parameterTypes)) {
			return BridgeGlobalPublishLocalServiceUtil.getNewBridgeGlobalPublish();
		}

		if (_methodName603.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes603, parameterTypes)) {
			return BridgeGlobalPublishLocalServiceUtil.getNewBridgeGlobalPublishCountry();
		}

		if (_methodName604.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes604, parameterTypes)) {
			return BridgeGlobalPublishLocalServiceUtil.getBridgeGlobalPublishCountryByGlobalPublishIdAndRegionId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName605.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes605, parameterTypes)) {
			BridgeGlobalPublishLocalServiceUtil.importGlobalMustPublishStandards(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3]);

			return null;
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
}