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
public class StandardTagPK implements Comparable<StandardTagPK>, Serializable {
	public long stdId;
	public String tag;

	public StandardTagPK() {
	}

	public StandardTagPK(long stdId, String tag) {
		this.stdId = stdId;
		this.tag = tag;
	}

	public long getStdId() {
		return stdId;
	}

	public void setStdId(long stdId) {
		this.stdId = stdId;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	@Override
	public int compareTo(StandardTagPK pk) {
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

		value = tag.compareTo(pk.tag);

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

		if (!(obj instanceof StandardTagPK)) {
			return false;
		}

		StandardTagPK pk = (StandardTagPK)obj;

		if ((stdId == pk.stdId) && (tag.equals(pk.tag))) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(stdId) + String.valueOf(tag)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("stdId");
		sb.append(StringPool.EQUAL);
		sb.append(stdId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("tag");
		sb.append(StringPool.EQUAL);
		sb.append(tag);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}