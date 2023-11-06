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

package com.ihg.brandstandards.db.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Mummanedi
 * @generated
 */
public class GEMMeasurementFormulaValueSoap implements Serializable {
	public static GEMMeasurementFormulaValueSoap toSoapModel(
		GEMMeasurementFormulaValue model) {
		GEMMeasurementFormulaValueSoap soapModel = new GEMMeasurementFormulaValueSoap();

		soapModel.setFormulaValueId(model.getFormulaValueId());
		soapModel.setFormulaId(model.getFormulaId());
		soapModel.setFormulaType(model.getFormulaType());
		soapModel.setFormulaValue(model.getFormulaValue());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static GEMMeasurementFormulaValueSoap[] toSoapModels(
		GEMMeasurementFormulaValue[] models) {
		GEMMeasurementFormulaValueSoap[] soapModels = new GEMMeasurementFormulaValueSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GEMMeasurementFormulaValueSoap[][] toSoapModels(
		GEMMeasurementFormulaValue[][] models) {
		GEMMeasurementFormulaValueSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GEMMeasurementFormulaValueSoap[models.length][models[0].length];
		}
		else {
			soapModels = new GEMMeasurementFormulaValueSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GEMMeasurementFormulaValueSoap[] toSoapModels(
		List<GEMMeasurementFormulaValue> models) {
		List<GEMMeasurementFormulaValueSoap> soapModels = new ArrayList<GEMMeasurementFormulaValueSoap>(models.size());

		for (GEMMeasurementFormulaValue model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GEMMeasurementFormulaValueSoap[soapModels.size()]);
	}

	public GEMMeasurementFormulaValueSoap() {
	}

	public long getPrimaryKey() {
		return _formulaValueId;
	}

	public void setPrimaryKey(long pk) {
		setFormulaValueId(pk);
	}

	public long getFormulaValueId() {
		return _formulaValueId;
	}

	public void setFormulaValueId(long formulaValueId) {
		_formulaValueId = formulaValueId;
	}

	public long getFormulaId() {
		return _formulaId;
	}

	public void setFormulaId(long formulaId) {
		_formulaId = formulaId;
	}

	public String getFormulaType() {
		return _formulaType;
	}

	public void setFormulaType(String formulaType) {
		_formulaType = formulaType;
	}

	public String getFormulaValue() {
		return _formulaValue;
	}

	public void setFormulaValue(String formulaValue) {
		_formulaValue = formulaValue;
	}

	public String getCreatorId() {
		return _creatorId;
	}

	public void setCreatorId(String creatorId) {
		_creatorId = creatorId;
	}

	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	public String getUpdatedBy() {
		return _updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		_updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return _updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		_updatedDate = updatedDate;
	}

	private long _formulaValueId;
	private long _formulaId;
	private String _formulaType;
	private String _formulaValue;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}