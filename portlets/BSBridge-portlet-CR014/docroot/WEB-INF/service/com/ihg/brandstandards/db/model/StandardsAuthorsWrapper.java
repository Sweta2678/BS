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
 * This class is a wrapper for {@link StandardsAuthors}.
 * </p>
 *
 * @author Mummanedi
 * @see StandardsAuthors
 * @generated
 */
public class StandardsAuthorsWrapper implements StandardsAuthors,
	ModelWrapper<StandardsAuthors> {
	public StandardsAuthorsWrapper(StandardsAuthors standardsAuthors) {
		_standardsAuthors = standardsAuthors;
	}

	@Override
	public Class<?> getModelClass() {
		return StandardsAuthors.class;
	}

	@Override
	public String getModelClassName() {
		return StandardsAuthors.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("stdAuthorId", getStdAuthorId());
		attributes.put("stdId", getStdId());
		attributes.put("authorName", getAuthorName());
		attributes.put("isPrimary", getIsPrimary());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long stdAuthorId = (Long)attributes.get("stdAuthorId");

		if (stdAuthorId != null) {
			setStdAuthorId(stdAuthorId);
		}

		Long stdId = (Long)attributes.get("stdId");

		if (stdId != null) {
			setStdId(stdId);
		}

		String authorName = (String)attributes.get("authorName");

		if (authorName != null) {
			setAuthorName(authorName);
		}

		String isPrimary = (String)attributes.get("isPrimary");

		if (isPrimary != null) {
			setIsPrimary(isPrimary);
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
	* Returns the primary key of this standards authors.
	*
	* @return the primary key of this standards authors
	*/
	@Override
	public long getPrimaryKey() {
		return _standardsAuthors.getPrimaryKey();
	}

	/**
	* Sets the primary key of this standards authors.
	*
	* @param primaryKey the primary key of this standards authors
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_standardsAuthors.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the std author ID of this standards authors.
	*
	* @return the std author ID of this standards authors
	*/
	@Override
	public long getStdAuthorId() {
		return _standardsAuthors.getStdAuthorId();
	}

	/**
	* Sets the std author ID of this standards authors.
	*
	* @param stdAuthorId the std author ID of this standards authors
	*/
	@Override
	public void setStdAuthorId(long stdAuthorId) {
		_standardsAuthors.setStdAuthorId(stdAuthorId);
	}

	/**
	* Returns the std ID of this standards authors.
	*
	* @return the std ID of this standards authors
	*/
	@Override
	public long getStdId() {
		return _standardsAuthors.getStdId();
	}

	/**
	* Sets the std ID of this standards authors.
	*
	* @param stdId the std ID of this standards authors
	*/
	@Override
	public void setStdId(long stdId) {
		_standardsAuthors.setStdId(stdId);
	}

	/**
	* Returns the author name of this standards authors.
	*
	* @return the author name of this standards authors
	*/
	@Override
	public java.lang.String getAuthorName() {
		return _standardsAuthors.getAuthorName();
	}

	/**
	* Sets the author name of this standards authors.
	*
	* @param authorName the author name of this standards authors
	*/
	@Override
	public void setAuthorName(java.lang.String authorName) {
		_standardsAuthors.setAuthorName(authorName);
	}

	/**
	* Returns the is primary of this standards authors.
	*
	* @return the is primary of this standards authors
	*/
	@Override
	public java.lang.String getIsPrimary() {
		return _standardsAuthors.getIsPrimary();
	}

	/**
	* Sets the is primary of this standards authors.
	*
	* @param isPrimary the is primary of this standards authors
	*/
	@Override
	public void setIsPrimary(java.lang.String isPrimary) {
		_standardsAuthors.setIsPrimary(isPrimary);
	}

	/**
	* Returns the creator ID of this standards authors.
	*
	* @return the creator ID of this standards authors
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _standardsAuthors.getCreatorId();
	}

	/**
	* Sets the creator ID of this standards authors.
	*
	* @param creatorId the creator ID of this standards authors
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_standardsAuthors.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this standards authors.
	*
	* @return the created date of this standards authors
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _standardsAuthors.getCreatedDate();
	}

	/**
	* Sets the created date of this standards authors.
	*
	* @param createdDate the created date of this standards authors
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_standardsAuthors.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this standards authors.
	*
	* @return the updated by of this standards authors
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _standardsAuthors.getUpdatedBy();
	}

	/**
	* Sets the updated by of this standards authors.
	*
	* @param updatedBy the updated by of this standards authors
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_standardsAuthors.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this standards authors.
	*
	* @return the updated date of this standards authors
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _standardsAuthors.getUpdatedDate();
	}

	/**
	* Sets the updated date of this standards authors.
	*
	* @param updatedDate the updated date of this standards authors
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_standardsAuthors.setUpdatedDate(updatedDate);
	}

	@Override
	public boolean isNew() {
		return _standardsAuthors.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_standardsAuthors.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _standardsAuthors.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_standardsAuthors.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _standardsAuthors.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _standardsAuthors.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_standardsAuthors.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _standardsAuthors.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_standardsAuthors.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_standardsAuthors.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_standardsAuthors.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new StandardsAuthorsWrapper((StandardsAuthors)_standardsAuthors.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.StandardsAuthors standardsAuthors) {
		return _standardsAuthors.compareTo(standardsAuthors);
	}

	@Override
	public int hashCode() {
		return _standardsAuthors.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.StandardsAuthors> toCacheModel() {
		return _standardsAuthors.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.StandardsAuthors toEscapedModel() {
		return new StandardsAuthorsWrapper(_standardsAuthors.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.StandardsAuthors toUnescapedModel() {
		return new StandardsAuthorsWrapper(_standardsAuthors.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _standardsAuthors.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _standardsAuthors.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_standardsAuthors.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StandardsAuthorsWrapper)) {
			return false;
		}

		StandardsAuthorsWrapper standardsAuthorsWrapper = (StandardsAuthorsWrapper)obj;

		if (Validator.equals(_standardsAuthors,
					standardsAuthorsWrapper._standardsAuthors)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public StandardsAuthors getWrappedStandardsAuthors() {
		return _standardsAuthors;
	}

	@Override
	public StandardsAuthors getWrappedModel() {
		return _standardsAuthors;
	}

	@Override
	public void resetOriginalValues() {
		_standardsAuthors.resetOriginalValues();
	}

	private StandardsAuthors _standardsAuthors;
}