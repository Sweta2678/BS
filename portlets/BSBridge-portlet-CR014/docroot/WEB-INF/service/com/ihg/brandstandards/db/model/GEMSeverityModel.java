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
 * The base model interface for the GEMSeverity service. Represents a row in the &quot;GEM_SEVERITY&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.ihg.brandstandards.db.model.impl.GEMSeverityModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.ihg.brandstandards.db.model.impl.GEMSeverityImpl}.
 * </p>
 *
 * @author Mummanedi
 * @see GEMSeverity
 * @see com.ihg.brandstandards.db.model.impl.GEMSeverityImpl
 * @see com.ihg.brandstandards.db.model.impl.GEMSeverityModelImpl
 * @generated
 */
public interface GEMSeverityModel extends BaseModel<GEMSeverity> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a g e m severity model instance should use the {@link GEMSeverity} interface instead.
	 */

	/**
	 * Returns the primary key of this g e m severity.
	 *
	 * @return the primary key of this g e m severity
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this g e m severity.
	 *
	 * @param primaryKey the primary key of this g e m severity
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the severity ID of this g e m severity.
	 *
	 * @return the severity ID of this g e m severity
	 */
	public long getSeverityId();

	/**
	 * Sets the severity ID of this g e m severity.
	 *
	 * @param severityId the severity ID of this g e m severity
	 */
	public void setSeverityId(long severityId);

	/**
	 * Returns the severity name of this g e m severity.
	 *
	 * @return the severity name of this g e m severity
	 */
	@AutoEscape
	public String getSeverityName();

	/**
	 * Sets the severity name of this g e m severity.
	 *
	 * @param severityName the severity name of this g e m severity
	 */
	public void setSeverityName(String severityName);

	/**
	 * Returns the creator ID of this g e m severity.
	 *
	 * @return the creator ID of this g e m severity
	 */
	@AutoEscape
	public String getCreatorId();

	/**
	 * Sets the creator ID of this g e m severity.
	 *
	 * @param creatorId the creator ID of this g e m severity
	 */
	public void setCreatorId(String creatorId);

	/**
	 * Returns the created date of this g e m severity.
	 *
	 * @return the created date of this g e m severity
	 */
	public Date getCreatedDate();

	/**
	 * Sets the created date of this g e m severity.
	 *
	 * @param createdDate the created date of this g e m severity
	 */
	public void setCreatedDate(Date createdDate);

	/**
	 * Returns the updated by of this g e m severity.
	 *
	 * @return the updated by of this g e m severity
	 */
	@AutoEscape
	public String getUpdatedBy();

	/**
	 * Sets the updated by of this g e m severity.
	 *
	 * @param updatedBy the updated by of this g e m severity
	 */
	public void setUpdatedBy(String updatedBy);

	/**
	 * Returns the updated date of this g e m severity.
	 *
	 * @return the updated date of this g e m severity
	 */
	public Date getUpdatedDate();

	/**
	 * Sets the updated date of this g e m severity.
	 *
	 * @param updatedDate the updated date of this g e m severity
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
	public int compareTo(GEMSeverity gemSeverity);

	@Override
	public int hashCode();

	@Override
	public CacheModel<GEMSeverity> toCacheModel();

	@Override
	public GEMSeverity toEscapedModel();

	@Override
	public GEMSeverity toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}