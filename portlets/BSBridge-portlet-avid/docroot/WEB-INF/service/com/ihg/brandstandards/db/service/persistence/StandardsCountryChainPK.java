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
public class StandardsCountryChainPK implements Comparable<StandardsCountryChainPK>,
	Serializable {
	public long stdId;
	public String countryCode;
	public String chainCode;

	public StandardsCountryChainPK() {
	}

	public StandardsCountryChainPK(long stdId, String countryCode,
		String chainCode) {
		this.stdId = stdId;
		this.countryCode = countryCode;
		this.chainCode = chainCode;
	}

	public long getStdId() {
		return stdId;
	}

	public void setStdId(long stdId) {
		this.stdId = stdId;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getChainCode() {
		return chainCode;
	}

	public void setChainCode(String chainCode) {
		this.chainCode = chainCode;
	}

	@Override
	public int compareTo(StandardsCountryChainPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (stdId < pk.stdId) {
			value = -1;
		}
		else if (stdId > pk.stdId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = countryCode.compareTo(pk.countryCode);

		if (value != 0) {
			return value;
		}

		value = chainCode.compareTo(pk.chainCode);

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

		if (!(obj instanceof StandardsCountryChainPK)) {
			return false;
		}

		StandardsCountryChainPK pk = (StandardsCountryChainPK)obj;

		if ((stdId == pk.stdId) && (countryCode.equals(pk.countryCode)) &&
				(chainCode.equals(pk.chainCode))) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(stdId) + String.valueOf(countryCode) +
		String.valueOf(chainCode)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("stdId");
		sb.append(StringPool.EQUAL);
		sb.append(stdId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("countryCode");
		sb.append(StringPool.EQUAL);
		sb.append(countryCode);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("chainCode");
		sb.append(StringPool.EQUAL);
		sb.append(chainCode);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}