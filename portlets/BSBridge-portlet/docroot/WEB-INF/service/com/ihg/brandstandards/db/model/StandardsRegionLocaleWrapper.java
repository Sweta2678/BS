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
 * This class is a wrapper for {@link StandardsRegionLocale}.
 * </p>
 *
 * @author Mummanedi
 * @see StandardsRegionLocale
 * @generated
 */
public class StandardsRegionLocaleWrapper implements StandardsRegionLocale,
	ModelWrapper<StandardsRegionLocale> {
	public StandardsRegionLocaleWrapper(
		StandardsRegionLocale standardsRegionLocale) {
		_standardsRegionLocale = standardsRegionLocale;
	}

	@Override
	public Class<?> getModelClass() {
		return StandardsRegionLocale.class;
	}

	@Override
	public String getModelClassName() {
		return StandardsRegionLocale.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("regionId", getRegionId());
		attributes.put("localeCode", getLocaleCode());
		attributes.put("isDefault", getIsDefault());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long regionId = (Long)attributes.get("regionId");

		if (regionId != null) {
			setRegionId(regionId);
		}

		String localeCode = (String)attributes.get("localeCode");

		if (localeCode != null) {
			setLocaleCode(localeCode);
		}

		String isDefault = (String)attributes.get("isDefault");

		if (isDefault != null) {
			setIsDefault(isDefault);
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
	* Returns the primary key of this standards region locale.
	*
	* @return the primary key of this standards region locale
	*/
	@Override
	public com.ihg.brandstandards.db.service.persistence.StandardsRegionLocalePK getPrimaryKey() {
		return _standardsRegionLocale.getPrimaryKey();
	}

	/**
	* Sets the primary key of this standards region locale.
	*
	* @param primaryKey the primary key of this standards region locale
	*/
	@Override
	public void setPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.StandardsRegionLocalePK primaryKey) {
		_standardsRegionLocale.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the region ID of this standards region locale.
	*
	* @return the region ID of this standards region locale
	*/
	@Override
	public long getRegionId() {
		return _standardsRegionLocale.getRegionId();
	}

	/**
	* Sets the region ID of this standards region locale.
	*
	* @param regionId the region ID of this standards region locale
	*/
	@Override
	public void setRegionId(long regionId) {
		_standardsRegionLocale.setRegionId(regionId);
	}

	/**
	* Returns the locale code of this standards region locale.
	*
	* @return the locale code of this standards region locale
	*/
	@Override
	public java.lang.String getLocaleCode() {
		return _standardsRegionLocale.getLocaleCode();
	}

	/**
	* Sets the locale code of this standards region locale.
	*
	* @param localeCode the locale code of this standards region locale
	*/
	@Override
	public void setLocaleCode(java.lang.String localeCode) {
		_standardsRegionLocale.setLocaleCode(localeCode);
	}

	/**
	* Returns the is default of this standards region locale.
	*
	* @return the is default of this standards region locale
	*/
	@Override
	public java.lang.String getIsDefault() {
		return _standardsRegionLocale.getIsDefault();
	}

	/**
	* Sets the is default of this standards region locale.
	*
	* @param isDefault the is default of this standards region locale
	*/
	@Override
	public void setIsDefault(java.lang.String isDefault) {
		_standardsRegionLocale.setIsDefault(isDefault);
	}

	/**
	* Returns the creator ID of this standards region locale.
	*
	* @return the creator ID of this standards region locale
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _standardsRegionLocale.getCreatorId();
	}

	/**
	* Sets the creator ID of this standards region locale.
	*
	* @param creatorId the creator ID of this standards region locale
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_standardsRegionLocale.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this standards region locale.
	*
	* @return the created date of this standards region locale
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _standardsRegionLocale.getCreatedDate();
	}

	/**
	* Sets the created date of this standards region locale.
	*
	* @param createdDate the created date of this standards region locale
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_standardsRegionLocale.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this standards region locale.
	*
	* @return the updated by of this standards region locale
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _standardsRegionLocale.getUpdatedBy();
	}

	/**
	* Sets the updated by of this standards region locale.
	*
	* @param updatedBy the updated by of this standards region locale
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_standardsRegionLocale.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this standards region locale.
	*
	* @return the updated date of this standards region locale
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _standardsRegionLocale.getUpdatedDate();
	}

	/**
	* Sets the updated date of this standards region locale.
	*
	* @param updatedDate the updated date of this standards region locale
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_standardsRegionLocale.setUpdatedDate(updatedDate);
	}

	@Override
	public boolean isNew() {
		return _standardsRegionLocale.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_standardsRegionLocale.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _standardsRegionLocale.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_standardsRegionLocale.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _standardsRegionLocale.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _standardsRegionLocale.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_standardsRegionLocale.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _standardsRegionLocale.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_standardsRegionLocale.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_standardsRegionLocale.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_standardsRegionLocale.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new StandardsRegionLocaleWrapper((StandardsRegionLocale)_standardsRegionLocale.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.StandardsRegionLocale standardsRegionLocale) {
		return _standardsRegionLocale.compareTo(standardsRegionLocale);
	}

	@Override
	public int hashCode() {
		return _standardsRegionLocale.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.StandardsRegionLocale> toCacheModel() {
		return _standardsRegionLocale.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.StandardsRegionLocale toEscapedModel() {
		return new StandardsRegionLocaleWrapper(_standardsRegionLocale.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.StandardsRegionLocale toUnescapedModel() {
		return new StandardsRegionLocaleWrapper(_standardsRegionLocale.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _standardsRegionLocale.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _standardsRegionLocale.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_standardsRegionLocale.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StandardsRegionLocaleWrapper)) {
			return false;
		}

		StandardsRegionLocaleWrapper standardsRegionLocaleWrapper = (StandardsRegionLocaleWrapper)obj;

		if (Validator.equals(_standardsRegionLocale,
					standardsRegionLocaleWrapper._standardsRegionLocale)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public StandardsRegionLocale getWrappedStandardsRegionLocale() {
		return _standardsRegionLocale;
	}

	@Override
	public StandardsRegionLocale getWrappedModel() {
		return _standardsRegionLocale;
	}

	@Override
	public void resetOriginalValues() {
		_standardsRegionLocale.resetOriginalValues();
	}

	private StandardsRegionLocale _standardsRegionLocale;
}