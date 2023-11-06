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
 * This class is a wrapper for {@link GEMMeasurement}.
 * </p>
 *
 * @author Mummanedi
 * @see GEMMeasurement
 * @generated
 */
public class GEMMeasurementWrapper implements GEMMeasurement,
	ModelWrapper<GEMMeasurement> {
	public GEMMeasurementWrapper(GEMMeasurement gemMeasurement) {
		_gemMeasurement = gemMeasurement;
	}

	@Override
	public Class<?> getModelClass() {
		return GEMMeasurement.class;
	}

	@Override
	public String getModelClassName() {
		return GEMMeasurement.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("measurementId", getMeasurementId());
		attributes.put("measurementName", getMeasurementName());
		attributes.put("measurementType", getMeasurementType());
		attributes.put("displayOrderNumber", getDisplayOrderNumber());
		attributes.put("templateId", getTemplateId());
		attributes.put("multiplierQty", getMultiplierQty());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long measurementId = (Long)attributes.get("measurementId");

		if (measurementId != null) {
			setMeasurementId(measurementId);
		}

		String measurementName = (String)attributes.get("measurementName");

		if (measurementName != null) {
			setMeasurementName(measurementName);
		}

		String measurementType = (String)attributes.get("measurementType");

		if (measurementType != null) {
			setMeasurementType(measurementType);
		}

		Long displayOrderNumber = (Long)attributes.get("displayOrderNumber");

		if (displayOrderNumber != null) {
			setDisplayOrderNumber(displayOrderNumber);
		}

		Long templateId = (Long)attributes.get("templateId");

		if (templateId != null) {
			setTemplateId(templateId);
		}

		Long multiplierQty = (Long)attributes.get("multiplierQty");

		if (multiplierQty != null) {
			setMultiplierQty(multiplierQty);
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
	* Returns the primary key of this g e m measurement.
	*
	* @return the primary key of this g e m measurement
	*/
	@Override
	public long getPrimaryKey() {
		return _gemMeasurement.getPrimaryKey();
	}

	/**
	* Sets the primary key of this g e m measurement.
	*
	* @param primaryKey the primary key of this g e m measurement
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_gemMeasurement.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the measurement ID of this g e m measurement.
	*
	* @return the measurement ID of this g e m measurement
	*/
	@Override
	public long getMeasurementId() {
		return _gemMeasurement.getMeasurementId();
	}

	/**
	* Sets the measurement ID of this g e m measurement.
	*
	* @param measurementId the measurement ID of this g e m measurement
	*/
	@Override
	public void setMeasurementId(long measurementId) {
		_gemMeasurement.setMeasurementId(measurementId);
	}

	/**
	* Returns the measurement name of this g e m measurement.
	*
	* @return the measurement name of this g e m measurement
	*/
	@Override
	public java.lang.String getMeasurementName() {
		return _gemMeasurement.getMeasurementName();
	}

	/**
	* Sets the measurement name of this g e m measurement.
	*
	* @param measurementName the measurement name of this g e m measurement
	*/
	@Override
	public void setMeasurementName(java.lang.String measurementName) {
		_gemMeasurement.setMeasurementName(measurementName);
	}

	/**
	* Returns the measurement type of this g e m measurement.
	*
	* @return the measurement type of this g e m measurement
	*/
	@Override
	public java.lang.String getMeasurementType() {
		return _gemMeasurement.getMeasurementType();
	}

	/**
	* Sets the measurement type of this g e m measurement.
	*
	* @param measurementType the measurement type of this g e m measurement
	*/
	@Override
	public void setMeasurementType(java.lang.String measurementType) {
		_gemMeasurement.setMeasurementType(measurementType);
	}

	/**
	* Returns the display order number of this g e m measurement.
	*
	* @return the display order number of this g e m measurement
	*/
	@Override
	public long getDisplayOrderNumber() {
		return _gemMeasurement.getDisplayOrderNumber();
	}

	/**
	* Sets the display order number of this g e m measurement.
	*
	* @param displayOrderNumber the display order number of this g e m measurement
	*/
	@Override
	public void setDisplayOrderNumber(long displayOrderNumber) {
		_gemMeasurement.setDisplayOrderNumber(displayOrderNumber);
	}

	/**
	* Returns the template ID of this g e m measurement.
	*
	* @return the template ID of this g e m measurement
	*/
	@Override
	public long getTemplateId() {
		return _gemMeasurement.getTemplateId();
	}

	/**
	* Sets the template ID of this g e m measurement.
	*
	* @param templateId the template ID of this g e m measurement
	*/
	@Override
	public void setTemplateId(long templateId) {
		_gemMeasurement.setTemplateId(templateId);
	}

	/**
	* Returns the multiplier qty of this g e m measurement.
	*
	* @return the multiplier qty of this g e m measurement
	*/
	@Override
	public long getMultiplierQty() {
		return _gemMeasurement.getMultiplierQty();
	}

	/**
	* Sets the multiplier qty of this g e m measurement.
	*
	* @param multiplierQty the multiplier qty of this g e m measurement
	*/
	@Override
	public void setMultiplierQty(long multiplierQty) {
		_gemMeasurement.setMultiplierQty(multiplierQty);
	}

	/**
	* Returns the creator ID of this g e m measurement.
	*
	* @return the creator ID of this g e m measurement
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _gemMeasurement.getCreatorId();
	}

	/**
	* Sets the creator ID of this g e m measurement.
	*
	* @param creatorId the creator ID of this g e m measurement
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_gemMeasurement.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this g e m measurement.
	*
	* @return the created date of this g e m measurement
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _gemMeasurement.getCreatedDate();
	}

	/**
	* Sets the created date of this g e m measurement.
	*
	* @param createdDate the created date of this g e m measurement
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_gemMeasurement.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this g e m measurement.
	*
	* @return the updated by of this g e m measurement
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _gemMeasurement.getUpdatedBy();
	}

	/**
	* Sets the updated by of this g e m measurement.
	*
	* @param updatedBy the updated by of this g e m measurement
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_gemMeasurement.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this g e m measurement.
	*
	* @return the updated date of this g e m measurement
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _gemMeasurement.getUpdatedDate();
	}

	/**
	* Sets the updated date of this g e m measurement.
	*
	* @param updatedDate the updated date of this g e m measurement
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_gemMeasurement.setUpdatedDate(updatedDate);
	}

	@Override
	public boolean isNew() {
		return _gemMeasurement.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_gemMeasurement.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _gemMeasurement.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_gemMeasurement.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _gemMeasurement.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _gemMeasurement.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_gemMeasurement.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _gemMeasurement.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_gemMeasurement.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_gemMeasurement.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_gemMeasurement.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new GEMMeasurementWrapper((GEMMeasurement)_gemMeasurement.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.GEMMeasurement gemMeasurement) {
		return _gemMeasurement.compareTo(gemMeasurement);
	}

	@Override
	public int hashCode() {
		return _gemMeasurement.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.GEMMeasurement> toCacheModel() {
		return _gemMeasurement.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.GEMMeasurement toEscapedModel() {
		return new GEMMeasurementWrapper(_gemMeasurement.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.GEMMeasurement toUnescapedModel() {
		return new GEMMeasurementWrapper(_gemMeasurement.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _gemMeasurement.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _gemMeasurement.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_gemMeasurement.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GEMMeasurementWrapper)) {
			return false;
		}

		GEMMeasurementWrapper gemMeasurementWrapper = (GEMMeasurementWrapper)obj;

		if (Validator.equals(_gemMeasurement,
					gemMeasurementWrapper._gemMeasurement)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public GEMMeasurement getWrappedGEMMeasurement() {
		return _gemMeasurement;
	}

	@Override
	public GEMMeasurement getWrappedModel() {
		return _gemMeasurement;
	}

	@Override
	public void resetOriginalValues() {
		_gemMeasurement.resetOriginalValues();
	}

	private GEMMeasurement _gemMeasurement;
}