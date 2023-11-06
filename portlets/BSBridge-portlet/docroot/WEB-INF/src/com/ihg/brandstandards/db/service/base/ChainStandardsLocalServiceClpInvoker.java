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

import com.ihg.brandstandards.db.service.ChainStandardsLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Mummanedi
 * @generated
 */
public class ChainStandardsLocalServiceClpInvoker {
	public ChainStandardsLocalServiceClpInvoker() {
		_methodName0 = "addChainStandards";

		_methodParameterTypes0 = new String[] {
				"com.ihg.brandstandards.db.model.ChainStandards"
			};

		_methodName1 = "createChainStandards";

		_methodParameterTypes1 = new String[] {
				"com.ihg.brandstandards.db.service.persistence.ChainStandardsPK"
			};

		_methodName2 = "deleteChainStandards";

		_methodParameterTypes2 = new String[] {
				"com.ihg.brandstandards.db.service.persistence.ChainStandardsPK"
			};

		_methodName3 = "deleteChainStandards";

		_methodParameterTypes3 = new String[] {
				"com.ihg.brandstandards.db.model.ChainStandards"
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

		_methodName10 = "fetchChainStandards";

		_methodParameterTypes10 = new String[] {
				"com.ihg.brandstandards.db.service.persistence.ChainStandardsPK"
			};

		_methodName11 = "getChainStandards";

		_methodParameterTypes11 = new String[] {
				"com.ihg.brandstandards.db.service.persistence.ChainStandardsPK"
			};

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getChainStandardses";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getChainStandardsesCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateChainStandards";

		_methodParameterTypes15 = new String[] {
				"com.ihg.brandstandards.db.model.ChainStandards"
			};

		_methodName608 = "getBeanIdentifier";

		_methodParameterTypes608 = new String[] {  };

		_methodName609 = "setBeanIdentifier";

		_methodParameterTypes609 = new String[] { "java.lang.String" };

		_methodName614 = "getChainStandardsObject";

		_methodParameterTypes614 = new String[] {  };

		_methodName615 = "clearCache";

		_methodParameterTypes615 = new String[] {  };

		_methodName616 = "getChainStandardsByStdId";

		_methodParameterTypes616 = new String[] { "long" };

		_methodName617 = "getChainStandardsByChainCode";

		_methodParameterTypes617 = new String[] { "long", "java.lang.String" };

		_methodName618 = "getChainStandardsByChainCodeAll";

		_methodParameterTypes618 = new String[] { "long", "java.lang.String" };

		_methodName619 = "getChainStandardsByStdIdAll";

		_methodParameterTypes619 = new String[] { "long" };

		_methodName620 = "deleteChainStandards";

		_methodParameterTypes620 = new String[] {
				"com.ihg.brandstandards.db.model.ChainStandards"
			};

		_methodName621 = "getStandardsByChain";

		_methodParameterTypes621 = new String[] { "java.lang.String" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return ChainStandardsLocalServiceUtil.addChainStandards((com.ihg.brandstandards.db.model.ChainStandards)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return ChainStandardsLocalServiceUtil.createChainStandards((com.ihg.brandstandards.db.service.persistence.ChainStandardsPK)arguments[0]);
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return ChainStandardsLocalServiceUtil.deleteChainStandards((com.ihg.brandstandards.db.service.persistence.ChainStandardsPK)arguments[0]);
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return ChainStandardsLocalServiceUtil.deleteChainStandards((com.ihg.brandstandards.db.model.ChainStandards)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return ChainStandardsLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return ChainStandardsLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return ChainStandardsLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return ChainStandardsLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return ChainStandardsLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return ChainStandardsLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return ChainStandardsLocalServiceUtil.fetchChainStandards((com.ihg.brandstandards.db.service.persistence.ChainStandardsPK)arguments[0]);
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return ChainStandardsLocalServiceUtil.getChainStandards((com.ihg.brandstandards.db.service.persistence.ChainStandardsPK)arguments[0]);
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return ChainStandardsLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return ChainStandardsLocalServiceUtil.getChainStandardses(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return ChainStandardsLocalServiceUtil.getChainStandardsesCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return ChainStandardsLocalServiceUtil.updateChainStandards((com.ihg.brandstandards.db.model.ChainStandards)arguments[0]);
		}

		if (_methodName608.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes608, parameterTypes)) {
			return ChainStandardsLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName609.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes609, parameterTypes)) {
			ChainStandardsLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName614.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes614, parameterTypes)) {
			return ChainStandardsLocalServiceUtil.getChainStandardsObject();
		}

		if (_methodName615.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes615, parameterTypes)) {
			ChainStandardsLocalServiceUtil.clearCache();

			return null;
		}

		if (_methodName616.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes616, parameterTypes)) {
			return ChainStandardsLocalServiceUtil.getChainStandardsByStdId(((Long)arguments[0]).longValue());
		}

		if (_methodName617.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes617, parameterTypes)) {
			return ChainStandardsLocalServiceUtil.getChainStandardsByChainCode(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName618.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes618, parameterTypes)) {
			return ChainStandardsLocalServiceUtil.getChainStandardsByChainCodeAll(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName619.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes619, parameterTypes)) {
			return ChainStandardsLocalServiceUtil.getChainStandardsByStdIdAll(((Long)arguments[0]).longValue());
		}

		if (_methodName620.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes620, parameterTypes)) {
			return ChainStandardsLocalServiceUtil.deleteChainStandards((com.ihg.brandstandards.db.model.ChainStandards)arguments[0]);
		}

		if (_methodName621.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes621, parameterTypes)) {
			return ChainStandardsLocalServiceUtil.getStandardsByChain((java.lang.String)arguments[0]);
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
	private String _methodName608;
	private String[] _methodParameterTypes608;
	private String _methodName609;
	private String[] _methodParameterTypes609;
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
}