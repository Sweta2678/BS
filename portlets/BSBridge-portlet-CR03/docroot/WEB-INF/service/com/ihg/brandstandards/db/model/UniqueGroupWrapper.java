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
 * This class is a wrapper for {@link UniqueGroup}.
 * </p>
 *
 * @author Mummanedi
 * @see UniqueGroup
 * @generated
 */
public class UniqueGroupWrapper implements UniqueGroup,
	ModelWrapper<UniqueGroup> {
	public UniqueGroupWrapper(UniqueGroup uniqueGroup) {
		_uniqueGroup = uniqueGroup;
	}

	@Override
	public Class<?> getModelClass() {
		return UniqueGroup.class;
	}

	@Override
	public String getModelClassName() {
		return UniqueGroup.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uniqueGroupId", getUniqueGroupId());
		attributes.put("publishId", getPublishId());
		attributes.put("groupName", getGroupName());
		attributes.put("regionId", getRegionId());
		attributes.put("groupType", getGroupType());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long uniqueGroupId = (Long)attributes.get("uniqueGroupId");

		if (uniqueGroupId != null) {
			setUniqueGroupId(uniqueGroupId);
		}

		Long publishId = (Long)attributes.get("publishId");

		if (publishId != null) {
			setPublishId(publishId);
		}

		String groupName = (String)attributes.get("groupName");

		if (groupName != null) {
			setGroupName(groupName);
		}

		Long regionId = (Long)attributes.get("regionId");

		if (regionId != null) {
			setRegionId(regionId);
		}

		String groupType = (String)attributes.get("groupType");

		if (groupType != null) {
			setGroupType(groupType);
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
	* Returns the primary key of this unique group.
	*
	* @return the primary key of this unique group
	*/
	@Override
	public long getPrimaryKey() {
		return _uniqueGroup.getPrimaryKey();
	}

	/**
	* Sets the primary key of this unique group.
	*
	* @param primaryKey the primary key of this unique group
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_uniqueGroup.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the unique group ID of this unique group.
	*
	* @return the unique group ID of this unique group
	*/
	@Override
	public long getUniqueGroupId() {
		return _uniqueGroup.getUniqueGroupId();
	}

	/**
	* Sets the unique group ID of this unique group.
	*
	* @param uniqueGroupId the unique group ID of this unique group
	*/
	@Override
	public void setUniqueGroupId(long uniqueGroupId) {
		_uniqueGroup.setUniqueGroupId(uniqueGroupId);
	}

	/**
	* Returns the publish ID of this unique group.
	*
	* @return the publish ID of this unique group
	*/
	@Override
	public long getPublishId() {
		return _uniqueGroup.getPublishId();
	}

	/**
	* Sets the publish ID of this unique group.
	*
	* @param publishId the publish ID of this unique group
	*/
	@Override
	public void setPublishId(long publishId) {
		_uniqueGroup.setPublishId(publishId);
	}

	/**
	* Returns the group name of this unique group.
	*
	* @return the group name of this unique group
	*/
	@Override
	public java.lang.String getGroupName() {
		return _uniqueGroup.getGroupName();
	}

	/**
	* Sets the group name of this unique group.
	*
	* @param groupName the group name of this unique group
	*/
	@Override
	public void setGroupName(java.lang.String groupName) {
		_uniqueGroup.setGroupName(groupName);
	}

	/**
	* Returns the region ID of this unique group.
	*
	* @return the region ID of this unique group
	*/
	@Override
	public long getRegionId() {
		return _uniqueGroup.getRegionId();
	}

	/**
	* Sets the region ID of this unique group.
	*
	* @param regionId the region ID of this unique group
	*/
	@Override
	public void setRegionId(long regionId) {
		_uniqueGroup.setRegionId(regionId);
	}

	/**
	* Returns the group type of this unique group.
	*
	* @return the group type of this unique group
	*/
	@Override
	public java.lang.String getGroupType() {
		return _uniqueGroup.getGroupType();
	}

	/**
	* Sets the group type of this unique group.
	*
	* @param groupType the group type of this unique group
	*/
	@Override
	public void setGroupType(java.lang.String groupType) {
		_uniqueGroup.setGroupType(groupType);
	}

	/**
	* Returns the creator ID of this unique group.
	*
	* @return the creator ID of this unique group
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _uniqueGroup.getCreatorId();
	}

	/**
	* Sets the creator ID of this unique group.
	*
	* @param creatorId the creator ID of this unique group
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_uniqueGroup.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this unique group.
	*
	* @return the created date of this unique group
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _uniqueGroup.getCreatedDate();
	}

	/**
	* Sets the created date of this unique group.
	*
	* @param createdDate the created date of this unique group
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_uniqueGroup.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this unique group.
	*
	* @return the updated by of this unique group
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _uniqueGroup.getUpdatedBy();
	}

	/**
	* Sets the updated by of this unique group.
	*
	* @param updatedBy the updated by of this unique group
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_uniqueGroup.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this unique group.
	*
	* @return the updated date of this unique group
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _uniqueGroup.getUpdatedDate();
	}

	/**
	* Sets the updated date of this unique group.
	*
	* @param updatedDate the updated date of this unique group
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_uniqueGroup.setUpdatedDate(updatedDate);
	}

	@Override
	public boolean isNew() {
		return _uniqueGroup.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_uniqueGroup.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _uniqueGroup.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_uniqueGroup.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _uniqueGroup.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _uniqueGroup.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_uniqueGroup.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _uniqueGroup.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_uniqueGroup.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_uniqueGroup.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_uniqueGroup.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new UniqueGroupWrapper((UniqueGroup)_uniqueGroup.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.UniqueGroup uniqueGroup) {
		return _uniqueGroup.compareTo(uniqueGroup);
	}

	@Override
	public int hashCode() {
		return _uniqueGroup.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.UniqueGroup> toCacheModel() {
		return _uniqueGroup.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.UniqueGroup toEscapedModel() {
		return new UniqueGroupWrapper(_uniqueGroup.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.UniqueGroup toUnescapedModel() {
		return new UniqueGroupWrapper(_uniqueGroup.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _uniqueGroup.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _uniqueGroup.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_uniqueGroup.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UniqueGroupWrapper)) {
			return false;
		}

		UniqueGroupWrapper uniqueGroupWrapper = (UniqueGroupWrapper)obj;

		if (Validator.equals(_uniqueGroup, uniqueGroupWrapper._uniqueGroup)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public UniqueGroup getWrappedUniqueGroup() {
		return _uniqueGroup;
	}

	@Override
	public UniqueGroup getWrappedModel() {
		return _uniqueGroup;
	}

	@Override
	public void resetOriginalValues() {
		_uniqueGroup.resetOriginalValues();
	}

	private UniqueGroup _uniqueGroup;
}