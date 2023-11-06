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
public class GEMManagementBucketSoap implements Serializable {
	public static GEMManagementBucketSoap toSoapModel(GEMManagementBucket model) {
		GEMManagementBucketSoap soapModel = new GEMManagementBucketSoap();

		soapModel.setBucketId(model.getBucketId());
		soapModel.setBucketName(model.getBucketName());
		soapModel.setDepartmentId(model.getDepartmentId());
		soapModel.setActiveInd(model.getActiveInd());
		soapModel.setDisplayOrderNumber(model.getDisplayOrderNumber());
		soapModel.setBucketCode(model.getBucketCode());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static GEMManagementBucketSoap[] toSoapModels(
		GEMManagementBucket[] models) {
		GEMManagementBucketSoap[] soapModels = new GEMManagementBucketSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GEMManagementBucketSoap[][] toSoapModels(
		GEMManagementBucket[][] models) {
		GEMManagementBucketSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GEMManagementBucketSoap[models.length][models[0].length];
		}
		else {
			soapModels = new GEMManagementBucketSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GEMManagementBucketSoap[] toSoapModels(
		List<GEMManagementBucket> models) {
		List<GEMManagementBucketSoap> soapModels = new ArrayList<GEMManagementBucketSoap>(models.size());

		for (GEMManagementBucket model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GEMManagementBucketSoap[soapModels.size()]);
	}

	public GEMManagementBucketSoap() {
	}

	public long getPrimaryKey() {
		return _bucketId;
	}

	public void setPrimaryKey(long pk) {
		setBucketId(pk);
	}

	public long getBucketId() {
		return _bucketId;
	}

	public void setBucketId(long bucketId) {
		_bucketId = bucketId;
	}

	public String getBucketName() {
		return _bucketName;
	}

	public void setBucketName(String bucketName) {
		_bucketName = bucketName;
	}

	public long getDepartmentId() {
		return _departmentId;
	}

	public void setDepartmentId(long departmentId) {
		_departmentId = departmentId;
	}

	public String getActiveInd() {
		return _activeInd;
	}

	public void setActiveInd(String activeInd) {
		_activeInd = activeInd;
	}

	public long getDisplayOrderNumber() {
		return _displayOrderNumber;
	}

	public void setDisplayOrderNumber(long displayOrderNumber) {
		_displayOrderNumber = displayOrderNumber;
	}

	public String getBucketCode() {
		return _bucketCode;
	}

	public void setBucketCode(String bucketCode) {
		_bucketCode = bucketCode;
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

	private long _bucketId;
	private String _bucketName;
	private long _departmentId;
	private String _activeInd;
	private long _displayOrderNumber;
	private String _bucketCode;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}