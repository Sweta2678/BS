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

import com.ihg.brandstandards.db.model.BridgeGlobalPublishCountry;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing BridgeGlobalPublishCountry in entity cache.
 *
 * @author Mummanedi
 * @see BridgeGlobalPublishCountry
 * @generated
 */
public class BridgeGlobalPublishCountryCacheModel implements CacheModel<BridgeGlobalPublishCountry>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{globalPublishCtryId=");
		sb.append(globalPublishCtryId);
		sb.append(", globalPublishId=");
		sb.append(globalPublishId);
		sb.append(", countryCode=");
		sb.append(countryCode);
		sb.append(", publishInd=");
		sb.append(publishInd);
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
	public BridgeGlobalPublishCountry toEntityModel() {
		BridgeGlobalPublishCountryImpl bridgeGlobalPublishCountryImpl = new BridgeGlobalPublishCountryImpl();

		bridgeGlobalPublishCountryImpl.setGlobalPublishCtryId(globalPublishCtryId);
		bridgeGlobalPublishCountryImpl.setGlobalPublishId(globalPublishId);

		if (countryCode == null) {
			bridgeGlobalPublishCountryImpl.setCountryCode(StringPool.BLANK);
		}
		else {
			bridgeGlobalPublishCountryImpl.setCountryCode(countryCode);
		}

		if (publishInd == null) {
			bridgeGlobalPublishCountryImpl.setPublishInd(StringPool.BLANK);
		}
		else {
			bridgeGlobalPublishCountryImpl.setPublishInd(publishInd);
		}

		if (creatorId == null) {
			bridgeGlobalPublishCountryImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			bridgeGlobalPublishCountryImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			bridgeGlobalPublishCountryImpl.setCreatedDate(null);
		}
		else {
			bridgeGlobalPublishCountryImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			bridgeGlobalPublishCountryImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			bridgeGlobalPublishCountryImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			bridgeGlobalPublishCountryImpl.setUpdatedDate(null);
		}
		else {
			bridgeGlobalPublishCountryImpl.setUpdatedDate(new Date(updatedDate));
		}

		bridgeGlobalPublishCountryImpl.resetOriginalValues();

		return bridgeGlobalPublishCountryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		globalPublishCtryId = objectInput.readLong();
		globalPublishId = objectInput.readLong();
		countryCode = objectInput.readUTF();
		publishInd = objectInput.readUTF();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(globalPublishCtryId);
		objectOutput.writeLong(globalPublishId);

		if (countryCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(countryCode);
		}

		if (publishInd == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(publishInd);
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

	public long globalPublishCtryId;
	public long globalPublishId;
	public String countryCode;
	public String publishInd;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}