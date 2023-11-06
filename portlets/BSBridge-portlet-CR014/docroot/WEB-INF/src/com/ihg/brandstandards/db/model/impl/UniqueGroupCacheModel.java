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

import com.ihg.brandstandards.db.model.UniqueGroup;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing UniqueGroup in entity cache.
 *
 * @author Mummanedi
 * @see UniqueGroup
 * @generated
 */
public class UniqueGroupCacheModel implements CacheModel<UniqueGroup>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{uniqueGroupId=");
		sb.append(uniqueGroupId);
		sb.append(", publishId=");
		sb.append(publishId);
		sb.append(", groupName=");
		sb.append(groupName);
		sb.append(", regionId=");
		sb.append(regionId);
		sb.append(", groupType=");
		sb.append(groupType);
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
	public UniqueGroup toEntityModel() {
		UniqueGroupImpl uniqueGroupImpl = new UniqueGroupImpl();

		uniqueGroupImpl.setUniqueGroupId(uniqueGroupId);
		uniqueGroupImpl.setPublishId(publishId);

		if (groupName == null) {
			uniqueGroupImpl.setGroupName(StringPool.BLANK);
		}
		else {
			uniqueGroupImpl.setGroupName(groupName);
		}

		uniqueGroupImpl.setRegionId(regionId);

		if (groupType == null) {
			uniqueGroupImpl.setGroupType(StringPool.BLANK);
		}
		else {
			uniqueGroupImpl.setGroupType(groupType);
		}

		if (creatorId == null) {
			uniqueGroupImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			uniqueGroupImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			uniqueGroupImpl.setCreatedDate(null);
		}
		else {
			uniqueGroupImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			uniqueGroupImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			uniqueGroupImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			uniqueGroupImpl.setUpdatedDate(null);
		}
		else {
			uniqueGroupImpl.setUpdatedDate(new Date(updatedDate));
		}

		uniqueGroupImpl.resetOriginalValues();

		return uniqueGroupImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uniqueGroupId = objectInput.readLong();
		publishId = objectInput.readLong();
		groupName = objectInput.readUTF();
		regionId = objectInput.readLong();
		groupType = objectInput.readUTF();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(uniqueGroupId);
		objectOutput.writeLong(publishId);

		if (groupName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(groupName);
		}

		objectOutput.writeLong(regionId);

		if (groupType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(groupType);
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

	public long uniqueGroupId;
	public long publishId;
	public String groupName;
	public long regionId;
	public String groupType;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}