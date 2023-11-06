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

import com.ihg.brandstandards.db.model.AttachmentsStandards;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AttachmentsStandards in entity cache.
 *
 * @author Mummanedi
 * @see AttachmentsStandards
 * @generated
 */
public class AttachmentsStandardsCacheModel implements CacheModel<AttachmentsStandards>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{attachmentId=");
		sb.append(attachmentId);
		sb.append(", localeCode=");
		sb.append(localeCode);
		sb.append(", parentAttachmentId=");
		sb.append(parentAttachmentId);
		sb.append(", stdId=");
		sb.append(stdId);
		sb.append(", type=");
		sb.append(type);
		sb.append(", title=");
		sb.append(title);
		sb.append(", translationIndicator=");
		sb.append(translationIndicator);
		sb.append(", attachmentPath=");
		sb.append(attachmentPath);
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
	public AttachmentsStandards toEntityModel() {
		AttachmentsStandardsImpl attachmentsStandardsImpl = new AttachmentsStandardsImpl();

		attachmentsStandardsImpl.setAttachmentId(attachmentId);

		if (localeCode == null) {
			attachmentsStandardsImpl.setLocaleCode(StringPool.BLANK);
		}
		else {
			attachmentsStandardsImpl.setLocaleCode(localeCode);
		}

		attachmentsStandardsImpl.setParentAttachmentId(parentAttachmentId);
		attachmentsStandardsImpl.setStdId(stdId);

		if (type == null) {
			attachmentsStandardsImpl.setType(StringPool.BLANK);
		}
		else {
			attachmentsStandardsImpl.setType(type);
		}

		if (title == null) {
			attachmentsStandardsImpl.setTitle(StringPool.BLANK);
		}
		else {
			attachmentsStandardsImpl.setTitle(title);
		}

		if (translationIndicator == null) {
			attachmentsStandardsImpl.setTranslationIndicator(StringPool.BLANK);
		}
		else {
			attachmentsStandardsImpl.setTranslationIndicator(translationIndicator);
		}

		if (attachmentPath == null) {
			attachmentsStandardsImpl.setAttachmentPath(StringPool.BLANK);
		}
		else {
			attachmentsStandardsImpl.setAttachmentPath(attachmentPath);
		}

		if (creatorId == null) {
			attachmentsStandardsImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			attachmentsStandardsImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			attachmentsStandardsImpl.setCreatedDate(null);
		}
		else {
			attachmentsStandardsImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			attachmentsStandardsImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			attachmentsStandardsImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			attachmentsStandardsImpl.setUpdatedDate(null);
		}
		else {
			attachmentsStandardsImpl.setUpdatedDate(new Date(updatedDate));
		}

		attachmentsStandardsImpl.resetOriginalValues();

		return attachmentsStandardsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		attachmentId = objectInput.readLong();
		localeCode = objectInput.readUTF();
		parentAttachmentId = objectInput.readLong();
		stdId = objectInput.readLong();
		type = objectInput.readUTF();
		title = objectInput.readUTF();
		translationIndicator = objectInput.readUTF();
		attachmentPath = objectInput.readUTF();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(attachmentId);

		if (localeCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(localeCode);
		}

		objectOutput.writeLong(parentAttachmentId);
		objectOutput.writeLong(stdId);

		if (type == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(type);
		}

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (translationIndicator == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(translationIndicator);
		}

		if (attachmentPath == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(attachmentPath);
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
	public String localeCode;
	public long parentAttachmentId;
	public long stdId;
	public String type;
	public String title;
	public String translationIndicator;
	public String attachmentPath;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}