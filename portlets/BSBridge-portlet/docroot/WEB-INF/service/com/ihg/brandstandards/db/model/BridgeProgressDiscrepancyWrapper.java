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
 * This class is a wrapper for {@link BridgeProgressDiscrepancy}.
 * </p>
 *
 * @author Mummanedi
 * @see BridgeProgressDiscrepancy
 * @generated
 */
public class BridgeProgressDiscrepancyWrapper
	implements BridgeProgressDiscrepancy,
		ModelWrapper<BridgeProgressDiscrepancy> {
	public BridgeProgressDiscrepancyWrapper(
		BridgeProgressDiscrepancy bridgeProgressDiscrepancy) {
		_bridgeProgressDiscrepancy = bridgeProgressDiscrepancy;
	}

	@Override
	public Class<?> getModelClass() {
		return BridgeProgressDiscrepancy.class;
	}

	@Override
	public String getModelClassName() {
		return BridgeProgressDiscrepancy.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("progressCategoryId", getProgressCategoryId());
		attributes.put("progressSubCategoryId", getProgressSubCategoryId());
		attributes.put("publishId", getPublishId());
		attributes.put("regionId", getRegionId());
		attributes.put("errorCount", getErrorCount());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long progressCategoryId = (Long)attributes.get("progressCategoryId");

		if (progressCategoryId != null) {
			setProgressCategoryId(progressCategoryId);
		}

		Long progressSubCategoryId = (Long)attributes.get(
				"progressSubCategoryId");

		if (progressSubCategoryId != null) {
			setProgressSubCategoryId(progressSubCategoryId);
		}

		Long publishId = (Long)attributes.get("publishId");

		if (publishId != null) {
			setPublishId(publishId);
		}

		Long regionId = (Long)attributes.get("regionId");

		if (regionId != null) {
			setRegionId(regionId);
		}

		Long errorCount = (Long)attributes.get("errorCount");

		if (errorCount != null) {
			setErrorCount(errorCount);
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
	* Returns the primary key of this bridge progress discrepancy.
	*
	* @return the primary key of this bridge progress discrepancy
	*/
	@Override
	public com.ihg.brandstandards.db.service.persistence.BridgeProgressDiscrepancyPK getPrimaryKey() {
		return _bridgeProgressDiscrepancy.getPrimaryKey();
	}

	/**
	* Sets the primary key of this bridge progress discrepancy.
	*
	* @param primaryKey the primary key of this bridge progress discrepancy
	*/
	@Override
	public void setPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.BridgeProgressDiscrepancyPK primaryKey) {
		_bridgeProgressDiscrepancy.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the progress category ID of this bridge progress discrepancy.
	*
	* @return the progress category ID of this bridge progress discrepancy
	*/
	@Override
	public long getProgressCategoryId() {
		return _bridgeProgressDiscrepancy.getProgressCategoryId();
	}

	/**
	* Sets the progress category ID of this bridge progress discrepancy.
	*
	* @param progressCategoryId the progress category ID of this bridge progress discrepancy
	*/
	@Override
	public void setProgressCategoryId(long progressCategoryId) {
		_bridgeProgressDiscrepancy.setProgressCategoryId(progressCategoryId);
	}

	/**
	* Returns the progress sub category ID of this bridge progress discrepancy.
	*
	* @return the progress sub category ID of this bridge progress discrepancy
	*/
	@Override
	public long getProgressSubCategoryId() {
		return _bridgeProgressDiscrepancy.getProgressSubCategoryId();
	}

	/**
	* Sets the progress sub category ID of this bridge progress discrepancy.
	*
	* @param progressSubCategoryId the progress sub category ID of this bridge progress discrepancy
	*/
	@Override
	public void setProgressSubCategoryId(long progressSubCategoryId) {
		_bridgeProgressDiscrepancy.setProgressSubCategoryId(progressSubCategoryId);
	}

	/**
	* Returns the publish ID of this bridge progress discrepancy.
	*
	* @return the publish ID of this bridge progress discrepancy
	*/
	@Override
	public long getPublishId() {
		return _bridgeProgressDiscrepancy.getPublishId();
	}

	/**
	* Sets the publish ID of this bridge progress discrepancy.
	*
	* @param publishId the publish ID of this bridge progress discrepancy
	*/
	@Override
	public void setPublishId(long publishId) {
		_bridgeProgressDiscrepancy.setPublishId(publishId);
	}

	/**
	* Returns the region ID of this bridge progress discrepancy.
	*
	* @return the region ID of this bridge progress discrepancy
	*/
	@Override
	public long getRegionId() {
		return _bridgeProgressDiscrepancy.getRegionId();
	}

	/**
	* Sets the region ID of this bridge progress discrepancy.
	*
	* @param regionId the region ID of this bridge progress discrepancy
	*/
	@Override
	public void setRegionId(long regionId) {
		_bridgeProgressDiscrepancy.setRegionId(regionId);
	}

	/**
	* Returns the error count of this bridge progress discrepancy.
	*
	* @return the error count of this bridge progress discrepancy
	*/
	@Override
	public long getErrorCount() {
		return _bridgeProgressDiscrepancy.getErrorCount();
	}

	/**
	* Sets the error count of this bridge progress discrepancy.
	*
	* @param errorCount the error count of this bridge progress discrepancy
	*/
	@Override
	public void setErrorCount(long errorCount) {
		_bridgeProgressDiscrepancy.setErrorCount(errorCount);
	}

	/**
	* Returns the creator ID of this bridge progress discrepancy.
	*
	* @return the creator ID of this bridge progress discrepancy
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _bridgeProgressDiscrepancy.getCreatorId();
	}

	/**
	* Sets the creator ID of this bridge progress discrepancy.
	*
	* @param creatorId the creator ID of this bridge progress discrepancy
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_bridgeProgressDiscrepancy.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this bridge progress discrepancy.
	*
	* @return the created date of this bridge progress discrepancy
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _bridgeProgressDiscrepancy.getCreatedDate();
	}

	/**
	* Sets the created date of this bridge progress discrepancy.
	*
	* @param createdDate the created date of this bridge progress discrepancy
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_bridgeProgressDiscrepancy.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this bridge progress discrepancy.
	*
	* @return the updated by of this bridge progress discrepancy
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _bridgeProgressDiscrepancy.getUpdatedBy();
	}

	/**
	* Sets the updated by of this bridge progress discrepancy.
	*
	* @param updatedBy the updated by of this bridge progress discrepancy
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_bridgeProgressDiscrepancy.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this bridge progress discrepancy.
	*
	* @return the updated date of this bridge progress discrepancy
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _bridgeProgressDiscrepancy.getUpdatedDate();
	}

	/**
	* Sets the updated date of this bridge progress discrepancy.
	*
	* @param updatedDate the updated date of this bridge progress discrepancy
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_bridgeProgressDiscrepancy.setUpdatedDate(updatedDate);
	}

	@Override
	public boolean isNew() {
		return _bridgeProgressDiscrepancy.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_bridgeProgressDiscrepancy.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _bridgeProgressDiscrepancy.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_bridgeProgressDiscrepancy.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _bridgeProgressDiscrepancy.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _bridgeProgressDiscrepancy.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_bridgeProgressDiscrepancy.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _bridgeProgressDiscrepancy.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_bridgeProgressDiscrepancy.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_bridgeProgressDiscrepancy.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_bridgeProgressDiscrepancy.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BridgeProgressDiscrepancyWrapper((BridgeProgressDiscrepancy)_bridgeProgressDiscrepancy.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy bridgeProgressDiscrepancy) {
		return _bridgeProgressDiscrepancy.compareTo(bridgeProgressDiscrepancy);
	}

	@Override
	public int hashCode() {
		return _bridgeProgressDiscrepancy.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy> toCacheModel() {
		return _bridgeProgressDiscrepancy.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy toEscapedModel() {
		return new BridgeProgressDiscrepancyWrapper(_bridgeProgressDiscrepancy.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy toUnescapedModel() {
		return new BridgeProgressDiscrepancyWrapper(_bridgeProgressDiscrepancy.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _bridgeProgressDiscrepancy.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _bridgeProgressDiscrepancy.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_bridgeProgressDiscrepancy.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BridgeProgressDiscrepancyWrapper)) {
			return false;
		}

		BridgeProgressDiscrepancyWrapper bridgeProgressDiscrepancyWrapper = (BridgeProgressDiscrepancyWrapper)obj;

		if (Validator.equals(_bridgeProgressDiscrepancy,
					bridgeProgressDiscrepancyWrapper._bridgeProgressDiscrepancy)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public BridgeProgressDiscrepancy getWrappedBridgeProgressDiscrepancy() {
		return _bridgeProgressDiscrepancy;
	}

	@Override
	public BridgeProgressDiscrepancy getWrappedModel() {
		return _bridgeProgressDiscrepancy;
	}

	@Override
	public void resetOriginalValues() {
		_bridgeProgressDiscrepancy.resetOriginalValues();
	}

	private BridgeProgressDiscrepancy _bridgeProgressDiscrepancy;
}