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
public class StandardsStatusSoap implements Serializable {
	public static StandardsStatusSoap toSoapModel(StandardsStatus model) {
		StandardsStatusSoap soapModel = new StandardsStatusSoap();

		soapModel.setStatusId(model.getStatusId());
		soapModel.setStatusCode(model.getStatusCode());
		soapModel.setTitle(model.getTitle());
		soapModel.setRegionId(model.getRegionId());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static StandardsStatusSoap[] toSoapModels(StandardsStatus[] models) {
		StandardsStatusSoap[] soapModels = new StandardsStatusSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StandardsStatusSoap[][] toSoapModels(
		StandardsStatus[][] models) {
		StandardsStatusSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StandardsStatusSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StandardsStatusSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StandardsStatusSoap[] toSoapModels(
		List<StandardsStatus> models) {
		List<StandardsStatusSoap> soapModels = new ArrayList<StandardsStatusSoap>(models.size());

		for (StandardsStatus model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StandardsStatusSoap[soapModels.size()]);
	}

	public StandardsStatusSoap() {
	}

	public long getPrimaryKey() {
		return _statusId;
	}

	public void setPrimaryKey(long pk) {
		setStatusId(pk);
	}

	public long getStatusId() {
		return _statusId;
	}

	public void setStatusId(long statusId) {
		_statusId = statusId;
	}

	public String getStatusCode() {
		return _statusCode;
	}

	public void setStatusCode(String statusCode) {
		_statusCode = statusCode;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public long getRegionId() {
		return _regionId;
	}

	public void setRegionId(long regionId) {
		_regionId = regionId;
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

	private long _statusId;
	private String _statusCode;
	private String _title;
	private long _regionId;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}