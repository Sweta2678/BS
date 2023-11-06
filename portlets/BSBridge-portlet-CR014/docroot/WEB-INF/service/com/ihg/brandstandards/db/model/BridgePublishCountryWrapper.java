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
 * This class is a wrapper for {@link BridgePublishCountry}.
 * </p>
 *
 * @author Mummanedi
 * @see BridgePublishCountry
 * @generated
 */
public class BridgePublishCountryWrapper implements BridgePublishCountry,
	ModelWrapper<BridgePublishCountry> {
	public BridgePublishCountryWrapper(
		BridgePublishCountry bridgePublishCountry) {
		_bridgePublishCountry = bridgePublishCountry;
	}

	@Override
	public Class<?> getModelClass() {
		return BridgePublishCountry.class;
	}

	@Override
	public String getModelClassName() {
		return BridgePublishCountry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("publishCtryId", getPublishCtryId());
		attributes.put("bridgePublishId", getBridgePublishId());
		attributes.put("countryCode", getCountryCode());
		attributes.put("statusCode", getStatusCode());
		attributes.put("publishInd", getPublishInd());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long publishCtryId = (Long)attributes.get("publishCtryId");

		if (publishCtryId != null) {
			setPublishCtryId(publishCtryId);
		}

		Long bridgePublishId = (Long)attributes.get("bridgePublishId");

		if (bridgePublishId != null) {
			setBridgePublishId(bridgePublishId);
		}

		String countryCode = (String)attributes.get("countryCode");

		if (countryCode != null) {
			setCountryCode(countryCode);
		}

		String statusCode = (String)attributes.get("statusCode");

		if (statusCode != null) {
			setStatusCode(statusCode);
		}

		String publishInd = (String)attributes.get("publishInd");

		if (publishInd != null) {
			setPublishInd(publishInd);
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
	* Returns the primary key of this bridge publish country.
	*
	* @return the primary key of this bridge publish country
	*/
	@Override
	public long getPrimaryKey() {
		return _bridgePublishCountry.getPrimaryKey();
	}

	/**
	* Sets the primary key of this bridge publish country.
	*
	* @param primaryKey the primary key of this bridge publish country
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_bridgePublishCountry.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the publish ctry ID of this bridge publish country.
	*
	* @return the publish ctry ID of this bridge publish country
	*/
	@Override
	public long getPublishCtryId() {
		return _bridgePublishCountry.getPublishCtryId();
	}

	/**
	* Sets the publish ctry ID of this bridge publish country.
	*
	* @param publishCtryId the publish ctry ID of this bridge publish country
	*/
	@Override
	public void setPublishCtryId(long publishCtryId) {
		_bridgePublishCountry.setPublishCtryId(publishCtryId);
	}

	/**
	* Returns the bridge publish ID of this bridge publish country.
	*
	* @return the bridge publish ID of this bridge publish country
	*/
	@Override
	public long getBridgePublishId() {
		return _bridgePublishCountry.getBridgePublishId();
	}

	/**
	* Sets the bridge publish ID of this bridge publish country.
	*
	* @param bridgePublishId the bridge publish ID of this bridge publish country
	*/
	@Override
	public void setBridgePublishId(long bridgePublishId) {
		_bridgePublishCountry.setBridgePublishId(bridgePublishId);
	}

	/**
	* Returns the country code of this bridge publish country.
	*
	* @return the country code of this bridge publish country
	*/
	@Override
	public java.lang.String getCountryCode() {
		return _bridgePublishCountry.getCountryCode();
	}

	/**
	* Sets the country code of this bridge publish country.
	*
	* @param countryCode the country code of this bridge publish country
	*/
	@Override
	public void setCountryCode(java.lang.String countryCode) {
		_bridgePublishCountry.setCountryCode(countryCode);
	}

	/**
	* Returns the status code of this bridge publish country.
	*
	* @return the status code of this bridge publish country
	*/
	@Override
	public java.lang.String getStatusCode() {
		return _bridgePublishCountry.getStatusCode();
	}

	/**
	* Sets the status code of this bridge publish country.
	*
	* @param statusCode the status code of this bridge publish country
	*/
	@Override
	public void setStatusCode(java.lang.String statusCode) {
		_bridgePublishCountry.setStatusCode(statusCode);
	}

	/**
	* Returns the publish ind of this bridge publish country.
	*
	* @return the publish ind of this bridge publish country
	*/
	@Override
	public java.lang.String getPublishInd() {
		return _bridgePublishCountry.getPublishInd();
	}

	/**
	* Sets the publish ind of this bridge publish country.
	*
	* @param publishInd the publish ind of this bridge publish country
	*/
	@Override
	public void setPublishInd(java.lang.String publishInd) {
		_bridgePublishCountry.setPublishInd(publishInd);
	}

	/**
	* Returns the creator ID of this bridge publish country.
	*
	* @return the creator ID of this bridge publish country
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _bridgePublishCountry.getCreatorId();
	}

	/**
	* Sets the creator ID of this bridge publish country.
	*
	* @param creatorId the creator ID of this bridge publish country
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_bridgePublishCountry.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this bridge publish country.
	*
	* @return the created date of this bridge publish country
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _bridgePublishCountry.getCreatedDate();
	}

	/**
	* Sets the created date of this bridge publish country.
	*
	* @param createdDate the created date of this bridge publish country
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_bridgePublishCountry.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this bridge publish country.
	*
	* @return the updated by of this bridge publish country
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _bridgePublishCountry.getUpdatedBy();
	}

	/**
	* Sets the updated by of this bridge publish country.
	*
	* @param updatedBy the updated by of this bridge publish country
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_bridgePublishCountry.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this bridge publish country.
	*
	* @return the updated date of this bridge publish country
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _bridgePublishCountry.getUpdatedDate();
	}

	/**
	* Sets the updated date of this bridge publish country.
	*
	* @param updatedDate the updated date of this bridge publish country
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_bridgePublishCountry.setUpdatedDate(updatedDate);
	}

	@Override
	public boolean isNew() {
		return _bridgePublishCountry.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_bridgePublishCountry.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _bridgePublishCountry.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_bridgePublishCountry.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _bridgePublishCountry.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _bridgePublishCountry.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_bridgePublishCountry.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _bridgePublishCountry.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_bridgePublishCountry.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_bridgePublishCountry.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_bridgePublishCountry.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BridgePublishCountryWrapper((BridgePublishCountry)_bridgePublishCountry.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.BridgePublishCountry bridgePublishCountry) {
		return _bridgePublishCountry.compareTo(bridgePublishCountry);
	}

	@Override
	public int hashCode() {
		return _bridgePublishCountry.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.BridgePublishCountry> toCacheModel() {
		return _bridgePublishCountry.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.BridgePublishCountry toEscapedModel() {
		return new BridgePublishCountryWrapper(_bridgePublishCountry.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.BridgePublishCountry toUnescapedModel() {
		return new BridgePublishCountryWrapper(_bridgePublishCountry.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _bridgePublishCountry.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _bridgePublishCountry.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_bridgePublishCountry.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BridgePublishCountryWrapper)) {
			return false;
		}

		BridgePublishCountryWrapper bridgePublishCountryWrapper = (BridgePublishCountryWrapper)obj;

		if (Validator.equals(_bridgePublishCountry,
					bridgePublishCountryWrapper._bridgePublishCountry)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public BridgePublishCountry getWrappedBridgePublishCountry() {
		return _bridgePublishCountry;
	}

	@Override
	public BridgePublishCountry getWrappedModel() {
		return _bridgePublishCountry;
	}

	@Override
	public void resetOriginalValues() {
		_bridgePublishCountry.resetOriginalValues();
	}

	private BridgePublishCountry _bridgePublishCountry;
}