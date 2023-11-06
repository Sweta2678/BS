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
public class GEMTemplateReferenceSoap implements Serializable {
	public static GEMTemplateReferenceSoap toSoapModel(
		GEMTemplateReference model) {
		GEMTemplateReferenceSoap soapModel = new GEMTemplateReferenceSoap();

		soapModel.setTemplateRefId(model.getTemplateRefId());
		soapModel.setTemplateId(model.getTemplateId());
		soapModel.setPublishDeptId(model.getPublishDeptId());
		soapModel.setRegionId(model.getRegionId());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static GEMTemplateReferenceSoap[] toSoapModels(
		GEMTemplateReference[] models) {
		GEMTemplateReferenceSoap[] soapModels = new GEMTemplateReferenceSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GEMTemplateReferenceSoap[][] toSoapModels(
		GEMTemplateReference[][] models) {
		GEMTemplateReferenceSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GEMTemplateReferenceSoap[models.length][models[0].length];
		}
		else {
			soapModels = new GEMTemplateReferenceSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GEMTemplateReferenceSoap[] toSoapModels(
		List<GEMTemplateReference> models) {
		List<GEMTemplateReferenceSoap> soapModels = new ArrayList<GEMTemplateReferenceSoap>(models.size());

		for (GEMTemplateReference model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GEMTemplateReferenceSoap[soapModels.size()]);
	}

	public GEMTemplateReferenceSoap() {
	}

	public long getPrimaryKey() {
		return _templateRefId;
	}

	public void setPrimaryKey(long pk) {
		setTemplateRefId(pk);
	}

	public long getTemplateRefId() {
		return _templateRefId;
	}

	public void setTemplateRefId(long templateRefId) {
		_templateRefId = templateRefId;
	}

	public long getTemplateId() {
		return _templateId;
	}

	public void setTemplateId(long templateId) {
		_templateId = templateId;
	}

	public long getPublishDeptId() {
		return _publishDeptId;
	}

	public void setPublishDeptId(long publishDeptId) {
		_publishDeptId = publishDeptId;
	}

	public long getRegionId() {
		return _regionId;
	}

	public void setRegionId(long regionId) {
		_regionId = regionId;
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

	private long _templateRefId;
	private long _templateId;
	private long _publishDeptId;
	private long _regionId;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}