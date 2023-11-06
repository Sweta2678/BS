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

import com.ihg.brandstandards.db.model.BrandTaxonomy;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing BrandTaxonomy in entity cache.
 *
 * @author Mummanedi
 * @see BrandTaxonomy
 * @generated
 */
public class BrandTaxonomyCacheModel implements CacheModel<BrandTaxonomy>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{id=");
		sb.append(id);
		sb.append(", taxId=");
		sb.append(taxId);
		sb.append(", chain=");
		sb.append(chain);
		sb.append(", title=");
		sb.append(title);
		sb.append(", desc=");
		sb.append(desc);
		sb.append(", imageLoc=");
		sb.append(imageLoc);
		sb.append(", createdBy=");
		sb.append(createdBy);
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
	public BrandTaxonomy toEntityModel() {
		BrandTaxonomyImpl brandTaxonomyImpl = new BrandTaxonomyImpl();

		brandTaxonomyImpl.setId(id);
		brandTaxonomyImpl.setTaxId(taxId);

		if (chain == null) {
			brandTaxonomyImpl.setChain(StringPool.BLANK);
		}
		else {
			brandTaxonomyImpl.setChain(chain);
		}

		if (title == null) {
			brandTaxonomyImpl.setTitle(StringPool.BLANK);
		}
		else {
			brandTaxonomyImpl.setTitle(title);
		}

		if (desc == null) {
			brandTaxonomyImpl.setDesc(StringPool.BLANK);
		}
		else {
			brandTaxonomyImpl.setDesc(desc);
		}

		if (imageLoc == null) {
			brandTaxonomyImpl.setImageLoc(StringPool.BLANK);
		}
		else {
			brandTaxonomyImpl.setImageLoc(imageLoc);
		}

		if (createdBy == null) {
			brandTaxonomyImpl.setCreatedBy(StringPool.BLANK);
		}
		else {
			brandTaxonomyImpl.setCreatedBy(createdBy);
		}

		if (creatorId == null) {
			brandTaxonomyImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			brandTaxonomyImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			brandTaxonomyImpl.setCreatedDate(null);
		}
		else {
			brandTaxonomyImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			brandTaxonomyImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			brandTaxonomyImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			brandTaxonomyImpl.setUpdatedDate(null);
		}
		else {
			brandTaxonomyImpl.setUpdatedDate(new Date(updatedDate));
		}

		brandTaxonomyImpl.resetOriginalValues();

		return brandTaxonomyImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		taxId = objectInput.readLong();
		chain = objectInput.readUTF();
		title = objectInput.readUTF();
		desc = objectInput.readUTF();
		imageLoc = objectInput.readUTF();
		createdBy = objectInput.readUTF();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);
		objectOutput.writeLong(taxId);

		if (chain == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(chain);
		}

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

	public long id;
	public long taxId;
	public String chain;
	public String title;
	public String desc;
	public String imageLoc;
	public String createdBy;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}