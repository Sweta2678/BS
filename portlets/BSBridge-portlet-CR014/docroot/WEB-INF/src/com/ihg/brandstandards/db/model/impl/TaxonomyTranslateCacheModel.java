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

import com.ihg.brandstandards.db.model.TaxonomyTranslate;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TaxonomyTranslate in entity cache.
 *
 * @author Mummanedi
 * @see TaxonomyTranslate
 * @generated
 */
public class TaxonomyTranslateCacheModel implements CacheModel<TaxonomyTranslate>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{taxId=");
		sb.append(taxId);
		sb.append(", localeCode=");
		sb.append(localeCode);
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
	public TaxonomyTranslate toEntityModel() {
		TaxonomyTranslateImpl taxonomyTranslateImpl = new TaxonomyTranslateImpl();

		taxonomyTranslateImpl.setTaxId(taxId);

		if (localeCode == null) {
			taxonomyTranslateImpl.setLocaleCode(StringPool.BLANK);
		}
		else {
			taxonomyTranslateImpl.setLocaleCode(localeCode);
		}

		if (title == null) {
			taxonomyTranslateImpl.setTitle(StringPool.BLANK);
		}
		else {
			taxonomyTranslateImpl.setTitle(title);
		}

		if (desc == null) {
			taxonomyTranslateImpl.setDesc(StringPool.BLANK);
		}
		else {
			taxonomyTranslateImpl.setDesc(desc);
		}

		if (imageLoc == null) {
			taxonomyTranslateImpl.setImageLoc(StringPool.BLANK);
		}
		else {
			taxonomyTranslateImpl.setImageLoc(imageLoc);
		}

		if (creatorId == null) {
			taxonomyTranslateImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			taxonomyTranslateImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			taxonomyTranslateImpl.setCreatedDate(null);
		}
		else {
			taxonomyTranslateImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			taxonomyTranslateImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			taxonomyTranslateImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			taxonomyTranslateImpl.setUpdatedDate(null);
		}
		else {
			taxonomyTranslateImpl.setUpdatedDate(new Date(updatedDate));
		}

		taxonomyTranslateImpl.resetOriginalValues();

		return taxonomyTranslateImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		taxId = objectInput.readLong();
		localeCode = objectInput.readUTF();
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
		objectOutput.writeLong(taxId);

		if (localeCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(localeCode);
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

	public long taxId;
	public String localeCode;
	public String title;
	public String desc;
	public String imageLoc;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}