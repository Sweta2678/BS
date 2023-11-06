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

package com.ihg.brandstandards.db.model.impl;

import com.ihg.brandstandards.db.model.UserPreference;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing UserPreference in entity cache.
 *
 * @author Mummanedi
 * @see UserPreference
 * @generated
 */
public class UserPreferenceCacheModel implements CacheModel<UserPreference>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{preferenceId=");
		sb.append(preferenceId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", langCode=");
		sb.append(langCode);
		sb.append(", pdfLangCode=");
		sb.append(pdfLangCode);
		sb.append(", buildType=");
		sb.append(buildType);
		sb.append(", chainCode=");
		sb.append(chainCode);
		sb.append(", reportType=");
		sb.append(reportType);
		sb.append(", paperSize=");
		sb.append(paperSize);
		sb.append(", itemsPerPage=");
		sb.append(itemsPerPage);
		sb.append(", infoDisplay=");
		sb.append(infoDisplay);
		sb.append(", CountryCode=");
		sb.append(CountryCode);
		sb.append(", unsubscribeEmail=");
		sb.append(unsubscribeEmail);
		sb.append(", moduleName=");
		sb.append(moduleName);
		sb.append(", creatorId=");
		sb.append(creatorId);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", updatedBy=");
		sb.append(updatedBy);
		sb.append(", updatedDate=");
		sb.append(updatedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UserPreference toEntityModel() {
		UserPreferenceImpl userPreferenceImpl = new UserPreferenceImpl();

		userPreferenceImpl.setPreferenceId(preferenceId);
		userPreferenceImpl.setUserId(userId);

		if (langCode == null) {
			userPreferenceImpl.setLangCode(StringPool.BLANK);
		}
		else {
			userPreferenceImpl.setLangCode(langCode);
		}

		if (pdfLangCode == null) {
			userPreferenceImpl.setPdfLangCode(StringPool.BLANK);
		}
		else {
			userPreferenceImpl.setPdfLangCode(pdfLangCode);
		}

		if (buildType == null) {
			userPreferenceImpl.setBuildType(StringPool.BLANK);
		}
		else {
			userPreferenceImpl.setBuildType(buildType);
		}

		if (chainCode == null) {
			userPreferenceImpl.setChainCode(StringPool.BLANK);
		}
		else {
			userPreferenceImpl.setChainCode(chainCode);
		}

		if (reportType == null) {
			userPreferenceImpl.setReportType(StringPool.BLANK);
		}
		else {
			userPreferenceImpl.setReportType(reportType);
		}

		if (paperSize == null) {
			userPreferenceImpl.setPaperSize(StringPool.BLANK);
		}
		else {
			userPreferenceImpl.setPaperSize(paperSize);
		}

		if (itemsPerPage == null) {
			userPreferenceImpl.setItemsPerPage(StringPool.BLANK);
		}
		else {
			userPreferenceImpl.setItemsPerPage(itemsPerPage);
		}

		if (infoDisplay == null) {
			userPreferenceImpl.setInfoDisplay(StringPool.BLANK);
		}
		else {
			userPreferenceImpl.setInfoDisplay(infoDisplay);
		}

		if (CountryCode == null) {
			userPreferenceImpl.setCountryCode(StringPool.BLANK);
		}
		else {
			userPreferenceImpl.setCountryCode(CountryCode);
		}

		if (unsubscribeEmail == null) {
			userPreferenceImpl.setUnsubscribeEmail(StringPool.BLANK);
		}
		else {
			userPreferenceImpl.setUnsubscribeEmail(unsubscribeEmail);
		}

		if (moduleName == null) {
			userPreferenceImpl.setModuleName(StringPool.BLANK);
		}
		else {
			userPreferenceImpl.setModuleName(moduleName);
		}

		if (creatorId == null) {
			userPreferenceImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			userPreferenceImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			userPreferenceImpl.setCreatedDate(null);
		}
		else {
			userPreferenceImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			userPreferenceImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			userPreferenceImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			userPreferenceImpl.setUpdatedDate(null);
		}
		else {
			userPreferenceImpl.setUpdatedDate(new Date(updatedDate));
		}

		userPreferenceImpl.resetOriginalValues();

		return userPreferenceImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		preferenceId = objectInput.readLong();
		userId = objectInput.readLong();
		langCode = objectInput.readUTF();
		pdfLangCode = objectInput.readUTF();
		buildType = objectInput.readUTF();
		chainCode = objectInput.readUTF();
		reportType = objectInput.readUTF();
		paperSize = objectInput.readUTF();
		itemsPerPage = objectInput.readUTF();
		infoDisplay = objectInput.readUTF();
		CountryCode = objectInput.readUTF();
		unsubscribeEmail = objectInput.readUTF();
		moduleName = objectInput.readUTF();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(preferenceId);
		objectOutput.writeLong(userId);

		if (langCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(langCode);
		}

		if (pdfLangCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(pdfLangCode);
		}

		if (buildType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(buildType);
		}

		if (chainCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(chainCode);
		}

		if (reportType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(reportType);
		}

		if (paperSize == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(paperSize);
		}

		if (itemsPerPage == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(itemsPerPage);
		}

		if (infoDisplay == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(infoDisplay);
		}

		if (CountryCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(CountryCode);
		}

		if (unsubscribeEmail == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(unsubscribeEmail);
		}

		if (moduleName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(moduleName);
		}

		if (creatorId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(creatorId);
		}

		objectOutput.writeLong(createdDate);

		if (updatedBy == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(updatedBy);
		}

		objectOutput.writeLong(updatedDate);
	}

	public long preferenceId;
	public long userId;
	public String langCode;
	public String pdfLangCode;
	public String buildType;
	public String chainCode;
	public String reportType;
	public String paperSize;
	public String itemsPerPage;
	public String infoDisplay;
	public String CountryCode;
	public String unsubscribeEmail;
	public String moduleName;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}