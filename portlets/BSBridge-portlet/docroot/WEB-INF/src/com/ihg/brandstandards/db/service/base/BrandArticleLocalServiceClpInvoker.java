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

import com.ihg.brandstandards.db.service.BrandArticleLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Mummanedi
 * @generated
 */
public class BrandArticleLocalServiceClpInvoker {
	public BrandArticleLocalServiceClpInvoker() {
		_methodName598 = "getBeanIdentifier";

		_methodParameterTypes598 = new String[] {  };

		_methodName599 = "setBeanIdentifier";

		_methodParameterTypes599 = new String[] { "java.lang.String" };

		_methodName602 = "getJournalArticleResourcPrimKey";

		_methodParameterTypes602 = new String[] { "java.lang.String" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName598.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes598, parameterTypes)) {
			return BrandArticleLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName599.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes599, parameterTypes)) {
			BrandArticleLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName602.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes602, parameterTypes)) {
			return BrandArticleLocalServiceUtil.getJournalArticleResourcPrimKey((java.lang.String)arguments[0]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName598;
	private String[] _methodParameterTypes598;
	private String _methodName599;
	private String[] _methodParameterTypes599;
	private String _methodName602;
	private String[] _methodParameterTypes602;
}