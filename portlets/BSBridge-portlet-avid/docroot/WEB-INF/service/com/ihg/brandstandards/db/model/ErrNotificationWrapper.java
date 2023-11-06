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
 * This class is a wrapper for {@link ErrNotification}.
 * </p>
 *
 * @author Mummanedi
 * @see ErrNotification
 * @generated
 */
public class ErrNotificationWrapper implements ErrNotification,
	ModelWrapper<ErrNotification> {
	public ErrNotificationWrapper(ErrNotification errNotification) {
		_errNotification = errNotification;
	}

	@Override
	public Class<?> getModelClass() {
		return ErrNotification.class;
	}

	@Override
	public String getModelClassName() {
		return ErrNotification.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("notificationId", getNotificationId());
		attributes.put("componentName", getComponentName());
		attributes.put("referenceId", getReferenceId());
		attributes.put("severity", getSeverity());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("status", getStatus());
		attributes.put("publishId", getPublishId());
		attributes.put("regionId", getRegionId());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long notificationId = (Long)attributes.get("notificationId");

		if (notificationId != null) {
			setNotificationId(notificationId);
		}

		String componentName = (String)attributes.get("componentName");

		if (componentName != null) {
			setComponentName(componentName);
		}

		Long referenceId = (Long)attributes.get("referenceId");

		if (referenceId != null) {
			setReferenceId(referenceId);
		}

		String severity = (String)attributes.get("severity");

		if (severity != null) {
			setSeverity(severity);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long publishId = (Long)attributes.get("publishId");

		if (publishId != null) {
			setPublishId(publishId);
		}

		Long regionId = (Long)attributes.get("regionId");

		if (regionId != null) {
			setRegionId(regionId);
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
	* Returns the primary key of this err notification.
	*
	* @return the primary key of this err notification
	*/
	@Override
	public long getPrimaryKey() {
		return _errNotification.getPrimaryKey();
	}

	/**
	* Sets the primary key of this err notification.
	*
	* @param primaryKey the primary key of this err notification
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_errNotification.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the notification ID of this err notification.
	*
	* @return the notification ID of this err notification
	*/
	@Override
	public long getNotificationId() {
		return _errNotification.getNotificationId();
	}

	/**
	* Sets the notification ID of this err notification.
	*
	* @param notificationId the notification ID of this err notification
	*/
	@Override
	public void setNotificationId(long notificationId) {
		_errNotification.setNotificationId(notificationId);
	}

	/**
	* Returns the component name of this err notification.
	*
	* @return the component name of this err notification
	*/
	@Override
	public java.lang.String getComponentName() {
		return _errNotification.getComponentName();
	}

	/**
	* Sets the component name of this err notification.
	*
	* @param componentName the component name of this err notification
	*/
	@Override
	public void setComponentName(java.lang.String componentName) {
		_errNotification.setComponentName(componentName);
	}

	/**
	* Returns the reference ID of this err notification.
	*
	* @return the reference ID of this err notification
	*/
	@Override
	public long getReferenceId() {
		return _errNotification.getReferenceId();
	}

	/**
	* Sets the reference ID of this err notification.
	*
	* @param referenceId the reference ID of this err notification
	*/
	@Override
	public void setReferenceId(long referenceId) {
		_errNotification.setReferenceId(referenceId);
	}

	/**
	* Returns the severity of this err notification.
	*
	* @return the severity of this err notification
	*/
	@Override
	public java.lang.String getSeverity() {
		return _errNotification.getSeverity();
	}

	/**
	* Sets the severity of this err notification.
	*
	* @param severity the severity of this err notification
	*/
	@Override
	public void setSeverity(java.lang.String severity) {
		_errNotification.setSeverity(severity);
	}

	/**
	* Returns the title of this err notification.
	*
	* @return the title of this err notification
	*/
	@Override
	public java.lang.String getTitle() {
		return _errNotification.getTitle();
	}

	/**
	* Sets the title of this err notification.
	*
	* @param title the title of this err notification
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_errNotification.setTitle(title);
	}

	/**
	* Returns the description of this err notification.
	*
	* @return the description of this err notification
	*/
	@Override
	public java.lang.String getDescription() {
		return _errNotification.getDescription();
	}

	/**
	* Sets the description of this err notification.
	*
	* @param description the description of this err notification
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_errNotification.setDescription(description);
	}

	/**
	* Returns the status of this err notification.
	*
	* @return the status of this err notification
	*/
	@Override
	public java.lang.String getStatus() {
		return _errNotification.getStatus();
	}

	/**
	* Sets the status of this err notification.
	*
	* @param status the status of this err notification
	*/
	@Override
	public void setStatus(java.lang.String status) {
		_errNotification.setStatus(status);
	}

	/**
	* Returns the publish ID of this err notification.
	*
	* @return the publish ID of this err notification
	*/
	@Override
	public long getPublishId() {
		return _errNotification.getPublishId();
	}

	/**
	* Sets the publish ID of this err notification.
	*
	* @param publishId the publish ID of this err notification
	*/
	@Override
	public void setPublishId(long publishId) {
		_errNotification.setPublishId(publishId);
	}

	/**
	* Returns the region ID of this err notification.
	*
	* @return the region ID of this err notification
	*/
	@Override
	public long getRegionId() {
		return _errNotification.getRegionId();
	}

	/**
	* Sets the region ID of this err notification.
	*
	* @param regionId the region ID of this err notification
	*/
	@Override
	public void setRegionId(long regionId) {
		_errNotification.setRegionId(regionId);
	}

	/**
	* Returns the creator ID of this err notification.
	*
	* @return the creator ID of this err notification
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _errNotification.getCreatorId();
	}

	/**
	* Sets the creator ID of this err notification.
	*
	* @param creatorId the creator ID of this err notification
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_errNotification.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this err notification.
	*
	* @return the created date of this err notification
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _errNotification.getCreatedDate();
	}

	/**
	* Sets the created date of this err notification.
	*
	* @param createdDate the created date of this err notification
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_errNotification.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this err notification.
	*
	* @return the updated by of this err notification
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _errNotification.getUpdatedBy();
	}

	/**
	* Sets the updated by of this err notification.
	*
	* @param updatedBy the updated by of this err notification
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_errNotification.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this err notification.
	*
	* @return the updated date of this err notification
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _errNotification.getUpdatedDate();
	}

	/**
	* Sets the updated date of this err notification.
	*
	* @param updatedDate the updated date of this err notification
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_errNotification.setUpdatedDate(updatedDate);
	}

	@Override
	public boolean isNew() {
		return _errNotification.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_errNotification.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _errNotification.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_errNotification.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _errNotification.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _errNotification.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_errNotification.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _errNotification.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_errNotification.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_errNotification.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_errNotification.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ErrNotificationWrapper((ErrNotification)_errNotification.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.ErrNotification errNotification) {
		return _errNotification.compareTo(errNotification);
	}

	@Override
	public int hashCode() {
		return _errNotification.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.ErrNotification> toCacheModel() {
		return _errNotification.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.ErrNotification toEscapedModel() {
		return new ErrNotificationWrapper(_errNotification.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.ErrNotification toUnescapedModel() {
		return new ErrNotificationWrapper(_errNotification.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _errNotification.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _errNotification.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_errNotification.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ErrNotificationWrapper)) {
			return false;
		}

		ErrNotificationWrapper errNotificationWrapper = (ErrNotificationWrapper)obj;

		if (Validator.equals(_errNotification,
					errNotificationWrapper._errNotification)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ErrNotification getWrappedErrNotification() {
		return _errNotification;
	}

	@Override
	public ErrNotification getWrappedModel() {
		return _errNotification;
	}

	@Override
	public void resetOriginalValues() {
		_errNotification.resetOriginalValues();
	}

	private ErrNotification _errNotification;
}