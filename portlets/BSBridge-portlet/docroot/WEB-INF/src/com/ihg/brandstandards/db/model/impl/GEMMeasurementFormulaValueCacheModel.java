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

import com.ihg.brandstandards.db.model.GEMMeasurementFormulaValue;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing GEMMeasurementFormulaValue in entity cache.
 *
 * @author Mummanedi
 * @see GEMMeasurementFormulaValue
 * @generated
 */
public class GEMMeasurementFormulaValueCacheModel implements CacheModel<GEMMeasurementFormulaValue>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{formulaValueId=");
		sb.append(formulaValueId);
		sb.append(", formulaId=");
		sb.append(formulaId);
		sb.append(", formulaType=");
		sb.append(formulaType);
		sb.append(", formulaValue=");
		sb.append(formulaValue);
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
	public GEMMeasurementFormulaValue toEntityModel() {
		GEMMeasurementFormulaValueImpl gemMeasurementFormulaValueImpl = new GEMMeasurementFormulaValueImpl();

		gemMeasurementFormulaValueImpl.setFormulaValueId(formulaValueId);
		gemMeasurementFormulaValueImpl.setFormulaId(formulaId);

		if (formulaType == null) {
			gemMeasurementFormulaValueImpl.setFormulaType(StringPool.BLANK);
		}
		else {
			gemMeasurementFormulaValueImpl.setFormulaType(formulaType);
		}

		if (formulaValue == null) {
			gemMeasurementFormulaValueImpl.setFormulaValue(StringPool.BLANK);
		}
		else {
			gemMeasurementFormulaValueImpl.setFormulaValue(formulaValue);
		}

		if (creatorId == null) {
			gemMeasurementFormulaValueImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			gemMeasurementFormulaValueImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			gemMeasurementFormulaValueImpl.setCreatedDate(null);
		}
		else {
			gemMeasurementFormulaValueImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			gemMeasurementFormulaValueImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			gemMeasurementFormulaValueImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			gemMeasurementFormulaValueImpl.setUpdatedDate(null);
		}
		else {
			gemMeasurementFormulaValueImpl.setUpdatedDate(new Date(updatedDate));
		}

		gemMeasurementFormulaValueImpl.resetOriginalValues();

		return gemMeasurementFormulaValueImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		formulaValueId = objectInput.readLong();
		formulaId = objectInput.readLong();
		formulaType = objectInput.readUTF();
		formulaValue = objectInput.readUTF();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(formulaValueId);
		objectOutput.writeLong(formulaId);

		if (formulaType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(formulaType);
		}

		if (formulaValue == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(formulaValue);
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

	public long formulaValueId;
	public long formulaId;
	public String formulaType;
	public String formulaValue;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}