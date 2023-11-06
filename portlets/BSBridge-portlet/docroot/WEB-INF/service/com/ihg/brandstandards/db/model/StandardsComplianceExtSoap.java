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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Mummanedi
 * @generated
 */
public class StandardsComplianceExtSoap implements Serializable {
	public static StandardsComplianceExtSoap toSoapModel(
		StandardsComplianceExt model) {
		StandardsComplianceExtSoap soapModel = new StandardsComplianceExtSoap();

		soapModel.setStdComplianceId(model.getStdComplianceId());
		soapModel.setStdId(model.getStdId());
		soapModel.setCountryCode(model.getCountryCode());
		soapModel.setRegionCode(model.getRegionCode());
		soapModel.setChainCode(model.getChainCode());
		soapModel.setComplianceExpiryDate(model.getComplianceExpiryDate());
		soapModel.setComplianceExpiryRule(model.getComplianceExpiryRule());
		soapModel.setComplianceRuleMonths(model.getComplianceRuleMonths());
		soapModel.setRuleDate(model.getRuleDate());
		soapModel.setExpiryDate(model.getExpiryDate());
		soapModel.setComplianceDateString(model.getComplianceDateString());
		soapModel.setExpiryDateString(model.getExpiryDateString());

		return soapModel;
	}

	public static StandardsComplianceExtSoap[] toSoapModels(
		StandardsComplianceExt[] models) {
		StandardsComplianceExtSoap[] soapModels = new StandardsComplianceExtSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StandardsComplianceExtSoap[][] toSoapModels(
		StandardsComplianceExt[][] models) {
		StandardsComplianceExtSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StandardsComplianceExtSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StandardsComplianceExtSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StandardsComplianceExtSoap[] toSoapModels(
		List<StandardsComplianceExt> models) {
		List<StandardsComplianceExtSoap> soapModels = new ArrayList<StandardsComplianceExtSoap>(models.size());

		for (StandardsComplianceExt model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StandardsComplianceExtSoap[soapModels.size()]);
	}

	public StandardsComplianceExtSoap() {
	}

	public long getPrimaryKey() {
		return _stdComplianceId;
	}

	public void setPrimaryKey(long pk) {
		setStdComplianceId(pk);
	}

	public long getStdComplianceId() {
		return _stdComplianceId;
	}

	public void setStdComplianceId(long stdComplianceId) {
		_stdComplianceId = stdComplianceId;
	}

	public long getStdId() {
		return _stdId;
	}

	public void setStdId(long stdId) {
		_stdId = stdId;
	}

	public String getCountryCode() {
		return _countryCode;
	}

	public void setCountryCode(String countryCode) {
		_countryCode = countryCode;
	}

	public String getRegionCode() {
		return _regionCode;
	}

	public void setRegionCode(String regionCode) {
		_regionCode = regionCode;
	}

	public String getChainCode() {
		return _chainCode;
	}

	public void setChainCode(String chainCode) {
		_chainCode = chainCode;
	}

	public Date getComplianceExpiryDate() {
		return _complianceExpiryDate;
	}

	public void setComplianceExpiryDate(Date complianceExpiryDate) {
		_complianceExpiryDate = complianceExpiryDate;
	}

	public String getComplianceExpiryRule() {
		return _complianceExpiryRule;
	}

	public void setComplianceExpiryRule(String complianceExpiryRule) {
		_complianceExpiryRule = complianceExpiryRule;
	}

	public long getComplianceRuleMonths() {
		return _complianceRuleMonths;
	}

	public void setComplianceRuleMonths(long complianceRuleMonths) {
		_complianceRuleMonths = complianceRuleMonths;
	}

	public String getRuleDate() {
		return _RuleDate;
	}

	public void setRuleDate(String RuleDate) {
		_RuleDate = RuleDate;
	}

	public String getExpiryDate() {
		return _expiryDate;
	}

	public void setExpiryDate(String expiryDate) {
		_expiryDate = expiryDate;
	}

	public String getComplianceDateString() {
		return _complianceDateString;
	}

	public void setComplianceDateString(String complianceDateString) {
		_complianceDateString = complianceDateString;
	}

	public String getExpiryDateString() {
		return _expiryDateString;
	}

	public void setExpiryDateString(String expiryDateString) {
		_expiryDateString = expiryDateString;
	}

	private long _stdComplianceId;
	private long _stdId;
	private String _countryCode;
	private String _regionCode;
	private String _chainCode;
	private Date _complianceExpiryDate;
	private String _complianceExpiryRule;
	private long _complianceRuleMonths;
	private String _RuleDate;
	private String _expiryDate;
	private String _complianceDateString;
	private String _expiryDateString;
}