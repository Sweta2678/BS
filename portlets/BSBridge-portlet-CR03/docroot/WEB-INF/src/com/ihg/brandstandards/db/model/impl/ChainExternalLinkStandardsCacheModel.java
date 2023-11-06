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

import com.ihg.brandstandards.db.model.ChainExternalLinkStandards;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ChainExternalLinkStandards in entity cache.
 *
 * @author Mummanedi
 * @see ChainExternalLinkStandards
 * @generated
 */
public class ChainExternalLinkStandardsCacheModel implements CacheModel<ChainExternalLinkStandards>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{extLinkId=");
		sb.append(extLinkId);
		sb.append(", chainCode=");
		sb.append(chainCode);
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
	public ChainExternalLinkStandards toEntityModel() {
		ChainExternalLinkStandardsImpl chainExternalLinkStandardsImpl = new ChainExternalLinkStandardsImpl();

		chainExternalLinkStandardsImpl.setExtLinkId(extLinkId);

		if (chainCode == null) {
			chainExternalLinkStandardsImpl.setChainCode(StringPool.BLANK);
		}
		else {
			chainExternalLinkStandardsImpl.setChainCode(chainCode);
		}

		if (creatorId == null) {
			chainExternalLinkStandardsImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			chainExternalLinkStandardsImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			chainExternalLinkStandardsImpl.setCreatedDate(null);
		}
		else {
			chainExternalLinkStandardsImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			chainExternalLinkStandardsImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			chainExternalLinkStandardsImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			chainExternalLinkStandardsImpl.setUpdatedDate(null);
		}
		else {
			chainExternalLinkStandardsImpl.setUpdatedDate(new Date(updatedDate));
		}

		chainExternalLinkStandardsImpl.resetOriginalValues();

		return chainExternalLinkStandardsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		extLinkId = objectInput.readLong();
		chainCode = objectInput.readUTF();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(extLinkId);

		if (chainCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(chainCode);
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

	public long extLinkId;
	public String chainCode;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}