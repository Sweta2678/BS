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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the GEMTemplateColumn service. Represents a row in the &quot;GEM_TEMPLATE_COL&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.ihg.brandstandards.db.model.impl.GEMTemplateColumnModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.ihg.brandstandards.db.model.impl.GEMTemplateColumnImpl}.
 * </p>
 *
 * @author Mummanedi
 * @see GEMTemplateColumn
 * @see com.ihg.brandstandards.db.model.impl.GEMTemplateColumnImpl
 * @see com.ihg.brandstandards.db.model.impl.GEMTemplateColumnModelImpl
 * @generated
 */
public interface GEMTemplateColumnModel extends BaseModel<GEMTemplateColumn> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a g e m template column model instance should use the {@link GEMTemplateColumn} interface instead.
	 */

	/**
	 * Returns the primary key of this g e m template column.
	 *
	 * @return the primary key of this g e m template column
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this g e m template column.
	 *
	 * @param primaryKey the primary key of this g e m template column
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the column ID of this g e m template column.
	 *
	 * @return the column ID of this g e m template column
	 */
	public long getColumnId();

	/**
	 * Sets the column ID of this g e m template column.
	 *
	 * @param columnId the column ID of this g e m template column
	 */
	public void setColumnId(long columnId);

	/**
	 * Returns the template ID of this g e m template column.
	 *
	 * @return the template ID of this g e m template column
	 */
	public long getTemplateId();

	/**
	 * Sets the template ID of this g e m template column.
	 *
	 * @param templateId the template ID of this g e m template column
	 */
	public void setTemplateId(long templateId);

	/**
	 * Returns the column name of this g e m template column.
	 *
	 * @return the column name of this g e m template column
	 */
	@AutoEscape
	public String getColumnName();

	/**
	 * Sets the column name of this g e m template column.
	 *
	 * @param columnName the column name of this g e m template column
	 */
	public void setColumnName(String columnName);

	/**
	 * Returns the value type of this g e m template column.
	 *
	 * @return the value type of this g e m template column
	 */
	@AutoEscape
	public String getValueType();

	/**
	 * Sets the value type of this g e m template column.
	 *
	 * @param valueType the value type of this g e m template column
	 */
	public void setValueType(String valueType);

	/**
	 * Returns the default value of this g e m template column.
	 *
	 * @return the default value of this g e m template column
	 */
	@AutoEscape
	public String getDefaultValue();

	/**
	 * Sets the default value of this g e m template column.
	 *
	 * @param defaultValue the default value of this g e m template column
	 */
	public void setDefaultValue(String defaultValue);

	/**
	 * Returns the is mandatory of this g e m template column.
	 *
	 * @return the is mandatory of this g e m template column
	 */
	@AutoEscape
	public String getIsMandatory();

	/**
	 * Sets the is mandatory of this g e m template column.
	 *
	 * @param isMandatory the is mandatory of this g e m template column
	 */
	public void setIsMandatory(String isMandatory);

	/**
	 * Returns the display order number of this g e m template column.
	 *
	 * @return the display order number of this g e m template column
	 */
	public long getDisplayOrderNumber();

	/**
	 * Sets the display order number of this g e m template column.
	 *
	 * @param displayOrderNumber the display order number of this g e m template column
	 */
	public void setDisplayOrderNumber(long displayOrderNumber);

	/**
	 * Returns the creator ID of this g e m template column.
	 *
	 * @return the creator ID of this g e m template column
	 */
	@AutoEscape
	public String getCreatorId();

	/**
	 * Sets the creator ID of this g e m template column.
	 *
	 * @param creatorId the creator ID of this g e m template column
	 */
	public void setCreatorId(String creatorId);

	/**
	 * Returns the created date of this g e m template column.
	 *
	 * @return the created date of this g e m template column
	 */
	public Date getCreatedDate();

	/**
	 * Sets the created date of this g e m template column.
	 *
	 * @param createdDate the created date of this g e m template column
	 */
	public void setCreatedDate(Date createdDate);

	/**
	 * Returns the updated by of this g e m template column.
	 *
	 * @return the updated by of this g e m template column
	 */
	@AutoEscape
	public String getUpdatedBy();

	/**
	 * Sets the updated by of this g e m template column.
	 *
	 * @param updatedBy the updated by of this g e m template column
	 */
	public void setUpdatedBy(String updatedBy);

	/**
	 * Returns the updated date of this g e m template column.
	 *
	 * @return the updated date of this g e m template column
	 */
	public Date getUpdatedDate();

	/**
	 * Sets the updated date of this g e m template column.
	 *
	 * @param updatedDate the updated date of this g e m template column
	 */
	public void setUpdatedDate(Date updatedDate);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(GEMTemplateColumn gemTemplateColumn);

	@Override
	public int hashCode();

	@Override
	public CacheModel<GEMTemplateColumn> toCacheModel();

	@Override
	public GEMTemplateColumn toEscapedModel();

	@Override
	public GEMTemplateColumn toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}