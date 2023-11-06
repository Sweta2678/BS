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
public class BridgePublishCountrySoap implements Serializable {
	public static BridgePublishCountrySoap toSoapModel(
		BridgePublishCountry model) {
		BridgePublishCountrySoap soapModel = new BridgePublishCountrySoap();

		soapModel.setPublishCtryId(model.getPublishCtryId());
		soapModel.setBridgePublishId(model.getBridgePublishId());
		soapModel.setCountryCode(model.getCountryCode());
		soapModel.setStatusCode(model.getStatusCode());
		soapModel.setPublishInd(model.getPublishInd());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static BridgePublishCountrySoap[] toSoapModels(
		BridgePublishCountry[] models) {
		BridgePublishCountrySoap[] soapModels = new BridgePublishCountrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BridgePublishCountrySoap[][] toSoapModels(
		BridgePublishCountry[][] models) {
		BridgePublishCountrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BridgePublishCountrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new BridgePublishCountrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BridgePublishCountrySoap[] toSoapModels(
		List<BridgePublishCountry> models) {
		List<BridgePublishCountrySoap> soapModels = new ArrayList<BridgePublishCountrySoap>(models.size());

		for (BridgePublishCountry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BridgePublishCountrySoap[soapModels.size()]);
	}

	public BridgePublishCountrySoap() {
	}

	public long getPrimaryKey() {
		return _publishCtryId;
	}

	public void setPrimaryKey(long pk) {
		setPublishCtryId(pk);
	}

	public long getPublishCtryId() {
		return _publishCtryId;
	}

	public void setPublishCtryId(long publishCtryId) {
		_publishCtryId = publishCtryId;
	}

	public long getBridgePublishId() {
		return _bridgePublishId;
	}

	public void setBridgePublishId(long bridgePublishId) {
		_bridgePublishId = bridgePublishId;
	}

	public String getCountryCode() {
		return _countryCode;
	}

	public void setCountryCode(String countryCode) {
		_countryCode = countryCode;
	}

	public String getStatusCode() {
		return _statusCode;
	}

	public void setStatusCode(String statusCode) {
		_statusCode = statusCode;
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

	private long _publishCtryId;
	private long _bridgePublishId;
	private String _countryCode;
	private String _statusCode;
	private String _publishInd;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}