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

import com.ihg.brandstandards.db.service.persistence.CountryStandardsPK;

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
public class CountryStandardsSoap implements Serializable {
	public static CountryStandardsSoap toSoapModel(CountryStandards model) {
		CountryStandardsSoap soapModel = new CountryStandardsSoap();

		soapModel.setCountry(model.getCountry());
		soapModel.setStdId(model.getStdId());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static CountryStandardsSoap[] toSoapModels(CountryStandards[] models) {
		CountryStandardsSoap[] soapModels = new CountryStandardsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CountryStandardsSoap[][] toSoapModels(
		CountryStandards[][] models) {
		CountryStandardsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CountryStandardsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CountryStandardsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CountryStandardsSoap[] toSoapModels(
		List<CountryStandards> models) {
		List<CountryStandardsSoap> soapModels = new ArrayList<CountryStandardsSoap>(models.size());

		for (CountryStandards model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CountryStandardsSoap[soapModels.size()]);
	}

	public CountryStandardsSoap() {
	}

	public CountryStandardsPK getPrimaryKey() {
		return new CountryStandardsPK(_country, _stdId);
	}

	public void setPrimaryKey(CountryStandardsPK pk) {
		setCountry(pk.country);
		setStdId(pk.stdId);
	}

	public String getCountry() {
		return _country;
	}

	public void setCountry(String country) {
		_country = country;
	}

	public long getStdId() {
		return _stdId;
	}

	public void setStdId(long stdId) {
		_stdId = stdId;
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

	private String _country;
	private long _stdId;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}