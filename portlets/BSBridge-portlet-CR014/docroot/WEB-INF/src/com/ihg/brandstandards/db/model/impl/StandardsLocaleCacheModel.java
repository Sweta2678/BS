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

import com.ihg.brandstandards.db.model.StandardsLocale;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing StandardsLocale in entity cache.
 *
 * @author Mummanedi
 * @see StandardsLocale
 * @generated
 */
public class StandardsLocaleCacheModel implements CacheModel<StandardsLocale>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{localeCode=");
		sb.append(localeCode);
		sb.append(", countryCode=");
		sb.append(countryCode);
		sb.append(", localeName=");
		sb.append(localeName);
		sb.append(", languageCode=");
		sb.append(languageCode);
		sb.append(", orderNumber=");
		sb.append(orderNumber);
		sb.append(", isActive=");
		sb.append(isActive);
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
	public StandardsLocale toEntityModel() {
		StandardsLocaleImpl standardsLocaleImpl = new StandardsLocaleImpl();

		if (localeCode == null) {
			standardsLocaleImpl.setLocaleCode(StringPool.BLANK);
		}
		else {
			standardsLocaleImpl.setLocaleCode(localeCode);
		}

		if (countryCode == null) {
			standardsLocaleImpl.setCountryCode(StringPool.BLANK);
		}
		else {
			standardsLocaleImpl.setCountryCode(countryCode);
		}

		if (localeName == null) {
			standardsLocaleImpl.setLocaleName(StringPool.BLANK);
		}
		else {
			standardsLocaleImpl.setLocaleName(localeName);
		}

		if (languageCode == null) {
			standardsLocaleImpl.setLanguageCode(StringPool.BLANK);
		}
		else {
			standardsLocaleImpl.setLanguageCode(languageCode);
		}

		standardsLocaleImpl.setOrderNumber(orderNumber);

		if (isActive == null) {
			standardsLocaleImpl.setIsActive(StringPool.BLANK);
		}
		else {
			standardsLocaleImpl.setIsActive(isActive);
		}

		if (creatorId == null) {
			standardsLocaleImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			standardsLocaleImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			standardsLocaleImpl.setCreatedDate(null);
		}
		else {
			standardsLocaleImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			standardsLocaleImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			standardsLocaleImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			standardsLocaleImpl.setUpdatedDate(null);
		}
		else {
			standardsLocaleImpl.setUpdatedDate(new Date(updatedDate));
		}

		standardsLocaleImpl.resetOriginalValues();

		return standardsLocaleImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		localeCode = objectInput.readUTF();
		countryCode = objectInput.readUTF();
		localeName = objectInput.readUTF();
		languageCode = objectInput.readUTF();
		orderNumber = objectInput.readLong();
		isActive = objectInput.readUTF();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (localeCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(localeCode);
		}

		if (countryCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(countryCode);
		}

		if (localeName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(localeName);
		}

		if (languageCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(languageCode);
		}

		objectOutput.writeLong(orderNumber);

		if (isActive == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(isActive);
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

	public String localeCode;
	public String countryCode;
	public String localeName;
	public String languageCode;
	public long orderNumber;
	public String isActive;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}