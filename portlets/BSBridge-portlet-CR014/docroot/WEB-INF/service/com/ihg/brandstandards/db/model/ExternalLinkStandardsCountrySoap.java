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

import com.ihg.brandstandards.db.service.persistence.ExternalLinkStandardsCountryPK;

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
public class ExternalLinkStandardsCountrySoap implements Serializable {
	public static ExternalLinkStandardsCountrySoap toSoapModel(
		ExternalLinkStandardsCountry model) {
		ExternalLinkStandardsCountrySoap soapModel = new ExternalLinkStandardsCountrySoap();

		soapModel.setExtLinkId(model.getExtLinkId());
		soapModel.setCountryCode(model.getCountryCode());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static ExternalLinkStandardsCountrySoap[] toSoapModels(
		ExternalLinkStandardsCountry[] models) {
		ExternalLinkStandardsCountrySoap[] soapModels = new ExternalLinkStandardsCountrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ExternalLinkStandardsCountrySoap[][] toSoapModels(
		ExternalLinkStandardsCountry[][] models) {
		ExternalLinkStandardsCountrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ExternalLinkStandardsCountrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new ExternalLinkStandardsCountrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ExternalLinkStandardsCountrySoap[] toSoapModels(
		List<ExternalLinkStandardsCountry> models) {
		List<ExternalLinkStandardsCountrySoap> soapModels = new ArrayList<ExternalLinkStandardsCountrySoap>(models.size());

		for (ExternalLinkStandardsCountry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ExternalLinkStandardsCountrySoap[soapModels.size()]);
	}

	public ExternalLinkStandardsCountrySoap() {
	}

	public ExternalLinkStandardsCountryPK getPrimaryKey() {
		return new ExternalLinkStandardsCountryPK(_extLinkId, _countryCode);
	}

	public void setPrimaryKey(ExternalLinkStandardsCountryPK pk) {
		setExtLinkId(pk.extLinkId);
		setCountryCode(pk.countryCode);
	}

	public long getExtLinkId() {
		return _extLinkId;
	}

	public void setExtLinkId(long extLinkId) {
		_extLinkId = extLinkId;
	}

	public String getCountryCode() {
		return _countryCode;
	}

	public void setCountryCode(String countryCode) {
		_countryCode = countryCode;
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

	private long _extLinkId;
	private String _countryCode;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}