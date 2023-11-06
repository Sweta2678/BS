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
 * The base model interface for the UniqueGroup service. Represents a row in the &quot;UNIQUE_GRP&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.ihg.brandstandards.db.model.impl.UniqueGroupModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.ihg.brandstandards.db.model.impl.UniqueGroupImpl}.
 * </p>
 *
 * @author Mummanedi
 * @see UniqueGroup
 * @see com.ihg.brandstandards.db.model.impl.UniqueGroupImpl
 * @see com.ihg.brandstandards.db.model.impl.UniqueGroupModelImpl
 * @generated
 */
public interface UniqueGroupModel extends BaseModel<UniqueGroup> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a unique group model instance should use the {@link UniqueGroup} interface instead.
	 */

	/**
	 * Returns the primary key of this unique group.
	 *
	 * @return the primary key of this unique group
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this unique group.
	 *
	 * @param primaryKey the primary key of this unique group
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the unique group ID of this unique group.
	 *
	 * @return the unique group ID of this unique group
	 */
	public long getUniqueGroupId();

	/**
	 * Sets the unique group ID of this unique group.
	 *
	 * @param uniqueGroupId the unique group ID of this unique group
	 */
	public void setUniqueGroupId(long uniqueGroupId);

	/**
	 * Returns the publish ID of this unique group.
	 *
	 * @return the publish ID of this unique group
	 */
	public long getPublishId();

	/**
	 * Sets the publish ID of this unique group.
	 *
	 * @param publishId the publish ID of this unique group
	 */
	public void setPublishId(long publishId);

	/**
	 * Returns the group name of this unique group.
	 *
	 * @return the group name of this unique group
	 */
	@AutoEscape
	public String getGroupName();

	/**
	 * Sets the group name of this unique group.
	 *
	 * @param groupName the group name of this unique group
	 */
	public void setGroupName(String groupName);

	/**
	 * Returns the region ID of this unique group.
	 *
	 * @return the region ID of this unique group
	 */
	public long getRegionId();

	/**
	 * Sets the region ID of this unique group.
	 *
	 * @param regionId the region ID of this unique group
	 */
	public void setRegionId(long regionId);

	/**
	 * Returns the group type of this unique group.
	 *
	 * @return the group type of this unique group
	 */
	@AutoEscape
	public String getGroupType();

	/**
	 * Sets the group type of this unique group.
	 *
	 * @param groupType the group type of this unique group
	 */
	public void setGroupType(String groupType);

	/**
	 * Returns the creator ID of this unique group.
	 *
	 * @return the creator ID of this unique group
	 */
	@AutoEscape
	public String getCreatorId();

	/**
	 * Sets the creator ID of this unique group.
	 *
	 * @param creatorId the creator ID of this unique group
	 */
	public void setCreatorId(String creatorId);

	/**
	 * Returns the created date of this unique group.
	 *
	 * @return the created date of this unique group
	 */
	public Date getCreatedDate();

	/**
	 * Sets the created date of this unique group.
	 *
	 * @param createdDate the created date of this unique group
	 */
	public void setCreatedDate(Date createdDate);

	/**
	 * Returns the updated by of this unique group.
	 *
	 * @return the updated by of this unique group
	 */
	@AutoEscape
	public String getUpdatedBy();

	/**
	 * Sets the updated by of this unique group.
	 *
	 * @param updatedBy the updated by of this unique group
	 */
	public void setUpdatedBy(String updatedBy);

	/**
	 * Returns the updated date of this unique group.
	 *
	 * @return the updated date of this unique group
	 */
	public Date getUpdatedDate();

	/**
	 * Sets the updated date of this unique group.
	 *
	 * @param updatedDate the updated date of this unique group
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
	public int compareTo(UniqueGroup uniqueGroup);

	@Override
	public int hashCode();

	@Override
	public CacheModel<UniqueGroup> toCacheModel();

	@Override
	public UniqueGroup toEscapedModel();

	@Override
	public UniqueGroup toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}