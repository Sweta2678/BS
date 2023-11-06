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
 * This class is a wrapper for {@link BridgePublishCountryStateEx}.
 * </p>
 *
 * @author Mummanedi
 * @see BridgePublishCountryStateEx
 * @generated
 */
public class BridgePublishCountryStateExWrapper
	implements BridgePublishCountryStateEx,
		ModelWrapper<BridgePublishCountryStateEx> {
	public BridgePublishCountryStateExWrapper(
		BridgePublishCountryStateEx bridgePublishCountryStateEx) {
		_bridgePublishCountryStateEx = bridgePublishCountryStateEx;
	}

	@Override
	public Class<?> getModelClass() {
		return BridgePublishCountryStateEx.class;
	}

	@Override
	public String getModelClassName() {
		return BridgePublishCountryStateEx.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("stdId", getStdId());
		attributes.put("CountryCode", getCountryCode());
		attributes.put("parentStdId", getParentStdId());
		attributes.put("type", getType());
		attributes.put("publishId", getPublishId());
		attributes.put("stateCd", getStateCd());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long stdId = (Long)attributes.get("stdId");

		if (stdId != null) {
			setStdId(stdId);
		}

		String CountryCode = (String)attributes.get("CountryCode");

		if (CountryCode != null) {
			setCountryCode(CountryCode);
		}

		Long parentStdId = (Long)attributes.get("parentStdId");

		if (parentStdId != null) {
			setParentStdId(parentStdId);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		Long publishId = (Long)attributes.get("publishId");

		if (publishId != null) {
			setPublishId(publishId);
		}

		String stateCd = (String)attributes.get("stateCd");

		if (stateCd != null) {
			setStateCd(stateCd);
		}
	}

	/**
	* Returns the primary key of this bridge publish country state ex.
	*
	* @return the primary key of this bridge publish country state ex
	*/
	@Override
	public com.ihg.brandstandards.db.service.persistence.BridgePublishCountryStateExPK getPrimaryKey() {
		return _bridgePublishCountryStateEx.getPrimaryKey();
	}

	/**
	* Sets the primary key of this bridge publish country state ex.
	*
	* @param primaryKey the primary key of this bridge publish country state ex
	*/
	@Override
	public void setPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.BridgePublishCountryStateExPK primaryKey) {
		_bridgePublishCountryStateEx.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the std ID of this bridge publish country state ex.
	*
	* @return the std ID of this bridge publish country state ex
	*/
	@Override
	public long getStdId() {
		return _bridgePublishCountryStateEx.getStdId();
	}

	/**
	* Sets the std ID of this bridge publish country state ex.
	*
	* @param stdId the std ID of this bridge publish country state ex
	*/
	@Override
	public void setStdId(long stdId) {
		_bridgePublishCountryStateEx.setStdId(stdId);
	}

	/**
	* Returns the country code of this bridge publish country state ex.
	*
	* @return the country code of this bridge publish country state ex
	*/
	@Override
	public java.lang.String getCountryCode() {
		return _bridgePublishCountryStateEx.getCountryCode();
	}

	/**
	* Sets the country code of this bridge publish country state ex.
	*
	* @param CountryCode the country code of this bridge publish country state ex
	*/
	@Override
	public void setCountryCode(java.lang.String CountryCode) {
		_bridgePublishCountryStateEx.setCountryCode(CountryCode);
	}

	/**
	* Returns the parent std ID of this bridge publish country state ex.
	*
	* @return the parent std ID of this bridge publish country state ex
	*/
	@Override
	public long getParentStdId() {
		return _bridgePublishCountryStateEx.getParentStdId();
	}

	/**
	* Sets the parent std ID of this bridge publish country state ex.
	*
	* @param parentStdId the parent std ID of this bridge publish country state ex
	*/
	@Override
	public void setParentStdId(long parentStdId) {
		_bridgePublishCountryStateEx.setParentStdId(parentStdId);
	}

	/**
	* Returns the type of this bridge publish country state ex.
	*
	* @return the type of this bridge publish country state ex
	*/
	@Override
	public java.lang.String getType() {
		return _bridgePublishCountryStateEx.getType();
	}

	/**
	* Sets the type of this bridge publish country state ex.
	*
	* @param type the type of this bridge publish country state ex
	*/
	@Override
	public void setType(java.lang.String type) {
		_bridgePublishCountryStateEx.setType(type);
	}

	/**
	* Returns the publish ID of this bridge publish country state ex.
	*
	* @return the publish ID of this bridge publish country state ex
	*/
	@Override
	public long getPublishId() {
		return _bridgePublishCountryStateEx.getPublishId();
	}

	/**
	* Sets the publish ID of this bridge publish country state ex.
	*
	* @param publishId the publish ID of this bridge publish country state ex
	*/
	@Override
	public void setPublishId(long publishId) {
		_bridgePublishCountryStateEx.setPublishId(publishId);
	}

	/**
	* Returns the state cd of this bridge publish country state ex.
	*
	* @return the state cd of this bridge publish country state ex
	*/
	@Override
	public java.lang.String getStateCd() {
		return _bridgePublishCountryStateEx.getStateCd();
	}

	/**
	* Sets the state cd of this bridge publish country state ex.
	*
	* @param stateCd the state cd of this bridge publish country state ex
	*/
	@Override
	public void setStateCd(java.lang.String stateCd) {
		_bridgePublishCountryStateEx.setStateCd(stateCd);
	}

	@Override
	public boolean isNew() {
		return _bridgePublishCountryStateEx.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_bridgePublishCountryStateEx.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _bridgePublishCountryStateEx.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_bridgePublishCountryStateEx.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _bridgePublishCountryStateEx.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _bridgePublishCountryStateEx.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_bridgePublishCountryStateEx.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _bridgePublishCountryStateEx.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_bridgePublishCountryStateEx.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_bridgePublishCountryStateEx.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_bridgePublishCountryStateEx.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BridgePublishCountryStateExWrapper((BridgePublishCountryStateEx)_bridgePublishCountryStateEx.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.BridgePublishCountryStateEx bridgePublishCountryStateEx) {
		return _bridgePublishCountryStateEx.compareTo(bridgePublishCountryStateEx);
	}

	@Override
	public int hashCode() {
		return _bridgePublishCountryStateEx.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.BridgePublishCountryStateEx> toCacheModel() {
		return _bridgePublishCountryStateEx.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.BridgePublishCountryStateEx toEscapedModel() {
		return new BridgePublishCountryStateExWrapper(_bridgePublishCountryStateEx.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.BridgePublishCountryStateEx toUnescapedModel() {
		return new BridgePublishCountryStateExWrapper(_bridgePublishCountryStateEx.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _bridgePublishCountryStateEx.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _bridgePublishCountryStateEx.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_bridgePublishCountryStateEx.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BridgePublishCountryStateExWrapper)) {
			return false;
		}

		BridgePublishCountryStateExWrapper bridgePublishCountryStateExWrapper = (BridgePublishCountryStateExWrapper)obj;

		if (Validator.equals(_bridgePublishCountryStateEx,
					bridgePublishCountryStateExWrapper._bridgePublishCountryStateEx)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public BridgePublishCountryStateEx getWrappedBridgePublishCountryStateEx() {
		return _bridgePublishCountryStateEx;
	}

	@Override
	public BridgePublishCountryStateEx getWrappedModel() {
		return _bridgePublishCountryStateEx;
	}

	@Override
	public void resetOriginalValues() {
		_bridgePublishCountryStateEx.resetOriginalValues();
	}

	private BridgePublishCountryStateEx _bridgePublishCountryStateEx;
}