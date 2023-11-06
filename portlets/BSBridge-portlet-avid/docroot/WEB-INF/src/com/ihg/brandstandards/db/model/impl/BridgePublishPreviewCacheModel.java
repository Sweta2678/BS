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

import com.ihg.brandstandards.db.model.BridgePublishPreview;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing BridgePublishPreview in entity cache.
 *
 * @author Mummanedi
 * @see BridgePublishPreview
 * @generated
 */
public class BridgePublishPreviewCacheModel implements CacheModel<BridgePublishPreview>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(45);

		sb.append("{stdId=");
		sb.append(stdId);
		sb.append(", taxonomyTitle=");
		sb.append(taxonomyTitle);
		sb.append(", title=");
		sb.append(title);
		sb.append(", path=");
		sb.append(path);
		sb.append(", parentStdId=");
		sb.append(parentStdId);
		sb.append(", currentTitle=");
		sb.append(currentTitle);
		sb.append(", type=");
		sb.append(type);
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
		sb.append(", status=");
		sb.append(status);
		sb.append(", imageCount=");
		sb.append(imageCount);
		sb.append(", attachmentCount=");
		sb.append(attachmentCount);
		sb.append(", xRefCount=");
		sb.append(xRefCount);
		sb.append(", hotelLifeCycle=");
		sb.append(hotelLifeCycle);
		sb.append(", complianceCount=");
		sb.append(complianceCount);
		sb.append(", hotelAttributes=");
		sb.append(hotelAttributes);
		sb.append(", complianceDate=");
		sb.append(complianceDate);
		sb.append(", stdReference=");
		sb.append(stdReference);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public BridgePublishPreview toEntityModel() {
		BridgePublishPreviewImpl bridgePublishPreviewImpl = new BridgePublishPreviewImpl();

		bridgePublishPreviewImpl.setStdId(stdId);

		if (taxonomyTitle == null) {
			bridgePublishPreviewImpl.setTaxonomyTitle(StringPool.BLANK);
		}
		else {
			bridgePublishPreviewImpl.setTaxonomyTitle(taxonomyTitle);
		}

		if (title == null) {
			bridgePublishPreviewImpl.setTitle(StringPool.BLANK);
		}
		else {
			bridgePublishPreviewImpl.setTitle(title);
		}

		if (path == null) {
			bridgePublishPreviewImpl.setPath(StringPool.BLANK);
		}
		else {
			bridgePublishPreviewImpl.setPath(path);
		}

		bridgePublishPreviewImpl.setParentStdId(parentStdId);

		if (currentTitle == null) {
			bridgePublishPreviewImpl.setCurrentTitle(StringPool.BLANK);
		}
		else {
			bridgePublishPreviewImpl.setCurrentTitle(currentTitle);
		}

		if (type == null) {
			bridgePublishPreviewImpl.setType(StringPool.BLANK);
		}
		else {
			bridgePublishPreviewImpl.setType(type);
		}

		bridgePublishPreviewImpl.setDisplayOrder(displayOrder);
		bridgePublishPreviewImpl.setTaxonomyId(taxonomyId);
		bridgePublishPreviewImpl.setParentTaxonomyId(parentTaxonomyId);
		bridgePublishPreviewImpl.setIndexOrder(indexOrder);
		bridgePublishPreviewImpl.setLevel(level);
		bridgePublishPreviewImpl.setLevelSortOrder(levelSortOrder);

		if (status == null) {
			bridgePublishPreviewImpl.setStatus(StringPool.BLANK);
		}
		else {
			bridgePublishPreviewImpl.setStatus(status);
		}

		bridgePublishPreviewImpl.setImageCount(imageCount);
		bridgePublishPreviewImpl.setAttachmentCount(attachmentCount);
		bridgePublishPreviewImpl.setXRefCount(xRefCount);
		bridgePublishPreviewImpl.setHotelLifeCycle(hotelLifeCycle);
		bridgePublishPreviewImpl.setComplianceCount(complianceCount);

		if (hotelAttributes == null) {
			bridgePublishPreviewImpl.setHotelAttributes(StringPool.BLANK);
		}
		else {
			bridgePublishPreviewImpl.setHotelAttributes(hotelAttributes);
		}

		if (complianceDate == null) {
			bridgePublishPreviewImpl.setComplianceDate(StringPool.BLANK);
		}
		else {
			bridgePublishPreviewImpl.setComplianceDate(complianceDate);
		}

		if (stdReference == null) {
			bridgePublishPreviewImpl.setStdReference(StringPool.BLANK);
		}
		else {
			bridgePublishPreviewImpl.setStdReference(stdReference);
		}

		bridgePublishPreviewImpl.resetOriginalValues();

		return bridgePublishPreviewImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		stdId = objectInput.readLong();
		taxonomyTitle = objectInput.readUTF();
		title = objectInput.readUTF();
		path = objectInput.readUTF();
		parentStdId = objectInput.readLong();
		currentTitle = objectInput.readUTF();
		type = objectInput.readUTF();
		displayOrder = objectInput.readLong();
		taxonomyId = objectInput.readLong();
		parentTaxonomyId = objectInput.readLong();
		indexOrder = objectInput.readLong();
		level = objectInput.readLong();
		levelSortOrder = objectInput.readLong();
		status = objectInput.readUTF();
		imageCount = objectInput.readLong();
		attachmentCount = objectInput.readLong();
		xRefCount = objectInput.readLong();
		hotelLifeCycle = objectInput.readLong();
		complianceCount = objectInput.readLong();
		hotelAttributes = objectInput.readUTF();
		complianceDate = objectInput.readUTF();
		stdReference = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(stdId);

		if (taxonomyTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(taxonomyTitle);
		}

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (path == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(path);
		}

		objectOutput.writeLong(parentStdId);

		if (currentTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(currentTitle);
		}

		if (type == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(type);
		}

		objectOutput.writeLong(displayOrder);
		objectOutput.writeLong(taxonomyId);
		objectOutput.writeLong(parentTaxonomyId);
		objectOutput.writeLong(indexOrder);
		objectOutput.writeLong(level);
		objectOutput.writeLong(levelSortOrder);

		if (status == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(status);
		}

		objectOutput.writeLong(imageCount);
		objectOutput.writeLong(attachmentCount);
		objectOutput.writeLong(xRefCount);
		objectOutput.writeLong(hotelLifeCycle);
		objectOutput.writeLong(complianceCount);

		if (hotelAttributes == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(hotelAttributes);
		}

		if (complianceDate == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(complianceDate);
		}

		if (stdReference == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(stdReference);
		}
	}

	public long stdId;
	public String taxonomyTitle;
	public String title;
	public String path;
	public long parentStdId;
	public String currentTitle;
	public String type;
	public long displayOrder;
	public long taxonomyId;
	public long parentTaxonomyId;
	public long indexOrder;
	public long level;
	public long levelSortOrder;
	public String status;
	public long imageCount;
	public long attachmentCount;
	public long xRefCount;
	public long hotelLifeCycle;
	public long complianceCount;
	public String hotelAttributes;
	public String complianceDate;
	public String stdReference;
}