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
public class StandardsCrossReferencePK implements Comparable<StandardsCrossReferencePK>,
	Serializable {
	public long stdId;
	public long xrefStdId;

	public StandardsCrossReferencePK() {
	}

	public StandardsCrossReferencePK(long stdId, long xrefStdId) {
		this.stdId = stdId;
		this.xrefStdId = xrefStdId;
	}

	public long getStdId() {
		return stdId;
	}

	public void setStdId(long stdId) {
		this.stdId = stdId;
	}

	public long getXrefStdId() {
		return xrefStdId;
	}

	public void setXrefStdId(long xrefStdId) {
		this.xrefStdId = xrefStdId;
	}

	@Override
	public int compareTo(StandardsCrossReferencePK pk) {
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

		if (xrefStdId < pk.xrefStdId) {
			value = -1;
		}
		else if (xrefStdId > pk.xrefStdId) {
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

		if (!(obj instanceof StandardsCrossReferencePK)) {
			return false;
		}

		StandardsCrossReferencePK pk = (StandardsCrossReferencePK)obj;

		if ((stdId == pk.stdId) && (xrefStdId == pk.xrefStdId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(stdId) + String.valueOf(xrefStdId)).hashCode();
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
		sb.append("xrefStdId");
		sb.append(StringPool.EQUAL);
		sb.append(xrefStdId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}