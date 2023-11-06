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

import com.ihg.brandstandards.db.model.StandardsImages;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing StandardsImages in entity cache.
 *
 * @author Mummanedi
 * @see StandardsImages
 * @generated
 */
public class StandardsImagesCacheModel implements CacheModel<StandardsImages>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{stdImageId=");
		sb.append(stdImageId);
		sb.append(", parentImageId=");
		sb.append(parentImageId);
		sb.append(", imageId=");
		sb.append(imageId);
		sb.append(", stdId=");
		sb.append(stdId);
		sb.append(", localeCode=");
		sb.append(localeCode);
		sb.append(", imageTitle=");
		sb.append(imageTitle);
		sb.append(", imageSortOrder=");
		sb.append(imageSortOrder);
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
	public StandardsImages toEntityModel() {
		StandardsImagesImpl standardsImagesImpl = new StandardsImagesImpl();

		standardsImagesImpl.setStdImageId(stdImageId);
		standardsImagesImpl.setParentImageId(parentImageId);
		standardsImagesImpl.setImageId(imageId);
		standardsImagesImpl.setStdId(stdId);

		if (localeCode == null) {
			standardsImagesImpl.setLocaleCode(StringPool.BLANK);
		}
		else {
			standardsImagesImpl.setLocaleCode(localeCode);
		}

		if (imageTitle == null) {
			standardsImagesImpl.setImageTitle(StringPool.BLANK);
		}
		else {
			standardsImagesImpl.setImageTitle(imageTitle);
		}

		standardsImagesImpl.setImageSortOrder(imageSortOrder);

		if (creatorId == null) {
			standardsImagesImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			standardsImagesImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			standardsImagesImpl.setCreatedDate(null);
		}
		else {
			standardsImagesImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			standardsImagesImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			standardsImagesImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			standardsImagesImpl.setUpdatedDate(null);
		}
		else {
			standardsImagesImpl.setUpdatedDate(new Date(updatedDate));
		}

		standardsImagesImpl.resetOriginalValues();

		return standardsImagesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		stdImageId = objectInput.readLong();
		parentImageId = objectInput.readLong();
		imageId = objectInput.readLong();
		stdId = objectInput.readLong();
		localeCode = objectInput.readUTF();
		imageTitle = objectInput.readUTF();
		imageSortOrder = objectInput.readLong();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(stdImageId);
		objectOutput.writeLong(parentImageId);
		objectOutput.writeLong(imageId);
		objectOutput.writeLong(stdId);

		if (localeCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(localeCode);
		}

		if (imageTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(imageTitle);
		}

		objectOutput.writeLong(imageSortOrder);

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

	public long stdImageId;
	public long parentImageId;
	public long imageId;
	public long stdId;
	public String localeCode;
	public String imageTitle;
	public long imageSortOrder;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}