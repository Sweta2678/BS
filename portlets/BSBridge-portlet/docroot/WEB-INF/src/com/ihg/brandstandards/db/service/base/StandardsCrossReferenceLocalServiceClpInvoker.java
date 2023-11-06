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

import com.ihg.brandstandards.db.service.StandardsCrossReferenceLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Mummanedi
 * @generated
 */
public class StandardsCrossReferenceLocalServiceClpInvoker {
	public StandardsCrossReferenceLocalServiceClpInvoker() {
		_methodName0 = "addStandardsCrossReference";

		_methodParameterTypes0 = new String[] {
				"com.ihg.brandstandards.db.model.StandardsCrossReference"
			};

		_methodName1 = "createStandardsCrossReference";

		_methodParameterTypes1 = new String[] {
				"com.ihg.brandstandards.db.service.persistence.StandardsCrossReferencePK"
			};

		_methodName2 = "deleteStandardsCrossReference";

		_methodParameterTypes2 = new String[] {
				"com.ihg.brandstandards.db.service.persistence.StandardsCrossReferencePK"
			};

		_methodName3 = "deleteStandardsCrossReference";

		_methodParameterTypes3 = new String[] {
				"com.ihg.brandstandards.db.model.StandardsCrossReference"
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

		_methodName10 = "fetchStandardsCrossReference";

		_methodParameterTypes10 = new String[] {
				"com.ihg.brandstandards.db.service.persistence.StandardsCrossReferencePK"
			};

		_methodName11 = "getStandardsCrossReference";

		_methodParameterTypes11 = new String[] {
				"com.ihg.brandstandards.db.service.persistence.StandardsCrossReferencePK"
			};

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getStandardsCrossReferences";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getStandardsCrossReferencesCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateStandardsCrossReference";

		_methodParameterTypes15 = new String[] {
				"com.ihg.brandstandards.db.model.StandardsCrossReference"
			};

		_methodName608 = "getBeanIdentifier";

		_methodParameterTypes608 = new String[] {  };

		_methodName609 = "setBeanIdentifier";

		_methodParameterTypes609 = new String[] { "java.lang.String" };

		_methodName614 = "clearCache";

		_methodParameterTypes614 = new String[] {  };

		_methodName615 = "getXStandardsOthers";

		_methodParameterTypes615 = new String[] { "long" };

		_methodName616 = "addCrossReferences";

		_methodParameterTypes616 = new String[] {
				"long", "java.util.Date", "long", "java.lang.String"
			};

		_methodName617 = "deleteCrossReferences";

		_methodParameterTypes617 = new String[] { "long", "java.lang.String" };

		_methodName618 = "updateStdOrder";

		_methodParameterTypes618 = new String[] { "long", "java.lang.String" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return StandardsCrossReferenceLocalServiceUtil.addStandardsCrossReference((com.ihg.brandstandards.db.model.StandardsCrossReference)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return StandardsCrossReferenceLocalServiceUtil.createStandardsCrossReference((com.ihg.brandstandards.db.service.persistence.StandardsCrossReferencePK)arguments[0]);
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return StandardsCrossReferenceLocalServiceUtil.deleteStandardsCrossReference((com.ihg.brandstandards.db.service.persistence.StandardsCrossReferencePK)arguments[0]);
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return StandardsCrossReferenceLocalServiceUtil.deleteStandardsCrossReference((com.ihg.brandstandards.db.model.StandardsCrossReference)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return StandardsCrossReferenceLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return StandardsCrossReferenceLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return StandardsCrossReferenceLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return StandardsCrossReferenceLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return StandardsCrossReferenceLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return StandardsCrossReferenceLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return StandardsCrossReferenceLocalServiceUtil.fetchStandardsCrossReference((com.ihg.brandstandards.db.service.persistence.StandardsCrossReferencePK)arguments[0]);
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return StandardsCrossReferenceLocalServiceUtil.getStandardsCrossReference((com.ihg.brandstandards.db.service.persistence.StandardsCrossReferencePK)arguments[0]);
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return StandardsCrossReferenceLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return StandardsCrossReferenceLocalServiceUtil.getStandardsCrossReferences(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return StandardsCrossReferenceLocalServiceUtil.getStandardsCrossReferencesCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return StandardsCrossReferenceLocalServiceUtil.updateStandardsCrossReference((com.ihg.brandstandards.db.model.StandardsCrossReference)arguments[0]);
		}

		if (_methodName608.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes608, parameterTypes)) {
			return StandardsCrossReferenceLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName609.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes609, parameterTypes)) {
			StandardsCrossReferenceLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName614.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes614, parameterTypes)) {
			StandardsCrossReferenceLocalServiceUtil.clearCache();

			return null;
		}

		if (_methodName615.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes615, parameterTypes)) {
			return StandardsCrossReferenceLocalServiceUtil.getXStandardsOthers(((Long)arguments[0]).longValue());
		}

		if (_methodName616.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes616, parameterTypes)) {
			StandardsCrossReferenceLocalServiceUtil.addCrossReferences(((Long)arguments[0]).longValue(),
				(java.util.Date)arguments[1], ((Long)arguments[2]).longValue(),
				(java.lang.String)arguments[3]);

			return null;
		}

		if (_methodName617.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes617, parameterTypes)) {
			StandardsCrossReferenceLocalServiceUtil.deleteCrossReferences(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);

			return null;
		}

		if (_methodName618.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes618, parameterTypes)) {
			StandardsCrossReferenceLocalServiceUtil.updateStdOrder(((Long)arguments[0]).longValue(),
				(java.lang.String)arguments[1]);

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
}