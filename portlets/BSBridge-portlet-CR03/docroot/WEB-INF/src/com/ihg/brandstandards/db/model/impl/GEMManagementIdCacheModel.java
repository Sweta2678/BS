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

import com.ihg.brandstandards.db.model.GEMManagementId;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing GEMManagementId in entity cache.
 *
 * @author Mummanedi
 * @see GEMManagementId
 * @generated
 */
public class GEMManagementIdCacheModel implements CacheModel<GEMManagementId>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{managementId=");
		sb.append(managementId);
		sb.append(", chainCode=");
		sb.append(chainCode);
		sb.append(", countryCode=");
		sb.append(countryCode);
		sb.append(", value=");
		sb.append(value);
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
	public GEMManagementId toEntityModel() {
		GEMManagementIdImpl gemManagementIdImpl = new GEMManagementIdImpl();

		gemManagementIdImpl.setManagementId(managementId);

		if (chainCode == null) {
			gemManagementIdImpl.setChainCode(StringPool.BLANK);
		}
		else {
			gemManagementIdImpl.setChainCode(chainCode);
		}

		if (countryCode == null) {
			gemManagementIdImpl.setCountryCode(StringPool.BLANK);
		}
		else {
			gemManagementIdImpl.setCountryCode(countryCode);
		}

		if (value == null) {
			gemManagementIdImpl.setValue(StringPool.BLANK);
		}
		else {
			gemManagementIdImpl.setValue(value);
		}

		if (creatorId == null) {
			gemManagementIdImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			gemManagementIdImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			gemManagementIdImpl.setCreatedDate(null);
		}
		else {
			gemManagementIdImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			gemManagementIdImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			gemManagementIdImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			gemManagementIdImpl.setUpdatedDate(null);
		}
		else {
			gemManagementIdImpl.setUpdatedDate(new Date(updatedDate));
		}

		gemManagementIdImpl.resetOriginalValues();

		return gemManagementIdImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		managementId = objectInput.readLong();
		chainCode = objectInput.readUTF();
		countryCode = objectInput.readUTF();
		value = objectInput.readUTF();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(managementId);

		if (chainCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(chainCode);
		}

		if (countryCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(countryCode);
		}

		if (value == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(value);
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

	public long managementId;
	public String chainCode;
	public String countryCode;
	public String value;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}