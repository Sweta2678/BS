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

import com.ihg.brandstandards.db.model.GEMTrigger;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing GEMTrigger in entity cache.
 *
 * @author Mummanedi
 * @see GEMTrigger
 * @generated
 */
public class GEMTriggerCacheModel implements CacheModel<GEMTrigger>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{triggerId=");
		sb.append(triggerId);
		sb.append(", publishDeptId=");
		sb.append(publishDeptId);
		sb.append(", publishId=");
		sb.append(publishId);
		sb.append(", question=");
		sb.append(question);
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
	public GEMTrigger toEntityModel() {
		GEMTriggerImpl gemTriggerImpl = new GEMTriggerImpl();

		gemTriggerImpl.setTriggerId(triggerId);
		gemTriggerImpl.setPublishDeptId(publishDeptId);
		gemTriggerImpl.setPublishId(publishId);

		if (question == null) {
			gemTriggerImpl.setQuestion(StringPool.BLANK);
		}
		else {
			gemTriggerImpl.setQuestion(question);
		}

		if (creatorId == null) {
			gemTriggerImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			gemTriggerImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			gemTriggerImpl.setCreatedDate(null);
		}
		else {
			gemTriggerImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			gemTriggerImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			gemTriggerImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			gemTriggerImpl.setUpdatedDate(null);
		}
		else {
			gemTriggerImpl.setUpdatedDate(new Date(updatedDate));
		}

		gemTriggerImpl.resetOriginalValues();

		return gemTriggerImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		triggerId = objectInput.readLong();
		publishDeptId = objectInput.readLong();
		publishId = objectInput.readLong();
		question = objectInput.readUTF();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(triggerId);
		objectOutput.writeLong(publishDeptId);
		objectOutput.writeLong(publishId);

		if (question == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(question);
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

	public long triggerId;
	public long publishDeptId;
	public long publishId;
	public String question;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}