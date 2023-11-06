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

import com.ihg.brandstandards.db.model.ChainAttachmentsStandards;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ChainAttachmentsStandards in entity cache.
 *
 * @author Mummanedi
 * @see ChainAttachmentsStandards
 * @generated
 */
public class ChainAttachmentsStandardsCacheModel implements CacheModel<ChainAttachmentsStandards>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{chainAttachmentId=");
		sb.append(chainAttachmentId);
		sb.append(", attachmentId=");
		sb.append(attachmentId);
		sb.append(", localeCode=");
		sb.append(localeCode);
		sb.append(", chainCode=");
		sb.append(chainCode);
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
	public ChainAttachmentsStandards toEntityModel() {
		ChainAttachmentsStandardsImpl chainAttachmentsStandardsImpl = new ChainAttachmentsStandardsImpl();

		chainAttachmentsStandardsImpl.setChainAttachmentId(chainAttachmentId);
		chainAttachmentsStandardsImpl.setAttachmentId(attachmentId);

		if (localeCode == null) {
			chainAttachmentsStandardsImpl.setLocaleCode(StringPool.BLANK);
		}
		else {
			chainAttachmentsStandardsImpl.setLocaleCode(localeCode);
		}

		if (chainCode == null) {
			chainAttachmentsStandardsImpl.setChainCode(StringPool.BLANK);
		}
		else {
			chainAttachmentsStandardsImpl.setChainCode(chainCode);
		}

		if (creatorId == null) {
			chainAttachmentsStandardsImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			chainAttachmentsStandardsImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			chainAttachmentsStandardsImpl.setCreatedDate(null);
		}
		else {
			chainAttachmentsStandardsImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			chainAttachmentsStandardsImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			chainAttachmentsStandardsImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			chainAttachmentsStandardsImpl.setUpdatedDate(null);
		}
		else {
			chainAttachmentsStandardsImpl.setUpdatedDate(new Date(updatedDate));
		}

		chainAttachmentsStandardsImpl.resetOriginalValues();

		return chainAttachmentsStandardsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		chainAttachmentId = objectInput.readLong();
		attachmentId = objectInput.readLong();
		localeCode = objectInput.readUTF();
		chainCode = objectInput.readUTF();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(chainAttachmentId);
		objectOutput.writeLong(attachmentId);

		if (localeCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(localeCode);
		}

		if (chainCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(chainCode);
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

	public long chainAttachmentId;
	public long attachmentId;
	public String localeCode;
	public String chainCode;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}