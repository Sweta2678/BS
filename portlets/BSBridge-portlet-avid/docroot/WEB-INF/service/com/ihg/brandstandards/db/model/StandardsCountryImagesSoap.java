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

import com.ihg.brandstandards.db.service.persistence.StandardsCountryImagesPK;

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
public class StandardsCountryImagesSoap implements Serializable {
	public static StandardsCountryImagesSoap toSoapModel(
		StandardsCountryImages model) {
		StandardsCountryImagesSoap soapModel = new StandardsCountryImagesSoap();

		soapModel.setStdImageId(model.getStdImageId());
		soapModel.setCountryCode(model.getCountryCode());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static StandardsCountryImagesSoap[] toSoapModels(
		StandardsCountryImages[] models) {
		StandardsCountryImagesSoap[] soapModels = new StandardsCountryImagesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StandardsCountryImagesSoap[][] toSoapModels(
		StandardsCountryImages[][] models) {
		StandardsCountryImagesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StandardsCountryImagesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StandardsCountryImagesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StandardsCountryImagesSoap[] toSoapModels(
		List<StandardsCountryImages> models) {
		List<StandardsCountryImagesSoap> soapModels = new ArrayList<StandardsCountryImagesSoap>(models.size());

		for (StandardsCountryImages model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StandardsCountryImagesSoap[soapModels.size()]);
	}

	public StandardsCountryImagesSoap() {
	}

	public StandardsCountryImagesPK getPrimaryKey() {
		return new StandardsCountryImagesPK(_stdImageId, _countryCode);
	}

	public void setPrimaryKey(StandardsCountryImagesPK pk) {
		setStdImageId(pk.stdImageId);
		setCountryCode(pk.countryCode);
	}

	public long getStdImageId() {
		return _stdImageId;
	}

	public void setStdImageId(long stdImageId) {
		_stdImageId = stdImageId;
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

	private long _stdImageId;
	private String _countryCode;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}