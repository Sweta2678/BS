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

import com.ihg.brandstandards.db.model.GEMMeasurement;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing GEMMeasurement in entity cache.
 *
 * @author Mummanedi
 * @see GEMMeasurement
 * @generated
 */
public class GEMMeasurementCacheModel implements CacheModel<GEMMeasurement>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{measurementId=");
		sb.append(measurementId);
		sb.append(", measurementName=");
		sb.append(measurementName);
		sb.append(", measurementType=");
		sb.append(measurementType);
		sb.append(", displayOrderNumber=");
		sb.append(displayOrderNumber);
		sb.append(", templateId=");
		sb.append(templateId);
		sb.append(", multiplierQty=");
		sb.append(multiplierQty);
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
	public GEMMeasurement toEntityModel() {
		GEMMeasurementImpl gemMeasurementImpl = new GEMMeasurementImpl();

		gemMeasurementImpl.setMeasurementId(measurementId);

		if (measurementName == null) {
			gemMeasurementImpl.setMeasurementName(StringPool.BLANK);
		}
		else {
			gemMeasurementImpl.setMeasurementName(measurementName);
		}

		if (measurementType == null) {
			gemMeasurementImpl.setMeasurementType(StringPool.BLANK);
		}
		else {
			gemMeasurementImpl.setMeasurementType(measurementType);
		}

		gemMeasurementImpl.setDisplayOrderNumber(displayOrderNumber);
		gemMeasurementImpl.setTemplateId(templateId);
		gemMeasurementImpl.setMultiplierQty(multiplierQty);

		if (creatorId == null) {
			gemMeasurementImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			gemMeasurementImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			gemMeasurementImpl.setCreatedDate(null);
		}
		else {
			gemMeasurementImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			gemMeasurementImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			gemMeasurementImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			gemMeasurementImpl.setUpdatedDate(null);
		}
		else {
			gemMeasurementImpl.setUpdatedDate(new Date(updatedDate));
		}

		gemMeasurementImpl.resetOriginalValues();

		return gemMeasurementImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		measurementId = objectInput.readLong();
		measurementName = objectInput.readUTF();
		measurementType = objectInput.readUTF();
		displayOrderNumber = objectInput.readLong();
		templateId = objectInput.readLong();
		multiplierQty = objectInput.readLong();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(measurementId);

		if (measurementName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(measurementName);
		}

		if (measurementType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(measurementType);
		}

		objectOutput.writeLong(displayOrderNumber);
		objectOutput.writeLong(templateId);
		objectOutput.writeLong(multiplierQty);

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

	public long measurementId;
	public String measurementName;
	public String measurementType;
	public long displayOrderNumber;
	public long templateId;
	public long multiplierQty;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}