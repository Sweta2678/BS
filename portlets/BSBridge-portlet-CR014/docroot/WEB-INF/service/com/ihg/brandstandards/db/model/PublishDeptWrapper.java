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
 * This class is a wrapper for {@link PublishDept}.
 * </p>
 *
 * @author Mummanedi
 * @see PublishDept
 * @generated
 */
public class PublishDeptWrapper implements PublishDept,
	ModelWrapper<PublishDept> {
	public PublishDeptWrapper(PublishDept publishDept) {
		_publishDept = publishDept;
	}

	@Override
	public Class<?> getModelClass() {
		return PublishDept.class;
	}

	@Override
	public String getModelClassName() {
		return PublishDept.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("publishDeptId", getPublishDeptId());
		attributes.put("deptId", getDeptId());
		attributes.put("publishId", getPublishId());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long publishDeptId = (Long)attributes.get("publishDeptId");

		if (publishDeptId != null) {
			setPublishDeptId(publishDeptId);
		}

		Long deptId = (Long)attributes.get("deptId");

		if (deptId != null) {
			setDeptId(deptId);
		}

		Long publishId = (Long)attributes.get("publishId");

		if (publishId != null) {
			setPublishId(publishId);
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
	* Returns the primary key of this publish dept.
	*
	* @return the primary key of this publish dept
	*/
	@Override
	public long getPrimaryKey() {
		return _publishDept.getPrimaryKey();
	}

	/**
	* Sets the primary key of this publish dept.
	*
	* @param primaryKey the primary key of this publish dept
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_publishDept.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the publish dept ID of this publish dept.
	*
	* @return the publish dept ID of this publish dept
	*/
	@Override
	public long getPublishDeptId() {
		return _publishDept.getPublishDeptId();
	}

	/**
	* Sets the publish dept ID of this publish dept.
	*
	* @param publishDeptId the publish dept ID of this publish dept
	*/
	@Override
	public void setPublishDeptId(long publishDeptId) {
		_publishDept.setPublishDeptId(publishDeptId);
	}

	/**
	* Returns the dept ID of this publish dept.
	*
	* @return the dept ID of this publish dept
	*/
	@Override
	public long getDeptId() {
		return _publishDept.getDeptId();
	}

	/**
	* Sets the dept ID of this publish dept.
	*
	* @param deptId the dept ID of this publish dept
	*/
	@Override
	public void setDeptId(long deptId) {
		_publishDept.setDeptId(deptId);
	}

	/**
	* Returns the publish ID of this publish dept.
	*
	* @return the publish ID of this publish dept
	*/
	@Override
	public long getPublishId() {
		return _publishDept.getPublishId();
	}

	/**
	* Sets the publish ID of this publish dept.
	*
	* @param publishId the publish ID of this publish dept
	*/
	@Override
	public void setPublishId(long publishId) {
		_publishDept.setPublishId(publishId);
	}

	/**
	* Returns the creator ID of this publish dept.
	*
	* @return the creator ID of this publish dept
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _publishDept.getCreatorId();
	}

	/**
	* Sets the creator ID of this publish dept.
	*
	* @param creatorId the creator ID of this publish dept
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_publishDept.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this publish dept.
	*
	* @return the created date of this publish dept
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _publishDept.getCreatedDate();
	}

	/**
	* Sets the created date of this publish dept.
	*
	* @param createdDate the created date of this publish dept
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_publishDept.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this publish dept.
	*
	* @return the updated by of this publish dept
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _publishDept.getUpdatedBy();
	}

	/**
	* Sets the updated by of this publish dept.
	*
	* @param updatedBy the updated by of this publish dept
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_publishDept.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this publish dept.
	*
	* @return the updated date of this publish dept
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _publishDept.getUpdatedDate();
	}

	/**
	* Sets the updated date of this publish dept.
	*
	* @param updatedDate the updated date of this publish dept
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_publishDept.setUpdatedDate(updatedDate);
	}

	@Override
	public boolean isNew() {
		return _publishDept.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_publishDept.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _publishDept.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_publishDept.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _publishDept.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _publishDept.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_publishDept.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _publishDept.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_publishDept.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_publishDept.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_publishDept.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PublishDeptWrapper((PublishDept)_publishDept.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.PublishDept publishDept) {
		return _publishDept.compareTo(publishDept);
	}

	@Override
	public int hashCode() {
		return _publishDept.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.PublishDept> toCacheModel() {
		return _publishDept.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.PublishDept toEscapedModel() {
		return new PublishDeptWrapper(_publishDept.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.PublishDept toUnescapedModel() {
		return new PublishDeptWrapper(_publishDept.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _publishDept.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _publishDept.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_publishDept.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PublishDeptWrapper)) {
			return false;
		}

		PublishDeptWrapper publishDeptWrapper = (PublishDeptWrapper)obj;

		if (Validator.equals(_publishDept, publishDeptWrapper._publishDept)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public PublishDept getWrappedPublishDept() {
		return _publishDept;
	}

	@Override
	public PublishDept getWrappedModel() {
		return _publishDept;
	}

	@Override
	public void resetOriginalValues() {
		_publishDept.resetOriginalValues();
	}

	private PublishDept _publishDept;
}