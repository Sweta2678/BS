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
public class GEMTriggerSoap implements Serializable {
	public static GEMTriggerSoap toSoapModel(GEMTrigger model) {
		GEMTriggerSoap soapModel = new GEMTriggerSoap();

		soapModel.setTriggerId(model.getTriggerId());
		soapModel.setPublishDeptId(model.getPublishDeptId());
		soapModel.setPublishId(model.getPublishId());
		soapModel.setQuestion(model.getQuestion());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static GEMTriggerSoap[] toSoapModels(GEMTrigger[] models) {
		GEMTriggerSoap[] soapModels = new GEMTriggerSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GEMTriggerSoap[][] toSoapModels(GEMTrigger[][] models) {
		GEMTriggerSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GEMTriggerSoap[models.length][models[0].length];
		}
		else {
			soapModels = new GEMTriggerSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GEMTriggerSoap[] toSoapModels(List<GEMTrigger> models) {
		List<GEMTriggerSoap> soapModels = new ArrayList<GEMTriggerSoap>(models.size());

		for (GEMTrigger model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GEMTriggerSoap[soapModels.size()]);
	}

	public GEMTriggerSoap() {
	}

	public long getPrimaryKey() {
		return _triggerId;
	}

	public void setPrimaryKey(long pk) {
		setTriggerId(pk);
	}

	public long getTriggerId() {
		return _triggerId;
	}

	public void setTriggerId(long triggerId) {
		_triggerId = triggerId;
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

	public String getQuestion() {
		return _question;
	}

	public void setQuestion(String question) {
		_question = question;
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

	private long _triggerId;
	private long _publishDeptId;
	private long _publishId;
	private String _question;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}