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
public class ChainAttachmentsStandardsSoap implements Serializable {
	public static ChainAttachmentsStandardsSoap toSoapModel(
		ChainAttachmentsStandards model) {
		ChainAttachmentsStandardsSoap soapModel = new ChainAttachmentsStandardsSoap();

		soapModel.setChainAttachmentId(model.getChainAttachmentId());
		soapModel.setAttachmentId(model.getAttachmentId());
		soapModel.setLocaleCode(model.getLocaleCode());
		soapModel.setChainCode(model.getChainCode());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static ChainAttachmentsStandardsSoap[] toSoapModels(
		ChainAttachmentsStandards[] models) {
		ChainAttachmentsStandardsSoap[] soapModels = new ChainAttachmentsStandardsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ChainAttachmentsStandardsSoap[][] toSoapModels(
		ChainAttachmentsStandards[][] models) {
		ChainAttachmentsStandardsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ChainAttachmentsStandardsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ChainAttachmentsStandardsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ChainAttachmentsStandardsSoap[] toSoapModels(
		List<ChainAttachmentsStandards> models) {
		List<ChainAttachmentsStandardsSoap> soapModels = new ArrayList<ChainAttachmentsStandardsSoap>(models.size());

		for (ChainAttachmentsStandards model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ChainAttachmentsStandardsSoap[soapModels.size()]);
	}

	public ChainAttachmentsStandardsSoap() {
	}

	public long getPrimaryKey() {
		return _chainAttachmentId;
	}

	public void setPrimaryKey(long pk) {
		setChainAttachmentId(pk);
	}

	public long getChainAttachmentId() {
		return _chainAttachmentId;
	}

	public void setChainAttachmentId(long chainAttachmentId) {
		_chainAttachmentId = chainAttachmentId;
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

	public String getChainCode() {
		return _chainCode;
	}

	public void setChainCode(String chainCode) {
		_chainCode = chainCode;
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

	private long _chainAttachmentId;
	private long _attachmentId;
	private String _localeCode;
	private String _chainCode;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}