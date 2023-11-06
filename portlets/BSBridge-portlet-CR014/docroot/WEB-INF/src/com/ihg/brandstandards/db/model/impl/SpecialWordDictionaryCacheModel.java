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

import com.ihg.brandstandards.db.model.SpecialWordDictionary;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SpecialWordDictionary in entity cache.
 *
 * @author Mummanedi
 * @see SpecialWordDictionary
 * @generated
 */
public class SpecialWordDictionaryCacheModel implements CacheModel<SpecialWordDictionary>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{specialWordId=");
		sb.append(specialWordId);
		sb.append(", replacedWordTxt=");
		sb.append(replacedWordTxt);
		sb.append(", replacementWordTxt=");
		sb.append(replacementWordTxt);
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
	public SpecialWordDictionary toEntityModel() {
		SpecialWordDictionaryImpl specialWordDictionaryImpl = new SpecialWordDictionaryImpl();

		specialWordDictionaryImpl.setSpecialWordId(specialWordId);

		if (replacedWordTxt == null) {
			specialWordDictionaryImpl.setReplacedWordTxt(StringPool.BLANK);
		}
		else {
			specialWordDictionaryImpl.setReplacedWordTxt(replacedWordTxt);
		}

		if (replacementWordTxt == null) {
			specialWordDictionaryImpl.setReplacementWordTxt(StringPool.BLANK);
		}
		else {
			specialWordDictionaryImpl.setReplacementWordTxt(replacementWordTxt);
		}

		if (localeCode == null) {
			specialWordDictionaryImpl.setLocaleCode(StringPool.BLANK);
		}
		else {
			specialWordDictionaryImpl.setLocaleCode(localeCode);
		}

		if (creatorId == null) {
			specialWordDictionaryImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			specialWordDictionaryImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			specialWordDictionaryImpl.setCreatedDate(null);
		}
		else {
			specialWordDictionaryImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			specialWordDictionaryImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			specialWordDictionaryImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			specialWordDictionaryImpl.setUpdatedDate(null);
		}
		else {
			specialWordDictionaryImpl.setUpdatedDate(new Date(updatedDate));
		}

		specialWordDictionaryImpl.resetOriginalValues();

		return specialWordDictionaryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		specialWordId = objectInput.readLong();
		replacedWordTxt = objectInput.readUTF();
		replacementWordTxt = objectInput.readUTF();
		localeCode = objectInput.readUTF();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(specialWordId);

		if (replacedWordTxt == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(replacedWordTxt);
		}

		if (replacementWordTxt == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(replacementWordTxt);
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

	public long specialWordId;
	public String replacedWordTxt;
	public String replacementWordTxt;
	public String localeCode;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}