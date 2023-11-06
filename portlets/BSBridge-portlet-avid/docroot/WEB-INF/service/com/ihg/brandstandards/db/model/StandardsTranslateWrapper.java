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
 * This class is a wrapper for {@link StandardsTranslate}.
 * </p>
 *
 * @author Mummanedi
 * @see StandardsTranslate
 * @generated
 */
public class StandardsTranslateWrapper implements StandardsTranslate,
	ModelWrapper<StandardsTranslate> {
	public StandardsTranslateWrapper(StandardsTranslate standardsTranslate) {
		_standardsTranslate = standardsTranslate;
	}

	@Override
	public Class<?> getModelClass() {
		return StandardsTranslate.class;
	}

	@Override
	public String getModelClassName() {
		return StandardsTranslate.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("stdId", getStdId());
		attributes.put("localeCode", getLocaleCode());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("note", getNote());
		attributes.put("comment", getComment());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());
		attributes.put("isValidTxt", getIsValidTxt());
		attributes.put("isValidCntxt", getIsValidCntxt());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long stdId = (Long)attributes.get("stdId");

		if (stdId != null) {
			setStdId(stdId);
		}

		String localeCode = (String)attributes.get("localeCode");

		if (localeCode != null) {
			setLocaleCode(localeCode);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String note = (String)attributes.get("note");

		if (note != null) {
			setNote(note);
		}

		String comment = (String)attributes.get("comment");

		if (comment != null) {
			setComment(comment);
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

		String isValidTxt = (String)attributes.get("isValidTxt");

		if (isValidTxt != null) {
			setIsValidTxt(isValidTxt);
		}

		String isValidCntxt = (String)attributes.get("isValidCntxt");

		if (isValidCntxt != null) {
			setIsValidCntxt(isValidCntxt);
		}
	}

	/**
	* Returns the primary key of this standards translate.
	*
	* @return the primary key of this standards translate
	*/
	@Override
	public com.ihg.brandstandards.db.service.persistence.StandardsTranslatePK getPrimaryKey() {
		return _standardsTranslate.getPrimaryKey();
	}

	/**
	* Sets the primary key of this standards translate.
	*
	* @param primaryKey the primary key of this standards translate
	*/
	@Override
	public void setPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.StandardsTranslatePK primaryKey) {
		_standardsTranslate.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the std ID of this standards translate.
	*
	* @return the std ID of this standards translate
	*/
	@Override
	public long getStdId() {
		return _standardsTranslate.getStdId();
	}

	/**
	* Sets the std ID of this standards translate.
	*
	* @param stdId the std ID of this standards translate
	*/
	@Override
	public void setStdId(long stdId) {
		_standardsTranslate.setStdId(stdId);
	}

	/**
	* Returns the locale code of this standards translate.
	*
	* @return the locale code of this standards translate
	*/
	@Override
	public java.lang.String getLocaleCode() {
		return _standardsTranslate.getLocaleCode();
	}

	/**
	* Sets the locale code of this standards translate.
	*
	* @param localeCode the locale code of this standards translate
	*/
	@Override
	public void setLocaleCode(java.lang.String localeCode) {
		_standardsTranslate.setLocaleCode(localeCode);
	}

	/**
	* Returns the title of this standards translate.
	*
	* @return the title of this standards translate
	*/
	@Override
	public java.lang.String getTitle() {
		return _standardsTranslate.getTitle();
	}

	/**
	* Sets the title of this standards translate.
	*
	* @param title the title of this standards translate
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_standardsTranslate.setTitle(title);
	}

	/**
	* Returns the description of this standards translate.
	*
	* @return the description of this standards translate
	*/
	@Override
	public java.lang.String getDescription() {
		return _standardsTranslate.getDescription();
	}

	/**
	* Sets the description of this standards translate.
	*
	* @param description the description of this standards translate
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_standardsTranslate.setDescription(description);
	}

	/**
	* Returns the note of this standards translate.
	*
	* @return the note of this standards translate
	*/
	@Override
	public java.lang.String getNote() {
		return _standardsTranslate.getNote();
	}

	/**
	* Sets the note of this standards translate.
	*
	* @param note the note of this standards translate
	*/
	@Override
	public void setNote(java.lang.String note) {
		_standardsTranslate.setNote(note);
	}

	/**
	* Returns the comment of this standards translate.
	*
	* @return the comment of this standards translate
	*/
	@Override
	public java.lang.String getComment() {
		return _standardsTranslate.getComment();
	}

	/**
	* Sets the comment of this standards translate.
	*
	* @param comment the comment of this standards translate
	*/
	@Override
	public void setComment(java.lang.String comment) {
		_standardsTranslate.setComment(comment);
	}

	/**
	* Returns the creator ID of this standards translate.
	*
	* @return the creator ID of this standards translate
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _standardsTranslate.getCreatorId();
	}

	/**
	* Sets the creator ID of this standards translate.
	*
	* @param creatorId the creator ID of this standards translate
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_standardsTranslate.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this standards translate.
	*
	* @return the created date of this standards translate
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _standardsTranslate.getCreatedDate();
	}

	/**
	* Sets the created date of this standards translate.
	*
	* @param createdDate the created date of this standards translate
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_standardsTranslate.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this standards translate.
	*
	* @return the updated by of this standards translate
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _standardsTranslate.getUpdatedBy();
	}

	/**
	* Sets the updated by of this standards translate.
	*
	* @param updatedBy the updated by of this standards translate
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_standardsTranslate.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this standards translate.
	*
	* @return the updated date of this standards translate
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _standardsTranslate.getUpdatedDate();
	}

	/**
	* Sets the updated date of this standards translate.
	*
	* @param updatedDate the updated date of this standards translate
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_standardsTranslate.setUpdatedDate(updatedDate);
	}

	/**
	* Returns the is valid txt of this standards translate.
	*
	* @return the is valid txt of this standards translate
	*/
	@Override
	public java.lang.String getIsValidTxt() {
		return _standardsTranslate.getIsValidTxt();
	}

	/**
	* Sets the is valid txt of this standards translate.
	*
	* @param isValidTxt the is valid txt of this standards translate
	*/
	@Override
	public void setIsValidTxt(java.lang.String isValidTxt) {
		_standardsTranslate.setIsValidTxt(isValidTxt);
	}

	/**
	* Returns the is valid cntxt of this standards translate.
	*
	* @return the is valid cntxt of this standards translate
	*/
	@Override
	public java.lang.String getIsValidCntxt() {
		return _standardsTranslate.getIsValidCntxt();
	}

	/**
	* Sets the is valid cntxt of this standards translate.
	*
	* @param isValidCntxt the is valid cntxt of this standards translate
	*/
	@Override
	public void setIsValidCntxt(java.lang.String isValidCntxt) {
		_standardsTranslate.setIsValidCntxt(isValidCntxt);
	}

	@Override
	public boolean isNew() {
		return _standardsTranslate.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_standardsTranslate.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _standardsTranslate.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_standardsTranslate.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _standardsTranslate.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _standardsTranslate.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_standardsTranslate.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _standardsTranslate.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_standardsTranslate.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_standardsTranslate.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_standardsTranslate.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new StandardsTranslateWrapper((StandardsTranslate)_standardsTranslate.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.StandardsTranslate standardsTranslate) {
		return _standardsTranslate.compareTo(standardsTranslate);
	}

	@Override
	public int hashCode() {
		return _standardsTranslate.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.StandardsTranslate> toCacheModel() {
		return _standardsTranslate.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.StandardsTranslate toEscapedModel() {
		return new StandardsTranslateWrapper(_standardsTranslate.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.StandardsTranslate toUnescapedModel() {
		return new StandardsTranslateWrapper(_standardsTranslate.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _standardsTranslate.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _standardsTranslate.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_standardsTranslate.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StandardsTranslateWrapper)) {
			return false;
		}

		StandardsTranslateWrapper standardsTranslateWrapper = (StandardsTranslateWrapper)obj;

		if (Validator.equals(_standardsTranslate,
					standardsTranslateWrapper._standardsTranslate)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public StandardsTranslate getWrappedStandardsTranslate() {
		return _standardsTranslate;
	}

	@Override
	public StandardsTranslate getWrappedModel() {
		return _standardsTranslate;
	}

	@Override
	public void resetOriginalValues() {
		_standardsTranslate.resetOriginalValues();
	}

	private StandardsTranslate _standardsTranslate;
}