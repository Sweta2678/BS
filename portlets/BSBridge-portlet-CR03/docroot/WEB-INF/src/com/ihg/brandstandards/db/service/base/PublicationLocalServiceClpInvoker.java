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

import com.ihg.brandstandards.db.service.PublicationLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Mummanedi
 * @generated
 */
public class PublicationLocalServiceClpInvoker {
	public PublicationLocalServiceClpInvoker() {
		_methodName0 = "addPublication";

		_methodParameterTypes0 = new String[] {
				"com.ihg.brandstandards.db.model.Publication"
			};

		_methodName1 = "createPublication";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deletePublication";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deletePublication";

		_methodParameterTypes3 = new String[] {
				"com.ihg.brandstandards.db.model.Publication"
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

		_methodName10 = "fetchPublication";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getPublication";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getPublications";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getPublicationsCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updatePublication";

		_methodParameterTypes15 = new String[] {
				"com.ihg.brandstandards.db.model.Publication"
			};

		_methodName590 = "getBeanIdentifier";

		_methodParameterTypes590 = new String[] {  };

		_methodName591 = "setBeanIdentifier";

		_methodParameterTypes591 = new String[] { "java.lang.String" };

		_methodName596 = "clearCache";

		_methodParameterTypes596 = new String[] {  };

		_methodName597 = "getPublishByStatEnvChainCode";

		_methodParameterTypes597 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String"
			};

		_methodName598 = "getPublishByEnvChainCode";

		_methodParameterTypes598 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName599 = "isPublishedBrand";

		_methodParameterTypes599 = new String[] { "java.lang.String" };

		_methodName600 = "getPublishObjectByBrand";

		_methodParameterTypes600 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String"
			};

		_methodName601 = "getWhatChangedOnNavigation";

		_methodParameterTypes601 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName602 = "getPublishLanguagesPerBrand";

		_methodParameterTypes602 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName603 = "getPublishIdByBrand";

		_methodParameterTypes603 = new String[] {
				"java.lang.String", "java.lang.String"
			};

		_methodName604 = "getFormatedDate";

		_methodParameterTypes604 = new String[] {
				"java.util.Date", "java.lang.String", "java.util.Map"
			};

		_methodName605 = "getAllPublicationsByBrand";

		_methodParameterTypes605 = new String[] { "java.lang.String" };

		_methodName606 = "createPublication";

		_methodParameterTypes606 = new String[] {  };

		_methodName607 = "fetchUniquePublishedBrandCodes";

		_methodParameterTypes607 = new String[] {  };

		_methodName608 = "getLatestPublication";

		_methodParameterTypes608 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String"
			};

		_methodName609 = "getPublicationByQuery";

		_methodParameterTypes609 = new String[] { "java.lang.String" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return PublicationLocalServiceUtil.addPublication((com.ihg.brandstandards.db.model.Publication)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return PublicationLocalServiceUtil.createPublication(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return PublicationLocalServiceUtil.deletePublication(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return PublicationLocalServiceUtil.deletePublication((com.ihg.brandstandards.db.model.Publication)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return PublicationLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return PublicationLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return PublicationLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return PublicationLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return PublicationLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return PublicationLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return PublicationLocalServiceUtil.fetchPublication(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return PublicationLocalServiceUtil.getPublication(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return PublicationLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return PublicationLocalServiceUtil.getPublications(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return PublicationLocalServiceUtil.getPublicationsCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return PublicationLocalServiceUtil.updatePublication((com.ihg.brandstandards.db.model.Publication)arguments[0]);
		}

		if (_methodName590.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes590, parameterTypes)) {
			return PublicationLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName591.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes591, parameterTypes)) {
			PublicationLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName596.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes596, parameterTypes)) {
			PublicationLocalServiceUtil.clearCache();

			return null;
		}

		if (_methodName597.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes597, parameterTypes)) {
			return PublicationLocalServiceUtil.getPublishByStatEnvChainCode((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName598.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes598, parameterTypes)) {
			return PublicationLocalServiceUtil.getPublishByEnvChainCode((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName599.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes599, parameterTypes)) {
			return PublicationLocalServiceUtil.isPublishedBrand((java.lang.String)arguments[0]);
		}

		if (_methodName600.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes600, parameterTypes)) {
			return PublicationLocalServiceUtil.getPublishObjectByBrand((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName601.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes601, parameterTypes)) {
			return PublicationLocalServiceUtil.getWhatChangedOnNavigation((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName602.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes602, parameterTypes)) {
			return PublicationLocalServiceUtil.getPublishLanguagesPerBrand((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName603.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes603, parameterTypes)) {
			return PublicationLocalServiceUtil.getPublishIdByBrand((java.lang.String)arguments[0],
				(java.lang.String)arguments[1]);
		}

		if (_methodName604.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes604, parameterTypes)) {
			return PublicationLocalServiceUtil.getFormatedDate((java.util.Date)arguments[0],
				(java.lang.String)arguments[1],
				(java.util.Map<java.lang.String, java.lang.String>)arguments[2]);
		}

		if (_methodName605.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes605, parameterTypes)) {
			return PublicationLocalServiceUtil.getAllPublicationsByBrand((java.lang.String)arguments[0]);
		}

		if (_methodName606.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes606, parameterTypes)) {
			return PublicationLocalServiceUtil.createPublication();
		}

		if (_methodName607.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes607, parameterTypes)) {
			return PublicationLocalServiceUtil.fetchUniquePublishedBrandCodes();
		}

		if (_methodName608.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes608, parameterTypes)) {
			return PublicationLocalServiceUtil.getLatestPublication((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2]);
		}

		if (_methodName609.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes609, parameterTypes)) {
			return PublicationLocalServiceUtil.getPublicationByQuery((java.lang.String)arguments[0]);
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
}