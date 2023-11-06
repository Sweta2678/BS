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

import com.ihg.brandstandards.db.model.PublishCountryStandard;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PublishCountryStandard in entity cache.
 *
 * @author Mummanedi
 * @see PublishCountryStandard
 * @generated
 */
public class PublishCountryStandardCacheModel implements CacheModel<PublishCountryStandard>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{publishCountryStdId=");
		sb.append(publishCountryStdId);
		sb.append(", publishVerId=");
		sb.append(publishVerId);
		sb.append(", countryCode=");
		sb.append(countryCode);
		sb.append(", expiredRefTxt=");
		sb.append(expiredRefTxt);
		sb.append(", publishStatCode=");
		sb.append(publishStatCode);
		sb.append(", stdComplyDeadlineDate=");
		sb.append(stdComplyDeadlineDate);
		sb.append(", orderNumber=");
		sb.append(orderNumber);
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
	public PublishCountryStandard toEntityModel() {
		PublishCountryStandardImpl publishCountryStandardImpl = new PublishCountryStandardImpl();

		if (publishCountryStdId == null) {
			publishCountryStandardImpl.setPublishCountryStdId(StringPool.BLANK);
		}
		else {
			publishCountryStandardImpl.setPublishCountryStdId(publishCountryStdId);
		}

		publishCountryStandardImpl.setPublishVerId(publishVerId);

		if (countryCode == null) {
			publishCountryStandardImpl.setCountryCode(StringPool.BLANK);
		}
		else {
			publishCountryStandardImpl.setCountryCode(countryCode);
		}

		if (expiredRefTxt == null) {
			publishCountryStandardImpl.setExpiredRefTxt(StringPool.BLANK);
		}
		else {
			publishCountryStandardImpl.setExpiredRefTxt(expiredRefTxt);
		}

		if (publishStatCode == null) {
			publishCountryStandardImpl.setPublishStatCode(StringPool.BLANK);
		}
		else {
			publishCountryStandardImpl.setPublishStatCode(publishStatCode);
		}

		if (stdComplyDeadlineDate == Long.MIN_VALUE) {
			publishCountryStandardImpl.setStdComplyDeadlineDate(null);
		}
		else {
			publishCountryStandardImpl.setStdComplyDeadlineDate(new Date(
					stdComplyDeadlineDate));
		}

		publishCountryStandardImpl.setOrderNumber(orderNumber);

		if (creatorId == null) {
			publishCountryStandardImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			publishCountryStandardImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			publishCountryStandardImpl.setCreatedDate(null);
		}
		else {
			publishCountryStandardImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			publishCountryStandardImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			publishCountryStandardImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			publishCountryStandardImpl.setUpdatedDate(null);
		}
		else {
			publishCountryStandardImpl.setUpdatedDate(new Date(updatedDate));
		}

		publishCountryStandardImpl.resetOriginalValues();

		return publishCountryStandardImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		publishCountryStdId = objectInput.readUTF();
		publishVerId = objectInput.readLong();
		countryCode = objectInput.readUTF();
		expiredRefTxt = objectInput.readUTF();
		publishStatCode = objectInput.readUTF();
		stdComplyDeadlineDate = objectInput.readLong();
		orderNumber = objectInput.readLong();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (publishCountryStdId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(publishCountryStdId);
		}

		objectOutput.writeLong(publishVerId);

		if (countryCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(countryCode);
		}

		if (expiredRefTxt == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(expiredRefTxt);
		}

		if (publishStatCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(publishStatCode);
		}

		objectOutput.writeLong(stdComplyDeadlineDate);
		objectOutput.writeLong(orderNumber);

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

	public String publishCountryStdId;
	public long publishVerId;
	public String countryCode;
	public String expiredRefTxt;
	public String publishStatCode;
	public long stdComplyDeadlineDate;
	public long orderNumber;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}