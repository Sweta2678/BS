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
public class GEMTemplateSoap implements Serializable {
	public static GEMTemplateSoap toSoapModel(GEMTemplate model) {
		GEMTemplateSoap soapModel = new GEMTemplateSoap();

		soapModel.setTemplateId(model.getTemplateId());
		soapModel.setTemplateName(model.getTemplateName());
		soapModel.setPublishId(model.getPublishId());
		soapModel.setRegionId(model.getRegionId());
		soapModel.setTemplateType(model.getTemplateType());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static GEMTemplateSoap[] toSoapModels(GEMTemplate[] models) {
		GEMTemplateSoap[] soapModels = new GEMTemplateSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GEMTemplateSoap[][] toSoapModels(GEMTemplate[][] models) {
		GEMTemplateSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GEMTemplateSoap[models.length][models[0].length];
		}
		else {
			soapModels = new GEMTemplateSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GEMTemplateSoap[] toSoapModels(List<GEMTemplate> models) {
		List<GEMTemplateSoap> soapModels = new ArrayList<GEMTemplateSoap>(models.size());

		for (GEMTemplate model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GEMTemplateSoap[soapModels.size()]);
	}

	public GEMTemplateSoap() {
	}

	public long getPrimaryKey() {
		return _templateId;
	}

	public void setPrimaryKey(long pk) {
		setTemplateId(pk);
	}

	public long getTemplateId() {
		return _templateId;
	}

	public void setTemplateId(long templateId) {
		_templateId = templateId;
	}

	public String getTemplateName() {
		return _templateName;
	}

	public void setTemplateName(String templateName) {
		_templateName = templateName;
	}

	public long getPublishId() {
		return _publishId;
	}

	public void setPublishId(long publishId) {
		_publishId = publishId;
	}

	public long getRegionId() {
		return _regionId;
	}

	public void setRegionId(long regionId) {
		_regionId = regionId;
	}

	public String getTemplateType() {
		return _templateType;
	}

	public void setTemplateType(String templateType) {
		_templateType = templateType;
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

	private long _templateId;
	private String _templateName;
	private long _publishId;
	private long _regionId;
	private String _templateType;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}