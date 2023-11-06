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

import com.ihg.brandstandards.db.model.GEMTemplateColumn;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing GEMTemplateColumn in entity cache.
 *
 * @author Mummanedi
 * @see GEMTemplateColumn
 * @generated
 */
public class GEMTemplateColumnCacheModel implements CacheModel<GEMTemplateColumn>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{columnId=");
		sb.append(columnId);
		sb.append(", templateId=");
		sb.append(templateId);
		sb.append(", columnName=");
		sb.append(columnName);
		sb.append(", valueType=");
		sb.append(valueType);
		sb.append(", defaultValue=");
		sb.append(defaultValue);
		sb.append(", isMandatory=");
		sb.append(isMandatory);
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
	public GEMTemplateColumn toEntityModel() {
		GEMTemplateColumnImpl gemTemplateColumnImpl = new GEMTemplateColumnImpl();

		gemTemplateColumnImpl.setColumnId(columnId);
		gemTemplateColumnImpl.setTemplateId(templateId);

		if (columnName == null) {
			gemTemplateColumnImpl.setColumnName(StringPool.BLANK);
		}
		else {
			gemTemplateColumnImpl.setColumnName(columnName);
		}

		if (valueType == null) {
			gemTemplateColumnImpl.setValueType(StringPool.BLANK);
		}
		else {
			gemTemplateColumnImpl.setValueType(valueType);
		}

		if (defaultValue == null) {
			gemTemplateColumnImpl.setDefaultValue(StringPool.BLANK);
		}
		else {
			gemTemplateColumnImpl.setDefaultValue(defaultValue);
		}

		if (isMandatory == null) {
			gemTemplateColumnImpl.setIsMandatory(StringPool.BLANK);
		}
		else {
			gemTemplateColumnImpl.setIsMandatory(isMandatory);
		}

		gemTemplateColumnImpl.setDisplayOrderNumber(displayOrderNumber);

		if (creatorId == null) {
			gemTemplateColumnImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			gemTemplateColumnImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			gemTemplateColumnImpl.setCreatedDate(null);
		}
		else {
			gemTemplateColumnImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			gemTemplateColumnImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			gemTemplateColumnImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			gemTemplateColumnImpl.setUpdatedDate(null);
		}
		else {
			gemTemplateColumnImpl.setUpdatedDate(new Date(updatedDate));
		}

		gemTemplateColumnImpl.resetOriginalValues();

		return gemTemplateColumnImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		columnId = objectInput.readLong();
		templateId = objectInput.readLong();
		columnName = objectInput.readUTF();
		valueType = objectInput.readUTF();
		defaultValue = objectInput.readUTF();
		isMandatory = objectInput.readUTF();
		displayOrderNumber = objectInput.readLong();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(columnId);
		objectOutput.writeLong(templateId);

		if (columnName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(columnName);
		}

		if (valueType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(valueType);
		}

		if (defaultValue == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(defaultValue);
		}

		if (isMandatory == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(isMandatory);
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

	public long columnId;
	public long templateId;
	public String columnName;
	public String valueType;
	public String defaultValue;
	public String isMandatory;
	public long displayOrderNumber;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}