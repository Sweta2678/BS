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
public class StandardsChainImagesPK implements Comparable<StandardsChainImagesPK>,
	Serializable {
	public long stdImageId;
	public String chainCode;

	public StandardsChainImagesPK() {
	}

	public StandardsChainImagesPK(long stdImageId, String chainCode) {
		this.stdImageId = stdImageId;
		this.chainCode = chainCode;
	}

	public long getStdImageId() {
		return stdImageId;
	}

	public void setStdImageId(long stdImageId) {
		this.stdImageId = stdImageId;
	}

	public String getChainCode() {
		return chainCode;
	}

	public void setChainCode(String chainCode) {
		this.chainCode = chainCode;
	}

	@Override
	public int compareTo(StandardsChainImagesPK pk) {
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

		if (!(obj instanceof StandardsChainImagesPK)) {
			return false;
		}

		StandardsChainImagesPK pk = (StandardsChainImagesPK)obj;

		if ((stdImageId == pk.stdImageId) && (chainCode.equals(pk.chainCode))) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(stdImageId) + String.valueOf(chainCode)).hashCode();
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
		sb.append("chainCode");
		sb.append(StringPool.EQUAL);
		sb.append(chainCode);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}