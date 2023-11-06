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
public class StandardsCountryImagesPK implements Comparable<StandardsCountryImagesPK>,
	Serializable {
	public long stdImageId;
	public String countryCode;

	public StandardsCountryImagesPK() {
	}

	public StandardsCountryImagesPK(long stdImageId, String countryCode) {
		this.stdImageId = stdImageId;
		this.countryCode = countryCode;
	}

	public long getStdImageId() {
		return stdImageId;
	}

	public void setStdImageId(long stdImageId) {
		this.stdImageId = stdImageId;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	@Override
	public int compareTo(StandardsCountryImagesPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (stdImageId < pk.stdImageId) {
			value = -1;
		}
		else if (stdImageId > pk.stdImageId) {
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

		if (!(obj instanceof StandardsCountryImagesPK)) {
			return false;
		}

		StandardsCountryImagesPK pk = (StandardsCountryImagesPK)obj;

		if ((stdImageId == pk.stdImageId) &&
				(countryCode.equals(pk.countryCode))) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(stdImageId) + String.valueOf(countryCode)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("stdImageId");
		sb.append(StringPool.EQUAL);
		sb.append(stdImageId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("countryCode");
		sb.append(StringPool.EQUAL);
		sb.append(countryCode);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}