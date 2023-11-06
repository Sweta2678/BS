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

import com.ihg.brandstandards.db.service.ExternalLinkStandardsLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Mummanedi
 * @generated
 */
public class ExternalLinkStandardsLocalServiceClpInvoker {
	public ExternalLinkStandardsLocalServiceClpInvoker() {
		_methodName0 = "addExternalLinkStandards";

		_methodParameterTypes0 = new String[] {
				"com.ihg.brandstandards.db.model.ExternalLinkStandards"
			};

		_methodName1 = "createExternalLinkStandards";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteExternalLinkStandards";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteExternalLinkStandards";

		_methodParameterTypes3 = new String[] {
				"com.ihg.brandstandards.db.model.ExternalLinkStandards"
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

		_methodName10 = "fetchExternalLinkStandards";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getExternalLinkStandards";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getExternalLinkStandardses";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getExternalLinkStandardsesCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateExternalLinkStandards";

		_methodParameterTypes15 = new String[] {
				"com.ihg.brandstandards.db.model.ExternalLinkStandards"
			};

		_methodName580 = "getBeanIdentifier";

		_methodParameterTypes580 = new String[] {  };

		_methodName581 = "setBeanIdentifier";

		_methodParameterTypes581 = new String[] { "java.lang.String" };

		_methodName586 = "clearCache";

		_methodParameterTypes586 = new String[] {  };

		_methodName587 = "getExternalLinkStandardsByStandardId";

		_methodParameterTypes587 = new String[] { "long" };

		_methodName588 = "getExternalLinkStandardsByParentId";

		_methodParameterTypes588 = new String[] { "long" };

		_methodName589 = "getExternalLinksStandardsByParentIdStdIdLangId";

		_methodParameterTypes589 = new String[] {
				"long", "long", "java.lang.String"
			};

		_methodName590 = "getExternalLinkStandardsByLocaleCdStdId";

		_methodParameterTypes590 = new String[] { "java.lang.String", "long" };

		_methodName591 = "getExternalLinkStandardsByParentIdStdId";

		_methodParameterTypes591 = new String[] { "long", "long" };

		_methodName592 = "getExternalLinksStandardsParentsByStdId";

		_methodParameterTypes592 = new String[] { "long" };

		_methodName593 = "getExternalLinksStandardsParentsByStdIdLocaleCd";

		_methodParameterTypes593 = new String[] { "long", "java.lang.String" };

		_methodName594 = "deleteExternalLinkStandards";

		_methodParameterTypes594 = new String[] { "long" };

		_methodName595 = "getExtLinkStandardsByStdIdAndRgnIdAndLocale";

		_methodParameterTypes595 = new String[] {
				"long", "java.lang.String", "java.util.List"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return ExternalLinkStandardsLocalServiceUtil.addExternalLinkStandards((com.ihg.brandstandards.db.model.ExternalLinkStandards)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return ExternalLinkStandardsLocalServiceUtil.createExternalLinkStandards(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return ExternalLinkStandardsLocalServiceUtil.deleteExternalLinkStandards(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return ExternalLinkStandardsLocalServiceUtil.deleteExternalLinkStandards((com.ihg.brandstandards.db.model.ExternalLinkStandards)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return ExternalLinkStandardsLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return ExternalLinkStandardsLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return ExternalLinkStandardsLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return ExternalLinkStandardsLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return ExternalLinkStandardsLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return ExternalLinkStandardsLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return ExternalLinkStandardsLocalServiceUtil.fetchExternalLinkStandards(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return ExternalLinkStandardsLocalServiceUtil.getExternalLinkStandards(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return ExternalLinkStandardsLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return ExternalLinkStandardsLocalServiceUtil.getExternalLinkStandardses(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return ExternalLinkStandardsLocalServiceUtil.getExternalLinkStandardsesCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return ExternalLinkStandardsLocalServiceUtil.updateExternalLinkStandards((com.ihg.brandstandards.db.model.ExternalLinkStandards)arguments[0]);
		}

		if (_methodName580.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes580, parameterTypes)) {
			return ExternalLinkStandardsLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName581.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes581, parameterTypes)) {
			ExternalLinkStandardsLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName586.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes586, parameterTypes)) {
			ExternalLinkStandardsLocalServiceUtil.clearCache();

			return null;
		}

		if (_methodName587.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes587, parameterTypes)) {
			return ExternalLinkStandardsLocalServiceUtil.getExternalLinkStandardsByStandardId(((Long)arguments[0]).longValue());
		}

		if (_methodName588.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes588, parameterTypes)) {
			return ExternalLinkStandardsLocalServiceUtil.getExternalLinkStandardsByParentId(((Long)arguments[0]).longValue());
		}

		if (_methodName589.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes589, parameterTypes)) {
			return ExternalLinkStandardsLocalServiceUtil.getExternalLinksStandardsByParentIdStdIdLangId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(), (java.lang.String)arguments[2]);
		}

		if (_methodName590.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes590, parameterTypes)) {
			return ExternalLinkStandardsLocalServiceUtil.getExternalLinkStandardsByLocaleCdStdId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName591.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes591, parameterTypes)) {
			return ExternalLinkStandardsLocalServiceUtil.getExternalLinkStandardsByParentIdStdId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName592.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes592, parameterTypes)) {
			return ExternalLinkStandardsLocalServiceUtil.getExternalLinksStandardsParentsByStdId(((Long)arguments[0]).longValue());
		}

		if (_methodName593.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes593, parameterTypes)) {
			return ExternalLinkStandardsLocalServiceUtil.getExternalLinksStandardsParentsByStdIdLocaleCd(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);
		}

		if (_methodName594.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes594, parameterTypes)) {
			return ExternalLinkStandardsLocalServiceUtil.deleteExternalLinkStandards(((Long)arguments[0]).longValue());
		}

		if (_methodName595.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes595, parameterTypes)) {
			return ExternalLinkStandardsLocalServiceUtil.getExtLinkStandardsByStdIdAndRgnIdAndLocale(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1],
				(java.util.List<java.lang.String>)arguments[2]);
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
}