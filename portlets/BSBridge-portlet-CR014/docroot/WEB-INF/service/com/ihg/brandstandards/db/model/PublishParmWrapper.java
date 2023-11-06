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
 * This class is a wrapper for {@link PublishParm}.
 * </p>
 *
 * @author Mummanedi
 * @see PublishParm
 * @generated
 */
public class PublishParmWrapper implements PublishParm,
	ModelWrapper<PublishParm> {
	public PublishParmWrapper(PublishParm publishParm) {
		_publishParm = publishParm;
	}

	@Override
	public Class<?> getModelClass() {
		return PublishParm.class;
	}

	@Override
	public String getModelClassName() {
		return PublishParm.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("publishParmId", getPublishParmId());
		attributes.put("publishId", getPublishId());
		attributes.put("parmName", getParmName());
		attributes.put("parmValue", getParmValue());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long publishParmId = (Long)attributes.get("publishParmId");

		if (publishParmId != null) {
			setPublishParmId(publishParmId);
		}

		Long publishId = (Long)attributes.get("publishId");

		if (publishId != null) {
			setPublishId(publishId);
		}

		String parmName = (String)attributes.get("parmName");

		if (parmName != null) {
			setParmName(parmName);
		}

		String parmValue = (String)attributes.get("parmValue");

		if (parmValue != null) {
			setParmValue(parmValue);
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
	* Returns the primary key of this publish parm.
	*
	* @return the primary key of this publish parm
	*/
	@Override
	public long getPrimaryKey() {
		return _publishParm.getPrimaryKey();
	}

	/**
	* Sets the primary key of this publish parm.
	*
	* @param primaryKey the primary key of this publish parm
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_publishParm.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the publish parm ID of this publish parm.
	*
	* @return the publish parm ID of this publish parm
	*/
	@Override
	public long getPublishParmId() {
		return _publishParm.getPublishParmId();
	}

	/**
	* Sets the publish parm ID of this publish parm.
	*
	* @param publishParmId the publish parm ID of this publish parm
	*/
	@Override
	public void setPublishParmId(long publishParmId) {
		_publishParm.setPublishParmId(publishParmId);
	}

	/**
	* Returns the publish ID of this publish parm.
	*
	* @return the publish ID of this publish parm
	*/
	@Override
	public long getPublishId() {
		return _publishParm.getPublishId();
	}

	/**
	* Sets the publish ID of this publish parm.
	*
	* @param publishId the publish ID of this publish parm
	*/
	@Override
	public void setPublishId(long publishId) {
		_publishParm.setPublishId(publishId);
	}

	/**
	* Returns the parm name of this publish parm.
	*
	* @return the parm name of this publish parm
	*/
	@Override
	public java.lang.String getParmName() {
		return _publishParm.getParmName();
	}

	/**
	* Sets the parm name of this publish parm.
	*
	* @param parmName the parm name of this publish parm
	*/
	@Override
	public void setParmName(java.lang.String parmName) {
		_publishParm.setParmName(parmName);
	}

	/**
	* Returns the parm value of this publish parm.
	*
	* @return the parm value of this publish parm
	*/
	@Override
	public java.lang.String getParmValue() {
		return _publishParm.getParmValue();
	}

	/**
	* Sets the parm value of this publish parm.
	*
	* @param parmValue the parm value of this publish parm
	*/
	@Override
	public void setParmValue(java.lang.String parmValue) {
		_publishParm.setParmValue(parmValue);
	}

	/**
	* Returns the creator ID of this publish parm.
	*
	* @return the creator ID of this publish parm
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _publishParm.getCreatorId();
	}

	/**
	* Sets the creator ID of this publish parm.
	*
	* @param creatorId the creator ID of this publish parm
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_publishParm.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this publish parm.
	*
	* @return the created date of this publish parm
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _publishParm.getCreatedDate();
	}

	/**
	* Sets the created date of this publish parm.
	*
	* @param createdDate the created date of this publish parm
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_publishParm.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this publish parm.
	*
	* @return the updated by of this publish parm
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _publishParm.getUpdatedBy();
	}

	/**
	* Sets the updated by of this publish parm.
	*
	* @param updatedBy the updated by of this publish parm
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_publishParm.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this publish parm.
	*
	* @return the updated date of this publish parm
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _publishParm.getUpdatedDate();
	}

	/**
	* Sets the updated date of this publish parm.
	*
	* @param updatedDate the updated date of this publish parm
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_publishParm.setUpdatedDate(updatedDate);
	}

	@Override
	public boolean isNew() {
		return _publishParm.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_publishParm.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _publishParm.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_publishParm.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _publishParm.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _publishParm.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_publishParm.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _publishParm.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_publishParm.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_publishParm.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_publishParm.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PublishParmWrapper((PublishParm)_publishParm.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.PublishParm publishParm) {
		return _publishParm.compareTo(publishParm);
	}

	@Override
	public int hashCode() {
		return _publishParm.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.PublishParm> toCacheModel() {
		return _publishParm.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.PublishParm toEscapedModel() {
		return new PublishParmWrapper(_publishParm.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.PublishParm toUnescapedModel() {
		return new PublishParmWrapper(_publishParm.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _publishParm.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _publishParm.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_publishParm.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PublishParmWrapper)) {
			return false;
		}

		PublishParmWrapper publishParmWrapper = (PublishParmWrapper)obj;

		if (Validator.equals(_publishParm, publishParmWrapper._publishParm)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public PublishParm getWrappedPublishParm() {
		return _publishParm;
	}

	@Override
	public PublishParm getWrappedModel() {
		return _publishParm;
	}

	@Override
	public void resetOriginalValues() {
		_publishParm.resetOriginalValues();
	}

	private PublishParm _publishParm;
}