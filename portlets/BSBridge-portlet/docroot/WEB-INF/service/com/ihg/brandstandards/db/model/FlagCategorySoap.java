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

import com.ihg.brandstandards.db.service.persistence.FlagCategoryPK;

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
public class FlagCategorySoap implements Serializable {
	public static FlagCategorySoap toSoapModel(FlagCategory model) {
		FlagCategorySoap soapModel = new FlagCategorySoap();

		soapModel.setFlagCatId(model.getFlagCatId());
		soapModel.setActiveInd(model.getActiveInd());
		soapModel.setParentCatId(model.getParentCatId());
		soapModel.setCatOrField(model.getCatOrField());
		soapModel.setTxtValue(model.getTxtValue());
		soapModel.setOrderNumber(model.getOrderNumber());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static FlagCategorySoap[] toSoapModels(FlagCategory[] models) {
		FlagCategorySoap[] soapModels = new FlagCategorySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FlagCategorySoap[][] toSoapModels(FlagCategory[][] models) {
		FlagCategorySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FlagCategorySoap[models.length][models[0].length];
		}
		else {
			soapModels = new FlagCategorySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FlagCategorySoap[] toSoapModels(List<FlagCategory> models) {
		List<FlagCategorySoap> soapModels = new ArrayList<FlagCategorySoap>(models.size());

		for (FlagCategory model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FlagCategorySoap[soapModels.size()]);
	}

	public FlagCategorySoap() {
	}

	public FlagCategoryPK getPrimaryKey() {
		return new FlagCategoryPK(_flagCatId, _activeInd);
	}

	public void setPrimaryKey(FlagCategoryPK pk) {
		setFlagCatId(pk.flagCatId);
		setActiveInd(pk.activeInd);
	}

	public long getFlagCatId() {
		return _flagCatId;
	}

	public void setFlagCatId(long flagCatId) {
		_flagCatId = flagCatId;
	}

	public String getActiveInd() {
		return _activeInd;
	}

	public void setActiveInd(String activeInd) {
		_activeInd = activeInd;
	}

	public long getParentCatId() {
		return _parentCatId;
	}

	public void setParentCatId(long parentCatId) {
		_parentCatId = parentCatId;
	}

	public String getCatOrField() {
		return _catOrField;
	}

	public void setCatOrField(String catOrField) {
		_catOrField = catOrField;
	}

	public String getTxtValue() {
		return _txtValue;
	}

	public void setTxtValue(String txtValue) {
		_txtValue = txtValue;
	}

	public long getOrderNumber() {
		return _orderNumber;
	}

	public void setOrderNumber(long orderNumber) {
		_orderNumber = orderNumber;
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

	private long _flagCatId;
	private String _activeInd;
	private long _parentCatId;
	private String _catOrField;
	private String _txtValue;
	private long _orderNumber;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}