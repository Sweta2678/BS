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
public class DepartmentSoap implements Serializable {
	public static DepartmentSoap toSoapModel(Department model) {
		DepartmentSoap soapModel = new DepartmentSoap();

		soapModel.setDepartmentId(model.getDepartmentId());
		soapModel.setDepartmentName(model.getDepartmentName());
		soapModel.setDescription(model.getDescription());
		soapModel.setActiveInd(model.getActiveInd());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static DepartmentSoap[] toSoapModels(Department[] models) {
		DepartmentSoap[] soapModels = new DepartmentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DepartmentSoap[][] toSoapModels(Department[][] models) {
		DepartmentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DepartmentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DepartmentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DepartmentSoap[] toSoapModels(List<Department> models) {
		List<DepartmentSoap> soapModels = new ArrayList<DepartmentSoap>(models.size());

		for (Department model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DepartmentSoap[soapModels.size()]);
	}

	public DepartmentSoap() {
	}

	public long getPrimaryKey() {
		return _departmentId;
	}

	public void setPrimaryKey(long pk) {
		setDepartmentId(pk);
	}

	public long getDepartmentId() {
		return _departmentId;
	}

	public void setDepartmentId(long departmentId) {
		_departmentId = departmentId;
	}

	public String getDepartmentName() {
		return _departmentName;
	}

	public void setDepartmentName(String departmentName) {
		_departmentName = departmentName;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getActiveInd() {
		return _activeInd;
	}

	public void setActiveInd(String activeInd) {
		_activeInd = activeInd;
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

	private long _departmentId;
	private String _departmentName;
	private String _description;
	private String _activeInd;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}