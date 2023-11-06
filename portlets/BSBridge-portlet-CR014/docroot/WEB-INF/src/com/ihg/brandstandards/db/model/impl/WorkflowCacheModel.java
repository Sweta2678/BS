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

import com.ihg.brandstandards.db.model.Workflow;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Workflow in entity cache.
 *
 * @author Mummanedi
 * @see Workflow
 * @generated
 */
public class WorkflowCacheModel implements CacheModel<Workflow>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{workflowActvtId=");
		sb.append(workflowActvtId);
		sb.append(", objectId=");
		sb.append(objectId);
		sb.append(", objectType=");
		sb.append(objectType);
		sb.append(", status=");
		sb.append(status);
		sb.append(", prevStatus=");
		sb.append(prevStatus);
		sb.append(", title=");
		sb.append(title);
		sb.append(", comment=");
		sb.append(comment);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", chainCode=");
		sb.append(chainCode);
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
	public Workflow toEntityModel() {
		WorkflowImpl workflowImpl = new WorkflowImpl();

		workflowImpl.setWorkflowActvtId(workflowActvtId);
		workflowImpl.setObjectId(objectId);

		if (objectType == null) {
			workflowImpl.setObjectType(StringPool.BLANK);
		}
		else {
			workflowImpl.setObjectType(objectType);
		}

		if (status == null) {
			workflowImpl.setStatus(StringPool.BLANK);
		}
		else {
			workflowImpl.setStatus(status);
		}

		if (prevStatus == null) {
			workflowImpl.setPrevStatus(StringPool.BLANK);
		}
		else {
			workflowImpl.setPrevStatus(prevStatus);
		}

		if (title == null) {
			workflowImpl.setTitle(StringPool.BLANK);
		}
		else {
			workflowImpl.setTitle(title);
		}

		if (comment == null) {
			workflowImpl.setComment(StringPool.BLANK);
		}
		else {
			workflowImpl.setComment(comment);
		}

		if (createdBy == null) {
			workflowImpl.setCreatedBy(StringPool.BLANK);
		}
		else {
			workflowImpl.setCreatedBy(createdBy);
		}

		if (chainCode == null) {
			workflowImpl.setChainCode(StringPool.BLANK);
		}
		else {
			workflowImpl.setChainCode(chainCode);
		}

		if (creatorId == null) {
			workflowImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			workflowImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			workflowImpl.setCreatedDate(null);
		}
		else {
			workflowImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			workflowImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			workflowImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			workflowImpl.setUpdatedDate(null);
		}
		else {
			workflowImpl.setUpdatedDate(new Date(updatedDate));
		}

		workflowImpl.resetOriginalValues();

		return workflowImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		workflowActvtId = objectInput.readLong();
		objectId = objectInput.readLong();
		objectType = objectInput.readUTF();
		status = objectInput.readUTF();
		prevStatus = objectInput.readUTF();
		title = objectInput.readUTF();
		comment = objectInput.readUTF();
		createdBy = objectInput.readUTF();
		chainCode = objectInput.readUTF();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(workflowActvtId);
		objectOutput.writeLong(objectId);

		if (objectType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(objectType);
		}

		if (status == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(status);
		}

		if (prevStatus == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(prevStatus);
		}

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (comment == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(comment);
		}

		if (createdBy == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(createdBy);
		}

		if (chainCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(chainCode);
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

	public long workflowActvtId;
	public long objectId;
	public String objectType;
	public String status;
	public String prevStatus;
	public String title;
	public String comment;
	public String createdBy;
	public String chainCode;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}