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
public class SpecialWordDictionarySoap implements Serializable {
	public static SpecialWordDictionarySoap toSoapModel(
		SpecialWordDictionary model) {
		SpecialWordDictionarySoap soapModel = new SpecialWordDictionarySoap();

		soapModel.setSpecialWordId(model.getSpecialWordId());
		soapModel.setReplacedWordTxt(model.getReplacedWordTxt());
		soapModel.setReplacementWordTxt(model.getReplacementWordTxt());
		soapModel.setLocaleCode(model.getLocaleCode());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static SpecialWordDictionarySoap[] toSoapModels(
		SpecialWordDictionary[] models) {
		SpecialWordDictionarySoap[] soapModels = new SpecialWordDictionarySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SpecialWordDictionarySoap[][] toSoapModels(
		SpecialWordDictionary[][] models) {
		SpecialWordDictionarySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SpecialWordDictionarySoap[models.length][models[0].length];
		}
		else {
			soapModels = new SpecialWordDictionarySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SpecialWordDictionarySoap[] toSoapModels(
		List<SpecialWordDictionary> models) {
		List<SpecialWordDictionarySoap> soapModels = new ArrayList<SpecialWordDictionarySoap>(models.size());

		for (SpecialWordDictionary model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SpecialWordDictionarySoap[soapModels.size()]);
	}

	public SpecialWordDictionarySoap() {
	}

	public long getPrimaryKey() {
		return _specialWordId;
	}

	public void setPrimaryKey(long pk) {
		setSpecialWordId(pk);
	}

	public long getSpecialWordId() {
		return _specialWordId;
	}

	public void setSpecialWordId(long specialWordId) {
		_specialWordId = specialWordId;
	}

	public String getReplacedWordTxt() {
		return _replacedWordTxt;
	}

	public void setReplacedWordTxt(String replacedWordTxt) {
		_replacedWordTxt = replacedWordTxt;
	}

	public String getReplacementWordTxt() {
		return _replacementWordTxt;
	}

	public void setReplacementWordTxt(String replacementWordTxt) {
		_replacementWordTxt = replacementWordTxt;
	}

	public String getLocaleCode() {
		return _localeCode;
	}

	public void setLocaleCode(String localeCode) {
		_localeCode = localeCode;
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

	private long _specialWordId;
	private String _replacedWordTxt;
	private String _replacementWordTxt;
	private String _localeCode;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}