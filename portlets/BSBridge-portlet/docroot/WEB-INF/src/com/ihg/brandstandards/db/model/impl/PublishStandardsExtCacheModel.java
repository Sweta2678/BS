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

import com.ihg.brandstandards.db.model.PublishStandardsExt;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PublishStandardsExt in entity cache.
 *
 * @author Mummanedi
 * @see PublishStandardsExt
 * @generated
 */
public class PublishStandardsExtCacheModel implements CacheModel<PublishStandardsExt>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(119);

		sb.append("{publishStdId=");
		sb.append(publishStdId);
		sb.append(", publishId=");
		sb.append(publishId);
		sb.append(", stdId=");
		sb.append(stdId);
		sb.append(", parentPublishId=");
		sb.append(parentPublishId);
		sb.append(", stdTyp=");
		sb.append(stdTyp);
		sb.append(", title=");
		sb.append(title);
		sb.append(", prevPublishTitle=");
		sb.append(prevPublishTitle);
		sb.append(", description=");
		sb.append(description);
		sb.append(", prevDescription=");
		sb.append(prevDescription);
		sb.append(", author=");
		sb.append(author);
		sb.append(", businessOwner=");
		sb.append(businessOwner);
		sb.append(", effectiveDate=");
		sb.append(effectiveDate);
		sb.append(", implDate=");
		sb.append(implDate);
		sb.append(", prevCmplyDate=");
		sb.append(prevCmplyDate);
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
		sb.append(", region=");
		sb.append(region);
		sb.append(", statusIdentifier=");
		sb.append(statusIdentifier);
		sb.append(", sortOrder=");
		sb.append(sortOrder);
		sb.append(", localeCode=");
		sb.append(localeCode);
		sb.append(", taxonomyId=");
		sb.append(taxonomyId);
		sb.append(", prntTaxonomyId=");
		sb.append(prntTaxonomyId);
		sb.append(", attachmentExists=");
		sb.append(attachmentExists);
		sb.append(", attachmentList=");
		sb.append(attachmentList);
		sb.append(", linkExists=");
		sb.append(linkExists);
		sb.append(", linkList=");
		sb.append(linkList);
		sb.append(", imageExists=");
		sb.append(imageExists);
		sb.append(", stdXrefListStdId=");
		sb.append(stdXrefListStdId);
		sb.append(", attachmentStatus=");
		sb.append(attachmentStatus);
		sb.append(", linkStatus=");
		sb.append(linkStatus);
		sb.append(", imageStatus=");
		sb.append(imageStatus);
		sb.append(", imageIdList=");
		sb.append(imageIdList);
		sb.append(", indexOrder=");
		sb.append(indexOrder);
		sb.append(", publishTaxonomyId=");
		sb.append(publishTaxonomyId);
		sb.append(", parentTaxonomyId=");
		sb.append(parentTaxonomyId);
		sb.append(", indexTitle=");
		sb.append(indexTitle);
		sb.append(", indexLvl=");
		sb.append(indexLvl);
		sb.append(", taxonomyPath=");
		sb.append(taxonomyPath);
		sb.append(", levelSortOrder=");
		sb.append(levelSortOrder);
		sb.append(", indexDescription=");
		sb.append(indexDescription);
		sb.append(", matchedId=");
		sb.append(matchedId);
		sb.append(", expiryDate=");
		sb.append(expiryDate);
		sb.append(", prevExpiryDate=");
		sb.append(prevExpiryDate);
		sb.append(", expiredStdId=");
		sb.append(expiredStdId);
		sb.append(", flagStdId=");
		sb.append(flagStdId);
		sb.append(", prevFlagStdId=");
		sb.append(prevFlagStdId);
		sb.append(", titleChange=");
		sb.append(titleChange);
		sb.append(", cmplyChange=");
		sb.append(cmplyChange);
		sb.append(", exprChange=");
		sb.append(exprChange);
		sb.append(", hlcChange=");
		sb.append(hlcChange);
		sb.append(", changedStatus=");
		sb.append(changedStatus);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PublishStandardsExt toEntityModel() {
		PublishStandardsExtImpl publishStandardsExtImpl = new PublishStandardsExtImpl();

		publishStandardsExtImpl.setPublishStdId(publishStdId);
		publishStandardsExtImpl.setPublishId(publishId);
		publishStandardsExtImpl.setStdId(stdId);
		publishStandardsExtImpl.setParentPublishId(parentPublishId);

		if (stdTyp == null) {
			publishStandardsExtImpl.setStdTyp(StringPool.BLANK);
		}
		else {
			publishStandardsExtImpl.setStdTyp(stdTyp);
		}

		if (title == null) {
			publishStandardsExtImpl.setTitle(StringPool.BLANK);
		}
		else {
			publishStandardsExtImpl.setTitle(title);
		}

		if (prevPublishTitle == null) {
			publishStandardsExtImpl.setPrevPublishTitle(StringPool.BLANK);
		}
		else {
			publishStandardsExtImpl.setPrevPublishTitle(prevPublishTitle);
		}

		if (description == null) {
			publishStandardsExtImpl.setDescription(StringPool.BLANK);
		}
		else {
			publishStandardsExtImpl.setDescription(description);
		}

		if (prevDescription == null) {
			publishStandardsExtImpl.setPrevDescription(StringPool.BLANK);
		}
		else {
			publishStandardsExtImpl.setPrevDescription(prevDescription);
		}

		if (author == null) {
			publishStandardsExtImpl.setAuthor(StringPool.BLANK);
		}
		else {
			publishStandardsExtImpl.setAuthor(author);
		}

		if (businessOwner == null) {
			publishStandardsExtImpl.setBusinessOwner(StringPool.BLANK);
		}
		else {
			publishStandardsExtImpl.setBusinessOwner(businessOwner);
		}

		if (effectiveDate == Long.MIN_VALUE) {
			publishStandardsExtImpl.setEffectiveDate(null);
		}
		else {
			publishStandardsExtImpl.setEffectiveDate(new Date(effectiveDate));
		}

		if (implDate == Long.MIN_VALUE) {
			publishStandardsExtImpl.setImplDate(null);
		}
		else {
			publishStandardsExtImpl.setImplDate(new Date(implDate));
		}

		if (prevCmplyDate == Long.MIN_VALUE) {
			publishStandardsExtImpl.setPrevCmplyDate(null);
		}
		else {
			publishStandardsExtImpl.setPrevCmplyDate(new Date(prevCmplyDate));
		}

		if (waiver == null) {
			publishStandardsExtImpl.setWaiver(StringPool.BLANK);
		}
		else {
			publishStandardsExtImpl.setWaiver(waiver);
		}

		if (status == null) {
			publishStandardsExtImpl.setStatus(StringPool.BLANK);
		}
		else {
			publishStandardsExtImpl.setStatus(status);
		}

		if (category == null) {
			publishStandardsExtImpl.setCategory(StringPool.BLANK);
		}
		else {
			publishStandardsExtImpl.setCategory(category);
		}

		if (createdBy == null) {
			publishStandardsExtImpl.setCreatedBy(StringPool.BLANK);
		}
		else {
			publishStandardsExtImpl.setCreatedBy(createdBy);
		}

		if (change == null) {
			publishStandardsExtImpl.setChange(StringPool.BLANK);
		}
		else {
			publishStandardsExtImpl.setChange(change);
		}

		if (isGlobal == null) {
			publishStandardsExtImpl.setIsGlobal(StringPool.BLANK);
		}
		else {
			publishStandardsExtImpl.setIsGlobal(isGlobal);
		}

		if (regionCode == null) {
			publishStandardsExtImpl.setRegionCode(StringPool.BLANK);
		}
		else {
			publishStandardsExtImpl.setRegionCode(regionCode);
		}

		if (notes == null) {
			publishStandardsExtImpl.setNotes(StringPool.BLANK);
		}
		else {
			publishStandardsExtImpl.setNotes(notes);
		}

		if (framework == null) {
			publishStandardsExtImpl.setFramework(StringPool.BLANK);
		}
		else {
			publishStandardsExtImpl.setFramework(framework);
		}

		if (internalReference == null) {
			publishStandardsExtImpl.setInternalReference(StringPool.BLANK);
		}
		else {
			publishStandardsExtImpl.setInternalReference(internalReference);
		}

		if (region == null) {
			publishStandardsExtImpl.setRegion(StringPool.BLANK);
		}
		else {
			publishStandardsExtImpl.setRegion(region);
		}

		if (statusIdentifier == null) {
			publishStandardsExtImpl.setStatusIdentifier(StringPool.BLANK);
		}
		else {
			publishStandardsExtImpl.setStatusIdentifier(statusIdentifier);
		}

		publishStandardsExtImpl.setSortOrder(sortOrder);

		if (localeCode == null) {
			publishStandardsExtImpl.setLocaleCode(StringPool.BLANK);
		}
		else {
			publishStandardsExtImpl.setLocaleCode(localeCode);
		}

		publishStandardsExtImpl.setTaxonomyId(taxonomyId);
		publishStandardsExtImpl.setPrntTaxonomyId(prntTaxonomyId);

		if (attachmentExists == null) {
			publishStandardsExtImpl.setAttachmentExists(StringPool.BLANK);
		}
		else {
			publishStandardsExtImpl.setAttachmentExists(attachmentExists);
		}

		if (attachmentList == null) {
			publishStandardsExtImpl.setAttachmentList(StringPool.BLANK);
		}
		else {
			publishStandardsExtImpl.setAttachmentList(attachmentList);
		}

		if (linkExists == null) {
			publishStandardsExtImpl.setLinkExists(StringPool.BLANK);
		}
		else {
			publishStandardsExtImpl.setLinkExists(linkExists);
		}

		if (linkList == null) {
			publishStandardsExtImpl.setLinkList(StringPool.BLANK);
		}
		else {
			publishStandardsExtImpl.setLinkList(linkList);
		}

		if (imageExists == null) {
			publishStandardsExtImpl.setImageExists(StringPool.BLANK);
		}
		else {
			publishStandardsExtImpl.setImageExists(imageExists);
		}

		if (stdXrefListStdId == null) {
			publishStandardsExtImpl.setStdXrefListStdId(StringPool.BLANK);
		}
		else {
			publishStandardsExtImpl.setStdXrefListStdId(stdXrefListStdId);
		}

		if (attachmentStatus == null) {
			publishStandardsExtImpl.setAttachmentStatus(StringPool.BLANK);
		}
		else {
			publishStandardsExtImpl.setAttachmentStatus(attachmentStatus);
		}

		if (linkStatus == null) {
			publishStandardsExtImpl.setLinkStatus(StringPool.BLANK);
		}
		else {
			publishStandardsExtImpl.setLinkStatus(linkStatus);
		}

		if (imageStatus == null) {
			publishStandardsExtImpl.setImageStatus(StringPool.BLANK);
		}
		else {
			publishStandardsExtImpl.setImageStatus(imageStatus);
		}

		if (imageIdList == null) {
			publishStandardsExtImpl.setImageIdList(StringPool.BLANK);
		}
		else {
			publishStandardsExtImpl.setImageIdList(imageIdList);
		}

		publishStandardsExtImpl.setIndexOrder(indexOrder);
		publishStandardsExtImpl.setPublishTaxonomyId(publishTaxonomyId);
		publishStandardsExtImpl.setParentTaxonomyId(parentTaxonomyId);

		if (indexTitle == null) {
			publishStandardsExtImpl.setIndexTitle(StringPool.BLANK);
		}
		else {
			publishStandardsExtImpl.setIndexTitle(indexTitle);
		}

		publishStandardsExtImpl.setIndexLvl(indexLvl);

		if (taxonomyPath == null) {
			publishStandardsExtImpl.setTaxonomyPath(StringPool.BLANK);
		}
		else {
			publishStandardsExtImpl.setTaxonomyPath(taxonomyPath);
		}

		publishStandardsExtImpl.setLevelSortOrder(levelSortOrder);

		if (indexDescription == null) {
			publishStandardsExtImpl.setIndexDescription(StringPool.BLANK);
		}
		else {
			publishStandardsExtImpl.setIndexDescription(indexDescription);
		}

		if (matchedId == null) {
			publishStandardsExtImpl.setMatchedId(StringPool.BLANK);
		}
		else {
			publishStandardsExtImpl.setMatchedId(matchedId);
		}

		if (expiryDate == Long.MIN_VALUE) {
			publishStandardsExtImpl.setExpiryDate(null);
		}
		else {
			publishStandardsExtImpl.setExpiryDate(new Date(expiryDate));
		}

		if (prevExpiryDate == Long.MIN_VALUE) {
			publishStandardsExtImpl.setPrevExpiryDate(null);
		}
		else {
			publishStandardsExtImpl.setPrevExpiryDate(new Date(prevExpiryDate));
		}

		if (expiredStdId == null) {
			publishStandardsExtImpl.setExpiredStdId(StringPool.BLANK);
		}
		else {
			publishStandardsExtImpl.setExpiredStdId(expiredStdId);
		}

		if (flagStdId == null) {
			publishStandardsExtImpl.setFlagStdId(StringPool.BLANK);
		}
		else {
			publishStandardsExtImpl.setFlagStdId(flagStdId);
		}

		if (prevFlagStdId == null) {
			publishStandardsExtImpl.setPrevFlagStdId(StringPool.BLANK);
		}
		else {
			publishStandardsExtImpl.setPrevFlagStdId(prevFlagStdId);
		}

		if (titleChange == null) {
			publishStandardsExtImpl.setTitleChange(StringPool.BLANK);
		}
		else {
			publishStandardsExtImpl.setTitleChange(titleChange);
		}

		if (cmplyChange == null) {
			publishStandardsExtImpl.setCmplyChange(StringPool.BLANK);
		}
		else {
			publishStandardsExtImpl.setCmplyChange(cmplyChange);
		}

		if (exprChange == null) {
			publishStandardsExtImpl.setExprChange(StringPool.BLANK);
		}
		else {
			publishStandardsExtImpl.setExprChange(exprChange);
		}

		if (hlcChange == null) {
			publishStandardsExtImpl.setHlcChange(StringPool.BLANK);
		}
		else {
			publishStandardsExtImpl.setHlcChange(hlcChange);
		}

		if (changedStatus == null) {
			publishStandardsExtImpl.setChangedStatus(StringPool.BLANK);
		}
		else {
			publishStandardsExtImpl.setChangedStatus(changedStatus);
		}

		publishStandardsExtImpl.resetOriginalValues();

		return publishStandardsExtImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		publishStdId = objectInput.readLong();
		publishId = objectInput.readLong();
		stdId = objectInput.readLong();
		parentPublishId = objectInput.readLong();
		stdTyp = objectInput.readUTF();
		title = objectInput.readUTF();
		prevPublishTitle = objectInput.readUTF();
		description = objectInput.readUTF();
		prevDescription = objectInput.readUTF();
		author = objectInput.readUTF();
		businessOwner = objectInput.readUTF();
		effectiveDate = objectInput.readLong();
		implDate = objectInput.readLong();
		prevCmplyDate = objectInput.readLong();
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
		region = objectInput.readUTF();
		statusIdentifier = objectInput.readUTF();
		sortOrder = objectInput.readLong();
		localeCode = objectInput.readUTF();
		taxonomyId = objectInput.readLong();
		prntTaxonomyId = objectInput.readLong();
		attachmentExists = objectInput.readUTF();
		attachmentList = objectInput.readUTF();
		linkExists = objectInput.readUTF();
		linkList = objectInput.readUTF();
		imageExists = objectInput.readUTF();
		stdXrefListStdId = objectInput.readUTF();
		attachmentStatus = objectInput.readUTF();
		linkStatus = objectInput.readUTF();
		imageStatus = objectInput.readUTF();
		imageIdList = objectInput.readUTF();
		indexOrder = objectInput.readLong();
		publishTaxonomyId = objectInput.readLong();
		parentTaxonomyId = objectInput.readLong();
		indexTitle = objectInput.readUTF();
		indexLvl = objectInput.readLong();
		taxonomyPath = objectInput.readUTF();
		levelSortOrder = objectInput.readLong();
		indexDescription = objectInput.readUTF();
		matchedId = objectInput.readUTF();
		expiryDate = objectInput.readLong();
		prevExpiryDate = objectInput.readLong();
		expiredStdId = objectInput.readUTF();
		flagStdId = objectInput.readUTF();
		prevFlagStdId = objectInput.readUTF();
		titleChange = objectInput.readUTF();
		cmplyChange = objectInput.readUTF();
		exprChange = objectInput.readUTF();
		hlcChange = objectInput.readUTF();
		changedStatus = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(publishStdId);
		objectOutput.writeLong(publishId);
		objectOutput.writeLong(stdId);
		objectOutput.writeLong(parentPublishId);

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

		if (prevPublishTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(prevPublishTitle);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (prevDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(prevDescription);
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
		objectOutput.writeLong(prevCmplyDate);

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

		if (region == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(region);
		}

		if (statusIdentifier == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(statusIdentifier);
		}

		objectOutput.writeLong(sortOrder);

		if (localeCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(localeCode);
		}

		objectOutput.writeLong(taxonomyId);
		objectOutput.writeLong(prntTaxonomyId);

		if (attachmentExists == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(attachmentExists);
		}

		if (attachmentList == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(attachmentList);
		}

		if (linkExists == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(linkExists);
		}

		if (linkList == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(linkList);
		}

		if (imageExists == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(imageExists);
		}

		if (stdXrefListStdId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(stdXrefListStdId);
		}

		if (attachmentStatus == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(attachmentStatus);
		}

		if (linkStatus == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(linkStatus);
		}

		if (imageStatus == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(imageStatus);
		}

		if (imageIdList == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(imageIdList);
		}

		objectOutput.writeLong(indexOrder);
		objectOutput.writeLong(publishTaxonomyId);
		objectOutput.writeLong(parentTaxonomyId);

		if (indexTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(indexTitle);
		}

		objectOutput.writeLong(indexLvl);

		if (taxonomyPath == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(taxonomyPath);
		}

		objectOutput.writeLong(levelSortOrder);

		if (indexDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(indexDescription);
		}

		if (matchedId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(matchedId);
		}

		objectOutput.writeLong(expiryDate);
		objectOutput.writeLong(prevExpiryDate);

		if (expiredStdId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(expiredStdId);
		}

		if (flagStdId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(flagStdId);
		}

		if (prevFlagStdId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(prevFlagStdId);
		}

		if (titleChange == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(titleChange);
		}

		if (cmplyChange == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cmplyChange);
		}

		if (exprChange == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(exprChange);
		}

		if (hlcChange == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(hlcChange);
		}

		if (changedStatus == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(changedStatus);
		}
	}

	public long publishStdId;
	public long publishId;
	public long stdId;
	public long parentPublishId;
	public String stdTyp;
	public String title;
	public String prevPublishTitle;
	public String description;
	public String prevDescription;
	public String author;
	public String businessOwner;
	public long effectiveDate;
	public long implDate;
	public long prevCmplyDate;
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
	public String region;
	public String statusIdentifier;
	public long sortOrder;
	public String localeCode;
	public long taxonomyId;
	public long prntTaxonomyId;
	public String attachmentExists;
	public String attachmentList;
	public String linkExists;
	public String linkList;
	public String imageExists;
	public String stdXrefListStdId;
	public String attachmentStatus;
	public String linkStatus;
	public String imageStatus;
	public String imageIdList;
	public long indexOrder;
	public long publishTaxonomyId;
	public long parentTaxonomyId;
	public String indexTitle;
	public long indexLvl;
	public String taxonomyPath;
	public long levelSortOrder;
	public String indexDescription;
	public String matchedId;
	public long expiryDate;
	public long prevExpiryDate;
	public String expiredStdId;
	public String flagStdId;
	public String prevFlagStdId;
	public String titleChange;
	public String cmplyChange;
	public String exprChange;
	public String hlcChange;
	public String changedStatus;
}