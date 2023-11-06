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
public class GEMMeasurementSoap implements Serializable {
	public static GEMMeasurementSoap toSoapModel(GEMMeasurement model) {
		GEMMeasurementSoap soapModel = new GEMMeasurementSoap();

		soapModel.setMeasurementId(model.getMeasurementId());
		soapModel.setMeasurementName(model.getMeasurementName());
		soapModel.setMeasurementType(model.getMeasurementType());
		soapModel.setDisplayOrderNumber(model.getDisplayOrderNumber());
		soapModel.setTemplateId(model.getTemplateId());
		soapModel.setMultiplierQty(model.getMultiplierQty());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static GEMMeasurementSoap[] toSoapModels(GEMMeasurement[] models) {
		GEMMeasurementSoap[] soapModels = new GEMMeasurementSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GEMMeasurementSoap[][] toSoapModels(GEMMeasurement[][] models) {
		GEMMeasurementSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GEMMeasurementSoap[models.length][models[0].length];
		}
		else {
			soapModels = new GEMMeasurementSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GEMMeasurementSoap[] toSoapModels(List<GEMMeasurement> models) {
		List<GEMMeasurementSoap> soapModels = new ArrayList<GEMMeasurementSoap>(models.size());

		for (GEMMeasurement model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GEMMeasurementSoap[soapModels.size()]);
	}

	public GEMMeasurementSoap() {
	}

	public long getPrimaryKey() {
		return _measurementId;
	}

	public void setPrimaryKey(long pk) {
		setMeasurementId(pk);
	}

	public long getMeasurementId() {
		return _measurementId;
	}

	public void setMeasurementId(long measurementId) {
		_measurementId = measurementId;
	}

	public String getMeasurementName() {
		return _measurementName;
	}

	public void setMeasurementName(String measurementName) {
		_measurementName = measurementName;
	}

	public String getMeasurementType() {
		return _measurementType;
	}

	public void setMeasurementType(String measurementType) {
		_measurementType = measurementType;
	}

	public long getDisplayOrderNumber() {
		return _displayOrderNumber;
	}

	public void setDisplayOrderNumber(long displayOrderNumber) {
		_displayOrderNumber = displayOrderNumber;
	}

	public long getTemplateId() {
		return _templateId;
	}

	public void setTemplateId(long templateId) {
		_templateId = templateId;
	}

	public long getMultiplierQty() {
		return _multiplierQty;
	}

	public void setMultiplierQty(long multiplierQty) {
		_multiplierQty = multiplierQty;
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

	private long _measurementId;
	private String _measurementName;
	private String _measurementType;
	private long _displayOrderNumber;
	private long _templateId;
	private long _multiplierQty;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}