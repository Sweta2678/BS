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

package com.ihg.grs.common.model.impl;

import com.ihg.grs.common.model.Directory;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Directory in entity cache.
 *
 * @author gulam.vora
 * @see Directory
 * @generated
 */
public class DirectoryCacheModel implements CacheModel<Directory>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{directoryId=");
		sb.append(directoryId);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", businessTitle=");
		sb.append(businessTitle);
		sb.append(", geoRegion=");
		sb.append(geoRegion);
		sb.append(", role=");
		sb.append(role);
		sb.append(", regionType=");
		sb.append(regionType);
		sb.append(", organizationName=");
		sb.append(organizationName);
		sb.append(", portraitURL=");
		sb.append(portraitURL);
		sb.append(", createdate=");
		sb.append(createdate);
		sb.append(", createUserId=");
		sb.append(createUserId);
		sb.append(", lastUpdateUserId=");
		sb.append(lastUpdateUserId);
		sb.append(", updatedate=");
		sb.append(updatedate);
		sb.append(", email=");
		sb.append(email);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Directory toEntityModel() {
		DirectoryImpl directoryImpl = new DirectoryImpl();

		directoryImpl.setDirectoryId(directoryId);

		if (firstName == null) {
			directoryImpl.setFirstName(StringPool.BLANK);
		}
		else {
			directoryImpl.setFirstName(firstName);
		}

		if (lastName == null) {
			directoryImpl.setLastName(StringPool.BLANK);
		}
		else {
			directoryImpl.setLastName(lastName);
		}

		if (businessTitle == null) {
			directoryImpl.setBusinessTitle(StringPool.BLANK);
		}
		else {
			directoryImpl.setBusinessTitle(businessTitle);
		}

		if (geoRegion == null) {
			directoryImpl.setGeoRegion(StringPool.BLANK);
		}
		else {
			directoryImpl.setGeoRegion(geoRegion);
		}

		if (role == null) {
			directoryImpl.setRole(StringPool.BLANK);
		}
		else {
			directoryImpl.setRole(role);
		}

		if (regionType == null) {
			directoryImpl.setRegionType(StringPool.BLANK);
		}
		else {
			directoryImpl.setRegionType(regionType);
		}

		if (organizationName == null) {
			directoryImpl.setOrganizationName(StringPool.BLANK);
		}
		else {
			directoryImpl.setOrganizationName(organizationName);
		}

		if (portraitURL == null) {
			directoryImpl.setPortraitURL(StringPool.BLANK);
		}
		else {
			directoryImpl.setPortraitURL(portraitURL);
		}

		if (createdate == Long.MIN_VALUE) {
			directoryImpl.setCreatedate(null);
		}
		else {
			directoryImpl.setCreatedate(new Date(createdate));
		}

		if (createUserId == null) {
			directoryImpl.setCreateUserId(StringPool.BLANK);
		}
		else {
			directoryImpl.setCreateUserId(createUserId);
		}

		if (lastUpdateUserId == null) {
			directoryImpl.setLastUpdateUserId(StringPool.BLANK);
		}
		else {
			directoryImpl.setLastUpdateUserId(lastUpdateUserId);
		}

		if (updatedate == Long.MIN_VALUE) {
			directoryImpl.setUpdatedate(null);
		}
		else {
			directoryImpl.setUpdatedate(new Date(updatedate));
		}

		if (email == null) {
			directoryImpl.setEmail(StringPool.BLANK);
		}
		else {
			directoryImpl.setEmail(email);
		}

		directoryImpl.resetOriginalValues();

		return directoryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		directoryId = objectInput.readInt();
		firstName = objectInput.readUTF();
		lastName = objectInput.readUTF();
		businessTitle = objectInput.readUTF();
		geoRegion = objectInput.readUTF();
		role = objectInput.readUTF();
		regionType = objectInput.readUTF();
		organizationName = objectInput.readUTF();
		portraitURL = objectInput.readUTF();
		createdate = objectInput.readLong();
		createUserId = objectInput.readUTF();
		lastUpdateUserId = objectInput.readUTF();
		updatedate = objectInput.readLong();
		email = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeInt(directoryId);

		if (firstName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(firstName);
		}

		if (lastName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lastName);
		}

		if (businessTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(businessTitle);
		}

		if (geoRegion == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(geoRegion);
		}

		if (role == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(role);
		}

		if (regionType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(regionType);
		}

		if (organizationName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(organizationName);
		}

		if (portraitURL == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(portraitURL);
		}

		objectOutput.writeLong(createdate);

		if (createUserId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(createUserId);
		}

		if (lastUpdateUserId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lastUpdateUserId);
		}

		objectOutput.writeLong(updatedate);

		if (email == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(email);
		}
	}

	public int directoryId;
	public String firstName;
	public String lastName;
	public String businessTitle;
	public String geoRegion;
	public String role;
	public String regionType;
	public String organizationName;
	public String portraitURL;
	public long createdate;
	public String createUserId;
	public String lastUpdateUserId;
	public long updatedate;
	public String email;
}