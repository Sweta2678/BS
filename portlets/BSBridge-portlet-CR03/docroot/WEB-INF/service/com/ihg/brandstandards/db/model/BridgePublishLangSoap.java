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
public class BridgePublishLangSoap implements Serializable {
	public static BridgePublishLangSoap toSoapModel(BridgePublishLang model) {
		BridgePublishLangSoap soapModel = new BridgePublishLangSoap();

		soapModel.setPublishLangId(model.getPublishLangId());
		soapModel.setPublishId(model.getPublishId());
		soapModel.setRegionId(model.getRegionId());
		soapModel.setLocaleCode(model.getLocaleCode());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static BridgePublishLangSoap[] toSoapModels(
		BridgePublishLang[] models) {
		BridgePublishLangSoap[] soapModels = new BridgePublishLangSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BridgePublishLangSoap[][] toSoapModels(
		BridgePublishLang[][] models) {
		BridgePublishLangSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BridgePublishLangSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BridgePublishLangSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BridgePublishLangSoap[] toSoapModels(
		List<BridgePublishLang> models) {
		List<BridgePublishLangSoap> soapModels = new ArrayList<BridgePublishLangSoap>(models.size());

		for (BridgePublishLang model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BridgePublishLangSoap[soapModels.size()]);
	}

	public BridgePublishLangSoap() {
	}

	public long getPrimaryKey() {
		return _publishLangId;
	}

	public void setPrimaryKey(long pk) {
		setPublishLangId(pk);
	}

	public long getPublishLangId() {
		return _publishLangId;
	}

	public void setPublishLangId(long publishLangId) {
		_publishLangId = publishLangId;
	}

	public long getPublishId() {
		return _publishId;
	}

	public void setPublishId(long publishId) {
		_publishId = publishId;
	}

	public long getRegionId() {
		return _regionId;
	}

	public void setRegionId(long regionId) {
		_regionId = regionId;
	}

	public String getLocaleCode() {
		return _localeCode;
	}

	public void setLocaleCode(String localeCode) {
		_localeCode = localeCode;
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

	private long _publishLangId;
	private long _publishId;
	private long _regionId;
	private String _localeCode;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}