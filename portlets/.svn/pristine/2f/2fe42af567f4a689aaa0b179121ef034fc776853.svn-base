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

import com.ihg.brandstandards.db.model.StandardsCountry;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing StandardsCountry in entity cache.
 *
 * @author Mummanedi
 * @see StandardsCountry
 * @generated
 */
public class StandardsCountryCacheModel implements CacheModel<StandardsCountry>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{countryNameCode=");
		sb.append(countryNameCode);
		sb.append(", regionId=");
		sb.append(regionId);
		sb.append(", creatorId=");
		sb.append(creatorId);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", updatedBy=");
		sb.append(updatedBy);
		sb.append(", updatedDate=");
		sb.append(updatedDate);
		sb.append(", subRegionId=");
		sb.append(subRegionId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public StandardsCountry toEntityModel() {
		StandardsCountryImpl standardsCountryImpl = new StandardsCountryImpl();

		if (countryNameCode == null) {
			standardsCountryImpl.setCountryNameCode(StringPool.BLANK);
		}
		else {
			standardsCountryImpl.setCountryNameCode(countryNameCode);
		}

		standardsCountryImpl.setRegionId(regionId);

		if (creatorId == null) {
			standardsCountryImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			standardsCountryImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			standardsCountryImpl.setCreatedDate(null);
		}
		else {
			standardsCountryImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			standardsCountryImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			standardsCountryImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			standardsCountryImpl.setUpdatedDate(null);
		}
		else {
			standardsCountryImpl.setUpdatedDate(new Date(updatedDate));
		}

		standardsCountryImpl.setSubRegionId(subRegionId);

		standardsCountryImpl.resetOriginalValues();

		return standardsCountryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		countryNameCode = objectInput.readUTF();
		regionId = objectInput.readLong();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
		subRegionId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (countryNameCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(countryNameCode);
		}

		objectOutput.writeLong(regionId);

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
		objectOutput.writeLong(subRegionId);
	}

	public String countryNameCode;
	public long regionId;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
	public long subRegionId;
}