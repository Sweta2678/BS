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
public class BrandTaxonomyTranslatePK implements Comparable<BrandTaxonomyTranslatePK>,
	Serializable {
	public long brandTaxId;
	public String localeCd;

	public BrandTaxonomyTranslatePK() {
	}

	public BrandTaxonomyTranslatePK(long brandTaxId, String localeCd) {
		this.brandTaxId = brandTaxId;
		this.localeCd = localeCd;
	}

	public long getBrandTaxId() {
		return brandTaxId;
	}

	public void setBrandTaxId(long brandTaxId) {
		this.brandTaxId = brandTaxId;
	}

	public String getLocaleCd() {
		return localeCd;
	}

	public void setLocaleCd(String localeCd) {
		this.localeCd = localeCd;
	}

	@Override
	public int compareTo(BrandTaxonomyTranslatePK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (brandTaxId < pk.brandTaxId) {
			value = -1;
		}
		else if (brandTaxId > pk.brandTaxId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = localeCd.compareTo(pk.localeCd);

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

		if (!(obj instanceof BrandTaxonomyTranslatePK)) {
			return false;
		}

		BrandTaxonomyTranslatePK pk = (BrandTaxonomyTranslatePK)obj;

		if ((brandTaxId == pk.brandTaxId) && (localeCd.equals(pk.localeCd))) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(brandTaxId) + String.valueOf(localeCd)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("brandTaxId");
		sb.append(StringPool.EQUAL);
		sb.append(brandTaxId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("localeCd");
		sb.append(StringPool.EQUAL);
		sb.append(localeCd);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}