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

package com.ihg.brandstandards.db.service.persistence;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

/**
 * @author Mummanedi
 * @generated
 */
public class UIElementTranslatePK implements Comparable<UIElementTranslatePK>,
	Serializable {
	public long elementId;
	public String localeCode;

	public UIElementTranslatePK() {
	}

	public UIElementTranslatePK(long elementId, String localeCode) {
		this.elementId = elementId;
		this.localeCode = localeCode;
	}

	public long getElementId() {
		return elementId;
	}

	public void setElementId(long elementId) {
		this.elementId = elementId;
	}

	public String getLocaleCode() {
		return localeCode;
	}

	public void setLocaleCode(String localeCode) {
		this.localeCode = localeCode;
	}

	@Override
	public int compareTo(UIElementTranslatePK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (elementId < pk.elementId) {
			value = -1;
		}
		else if (elementId > pk.elementId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = localeCode.compareTo(pk.localeCode);

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UIElementTranslatePK)) {
			return false;
		}

		UIElementTranslatePK pk = (UIElementTranslatePK)obj;

		if ((elementId == pk.elementId) && (localeCode.equals(pk.localeCode))) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(elementId) + String.valueOf(localeCode)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("elementId");
		sb.append(StringPool.EQUAL);
		sb.append(elementId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("localeCode");
		sb.append(StringPool.EQUAL);
		sb.append(localeCode);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}