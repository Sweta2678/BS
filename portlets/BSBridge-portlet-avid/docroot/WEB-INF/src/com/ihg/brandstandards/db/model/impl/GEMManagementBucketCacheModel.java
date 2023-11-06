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

import com.ihg.brandstandards.db.model.GEMManagementBucket;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing GEMManagementBucket in entity cache.
 *
 * @author Mummanedi
 * @see GEMManagementBucket
 * @generated
 */
public class GEMManagementBucketCacheModel implements CacheModel<GEMManagementBucket>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{bucketId=");
		sb.append(bucketId);
		sb.append(", bucketName=");
		sb.append(bucketName);
		sb.append(", departmentId=");
		sb.append(departmentId);
		sb.append(", activeInd=");
		sb.append(activeInd);
		sb.append(", displayOrderNumber=");
		sb.append(displayOrderNumber);
		sb.append(", bucketCode=");
		sb.append(bucketCode);
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
	public GEMManagementBucket toEntityModel() {
		GEMManagementBucketImpl gemManagementBucketImpl = new GEMManagementBucketImpl();

		gemManagementBucketImpl.setBucketId(bucketId);

		if (bucketName == null) {
			gemManagementBucketImpl.setBucketName(StringPool.BLANK);
		}
		else {
			gemManagementBucketImpl.setBucketName(bucketName);
		}

		gemManagementBucketImpl.setDepartmentId(departmentId);

		if (activeInd == null) {
			gemManagementBucketImpl.setActiveInd(StringPool.BLANK);
		}
		else {
			gemManagementBucketImpl.setActiveInd(activeInd);
		}

		gemManagementBucketImpl.setDisplayOrderNumber(displayOrderNumber);

		if (bucketCode == null) {
			gemManagementBucketImpl.setBucketCode(StringPool.BLANK);
		}
		else {
			gemManagementBucketImpl.setBucketCode(bucketCode);
		}

		if (creatorId == null) {
			gemManagementBucketImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			gemManagementBucketImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			gemManagementBucketImpl.setCreatedDate(null);
		}
		else {
			gemManagementBucketImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			gemManagementBucketImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			gemManagementBucketImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			gemManagementBucketImpl.setUpdatedDate(null);
		}
		else {
			gemManagementBucketImpl.setUpdatedDate(new Date(updatedDate));
		}

		gemManagementBucketImpl.resetOriginalValues();

		return gemManagementBucketImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		bucketId = objectInput.readLong();
		bucketName = objectInput.readUTF();
		departmentId = objectInput.readLong();
		activeInd = objectInput.readUTF();
		displayOrderNumber = objectInput.readLong();
		bucketCode = objectInput.readUTF();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(bucketId);

		if (bucketName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bucketName);
		}

		objectOutput.writeLong(departmentId);

		if (activeInd == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(activeInd);
		}

		objectOutput.writeLong(displayOrderNumber);

		if (bucketCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bucketCode);
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

	public long bucketId;
	public String bucketName;
	public long departmentId;
	public String activeInd;
	public long displayOrderNumber;
	public String bucketCode;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}