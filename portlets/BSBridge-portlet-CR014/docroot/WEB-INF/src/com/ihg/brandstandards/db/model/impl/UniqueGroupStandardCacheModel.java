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

import com.ihg.brandstandards.db.model.UniqueGroupStandard;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing UniqueGroupStandard in entity cache.
 *
 * @author Mummanedi
 * @see UniqueGroupStandard
 * @generated
 */
public class UniqueGroupStandardCacheModel implements CacheModel<UniqueGroupStandard>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{groupStandardId=");
		sb.append(groupStandardId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", stdId=");
		sb.append(stdId);
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
	public UniqueGroupStandard toEntityModel() {
		UniqueGroupStandardImpl uniqueGroupStandardImpl = new UniqueGroupStandardImpl();

		uniqueGroupStandardImpl.setGroupStandardId(groupStandardId);
		uniqueGroupStandardImpl.setGroupId(groupId);
		uniqueGroupStandardImpl.setStdId(stdId);

		if (creatorId == null) {
			uniqueGroupStandardImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			uniqueGroupStandardImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			uniqueGroupStandardImpl.setCreatedDate(null);
		}
		else {
			uniqueGroupStandardImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			uniqueGroupStandardImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			uniqueGroupStandardImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			uniqueGroupStandardImpl.setUpdatedDate(null);
		}
		else {
			uniqueGroupStandardImpl.setUpdatedDate(new Date(updatedDate));
		}

		uniqueGroupStandardImpl.resetOriginalValues();

		return uniqueGroupStandardImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		groupStandardId = objectInput.readLong();
		groupId = objectInput.readLong();
		stdId = objectInput.readLong();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(groupStandardId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(stdId);

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

	public long groupStandardId;
	public long groupId;
	public long stdId;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}