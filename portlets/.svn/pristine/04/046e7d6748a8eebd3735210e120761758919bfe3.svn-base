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

import com.ihg.brandstandards.db.service.persistence.AttachmentsStandardsPK;

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
public class AttachmentsStandardsSoap implements Serializable {
	public static AttachmentsStandardsSoap toSoapModel(
		AttachmentsStandards model) {
		AttachmentsStandardsSoap soapModel = new AttachmentsStandardsSoap();

		soapModel.setAttachmentId(model.getAttachmentId());
		soapModel.setLocaleCode(model.getLocaleCode());
		soapModel.setParentAttachmentId(model.getParentAttachmentId());
		soapModel.setStdId(model.getStdId());
		soapModel.setType(model.getType());
		soapModel.setTitle(model.getTitle());
		soapModel.setTranslationIndicator(model.getTranslationIndicator());
		soapModel.setAttachmentPath(model.getAttachmentPath());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static AttachmentsStandardsSoap[] toSoapModels(
		AttachmentsStandards[] models) {
		AttachmentsStandardsSoap[] soapModels = new AttachmentsStandardsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AttachmentsStandardsSoap[][] toSoapModels(
		AttachmentsStandards[][] models) {
		AttachmentsStandardsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AttachmentsStandardsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AttachmentsStandardsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AttachmentsStandardsSoap[] toSoapModels(
		List<AttachmentsStandards> models) {
		List<AttachmentsStandardsSoap> soapModels = new ArrayList<AttachmentsStandardsSoap>(models.size());

		for (AttachmentsStandards model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AttachmentsStandardsSoap[soapModels.size()]);
	}

	public AttachmentsStandardsSoap() {
	}

	public AttachmentsStandardsPK getPrimaryKey() {
		return new AttachmentsStandardsPK(_attachmentId, _localeCode);
	}

	public void setPrimaryKey(AttachmentsStandardsPK pk) {
		setAttachmentId(pk.attachmentId);
		setLocaleCode(pk.localeCode);
	}

	public long getAttachmentId() {
		return _attachmentId;
	}

	public void setAttachmentId(long attachmentId) {
		_attachmentId = attachmentId;
	}

	public String getLocaleCode() {
		return _localeCode;
	}

	public void setLocaleCode(String localeCode) {
		_localeCode = localeCode;
	}

	public long getParentAttachmentId() {
		return _parentAttachmentId;
	}

	public void setParentAttachmentId(long parentAttachmentId) {
		_parentAttachmentId = parentAttachmentId;
	}

	public long getStdId() {
		return _stdId;
	}

	public void setStdId(long stdId) {
		_stdId = stdId;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getTranslationIndicator() {
		return _translationIndicator;
	}

	public void setTranslationIndicator(String translationIndicator) {
		_translationIndicator = translationIndicator;
	}

	public String getAttachmentPath() {
		return _attachmentPath;
	}

	public void setAttachmentPath(String attachmentPath) {
		_attachmentPath = attachmentPath;
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
	private String _localeCode;
	private long _parentAttachmentId;
	private long _stdId;
	private String _type;
	private String _title;
	private String _translationIndicator;
	private String _attachmentPath;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}