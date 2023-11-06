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
public class GEMMeasurementFormulaSoap implements Serializable {
	public static GEMMeasurementFormulaSoap toSoapModel(
		GEMMeasurementFormula model) {
		GEMMeasurementFormulaSoap soapModel = new GEMMeasurementFormulaSoap();

		soapModel.setFormulaId(model.getFormulaId());
		soapModel.setPublishId(model.getPublishId());
		soapModel.setRegionId(model.getRegionId());
		soapModel.setMeasurementId(model.getMeasurementId());
		soapModel.setSeverityId(model.getSeverityId());
		soapModel.setSubRegionLevelCd(model.getSubRegionLevelCd());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static GEMMeasurementFormulaSoap[] toSoapModels(
		GEMMeasurementFormula[] models) {
		GEMMeasurementFormulaSoap[] soapModels = new GEMMeasurementFormulaSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GEMMeasurementFormulaSoap[][] toSoapModels(
		GEMMeasurementFormula[][] models) {
		GEMMeasurementFormulaSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GEMMeasurementFormulaSoap[models.length][models[0].length];
		}
		else {
			soapModels = new GEMMeasurementFormulaSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GEMMeasurementFormulaSoap[] toSoapModels(
		List<GEMMeasurementFormula> models) {
		List<GEMMeasurementFormulaSoap> soapModels = new ArrayList<GEMMeasurementFormulaSoap>(models.size());

		for (GEMMeasurementFormula model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GEMMeasurementFormulaSoap[soapModels.size()]);
	}

	public GEMMeasurementFormulaSoap() {
	}

	public long getPrimaryKey() {
		return _formulaId;
	}

	public void setPrimaryKey(long pk) {
		setFormulaId(pk);
	}

	public long getFormulaId() {
		return _formulaId;
	}

	public void setFormulaId(long formulaId) {
		_formulaId = formulaId;
	}

	public long getPublishId() {
		return _publishId;
	}

	public void setPublishId(long publishId) {
		_publishId = publishId;
	}

	public long getRegionId() {
		return _regionId;
	}

	public void setRegionId(long regionId) {
		_regionId = regionId;
	}

	public long getMeasurementId() {
		return _measurementId;
	}

	public void setMeasurementId(long measurementId) {
		_measurementId = measurementId;
	}

	public long getSeverityId() {
		return _severityId;
	}

	public void setSeverityId(long severityId) {
		_severityId = severityId;
	}

	public String getSubRegionLevelCd() {
		return _subRegionLevelCd;
	}

	public void setSubRegionLevelCd(String subRegionLevelCd) {
		_subRegionLevelCd = subRegionLevelCd;
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

	private long _formulaId;
	private long _publishId;
	private long _regionId;
	private long _measurementId;
	private long _severityId;
	private String _subRegionLevelCd;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}