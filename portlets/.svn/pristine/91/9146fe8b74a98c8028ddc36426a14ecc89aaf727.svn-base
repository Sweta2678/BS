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

import com.ihg.brandstandards.db.model.PublishTaxonomyExt;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing PublishTaxonomyExt in entity cache.
 *
 * @author Mummanedi
 * @see PublishTaxonomyExt
 * @generated
 */
public class PublishTaxonomyExtCacheModel implements CacheModel<PublishTaxonomyExt>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{publishTaxId=");
		sb.append(publishTaxId);
		sb.append(", publishParentId=");
		sb.append(publishParentId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", lvl=");
		sb.append(lvl);
		sb.append(", path=");
		sb.append(path);
		sb.append(", levelSortOrder=");
		sb.append(levelSortOrder);
		sb.append(", publishId=");
		sb.append(publishId);
		sb.append(", indexOrder=");
		sb.append(indexOrder);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PublishTaxonomyExt toEntityModel() {
		PublishTaxonomyExtImpl publishTaxonomyExtImpl = new PublishTaxonomyExtImpl();

		publishTaxonomyExtImpl.setPublishTaxId(publishTaxId);
		publishTaxonomyExtImpl.setPublishParentId(publishParentId);

		if (title == null) {
			publishTaxonomyExtImpl.setTitle(StringPool.BLANK);
		}
		else {
			publishTaxonomyExtImpl.setTitle(title);
		}

		if (lvl == null) {
			publishTaxonomyExtImpl.setLvl(StringPool.BLANK);
		}
		else {
			publishTaxonomyExtImpl.setLvl(lvl);
		}

		if (path == null) {
			publishTaxonomyExtImpl.setPath(StringPool.BLANK);
		}
		else {
			publishTaxonomyExtImpl.setPath(path);
		}

		publishTaxonomyExtImpl.setLevelSortOrder(levelSortOrder);
		publishTaxonomyExtImpl.setPublishId(publishId);
		publishTaxonomyExtImpl.setIndexOrder(indexOrder);

		publishTaxonomyExtImpl.resetOriginalValues();

		return publishTaxonomyExtImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		publishTaxId = objectInput.readLong();
		publishParentId = objectInput.readLong();
		title = objectInput.readUTF();
		lvl = objectInput.readUTF();
		path = objectInput.readUTF();
		levelSortOrder = objectInput.readLong();
		publishId = objectInput.readLong();
		indexOrder = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(publishTaxId);
		objectOutput.writeLong(publishParentId);

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
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
		objectOutput.writeLong(publishId);
		objectOutput.writeLong(indexOrder);
	}

	public long publishTaxId;
	public long publishParentId;
	public String title;
	public String lvl;
	public String path;
	public long levelSortOrder;
	public long publishId;
	public long indexOrder;
}