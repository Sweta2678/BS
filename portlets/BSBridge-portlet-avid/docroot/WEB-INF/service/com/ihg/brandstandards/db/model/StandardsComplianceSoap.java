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
public class StandardsComplianceSoap implements Serializable {
	public static StandardsComplianceSoap toSoapModel(StandardsCompliance model) {
		StandardsComplianceSoap soapModel = new StandardsComplianceSoap();

		soapModel.setStdComplianceId(model.getStdComplianceId());
		soapModel.setStdId(model.getStdId());
		soapModel.setCountryCode(model.getCountryCode());
		soapModel.setChainCode(model.getChainCode());
		soapModel.setComplianceExpiryDate(model.getComplianceExpiryDate());
		soapModel.setComplianceExpiryRule(model.getComplianceExpiryRule());
		soapModel.setComplianceRuleMonths(model.getComplianceRuleMonths());
		soapModel.setRuleDate(model.getRuleDate());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static StandardsComplianceSoap[] toSoapModels(
		StandardsCompliance[] models) {
		StandardsComplianceSoap[] soapModels = new StandardsComplianceSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StandardsComplianceSoap[][] toSoapModels(
		StandardsCompliance[][] models) {
		StandardsComplianceSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StandardsComplianceSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StandardsComplianceSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StandardsComplianceSoap[] toSoapModels(
		List<StandardsCompliance> models) {
		List<StandardsComplianceSoap> soapModels = new ArrayList<StandardsComplianceSoap>(models.size());

		for (StandardsCompliance model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StandardsComplianceSoap[soapModels.size()]);
	}

	public StandardsComplianceSoap() {
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

	public String getCreatorId() {
		return _creatorId;
	}

	public void setCreatorId(String creatorId) {
		_creatorId = creatorId;
	}

	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	public String getUpdatedBy() {
		return _updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		_updatedBy = updatedBy;
	}

	public Date getUpdatedDate() {
		return _updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		_updatedDate = updatedDate;
	}

	private long _stdComplianceId;
	private long _stdId;
	private String _countryCode;
	private String _chainCode;
	private Date _complianceExpiryDate;
	private String _complianceExpiryRule;
	private long _complianceRuleMonths;
	private String _RuleDate;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}