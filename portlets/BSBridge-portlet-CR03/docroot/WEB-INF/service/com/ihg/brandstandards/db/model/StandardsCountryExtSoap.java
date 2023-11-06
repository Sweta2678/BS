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
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Mummanedi
 * @generated
 */
public class StandardsCountryExtSoap implements Serializable {
	public static StandardsCountryExtSoap toSoapModel(StandardsCountryExt model) {
		StandardsCountryExtSoap soapModel = new StandardsCountryExtSoap();

		soapModel.setRowNum(model.getRowNum());
		soapModel.setCountryCode(model.getCountryCode());
		soapModel.setFlag(model.getFlag());

		return soapModel;
	}

	public static StandardsCountryExtSoap[] toSoapModels(
		StandardsCountryExt[] models) {
		StandardsCountryExtSoap[] soapModels = new StandardsCountryExtSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StandardsCountryExtSoap[][] toSoapModels(
		StandardsCountryExt[][] models) {
		StandardsCountryExtSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StandardsCountryExtSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StandardsCountryExtSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StandardsCountryExtSoap[] toSoapModels(
		List<StandardsCountryExt> models) {
		List<StandardsCountryExtSoap> soapModels = new ArrayList<StandardsCountryExtSoap>(models.size());

		for (StandardsCountryExt model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StandardsCountryExtSoap[soapModels.size()]);
	}

	public StandardsCountryExtSoap() {
	}

	public long getPrimaryKey() {
		return _rowNum;
	}

	public void setPrimaryKey(long pk) {
		setRowNum(pk);
	}

	public long getRowNum() {
		return _rowNum;
	}

	public void setRowNum(long rowNum) {
		_rowNum = rowNum;
	}

	public String getCountryCode() {
		return _countryCode;
	}

	public void setCountryCode(String countryCode) {
		_countryCode = countryCode;
	}

	public String getFlag() {
		return _flag;
	}

	public void setFlag(String flag) {
		_flag = flag;
	}

	private long _rowNum;
	private String _countryCode;
	private String _flag;
}