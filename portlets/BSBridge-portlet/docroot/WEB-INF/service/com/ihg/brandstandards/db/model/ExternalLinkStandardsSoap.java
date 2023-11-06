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
public class ExternalLinkStandardsSoap implements Serializable {
	public static ExternalLinkStandardsSoap toSoapModel(
		ExternalLinkStandards model) {
		ExternalLinkStandardsSoap soapModel = new ExternalLinkStandardsSoap();

		soapModel.setExtLinkId(model.getExtLinkId());
		soapModel.setParentExtLinkId(model.getParentExtLinkId());
		soapModel.setStdId(model.getStdId());
		soapModel.setUrl(model.getUrl());
		soapModel.setTitle(model.getTitle());
		soapModel.setTranslationIndicator(model.getTranslationIndicator());
		soapModel.setLocaleCode(model.getLocaleCode());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static ExternalLinkStandardsSoap[] toSoapModels(
		ExternalLinkStandards[] models) {
		ExternalLinkStandardsSoap[] soapModels = new ExternalLinkStandardsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ExternalLinkStandardsSoap[][] toSoapModels(
		ExternalLinkStandards[][] models) {
		ExternalLinkStandardsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ExternalLinkStandardsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ExternalLinkStandardsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ExternalLinkStandardsSoap[] toSoapModels(
		List<ExternalLinkStandards> models) {
		List<ExternalLinkStandardsSoap> soapModels = new ArrayList<ExternalLinkStandardsSoap>(models.size());

		for (ExternalLinkStandards model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ExternalLinkStandardsSoap[soapModels.size()]);
	}

	public ExternalLinkStandardsSoap() {
	}

	public long getPrimaryKey() {
		return _extLinkId;
	}

	public void setPrimaryKey(long pk) {
		setExtLinkId(pk);
	}

	public long getExtLinkId() {
		return _extLinkId;
	}

	public void setExtLinkId(long extLinkId) {
		_extLinkId = extLinkId;
	}

	public long getParentExtLinkId() {
		return _parentExtLinkId;
	}

	public void setParentExtLinkId(long parentExtLinkId) {
		_parentExtLinkId = parentExtLinkId;
	}

	public long getStdId() {
		return _stdId;
	}

	public void setStdId(long stdId) {
		_stdId = stdId;
	}

	public String getUrl() {
		return _url;
	}

	public void setUrl(String url) {
		_url = url;
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

	private long _extLinkId;
	private long _parentExtLinkId;
	private long _stdId;
	private String _url;
	private String _title;
	private String _translationIndicator;
	private String _localeCode;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}