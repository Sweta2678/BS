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
 * This class is a wrapper for {@link StandardsCountryChain}.
 * </p>
 *
 * @author Mummanedi
 * @see StandardsCountryChain
 * @generated
 */
public class StandardsCountryChainWrapper implements StandardsCountryChain,
	ModelWrapper<StandardsCountryChain> {
	public StandardsCountryChainWrapper(
		StandardsCountryChain standardsCountryChain) {
		_standardsCountryChain = standardsCountryChain;
	}

	@Override
	public Class<?> getModelClass() {
		return StandardsCountryChain.class;
	}

	@Override
	public String getModelClassName() {
		return StandardsCountryChain.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("stdId", getStdId());
		attributes.put("countryCode", getCountryCode());
		attributes.put("chainCode", getChainCode());
		attributes.put("regionCode", getRegionCode());
		attributes.put("compDate", getCompDate());
		attributes.put("exprDate", getExprDate());
		attributes.put("expiredIds", getExpiredIds());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long stdId = (Long)attributes.get("stdId");

		if (stdId != null) {
			setStdId(stdId);
		}

		String countryCode = (String)attributes.get("countryCode");

		if (countryCode != null) {
			setCountryCode(countryCode);
		}

		String chainCode = (String)attributes.get("chainCode");

		if (chainCode != null) {
			setChainCode(chainCode);
		}

		String regionCode = (String)attributes.get("regionCode");

		if (regionCode != null) {
			setRegionCode(regionCode);
		}

		Date compDate = (Date)attributes.get("compDate");

		if (compDate != null) {
			setCompDate(compDate);
		}

		Date exprDate = (Date)attributes.get("exprDate");

		if (exprDate != null) {
			setExprDate(exprDate);
		}

		String expiredIds = (String)attributes.get("expiredIds");

		if (expiredIds != null) {
			setExpiredIds(expiredIds);
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
	* Returns the primary key of this standards country chain.
	*
	* @return the primary key of this standards country chain
	*/
	@Override
	public com.ihg.brandstandards.db.service.persistence.StandardsCountryChainPK getPrimaryKey() {
		return _standardsCountryChain.getPrimaryKey();
	}

	/**
	* Sets the primary key of this standards country chain.
	*
	* @param primaryKey the primary key of this standards country chain
	*/
	@Override
	public void setPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.StandardsCountryChainPK primaryKey) {
		_standardsCountryChain.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the std ID of this standards country chain.
	*
	* @return the std ID of this standards country chain
	*/
	@Override
	public long getStdId() {
		return _standardsCountryChain.getStdId();
	}

	/**
	* Sets the std ID of this standards country chain.
	*
	* @param stdId the std ID of this standards country chain
	*/
	@Override
	public void setStdId(long stdId) {
		_standardsCountryChain.setStdId(stdId);
	}

	/**
	* Returns the country code of this standards country chain.
	*
	* @return the country code of this standards country chain
	*/
	@Override
	public java.lang.String getCountryCode() {
		return _standardsCountryChain.getCountryCode();
	}

	/**
	* Sets the country code of this standards country chain.
	*
	* @param countryCode the country code of this standards country chain
	*/
	@Override
	public void setCountryCode(java.lang.String countryCode) {
		_standardsCountryChain.setCountryCode(countryCode);
	}

	/**
	* Returns the chain code of this standards country chain.
	*
	* @return the chain code of this standards country chain
	*/
	@Override
	public java.lang.String getChainCode() {
		return _standardsCountryChain.getChainCode();
	}

	/**
	* Sets the chain code of this standards country chain.
	*
	* @param chainCode the chain code of this standards country chain
	*/
	@Override
	public void setChainCode(java.lang.String chainCode) {
		_standardsCountryChain.setChainCode(chainCode);
	}

	/**
	* Returns the region code of this standards country chain.
	*
	* @return the region code of this standards country chain
	*/
	@Override
	public java.lang.String getRegionCode() {
		return _standardsCountryChain.getRegionCode();
	}

	/**
	* Sets the region code of this standards country chain.
	*
	* @param regionCode the region code of this standards country chain
	*/
	@Override
	public void setRegionCode(java.lang.String regionCode) {
		_standardsCountryChain.setRegionCode(regionCode);
	}

	/**
	* Returns the comp date of this standards country chain.
	*
	* @return the comp date of this standards country chain
	*/
	@Override
	public java.util.Date getCompDate() {
		return _standardsCountryChain.getCompDate();
	}

	/**
	* Sets the comp date of this standards country chain.
	*
	* @param compDate the comp date of this standards country chain
	*/
	@Override
	public void setCompDate(java.util.Date compDate) {
		_standardsCountryChain.setCompDate(compDate);
	}

	/**
	* Returns the expr date of this standards country chain.
	*
	* @return the expr date of this standards country chain
	*/
	@Override
	public java.util.Date getExprDate() {
		return _standardsCountryChain.getExprDate();
	}

	/**
	* Sets the expr date of this standards country chain.
	*
	* @param exprDate the expr date of this standards country chain
	*/
	@Override
	public void setExprDate(java.util.Date exprDate) {
		_standardsCountryChain.setExprDate(exprDate);
	}

	/**
	* Returns the expired IDs of this standards country chain.
	*
	* @return the expired IDs of this standards country chain
	*/
	@Override
	public java.lang.String getExpiredIds() {
		return _standardsCountryChain.getExpiredIds();
	}

	/**
	* Sets the expired IDs of this standards country chain.
	*
	* @param expiredIds the expired IDs of this standards country chain
	*/
	@Override
	public void setExpiredIds(java.lang.String expiredIds) {
		_standardsCountryChain.setExpiredIds(expiredIds);
	}

	/**
	* Returns the creator ID of this standards country chain.
	*
	* @return the creator ID of this standards country chain
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _standardsCountryChain.getCreatorId();
	}

	/**
	* Sets the creator ID of this standards country chain.
	*
	* @param creatorId the creator ID of this standards country chain
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_standardsCountryChain.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this standards country chain.
	*
	* @return the created date of this standards country chain
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _standardsCountryChain.getCreatedDate();
	}

	/**
	* Sets the created date of this standards country chain.
	*
	* @param createdDate the created date of this standards country chain
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_standardsCountryChain.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this standards country chain.
	*
	* @return the updated by of this standards country chain
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _standardsCountryChain.getUpdatedBy();
	}

	/**
	* Sets the updated by of this standards country chain.
	*
	* @param updatedBy the updated by of this standards country chain
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_standardsCountryChain.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this standards country chain.
	*
	* @return the updated date of this standards country chain
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _standardsCountryChain.getUpdatedDate();
	}

	/**
	* Sets the updated date of this standards country chain.
	*
	* @param updatedDate the updated date of this standards country chain
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_standardsCountryChain.setUpdatedDate(updatedDate);
	}

	@Override
	public boolean isNew() {
		return _standardsCountryChain.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_standardsCountryChain.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _standardsCountryChain.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_standardsCountryChain.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _standardsCountryChain.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _standardsCountryChain.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_standardsCountryChain.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _standardsCountryChain.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_standardsCountryChain.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_standardsCountryChain.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_standardsCountryChain.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new StandardsCountryChainWrapper((StandardsCountryChain)_standardsCountryChain.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.StandardsCountryChain standardsCountryChain) {
		return _standardsCountryChain.compareTo(standardsCountryChain);
	}

	@Override
	public int hashCode() {
		return _standardsCountryChain.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.StandardsCountryChain> toCacheModel() {
		return _standardsCountryChain.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.StandardsCountryChain toEscapedModel() {
		return new StandardsCountryChainWrapper(_standardsCountryChain.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.StandardsCountryChain toUnescapedModel() {
		return new StandardsCountryChainWrapper(_standardsCountryChain.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _standardsCountryChain.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _standardsCountryChain.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_standardsCountryChain.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StandardsCountryChainWrapper)) {
			return false;
		}

		StandardsCountryChainWrapper standardsCountryChainWrapper = (StandardsCountryChainWrapper)obj;

		if (Validator.equals(_standardsCountryChain,
					standardsCountryChainWrapper._standardsCountryChain)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public StandardsCountryChain getWrappedStandardsCountryChain() {
		return _standardsCountryChain;
	}

	@Override
	public StandardsCountryChain getWrappedModel() {
		return _standardsCountryChain;
	}

	@Override
	public void resetOriginalValues() {
		_standardsCountryChain.resetOriginalValues();
	}

	private StandardsCountryChain _standardsCountryChain;
}