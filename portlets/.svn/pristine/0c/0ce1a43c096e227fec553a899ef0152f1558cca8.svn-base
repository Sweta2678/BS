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
public class TaxonomyTranslatePK implements Comparable<TaxonomyTranslatePK>,
	Serializable {
	public long taxId;
	public String localeCode;

	public TaxonomyTranslatePK() {
	}

	public TaxonomyTranslatePK(long taxId, String localeCode) {
		this.taxId = taxId;
		this.localeCode = localeCode;
	}

	public long getTaxId() {
		return taxId;
	}

	public void setTaxId(long taxId) {
		this.taxId = taxId;
	}

	public String getLocaleCode() {
		return localeCode;
	}

	public void setLocaleCode(String localeCode) {
		this.localeCode = localeCode;
	}

	@Override
	public int compareTo(TaxonomyTranslatePK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (taxId < pk.taxId) {
			value = -1;
		}
		else if (taxId > pk.taxId) {
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

		if (!(obj instanceof TaxonomyTranslatePK)) {
			return false;
		}

		TaxonomyTranslatePK pk = (TaxonomyTranslatePK)obj;

		if ((taxId == pk.taxId) && (localeCode.equals(pk.localeCode))) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(taxId) + String.valueOf(localeCode)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("taxId");
		sb.append(StringPool.EQUAL);
		sb.append(taxId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("localeCode");
		sb.append(StringPool.EQUAL);
		sb.append(localeCode);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}