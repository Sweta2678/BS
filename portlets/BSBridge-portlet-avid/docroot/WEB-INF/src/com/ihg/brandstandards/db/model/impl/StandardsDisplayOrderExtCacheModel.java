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

import com.ihg.brandstandards.db.model.StandardsDisplayOrderExt;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing StandardsDisplayOrderExt in entity cache.
 *
 * @author Mummanedi
 * @see StandardsDisplayOrderExt
 * @generated
 */
public class StandardsDisplayOrderExtCacheModel implements CacheModel<StandardsDisplayOrderExt>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{stdId=");
		sb.append(stdId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", isGlobal=");
		sb.append(isGlobal);
		sb.append(", framework=");
		sb.append(framework);
		sb.append(", chainCode=");
		sb.append(chainCode);
		sb.append(", regionCode=");
		sb.append(regionCode);
		sb.append(", displayOrder=");
		sb.append(displayOrder);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public StandardsDisplayOrderExt toEntityModel() {
		StandardsDisplayOrderExtImpl standardsDisplayOrderExtImpl = new StandardsDisplayOrderExtImpl();

		standardsDisplayOrderExtImpl.setStdId(stdId);

		if (title == null) {
			standardsDisplayOrderExtImpl.setTitle(StringPool.BLANK);
		}
		else {
			standardsDisplayOrderExtImpl.setTitle(title);
		}

		if (isGlobal == null) {
			standardsDisplayOrderExtImpl.setIsGlobal(StringPool.BLANK);
		}
		else {
			standardsDisplayOrderExtImpl.setIsGlobal(isGlobal);
		}

		if (framework == null) {
			standardsDisplayOrderExtImpl.setFramework(StringPool.BLANK);
		}
		else {
			standardsDisplayOrderExtImpl.setFramework(framework);
		}

		if (chainCode == null) {
			standardsDisplayOrderExtImpl.setChainCode(StringPool.BLANK);
		}
		else {
			standardsDisplayOrderExtImpl.setChainCode(chainCode);
		}

		if (regionCode == null) {
			standardsDisplayOrderExtImpl.setRegionCode(StringPool.BLANK);
		}
		else {
			standardsDisplayOrderExtImpl.setRegionCode(regionCode);
		}

		standardsDisplayOrderExtImpl.setDisplayOrder(displayOrder);

		standardsDisplayOrderExtImpl.resetOriginalValues();

		return standardsDisplayOrderExtImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		stdId = objectInput.readLong();
		title = objectInput.readUTF();
		isGlobal = objectInput.readUTF();
		framework = objectInput.readUTF();
		chainCode = objectInput.readUTF();
		regionCode = objectInput.readUTF();
		displayOrder = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(stdId);

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
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

		objectOutput.writeLong(displayOrder);
	}

	public long stdId;
	public String title;
	public String isGlobal;
	public String framework;
	public String chainCode;
	public String regionCode;
	public long displayOrder;
}