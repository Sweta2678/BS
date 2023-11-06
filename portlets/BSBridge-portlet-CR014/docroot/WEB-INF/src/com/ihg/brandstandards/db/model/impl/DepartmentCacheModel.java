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

import com.ihg.brandstandards.db.model.Department;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Department in entity cache.
 *
 * @author Mummanedi
 * @see Department
 * @generated
 */
public class DepartmentCacheModel implements CacheModel<Department>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{departmentId=");
		sb.append(departmentId);
		sb.append(", departmentName=");
		sb.append(departmentName);
		sb.append(", description=");
		sb.append(description);
		sb.append(", activeInd=");
		sb.append(activeInd);
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
	public Department toEntityModel() {
		DepartmentImpl departmentImpl = new DepartmentImpl();

		departmentImpl.setDepartmentId(departmentId);

		if (departmentName == null) {
			departmentImpl.setDepartmentName(StringPool.BLANK);
		}
		else {
			departmentImpl.setDepartmentName(departmentName);
		}

		if (description == null) {
			departmentImpl.setDescription(StringPool.BLANK);
		}
		else {
			departmentImpl.setDescription(description);
		}

		if (activeInd == null) {
			departmentImpl.setActiveInd(StringPool.BLANK);
		}
		else {
			departmentImpl.setActiveInd(activeInd);
		}

		if (creatorId == null) {
			departmentImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			departmentImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			departmentImpl.setCreatedDate(null);
		}
		else {
			departmentImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			departmentImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			departmentImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			departmentImpl.setUpdatedDate(null);
		}
		else {
			departmentImpl.setUpdatedDate(new Date(updatedDate));
		}

		departmentImpl.resetOriginalValues();

		return departmentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		departmentId = objectInput.readLong();
		departmentName = objectInput.readUTF();
		description = objectInput.readUTF();
		activeInd = objectInput.readUTF();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(departmentId);

		if (departmentName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(departmentName);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (activeInd == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(activeInd);
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

	public long departmentId;
	public String departmentName;
	public String description;
	public String activeInd;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}