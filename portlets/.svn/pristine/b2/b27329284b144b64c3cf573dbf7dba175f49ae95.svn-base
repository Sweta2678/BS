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
public class FlagCategoryPK implements Comparable<FlagCategoryPK>, Serializable {
	public long flagCatId;
	public String activeInd;

	public FlagCategoryPK() {
	}

	public FlagCategoryPK(long flagCatId, String activeInd) {
		this.flagCatId = flagCatId;
		this.activeInd = activeInd;
	}

	public long getFlagCatId() {
		return flagCatId;
	}

	public void setFlagCatId(long flagCatId) {
		this.flagCatId = flagCatId;
	}

	public String getActiveInd() {
		return activeInd;
	}

	public void setActiveInd(String activeInd) {
		this.activeInd = activeInd;
	}

	@Override
	public int compareTo(FlagCategoryPK pk) {
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

		value = activeInd.compareTo(pk.activeInd);

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

		if (!(obj instanceof FlagCategoryPK)) {
			return false;
		}

		FlagCategoryPK pk = (FlagCategoryPK)obj;

		if ((flagCatId == pk.flagCatId) && (activeInd.equals(pk.activeInd))) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(flagCatId) + String.valueOf(activeInd)).hashCode();
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
		sb.append("activeInd");
		sb.append(StringPool.EQUAL);
		sb.append(activeInd);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}