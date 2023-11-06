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
public class GEMQlReportSoap implements Serializable {
	public static GEMQlReportSoap toSoapModel(GEMQlReport model) {
		GEMQlReportSoap soapModel = new GEMQlReportSoap();

		soapModel.setQlReportId(model.getQlReportId());
		soapModel.setPublishDeptId(model.getPublishDeptId());
		soapModel.setPublishId(model.getPublishId());
		soapModel.setStdId(model.getStdId());
		soapModel.setBucketId(model.getBucketId());
		soapModel.setSeverityId(model.getSeverityId());
		soapModel.setMeasurementId(model.getMeasurementId());
		soapModel.setTriggerId(model.getTriggerId());
		soapModel.setCategoryId(model.getCategoryId());
		soapModel.setDisplayOrderNumber(model.getDisplayOrderNumber());
		soapModel.setRegionId(model.getRegionId());
		soapModel.setComplianceDueDays(model.getComplianceDueDays());
		soapModel.setGlblMustMeasure(model.getGlblMustMeasure());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static GEMQlReportSoap[] toSoapModels(GEMQlReport[] models) {
		GEMQlReportSoap[] soapModels = new GEMQlReportSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GEMQlReportSoap[][] toSoapModels(GEMQlReport[][] models) {
		GEMQlReportSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GEMQlReportSoap[models.length][models[0].length];
		}
		else {
			soapModels = new GEMQlReportSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GEMQlReportSoap[] toSoapModels(List<GEMQlReport> models) {
		List<GEMQlReportSoap> soapModels = new ArrayList<GEMQlReportSoap>(models.size());

		for (GEMQlReport model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GEMQlReportSoap[soapModels.size()]);
	}

	public GEMQlReportSoap() {
	}

	public long getPrimaryKey() {
		return _qlReportId;
	}

	public void setPrimaryKey(long pk) {
		setQlReportId(pk);
	}

	public long getQlReportId() {
		return _qlReportId;
	}

	public void setQlReportId(long qlReportId) {
		_qlReportId = qlReportId;
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

	public long getStdId() {
		return _stdId;
	}

	public void setStdId(long stdId) {
		_stdId = stdId;
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

	public long getTriggerId() {
		return _triggerId;
	}

	public void setTriggerId(long triggerId) {
		_triggerId = triggerId;
	}

	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
	}

	public long getDisplayOrderNumber() {
		return _displayOrderNumber;
	}

	public void setDisplayOrderNumber(long displayOrderNumber) {
		_displayOrderNumber = displayOrderNumber;
	}

	public long getRegionId() {
		return _regionId;
	}

	public void setRegionId(long regionId) {
		_regionId = regionId;
	}

	public long getComplianceDueDays() {
		return _complianceDueDays;
	}

	public void setComplianceDueDays(long complianceDueDays) {
		_complianceDueDays = complianceDueDays;
	}

	public String getGlblMustMeasure() {
		return _glblMustMeasure;
	}

	public void setGlblMustMeasure(String glblMustMeasure) {
		_glblMustMeasure = glblMustMeasure;
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

	private long _qlReportId;
	private long _publishDeptId;
	private long _publishId;
	private long _stdId;
	private long _bucketId;
	private long _severityId;
	private long _measurementId;
	private long _triggerId;
	private long _categoryId;
	private long _displayOrderNumber;
	private long _regionId;
	private long _complianceDueDays;
	private String _glblMustMeasure;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}