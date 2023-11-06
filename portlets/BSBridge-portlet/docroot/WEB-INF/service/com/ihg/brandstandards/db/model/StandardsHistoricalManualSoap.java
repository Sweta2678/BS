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
public class StandardsHistoricalManualSoap implements Serializable {
	public static StandardsHistoricalManualSoap toSoapModel(
		StandardsHistoricalManual model) {
		StandardsHistoricalManualSoap soapModel = new StandardsHistoricalManualSoap();

		soapModel.setStdMnlId(model.getStdMnlId());
		soapModel.setStdId(model.getStdId());
		soapModel.setHistManualId(model.getHistManualId());
		soapModel.setChange(model.getChange());
		soapModel.setTitle(model.getTitle());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static StandardsHistoricalManualSoap[] toSoapModels(
		StandardsHistoricalManual[] models) {
		StandardsHistoricalManualSoap[] soapModels = new StandardsHistoricalManualSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StandardsHistoricalManualSoap[][] toSoapModels(
		StandardsHistoricalManual[][] models) {
		StandardsHistoricalManualSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StandardsHistoricalManualSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StandardsHistoricalManualSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StandardsHistoricalManualSoap[] toSoapModels(
		List<StandardsHistoricalManual> models) {
		List<StandardsHistoricalManualSoap> soapModels = new ArrayList<StandardsHistoricalManualSoap>(models.size());

		for (StandardsHistoricalManual model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StandardsHistoricalManualSoap[soapModels.size()]);
	}

	public StandardsHistoricalManualSoap() {
	}

	public long getPrimaryKey() {
		return _stdMnlId;
	}

	public void setPrimaryKey(long pk) {
		setStdMnlId(pk);
	}

	public long getStdMnlId() {
		return _stdMnlId;
	}

	public void setStdMnlId(long stdMnlId) {
		_stdMnlId = stdMnlId;
	}

	public long getStdId() {
		return _stdId;
	}

	public void setStdId(long stdId) {
		_stdId = stdId;
	}

	public long getHistManualId() {
		return _histManualId;
	}

	public void setHistManualId(long histManualId) {
		_histManualId = histManualId;
	}

	public String getChange() {
		return _change;
	}

	public void setChange(String change) {
		_change = change;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
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

	private long _stdMnlId;
	private long _stdId;
	private long _histManualId;
	private String _change;
	private String _title;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}