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

import com.ihg.brandstandards.db.service.AttachmentsStandardsLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Mummanedi
 * @generated
 */
public class AttachmentsStandardsLocalServiceClpInvoker {
	public AttachmentsStandardsLocalServiceClpInvoker() {
		_methodName0 = "addAttachmentsStandards";

		_methodParameterTypes0 = new String[] {
				"com.ihg.brandstandards.db.model.AttachmentsStandards"
			};

		_methodName1 = "createAttachmentsStandards";

		_methodParameterTypes1 = new String[] {
				"com.ihg.brandstandards.db.service.persistence.AttachmentsStandardsPK"
			};

		_methodName2 = "deleteAttachmentsStandards";

		_methodParameterTypes2 = new String[] {
				"com.ihg.brandstandards.db.service.persistence.AttachmentsStandardsPK"
			};

		_methodName3 = "deleteAttachmentsStandards";

		_methodParameterTypes3 = new String[] {
				"com.ihg.brandstandards.db.model.AttachmentsStandards"
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

		_methodName10 = "fetchAttachmentsStandards";

		_methodParameterTypes10 = new String[] {
				"com.ihg.brandstandards.db.service.persistence.AttachmentsStandardsPK"
			};

		_methodName11 = "getAttachmentsStandards";

		_methodParameterTypes11 = new String[] {
				"com.ihg.brandstandards.db.service.persistence.AttachmentsStandardsPK"
			};

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getAttachmentsStandardses";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getAttachmentsStandardsesCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateAttachmentsStandards";

		_methodParameterTypes15 = new String[] {
				"com.ihg.brandstandards.db.model.AttachmentsStandards"
			};

		_methodName608 = "getBeanIdentifier";

		_methodParameterTypes608 = new String[] {  };

		_methodName609 = "setBeanIdentifier";

		_methodParameterTypes609 = new String[] { "java.lang.String" };

		_methodName614 = "clearCache";

		_methodParameterTypes614 = new String[] {  };

		_methodName615 = "getAttachmentsStandardsByStandardId";

		_methodParameterTypes615 = new String[] { "long" };

		_methodName616 = "getAttachmentsStandardsByParentId";

		_methodParameterTypes616 = new String[] { "long" };

		_methodName617 = "getAttachmentsStandardsByParentIdStdIdLangId";

		_methodParameterTypes617 = new String[] {
				"long", "long", "java.lang.String"
			};

		_methodName618 = "getAttachmentsStandardsByLocaleCdStdId";

		_methodParameterTypes618 = new String[] { "java.lang.String", "long" };

		_methodName619 = "getAttachmentsStandardsByParentIdStdId";

		_methodParameterTypes619 = new String[] { "long", "long" };

		_methodName620 = "getAttachmentsStandardsParentsByStdId";

		_methodParameterTypes620 = new String[] { "long" };

		_methodName621 = "getAttachmentsStandardsByParentIdAttachId";

		_methodParameterTypes621 = new String[] { "long", "long" };

		_methodName622 = "deleteAttachmentsStandards";

		_methodParameterTypes622 = new String[] {
				"com.ihg.brandstandards.db.model.AttachmentsStandards"
			};

		_methodName623 = "getAttchmentByAttachmendId";

		_methodParameterTypes623 = new String[] { "long" };

		_methodName624 = "getStandardAttachmentsByStdIdAndRgnIdAndLocale";

		_methodParameterTypes624 = new String[] {
				"long", "java.lang.String", "java.util.List"
			};
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return AttachmentsStandardsLocalServiceUtil.addAttachmentsStandards((com.ihg.brandstandards.db.model.AttachmentsStandards)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return AttachmentsStandardsLocalServiceUtil.createAttachmentsStandards((com.ihg.brandstandards.db.service.persistence.AttachmentsStandardsPK)arguments[0]);
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return AttachmentsStandardsLocalServiceUtil.deleteAttachmentsStandards((com.ihg.brandstandards.db.service.persistence.AttachmentsStandardsPK)arguments[0]);
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return AttachmentsStandardsLocalServiceUtil.deleteAttachmentsStandards((com.ihg.brandstandards.db.model.AttachmentsStandards)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return AttachmentsStandardsLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return AttachmentsStandardsLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return AttachmentsStandardsLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return AttachmentsStandardsLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return AttachmentsStandardsLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return AttachmentsStandardsLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return AttachmentsStandardsLocalServiceUtil.fetchAttachmentsStandards((com.ihg.brandstandards.db.service.persistence.AttachmentsStandardsPK)arguments[0]);
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return AttachmentsStandardsLocalServiceUtil.getAttachmentsStandards((com.ihg.brandstandards.db.service.persistence.AttachmentsStandardsPK)arguments[0]);
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return AttachmentsStandardsLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return AttachmentsStandardsLocalServiceUtil.getAttachmentsStandardses(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return AttachmentsStandardsLocalServiceUtil.getAttachmentsStandardsesCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return AttachmentsStandardsLocalServiceUtil.updateAttachmentsStandards((com.ihg.brandstandards.db.model.AttachmentsStandards)arguments[0]);
		}

		if (_methodName608.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes608, parameterTypes)) {
			return AttachmentsStandardsLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName609.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes609, parameterTypes)) {
			AttachmentsStandardsLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName614.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes614, parameterTypes)) {
			AttachmentsStandardsLocalServiceUtil.clearCache();

			return null;
		}

		if (_methodName615.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes615, parameterTypes)) {
			return AttachmentsStandardsLocalServiceUtil.getAttachmentsStandardsByStandardId(((Long)arguments[0]).longValue());
		}

		if (_methodName616.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes616, parameterTypes)) {
			return AttachmentsStandardsLocalServiceUtil.getAttachmentsStandardsByParentId(((Long)arguments[0]).longValue());
		}

		if (_methodName617.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes617, parameterTypes)) {
			return AttachmentsStandardsLocalServiceUtil.getAttachmentsStandardsByParentIdStdIdLangId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(), (java.lang.String)arguments[2]);
		}

		if (_methodName618.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes618, parameterTypes)) {
			return AttachmentsStandardsLocalServiceUtil.getAttachmentsStandardsByLocaleCdStdId((java.lang.String)arguments[0],
				((Long)arguments[1]).longValue());
		}

		if (_methodName619.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes619, parameterTypes)) {
			return AttachmentsStandardsLocalServiceUtil.getAttachmentsStandardsByParentIdStdId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName620.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes620, parameterTypes)) {
			return AttachmentsStandardsLocalServiceUtil.getAttachmentsStandardsParentsByStdId(((Long)arguments[0]).longValue());
		}

		if (_methodName621.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes621, parameterTypes)) {
			return AttachmentsStandardsLocalServiceUtil.getAttachmentsStandardsByParentIdAttachId(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue());
		}

		if (_methodName622.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes622, parameterTypes)) {
			return AttachmentsStandardsLocalServiceUtil.deleteAttachmentsStandards((com.ihg.brandstandards.db.model.AttachmentsStandards)arguments[0]);
		}

		if (_methodName623.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes623, parameterTypes)) {
			return AttachmentsStandardsLocalServiceUtil.getAttchmentByAttachmendId(((Long)arguments[0]).longValue());
		}

		if (_methodName624.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes624, parameterTypes)) {
			return AttachmentsStandardsLocalServiceUtil.getStandardAttachmentsByStdIdAndRgnIdAndLocale(((Long)arguments[0]).longValue(),
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
	private String _methodName622;
	private String[] _methodParameterTypes622;
	private String _methodName623;
	private String[] _methodParameterTypes623;
	private String _methodName624;
	private String[] _methodParameterTypes624;
}