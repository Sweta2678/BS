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
public class BridgeProgressCategorySoap implements Serializable {
	public static BridgeProgressCategorySoap toSoapModel(
		BridgeProgressCategory model) {
		BridgeProgressCategorySoap soapModel = new BridgeProgressCategorySoap();

		soapModel.setProgressCategoryId(model.getProgressCategoryId());
		soapModel.setProgressCategoryName(model.getProgressCategoryName());
		soapModel.setDisplayOrderNumber(model.getDisplayOrderNumber());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static BridgeProgressCategorySoap[] toSoapModels(
		BridgeProgressCategory[] models) {
		BridgeProgressCategorySoap[] soapModels = new BridgeProgressCategorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BridgeProgressCategorySoap[][] toSoapModels(
		BridgeProgressCategory[][] models) {
		BridgeProgressCategorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BridgeProgressCategorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new BridgeProgressCategorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BridgeProgressCategorySoap[] toSoapModels(
		List<BridgeProgressCategory> models) {
		List<BridgeProgressCategorySoap> soapModels = new ArrayList<BridgeProgressCategorySoap>(models.size());

		for (BridgeProgressCategory model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BridgeProgressCategorySoap[soapModels.size()]);
	}

	public BridgeProgressCategorySoap() {
	}

	public long getPrimaryKey() {
		return _progressCategoryId;
	}

	public void setPrimaryKey(long pk) {
		setProgressCategoryId(pk);
	}

	public long getProgressCategoryId() {
		return _progressCategoryId;
	}

	public void setProgressCategoryId(long progressCategoryId) {
		_progressCategoryId = progressCategoryId;
	}

	public String getProgressCategoryName() {
		return _progressCategoryName;
	}

	public void setProgressCategoryName(String progressCategoryName) {
		_progressCategoryName = progressCategoryName;
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

	private long _progressCategoryId;
	private String _progressCategoryName;
	private long _displayOrderNumber;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}