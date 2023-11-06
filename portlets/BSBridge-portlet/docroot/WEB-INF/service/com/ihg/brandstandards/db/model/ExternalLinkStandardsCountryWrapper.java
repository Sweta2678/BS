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
 * This class is a wrapper for {@link ExternalLinkStandardsCountry}.
 * </p>
 *
 * @author Mummanedi
 * @see ExternalLinkStandardsCountry
 * @generated
 */
public class ExternalLinkStandardsCountryWrapper
	implements ExternalLinkStandardsCountry,
		ModelWrapper<ExternalLinkStandardsCountry> {
	public ExternalLinkStandardsCountryWrapper(
		ExternalLinkStandardsCountry externalLinkStandardsCountry) {
		_externalLinkStandardsCountry = externalLinkStandardsCountry;
	}

	@Override
	public Class<?> getModelClass() {
		return ExternalLinkStandardsCountry.class;
	}

	@Override
	public String getModelClassName() {
		return ExternalLinkStandardsCountry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("extLinkId", getExtLinkId());
		attributes.put("countryCode", getCountryCode());
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

		String countryCode = (String)attributes.get("countryCode");

		if (countryCode != null) {
			setCountryCode(countryCode);
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
	* Returns the primary key of this external link standards country.
	*
	* @return the primary key of this external link standards country
	*/
	@Override
	public com.ihg.brandstandards.db.service.persistence.ExternalLinkStandardsCountryPK getPrimaryKey() {
		return _externalLinkStandardsCountry.getPrimaryKey();
	}

	/**
	* Sets the primary key of this external link standards country.
	*
	* @param primaryKey the primary key of this external link standards country
	*/
	@Override
	public void setPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.ExternalLinkStandardsCountryPK primaryKey) {
		_externalLinkStandardsCountry.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ext link ID of this external link standards country.
	*
	* @return the ext link ID of this external link standards country
	*/
	@Override
	public long getExtLinkId() {
		return _externalLinkStandardsCountry.getExtLinkId();
	}

	/**
	* Sets the ext link ID of this external link standards country.
	*
	* @param extLinkId the ext link ID of this external link standards country
	*/
	@Override
	public void setExtLinkId(long extLinkId) {
		_externalLinkStandardsCountry.setExtLinkId(extLinkId);
	}

	/**
	* Returns the country code of this external link standards country.
	*
	* @return the country code of this external link standards country
	*/
	@Override
	public java.lang.String getCountryCode() {
		return _externalLinkStandardsCountry.getCountryCode();
	}

	/**
	* Sets the country code of this external link standards country.
	*
	* @param countryCode the country code of this external link standards country
	*/
	@Override
	public void setCountryCode(java.lang.String countryCode) {
		_externalLinkStandardsCountry.setCountryCode(countryCode);
	}

	/**
	* Returns the creator ID of this external link standards country.
	*
	* @return the creator ID of this external link standards country
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _externalLinkStandardsCountry.getCreatorId();
	}

	/**
	* Sets the creator ID of this external link standards country.
	*
	* @param creatorId the creator ID of this external link standards country
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_externalLinkStandardsCountry.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this external link standards country.
	*
	* @return the created date of this external link standards country
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _externalLinkStandardsCountry.getCreatedDate();
	}

	/**
	* Sets the created date of this external link standards country.
	*
	* @param createdDate the created date of this external link standards country
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_externalLinkStandardsCountry.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this external link standards country.
	*
	* @return the updated by of this external link standards country
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _externalLinkStandardsCountry.getUpdatedBy();
	}

	/**
	* Sets the updated by of this external link standards country.
	*
	* @param updatedBy the updated by of this external link standards country
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_externalLinkStandardsCountry.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this external link standards country.
	*
	* @return the updated date of this external link standards country
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _externalLinkStandardsCountry.getUpdatedDate();
	}

	/**
	* Sets the updated date of this external link standards country.
	*
	* @param updatedDate the updated date of this external link standards country
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_externalLinkStandardsCountry.setUpdatedDate(updatedDate);
	}

	@Override
	public boolean isNew() {
		return _externalLinkStandardsCountry.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_externalLinkStandardsCountry.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _externalLinkStandardsCountry.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_externalLinkStandardsCountry.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _externalLinkStandardsCountry.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _externalLinkStandardsCountry.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_externalLinkStandardsCountry.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _externalLinkStandardsCountry.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_externalLinkStandardsCountry.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_externalLinkStandardsCountry.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_externalLinkStandardsCountry.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ExternalLinkStandardsCountryWrapper((ExternalLinkStandardsCountry)_externalLinkStandardsCountry.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.ExternalLinkStandardsCountry externalLinkStandardsCountry) {
		return _externalLinkStandardsCountry.compareTo(externalLinkStandardsCountry);
	}

	@Override
	public int hashCode() {
		return _externalLinkStandardsCountry.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.ExternalLinkStandardsCountry> toCacheModel() {
		return _externalLinkStandardsCountry.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.ExternalLinkStandardsCountry toEscapedModel() {
		return new ExternalLinkStandardsCountryWrapper(_externalLinkStandardsCountry.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.ExternalLinkStandardsCountry toUnescapedModel() {
		return new ExternalLinkStandardsCountryWrapper(_externalLinkStandardsCountry.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _externalLinkStandardsCountry.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _externalLinkStandardsCountry.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_externalLinkStandardsCountry.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ExternalLinkStandardsCountryWrapper)) {
			return false;
		}

		ExternalLinkStandardsCountryWrapper externalLinkStandardsCountryWrapper = (ExternalLinkStandardsCountryWrapper)obj;

		if (Validator.equals(_externalLinkStandardsCountry,
					externalLinkStandardsCountryWrapper._externalLinkStandardsCountry)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ExternalLinkStandardsCountry getWrappedExternalLinkStandardsCountry() {
		return _externalLinkStandardsCountry;
	}

	@Override
	public ExternalLinkStandardsCountry getWrappedModel() {
		return _externalLinkStandardsCountry;
	}

	@Override
	public void resetOriginalValues() {
		_externalLinkStandardsCountry.resetOriginalValues();
	}

	private ExternalLinkStandardsCountry _externalLinkStandardsCountry;
}