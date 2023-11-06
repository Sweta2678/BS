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

import com.ihg.brandstandards.db.model.UIElementTranslate;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing UIElementTranslate in entity cache.
 *
 * @author Mummanedi
 * @see UIElementTranslate
 * @generated
 */
public class UIElementTranslateCacheModel implements CacheModel<UIElementTranslate>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{elementId=");
		sb.append(elementId);
		sb.append(", localeCode=");
		sb.append(localeCode);
		sb.append(", elementValue=");
		sb.append(elementValue);
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
	public UIElementTranslate toEntityModel() {
		UIElementTranslateImpl uiElementTranslateImpl = new UIElementTranslateImpl();

		uiElementTranslateImpl.setElementId(elementId);

		if (localeCode == null) {
			uiElementTranslateImpl.setLocaleCode(StringPool.BLANK);
		}
		else {
			uiElementTranslateImpl.setLocaleCode(localeCode);
		}

		if (elementValue == null) {
			uiElementTranslateImpl.setElementValue(StringPool.BLANK);
		}
		else {
			uiElementTranslateImpl.setElementValue(elementValue);
		}

		if (creatorId == null) {
			uiElementTranslateImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			uiElementTranslateImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			uiElementTranslateImpl.setCreatedDate(null);
		}
		else {
			uiElementTranslateImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			uiElementTranslateImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			uiElementTranslateImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			uiElementTranslateImpl.setUpdatedDate(null);
		}
		else {
			uiElementTranslateImpl.setUpdatedDate(new Date(updatedDate));
		}

		uiElementTranslateImpl.resetOriginalValues();

		return uiElementTranslateImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		elementId = objectInput.readLong();
		localeCode = objectInput.readUTF();
		elementValue = objectInput.readUTF();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(elementId);

		if (localeCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(localeCode);
		}

		if (elementValue == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(elementValue);
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

	public long elementId;
	public String localeCode;
	public String elementValue;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}