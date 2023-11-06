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

import com.ihg.brandstandards.db.model.BridgePublishCountryStateEx;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing BridgePublishCountryStateEx in entity cache.
 *
 * @author Mummanedi
 * @see BridgePublishCountryStateEx
 * @generated
 */
public class BridgePublishCountryStateExCacheModel implements CacheModel<BridgePublishCountryStateEx>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{stdId=");
		sb.append(stdId);
		sb.append(", CountryCode=");
		sb.append(CountryCode);
		sb.append(", parentStdId=");
		sb.append(parentStdId);
		sb.append(", type=");
		sb.append(type);
		sb.append(", publishId=");
		sb.append(publishId);
		sb.append(", stateCd=");
		sb.append(stateCd);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public BridgePublishCountryStateEx toEntityModel() {
		BridgePublishCountryStateExImpl bridgePublishCountryStateExImpl = new BridgePublishCountryStateExImpl();

		bridgePublishCountryStateExImpl.setStdId(stdId);

		if (CountryCode == null) {
			bridgePublishCountryStateExImpl.setCountryCode(StringPool.BLANK);
		}
		else {
			bridgePublishCountryStateExImpl.setCountryCode(CountryCode);
		}

		bridgePublishCountryStateExImpl.setParentStdId(parentStdId);

		if (type == null) {
			bridgePublishCountryStateExImpl.setType(StringPool.BLANK);
		}
		else {
			bridgePublishCountryStateExImpl.setType(type);
		}

		bridgePublishCountryStateExImpl.setPublishId(publishId);

		if (stateCd == null) {
			bridgePublishCountryStateExImpl.setStateCd(StringPool.BLANK);
		}
		else {
			bridgePublishCountryStateExImpl.setStateCd(stateCd);
		}

		bridgePublishCountryStateExImpl.resetOriginalValues();

		return bridgePublishCountryStateExImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		stdId = objectInput.readLong();
		CountryCode = objectInput.readUTF();
		parentStdId = objectInput.readLong();
		type = objectInput.readUTF();
		publishId = objectInput.readLong();
		stateCd = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(stdId);

		if (CountryCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(CountryCode);
		}

		objectOutput.writeLong(parentStdId);

		if (type == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(type);
		}

		objectOutput.writeLong(publishId);

		if (stateCd == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(stateCd);
		}
	}

	public long stdId;
	public String CountryCode;
	public long parentStdId;
	public String type;
	public long publishId;
	public String stateCd;
}