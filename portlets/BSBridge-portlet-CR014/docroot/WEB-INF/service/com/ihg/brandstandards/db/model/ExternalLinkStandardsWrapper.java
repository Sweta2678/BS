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
 * This class is a wrapper for {@link ExternalLinkStandards}.
 * </p>
 *
 * @author Mummanedi
 * @see ExternalLinkStandards
 * @generated
 */
public class ExternalLinkStandardsWrapper implements ExternalLinkStandards,
	ModelWrapper<ExternalLinkStandards> {
	public ExternalLinkStandardsWrapper(
		ExternalLinkStandards externalLinkStandards) {
		_externalLinkStandards = externalLinkStandards;
	}

	@Override
	public Class<?> getModelClass() {
		return ExternalLinkStandards.class;
	}

	@Override
	public String getModelClassName() {
		return ExternalLinkStandards.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("extLinkId", getExtLinkId());
		attributes.put("parentExtLinkId", getParentExtLinkId());
		attributes.put("stdId", getStdId());
		attributes.put("url", getUrl());
		attributes.put("title", getTitle());
		attributes.put("translationIndicator", getTranslationIndicator());
		attributes.put("localeCode", getLocaleCode());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long extLinkId = (Long)attributes.get("extLinkId");

		if (extLinkId != null) {
			setExtLinkId(extLinkId);
		}

		Long parentExtLinkId = (Long)attributes.get("parentExtLinkId");

		if (parentExtLinkId != null) {
			setParentExtLinkId(parentExtLinkId);
		}

		Long stdId = (Long)attributes.get("stdId");

		if (stdId != null) {
			setStdId(stdId);
		}

		String url = (String)attributes.get("url");

		if (url != null) {
			setUrl(url);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String translationIndicator = (String)attributes.get(
				"translationIndicator");

		if (translationIndicator != null) {
			setTranslationIndicator(translationIndicator);
		}

		String localeCode = (String)attributes.get("localeCode");

		if (localeCode != null) {
			setLocaleCode(localeCode);
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
	* Returns the primary key of this external link standards.
	*
	* @return the primary key of this external link standards
	*/
	@Override
	public long getPrimaryKey() {
		return _externalLinkStandards.getPrimaryKey();
	}

	/**
	* Sets the primary key of this external link standards.
	*
	* @param primaryKey the primary key of this external link standards
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_externalLinkStandards.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ext link ID of this external link standards.
	*
	* @return the ext link ID of this external link standards
	*/
	@Override
	public long getExtLinkId() {
		return _externalLinkStandards.getExtLinkId();
	}

	/**
	* Sets the ext link ID of this external link standards.
	*
	* @param extLinkId the ext link ID of this external link standards
	*/
	@Override
	public void setExtLinkId(long extLinkId) {
		_externalLinkStandards.setExtLinkId(extLinkId);
	}

	/**
	* Returns the parent ext link ID of this external link standards.
	*
	* @return the parent ext link ID of this external link standards
	*/
	@Override
	public long getParentExtLinkId() {
		return _externalLinkStandards.getParentExtLinkId();
	}

	/**
	* Sets the parent ext link ID of this external link standards.
	*
	* @param parentExtLinkId the parent ext link ID of this external link standards
	*/
	@Override
	public void setParentExtLinkId(long parentExtLinkId) {
		_externalLinkStandards.setParentExtLinkId(parentExtLinkId);
	}

	/**
	* Returns the std ID of this external link standards.
	*
	* @return the std ID of this external link standards
	*/
	@Override
	public long getStdId() {
		return _externalLinkStandards.getStdId();
	}

	/**
	* Sets the std ID of this external link standards.
	*
	* @param stdId the std ID of this external link standards
	*/
	@Override
	public void setStdId(long stdId) {
		_externalLinkStandards.setStdId(stdId);
	}

	/**
	* Returns the url of this external link standards.
	*
	* @return the url of this external link standards
	*/
	@Override
	public java.lang.String getUrl() {
		return _externalLinkStandards.getUrl();
	}

	/**
	* Sets the url of this external link standards.
	*
	* @param url the url of this external link standards
	*/
	@Override
	public void setUrl(java.lang.String url) {
		_externalLinkStandards.setUrl(url);
	}

	/**
	* Returns the title of this external link standards.
	*
	* @return the title of this external link standards
	*/
	@Override
	public java.lang.String getTitle() {
		return _externalLinkStandards.getTitle();
	}

	/**
	* Sets the title of this external link standards.
	*
	* @param title the title of this external link standards
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_externalLinkStandards.setTitle(title);
	}

	/**
	* Returns the translation indicator of this external link standards.
	*
	* @return the translation indicator of this external link standards
	*/
	@Override
	public java.lang.String getTranslationIndicator() {
		return _externalLinkStandards.getTranslationIndicator();
	}

	/**
	* Sets the translation indicator of this external link standards.
	*
	* @param translationIndicator the translation indicator of this external link standards
	*/
	@Override
	public void setTranslationIndicator(java.lang.String translationIndicator) {
		_externalLinkStandards.setTranslationIndicator(translationIndicator);
	}

	/**
	* Returns the locale code of this external link standards.
	*
	* @return the locale code of this external link standards
	*/
	@Override
	public java.lang.String getLocaleCode() {
		return _externalLinkStandards.getLocaleCode();
	}

	/**
	* Sets the locale code of this external link standards.
	*
	* @param localeCode the locale code of this external link standards
	*/
	@Override
	public void setLocaleCode(java.lang.String localeCode) {
		_externalLinkStandards.setLocaleCode(localeCode);
	}

	/**
	* Returns the creator ID of this external link standards.
	*
	* @return the creator ID of this external link standards
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _externalLinkStandards.getCreatorId();
	}

	/**
	* Sets the creator ID of this external link standards.
	*
	* @param creatorId the creator ID of this external link standards
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_externalLinkStandards.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this external link standards.
	*
	* @return the created date of this external link standards
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _externalLinkStandards.getCreatedDate();
	}

	/**
	* Sets the created date of this external link standards.
	*
	* @param createdDate the created date of this external link standards
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_externalLinkStandards.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this external link standards.
	*
	* @return the updated by of this external link standards
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _externalLinkStandards.getUpdatedBy();
	}

	/**
	* Sets the updated by of this external link standards.
	*
	* @param updatedBy the updated by of this external link standards
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_externalLinkStandards.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this external link standards.
	*
	* @return the updated date of this external link standards
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _externalLinkStandards.getUpdatedDate();
	}

	/**
	* Sets the updated date of this external link standards.
	*
	* @param updatedDate the updated date of this external link standards
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_externalLinkStandards.setUpdatedDate(updatedDate);
	}

	@Override
	public boolean isNew() {
		return _externalLinkStandards.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_externalLinkStandards.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _externalLinkStandards.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_externalLinkStandards.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _externalLinkStandards.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _externalLinkStandards.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_externalLinkStandards.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _externalLinkStandards.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_externalLinkStandards.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_externalLinkStandards.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_externalLinkStandards.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ExternalLinkStandardsWrapper((ExternalLinkStandards)_externalLinkStandards.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.ExternalLinkStandards externalLinkStandards) {
		return _externalLinkStandards.compareTo(externalLinkStandards);
	}

	@Override
	public int hashCode() {
		return _externalLinkStandards.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.ExternalLinkStandards> toCacheModel() {
		return _externalLinkStandards.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.ExternalLinkStandards toEscapedModel() {
		return new ExternalLinkStandardsWrapper(_externalLinkStandards.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.ExternalLinkStandards toUnescapedModel() {
		return new ExternalLinkStandardsWrapper(_externalLinkStandards.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _externalLinkStandards.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _externalLinkStandards.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_externalLinkStandards.persist();
	}

	@Override
	public java.lang.String getRealUrl() {
		return _externalLinkStandards.getRealUrl();
	}

	@Override
	public java.lang.String getRealTitle() {
		return _externalLinkStandards.getRealTitle();
	}

	/**
	* @return the isLinkTranslationExist
	*/
	@Override
	public boolean isLinkTranslationExist() {
		return _externalLinkStandards.isLinkTranslationExist();
	}

	/**
	* @param isLinkTranslationExist the isLinkTranslationExist to set
	*/
	@Override
	public void setLinkTranslationExist(boolean isLinkTranslationExist) {
		_externalLinkStandards.setLinkTranslationExist(isLinkTranslationExist);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ExternalLinkStandardsWrapper)) {
			return false;
		}

		ExternalLinkStandardsWrapper externalLinkStandardsWrapper = (ExternalLinkStandardsWrapper)obj;

		if (Validator.equals(_externalLinkStandards,
					externalLinkStandardsWrapper._externalLinkStandards)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ExternalLinkStandards getWrappedExternalLinkStandards() {
		return _externalLinkStandards;
	}

	@Override
	public ExternalLinkStandards getWrappedModel() {
		return _externalLinkStandards;
	}

	@Override
	public void resetOriginalValues() {
		_externalLinkStandards.resetOriginalValues();
	}

	private ExternalLinkStandards _externalLinkStandards;
}