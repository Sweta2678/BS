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
 * This class is a wrapper for {@link StandardsComplianceExt}.
 * </p>
 *
 * @author Mummanedi
 * @see StandardsComplianceExt
 * @generated
 */
public class StandardsComplianceExtWrapper implements StandardsComplianceExt,
	ModelWrapper<StandardsComplianceExt> {
	public StandardsComplianceExtWrapper(
		StandardsComplianceExt standardsComplianceExt) {
		_standardsComplianceExt = standardsComplianceExt;
	}

	@Override
	public Class<?> getModelClass() {
		return StandardsComplianceExt.class;
	}

	@Override
	public String getModelClassName() {
		return StandardsComplianceExt.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("stdComplianceId", getStdComplianceId());
		attributes.put("stdId", getStdId());
		attributes.put("countryCode", getCountryCode());
		attributes.put("regionCode", getRegionCode());
		attributes.put("chainCode", getChainCode());
		attributes.put("complianceExpiryDate", getComplianceExpiryDate());
		attributes.put("complianceExpiryRule", getComplianceExpiryRule());
		attributes.put("complianceRuleMonths", getComplianceRuleMonths());
		attributes.put("RuleDate", getRuleDate());
		attributes.put("expiryDate", getExpiryDate());
		attributes.put("complianceDateString", getComplianceDateString());
		attributes.put("expiryDateString", getExpiryDateString());

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

		String regionCode = (String)attributes.get("regionCode");

		if (regionCode != null) {
			setRegionCode(regionCode);
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

		String expiryDate = (String)attributes.get("expiryDate");

		if (expiryDate != null) {
			setExpiryDate(expiryDate);
		}

		String complianceDateString = (String)attributes.get(
				"complianceDateString");

		if (complianceDateString != null) {
			setComplianceDateString(complianceDateString);
		}

		String expiryDateString = (String)attributes.get("expiryDateString");

		if (expiryDateString != null) {
			setExpiryDateString(expiryDateString);
		}
	}

	/**
	* Returns the primary key of this standards compliance ext.
	*
	* @return the primary key of this standards compliance ext
	*/
	@Override
	public long getPrimaryKey() {
		return _standardsComplianceExt.getPrimaryKey();
	}

	/**
	* Sets the primary key of this standards compliance ext.
	*
	* @param primaryKey the primary key of this standards compliance ext
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_standardsComplianceExt.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the std compliance ID of this standards compliance ext.
	*
	* @return the std compliance ID of this standards compliance ext
	*/
	@Override
	public long getStdComplianceId() {
		return _standardsComplianceExt.getStdComplianceId();
	}

	/**
	* Sets the std compliance ID of this standards compliance ext.
	*
	* @param stdComplianceId the std compliance ID of this standards compliance ext
	*/
	@Override
	public void setStdComplianceId(long stdComplianceId) {
		_standardsComplianceExt.setStdComplianceId(stdComplianceId);
	}

	/**
	* Returns the std ID of this standards compliance ext.
	*
	* @return the std ID of this standards compliance ext
	*/
	@Override
	public long getStdId() {
		return _standardsComplianceExt.getStdId();
	}

	/**
	* Sets the std ID of this standards compliance ext.
	*
	* @param stdId the std ID of this standards compliance ext
	*/
	@Override
	public void setStdId(long stdId) {
		_standardsComplianceExt.setStdId(stdId);
	}

	/**
	* Returns the country code of this standards compliance ext.
	*
	* @return the country code of this standards compliance ext
	*/
	@Override
	public java.lang.String getCountryCode() {
		return _standardsComplianceExt.getCountryCode();
	}

	/**
	* Sets the country code of this standards compliance ext.
	*
	* @param countryCode the country code of this standards compliance ext
	*/
	@Override
	public void setCountryCode(java.lang.String countryCode) {
		_standardsComplianceExt.setCountryCode(countryCode);
	}

	/**
	* Returns the region code of this standards compliance ext.
	*
	* @return the region code of this standards compliance ext
	*/
	@Override
	public java.lang.String getRegionCode() {
		return _standardsComplianceExt.getRegionCode();
	}

	/**
	* Sets the region code of this standards compliance ext.
	*
	* @param regionCode the region code of this standards compliance ext
	*/
	@Override
	public void setRegionCode(java.lang.String regionCode) {
		_standardsComplianceExt.setRegionCode(regionCode);
	}

	/**
	* Returns the chain code of this standards compliance ext.
	*
	* @return the chain code of this standards compliance ext
	*/
	@Override
	public java.lang.String getChainCode() {
		return _standardsComplianceExt.getChainCode();
	}

	/**
	* Sets the chain code of this standards compliance ext.
	*
	* @param chainCode the chain code of this standards compliance ext
	*/
	@Override
	public void setChainCode(java.lang.String chainCode) {
		_standardsComplianceExt.setChainCode(chainCode);
	}

	/**
	* Returns the compliance expiry date of this standards compliance ext.
	*
	* @return the compliance expiry date of this standards compliance ext
	*/
	@Override
	public java.util.Date getComplianceExpiryDate() {
		return _standardsComplianceExt.getComplianceExpiryDate();
	}

	/**
	* Sets the compliance expiry date of this standards compliance ext.
	*
	* @param complianceExpiryDate the compliance expiry date of this standards compliance ext
	*/
	@Override
	public void setComplianceExpiryDate(java.util.Date complianceExpiryDate) {
		_standardsComplianceExt.setComplianceExpiryDate(complianceExpiryDate);
	}

	/**
	* Returns the compliance expiry rule of this standards compliance ext.
	*
	* @return the compliance expiry rule of this standards compliance ext
	*/
	@Override
	public java.lang.String getComplianceExpiryRule() {
		return _standardsComplianceExt.getComplianceExpiryRule();
	}

	/**
	* Sets the compliance expiry rule of this standards compliance ext.
	*
	* @param complianceExpiryRule the compliance expiry rule of this standards compliance ext
	*/
	@Override
	public void setComplianceExpiryRule(java.lang.String complianceExpiryRule) {
		_standardsComplianceExt.setComplianceExpiryRule(complianceExpiryRule);
	}

	/**
	* Returns the compliance rule months of this standards compliance ext.
	*
	* @return the compliance rule months of this standards compliance ext
	*/
	@Override
	public long getComplianceRuleMonths() {
		return _standardsComplianceExt.getComplianceRuleMonths();
	}

	/**
	* Sets the compliance rule months of this standards compliance ext.
	*
	* @param complianceRuleMonths the compliance rule months of this standards compliance ext
	*/
	@Override
	public void setComplianceRuleMonths(long complianceRuleMonths) {
		_standardsComplianceExt.setComplianceRuleMonths(complianceRuleMonths);
	}

	/**
	* Returns the rule date of this standards compliance ext.
	*
	* @return the rule date of this standards compliance ext
	*/
	@Override
	public java.lang.String getRuleDate() {
		return _standardsComplianceExt.getRuleDate();
	}

	/**
	* Sets the rule date of this standards compliance ext.
	*
	* @param RuleDate the rule date of this standards compliance ext
	*/
	@Override
	public void setRuleDate(java.lang.String RuleDate) {
		_standardsComplianceExt.setRuleDate(RuleDate);
	}

	/**
	* Returns the expiry date of this standards compliance ext.
	*
	* @return the expiry date of this standards compliance ext
	*/
	@Override
	public java.lang.String getExpiryDate() {
		return _standardsComplianceExt.getExpiryDate();
	}

	/**
	* Sets the expiry date of this standards compliance ext.
	*
	* @param expiryDate the expiry date of this standards compliance ext
	*/
	@Override
	public void setExpiryDate(java.lang.String expiryDate) {
		_standardsComplianceExt.setExpiryDate(expiryDate);
	}

	/**
	* Returns the compliance date string of this standards compliance ext.
	*
	* @return the compliance date string of this standards compliance ext
	*/
	@Override
	public java.lang.String getComplianceDateString() {
		return _standardsComplianceExt.getComplianceDateString();
	}

	/**
	* Sets the compliance date string of this standards compliance ext.
	*
	* @param complianceDateString the compliance date string of this standards compliance ext
	*/
	@Override
	public void setComplianceDateString(java.lang.String complianceDateString) {
		_standardsComplianceExt.setComplianceDateString(complianceDateString);
	}

	/**
	* Returns the expiry date string of this standards compliance ext.
	*
	* @return the expiry date string of this standards compliance ext
	*/
	@Override
	public java.lang.String getExpiryDateString() {
		return _standardsComplianceExt.getExpiryDateString();
	}

	/**
	* Sets the expiry date string of this standards compliance ext.
	*
	* @param expiryDateString the expiry date string of this standards compliance ext
	*/
	@Override
	public void setExpiryDateString(java.lang.String expiryDateString) {
		_standardsComplianceExt.setExpiryDateString(expiryDateString);
	}

	@Override
	public boolean isNew() {
		return _standardsComplianceExt.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_standardsComplianceExt.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _standardsComplianceExt.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_standardsComplianceExt.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _standardsComplianceExt.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _standardsComplianceExt.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_standardsComplianceExt.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _standardsComplianceExt.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_standardsComplianceExt.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_standardsComplianceExt.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_standardsComplianceExt.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new StandardsComplianceExtWrapper((StandardsComplianceExt)_standardsComplianceExt.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.StandardsComplianceExt standardsComplianceExt) {
		return _standardsComplianceExt.compareTo(standardsComplianceExt);
	}

	@Override
	public int hashCode() {
		return _standardsComplianceExt.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.StandardsComplianceExt> toCacheModel() {
		return _standardsComplianceExt.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.StandardsComplianceExt toEscapedModel() {
		return new StandardsComplianceExtWrapper(_standardsComplianceExt.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.StandardsComplianceExt toUnescapedModel() {
		return new StandardsComplianceExtWrapper(_standardsComplianceExt.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _standardsComplianceExt.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _standardsComplianceExt.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_standardsComplianceExt.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StandardsComplianceExtWrapper)) {
			return false;
		}

		StandardsComplianceExtWrapper standardsComplianceExtWrapper = (StandardsComplianceExtWrapper)obj;

		if (Validator.equals(_standardsComplianceExt,
					standardsComplianceExtWrapper._standardsComplianceExt)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public StandardsComplianceExt getWrappedStandardsComplianceExt() {
		return _standardsComplianceExt;
	}

	@Override
	public StandardsComplianceExt getWrappedModel() {
		return _standardsComplianceExt;
	}

	@Override
	public void resetOriginalValues() {
		_standardsComplianceExt.resetOriginalValues();
	}

	private StandardsComplianceExt _standardsComplianceExt;
}