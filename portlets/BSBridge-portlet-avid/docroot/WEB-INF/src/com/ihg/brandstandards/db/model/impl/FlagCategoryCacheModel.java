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

import com.ihg.brandstandards.db.model.FlagCategory;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FlagCategory in entity cache.
 *
 * @author Mummanedi
 * @see FlagCategory
 * @generated
 */
public class FlagCategoryCacheModel implements CacheModel<FlagCategory>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{flagCatId=");
		sb.append(flagCatId);
		sb.append(", activeInd=");
		sb.append(activeInd);
		sb.append(", parentCatId=");
		sb.append(parentCatId);
		sb.append(", catOrField=");
		sb.append(catOrField);
		sb.append(", txtValue=");
		sb.append(txtValue);
		sb.append(", orderNumber=");
		sb.append(orderNumber);
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
	public FlagCategory toEntityModel() {
		FlagCategoryImpl flagCategoryImpl = new FlagCategoryImpl();

		flagCategoryImpl.setFlagCatId(flagCatId);

		if (activeInd == null) {
			flagCategoryImpl.setActiveInd(StringPool.BLANK);
		}
		else {
			flagCategoryImpl.setActiveInd(activeInd);
		}

		flagCategoryImpl.setParentCatId(parentCatId);

		if (catOrField == null) {
			flagCategoryImpl.setCatOrField(StringPool.BLANK);
		}
		else {
			flagCategoryImpl.setCatOrField(catOrField);
		}

		if (txtValue == null) {
			flagCategoryImpl.setTxtValue(StringPool.BLANK);
		}
		else {
			flagCategoryImpl.setTxtValue(txtValue);
		}

		flagCategoryImpl.setOrderNumber(orderNumber);

		if (creatorId == null) {
			flagCategoryImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			flagCategoryImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			flagCategoryImpl.setCreatedDate(null);
		}
		else {
			flagCategoryImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			flagCategoryImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			flagCategoryImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			flagCategoryImpl.setUpdatedDate(null);
		}
		else {
			flagCategoryImpl.setUpdatedDate(new Date(updatedDate));
		}

		flagCategoryImpl.resetOriginalValues();

		return flagCategoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		flagCatId = objectInput.readLong();
		activeInd = objectInput.readUTF();
		parentCatId = objectInput.readLong();
		catOrField = objectInput.readUTF();
		txtValue = objectInput.readUTF();
		orderNumber = objectInput.readLong();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(flagCatId);

		if (activeInd == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(activeInd);
		}

		objectOutput.writeLong(parentCatId);

		if (catOrField == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(catOrField);
		}

		if (txtValue == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(txtValue);
		}

		objectOutput.writeLong(orderNumber);

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

	public long flagCatId;
	public String activeInd;
	public long parentCatId;
	public String catOrField;
	public String txtValue;
	public long orderNumber;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}