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

import com.ihg.brandstandards.db.model.BridgeProgressSubCategory;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing BridgeProgressSubCategory in entity cache.
 *
 * @author Mummanedi
 * @see BridgeProgressSubCategory
 * @generated
 */
public class BridgeProgressSubCategoryCacheModel implements CacheModel<BridgeProgressSubCategory>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{progressSubCategoryId=");
		sb.append(progressSubCategoryId);
		sb.append(", progressCategoryId=");
		sb.append(progressCategoryId);
		sb.append(", categoryName=");
		sb.append(categoryName);
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
	public BridgeProgressSubCategory toEntityModel() {
		BridgeProgressSubCategoryImpl bridgeProgressSubCategoryImpl = new BridgeProgressSubCategoryImpl();

		bridgeProgressSubCategoryImpl.setProgressSubCategoryId(progressSubCategoryId);
		bridgeProgressSubCategoryImpl.setProgressCategoryId(progressCategoryId);

		if (categoryName == null) {
			bridgeProgressSubCategoryImpl.setCategoryName(StringPool.BLANK);
		}
		else {
			bridgeProgressSubCategoryImpl.setCategoryName(categoryName);
		}

		bridgeProgressSubCategoryImpl.setDisplayOrderNumber(displayOrderNumber);

		if (creatorId == null) {
			bridgeProgressSubCategoryImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			bridgeProgressSubCategoryImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			bridgeProgressSubCategoryImpl.setCreatedDate(null);
		}
		else {
			bridgeProgressSubCategoryImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			bridgeProgressSubCategoryImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			bridgeProgressSubCategoryImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			bridgeProgressSubCategoryImpl.setUpdatedDate(null);
		}
		else {
			bridgeProgressSubCategoryImpl.setUpdatedDate(new Date(updatedDate));
		}

		bridgeProgressSubCategoryImpl.resetOriginalValues();

		return bridgeProgressSubCategoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		progressSubCategoryId = objectInput.readLong();
		progressCategoryId = objectInput.readLong();
		categoryName = objectInput.readUTF();
		displayOrderNumber = objectInput.readLong();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(progressSubCategoryId);
		objectOutput.writeLong(progressCategoryId);

		if (categoryName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(categoryName);
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

	public long progressSubCategoryId;
	public long progressCategoryId;
	public String categoryName;
	public long displayOrderNumber;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}