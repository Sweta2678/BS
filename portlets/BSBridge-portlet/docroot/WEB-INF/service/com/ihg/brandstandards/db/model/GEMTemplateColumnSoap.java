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
public class GEMTemplateColumnSoap implements Serializable {
	public static GEMTemplateColumnSoap toSoapModel(GEMTemplateColumn model) {
		GEMTemplateColumnSoap soapModel = new GEMTemplateColumnSoap();

		soapModel.setColumnId(model.getColumnId());
		soapModel.setTemplateId(model.getTemplateId());
		soapModel.setColumnName(model.getColumnName());
		soapModel.setValueType(model.getValueType());
		soapModel.setDefaultValue(model.getDefaultValue());
		soapModel.setIsMandatory(model.getIsMandatory());
		soapModel.setDisplayOrderNumber(model.getDisplayOrderNumber());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static GEMTemplateColumnSoap[] toSoapModels(
		GEMTemplateColumn[] models) {
		GEMTemplateColumnSoap[] soapModels = new GEMTemplateColumnSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GEMTemplateColumnSoap[][] toSoapModels(
		GEMTemplateColumn[][] models) {
		GEMTemplateColumnSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GEMTemplateColumnSoap[models.length][models[0].length];
		}
		else {
			soapModels = new GEMTemplateColumnSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GEMTemplateColumnSoap[] toSoapModels(
		List<GEMTemplateColumn> models) {
		List<GEMTemplateColumnSoap> soapModels = new ArrayList<GEMTemplateColumnSoap>(models.size());

		for (GEMTemplateColumn model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GEMTemplateColumnSoap[soapModels.size()]);
	}

	public GEMTemplateColumnSoap() {
	}

	public long getPrimaryKey() {
		return _columnId;
	}

	public void setPrimaryKey(long pk) {
		setColumnId(pk);
	}

	public long getColumnId() {
		return _columnId;
	}

	public void setColumnId(long columnId) {
		_columnId = columnId;
	}

	public long getTemplateId() {
		return _templateId;
	}

	public void setTemplateId(long templateId) {
		_templateId = templateId;
	}

	public String getColumnName() {
		return _columnName;
	}

	public void setColumnName(String columnName) {
		_columnName = columnName;
	}

	public String getValueType() {
		return _valueType;
	}

	public void setValueType(String valueType) {
		_valueType = valueType;
	}

	public String getDefaultValue() {
		return _defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		_defaultValue = defaultValue;
	}

	public String getIsMandatory() {
		return _isMandatory;
	}

	public void setIsMandatory(String isMandatory) {
		_isMandatory = isMandatory;
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

	private long _columnId;
	private long _templateId;
	private String _columnName;
	private String _valueType;
	private String _defaultValue;
	private String _isMandatory;
	private long _displayOrderNumber;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}