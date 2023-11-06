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

import com.ihg.brandstandards.db.model.StandardsTranslate;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing StandardsTranslate in entity cache.
 *
 * @author Mummanedi
 * @see StandardsTranslate
 * @generated
 */
public class StandardsTranslateCacheModel implements CacheModel<StandardsTranslate>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{stdId=");
		sb.append(stdId);
		sb.append(", localeCode=");
		sb.append(localeCode);
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append(", note=");
		sb.append(note);
		sb.append(", comment=");
		sb.append(comment);
		sb.append(", creatorId=");
		sb.append(creatorId);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", updatedBy=");
		sb.append(updatedBy);
		sb.append(", updatedDate=");
		sb.append(updatedDate);
		sb.append(", isValidTxt=");
		sb.append(isValidTxt);
		sb.append(", isValidCntxt=");
		sb.append(isValidCntxt);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public StandardsTranslate toEntityModel() {
		StandardsTranslateImpl standardsTranslateImpl = new StandardsTranslateImpl();

		standardsTranslateImpl.setStdId(stdId);

		if (localeCode == null) {
			standardsTranslateImpl.setLocaleCode(StringPool.BLANK);
		}
		else {
			standardsTranslateImpl.setLocaleCode(localeCode);
		}

		if (title == null) {
			standardsTranslateImpl.setTitle(StringPool.BLANK);
		}
		else {
			standardsTranslateImpl.setTitle(title);
		}

		if (description == null) {
			standardsTranslateImpl.setDescription(StringPool.BLANK);
		}
		else {
			standardsTranslateImpl.setDescription(description);
		}

		if (note == null) {
			standardsTranslateImpl.setNote(StringPool.BLANK);
		}
		else {
			standardsTranslateImpl.setNote(note);
		}

		if (comment == null) {
			standardsTranslateImpl.setComment(StringPool.BLANK);
		}
		else {
			standardsTranslateImpl.setComment(comment);
		}

		if (creatorId == null) {
			standardsTranslateImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			standardsTranslateImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			standardsTranslateImpl.setCreatedDate(null);
		}
		else {
			standardsTranslateImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			standardsTranslateImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			standardsTranslateImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			standardsTranslateImpl.setUpdatedDate(null);
		}
		else {
			standardsTranslateImpl.setUpdatedDate(new Date(updatedDate));
		}

		if (isValidTxt == null) {
			standardsTranslateImpl.setIsValidTxt(StringPool.BLANK);
		}
		else {
			standardsTranslateImpl.setIsValidTxt(isValidTxt);
		}

		if (isValidCntxt == null) {
			standardsTranslateImpl.setIsValidCntxt(StringPool.BLANK);
		}
		else {
			standardsTranslateImpl.setIsValidCntxt(isValidCntxt);
		}

		standardsTranslateImpl.resetOriginalValues();

		return standardsTranslateImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		stdId = objectInput.readLong();
		localeCode = objectInput.readUTF();
		title = objectInput.readUTF();
		description = objectInput.readUTF();
		note = objectInput.readUTF();
		comment = objectInput.readUTF();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
		isValidTxt = objectInput.readUTF();
		isValidCntxt = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(stdId);

		if (localeCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(localeCode);
		}

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (note == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(note);
		}

		if (comment == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(comment);
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

		if (isValidTxt == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(isValidTxt);
		}

		if (isValidCntxt == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(isValidCntxt);
		}
	}

	public long stdId;
	public String localeCode;
	public String title;
	public String description;
	public String note;
	public String comment;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
	public String isValidTxt;
	public String isValidCntxt;
}