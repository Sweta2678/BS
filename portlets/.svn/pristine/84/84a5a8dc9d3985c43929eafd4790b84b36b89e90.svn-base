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
public class GEMTemplateCategorySoap implements Serializable {
	public static GEMTemplateCategorySoap toSoapModel(GEMTemplateCategory model) {
		GEMTemplateCategorySoap soapModel = new GEMTemplateCategorySoap();

		soapModel.setTemplateCatgyId(model.getTemplateCatgyId());
		soapModel.setTemplateId(model.getTemplateId());
		soapModel.setCategoryId(model.getCategoryId());
		soapModel.setCategoryViewType(model.getCategoryViewType());
		soapModel.setCategoryAnsAll(model.getCategoryAnsAll());
		soapModel.setDuplicatable(model.getDuplicatable());
		soapModel.setDisplayOrderNumber(model.getDisplayOrderNumber());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static GEMTemplateCategorySoap[] toSoapModels(
		GEMTemplateCategory[] models) {
		GEMTemplateCategorySoap[] soapModels = new GEMTemplateCategorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GEMTemplateCategorySoap[][] toSoapModels(
		GEMTemplateCategory[][] models) {
		GEMTemplateCategorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GEMTemplateCategorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new GEMTemplateCategorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GEMTemplateCategorySoap[] toSoapModels(
		List<GEMTemplateCategory> models) {
		List<GEMTemplateCategorySoap> soapModels = new ArrayList<GEMTemplateCategorySoap>(models.size());

		for (GEMTemplateCategory model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GEMTemplateCategorySoap[soapModels.size()]);
	}

	public GEMTemplateCategorySoap() {
	}

	public long getPrimaryKey() {
		return _templateCatgyId;
	}

	public void setPrimaryKey(long pk) {
		setTemplateCatgyId(pk);
	}

	public long getTemplateCatgyId() {
		return _templateCatgyId;
	}

	public void setTemplateCatgyId(long templateCatgyId) {
		_templateCatgyId = templateCatgyId;
	}

	public long getTemplateId() {
		return _templateId;
	}

	public void setTemplateId(long templateId) {
		_templateId = templateId;
	}

	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
	}

	public String getCategoryViewType() {
		return _categoryViewType;
	}

	public void setCategoryViewType(String categoryViewType) {
		_categoryViewType = categoryViewType;
	}

	public String getCategoryAnsAll() {
		return _categoryAnsAll;
	}

	public void setCategoryAnsAll(String categoryAnsAll) {
		_categoryAnsAll = categoryAnsAll;
	}

	public String getDuplicatable() {
		return _duplicatable;
	}

	public void setDuplicatable(String duplicatable) {
		_duplicatable = duplicatable;
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

	private long _templateCatgyId;
	private long _templateId;
	private long _categoryId;
	private String _categoryViewType;
	private String _categoryAnsAll;
	private String _duplicatable;
	private long _displayOrderNumber;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}