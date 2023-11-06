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

import com.ihg.brandstandards.db.model.BridgePublishStatus;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing BridgePublishStatus in entity cache.
 *
 * @author Mummanedi
 * @see BridgePublishStatus
 * @generated
 */
public class BridgePublishStatusCacheModel implements CacheModel<BridgePublishStatus>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{publishStatusCode=");
		sb.append(publishStatusCode);
		sb.append(", publishStatusName=");
		sb.append(publishStatusName);
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
	public BridgePublishStatus toEntityModel() {
		BridgePublishStatusImpl bridgePublishStatusImpl = new BridgePublishStatusImpl();

		if (publishStatusCode == null) {
			bridgePublishStatusImpl.setPublishStatusCode(StringPool.BLANK);
		}
		else {
			bridgePublishStatusImpl.setPublishStatusCode(publishStatusCode);
		}

		if (publishStatusName == null) {
			bridgePublishStatusImpl.setPublishStatusName(StringPool.BLANK);
		}
		else {
			bridgePublishStatusImpl.setPublishStatusName(publishStatusName);
		}

		if (creatorId == null) {
			bridgePublishStatusImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			bridgePublishStatusImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			bridgePublishStatusImpl.setCreatedDate(null);
		}
		else {
			bridgePublishStatusImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			bridgePublishStatusImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			bridgePublishStatusImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			bridgePublishStatusImpl.setUpdatedDate(null);
		}
		else {
			bridgePublishStatusImpl.setUpdatedDate(new Date(updatedDate));
		}

		bridgePublishStatusImpl.resetOriginalValues();

		return bridgePublishStatusImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		publishStatusCode = objectInput.readUTF();
		publishStatusName = objectInput.readUTF();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (publishStatusCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(publishStatusCode);
		}

		if (publishStatusName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(publishStatusName);
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

	public String publishStatusCode;
	public String publishStatusName;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}