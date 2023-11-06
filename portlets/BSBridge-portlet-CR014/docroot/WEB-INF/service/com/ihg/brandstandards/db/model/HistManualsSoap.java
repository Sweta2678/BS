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
public class HistManualsSoap implements Serializable {
	public static HistManualsSoap toSoapModel(HistManuals model) {
		HistManualsSoap soapModel = new HistManualsSoap();

		soapModel.setHistManualId(model.getHistManualId());
		soapModel.setTitle(model.getTitle());
		soapModel.setType(model.getType());
		soapModel.setPubDate(model.getPubDate());
		soapModel.setStatus(model.getStatus());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static HistManualsSoap[] toSoapModels(HistManuals[] models) {
		HistManualsSoap[] soapModels = new HistManualsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static HistManualsSoap[][] toSoapModels(HistManuals[][] models) {
		HistManualsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new HistManualsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new HistManualsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static HistManualsSoap[] toSoapModels(List<HistManuals> models) {
		List<HistManualsSoap> soapModels = new ArrayList<HistManualsSoap>(models.size());

		for (HistManuals model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new HistManualsSoap[soapModels.size()]);
	}

	public HistManualsSoap() {
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

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	public Date getPubDate() {
		return _pubDate;
	}

	public void setPubDate(Date pubDate) {
		_pubDate = pubDate;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
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
	private String _title;
	private String _type;
	private Date _pubDate;
	private String _status;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}