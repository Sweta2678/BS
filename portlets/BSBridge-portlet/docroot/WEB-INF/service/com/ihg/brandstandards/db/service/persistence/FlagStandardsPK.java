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
public class FlagStandardsPK implements Comparable<FlagStandardsPK>,
	Serializable {
	public long flagCatId;
	public long stdId;

	public FlagStandardsPK() {
	}

	public FlagStandardsPK(long flagCatId, long stdId) {
		this.flagCatId = flagCatId;
		this.stdId = stdId;
	}

	public long getFlagCatId() {
		return flagCatId;
	}

	public void setFlagCatId(long flagCatId) {
		this.flagCatId = flagCatId;
	}

	public long getStdId() {
		return stdId;
	}

	public void setStdId(long stdId) {
		this.stdId = stdId;
	}

	@Override
	public int compareTo(FlagStandardsPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (flagCatId < pk.flagCatId) {
			value = -1;
		}
		else if (flagCatId > pk.flagCatId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

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

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FlagStandardsPK)) {
			return false;
		}

		FlagStandardsPK pk = (FlagStandardsPK)obj;

		if ((flagCatId == pk.flagCatId) && (stdId == pk.stdId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(flagCatId) + String.valueOf(stdId)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("flagCatId");
		sb.append(StringPool.EQUAL);
		sb.append(flagCatId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("stdId");
		sb.append(StringPool.EQUAL);
		sb.append(stdId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}