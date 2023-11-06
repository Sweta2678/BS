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

import com.ihg.brandstandards.db.model.ErrNotification;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ErrNotification in entity cache.
 *
 * @author Mummanedi
 * @see ErrNotification
 * @generated
 */
public class ErrNotificationCacheModel implements CacheModel<ErrNotification>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{notificationId=");
		sb.append(notificationId);
		sb.append(", componentName=");
		sb.append(componentName);
		sb.append(", referenceId=");
		sb.append(referenceId);
		sb.append(", severity=");
		sb.append(severity);
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append(", status=");
		sb.append(status);
		sb.append(", publishId=");
		sb.append(publishId);
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
	public ErrNotification toEntityModel() {
		ErrNotificationImpl errNotificationImpl = new ErrNotificationImpl();

		errNotificationImpl.setNotificationId(notificationId);

		if (componentName == null) {
			errNotificationImpl.setComponentName(StringPool.BLANK);
		}
		else {
			errNotificationImpl.setComponentName(componentName);
		}

		errNotificationImpl.setReferenceId(referenceId);

		if (severity == null) {
			errNotificationImpl.setSeverity(StringPool.BLANK);
		}
		else {
			errNotificationImpl.setSeverity(severity);
		}

		if (title == null) {
			errNotificationImpl.setTitle(StringPool.BLANK);
		}
		else {
			errNotificationImpl.setTitle(title);
		}

		if (description == null) {
			errNotificationImpl.setDescription(StringPool.BLANK);
		}
		else {
			errNotificationImpl.setDescription(description);
		}

		if (status == null) {
			errNotificationImpl.setStatus(StringPool.BLANK);
		}
		else {
			errNotificationImpl.setStatus(status);
		}

		errNotificationImpl.setPublishId(publishId);
		errNotificationImpl.setRegionId(regionId);

		if (creatorId == null) {
			errNotificationImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			errNotificationImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			errNotificationImpl.setCreatedDate(null);
		}
		else {
			errNotificationImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			errNotificationImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			errNotificationImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			errNotificationImpl.setUpdatedDate(null);
		}
		else {
			errNotificationImpl.setUpdatedDate(new Date(updatedDate));
		}

		errNotificationImpl.resetOriginalValues();

		return errNotificationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		notificationId = objectInput.readLong();
		componentName = objectInput.readUTF();
		referenceId = objectInput.readLong();
		severity = objectInput.readUTF();
		title = objectInput.readUTF();
		description = objectInput.readUTF();
		status = objectInput.readUTF();
		publishId = objectInput.readLong();
		regionId = objectInput.readLong();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(notificationId);

		if (componentName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(componentName);
		}

		objectOutput.writeLong(referenceId);

		if (severity == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(severity);
		}

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (status == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(status);
		}

		objectOutput.writeLong(publishId);
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

	public long notificationId;
	public String componentName;
	public long referenceId;
	public String severity;
	public String title;
	public String description;
	public String status;
	public long publishId;
	public long regionId;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}