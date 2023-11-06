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
 * This class is a wrapper for {@link GEMMeasurementBucketChain}.
 * </p>
 *
 * @author Mummanedi
 * @see GEMMeasurementBucketChain
 * @generated
 */
public class GEMMeasurementBucketChainWrapper
	implements GEMMeasurementBucketChain,
		ModelWrapper<GEMMeasurementBucketChain> {
	public GEMMeasurementBucketChainWrapper(
		GEMMeasurementBucketChain gemMeasurementBucketChain) {
		_gemMeasurementBucketChain = gemMeasurementBucketChain;
	}

	@Override
	public Class<?> getModelClass() {
		return GEMMeasurementBucketChain.class;
	}

	@Override
	public String getModelClassName() {
		return GEMMeasurementBucketChain.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("measurementBucketChainId", getMeasurementBucketChainId());
		attributes.put("bucketId", getBucketId());
		attributes.put("severityId", getSeverityId());
		attributes.put("measurementId", getMeasurementId());
		attributes.put("publishDeptId", getPublishDeptId());
		attributes.put("publishId", getPublishId());
		attributes.put("regionId", getRegionId());
		attributes.put("subRegionCd", getSubRegionCd());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long measurementBucketChainId = (Long)attributes.get(
				"measurementBucketChainId");

		if (measurementBucketChainId != null) {
			setMeasurementBucketChainId(measurementBucketChainId);
		}

		Long bucketId = (Long)attributes.get("bucketId");

		if (bucketId != null) {
			setBucketId(bucketId);
		}

		Long severityId = (Long)attributes.get("severityId");

		if (severityId != null) {
			setSeverityId(severityId);
		}

		Long measurementId = (Long)attributes.get("measurementId");

		if (measurementId != null) {
			setMeasurementId(measurementId);
		}

		Long publishDeptId = (Long)attributes.get("publishDeptId");

		if (publishDeptId != null) {
			setPublishDeptId(publishDeptId);
		}

		Long publishId = (Long)attributes.get("publishId");

		if (publishId != null) {
			setPublishId(publishId);
		}

		Long regionId = (Long)attributes.get("regionId");

		if (regionId != null) {
			setRegionId(regionId);
		}

		String subRegionCd = (String)attributes.get("subRegionCd");

		if (subRegionCd != null) {
			setSubRegionCd(subRegionCd);
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
	* Returns the primary key of this g e m measurement bucket chain.
	*
	* @return the primary key of this g e m measurement bucket chain
	*/
	@Override
	public long getPrimaryKey() {
		return _gemMeasurementBucketChain.getPrimaryKey();
	}

	/**
	* Sets the primary key of this g e m measurement bucket chain.
	*
	* @param primaryKey the primary key of this g e m measurement bucket chain
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_gemMeasurementBucketChain.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the measurement bucket chain ID of this g e m measurement bucket chain.
	*
	* @return the measurement bucket chain ID of this g e m measurement bucket chain
	*/
	@Override
	public long getMeasurementBucketChainId() {
		return _gemMeasurementBucketChain.getMeasurementBucketChainId();
	}

	/**
	* Sets the measurement bucket chain ID of this g e m measurement bucket chain.
	*
	* @param measurementBucketChainId the measurement bucket chain ID of this g e m measurement bucket chain
	*/
	@Override
	public void setMeasurementBucketChainId(long measurementBucketChainId) {
		_gemMeasurementBucketChain.setMeasurementBucketChainId(measurementBucketChainId);
	}

	/**
	* Returns the bucket ID of this g e m measurement bucket chain.
	*
	* @return the bucket ID of this g e m measurement bucket chain
	*/
	@Override
	public long getBucketId() {
		return _gemMeasurementBucketChain.getBucketId();
	}

	/**
	* Sets the bucket ID of this g e m measurement bucket chain.
	*
	* @param bucketId the bucket ID of this g e m measurement bucket chain
	*/
	@Override
	public void setBucketId(long bucketId) {
		_gemMeasurementBucketChain.setBucketId(bucketId);
	}

	/**
	* Returns the severity ID of this g e m measurement bucket chain.
	*
	* @return the severity ID of this g e m measurement bucket chain
	*/
	@Override
	public long getSeverityId() {
		return _gemMeasurementBucketChain.getSeverityId();
	}

	/**
	* Sets the severity ID of this g e m measurement bucket chain.
	*
	* @param severityId the severity ID of this g e m measurement bucket chain
	*/
	@Override
	public void setSeverityId(long severityId) {
		_gemMeasurementBucketChain.setSeverityId(severityId);
	}

	/**
	* Returns the measurement ID of this g e m measurement bucket chain.
	*
	* @return the measurement ID of this g e m measurement bucket chain
	*/
	@Override
	public long getMeasurementId() {
		return _gemMeasurementBucketChain.getMeasurementId();
	}

	/**
	* Sets the measurement ID of this g e m measurement bucket chain.
	*
	* @param measurementId the measurement ID of this g e m measurement bucket chain
	*/
	@Override
	public void setMeasurementId(long measurementId) {
		_gemMeasurementBucketChain.setMeasurementId(measurementId);
	}

	/**
	* Returns the publish dept ID of this g e m measurement bucket chain.
	*
	* @return the publish dept ID of this g e m measurement bucket chain
	*/
	@Override
	public long getPublishDeptId() {
		return _gemMeasurementBucketChain.getPublishDeptId();
	}

	/**
	* Sets the publish dept ID of this g e m measurement bucket chain.
	*
	* @param publishDeptId the publish dept ID of this g e m measurement bucket chain
	*/
	@Override
	public void setPublishDeptId(long publishDeptId) {
		_gemMeasurementBucketChain.setPublishDeptId(publishDeptId);
	}

	/**
	* Returns the publish ID of this g e m measurement bucket chain.
	*
	* @return the publish ID of this g e m measurement bucket chain
	*/
	@Override
	public long getPublishId() {
		return _gemMeasurementBucketChain.getPublishId();
	}

	/**
	* Sets the publish ID of this g e m measurement bucket chain.
	*
	* @param publishId the publish ID of this g e m measurement bucket chain
	*/
	@Override
	public void setPublishId(long publishId) {
		_gemMeasurementBucketChain.setPublishId(publishId);
	}

	/**
	* Returns the region ID of this g e m measurement bucket chain.
	*
	* @return the region ID of this g e m measurement bucket chain
	*/
	@Override
	public long getRegionId() {
		return _gemMeasurementBucketChain.getRegionId();
	}

	/**
	* Sets the region ID of this g e m measurement bucket chain.
	*
	* @param regionId the region ID of this g e m measurement bucket chain
	*/
	@Override
	public void setRegionId(long regionId) {
		_gemMeasurementBucketChain.setRegionId(regionId);
	}

	/**
	* Returns the sub region cd of this g e m measurement bucket chain.
	*
	* @return the sub region cd of this g e m measurement bucket chain
	*/
	@Override
	public java.lang.String getSubRegionCd() {
		return _gemMeasurementBucketChain.getSubRegionCd();
	}

	/**
	* Sets the sub region cd of this g e m measurement bucket chain.
	*
	* @param subRegionCd the sub region cd of this g e m measurement bucket chain
	*/
	@Override
	public void setSubRegionCd(java.lang.String subRegionCd) {
		_gemMeasurementBucketChain.setSubRegionCd(subRegionCd);
	}

	/**
	* Returns the creator ID of this g e m measurement bucket chain.
	*
	* @return the creator ID of this g e m measurement bucket chain
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _gemMeasurementBucketChain.getCreatorId();
	}

	/**
	* Sets the creator ID of this g e m measurement bucket chain.
	*
	* @param creatorId the creator ID of this g e m measurement bucket chain
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_gemMeasurementBucketChain.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this g e m measurement bucket chain.
	*
	* @return the created date of this g e m measurement bucket chain
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _gemMeasurementBucketChain.getCreatedDate();
	}

	/**
	* Sets the created date of this g e m measurement bucket chain.
	*
	* @param createdDate the created date of this g e m measurement bucket chain
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_gemMeasurementBucketChain.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this g e m measurement bucket chain.
	*
	* @return the updated by of this g e m measurement bucket chain
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _gemMeasurementBucketChain.getUpdatedBy();
	}

	/**
	* Sets the updated by of this g e m measurement bucket chain.
	*
	* @param updatedBy the updated by of this g e m measurement bucket chain
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_gemMeasurementBucketChain.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this g e m measurement bucket chain.
	*
	* @return the updated date of this g e m measurement bucket chain
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _gemMeasurementBucketChain.getUpdatedDate();
	}

	/**
	* Sets the updated date of this g e m measurement bucket chain.
	*
	* @param updatedDate the updated date of this g e m measurement bucket chain
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_gemMeasurementBucketChain.setUpdatedDate(updatedDate);
	}

	@Override
	public boolean isNew() {
		return _gemMeasurementBucketChain.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_gemMeasurementBucketChain.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _gemMeasurementBucketChain.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_gemMeasurementBucketChain.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _gemMeasurementBucketChain.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _gemMeasurementBucketChain.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_gemMeasurementBucketChain.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _gemMeasurementBucketChain.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_gemMeasurementBucketChain.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_gemMeasurementBucketChain.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_gemMeasurementBucketChain.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new GEMMeasurementBucketChainWrapper((GEMMeasurementBucketChain)_gemMeasurementBucketChain.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.GEMMeasurementBucketChain gemMeasurementBucketChain) {
		return _gemMeasurementBucketChain.compareTo(gemMeasurementBucketChain);
	}

	@Override
	public int hashCode() {
		return _gemMeasurementBucketChain.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.GEMMeasurementBucketChain> toCacheModel() {
		return _gemMeasurementBucketChain.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.GEMMeasurementBucketChain toEscapedModel() {
		return new GEMMeasurementBucketChainWrapper(_gemMeasurementBucketChain.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.GEMMeasurementBucketChain toUnescapedModel() {
		return new GEMMeasurementBucketChainWrapper(_gemMeasurementBucketChain.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _gemMeasurementBucketChain.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _gemMeasurementBucketChain.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_gemMeasurementBucketChain.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GEMMeasurementBucketChainWrapper)) {
			return false;
		}

		GEMMeasurementBucketChainWrapper gemMeasurementBucketChainWrapper = (GEMMeasurementBucketChainWrapper)obj;

		if (Validator.equals(_gemMeasurementBucketChain,
					gemMeasurementBucketChainWrapper._gemMeasurementBucketChain)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public GEMMeasurementBucketChain getWrappedGEMMeasurementBucketChain() {
		return _gemMeasurementBucketChain;
	}

	@Override
	public GEMMeasurementBucketChain getWrappedModel() {
		return _gemMeasurementBucketChain;
	}

	@Override
	public void resetOriginalValues() {
		_gemMeasurementBucketChain.resetOriginalValues();
	}

	private GEMMeasurementBucketChain _gemMeasurementBucketChain;
}