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
 * This class is a wrapper for {@link BridgePublishStatus}.
 * </p>
 *
 * @author Mummanedi
 * @see BridgePublishStatus
 * @generated
 */
public class BridgePublishStatusWrapper implements BridgePublishStatus,
	ModelWrapper<BridgePublishStatus> {
	public BridgePublishStatusWrapper(BridgePublishStatus bridgePublishStatus) {
		_bridgePublishStatus = bridgePublishStatus;
	}

	@Override
	public Class<?> getModelClass() {
		return BridgePublishStatus.class;
	}

	@Override
	public String getModelClassName() {
		return BridgePublishStatus.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("publishStatusCode", getPublishStatusCode());
		attributes.put("publishStatusName", getPublishStatusName());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String publishStatusCode = (String)attributes.get("publishStatusCode");

		if (publishStatusCode != null) {
			setPublishStatusCode(publishStatusCode);
		}

		String publishStatusName = (String)attributes.get("publishStatusName");

		if (publishStatusName != null) {
			setPublishStatusName(publishStatusName);
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
	* Returns the primary key of this bridge publish status.
	*
	* @return the primary key of this bridge publish status
	*/
	@Override
	public java.lang.String getPrimaryKey() {
		return _bridgePublishStatus.getPrimaryKey();
	}

	/**
	* Sets the primary key of this bridge publish status.
	*
	* @param primaryKey the primary key of this bridge publish status
	*/
	@Override
	public void setPrimaryKey(java.lang.String primaryKey) {
		_bridgePublishStatus.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the publish status code of this bridge publish status.
	*
	* @return the publish status code of this bridge publish status
	*/
	@Override
	public java.lang.String getPublishStatusCode() {
		return _bridgePublishStatus.getPublishStatusCode();
	}

	/**
	* Sets the publish status code of this bridge publish status.
	*
	* @param publishStatusCode the publish status code of this bridge publish status
	*/
	@Override
	public void setPublishStatusCode(java.lang.String publishStatusCode) {
		_bridgePublishStatus.setPublishStatusCode(publishStatusCode);
	}

	/**
	* Returns the publish status name of this bridge publish status.
	*
	* @return the publish status name of this bridge publish status
	*/
	@Override
	public java.lang.String getPublishStatusName() {
		return _bridgePublishStatus.getPublishStatusName();
	}

	/**
	* Sets the publish status name of this bridge publish status.
	*
	* @param publishStatusName the publish status name of this bridge publish status
	*/
	@Override
	public void setPublishStatusName(java.lang.String publishStatusName) {
		_bridgePublishStatus.setPublishStatusName(publishStatusName);
	}

	/**
	* Returns the creator ID of this bridge publish status.
	*
	* @return the creator ID of this bridge publish status
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _bridgePublishStatus.getCreatorId();
	}

	/**
	* Sets the creator ID of this bridge publish status.
	*
	* @param creatorId the creator ID of this bridge publish status
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_bridgePublishStatus.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this bridge publish status.
	*
	* @return the created date of this bridge publish status
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _bridgePublishStatus.getCreatedDate();
	}

	/**
	* Sets the created date of this bridge publish status.
	*
	* @param createdDate the created date of this bridge publish status
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_bridgePublishStatus.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this bridge publish status.
	*
	* @return the updated by of this bridge publish status
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _bridgePublishStatus.getUpdatedBy();
	}

	/**
	* Sets the updated by of this bridge publish status.
	*
	* @param updatedBy the updated by of this bridge publish status
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_bridgePublishStatus.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this bridge publish status.
	*
	* @return the updated date of this bridge publish status
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _bridgePublishStatus.getUpdatedDate();
	}

	/**
	* Sets the updated date of this bridge publish status.
	*
	* @param updatedDate the updated date of this bridge publish status
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_bridgePublishStatus.setUpdatedDate(updatedDate);
	}

	@Override
	public boolean isNew() {
		return _bridgePublishStatus.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_bridgePublishStatus.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _bridgePublishStatus.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_bridgePublishStatus.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _bridgePublishStatus.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _bridgePublishStatus.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_bridgePublishStatus.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _bridgePublishStatus.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_bridgePublishStatus.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_bridgePublishStatus.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_bridgePublishStatus.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BridgePublishStatusWrapper((BridgePublishStatus)_bridgePublishStatus.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.BridgePublishStatus bridgePublishStatus) {
		return _bridgePublishStatus.compareTo(bridgePublishStatus);
	}

	@Override
	public int hashCode() {
		return _bridgePublishStatus.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.BridgePublishStatus> toCacheModel() {
		return _bridgePublishStatus.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.BridgePublishStatus toEscapedModel() {
		return new BridgePublishStatusWrapper(_bridgePublishStatus.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.BridgePublishStatus toUnescapedModel() {
		return new BridgePublishStatusWrapper(_bridgePublishStatus.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _bridgePublishStatus.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _bridgePublishStatus.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_bridgePublishStatus.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BridgePublishStatusWrapper)) {
			return false;
		}

		BridgePublishStatusWrapper bridgePublishStatusWrapper = (BridgePublishStatusWrapper)obj;

		if (Validator.equals(_bridgePublishStatus,
					bridgePublishStatusWrapper._bridgePublishStatus)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public BridgePublishStatus getWrappedBridgePublishStatus() {
		return _bridgePublishStatus;
	}

	@Override
	public BridgePublishStatus getWrappedModel() {
		return _bridgePublishStatus;
	}

	@Override
	public void resetOriginalValues() {
		_bridgePublishStatus.resetOriginalValues();
	}

	private BridgePublishStatus _bridgePublishStatus;
}