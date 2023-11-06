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

import com.ihg.brandstandards.db.model.PublishDept;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PublishDept in entity cache.
 *
 * @author Mummanedi
 * @see PublishDept
 * @generated
 */
public class PublishDeptCacheModel implements CacheModel<PublishDept>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{publishDeptId=");
		sb.append(publishDeptId);
		sb.append(", deptId=");
		sb.append(deptId);
		sb.append(", publishId=");
		sb.append(publishId);
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
	public PublishDept toEntityModel() {
		PublishDeptImpl publishDeptImpl = new PublishDeptImpl();

		publishDeptImpl.setPublishDeptId(publishDeptId);
		publishDeptImpl.setDeptId(deptId);
		publishDeptImpl.setPublishId(publishId);

		if (creatorId == null) {
			publishDeptImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			publishDeptImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			publishDeptImpl.setCreatedDate(null);
		}
		else {
			publishDeptImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			publishDeptImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			publishDeptImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			publishDeptImpl.setUpdatedDate(null);
		}
		else {
			publishDeptImpl.setUpdatedDate(new Date(updatedDate));
		}

		publishDeptImpl.resetOriginalValues();

		return publishDeptImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		publishDeptId = objectInput.readLong();
		deptId = objectInput.readLong();
		publishId = objectInput.readLong();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(publishDeptId);
		objectOutput.writeLong(deptId);
		objectOutput.writeLong(publishId);

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

	public long publishDeptId;
	public long deptId;
	public long publishId;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}