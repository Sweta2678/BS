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

import com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SpreadSheetAttributeUpdate in entity cache.
 *
 * @author Mummanedi
 * @see SpreadSheetAttributeUpdate
 * @generated
 */
public class SpreadSheetAttributeUpdateCacheModel implements CacheModel<SpreadSheetAttributeUpdate>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{speardSheetId=");
		sb.append(speardSheetId);
		sb.append(", requestTitle=");
		sb.append(requestTitle);
		sb.append(", status=");
		sb.append(status);
		sb.append(", creatorId=");
		sb.append(creatorId);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", updatedBy=");
		sb.append(updatedBy);
		sb.append(", updatedDate=");
		sb.append(updatedDate);
		sb.append(", spreadSheet=");
		sb.append(spreadSheet);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SpreadSheetAttributeUpdate toEntityModel() {
		SpreadSheetAttributeUpdateImpl spreadSheetAttributeUpdateImpl = new SpreadSheetAttributeUpdateImpl();

		spreadSheetAttributeUpdateImpl.setSpeardSheetId(speardSheetId);

		if (requestTitle == null) {
			spreadSheetAttributeUpdateImpl.setRequestTitle(StringPool.BLANK);
		}
		else {
			spreadSheetAttributeUpdateImpl.setRequestTitle(requestTitle);
		}

		if (status == null) {
			spreadSheetAttributeUpdateImpl.setStatus(StringPool.BLANK);
		}
		else {
			spreadSheetAttributeUpdateImpl.setStatus(status);
		}

		if (creatorId == null) {
			spreadSheetAttributeUpdateImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			spreadSheetAttributeUpdateImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			spreadSheetAttributeUpdateImpl.setCreatedDate(null);
		}
		else {
			spreadSheetAttributeUpdateImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			spreadSheetAttributeUpdateImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			spreadSheetAttributeUpdateImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			spreadSheetAttributeUpdateImpl.setUpdatedDate(null);
		}
		else {
			spreadSheetAttributeUpdateImpl.setUpdatedDate(new Date(updatedDate));
		}

		if (spreadSheet == null) {
			spreadSheetAttributeUpdateImpl.setSpreadSheet(StringPool.BLANK);
		}
		else {
			spreadSheetAttributeUpdateImpl.setSpreadSheet(spreadSheet);
		}

		spreadSheetAttributeUpdateImpl.resetOriginalValues();

		return spreadSheetAttributeUpdateImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		speardSheetId = objectInput.readLong();
		requestTitle = objectInput.readUTF();
		status = objectInput.readUTF();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
		spreadSheet = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(speardSheetId);

		if (requestTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(requestTitle);
		}

		if (status == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(status);
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

		if (spreadSheet == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(spreadSheet);
		}
	}

	public long speardSheetId;
	public String requestTitle;
	public String status;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
	public String spreadSheet;
}