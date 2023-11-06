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

import com.ihg.brandstandards.db.model.GEMMeasurementBucketChain;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing GEMMeasurementBucketChain in entity cache.
 *
 * @author Mummanedi
 * @see GEMMeasurementBucketChain
 * @generated
 */
public class GEMMeasurementBucketChainCacheModel implements CacheModel<GEMMeasurementBucketChain>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{measurementBucketChainId=");
		sb.append(measurementBucketChainId);
		sb.append(", bucketId=");
		sb.append(bucketId);
		sb.append(", severityId=");
		sb.append(severityId);
		sb.append(", measurementId=");
		sb.append(measurementId);
		sb.append(", publishDeptId=");
		sb.append(publishDeptId);
		sb.append(", publishId=");
		sb.append(publishId);
		sb.append(", regionId=");
		sb.append(regionId);
		sb.append(", subRegionCd=");
		sb.append(subRegionCd);
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
	public GEMMeasurementBucketChain toEntityModel() {
		GEMMeasurementBucketChainImpl gemMeasurementBucketChainImpl = new GEMMeasurementBucketChainImpl();

		gemMeasurementBucketChainImpl.setMeasurementBucketChainId(measurementBucketChainId);
		gemMeasurementBucketChainImpl.setBucketId(bucketId);
		gemMeasurementBucketChainImpl.setSeverityId(severityId);
		gemMeasurementBucketChainImpl.setMeasurementId(measurementId);
		gemMeasurementBucketChainImpl.setPublishDeptId(publishDeptId);
		gemMeasurementBucketChainImpl.setPublishId(publishId);
		gemMeasurementBucketChainImpl.setRegionId(regionId);

		if (subRegionCd == null) {
			gemMeasurementBucketChainImpl.setSubRegionCd(StringPool.BLANK);
		}
		else {
			gemMeasurementBucketChainImpl.setSubRegionCd(subRegionCd);
		}

		if (creatorId == null) {
			gemMeasurementBucketChainImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			gemMeasurementBucketChainImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			gemMeasurementBucketChainImpl.setCreatedDate(null);
		}
		else {
			gemMeasurementBucketChainImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			gemMeasurementBucketChainImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			gemMeasurementBucketChainImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			gemMeasurementBucketChainImpl.setUpdatedDate(null);
		}
		else {
			gemMeasurementBucketChainImpl.setUpdatedDate(new Date(updatedDate));
		}

		gemMeasurementBucketChainImpl.resetOriginalValues();

		return gemMeasurementBucketChainImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		measurementBucketChainId = objectInput.readLong();
		bucketId = objectInput.readLong();
		severityId = objectInput.readLong();
		measurementId = objectInput.readLong();
		publishDeptId = objectInput.readLong();
		publishId = objectInput.readLong();
		regionId = objectInput.readLong();
		subRegionCd = objectInput.readUTF();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(measurementBucketChainId);
		objectOutput.writeLong(bucketId);
		objectOutput.writeLong(severityId);
		objectOutput.writeLong(measurementId);
		objectOutput.writeLong(publishDeptId);
		objectOutput.writeLong(publishId);
		objectOutput.writeLong(regionId);

		if (subRegionCd == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(subRegionCd);
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

	public long measurementBucketChainId;
	public long bucketId;
	public long severityId;
	public long measurementId;
	public long publishDeptId;
	public long publishId;
	public long regionId;
	public String subRegionCd;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}