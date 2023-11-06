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

import com.ihg.brandstandards.db.model.PublishStd;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PublishStd in entity cache.
 *
 * @author Mummanedi
 * @see PublishStd
 * @generated
 */
public class PublishStdCacheModel implements CacheModel<PublishStd>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(57);

		sb.append("{publishStdVerId=");
		sb.append(publishStdVerId);
		sb.append(", stdId=");
		sb.append(stdId);
		sb.append(", parentId=");
		sb.append(parentId);
		sb.append(", stdTyp=");
		sb.append(stdTyp);
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append(", author=");
		sb.append(author);
		sb.append(", businessOwner=");
		sb.append(businessOwner);
		sb.append(", effectiveDate=");
		sb.append(effectiveDate);
		sb.append(", implDate=");
		sb.append(implDate);
		sb.append(", waiver=");
		sb.append(waiver);
		sb.append(", status=");
		sb.append(status);
		sb.append(", category=");
		sb.append(category);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", change=");
		sb.append(change);
		sb.append(", isGlobal=");
		sb.append(isGlobal);
		sb.append(", regionCode=");
		sb.append(regionCode);
		sb.append(", notes=");
		sb.append(notes);
		sb.append(", framework=");
		sb.append(framework);
		sb.append(", internalReference=");
		sb.append(internalReference);
		sb.append(", orderNumber=");
		sb.append(orderNumber);
		sb.append(", statusIdentifier=");
		sb.append(statusIdentifier);
		sb.append(", regionIdentifier=");
		sb.append(regionIdentifier);
		sb.append(", publishId=");
		sb.append(publishId);
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
	public PublishStd toEntityModel() {
		PublishStdImpl publishStdImpl = new PublishStdImpl();

		publishStdImpl.setPublishStdVerId(publishStdVerId);
		publishStdImpl.setStdId(stdId);
		publishStdImpl.setParentId(parentId);

		if (stdTyp == null) {
			publishStdImpl.setStdTyp(StringPool.BLANK);
		}
		else {
			publishStdImpl.setStdTyp(stdTyp);
		}

		if (title == null) {
			publishStdImpl.setTitle(StringPool.BLANK);
		}
		else {
			publishStdImpl.setTitle(title);
		}

		if (description == null) {
			publishStdImpl.setDescription(StringPool.BLANK);
		}
		else {
			publishStdImpl.setDescription(description);
		}

		if (author == null) {
			publishStdImpl.setAuthor(StringPool.BLANK);
		}
		else {
			publishStdImpl.setAuthor(author);
		}

		if (businessOwner == null) {
			publishStdImpl.setBusinessOwner(StringPool.BLANK);
		}
		else {
			publishStdImpl.setBusinessOwner(businessOwner);
		}

		if (effectiveDate == Long.MIN_VALUE) {
			publishStdImpl.setEffectiveDate(null);
		}
		else {
			publishStdImpl.setEffectiveDate(new Date(effectiveDate));
		}

		if (implDate == Long.MIN_VALUE) {
			publishStdImpl.setImplDate(null);
		}
		else {
			publishStdImpl.setImplDate(new Date(implDate));
		}

		if (waiver == null) {
			publishStdImpl.setWaiver(StringPool.BLANK);
		}
		else {
			publishStdImpl.setWaiver(waiver);
		}

		if (status == null) {
			publishStdImpl.setStatus(StringPool.BLANK);
		}
		else {
			publishStdImpl.setStatus(status);
		}

		if (category == null) {
			publishStdImpl.setCategory(StringPool.BLANK);
		}
		else {
			publishStdImpl.setCategory(category);
		}

		if (createdBy == null) {
			publishStdImpl.setCreatedBy(StringPool.BLANK);
		}
		else {
			publishStdImpl.setCreatedBy(createdBy);
		}

		if (change == null) {
			publishStdImpl.setChange(StringPool.BLANK);
		}
		else {
			publishStdImpl.setChange(change);
		}

		if (isGlobal == null) {
			publishStdImpl.setIsGlobal(StringPool.BLANK);
		}
		else {
			publishStdImpl.setIsGlobal(isGlobal);
		}

		if (regionCode == null) {
			publishStdImpl.setRegionCode(StringPool.BLANK);
		}
		else {
			publishStdImpl.setRegionCode(regionCode);
		}

		if (notes == null) {
			publishStdImpl.setNotes(StringPool.BLANK);
		}
		else {
			publishStdImpl.setNotes(notes);
		}

		if (framework == null) {
			publishStdImpl.setFramework(StringPool.BLANK);
		}
		else {
			publishStdImpl.setFramework(framework);
		}

		if (internalReference == null) {
			publishStdImpl.setInternalReference(StringPool.BLANK);
		}
		else {
			publishStdImpl.setInternalReference(internalReference);
		}

		publishStdImpl.setOrderNumber(orderNumber);
		publishStdImpl.setStatusIdentifier(statusIdentifier);
		publishStdImpl.setRegionIdentifier(regionIdentifier);
		publishStdImpl.setPublishId(publishId);

		if (creatorId == null) {
			publishStdImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			publishStdImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			publishStdImpl.setCreatedDate(null);
		}
		else {
			publishStdImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			publishStdImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			publishStdImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			publishStdImpl.setUpdatedDate(null);
		}
		else {
			publishStdImpl.setUpdatedDate(new Date(updatedDate));
		}

		publishStdImpl.resetOriginalValues();

		return publishStdImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		publishStdVerId = objectInput.readLong();
		stdId = objectInput.readLong();
		parentId = objectInput.readLong();
		stdTyp = objectInput.readUTF();
		title = objectInput.readUTF();
		description = objectInput.readUTF();
		author = objectInput.readUTF();
		businessOwner = objectInput.readUTF();
		effectiveDate = objectInput.readLong();
		implDate = objectInput.readLong();
		waiver = objectInput.readUTF();
		status = objectInput.readUTF();
		category = objectInput.readUTF();
		createdBy = objectInput.readUTF();
		change = objectInput.readUTF();
		isGlobal = objectInput.readUTF();
		regionCode = objectInput.readUTF();
		notes = objectInput.readUTF();
		framework = objectInput.readUTF();
		internalReference = objectInput.readUTF();
		orderNumber = objectInput.readLong();
		statusIdentifier = objectInput.readLong();
		regionIdentifier = objectInput.readLong();
		publishId = objectInput.readLong();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(publishStdVerId);
		objectOutput.writeLong(stdId);
		objectOutput.writeLong(parentId);

		if (stdTyp == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(stdTyp);
		}

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (author == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(author);
		}

		if (businessOwner == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(businessOwner);
		}

		objectOutput.writeLong(effectiveDate);
		objectOutput.writeLong(implDate);

		if (waiver == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(waiver);
		}

		if (status == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(status);
		}

		if (category == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(category);
		}

		if (createdBy == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(createdBy);
		}

		if (change == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(change);
		}

		if (isGlobal == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(isGlobal);
		}

		if (regionCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(regionCode);
		}

		if (notes == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(notes);
		}

		if (framework == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(framework);
		}

		if (internalReference == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(internalReference);
		}

		objectOutput.writeLong(orderNumber);
		objectOutput.writeLong(statusIdentifier);
		objectOutput.writeLong(regionIdentifier);
		objectOutput.writeLong(publishId);

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

	public long publishStdVerId;
	public long stdId;
	public long parentId;
	public String stdTyp;
	public String title;
	public String description;
	public String author;
	public String businessOwner;
	public long effectiveDate;
	public long implDate;
	public String waiver;
	public String status;
	public String category;
	public String createdBy;
	public String change;
	public String isGlobal;
	public String regionCode;
	public String notes;
	public String framework;
	public String internalReference;
	public long orderNumber;
	public long statusIdentifier;
	public long regionIdentifier;
	public long publishId;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}