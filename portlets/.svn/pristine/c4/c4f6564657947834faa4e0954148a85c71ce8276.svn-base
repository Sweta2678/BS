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

import com.ihg.brandstandards.db.model.BrandTaxonomyTranslate;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing BrandTaxonomyTranslate in entity cache.
 *
 * @author Mummanedi
 * @see BrandTaxonomyTranslate
 * @generated
 */
public class BrandTaxonomyTranslateCacheModel implements CacheModel<BrandTaxonomyTranslate>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{brandTaxId=");
		sb.append(brandTaxId);
		sb.append(", localeCd=");
		sb.append(localeCd);
		sb.append(", title=");
		sb.append(title);
		sb.append(", desc=");
		sb.append(desc);
		sb.append(", imageLoc=");
		sb.append(imageLoc);
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
	public BrandTaxonomyTranslate toEntityModel() {
		BrandTaxonomyTranslateImpl brandTaxonomyTranslateImpl = new BrandTaxonomyTranslateImpl();

		brandTaxonomyTranslateImpl.setBrandTaxId(brandTaxId);

		if (localeCd == null) {
			brandTaxonomyTranslateImpl.setLocaleCd(StringPool.BLANK);
		}
		else {
			brandTaxonomyTranslateImpl.setLocaleCd(localeCd);
		}

		if (title == null) {
			brandTaxonomyTranslateImpl.setTitle(StringPool.BLANK);
		}
		else {
			brandTaxonomyTranslateImpl.setTitle(title);
		}

		if (desc == null) {
			brandTaxonomyTranslateImpl.setDesc(StringPool.BLANK);
		}
		else {
			brandTaxonomyTranslateImpl.setDesc(desc);
		}

		if (imageLoc == null) {
			brandTaxonomyTranslateImpl.setImageLoc(StringPool.BLANK);
		}
		else {
			brandTaxonomyTranslateImpl.setImageLoc(imageLoc);
		}

		if (creatorId == null) {
			brandTaxonomyTranslateImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			brandTaxonomyTranslateImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			brandTaxonomyTranslateImpl.setCreatedDate(null);
		}
		else {
			brandTaxonomyTranslateImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			brandTaxonomyTranslateImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			brandTaxonomyTranslateImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			brandTaxonomyTranslateImpl.setUpdatedDate(null);
		}
		else {
			brandTaxonomyTranslateImpl.setUpdatedDate(new Date(updatedDate));
		}

		brandTaxonomyTranslateImpl.resetOriginalValues();

		return brandTaxonomyTranslateImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		brandTaxId = objectInput.readLong();
		localeCd = objectInput.readUTF();
		title = objectInput.readUTF();
		desc = objectInput.readUTF();
		imageLoc = objectInput.readUTF();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(brandTaxId);

		if (localeCd == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(localeCd);
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

	public long brandTaxId;
	public String localeCd;
	public String title;
	public String desc;
	public String imageLoc;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}