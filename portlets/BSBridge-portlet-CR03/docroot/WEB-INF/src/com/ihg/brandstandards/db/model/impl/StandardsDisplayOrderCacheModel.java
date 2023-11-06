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

import com.ihg.brandstandards.db.model.StandardsDisplayOrder;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing StandardsDisplayOrder in entity cache.
 *
 * @author Mummanedi
 * @see StandardsDisplayOrder
 * @generated
 */
public class StandardsDisplayOrderCacheModel implements CacheModel<StandardsDisplayOrder>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{stdId=");
		sb.append(stdId);
		sb.append(", regionCode=");
		sb.append(regionCode);
		sb.append(", chainCode=");
		sb.append(chainCode);
		sb.append(", displayOrder=");
		sb.append(displayOrder);
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
	public StandardsDisplayOrder toEntityModel() {
		StandardsDisplayOrderImpl standardsDisplayOrderImpl = new StandardsDisplayOrderImpl();

		standardsDisplayOrderImpl.setStdId(stdId);

		if (regionCode == null) {
			standardsDisplayOrderImpl.setRegionCode(StringPool.BLANK);
		}
		else {
			standardsDisplayOrderImpl.setRegionCode(regionCode);
		}

		if (chainCode == null) {
			standardsDisplayOrderImpl.setChainCode(StringPool.BLANK);
		}
		else {
			standardsDisplayOrderImpl.setChainCode(chainCode);
		}

		standardsDisplayOrderImpl.setDisplayOrder(displayOrder);

		if (creatorId == null) {
			standardsDisplayOrderImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			standardsDisplayOrderImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			standardsDisplayOrderImpl.setCreatedDate(null);
		}
		else {
			standardsDisplayOrderImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			standardsDisplayOrderImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			standardsDisplayOrderImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			standardsDisplayOrderImpl.setUpdatedDate(null);
		}
		else {
			standardsDisplayOrderImpl.setUpdatedDate(new Date(updatedDate));
		}

		standardsDisplayOrderImpl.resetOriginalValues();

		return standardsDisplayOrderImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		stdId = objectInput.readLong();
		regionCode = objectInput.readUTF();
		chainCode = objectInput.readUTF();
		displayOrder = objectInput.readLong();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(stdId);

		if (regionCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(regionCode);
		}

		if (chainCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(chainCode);
		}

		objectOutput.writeLong(displayOrder);

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
	public String regionCode;
	public String chainCode;
	public long displayOrder;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}