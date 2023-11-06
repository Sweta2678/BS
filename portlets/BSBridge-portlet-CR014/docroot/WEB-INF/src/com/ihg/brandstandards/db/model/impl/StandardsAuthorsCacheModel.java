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

import com.ihg.brandstandards.db.model.StandardsAuthors;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing StandardsAuthors in entity cache.
 *
 * @author Mummanedi
 * @see StandardsAuthors
 * @generated
 */
public class StandardsAuthorsCacheModel implements CacheModel<StandardsAuthors>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{stdAuthorId=");
		sb.append(stdAuthorId);
		sb.append(", stdId=");
		sb.append(stdId);
		sb.append(", authorName=");
		sb.append(authorName);
		sb.append(", isPrimary=");
		sb.append(isPrimary);
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
	public StandardsAuthors toEntityModel() {
		StandardsAuthorsImpl standardsAuthorsImpl = new StandardsAuthorsImpl();

		standardsAuthorsImpl.setStdAuthorId(stdAuthorId);
		standardsAuthorsImpl.setStdId(stdId);

		if (authorName == null) {
			standardsAuthorsImpl.setAuthorName(StringPool.BLANK);
		}
		else {
			standardsAuthorsImpl.setAuthorName(authorName);
		}

		if (isPrimary == null) {
			standardsAuthorsImpl.setIsPrimary(StringPool.BLANK);
		}
		else {
			standardsAuthorsImpl.setIsPrimary(isPrimary);
		}

		if (creatorId == null) {
			standardsAuthorsImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			standardsAuthorsImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			standardsAuthorsImpl.setCreatedDate(null);
		}
		else {
			standardsAuthorsImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			standardsAuthorsImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			standardsAuthorsImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			standardsAuthorsImpl.setUpdatedDate(null);
		}
		else {
			standardsAuthorsImpl.setUpdatedDate(new Date(updatedDate));
		}

		standardsAuthorsImpl.resetOriginalValues();

		return standardsAuthorsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		stdAuthorId = objectInput.readLong();
		stdId = objectInput.readLong();
		authorName = objectInput.readUTF();
		isPrimary = objectInput.readUTF();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(stdAuthorId);
		objectOutput.writeLong(stdId);

		if (authorName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(authorName);
		}

		if (isPrimary == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(isPrimary);
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

	public long stdAuthorId;
	public long stdId;
	public String authorName;
	public String isPrimary;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}