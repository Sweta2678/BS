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

import com.ihg.brandstandards.db.model.BridgeProgressCategory;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing BridgeProgressCategory in entity cache.
 *
 * @author Mummanedi
 * @see BridgeProgressCategory
 * @generated
 */
public class BridgeProgressCategoryCacheModel implements CacheModel<BridgeProgressCategory>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{progressCategoryId=");
		sb.append(progressCategoryId);
		sb.append(", progressCategoryName=");
		sb.append(progressCategoryName);
		sb.append(", displayOrderNumber=");
		sb.append(displayOrderNumber);
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
	public BridgeProgressCategory toEntityModel() {
		BridgeProgressCategoryImpl bridgeProgressCategoryImpl = new BridgeProgressCategoryImpl();

		bridgeProgressCategoryImpl.setProgressCategoryId(progressCategoryId);

		if (progressCategoryName == null) {
			bridgeProgressCategoryImpl.setProgressCategoryName(StringPool.BLANK);
		}
		else {
			bridgeProgressCategoryImpl.setProgressCategoryName(progressCategoryName);
		}

		bridgeProgressCategoryImpl.setDisplayOrderNumber(displayOrderNumber);

		if (creatorId == null) {
			bridgeProgressCategoryImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			bridgeProgressCategoryImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			bridgeProgressCategoryImpl.setCreatedDate(null);
		}
		else {
			bridgeProgressCategoryImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			bridgeProgressCategoryImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			bridgeProgressCategoryImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			bridgeProgressCategoryImpl.setUpdatedDate(null);
		}
		else {
			bridgeProgressCategoryImpl.setUpdatedDate(new Date(updatedDate));
		}

		bridgeProgressCategoryImpl.resetOriginalValues();

		return bridgeProgressCategoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		progressCategoryId = objectInput.readLong();
		progressCategoryName = objectInput.readUTF();
		displayOrderNumber = objectInput.readLong();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(progressCategoryId);

		if (progressCategoryName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(progressCategoryName);
		}

		objectOutput.writeLong(displayOrderNumber);

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

	public long progressCategoryId;
	public String progressCategoryName;
	public long displayOrderNumber;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}