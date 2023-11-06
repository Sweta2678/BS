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
public class GEMSeveritySoap implements Serializable {
	public static GEMSeveritySoap toSoapModel(GEMSeverity model) {
		GEMSeveritySoap soapModel = new GEMSeveritySoap();

		soapModel.setSeverityId(model.getSeverityId());
		soapModel.setSeverityName(model.getSeverityName());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static GEMSeveritySoap[] toSoapModels(GEMSeverity[] models) {
		GEMSeveritySoap[] soapModels = new GEMSeveritySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GEMSeveritySoap[][] toSoapModels(GEMSeverity[][] models) {
		GEMSeveritySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GEMSeveritySoap[models.length][models[0].length];
		}
		else {
			soapModels = new GEMSeveritySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GEMSeveritySoap[] toSoapModels(List<GEMSeverity> models) {
		List<GEMSeveritySoap> soapModels = new ArrayList<GEMSeveritySoap>(models.size());

		for (GEMSeverity model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GEMSeveritySoap[soapModels.size()]);
	}

	public GEMSeveritySoap() {
	}

	public long getPrimaryKey() {
		return _severityId;
	}

	public void setPrimaryKey(long pk) {
		setSeverityId(pk);
	}

	public long getSeverityId() {
		return _severityId;
	}

	public void setSeverityId(long severityId) {
		_severityId = severityId;
	}

	public String getSeverityName() {
		return _severityName;
	}

	public void setSeverityName(String severityName) {
		_severityName = severityName;
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

	private long _severityId;
	private String _severityName;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}