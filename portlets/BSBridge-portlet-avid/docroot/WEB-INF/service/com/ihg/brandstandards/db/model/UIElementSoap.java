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
public class UIElementSoap implements Serializable {
	public static UIElementSoap toSoapModel(UIElement model) {
		UIElementSoap soapModel = new UIElementSoap();

		soapModel.setElementId(model.getElementId());
		soapModel.setElementKey(model.getElementKey());
		soapModel.setModuleName(model.getModuleName());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static UIElementSoap[] toSoapModels(UIElement[] models) {
		UIElementSoap[] soapModels = new UIElementSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UIElementSoap[][] toSoapModels(UIElement[][] models) {
		UIElementSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UIElementSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UIElementSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UIElementSoap[] toSoapModels(List<UIElement> models) {
		List<UIElementSoap> soapModels = new ArrayList<UIElementSoap>(models.size());

		for (UIElement model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UIElementSoap[soapModels.size()]);
	}

	public UIElementSoap() {
	}

	public long getPrimaryKey() {
		return _elementId;
	}

	public void setPrimaryKey(long pk) {
		setElementId(pk);
	}

	public long getElementId() {
		return _elementId;
	}

	public void setElementId(long elementId) {
		_elementId = elementId;
	}

	public String getElementKey() {
		return _elementKey;
	}

	public void setElementKey(String elementKey) {
		_elementKey = elementKey;
	}

	public String getModuleName() {
		return _moduleName;
	}

	public void setModuleName(String moduleName) {
		_moduleName = moduleName;
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
	private String _elementKey;
	private String _moduleName;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}