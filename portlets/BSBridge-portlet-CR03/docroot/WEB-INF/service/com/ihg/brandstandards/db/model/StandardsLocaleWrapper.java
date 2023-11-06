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
 * This class is a wrapper for {@link StandardsLocale}.
 * </p>
 *
 * @author Mummanedi
 * @see StandardsLocale
 * @generated
 */
public class StandardsLocaleWrapper implements StandardsLocale,
	ModelWrapper<StandardsLocale> {
	public StandardsLocaleWrapper(StandardsLocale standardsLocale) {
		_standardsLocale = standardsLocale;
	}

	@Override
	public Class<?> getModelClass() {
		return StandardsLocale.class;
	}

	@Override
	public String getModelClassName() {
		return StandardsLocale.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("localeCode", getLocaleCode());
		attributes.put("countryCode", getCountryCode());
		attributes.put("localeName", getLocaleName());
		attributes.put("languageCode", getLanguageCode());
		attributes.put("orderNumber", getOrderNumber());
		attributes.put("isActive", getIsActive());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String localeCode = (String)attributes.get("localeCode");

		if (localeCode != null) {
			setLocaleCode(localeCode);
		}

		String countryCode = (String)attributes.get("countryCode");

		if (countryCode != null) {
			setCountryCode(countryCode);
		}

		String localeName = (String)attributes.get("localeName");

		if (localeName != null) {
			setLocaleName(localeName);
		}

		String languageCode = (String)attributes.get("languageCode");

		if (languageCode != null) {
			setLanguageCode(languageCode);
		}

		Long orderNumber = (Long)attributes.get("orderNumber");

		if (orderNumber != null) {
			setOrderNumber(orderNumber);
		}

		String isActive = (String)attributes.get("isActive");

		if (isActive != null) {
			setIsActive(isActive);
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
	* Returns the primary key of this standards locale.
	*
	* @return the primary key of this standards locale
	*/
	@Override
	public java.lang.String getPrimaryKey() {
		return _standardsLocale.getPrimaryKey();
	}

	/**
	* Sets the primary key of this standards locale.
	*
	* @param primaryKey the primary key of this standards locale
	*/
	@Override
	public void setPrimaryKey(java.lang.String primaryKey) {
		_standardsLocale.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the locale code of this standards locale.
	*
	* @return the locale code of this standards locale
	*/
	@Override
	public java.lang.String getLocaleCode() {
		return _standardsLocale.getLocaleCode();
	}

	/**
	* Sets the locale code of this standards locale.
	*
	* @param localeCode the locale code of this standards locale
	*/
	@Override
	public void setLocaleCode(java.lang.String localeCode) {
		_standardsLocale.setLocaleCode(localeCode);
	}

	/**
	* Returns the country code of this standards locale.
	*
	* @return the country code of this standards locale
	*/
	@Override
	public java.lang.String getCountryCode() {
		return _standardsLocale.getCountryCode();
	}

	/**
	* Sets the country code of this standards locale.
	*
	* @param countryCode the country code of this standards locale
	*/
	@Override
	public void setCountryCode(java.lang.String countryCode) {
		_standardsLocale.setCountryCode(countryCode);
	}

	/**
	* Returns the locale name of this standards locale.
	*
	* @return the locale name of this standards locale
	*/
	@Override
	public java.lang.String getLocaleName() {
		return _standardsLocale.getLocaleName();
	}

	/**
	* Sets the locale name of this standards locale.
	*
	* @param localeName the locale name of this standards locale
	*/
	@Override
	public void setLocaleName(java.lang.String localeName) {
		_standardsLocale.setLocaleName(localeName);
	}

	/**
	* Returns the language code of this standards locale.
	*
	* @return the language code of this standards locale
	*/
	@Override
	public java.lang.String getLanguageCode() {
		return _standardsLocale.getLanguageCode();
	}

	/**
	* Sets the language code of this standards locale.
	*
	* @param languageCode the language code of this standards locale
	*/
	@Override
	public void setLanguageCode(java.lang.String languageCode) {
		_standardsLocale.setLanguageCode(languageCode);
	}

	/**
	* Returns the order number of this standards locale.
	*
	* @return the order number of this standards locale
	*/
	@Override
	public long getOrderNumber() {
		return _standardsLocale.getOrderNumber();
	}

	/**
	* Sets the order number of this standards locale.
	*
	* @param orderNumber the order number of this standards locale
	*/
	@Override
	public void setOrderNumber(long orderNumber) {
		_standardsLocale.setOrderNumber(orderNumber);
	}

	/**
	* Returns the is active of this standards locale.
	*
	* @return the is active of this standards locale
	*/
	@Override
	public java.lang.String getIsActive() {
		return _standardsLocale.getIsActive();
	}

	/**
	* Sets the is active of this standards locale.
	*
	* @param isActive the is active of this standards locale
	*/
	@Override
	public void setIsActive(java.lang.String isActive) {
		_standardsLocale.setIsActive(isActive);
	}

	/**
	* Returns the creator ID of this standards locale.
	*
	* @return the creator ID of this standards locale
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _standardsLocale.getCreatorId();
	}

	/**
	* Sets the creator ID of this standards locale.
	*
	* @param creatorId the creator ID of this standards locale
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_standardsLocale.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this standards locale.
	*
	* @return the created date of this standards locale
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _standardsLocale.getCreatedDate();
	}

	/**
	* Sets the created date of this standards locale.
	*
	* @param createdDate the created date of this standards locale
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_standardsLocale.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this standards locale.
	*
	* @return the updated by of this standards locale
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _standardsLocale.getUpdatedBy();
	}

	/**
	* Sets the updated by of this standards locale.
	*
	* @param updatedBy the updated by of this standards locale
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_standardsLocale.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this standards locale.
	*
	* @return the updated date of this standards locale
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _standardsLocale.getUpdatedDate();
	}

	/**
	* Sets the updated date of this standards locale.
	*
	* @param updatedDate the updated date of this standards locale
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_standardsLocale.setUpdatedDate(updatedDate);
	}

	@Override
	public boolean isNew() {
		return _standardsLocale.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_standardsLocale.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _standardsLocale.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_standardsLocale.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _standardsLocale.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _standardsLocale.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_standardsLocale.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _standardsLocale.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_standardsLocale.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_standardsLocale.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_standardsLocale.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new StandardsLocaleWrapper((StandardsLocale)_standardsLocale.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.StandardsLocale standardsLocale) {
		return _standardsLocale.compareTo(standardsLocale);
	}

	@Override
	public int hashCode() {
		return _standardsLocale.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.StandardsLocale> toCacheModel() {
		return _standardsLocale.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.StandardsLocale toEscapedModel() {
		return new StandardsLocaleWrapper(_standardsLocale.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.StandardsLocale toUnescapedModel() {
		return new StandardsLocaleWrapper(_standardsLocale.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _standardsLocale.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _standardsLocale.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_standardsLocale.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StandardsLocaleWrapper)) {
			return false;
		}

		StandardsLocaleWrapper standardsLocaleWrapper = (StandardsLocaleWrapper)obj;

		if (Validator.equals(_standardsLocale,
					standardsLocaleWrapper._standardsLocale)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public StandardsLocale getWrappedStandardsLocale() {
		return _standardsLocale;
	}

	@Override
	public StandardsLocale getWrappedModel() {
		return _standardsLocale;
	}

	@Override
	public void resetOriginalValues() {
		_standardsLocale.resetOriginalValues();
	}

	private StandardsLocale _standardsLocale;
}