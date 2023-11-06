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

import com.ihg.brandstandards.db.model.StandardsCountryImages;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing StandardsCountryImages in entity cache.
 *
 * @author Mummanedi
 * @see StandardsCountryImages
 * @generated
 */
public class StandardsCountryImagesCacheModel implements CacheModel<StandardsCountryImages>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{stdImageId=");
		sb.append(stdImageId);
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
	public StandardsCountryImages toEntityModel() {
		StandardsCountryImagesImpl standardsCountryImagesImpl = new StandardsCountryImagesImpl();

		standardsCountryImagesImpl.setStdImageId(stdImageId);

		if (countryCode == null) {
			standardsCountryImagesImpl.setCountryCode(StringPool.BLANK);
		}
		else {
			standardsCountryImagesImpl.setCountryCode(countryCode);
		}

		if (creatorId == null) {
			standardsCountryImagesImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			standardsCountryImagesImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			standardsCountryImagesImpl.setCreatedDate(null);
		}
		else {
			standardsCountryImagesImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			standardsCountryImagesImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			standardsCountryImagesImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			standardsCountryImagesImpl.setUpdatedDate(null);
		}
		else {
			standardsCountryImagesImpl.setUpdatedDate(new Date(updatedDate));
		}

		standardsCountryImagesImpl.resetOriginalValues();

		return standardsCountryImagesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		stdImageId = objectInput.readLong();
		countryCode = objectInput.readUTF();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(stdImageId);

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

	public long stdImageId;
	public String countryCode;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}