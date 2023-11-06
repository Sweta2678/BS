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
public class GlossaryTranslateSoap implements Serializable {
	public static GlossaryTranslateSoap toSoapModel(GlossaryTranslate model) {
		GlossaryTranslateSoap soapModel = new GlossaryTranslateSoap();

		soapModel.setGlossaryXlatId(model.getGlossaryXlatId());
		soapModel.setGlossaryId(model.getGlossaryId());
		soapModel.setLangCode(model.getLangCode());
		soapModel.setGlossaryTermText(model.getGlossaryTermText());
		soapModel.setGlossaryTermDesc(model.getGlossaryTermDesc());
		soapModel.setIsValidTermTxt(model.getIsValidTermTxt());
		soapModel.setIsValidDescTxt(model.getIsValidDescTxt());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static GlossaryTranslateSoap[] toSoapModels(
		GlossaryTranslate[] models) {
		GlossaryTranslateSoap[] soapModels = new GlossaryTranslateSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GlossaryTranslateSoap[][] toSoapModels(
		GlossaryTranslate[][] models) {
		GlossaryTranslateSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GlossaryTranslateSoap[models.length][models[0].length];
		}
		else {
			soapModels = new GlossaryTranslateSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GlossaryTranslateSoap[] toSoapModels(
		List<GlossaryTranslate> models) {
		List<GlossaryTranslateSoap> soapModels = new ArrayList<GlossaryTranslateSoap>(models.size());

		for (GlossaryTranslate model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GlossaryTranslateSoap[soapModels.size()]);
	}

	public GlossaryTranslateSoap() {
	}

	public long getPrimaryKey() {
		return _glossaryXlatId;
	}

	public void setPrimaryKey(long pk) {
		setGlossaryXlatId(pk);
	}

	public long getGlossaryXlatId() {
		return _glossaryXlatId;
	}

	public void setGlossaryXlatId(long glossaryXlatId) {
		_glossaryXlatId = glossaryXlatId;
	}

	public long getGlossaryId() {
		return _glossaryId;
	}

	public void setGlossaryId(long glossaryId) {
		_glossaryId = glossaryId;
	}

	public String getLangCode() {
		return _langCode;
	}

	public void setLangCode(String langCode) {
		_langCode = langCode;
	}

	public String getGlossaryTermText() {
		return _glossaryTermText;
	}

	public void setGlossaryTermText(String glossaryTermText) {
		_glossaryTermText = glossaryTermText;
	}

	public String getGlossaryTermDesc() {
		return _glossaryTermDesc;
	}

	public void setGlossaryTermDesc(String glossaryTermDesc) {
		_glossaryTermDesc = glossaryTermDesc;
	}

	public String getIsValidTermTxt() {
		return _isValidTermTxt;
	}

	public void setIsValidTermTxt(String isValidTermTxt) {
		_isValidTermTxt = isValidTermTxt;
	}

	public String getIsValidDescTxt() {
		return _isValidDescTxt;
	}

	public void setIsValidDescTxt(String isValidDescTxt) {
		_isValidDescTxt = isValidDescTxt;
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

	private long _glossaryXlatId;
	private long _glossaryId;
	private String _langCode;
	private String _glossaryTermText;
	private String _glossaryTermDesc;
	private String _isValidTermTxt;
	private String _isValidDescTxt;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}