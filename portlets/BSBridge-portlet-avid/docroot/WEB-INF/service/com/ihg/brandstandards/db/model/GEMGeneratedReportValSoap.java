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

import com.ihg.brandstandards.db.service.persistence.GEMGeneratedReportValPK;

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
public class GEMGeneratedReportValSoap implements Serializable {
	public static GEMGeneratedReportValSoap toSoapModel(
		GEMGeneratedReportVal model) {
		GEMGeneratedReportValSoap soapModel = new GEMGeneratedReportValSoap();

		soapModel.setReportValId(model.getReportValId());
		soapModel.setReportId(model.getReportId());
		soapModel.setColumnId(model.getColumnId());
		soapModel.setGeneratedValue(model.getGeneratedValue());
		soapModel.setDisplayOrderNumber(model.getDisplayOrderNumber());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static GEMGeneratedReportValSoap[] toSoapModels(
		GEMGeneratedReportVal[] models) {
		GEMGeneratedReportValSoap[] soapModels = new GEMGeneratedReportValSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GEMGeneratedReportValSoap[][] toSoapModels(
		GEMGeneratedReportVal[][] models) {
		GEMGeneratedReportValSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GEMGeneratedReportValSoap[models.length][models[0].length];
		}
		else {
			soapModels = new GEMGeneratedReportValSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GEMGeneratedReportValSoap[] toSoapModels(
		List<GEMGeneratedReportVal> models) {
		List<GEMGeneratedReportValSoap> soapModels = new ArrayList<GEMGeneratedReportValSoap>(models.size());

		for (GEMGeneratedReportVal model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GEMGeneratedReportValSoap[soapModels.size()]);
	}

	public GEMGeneratedReportValSoap() {
	}

	public GEMGeneratedReportValPK getPrimaryKey() {
		return new GEMGeneratedReportValPK(_reportValId, _reportId);
	}

	public void setPrimaryKey(GEMGeneratedReportValPK pk) {
		setReportValId(pk.reportValId);
		setReportId(pk.reportId);
	}

	public long getReportValId() {
		return _reportValId;
	}

	public void setReportValId(long reportValId) {
		_reportValId = reportValId;
	}

	public long getReportId() {
		return _reportId;
	}

	public void setReportId(long reportId) {
		_reportId = reportId;
	}

	public long getColumnId() {
		return _columnId;
	}

	public void setColumnId(long columnId) {
		_columnId = columnId;
	}

	public String getGeneratedValue() {
		return _generatedValue;
	}

	public void setGeneratedValue(String generatedValue) {
		_generatedValue = generatedValue;
	}

	public long getDisplayOrderNumber() {
		return _displayOrderNumber;
	}

	public void setDisplayOrderNumber(long displayOrderNumber) {
		_displayOrderNumber = displayOrderNumber;
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

	private long _reportValId;
	private long _reportId;
	private long _columnId;
	private String _generatedValue;
	private long _displayOrderNumber;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}