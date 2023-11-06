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
public class GEMChainMeasurementSoap implements Serializable {
	public static GEMChainMeasurementSoap toSoapModel(GEMChainMeasurement model) {
		GEMChainMeasurementSoap soapModel = new GEMChainMeasurementSoap();

		soapModel.setChainMeasurementId(model.getChainMeasurementId());
		soapModel.setMeasurementId(model.getMeasurementId());
		soapModel.setPublishDeptId(model.getPublishDeptId());
		soapModel.setPublishId(model.getPublishId());
		soapModel.setRegionId(model.getRegionId());
		soapModel.setUniqueGroupId(model.getUniqueGroupId());
		soapModel.setMeasurementItemCount(model.getMeasurementItemCount());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static GEMChainMeasurementSoap[] toSoapModels(
		GEMChainMeasurement[] models) {
		GEMChainMeasurementSoap[] soapModels = new GEMChainMeasurementSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GEMChainMeasurementSoap[][] toSoapModels(
		GEMChainMeasurement[][] models) {
		GEMChainMeasurementSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GEMChainMeasurementSoap[models.length][models[0].length];
		}
		else {
			soapModels = new GEMChainMeasurementSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GEMChainMeasurementSoap[] toSoapModels(
		List<GEMChainMeasurement> models) {
		List<GEMChainMeasurementSoap> soapModels = new ArrayList<GEMChainMeasurementSoap>(models.size());

		for (GEMChainMeasurement model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GEMChainMeasurementSoap[soapModels.size()]);
	}

	public GEMChainMeasurementSoap() {
	}

	public long getPrimaryKey() {
		return _chainMeasurementId;
	}

	public void setPrimaryKey(long pk) {
		setChainMeasurementId(pk);
	}

	public long getChainMeasurementId() {
		return _chainMeasurementId;
	}

	public void setChainMeasurementId(long chainMeasurementId) {
		_chainMeasurementId = chainMeasurementId;
	}

	public long getMeasurementId() {
		return _measurementId;
	}

	public void setMeasurementId(long measurementId) {
		_measurementId = measurementId;
	}

	public long getPublishDeptId() {
		return _publishDeptId;
	}

	public void setPublishDeptId(long publishDeptId) {
		_publishDeptId = publishDeptId;
	}

	public long getPublishId() {
		return _publishId;
	}

	public void setPublishId(long publishId) {
		_publishId = publishId;
	}

	public long getRegionId() {
		return _regionId;
	}

	public void setRegionId(long regionId) {
		_regionId = regionId;
	}

	public long getUniqueGroupId() {
		return _uniqueGroupId;
	}

	public void setUniqueGroupId(long uniqueGroupId) {
		_uniqueGroupId = uniqueGroupId;
	}

	public long getMeasurementItemCount() {
		return _measurementItemCount;
	}

	public void setMeasurementItemCount(long measurementItemCount) {
		_measurementItemCount = measurementItemCount;
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

	private long _chainMeasurementId;
	private long _measurementId;
	private long _publishDeptId;
	private long _publishId;
	private long _regionId;
	private long _uniqueGroupId;
	private long _measurementItemCount;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}