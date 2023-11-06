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
 * This class is a wrapper for {@link BridgePublishImport}.
 * </p>
 *
 * @author Mummanedi
 * @see BridgePublishImport
 * @generated
 */
public class BridgePublishImportWrapper implements BridgePublishImport,
	ModelWrapper<BridgePublishImport> {
	public BridgePublishImportWrapper(BridgePublishImport bridgePublishImport) {
		_bridgePublishImport = bridgePublishImport;
	}

	@Override
	public Class<?> getModelClass() {
		return BridgePublishImport.class;
	}

	@Override
	public String getModelClassName() {
		return BridgePublishImport.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("publishImportId", getPublishImportId());
		attributes.put("publishId", getPublishId());
		attributes.put("stdId", getStdId());
		attributes.put("selectInd", getSelectInd());
		attributes.put("regionId", getRegionId());
		attributes.put("status", getStatus());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long publishImportId = (Long)attributes.get("publishImportId");

		if (publishImportId != null) {
			setPublishImportId(publishImportId);
		}

		Long publishId = (Long)attributes.get("publishId");

		if (publishId != null) {
			setPublishId(publishId);
		}

		Long stdId = (Long)attributes.get("stdId");

		if (stdId != null) {
			setStdId(stdId);
		}

		String selectInd = (String)attributes.get("selectInd");

		if (selectInd != null) {
			setSelectInd(selectInd);
		}

		Long regionId = (Long)attributes.get("regionId");

		if (regionId != null) {
			setRegionId(regionId);
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
	}

	/**
	* Returns the primary key of this bridge publish import.
	*
	* @return the primary key of this bridge publish import
	*/
	@Override
	public long getPrimaryKey() {
		return _bridgePublishImport.getPrimaryKey();
	}

	/**
	* Sets the primary key of this bridge publish import.
	*
	* @param primaryKey the primary key of this bridge publish import
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_bridgePublishImport.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the publish import ID of this bridge publish import.
	*
	* @return the publish import ID of this bridge publish import
	*/
	@Override
	public long getPublishImportId() {
		return _bridgePublishImport.getPublishImportId();
	}

	/**
	* Sets the publish import ID of this bridge publish import.
	*
	* @param publishImportId the publish import ID of this bridge publish import
	*/
	@Override
	public void setPublishImportId(long publishImportId) {
		_bridgePublishImport.setPublishImportId(publishImportId);
	}

	/**
	* Returns the publish ID of this bridge publish import.
	*
	* @return the publish ID of this bridge publish import
	*/
	@Override
	public long getPublishId() {
		return _bridgePublishImport.getPublishId();
	}

	/**
	* Sets the publish ID of this bridge publish import.
	*
	* @param publishId the publish ID of this bridge publish import
	*/
	@Override
	public void setPublishId(long publishId) {
		_bridgePublishImport.setPublishId(publishId);
	}

	/**
	* Returns the std ID of this bridge publish import.
	*
	* @return the std ID of this bridge publish import
	*/
	@Override
	public long getStdId() {
		return _bridgePublishImport.getStdId();
	}

	/**
	* Sets the std ID of this bridge publish import.
	*
	* @param stdId the std ID of this bridge publish import
	*/
	@Override
	public void setStdId(long stdId) {
		_bridgePublishImport.setStdId(stdId);
	}

	/**
	* Returns the select ind of this bridge publish import.
	*
	* @return the select ind of this bridge publish import
	*/
	@Override
	public java.lang.String getSelectInd() {
		return _bridgePublishImport.getSelectInd();
	}

	/**
	* Sets the select ind of this bridge publish import.
	*
	* @param selectInd the select ind of this bridge publish import
	*/
	@Override
	public void setSelectInd(java.lang.String selectInd) {
		_bridgePublishImport.setSelectInd(selectInd);
	}

	/**
	* Returns the region ID of this bridge publish import.
	*
	* @return the region ID of this bridge publish import
	*/
	@Override
	public long getRegionId() {
		return _bridgePublishImport.getRegionId();
	}

	/**
	* Sets the region ID of this bridge publish import.
	*
	* @param regionId the region ID of this bridge publish import
	*/
	@Override
	public void setRegionId(long regionId) {
		_bridgePublishImport.setRegionId(regionId);
	}

	/**
	* Returns the status of this bridge publish import.
	*
	* @return the status of this bridge publish import
	*/
	@Override
	public java.lang.String getStatus() {
		return _bridgePublishImport.getStatus();
	}

	/**
	* Sets the status of this bridge publish import.
	*
	* @param status the status of this bridge publish import
	*/
	@Override
	public void setStatus(java.lang.String status) {
		_bridgePublishImport.setStatus(status);
	}

	/**
	* Returns the creator ID of this bridge publish import.
	*
	* @return the creator ID of this bridge publish import
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _bridgePublishImport.getCreatorId();
	}

	/**
	* Sets the creator ID of this bridge publish import.
	*
	* @param creatorId the creator ID of this bridge publish import
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_bridgePublishImport.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this bridge publish import.
	*
	* @return the created date of this bridge publish import
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _bridgePublishImport.getCreatedDate();
	}

	/**
	* Sets the created date of this bridge publish import.
	*
	* @param createdDate the created date of this bridge publish import
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_bridgePublishImport.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this bridge publish import.
	*
	* @return the updated by of this bridge publish import
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _bridgePublishImport.getUpdatedBy();
	}

	/**
	* Sets the updated by of this bridge publish import.
	*
	* @param updatedBy the updated by of this bridge publish import
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_bridgePublishImport.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this bridge publish import.
	*
	* @return the updated date of this bridge publish import
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _bridgePublishImport.getUpdatedDate();
	}

	/**
	* Sets the updated date of this bridge publish import.
	*
	* @param updatedDate the updated date of this bridge publish import
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_bridgePublishImport.setUpdatedDate(updatedDate);
	}

	@Override
	public boolean isNew() {
		return _bridgePublishImport.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_bridgePublishImport.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _bridgePublishImport.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_bridgePublishImport.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _bridgePublishImport.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _bridgePublishImport.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_bridgePublishImport.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _bridgePublishImport.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_bridgePublishImport.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_bridgePublishImport.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_bridgePublishImport.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BridgePublishImportWrapper((BridgePublishImport)_bridgePublishImport.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.BridgePublishImport bridgePublishImport) {
		return _bridgePublishImport.compareTo(bridgePublishImport);
	}

	@Override
	public int hashCode() {
		return _bridgePublishImport.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.BridgePublishImport> toCacheModel() {
		return _bridgePublishImport.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.BridgePublishImport toEscapedModel() {
		return new BridgePublishImportWrapper(_bridgePublishImport.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.BridgePublishImport toUnescapedModel() {
		return new BridgePublishImportWrapper(_bridgePublishImport.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _bridgePublishImport.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _bridgePublishImport.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_bridgePublishImport.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BridgePublishImportWrapper)) {
			return false;
		}

		BridgePublishImportWrapper bridgePublishImportWrapper = (BridgePublishImportWrapper)obj;

		if (Validator.equals(_bridgePublishImport,
					bridgePublishImportWrapper._bridgePublishImport)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public BridgePublishImport getWrappedBridgePublishImport() {
		return _bridgePublishImport;
	}

	@Override
	public BridgePublishImport getWrappedModel() {
		return _bridgePublishImport;
	}

	@Override
	public void resetOriginalValues() {
		_bridgePublishImport.resetOriginalValues();
	}

	private BridgePublishImport _bridgePublishImport;
}