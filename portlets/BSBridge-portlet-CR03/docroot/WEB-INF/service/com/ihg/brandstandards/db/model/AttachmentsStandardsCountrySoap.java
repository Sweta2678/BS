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

import com.ihg.brandstandards.db.service.persistence.AttachmentsStandardsCountryPK;

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
public class AttachmentsStandardsCountrySoap implements Serializable {
	public static AttachmentsStandardsCountrySoap toSoapModel(
		AttachmentsStandardsCountry model) {
		AttachmentsStandardsCountrySoap soapModel = new AttachmentsStandardsCountrySoap();

		soapModel.setAttachmentId(model.getAttachmentId());
		soapModel.setCountryCode(model.getCountryCode());
		soapModel.setLocaleCode(model.getLocaleCode());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static AttachmentsStandardsCountrySoap[] toSoapModels(
		AttachmentsStandardsCountry[] models) {
		AttachmentsStandardsCountrySoap[] soapModels = new AttachmentsStandardsCountrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AttachmentsStandardsCountrySoap[][] toSoapModels(
		AttachmentsStandardsCountry[][] models) {
		AttachmentsStandardsCountrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AttachmentsStandardsCountrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new AttachmentsStandardsCountrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AttachmentsStandardsCountrySoap[] toSoapModels(
		List<AttachmentsStandardsCountry> models) {
		List<AttachmentsStandardsCountrySoap> soapModels = new ArrayList<AttachmentsStandardsCountrySoap>(models.size());

		for (AttachmentsStandardsCountry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AttachmentsStandardsCountrySoap[soapModels.size()]);
	}

	public AttachmentsStandardsCountrySoap() {
	}

	public AttachmentsStandardsCountryPK getPrimaryKey() {
		return new AttachmentsStandardsCountryPK(_attachmentId, _countryCode,
			_localeCode);
	}

	public void setPrimaryKey(AttachmentsStandardsCountryPK pk) {
		setAttachmentId(pk.attachmentId);
		setCountryCode(pk.countryCode);
		setLocaleCode(pk.localeCode);
	}

	public long getAttachmentId() {
		return _attachmentId;
	}

	public void setAttachmentId(long attachmentId) {
		_attachmentId = attachmentId;
	}

	public String getCountryCode() {
		return _countryCode;
	}

	public void setCountryCode(String countryCode) {
		_countryCode = countryCode;
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

	private long _attachmentId;
	private String _countryCode;
	private String _localeCode;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}