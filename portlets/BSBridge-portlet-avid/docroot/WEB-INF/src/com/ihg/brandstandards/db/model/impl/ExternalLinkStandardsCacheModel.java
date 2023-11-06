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

import com.ihg.brandstandards.db.model.ExternalLinkStandards;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ExternalLinkStandards in entity cache.
 *
 * @author Mummanedi
 * @see ExternalLinkStandards
 * @generated
 */
public class ExternalLinkStandardsCacheModel implements CacheModel<ExternalLinkStandards>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{extLinkId=");
		sb.append(extLinkId);
		sb.append(", parentExtLinkId=");
		sb.append(parentExtLinkId);
		sb.append(", stdId=");
		sb.append(stdId);
		sb.append(", url=");
		sb.append(url);
		sb.append(", title=");
		sb.append(title);
		sb.append(", translationIndicator=");
		sb.append(translationIndicator);
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
	public ExternalLinkStandards toEntityModel() {
		ExternalLinkStandardsImpl externalLinkStandardsImpl = new ExternalLinkStandardsImpl();

		externalLinkStandardsImpl.setExtLinkId(extLinkId);
		externalLinkStandardsImpl.setParentExtLinkId(parentExtLinkId);
		externalLinkStandardsImpl.setStdId(stdId);

		if (url == null) {
			externalLinkStandardsImpl.setUrl(StringPool.BLANK);
		}
		else {
			externalLinkStandardsImpl.setUrl(url);
		}

		if (title == null) {
			externalLinkStandardsImpl.setTitle(StringPool.BLANK);
		}
		else {
			externalLinkStandardsImpl.setTitle(title);
		}

		if (translationIndicator == null) {
			externalLinkStandardsImpl.setTranslationIndicator(StringPool.BLANK);
		}
		else {
			externalLinkStandardsImpl.setTranslationIndicator(translationIndicator);
		}

		if (localeCode == null) {
			externalLinkStandardsImpl.setLocaleCode(StringPool.BLANK);
		}
		else {
			externalLinkStandardsImpl.setLocaleCode(localeCode);
		}

		if (creatorId == null) {
			externalLinkStandardsImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			externalLinkStandardsImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			externalLinkStandardsImpl.setCreatedDate(null);
		}
		else {
			externalLinkStandardsImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			externalLinkStandardsImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			externalLinkStandardsImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			externalLinkStandardsImpl.setUpdatedDate(null);
		}
		else {
			externalLinkStandardsImpl.setUpdatedDate(new Date(updatedDate));
		}

		externalLinkStandardsImpl.resetOriginalValues();

		return externalLinkStandardsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		extLinkId = objectInput.readLong();
		parentExtLinkId = objectInput.readLong();
		stdId = objectInput.readLong();
		url = objectInput.readUTF();
		title = objectInput.readUTF();
		translationIndicator = objectInput.readUTF();
		localeCode = objectInput.readUTF();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(extLinkId);
		objectOutput.writeLong(parentExtLinkId);
		objectOutput.writeLong(stdId);

		if (url == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(url);
		}

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (translationIndicator == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(translationIndicator);
		}

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

	public long extLinkId;
	public long parentExtLinkId;
	public long stdId;
	public String url;
	public String title;
	public String translationIndicator;
	public String localeCode;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}