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
public class WorkflowSoap implements Serializable {
	public static WorkflowSoap toSoapModel(Workflow model) {
		WorkflowSoap soapModel = new WorkflowSoap();

		soapModel.setWorkflowActvtId(model.getWorkflowActvtId());
		soapModel.setObjectId(model.getObjectId());
		soapModel.setObjectType(model.getObjectType());
		soapModel.setStatus(model.getStatus());
		soapModel.setPrevStatus(model.getPrevStatus());
		soapModel.setTitle(model.getTitle());
		soapModel.setComment(model.getComment());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setChainCode(model.getChainCode());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static WorkflowSoap[] toSoapModels(Workflow[] models) {
		WorkflowSoap[] soapModels = new WorkflowSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static WorkflowSoap[][] toSoapModels(Workflow[][] models) {
		WorkflowSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new WorkflowSoap[models.length][models[0].length];
		}
		else {
			soapModels = new WorkflowSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static WorkflowSoap[] toSoapModels(List<Workflow> models) {
		List<WorkflowSoap> soapModels = new ArrayList<WorkflowSoap>(models.size());

		for (Workflow model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new WorkflowSoap[soapModels.size()]);
	}

	public WorkflowSoap() {
	}

	public long getPrimaryKey() {
		return _workflowActvtId;
	}

	public void setPrimaryKey(long pk) {
		setWorkflowActvtId(pk);
	}

	public long getWorkflowActvtId() {
		return _workflowActvtId;
	}

	public void setWorkflowActvtId(long workflowActvtId) {
		_workflowActvtId = workflowActvtId;
	}

	public long getObjectId() {
		return _objectId;
	}

	public void setObjectId(long objectId) {
		_objectId = objectId;
	}

	public String getObjectType() {
		return _objectType;
	}

	public void setObjectType(String objectType) {
		_objectType = objectType;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	public String getPrevStatus() {
		return _prevStatus;
	}

	public void setPrevStatus(String prevStatus) {
		_prevStatus = prevStatus;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getComment() {
		return _comment;
	}

	public void setComment(String comment) {
		_comment = comment;
	}

	public String getCreatedBy() {
		return _createdBy;
	}

	public void setCreatedBy(String createdBy) {
		_createdBy = createdBy;
	}

	public String getChainCode() {
		return _chainCode;
	}

	public void setChainCode(String chainCode) {
		_chainCode = chainCode;
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

	private long _workflowActvtId;
	private long _objectId;
	private String _objectType;
	private String _status;
	private String _prevStatus;
	private String _title;
	private String _comment;
	private String _createdBy;
	private String _chainCode;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}