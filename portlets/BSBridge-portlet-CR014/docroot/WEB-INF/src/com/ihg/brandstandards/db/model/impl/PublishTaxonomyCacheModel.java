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

import com.ihg.brandstandards.db.model.PublishTaxonomy;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PublishTaxonomy in entity cache.
 *
 * @author Mummanedi
 * @see PublishTaxonomy
 * @generated
 */
public class PublishTaxonomyCacheModel implements CacheModel<PublishTaxonomy>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{publishTaxId=");
		sb.append(publishTaxId);
		sb.append(", publishId=");
		sb.append(publishId);
		sb.append(", taxId=");
		sb.append(taxId);
		sb.append(", publishParentId=");
		sb.append(publishParentId);
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
	public PublishTaxonomy toEntityModel() {
		PublishTaxonomyImpl publishTaxonomyImpl = new PublishTaxonomyImpl();

		publishTaxonomyImpl.setPublishTaxId(publishTaxId);
		publishTaxonomyImpl.setPublishId(publishId);
		publishTaxonomyImpl.setTaxId(taxId);
		publishTaxonomyImpl.setPublishParentId(publishParentId);

		if (title == null) {
			publishTaxonomyImpl.setTitle(StringPool.BLANK);
		}
		else {
			publishTaxonomyImpl.setTitle(title);
		}

		if (desc == null) {
			publishTaxonomyImpl.setDesc(StringPool.BLANK);
		}
		else {
			publishTaxonomyImpl.setDesc(desc);
		}

		if (imageLoc == null) {
			publishTaxonomyImpl.setImageLoc(StringPool.BLANK);
		}
		else {
			publishTaxonomyImpl.setImageLoc(imageLoc);
		}

		if (createdBy == null) {
			publishTaxonomyImpl.setCreatedBy(StringPool.BLANK);
		}
		else {
			publishTaxonomyImpl.setCreatedBy(createdBy);
		}

		publishTaxonomyImpl.setPosition(position);

		if (creatorId == null) {
			publishTaxonomyImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			publishTaxonomyImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			publishTaxonomyImpl.setCreatedDate(null);
		}
		else {
			publishTaxonomyImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			publishTaxonomyImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			publishTaxonomyImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			publishTaxonomyImpl.setUpdatedDate(null);
		}
		else {
			publishTaxonomyImpl.setUpdatedDate(new Date(updatedDate));
		}

		publishTaxonomyImpl.resetOriginalValues();

		return publishTaxonomyImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		publishTaxId = objectInput.readLong();
		publishId = objectInput.readLong();
		taxId = objectInput.readLong();
		publishParentId = objectInput.readLong();
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
		objectOutput.writeLong(publishTaxId);
		objectOutput.writeLong(publishId);
		objectOutput.writeLong(taxId);
		objectOutput.writeLong(publishParentId);

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

	public long publishTaxId;
	public long publishId;
	public long taxId;
	public long publishParentId;
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