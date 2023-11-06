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

import com.ihg.brandstandards.db.model.Standards;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Standards in entity cache.
 *
 * @author Mummanedi
 * @see Standards
 * @generated
 */
public class StandardsCacheModel implements CacheModel<Standards>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(53);

		sb.append("{stdId=");
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
		sb.append(", creatorId=");
		sb.append(creatorId);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", updatedBy=");
		sb.append(updatedBy);
		sb.append(", updatedDate=");
		sb.append(updatedDate);
		sb.append(", statusId=");
		sb.append(statusId);
		sb.append(", regionId=");
		sb.append(regionId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Standards toEntityModel() {
		StandardsImpl standardsImpl = new StandardsImpl();

		standardsImpl.setStdId(stdId);
		standardsImpl.setParentId(parentId);

		if (stdTyp == null) {
			standardsImpl.setStdTyp(StringPool.BLANK);
		}
		else {
			standardsImpl.setStdTyp(stdTyp);
		}

		if (title == null) {
			standardsImpl.setTitle(StringPool.BLANK);
		}
		else {
			standardsImpl.setTitle(title);
		}

		if (description == null) {
			standardsImpl.setDescription(StringPool.BLANK);
		}
		else {
			standardsImpl.setDescription(description);
		}

		if (author == null) {
			standardsImpl.setAuthor(StringPool.BLANK);
		}
		else {
			standardsImpl.setAuthor(author);
		}

		if (businessOwner == null) {
			standardsImpl.setBusinessOwner(StringPool.BLANK);
		}
		else {
			standardsImpl.setBusinessOwner(businessOwner);
		}

		if (effectiveDate == Long.MIN_VALUE) {
			standardsImpl.setEffectiveDate(null);
		}
		else {
			standardsImpl.setEffectiveDate(new Date(effectiveDate));
		}

		if (implDate == Long.MIN_VALUE) {
			standardsImpl.setImplDate(null);
		}
		else {
			standardsImpl.setImplDate(new Date(implDate));
		}

		if (waiver == null) {
			standardsImpl.setWaiver(StringPool.BLANK);
		}
		else {
			standardsImpl.setWaiver(waiver);
		}

		if (status == null) {
			standardsImpl.setStatus(StringPool.BLANK);
		}
		else {
			standardsImpl.setStatus(status);
		}

		if (category == null) {
			standardsImpl.setCategory(StringPool.BLANK);
		}
		else {
			standardsImpl.setCategory(category);
		}

		if (createdBy == null) {
			standardsImpl.setCreatedBy(StringPool.BLANK);
		}
		else {
			standardsImpl.setCreatedBy(createdBy);
		}

		if (change == null) {
			standardsImpl.setChange(StringPool.BLANK);
		}
		else {
			standardsImpl.setChange(change);
		}

		if (isGlobal == null) {
			standardsImpl.setIsGlobal(StringPool.BLANK);
		}
		else {
			standardsImpl.setIsGlobal(isGlobal);
		}

		if (regionCode == null) {
			standardsImpl.setRegionCode(StringPool.BLANK);
		}
		else {
			standardsImpl.setRegionCode(regionCode);
		}

		if (notes == null) {
			standardsImpl.setNotes(StringPool.BLANK);
		}
		else {
			standardsImpl.setNotes(notes);
		}

		if (framework == null) {
			standardsImpl.setFramework(StringPool.BLANK);
		}
		else {
			standardsImpl.setFramework(framework);
		}

		if (internalReference == null) {
			standardsImpl.setInternalReference(StringPool.BLANK);
		}
		else {
			standardsImpl.setInternalReference(internalReference);
		}

		standardsImpl.setOrderNumber(orderNumber);

		if (creatorId == null) {
			standardsImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			standardsImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			standardsImpl.setCreatedDate(null);
		}
		else {
			standardsImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			standardsImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			standardsImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			standardsImpl.setUpdatedDate(null);
		}
		else {
			standardsImpl.setUpdatedDate(new Date(updatedDate));
		}

		standardsImpl.setStatusId(statusId);
		standardsImpl.setRegionId(regionId);

		standardsImpl.resetOriginalValues();

		return standardsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
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
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
		statusId = objectInput.readLong();
		regionId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
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
		objectOutput.writeLong(statusId);
		objectOutput.writeLong(regionId);
	}

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
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
	public long statusId;
	public long regionId;
}