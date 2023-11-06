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
 * This class is a wrapper for {@link BridgeGlobalPublish}.
 * </p>
 *
 * @author Mummanedi
 * @see BridgeGlobalPublish
 * @generated
 */
public class BridgeGlobalPublishWrapper implements BridgeGlobalPublish,
	ModelWrapper<BridgeGlobalPublish> {
	public BridgeGlobalPublishWrapper(BridgeGlobalPublish bridgeGlobalPublish) {
		_bridgeGlobalPublish = bridgeGlobalPublish;
	}

	@Override
	public Class<?> getModelClass() {
		return BridgeGlobalPublish.class;
	}

	@Override
	public String getModelClassName() {
		return BridgeGlobalPublish.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("globalPublishId", getGlobalPublishId());
		attributes.put("publishId", getPublishId());
		attributes.put("stdId", getStdId());
		attributes.put("mustPublishInd", getMustPublishInd());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long globalPublishId = (Long)attributes.get("globalPublishId");

		if (globalPublishId != null) {
			setGlobalPublishId(globalPublishId);
		}

		Long publishId = (Long)attributes.get("publishId");

		if (publishId != null) {
			setPublishId(publishId);
		}

		Long stdId = (Long)attributes.get("stdId");

		if (stdId != null) {
			setStdId(stdId);
		}

		String mustPublishInd = (String)attributes.get("mustPublishInd");

		if (mustPublishInd != null) {
			setMustPublishInd(mustPublishInd);
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
	* Returns the primary key of this bridge global publish.
	*
	* @return the primary key of this bridge global publish
	*/
	@Override
	public long getPrimaryKey() {
		return _bridgeGlobalPublish.getPrimaryKey();
	}

	/**
	* Sets the primary key of this bridge global publish.
	*
	* @param primaryKey the primary key of this bridge global publish
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_bridgeGlobalPublish.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the global publish ID of this bridge global publish.
	*
	* @return the global publish ID of this bridge global publish
	*/
	@Override
	public long getGlobalPublishId() {
		return _bridgeGlobalPublish.getGlobalPublishId();
	}

	/**
	* Sets the global publish ID of this bridge global publish.
	*
	* @param globalPublishId the global publish ID of this bridge global publish
	*/
	@Override
	public void setGlobalPublishId(long globalPublishId) {
		_bridgeGlobalPublish.setGlobalPublishId(globalPublishId);
	}

	/**
	* Returns the publish ID of this bridge global publish.
	*
	* @return the publish ID of this bridge global publish
	*/
	@Override
	public long getPublishId() {
		return _bridgeGlobalPublish.getPublishId();
	}

	/**
	* Sets the publish ID of this bridge global publish.
	*
	* @param publishId the publish ID of this bridge global publish
	*/
	@Override
	public void setPublishId(long publishId) {
		_bridgeGlobalPublish.setPublishId(publishId);
	}

	/**
	* Returns the std ID of this bridge global publish.
	*
	* @return the std ID of this bridge global publish
	*/
	@Override
	public long getStdId() {
		return _bridgeGlobalPublish.getStdId();
	}

	/**
	* Sets the std ID of this bridge global publish.
	*
	* @param stdId the std ID of this bridge global publish
	*/
	@Override
	public void setStdId(long stdId) {
		_bridgeGlobalPublish.setStdId(stdId);
	}

	/**
	* Returns the must publish ind of this bridge global publish.
	*
	* @return the must publish ind of this bridge global publish
	*/
	@Override
	public java.lang.String getMustPublishInd() {
		return _bridgeGlobalPublish.getMustPublishInd();
	}

	/**
	* Sets the must publish ind of this bridge global publish.
	*
	* @param mustPublishInd the must publish ind of this bridge global publish
	*/
	@Override
	public void setMustPublishInd(java.lang.String mustPublishInd) {
		_bridgeGlobalPublish.setMustPublishInd(mustPublishInd);
	}

	/**
	* Returns the creator ID of this bridge global publish.
	*
	* @return the creator ID of this bridge global publish
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _bridgeGlobalPublish.getCreatorId();
	}

	/**
	* Sets the creator ID of this bridge global publish.
	*
	* @param creatorId the creator ID of this bridge global publish
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_bridgeGlobalPublish.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this bridge global publish.
	*
	* @return the created date of this bridge global publish
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _bridgeGlobalPublish.getCreatedDate();
	}

	/**
	* Sets the created date of this bridge global publish.
	*
	* @param createdDate the created date of this bridge global publish
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_bridgeGlobalPublish.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this bridge global publish.
	*
	* @return the updated by of this bridge global publish
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _bridgeGlobalPublish.getUpdatedBy();
	}

	/**
	* Sets the updated by of this bridge global publish.
	*
	* @param updatedBy the updated by of this bridge global publish
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_bridgeGlobalPublish.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this bridge global publish.
	*
	* @return the updated date of this bridge global publish
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _bridgeGlobalPublish.getUpdatedDate();
	}

	/**
	* Sets the updated date of this bridge global publish.
	*
	* @param updatedDate the updated date of this bridge global publish
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_bridgeGlobalPublish.setUpdatedDate(updatedDate);
	}

	@Override
	public boolean isNew() {
		return _bridgeGlobalPublish.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_bridgeGlobalPublish.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _bridgeGlobalPublish.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_bridgeGlobalPublish.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _bridgeGlobalPublish.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _bridgeGlobalPublish.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_bridgeGlobalPublish.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _bridgeGlobalPublish.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_bridgeGlobalPublish.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_bridgeGlobalPublish.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_bridgeGlobalPublish.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BridgeGlobalPublishWrapper((BridgeGlobalPublish)_bridgeGlobalPublish.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.BridgeGlobalPublish bridgeGlobalPublish) {
		return _bridgeGlobalPublish.compareTo(bridgeGlobalPublish);
	}

	@Override
	public int hashCode() {
		return _bridgeGlobalPublish.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.BridgeGlobalPublish> toCacheModel() {
		return _bridgeGlobalPublish.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.BridgeGlobalPublish toEscapedModel() {
		return new BridgeGlobalPublishWrapper(_bridgeGlobalPublish.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.BridgeGlobalPublish toUnescapedModel() {
		return new BridgeGlobalPublishWrapper(_bridgeGlobalPublish.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _bridgeGlobalPublish.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _bridgeGlobalPublish.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_bridgeGlobalPublish.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BridgeGlobalPublishWrapper)) {
			return false;
		}

		BridgeGlobalPublishWrapper bridgeGlobalPublishWrapper = (BridgeGlobalPublishWrapper)obj;

		if (Validator.equals(_bridgeGlobalPublish,
					bridgeGlobalPublishWrapper._bridgeGlobalPublish)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public BridgeGlobalPublish getWrappedBridgeGlobalPublish() {
		return _bridgeGlobalPublish;
	}

	@Override
	public BridgeGlobalPublish getWrappedModel() {
		return _bridgeGlobalPublish;
	}

	@Override
	public void resetOriginalValues() {
		_bridgeGlobalPublish.resetOriginalValues();
	}

	private BridgeGlobalPublish _bridgeGlobalPublish;
}