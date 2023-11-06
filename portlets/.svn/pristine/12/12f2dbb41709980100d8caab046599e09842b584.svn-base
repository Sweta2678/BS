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

package com.ihg.grs.common.model.impl;

import com.ihg.grs.common.model.FeedbackDetail;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FeedbackDetail in entity cache.
 *
 * @author gulam.vora
 * @see FeedbackDetail
 * @generated
 */
public class FeedbackDetailCacheModel implements CacheModel<FeedbackDetail>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{PORTAL_FEEDBACK_DTL_ID=");
		sb.append(PORTAL_FEEDBACK_DTL_ID);
		sb.append(", feedbackId=");
		sb.append(feedbackId);
		sb.append(", feedbackType=");
		sb.append(feedbackType);
		sb.append(", subject=");
		sb.append(subject);
		sb.append(", message=");
		sb.append(message);
		sb.append(", fileName=");
		sb.append(fileName);
		sb.append(", createUserId=");
		sb.append(createUserId);
		sb.append(", createdate=");
		sb.append(createdate);
		sb.append(", lastUpdateUserId=");
		sb.append(lastUpdateUserId);
		sb.append(", updatedate=");
		sb.append(updatedate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FeedbackDetail toEntityModel() {
		FeedbackDetailImpl feedbackDetailImpl = new FeedbackDetailImpl();

		feedbackDetailImpl.setPORTAL_FEEDBACK_DTL_ID(PORTAL_FEEDBACK_DTL_ID);
		feedbackDetailImpl.setFeedbackId(feedbackId);

		if (feedbackType == null) {
			feedbackDetailImpl.setFeedbackType(StringPool.BLANK);
		}
		else {
			feedbackDetailImpl.setFeedbackType(feedbackType);
		}

		if (subject == null) {
			feedbackDetailImpl.setSubject(StringPool.BLANK);
		}
		else {
			feedbackDetailImpl.setSubject(subject);
		}

		if (message == null) {
			feedbackDetailImpl.setMessage(StringPool.BLANK);
		}
		else {
			feedbackDetailImpl.setMessage(message);
		}

		if (fileName == null) {
			feedbackDetailImpl.setFileName(StringPool.BLANK);
		}
		else {
			feedbackDetailImpl.setFileName(fileName);
		}

		if (createUserId == null) {
			feedbackDetailImpl.setCreateUserId(StringPool.BLANK);
		}
		else {
			feedbackDetailImpl.setCreateUserId(createUserId);
		}

		if (createdate == Long.MIN_VALUE) {
			feedbackDetailImpl.setCreatedate(null);
		}
		else {
			feedbackDetailImpl.setCreatedate(new Date(createdate));
		}

		if (lastUpdateUserId == null) {
			feedbackDetailImpl.setLastUpdateUserId(StringPool.BLANK);
		}
		else {
			feedbackDetailImpl.setLastUpdateUserId(lastUpdateUserId);
		}

		if (updatedate == Long.MIN_VALUE) {
			feedbackDetailImpl.setUpdatedate(null);
		}
		else {
			feedbackDetailImpl.setUpdatedate(new Date(updatedate));
		}

		feedbackDetailImpl.resetOriginalValues();

		return feedbackDetailImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		PORTAL_FEEDBACK_DTL_ID = objectInput.readInt();
		feedbackId = objectInput.readInt();
		feedbackType = objectInput.readUTF();
		subject = objectInput.readUTF();
		message = objectInput.readUTF();
		fileName = objectInput.readUTF();
		createUserId = objectInput.readUTF();
		createdate = objectInput.readLong();
		lastUpdateUserId = objectInput.readUTF();
		updatedate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeInt(PORTAL_FEEDBACK_DTL_ID);
		objectOutput.writeInt(feedbackId);

		if (feedbackType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(feedbackType);
		}

		if (subject == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(subject);
		}

		if (message == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(message);
		}

		if (fileName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fileName);
		}

		if (createUserId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(createUserId);
		}

		objectOutput.writeLong(createdate);

		if (lastUpdateUserId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lastUpdateUserId);
		}

		objectOutput.writeLong(updatedate);
	}

	public int PORTAL_FEEDBACK_DTL_ID;
	public int feedbackId;
	public String feedbackType;
	public String subject;
	public String message;
	public String fileName;
	public String createUserId;
	public long createdate;
	public String lastUpdateUserId;
	public long updatedate;
}