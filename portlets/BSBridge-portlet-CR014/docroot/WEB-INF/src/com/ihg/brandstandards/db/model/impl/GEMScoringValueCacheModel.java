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

import com.ihg.brandstandards.db.model.GEMScoringValue;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing GEMScoringValue in entity cache.
 *
 * @author Mummanedi
 * @see GEMScoringValue
 * @generated
 */
public class GEMScoringValueCacheModel implements CacheModel<GEMScoringValue>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{scoringId=");
		sb.append(scoringId);
		sb.append(", measurementBucketChainId=");
		sb.append(measurementBucketChainId);
		sb.append(", totalMeasurement=");
		sb.append(totalMeasurement);
		sb.append(", netMeasurement=");
		sb.append(netMeasurement);
		sb.append(", nonCompliantMeasurement=");
		sb.append(nonCompliantMeasurement);
		sb.append(", nonCompliantMeasurementPercent=");
		sb.append(nonCompliantMeasurementPercent);
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
	public GEMScoringValue toEntityModel() {
		GEMScoringValueImpl gemScoringValueImpl = new GEMScoringValueImpl();

		gemScoringValueImpl.setScoringId(scoringId);
		gemScoringValueImpl.setMeasurementBucketChainId(measurementBucketChainId);
		gemScoringValueImpl.setTotalMeasurement(totalMeasurement);
		gemScoringValueImpl.setNetMeasurement(netMeasurement);
		gemScoringValueImpl.setNonCompliantMeasurement(nonCompliantMeasurement);
		gemScoringValueImpl.setNonCompliantMeasurementPercent(nonCompliantMeasurementPercent);

		if (creatorId == null) {
			gemScoringValueImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			gemScoringValueImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			gemScoringValueImpl.setCreatedDate(null);
		}
		else {
			gemScoringValueImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			gemScoringValueImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			gemScoringValueImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			gemScoringValueImpl.setUpdatedDate(null);
		}
		else {
			gemScoringValueImpl.setUpdatedDate(new Date(updatedDate));
		}

		gemScoringValueImpl.resetOriginalValues();

		return gemScoringValueImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		scoringId = objectInput.readLong();
		measurementBucketChainId = objectInput.readLong();
		totalMeasurement = objectInput.readLong();
		netMeasurement = objectInput.readLong();
		nonCompliantMeasurement = objectInput.readLong();
		nonCompliantMeasurementPercent = objectInput.readLong();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(scoringId);
		objectOutput.writeLong(measurementBucketChainId);
		objectOutput.writeLong(totalMeasurement);
		objectOutput.writeLong(netMeasurement);
		objectOutput.writeLong(nonCompliantMeasurement);
		objectOutput.writeLong(nonCompliantMeasurementPercent);

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

	public long scoringId;
	public long measurementBucketChainId;
	public long totalMeasurement;
	public long netMeasurement;
	public long nonCompliantMeasurement;
	public long nonCompliantMeasurementPercent;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}