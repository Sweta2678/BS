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

import com.ihg.brandstandards.db.model.BridgePublishCountry;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing BridgePublishCountry in entity cache.
 *
 * @author Mummanedi
 * @see BridgePublishCountry
 * @generated
 */
public class BridgePublishCountryCacheModel implements CacheModel<BridgePublishCountry>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{publishCtryId=");
		sb.append(publishCtryId);
		sb.append(", bridgePublishId=");
		sb.append(bridgePublishId);
		sb.append(", countryCode=");
		sb.append(countryCode);
		sb.append(", statusCode=");
		sb.append(statusCode);
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
	public BridgePublishCountry toEntityModel() {
		BridgePublishCountryImpl bridgePublishCountryImpl = new BridgePublishCountryImpl();

		bridgePublishCountryImpl.setPublishCtryId(publishCtryId);
		bridgePublishCountryImpl.setBridgePublishId(bridgePublishId);

		if (countryCode == null) {
			bridgePublishCountryImpl.setCountryCode(StringPool.BLANK);
		}
		else {
			bridgePublishCountryImpl.setCountryCode(countryCode);
		}

		if (statusCode == null) {
			bridgePublishCountryImpl.setStatusCode(StringPool.BLANK);
		}
		else {
			bridgePublishCountryImpl.setStatusCode(statusCode);
		}

		if (publishInd == null) {
			bridgePublishCountryImpl.setPublishInd(StringPool.BLANK);
		}
		else {
			bridgePublishCountryImpl.setPublishInd(publishInd);
		}

		if (creatorId == null) {
			bridgePublishCountryImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			bridgePublishCountryImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			bridgePublishCountryImpl.setCreatedDate(null);
		}
		else {
			bridgePublishCountryImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			bridgePublishCountryImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			bridgePublishCountryImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			bridgePublishCountryImpl.setUpdatedDate(null);
		}
		else {
			bridgePublishCountryImpl.setUpdatedDate(new Date(updatedDate));
		}

		bridgePublishCountryImpl.resetOriginalValues();

		return bridgePublishCountryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		publishCtryId = objectInput.readLong();
		bridgePublishId = objectInput.readLong();
		countryCode = objectInput.readUTF();
		statusCode = objectInput.readUTF();
		publishInd = objectInput.readUTF();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(publishCtryId);
		objectOutput.writeLong(bridgePublishId);

		if (countryCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(countryCode);
		}

		if (statusCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(statusCode);
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

	public long publishCtryId;
	public long bridgePublishId;
	public String countryCode;
	public String statusCode;
	public String publishInd;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}