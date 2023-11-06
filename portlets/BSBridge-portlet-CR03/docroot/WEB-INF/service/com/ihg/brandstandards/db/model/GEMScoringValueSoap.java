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
public class GEMScoringValueSoap implements Serializable {
	public static GEMScoringValueSoap toSoapModel(GEMScoringValue model) {
		GEMScoringValueSoap soapModel = new GEMScoringValueSoap();

		soapModel.setScoringId(model.getScoringId());
		soapModel.setMeasurementBucketChainId(model.getMeasurementBucketChainId());
		soapModel.setTotalMeasurement(model.getTotalMeasurement());
		soapModel.setNetMeasurement(model.getNetMeasurement());
		soapModel.setNonCompliantMeasurement(model.getNonCompliantMeasurement());
		soapModel.setNonCompliantMeasurementPercent(model.getNonCompliantMeasurementPercent());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static GEMScoringValueSoap[] toSoapModels(GEMScoringValue[] models) {
		GEMScoringValueSoap[] soapModels = new GEMScoringValueSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GEMScoringValueSoap[][] toSoapModels(
		GEMScoringValue[][] models) {
		GEMScoringValueSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GEMScoringValueSoap[models.length][models[0].length];
		}
		else {
			soapModels = new GEMScoringValueSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GEMScoringValueSoap[] toSoapModels(
		List<GEMScoringValue> models) {
		List<GEMScoringValueSoap> soapModels = new ArrayList<GEMScoringValueSoap>(models.size());

		for (GEMScoringValue model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GEMScoringValueSoap[soapModels.size()]);
	}

	public GEMScoringValueSoap() {
	}

	public long getPrimaryKey() {
		return _scoringId;
	}

	public void setPrimaryKey(long pk) {
		setScoringId(pk);
	}

	public long getScoringId() {
		return _scoringId;
	}

	public void setScoringId(long scoringId) {
		_scoringId = scoringId;
	}

	public long getMeasurementBucketChainId() {
		return _measurementBucketChainId;
	}

	public void setMeasurementBucketChainId(long measurementBucketChainId) {
		_measurementBucketChainId = measurementBucketChainId;
	}

	public long getTotalMeasurement() {
		return _totalMeasurement;
	}

	public void setTotalMeasurement(long totalMeasurement) {
		_totalMeasurement = totalMeasurement;
	}

	public long getNetMeasurement() {
		return _netMeasurement;
	}

	public void setNetMeasurement(long netMeasurement) {
		_netMeasurement = netMeasurement;
	}

	public long getNonCompliantMeasurement() {
		return _nonCompliantMeasurement;
	}

	public void setNonCompliantMeasurement(long nonCompliantMeasurement) {
		_nonCompliantMeasurement = nonCompliantMeasurement;
	}

	public long getNonCompliantMeasurementPercent() {
		return _nonCompliantMeasurementPercent;
	}

	public void setNonCompliantMeasurementPercent(
		long nonCompliantMeasurementPercent) {
		_nonCompliantMeasurementPercent = nonCompliantMeasurementPercent;
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

	private long _scoringId;
	private long _measurementBucketChainId;
	private long _totalMeasurement;
	private long _netMeasurement;
	private long _nonCompliantMeasurement;
	private long _nonCompliantMeasurementPercent;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}