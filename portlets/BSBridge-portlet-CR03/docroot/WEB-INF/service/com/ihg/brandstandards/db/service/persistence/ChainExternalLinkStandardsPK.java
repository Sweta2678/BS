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
public class ChainExternalLinkStandardsPK implements Comparable<ChainExternalLinkStandardsPK>,
	Serializable {
	public long extLinkId;
	public String chainCode;

	public ChainExternalLinkStandardsPK() {
	}

	public ChainExternalLinkStandardsPK(long extLinkId, String chainCode) {
		this.extLinkId = extLinkId;
		this.chainCode = chainCode;
	}

	public long getExtLinkId() {
		return extLinkId;
	}

	public void setExtLinkId(long extLinkId) {
		this.extLinkId = extLinkId;
	}

	public String getChainCode() {
		return chainCode;
	}

	public void setChainCode(String chainCode) {
		this.chainCode = chainCode;
	}

	@Override
	public int compareTo(ChainExternalLinkStandardsPK pk) {
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

		if (!(obj instanceof ChainExternalLinkStandardsPK)) {
			return false;
		}

		ChainExternalLinkStandardsPK pk = (ChainExternalLinkStandardsPK)obj;

		if ((extLinkId == pk.extLinkId) && (chainCode.equals(pk.chainCode))) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(extLinkId) + String.valueOf(chainCode)).hashCode();
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
		sb.append("chainCode");
		sb.append(StringPool.EQUAL);
		sb.append(chainCode);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}