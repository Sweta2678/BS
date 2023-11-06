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
public class BridgePublishStatusSoap implements Serializable {
	public static BridgePublishStatusSoap toSoapModel(BridgePublishStatus model) {
		BridgePublishStatusSoap soapModel = new BridgePublishStatusSoap();

		soapModel.setPublishStatusCode(model.getPublishStatusCode());
		soapModel.setPublishStatusName(model.getPublishStatusName());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static BridgePublishStatusSoap[] toSoapModels(
		BridgePublishStatus[] models) {
		BridgePublishStatusSoap[] soapModels = new BridgePublishStatusSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BridgePublishStatusSoap[][] toSoapModels(
		BridgePublishStatus[][] models) {
		BridgePublishStatusSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BridgePublishStatusSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BridgePublishStatusSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BridgePublishStatusSoap[] toSoapModels(
		List<BridgePublishStatus> models) {
		List<BridgePublishStatusSoap> soapModels = new ArrayList<BridgePublishStatusSoap>(models.size());

		for (BridgePublishStatus model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BridgePublishStatusSoap[soapModels.size()]);
	}

	public BridgePublishStatusSoap() {
	}

	public String getPrimaryKey() {
		return _publishStatusCode;
	}

	public void setPrimaryKey(String pk) {
		setPublishStatusCode(pk);
	}

	public String getPublishStatusCode() {
		return _publishStatusCode;
	}

	public void setPublishStatusCode(String publishStatusCode) {
		_publishStatusCode = publishStatusCode;
	}

	public String getPublishStatusName() {
		return _publishStatusName;
	}

	public void setPublishStatusName(String publishStatusName) {
		_publishStatusName = publishStatusName;
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

	private String _publishStatusCode;
	private String _publishStatusName;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}