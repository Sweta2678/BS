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

import com.ihg.brandstandards.db.model.MustPublish;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing MustPublish in entity cache.
 *
 * @author Mummanedi
 * @see MustPublish
 * @generated
 */
public class MustPublishCacheModel implements CacheModel<MustPublish>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{parentId=");
		sb.append(parentId);
		sb.append(", stdId=");
		sb.append(stdId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", stdType=");
		sb.append(stdType);
		sb.append(", path=");
		sb.append(path);
		sb.append(", currentPath=");
		sb.append(currentPath);
		sb.append(", regionCode=");
		sb.append(regionCode);
		sb.append(", amer=");
		sb.append(amer);
		sb.append(", amea=");
		sb.append(amea);
		sb.append(", euro=");
		sb.append(euro);
		sb.append(", gc=");
		sb.append(gc);
		sb.append(", status=");
		sb.append(status);
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
		sb.append(", isGlobal=");
		sb.append(isGlobal);
		sb.append(", framework=");
		sb.append(framework);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MustPublish toEntityModel() {
		MustPublishImpl mustPublishImpl = new MustPublishImpl();

		mustPublishImpl.setParentId(parentId);
		mustPublishImpl.setStdId(stdId);

		if (title == null) {
			mustPublishImpl.setTitle(StringPool.BLANK);
		}
		else {
			mustPublishImpl.setTitle(title);
		}

		if (stdType == null) {
			mustPublishImpl.setStdType(StringPool.BLANK);
		}
		else {
			mustPublishImpl.setStdType(stdType);
		}

		if (path == null) {
			mustPublishImpl.setPath(StringPool.BLANK);
		}
		else {
			mustPublishImpl.setPath(path);
		}

		if (currentPath == null) {
			mustPublishImpl.setCurrentPath(StringPool.BLANK);
		}
		else {
			mustPublishImpl.setCurrentPath(currentPath);
		}

		if (regionCode == null) {
			mustPublishImpl.setRegionCode(StringPool.BLANK);
		}
		else {
			mustPublishImpl.setRegionCode(regionCode);
		}

		if (amer == null) {
			mustPublishImpl.setAmer(StringPool.BLANK);
		}
		else {
			mustPublishImpl.setAmer(amer);
		}

		if (amea == null) {
			mustPublishImpl.setAmea(StringPool.BLANK);
		}
		else {
			mustPublishImpl.setAmea(amea);
		}

		if (euro == null) {
			mustPublishImpl.setEuro(StringPool.BLANK);
		}
		else {
			mustPublishImpl.setEuro(euro);
		}

		if (gc == null) {
			mustPublishImpl.setGc(StringPool.BLANK);
		}
		else {
			mustPublishImpl.setGc(gc);
		}

		if (status == null) {
			mustPublishImpl.setStatus(StringPool.BLANK);
		}
		else {
			mustPublishImpl.setStatus(status);
		}

		mustPublishImpl.setDisplayOrder(displayOrder);
		mustPublishImpl.setTaxonomyId(taxonomyId);
		mustPublishImpl.setParentTaxonomyId(parentTaxonomyId);
		mustPublishImpl.setIndexOrder(indexOrder);
		mustPublishImpl.setLevel(level);
		mustPublishImpl.setLevelSortOrder(levelSortOrder);

		if (isGlobal == null) {
			mustPublishImpl.setIsGlobal(StringPool.BLANK);
		}
		else {
			mustPublishImpl.setIsGlobal(isGlobal);
		}

		if (framework == null) {
			mustPublishImpl.setFramework(StringPool.BLANK);
		}
		else {
			mustPublishImpl.setFramework(framework);
		}

		mustPublishImpl.resetOriginalValues();

		return mustPublishImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		parentId = objectInput.readLong();
		stdId = objectInput.readLong();
		title = objectInput.readUTF();
		stdType = objectInput.readUTF();
		path = objectInput.readUTF();
		currentPath = objectInput.readUTF();
		regionCode = objectInput.readUTF();
		amer = objectInput.readUTF();
		amea = objectInput.readUTF();
		euro = objectInput.readUTF();
		gc = objectInput.readUTF();
		status = objectInput.readUTF();
		displayOrder = objectInput.readLong();
		taxonomyId = objectInput.readLong();
		parentTaxonomyId = objectInput.readLong();
		indexOrder = objectInput.readLong();
		level = objectInput.readLong();
		levelSortOrder = objectInput.readLong();
		isGlobal = objectInput.readUTF();
		framework = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(parentId);
		objectOutput.writeLong(stdId);

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (stdType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(stdType);
		}

		if (path == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(path);
		}

		if (currentPath == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(currentPath);
		}

		if (regionCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(regionCode);
		}

		if (amer == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(amer);
		}

		if (amea == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(amea);
		}

		if (euro == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(euro);
		}

		if (gc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(gc);
		}

		if (status == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(status);
		}

		objectOutput.writeLong(displayOrder);
		objectOutput.writeLong(taxonomyId);
		objectOutput.writeLong(parentTaxonomyId);
		objectOutput.writeLong(indexOrder);
		objectOutput.writeLong(level);
		objectOutput.writeLong(levelSortOrder);

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

	public long parentId;
	public long stdId;
	public String title;
	public String stdType;
	public String path;
	public String currentPath;
	public String regionCode;
	public String amer;
	public String amea;
	public String euro;
	public String gc;
	public String status;
	public long displayOrder;
	public long taxonomyId;
	public long parentTaxonomyId;
	public long indexOrder;
	public long level;
	public long levelSortOrder;
	public String isGlobal;
	public String framework;
}