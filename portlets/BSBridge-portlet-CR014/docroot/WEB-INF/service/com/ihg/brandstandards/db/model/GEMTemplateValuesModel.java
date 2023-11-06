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
 * The base model interface for the GEMTemplateValues service. Represents a row in the &quot;GEM_TEMPLATE_VAL&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.ihg.brandstandards.db.model.impl.GEMTemplateValuesModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.ihg.brandstandards.db.model.impl.GEMTemplateValuesImpl}.
 * </p>
 *
 * @author Mummanedi
 * @see GEMTemplateValues
 * @see com.ihg.brandstandards.db.model.impl.GEMTemplateValuesImpl
 * @see com.ihg.brandstandards.db.model.impl.GEMTemplateValuesModelImpl
 * @generated
 */
public interface GEMTemplateValuesModel extends BaseModel<GEMTemplateValues> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a g e m template values model instance should use the {@link GEMTemplateValues} interface instead.
	 */

	/**
	 * Returns the primary key of this g e m template values.
	 *
	 * @return the primary key of this g e m template values
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this g e m template values.
	 *
	 * @param primaryKey the primary key of this g e m template values
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the value ID of this g e m template values.
	 *
	 * @return the value ID of this g e m template values
	 */
	public long getValueId();

	/**
	 * Sets the value ID of this g e m template values.
	 *
	 * @param valueId the value ID of this g e m template values
	 */
	public void setValueId(long valueId);

	/**
	 * Returns the column ID of this g e m template values.
	 *
	 * @return the column ID of this g e m template values
	 */
	public long getColumnId();

	/**
	 * Sets the column ID of this g e m template values.
	 *
	 * @param columnId the column ID of this g e m template values
	 */
	public void setColumnId(long columnId);

	/**
	 * Returns the category ID of this g e m template values.
	 *
	 * @return the category ID of this g e m template values
	 */
	public long getCategoryId();

	/**
	 * Sets the category ID of this g e m template values.
	 *
	 * @param categoryId the category ID of this g e m template values
	 */
	public void setCategoryId(long categoryId);

	/**
	 * Returns the column value of this g e m template values.
	 *
	 * @return the column value of this g e m template values
	 */
	@AutoEscape
	public String getColumnValue();

	/**
	 * Sets the column value of this g e m template values.
	 *
	 * @param columnValue the column value of this g e m template values
	 */
	public void setColumnValue(String columnValue);

	/**
	 * Returns the display order number of this g e m template values.
	 *
	 * @return the display order number of this g e m template values
	 */
	public long getDisplayOrderNumber();

	/**
	 * Sets the display order number of this g e m template values.
	 *
	 * @param displayOrderNumber the display order number of this g e m template values
	 */
	public void setDisplayOrderNumber(long displayOrderNumber);

	/**
	 * Returns the creator ID of this g e m template values.
	 *
	 * @return the creator ID of this g e m template values
	 */
	@AutoEscape
	public String getCreatorId();

	/**
	 * Sets the creator ID of this g e m template values.
	 *
	 * @param creatorId the creator ID of this g e m template values
	 */
	public void setCreatorId(String creatorId);

	/**
	 * Returns the created date of this g e m template values.
	 *
	 * @return the created date of this g e m template values
	 */
	public Date getCreatedDate();

	/**
	 * Sets the created date of this g e m template values.
	 *
	 * @param createdDate the created date of this g e m template values
	 */
	public void setCreatedDate(Date createdDate);

	/**
	 * Returns the updated by of this g e m template values.
	 *
	 * @return the updated by of this g e m template values
	 */
	@AutoEscape
	public String getUpdatedBy();

	/**
	 * Sets the updated by of this g e m template values.
	 *
	 * @param updatedBy the updated by of this g e m template values
	 */
	public void setUpdatedBy(String updatedBy);

	/**
	 * Returns the updated date of this g e m template values.
	 *
	 * @return the updated date of this g e m template values
	 */
	public Date getUpdatedDate();

	/**
	 * Sets the updated date of this g e m template values.
	 *
	 * @param updatedDate the updated date of this g e m template values
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
	public int compareTo(GEMTemplateValues gemTemplateValues);

	@Override
	public int hashCode();

	@Override
	public CacheModel<GEMTemplateValues> toCacheModel();

	@Override
	public GEMTemplateValues toEscapedModel();

	@Override
	public GEMTemplateValues toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}