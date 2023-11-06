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

import com.ihg.brandstandards.db.model.GlossaryTranslate;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing GlossaryTranslate in entity cache.
 *
 * @author Mummanedi
 * @see GlossaryTranslate
 * @generated
 */
public class GlossaryTranslateCacheModel implements CacheModel<GlossaryTranslate>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{glossaryXlatId=");
		sb.append(glossaryXlatId);
		sb.append(", glossaryId=");
		sb.append(glossaryId);
		sb.append(", langCode=");
		sb.append(langCode);
		sb.append(", glossaryTermText=");
		sb.append(glossaryTermText);
		sb.append(", glossaryTermDesc=");
		sb.append(glossaryTermDesc);
		sb.append(", isValidTermTxt=");
		sb.append(isValidTermTxt);
		sb.append(", isValidDescTxt=");
		sb.append(isValidDescTxt);
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
	public GlossaryTranslate toEntityModel() {
		GlossaryTranslateImpl glossaryTranslateImpl = new GlossaryTranslateImpl();

		glossaryTranslateImpl.setGlossaryXlatId(glossaryXlatId);
		glossaryTranslateImpl.setGlossaryId(glossaryId);

		if (langCode == null) {
			glossaryTranslateImpl.setLangCode(StringPool.BLANK);
		}
		else {
			glossaryTranslateImpl.setLangCode(langCode);
		}

		if (glossaryTermText == null) {
			glossaryTranslateImpl.setGlossaryTermText(StringPool.BLANK);
		}
		else {
			glossaryTranslateImpl.setGlossaryTermText(glossaryTermText);
		}

		if (glossaryTermDesc == null) {
			glossaryTranslateImpl.setGlossaryTermDesc(StringPool.BLANK);
		}
		else {
			glossaryTranslateImpl.setGlossaryTermDesc(glossaryTermDesc);
		}

		if (isValidTermTxt == null) {
			glossaryTranslateImpl.setIsValidTermTxt(StringPool.BLANK);
		}
		else {
			glossaryTranslateImpl.setIsValidTermTxt(isValidTermTxt);
		}

		if (isValidDescTxt == null) {
			glossaryTranslateImpl.setIsValidDescTxt(StringPool.BLANK);
		}
		else {
			glossaryTranslateImpl.setIsValidDescTxt(isValidDescTxt);
		}

		if (creatorId == null) {
			glossaryTranslateImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			glossaryTranslateImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			glossaryTranslateImpl.setCreatedDate(null);
		}
		else {
			glossaryTranslateImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			glossaryTranslateImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			glossaryTranslateImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			glossaryTranslateImpl.setUpdatedDate(null);
		}
		else {
			glossaryTranslateImpl.setUpdatedDate(new Date(updatedDate));
		}

		glossaryTranslateImpl.resetOriginalValues();

		return glossaryTranslateImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		glossaryXlatId = objectInput.readLong();
		glossaryId = objectInput.readLong();
		langCode = objectInput.readUTF();
		glossaryTermText = objectInput.readUTF();
		glossaryTermDesc = objectInput.readUTF();
		isValidTermTxt = objectInput.readUTF();
		isValidDescTxt = objectInput.readUTF();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(glossaryXlatId);
		objectOutput.writeLong(glossaryId);

		if (langCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(langCode);
		}

		if (glossaryTermText == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(glossaryTermText);
		}

		if (glossaryTermDesc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(glossaryTermDesc);
		}

		if (isValidTermTxt == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(isValidTermTxt);
		}

		if (isValidDescTxt == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(isValidDescTxt);
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

	public long glossaryXlatId;
	public long glossaryId;
	public String langCode;
	public String glossaryTermText;
	public String glossaryTermDesc;
	public String isValidTermTxt;
	public String isValidDescTxt;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}