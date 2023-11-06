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

import com.ihg.brandstandards.db.model.StandardsRegion;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing StandardsRegion in entity cache.
 *
 * @author Mummanedi
 * @see StandardsRegion
 * @generated
 */
public class StandardsRegionCacheModel implements CacheModel<StandardsRegion>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{regionId=");
		sb.append(regionId);
		sb.append(", regionCode=");
		sb.append(regionCode);
		sb.append(", regionType=");
		sb.append(regionType);
		sb.append(", regionName=");
		sb.append(regionName);
		sb.append(", isActive=");
		sb.append(isActive);
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
	public StandardsRegion toEntityModel() {
		StandardsRegionImpl standardsRegionImpl = new StandardsRegionImpl();

		standardsRegionImpl.setRegionId(regionId);

		if (regionCode == null) {
			standardsRegionImpl.setRegionCode(StringPool.BLANK);
		}
		else {
			standardsRegionImpl.setRegionCode(regionCode);
		}

		if (regionType == null) {
			standardsRegionImpl.setRegionType(StringPool.BLANK);
		}
		else {
			standardsRegionImpl.setRegionType(regionType);
		}

		if (regionName == null) {
			standardsRegionImpl.setRegionName(StringPool.BLANK);
		}
		else {
			standardsRegionImpl.setRegionName(regionName);
		}

		if (isActive == null) {
			standardsRegionImpl.setIsActive(StringPool.BLANK);
		}
		else {
			standardsRegionImpl.setIsActive(isActive);
		}

		if (creatorId == null) {
			standardsRegionImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			standardsRegionImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			standardsRegionImpl.setCreatedDate(null);
		}
		else {
			standardsRegionImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			standardsRegionImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			standardsRegionImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			standardsRegionImpl.setUpdatedDate(null);
		}
		else {
			standardsRegionImpl.setUpdatedDate(new Date(updatedDate));
		}

		standardsRegionImpl.resetOriginalValues();

		return standardsRegionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		regionId = objectInput.readLong();
		regionCode = objectInput.readUTF();
		regionType = objectInput.readUTF();
		regionName = objectInput.readUTF();
		isActive = objectInput.readUTF();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(regionId);

		if (regionCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(regionCode);
		}

		if (regionType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(regionType);
		}

		if (regionName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(regionName);
		}

		if (isActive == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(isActive);
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
	public String regionCode;
	public String regionType;
	public String regionName;
	public String isActive;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}