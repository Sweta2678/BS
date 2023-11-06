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
public class GEMTemplateValuesSoap implements Serializable {
	public static GEMTemplateValuesSoap toSoapModel(GEMTemplateValues model) {
		GEMTemplateValuesSoap soapModel = new GEMTemplateValuesSoap();

		soapModel.setValueId(model.getValueId());
		soapModel.setColumnId(model.getColumnId());
		soapModel.setCategoryId(model.getCategoryId());
		soapModel.setColumnValue(model.getColumnValue());
		soapModel.setDisplayOrderNumber(model.getDisplayOrderNumber());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static GEMTemplateValuesSoap[] toSoapModels(
		GEMTemplateValues[] models) {
		GEMTemplateValuesSoap[] soapModels = new GEMTemplateValuesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GEMTemplateValuesSoap[][] toSoapModels(
		GEMTemplateValues[][] models) {
		GEMTemplateValuesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GEMTemplateValuesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new GEMTemplateValuesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GEMTemplateValuesSoap[] toSoapModels(
		List<GEMTemplateValues> models) {
		List<GEMTemplateValuesSoap> soapModels = new ArrayList<GEMTemplateValuesSoap>(models.size());

		for (GEMTemplateValues model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GEMTemplateValuesSoap[soapModels.size()]);
	}

	public GEMTemplateValuesSoap() {
	}

	public long getPrimaryKey() {
		return _valueId;
	}

	public void setPrimaryKey(long pk) {
		setValueId(pk);
	}

	public long getValueId() {
		return _valueId;
	}

	public void setValueId(long valueId) {
		_valueId = valueId;
	}

	public long getColumnId() {
		return _columnId;
	}

	public void setColumnId(long columnId) {
		_columnId = columnId;
	}

	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
	}

	public String getColumnValue() {
		return _columnValue;
	}

	public void setColumnValue(String columnValue) {
		_columnValue = columnValue;
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

	private long _valueId;
	private long _columnId;
	private long _categoryId;
	private String _columnValue;
	private long _displayOrderNumber;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}