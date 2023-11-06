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

import com.ihg.brandstandards.db.model.ExternalLinkStandardsCountry;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ExternalLinkStandardsCountry in entity cache.
 *
 * @author Mummanedi
 * @see ExternalLinkStandardsCountry
 * @generated
 */
public class ExternalLinkStandardsCountryCacheModel implements CacheModel<ExternalLinkStandardsCountry>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{extLinkId=");
		sb.append(extLinkId);
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
	public ExternalLinkStandardsCountry toEntityModel() {
		ExternalLinkStandardsCountryImpl externalLinkStandardsCountryImpl = new ExternalLinkStandardsCountryImpl();

		externalLinkStandardsCountryImpl.setExtLinkId(extLinkId);

		if (countryCode == null) {
			externalLinkStandardsCountryImpl.setCountryCode(StringPool.BLANK);
		}
		else {
			externalLinkStandardsCountryImpl.setCountryCode(countryCode);
		}

		if (creatorId == null) {
			externalLinkStandardsCountryImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			externalLinkStandardsCountryImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			externalLinkStandardsCountryImpl.setCreatedDate(null);
		}
		else {
			externalLinkStandardsCountryImpl.setCreatedDate(new Date(
					createdDate));
		}

		if (updatedBy == null) {
			externalLinkStandardsCountryImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			externalLinkStandardsCountryImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			externalLinkStandardsCountryImpl.setUpdatedDate(null);
		}
		else {
			externalLinkStandardsCountryImpl.setUpdatedDate(new Date(
					updatedDate));
		}

		externalLinkStandardsCountryImpl.resetOriginalValues();

		return externalLinkStandardsCountryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		extLinkId = objectInput.readLong();
		countryCode = objectInput.readUTF();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(extLinkId);

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

	public long extLinkId;
	public String countryCode;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}