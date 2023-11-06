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

import com.ihg.brandstandards.db.model.GEMMeasurementFormula;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing GEMMeasurementFormula in entity cache.
 *
 * @author Mummanedi
 * @see GEMMeasurementFormula
 * @generated
 */
public class GEMMeasurementFormulaCacheModel implements CacheModel<GEMMeasurementFormula>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{formulaId=");
		sb.append(formulaId);
		sb.append(", publishId=");
		sb.append(publishId);
		sb.append(", regionId=");
		sb.append(regionId);
		sb.append(", measurementId=");
		sb.append(measurementId);
		sb.append(", severityId=");
		sb.append(severityId);
		sb.append(", subRegionLevelCd=");
		sb.append(subRegionLevelCd);
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
	public GEMMeasurementFormula toEntityModel() {
		GEMMeasurementFormulaImpl gemMeasurementFormulaImpl = new GEMMeasurementFormulaImpl();

		gemMeasurementFormulaImpl.setFormulaId(formulaId);
		gemMeasurementFormulaImpl.setPublishId(publishId);
		gemMeasurementFormulaImpl.setRegionId(regionId);
		gemMeasurementFormulaImpl.setMeasurementId(measurementId);
		gemMeasurementFormulaImpl.setSeverityId(severityId);

		if (subRegionLevelCd == null) {
			gemMeasurementFormulaImpl.setSubRegionLevelCd(StringPool.BLANK);
		}
		else {
			gemMeasurementFormulaImpl.setSubRegionLevelCd(subRegionLevelCd);
		}

		if (creatorId == null) {
			gemMeasurementFormulaImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			gemMeasurementFormulaImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			gemMeasurementFormulaImpl.setCreatedDate(null);
		}
		else {
			gemMeasurementFormulaImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			gemMeasurementFormulaImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			gemMeasurementFormulaImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			gemMeasurementFormulaImpl.setUpdatedDate(null);
		}
		else {
			gemMeasurementFormulaImpl.setUpdatedDate(new Date(updatedDate));
		}

		gemMeasurementFormulaImpl.resetOriginalValues();

		return gemMeasurementFormulaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		formulaId = objectInput.readLong();
		publishId = objectInput.readLong();
		regionId = objectInput.readLong();
		measurementId = objectInput.readLong();
		severityId = objectInput.readLong();
		subRegionLevelCd = objectInput.readUTF();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(formulaId);
		objectOutput.writeLong(publishId);
		objectOutput.writeLong(regionId);
		objectOutput.writeLong(measurementId);
		objectOutput.writeLong(severityId);

		if (subRegionLevelCd == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(subRegionLevelCd);
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

	public long formulaId;
	public long publishId;
	public long regionId;
	public long measurementId;
	public long severityId;
	public String subRegionLevelCd;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}