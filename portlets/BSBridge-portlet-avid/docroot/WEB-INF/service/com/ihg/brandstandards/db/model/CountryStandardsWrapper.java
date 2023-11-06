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
 * This class is a wrapper for {@link CountryStandards}.
 * </p>
 *
 * @author Mummanedi
 * @see CountryStandards
 * @generated
 */
public class CountryStandardsWrapper implements CountryStandards,
	ModelWrapper<CountryStandards> {
	public CountryStandardsWrapper(CountryStandards countryStandards) {
		_countryStandards = countryStandards;
	}

	@Override
	public Class<?> getModelClass() {
		return CountryStandards.class;
	}

	@Override
	public String getModelClassName() {
		return CountryStandards.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("country", getCountry());
		attributes.put("stdId", getStdId());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String country = (String)attributes.get("country");

		if (country != null) {
			setCountry(country);
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
	* Returns the primary key of this country standards.
	*
	* @return the primary key of this country standards
	*/
	@Override
	public com.ihg.brandstandards.db.service.persistence.CountryStandardsPK getPrimaryKey() {
		return _countryStandards.getPrimaryKey();
	}

	/**
	* Sets the primary key of this country standards.
	*
	* @param primaryKey the primary key of this country standards
	*/
	@Override
	public void setPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.CountryStandardsPK primaryKey) {
		_countryStandards.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the country of this country standards.
	*
	* @return the country of this country standards
	*/
	@Override
	public java.lang.String getCountry() {
		return _countryStandards.getCountry();
	}

	/**
	* Sets the country of this country standards.
	*
	* @param country the country of this country standards
	*/
	@Override
	public void setCountry(java.lang.String country) {
		_countryStandards.setCountry(country);
	}

	/**
	* Returns the std ID of this country standards.
	*
	* @return the std ID of this country standards
	*/
	@Override
	public long getStdId() {
		return _countryStandards.getStdId();
	}

	/**
	* Sets the std ID of this country standards.
	*
	* @param stdId the std ID of this country standards
	*/
	@Override
	public void setStdId(long stdId) {
		_countryStandards.setStdId(stdId);
	}

	/**
	* Returns the creator ID of this country standards.
	*
	* @return the creator ID of this country standards
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _countryStandards.getCreatorId();
	}

	/**
	* Sets the creator ID of this country standards.
	*
	* @param creatorId the creator ID of this country standards
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_countryStandards.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this country standards.
	*
	* @return the created date of this country standards
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _countryStandards.getCreatedDate();
	}

	/**
	* Sets the created date of this country standards.
	*
	* @param createdDate the created date of this country standards
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_countryStandards.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this country standards.
	*
	* @return the updated by of this country standards
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _countryStandards.getUpdatedBy();
	}

	/**
	* Sets the updated by of this country standards.
	*
	* @param updatedBy the updated by of this country standards
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_countryStandards.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this country standards.
	*
	* @return the updated date of this country standards
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _countryStandards.getUpdatedDate();
	}

	/**
	* Sets the updated date of this country standards.
	*
	* @param updatedDate the updated date of this country standards
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_countryStandards.setUpdatedDate(updatedDate);
	}

	@Override
	public boolean isNew() {
		return _countryStandards.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_countryStandards.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _countryStandards.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_countryStandards.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _countryStandards.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _countryStandards.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_countryStandards.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _countryStandards.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_countryStandards.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_countryStandards.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_countryStandards.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CountryStandardsWrapper((CountryStandards)_countryStandards.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.CountryStandards countryStandards) {
		return _countryStandards.compareTo(countryStandards);
	}

	@Override
	public int hashCode() {
		return _countryStandards.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.CountryStandards> toCacheModel() {
		return _countryStandards.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.CountryStandards toEscapedModel() {
		return new CountryStandardsWrapper(_countryStandards.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.CountryStandards toUnescapedModel() {
		return new CountryStandardsWrapper(_countryStandards.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _countryStandards.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _countryStandards.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_countryStandards.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CountryStandardsWrapper)) {
			return false;
		}

		CountryStandardsWrapper countryStandardsWrapper = (CountryStandardsWrapper)obj;

		if (Validator.equals(_countryStandards,
					countryStandardsWrapper._countryStandards)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public CountryStandards getWrappedCountryStandards() {
		return _countryStandards;
	}

	@Override
	public CountryStandards getWrappedModel() {
		return _countryStandards;
	}

	@Override
	public void resetOriginalValues() {
		_countryStandards.resetOriginalValues();
	}

	private CountryStandards _countryStandards;
}