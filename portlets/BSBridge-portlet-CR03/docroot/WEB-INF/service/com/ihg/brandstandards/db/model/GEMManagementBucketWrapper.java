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
 * This class is a wrapper for {@link GEMManagementBucket}.
 * </p>
 *
 * @author Mummanedi
 * @see GEMManagementBucket
 * @generated
 */
public class GEMManagementBucketWrapper implements GEMManagementBucket,
	ModelWrapper<GEMManagementBucket> {
	public GEMManagementBucketWrapper(GEMManagementBucket gemManagementBucket) {
		_gemManagementBucket = gemManagementBucket;
	}

	@Override
	public Class<?> getModelClass() {
		return GEMManagementBucket.class;
	}

	@Override
	public String getModelClassName() {
		return GEMManagementBucket.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("bucketId", getBucketId());
		attributes.put("bucketName", getBucketName());
		attributes.put("departmentId", getDepartmentId());
		attributes.put("activeInd", getActiveInd());
		attributes.put("displayOrderNumber", getDisplayOrderNumber());
		attributes.put("bucketCode", getBucketCode());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long bucketId = (Long)attributes.get("bucketId");

		if (bucketId != null) {
			setBucketId(bucketId);
		}

		String bucketName = (String)attributes.get("bucketName");

		if (bucketName != null) {
			setBucketName(bucketName);
		}

		Long departmentId = (Long)attributes.get("departmentId");

		if (departmentId != null) {
			setDepartmentId(departmentId);
		}

		String activeInd = (String)attributes.get("activeInd");

		if (activeInd != null) {
			setActiveInd(activeInd);
		}

		Long displayOrderNumber = (Long)attributes.get("displayOrderNumber");

		if (displayOrderNumber != null) {
			setDisplayOrderNumber(displayOrderNumber);
		}

		String bucketCode = (String)attributes.get("bucketCode");

		if (bucketCode != null) {
			setBucketCode(bucketCode);
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
	* Returns the primary key of this g e m management bucket.
	*
	* @return the primary key of this g e m management bucket
	*/
	@Override
	public long getPrimaryKey() {
		return _gemManagementBucket.getPrimaryKey();
	}

	/**
	* Sets the primary key of this g e m management bucket.
	*
	* @param primaryKey the primary key of this g e m management bucket
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_gemManagementBucket.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the bucket ID of this g e m management bucket.
	*
	* @return the bucket ID of this g e m management bucket
	*/
	@Override
	public long getBucketId() {
		return _gemManagementBucket.getBucketId();
	}

	/**
	* Sets the bucket ID of this g e m management bucket.
	*
	* @param bucketId the bucket ID of this g e m management bucket
	*/
	@Override
	public void setBucketId(long bucketId) {
		_gemManagementBucket.setBucketId(bucketId);
	}

	/**
	* Returns the bucket name of this g e m management bucket.
	*
	* @return the bucket name of this g e m management bucket
	*/
	@Override
	public java.lang.String getBucketName() {
		return _gemManagementBucket.getBucketName();
	}

	/**
	* Sets the bucket name of this g e m management bucket.
	*
	* @param bucketName the bucket name of this g e m management bucket
	*/
	@Override
	public void setBucketName(java.lang.String bucketName) {
		_gemManagementBucket.setBucketName(bucketName);
	}

	/**
	* Returns the department ID of this g e m management bucket.
	*
	* @return the department ID of this g e m management bucket
	*/
	@Override
	public long getDepartmentId() {
		return _gemManagementBucket.getDepartmentId();
	}

	/**
	* Sets the department ID of this g e m management bucket.
	*
	* @param departmentId the department ID of this g e m management bucket
	*/
	@Override
	public void setDepartmentId(long departmentId) {
		_gemManagementBucket.setDepartmentId(departmentId);
	}

	/**
	* Returns the active ind of this g e m management bucket.
	*
	* @return the active ind of this g e m management bucket
	*/
	@Override
	public java.lang.String getActiveInd() {
		return _gemManagementBucket.getActiveInd();
	}

	/**
	* Sets the active ind of this g e m management bucket.
	*
	* @param activeInd the active ind of this g e m management bucket
	*/
	@Override
	public void setActiveInd(java.lang.String activeInd) {
		_gemManagementBucket.setActiveInd(activeInd);
	}

	/**
	* Returns the display order number of this g e m management bucket.
	*
	* @return the display order number of this g e m management bucket
	*/
	@Override
	public long getDisplayOrderNumber() {
		return _gemManagementBucket.getDisplayOrderNumber();
	}

	/**
	* Sets the display order number of this g e m management bucket.
	*
	* @param displayOrderNumber the display order number of this g e m management bucket
	*/
	@Override
	public void setDisplayOrderNumber(long displayOrderNumber) {
		_gemManagementBucket.setDisplayOrderNumber(displayOrderNumber);
	}

	/**
	* Returns the bucket code of this g e m management bucket.
	*
	* @return the bucket code of this g e m management bucket
	*/
	@Override
	public java.lang.String getBucketCode() {
		return _gemManagementBucket.getBucketCode();
	}

	/**
	* Sets the bucket code of this g e m management bucket.
	*
	* @param bucketCode the bucket code of this g e m management bucket
	*/
	@Override
	public void setBucketCode(java.lang.String bucketCode) {
		_gemManagementBucket.setBucketCode(bucketCode);
	}

	/**
	* Returns the creator ID of this g e m management bucket.
	*
	* @return the creator ID of this g e m management bucket
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _gemManagementBucket.getCreatorId();
	}

	/**
	* Sets the creator ID of this g e m management bucket.
	*
	* @param creatorId the creator ID of this g e m management bucket
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_gemManagementBucket.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this g e m management bucket.
	*
	* @return the created date of this g e m management bucket
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _gemManagementBucket.getCreatedDate();
	}

	/**
	* Sets the created date of this g e m management bucket.
	*
	* @param createdDate the created date of this g e m management bucket
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_gemManagementBucket.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this g e m management bucket.
	*
	* @return the updated by of this g e m management bucket
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _gemManagementBucket.getUpdatedBy();
	}

	/**
	* Sets the updated by of this g e m management bucket.
	*
	* @param updatedBy the updated by of this g e m management bucket
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_gemManagementBucket.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this g e m management bucket.
	*
	* @return the updated date of this g e m management bucket
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _gemManagementBucket.getUpdatedDate();
	}

	/**
	* Sets the updated date of this g e m management bucket.
	*
	* @param updatedDate the updated date of this g e m management bucket
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_gemManagementBucket.setUpdatedDate(updatedDate);
	}

	@Override
	public boolean isNew() {
		return _gemManagementBucket.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_gemManagementBucket.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _gemManagementBucket.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_gemManagementBucket.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _gemManagementBucket.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _gemManagementBucket.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_gemManagementBucket.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _gemManagementBucket.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_gemManagementBucket.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_gemManagementBucket.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_gemManagementBucket.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new GEMManagementBucketWrapper((GEMManagementBucket)_gemManagementBucket.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.GEMManagementBucket gemManagementBucket) {
		return _gemManagementBucket.compareTo(gemManagementBucket);
	}

	@Override
	public int hashCode() {
		return _gemManagementBucket.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.GEMManagementBucket> toCacheModel() {
		return _gemManagementBucket.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.GEMManagementBucket toEscapedModel() {
		return new GEMManagementBucketWrapper(_gemManagementBucket.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.GEMManagementBucket toUnescapedModel() {
		return new GEMManagementBucketWrapper(_gemManagementBucket.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _gemManagementBucket.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _gemManagementBucket.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_gemManagementBucket.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GEMManagementBucketWrapper)) {
			return false;
		}

		GEMManagementBucketWrapper gemManagementBucketWrapper = (GEMManagementBucketWrapper)obj;

		if (Validator.equals(_gemManagementBucket,
					gemManagementBucketWrapper._gemManagementBucket)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public GEMManagementBucket getWrappedGEMManagementBucket() {
		return _gemManagementBucket;
	}

	@Override
	public GEMManagementBucket getWrappedModel() {
		return _gemManagementBucket;
	}

	@Override
	public void resetOriginalValues() {
		_gemManagementBucket.resetOriginalValues();
	}

	private GEMManagementBucket _gemManagementBucket;
}