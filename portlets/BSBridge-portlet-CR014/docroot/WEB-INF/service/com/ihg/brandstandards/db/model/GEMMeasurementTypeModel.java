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
 * The base model interface for the GEMMeasurementType service. Represents a row in the &quot;GEM_MSRMNT_TYP&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.ihg.brandstandards.db.model.impl.GEMMeasurementTypeModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.ihg.brandstandards.db.model.impl.GEMMeasurementTypeImpl}.
 * </p>
 *
 * @author Mummanedi
 * @see GEMMeasurementType
 * @see com.ihg.brandstandards.db.model.impl.GEMMeasurementTypeImpl
 * @see com.ihg.brandstandards.db.model.impl.GEMMeasurementTypeModelImpl
 * @generated
 */
public interface GEMMeasurementTypeModel extends BaseModel<GEMMeasurementType> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a g e m measurement type model instance should use the {@link GEMMeasurementType} interface instead.
	 */

	/**
	 * Returns the primary key of this g e m measurement type.
	 *
	 * @return the primary key of this g e m measurement type
	 */
	public String getPrimaryKey();

	/**
	 * Sets the primary key of this g e m measurement type.
	 *
	 * @param primaryKey the primary key of this g e m measurement type
	 */
	public void setPrimaryKey(String primaryKey);

	/**
	 * Returns the measurement type of this g e m measurement type.
	 *
	 * @return the measurement type of this g e m measurement type
	 */
	@AutoEscape
	public String getMeasurementType();

	/**
	 * Sets the measurement type of this g e m measurement type.
	 *
	 * @param measurementType the measurement type of this g e m measurement type
	 */
	public void setMeasurementType(String measurementType);

	/**
	 * Returns the measurement type desc of this g e m measurement type.
	 *
	 * @return the measurement type desc of this g e m measurement type
	 */
	@AutoEscape
	public String getMeasurementTypeDesc();

	/**
	 * Sets the measurement type desc of this g e m measurement type.
	 *
	 * @param measurementTypeDesc the measurement type desc of this g e m measurement type
	 */
	public void setMeasurementTypeDesc(String measurementTypeDesc);

	/**
	 * Returns the creator ID of this g e m measurement type.
	 *
	 * @return the creator ID of this g e m measurement type
	 */
	@AutoEscape
	public String getCreatorId();

	/**
	 * Sets the creator ID of this g e m measurement type.
	 *
	 * @param creatorId the creator ID of this g e m measurement type
	 */
	public void setCreatorId(String creatorId);

	/**
	 * Returns the created date of this g e m measurement type.
	 *
	 * @return the created date of this g e m measurement type
	 */
	public Date getCreatedDate();

	/**
	 * Sets the created date of this g e m measurement type.
	 *
	 * @param createdDate the created date of this g e m measurement type
	 */
	public void setCreatedDate(Date createdDate);

	/**
	 * Returns the updated by of this g e m measurement type.
	 *
	 * @return the updated by of this g e m measurement type
	 */
	@AutoEscape
	public String getUpdatedBy();

	/**
	 * Sets the updated by of this g e m measurement type.
	 *
	 * @param updatedBy the updated by of this g e m measurement type
	 */
	public void setUpdatedBy(String updatedBy);

	/**
	 * Returns the updated date of this g e m measurement type.
	 *
	 * @return the updated date of this g e m measurement type
	 */
	public Date getUpdatedDate();

	/**
	 * Sets the updated date of this g e m measurement type.
	 *
	 * @param updatedDate the updated date of this g e m measurement type
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
	public int compareTo(GEMMeasurementType gemMeasurementType);

	@Override
	public int hashCode();

	@Override
	public CacheModel<GEMMeasurementType> toCacheModel();

	@Override
	public GEMMeasurementType toEscapedModel();

	@Override
	public GEMMeasurementType toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}