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

import com.ihg.brandstandards.db.model.StandardsCountryExt;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing StandardsCountryExt in entity cache.
 *
 * @author Mummanedi
 * @see StandardsCountryExt
 * @generated
 */
public class StandardsCountryExtCacheModel implements CacheModel<StandardsCountryExt>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{rowNum=");
		sb.append(rowNum);
		sb.append(", countryCode=");
		sb.append(countryCode);
		sb.append(", flag=");
		sb.append(flag);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public StandardsCountryExt toEntityModel() {
		StandardsCountryExtImpl standardsCountryExtImpl = new StandardsCountryExtImpl();

		standardsCountryExtImpl.setRowNum(rowNum);

		if (countryCode == null) {
			standardsCountryExtImpl.setCountryCode(StringPool.BLANK);
		}
		else {
			standardsCountryExtImpl.setCountryCode(countryCode);
		}

		if (flag == null) {
			standardsCountryExtImpl.setFlag(StringPool.BLANK);
		}
		else {
			standardsCountryExtImpl.setFlag(flag);
		}

		standardsCountryExtImpl.resetOriginalValues();

		return standardsCountryExtImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		rowNum = objectInput.readLong();
		countryCode = objectInput.readUTF();
		flag = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(rowNum);

		if (countryCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(countryCode);
		}

		if (flag == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(flag);
		}
	}

	public long rowNum;
	public String countryCode;
	public String flag;
}