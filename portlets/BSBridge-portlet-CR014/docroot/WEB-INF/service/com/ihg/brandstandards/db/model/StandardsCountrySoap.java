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
public class StandardsCountrySoap implements Serializable {
	public static StandardsCountrySoap toSoapModel(StandardsCountry model) {
		StandardsCountrySoap soapModel = new StandardsCountrySoap();

		soapModel.setCountryNameCode(model.getCountryNameCode());
		soapModel.setRegionId(model.getRegionId());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static StandardsCountrySoap[] toSoapModels(StandardsCountry[] models) {
		StandardsCountrySoap[] soapModels = new StandardsCountrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StandardsCountrySoap[][] toSoapModels(
		StandardsCountry[][] models) {
		StandardsCountrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StandardsCountrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new StandardsCountrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StandardsCountrySoap[] toSoapModels(
		List<StandardsCountry> models) {
		List<StandardsCountrySoap> soapModels = new ArrayList<StandardsCountrySoap>(models.size());

		for (StandardsCountry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StandardsCountrySoap[soapModels.size()]);
	}

	public StandardsCountrySoap() {
	}

	public String getPrimaryKey() {
		return _countryNameCode;
	}

	public void setPrimaryKey(String pk) {
		setCountryNameCode(pk);
	}

	public String getCountryNameCode() {
		return _countryNameCode;
	}

	public void setCountryNameCode(String countryNameCode) {
		_countryNameCode = countryNameCode;
	}

	public long getRegionId() {
		return _regionId;
	}

	public void setRegionId(long regionId) {
		_regionId = regionId;
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

	private String _countryNameCode;
	private long _regionId;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}