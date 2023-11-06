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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CountryStandardsExt}.
 * </p>
 *
 * @author Mummanedi
 * @see CountryStandardsExt
 * @generated
 */
public class CountryStandardsExtWrapper implements CountryStandardsExt,
	ModelWrapper<CountryStandardsExt> {
	public CountryStandardsExtWrapper(CountryStandardsExt countryStandardsExt) {
		_countryStandardsExt = countryStandardsExt;
	}

	@Override
	public Class<?> getModelClass() {
		return CountryStandardsExt.class;
	}

	@Override
	public String getModelClassName() {
		return CountryStandardsExt.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("countryCode", getCountryCode());
		attributes.put("stdId", getStdId());
		attributes.put("regionId", getRegionId());
		attributes.put("regionCode", getRegionCode());
		attributes.put("regionName", getRegionName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String countryCode = (String)attributes.get("countryCode");

		if (countryCode != null) {
			setCountryCode(countryCode);
		}

		Long stdId = (Long)attributes.get("stdId");

		if (stdId != null) {
			setStdId(stdId);
		}

		Long regionId = (Long)attributes.get("regionId");

		if (regionId != null) {
			setRegionId(regionId);
		}

		String regionCode = (String)attributes.get("regionCode");

		if (regionCode != null) {
			setRegionCode(regionCode);
		}

		String regionName = (String)attributes.get("regionName");

		if (regionName != null) {
			setRegionName(regionName);
		}
	}

	/**
	* Returns the primary key of this country standards ext.
	*
	* @return the primary key of this country standards ext
	*/
	@Override
	public com.ihg.brandstandards.db.service.persistence.CountryStandardsExtPK getPrimaryKey() {
		return _countryStandardsExt.getPrimaryKey();
	}

	/**
	* Sets the primary key of this country standards ext.
	*
	* @param primaryKey the primary key of this country standards ext
	*/
	@Override
	public void setPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.CountryStandardsExtPK primaryKey) {
		_countryStandardsExt.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the country code of this country standards ext.
	*
	* @return the country code of this country standards ext
	*/
	@Override
	public java.lang.String getCountryCode() {
		return _countryStandardsExt.getCountryCode();
	}

	/**
	* Sets the country code of this country standards ext.
	*
	* @param countryCode the country code of this country standards ext
	*/
	@Override
	public void setCountryCode(java.lang.String countryCode) {
		_countryStandardsExt.setCountryCode(countryCode);
	}

	/**
	* Returns the std ID of this country standards ext.
	*
	* @return the std ID of this country standards ext
	*/
	@Override
	public long getStdId() {
		return _countryStandardsExt.getStdId();
	}

	/**
	* Sets the std ID of this country standards ext.
	*
	* @param stdId the std ID of this country standards ext
	*/
	@Override
	public void setStdId(long stdId) {
		_countryStandardsExt.setStdId(stdId);
	}

	/**
	* Returns the region ID of this country standards ext.
	*
	* @return the region ID of this country standards ext
	*/
	@Override
	public long getRegionId() {
		return _countryStandardsExt.getRegionId();
	}

	/**
	* Sets the region ID of this country standards ext.
	*
	* @param regionId the region ID of this country standards ext
	*/
	@Override
	public void setRegionId(long regionId) {
		_countryStandardsExt.setRegionId(regionId);
	}

	/**
	* Returns the region code of this country standards ext.
	*
	* @return the region code of this country standards ext
	*/
	@Override
	public java.lang.String getRegionCode() {
		return _countryStandardsExt.getRegionCode();
	}

	/**
	* Sets the region code of this country standards ext.
	*
	* @param regionCode the region code of this country standards ext
	*/
	@Override
	public void setRegionCode(java.lang.String regionCode) {
		_countryStandardsExt.setRegionCode(regionCode);
	}

	/**
	* Returns the region name of this country standards ext.
	*
	* @return the region name of this country standards ext
	*/
	@Override
	public java.lang.String getRegionName() {
		return _countryStandardsExt.getRegionName();
	}

	/**
	* Sets the region name of this country standards ext.
	*
	* @param regionName the region name of this country standards ext
	*/
	@Override
	public void setRegionName(java.lang.String regionName) {
		_countryStandardsExt.setRegionName(regionName);
	}

	@Override
	public boolean isNew() {
		return _countryStandardsExt.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_countryStandardsExt.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _countryStandardsExt.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_countryStandardsExt.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _countryStandardsExt.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _countryStandardsExt.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_countryStandardsExt.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _countryStandardsExt.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_countryStandardsExt.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_countryStandardsExt.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_countryStandardsExt.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CountryStandardsExtWrapper((CountryStandardsExt)_countryStandardsExt.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.CountryStandardsExt countryStandardsExt) {
		return _countryStandardsExt.compareTo(countryStandardsExt);
	}

	@Override
	public int hashCode() {
		return _countryStandardsExt.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.CountryStandardsExt> toCacheModel() {
		return _countryStandardsExt.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.CountryStandardsExt toEscapedModel() {
		return new CountryStandardsExtWrapper(_countryStandardsExt.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.CountryStandardsExt toUnescapedModel() {
		return new CountryStandardsExtWrapper(_countryStandardsExt.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _countryStandardsExt.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _countryStandardsExt.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_countryStandardsExt.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CountryStandardsExtWrapper)) {
			return false;
		}

		CountryStandardsExtWrapper countryStandardsExtWrapper = (CountryStandardsExtWrapper)obj;

		if (Validator.equals(_countryStandardsExt,
					countryStandardsExtWrapper._countryStandardsExt)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public CountryStandardsExt getWrappedCountryStandardsExt() {
		return _countryStandardsExt;
	}

	@Override
	public CountryStandardsExt getWrappedModel() {
		return _countryStandardsExt;
	}

	@Override
	public void resetOriginalValues() {
		_countryStandardsExt.resetOriginalValues();
	}

	private CountryStandardsExt _countryStandardsExt;
}