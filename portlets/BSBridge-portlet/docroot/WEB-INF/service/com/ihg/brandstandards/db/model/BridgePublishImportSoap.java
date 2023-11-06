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
public class BridgePublishImportSoap implements Serializable {
	public static BridgePublishImportSoap toSoapModel(BridgePublishImport model) {
		BridgePublishImportSoap soapModel = new BridgePublishImportSoap();

		soapModel.setPublishImportId(model.getPublishImportId());
		soapModel.setPublishId(model.getPublishId());
		soapModel.setStdId(model.getStdId());
		soapModel.setSelectInd(model.getSelectInd());
		soapModel.setRegionId(model.getRegionId());
		soapModel.setStatus(model.getStatus());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static BridgePublishImportSoap[] toSoapModels(
		BridgePublishImport[] models) {
		BridgePublishImportSoap[] soapModels = new BridgePublishImportSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BridgePublishImportSoap[][] toSoapModels(
		BridgePublishImport[][] models) {
		BridgePublishImportSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BridgePublishImportSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BridgePublishImportSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BridgePublishImportSoap[] toSoapModels(
		List<BridgePublishImport> models) {
		List<BridgePublishImportSoap> soapModels = new ArrayList<BridgePublishImportSoap>(models.size());

		for (BridgePublishImport model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BridgePublishImportSoap[soapModels.size()]);
	}

	public BridgePublishImportSoap() {
	}

	public long getPrimaryKey() {
		return _publishImportId;
	}

	public void setPrimaryKey(long pk) {
		setPublishImportId(pk);
	}

	public long getPublishImportId() {
		return _publishImportId;
	}

	public void setPublishImportId(long publishImportId) {
		_publishImportId = publishImportId;
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

	public String getSelectInd() {
		return _selectInd;
	}

	public void setSelectInd(String selectInd) {
		_selectInd = selectInd;
	}

	public long getRegionId() {
		return _regionId;
	}

	public void setRegionId(long regionId) {
		_regionId = regionId;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
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

	private long _publishImportId;
	private long _publishId;
	private long _stdId;
	private String _selectInd;
	private long _regionId;
	private String _status;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}