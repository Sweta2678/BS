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
public class GEMGeneratedReportValPK implements Comparable<GEMGeneratedReportValPK>,
	Serializable {
	public long reportValId;
	public long reportId;

	public GEMGeneratedReportValPK() {
	}

	public GEMGeneratedReportValPK(long reportValId, long reportId) {
		this.reportValId = reportValId;
		this.reportId = reportId;
	}

	public long getReportValId() {
		return reportValId;
	}

	public void setReportValId(long reportValId) {
		this.reportValId = reportValId;
	}

	public long getReportId() {
		return reportId;
	}

	public void setReportId(long reportId) {
		this.reportId = reportId;
	}

	@Override
	public int compareTo(GEMGeneratedReportValPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (reportValId < pk.reportValId) {
			value = -1;
		}
		else if (reportValId > pk.reportValId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (reportId < pk.reportId) {
			value = -1;
		}
		else if (reportId > pk.reportId) {
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

		if (!(obj instanceof GEMGeneratedReportValPK)) {
			return false;
		}

		GEMGeneratedReportValPK pk = (GEMGeneratedReportValPK)obj;

		if ((reportValId == pk.reportValId) && (reportId == pk.reportId)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(reportValId) + String.valueOf(reportId)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("reportValId");
		sb.append(StringPool.EQUAL);
		sb.append(reportValId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("reportId");
		sb.append(StringPool.EQUAL);
		sb.append(reportId);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}