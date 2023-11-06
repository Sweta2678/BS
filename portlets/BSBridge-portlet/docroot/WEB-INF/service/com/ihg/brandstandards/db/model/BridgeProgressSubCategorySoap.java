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
public class BridgeProgressSubCategorySoap implements Serializable {
	public static BridgeProgressSubCategorySoap toSoapModel(
		BridgeProgressSubCategory model) {
		BridgeProgressSubCategorySoap soapModel = new BridgeProgressSubCategorySoap();

		soapModel.setProgressSubCategoryId(model.getProgressSubCategoryId());
		soapModel.setProgressCategoryId(model.getProgressCategoryId());
		soapModel.setCategoryName(model.getCategoryName());
		soapModel.setDisplayOrderNumber(model.getDisplayOrderNumber());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static BridgeProgressSubCategorySoap[] toSoapModels(
		BridgeProgressSubCategory[] models) {
		BridgeProgressSubCategorySoap[] soapModels = new BridgeProgressSubCategorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BridgeProgressSubCategorySoap[][] toSoapModels(
		BridgeProgressSubCategory[][] models) {
		BridgeProgressSubCategorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BridgeProgressSubCategorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new BridgeProgressSubCategorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BridgeProgressSubCategorySoap[] toSoapModels(
		List<BridgeProgressSubCategory> models) {
		List<BridgeProgressSubCategorySoap> soapModels = new ArrayList<BridgeProgressSubCategorySoap>(models.size());

		for (BridgeProgressSubCategory model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BridgeProgressSubCategorySoap[soapModels.size()]);
	}

	public BridgeProgressSubCategorySoap() {
	}

	public long getPrimaryKey() {
		return _progressSubCategoryId;
	}

	public void setPrimaryKey(long pk) {
		setProgressSubCategoryId(pk);
	}

	public long getProgressSubCategoryId() {
		return _progressSubCategoryId;
	}

	public void setProgressSubCategoryId(long progressSubCategoryId) {
		_progressSubCategoryId = progressSubCategoryId;
	}

	public long getProgressCategoryId() {
		return _progressCategoryId;
	}

	public void setProgressCategoryId(long progressCategoryId) {
		_progressCategoryId = progressCategoryId;
	}

	public String getCategoryName() {
		return _categoryName;
	}

	public void setCategoryName(String categoryName) {
		_categoryName = categoryName;
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

	private long _progressSubCategoryId;
	private long _progressCategoryId;
	private String _categoryName;
	private long _displayOrderNumber;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}