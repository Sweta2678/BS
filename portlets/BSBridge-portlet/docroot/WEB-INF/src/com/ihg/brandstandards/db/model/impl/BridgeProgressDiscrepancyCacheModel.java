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

import com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing BridgeProgressDiscrepancy in entity cache.
 *
 * @author Mummanedi
 * @see BridgeProgressDiscrepancy
 * @generated
 */
public class BridgeProgressDiscrepancyCacheModel implements CacheModel<BridgeProgressDiscrepancy>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{progressCategoryId=");
		sb.append(progressCategoryId);
		sb.append(", progressSubCategoryId=");
		sb.append(progressSubCategoryId);
		sb.append(", publishId=");
		sb.append(publishId);
		sb.append(", regionId=");
		sb.append(regionId);
		sb.append(", errorCount=");
		sb.append(errorCount);
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
	public BridgeProgressDiscrepancy toEntityModel() {
		BridgeProgressDiscrepancyImpl bridgeProgressDiscrepancyImpl = new BridgeProgressDiscrepancyImpl();

		bridgeProgressDiscrepancyImpl.setProgressCategoryId(progressCategoryId);
		bridgeProgressDiscrepancyImpl.setProgressSubCategoryId(progressSubCategoryId);
		bridgeProgressDiscrepancyImpl.setPublishId(publishId);
		bridgeProgressDiscrepancyImpl.setRegionId(regionId);
		bridgeProgressDiscrepancyImpl.setErrorCount(errorCount);

		if (creatorId == null) {
			bridgeProgressDiscrepancyImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			bridgeProgressDiscrepancyImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			bridgeProgressDiscrepancyImpl.setCreatedDate(null);
		}
		else {
			bridgeProgressDiscrepancyImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			bridgeProgressDiscrepancyImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			bridgeProgressDiscrepancyImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			bridgeProgressDiscrepancyImpl.setUpdatedDate(null);
		}
		else {
			bridgeProgressDiscrepancyImpl.setUpdatedDate(new Date(updatedDate));
		}

		bridgeProgressDiscrepancyImpl.resetOriginalValues();

		return bridgeProgressDiscrepancyImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		progressCategoryId = objectInput.readLong();
		progressSubCategoryId = objectInput.readLong();
		publishId = objectInput.readLong();
		regionId = objectInput.readLong();
		errorCount = objectInput.readLong();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(progressCategoryId);
		objectOutput.writeLong(progressSubCategoryId);
		objectOutput.writeLong(publishId);
		objectOutput.writeLong(regionId);
		objectOutput.writeLong(errorCount);

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
	public long progressSubCategoryId;
	public long publishId;
	public long regionId;
	public long errorCount;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}