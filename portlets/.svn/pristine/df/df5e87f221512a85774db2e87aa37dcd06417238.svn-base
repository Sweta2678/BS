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

import com.ihg.brandstandards.db.model.JobQueue;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing JobQueue in entity cache.
 *
 * @author Mummanedi
 * @see JobQueue
 * @generated
 */
public class JobQueueCacheModel implements CacheModel<JobQueue>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{jobId=");
		sb.append(jobId);
		sb.append(", jobOwner=");
		sb.append(jobOwner);
		sb.append(", jobType=");
		sb.append(jobType);
		sb.append(", metadata=");
		sb.append(metadata);
		sb.append(", link=");
		sb.append(link);
		sb.append(", notificationEmail=");
		sb.append(notificationEmail);
		sb.append(", startTime=");
		sb.append(startTime);
		sb.append(", endTime=");
		sb.append(endTime);
		sb.append(", status=");
		sb.append(status);
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
	public JobQueue toEntityModel() {
		JobQueueImpl jobQueueImpl = new JobQueueImpl();

		jobQueueImpl.setJobId(jobId);

		if (jobOwner == null) {
			jobQueueImpl.setJobOwner(StringPool.BLANK);
		}
		else {
			jobQueueImpl.setJobOwner(jobOwner);
		}

		if (jobType == null) {
			jobQueueImpl.setJobType(StringPool.BLANK);
		}
		else {
			jobQueueImpl.setJobType(jobType);
		}

		if (metadata == null) {
			jobQueueImpl.setMetadata(StringPool.BLANK);
		}
		else {
			jobQueueImpl.setMetadata(metadata);
		}

		if (link == null) {
			jobQueueImpl.setLink(StringPool.BLANK);
		}
		else {
			jobQueueImpl.setLink(link);
		}

		if (notificationEmail == null) {
			jobQueueImpl.setNotificationEmail(StringPool.BLANK);
		}
		else {
			jobQueueImpl.setNotificationEmail(notificationEmail);
		}

		if (startTime == Long.MIN_VALUE) {
			jobQueueImpl.setStartTime(null);
		}
		else {
			jobQueueImpl.setStartTime(new Date(startTime));
		}

		if (endTime == Long.MIN_VALUE) {
			jobQueueImpl.setEndTime(null);
		}
		else {
			jobQueueImpl.setEndTime(new Date(endTime));
		}

		if (status == null) {
			jobQueueImpl.setStatus(StringPool.BLANK);
		}
		else {
			jobQueueImpl.setStatus(status);
		}

		if (creatorId == null) {
			jobQueueImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			jobQueueImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			jobQueueImpl.setCreatedDate(null);
		}
		else {
			jobQueueImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			jobQueueImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			jobQueueImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			jobQueueImpl.setUpdatedDate(null);
		}
		else {
			jobQueueImpl.setUpdatedDate(new Date(updatedDate));
		}

		jobQueueImpl.resetOriginalValues();

		return jobQueueImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		jobId = objectInput.readLong();
		jobOwner = objectInput.readUTF();
		jobType = objectInput.readUTF();
		metadata = objectInput.readUTF();
		link = objectInput.readUTF();
		notificationEmail = objectInput.readUTF();
		startTime = objectInput.readLong();
		endTime = objectInput.readLong();
		status = objectInput.readUTF();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(jobId);

		if (jobOwner == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jobOwner);
		}

		if (jobType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jobType);
		}

		if (metadata == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(metadata);
		}

		if (link == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(link);
		}

		if (notificationEmail == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(notificationEmail);
		}

		objectOutput.writeLong(startTime);
		objectOutput.writeLong(endTime);

		if (status == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(status);
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

	public long jobId;
	public String jobOwner;
	public String jobType;
	public String metadata;
	public String link;
	public String notificationEmail;
	public long startTime;
	public long endTime;
	public String status;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}