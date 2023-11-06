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
public class BridgeGlobalPublishCountrySoap implements Serializable {
	public static BridgeGlobalPublishCountrySoap toSoapModel(
		BridgeGlobalPublishCountry model) {
		BridgeGlobalPublishCountrySoap soapModel = new BridgeGlobalPublishCountrySoap();

		soapModel.setGlobalPublishCtryId(model.getGlobalPublishCtryId());
		soapModel.setGlobalPublishId(model.getGlobalPublishId());
		soapModel.setCountryCode(model.getCountryCode());
		soapModel.setPublishInd(model.getPublishInd());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static BridgeGlobalPublishCountrySoap[] toSoapModels(
		BridgeGlobalPublishCountry[] models) {
		BridgeGlobalPublishCountrySoap[] soapModels = new BridgeGlobalPublishCountrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BridgeGlobalPublishCountrySoap[][] toSoapModels(
		BridgeGlobalPublishCountry[][] models) {
		BridgeGlobalPublishCountrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BridgeGlobalPublishCountrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new BridgeGlobalPublishCountrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BridgeGlobalPublishCountrySoap[] toSoapModels(
		List<BridgeGlobalPublishCountry> models) {
		List<BridgeGlobalPublishCountrySoap> soapModels = new ArrayList<BridgeGlobalPublishCountrySoap>(models.size());

		for (BridgeGlobalPublishCountry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BridgeGlobalPublishCountrySoap[soapModels.size()]);
	}

	public BridgeGlobalPublishCountrySoap() {
	}

	public long getPrimaryKey() {
		return _globalPublishCtryId;
	}

	public void setPrimaryKey(long pk) {
		setGlobalPublishCtryId(pk);
	}

	public long getGlobalPublishCtryId() {
		return _globalPublishCtryId;
	}

	public void setGlobalPublishCtryId(long globalPublishCtryId) {
		_globalPublishCtryId = globalPublishCtryId;
	}

	public long getGlobalPublishId() {
		return _globalPublishId;
	}

	public void setGlobalPublishId(long globalPublishId) {
		_globalPublishId = globalPublishId;
	}

	public String getCountryCode() {
		return _countryCode;
	}

	public void setCountryCode(String countryCode) {
		_countryCode = countryCode;
	}

	public String getPublishInd() {
		return _publishInd;
	}

	public void setPublishInd(String publishInd) {
		_publishInd = publishInd;
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

	private long _globalPublishCtryId;
	private long _globalPublishId;
	private String _countryCode;
	private String _publishInd;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}