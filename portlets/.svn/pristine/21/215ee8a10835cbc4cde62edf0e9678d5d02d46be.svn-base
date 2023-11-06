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

import com.ihg.brandstandards.db.service.persistence.StandardsRegionLocalePK;

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
public class StandardsRegionLocaleSoap implements Serializable {
	public static StandardsRegionLocaleSoap toSoapModel(
		StandardsRegionLocale model) {
		StandardsRegionLocaleSoap soapModel = new StandardsRegionLocaleSoap();

		soapModel.setRegionId(model.getRegionId());
		soapModel.setLocaleCode(model.getLocaleCode());
		soapModel.setIsDefault(model.getIsDefault());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static StandardsRegionLocaleSoap[] toSoapModels(
		StandardsRegionLocale[] models) {
		StandardsRegionLocaleSoap[] soapModels = new StandardsRegionLocaleSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StandardsRegionLocaleSoap[][] toSoapModels(
		StandardsRegionLocale[][] models) {
		StandardsRegionLocaleSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StandardsRegionLocaleSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StandardsRegionLocaleSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StandardsRegionLocaleSoap[] toSoapModels(
		List<StandardsRegionLocale> models) {
		List<StandardsRegionLocaleSoap> soapModels = new ArrayList<StandardsRegionLocaleSoap>(models.size());

		for (StandardsRegionLocale model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StandardsRegionLocaleSoap[soapModels.size()]);
	}

	public StandardsRegionLocaleSoap() {
	}

	public StandardsRegionLocalePK getPrimaryKey() {
		return new StandardsRegionLocalePK(_regionId, _localeCode);
	}

	public void setPrimaryKey(StandardsRegionLocalePK pk) {
		setRegionId(pk.regionId);
		setLocaleCode(pk.localeCode);
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

	public String getIsDefault() {
		return _isDefault;
	}

	public void setIsDefault(String isDefault) {
		_isDefault = isDefault;
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

	private long _regionId;
	private String _localeCode;
	private String _isDefault;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}