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

import com.ihg.brandstandards.db.service.persistence.UIElementTranslatePK;

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
public class UIElementTranslateSoap implements Serializable {
	public static UIElementTranslateSoap toSoapModel(UIElementTranslate model) {
		UIElementTranslateSoap soapModel = new UIElementTranslateSoap();

		soapModel.setElementId(model.getElementId());
		soapModel.setLocaleCode(model.getLocaleCode());
		soapModel.setElementValue(model.getElementValue());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static UIElementTranslateSoap[] toSoapModels(
		UIElementTranslate[] models) {
		UIElementTranslateSoap[] soapModels = new UIElementTranslateSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UIElementTranslateSoap[][] toSoapModels(
		UIElementTranslate[][] models) {
		UIElementTranslateSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UIElementTranslateSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UIElementTranslateSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UIElementTranslateSoap[] toSoapModels(
		List<UIElementTranslate> models) {
		List<UIElementTranslateSoap> soapModels = new ArrayList<UIElementTranslateSoap>(models.size());

		for (UIElementTranslate model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UIElementTranslateSoap[soapModels.size()]);
	}

	public UIElementTranslateSoap() {
	}

	public UIElementTranslatePK getPrimaryKey() {
		return new UIElementTranslatePK(_elementId, _localeCode);
	}

	public void setPrimaryKey(UIElementTranslatePK pk) {
		setElementId(pk.elementId);
		setLocaleCode(pk.localeCode);
	}

	public long getElementId() {
		return _elementId;
	}

	public void setElementId(long elementId) {
		_elementId = elementId;
	}

	public String getLocaleCode() {
		return _localeCode;
	}

	public void setLocaleCode(String localeCode) {
		_localeCode = localeCode;
	}

	public String getElementValue() {
		return _elementValue;
	}

	public void setElementValue(String elementValue) {
		_elementValue = elementValue;
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

	private long _elementId;
	private String _localeCode;
	private String _elementValue;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}