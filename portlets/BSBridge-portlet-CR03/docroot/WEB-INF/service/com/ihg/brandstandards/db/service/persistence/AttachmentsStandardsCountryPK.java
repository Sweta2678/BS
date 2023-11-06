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
public class AttachmentsStandardsCountryPK implements Comparable<AttachmentsStandardsCountryPK>,
	Serializable {
	public long attachmentId;
	public String countryCode;
	public String localeCode;

	public AttachmentsStandardsCountryPK() {
	}

	public AttachmentsStandardsCountryPK(long attachmentId, String countryCode,
		String localeCode) {
		this.attachmentId = attachmentId;
		this.countryCode = countryCode;
		this.localeCode = localeCode;
	}

	public long getAttachmentId() {
		return attachmentId;
	}

	public void setAttachmentId(long attachmentId) {
		this.attachmentId = attachmentId;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getLocaleCode() {
		return localeCode;
	}

	public void setLocaleCode(String localeCode) {
		this.localeCode = localeCode;
	}

	@Override
	public int compareTo(AttachmentsStandardsCountryPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (attachmentId < pk.attachmentId) {
			value = -1;
		}
		else if (attachmentId > pk.attachmentId) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = countryCode.compareTo(pk.countryCode);

		if (value != 0) {
			return value;
		}

		value = localeCode.compareTo(pk.localeCode);

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

		if (!(obj instanceof AttachmentsStandardsCountryPK)) {
			return false;
		}

		AttachmentsStandardsCountryPK pk = (AttachmentsStandardsCountryPK)obj;

		if ((attachmentId == pk.attachmentId) &&
				(countryCode.equals(pk.countryCode)) &&
				(localeCode.equals(pk.localeCode))) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(attachmentId) + String.valueOf(countryCode) +
		String.valueOf(localeCode)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("attachmentId");
		sb.append(StringPool.EQUAL);
		sb.append(attachmentId);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("countryCode");
		sb.append(StringPool.EQUAL);
		sb.append(countryCode);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("localeCode");
		sb.append(StringPool.EQUAL);
		sb.append(localeCode);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}