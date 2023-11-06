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

import com.ihg.brandstandards.db.model.GEMGeneratedReport;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing GEMGeneratedReport in entity cache.
 *
 * @author Mummanedi
 * @see GEMGeneratedReport
 * @generated
 */
public class GEMGeneratedReportCacheModel implements CacheModel<GEMGeneratedReport>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{reportId=");
		sb.append(reportId);
		sb.append(", templateId=");
		sb.append(templateId);
		sb.append(", uniqueGroupId=");
		sb.append(uniqueGroupId);
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
	public GEMGeneratedReport toEntityModel() {
		GEMGeneratedReportImpl gemGeneratedReportImpl = new GEMGeneratedReportImpl();

		gemGeneratedReportImpl.setReportId(reportId);
		gemGeneratedReportImpl.setTemplateId(templateId);
		gemGeneratedReportImpl.setUniqueGroupId(uniqueGroupId);

		if (creatorId == null) {
			gemGeneratedReportImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			gemGeneratedReportImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			gemGeneratedReportImpl.setCreatedDate(null);
		}
		else {
			gemGeneratedReportImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			gemGeneratedReportImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			gemGeneratedReportImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			gemGeneratedReportImpl.setUpdatedDate(null);
		}
		else {
			gemGeneratedReportImpl.setUpdatedDate(new Date(updatedDate));
		}

		gemGeneratedReportImpl.resetOriginalValues();

		return gemGeneratedReportImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		reportId = objectInput.readLong();
		templateId = objectInput.readLong();
		uniqueGroupId = objectInput.readLong();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(reportId);
		objectOutput.writeLong(templateId);
		objectOutput.writeLong(uniqueGroupId);

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

	public long reportId;
	public long templateId;
	public long uniqueGroupId;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}