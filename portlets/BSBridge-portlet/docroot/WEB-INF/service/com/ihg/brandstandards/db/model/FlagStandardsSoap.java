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

import com.ihg.brandstandards.db.service.persistence.FlagStandardsPK;

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
public class FlagStandardsSoap implements Serializable {
	public static FlagStandardsSoap toSoapModel(FlagStandards model) {
		FlagStandardsSoap soapModel = new FlagStandardsSoap();

		soapModel.setFlagCatId(model.getFlagCatId());
		soapModel.setStdId(model.getStdId());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static FlagStandardsSoap[] toSoapModels(FlagStandards[] models) {
		FlagStandardsSoap[] soapModels = new FlagStandardsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FlagStandardsSoap[][] toSoapModels(FlagStandards[][] models) {
		FlagStandardsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FlagStandardsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FlagStandardsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FlagStandardsSoap[] toSoapModels(List<FlagStandards> models) {
		List<FlagStandardsSoap> soapModels = new ArrayList<FlagStandardsSoap>(models.size());

		for (FlagStandards model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FlagStandardsSoap[soapModels.size()]);
	}

	public FlagStandardsSoap() {
	}

	public FlagStandardsPK getPrimaryKey() {
		return new FlagStandardsPK(_flagCatId, _stdId);
	}

	public void setPrimaryKey(FlagStandardsPK pk) {
		setFlagCatId(pk.flagCatId);
		setStdId(pk.stdId);
	}

	public long getFlagCatId() {
		return _flagCatId;
	}

	public void setFlagCatId(long flagCatId) {
		_flagCatId = flagCatId;
	}

	public long getStdId() {
		return _stdId;
	}

	public void setStdId(long stdId) {
		_stdId = stdId;
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

	private long _flagCatId;
	private long _stdId;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}