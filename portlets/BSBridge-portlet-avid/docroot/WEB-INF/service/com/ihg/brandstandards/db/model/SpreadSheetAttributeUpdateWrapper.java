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
 * This class is a wrapper for {@link SpreadSheetAttributeUpdate}.
 * </p>
 *
 * @author Mummanedi
 * @see SpreadSheetAttributeUpdate
 * @generated
 */
public class SpreadSheetAttributeUpdateWrapper
	implements SpreadSheetAttributeUpdate,
		ModelWrapper<SpreadSheetAttributeUpdate> {
	public SpreadSheetAttributeUpdateWrapper(
		SpreadSheetAttributeUpdate spreadSheetAttributeUpdate) {
		_spreadSheetAttributeUpdate = spreadSheetAttributeUpdate;
	}

	@Override
	public Class<?> getModelClass() {
		return SpreadSheetAttributeUpdate.class;
	}

	@Override
	public String getModelClassName() {
		return SpreadSheetAttributeUpdate.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("speardSheetId", getSpeardSheetId());
		attributes.put("requestTitle", getRequestTitle());
		attributes.put("status", getStatus());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());
		attributes.put("spreadSheet", getSpreadSheet());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long speardSheetId = (Long)attributes.get("speardSheetId");

		if (speardSheetId != null) {
			setSpeardSheetId(speardSheetId);
		}

		String requestTitle = (String)attributes.get("requestTitle");

		if (requestTitle != null) {
			setRequestTitle(requestTitle);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
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

		String spreadSheet = (String)attributes.get("spreadSheet");

		if (spreadSheet != null) {
			setSpreadSheet(spreadSheet);
		}
	}

	/**
	* Returns the primary key of this spread sheet attribute update.
	*
	* @return the primary key of this spread sheet attribute update
	*/
	@Override
	public long getPrimaryKey() {
		return _spreadSheetAttributeUpdate.getPrimaryKey();
	}

	/**
	* Sets the primary key of this spread sheet attribute update.
	*
	* @param primaryKey the primary key of this spread sheet attribute update
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_spreadSheetAttributeUpdate.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the speard sheet ID of this spread sheet attribute update.
	*
	* @return the speard sheet ID of this spread sheet attribute update
	*/
	@Override
	public long getSpeardSheetId() {
		return _spreadSheetAttributeUpdate.getSpeardSheetId();
	}

	/**
	* Sets the speard sheet ID of this spread sheet attribute update.
	*
	* @param speardSheetId the speard sheet ID of this spread sheet attribute update
	*/
	@Override
	public void setSpeardSheetId(long speardSheetId) {
		_spreadSheetAttributeUpdate.setSpeardSheetId(speardSheetId);
	}

	/**
	* Returns the request title of this spread sheet attribute update.
	*
	* @return the request title of this spread sheet attribute update
	*/
	@Override
	public java.lang.String getRequestTitle() {
		return _spreadSheetAttributeUpdate.getRequestTitle();
	}

	/**
	* Sets the request title of this spread sheet attribute update.
	*
	* @param requestTitle the request title of this spread sheet attribute update
	*/
	@Override
	public void setRequestTitle(java.lang.String requestTitle) {
		_spreadSheetAttributeUpdate.setRequestTitle(requestTitle);
	}

	/**
	* Returns the status of this spread sheet attribute update.
	*
	* @return the status of this spread sheet attribute update
	*/
	@Override
	public java.lang.String getStatus() {
		return _spreadSheetAttributeUpdate.getStatus();
	}

	/**
	* Sets the status of this spread sheet attribute update.
	*
	* @param status the status of this spread sheet attribute update
	*/
	@Override
	public void setStatus(java.lang.String status) {
		_spreadSheetAttributeUpdate.setStatus(status);
	}

	/**
	* Returns the creator ID of this spread sheet attribute update.
	*
	* @return the creator ID of this spread sheet attribute update
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _spreadSheetAttributeUpdate.getCreatorId();
	}

	/**
	* Sets the creator ID of this spread sheet attribute update.
	*
	* @param creatorId the creator ID of this spread sheet attribute update
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_spreadSheetAttributeUpdate.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this spread sheet attribute update.
	*
	* @return the created date of this spread sheet attribute update
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _spreadSheetAttributeUpdate.getCreatedDate();
	}

	/**
	* Sets the created date of this spread sheet attribute update.
	*
	* @param createdDate the created date of this spread sheet attribute update
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_spreadSheetAttributeUpdate.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this spread sheet attribute update.
	*
	* @return the updated by of this spread sheet attribute update
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _spreadSheetAttributeUpdate.getUpdatedBy();
	}

	/**
	* Sets the updated by of this spread sheet attribute update.
	*
	* @param updatedBy the updated by of this spread sheet attribute update
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_spreadSheetAttributeUpdate.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this spread sheet attribute update.
	*
	* @return the updated date of this spread sheet attribute update
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _spreadSheetAttributeUpdate.getUpdatedDate();
	}

	/**
	* Sets the updated date of this spread sheet attribute update.
	*
	* @param updatedDate the updated date of this spread sheet attribute update
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_spreadSheetAttributeUpdate.setUpdatedDate(updatedDate);
	}

	/**
	* Returns the spread sheet of this spread sheet attribute update.
	*
	* @return the spread sheet of this spread sheet attribute update
	*/
	@Override
	public java.lang.String getSpreadSheet() {
		return _spreadSheetAttributeUpdate.getSpreadSheet();
	}

	/**
	* Sets the spread sheet of this spread sheet attribute update.
	*
	* @param spreadSheet the spread sheet of this spread sheet attribute update
	*/
	@Override
	public void setSpreadSheet(java.lang.String spreadSheet) {
		_spreadSheetAttributeUpdate.setSpreadSheet(spreadSheet);
	}

	@Override
	public boolean isNew() {
		return _spreadSheetAttributeUpdate.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_spreadSheetAttributeUpdate.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _spreadSheetAttributeUpdate.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_spreadSheetAttributeUpdate.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _spreadSheetAttributeUpdate.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _spreadSheetAttributeUpdate.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_spreadSheetAttributeUpdate.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _spreadSheetAttributeUpdate.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_spreadSheetAttributeUpdate.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_spreadSheetAttributeUpdate.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_spreadSheetAttributeUpdate.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SpreadSheetAttributeUpdateWrapper((SpreadSheetAttributeUpdate)_spreadSheetAttributeUpdate.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate spreadSheetAttributeUpdate) {
		return _spreadSheetAttributeUpdate.compareTo(spreadSheetAttributeUpdate);
	}

	@Override
	public int hashCode() {
		return _spreadSheetAttributeUpdate.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate> toCacheModel() {
		return _spreadSheetAttributeUpdate.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate toEscapedModel() {
		return new SpreadSheetAttributeUpdateWrapper(_spreadSheetAttributeUpdate.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate toUnescapedModel() {
		return new SpreadSheetAttributeUpdateWrapper(_spreadSheetAttributeUpdate.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _spreadSheetAttributeUpdate.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _spreadSheetAttributeUpdate.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_spreadSheetAttributeUpdate.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SpreadSheetAttributeUpdateWrapper)) {
			return false;
		}

		SpreadSheetAttributeUpdateWrapper spreadSheetAttributeUpdateWrapper = (SpreadSheetAttributeUpdateWrapper)obj;

		if (Validator.equals(_spreadSheetAttributeUpdate,
					spreadSheetAttributeUpdateWrapper._spreadSheetAttributeUpdate)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SpreadSheetAttributeUpdate getWrappedSpreadSheetAttributeUpdate() {
		return _spreadSheetAttributeUpdate;
	}

	@Override
	public SpreadSheetAttributeUpdate getWrappedModel() {
		return _spreadSheetAttributeUpdate;
	}

	@Override
	public void resetOriginalValues() {
		_spreadSheetAttributeUpdate.resetOriginalValues();
	}

	private SpreadSheetAttributeUpdate _spreadSheetAttributeUpdate;
}