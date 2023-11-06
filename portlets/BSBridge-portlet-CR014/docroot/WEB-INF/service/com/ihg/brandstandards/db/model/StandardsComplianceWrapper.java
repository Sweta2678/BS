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
 * This class is a wrapper for {@link StandardsCompliance}.
 * </p>
 *
 * @author Mummanedi
 * @see StandardsCompliance
 * @generated
 */
public class StandardsComplianceWrapper implements StandardsCompliance,
	ModelWrapper<StandardsCompliance> {
	public StandardsComplianceWrapper(StandardsCompliance standardsCompliance) {
		_standardsCompliance = standardsCompliance;
	}

	@Override
	public Class<?> getModelClass() {
		return StandardsCompliance.class;
	}

	@Override
	public String getModelClassName() {
		return StandardsCompliance.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("stdComplianceId", getStdComplianceId());
		attributes.put("stdId", getStdId());
		attributes.put("countryCode", getCountryCode());
		attributes.put("chainCode", getChainCode());
		attributes.put("complianceExpiryDate", getComplianceExpiryDate());
		attributes.put("complianceExpiryRule", getComplianceExpiryRule());
		attributes.put("complianceRuleMonths", getComplianceRuleMonths());
		attributes.put("RuleDate", getRuleDate());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long stdComplianceId = (Long)attributes.get("stdComplianceId");

		if (stdComplianceId != null) {
			setStdComplianceId(stdComplianceId);
		}

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

		Date complianceExpiryDate = (Date)attributes.get("complianceExpiryDate");

		if (complianceExpiryDate != null) {
			setComplianceExpiryDate(complianceExpiryDate);
		}

		String complianceExpiryRule = (String)attributes.get(
				"complianceExpiryRule");

		if (complianceExpiryRule != null) {
			setComplianceExpiryRule(complianceExpiryRule);
		}

		Long complianceRuleMonths = (Long)attributes.get("complianceRuleMonths");

		if (complianceRuleMonths != null) {
			setComplianceRuleMonths(complianceRuleMonths);
		}

		String RuleDate = (String)attributes.get("RuleDate");

		if (RuleDate != null) {
			setRuleDate(RuleDate);
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
	* Returns the primary key of this standards compliance.
	*
	* @return the primary key of this standards compliance
	*/
	@Override
	public long getPrimaryKey() {
		return _standardsCompliance.getPrimaryKey();
	}

	/**
	* Sets the primary key of this standards compliance.
	*
	* @param primaryKey the primary key of this standards compliance
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_standardsCompliance.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the std compliance ID of this standards compliance.
	*
	* @return the std compliance ID of this standards compliance
	*/
	@Override
	public long getStdComplianceId() {
		return _standardsCompliance.getStdComplianceId();
	}

	/**
	* Sets the std compliance ID of this standards compliance.
	*
	* @param stdComplianceId the std compliance ID of this standards compliance
	*/
	@Override
	public void setStdComplianceId(long stdComplianceId) {
		_standardsCompliance.setStdComplianceId(stdComplianceId);
	}

	/**
	* Returns the std ID of this standards compliance.
	*
	* @return the std ID of this standards compliance
	*/
	@Override
	public long getStdId() {
		return _standardsCompliance.getStdId();
	}

	/**
	* Sets the std ID of this standards compliance.
	*
	* @param stdId the std ID of this standards compliance
	*/
	@Override
	public void setStdId(long stdId) {
		_standardsCompliance.setStdId(stdId);
	}

	/**
	* Returns the country code of this standards compliance.
	*
	* @return the country code of this standards compliance
	*/
	@Override
	public java.lang.String getCountryCode() {
		return _standardsCompliance.getCountryCode();
	}

	/**
	* Sets the country code of this standards compliance.
	*
	* @param countryCode the country code of this standards compliance
	*/
	@Override
	public void setCountryCode(java.lang.String countryCode) {
		_standardsCompliance.setCountryCode(countryCode);
	}

	/**
	* Returns the chain code of this standards compliance.
	*
	* @return the chain code of this standards compliance
	*/
	@Override
	public java.lang.String getChainCode() {
		return _standardsCompliance.getChainCode();
	}

	/**
	* Sets the chain code of this standards compliance.
	*
	* @param chainCode the chain code of this standards compliance
	*/
	@Override
	public void setChainCode(java.lang.String chainCode) {
		_standardsCompliance.setChainCode(chainCode);
	}

	/**
	* Returns the compliance expiry date of this standards compliance.
	*
	* @return the compliance expiry date of this standards compliance
	*/
	@Override
	public java.util.Date getComplianceExpiryDate() {
		return _standardsCompliance.getComplianceExpiryDate();
	}

	/**
	* Sets the compliance expiry date of this standards compliance.
	*
	* @param complianceExpiryDate the compliance expiry date of this standards compliance
	*/
	@Override
	public void setComplianceExpiryDate(java.util.Date complianceExpiryDate) {
		_standardsCompliance.setComplianceExpiryDate(complianceExpiryDate);
	}

	/**
	* Returns the compliance expiry rule of this standards compliance.
	*
	* @return the compliance expiry rule of this standards compliance
	*/
	@Override
	public java.lang.String getComplianceExpiryRule() {
		return _standardsCompliance.getComplianceExpiryRule();
	}

	/**
	* Sets the compliance expiry rule of this standards compliance.
	*
	* @param complianceExpiryRule the compliance expiry rule of this standards compliance
	*/
	@Override
	public void setComplianceExpiryRule(java.lang.String complianceExpiryRule) {
		_standardsCompliance.setComplianceExpiryRule(complianceExpiryRule);
	}

	/**
	* Returns the compliance rule months of this standards compliance.
	*
	* @return the compliance rule months of this standards compliance
	*/
	@Override
	public long getComplianceRuleMonths() {
		return _standardsCompliance.getComplianceRuleMonths();
	}

	/**
	* Sets the compliance rule months of this standards compliance.
	*
	* @param complianceRuleMonths the compliance rule months of this standards compliance
	*/
	@Override
	public void setComplianceRuleMonths(long complianceRuleMonths) {
		_standardsCompliance.setComplianceRuleMonths(complianceRuleMonths);
	}

	/**
	* Returns the rule date of this standards compliance.
	*
	* @return the rule date of this standards compliance
	*/
	@Override
	public java.lang.String getRuleDate() {
		return _standardsCompliance.getRuleDate();
	}

	/**
	* Sets the rule date of this standards compliance.
	*
	* @param RuleDate the rule date of this standards compliance
	*/
	@Override
	public void setRuleDate(java.lang.String RuleDate) {
		_standardsCompliance.setRuleDate(RuleDate);
	}

	/**
	* Returns the creator ID of this standards compliance.
	*
	* @return the creator ID of this standards compliance
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _standardsCompliance.getCreatorId();
	}

	/**
	* Sets the creator ID of this standards compliance.
	*
	* @param creatorId the creator ID of this standards compliance
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_standardsCompliance.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this standards compliance.
	*
	* @return the created date of this standards compliance
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _standardsCompliance.getCreatedDate();
	}

	/**
	* Sets the created date of this standards compliance.
	*
	* @param createdDate the created date of this standards compliance
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_standardsCompliance.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this standards compliance.
	*
	* @return the updated by of this standards compliance
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _standardsCompliance.getUpdatedBy();
	}

	/**
	* Sets the updated by of this standards compliance.
	*
	* @param updatedBy the updated by of this standards compliance
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_standardsCompliance.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this standards compliance.
	*
	* @return the updated date of this standards compliance
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _standardsCompliance.getUpdatedDate();
	}

	/**
	* Sets the updated date of this standards compliance.
	*
	* @param updatedDate the updated date of this standards compliance
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_standardsCompliance.setUpdatedDate(updatedDate);
	}

	@Override
	public boolean isNew() {
		return _standardsCompliance.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_standardsCompliance.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _standardsCompliance.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_standardsCompliance.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _standardsCompliance.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _standardsCompliance.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_standardsCompliance.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _standardsCompliance.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_standardsCompliance.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_standardsCompliance.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_standardsCompliance.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new StandardsComplianceWrapper((StandardsCompliance)_standardsCompliance.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.StandardsCompliance standardsCompliance) {
		return _standardsCompliance.compareTo(standardsCompliance);
	}

	@Override
	public int hashCode() {
		return _standardsCompliance.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.StandardsCompliance> toCacheModel() {
		return _standardsCompliance.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.StandardsCompliance toEscapedModel() {
		return new StandardsComplianceWrapper(_standardsCompliance.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.StandardsCompliance toUnescapedModel() {
		return new StandardsComplianceWrapper(_standardsCompliance.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _standardsCompliance.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _standardsCompliance.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_standardsCompliance.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StandardsComplianceWrapper)) {
			return false;
		}

		StandardsComplianceWrapper standardsComplianceWrapper = (StandardsComplianceWrapper)obj;

		if (Validator.equals(_standardsCompliance,
					standardsComplianceWrapper._standardsCompliance)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public StandardsCompliance getWrappedStandardsCompliance() {
		return _standardsCompliance;
	}

	@Override
	public StandardsCompliance getWrappedModel() {
		return _standardsCompliance;
	}

	@Override
	public void resetOriginalValues() {
		_standardsCompliance.resetOriginalValues();
	}

	private StandardsCompliance _standardsCompliance;
}