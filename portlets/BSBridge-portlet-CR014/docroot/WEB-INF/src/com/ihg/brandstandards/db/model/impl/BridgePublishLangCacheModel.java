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

import com.ihg.brandstandards.db.model.BridgePublishLang;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing BridgePublishLang in entity cache.
 *
 * @author Mummanedi
 * @see BridgePublishLang
 * @generated
 */
public class BridgePublishLangCacheModel implements CacheModel<BridgePublishLang>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{publishLangId=");
		sb.append(publishLangId);
		sb.append(", publishId=");
		sb.append(publishId);
		sb.append(", regionId=");
		sb.append(regionId);
		sb.append(", localeCode=");
		sb.append(localeCode);
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
	public BridgePublishLang toEntityModel() {
		BridgePublishLangImpl bridgePublishLangImpl = new BridgePublishLangImpl();

		bridgePublishLangImpl.setPublishLangId(publishLangId);
		bridgePublishLangImpl.setPublishId(publishId);
		bridgePublishLangImpl.setRegionId(regionId);

		if (localeCode == null) {
			bridgePublishLangImpl.setLocaleCode(StringPool.BLANK);
		}
		else {
			bridgePublishLangImpl.setLocaleCode(localeCode);
		}

		if (creatorId == null) {
			bridgePublishLangImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			bridgePublishLangImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			bridgePublishLangImpl.setCreatedDate(null);
		}
		else {
			bridgePublishLangImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			bridgePublishLangImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			bridgePublishLangImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			bridgePublishLangImpl.setUpdatedDate(null);
		}
		else {
			bridgePublishLangImpl.setUpdatedDate(new Date(updatedDate));
		}

		bridgePublishLangImpl.resetOriginalValues();

		return bridgePublishLangImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		publishLangId = objectInput.readLong();
		publishId = objectInput.readLong();
		regionId = objectInput.readLong();
		localeCode = objectInput.readUTF();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(publishLangId);
		objectOutput.writeLong(publishId);
		objectOutput.writeLong(regionId);

		if (localeCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(localeCode);
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

	public long publishLangId;
	public long publishId;
	public long regionId;
	public String localeCode;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}