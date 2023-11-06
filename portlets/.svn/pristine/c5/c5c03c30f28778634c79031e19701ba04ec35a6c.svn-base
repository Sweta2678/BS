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

import com.ihg.brandstandards.db.model.HistManualRegion;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing HistManualRegion in entity cache.
 *
 * @author Mummanedi
 * @see HistManualRegion
 * @generated
 */
public class HistManualRegionCacheModel implements CacheModel<HistManualRegion>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{regionCode=");
		sb.append(regionCode);
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
	public HistManualRegion toEntityModel() {
		HistManualRegionImpl histManualRegionImpl = new HistManualRegionImpl();

		if (regionCode == null) {
			histManualRegionImpl.setRegionCode(StringPool.BLANK);
		}
		else {
			histManualRegionImpl.setRegionCode(regionCode);
		}

		histManualRegionImpl.setHistManualId(histManualId);

		if (creatorId == null) {
			histManualRegionImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			histManualRegionImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			histManualRegionImpl.setCreatedDate(null);
		}
		else {
			histManualRegionImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			histManualRegionImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			histManualRegionImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			histManualRegionImpl.setUpdatedDate(null);
		}
		else {
			histManualRegionImpl.setUpdatedDate(new Date(updatedDate));
		}

		histManualRegionImpl.resetOriginalValues();

		return histManualRegionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		regionCode = objectInput.readUTF();
		histManualId = objectInput.readLong();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (regionCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(regionCode);
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

	public String regionCode;
	public long histManualId;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}