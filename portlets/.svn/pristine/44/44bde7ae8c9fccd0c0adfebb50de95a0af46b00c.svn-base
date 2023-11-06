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

package com.ihg.brandstandards.db.model.impl;

import com.ihg.brandstandards.db.model.AttachmentsStandardsCountry;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AttachmentsStandardsCountry in entity cache.
 *
 * @author Mummanedi
 * @see AttachmentsStandardsCountry
 * @generated
 */
public class AttachmentsStandardsCountryCacheModel implements CacheModel<AttachmentsStandardsCountry>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{attachmentId=");
		sb.append(attachmentId);
		sb.append(", countryCode=");
		sb.append(countryCode);
		sb.append(", localeCode=");
		sb.append(localeCode);
		sb.append(", creatorId=");
		sb.append(creatorId);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", updatedBy=");
		sb.append(updatedBy);
		sb.append(", updatedDate=");
		sb.append(updatedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AttachmentsStandardsCountry toEntityModel() {
		AttachmentsStandardsCountryImpl attachmentsStandardsCountryImpl = new AttachmentsStandardsCountryImpl();

		attachmentsStandardsCountryImpl.setAttachmentId(attachmentId);

		if (countryCode == null) {
			attachmentsStandardsCountryImpl.setCountryCode(StringPool.BLANK);
		}
		else {
			attachmentsStandardsCountryImpl.setCountryCode(countryCode);
		}

		if (localeCode == null) {
			attachmentsStandardsCountryImpl.setLocaleCode(StringPool.BLANK);
		}
		else {
			attachmentsStandardsCountryImpl.setLocaleCode(localeCode);
		}

		if (creatorId == null) {
			attachmentsStandardsCountryImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			attachmentsStandardsCountryImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			attachmentsStandardsCountryImpl.setCreatedDate(null);
		}
		else {
			attachmentsStandardsCountryImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			attachmentsStandardsCountryImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			attachmentsStandardsCountryImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			attachmentsStandardsCountryImpl.setUpdatedDate(null);
		}
		else {
			attachmentsStandardsCountryImpl.setUpdatedDate(new Date(updatedDate));
		}

		attachmentsStandardsCountryImpl.resetOriginalValues();

		return attachmentsStandardsCountryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		attachmentId = objectInput.readLong();
		countryCode = objectInput.readUTF();
		localeCode = objectInput.readUTF();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(attachmentId);

		if (countryCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(countryCode);
		}

		if (localeCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(localeCode);
		}

		if (creatorId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(creatorId);
		}

		objectOutput.writeLong(createdDate);

		if (updatedBy == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(updatedBy);
		}

		objectOutput.writeLong(updatedDate);
	}

	public long attachmentId;
	public String countryCode;
	public String localeCode;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}