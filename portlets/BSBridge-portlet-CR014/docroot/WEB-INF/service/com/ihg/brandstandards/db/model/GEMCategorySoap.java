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
public class GEMCategorySoap implements Serializable {
	public static GEMCategorySoap toSoapModel(GEMCategory model) {
		GEMCategorySoap soapModel = new GEMCategorySoap();

		soapModel.setCategoryId(model.getCategoryId());
		soapModel.setCmsCategoryId(model.getCmsCategoryId());
		soapModel.setGemCategoryCode(model.getGemCategoryCode());
		soapModel.setGemPrntCategoryId(model.getGemPrntCategoryId());
		soapModel.setCategoryName(model.getCategoryName());
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

	public static GEMCategorySoap[] toSoapModels(GEMCategory[] models) {
		GEMCategorySoap[] soapModels = new GEMCategorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GEMCategorySoap[][] toSoapModels(GEMCategory[][] models) {
		GEMCategorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GEMCategorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new GEMCategorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GEMCategorySoap[] toSoapModels(List<GEMCategory> models) {
		List<GEMCategorySoap> soapModels = new ArrayList<GEMCategorySoap>(models.size());

		for (GEMCategory model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GEMCategorySoap[soapModels.size()]);
	}

	public GEMCategorySoap() {
	}

	public long getPrimaryKey() {
		return _categoryId;
	}

	public void setPrimaryKey(long pk) {
		setCategoryId(pk);
	}

	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
	}

	public long getCmsCategoryId() {
		return _cmsCategoryId;
	}

	public void setCmsCategoryId(long cmsCategoryId) {
		_cmsCategoryId = cmsCategoryId;
	}

	public String getGemCategoryCode() {
		return _gemCategoryCode;
	}

	public void setGemCategoryCode(String gemCategoryCode) {
		_gemCategoryCode = gemCategoryCode;
	}

	public String getGemPrntCategoryId() {
		return _gemPrntCategoryId;
	}

	public void setGemPrntCategoryId(String gemPrntCategoryId) {
		_gemPrntCategoryId = gemPrntCategoryId;
	}

	public String getCategoryName() {
		return _categoryName;
	}

	public void setCategoryName(String categoryName) {
		_categoryName = categoryName;
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

	private long _categoryId;
	private long _cmsCategoryId;
	private String _gemCategoryCode;
	private String _gemPrntCategoryId;
	private String _categoryName;
	private String _categoryViewType;
	private String _categoryAnsAll;
	private String _duplicatable;
	private long _displayOrderNumber;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}