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
 * This class is a wrapper for {@link GEMMeasurementType}.
 * </p>
 *
 * @author Mummanedi
 * @see GEMMeasurementType
 * @generated
 */
public class GEMMeasurementTypeWrapper implements GEMMeasurementType,
	ModelWrapper<GEMMeasurementType> {
	public GEMMeasurementTypeWrapper(GEMMeasurementType gemMeasurementType) {
		_gemMeasurementType = gemMeasurementType;
	}

	@Override
	public Class<?> getModelClass() {
		return GEMMeasurementType.class;
	}

	@Override
	public String getModelClassName() {
		return GEMMeasurementType.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("measurementType", getMeasurementType());
		attributes.put("measurementTypeDesc", getMeasurementTypeDesc());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String measurementType = (String)attributes.get("measurementType");

		if (measurementType != null) {
			setMeasurementType(measurementType);
		}

		String measurementTypeDesc = (String)attributes.get(
				"measurementTypeDesc");

		if (measurementTypeDesc != null) {
			setMeasurementTypeDesc(measurementTypeDesc);
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
	* Returns the primary key of this g e m measurement type.
	*
	* @return the primary key of this g e m measurement type
	*/
	@Override
	public java.lang.String getPrimaryKey() {
		return _gemMeasurementType.getPrimaryKey();
	}

	/**
	* Sets the primary key of this g e m measurement type.
	*
	* @param primaryKey the primary key of this g e m measurement type
	*/
	@Override
	public void setPrimaryKey(java.lang.String primaryKey) {
		_gemMeasurementType.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the measurement type of this g e m measurement type.
	*
	* @return the measurement type of this g e m measurement type
	*/
	@Override
	public java.lang.String getMeasurementType() {
		return _gemMeasurementType.getMeasurementType();
	}

	/**
	* Sets the measurement type of this g e m measurement type.
	*
	* @param measurementType the measurement type of this g e m measurement type
	*/
	@Override
	public void setMeasurementType(java.lang.String measurementType) {
		_gemMeasurementType.setMeasurementType(measurementType);
	}

	/**
	* Returns the measurement type desc of this g e m measurement type.
	*
	* @return the measurement type desc of this g e m measurement type
	*/
	@Override
	public java.lang.String getMeasurementTypeDesc() {
		return _gemMeasurementType.getMeasurementTypeDesc();
	}

	/**
	* Sets the measurement type desc of this g e m measurement type.
	*
	* @param measurementTypeDesc the measurement type desc of this g e m measurement type
	*/
	@Override
	public void setMeasurementTypeDesc(java.lang.String measurementTypeDesc) {
		_gemMeasurementType.setMeasurementTypeDesc(measurementTypeDesc);
	}

	/**
	* Returns the creator ID of this g e m measurement type.
	*
	* @return the creator ID of this g e m measurement type
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _gemMeasurementType.getCreatorId();
	}

	/**
	* Sets the creator ID of this g e m measurement type.
	*
	* @param creatorId the creator ID of this g e m measurement type
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_gemMeasurementType.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this g e m measurement type.
	*
	* @return the created date of this g e m measurement type
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _gemMeasurementType.getCreatedDate();
	}

	/**
	* Sets the created date of this g e m measurement type.
	*
	* @param createdDate the created date of this g e m measurement type
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_gemMeasurementType.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this g e m measurement type.
	*
	* @return the updated by of this g e m measurement type
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _gemMeasurementType.getUpdatedBy();
	}

	/**
	* Sets the updated by of this g e m measurement type.
	*
	* @param updatedBy the updated by of this g e m measurement type
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_gemMeasurementType.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this g e m measurement type.
	*
	* @return the updated date of this g e m measurement type
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _gemMeasurementType.getUpdatedDate();
	}

	/**
	* Sets the updated date of this g e m measurement type.
	*
	* @param updatedDate the updated date of this g e m measurement type
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_gemMeasurementType.setUpdatedDate(updatedDate);
	}

	@Override
	public boolean isNew() {
		return _gemMeasurementType.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_gemMeasurementType.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _gemMeasurementType.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_gemMeasurementType.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _gemMeasurementType.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _gemMeasurementType.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_gemMeasurementType.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _gemMeasurementType.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_gemMeasurementType.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_gemMeasurementType.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_gemMeasurementType.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new GEMMeasurementTypeWrapper((GEMMeasurementType)_gemMeasurementType.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.GEMMeasurementType gemMeasurementType) {
		return _gemMeasurementType.compareTo(gemMeasurementType);
	}

	@Override
	public int hashCode() {
		return _gemMeasurementType.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.GEMMeasurementType> toCacheModel() {
		return _gemMeasurementType.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.GEMMeasurementType toEscapedModel() {
		return new GEMMeasurementTypeWrapper(_gemMeasurementType.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.GEMMeasurementType toUnescapedModel() {
		return new GEMMeasurementTypeWrapper(_gemMeasurementType.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _gemMeasurementType.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _gemMeasurementType.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_gemMeasurementType.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GEMMeasurementTypeWrapper)) {
			return false;
		}

		GEMMeasurementTypeWrapper gemMeasurementTypeWrapper = (GEMMeasurementTypeWrapper)obj;

		if (Validator.equals(_gemMeasurementType,
					gemMeasurementTypeWrapper._gemMeasurementType)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public GEMMeasurementType getWrappedGEMMeasurementType() {
		return _gemMeasurementType;
	}

	@Override
	public GEMMeasurementType getWrappedModel() {
		return _gemMeasurementType;
	}

	@Override
	public void resetOriginalValues() {
		_gemMeasurementType.resetOriginalValues();
	}

	private GEMMeasurementType _gemMeasurementType;
}