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

import com.ihg.brandstandards.db.model.GEMTemplateCategory;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing GEMTemplateCategory in entity cache.
 *
 * @author Mummanedi
 * @see GEMTemplateCategory
 * @generated
 */
public class GEMTemplateCategoryCacheModel implements CacheModel<GEMTemplateCategory>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{templateCatgyId=");
		sb.append(templateCatgyId);
		sb.append(", templateId=");
		sb.append(templateId);
		sb.append(", categoryId=");
		sb.append(categoryId);
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
	public GEMTemplateCategory toEntityModel() {
		GEMTemplateCategoryImpl gemTemplateCategoryImpl = new GEMTemplateCategoryImpl();

		gemTemplateCategoryImpl.setTemplateCatgyId(templateCatgyId);
		gemTemplateCategoryImpl.setTemplateId(templateId);
		gemTemplateCategoryImpl.setCategoryId(categoryId);

		if (categoryViewType == null) {
			gemTemplateCategoryImpl.setCategoryViewType(StringPool.BLANK);
		}
		else {
			gemTemplateCategoryImpl.setCategoryViewType(categoryViewType);
		}

		if (categoryAnsAll == null) {
			gemTemplateCategoryImpl.setCategoryAnsAll(StringPool.BLANK);
		}
		else {
			gemTemplateCategoryImpl.setCategoryAnsAll(categoryAnsAll);
		}

		if (duplicatable == null) {
			gemTemplateCategoryImpl.setDuplicatable(StringPool.BLANK);
		}
		else {
			gemTemplateCategoryImpl.setDuplicatable(duplicatable);
		}

		gemTemplateCategoryImpl.setDisplayOrderNumber(displayOrderNumber);

		if (creatorId == null) {
			gemTemplateCategoryImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			gemTemplateCategoryImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			gemTemplateCategoryImpl.setCreatedDate(null);
		}
		else {
			gemTemplateCategoryImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			gemTemplateCategoryImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			gemTemplateCategoryImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			gemTemplateCategoryImpl.setUpdatedDate(null);
		}
		else {
			gemTemplateCategoryImpl.setUpdatedDate(new Date(updatedDate));
		}

		gemTemplateCategoryImpl.resetOriginalValues();

		return gemTemplateCategoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		templateCatgyId = objectInput.readLong();
		templateId = objectInput.readLong();
		categoryId = objectInput.readLong();
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
		objectOutput.writeLong(templateCatgyId);
		objectOutput.writeLong(templateId);
		objectOutput.writeLong(categoryId);

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

	public long templateCatgyId;
	public long templateId;
	public long categoryId;
	public String categoryViewType;
	public String categoryAnsAll;
	public String duplicatable;
	public long displayOrderNumber;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}