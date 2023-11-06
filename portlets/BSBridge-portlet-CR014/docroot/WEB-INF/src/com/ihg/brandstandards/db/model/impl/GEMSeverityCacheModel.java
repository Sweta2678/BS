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

import com.ihg.brandstandards.db.model.GEMSeverity;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing GEMSeverity in entity cache.
 *
 * @author Mummanedi
 * @see GEMSeverity
 * @generated
 */
public class GEMSeverityCacheModel implements CacheModel<GEMSeverity>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{severityId=");
		sb.append(severityId);
		sb.append(", severityName=");
		sb.append(severityName);
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
	public GEMSeverity toEntityModel() {
		GEMSeverityImpl gemSeverityImpl = new GEMSeverityImpl();

		gemSeverityImpl.setSeverityId(severityId);

		if (severityName == null) {
			gemSeverityImpl.setSeverityName(StringPool.BLANK);
		}
		else {
			gemSeverityImpl.setSeverityName(severityName);
		}

		if (creatorId == null) {
			gemSeverityImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			gemSeverityImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			gemSeverityImpl.setCreatedDate(null);
		}
		else {
			gemSeverityImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			gemSeverityImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			gemSeverityImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			gemSeverityImpl.setUpdatedDate(null);
		}
		else {
			gemSeverityImpl.setUpdatedDate(new Date(updatedDate));
		}

		gemSeverityImpl.resetOriginalValues();

		return gemSeverityImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		severityId = objectInput.readLong();
		severityName = objectInput.readUTF();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(severityId);

		if (severityName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(severityName);
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

	public long severityId;
	public String severityName;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}