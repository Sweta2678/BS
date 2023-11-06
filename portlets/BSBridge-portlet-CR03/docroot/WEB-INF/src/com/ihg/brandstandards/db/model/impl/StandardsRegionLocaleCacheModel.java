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

import com.ihg.brandstandards.db.model.StandardsRegionLocale;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing StandardsRegionLocale in entity cache.
 *
 * @author Mummanedi
 * @see StandardsRegionLocale
 * @generated
 */
public class StandardsRegionLocaleCacheModel implements CacheModel<StandardsRegionLocale>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{regionId=");
		sb.append(regionId);
		sb.append(", localeCode=");
		sb.append(localeCode);
		sb.append(", isDefault=");
		sb.append(isDefault);
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
	public StandardsRegionLocale toEntityModel() {
		StandardsRegionLocaleImpl standardsRegionLocaleImpl = new StandardsRegionLocaleImpl();

		standardsRegionLocaleImpl.setRegionId(regionId);

		if (localeCode == null) {
			standardsRegionLocaleImpl.setLocaleCode(StringPool.BLANK);
		}
		else {
			standardsRegionLocaleImpl.setLocaleCode(localeCode);
		}

		if (isDefault == null) {
			standardsRegionLocaleImpl.setIsDefault(StringPool.BLANK);
		}
		else {
			standardsRegionLocaleImpl.setIsDefault(isDefault);
		}

		if (creatorId == null) {
			standardsRegionLocaleImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			standardsRegionLocaleImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			standardsRegionLocaleImpl.setCreatedDate(null);
		}
		else {
			standardsRegionLocaleImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			standardsRegionLocaleImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			standardsRegionLocaleImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			standardsRegionLocaleImpl.setUpdatedDate(null);
		}
		else {
			standardsRegionLocaleImpl.setUpdatedDate(new Date(updatedDate));
		}

		standardsRegionLocaleImpl.resetOriginalValues();

		return standardsRegionLocaleImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		regionId = objectInput.readLong();
		localeCode = objectInput.readUTF();
		isDefault = objectInput.readUTF();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(regionId);

		if (localeCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(localeCode);
		}

		if (isDefault == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(isDefault);
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

	public long regionId;
	public String localeCode;
	public String isDefault;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}