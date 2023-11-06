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

import com.ihg.brandstandards.db.service.persistence.BridgeProgressDiscrepancyPK;

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
public class BridgeProgressDiscrepancySoap implements Serializable {
	public static BridgeProgressDiscrepancySoap toSoapModel(
		BridgeProgressDiscrepancy model) {
		BridgeProgressDiscrepancySoap soapModel = new BridgeProgressDiscrepancySoap();

		soapModel.setProgressCategoryId(model.getProgressCategoryId());
		soapModel.setProgressSubCategoryId(model.getProgressSubCategoryId());
		soapModel.setPublishId(model.getPublishId());
		soapModel.setRegionId(model.getRegionId());
		soapModel.setErrorCount(model.getErrorCount());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static BridgeProgressDiscrepancySoap[] toSoapModels(
		BridgeProgressDiscrepancy[] models) {
		BridgeProgressDiscrepancySoap[] soapModels = new BridgeProgressDiscrepancySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BridgeProgressDiscrepancySoap[][] toSoapModels(
		BridgeProgressDiscrepancy[][] models) {
		BridgeProgressDiscrepancySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BridgeProgressDiscrepancySoap[models.length][models[0].length];
		}
		else {
			soapModels = new BridgeProgressDiscrepancySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BridgeProgressDiscrepancySoap[] toSoapModels(
		List<BridgeProgressDiscrepancy> models) {
		List<BridgeProgressDiscrepancySoap> soapModels = new ArrayList<BridgeProgressDiscrepancySoap>(models.size());

		for (BridgeProgressDiscrepancy model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BridgeProgressDiscrepancySoap[soapModels.size()]);
	}

	public BridgeProgressDiscrepancySoap() {
	}

	public BridgeProgressDiscrepancyPK getPrimaryKey() {
		return new BridgeProgressDiscrepancyPK(_progressCategoryId,
			_progressSubCategoryId, _publishId, _regionId);
	}

	public void setPrimaryKey(BridgeProgressDiscrepancyPK pk) {
		setProgressCategoryId(pk.progressCategoryId);
		setProgressSubCategoryId(pk.progressSubCategoryId);
		setPublishId(pk.publishId);
		setRegionId(pk.regionId);
	}

	public long getProgressCategoryId() {
		return _progressCategoryId;
	}

	public void setProgressCategoryId(long progressCategoryId) {
		_progressCategoryId = progressCategoryId;
	}

	public long getProgressSubCategoryId() {
		return _progressSubCategoryId;
	}

	public void setProgressSubCategoryId(long progressSubCategoryId) {
		_progressSubCategoryId = progressSubCategoryId;
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

	public long getErrorCount() {
		return _errorCount;
	}

	public void setErrorCount(long errorCount) {
		_errorCount = errorCount;
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

	private long _progressCategoryId;
	private long _progressSubCategoryId;
	private long _publishId;
	private long _regionId;
	private long _errorCount;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}