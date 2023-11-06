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

import com.ihg.brandstandards.db.model.PublishQueue;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PublishQueue in entity cache.
 *
 * @author Mummanedi
 * @see PublishQueue
 * @generated
 */
public class PublishQueueCacheModel implements CacheModel<PublishQueue>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{publishQueueId=");
		sb.append(publishQueueId);
		sb.append(", publishFileText=");
		sb.append(publishFileText);
		sb.append(", publishEnvironment=");
		sb.append(publishEnvironment);
		sb.append(", schedulePublish=");
		sb.append(schedulePublish);
		sb.append(", queueStatCd=");
		sb.append(queueStatCd);
		sb.append(", chainCd=");
		sb.append(chainCd);
		sb.append(", notificationEmailId=");
		sb.append(notificationEmailId);
		sb.append(", scheduleStart=");
		sb.append(scheduleStart);
		sb.append(", scheduleEnd=");
		sb.append(scheduleEnd);
		sb.append(", expectedProdPublishDt=");
		sb.append(expectedProdPublishDt);
		sb.append(", publishId=");
		sb.append(publishId);
		sb.append(", publishLocaleList=");
		sb.append(publishLocaleList);
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
	public PublishQueue toEntityModel() {
		PublishQueueImpl publishQueueImpl = new PublishQueueImpl();

		publishQueueImpl.setPublishQueueId(publishQueueId);

		if (publishFileText == null) {
			publishQueueImpl.setPublishFileText(StringPool.BLANK);
		}
		else {
			publishQueueImpl.setPublishFileText(publishFileText);
		}

		if (publishEnvironment == null) {
			publishQueueImpl.setPublishEnvironment(StringPool.BLANK);
		}
		else {
			publishQueueImpl.setPublishEnvironment(publishEnvironment);
		}

		if (schedulePublish == Long.MIN_VALUE) {
			publishQueueImpl.setSchedulePublish(null);
		}
		else {
			publishQueueImpl.setSchedulePublish(new Date(schedulePublish));
		}

		if (queueStatCd == null) {
			publishQueueImpl.setQueueStatCd(StringPool.BLANK);
		}
		else {
			publishQueueImpl.setQueueStatCd(queueStatCd);
		}

		if (chainCd == null) {
			publishQueueImpl.setChainCd(StringPool.BLANK);
		}
		else {
			publishQueueImpl.setChainCd(chainCd);
		}

		if (notificationEmailId == null) {
			publishQueueImpl.setNotificationEmailId(StringPool.BLANK);
		}
		else {
			publishQueueImpl.setNotificationEmailId(notificationEmailId);
		}

		if (scheduleStart == Long.MIN_VALUE) {
			publishQueueImpl.setScheduleStart(null);
		}
		else {
			publishQueueImpl.setScheduleStart(new Date(scheduleStart));
		}

		if (scheduleEnd == Long.MIN_VALUE) {
			publishQueueImpl.setScheduleEnd(null);
		}
		else {
			publishQueueImpl.setScheduleEnd(new Date(scheduleEnd));
		}

		if (expectedProdPublishDt == Long.MIN_VALUE) {
			publishQueueImpl.setExpectedProdPublishDt(null);
		}
		else {
			publishQueueImpl.setExpectedProdPublishDt(new Date(
					expectedProdPublishDt));
		}

		publishQueueImpl.setPublishId(publishId);

		if (publishLocaleList == null) {
			publishQueueImpl.setPublishLocaleList(StringPool.BLANK);
		}
		else {
			publishQueueImpl.setPublishLocaleList(publishLocaleList);
		}

		if (creatorId == null) {
			publishQueueImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			publishQueueImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			publishQueueImpl.setCreatedDate(null);
		}
		else {
			publishQueueImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			publishQueueImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			publishQueueImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			publishQueueImpl.setUpdatedDate(null);
		}
		else {
			publishQueueImpl.setUpdatedDate(new Date(updatedDate));
		}

		publishQueueImpl.resetOriginalValues();

		return publishQueueImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		publishQueueId = objectInput.readLong();
		publishFileText = objectInput.readUTF();
		publishEnvironment = objectInput.readUTF();
		schedulePublish = objectInput.readLong();
		queueStatCd = objectInput.readUTF();
		chainCd = objectInput.readUTF();
		notificationEmailId = objectInput.readUTF();
		scheduleStart = objectInput.readLong();
		scheduleEnd = objectInput.readLong();
		expectedProdPublishDt = objectInput.readLong();
		publishId = objectInput.readLong();
		publishLocaleList = objectInput.readUTF();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(publishQueueId);

		if (publishFileText == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(publishFileText);
		}

		if (publishEnvironment == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(publishEnvironment);
		}

		objectOutput.writeLong(schedulePublish);

		if (queueStatCd == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(queueStatCd);
		}

		if (chainCd == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(chainCd);
		}

		if (notificationEmailId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(notificationEmailId);
		}

		objectOutput.writeLong(scheduleStart);
		objectOutput.writeLong(scheduleEnd);
		objectOutput.writeLong(expectedProdPublishDt);
		objectOutput.writeLong(publishId);

		if (publishLocaleList == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(publishLocaleList);
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

	public long publishQueueId;
	public String publishFileText;
	public String publishEnvironment;
	public long schedulePublish;
	public String queueStatCd;
	public String chainCd;
	public String notificationEmailId;
	public long scheduleStart;
	public long scheduleEnd;
	public long expectedProdPublishDt;
	public long publishId;
	public String publishLocaleList;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}