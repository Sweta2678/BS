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
public class GEMManagementIdSoap implements Serializable {
	public static GEMManagementIdSoap toSoapModel(GEMManagementId model) {
		GEMManagementIdSoap soapModel = new GEMManagementIdSoap();

		soapModel.setManagementId(model.getManagementId());
		soapModel.setChainCode(model.getChainCode());
		soapModel.setCountryCode(model.getCountryCode());
		soapModel.setValue(model.getValue());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static GEMManagementIdSoap[] toSoapModels(GEMManagementId[] models) {
		GEMManagementIdSoap[] soapModels = new GEMManagementIdSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GEMManagementIdSoap[][] toSoapModels(
		GEMManagementId[][] models) {
		GEMManagementIdSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GEMManagementIdSoap[models.length][models[0].length];
		}
		else {
			soapModels = new GEMManagementIdSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GEMManagementIdSoap[] toSoapModels(
		List<GEMManagementId> models) {
		List<GEMManagementIdSoap> soapModels = new ArrayList<GEMManagementIdSoap>(models.size());

		for (GEMManagementId model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GEMManagementIdSoap[soapModels.size()]);
	}

	public GEMManagementIdSoap() {
	}

	public long getPrimaryKey() {
		return _managementId;
	}

	public void setPrimaryKey(long pk) {
		setManagementId(pk);
	}

	public long getManagementId() {
		return _managementId;
	}

	public void setManagementId(long managementId) {
		_managementId = managementId;
	}

	public String getChainCode() {
		return _chainCode;
	}

	public void setChainCode(String chainCode) {
		_chainCode = chainCode;
	}

	public String getCountryCode() {
		return _countryCode;
	}

	public void setCountryCode(String countryCode) {
		_countryCode = countryCode;
	}

	public String getValue() {
		return _value;
	}

	public void setValue(String value) {
		_value = value;
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

	private long _managementId;
	private String _chainCode;
	private String _countryCode;
	private String _value;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}