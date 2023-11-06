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
 * This class is a wrapper for {@link GEMSeverity}.
 * </p>
 *
 * @author Mummanedi
 * @see GEMSeverity
 * @generated
 */
public class GEMSeverityWrapper implements GEMSeverity,
	ModelWrapper<GEMSeverity> {
	public GEMSeverityWrapper(GEMSeverity gemSeverity) {
		_gemSeverity = gemSeverity;
	}

	@Override
	public Class<?> getModelClass() {
		return GEMSeverity.class;
	}

	@Override
	public String getModelClassName() {
		return GEMSeverity.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("severityId", getSeverityId());
		attributes.put("severityName", getSeverityName());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long severityId = (Long)attributes.get("severityId");

		if (severityId != null) {
			setSeverityId(severityId);
		}

		String severityName = (String)attributes.get("severityName");

		if (severityName != null) {
			setSeverityName(severityName);
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
	* Returns the primary key of this g e m severity.
	*
	* @return the primary key of this g e m severity
	*/
	@Override
	public long getPrimaryKey() {
		return _gemSeverity.getPrimaryKey();
	}

	/**
	* Sets the primary key of this g e m severity.
	*
	* @param primaryKey the primary key of this g e m severity
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_gemSeverity.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the severity ID of this g e m severity.
	*
	* @return the severity ID of this g e m severity
	*/
	@Override
	public long getSeverityId() {
		return _gemSeverity.getSeverityId();
	}

	/**
	* Sets the severity ID of this g e m severity.
	*
	* @param severityId the severity ID of this g e m severity
	*/
	@Override
	public void setSeverityId(long severityId) {
		_gemSeverity.setSeverityId(severityId);
	}

	/**
	* Returns the severity name of this g e m severity.
	*
	* @return the severity name of this g e m severity
	*/
	@Override
	public java.lang.String getSeverityName() {
		return _gemSeverity.getSeverityName();
	}

	/**
	* Sets the severity name of this g e m severity.
	*
	* @param severityName the severity name of this g e m severity
	*/
	@Override
	public void setSeverityName(java.lang.String severityName) {
		_gemSeverity.setSeverityName(severityName);
	}

	/**
	* Returns the creator ID of this g e m severity.
	*
	* @return the creator ID of this g e m severity
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _gemSeverity.getCreatorId();
	}

	/**
	* Sets the creator ID of this g e m severity.
	*
	* @param creatorId the creator ID of this g e m severity
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_gemSeverity.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this g e m severity.
	*
	* @return the created date of this g e m severity
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _gemSeverity.getCreatedDate();
	}

	/**
	* Sets the created date of this g e m severity.
	*
	* @param createdDate the created date of this g e m severity
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_gemSeverity.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this g e m severity.
	*
	* @return the updated by of this g e m severity
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _gemSeverity.getUpdatedBy();
	}

	/**
	* Sets the updated by of this g e m severity.
	*
	* @param updatedBy the updated by of this g e m severity
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_gemSeverity.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this g e m severity.
	*
	* @return the updated date of this g e m severity
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _gemSeverity.getUpdatedDate();
	}

	/**
	* Sets the updated date of this g e m severity.
	*
	* @param updatedDate the updated date of this g e m severity
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_gemSeverity.setUpdatedDate(updatedDate);
	}

	@Override
	public boolean isNew() {
		return _gemSeverity.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_gemSeverity.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _gemSeverity.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_gemSeverity.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _gemSeverity.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _gemSeverity.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_gemSeverity.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _gemSeverity.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_gemSeverity.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_gemSeverity.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_gemSeverity.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new GEMSeverityWrapper((GEMSeverity)_gemSeverity.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.GEMSeverity gemSeverity) {
		return _gemSeverity.compareTo(gemSeverity);
	}

	@Override
	public int hashCode() {
		return _gemSeverity.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.GEMSeverity> toCacheModel() {
		return _gemSeverity.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.GEMSeverity toEscapedModel() {
		return new GEMSeverityWrapper(_gemSeverity.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.GEMSeverity toUnescapedModel() {
		return new GEMSeverityWrapper(_gemSeverity.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _gemSeverity.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _gemSeverity.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_gemSeverity.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GEMSeverityWrapper)) {
			return false;
		}

		GEMSeverityWrapper gemSeverityWrapper = (GEMSeverityWrapper)obj;

		if (Validator.equals(_gemSeverity, gemSeverityWrapper._gemSeverity)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public GEMSeverity getWrappedGEMSeverity() {
		return _gemSeverity;
	}

	@Override
	public GEMSeverity getWrappedModel() {
		return _gemSeverity;
	}

	@Override
	public void resetOriginalValues() {
		_gemSeverity.resetOriginalValues();
	}

	private GEMSeverity _gemSeverity;
}