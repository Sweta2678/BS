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

import com.ihg.brandstandards.db.model.GEMMeasurementType;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing GEMMeasurementType in entity cache.
 *
 * @author Mummanedi
 * @see GEMMeasurementType
 * @generated
 */
public class GEMMeasurementTypeCacheModel implements CacheModel<GEMMeasurementType>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{measurementType=");
		sb.append(measurementType);
		sb.append(", measurementTypeDesc=");
		sb.append(measurementTypeDesc);
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
	public GEMMeasurementType toEntityModel() {
		GEMMeasurementTypeImpl gemMeasurementTypeImpl = new GEMMeasurementTypeImpl();

		if (measurementType == null) {
			gemMeasurementTypeImpl.setMeasurementType(StringPool.BLANK);
		}
		else {
			gemMeasurementTypeImpl.setMeasurementType(measurementType);
		}

		if (measurementTypeDesc == null) {
			gemMeasurementTypeImpl.setMeasurementTypeDesc(StringPool.BLANK);
		}
		else {
			gemMeasurementTypeImpl.setMeasurementTypeDesc(measurementTypeDesc);
		}

		if (creatorId == null) {
			gemMeasurementTypeImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			gemMeasurementTypeImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			gemMeasurementTypeImpl.setCreatedDate(null);
		}
		else {
			gemMeasurementTypeImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			gemMeasurementTypeImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			gemMeasurementTypeImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			gemMeasurementTypeImpl.setUpdatedDate(null);
		}
		else {
			gemMeasurementTypeImpl.setUpdatedDate(new Date(updatedDate));
		}

		gemMeasurementTypeImpl.resetOriginalValues();

		return gemMeasurementTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		measurementType = objectInput.readUTF();
		measurementTypeDesc = objectInput.readUTF();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (measurementType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(measurementType);
		}

		if (measurementTypeDesc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(measurementTypeDesc);
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

	public String measurementType;
	public String measurementTypeDesc;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}