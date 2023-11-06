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

import com.ihg.brandstandards.db.model.TaxonomyExt;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing TaxonomyExt in entity cache.
 *
 * @author Mummanedi
 * @see TaxonomyExt
 * @generated
 */
public class TaxonomyExtCacheModel implements CacheModel<TaxonomyExt>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{taxId=");
		sb.append(taxId);
		sb.append(", parentId=");
		sb.append(parentId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", desc=");
		sb.append(desc);
		sb.append(", imageLoc=");
		sb.append(imageLoc);
		sb.append(", lvl=");
		sb.append(lvl);
		sb.append(", path=");
		sb.append(path);
		sb.append(", levelSortOrder=");
		sb.append(levelSortOrder);
		sb.append(", indexOrder=");
		sb.append(indexOrder);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public TaxonomyExt toEntityModel() {
		TaxonomyExtImpl taxonomyExtImpl = new TaxonomyExtImpl();

		taxonomyExtImpl.setTaxId(taxId);
		taxonomyExtImpl.setParentId(parentId);

		if (title == null) {
			taxonomyExtImpl.setTitle(StringPool.BLANK);
		}
		else {
			taxonomyExtImpl.setTitle(title);
		}

		if (desc == null) {
			taxonomyExtImpl.setDesc(StringPool.BLANK);
		}
		else {
			taxonomyExtImpl.setDesc(desc);
		}

		if (imageLoc == null) {
			taxonomyExtImpl.setImageLoc(StringPool.BLANK);
		}
		else {
			taxonomyExtImpl.setImageLoc(imageLoc);
		}

		if (lvl == null) {
			taxonomyExtImpl.setLvl(StringPool.BLANK);
		}
		else {
			taxonomyExtImpl.setLvl(lvl);
		}

		if (path == null) {
			taxonomyExtImpl.setPath(StringPool.BLANK);
		}
		else {
			taxonomyExtImpl.setPath(path);
		}

		taxonomyExtImpl.setLevelSortOrder(levelSortOrder);
		taxonomyExtImpl.setIndexOrder(indexOrder);

		taxonomyExtImpl.resetOriginalValues();

		return taxonomyExtImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		taxId = objectInput.readLong();
		parentId = objectInput.readLong();
		title = objectInput.readUTF();
		desc = objectInput.readUTF();
		imageLoc = objectInput.readUTF();
		lvl = objectInput.readUTF();
		path = objectInput.readUTF();
		levelSortOrder = objectInput.readLong();
		indexOrder = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(taxId);
		objectOutput.writeLong(parentId);

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (desc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(desc);
		}

		if (imageLoc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(imageLoc);
		}

		if (lvl == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lvl);
		}

		if (path == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(path);
		}

		objectOutput.writeLong(levelSortOrder);
		objectOutput.writeLong(indexOrder);
	}

	public long taxId;
	public long parentId;
	public String title;
	public String desc;
	public String imageLoc;
	public String lvl;
	public String path;
	public long levelSortOrder;
	public long indexOrder;
}