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

import com.ihg.brandstandards.db.service.persistence.BridgePublishCountryStateExPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Mummanedi
 * @generated
 */
public class BridgePublishCountryStateExSoap implements Serializable {
	public static BridgePublishCountryStateExSoap toSoapModel(
		BridgePublishCountryStateEx model) {
		BridgePublishCountryStateExSoap soapModel = new BridgePublishCountryStateExSoap();

		soapModel.setStdId(model.getStdId());
		soapModel.setCountryCode(model.getCountryCode());
		soapModel.setParentStdId(model.getParentStdId());
		soapModel.setType(model.getType());
		soapModel.setPublishId(model.getPublishId());
		soapModel.setStateCd(model.getStateCd());

		return soapModel;
	}

	public static BridgePublishCountryStateExSoap[] toSoapModels(
		BridgePublishCountryStateEx[] models) {
		BridgePublishCountryStateExSoap[] soapModels = new BridgePublishCountryStateExSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static BridgePublishCountryStateExSoap[][] toSoapModels(
		BridgePublishCountryStateEx[][] models) {
		BridgePublishCountryStateExSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new BridgePublishCountryStateExSoap[models.length][models[0].length];
		}
		else {
			soapModels = new BridgePublishCountryStateExSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static BridgePublishCountryStateExSoap[] toSoapModels(
		List<BridgePublishCountryStateEx> models) {
		List<BridgePublishCountryStateExSoap> soapModels = new ArrayList<BridgePublishCountryStateExSoap>(models.size());

		for (BridgePublishCountryStateEx model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new BridgePublishCountryStateExSoap[soapModels.size()]);
	}

	public BridgePublishCountryStateExSoap() {
	}

	public BridgePublishCountryStateExPK getPrimaryKey() {
		return new BridgePublishCountryStateExPK(_stdId, _CountryCode);
	}

	public void setPrimaryKey(BridgePublishCountryStateExPK pk) {
		setStdId(pk.stdId);
		setCountryCode(pk.CountryCode);
	}

	public long getStdId() {
		return _stdId;
	}

	public void setStdId(long stdId) {
		_stdId = stdId;
	}

	public String getCountryCode() {
		return _CountryCode;
	}

	public void setCountryCode(String CountryCode) {
		_CountryCode = CountryCode;
	}

	public long getParentStdId() {
		return _parentStdId;
	}

	public void setParentStdId(long parentStdId) {
		_parentStdId = parentStdId;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	public long getPublishId() {
		return _publishId;
	}

	public void setPublishId(long publishId) {
		_publishId = publishId;
	}

	public String getStateCd() {
		return _stateCd;
	}

	public void setStateCd(String stateCd) {
		_stateCd = stateCd;
	}

	private long _stdId;
	private String _CountryCode;
	private long _parentStdId;
	private String _type;
	private long _publishId;
	private String _stateCd;
}