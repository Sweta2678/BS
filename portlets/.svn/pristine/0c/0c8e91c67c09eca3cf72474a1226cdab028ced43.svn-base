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

import com.ihg.brandstandards.db.model.UniqueGroupCountry;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing UniqueGroupCountry in entity cache.
 *
 * @author Mummanedi
 * @see UniqueGroupCountry
 * @generated
 */
public class UniqueGroupCountryCacheModel implements CacheModel<UniqueGroupCountry>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{groupCountryId=");
		sb.append(groupCountryId);
		sb.append(", uniqueGroupId=");
		sb.append(uniqueGroupId);
		sb.append(", countryCode=");
		sb.append(countryCode);
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
	public UniqueGroupCountry toEntityModel() {
		UniqueGroupCountryImpl uniqueGroupCountryImpl = new UniqueGroupCountryImpl();

		uniqueGroupCountryImpl.setGroupCountryId(groupCountryId);
		uniqueGroupCountryImpl.setUniqueGroupId(uniqueGroupId);

		if (countryCode == null) {
			uniqueGroupCountryImpl.setCountryCode(StringPool.BLANK);
		}
		else {
			uniqueGroupCountryImpl.setCountryCode(countryCode);
		}

		if (creatorId == null) {
			uniqueGroupCountryImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			uniqueGroupCountryImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			uniqueGroupCountryImpl.setCreatedDate(null);
		}
		else {
			uniqueGroupCountryImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			uniqueGroupCountryImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			uniqueGroupCountryImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			uniqueGroupCountryImpl.setUpdatedDate(null);
		}
		else {
			uniqueGroupCountryImpl.setUpdatedDate(new Date(updatedDate));
		}

		uniqueGroupCountryImpl.resetOriginalValues();

		return uniqueGroupCountryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		groupCountryId = objectInput.readLong();
		uniqueGroupId = objectInput.readLong();
		countryCode = objectInput.readUTF();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(groupCountryId);
		objectOutput.writeLong(uniqueGroupId);

		if (countryCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(countryCode);
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

	public long groupCountryId;
	public long uniqueGroupId;
	public String countryCode;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}