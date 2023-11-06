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

import com.ihg.brandstandards.db.model.Image;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Image in entity cache.
 *
 * @author Mummanedi
 * @see Image
 * @generated
 */
public class ImageCacheModel implements CacheModel<Image>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{imageId=");
		sb.append(imageId);
		sb.append(", imageUuId=");
		sb.append(imageUuId);
		sb.append(", imageDesc=");
		sb.append(imageDesc);
		sb.append(", imageTitle=");
		sb.append(imageTitle);
		sb.append(", imageSize=");
		sb.append(imageSize);
		sb.append(", imageType=");
		sb.append(imageType);
		sb.append(", smallImageId=");
		sb.append(smallImageId);
		sb.append(", imageDimension=");
		sb.append(imageDimension);
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
	public Image toEntityModel() {
		ImageImpl imageImpl = new ImageImpl();

		imageImpl.setImageId(imageId);

		if (imageUuId == null) {
			imageImpl.setImageUuId(StringPool.BLANK);
		}
		else {
			imageImpl.setImageUuId(imageUuId);
		}

		if (imageDesc == null) {
			imageImpl.setImageDesc(StringPool.BLANK);
		}
		else {
			imageImpl.setImageDesc(imageDesc);
		}

		if (imageTitle == null) {
			imageImpl.setImageTitle(StringPool.BLANK);
		}
		else {
			imageImpl.setImageTitle(imageTitle);
		}

		if (imageSize == null) {
			imageImpl.setImageSize(StringPool.BLANK);
		}
		else {
			imageImpl.setImageSize(imageSize);
		}

		if (imageType == null) {
			imageImpl.setImageType(StringPool.BLANK);
		}
		else {
			imageImpl.setImageType(imageType);
		}

		if (smallImageId == null) {
			imageImpl.setSmallImageId(StringPool.BLANK);
		}
		else {
			imageImpl.setSmallImageId(smallImageId);
		}

		if (imageDimension == null) {
			imageImpl.setImageDimension(StringPool.BLANK);
		}
		else {
			imageImpl.setImageDimension(imageDimension);
		}

		if (creatorId == null) {
			imageImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			imageImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			imageImpl.setCreatedDate(null);
		}
		else {
			imageImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			imageImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			imageImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			imageImpl.setUpdatedDate(null);
		}
		else {
			imageImpl.setUpdatedDate(new Date(updatedDate));
		}

		imageImpl.resetOriginalValues();

		return imageImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		imageId = objectInput.readLong();
		imageUuId = objectInput.readUTF();
		imageDesc = objectInput.readUTF();
		imageTitle = objectInput.readUTF();
		imageSize = objectInput.readUTF();
		imageType = objectInput.readUTF();
		smallImageId = objectInput.readUTF();
		imageDimension = objectInput.readUTF();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(imageId);

		if (imageUuId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(imageUuId);
		}

		if (imageDesc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(imageDesc);
		}

		if (imageTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(imageTitle);
		}

		if (imageSize == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(imageSize);
		}

		if (imageType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(imageType);
		}

		if (smallImageId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(smallImageId);
		}

		if (imageDimension == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(imageDimension);
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

	public long imageId;
	public String imageUuId;
	public String imageDesc;
	public String imageTitle;
	public String imageSize;
	public String imageType;
	public String smallImageId;
	public String imageDimension;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}