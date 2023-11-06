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
		_methodName570 = "getBeanIdentifier";

		_methodParameterTypes570 = new String[] {  };

		_methodName571 = "setBeanIdentifier";

		_methodParameterTypes571 = new String[] { "java.lang.String" };

		_methodName574 = "getJournalArticleResourcPrimKey";

		_methodParameterTypes574 = new String[] { "java.lang.String" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName570.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes570, parameterTypes)) {
			return BrandArticleLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName571.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes571, parameterTypes)) {
			BrandArticleLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName574.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes574, parameterTypes)) {
			return BrandArticleLocalServiceUtil.getJournalArticleResourcPrimKey((java.lang.String)arguments[0]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName570;
	private String[] _methodParameterTypes570;
	private String _methodName571;
	private String[] _methodParameterTypes571;
	private String _methodName574;
	private String[] _methodParameterTypes574;
}