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

import com.ihg.brandstandards.db.model.StandardsStatus;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing StandardsStatus in entity cache.
 *
 * @author Mummanedi
 * @see StandardsStatus
 * @generated
 */
public class StandardsStatusCacheModel implements CacheModel<StandardsStatus>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{statusId=");
		sb.append(statusId);
		sb.append(", statusCode=");
		sb.append(statusCode);
		sb.append(", title=");
		sb.append(title);
		sb.append(", regionId=");
		sb.append(regionId);
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
	public StandardsStatus toEntityModel() {
		StandardsStatusImpl standardsStatusImpl = new StandardsStatusImpl();

		standardsStatusImpl.setStatusId(statusId);

		if (statusCode == null) {
			standardsStatusImpl.setStatusCode(StringPool.BLANK);
		}
		else {
			standardsStatusImpl.setStatusCode(statusCode);
		}

		if (title == null) {
			standardsStatusImpl.setTitle(StringPool.BLANK);
		}
		else {
			standardsStatusImpl.setTitle(title);
		}

		standardsStatusImpl.setRegionId(regionId);

		if (creatorId == null) {
			standardsStatusImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			standardsStatusImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			standardsStatusImpl.setCreatedDate(null);
		}
		else {
			standardsStatusImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			standardsStatusImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			standardsStatusImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			standardsStatusImpl.setUpdatedDate(null);
		}
		else {
			standardsStatusImpl.setUpdatedDate(new Date(updatedDate));
		}

		standardsStatusImpl.resetOriginalValues();

		return standardsStatusImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		statusId = objectInput.readLong();
		statusCode = objectInput.readUTF();
		title = objectInput.readUTF();
		regionId = objectInput.readLong();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(statusId);

		if (statusCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(statusCode);
		}

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		objectOutput.writeLong(regionId);

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

	public long statusId;
	public String statusCode;
	public String title;
	public long regionId;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}