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

import com.ihg.brandstandards.db.model.HistManualChain;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing HistManualChain in entity cache.
 *
 * @author Mummanedi
 * @see HistManualChain
 * @generated
 */
public class HistManualChainCacheModel implements CacheModel<HistManualChain>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{chainCode=");
		sb.append(chainCode);
		sb.append(", histManualId=");
		sb.append(histManualId);
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
	public HistManualChain toEntityModel() {
		HistManualChainImpl histManualChainImpl = new HistManualChainImpl();

		if (chainCode == null) {
			histManualChainImpl.setChainCode(StringPool.BLANK);
		}
		else {
			histManualChainImpl.setChainCode(chainCode);
		}

		histManualChainImpl.setHistManualId(histManualId);

		if (creatorId == null) {
			histManualChainImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			histManualChainImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			histManualChainImpl.setCreatedDate(null);
		}
		else {
			histManualChainImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			histManualChainImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			histManualChainImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			histManualChainImpl.setUpdatedDate(null);
		}
		else {
			histManualChainImpl.setUpdatedDate(new Date(updatedDate));
		}

		histManualChainImpl.resetOriginalValues();

		return histManualChainImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		chainCode = objectInput.readUTF();
		histManualId = objectInput.readLong();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (chainCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(chainCode);
		}

		objectOutput.writeLong(histManualId);

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

	public String chainCode;
	public long histManualId;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}