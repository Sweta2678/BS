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

import com.ihg.brandstandards.db.model.GEMQlReport;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing GEMQlReport in entity cache.
 *
 * @author Mummanedi
 * @see GEMQlReport
 * @generated
 */
public class GEMQlReportCacheModel implements CacheModel<GEMQlReport>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{qlReportId=");
		sb.append(qlReportId);
		sb.append(", publishDeptId=");
		sb.append(publishDeptId);
		sb.append(", publishId=");
		sb.append(publishId);
		sb.append(", stdId=");
		sb.append(stdId);
		sb.append(", bucketId=");
		sb.append(bucketId);
		sb.append(", severityId=");
		sb.append(severityId);
		sb.append(", measurementId=");
		sb.append(measurementId);
		sb.append(", triggerId=");
		sb.append(triggerId);
		sb.append(", categoryId=");
		sb.append(categoryId);
		sb.append(", displayOrderNumber=");
		sb.append(displayOrderNumber);
		sb.append(", regionId=");
		sb.append(regionId);
		sb.append(", complianceDueDays=");
		sb.append(complianceDueDays);
		sb.append(", glblMustMeasure=");
		sb.append(glblMustMeasure);
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
	public GEMQlReport toEntityModel() {
		GEMQlReportImpl gemQlReportImpl = new GEMQlReportImpl();

		gemQlReportImpl.setQlReportId(qlReportId);
		gemQlReportImpl.setPublishDeptId(publishDeptId);
		gemQlReportImpl.setPublishId(publishId);
		gemQlReportImpl.setStdId(stdId);
		gemQlReportImpl.setBucketId(bucketId);
		gemQlReportImpl.setSeverityId(severityId);
		gemQlReportImpl.setMeasurementId(measurementId);
		gemQlReportImpl.setTriggerId(triggerId);
		gemQlReportImpl.setCategoryId(categoryId);
		gemQlReportImpl.setDisplayOrderNumber(displayOrderNumber);
		gemQlReportImpl.setRegionId(regionId);
		gemQlReportImpl.setComplianceDueDays(complianceDueDays);

		if (glblMustMeasure == null) {
			gemQlReportImpl.setGlblMustMeasure(StringPool.BLANK);
		}
		else {
			gemQlReportImpl.setGlblMustMeasure(glblMustMeasure);
		}

		if (creatorId == null) {
			gemQlReportImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			gemQlReportImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			gemQlReportImpl.setCreatedDate(null);
		}
		else {
			gemQlReportImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			gemQlReportImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			gemQlReportImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			gemQlReportImpl.setUpdatedDate(null);
		}
		else {
			gemQlReportImpl.setUpdatedDate(new Date(updatedDate));
		}

		gemQlReportImpl.resetOriginalValues();

		return gemQlReportImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		qlReportId = objectInput.readLong();
		publishDeptId = objectInput.readLong();
		publishId = objectInput.readLong();
		stdId = objectInput.readLong();
		bucketId = objectInput.readLong();
		severityId = objectInput.readLong();
		measurementId = objectInput.readLong();
		triggerId = objectInput.readLong();
		categoryId = objectInput.readLong();
		displayOrderNumber = objectInput.readLong();
		regionId = objectInput.readLong();
		complianceDueDays = objectInput.readLong();
		glblMustMeasure = objectInput.readUTF();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(qlReportId);
		objectOutput.writeLong(publishDeptId);
		objectOutput.writeLong(publishId);
		objectOutput.writeLong(stdId);
		objectOutput.writeLong(bucketId);
		objectOutput.writeLong(severityId);
		objectOutput.writeLong(measurementId);
		objectOutput.writeLong(triggerId);
		objectOutput.writeLong(categoryId);
		objectOutput.writeLong(displayOrderNumber);
		objectOutput.writeLong(regionId);
		objectOutput.writeLong(complianceDueDays);

		if (glblMustMeasure == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(glblMustMeasure);
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

	public long qlReportId;
	public long publishDeptId;
	public long publishId;
	public long stdId;
	public long bucketId;
	public long severityId;
	public long measurementId;
	public long triggerId;
	public long categoryId;
	public long displayOrderNumber;
	public long regionId;
	public long complianceDueDays;
	public String glblMustMeasure;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}