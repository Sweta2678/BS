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

import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

import java.util.Date;

/**
 * @author Mummanedi
 * @generated
 */
public class PublishExtStdPK implements Comparable<PublishExtStdPK>,
	Serializable {
	public Date compDate;
	public long stdId;

	public PublishExtStdPK() {
	}

	public PublishExtStdPK(Date compDate, long stdId) {
		this.compDate = compDate;
		this.stdId = stdId;
	}

	public Date getCompDate() {
		return compDate;
	}

	public void setCompDate(Date compDate) {
		this.compDate = compDate;
	}

	public long getStdId() {
		return stdId;
	}

	public void setStdId(long stdId) {
		this.stdId = stdId;
	}

	@Override
	public int compareTo(PublishExtStdPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		value = DateUtil.compareTo(compDate, pk.compDate);

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

		if (!(obj instanceof PublishExtStdPK)) {
			return false;
		}

		PublishExtStdPK pk = (PublishExtStdPK)obj;

		if ((compDate.equals(pk.compDate)) && (stdId == pk.stdId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (compDate.toString() + String.valueOf(stdId)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("compDate");
		sb.append(StringPool.EQUAL);
		sb.append(compDate);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("stdId");
		sb.append(StringPool.EQUAL);
		sb.append(stdId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}