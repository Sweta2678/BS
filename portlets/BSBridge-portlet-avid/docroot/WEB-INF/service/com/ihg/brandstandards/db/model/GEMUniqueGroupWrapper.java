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
 * This class is a wrapper for {@link GEMUniqueGroup}.
 * </p>
 *
 * @author Mummanedi
 * @see GEMUniqueGroup
 * @generated
 */
public class GEMUniqueGroupWrapper implements GEMUniqueGroup,
	ModelWrapper<GEMUniqueGroup> {
	public GEMUniqueGroupWrapper(GEMUniqueGroup gemUniqueGroup) {
		_gemUniqueGroup = gemUniqueGroup;
	}

	@Override
	public Class<?> getModelClass() {
		return GEMUniqueGroup.class;
	}

	@Override
	public String getModelClassName() {
		return GEMUniqueGroup.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uniqueGroupId", getUniqueGroupId());
		attributes.put("publishDeptId", getPublishDeptId());
		attributes.put("publishId", getPublishId());
		attributes.put("groupName", getGroupName());
		attributes.put("regionId", getRegionId());
		attributes.put("policyId", getPolicyId());
		attributes.put("levelId", getLevelId());
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

		Long publishDeptId = (Long)attributes.get("publishDeptId");

		if (publishDeptId != null) {
			setPublishDeptId(publishDeptId);
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

		String policyId = (String)attributes.get("policyId");

		if (policyId != null) {
			setPolicyId(policyId);
		}

		String levelId = (String)attributes.get("levelId");

		if (levelId != null) {
			setLevelId(levelId);
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
	* Returns the primary key of this g e m unique group.
	*
	* @return the primary key of this g e m unique group
	*/
	@Override
	public long getPrimaryKey() {
		return _gemUniqueGroup.getPrimaryKey();
	}

	/**
	* Sets the primary key of this g e m unique group.
	*
	* @param primaryKey the primary key of this g e m unique group
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_gemUniqueGroup.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the unique group ID of this g e m unique group.
	*
	* @return the unique group ID of this g e m unique group
	*/
	@Override
	public long getUniqueGroupId() {
		return _gemUniqueGroup.getUniqueGroupId();
	}

	/**
	* Sets the unique group ID of this g e m unique group.
	*
	* @param uniqueGroupId the unique group ID of this g e m unique group
	*/
	@Override
	public void setUniqueGroupId(long uniqueGroupId) {
		_gemUniqueGroup.setUniqueGroupId(uniqueGroupId);
	}

	/**
	* Returns the publish dept ID of this g e m unique group.
	*
	* @return the publish dept ID of this g e m unique group
	*/
	@Override
	public long getPublishDeptId() {
		return _gemUniqueGroup.getPublishDeptId();
	}

	/**
	* Sets the publish dept ID of this g e m unique group.
	*
	* @param publishDeptId the publish dept ID of this g e m unique group
	*/
	@Override
	public void setPublishDeptId(long publishDeptId) {
		_gemUniqueGroup.setPublishDeptId(publishDeptId);
	}

	/**
	* Returns the publish ID of this g e m unique group.
	*
	* @return the publish ID of this g e m unique group
	*/
	@Override
	public long getPublishId() {
		return _gemUniqueGroup.getPublishId();
	}

	/**
	* Sets the publish ID of this g e m unique group.
	*
	* @param publishId the publish ID of this g e m unique group
	*/
	@Override
	public void setPublishId(long publishId) {
		_gemUniqueGroup.setPublishId(publishId);
	}

	/**
	* Returns the group name of this g e m unique group.
	*
	* @return the group name of this g e m unique group
	*/
	@Override
	public java.lang.String getGroupName() {
		return _gemUniqueGroup.getGroupName();
	}

	/**
	* Sets the group name of this g e m unique group.
	*
	* @param groupName the group name of this g e m unique group
	*/
	@Override
	public void setGroupName(java.lang.String groupName) {
		_gemUniqueGroup.setGroupName(groupName);
	}

	/**
	* Returns the region ID of this g e m unique group.
	*
	* @return the region ID of this g e m unique group
	*/
	@Override
	public long getRegionId() {
		return _gemUniqueGroup.getRegionId();
	}

	/**
	* Sets the region ID of this g e m unique group.
	*
	* @param regionId the region ID of this g e m unique group
	*/
	@Override
	public void setRegionId(long regionId) {
		_gemUniqueGroup.setRegionId(regionId);
	}

	/**
	* Returns the policy ID of this g e m unique group.
	*
	* @return the policy ID of this g e m unique group
	*/
	@Override
	public java.lang.String getPolicyId() {
		return _gemUniqueGroup.getPolicyId();
	}

	/**
	* Sets the policy ID of this g e m unique group.
	*
	* @param policyId the policy ID of this g e m unique group
	*/
	@Override
	public void setPolicyId(java.lang.String policyId) {
		_gemUniqueGroup.setPolicyId(policyId);
	}

	/**
	* Returns the level ID of this g e m unique group.
	*
	* @return the level ID of this g e m unique group
	*/
	@Override
	public java.lang.String getLevelId() {
		return _gemUniqueGroup.getLevelId();
	}

	/**
	* Sets the level ID of this g e m unique group.
	*
	* @param levelId the level ID of this g e m unique group
	*/
	@Override
	public void setLevelId(java.lang.String levelId) {
		_gemUniqueGroup.setLevelId(levelId);
	}

	/**
	* Returns the group type of this g e m unique group.
	*
	* @return the group type of this g e m unique group
	*/
	@Override
	public java.lang.String getGroupType() {
		return _gemUniqueGroup.getGroupType();
	}

	/**
	* Sets the group type of this g e m unique group.
	*
	* @param groupType the group type of this g e m unique group
	*/
	@Override
	public void setGroupType(java.lang.String groupType) {
		_gemUniqueGroup.setGroupType(groupType);
	}

	/**
	* Returns the creator ID of this g e m unique group.
	*
	* @return the creator ID of this g e m unique group
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _gemUniqueGroup.getCreatorId();
	}

	/**
	* Sets the creator ID of this g e m unique group.
	*
	* @param creatorId the creator ID of this g e m unique group
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_gemUniqueGroup.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this g e m unique group.
	*
	* @return the created date of this g e m unique group
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _gemUniqueGroup.getCreatedDate();
	}

	/**
	* Sets the created date of this g e m unique group.
	*
	* @param createdDate the created date of this g e m unique group
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_gemUniqueGroup.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this g e m unique group.
	*
	* @return the updated by of this g e m unique group
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _gemUniqueGroup.getUpdatedBy();
	}

	/**
	* Sets the updated by of this g e m unique group.
	*
	* @param updatedBy the updated by of this g e m unique group
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_gemUniqueGroup.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this g e m unique group.
	*
	* @return the updated date of this g e m unique group
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _gemUniqueGroup.getUpdatedDate();
	}

	/**
	* Sets the updated date of this g e m unique group.
	*
	* @param updatedDate the updated date of this g e m unique group
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_gemUniqueGroup.setUpdatedDate(updatedDate);
	}

	@Override
	public boolean isNew() {
		return _gemUniqueGroup.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_gemUniqueGroup.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _gemUniqueGroup.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_gemUniqueGroup.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _gemUniqueGroup.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _gemUniqueGroup.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_gemUniqueGroup.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _gemUniqueGroup.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_gemUniqueGroup.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_gemUniqueGroup.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_gemUniqueGroup.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new GEMUniqueGroupWrapper((GEMUniqueGroup)_gemUniqueGroup.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.GEMUniqueGroup gemUniqueGroup) {
		return _gemUniqueGroup.compareTo(gemUniqueGroup);
	}

	@Override
	public int hashCode() {
		return _gemUniqueGroup.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.GEMUniqueGroup> toCacheModel() {
		return _gemUniqueGroup.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.GEMUniqueGroup toEscapedModel() {
		return new GEMUniqueGroupWrapper(_gemUniqueGroup.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.GEMUniqueGroup toUnescapedModel() {
		return new GEMUniqueGroupWrapper(_gemUniqueGroup.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _gemUniqueGroup.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _gemUniqueGroup.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_gemUniqueGroup.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GEMUniqueGroupWrapper)) {
			return false;
		}

		GEMUniqueGroupWrapper gemUniqueGroupWrapper = (GEMUniqueGroupWrapper)obj;

		if (Validator.equals(_gemUniqueGroup,
					gemUniqueGroupWrapper._gemUniqueGroup)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public GEMUniqueGroup getWrappedGEMUniqueGroup() {
		return _gemUniqueGroup;
	}

	@Override
	public GEMUniqueGroup getWrappedModel() {
		return _gemUniqueGroup;
	}

	@Override
	public void resetOriginalValues() {
		_gemUniqueGroup.resetOriginalValues();
	}

	private GEMUniqueGroup _gemUniqueGroup;
}