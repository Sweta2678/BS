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
public class HistManualAttachmentSoap implements Serializable {
	public static HistManualAttachmentSoap toSoapModel(
		HistManualAttachment model) {
		HistManualAttachmentSoap soapModel = new HistManualAttachmentSoap();

		soapModel.setHistManualId(model.getHistManualId());
		soapModel.setAttachmentPath(model.getAttachmentPath());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static HistManualAttachmentSoap[] toSoapModels(
		HistManualAttachment[] models) {
		HistManualAttachmentSoap[] soapModels = new HistManualAttachmentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static HistManualAttachmentSoap[][] toSoapModels(
		HistManualAttachment[][] models) {
		HistManualAttachmentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new HistManualAttachmentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new HistManualAttachmentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static HistManualAttachmentSoap[] toSoapModels(
		List<HistManualAttachment> models) {
		List<HistManualAttachmentSoap> soapModels = new ArrayList<HistManualAttachmentSoap>(models.size());

		for (HistManualAttachment model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new HistManualAttachmentSoap[soapModels.size()]);
	}

	public HistManualAttachmentSoap() {
	}

	public long getPrimaryKey() {
		return _histManualId;
	}

	public void setPrimaryKey(long pk) {
		setHistManualId(pk);
	}

	public long getHistManualId() {
		return _histManualId;
	}

	public void setHistManualId(long histManualId) {
		_histManualId = histManualId;
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

	private long _histManualId;
	private String _attachmentPath;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}