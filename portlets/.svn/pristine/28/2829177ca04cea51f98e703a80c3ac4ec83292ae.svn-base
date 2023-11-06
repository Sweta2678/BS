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
public class PublishedPdfListSoap implements Serializable {
	public static PublishedPdfListSoap toSoapModel(PublishedPdfList model) {
		PublishedPdfListSoap soapModel = new PublishedPdfListSoap();

		soapModel.setPdfId(model.getPdfId());
		soapModel.setPdfChainCode(model.getPdfChainCode());
		soapModel.setPdfCtryCode(model.getPdfCtryCode());
		soapModel.setPdfBuildType(model.getPdfBuildType());
		soapModel.setPdfYearNumber(model.getPdfYearNumber());
		soapModel.setPdfLocaleCode(model.getPdfLocaleCode());
		soapModel.setPdfVersionNumber(model.getPdfVersionNumber());
		soapModel.setPdfFileName(model.getPdfFileName());
		soapModel.setPdfFileURLText(model.getPdfFileURLText());
		soapModel.setPublishId(model.getPublishId());
		soapModel.setPageSizeOrientationType(model.getPageSizeOrientationType());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static PublishedPdfListSoap[] toSoapModels(PublishedPdfList[] models) {
		PublishedPdfListSoap[] soapModels = new PublishedPdfListSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PublishedPdfListSoap[][] toSoapModels(
		PublishedPdfList[][] models) {
		PublishedPdfListSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PublishedPdfListSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PublishedPdfListSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PublishedPdfListSoap[] toSoapModels(
		List<PublishedPdfList> models) {
		List<PublishedPdfListSoap> soapModels = new ArrayList<PublishedPdfListSoap>(models.size());

		for (PublishedPdfList model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PublishedPdfListSoap[soapModels.size()]);
	}

	public PublishedPdfListSoap() {
	}

	public long getPrimaryKey() {
		return _pdfId;
	}

	public void setPrimaryKey(long pk) {
		setPdfId(pk);
	}

	public long getPdfId() {
		return _pdfId;
	}

	public void setPdfId(long pdfId) {
		_pdfId = pdfId;
	}

	public String getPdfChainCode() {
		return _pdfChainCode;
	}

	public void setPdfChainCode(String pdfChainCode) {
		_pdfChainCode = pdfChainCode;
	}

	public String getPdfCtryCode() {
		return _pdfCtryCode;
	}

	public void setPdfCtryCode(String pdfCtryCode) {
		_pdfCtryCode = pdfCtryCode;
	}

	public String getPdfBuildType() {
		return _pdfBuildType;
	}

	public void setPdfBuildType(String pdfBuildType) {
		_pdfBuildType = pdfBuildType;
	}

	public int getPdfYearNumber() {
		return _pdfYearNumber;
	}

	public void setPdfYearNumber(int pdfYearNumber) {
		_pdfYearNumber = pdfYearNumber;
	}

	public String getPdfLocaleCode() {
		return _pdfLocaleCode;
	}

	public void setPdfLocaleCode(String pdfLocaleCode) {
		_pdfLocaleCode = pdfLocaleCode;
	}

	public long getPdfVersionNumber() {
		return _pdfVersionNumber;
	}

	public void setPdfVersionNumber(long pdfVersionNumber) {
		_pdfVersionNumber = pdfVersionNumber;
	}

	public String getPdfFileName() {
		return _pdfFileName;
	}

	public void setPdfFileName(String pdfFileName) {
		_pdfFileName = pdfFileName;
	}

	public String getPdfFileURLText() {
		return _pdfFileURLText;
	}

	public void setPdfFileURLText(String pdfFileURLText) {
		_pdfFileURLText = pdfFileURLText;
	}

	public long getPublishId() {
		return _publishId;
	}

	public void setPublishId(long publishId) {
		_publishId = publishId;
	}

	public String getPageSizeOrientationType() {
		return _pageSizeOrientationType;
	}

	public void setPageSizeOrientationType(String pageSizeOrientationType) {
		_pageSizeOrientationType = pageSizeOrientationType;
	}

	public String getCreatedBy() {
		return _createdBy;
	}

	public void setCreatedBy(String createdBy) {
		_createdBy = createdBy;
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

	private long _pdfId;
	private String _pdfChainCode;
	private String _pdfCtryCode;
	private String _pdfBuildType;
	private int _pdfYearNumber;
	private String _pdfLocaleCode;
	private long _pdfVersionNumber;
	private String _pdfFileName;
	private String _pdfFileURLText;
	private long _publishId;
	private String _pageSizeOrientationType;
	private String _createdBy;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}