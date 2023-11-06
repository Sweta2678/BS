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

import com.ihg.grs.common.model.Feedback;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Feedback in entity cache.
 *
 * @author gulam.vora
 * @see Feedback
 * @generated
 */
public class FeedbackCacheModel implements CacheModel<Feedback>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{feedbackId=");
		sb.append(feedbackId);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", title=");
		sb.append(title);
		sb.append(", email=");
		sb.append(email);
		sb.append(", onBehalfOf=");
		sb.append(onBehalfOf);
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
	public Feedback toEntityModel() {
		FeedbackImpl feedbackImpl = new FeedbackImpl();

		feedbackImpl.setFeedbackId(feedbackId);

		if (firstName == null) {
			feedbackImpl.setFirstName(StringPool.BLANK);
		}
		else {
			feedbackImpl.setFirstName(firstName);
		}

		if (lastName == null) {
			feedbackImpl.setLastName(StringPool.BLANK);
		}
		else {
			feedbackImpl.setLastName(lastName);
		}

		if (title == null) {
			feedbackImpl.setTitle(StringPool.BLANK);
		}
		else {
			feedbackImpl.setTitle(title);
		}

		if (email == null) {
			feedbackImpl.setEmail(StringPool.BLANK);
		}
		else {
			feedbackImpl.setEmail(email);
		}

		if (onBehalfOf == null) {
			feedbackImpl.setOnBehalfOf(StringPool.BLANK);
		}
		else {
			feedbackImpl.setOnBehalfOf(onBehalfOf);
		}

		if (createUserId == null) {
			feedbackImpl.setCreateUserId(StringPool.BLANK);
		}
		else {
			feedbackImpl.setCreateUserId(createUserId);
		}

		if (createdate == Long.MIN_VALUE) {
			feedbackImpl.setCreatedate(null);
		}
		else {
			feedbackImpl.setCreatedate(new Date(createdate));
		}

		if (lastUpdateUserId == null) {
			feedbackImpl.setLastUpdateUserId(StringPool.BLANK);
		}
		else {
			feedbackImpl.setLastUpdateUserId(lastUpdateUserId);
		}

		if (updatedate == Long.MIN_VALUE) {
			feedbackImpl.setUpdatedate(null);
		}
		else {
			feedbackImpl.setUpdatedate(new Date(updatedate));
		}

		feedbackImpl.resetOriginalValues();

		return feedbackImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		feedbackId = objectInput.readInt();
		firstName = objectInput.readUTF();
		lastName = objectInput.readUTF();
		title = objectInput.readUTF();
		email = objectInput.readUTF();
		onBehalfOf = objectInput.readUTF();
		createUserId = objectInput.readUTF();
		createdate = objectInput.readLong();
		lastUpdateUserId = objectInput.readUTF();
		updatedate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeInt(feedbackId);

		if (firstName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(firstName);
		}

		if (lastName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lastName);
		}

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (email == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (onBehalfOf == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(onBehalfOf);
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

	public int feedbackId;
	public String firstName;
	public String lastName;
	public String title;
	public String email;
	public String onBehalfOf;
	public String createUserId;
	public long createdate;
	public String lastUpdateUserId;
	public long updatedate;
}