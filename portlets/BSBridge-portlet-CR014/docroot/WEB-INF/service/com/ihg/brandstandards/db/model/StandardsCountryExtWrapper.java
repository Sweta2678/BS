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
 * This class is a wrapper for {@link StandardsCountryExt}.
 * </p>
 *
 * @author Mummanedi
 * @see StandardsCountryExt
 * @generated
 */
public class StandardsCountryExtWrapper implements StandardsCountryExt,
	ModelWrapper<StandardsCountryExt> {
	public StandardsCountryExtWrapper(StandardsCountryExt standardsCountryExt) {
		_standardsCountryExt = standardsCountryExt;
	}

	@Override
	public Class<?> getModelClass() {
		return StandardsCountryExt.class;
	}

	@Override
	public String getModelClassName() {
		return StandardsCountryExt.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("rowNum", getRowNum());
		attributes.put("countryCode", getCountryCode());
		attributes.put("flag", getFlag());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long rowNum = (Long)attributes.get("rowNum");

		if (rowNum != null) {
			setRowNum(rowNum);
		}

		String countryCode = (String)attributes.get("countryCode");

		if (countryCode != null) {
			setCountryCode(countryCode);
		}

		String flag = (String)attributes.get("flag");

		if (flag != null) {
			setFlag(flag);
		}
	}

	/**
	* Returns the primary key of this standards country ext.
	*
	* @return the primary key of this standards country ext
	*/
	@Override
	public long getPrimaryKey() {
		return _standardsCountryExt.getPrimaryKey();
	}

	/**
	* Sets the primary key of this standards country ext.
	*
	* @param primaryKey the primary key of this standards country ext
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_standardsCountryExt.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the row num of this standards country ext.
	*
	* @return the row num of this standards country ext
	*/
	@Override
	public long getRowNum() {
		return _standardsCountryExt.getRowNum();
	}

	/**
	* Sets the row num of this standards country ext.
	*
	* @param rowNum the row num of this standards country ext
	*/
	@Override
	public void setRowNum(long rowNum) {
		_standardsCountryExt.setRowNum(rowNum);
	}

	/**
	* Returns the country code of this standards country ext.
	*
	* @return the country code of this standards country ext
	*/
	@Override
	public java.lang.String getCountryCode() {
		return _standardsCountryExt.getCountryCode();
	}

	/**
	* Sets the country code of this standards country ext.
	*
	* @param countryCode the country code of this standards country ext
	*/
	@Override
	public void setCountryCode(java.lang.String countryCode) {
		_standardsCountryExt.setCountryCode(countryCode);
	}

	/**
	* Returns the flag of this standards country ext.
	*
	* @return the flag of this standards country ext
	*/
	@Override
	public java.lang.String getFlag() {
		return _standardsCountryExt.getFlag();
	}

	/**
	* Sets the flag of this standards country ext.
	*
	* @param flag the flag of this standards country ext
	*/
	@Override
	public void setFlag(java.lang.String flag) {
		_standardsCountryExt.setFlag(flag);
	}

	@Override
	public boolean isNew() {
		return _standardsCountryExt.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_standardsCountryExt.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _standardsCountryExt.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_standardsCountryExt.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _standardsCountryExt.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _standardsCountryExt.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_standardsCountryExt.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _standardsCountryExt.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_standardsCountryExt.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_standardsCountryExt.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_standardsCountryExt.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new StandardsCountryExtWrapper((StandardsCountryExt)_standardsCountryExt.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.StandardsCountryExt standardsCountryExt) {
		return _standardsCountryExt.compareTo(standardsCountryExt);
	}

	@Override
	public int hashCode() {
		return _standardsCountryExt.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.StandardsCountryExt> toCacheModel() {
		return _standardsCountryExt.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.StandardsCountryExt toEscapedModel() {
		return new StandardsCountryExtWrapper(_standardsCountryExt.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.StandardsCountryExt toUnescapedModel() {
		return new StandardsCountryExtWrapper(_standardsCountryExt.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _standardsCountryExt.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _standardsCountryExt.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_standardsCountryExt.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StandardsCountryExtWrapper)) {
			return false;
		}

		StandardsCountryExtWrapper standardsCountryExtWrapper = (StandardsCountryExtWrapper)obj;

		if (Validator.equals(_standardsCountryExt,
					standardsCountryExtWrapper._standardsCountryExt)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public StandardsCountryExt getWrappedStandardsCountryExt() {
		return _standardsCountryExt;
	}

	@Override
	public StandardsCountryExt getWrappedModel() {
		return _standardsCountryExt;
	}

	@Override
	public void resetOriginalValues() {
		_standardsCountryExt.resetOriginalValues();
	}

	private StandardsCountryExt _standardsCountryExt;
}