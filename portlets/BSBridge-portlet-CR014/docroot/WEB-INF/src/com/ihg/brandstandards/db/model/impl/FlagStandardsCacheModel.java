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

import com.ihg.brandstandards.db.model.FlagStandards;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FlagStandards in entity cache.
 *
 * @author Mummanedi
 * @see FlagStandards
 * @generated
 */
public class FlagStandardsCacheModel implements CacheModel<FlagStandards>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{flagCatId=");
		sb.append(flagCatId);
		sb.append(", stdId=");
		sb.append(stdId);
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
	public FlagStandards toEntityModel() {
		FlagStandardsImpl flagStandardsImpl = new FlagStandardsImpl();

		flagStandardsImpl.setFlagCatId(flagCatId);
		flagStandardsImpl.setStdId(stdId);

		if (creatorId == null) {
			flagStandardsImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			flagStandardsImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			flagStandardsImpl.setCreatedDate(null);
		}
		else {
			flagStandardsImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			flagStandardsImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			flagStandardsImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			flagStandardsImpl.setUpdatedDate(null);
		}
		else {
			flagStandardsImpl.setUpdatedDate(new Date(updatedDate));
		}

		flagStandardsImpl.resetOriginalValues();

		return flagStandardsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		flagCatId = objectInput.readLong();
		stdId = objectInput.readLong();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(flagCatId);
		objectOutput.writeLong(stdId);

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

	public long flagCatId;
	public long stdId;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}