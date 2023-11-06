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

import com.ihg.brandstandards.db.model.UIElement;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing UIElement in entity cache.
 *
 * @author Mummanedi
 * @see UIElement
 * @generated
 */
public class UIElementCacheModel implements CacheModel<UIElement>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{elementId=");
		sb.append(elementId);
		sb.append(", elementKey=");
		sb.append(elementKey);
		sb.append(", moduleName=");
		sb.append(moduleName);
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
	public UIElement toEntityModel() {
		UIElementImpl uiElementImpl = new UIElementImpl();

		uiElementImpl.setElementId(elementId);

		if (elementKey == null) {
			uiElementImpl.setElementKey(StringPool.BLANK);
		}
		else {
			uiElementImpl.setElementKey(elementKey);
		}

		if (moduleName == null) {
			uiElementImpl.setModuleName(StringPool.BLANK);
		}
		else {
			uiElementImpl.setModuleName(moduleName);
		}

		if (creatorId == null) {
			uiElementImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			uiElementImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			uiElementImpl.setCreatedDate(null);
		}
		else {
			uiElementImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			uiElementImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			uiElementImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			uiElementImpl.setUpdatedDate(null);
		}
		else {
			uiElementImpl.setUpdatedDate(new Date(updatedDate));
		}

		uiElementImpl.resetOriginalValues();

		return uiElementImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		elementId = objectInput.readLong();
		elementKey = objectInput.readUTF();
		moduleName = objectInput.readUTF();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(elementId);

		if (elementKey == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(elementKey);
		}

		if (moduleName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(moduleName);
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
	public String elementKey;
	public String moduleName;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}