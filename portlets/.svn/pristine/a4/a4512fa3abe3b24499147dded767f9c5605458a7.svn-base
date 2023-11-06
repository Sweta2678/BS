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
public class ErrNotificationSoap implements Serializable {
	public static ErrNotificationSoap toSoapModel(ErrNotification model) {
		ErrNotificationSoap soapModel = new ErrNotificationSoap();

		soapModel.setNotificationId(model.getNotificationId());
		soapModel.setComponentName(model.getComponentName());
		soapModel.setReferenceId(model.getReferenceId());
		soapModel.setSeverity(model.getSeverity());
		soapModel.setTitle(model.getTitle());
		soapModel.setDescription(model.getDescription());
		soapModel.setStatus(model.getStatus());
		soapModel.setPublishId(model.getPublishId());
		soapModel.setRegionId(model.getRegionId());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static ErrNotificationSoap[] toSoapModels(ErrNotification[] models) {
		ErrNotificationSoap[] soapModels = new ErrNotificationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ErrNotificationSoap[][] toSoapModels(
		ErrNotification[][] models) {
		ErrNotificationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ErrNotificationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ErrNotificationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ErrNotificationSoap[] toSoapModels(
		List<ErrNotification> models) {
		List<ErrNotificationSoap> soapModels = new ArrayList<ErrNotificationSoap>(models.size());

		for (ErrNotification model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ErrNotificationSoap[soapModels.size()]);
	}

	public ErrNotificationSoap() {
	}

	public long getPrimaryKey() {
		return _notificationId;
	}

	public void setPrimaryKey(long pk) {
		setNotificationId(pk);
	}

	public long getNotificationId() {
		return _notificationId;
	}

	public void setNotificationId(long notificationId) {
		_notificationId = notificationId;
	}

	public String getComponentName() {
		return _componentName;
	}

	public void setComponentName(String componentName) {
		_componentName = componentName;
	}

	public long getReferenceId() {
		return _referenceId;
	}

	public void setReferenceId(long referenceId) {
		_referenceId = referenceId;
	}

	public String getSeverity() {
		return _severity;
	}

	public void setSeverity(String severity) {
		_severity = severity;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
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

	private long _notificationId;
	private String _componentName;
	private long _referenceId;
	private String _severity;
	private String _title;
	private String _description;
	private String _status;
	private long _publishId;
	private long _regionId;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}