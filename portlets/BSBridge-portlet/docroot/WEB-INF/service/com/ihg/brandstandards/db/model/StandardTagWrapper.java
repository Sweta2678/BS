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
 * This class is a wrapper for {@link StandardTag}.
 * </p>
 *
 * @author Mummanedi
 * @see StandardTag
 * @generated
 */
public class StandardTagWrapper implements StandardTag,
	ModelWrapper<StandardTag> {
	public StandardTagWrapper(StandardTag standardTag) {
		_standardTag = standardTag;
	}

	@Override
	public Class<?> getModelClass() {
		return StandardTag.class;
	}

	@Override
	public String getModelClassName() {
		return StandardTag.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("stdId", getStdId());
		attributes.put("tag", getTag());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long stdId = (Long)attributes.get("stdId");

		if (stdId != null) {
			setStdId(stdId);
		}

		String tag = (String)attributes.get("tag");

		if (tag != null) {
			setTag(tag);
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
	* Returns the primary key of this standard tag.
	*
	* @return the primary key of this standard tag
	*/
	@Override
	public com.ihg.brandstandards.db.service.persistence.StandardTagPK getPrimaryKey() {
		return _standardTag.getPrimaryKey();
	}

	/**
	* Sets the primary key of this standard tag.
	*
	* @param primaryKey the primary key of this standard tag
	*/
	@Override
	public void setPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.StandardTagPK primaryKey) {
		_standardTag.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the std ID of this standard tag.
	*
	* @return the std ID of this standard tag
	*/
	@Override
	public long getStdId() {
		return _standardTag.getStdId();
	}

	/**
	* Sets the std ID of this standard tag.
	*
	* @param stdId the std ID of this standard tag
	*/
	@Override
	public void setStdId(long stdId) {
		_standardTag.setStdId(stdId);
	}

	/**
	* Returns the tag of this standard tag.
	*
	* @return the tag of this standard tag
	*/
	@Override
	public java.lang.String getTag() {
		return _standardTag.getTag();
	}

	/**
	* Sets the tag of this standard tag.
	*
	* @param tag the tag of this standard tag
	*/
	@Override
	public void setTag(java.lang.String tag) {
		_standardTag.setTag(tag);
	}

	/**
	* Returns the creator ID of this standard tag.
	*
	* @return the creator ID of this standard tag
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _standardTag.getCreatorId();
	}

	/**
	* Sets the creator ID of this standard tag.
	*
	* @param creatorId the creator ID of this standard tag
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_standardTag.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this standard tag.
	*
	* @return the created date of this standard tag
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _standardTag.getCreatedDate();
	}

	/**
	* Sets the created date of this standard tag.
	*
	* @param createdDate the created date of this standard tag
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_standardTag.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this standard tag.
	*
	* @return the updated by of this standard tag
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _standardTag.getUpdatedBy();
	}

	/**
	* Sets the updated by of this standard tag.
	*
	* @param updatedBy the updated by of this standard tag
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_standardTag.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this standard tag.
	*
	* @return the updated date of this standard tag
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _standardTag.getUpdatedDate();
	}

	/**
	* Sets the updated date of this standard tag.
	*
	* @param updatedDate the updated date of this standard tag
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_standardTag.setUpdatedDate(updatedDate);
	}

	@Override
	public boolean isNew() {
		return _standardTag.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_standardTag.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _standardTag.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_standardTag.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _standardTag.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _standardTag.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_standardTag.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _standardTag.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_standardTag.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_standardTag.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_standardTag.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new StandardTagWrapper((StandardTag)_standardTag.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.StandardTag standardTag) {
		return _standardTag.compareTo(standardTag);
	}

	@Override
	public int hashCode() {
		return _standardTag.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.StandardTag> toCacheModel() {
		return _standardTag.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.StandardTag toEscapedModel() {
		return new StandardTagWrapper(_standardTag.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.StandardTag toUnescapedModel() {
		return new StandardTagWrapper(_standardTag.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _standardTag.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _standardTag.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_standardTag.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StandardTagWrapper)) {
			return false;
		}

		StandardTagWrapper standardTagWrapper = (StandardTagWrapper)obj;

		if (Validator.equals(_standardTag, standardTagWrapper._standardTag)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public StandardTag getWrappedStandardTag() {
		return _standardTag;
	}

	@Override
	public StandardTag getWrappedModel() {
		return _standardTag;
	}

	@Override
	public void resetOriginalValues() {
		_standardTag.resetOriginalValues();
	}

	private StandardTag _standardTag;
}