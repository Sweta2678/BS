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
 * This class is a wrapper for {@link BridgePublish}.
 * </p>
 *
 * @author Mummanedi
 * @see BridgePublish
 * @generated
 */
public class BridgePublishWrapper implements BridgePublish,
	ModelWrapper<BridgePublish> {
	public BridgePublishWrapper(BridgePublish bridgePublish) {
		_bridgePublish = bridgePublish;
	}

	@Override
	public Class<?> getModelClass() {
		return BridgePublish.class;
	}

	@Override
	public String getModelClassName() {
		return BridgePublish.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("bridgePublishId", getBridgePublishId());
		attributes.put("publishId", getPublishId());
		attributes.put("standardId", getStandardId());
		attributes.put("regionId", getRegionId());
		attributes.put("unpublishInd", getUnpublishInd());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long bridgePublishId = (Long)attributes.get("bridgePublishId");

		if (bridgePublishId != null) {
			setBridgePublishId(bridgePublishId);
		}

		Long publishId = (Long)attributes.get("publishId");

		if (publishId != null) {
			setPublishId(publishId);
		}

		Long standardId = (Long)attributes.get("standardId");

		if (standardId != null) {
			setStandardId(standardId);
		}

		Long regionId = (Long)attributes.get("regionId");

		if (regionId != null) {
			setRegionId(regionId);
		}

		String unpublishInd = (String)attributes.get("unpublishInd");

		if (unpublishInd != null) {
			setUnpublishInd(unpublishInd);
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
	* Returns the primary key of this bridge publish.
	*
	* @return the primary key of this bridge publish
	*/
	@Override
	public long getPrimaryKey() {
		return _bridgePublish.getPrimaryKey();
	}

	/**
	* Sets the primary key of this bridge publish.
	*
	* @param primaryKey the primary key of this bridge publish
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_bridgePublish.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the bridge publish ID of this bridge publish.
	*
	* @return the bridge publish ID of this bridge publish
	*/
	@Override
	public long getBridgePublishId() {
		return _bridgePublish.getBridgePublishId();
	}

	/**
	* Sets the bridge publish ID of this bridge publish.
	*
	* @param bridgePublishId the bridge publish ID of this bridge publish
	*/
	@Override
	public void setBridgePublishId(long bridgePublishId) {
		_bridgePublish.setBridgePublishId(bridgePublishId);
	}

	/**
	* Returns the publish ID of this bridge publish.
	*
	* @return the publish ID of this bridge publish
	*/
	@Override
	public long getPublishId() {
		return _bridgePublish.getPublishId();
	}

	/**
	* Sets the publish ID of this bridge publish.
	*
	* @param publishId the publish ID of this bridge publish
	*/
	@Override
	public void setPublishId(long publishId) {
		_bridgePublish.setPublishId(publishId);
	}

	/**
	* Returns the standard ID of this bridge publish.
	*
	* @return the standard ID of this bridge publish
	*/
	@Override
	public long getStandardId() {
		return _bridgePublish.getStandardId();
	}

	/**
	* Sets the standard ID of this bridge publish.
	*
	* @param standardId the standard ID of this bridge publish
	*/
	@Override
	public void setStandardId(long standardId) {
		_bridgePublish.setStandardId(standardId);
	}

	/**
	* Returns the region ID of this bridge publish.
	*
	* @return the region ID of this bridge publish
	*/
	@Override
	public long getRegionId() {
		return _bridgePublish.getRegionId();
	}

	/**
	* Sets the region ID of this bridge publish.
	*
	* @param regionId the region ID of this bridge publish
	*/
	@Override
	public void setRegionId(long regionId) {
		_bridgePublish.setRegionId(regionId);
	}

	/**
	* Returns the unpublish ind of this bridge publish.
	*
	* @return the unpublish ind of this bridge publish
	*/
	@Override
	public java.lang.String getUnpublishInd() {
		return _bridgePublish.getUnpublishInd();
	}

	/**
	* Sets the unpublish ind of this bridge publish.
	*
	* @param unpublishInd the unpublish ind of this bridge publish
	*/
	@Override
	public void setUnpublishInd(java.lang.String unpublishInd) {
		_bridgePublish.setUnpublishInd(unpublishInd);
	}

	/**
	* Returns the creator ID of this bridge publish.
	*
	* @return the creator ID of this bridge publish
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _bridgePublish.getCreatorId();
	}

	/**
	* Sets the creator ID of this bridge publish.
	*
	* @param creatorId the creator ID of this bridge publish
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_bridgePublish.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this bridge publish.
	*
	* @return the created date of this bridge publish
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _bridgePublish.getCreatedDate();
	}

	/**
	* Sets the created date of this bridge publish.
	*
	* @param createdDate the created date of this bridge publish
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_bridgePublish.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this bridge publish.
	*
	* @return the updated by of this bridge publish
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _bridgePublish.getUpdatedBy();
	}

	/**
	* Sets the updated by of this bridge publish.
	*
	* @param updatedBy the updated by of this bridge publish
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_bridgePublish.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this bridge publish.
	*
	* @return the updated date of this bridge publish
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _bridgePublish.getUpdatedDate();
	}

	/**
	* Sets the updated date of this bridge publish.
	*
	* @param updatedDate the updated date of this bridge publish
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_bridgePublish.setUpdatedDate(updatedDate);
	}

	@Override
	public boolean isNew() {
		return _bridgePublish.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_bridgePublish.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _bridgePublish.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_bridgePublish.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _bridgePublish.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _bridgePublish.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_bridgePublish.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _bridgePublish.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_bridgePublish.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_bridgePublish.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_bridgePublish.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BridgePublishWrapper((BridgePublish)_bridgePublish.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.BridgePublish bridgePublish) {
		return _bridgePublish.compareTo(bridgePublish);
	}

	@Override
	public int hashCode() {
		return _bridgePublish.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.BridgePublish> toCacheModel() {
		return _bridgePublish.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.BridgePublish toEscapedModel() {
		return new BridgePublishWrapper(_bridgePublish.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.BridgePublish toUnescapedModel() {
		return new BridgePublishWrapper(_bridgePublish.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _bridgePublish.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _bridgePublish.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_bridgePublish.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BridgePublishWrapper)) {
			return false;
		}

		BridgePublishWrapper bridgePublishWrapper = (BridgePublishWrapper)obj;

		if (Validator.equals(_bridgePublish, bridgePublishWrapper._bridgePublish)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public BridgePublish getWrappedBridgePublish() {
		return _bridgePublish;
	}

	@Override
	public BridgePublish getWrappedModel() {
		return _bridgePublish;
	}

	@Override
	public void resetOriginalValues() {
		_bridgePublish.resetOriginalValues();
	}

	private BridgePublish _bridgePublish;
}