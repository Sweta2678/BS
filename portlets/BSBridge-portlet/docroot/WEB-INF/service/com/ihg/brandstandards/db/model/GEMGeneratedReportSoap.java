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
public class GEMGeneratedReportSoap implements Serializable {
	public static GEMGeneratedReportSoap toSoapModel(GEMGeneratedReport model) {
		GEMGeneratedReportSoap soapModel = new GEMGeneratedReportSoap();

		soapModel.setReportId(model.getReportId());
		soapModel.setTemplateId(model.getTemplateId());
		soapModel.setUniqueGroupId(model.getUniqueGroupId());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static GEMGeneratedReportSoap[] toSoapModels(
		GEMGeneratedReport[] models) {
		GEMGeneratedReportSoap[] soapModels = new GEMGeneratedReportSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GEMGeneratedReportSoap[][] toSoapModels(
		GEMGeneratedReport[][] models) {
		GEMGeneratedReportSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GEMGeneratedReportSoap[models.length][models[0].length];
		}
		else {
			soapModels = new GEMGeneratedReportSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GEMGeneratedReportSoap[] toSoapModels(
		List<GEMGeneratedReport> models) {
		List<GEMGeneratedReportSoap> soapModels = new ArrayList<GEMGeneratedReportSoap>(models.size());

		for (GEMGeneratedReport model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GEMGeneratedReportSoap[soapModels.size()]);
	}

	public GEMGeneratedReportSoap() {
	}

	public long getPrimaryKey() {
		return _reportId;
	}

	public void setPrimaryKey(long pk) {
		setReportId(pk);
	}

	public long getReportId() {
		return _reportId;
	}

	public void setReportId(long reportId) {
		_reportId = reportId;
	}

	public long getTemplateId() {
		return _templateId;
	}

	public void setTemplateId(long templateId) {
		_templateId = templateId;
	}

	public long getUniqueGroupId() {
		return _uniqueGroupId;
	}

	public void setUniqueGroupId(long uniqueGroupId) {
		_uniqueGroupId = uniqueGroupId;
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

	private long _reportId;
	private long _templateId;
	private long _uniqueGroupId;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}