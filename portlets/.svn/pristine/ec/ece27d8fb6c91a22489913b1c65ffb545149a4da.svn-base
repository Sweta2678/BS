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
public class GEMCodeSoap implements Serializable {
	public static GEMCodeSoap toSoapModel(GEMCode model) {
		GEMCodeSoap soapModel = new GEMCodeSoap();

		soapModel.setCode(model.getCode());
		soapModel.setCodeDesc(model.getCodeDesc());
		soapModel.setCodeVal(model.getCodeVal());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static GEMCodeSoap[] toSoapModels(GEMCode[] models) {
		GEMCodeSoap[] soapModels = new GEMCodeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GEMCodeSoap[][] toSoapModels(GEMCode[][] models) {
		GEMCodeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GEMCodeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new GEMCodeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GEMCodeSoap[] toSoapModels(List<GEMCode> models) {
		List<GEMCodeSoap> soapModels = new ArrayList<GEMCodeSoap>(models.size());

		for (GEMCode model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GEMCodeSoap[soapModels.size()]);
	}

	public GEMCodeSoap() {
	}

	public String getPrimaryKey() {
		return _code;
	}

	public void setPrimaryKey(String pk) {
		setCode(pk);
	}

	public String getCode() {
		return _code;
	}

	public void setCode(String code) {
		_code = code;
	}

	public String getCodeDesc() {
		return _codeDesc;
	}

	public void setCodeDesc(String codeDesc) {
		_codeDesc = codeDesc;
	}

	public String getCodeVal() {
		return _codeVal;
	}

	public void setCodeVal(String codeVal) {
		_codeVal = codeVal;
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

	private String _code;
	private String _codeDesc;
	private String _codeVal;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}