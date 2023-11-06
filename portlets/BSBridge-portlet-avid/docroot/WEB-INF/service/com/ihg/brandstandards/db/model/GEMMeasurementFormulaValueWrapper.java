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
 * This class is a wrapper for {@link GEMMeasurementFormulaValue}.
 * </p>
 *
 * @author Mummanedi
 * @see GEMMeasurementFormulaValue
 * @generated
 */
public class GEMMeasurementFormulaValueWrapper
	implements GEMMeasurementFormulaValue,
		ModelWrapper<GEMMeasurementFormulaValue> {
	public GEMMeasurementFormulaValueWrapper(
		GEMMeasurementFormulaValue gemMeasurementFormulaValue) {
		_gemMeasurementFormulaValue = gemMeasurementFormulaValue;
	}

	@Override
	public Class<?> getModelClass() {
		return GEMMeasurementFormulaValue.class;
	}

	@Override
	public String getModelClassName() {
		return GEMMeasurementFormulaValue.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("formulaValueId", getFormulaValueId());
		attributes.put("formulaId", getFormulaId());
		attributes.put("formulaType", getFormulaType());
		attributes.put("formulaValue", getFormulaValue());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long formulaValueId = (Long)attributes.get("formulaValueId");

		if (formulaValueId != null) {
			setFormulaValueId(formulaValueId);
		}

		Long formulaId = (Long)attributes.get("formulaId");

		if (formulaId != null) {
			setFormulaId(formulaId);
		}

		String formulaType = (String)attributes.get("formulaType");

		if (formulaType != null) {
			setFormulaType(formulaType);
		}

		String formulaValue = (String)attributes.get("formulaValue");

		if (formulaValue != null) {
			setFormulaValue(formulaValue);
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
	* Returns the primary key of this g e m measurement formula value.
	*
	* @return the primary key of this g e m measurement formula value
	*/
	@Override
	public long getPrimaryKey() {
		return _gemMeasurementFormulaValue.getPrimaryKey();
	}

	/**
	* Sets the primary key of this g e m measurement formula value.
	*
	* @param primaryKey the primary key of this g e m measurement formula value
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_gemMeasurementFormulaValue.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the formula value ID of this g e m measurement formula value.
	*
	* @return the formula value ID of this g e m measurement formula value
	*/
	@Override
	public long getFormulaValueId() {
		return _gemMeasurementFormulaValue.getFormulaValueId();
	}

	/**
	* Sets the formula value ID of this g e m measurement formula value.
	*
	* @param formulaValueId the formula value ID of this g e m measurement formula value
	*/
	@Override
	public void setFormulaValueId(long formulaValueId) {
		_gemMeasurementFormulaValue.setFormulaValueId(formulaValueId);
	}

	/**
	* Returns the formula ID of this g e m measurement formula value.
	*
	* @return the formula ID of this g e m measurement formula value
	*/
	@Override
	public long getFormulaId() {
		return _gemMeasurementFormulaValue.getFormulaId();
	}

	/**
	* Sets the formula ID of this g e m measurement formula value.
	*
	* @param formulaId the formula ID of this g e m measurement formula value
	*/
	@Override
	public void setFormulaId(long formulaId) {
		_gemMeasurementFormulaValue.setFormulaId(formulaId);
	}

	/**
	* Returns the formula type of this g e m measurement formula value.
	*
	* @return the formula type of this g e m measurement formula value
	*/
	@Override
	public java.lang.String getFormulaType() {
		return _gemMeasurementFormulaValue.getFormulaType();
	}

	/**
	* Sets the formula type of this g e m measurement formula value.
	*
	* @param formulaType the formula type of this g e m measurement formula value
	*/
	@Override
	public void setFormulaType(java.lang.String formulaType) {
		_gemMeasurementFormulaValue.setFormulaType(formulaType);
	}

	/**
	* Returns the formula value of this g e m measurement formula value.
	*
	* @return the formula value of this g e m measurement formula value
	*/
	@Override
	public java.lang.String getFormulaValue() {
		return _gemMeasurementFormulaValue.getFormulaValue();
	}

	/**
	* Sets the formula value of this g e m measurement formula value.
	*
	* @param formulaValue the formula value of this g e m measurement formula value
	*/
	@Override
	public void setFormulaValue(java.lang.String formulaValue) {
		_gemMeasurementFormulaValue.setFormulaValue(formulaValue);
	}

	/**
	* Returns the creator ID of this g e m measurement formula value.
	*
	* @return the creator ID of this g e m measurement formula value
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _gemMeasurementFormulaValue.getCreatorId();
	}

	/**
	* Sets the creator ID of this g e m measurement formula value.
	*
	* @param creatorId the creator ID of this g e m measurement formula value
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_gemMeasurementFormulaValue.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this g e m measurement formula value.
	*
	* @return the created date of this g e m measurement formula value
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _gemMeasurementFormulaValue.getCreatedDate();
	}

	/**
	* Sets the created date of this g e m measurement formula value.
	*
	* @param createdDate the created date of this g e m measurement formula value
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_gemMeasurementFormulaValue.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this g e m measurement formula value.
	*
	* @return the updated by of this g e m measurement formula value
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _gemMeasurementFormulaValue.getUpdatedBy();
	}

	/**
	* Sets the updated by of this g e m measurement formula value.
	*
	* @param updatedBy the updated by of this g e m measurement formula value
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_gemMeasurementFormulaValue.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this g e m measurement formula value.
	*
	* @return the updated date of this g e m measurement formula value
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _gemMeasurementFormulaValue.getUpdatedDate();
	}

	/**
	* Sets the updated date of this g e m measurement formula value.
	*
	* @param updatedDate the updated date of this g e m measurement formula value
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_gemMeasurementFormulaValue.setUpdatedDate(updatedDate);
	}

	@Override
	public boolean isNew() {
		return _gemMeasurementFormulaValue.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_gemMeasurementFormulaValue.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _gemMeasurementFormulaValue.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_gemMeasurementFormulaValue.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _gemMeasurementFormulaValue.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _gemMeasurementFormulaValue.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_gemMeasurementFormulaValue.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _gemMeasurementFormulaValue.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_gemMeasurementFormulaValue.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_gemMeasurementFormulaValue.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_gemMeasurementFormulaValue.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new GEMMeasurementFormulaValueWrapper((GEMMeasurementFormulaValue)_gemMeasurementFormulaValue.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.GEMMeasurementFormulaValue gemMeasurementFormulaValue) {
		return _gemMeasurementFormulaValue.compareTo(gemMeasurementFormulaValue);
	}

	@Override
	public int hashCode() {
		return _gemMeasurementFormulaValue.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.GEMMeasurementFormulaValue> toCacheModel() {
		return _gemMeasurementFormulaValue.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.GEMMeasurementFormulaValue toEscapedModel() {
		return new GEMMeasurementFormulaValueWrapper(_gemMeasurementFormulaValue.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.GEMMeasurementFormulaValue toUnescapedModel() {
		return new GEMMeasurementFormulaValueWrapper(_gemMeasurementFormulaValue.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _gemMeasurementFormulaValue.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _gemMeasurementFormulaValue.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_gemMeasurementFormulaValue.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GEMMeasurementFormulaValueWrapper)) {
			return false;
		}

		GEMMeasurementFormulaValueWrapper gemMeasurementFormulaValueWrapper = (GEMMeasurementFormulaValueWrapper)obj;

		if (Validator.equals(_gemMeasurementFormulaValue,
					gemMeasurementFormulaValueWrapper._gemMeasurementFormulaValue)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public GEMMeasurementFormulaValue getWrappedGEMMeasurementFormulaValue() {
		return _gemMeasurementFormulaValue;
	}

	@Override
	public GEMMeasurementFormulaValue getWrappedModel() {
		return _gemMeasurementFormulaValue;
	}

	@Override
	public void resetOriginalValues() {
		_gemMeasurementFormulaValue.resetOriginalValues();
	}

	private GEMMeasurementFormulaValue _gemMeasurementFormulaValue;
}