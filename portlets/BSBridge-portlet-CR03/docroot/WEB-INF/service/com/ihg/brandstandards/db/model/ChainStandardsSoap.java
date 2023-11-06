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

import com.ihg.brandstandards.db.service.persistence.ChainStandardsPK;

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
public class ChainStandardsSoap implements Serializable {
	public static ChainStandardsSoap toSoapModel(ChainStandards model) {
		ChainStandardsSoap soapModel = new ChainStandardsSoap();

		soapModel.setChainCode(model.getChainCode());
		soapModel.setStdId(model.getStdId());
		soapModel.setStatusId(model.getStatusId());
		soapModel.setIsActive(model.getIsActive());
		soapModel.setLastPublishedDate(model.getLastPublishedDate());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static ChainStandardsSoap[] toSoapModels(ChainStandards[] models) {
		ChainStandardsSoap[] soapModels = new ChainStandardsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ChainStandardsSoap[][] toSoapModels(ChainStandards[][] models) {
		ChainStandardsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ChainStandardsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ChainStandardsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ChainStandardsSoap[] toSoapModels(List<ChainStandards> models) {
		List<ChainStandardsSoap> soapModels = new ArrayList<ChainStandardsSoap>(models.size());

		for (ChainStandards model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ChainStandardsSoap[soapModels.size()]);
	}

	public ChainStandardsSoap() {
	}

	public ChainStandardsPK getPrimaryKey() {
		return new ChainStandardsPK(_chainCode, _stdId);
	}

	public void setPrimaryKey(ChainStandardsPK pk) {
		setChainCode(pk.chainCode);
		setStdId(pk.stdId);
	}

	public String getChainCode() {
		return _chainCode;
	}

	public void setChainCode(String chainCode) {
		_chainCode = chainCode;
	}

	public long getStdId() {
		return _stdId;
	}

	public void setStdId(long stdId) {
		_stdId = stdId;
	}

	public long getStatusId() {
		return _statusId;
	}

	public void setStatusId(long statusId) {
		_statusId = statusId;
	}

	public String getIsActive() {
		return _isActive;
	}

	public void setIsActive(String isActive) {
		_isActive = isActive;
	}

	public Date getLastPublishedDate() {
		return _lastPublishedDate;
	}

	public void setLastPublishedDate(Date lastPublishedDate) {
		_lastPublishedDate = lastPublishedDate;
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

	private String _chainCode;
	private long _stdId;
	private long _statusId;
	private String _isActive;
	private Date _lastPublishedDate;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}