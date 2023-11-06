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

import com.ihg.brandstandards.db.service.persistence.StandardsCountryChainPK;

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
public class StandardsCountryChainSoap implements Serializable {
	public static StandardsCountryChainSoap toSoapModel(
		StandardsCountryChain model) {
		StandardsCountryChainSoap soapModel = new StandardsCountryChainSoap();

		soapModel.setStdId(model.getStdId());
		soapModel.setCountryCode(model.getCountryCode());
		soapModel.setChainCode(model.getChainCode());
		soapModel.setRegionCode(model.getRegionCode());
		soapModel.setCompDate(model.getCompDate());
		soapModel.setExprDate(model.getExprDate());
		soapModel.setExpiredIds(model.getExpiredIds());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static StandardsCountryChainSoap[] toSoapModels(
		StandardsCountryChain[] models) {
		StandardsCountryChainSoap[] soapModels = new StandardsCountryChainSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StandardsCountryChainSoap[][] toSoapModels(
		StandardsCountryChain[][] models) {
		StandardsCountryChainSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StandardsCountryChainSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StandardsCountryChainSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StandardsCountryChainSoap[] toSoapModels(
		List<StandardsCountryChain> models) {
		List<StandardsCountryChainSoap> soapModels = new ArrayList<StandardsCountryChainSoap>(models.size());

		for (StandardsCountryChain model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StandardsCountryChainSoap[soapModels.size()]);
	}

	public StandardsCountryChainSoap() {
	}

	public StandardsCountryChainPK getPrimaryKey() {
		return new StandardsCountryChainPK(_stdId, _countryCode, _chainCode);
	}

	public void setPrimaryKey(StandardsCountryChainPK pk) {
		setStdId(pk.stdId);
		setCountryCode(pk.countryCode);
		setChainCode(pk.chainCode);
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

	public String getRegionCode() {
		return _regionCode;
	}

	public void setRegionCode(String regionCode) {
		_regionCode = regionCode;
	}

	public Date getCompDate() {
		return _compDate;
	}

	public void setCompDate(Date compDate) {
		_compDate = compDate;
	}

	public Date getExprDate() {
		return _exprDate;
	}

	public void setExprDate(Date exprDate) {
		_exprDate = exprDate;
	}

	public String getExpiredIds() {
		return _expiredIds;
	}

	public void setExpiredIds(String expiredIds) {
		_expiredIds = expiredIds;
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
	private String _countryCode;
	private String _chainCode;
	private String _regionCode;
	private Date _compDate;
	private Date _exprDate;
	private String _expiredIds;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}