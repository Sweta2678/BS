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

import com.ihg.brandstandards.db.model.Publication;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Publication in entity cache.
 *
 * @author Mummanedi
 * @see Publication
 * @generated
 */
public class PublicationCacheModel implements CacheModel<Publication>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{publishId=");
		sb.append(publishId);
		sb.append(", publishVerId=");
		sb.append(publishVerId);
		sb.append(", publishStatCd=");
		sb.append(publishStatCd);
		sb.append(", chainCode=");
		sb.append(chainCode);
		sb.append(", publishEnvName=");
		sb.append(publishEnvName);
		sb.append(", publishLocaleList=");
		sb.append(publishLocaleList);
		sb.append(", publishDate=");
		sb.append(publishDate);
		sb.append(", publishContentType=");
		sb.append(publishContentType);
		sb.append(", parentPublishId=");
		sb.append(parentPublishId);
		sb.append(", validateTranslation=");
		sb.append(validateTranslation);
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
	public Publication toEntityModel() {
		PublicationImpl publicationImpl = new PublicationImpl();

		publicationImpl.setPublishId(publishId);
		publicationImpl.setPublishVerId(publishVerId);

		if (publishStatCd == null) {
			publicationImpl.setPublishStatCd(StringPool.BLANK);
		}
		else {
			publicationImpl.setPublishStatCd(publishStatCd);
		}

		if (chainCode == null) {
			publicationImpl.setChainCode(StringPool.BLANK);
		}
		else {
			publicationImpl.setChainCode(chainCode);
		}

		if (publishEnvName == null) {
			publicationImpl.setPublishEnvName(StringPool.BLANK);
		}
		else {
			publicationImpl.setPublishEnvName(publishEnvName);
		}

		if (publishLocaleList == null) {
			publicationImpl.setPublishLocaleList(StringPool.BLANK);
		}
		else {
			publicationImpl.setPublishLocaleList(publishLocaleList);
		}

		if (publishDate == Long.MIN_VALUE) {
			publicationImpl.setPublishDate(null);
		}
		else {
			publicationImpl.setPublishDate(new Date(publishDate));
		}

		if (publishContentType == null) {
			publicationImpl.setPublishContentType(StringPool.BLANK);
		}
		else {
			publicationImpl.setPublishContentType(publishContentType);
		}

		publicationImpl.setParentPublishId(parentPublishId);

		if (validateTranslation == null) {
			publicationImpl.setValidateTranslation(StringPool.BLANK);
		}
		else {
			publicationImpl.setValidateTranslation(validateTranslation);
		}

		if (creatorId == null) {
			publicationImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			publicationImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			publicationImpl.setCreatedDate(null);
		}
		else {
			publicationImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			publicationImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			publicationImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			publicationImpl.setUpdatedDate(null);
		}
		else {
			publicationImpl.setUpdatedDate(new Date(updatedDate));
		}

		publicationImpl.resetOriginalValues();

		return publicationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		publishId = objectInput.readLong();
		publishVerId = objectInput.readLong();
		publishStatCd = objectInput.readUTF();
		chainCode = objectInput.readUTF();
		publishEnvName = objectInput.readUTF();
		publishLocaleList = objectInput.readUTF();
		publishDate = objectInput.readLong();
		publishContentType = objectInput.readUTF();
		parentPublishId = objectInput.readLong();
		validateTranslation = objectInput.readUTF();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(publishId);
		objectOutput.writeLong(publishVerId);

		if (publishStatCd == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(publishStatCd);
		}

		if (chainCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(chainCode);
		}

		if (publishEnvName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(publishEnvName);
		}

		if (publishLocaleList == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(publishLocaleList);
		}

		objectOutput.writeLong(publishDate);

		if (publishContentType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(publishContentType);
		}

		objectOutput.writeLong(parentPublishId);

		if (validateTranslation == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(validateTranslation);
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

	public long publishId;
	public long publishVerId;
	public String publishStatCd;
	public String chainCode;
	public String publishEnvName;
	public String publishLocaleList;
	public long publishDate;
	public String publishContentType;
	public long parentPublishId;
	public String validateTranslation;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}