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

import com.ihg.brandstandards.db.service.persistence.HistManualRegionPK;

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
public class HistManualRegionSoap implements Serializable {
	public static HistManualRegionSoap toSoapModel(HistManualRegion model) {
		HistManualRegionSoap soapModel = new HistManualRegionSoap();

		soapModel.setRegionCode(model.getRegionCode());
		soapModel.setHistManualId(model.getHistManualId());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static HistManualRegionSoap[] toSoapModels(HistManualRegion[] models) {
		HistManualRegionSoap[] soapModels = new HistManualRegionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static HistManualRegionSoap[][] toSoapModels(
		HistManualRegion[][] models) {
		HistManualRegionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new HistManualRegionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new HistManualRegionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static HistManualRegionSoap[] toSoapModels(
		List<HistManualRegion> models) {
		List<HistManualRegionSoap> soapModels = new ArrayList<HistManualRegionSoap>(models.size());

		for (HistManualRegion model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new HistManualRegionSoap[soapModels.size()]);
	}

	public HistManualRegionSoap() {
	}

	public HistManualRegionPK getPrimaryKey() {
		return new HistManualRegionPK(_regionCode, _histManualId);
	}

	public void setPrimaryKey(HistManualRegionPK pk) {
		setRegionCode(pk.regionCode);
		setHistManualId(pk.histManualId);
	}

	public String getRegionCode() {
		return _regionCode;
	}

	public void setRegionCode(String regionCode) {
		_regionCode = regionCode;
	}

	public long getHistManualId() {
		return _histManualId;
	}

	public void setHistManualId(long histManualId) {
		_histManualId = histManualId;
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

	private String _regionCode;
	private long _histManualId;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}