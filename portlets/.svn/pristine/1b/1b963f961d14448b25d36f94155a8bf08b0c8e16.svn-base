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
public class PublishDeptSoap implements Serializable {
	public static PublishDeptSoap toSoapModel(PublishDept model) {
		PublishDeptSoap soapModel = new PublishDeptSoap();

		soapModel.setPublishDeptId(model.getPublishDeptId());
		soapModel.setDeptId(model.getDeptId());
		soapModel.setPublishId(model.getPublishId());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static PublishDeptSoap[] toSoapModels(PublishDept[] models) {
		PublishDeptSoap[] soapModels = new PublishDeptSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PublishDeptSoap[][] toSoapModels(PublishDept[][] models) {
		PublishDeptSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PublishDeptSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PublishDeptSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PublishDeptSoap[] toSoapModels(List<PublishDept> models) {
		List<PublishDeptSoap> soapModels = new ArrayList<PublishDeptSoap>(models.size());

		for (PublishDept model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PublishDeptSoap[soapModels.size()]);
	}

	public PublishDeptSoap() {
	}

	public long getPrimaryKey() {
		return _publishDeptId;
	}

	public void setPrimaryKey(long pk) {
		setPublishDeptId(pk);
	}

	public long getPublishDeptId() {
		return _publishDeptId;
	}

	public void setPublishDeptId(long publishDeptId) {
		_publishDeptId = publishDeptId;
	}

	public long getDeptId() {
		return _deptId;
	}

	public void setDeptId(long deptId) {
		_deptId = deptId;
	}

	public long getPublishId() {
		return _publishId;
	}

	public void setPublishId(long publishId) {
		_publishId = publishId;
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

	private long _publishDeptId;
	private long _deptId;
	private long _publishId;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}