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
public class PublicationSoap implements Serializable {
	public static PublicationSoap toSoapModel(Publication model) {
		PublicationSoap soapModel = new PublicationSoap();

		soapModel.setPublishId(model.getPublishId());
		soapModel.setPublishVerId(model.getPublishVerId());
		soapModel.setPublishStatCd(model.getPublishStatCd());
		soapModel.setChainCode(model.getChainCode());
		soapModel.setPublishEnvName(model.getPublishEnvName());
		soapModel.setPublishLocaleList(model.getPublishLocaleList());
		soapModel.setPublishDate(model.getPublishDate());
		soapModel.setPublishContentType(model.getPublishContentType());
		soapModel.setParentPublishId(model.getParentPublishId());
		soapModel.setValidateTranslation(model.getValidateTranslation());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static PublicationSoap[] toSoapModels(Publication[] models) {
		PublicationSoap[] soapModels = new PublicationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PublicationSoap[][] toSoapModels(Publication[][] models) {
		PublicationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PublicationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PublicationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PublicationSoap[] toSoapModels(List<Publication> models) {
		List<PublicationSoap> soapModels = new ArrayList<PublicationSoap>(models.size());

		for (Publication model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PublicationSoap[soapModels.size()]);
	}

	public PublicationSoap() {
	}

	public long getPrimaryKey() {
		return _publishId;
	}

	public void setPrimaryKey(long pk) {
		setPublishId(pk);
	}

	public long getPublishId() {
		return _publishId;
	}

	public void setPublishId(long publishId) {
		_publishId = publishId;
	}

	public long getPublishVerId() {
		return _publishVerId;
	}

	public void setPublishVerId(long publishVerId) {
		_publishVerId = publishVerId;
	}

	public String getPublishStatCd() {
		return _publishStatCd;
	}

	public void setPublishStatCd(String publishStatCd) {
		_publishStatCd = publishStatCd;
	}

	public String getChainCode() {
		return _chainCode;
	}

	public void setChainCode(String chainCode) {
		_chainCode = chainCode;
	}

	public String getPublishEnvName() {
		return _publishEnvName;
	}

	public void setPublishEnvName(String publishEnvName) {
		_publishEnvName = publishEnvName;
	}

	public String getPublishLocaleList() {
		return _publishLocaleList;
	}

	public void setPublishLocaleList(String publishLocaleList) {
		_publishLocaleList = publishLocaleList;
	}

	public Date getPublishDate() {
		return _publishDate;
	}

	public void setPublishDate(Date publishDate) {
		_publishDate = publishDate;
	}

	public String getPublishContentType() {
		return _publishContentType;
	}

	public void setPublishContentType(String publishContentType) {
		_publishContentType = publishContentType;
	}

	public long getParentPublishId() {
		return _parentPublishId;
	}

	public void setParentPublishId(long parentPublishId) {
		_parentPublishId = parentPublishId;
	}

	public String getValidateTranslation() {
		return _validateTranslation;
	}

	public void setValidateTranslation(String validateTranslation) {
		_validateTranslation = validateTranslation;
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

	private long _publishId;
	private long _publishVerId;
	private String _publishStatCd;
	private String _chainCode;
	private String _publishEnvName;
	private String _publishLocaleList;
	private Date _publishDate;
	private String _publishContentType;
	private long _parentPublishId;
	private String _validateTranslation;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}