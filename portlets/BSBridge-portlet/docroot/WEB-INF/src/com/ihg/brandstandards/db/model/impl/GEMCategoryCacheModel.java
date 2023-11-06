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

import com.ihg.brandstandards.db.model.GEMCategory;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing GEMCategory in entity cache.
 *
 * @author Mummanedi
 * @see GEMCategory
 * @generated
 */
public class GEMCategoryCacheModel implements CacheModel<GEMCategory>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{categoryId=");
		sb.append(categoryId);
		sb.append(", cmsCategoryId=");
		sb.append(cmsCategoryId);
		sb.append(", gemCategoryCode=");
		sb.append(gemCategoryCode);
		sb.append(", gemPrntCategoryId=");
		sb.append(gemPrntCategoryId);
		sb.append(", categoryName=");
		sb.append(categoryName);
		sb.append(", categoryViewType=");
		sb.append(categoryViewType);
		sb.append(", categoryAnsAll=");
		sb.append(categoryAnsAll);
		sb.append(", duplicatable=");
		sb.append(duplicatable);
		sb.append(", displayOrderNumber=");
		sb.append(displayOrderNumber);
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
	public GEMCategory toEntityModel() {
		GEMCategoryImpl gemCategoryImpl = new GEMCategoryImpl();

		gemCategoryImpl.setCategoryId(categoryId);
		gemCategoryImpl.setCmsCategoryId(cmsCategoryId);

		if (gemCategoryCode == null) {
			gemCategoryImpl.setGemCategoryCode(StringPool.BLANK);
		}
		else {
			gemCategoryImpl.setGemCategoryCode(gemCategoryCode);
		}

		if (gemPrntCategoryId == null) {
			gemCategoryImpl.setGemPrntCategoryId(StringPool.BLANK);
		}
		else {
			gemCategoryImpl.setGemPrntCategoryId(gemPrntCategoryId);
		}

		if (categoryName == null) {
			gemCategoryImpl.setCategoryName(StringPool.BLANK);
		}
		else {
			gemCategoryImpl.setCategoryName(categoryName);
		}

		if (categoryViewType == null) {
			gemCategoryImpl.setCategoryViewType(StringPool.BLANK);
		}
		else {
			gemCategoryImpl.setCategoryViewType(categoryViewType);
		}

		if (categoryAnsAll == null) {
			gemCategoryImpl.setCategoryAnsAll(StringPool.BLANK);
		}
		else {
			gemCategoryImpl.setCategoryAnsAll(categoryAnsAll);
		}

		if (duplicatable == null) {
			gemCategoryImpl.setDuplicatable(StringPool.BLANK);
		}
		else {
			gemCategoryImpl.setDuplicatable(duplicatable);
		}

		gemCategoryImpl.setDisplayOrderNumber(displayOrderNumber);

		if (creatorId == null) {
			gemCategoryImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			gemCategoryImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			gemCategoryImpl.setCreatedDate(null);
		}
		else {
			gemCategoryImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			gemCategoryImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			gemCategoryImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			gemCategoryImpl.setUpdatedDate(null);
		}
		else {
			gemCategoryImpl.setUpdatedDate(new Date(updatedDate));
		}

		gemCategoryImpl.resetOriginalValues();

		return gemCategoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		categoryId = objectInput.readLong();
		cmsCategoryId = objectInput.readLong();
		gemCategoryCode = objectInput.readUTF();
		gemPrntCategoryId = objectInput.readUTF();
		categoryName = objectInput.readUTF();
		categoryViewType = objectInput.readUTF();
		categoryAnsAll = objectInput.readUTF();
		duplicatable = objectInput.readUTF();
		displayOrderNumber = objectInput.readLong();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(categoryId);
		objectOutput.writeLong(cmsCategoryId);

		if (gemCategoryCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(gemCategoryCode);
		}

		if (gemPrntCategoryId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(gemPrntCategoryId);
		}

		if (categoryName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(categoryName);
		}

		if (categoryViewType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(categoryViewType);
		}

		if (categoryAnsAll == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(categoryAnsAll);
		}

		if (duplicatable == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(duplicatable);
		}

		objectOutput.writeLong(displayOrderNumber);

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

	public long categoryId;
	public long cmsCategoryId;
	public String gemCategoryCode;
	public String gemPrntCategoryId;
	public String categoryName;
	public String categoryViewType;
	public String categoryAnsAll;
	public String duplicatable;
	public long displayOrderNumber;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}