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

import com.ihg.brandstandards.db.model.BridgePublish;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing BridgePublish in entity cache.
 *
 * @author Mummanedi
 * @see BridgePublish
 * @generated
 */
public class BridgePublishCacheModel implements CacheModel<BridgePublish>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{bridgePublishId=");
		sb.append(bridgePublishId);
		sb.append(", publishId=");
		sb.append(publishId);
		sb.append(", standardId=");
		sb.append(standardId);
		sb.append(", regionId=");
		sb.append(regionId);
		sb.append(", unpublishInd=");
		sb.append(unpublishInd);
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
	public BridgePublish toEntityModel() {
		BridgePublishImpl bridgePublishImpl = new BridgePublishImpl();

		bridgePublishImpl.setBridgePublishId(bridgePublishId);
		bridgePublishImpl.setPublishId(publishId);
		bridgePublishImpl.setStandardId(standardId);
		bridgePublishImpl.setRegionId(regionId);

		if (unpublishInd == null) {
			bridgePublishImpl.setUnpublishInd(StringPool.BLANK);
		}
		else {
			bridgePublishImpl.setUnpublishInd(unpublishInd);
		}

		if (creatorId == null) {
			bridgePublishImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			bridgePublishImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			bridgePublishImpl.setCreatedDate(null);
		}
		else {
			bridgePublishImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			bridgePublishImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			bridgePublishImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			bridgePublishImpl.setUpdatedDate(null);
		}
		else {
			bridgePublishImpl.setUpdatedDate(new Date(updatedDate));
		}

		bridgePublishImpl.resetOriginalValues();

		return bridgePublishImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		bridgePublishId = objectInput.readLong();
		publishId = objectInput.readLong();
		standardId = objectInput.readLong();
		regionId = objectInput.readLong();
		unpublishInd = objectInput.readUTF();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(bridgePublishId);
		objectOutput.writeLong(publishId);
		objectOutput.writeLong(standardId);
		objectOutput.writeLong(regionId);

		if (unpublishInd == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(unpublishInd);
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

	public long bridgePublishId;
	public long publishId;
	public long standardId;
	public long regionId;
	public String unpublishInd;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}