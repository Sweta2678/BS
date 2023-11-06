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

import com.ihg.brandstandards.db.model.PublishedPdfList;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PublishedPdfList in entity cache.
 *
 * @author Mummanedi
 * @see PublishedPdfList
 * @generated
 */
public class PublishedPdfListCacheModel implements CacheModel<PublishedPdfList>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{pdfId=");
		sb.append(pdfId);
		sb.append(", pdfChainCode=");
		sb.append(pdfChainCode);
		sb.append(", pdfCtryCode=");
		sb.append(pdfCtryCode);
		sb.append(", pdfBuildType=");
		sb.append(pdfBuildType);
		sb.append(", pdfYearNumber=");
		sb.append(pdfYearNumber);
		sb.append(", pdfLocaleCode=");
		sb.append(pdfLocaleCode);
		sb.append(", pdfVersionNumber=");
		sb.append(pdfVersionNumber);
		sb.append(", pdfFileName=");
		sb.append(pdfFileName);
		sb.append(", pdfFileURLText=");
		sb.append(pdfFileURLText);
		sb.append(", publishId=");
		sb.append(publishId);
		sb.append(", pageSizeOrientationType=");
		sb.append(pageSizeOrientationType);
		sb.append(", createdBy=");
		sb.append(createdBy);
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
	public PublishedPdfList toEntityModel() {
		PublishedPdfListImpl publishedPdfListImpl = new PublishedPdfListImpl();

		publishedPdfListImpl.setPdfId(pdfId);

		if (pdfChainCode == null) {
			publishedPdfListImpl.setPdfChainCode(StringPool.BLANK);
		}
		else {
			publishedPdfListImpl.setPdfChainCode(pdfChainCode);
		}

		if (pdfCtryCode == null) {
			publishedPdfListImpl.setPdfCtryCode(StringPool.BLANK);
		}
		else {
			publishedPdfListImpl.setPdfCtryCode(pdfCtryCode);
		}

		if (pdfBuildType == null) {
			publishedPdfListImpl.setPdfBuildType(StringPool.BLANK);
		}
		else {
			publishedPdfListImpl.setPdfBuildType(pdfBuildType);
		}

		publishedPdfListImpl.setPdfYearNumber(pdfYearNumber);

		if (pdfLocaleCode == null) {
			publishedPdfListImpl.setPdfLocaleCode(StringPool.BLANK);
		}
		else {
			publishedPdfListImpl.setPdfLocaleCode(pdfLocaleCode);
		}

		publishedPdfListImpl.setPdfVersionNumber(pdfVersionNumber);

		if (pdfFileName == null) {
			publishedPdfListImpl.setPdfFileName(StringPool.BLANK);
		}
		else {
			publishedPdfListImpl.setPdfFileName(pdfFileName);
		}

		if (pdfFileURLText == null) {
			publishedPdfListImpl.setPdfFileURLText(StringPool.BLANK);
		}
		else {
			publishedPdfListImpl.setPdfFileURLText(pdfFileURLText);
		}

		publishedPdfListImpl.setPublishId(publishId);

		if (pageSizeOrientationType == null) {
			publishedPdfListImpl.setPageSizeOrientationType(StringPool.BLANK);
		}
		else {
			publishedPdfListImpl.setPageSizeOrientationType(pageSizeOrientationType);
		}

		if (createdBy == null) {
			publishedPdfListImpl.setCreatedBy(StringPool.BLANK);
		}
		else {
			publishedPdfListImpl.setCreatedBy(createdBy);
		}

		if (createdDate == Long.MIN_VALUE) {
			publishedPdfListImpl.setCreatedDate(null);
		}
		else {
			publishedPdfListImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			publishedPdfListImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			publishedPdfListImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			publishedPdfListImpl.setUpdatedDate(null);
		}
		else {
			publishedPdfListImpl.setUpdatedDate(new Date(updatedDate));
		}

		publishedPdfListImpl.resetOriginalValues();

		return publishedPdfListImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		pdfId = objectInput.readLong();
		pdfChainCode = objectInput.readUTF();
		pdfCtryCode = objectInput.readUTF();
		pdfBuildType = objectInput.readUTF();
		pdfYearNumber = objectInput.readInt();
		pdfLocaleCode = objectInput.readUTF();
		pdfVersionNumber = objectInput.readLong();
		pdfFileName = objectInput.readUTF();
		pdfFileURLText = objectInput.readUTF();
		publishId = objectInput.readLong();
		pageSizeOrientationType = objectInput.readUTF();
		createdBy = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(pdfId);

		if (pdfChainCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(pdfChainCode);
		}

		if (pdfCtryCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(pdfCtryCode);
		}

		if (pdfBuildType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(pdfBuildType);
		}

		objectOutput.writeInt(pdfYearNumber);

		if (pdfLocaleCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(pdfLocaleCode);
		}

		objectOutput.writeLong(pdfVersionNumber);

		if (pdfFileName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(pdfFileName);
		}

		if (pdfFileURLText == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(pdfFileURLText);
		}

		objectOutput.writeLong(publishId);

		if (pageSizeOrientationType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(pageSizeOrientationType);
		}

		if (createdBy == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(createdBy);
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

	public long pdfId;
	public String pdfChainCode;
	public String pdfCtryCode;
	public String pdfBuildType;
	public int pdfYearNumber;
	public String pdfLocaleCode;
	public long pdfVersionNumber;
	public String pdfFileName;
	public String pdfFileURLText;
	public long publishId;
	public String pageSizeOrientationType;
	public String createdBy;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}