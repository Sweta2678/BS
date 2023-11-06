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

import com.ihg.brandstandards.db.model.GEMGeneratedReportVal;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing GEMGeneratedReportVal in entity cache.
 *
 * @author Mummanedi
 * @see GEMGeneratedReportVal
 * @generated
 */
public class GEMGeneratedReportValCacheModel implements CacheModel<GEMGeneratedReportVal>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{reportValId=");
		sb.append(reportValId);
		sb.append(", reportId=");
		sb.append(reportId);
		sb.append(", columnId=");
		sb.append(columnId);
		sb.append(", generatedValue=");
		sb.append(generatedValue);
		sb.append(", displayOrderNumber=");
		sb.append(displayOrderNumber);
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
	public GEMGeneratedReportVal toEntityModel() {
		GEMGeneratedReportValImpl gemGeneratedReportValImpl = new GEMGeneratedReportValImpl();

		gemGeneratedReportValImpl.setReportValId(reportValId);
		gemGeneratedReportValImpl.setReportId(reportId);
		gemGeneratedReportValImpl.setColumnId(columnId);

		if (generatedValue == null) {
			gemGeneratedReportValImpl.setGeneratedValue(StringPool.BLANK);
		}
		else {
			gemGeneratedReportValImpl.setGeneratedValue(generatedValue);
		}

		gemGeneratedReportValImpl.setDisplayOrderNumber(displayOrderNumber);

		if (creatorId == null) {
			gemGeneratedReportValImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			gemGeneratedReportValImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			gemGeneratedReportValImpl.setCreatedDate(null);
		}
		else {
			gemGeneratedReportValImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			gemGeneratedReportValImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			gemGeneratedReportValImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			gemGeneratedReportValImpl.setUpdatedDate(null);
		}
		else {
			gemGeneratedReportValImpl.setUpdatedDate(new Date(updatedDate));
		}

		gemGeneratedReportValImpl.resetOriginalValues();

		return gemGeneratedReportValImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		reportValId = objectInput.readLong();
		reportId = objectInput.readLong();
		columnId = objectInput.readLong();
		generatedValue = objectInput.readUTF();
		displayOrderNumber = objectInput.readLong();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(reportValId);
		objectOutput.writeLong(reportId);
		objectOutput.writeLong(columnId);

		if (generatedValue == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(generatedValue);
		}

		objectOutput.writeLong(displayOrderNumber);

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

	public long reportValId;
	public long reportId;
	public long columnId;
	public String generatedValue;
	public long displayOrderNumber;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}