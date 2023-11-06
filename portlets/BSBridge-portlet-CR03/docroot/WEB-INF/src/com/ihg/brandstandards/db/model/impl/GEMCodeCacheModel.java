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

import com.ihg.brandstandards.db.model.GEMCode;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing GEMCode in entity cache.
 *
 * @author Mummanedi
 * @see GEMCode
 * @generated
 */
public class GEMCodeCacheModel implements CacheModel<GEMCode>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{code=");
		sb.append(code);
		sb.append(", codeDesc=");
		sb.append(codeDesc);
		sb.append(", codeVal=");
		sb.append(codeVal);
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
	public GEMCode toEntityModel() {
		GEMCodeImpl gemCodeImpl = new GEMCodeImpl();

		if (code == null) {
			gemCodeImpl.setCode(StringPool.BLANK);
		}
		else {
			gemCodeImpl.setCode(code);
		}

		if (codeDesc == null) {
			gemCodeImpl.setCodeDesc(StringPool.BLANK);
		}
		else {
			gemCodeImpl.setCodeDesc(codeDesc);
		}

		if (codeVal == null) {
			gemCodeImpl.setCodeVal(StringPool.BLANK);
		}
		else {
			gemCodeImpl.setCodeVal(codeVal);
		}

		if (creatorId == null) {
			gemCodeImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			gemCodeImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			gemCodeImpl.setCreatedDate(null);
		}
		else {
			gemCodeImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			gemCodeImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			gemCodeImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			gemCodeImpl.setUpdatedDate(null);
		}
		else {
			gemCodeImpl.setUpdatedDate(new Date(updatedDate));
		}

		gemCodeImpl.resetOriginalValues();

		return gemCodeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		code = objectInput.readUTF();
		codeDesc = objectInput.readUTF();
		codeVal = objectInput.readUTF();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (code == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(code);
		}

		if (codeDesc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(codeDesc);
		}

		if (codeVal == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(codeVal);
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

	public String code;
	public String codeDesc;
	public String codeVal;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}