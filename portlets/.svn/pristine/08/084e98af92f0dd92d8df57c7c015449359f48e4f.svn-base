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

import com.ihg.brandstandards.db.model.PublishExtStd;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PublishExtStd in entity cache.
 *
 * @author Mummanedi
 * @see PublishExtStd
 * @generated
 */
public class PublishExtStdCacheModel implements CacheModel<PublishExtStd>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{compDate=");
		sb.append(compDate);
		sb.append(", stdId=");
		sb.append(stdId);
		sb.append(", parentId=");
		sb.append(parentId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", expiredIds=");
		sb.append(expiredIds);
		sb.append(", regionCode=");
		sb.append(regionCode);
		sb.append(", isGlobal=");
		sb.append(isGlobal);
		sb.append(", framework=");
		sb.append(framework);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PublishExtStd toEntityModel() {
		PublishExtStdImpl publishExtStdImpl = new PublishExtStdImpl();

		if (compDate == Long.MIN_VALUE) {
			publishExtStdImpl.setCompDate(null);
		}
		else {
			publishExtStdImpl.setCompDate(new Date(compDate));
		}

		publishExtStdImpl.setStdId(stdId);
		publishExtStdImpl.setParentId(parentId);

		if (title == null) {
			publishExtStdImpl.setTitle(StringPool.BLANK);
		}
		else {
			publishExtStdImpl.setTitle(title);
		}

		if (expiredIds == null) {
			publishExtStdImpl.setExpiredIds(StringPool.BLANK);
		}
		else {
			publishExtStdImpl.setExpiredIds(expiredIds);
		}

		if (regionCode == null) {
			publishExtStdImpl.setRegionCode(StringPool.BLANK);
		}
		else {
			publishExtStdImpl.setRegionCode(regionCode);
		}

		if (isGlobal == null) {
			publishExtStdImpl.setIsGlobal(StringPool.BLANK);
		}
		else {
			publishExtStdImpl.setIsGlobal(isGlobal);
		}

		if (framework == null) {
			publishExtStdImpl.setFramework(StringPool.BLANK);
		}
		else {
			publishExtStdImpl.setFramework(framework);
		}

		publishExtStdImpl.resetOriginalValues();

		return publishExtStdImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		compDate = objectInput.readLong();
		stdId = objectInput.readLong();
		parentId = objectInput.readLong();
		title = objectInput.readUTF();
		expiredIds = objectInput.readUTF();
		regionCode = objectInput.readUTF();
		isGlobal = objectInput.readUTF();
		framework = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(compDate);
		objectOutput.writeLong(stdId);
		objectOutput.writeLong(parentId);

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (expiredIds == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(expiredIds);
		}

		if (regionCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(regionCode);
		}

		if (isGlobal == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(isGlobal);
		}

		if (framework == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(framework);
		}
	}

	public long compDate;
	public long stdId;
	public long parentId;
	public String title;
	public String expiredIds;
	public String regionCode;
	public String isGlobal;
	public String framework;
}