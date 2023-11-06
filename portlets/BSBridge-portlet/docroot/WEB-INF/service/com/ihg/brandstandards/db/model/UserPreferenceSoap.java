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
public class UserPreferenceSoap implements Serializable {
	public static UserPreferenceSoap toSoapModel(UserPreference model) {
		UserPreferenceSoap soapModel = new UserPreferenceSoap();

		soapModel.setPreferenceId(model.getPreferenceId());
		soapModel.setUserId(model.getUserId());
		soapModel.setLangCode(model.getLangCode());
		soapModel.setPdfLangCode(model.getPdfLangCode());
		soapModel.setBuildType(model.getBuildType());
		soapModel.setChainCode(model.getChainCode());
		soapModel.setReportType(model.getReportType());
		soapModel.setPaperSize(model.getPaperSize());
		soapModel.setItemsPerPage(model.getItemsPerPage());
		soapModel.setInfoDisplay(model.getInfoDisplay());
		soapModel.setCountryCode(model.getCountryCode());
		soapModel.setUnsubscribeEmail(model.getUnsubscribeEmail());
		soapModel.setModuleName(model.getModuleName());
		soapModel.setCreatorId(model.getCreatorId());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setUpdatedDate(model.getUpdatedDate());

		return soapModel;
	}

	public static UserPreferenceSoap[] toSoapModels(UserPreference[] models) {
		UserPreferenceSoap[] soapModels = new UserPreferenceSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserPreferenceSoap[][] toSoapModels(UserPreference[][] models) {
		UserPreferenceSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UserPreferenceSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UserPreferenceSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserPreferenceSoap[] toSoapModels(List<UserPreference> models) {
		List<UserPreferenceSoap> soapModels = new ArrayList<UserPreferenceSoap>(models.size());

		for (UserPreference model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UserPreferenceSoap[soapModels.size()]);
	}

	public UserPreferenceSoap() {
	}

	public long getPrimaryKey() {
		return _preferenceId;
	}

	public void setPrimaryKey(long pk) {
		setPreferenceId(pk);
	}

	public long getPreferenceId() {
		return _preferenceId;
	}

	public void setPreferenceId(long preferenceId) {
		_preferenceId = preferenceId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getLangCode() {
		return _langCode;
	}

	public void setLangCode(String langCode) {
		_langCode = langCode;
	}

	public String getPdfLangCode() {
		return _pdfLangCode;
	}

	public void setPdfLangCode(String pdfLangCode) {
		_pdfLangCode = pdfLangCode;
	}

	public String getBuildType() {
		return _buildType;
	}

	public void setBuildType(String buildType) {
		_buildType = buildType;
	}

	public String getChainCode() {
		return _chainCode;
	}

	public void setChainCode(String chainCode) {
		_chainCode = chainCode;
	}

	public String getReportType() {
		return _reportType;
	}

	public void setReportType(String reportType) {
		_reportType = reportType;
	}

	public String getPaperSize() {
		return _paperSize;
	}

	public void setPaperSize(String paperSize) {
		_paperSize = paperSize;
	}

	public String getItemsPerPage() {
		return _itemsPerPage;
	}

	public void setItemsPerPage(String itemsPerPage) {
		_itemsPerPage = itemsPerPage;
	}

	public String getInfoDisplay() {
		return _infoDisplay;
	}

	public void setInfoDisplay(String infoDisplay) {
		_infoDisplay = infoDisplay;
	}

	public String getCountryCode() {
		return _CountryCode;
	}

	public void setCountryCode(String CountryCode) {
		_CountryCode = CountryCode;
	}

	public String getUnsubscribeEmail() {
		return _unsubscribeEmail;
	}

	public void setUnsubscribeEmail(String unsubscribeEmail) {
		_unsubscribeEmail = unsubscribeEmail;
	}

	public String getModuleName() {
		return _moduleName;
	}

	public void setModuleName(String moduleName) {
		_moduleName = moduleName;
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

	private long _preferenceId;
	private long _userId;
	private String _langCode;
	private String _pdfLangCode;
	private String _buildType;
	private String _chainCode;
	private String _reportType;
	private String _paperSize;
	private String _itemsPerPage;
	private String _infoDisplay;
	private String _CountryCode;
	private String _unsubscribeEmail;
	private String _moduleName;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
}