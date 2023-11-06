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
public class GEMStdCategorySoap implements Serializable {
	public static GEMStdCategorySoap toSoapModel(GEMStdCategory model) {
		GEMStdCategorySoap soapModel = new GEMStdCategorySoap();

		soapModel.setGemStdCategoryId(model.getGemStdCategoryId());
		soapModel.setStdId(model.getStdId());
		soapModel.setCategoryId(model.getCategoryId());
		soapModel.setTemplateType(model.getTemplateType());
		soapModel.setChainCode(model.getChainCode());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static GEMStdCategorySoap[] toSoapModels(GEMStdCategory[] models) {
		GEMStdCategorySoap[] soapModels = new GEMStdCategorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GEMStdCategorySoap[][] toSoapModels(GEMStdCategory[][] models) {
		GEMStdCategorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GEMStdCategorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new GEMStdCategorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GEMStdCategorySoap[] toSoapModels(List<GEMStdCategory> models) {
		List<GEMStdCategorySoap> soapModels = new ArrayList<GEMStdCategorySoap>(models.size());

		for (GEMStdCategory model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GEMStdCategorySoap[soapModels.size()]);
	}

	public GEMStdCategorySoap() {
	}

	public long getPrimaryKey() {
		return _gemStdCategoryId;
	}

	public void setPrimaryKey(long pk) {
		setGemStdCategoryId(pk);
	}

	public long getGemStdCategoryId() {
		return _gemStdCategoryId;
	}

	public void setGemStdCategoryId(long gemStdCategoryId) {
		_gemStdCategoryId = gemStdCategoryId;
	}

	public long getStdId() {
		return _stdId;
	}

	public void setStdId(long stdId) {
		_stdId = stdId;
	}

	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
	}

	public String getTemplateType() {
		return _templateType;
	}

	public void setTemplateType(String templateType) {
		_templateType = templateType;
	}

	public String getChainCode() {
		return _chainCode;
	}

	public void setChainCode(String chainCode) {
		_chainCode = chainCode;
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

	private long _gemStdCategoryId;
	private long _stdId;
	private long _categoryId;
	private String _templateType;
	private String _chainCode;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}