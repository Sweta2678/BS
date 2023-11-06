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

import com.ihg.brandstandards.db.service.persistence.CountryStandardsExtPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Mummanedi
 * @generated
 */
public class CountryStandardsExtSoap implements Serializable {
	public static CountryStandardsExtSoap toSoapModel(CountryStandardsExt model) {
		CountryStandardsExtSoap soapModel = new CountryStandardsExtSoap();

		soapModel.setCountryCode(model.getCountryCode());
		soapModel.setStdId(model.getStdId());
		soapModel.setRegionId(model.getRegionId());
		soapModel.setRegionCode(model.getRegionCode());
		soapModel.setRegionName(model.getRegionName());

		return soapModel;
	}

	public static CountryStandardsExtSoap[] toSoapModels(
		CountryStandardsExt[] models) {
		CountryStandardsExtSoap[] soapModels = new CountryStandardsExtSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CountryStandardsExtSoap[][] toSoapModels(
		CountryStandardsExt[][] models) {
		CountryStandardsExtSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CountryStandardsExtSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CountryStandardsExtSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CountryStandardsExtSoap[] toSoapModels(
		List<CountryStandardsExt> models) {
		List<CountryStandardsExtSoap> soapModels = new ArrayList<CountryStandardsExtSoap>(models.size());

		for (CountryStandardsExt model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CountryStandardsExtSoap[soapModels.size()]);
	}

	public CountryStandardsExtSoap() {
	}

	public CountryStandardsExtPK getPrimaryKey() {
		return new CountryStandardsExtPK(_countryCode, _stdId);
	}

	public void setPrimaryKey(CountryStandardsExtPK pk) {
		setCountryCode(pk.countryCode);
		setStdId(pk.stdId);
	}

	public String getCountryCode() {
		return _countryCode;
	}

	public void setCountryCode(String countryCode) {
		_countryCode = countryCode;
	}

	public long getStdId() {
		return _stdId;
	}

	public void setStdId(long stdId) {
		_stdId = stdId;
	}

	public long getRegionId() {
		return _regionId;
	}

	public void setRegionId(long regionId) {
		_regionId = regionId;
	}

	public String getRegionCode() {
		return _regionCode;
	}

	public void setRegionCode(String regionCode) {
		_regionCode = regionCode;
	}

	public String getRegionName() {
		return _regionName;
	}

	public void setRegionName(String regionName) {
		_regionName = regionName;
	}

	private String _countryCode;
	private long _stdId;
	private long _regionId;
	private String _regionCode;
	private String _regionName;
}