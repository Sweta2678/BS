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

import com.ihg.brandstandards.db.model.StandardsRegionChain;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing StandardsRegionChain in entity cache.
 *
 * @author Mummanedi
 * @see StandardsRegionChain
 * @generated
 */
public class StandardsRegionChainCacheModel implements CacheModel<StandardsRegionChain>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{stdId=");
		sb.append(stdId);
		sb.append(", regionCode=");
		sb.append(regionCode);
		sb.append(", chainCode=");
		sb.append(chainCode);
		sb.append(", compDate=");
		sb.append(compDate);
		sb.append(", expiredIds=");
		sb.append(expiredIds);
		sb.append(", complianceRule=");
		sb.append(complianceRule);
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
	public StandardsRegionChain toEntityModel() {
		StandardsRegionChainImpl standardsRegionChainImpl = new StandardsRegionChainImpl();

		standardsRegionChainImpl.setStdId(stdId);

		if (regionCode == null) {
			standardsRegionChainImpl.setRegionCode(StringPool.BLANK);
		}
		else {
			standardsRegionChainImpl.setRegionCode(regionCode);
		}

		if (chainCode == null) {
			standardsRegionChainImpl.setChainCode(StringPool.BLANK);
		}
		else {
			standardsRegionChainImpl.setChainCode(chainCode);
		}

		if (compDate == Long.MIN_VALUE) {
			standardsRegionChainImpl.setCompDate(null);
		}
		else {
			standardsRegionChainImpl.setCompDate(new Date(compDate));
		}

		if (expiredIds == null) {
			standardsRegionChainImpl.setExpiredIds(StringPool.BLANK);
		}
		else {
			standardsRegionChainImpl.setExpiredIds(expiredIds);
		}

		standardsRegionChainImpl.setComplianceRule(complianceRule);

		if (creatorId == null) {
			standardsRegionChainImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			standardsRegionChainImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			standardsRegionChainImpl.setCreatedDate(null);
		}
		else {
			standardsRegionChainImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			standardsRegionChainImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			standardsRegionChainImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			standardsRegionChainImpl.setUpdatedDate(null);
		}
		else {
			standardsRegionChainImpl.setUpdatedDate(new Date(updatedDate));
		}

		standardsRegionChainImpl.resetOriginalValues();

		return standardsRegionChainImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		stdId = objectInput.readLong();
		regionCode = objectInput.readUTF();
		chainCode = objectInput.readUTF();
		compDate = objectInput.readLong();
		expiredIds = objectInput.readUTF();
		complianceRule = objectInput.readLong();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(stdId);

		if (regionCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(regionCode);
		}

		if (chainCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(chainCode);
		}

		objectOutput.writeLong(compDate);

		if (expiredIds == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(expiredIds);
		}

		objectOutput.writeLong(complianceRule);

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
	public String regionCode;
	public String chainCode;
	public long compDate;
	public String expiredIds;
	public long complianceRule;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}