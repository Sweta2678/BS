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

import com.ihg.brandstandards.db.model.GEMChainMeasurement;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing GEMChainMeasurement in entity cache.
 *
 * @author Mummanedi
 * @see GEMChainMeasurement
 * @generated
 */
public class GEMChainMeasurementCacheModel implements CacheModel<GEMChainMeasurement>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{chainMeasurementId=");
		sb.append(chainMeasurementId);
		sb.append(", measurementId=");
		sb.append(measurementId);
		sb.append(", publishDeptId=");
		sb.append(publishDeptId);
		sb.append(", publishId=");
		sb.append(publishId);
		sb.append(", regionId=");
		sb.append(regionId);
		sb.append(", uniqueGroupId=");
		sb.append(uniqueGroupId);
		sb.append(", measurementItemCount=");
		sb.append(measurementItemCount);
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
	public GEMChainMeasurement toEntityModel() {
		GEMChainMeasurementImpl gemChainMeasurementImpl = new GEMChainMeasurementImpl();

		gemChainMeasurementImpl.setChainMeasurementId(chainMeasurementId);
		gemChainMeasurementImpl.setMeasurementId(measurementId);
		gemChainMeasurementImpl.setPublishDeptId(publishDeptId);
		gemChainMeasurementImpl.setPublishId(publishId);
		gemChainMeasurementImpl.setRegionId(regionId);
		gemChainMeasurementImpl.setUniqueGroupId(uniqueGroupId);
		gemChainMeasurementImpl.setMeasurementItemCount(measurementItemCount);

		if (creatorId == null) {
			gemChainMeasurementImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			gemChainMeasurementImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			gemChainMeasurementImpl.setCreatedDate(null);
		}
		else {
			gemChainMeasurementImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			gemChainMeasurementImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			gemChainMeasurementImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			gemChainMeasurementImpl.setUpdatedDate(null);
		}
		else {
			gemChainMeasurementImpl.setUpdatedDate(new Date(updatedDate));
		}

		gemChainMeasurementImpl.resetOriginalValues();

		return gemChainMeasurementImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		chainMeasurementId = objectInput.readLong();
		measurementId = objectInput.readLong();
		publishDeptId = objectInput.readLong();
		publishId = objectInput.readLong();
		regionId = objectInput.readLong();
		uniqueGroupId = objectInput.readLong();
		measurementItemCount = objectInput.readLong();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(chainMeasurementId);
		objectOutput.writeLong(measurementId);
		objectOutput.writeLong(publishDeptId);
		objectOutput.writeLong(publishId);
		objectOutput.writeLong(regionId);
		objectOutput.writeLong(uniqueGroupId);
		objectOutput.writeLong(measurementItemCount);

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

	public long chainMeasurementId;
	public long measurementId;
	public long publishDeptId;
	public long publishId;
	public long regionId;
	public long uniqueGroupId;
	public long measurementItemCount;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}