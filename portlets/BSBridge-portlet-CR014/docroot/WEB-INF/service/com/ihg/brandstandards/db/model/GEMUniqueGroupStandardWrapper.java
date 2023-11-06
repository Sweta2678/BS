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
 * This class is a wrapper for {@link GEMUniqueGroupStandard}.
 * </p>
 *
 * @author Mummanedi
 * @see GEMUniqueGroupStandard
 * @generated
 */
public class GEMUniqueGroupStandardWrapper implements GEMUniqueGroupStandard,
	ModelWrapper<GEMUniqueGroupStandard> {
	public GEMUniqueGroupStandardWrapper(
		GEMUniqueGroupStandard gemUniqueGroupStandard) {
		_gemUniqueGroupStandard = gemUniqueGroupStandard;
	}

	@Override
	public Class<?> getModelClass() {
		return GEMUniqueGroupStandard.class;
	}

	@Override
	public String getModelClassName() {
		return GEMUniqueGroupStandard.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("groupStandardId", getGroupStandardId());
		attributes.put("groupId", getGroupId());
		attributes.put("stdId", getStdId());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long groupStandardId = (Long)attributes.get("groupStandardId");

		if (groupStandardId != null) {
			setGroupStandardId(groupStandardId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long stdId = (Long)attributes.get("stdId");

		if (stdId != null) {
			setStdId(stdId);
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
	* Returns the primary key of this g e m unique group standard.
	*
	* @return the primary key of this g e m unique group standard
	*/
	@Override
	public long getPrimaryKey() {
		return _gemUniqueGroupStandard.getPrimaryKey();
	}

	/**
	* Sets the primary key of this g e m unique group standard.
	*
	* @param primaryKey the primary key of this g e m unique group standard
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_gemUniqueGroupStandard.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the group standard ID of this g e m unique group standard.
	*
	* @return the group standard ID of this g e m unique group standard
	*/
	@Override
	public long getGroupStandardId() {
		return _gemUniqueGroupStandard.getGroupStandardId();
	}

	/**
	* Sets the group standard ID of this g e m unique group standard.
	*
	* @param groupStandardId the group standard ID of this g e m unique group standard
	*/
	@Override
	public void setGroupStandardId(long groupStandardId) {
		_gemUniqueGroupStandard.setGroupStandardId(groupStandardId);
	}

	/**
	* Returns the group ID of this g e m unique group standard.
	*
	* @return the group ID of this g e m unique group standard
	*/
	@Override
	public long getGroupId() {
		return _gemUniqueGroupStandard.getGroupId();
	}

	/**
	* Sets the group ID of this g e m unique group standard.
	*
	* @param groupId the group ID of this g e m unique group standard
	*/
	@Override
	public void setGroupId(long groupId) {
		_gemUniqueGroupStandard.setGroupId(groupId);
	}

	/**
	* Returns the std ID of this g e m unique group standard.
	*
	* @return the std ID of this g e m unique group standard
	*/
	@Override
	public long getStdId() {
		return _gemUniqueGroupStandard.getStdId();
	}

	/**
	* Sets the std ID of this g e m unique group standard.
	*
	* @param stdId the std ID of this g e m unique group standard
	*/
	@Override
	public void setStdId(long stdId) {
		_gemUniqueGroupStandard.setStdId(stdId);
	}

	/**
	* Returns the creator ID of this g e m unique group standard.
	*
	* @return the creator ID of this g e m unique group standard
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _gemUniqueGroupStandard.getCreatorId();
	}

	/**
	* Sets the creator ID of this g e m unique group standard.
	*
	* @param creatorId the creator ID of this g e m unique group standard
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_gemUniqueGroupStandard.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this g e m unique group standard.
	*
	* @return the created date of this g e m unique group standard
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _gemUniqueGroupStandard.getCreatedDate();
	}

	/**
	* Sets the created date of this g e m unique group standard.
	*
	* @param createdDate the created date of this g e m unique group standard
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_gemUniqueGroupStandard.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this g e m unique group standard.
	*
	* @return the updated by of this g e m unique group standard
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _gemUniqueGroupStandard.getUpdatedBy();
	}

	/**
	* Sets the updated by of this g e m unique group standard.
	*
	* @param updatedBy the updated by of this g e m unique group standard
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_gemUniqueGroupStandard.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this g e m unique group standard.
	*
	* @return the updated date of this g e m unique group standard
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _gemUniqueGroupStandard.getUpdatedDate();
	}

	/**
	* Sets the updated date of this g e m unique group standard.
	*
	* @param updatedDate the updated date of this g e m unique group standard
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_gemUniqueGroupStandard.setUpdatedDate(updatedDate);
	}

	@Override
	public boolean isNew() {
		return _gemUniqueGroupStandard.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_gemUniqueGroupStandard.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _gemUniqueGroupStandard.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_gemUniqueGroupStandard.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _gemUniqueGroupStandard.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _gemUniqueGroupStandard.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_gemUniqueGroupStandard.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _gemUniqueGroupStandard.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_gemUniqueGroupStandard.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_gemUniqueGroupStandard.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_gemUniqueGroupStandard.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new GEMUniqueGroupStandardWrapper((GEMUniqueGroupStandard)_gemUniqueGroupStandard.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.GEMUniqueGroupStandard gemUniqueGroupStandard) {
		return _gemUniqueGroupStandard.compareTo(gemUniqueGroupStandard);
	}

	@Override
	public int hashCode() {
		return _gemUniqueGroupStandard.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.GEMUniqueGroupStandard> toCacheModel() {
		return _gemUniqueGroupStandard.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.GEMUniqueGroupStandard toEscapedModel() {
		return new GEMUniqueGroupStandardWrapper(_gemUniqueGroupStandard.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.GEMUniqueGroupStandard toUnescapedModel() {
		return new GEMUniqueGroupStandardWrapper(_gemUniqueGroupStandard.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _gemUniqueGroupStandard.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _gemUniqueGroupStandard.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_gemUniqueGroupStandard.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GEMUniqueGroupStandardWrapper)) {
			return false;
		}

		GEMUniqueGroupStandardWrapper gemUniqueGroupStandardWrapper = (GEMUniqueGroupStandardWrapper)obj;

		if (Validator.equals(_gemUniqueGroupStandard,
					gemUniqueGroupStandardWrapper._gemUniqueGroupStandard)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public GEMUniqueGroupStandard getWrappedGEMUniqueGroupStandard() {
		return _gemUniqueGroupStandard;
	}

	@Override
	public GEMUniqueGroupStandard getWrappedModel() {
		return _gemUniqueGroupStandard;
	}

	@Override
	public void resetOriginalValues() {
		_gemUniqueGroupStandard.resetOriginalValues();
	}

	private GEMUniqueGroupStandard _gemUniqueGroupStandard;
}