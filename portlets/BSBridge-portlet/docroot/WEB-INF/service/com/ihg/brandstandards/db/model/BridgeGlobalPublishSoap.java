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
public class BridgeGlobalPublishSoap implements Serializable {
	public static BridgeGlobalPublishSoap toSoapModel(BridgeGlobalPublish model) {
		BridgeGlobalPublishSoap soapModel = new BridgeGlobalPublishSoap();

		soapModel.setGlobalPublishId(model.getGlobalPublishId());
		soapModel.setPublishId(model.getPublishId());
		soapModel.setStdId(model.getStdId());
		soapModel.setMustPublishInd(model.getMustPublishInd());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static BridgeGlobalPublishSoap[] toSoapModels(
		BridgeGlobalPublish[] models) {
		BridgeGlobalPublishSoap[] soapModels = new BridgeGlobalPublishSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BridgeGlobalPublishSoap[][] toSoapModels(
		BridgeGlobalPublish[][] models) {
		BridgeGlobalPublishSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BridgeGlobalPublishSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BridgeGlobalPublishSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BridgeGlobalPublishSoap[] toSoapModels(
		List<BridgeGlobalPublish> models) {
		List<BridgeGlobalPublishSoap> soapModels = new ArrayList<BridgeGlobalPublishSoap>(models.size());

		for (BridgeGlobalPublish model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BridgeGlobalPublishSoap[soapModels.size()]);
	}

	public BridgeGlobalPublishSoap() {
	}

	public long getPrimaryKey() {
		return _globalPublishId;
	}

	public void setPrimaryKey(long pk) {
		setGlobalPublishId(pk);
	}

	public long getGlobalPublishId() {
		return _globalPublishId;
	}

	public void setGlobalPublishId(long globalPublishId) {
		_globalPublishId = globalPublishId;
	}

	public long getPublishId() {
		return _publishId;
	}

	public void setPublishId(long publishId) {
		_publishId = publishId;
	}

	public long getStdId() {
		return _stdId;
	}

	public void setStdId(long stdId) {
		_stdId = stdId;
	}

	public String getMustPublishInd() {
		return _mustPublishInd;
	}

	public void setMustPublishInd(String mustPublishInd) {
		_mustPublishInd = mustPublishInd;
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

	private long _globalPublishId;
	private long _publishId;
	private long _stdId;
	private String _mustPublishInd;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}