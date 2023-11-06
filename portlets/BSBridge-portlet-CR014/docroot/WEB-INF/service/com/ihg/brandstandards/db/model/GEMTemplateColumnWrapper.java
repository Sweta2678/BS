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
 * This class is a wrapper for {@link GEMTemplateColumn}.
 * </p>
 *
 * @author Mummanedi
 * @see GEMTemplateColumn
 * @generated
 */
public class GEMTemplateColumnWrapper implements GEMTemplateColumn,
	ModelWrapper<GEMTemplateColumn> {
	public GEMTemplateColumnWrapper(GEMTemplateColumn gemTemplateColumn) {
		_gemTemplateColumn = gemTemplateColumn;
	}

	@Override
	public Class<?> getModelClass() {
		return GEMTemplateColumn.class;
	}

	@Override
	public String getModelClassName() {
		return GEMTemplateColumn.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("columnId", getColumnId());
		attributes.put("templateId", getTemplateId());
		attributes.put("columnName", getColumnName());
		attributes.put("valueType", getValueType());
		attributes.put("defaultValue", getDefaultValue());
		attributes.put("isMandatory", getIsMandatory());
		attributes.put("displayOrderNumber", getDisplayOrderNumber());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long columnId = (Long)attributes.get("columnId");

		if (columnId != null) {
			setColumnId(columnId);
		}

		Long templateId = (Long)attributes.get("templateId");

		if (templateId != null) {
			setTemplateId(templateId);
		}

		String columnName = (String)attributes.get("columnName");

		if (columnName != null) {
			setColumnName(columnName);
		}

		String valueType = (String)attributes.get("valueType");

		if (valueType != null) {
			setValueType(valueType);
		}

		String defaultValue = (String)attributes.get("defaultValue");

		if (defaultValue != null) {
			setDefaultValue(defaultValue);
		}

		String isMandatory = (String)attributes.get("isMandatory");

		if (isMandatory != null) {
			setIsMandatory(isMandatory);
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
	* Returns the primary key of this g e m template column.
	*
	* @return the primary key of this g e m template column
	*/
	@Override
	public long getPrimaryKey() {
		return _gemTemplateColumn.getPrimaryKey();
	}

	/**
	* Sets the primary key of this g e m template column.
	*
	* @param primaryKey the primary key of this g e m template column
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_gemTemplateColumn.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the column ID of this g e m template column.
	*
	* @return the column ID of this g e m template column
	*/
	@Override
	public long getColumnId() {
		return _gemTemplateColumn.getColumnId();
	}

	/**
	* Sets the column ID of this g e m template column.
	*
	* @param columnId the column ID of this g e m template column
	*/
	@Override
	public void setColumnId(long columnId) {
		_gemTemplateColumn.setColumnId(columnId);
	}

	/**
	* Returns the template ID of this g e m template column.
	*
	* @return the template ID of this g e m template column
	*/
	@Override
	public long getTemplateId() {
		return _gemTemplateColumn.getTemplateId();
	}

	/**
	* Sets the template ID of this g e m template column.
	*
	* @param templateId the template ID of this g e m template column
	*/
	@Override
	public void setTemplateId(long templateId) {
		_gemTemplateColumn.setTemplateId(templateId);
	}

	/**
	* Returns the column name of this g e m template column.
	*
	* @return the column name of this g e m template column
	*/
	@Override
	public java.lang.String getColumnName() {
		return _gemTemplateColumn.getColumnName();
	}

	/**
	* Sets the column name of this g e m template column.
	*
	* @param columnName the column name of this g e m template column
	*/
	@Override
	public void setColumnName(java.lang.String columnName) {
		_gemTemplateColumn.setColumnName(columnName);
	}

	/**
	* Returns the value type of this g e m template column.
	*
	* @return the value type of this g e m template column
	*/
	@Override
	public java.lang.String getValueType() {
		return _gemTemplateColumn.getValueType();
	}

	/**
	* Sets the value type of this g e m template column.
	*
	* @param valueType the value type of this g e m template column
	*/
	@Override
	public void setValueType(java.lang.String valueType) {
		_gemTemplateColumn.setValueType(valueType);
	}

	/**
	* Returns the default value of this g e m template column.
	*
	* @return the default value of this g e m template column
	*/
	@Override
	public java.lang.String getDefaultValue() {
		return _gemTemplateColumn.getDefaultValue();
	}

	/**
	* Sets the default value of this g e m template column.
	*
	* @param defaultValue the default value of this g e m template column
	*/
	@Override
	public void setDefaultValue(java.lang.String defaultValue) {
		_gemTemplateColumn.setDefaultValue(defaultValue);
	}

	/**
	* Returns the is mandatory of this g e m template column.
	*
	* @return the is mandatory of this g e m template column
	*/
	@Override
	public java.lang.String getIsMandatory() {
		return _gemTemplateColumn.getIsMandatory();
	}

	/**
	* Sets the is mandatory of this g e m template column.
	*
	* @param isMandatory the is mandatory of this g e m template column
	*/
	@Override
	public void setIsMandatory(java.lang.String isMandatory) {
		_gemTemplateColumn.setIsMandatory(isMandatory);
	}

	/**
	* Returns the display order number of this g e m template column.
	*
	* @return the display order number of this g e m template column
	*/
	@Override
	public long getDisplayOrderNumber() {
		return _gemTemplateColumn.getDisplayOrderNumber();
	}

	/**
	* Sets the display order number of this g e m template column.
	*
	* @param displayOrderNumber the display order number of this g e m template column
	*/
	@Override
	public void setDisplayOrderNumber(long displayOrderNumber) {
		_gemTemplateColumn.setDisplayOrderNumber(displayOrderNumber);
	}

	/**
	* Returns the creator ID of this g e m template column.
	*
	* @return the creator ID of this g e m template column
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _gemTemplateColumn.getCreatorId();
	}

	/**
	* Sets the creator ID of this g e m template column.
	*
	* @param creatorId the creator ID of this g e m template column
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_gemTemplateColumn.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this g e m template column.
	*
	* @return the created date of this g e m template column
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _gemTemplateColumn.getCreatedDate();
	}

	/**
	* Sets the created date of this g e m template column.
	*
	* @param createdDate the created date of this g e m template column
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_gemTemplateColumn.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this g e m template column.
	*
	* @return the updated by of this g e m template column
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _gemTemplateColumn.getUpdatedBy();
	}

	/**
	* Sets the updated by of this g e m template column.
	*
	* @param updatedBy the updated by of this g e m template column
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_gemTemplateColumn.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this g e m template column.
	*
	* @return the updated date of this g e m template column
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _gemTemplateColumn.getUpdatedDate();
	}

	/**
	* Sets the updated date of this g e m template column.
	*
	* @param updatedDate the updated date of this g e m template column
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_gemTemplateColumn.setUpdatedDate(updatedDate);
	}

	@Override
	public boolean isNew() {
		return _gemTemplateColumn.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_gemTemplateColumn.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _gemTemplateColumn.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_gemTemplateColumn.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _gemTemplateColumn.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _gemTemplateColumn.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_gemTemplateColumn.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _gemTemplateColumn.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_gemTemplateColumn.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_gemTemplateColumn.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_gemTemplateColumn.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new GEMTemplateColumnWrapper((GEMTemplateColumn)_gemTemplateColumn.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.GEMTemplateColumn gemTemplateColumn) {
		return _gemTemplateColumn.compareTo(gemTemplateColumn);
	}

	@Override
	public int hashCode() {
		return _gemTemplateColumn.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.GEMTemplateColumn> toCacheModel() {
		return _gemTemplateColumn.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.GEMTemplateColumn toEscapedModel() {
		return new GEMTemplateColumnWrapper(_gemTemplateColumn.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.GEMTemplateColumn toUnescapedModel() {
		return new GEMTemplateColumnWrapper(_gemTemplateColumn.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _gemTemplateColumn.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _gemTemplateColumn.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_gemTemplateColumn.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GEMTemplateColumnWrapper)) {
			return false;
		}

		GEMTemplateColumnWrapper gemTemplateColumnWrapper = (GEMTemplateColumnWrapper)obj;

		if (Validator.equals(_gemTemplateColumn,
					gemTemplateColumnWrapper._gemTemplateColumn)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public GEMTemplateColumn getWrappedGEMTemplateColumn() {
		return _gemTemplateColumn;
	}

	@Override
	public GEMTemplateColumn getWrappedModel() {
		return _gemTemplateColumn;
	}

	@Override
	public void resetOriginalValues() {
		_gemTemplateColumn.resetOriginalValues();
	}

	private GEMTemplateColumn _gemTemplateColumn;
}