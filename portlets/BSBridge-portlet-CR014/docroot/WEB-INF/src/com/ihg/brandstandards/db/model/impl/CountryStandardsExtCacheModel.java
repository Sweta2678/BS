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

import com.ihg.brandstandards.db.model.CountryStandardsExt;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing CountryStandardsExt in entity cache.
 *
 * @author Mummanedi
 * @see CountryStandardsExt
 * @generated
 */
public class CountryStandardsExtCacheModel implements CacheModel<CountryStandardsExt>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{countryCode=");
		sb.append(countryCode);
		sb.append(", stdId=");
		sb.append(stdId);
		sb.append(", regionId=");
		sb.append(regionId);
		sb.append(", regionCode=");
		sb.append(regionCode);
		sb.append(", regionName=");
		sb.append(regionName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CountryStandardsExt toEntityModel() {
		CountryStandardsExtImpl countryStandardsExtImpl = new CountryStandardsExtImpl();

		if (countryCode == null) {
			countryStandardsExtImpl.setCountryCode(StringPool.BLANK);
		}
		else {
			countryStandardsExtImpl.setCountryCode(countryCode);
		}

		countryStandardsExtImpl.setStdId(stdId);
		countryStandardsExtImpl.setRegionId(regionId);

		if (regionCode == null) {
			countryStandardsExtImpl.setRegionCode(StringPool.BLANK);
		}
		else {
			countryStandardsExtImpl.setRegionCode(regionCode);
		}

		if (regionName == null) {
			countryStandardsExtImpl.setRegionName(StringPool.BLANK);
		}
		else {
			countryStandardsExtImpl.setRegionName(regionName);
		}

		countryStandardsExtImpl.resetOriginalValues();

		return countryStandardsExtImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		countryCode = objectInput.readUTF();
		stdId = objectInput.readLong();
		regionId = objectInput.readLong();
		regionCode = objectInput.readUTF();
		regionName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (countryCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(countryCode);
		}

		objectOutput.writeLong(stdId);
		objectOutput.writeLong(regionId);

		if (regionCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(regionCode);
		}

		if (regionName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(regionName);
		}
	}

	public String countryCode;
	public long stdId;
	public long regionId;
	public String regionCode;
	public String regionName;
}