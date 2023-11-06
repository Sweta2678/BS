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
 * This class is a wrapper for {@link GEMTemplateValues}.
 * </p>
 *
 * @author Mummanedi
 * @see GEMTemplateValues
 * @generated
 */
public class GEMTemplateValuesWrapper implements GEMTemplateValues,
	ModelWrapper<GEMTemplateValues> {
	public GEMTemplateValuesWrapper(GEMTemplateValues gemTemplateValues) {
		_gemTemplateValues = gemTemplateValues;
	}

	@Override
	public Class<?> getModelClass() {
		return GEMTemplateValues.class;
	}

	@Override
	public String getModelClassName() {
		return GEMTemplateValues.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("valueId", getValueId());
		attributes.put("columnId", getColumnId());
		attributes.put("categoryId", getCategoryId());
		attributes.put("columnValue", getColumnValue());
		attributes.put("displayOrderNumber", getDisplayOrderNumber());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long valueId = (Long)attributes.get("valueId");

		if (valueId != null) {
			setValueId(valueId);
		}

		Long columnId = (Long)attributes.get("columnId");

		if (columnId != null) {
			setColumnId(columnId);
		}

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		String columnValue = (String)attributes.get("columnValue");

		if (columnValue != null) {
			setColumnValue(columnValue);
		}

		Long displayOrderNumber = (Long)attributes.get("displayOrderNumber");

		if (displayOrderNumber != null) {
			setDisplayOrderNumber(displayOrderNumber);
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
	* Returns the primary key of this g e m template values.
	*
	* @return the primary key of this g e m template values
	*/
	@Override
	public long getPrimaryKey() {
		return _gemTemplateValues.getPrimaryKey();
	}

	/**
	* Sets the primary key of this g e m template values.
	*
	* @param primaryKey the primary key of this g e m template values
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_gemTemplateValues.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the value ID of this g e m template values.
	*
	* @return the value ID of this g e m template values
	*/
	@Override
	public long getValueId() {
		return _gemTemplateValues.getValueId();
	}

	/**
	* Sets the value ID of this g e m template values.
	*
	* @param valueId the value ID of this g e m template values
	*/
	@Override
	public void setValueId(long valueId) {
		_gemTemplateValues.setValueId(valueId);
	}

	/**
	* Returns the column ID of this g e m template values.
	*
	* @return the column ID of this g e m template values
	*/
	@Override
	public long getColumnId() {
		return _gemTemplateValues.getColumnId();
	}

	/**
	* Sets the column ID of this g e m template values.
	*
	* @param columnId the column ID of this g e m template values
	*/
	@Override
	public void setColumnId(long columnId) {
		_gemTemplateValues.setColumnId(columnId);
	}

	/**
	* Returns the category ID of this g e m template values.
	*
	* @return the category ID of this g e m template values
	*/
	@Override
	public long getCategoryId() {
		return _gemTemplateValues.getCategoryId();
	}

	/**
	* Sets the category ID of this g e m template values.
	*
	* @param categoryId the category ID of this g e m template values
	*/
	@Override
	public void setCategoryId(long categoryId) {
		_gemTemplateValues.setCategoryId(categoryId);
	}

	/**
	* Returns the column value of this g e m template values.
	*
	* @return the column value of this g e m template values
	*/
	@Override
	public java.lang.String getColumnValue() {
		return _gemTemplateValues.getColumnValue();
	}

	/**
	* Sets the column value of this g e m template values.
	*
	* @param columnValue the column value of this g e m template values
	*/
	@Override
	public void setColumnValue(java.lang.String columnValue) {
		_gemTemplateValues.setColumnValue(columnValue);
	}

	/**
	* Returns the display order number of this g e m template values.
	*
	* @return the display order number of this g e m template values
	*/
	@Override
	public long getDisplayOrderNumber() {
		return _gemTemplateValues.getDisplayOrderNumber();
	}

	/**
	* Sets the display order number of this g e m template values.
	*
	* @param displayOrderNumber the display order number of this g e m template values
	*/
	@Override
	public void setDisplayOrderNumber(long displayOrderNumber) {
		_gemTemplateValues.setDisplayOrderNumber(displayOrderNumber);
	}

	/**
	* Returns the creator ID of this g e m template values.
	*
	* @return the creator ID of this g e m template values
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _gemTemplateValues.getCreatorId();
	}

	/**
	* Sets the creator ID of this g e m template values.
	*
	* @param creatorId the creator ID of this g e m template values
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_gemTemplateValues.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this g e m template values.
	*
	* @return the created date of this g e m template values
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _gemTemplateValues.getCreatedDate();
	}

	/**
	* Sets the created date of this g e m template values.
	*
	* @param createdDate the created date of this g e m template values
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_gemTemplateValues.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this g e m template values.
	*
	* @return the updated by of this g e m template values
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _gemTemplateValues.getUpdatedBy();
	}

	/**
	* Sets the updated by of this g e m template values.
	*
	* @param updatedBy the updated by of this g e m template values
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_gemTemplateValues.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this g e m template values.
	*
	* @return the updated date of this g e m template values
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _gemTemplateValues.getUpdatedDate();
	}

	/**
	* Sets the updated date of this g e m template values.
	*
	* @param updatedDate the updated date of this g e m template values
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_gemTemplateValues.setUpdatedDate(updatedDate);
	}

	@Override
	public boolean isNew() {
		return _gemTemplateValues.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_gemTemplateValues.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _gemTemplateValues.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_gemTemplateValues.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _gemTemplateValues.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _gemTemplateValues.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_gemTemplateValues.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _gemTemplateValues.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_gemTemplateValues.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_gemTemplateValues.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_gemTemplateValues.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new GEMTemplateValuesWrapper((GEMTemplateValues)_gemTemplateValues.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.GEMTemplateValues gemTemplateValues) {
		return _gemTemplateValues.compareTo(gemTemplateValues);
	}

	@Override
	public int hashCode() {
		return _gemTemplateValues.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.GEMTemplateValues> toCacheModel() {
		return _gemTemplateValues.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.GEMTemplateValues toEscapedModel() {
		return new GEMTemplateValuesWrapper(_gemTemplateValues.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.GEMTemplateValues toUnescapedModel() {
		return new GEMTemplateValuesWrapper(_gemTemplateValues.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _gemTemplateValues.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _gemTemplateValues.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_gemTemplateValues.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GEMTemplateValuesWrapper)) {
			return false;
		}

		GEMTemplateValuesWrapper gemTemplateValuesWrapper = (GEMTemplateValuesWrapper)obj;

		if (Validator.equals(_gemTemplateValues,
					gemTemplateValuesWrapper._gemTemplateValues)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public GEMTemplateValues getWrappedGEMTemplateValues() {
		return _gemTemplateValues;
	}

	@Override
	public GEMTemplateValues getWrappedModel() {
		return _gemTemplateValues;
	}

	@Override
	public void resetOriginalValues() {
		_gemTemplateValues.resetOriginalValues();
	}

	private GEMTemplateValues _gemTemplateValues;
}