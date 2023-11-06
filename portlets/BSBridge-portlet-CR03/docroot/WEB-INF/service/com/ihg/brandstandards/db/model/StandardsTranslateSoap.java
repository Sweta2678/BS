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

import com.ihg.brandstandards.db.service.persistence.StandardsTranslatePK;

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
public class StandardsTranslateSoap implements Serializable {
	public static StandardsTranslateSoap toSoapModel(StandardsTranslate model) {
		StandardsTranslateSoap soapModel = new StandardsTranslateSoap();

		soapModel.setStdId(model.getStdId());
		soapModel.setLocaleCode(model.getLocaleCode());
		soapModel.setTitle(model.getTitle());
		soapModel.setDescription(model.getDescription());
		soapModel.setNote(model.getNote());
		soapModel.setComment(model.getComment());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());
		soapModel.setIsValidTxt(model.getIsValidTxt());
		soapModel.setIsValidCntxt(model.getIsValidCntxt());

		return soapModel;
	}

	public static StandardsTranslateSoap[] toSoapModels(
		StandardsTranslate[] models) {
		StandardsTranslateSoap[] soapModels = new StandardsTranslateSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StandardsTranslateSoap[][] toSoapModels(
		StandardsTranslate[][] models) {
		StandardsTranslateSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StandardsTranslateSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StandardsTranslateSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StandardsTranslateSoap[] toSoapModels(
		List<StandardsTranslate> models) {
		List<StandardsTranslateSoap> soapModels = new ArrayList<StandardsTranslateSoap>(models.size());

		for (StandardsTranslate model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StandardsTranslateSoap[soapModels.size()]);
	}

	public StandardsTranslateSoap() {
	}

	public StandardsTranslatePK getPrimaryKey() {
		return new StandardsTranslatePK(_stdId, _localeCode);
	}

	public void setPrimaryKey(StandardsTranslatePK pk) {
		setStdId(pk.stdId);
		setLocaleCode(pk.localeCode);
	}

	public long getStdId() {
		return _stdId;
	}

	public void setStdId(long stdId) {
		_stdId = stdId;
	}

	public String getLocaleCode() {
		return _localeCode;
	}

	public void setLocaleCode(String localeCode) {
		_localeCode = localeCode;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getNote() {
		return _note;
	}

	public void setNote(String note) {
		_note = note;
	}

	public String getComment() {
		return _comment;
	}

	public void setComment(String comment) {
		_comment = comment;
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

	public String getIsValidTxt() {
		return _isValidTxt;
	}

	public void setIsValidTxt(String isValidTxt) {
		_isValidTxt = isValidTxt;
	}

	public String getIsValidCntxt() {
		return _isValidCntxt;
	}

	public void setIsValidCntxt(String isValidCntxt) {
		_isValidCntxt = isValidCntxt;
	}

	private long _stdId;
	private String _localeCode;
	private String _title;
	private String _description;
	private String _note;
	private String _comment;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private String _isValidTxt;
	private String _isValidCntxt;
}