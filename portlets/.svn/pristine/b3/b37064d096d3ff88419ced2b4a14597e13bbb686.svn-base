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
public class SpreadSheetAttributeUpdateSoap implements Serializable {
	public static SpreadSheetAttributeUpdateSoap toSoapModel(
		SpreadSheetAttributeUpdate model) {
		SpreadSheetAttributeUpdateSoap soapModel = new SpreadSheetAttributeUpdateSoap();

		soapModel.setSpeardSheetId(model.getSpeardSheetId());
		soapModel.setRequestTitle(model.getRequestTitle());
		soapModel.setStatus(model.getStatus());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());
		soapModel.setSpreadSheet(model.getSpreadSheet());

		return soapModel;
	}

	public static SpreadSheetAttributeUpdateSoap[] toSoapModels(
		SpreadSheetAttributeUpdate[] models) {
		SpreadSheetAttributeUpdateSoap[] soapModels = new SpreadSheetAttributeUpdateSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SpreadSheetAttributeUpdateSoap[][] toSoapModels(
		SpreadSheetAttributeUpdate[][] models) {
		SpreadSheetAttributeUpdateSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SpreadSheetAttributeUpdateSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SpreadSheetAttributeUpdateSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SpreadSheetAttributeUpdateSoap[] toSoapModels(
		List<SpreadSheetAttributeUpdate> models) {
		List<SpreadSheetAttributeUpdateSoap> soapModels = new ArrayList<SpreadSheetAttributeUpdateSoap>(models.size());

		for (SpreadSheetAttributeUpdate model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SpreadSheetAttributeUpdateSoap[soapModels.size()]);
	}

	public SpreadSheetAttributeUpdateSoap() {
	}

	public long getPrimaryKey() {
		return _speardSheetId;
	}

	public void setPrimaryKey(long pk) {
		setSpeardSheetId(pk);
	}

	public long getSpeardSheetId() {
		return _speardSheetId;
	}

	public void setSpeardSheetId(long speardSheetId) {
		_speardSheetId = speardSheetId;
	}

	public String getRequestTitle() {
		return _requestTitle;
	}

	public void setRequestTitle(String requestTitle) {
		_requestTitle = requestTitle;
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

	public String getSpreadSheet() {
		return _spreadSheet;
	}

	public void setSpreadSheet(String spreadSheet) {
		_spreadSheet = spreadSheet;
	}

	private long _speardSheetId;
	private String _requestTitle;
	private String _status;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private String _spreadSheet;
}