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

import com.ihg.brandstandards.db.model.BridgeGlobalPublish;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing BridgeGlobalPublish in entity cache.
 *
 * @author Mummanedi
 * @see BridgeGlobalPublish
 * @generated
 */
public class BridgeGlobalPublishCacheModel implements CacheModel<BridgeGlobalPublish>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{globalPublishId=");
		sb.append(globalPublishId);
		sb.append(", publishId=");
		sb.append(publishId);
		sb.append(", stdId=");
		sb.append(stdId);
		sb.append(", mustPublishInd=");
		sb.append(mustPublishInd);
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
	public BridgeGlobalPublish toEntityModel() {
		BridgeGlobalPublishImpl bridgeGlobalPublishImpl = new BridgeGlobalPublishImpl();

		bridgeGlobalPublishImpl.setGlobalPublishId(globalPublishId);
		bridgeGlobalPublishImpl.setPublishId(publishId);
		bridgeGlobalPublishImpl.setStdId(stdId);

		if (mustPublishInd == null) {
			bridgeGlobalPublishImpl.setMustPublishInd(StringPool.BLANK);
		}
		else {
			bridgeGlobalPublishImpl.setMustPublishInd(mustPublishInd);
		}

		if (creatorId == null) {
			bridgeGlobalPublishImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			bridgeGlobalPublishImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			bridgeGlobalPublishImpl.setCreatedDate(null);
		}
		else {
			bridgeGlobalPublishImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			bridgeGlobalPublishImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			bridgeGlobalPublishImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			bridgeGlobalPublishImpl.setUpdatedDate(null);
		}
		else {
			bridgeGlobalPublishImpl.setUpdatedDate(new Date(updatedDate));
		}

		bridgeGlobalPublishImpl.resetOriginalValues();

		return bridgeGlobalPublishImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		globalPublishId = objectInput.readLong();
		publishId = objectInput.readLong();
		stdId = objectInput.readLong();
		mustPublishInd = objectInput.readUTF();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(globalPublishId);
		objectOutput.writeLong(publishId);
		objectOutput.writeLong(stdId);

		if (mustPublishInd == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(mustPublishInd);
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

	public long globalPublishId;
	public long publishId;
	public long stdId;
	public String mustPublishInd;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}