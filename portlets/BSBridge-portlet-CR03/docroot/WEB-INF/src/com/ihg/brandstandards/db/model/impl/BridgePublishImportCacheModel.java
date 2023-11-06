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

import com.ihg.brandstandards.db.model.BridgePublishImport;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing BridgePublishImport in entity cache.
 *
 * @author Mummanedi
 * @see BridgePublishImport
 * @generated
 */
public class BridgePublishImportCacheModel implements CacheModel<BridgePublishImport>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{publishImportId=");
		sb.append(publishImportId);
		sb.append(", publishId=");
		sb.append(publishId);
		sb.append(", stdId=");
		sb.append(stdId);
		sb.append(", selectInd=");
		sb.append(selectInd);
		sb.append(", regionId=");
		sb.append(regionId);
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public BridgePublishImport toEntityModel() {
		BridgePublishImportImpl bridgePublishImportImpl = new BridgePublishImportImpl();

		bridgePublishImportImpl.setPublishImportId(publishImportId);
		bridgePublishImportImpl.setPublishId(publishId);
		bridgePublishImportImpl.setStdId(stdId);

		if (selectInd == null) {
			bridgePublishImportImpl.setSelectInd(StringPool.BLANK);
		}
		else {
			bridgePublishImportImpl.setSelectInd(selectInd);
		}

		bridgePublishImportImpl.setRegionId(regionId);

		if (status == null) {
			bridgePublishImportImpl.setStatus(StringPool.BLANK);
		}
		else {
			bridgePublishImportImpl.setStatus(status);
		}

		if (creatorId == null) {
			bridgePublishImportImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			bridgePublishImportImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			bridgePublishImportImpl.setCreatedDate(null);
		}
		else {
			bridgePublishImportImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			bridgePublishImportImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			bridgePublishImportImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			bridgePublishImportImpl.setUpdatedDate(null);
		}
		else {
			bridgePublishImportImpl.setUpdatedDate(new Date(updatedDate));
		}

		bridgePublishImportImpl.resetOriginalValues();

		return bridgePublishImportImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		publishImportId = objectInput.readLong();
		publishId = objectInput.readLong();
		stdId = objectInput.readLong();
		selectInd = objectInput.readUTF();
		regionId = objectInput.readLong();
		status = objectInput.readUTF();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(publishImportId);
		objectOutput.writeLong(publishId);
		objectOutput.writeLong(stdId);

		if (selectInd == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(selectInd);
		}

		objectOutput.writeLong(regionId);

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
	}

	public long publishImportId;
	public long publishId;
	public long stdId;
	public String selectInd;
	public long regionId;
	public String status;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}