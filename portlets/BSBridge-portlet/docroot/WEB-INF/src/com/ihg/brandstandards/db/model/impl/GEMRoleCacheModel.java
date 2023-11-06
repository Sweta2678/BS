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

import com.ihg.brandstandards.db.model.GEMRole;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing GEMRole in entity cache.
 *
 * @author Mummanedi
 * @see GEMRole
 * @generated
 */
public class GEMRoleCacheModel implements CacheModel<GEMRole>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{gemGrpId=");
		sb.append(gemGrpId);
		sb.append(", regionId=");
		sb.append(regionId);
		sb.append(", chainCode=");
		sb.append(chainCode);
		sb.append(", gemGrpCode=");
		sb.append(gemGrpCode);
		sb.append(", ownerGrpId=");
		sb.append(ownerGrpId);
		sb.append(", ownerGrpName=");
		sb.append(ownerGrpName);
		sb.append(", busOwnerName=");
		sb.append(busOwnerName);
		sb.append(", deligate1Name=");
		sb.append(deligate1Name);
		sb.append(", deligate2Name=");
		sb.append(deligate2Name);
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
	public GEMRole toEntityModel() {
		GEMRoleImpl gemRoleImpl = new GEMRoleImpl();

		gemRoleImpl.setGemGrpId(gemGrpId);
		gemRoleImpl.setRegionId(regionId);

		if (chainCode == null) {
			gemRoleImpl.setChainCode(StringPool.BLANK);
		}
		else {
			gemRoleImpl.setChainCode(chainCode);
		}

		if (gemGrpCode == null) {
			gemRoleImpl.setGemGrpCode(StringPool.BLANK);
		}
		else {
			gemRoleImpl.setGemGrpCode(gemGrpCode);
		}

		if (ownerGrpId == null) {
			gemRoleImpl.setOwnerGrpId(StringPool.BLANK);
		}
		else {
			gemRoleImpl.setOwnerGrpId(ownerGrpId);
		}

		if (ownerGrpName == null) {
			gemRoleImpl.setOwnerGrpName(StringPool.BLANK);
		}
		else {
			gemRoleImpl.setOwnerGrpName(ownerGrpName);
		}

		if (busOwnerName == null) {
			gemRoleImpl.setBusOwnerName(StringPool.BLANK);
		}
		else {
			gemRoleImpl.setBusOwnerName(busOwnerName);
		}

		if (deligate1Name == null) {
			gemRoleImpl.setDeligate1Name(StringPool.BLANK);
		}
		else {
			gemRoleImpl.setDeligate1Name(deligate1Name);
		}

		if (deligate2Name == null) {
			gemRoleImpl.setDeligate2Name(StringPool.BLANK);
		}
		else {
			gemRoleImpl.setDeligate2Name(deligate2Name);
		}

		if (creatorId == null) {
			gemRoleImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			gemRoleImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			gemRoleImpl.setCreatedDate(null);
		}
		else {
			gemRoleImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			gemRoleImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			gemRoleImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			gemRoleImpl.setUpdatedDate(null);
		}
		else {
			gemRoleImpl.setUpdatedDate(new Date(updatedDate));
		}

		gemRoleImpl.resetOriginalValues();

		return gemRoleImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		gemGrpId = objectInput.readLong();
		regionId = objectInput.readLong();
		chainCode = objectInput.readUTF();
		gemGrpCode = objectInput.readUTF();
		ownerGrpId = objectInput.readUTF();
		ownerGrpName = objectInput.readUTF();
		busOwnerName = objectInput.readUTF();
		deligate1Name = objectInput.readUTF();
		deligate2Name = objectInput.readUTF();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(gemGrpId);
		objectOutput.writeLong(regionId);

		if (chainCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(chainCode);
		}

		if (gemGrpCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(gemGrpCode);
		}

		if (ownerGrpId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ownerGrpId);
		}

		if (ownerGrpName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ownerGrpName);
		}

		if (busOwnerName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(busOwnerName);
		}

		if (deligate1Name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(deligate1Name);
		}

		if (deligate2Name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(deligate2Name);
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

	public long gemGrpId;
	public long regionId;
	public String chainCode;
	public String gemGrpCode;
	public String ownerGrpId;
	public String ownerGrpName;
	public String busOwnerName;
	public String deligate1Name;
	public String deligate2Name;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}