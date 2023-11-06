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

import com.ihg.brandstandards.db.service.persistence.ChainExternalLinkStandardsPK;

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
public class ChainExternalLinkStandardsSoap implements Serializable {
	public static ChainExternalLinkStandardsSoap toSoapModel(
		ChainExternalLinkStandards model) {
		ChainExternalLinkStandardsSoap soapModel = new ChainExternalLinkStandardsSoap();

		soapModel.setExtLinkId(model.getExtLinkId());
		soapModel.setChainCode(model.getChainCode());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static ChainExternalLinkStandardsSoap[] toSoapModels(
		ChainExternalLinkStandards[] models) {
		ChainExternalLinkStandardsSoap[] soapModels = new ChainExternalLinkStandardsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ChainExternalLinkStandardsSoap[][] toSoapModels(
		ChainExternalLinkStandards[][] models) {
		ChainExternalLinkStandardsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ChainExternalLinkStandardsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ChainExternalLinkStandardsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ChainExternalLinkStandardsSoap[] toSoapModels(
		List<ChainExternalLinkStandards> models) {
		List<ChainExternalLinkStandardsSoap> soapModels = new ArrayList<ChainExternalLinkStandardsSoap>(models.size());

		for (ChainExternalLinkStandards model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ChainExternalLinkStandardsSoap[soapModels.size()]);
	}

	public ChainExternalLinkStandardsSoap() {
	}

	public ChainExternalLinkStandardsPK getPrimaryKey() {
		return new ChainExternalLinkStandardsPK(_extLinkId, _chainCode);
	}

	public void setPrimaryKey(ChainExternalLinkStandardsPK pk) {
		setExtLinkId(pk.extLinkId);
		setChainCode(pk.chainCode);
	}

	public long getExtLinkId() {
		return _extLinkId;
	}

	public void setExtLinkId(long extLinkId) {
		_extLinkId = extLinkId;
	}

	public String getChainCode() {
		return _chainCode;
	}

	public void setChainCode(String chainCode) {
		_chainCode = chainCode;
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

	private long _extLinkId;
	private String _chainCode;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}