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
public class HistManualChainPK implements Comparable<HistManualChainPK>,
	Serializable {
	public String chainCode;
	public long histManualId;

	public HistManualChainPK() {
	}

	public HistManualChainPK(String chainCode, long histManualId) {
		this.chainCode = chainCode;
		this.histManualId = histManualId;
	}

	public String getChainCode() {
		return chainCode;
	}

	public void setChainCode(String chainCode) {
		this.chainCode = chainCode;
	}

	public long getHistManualId() {
		return histManualId;
	}

	public void setHistManualId(long histManualId) {
		this.histManualId = histManualId;
	}

	@Override
	public int compareTo(HistManualChainPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		value = chainCode.compareTo(pk.chainCode);

		if (value != 0) {
			return value;
		}

		if (histManualId < pk.histManualId) {
			value = -1;
		}
		else if (histManualId > pk.histManualId) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		if (!(obj instanceof HistManualChainPK)) {
			return false;
		}

		HistManualChainPK pk = (HistManualChainPK)obj;

		if ((chainCode.equals(pk.chainCode)) &&
				(histManualId == pk.histManualId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(chainCode) + String.valueOf(histManualId)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("chainCode");
		sb.append(StringPool.EQUAL);
		sb.append(chainCode);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("histManualId");
		sb.append(StringPool.EQUAL);
		sb.append(histManualId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}