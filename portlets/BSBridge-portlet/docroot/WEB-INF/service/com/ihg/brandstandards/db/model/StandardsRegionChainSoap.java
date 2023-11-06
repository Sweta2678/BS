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

import com.ihg.brandstandards.db.service.persistence.StandardsRegionChainPK;

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
public class StandardsRegionChainSoap implements Serializable {
	public static StandardsRegionChainSoap toSoapModel(
		StandardsRegionChain model) {
		StandardsRegionChainSoap soapModel = new StandardsRegionChainSoap();

		soapModel.setStdId(model.getStdId());
		soapModel.setRegionCode(model.getRegionCode());
		soapModel.setChainCode(model.getChainCode());
		soapModel.setCompDate(model.getCompDate());
		soapModel.setExpiredIds(model.getExpiredIds());
		soapModel.setComplianceRule(model.getComplianceRule());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static StandardsRegionChainSoap[] toSoapModels(
		StandardsRegionChain[] models) {
		StandardsRegionChainSoap[] soapModels = new StandardsRegionChainSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StandardsRegionChainSoap[][] toSoapModels(
		StandardsRegionChain[][] models) {
		StandardsRegionChainSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StandardsRegionChainSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StandardsRegionChainSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StandardsRegionChainSoap[] toSoapModels(
		List<StandardsRegionChain> models) {
		List<StandardsRegionChainSoap> soapModels = new ArrayList<StandardsRegionChainSoap>(models.size());

		for (StandardsRegionChain model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StandardsRegionChainSoap[soapModels.size()]);
	}

	public StandardsRegionChainSoap() {
	}

	public StandardsRegionChainPK getPrimaryKey() {
		return new StandardsRegionChainPK(_stdId, _regionCode, _chainCode);
	}

	public void setPrimaryKey(StandardsRegionChainPK pk) {
		setStdId(pk.stdId);
		setRegionCode(pk.regionCode);
		setChainCode(pk.chainCode);
	}

	public long getStdId() {
		return _stdId;
	}

	public void setStdId(long stdId) {
		_stdId = stdId;
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

	public Date getCompDate() {
		return _compDate;
	}

	public void setCompDate(Date compDate) {
		_compDate = compDate;
	}

	public String getExpiredIds() {
		return _expiredIds;
	}

	public void setExpiredIds(String expiredIds) {
		_expiredIds = expiredIds;
	}

	public long getComplianceRule() {
		return _complianceRule;
	}

	public void setComplianceRule(long complianceRule) {
		_complianceRule = complianceRule;
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

	private long _stdId;
	private String _regionCode;
	private String _chainCode;
	private Date _compDate;
	private String _expiredIds;
	private long _complianceRule;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}