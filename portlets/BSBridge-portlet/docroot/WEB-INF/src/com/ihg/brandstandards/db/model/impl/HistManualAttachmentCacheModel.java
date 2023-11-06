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

import com.ihg.brandstandards.db.model.HistManualAttachment;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing HistManualAttachment in entity cache.
 *
 * @author Mummanedi
 * @see HistManualAttachment
 * @generated
 */
public class HistManualAttachmentCacheModel implements CacheModel<HistManualAttachment>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{histManualId=");
		sb.append(histManualId);
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
	public HistManualAttachment toEntityModel() {
		HistManualAttachmentImpl histManualAttachmentImpl = new HistManualAttachmentImpl();

		histManualAttachmentImpl.setHistManualId(histManualId);

		if (attachmentPath == null) {
			histManualAttachmentImpl.setAttachmentPath(StringPool.BLANK);
		}
		else {
			histManualAttachmentImpl.setAttachmentPath(attachmentPath);
		}

		if (creatorId == null) {
			histManualAttachmentImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			histManualAttachmentImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			histManualAttachmentImpl.setCreatedDate(null);
		}
		else {
			histManualAttachmentImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			histManualAttachmentImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			histManualAttachmentImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			histManualAttachmentImpl.setUpdatedDate(null);
		}
		else {
			histManualAttachmentImpl.setUpdatedDate(new Date(updatedDate));
		}

		histManualAttachmentImpl.resetOriginalValues();

		return histManualAttachmentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		histManualId = objectInput.readLong();
		attachmentPath = objectInput.readUTF();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(histManualId);

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

	public long histManualId;
	public String attachmentPath;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}