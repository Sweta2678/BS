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

import com.ihg.brandstandards.db.model.GEMUniqueGroupCountry;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing GEMUniqueGroupCountry in entity cache.
 *
 * @author Mummanedi
 * @see GEMUniqueGroupCountry
 * @generated
 */
public class GEMUniqueGroupCountryCacheModel implements CacheModel<GEMUniqueGroupCountry>,
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
	public GEMUniqueGroupCountry toEntityModel() {
		GEMUniqueGroupCountryImpl gemUniqueGroupCountryImpl = new GEMUniqueGroupCountryImpl();

		gemUniqueGroupCountryImpl.setGroupCountryId(groupCountryId);
		gemUniqueGroupCountryImpl.setUniqueGroupId(uniqueGroupId);

		if (countryCode == null) {
			gemUniqueGroupCountryImpl.setCountryCode(StringPool.BLANK);
		}
		else {
			gemUniqueGroupCountryImpl.setCountryCode(countryCode);
		}

		if (creatorId == null) {
			gemUniqueGroupCountryImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			gemUniqueGroupCountryImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			gemUniqueGroupCountryImpl.setCreatedDate(null);
		}
		else {
			gemUniqueGroupCountryImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			gemUniqueGroupCountryImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			gemUniqueGroupCountryImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			gemUniqueGroupCountryImpl.setUpdatedDate(null);
		}
		else {
			gemUniqueGroupCountryImpl.setUpdatedDate(new Date(updatedDate));
		}

		gemUniqueGroupCountryImpl.resetOriginalValues();

		return gemUniqueGroupCountryImpl;
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