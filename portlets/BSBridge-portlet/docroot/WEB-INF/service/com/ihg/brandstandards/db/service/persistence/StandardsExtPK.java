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
public class StandardsExtPK implements Comparable<StandardsExtPK>, Serializable {
	public long stdId;
	public long auditLogId;
	public String stdManual;
	public String stdCorporateDepartment;
	public String stdBrandCd;
	public long biImpactAssmntId;
	public String stdCountryCd;

	public StandardsExtPK() {
	}

	public StandardsExtPK(long stdId, long auditLogId, String stdManual,
		String stdCorporateDepartment, String stdBrandCd,
		long biImpactAssmntId, String stdCountryCd) {
		this.stdId = stdId;
		this.auditLogId = auditLogId;
		this.stdManual = stdManual;
		this.stdCorporateDepartment = stdCorporateDepartment;
		this.stdBrandCd = stdBrandCd;
		this.biImpactAssmntId = biImpactAssmntId;
		this.stdCountryCd = stdCountryCd;
	}

	public long getStdId() {
		return stdId;
	}

	public void setStdId(long stdId) {
		this.stdId = stdId;
	}

	public long getAuditLogId() {
		return auditLogId;
	}

	public void setAuditLogId(long auditLogId) {
		this.auditLogId = auditLogId;
	}

	public String getStdManual() {
		return stdManual;
	}

	public void setStdManual(String stdManual) {
		this.stdManual = stdManual;
	}

	public String getStdCorporateDepartment() {
		return stdCorporateDepartment;
	}

	public void setStdCorporateDepartment(String stdCorporateDepartment) {
		this.stdCorporateDepartment = stdCorporateDepartment;
	}

	public String getStdBrandCd() {
		return stdBrandCd;
	}

	public void setStdBrandCd(String stdBrandCd) {
		this.stdBrandCd = stdBrandCd;
	}

	public long getBiImpactAssmntId() {
		return biImpactAssmntId;
	}

	public void setBiImpactAssmntId(long biImpactAssmntId) {
		this.biImpactAssmntId = biImpactAssmntId;
	}

	public String getStdCountryCd() {
		return stdCountryCd;
	}

	public void setStdCountryCd(String stdCountryCd) {
		this.stdCountryCd = stdCountryCd;
	}

	@Override
	public int compareTo(StandardsExtPK pk) {
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

		if (auditLogId < pk.auditLogId) {
			value = -1;
		}
		else if (auditLogId > pk.auditLogId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = stdManual.compareTo(pk.stdManual);

		if (value != 0) {
			return value;
		}

		value = stdCorporateDepartment.compareTo(pk.stdCorporateDepartment);

		if (value != 0) {
			return value;
		}

		value = stdBrandCd.compareTo(pk.stdBrandCd);

		if (value != 0) {
			return value;
		}

		if (biImpactAssmntId < pk.biImpactAssmntId) {
			value = -1;
		}
		else if (biImpactAssmntId > pk.biImpactAssmntId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = stdCountryCd.compareTo(pk.stdCountryCd);

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

		if (!(obj instanceof StandardsExtPK)) {
			return false;
		}

		StandardsExtPK pk = (StandardsExtPK)obj;

		if ((stdId == pk.stdId) && (auditLogId == pk.auditLogId) &&
				(stdManual.equals(pk.stdManual)) &&
				(stdCorporateDepartment.equals(pk.stdCorporateDepartment)) &&
				(stdBrandCd.equals(pk.stdBrandCd)) &&
				(biImpactAssmntId == pk.biImpactAssmntId) &&
				(stdCountryCd.equals(pk.stdCountryCd))) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(stdId) + String.valueOf(auditLogId) +
		String.valueOf(stdManual) + String.valueOf(stdCorporateDepartment) +
		String.valueOf(stdBrandCd) + String.valueOf(biImpactAssmntId) +
		String.valueOf(stdCountryCd)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("stdId");
		sb.append(StringPool.EQUAL);
		sb.append(stdId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("auditLogId");
		sb.append(StringPool.EQUAL);
		sb.append(auditLogId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("stdManual");
		sb.append(StringPool.EQUAL);
		sb.append(stdManual);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("stdCorporateDepartment");
		sb.append(StringPool.EQUAL);
		sb.append(stdCorporateDepartment);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("stdBrandCd");
		sb.append(StringPool.EQUAL);
		sb.append(stdBrandCd);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("biImpactAssmntId");
		sb.append(StringPool.EQUAL);
		sb.append(biImpactAssmntId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("stdCountryCd");
		sb.append(StringPool.EQUAL);
		sb.append(stdCountryCd);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}