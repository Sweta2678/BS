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

import com.ihg.brandstandards.db.model.Taxonomy;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Taxonomy in entity cache.
 *
 * @author Mummanedi
 * @see Taxonomy
 * @generated
 */
public class TaxonomyCacheModel implements CacheModel<Taxonomy>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

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
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", position=");
		sb.append(position);
		sb.append(", creatorId=");
		sb.append(creatorId);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", updatedBy=");
		sb.append(updatedBy);
		sb.append(", updatedDate=");
		sb.append(updatedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Taxonomy toEntityModel() {
		TaxonomyImpl taxonomyImpl = new TaxonomyImpl();

		taxonomyImpl.setTaxId(taxId);
		taxonomyImpl.setParentId(parentId);

		if (title == null) {
			taxonomyImpl.setTitle(StringPool.BLANK);
		}
		else {
			taxonomyImpl.setTitle(title);
		}

		if (desc == null) {
			taxonomyImpl.setDesc(StringPool.BLANK);
		}
		else {
			taxonomyImpl.setDesc(desc);
		}

		if (imageLoc == null) {
			taxonomyImpl.setImageLoc(StringPool.BLANK);
		}
		else {
			taxonomyImpl.setImageLoc(imageLoc);
		}

		if (createdBy == null) {
			taxonomyImpl.setCreatedBy(StringPool.BLANK);
		}
		else {
			taxonomyImpl.setCreatedBy(createdBy);
		}

		taxonomyImpl.setPosition(position);

		if (creatorId == null) {
			taxonomyImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			taxonomyImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			taxonomyImpl.setCreatedDate(null);
		}
		else {
			taxonomyImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			taxonomyImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			taxonomyImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			taxonomyImpl.setUpdatedDate(null);
		}
		else {
			taxonomyImpl.setUpdatedDate(new Date(updatedDate));
		}

		taxonomyImpl.resetOriginalValues();

		return taxonomyImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		taxId = objectInput.readLong();
		parentId = objectInput.readLong();
		title = objectInput.readUTF();
		desc = objectInput.readUTF();
		imageLoc = objectInput.readUTF();
		createdBy = objectInput.readUTF();
		position = objectInput.readLong();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
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

		if (createdBy == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(createdBy);
		}

		objectOutput.writeLong(position);

		if (creatorId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(creatorId);
		}

		objectOutput.writeLong(createdDate);

		if (updatedBy == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(updatedBy);
		}

		objectOutput.writeLong(updatedDate);
	}

	public long taxId;
	public long parentId;
	public String title;
	public String desc;
	public String imageLoc;
	public String createdBy;
	public long position;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}