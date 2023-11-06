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

import com.ihg.brandstandards.db.model.ChainStandards;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ChainStandards in entity cache.
 *
 * @author Mummanedi
 * @see ChainStandards
 * @generated
 */
public class ChainStandardsCacheModel implements CacheModel<ChainStandards>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{chainCode=");
		sb.append(chainCode);
		sb.append(", stdId=");
		sb.append(stdId);
		sb.append(", statusId=");
		sb.append(statusId);
		sb.append(", isActive=");
		sb.append(isActive);
		sb.append(", lastPublishedDate=");
		sb.append(lastPublishedDate);
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
	public ChainStandards toEntityModel() {
		ChainStandardsImpl chainStandardsImpl = new ChainStandardsImpl();

		if (chainCode == null) {
			chainStandardsImpl.setChainCode(StringPool.BLANK);
		}
		else {
			chainStandardsImpl.setChainCode(chainCode);
		}

		chainStandardsImpl.setStdId(stdId);
		chainStandardsImpl.setStatusId(statusId);

		if (isActive == null) {
			chainStandardsImpl.setIsActive(StringPool.BLANK);
		}
		else {
			chainStandardsImpl.setIsActive(isActive);
		}

		if (lastPublishedDate == Long.MIN_VALUE) {
			chainStandardsImpl.setLastPublishedDate(null);
		}
		else {
			chainStandardsImpl.setLastPublishedDate(new Date(lastPublishedDate));
		}

		if (creatorId == null) {
			chainStandardsImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			chainStandardsImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			chainStandardsImpl.setCreatedDate(null);
		}
		else {
			chainStandardsImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			chainStandardsImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			chainStandardsImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			chainStandardsImpl.setUpdatedDate(null);
		}
		else {
			chainStandardsImpl.setUpdatedDate(new Date(updatedDate));
		}

		chainStandardsImpl.resetOriginalValues();

		return chainStandardsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		chainCode = objectInput.readUTF();
		stdId = objectInput.readLong();
		statusId = objectInput.readLong();
		isActive = objectInput.readUTF();
		lastPublishedDate = objectInput.readLong();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (chainCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(chainCode);
		}

		objectOutput.writeLong(stdId);
		objectOutput.writeLong(statusId);

		if (isActive == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(isActive);
		}

		objectOutput.writeLong(lastPublishedDate);

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

	public String chainCode;
	public long stdId;
	public long statusId;
	public String isActive;
	public long lastPublishedDate;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}