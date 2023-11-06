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

import com.ihg.brandstandards.db.model.PublishParm;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PublishParm in entity cache.
 *
 * @author Mummanedi
 * @see PublishParm
 * @generated
 */
public class PublishParmCacheModel implements CacheModel<PublishParm>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{publishParmId=");
		sb.append(publishParmId);
		sb.append(", publishId=");
		sb.append(publishId);
		sb.append(", parmName=");
		sb.append(parmName);
		sb.append(", parmValue=");
		sb.append(parmValue);
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
	public PublishParm toEntityModel() {
		PublishParmImpl publishParmImpl = new PublishParmImpl();

		publishParmImpl.setPublishParmId(publishParmId);
		publishParmImpl.setPublishId(publishId);

		if (parmName == null) {
			publishParmImpl.setParmName(StringPool.BLANK);
		}
		else {
			publishParmImpl.setParmName(parmName);
		}

		if (parmValue == null) {
			publishParmImpl.setParmValue(StringPool.BLANK);
		}
		else {
			publishParmImpl.setParmValue(parmValue);
		}

		if (creatorId == null) {
			publishParmImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			publishParmImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			publishParmImpl.setCreatedDate(null);
		}
		else {
			publishParmImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			publishParmImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			publishParmImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			publishParmImpl.setUpdatedDate(null);
		}
		else {
			publishParmImpl.setUpdatedDate(new Date(updatedDate));
		}

		publishParmImpl.resetOriginalValues();

		return publishParmImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		publishParmId = objectInput.readLong();
		publishId = objectInput.readLong();
		parmName = objectInput.readUTF();
		parmValue = objectInput.readUTF();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(publishParmId);
		objectOutput.writeLong(publishId);

		if (parmName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(parmName);
		}

		if (parmValue == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(parmValue);
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

	public long publishParmId;
	public long publishId;
	public String parmName;
	public String parmValue;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}