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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Department}.
 * </p>
 *
 * @author Mummanedi
 * @see Department
 * @generated
 */
public class DepartmentWrapper implements Department, ModelWrapper<Department> {
	public DepartmentWrapper(Department department) {
		_department = department;
	}

	@Override
	public Class<?> getModelClass() {
		return Department.class;
	}

	@Override
	public String getModelClassName() {
		return Department.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("departmentId", getDepartmentId());
		attributes.put("departmentName", getDepartmentName());
		attributes.put("description", getDescription());
		attributes.put("activeInd", getActiveInd());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long departmentId = (Long)attributes.get("departmentId");

		if (departmentId != null) {
			setDepartmentId(departmentId);
		}

		String departmentName = (String)attributes.get("departmentName");

		if (departmentName != null) {
			setDepartmentName(departmentName);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String activeInd = (String)attributes.get("activeInd");

		if (activeInd != null) {
			setActiveInd(activeInd);
		}

		String creatorId = (String)attributes.get("creatorId");

		if (creatorId != null) {
			setCreatorId(creatorId);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}

		String updatedBy = (String)attributes.get("updatedBy");

		if (updatedBy != null) {
			setUpdatedBy(updatedBy);
		}

		Date updatedDate = (Date)attributes.get("updatedDate");

		if (updatedDate != null) {
			setUpdatedDate(updatedDate);
		}
	}

	/**
	* Returns the primary key of this department.
	*
	* @return the primary key of this department
	*/
	@Override
	public long getPrimaryKey() {
		return _department.getPrimaryKey();
	}

	/**
	* Sets the primary key of this department.
	*
	* @param primaryKey the primary key of this department
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_department.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the department ID of this department.
	*
	* @return the department ID of this department
	*/
	@Override
	public long getDepartmentId() {
		return _department.getDepartmentId();
	}

	/**
	* Sets the department ID of this department.
	*
	* @param departmentId the department ID of this department
	*/
	@Override
	public void setDepartmentId(long departmentId) {
		_department.setDepartmentId(departmentId);
	}

	/**
	* Returns the department name of this department.
	*
	* @return the department name of this department
	*/
	@Override
	public java.lang.String getDepartmentName() {
		return _department.getDepartmentName();
	}

	/**
	* Sets the department name of this department.
	*
	* @param departmentName the department name of this department
	*/
	@Override
	public void setDepartmentName(java.lang.String departmentName) {
		_department.setDepartmentName(departmentName);
	}

	/**
	* Returns the description of this department.
	*
	* @return the description of this department
	*/
	@Override
	public java.lang.String getDescription() {
		return _department.getDescription();
	}

	/**
	* Sets the description of this department.
	*
	* @param description the description of this department
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_department.setDescription(description);
	}

	/**
	* Returns the active ind of this department.
	*
	* @return the active ind of this department
	*/
	@Override
	public java.lang.String getActiveInd() {
		return _department.getActiveInd();
	}

	/**
	* Sets the active ind of this department.
	*
	* @param activeInd the active ind of this department
	*/
	@Override
	public void setActiveInd(java.lang.String activeInd) {
		_department.setActiveInd(activeInd);
	}

	/**
	* Returns the creator ID of this department.
	*
	* @return the creator ID of this department
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _department.getCreatorId();
	}

	/**
	* Sets the creator ID of this department.
	*
	* @param creatorId the creator ID of this department
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_department.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this department.
	*
	* @return the created date of this department
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _department.getCreatedDate();
	}

	/**
	* Sets the created date of this department.
	*
	* @param createdDate the created date of this department
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_department.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this department.
	*
	* @return the updated by of this department
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _department.getUpdatedBy();
	}

	/**
	* Sets the updated by of this department.
	*
	* @param updatedBy the updated by of this department
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_department.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this department.
	*
	* @return the updated date of this department
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _department.getUpdatedDate();
	}

	/**
	* Sets the updated date of this department.
	*
	* @param updatedDate the updated date of this department
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_department.setUpdatedDate(updatedDate);
	}

	@Override
	public boolean isNew() {
		return _department.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_department.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _department.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_department.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _department.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _department.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_department.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _department.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_department.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_department.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_department.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DepartmentWrapper((Department)_department.clone());
	}

	@Override
	public int compareTo(com.ihg.brandstandards.db.model.Department department) {
		return _department.compareTo(department);
	}

	@Override
	public int hashCode() {
		return _department.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.Department> toCacheModel() {
		return _department.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.Department toEscapedModel() {
		return new DepartmentWrapper(_department.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.Department toUnescapedModel() {
		return new DepartmentWrapper(_department.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _department.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _department.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_department.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DepartmentWrapper)) {
			return false;
		}

		DepartmentWrapper departmentWrapper = (DepartmentWrapper)obj;

		if (Validator.equals(_department, departmentWrapper._department)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Department getWrappedDepartment() {
		return _department;
	}

	@Override
	public Department getWrappedModel() {
		return _department;
	}

	@Override
	public void resetOriginalValues() {
		_department.resetOriginalValues();
	}

	private Department _department;
}