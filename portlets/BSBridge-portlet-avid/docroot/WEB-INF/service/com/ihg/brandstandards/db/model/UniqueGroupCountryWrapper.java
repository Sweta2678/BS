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
 * This class is a wrapper for {@link UniqueGroupCountry}.
 * </p>
 *
 * @author Mummanedi
 * @see UniqueGroupCountry
 * @generated
 */
public class UniqueGroupCountryWrapper implements UniqueGroupCountry,
	ModelWrapper<UniqueGroupCountry> {
	public UniqueGroupCountryWrapper(UniqueGroupCountry uniqueGroupCountry) {
		_uniqueGroupCountry = uniqueGroupCountry;
	}

	@Override
	public Class<?> getModelClass() {
		return UniqueGroupCountry.class;
	}

	@Override
	public String getModelClassName() {
		return UniqueGroupCountry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("groupCountryId", getGroupCountryId());
		attributes.put("uniqueGroupId", getUniqueGroupId());
		attributes.put("countryCode", getCountryCode());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long groupCountryId = (Long)attributes.get("groupCountryId");

		if (groupCountryId != null) {
			setGroupCountryId(groupCountryId);
		}

		Long uniqueGroupId = (Long)attributes.get("uniqueGroupId");

		if (uniqueGroupId != null) {
			setUniqueGroupId(uniqueGroupId);
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
	* Returns the primary key of this unique group country.
	*
	* @return the primary key of this unique group country
	*/
	@Override
	public long getPrimaryKey() {
		return _uniqueGroupCountry.getPrimaryKey();
	}

	/**
	* Sets the primary key of this unique group country.
	*
	* @param primaryKey the primary key of this unique group country
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_uniqueGroupCountry.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the group country ID of this unique group country.
	*
	* @return the group country ID of this unique group country
	*/
	@Override
	public long getGroupCountryId() {
		return _uniqueGroupCountry.getGroupCountryId();
	}

	/**
	* Sets the group country ID of this unique group country.
	*
	* @param groupCountryId the group country ID of this unique group country
	*/
	@Override
	public void setGroupCountryId(long groupCountryId) {
		_uniqueGroupCountry.setGroupCountryId(groupCountryId);
	}

	/**
	* Returns the unique group ID of this unique group country.
	*
	* @return the unique group ID of this unique group country
	*/
	@Override
	public long getUniqueGroupId() {
		return _uniqueGroupCountry.getUniqueGroupId();
	}

	/**
	* Sets the unique group ID of this unique group country.
	*
	* @param uniqueGroupId the unique group ID of this unique group country
	*/
	@Override
	public void setUniqueGroupId(long uniqueGroupId) {
		_uniqueGroupCountry.setUniqueGroupId(uniqueGroupId);
	}

	/**
	* Returns the country code of this unique group country.
	*
	* @return the country code of this unique group country
	*/
	@Override
	public java.lang.String getCountryCode() {
		return _uniqueGroupCountry.getCountryCode();
	}

	/**
	* Sets the country code of this unique group country.
	*
	* @param countryCode the country code of this unique group country
	*/
	@Override
	public void setCountryCode(java.lang.String countryCode) {
		_uniqueGroupCountry.setCountryCode(countryCode);
	}

	/**
	* Returns the creator ID of this unique group country.
	*
	* @return the creator ID of this unique group country
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _uniqueGroupCountry.getCreatorId();
	}

	/**
	* Sets the creator ID of this unique group country.
	*
	* @param creatorId the creator ID of this unique group country
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_uniqueGroupCountry.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this unique group country.
	*
	* @return the created date of this unique group country
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _uniqueGroupCountry.getCreatedDate();
	}

	/**
	* Sets the created date of this unique group country.
	*
	* @param createdDate the created date of this unique group country
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_uniqueGroupCountry.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this unique group country.
	*
	* @return the updated by of this unique group country
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _uniqueGroupCountry.getUpdatedBy();
	}

	/**
	* Sets the updated by of this unique group country.
	*
	* @param updatedBy the updated by of this unique group country
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_uniqueGroupCountry.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this unique group country.
	*
	* @return the updated date of this unique group country
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _uniqueGroupCountry.getUpdatedDate();
	}

	/**
	* Sets the updated date of this unique group country.
	*
	* @param updatedDate the updated date of this unique group country
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_uniqueGroupCountry.setUpdatedDate(updatedDate);
	}

	@Override
	public boolean isNew() {
		return _uniqueGroupCountry.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_uniqueGroupCountry.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _uniqueGroupCountry.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_uniqueGroupCountry.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _uniqueGroupCountry.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _uniqueGroupCountry.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_uniqueGroupCountry.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _uniqueGroupCountry.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_uniqueGroupCountry.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_uniqueGroupCountry.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_uniqueGroupCountry.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new UniqueGroupCountryWrapper((UniqueGroupCountry)_uniqueGroupCountry.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.UniqueGroupCountry uniqueGroupCountry) {
		return _uniqueGroupCountry.compareTo(uniqueGroupCountry);
	}

	@Override
	public int hashCode() {
		return _uniqueGroupCountry.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.UniqueGroupCountry> toCacheModel() {
		return _uniqueGroupCountry.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.UniqueGroupCountry toEscapedModel() {
		return new UniqueGroupCountryWrapper(_uniqueGroupCountry.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.UniqueGroupCountry toUnescapedModel() {
		return new UniqueGroupCountryWrapper(_uniqueGroupCountry.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _uniqueGroupCountry.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _uniqueGroupCountry.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_uniqueGroupCountry.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UniqueGroupCountryWrapper)) {
			return false;
		}

		UniqueGroupCountryWrapper uniqueGroupCountryWrapper = (UniqueGroupCountryWrapper)obj;

		if (Validator.equals(_uniqueGroupCountry,
					uniqueGroupCountryWrapper._uniqueGroupCountry)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public UniqueGroupCountry getWrappedUniqueGroupCountry() {
		return _uniqueGroupCountry;
	}

	@Override
	public UniqueGroupCountry getWrappedModel() {
		return _uniqueGroupCountry;
	}

	@Override
	public void resetOriginalValues() {
		_uniqueGroupCountry.resetOriginalValues();
	}

	private UniqueGroupCountry _uniqueGroupCountry;
}