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

import com.ihg.brandstandards.db.model.BusImpactAssmt;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing BusImpactAssmt in entity cache.
 *
 * @author Mummanedi
 * @see BusImpactAssmt
 * @generated
 */
public class BusImpactAssmtCacheModel implements CacheModel<BusImpactAssmt>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{busImpactAssmtId=");
		sb.append(busImpactAssmtId);
		sb.append(", stdId=");
		sb.append(stdId);
		sb.append(", chain=");
		sb.append(chain);
		sb.append(", region=");
		sb.append(region);
		sb.append(", profileLossImpact=");
		sb.append(profileLossImpact);
		sb.append(", CapExpenseImpact=");
		sb.append(CapExpenseImpact);
		sb.append(", ImplTimeScale=");
		sb.append(ImplTimeScale);
		sb.append(", changeFromRegional=");
		sb.append(changeFromRegional);
		sb.append(", biaComments=");
		sb.append(biaComments);
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
	public BusImpactAssmt toEntityModel() {
		BusImpactAssmtImpl busImpactAssmtImpl = new BusImpactAssmtImpl();

		busImpactAssmtImpl.setBusImpactAssmtId(busImpactAssmtId);
		busImpactAssmtImpl.setStdId(stdId);

		if (chain == null) {
			busImpactAssmtImpl.setChain(StringPool.BLANK);
		}
		else {
			busImpactAssmtImpl.setChain(chain);
		}

		if (region == null) {
			busImpactAssmtImpl.setRegion(StringPool.BLANK);
		}
		else {
			busImpactAssmtImpl.setRegion(region);
		}

		if (profileLossImpact == null) {
			busImpactAssmtImpl.setProfileLossImpact(StringPool.BLANK);
		}
		else {
			busImpactAssmtImpl.setProfileLossImpact(profileLossImpact);
		}

		if (CapExpenseImpact == null) {
			busImpactAssmtImpl.setCapExpenseImpact(StringPool.BLANK);
		}
		else {
			busImpactAssmtImpl.setCapExpenseImpact(CapExpenseImpact);
		}

		if (ImplTimeScale == null) {
			busImpactAssmtImpl.setImplTimeScale(StringPool.BLANK);
		}
		else {
			busImpactAssmtImpl.setImplTimeScale(ImplTimeScale);
		}

		if (changeFromRegional == null) {
			busImpactAssmtImpl.setChangeFromRegional(StringPool.BLANK);
		}
		else {
			busImpactAssmtImpl.setChangeFromRegional(changeFromRegional);
		}

		if (biaComments == null) {
			busImpactAssmtImpl.setBiaComments(StringPool.BLANK);
		}
		else {
			busImpactAssmtImpl.setBiaComments(biaComments);
		}

		if (creatorId == null) {
			busImpactAssmtImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			busImpactAssmtImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			busImpactAssmtImpl.setCreatedDate(null);
		}
		else {
			busImpactAssmtImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			busImpactAssmtImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			busImpactAssmtImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			busImpactAssmtImpl.setUpdatedDate(null);
		}
		else {
			busImpactAssmtImpl.setUpdatedDate(new Date(updatedDate));
		}

		busImpactAssmtImpl.resetOriginalValues();

		return busImpactAssmtImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		busImpactAssmtId = objectInput.readLong();
		stdId = objectInput.readLong();
		chain = objectInput.readUTF();
		region = objectInput.readUTF();
		profileLossImpact = objectInput.readUTF();
		CapExpenseImpact = objectInput.readUTF();
		ImplTimeScale = objectInput.readUTF();
		changeFromRegional = objectInput.readUTF();
		biaComments = objectInput.readUTF();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(busImpactAssmtId);
		objectOutput.writeLong(stdId);

		if (chain == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(chain);
		}

		if (region == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(region);
		}

		if (profileLossImpact == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(profileLossImpact);
		}

		if (CapExpenseImpact == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(CapExpenseImpact);
		}

		if (ImplTimeScale == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ImplTimeScale);
		}

		if (changeFromRegional == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(changeFromRegional);
		}

		if (biaComments == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(biaComments);
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

	public long busImpactAssmtId;
	public long stdId;
	public String chain;
	public String region;
	public String profileLossImpact;
	public String CapExpenseImpact;
	public String ImplTimeScale;
	public String changeFromRegional;
	public String biaComments;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}