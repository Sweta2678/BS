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

import com.ihg.brandstandards.db.model.GEMUniqueGroup;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing GEMUniqueGroup in entity cache.
 *
 * @author Mummanedi
 * @see GEMUniqueGroup
 * @generated
 */
public class GEMUniqueGroupCacheModel implements CacheModel<GEMUniqueGroup>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uniqueGroupId=");
		sb.append(uniqueGroupId);
		sb.append(", publishDeptId=");
		sb.append(publishDeptId);
		sb.append(", publishId=");
		sb.append(publishId);
		sb.append(", groupName=");
		sb.append(groupName);
		sb.append(", regionId=");
		sb.append(regionId);
		sb.append(", policyId=");
		sb.append(policyId);
		sb.append(", levelId=");
		sb.append(levelId);
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
	public GEMUniqueGroup toEntityModel() {
		GEMUniqueGroupImpl gemUniqueGroupImpl = new GEMUniqueGroupImpl();

		gemUniqueGroupImpl.setUniqueGroupId(uniqueGroupId);
		gemUniqueGroupImpl.setPublishDeptId(publishDeptId);
		gemUniqueGroupImpl.setPublishId(publishId);

		if (groupName == null) {
			gemUniqueGroupImpl.setGroupName(StringPool.BLANK);
		}
		else {
			gemUniqueGroupImpl.setGroupName(groupName);
		}

		gemUniqueGroupImpl.setRegionId(regionId);

		if (policyId == null) {
			gemUniqueGroupImpl.setPolicyId(StringPool.BLANK);
		}
		else {
			gemUniqueGroupImpl.setPolicyId(policyId);
		}

		if (levelId == null) {
			gemUniqueGroupImpl.setLevelId(StringPool.BLANK);
		}
		else {
			gemUniqueGroupImpl.setLevelId(levelId);
		}

		if (groupType == null) {
			gemUniqueGroupImpl.setGroupType(StringPool.BLANK);
		}
		else {
			gemUniqueGroupImpl.setGroupType(groupType);
		}

		if (creatorId == null) {
			gemUniqueGroupImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			gemUniqueGroupImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			gemUniqueGroupImpl.setCreatedDate(null);
		}
		else {
			gemUniqueGroupImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			gemUniqueGroupImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			gemUniqueGroupImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			gemUniqueGroupImpl.setUpdatedDate(null);
		}
		else {
			gemUniqueGroupImpl.setUpdatedDate(new Date(updatedDate));
		}

		gemUniqueGroupImpl.resetOriginalValues();

		return gemUniqueGroupImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uniqueGroupId = objectInput.readLong();
		publishDeptId = objectInput.readLong();
		publishId = objectInput.readLong();
		groupName = objectInput.readUTF();
		regionId = objectInput.readLong();
		policyId = objectInput.readUTF();
		levelId = objectInput.readUTF();
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
		objectOutput.writeLong(publishDeptId);
		objectOutput.writeLong(publishId);

		if (groupName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(groupName);
		}

		objectOutput.writeLong(regionId);

		if (policyId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(policyId);
		}

		if (levelId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(levelId);
		}

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
	public long publishDeptId;
	public long publishId;
	public String groupName;
	public long regionId;
	public String policyId;
	public String levelId;
	public String groupType;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}