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

import com.ihg.brandstandards.db.model.HistManuals;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing HistManuals in entity cache.
 *
 * @author Mummanedi
 * @see HistManuals
 * @generated
 */
public class HistManualsCacheModel implements CacheModel<HistManuals>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{histManualId=");
		sb.append(histManualId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", type=");
		sb.append(type);
		sb.append(", pubDate=");
		sb.append(pubDate);
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
	public HistManuals toEntityModel() {
		HistManualsImpl histManualsImpl = new HistManualsImpl();

		histManualsImpl.setHistManualId(histManualId);

		if (title == null) {
			histManualsImpl.setTitle(StringPool.BLANK);
		}
		else {
			histManualsImpl.setTitle(title);
		}

		if (type == null) {
			histManualsImpl.setType(StringPool.BLANK);
		}
		else {
			histManualsImpl.setType(type);
		}

		if (pubDate == Long.MIN_VALUE) {
			histManualsImpl.setPubDate(null);
		}
		else {
			histManualsImpl.setPubDate(new Date(pubDate));
		}

		if (status == null) {
			histManualsImpl.setStatus(StringPool.BLANK);
		}
		else {
			histManualsImpl.setStatus(status);
		}

		if (creatorId == null) {
			histManualsImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			histManualsImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			histManualsImpl.setCreatedDate(null);
		}
		else {
			histManualsImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			histManualsImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			histManualsImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			histManualsImpl.setUpdatedDate(null);
		}
		else {
			histManualsImpl.setUpdatedDate(new Date(updatedDate));
		}

		histManualsImpl.resetOriginalValues();

		return histManualsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		histManualId = objectInput.readLong();
		title = objectInput.readUTF();
		type = objectInput.readUTF();
		pubDate = objectInput.readLong();
		status = objectInput.readUTF();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(histManualId);

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (type == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(type);
		}

		objectOutput.writeLong(pubDate);

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

	public long histManualId;
	public String title;
	public String type;
	public long pubDate;
	public String status;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}