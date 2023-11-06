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

import com.ihg.brandstandards.db.model.GEMTemplateValues;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing GEMTemplateValues in entity cache.
 *
 * @author Mummanedi
 * @see GEMTemplateValues
 * @generated
 */
public class GEMTemplateValuesCacheModel implements CacheModel<GEMTemplateValues>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{valueId=");
		sb.append(valueId);
		sb.append(", columnId=");
		sb.append(columnId);
		sb.append(", categoryId=");
		sb.append(categoryId);
		sb.append(", columnValue=");
		sb.append(columnValue);
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
	public GEMTemplateValues toEntityModel() {
		GEMTemplateValuesImpl gemTemplateValuesImpl = new GEMTemplateValuesImpl();

		gemTemplateValuesImpl.setValueId(valueId);
		gemTemplateValuesImpl.setColumnId(columnId);
		gemTemplateValuesImpl.setCategoryId(categoryId);

		if (columnValue == null) {
			gemTemplateValuesImpl.setColumnValue(StringPool.BLANK);
		}
		else {
			gemTemplateValuesImpl.setColumnValue(columnValue);
		}

		gemTemplateValuesImpl.setDisplayOrderNumber(displayOrderNumber);

		if (creatorId == null) {
			gemTemplateValuesImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			gemTemplateValuesImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			gemTemplateValuesImpl.setCreatedDate(null);
		}
		else {
			gemTemplateValuesImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			gemTemplateValuesImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			gemTemplateValuesImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			gemTemplateValuesImpl.setUpdatedDate(null);
		}
		else {
			gemTemplateValuesImpl.setUpdatedDate(new Date(updatedDate));
		}

		gemTemplateValuesImpl.resetOriginalValues();

		return gemTemplateValuesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		valueId = objectInput.readLong();
		columnId = objectInput.readLong();
		categoryId = objectInput.readLong();
		columnValue = objectInput.readUTF();
		displayOrderNumber = objectInput.readLong();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(valueId);
		objectOutput.writeLong(columnId);
		objectOutput.writeLong(categoryId);

		if (columnValue == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(columnValue);
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

	public long valueId;
	public long columnId;
	public long categoryId;
	public String columnValue;
	public long displayOrderNumber;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}