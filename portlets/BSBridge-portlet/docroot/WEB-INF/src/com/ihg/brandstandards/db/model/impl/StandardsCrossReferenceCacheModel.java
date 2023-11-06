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

import com.ihg.brandstandards.db.model.StandardsCrossReference;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing StandardsCrossReference in entity cache.
 *
 * @author Mummanedi
 * @see StandardsCrossReference
 * @generated
 */
public class StandardsCrossReferenceCacheModel implements CacheModel<StandardsCrossReference>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{stdId=");
		sb.append(stdId);
		sb.append(", xrefStdId=");
		sb.append(xrefStdId);
		sb.append(", dispOrderNumber=");
		sb.append(dispOrderNumber);
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
	public StandardsCrossReference toEntityModel() {
		StandardsCrossReferenceImpl standardsCrossReferenceImpl = new StandardsCrossReferenceImpl();

		standardsCrossReferenceImpl.setStdId(stdId);
		standardsCrossReferenceImpl.setXrefStdId(xrefStdId);
		standardsCrossReferenceImpl.setDispOrderNumber(dispOrderNumber);

		if (creatorId == null) {
			standardsCrossReferenceImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			standardsCrossReferenceImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			standardsCrossReferenceImpl.setCreatedDate(null);
		}
		else {
			standardsCrossReferenceImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			standardsCrossReferenceImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			standardsCrossReferenceImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			standardsCrossReferenceImpl.setUpdatedDate(null);
		}
		else {
			standardsCrossReferenceImpl.setUpdatedDate(new Date(updatedDate));
		}

		standardsCrossReferenceImpl.resetOriginalValues();

		return standardsCrossReferenceImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		stdId = objectInput.readLong();
		xrefStdId = objectInput.readLong();
		dispOrderNumber = objectInput.readLong();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(stdId);
		objectOutput.writeLong(xrefStdId);
		objectOutput.writeLong(dispOrderNumber);

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

	public long stdId;
	public long xrefStdId;
	public long dispOrderNumber;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}