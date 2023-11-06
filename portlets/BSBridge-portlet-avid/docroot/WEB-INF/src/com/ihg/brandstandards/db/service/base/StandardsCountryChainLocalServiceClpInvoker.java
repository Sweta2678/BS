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

import com.ihg.brandstandards.db.service.StandardsCountryChainLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Mummanedi
 * @generated
 */
public class StandardsCountryChainLocalServiceClpInvoker {
	public StandardsCountryChainLocalServiceClpInvoker() {
		_methodName0 = "addStandardsCountryChain";

		_methodParameterTypes0 = new String[] {
				"com.ihg.brandstandards.db.model.StandardsCountryChain"
			};

		_methodName1 = "createStandardsCountryChain";

		_methodParameterTypes1 = new String[] {
				"com.ihg.brandstandards.db.service.persistence.StandardsCountryChainPK"
			};

		_methodName2 = "deleteStandardsCountryChain";

		_methodParameterTypes2 = new String[] {
				"com.ihg.brandstandards.db.service.persistence.StandardsCountryChainPK"
			};

		_methodName3 = "deleteStandardsCountryChain";

		_methodParameterTypes3 = new String[] {
				"com.ihg.brandstandards.db.model.StandardsCountryChain"
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

		_methodName10 = "fetchStandardsCountryChain";

		_methodParameterTypes10 = new String[] {
				"com.ihg.brandstandards.db.service.persistence.StandardsCountryChainPK"
			};

		_methodName11 = "getStandardsCountryChain";

		_methodParameterTypes11 = new String[] {
				"com.ihg.brandstandards.db.service.persistence.StandardsCountryChainPK"
			};

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getStandardsCountryChains";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getStandardsCountryChainsCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateStandardsCountryChain";

		_methodParameterTypes15 = new String[] {
				"com.ihg.brandstandards.db.model.StandardsCountryChain"
			};

		_methodName590 = "getBeanIdentifier";

		_methodParameterTypes590 = new String[] {  };

		_methodName591 = "setBeanIdentifier";

		_methodParameterTypes591 = new String[] { "java.lang.String" };

		_methodName596 = "clearCache";

		_methodParameterTypes596 = new String[] {  };

		_methodName597 = "getStandardsCountryChain";

		_methodParameterTypes597 = new String[] {
				"long", "java.lang.String", "java.util.Date"
			};

		_methodName598 = "getStandardsCountryChains";

		_methodParameterTypes598 = new String[] {
				"long", "java.lang.String", "java.util.Date"
			};

		_methodName599 = "getStandardsChainRegion";

		_methodParameterTypes599 = new String[] {
				"long", "java.lang.String", "java.lang.String"
			};

		_methodName600 = "getStandardsChain";

		_methodParameterTypes600 = new String[] { "long", "java.lang.String" };

		_methodName601 = "updateComplianceDeadline";

		_methodParameterTypes601 = new String[] {
				"java.lang.Long", "java.util.Map", "java.lang.String",
				"java.lang.String"
			};

		_methodName602 = "getDefaultComplianceDate";

		_methodParameterTypes602 = new String[] {
				"long", "java.lang.String", "java.lang.String"
			};

		_methodName603 = "getDefaulExpiryDate";

		_methodParameterTypes603 = new String[] {
				"long", "java.lang.String", "java.lang.String"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return StandardsCountryChainLocalServiceUtil.addStandardsCountryChain((com.ihg.brandstandards.db.model.StandardsCountryChain)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return StandardsCountryChainLocalServiceUtil.createStandardsCountryChain((com.ihg.brandstandards.db.service.persistence.StandardsCountryChainPK)arguments[0]);
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return StandardsCountryChainLocalServiceUtil.deleteStandardsCountryChain((com.ihg.brandstandards.db.service.persistence.StandardsCountryChainPK)arguments[0]);
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return StandardsCountryChainLocalServiceUtil.deleteStandardsCountryChain((com.ihg.brandstandards.db.model.StandardsCountryChain)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return StandardsCountryChainLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return StandardsCountryChainLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return StandardsCountryChainLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return StandardsCountryChainLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return StandardsCountryChainLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return StandardsCountryChainLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return StandardsCountryChainLocalServiceUtil.fetchStandardsCountryChain((com.ihg.brandstandards.db.service.persistence.StandardsCountryChainPK)arguments[0]);
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return StandardsCountryChainLocalServiceUtil.getStandardsCountryChain((com.ihg.brandstandards.db.service.persistence.StandardsCountryChainPK)arguments[0]);
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return StandardsCountryChainLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return StandardsCountryChainLocalServiceUtil.getStandardsCountryChains(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return StandardsCountryChainLocalServiceUtil.getStandardsCountryChainsCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return StandardsCountryChainLocalServiceUtil.updateStandardsCountryChain((com.ihg.brandstandards.db.model.StandardsCountryChain)arguments[0]);
		}

		if (_methodName590.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes590, parameterTypes)) {
			return StandardsCountryChainLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName591.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes591, parameterTypes)) {
			StandardsCountryChainLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName596.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes596, parameterTypes)) {
			StandardsCountryChainLocalServiceUtil.clearCache();

			return null;
		}

		if (_methodName597.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes597, parameterTypes)) {
			return StandardsCountryChainLocalServiceUtil.getStandardsCountryChain(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.util.Date)arguments[2]);
		}

		if (_methodName598.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes598, parameterTypes)) {
			return StandardsCountryChainLocalServiceUtil.getStandardsCountryChains(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.util.Date)arguments[2]);
		}

		if (_methodName599.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes599, parameterTypes)) {
			return StandardsCountryChainLocalServiceUtil.getStandardsChainRegion(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName600.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes600, parameterTypes)) {
			return StandardsCountryChainLocalServiceUtil.getStandardsChain(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName601.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes601, parameterTypes)) {
			return StandardsCountryChainLocalServiceUtil.updateComplianceDeadline((java.lang.Long)arguments[0],
				(java.util.Map<java.lang.String, java.util.Date>)arguments[1],
				(java.lang.String)arguments[2], (java.lang.String)arguments[3]);
		}

		if (_methodName602.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes602, parameterTypes)) {
			return StandardsCountryChainLocalServiceUtil.getDefaultComplianceDate(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName603.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes603, parameterTypes)) {
			return StandardsCountryChainLocalServiceUtil.getDefaulExpiryDate(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
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
}