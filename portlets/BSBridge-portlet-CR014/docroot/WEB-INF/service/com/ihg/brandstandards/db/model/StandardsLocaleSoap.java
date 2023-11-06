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
public class StandardsLocaleSoap implements Serializable {
	public static StandardsLocaleSoap toSoapModel(StandardsLocale model) {
		StandardsLocaleSoap soapModel = new StandardsLocaleSoap();

		soapModel.setLocaleCode(model.getLocaleCode());
		soapModel.setCountryCode(model.getCountryCode());
		soapModel.setLocaleName(model.getLocaleName());
		soapModel.setLanguageCode(model.getLanguageCode());
		soapModel.setOrderNumber(model.getOrderNumber());
		soapModel.setIsActive(model.getIsActive());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static StandardsLocaleSoap[] toSoapModels(StandardsLocale[] models) {
		StandardsLocaleSoap[] soapModels = new StandardsLocaleSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StandardsLocaleSoap[][] toSoapModels(
		StandardsLocale[][] models) {
		StandardsLocaleSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StandardsLocaleSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StandardsLocaleSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StandardsLocaleSoap[] toSoapModels(
		List<StandardsLocale> models) {
		List<StandardsLocaleSoap> soapModels = new ArrayList<StandardsLocaleSoap>(models.size());

		for (StandardsLocale model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StandardsLocaleSoap[soapModels.size()]);
	}

	public StandardsLocaleSoap() {
	}

	public String getPrimaryKey() {
		return _localeCode;
	}

	public void setPrimaryKey(String pk) {
		setLocaleCode(pk);
	}

	public String getLocaleCode() {
		return _localeCode;
	}

	public void setLocaleCode(String localeCode) {
		_localeCode = localeCode;
	}

	public String getCountryCode() {
		return _countryCode;
	}

	public void setCountryCode(String countryCode) {
		_countryCode = countryCode;
	}

	public String getLocaleName() {
		return _localeName;
	}

	public void setLocaleName(String localeName) {
		_localeName = localeName;
	}

	public String getLanguageCode() {
		return _languageCode;
	}

	public void setLanguageCode(String languageCode) {
		_languageCode = languageCode;
	}

	public long getOrderNumber() {
		return _orderNumber;
	}

	public void setOrderNumber(long orderNumber) {
		_orderNumber = orderNumber;
	}

	public String getIsActive() {
		return _isActive;
	}

	public void setIsActive(String isActive) {
		_isActive = isActive;
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

	private String _localeCode;
	private String _countryCode;
	private String _localeName;
	private String _languageCode;
	private long _orderNumber;
	private String _isActive;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}