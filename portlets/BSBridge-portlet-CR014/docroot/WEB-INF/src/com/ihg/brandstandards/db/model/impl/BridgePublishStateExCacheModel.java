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

import com.ihg.brandstandards.db.model.BridgePublishStateEx;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing BridgePublishStateEx in entity cache.
 *
 * @author Mummanedi
 * @see BridgePublishStateEx
 * @generated
 */
public class BridgePublishStateExCacheModel implements CacheModel<BridgePublishStateEx>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{publishId=");
		sb.append(publishId);
		sb.append(", stdId=");
		sb.append(stdId);
		sb.append(", taxonomyTitle=");
		sb.append(taxonomyTitle);
		sb.append(", title=");
		sb.append(title);
		sb.append(", path=");
		sb.append(path);
		sb.append(", parentStdId=");
		sb.append(parentStdId);
		sb.append(", stateCd=");
		sb.append(stateCd);
		sb.append(", type=");
		sb.append(type);
		sb.append(", manualType=");
		sb.append(manualType);
		sb.append(", count=");
		sb.append(count);
		sb.append(", displayOrder=");
		sb.append(displayOrder);
		sb.append(", taxonomyId=");
		sb.append(taxonomyId);
		sb.append(", parentTaxonomyId=");
		sb.append(parentTaxonomyId);
		sb.append(", indexOrder=");
		sb.append(indexOrder);
		sb.append(", level=");
		sb.append(level);
		sb.append(", levelSortOrder=");
		sb.append(levelSortOrder);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public BridgePublishStateEx toEntityModel() {
		BridgePublishStateExImpl bridgePublishStateExImpl = new BridgePublishStateExImpl();

		bridgePublishStateExImpl.setPublishId(publishId);
		bridgePublishStateExImpl.setStdId(stdId);

		if (taxonomyTitle == null) {
			bridgePublishStateExImpl.setTaxonomyTitle(StringPool.BLANK);
		}
		else {
			bridgePublishStateExImpl.setTaxonomyTitle(taxonomyTitle);
		}

		if (title == null) {
			bridgePublishStateExImpl.setTitle(StringPool.BLANK);
		}
		else {
			bridgePublishStateExImpl.setTitle(title);
		}

		if (path == null) {
			bridgePublishStateExImpl.setPath(StringPool.BLANK);
		}
		else {
			bridgePublishStateExImpl.setPath(path);
		}

		bridgePublishStateExImpl.setParentStdId(parentStdId);

		if (stateCd == null) {
			bridgePublishStateExImpl.setStateCd(StringPool.BLANK);
		}
		else {
			bridgePublishStateExImpl.setStateCd(stateCd);
		}

		if (type == null) {
			bridgePublishStateExImpl.setType(StringPool.BLANK);
		}
		else {
			bridgePublishStateExImpl.setType(type);
		}

		if (manualType == null) {
			bridgePublishStateExImpl.setManualType(StringPool.BLANK);
		}
		else {
			bridgePublishStateExImpl.setManualType(manualType);
		}

		bridgePublishStateExImpl.setCount(count);
		bridgePublishStateExImpl.setDisplayOrder(displayOrder);
		bridgePublishStateExImpl.setTaxonomyId(taxonomyId);
		bridgePublishStateExImpl.setParentTaxonomyId(parentTaxonomyId);
		bridgePublishStateExImpl.setIndexOrder(indexOrder);
		bridgePublishStateExImpl.setLevel(level);
		bridgePublishStateExImpl.setLevelSortOrder(levelSortOrder);

		bridgePublishStateExImpl.resetOriginalValues();

		return bridgePublishStateExImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		publishId = objectInput.readLong();
		stdId = objectInput.readLong();
		taxonomyTitle = objectInput.readUTF();
		title = objectInput.readUTF();
		path = objectInput.readUTF();
		parentStdId = objectInput.readLong();
		stateCd = objectInput.readUTF();
		type = objectInput.readUTF();
		manualType = objectInput.readUTF();
		count = objectInput.readLong();
		displayOrder = objectInput.readLong();
		taxonomyId = objectInput.readLong();
		parentTaxonomyId = objectInput.readLong();
		indexOrder = objectInput.readLong();
		level = objectInput.readLong();
		levelSortOrder = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(publishId);
		objectOutput.writeLong(stdId);

		if (taxonomyTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(taxonomyTitle);
		}

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (path == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(path);
		}

		objectOutput.writeLong(parentStdId);

		if (stateCd == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(stateCd);
		}

		if (type == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(type);
		}

		if (manualType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(manualType);
		}

		objectOutput.writeLong(count);
		objectOutput.writeLong(displayOrder);
		objectOutput.writeLong(taxonomyId);
		objectOutput.writeLong(parentTaxonomyId);
		objectOutput.writeLong(indexOrder);
		objectOutput.writeLong(level);
		objectOutput.writeLong(levelSortOrder);
	}

	public long publishId;
	public long stdId;
	public String taxonomyTitle;
	public String title;
	public String path;
	public long parentStdId;
	public String stateCd;
	public String type;
	public String manualType;
	public long count;
	public long displayOrder;
	public long taxonomyId;
	public long parentTaxonomyId;
	public long indexOrder;
	public long level;
	public long levelSortOrder;
}