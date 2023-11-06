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

import com.ihg.brandstandards.db.model.StandardsCountryChain;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing StandardsCountryChain in entity cache.
 *
 * @author Mummanedi
 * @see StandardsCountryChain
 * @generated
 */
public class StandardsCountryChainCacheModel implements CacheModel<StandardsCountryChain>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{stdId=");
		sb.append(stdId);
		sb.append(", countryCode=");
		sb.append(countryCode);
		sb.append(", chainCode=");
		sb.append(chainCode);
		sb.append(", regionCode=");
		sb.append(regionCode);
		sb.append(", compDate=");
		sb.append(compDate);
		sb.append(", exprDate=");
		sb.append(exprDate);
		sb.append(", expiredIds=");
		sb.append(expiredIds);
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
	public StandardsCountryChain toEntityModel() {
		StandardsCountryChainImpl standardsCountryChainImpl = new StandardsCountryChainImpl();

		standardsCountryChainImpl.setStdId(stdId);

		if (countryCode == null) {
			standardsCountryChainImpl.setCountryCode(StringPool.BLANK);
		}
		else {
			standardsCountryChainImpl.setCountryCode(countryCode);
		}

		if (chainCode == null) {
			standardsCountryChainImpl.setChainCode(StringPool.BLANK);
		}
		else {
			standardsCountryChainImpl.setChainCode(chainCode);
		}

		if (regionCode == null) {
			standardsCountryChainImpl.setRegionCode(StringPool.BLANK);
		}
		else {
			standardsCountryChainImpl.setRegionCode(regionCode);
		}

		if (compDate == Long.MIN_VALUE) {
			standardsCountryChainImpl.setCompDate(null);
		}
		else {
			standardsCountryChainImpl.setCompDate(new Date(compDate));
		}

		if (exprDate == Long.MIN_VALUE) {
			standardsCountryChainImpl.setExprDate(null);
		}
		else {
			standardsCountryChainImpl.setExprDate(new Date(exprDate));
		}

		if (expiredIds == null) {
			standardsCountryChainImpl.setExpiredIds(StringPool.BLANK);
		}
		else {
			standardsCountryChainImpl.setExpiredIds(expiredIds);
		}

		if (creatorId == null) {
			standardsCountryChainImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			standardsCountryChainImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			standardsCountryChainImpl.setCreatedDate(null);
		}
		else {
			standardsCountryChainImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			standardsCountryChainImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			standardsCountryChainImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			standardsCountryChainImpl.setUpdatedDate(null);
		}
		else {
			standardsCountryChainImpl.setUpdatedDate(new Date(updatedDate));
		}

		standardsCountryChainImpl.resetOriginalValues();

		return standardsCountryChainImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		stdId = objectInput.readLong();
		countryCode = objectInput.readUTF();
		chainCode = objectInput.readUTF();
		regionCode = objectInput.readUTF();
		compDate = objectInput.readLong();
		exprDate = objectInput.readLong();
		expiredIds = objectInput.readUTF();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(stdId);

		if (countryCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(countryCode);
		}

		if (chainCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(chainCode);
		}

		if (regionCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(regionCode);
		}

		objectOutput.writeLong(compDate);
		objectOutput.writeLong(exprDate);

		if (expiredIds == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(expiredIds);
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

	public long stdId;
	public String countryCode;
	public String chainCode;
	public String regionCode;
	public long compDate;
	public long exprDate;
	public String expiredIds;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}