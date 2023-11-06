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

import com.ihg.brandstandards.db.model.StandardsHistoricalManual;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing StandardsHistoricalManual in entity cache.
 *
 * @author Mummanedi
 * @see StandardsHistoricalManual
 * @generated
 */
public class StandardsHistoricalManualCacheModel implements CacheModel<StandardsHistoricalManual>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{stdMnlId=");
		sb.append(stdMnlId);
		sb.append(", stdId=");
		sb.append(stdId);
		sb.append(", histManualId=");
		sb.append(histManualId);
		sb.append(", change=");
		sb.append(change);
		sb.append(", title=");
		sb.append(title);
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
	public StandardsHistoricalManual toEntityModel() {
		StandardsHistoricalManualImpl standardsHistoricalManualImpl = new StandardsHistoricalManualImpl();

		standardsHistoricalManualImpl.setStdMnlId(stdMnlId);
		standardsHistoricalManualImpl.setStdId(stdId);
		standardsHistoricalManualImpl.setHistManualId(histManualId);

		if (change == null) {
			standardsHistoricalManualImpl.setChange(StringPool.BLANK);
		}
		else {
			standardsHistoricalManualImpl.setChange(change);
		}

		if (title == null) {
			standardsHistoricalManualImpl.setTitle(StringPool.BLANK);
		}
		else {
			standardsHistoricalManualImpl.setTitle(title);
		}

		if (creatorId == null) {
			standardsHistoricalManualImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			standardsHistoricalManualImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			standardsHistoricalManualImpl.setCreatedDate(null);
		}
		else {
			standardsHistoricalManualImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			standardsHistoricalManualImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			standardsHistoricalManualImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			standardsHistoricalManualImpl.setUpdatedDate(null);
		}
		else {
			standardsHistoricalManualImpl.setUpdatedDate(new Date(updatedDate));
		}

		standardsHistoricalManualImpl.resetOriginalValues();

		return standardsHistoricalManualImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		stdMnlId = objectInput.readLong();
		stdId = objectInput.readLong();
		histManualId = objectInput.readLong();
		change = objectInput.readUTF();
		title = objectInput.readUTF();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(stdMnlId);
		objectOutput.writeLong(stdId);
		objectOutput.writeLong(histManualId);

		if (change == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(change);
		}

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
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

	public long stdMnlId;
	public long stdId;
	public long histManualId;
	public String change;
	public String title;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}