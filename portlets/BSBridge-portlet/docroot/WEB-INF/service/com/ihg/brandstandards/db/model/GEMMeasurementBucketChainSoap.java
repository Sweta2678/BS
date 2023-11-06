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
public class GEMMeasurementBucketChainSoap implements Serializable {
	public static GEMMeasurementBucketChainSoap toSoapModel(
		GEMMeasurementBucketChain model) {
		GEMMeasurementBucketChainSoap soapModel = new GEMMeasurementBucketChainSoap();

		soapModel.setMeasurementBucketChainId(model.getMeasurementBucketChainId());
		soapModel.setBucketId(model.getBucketId());
		soapModel.setSeverityId(model.getSeverityId());
		soapModel.setMeasurementId(model.getMeasurementId());
		soapModel.setPublishDeptId(model.getPublishDeptId());
		soapModel.setPublishId(model.getPublishId());
		soapModel.setRegionId(model.getRegionId());
		soapModel.setSubRegionCd(model.getSubRegionCd());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static GEMMeasurementBucketChainSoap[] toSoapModels(
		GEMMeasurementBucketChain[] models) {
		GEMMeasurementBucketChainSoap[] soapModels = new GEMMeasurementBucketChainSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GEMMeasurementBucketChainSoap[][] toSoapModels(
		GEMMeasurementBucketChain[][] models) {
		GEMMeasurementBucketChainSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GEMMeasurementBucketChainSoap[models.length][models[0].length];
		}
		else {
			soapModels = new GEMMeasurementBucketChainSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GEMMeasurementBucketChainSoap[] toSoapModels(
		List<GEMMeasurementBucketChain> models) {
		List<GEMMeasurementBucketChainSoap> soapModels = new ArrayList<GEMMeasurementBucketChainSoap>(models.size());

		for (GEMMeasurementBucketChain model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GEMMeasurementBucketChainSoap[soapModels.size()]);
	}

	public GEMMeasurementBucketChainSoap() {
	}

	public long getPrimaryKey() {
		return _measurementBucketChainId;
	}

	public void setPrimaryKey(long pk) {
		setMeasurementBucketChainId(pk);
	}

	public long getMeasurementBucketChainId() {
		return _measurementBucketChainId;
	}

	public void setMeasurementBucketChainId(long measurementBucketChainId) {
		_measurementBucketChainId = measurementBucketChainId;
	}

	public long getBucketId() {
		return _bucketId;
	}

	public void setBucketId(long bucketId) {
		_bucketId = bucketId;
	}

	public long getSeverityId() {
		return _severityId;
	}

	public void setSeverityId(long severityId) {
		_severityId = severityId;
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

	public String getSubRegionCd() {
		return _subRegionCd;
	}

	public void setSubRegionCd(String subRegionCd) {
		_subRegionCd = subRegionCd;
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

	private long _measurementBucketChainId;
	private long _bucketId;
	private long _severityId;
	private long _measurementId;
	private long _publishDeptId;
	private long _publishId;
	private long _regionId;
	private String _subRegionCd;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}