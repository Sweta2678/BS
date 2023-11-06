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
public class ExternalLinkStandardsCountryPK implements Comparable<ExternalLinkStandardsCountryPK>,
	Serializable {
	public long extLinkId;
	public String countryCode;

	public ExternalLinkStandardsCountryPK() {
	}

	public ExternalLinkStandardsCountryPK(long extLinkId, String countryCode) {
		this.extLinkId = extLinkId;
		this.countryCode = countryCode;
	}

	public long getExtLinkId() {
		return extLinkId;
	}

	public void setExtLinkId(long extLinkId) {
		this.extLinkId = extLinkId;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	@Override
	public int compareTo(ExternalLinkStandardsCountryPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (extLinkId < pk.extLinkId) {
			value = -1;
		}
		else if (extLinkId > pk.extLinkId) {
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

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ExternalLinkStandardsCountryPK)) {
			return false;
		}

		ExternalLinkStandardsCountryPK pk = (ExternalLinkStandardsCountryPK)obj;

		if ((extLinkId == pk.extLinkId) &&
				(countryCode.equals(pk.countryCode))) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(extLinkId) + String.valueOf(countryCode)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("extLinkId");
		sb.append(StringPool.EQUAL);
		sb.append(extLinkId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("countryCode");
		sb.append(StringPool.EQUAL);
		sb.append(countryCode);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}