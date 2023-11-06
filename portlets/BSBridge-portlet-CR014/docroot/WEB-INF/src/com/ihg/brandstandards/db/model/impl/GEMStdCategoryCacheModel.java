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

import com.ihg.brandstandards.db.model.GEMStdCategory;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing GEMStdCategory in entity cache.
 *
 * @author Mummanedi
 * @see GEMStdCategory
 * @generated
 */
public class GEMStdCategoryCacheModel implements CacheModel<GEMStdCategory>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{gemStdCategoryId=");
		sb.append(gemStdCategoryId);
		sb.append(", stdId=");
		sb.append(stdId);
		sb.append(", categoryId=");
		sb.append(categoryId);
		sb.append(", templateType=");
		sb.append(templateType);
		sb.append(", chainCode=");
		sb.append(chainCode);
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
	public GEMStdCategory toEntityModel() {
		GEMStdCategoryImpl gemStdCategoryImpl = new GEMStdCategoryImpl();

		gemStdCategoryImpl.setGemStdCategoryId(gemStdCategoryId);
		gemStdCategoryImpl.setStdId(stdId);
		gemStdCategoryImpl.setCategoryId(categoryId);

		if (templateType == null) {
			gemStdCategoryImpl.setTemplateType(StringPool.BLANK);
		}
		else {
			gemStdCategoryImpl.setTemplateType(templateType);
		}

		if (chainCode == null) {
			gemStdCategoryImpl.setChainCode(StringPool.BLANK);
		}
		else {
			gemStdCategoryImpl.setChainCode(chainCode);
		}

		if (creatorId == null) {
			gemStdCategoryImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			gemStdCategoryImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			gemStdCategoryImpl.setCreatedDate(null);
		}
		else {
			gemStdCategoryImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			gemStdCategoryImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			gemStdCategoryImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			gemStdCategoryImpl.setUpdatedDate(null);
		}
		else {
			gemStdCategoryImpl.setUpdatedDate(new Date(updatedDate));
		}

		gemStdCategoryImpl.resetOriginalValues();

		return gemStdCategoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		gemStdCategoryId = objectInput.readLong();
		stdId = objectInput.readLong();
		categoryId = objectInput.readLong();
		templateType = objectInput.readUTF();
		chainCode = objectInput.readUTF();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(gemStdCategoryId);
		objectOutput.writeLong(stdId);
		objectOutput.writeLong(categoryId);

		if (templateType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(templateType);
		}

		if (chainCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(chainCode);
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

	public long gemStdCategoryId;
	public long stdId;
	public long categoryId;
	public String templateType;
	public String chainCode;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}