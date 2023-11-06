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

package com.ihg.brandstandards.db.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link PublishStandardsExt}.
 * </p>
 *
 * @author Mummanedi
 * @see PublishStandardsExt
 * @generated
 */
public class PublishStandardsExtWrapper implements PublishStandardsExt,
	ModelWrapper<PublishStandardsExt> {
	public PublishStandardsExtWrapper(PublishStandardsExt publishStandardsExt) {
		_publishStandardsExt = publishStandardsExt;
	}

	@Override
	public Class<?> getModelClass() {
		return PublishStandardsExt.class;
	}

	@Override
	public String getModelClassName() {
		return PublishStandardsExt.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("publishStdId", getPublishStdId());
		attributes.put("publishId", getPublishId());
		attributes.put("stdId", getStdId());
		attributes.put("parentPublishId", getParentPublishId());
		attributes.put("stdTyp", getStdTyp());
		attributes.put("title", getTitle());
		attributes.put("prevPublishTitle", getPrevPublishTitle());
		attributes.put("description", getDescription());
		attributes.put("prevDescription", getPrevDescription());
		attributes.put("author", getAuthor());
		attributes.put("businessOwner", getBusinessOwner());
		attributes.put("effectiveDate", getEffectiveDate());
		attributes.put("implDate", getImplDate());
		attributes.put("prevCmplyDate", getPrevCmplyDate());
		attributes.put("waiver", getWaiver());
		attributes.put("status", getStatus());
		attributes.put("category", getCategory());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("change", getChange());
		attributes.put("isGlobal", getIsGlobal());
		attributes.put("regionCode", getRegionCode());
		attributes.put("notes", getNotes());
		attributes.put("framework", getFramework());
		attributes.put("internalReference", getInternalReference());
		attributes.put("region", getRegion());
		attributes.put("statusIdentifier", getStatusIdentifier());
		attributes.put("sortOrder", getSortOrder());
		attributes.put("localeCode", getLocaleCode());
		attributes.put("taxonomyId", getTaxonomyId());
		attributes.put("prntTaxonomyId", getPrntTaxonomyId());
		attributes.put("attachmentExists", getAttachmentExists());
		attributes.put("attachmentList", getAttachmentList());
		attributes.put("linkExists", getLinkExists());
		attributes.put("linkList", getLinkList());
		attributes.put("imageExists", getImageExists());
		attributes.put("stdXrefListStdId", getStdXrefListStdId());
		attributes.put("attachmentStatus", getAttachmentStatus());
		attributes.put("linkStatus", getLinkStatus());
		attributes.put("imageStatus", getImageStatus());
		attributes.put("imageIdList", getImageIdList());
		attributes.put("indexOrder", getIndexOrder());
		attributes.put("publishTaxonomyId", getPublishTaxonomyId());
		attributes.put("parentTaxonomyId", getParentTaxonomyId());
		attributes.put("indexTitle", getIndexTitle());
		attributes.put("indexLvl", getIndexLvl());
		attributes.put("taxonomyPath", getTaxonomyPath());
		attributes.put("levelSortOrder", getLevelSortOrder());
		attributes.put("indexDescription", getIndexDescription());
		attributes.put("matchedId", getMatchedId());
		attributes.put("expiryDate", getExpiryDate());
		attributes.put("prevExpiryDate", getPrevExpiryDate());
		attributes.put("expiredStdId", getExpiredStdId());
		attributes.put("flagStdId", getFlagStdId());
		attributes.put("prevFlagStdId", getPrevFlagStdId());
		attributes.put("titleChange", getTitleChange());
		attributes.put("cmplyChange", getCmplyChange());
		attributes.put("exprChange", getExprChange());
		attributes.put("hlcChange", getHlcChange());
		attributes.put("changedStatus", getChangedStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long publishStdId = (Long)attributes.get("publishStdId");

		if (publishStdId != null) {
			setPublishStdId(publishStdId);
		}

		Long publishId = (Long)attributes.get("publishId");

		if (publishId != null) {
			setPublishId(publishId);
		}

		Long stdId = (Long)attributes.get("stdId");

		if (stdId != null) {
			setStdId(stdId);
		}

		Long parentPublishId = (Long)attributes.get("parentPublishId");

		if (parentPublishId != null) {
			setParentPublishId(parentPublishId);
		}

		String stdTyp = (String)attributes.get("stdTyp");

		if (stdTyp != null) {
			setStdTyp(stdTyp);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String prevPublishTitle = (String)attributes.get("prevPublishTitle");

		if (prevPublishTitle != null) {
			setPrevPublishTitle(prevPublishTitle);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String prevDescription = (String)attributes.get("prevDescription");

		if (prevDescription != null) {
			setPrevDescription(prevDescription);
		}

		String author = (String)attributes.get("author");

		if (author != null) {
			setAuthor(author);
		}

		String businessOwner = (String)attributes.get("businessOwner");

		if (businessOwner != null) {
			setBusinessOwner(businessOwner);
		}

		Date effectiveDate = (Date)attributes.get("effectiveDate");

		if (effectiveDate != null) {
			setEffectiveDate(effectiveDate);
		}

		Date implDate = (Date)attributes.get("implDate");

		if (implDate != null) {
			setImplDate(implDate);
		}

		Date prevCmplyDate = (Date)attributes.get("prevCmplyDate");

		if (prevCmplyDate != null) {
			setPrevCmplyDate(prevCmplyDate);
		}

		String waiver = (String)attributes.get("waiver");

		if (waiver != null) {
			setWaiver(waiver);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String category = (String)attributes.get("category");

		if (category != null) {
			setCategory(category);
		}

		String createdBy = (String)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		String change = (String)attributes.get("change");

		if (change != null) {
			setChange(change);
		}

		String isGlobal = (String)attributes.get("isGlobal");

		if (isGlobal != null) {
			setIsGlobal(isGlobal);
		}

		String regionCode = (String)attributes.get("regionCode");

		if (regionCode != null) {
			setRegionCode(regionCode);
		}

		String notes = (String)attributes.get("notes");

		if (notes != null) {
			setNotes(notes);
		}

		String framework = (String)attributes.get("framework");

		if (framework != null) {
			setFramework(framework);
		}

		String internalReference = (String)attributes.get("internalReference");

		if (internalReference != null) {
			setInternalReference(internalReference);
		}

		String region = (String)attributes.get("region");

		if (region != null) {
			setRegion(region);
		}

		String statusIdentifier = (String)attributes.get("statusIdentifier");

		if (statusIdentifier != null) {
			setStatusIdentifier(statusIdentifier);
		}

		Long sortOrder = (Long)attributes.get("sortOrder");

		if (sortOrder != null) {
			setSortOrder(sortOrder);
		}

		String localeCode = (String)attributes.get("localeCode");

		if (localeCode != null) {
			setLocaleCode(localeCode);
		}

		Long taxonomyId = (Long)attributes.get("taxonomyId");

		if (taxonomyId != null) {
			setTaxonomyId(taxonomyId);
		}

		Long prntTaxonomyId = (Long)attributes.get("prntTaxonomyId");

		if (prntTaxonomyId != null) {
			setPrntTaxonomyId(prntTaxonomyId);
		}

		String attachmentExists = (String)attributes.get("attachmentExists");

		if (attachmentExists != null) {
			setAttachmentExists(attachmentExists);
		}

		String attachmentList = (String)attributes.get("attachmentList");

		if (attachmentList != null) {
			setAttachmentList(attachmentList);
		}

		String linkExists = (String)attributes.get("linkExists");

		if (linkExists != null) {
			setLinkExists(linkExists);
		}

		String linkList = (String)attributes.get("linkList");

		if (linkList != null) {
			setLinkList(linkList);
		}

		String imageExists = (String)attributes.get("imageExists");

		if (imageExists != null) {
			setImageExists(imageExists);
		}

		String stdXrefListStdId = (String)attributes.get("stdXrefListStdId");

		if (stdXrefListStdId != null) {
			setStdXrefListStdId(stdXrefListStdId);
		}

		String attachmentStatus = (String)attributes.get("attachmentStatus");

		if (attachmentStatus != null) {
			setAttachmentStatus(attachmentStatus);
		}

		String linkStatus = (String)attributes.get("linkStatus");

		if (linkStatus != null) {
			setLinkStatus(linkStatus);
		}

		String imageStatus = (String)attributes.get("imageStatus");

		if (imageStatus != null) {
			setImageStatus(imageStatus);
		}

		String imageIdList = (String)attributes.get("imageIdList");

		if (imageIdList != null) {
			setImageIdList(imageIdList);
		}

		Long indexOrder = (Long)attributes.get("indexOrder");

		if (indexOrder != null) {
			setIndexOrder(indexOrder);
		}

		Long publishTaxonomyId = (Long)attributes.get("publishTaxonomyId");

		if (publishTaxonomyId != null) {
			setPublishTaxonomyId(publishTaxonomyId);
		}

		Long parentTaxonomyId = (Long)attributes.get("parentTaxonomyId");

		if (parentTaxonomyId != null) {
			setParentTaxonomyId(parentTaxonomyId);
		}

		String indexTitle = (String)attributes.get("indexTitle");

		if (indexTitle != null) {
			setIndexTitle(indexTitle);
		}

		Long indexLvl = (Long)attributes.get("indexLvl");

		if (indexLvl != null) {
			setIndexLvl(indexLvl);
		}

		String taxonomyPath = (String)attributes.get("taxonomyPath");

		if (taxonomyPath != null) {
			setTaxonomyPath(taxonomyPath);
		}

		Long levelSortOrder = (Long)attributes.get("levelSortOrder");

		if (levelSortOrder != null) {
			setLevelSortOrder(levelSortOrder);
		}

		String indexDescription = (String)attributes.get("indexDescription");

		if (indexDescription != null) {
			setIndexDescription(indexDescription);
		}

		String matchedId = (String)attributes.get("matchedId");

		if (matchedId != null) {
			setMatchedId(matchedId);
		}

		Date expiryDate = (Date)attributes.get("expiryDate");

		if (expiryDate != null) {
			setExpiryDate(expiryDate);
		}

		Date prevExpiryDate = (Date)attributes.get("prevExpiryDate");

		if (prevExpiryDate != null) {
			setPrevExpiryDate(prevExpiryDate);
		}

		String expiredStdId = (String)attributes.get("expiredStdId");

		if (expiredStdId != null) {
			setExpiredStdId(expiredStdId);
		}

		String flagStdId = (String)attributes.get("flagStdId");

		if (flagStdId != null) {
			setFlagStdId(flagStdId);
		}

		String prevFlagStdId = (String)attributes.get("prevFlagStdId");

		if (prevFlagStdId != null) {
			setPrevFlagStdId(prevFlagStdId);
		}

		String titleChange = (String)attributes.get("titleChange");

		if (titleChange != null) {
			setTitleChange(titleChange);
		}

		String cmplyChange = (String)attributes.get("cmplyChange");

		if (cmplyChange != null) {
			setCmplyChange(cmplyChange);
		}

		String exprChange = (String)attributes.get("exprChange");

		if (exprChange != null) {
			setExprChange(exprChange);
		}

		String hlcChange = (String)attributes.get("hlcChange");

		if (hlcChange != null) {
			setHlcChange(hlcChange);
		}

		String changedStatus = (String)attributes.get("changedStatus");

		if (changedStatus != null) {
			setChangedStatus(changedStatus);
		}
	}

	/**
	* Returns the primary key of this Custom Query mapping to createlist of standards with translations..
	*
	* @return the primary key of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public long getPrimaryKey() {
		return _publishStandardsExt.getPrimaryKey();
	}

	/**
	* Sets the primary key of this Custom Query mapping to createlist of standards with translations..
	*
	* @param primaryKey the primary key of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_publishStandardsExt.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the publish std ID of this Custom Query mapping to createlist of standards with translations..
	*
	* @return the publish std ID of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public long getPublishStdId() {
		return _publishStandardsExt.getPublishStdId();
	}

	/**
	* Sets the publish std ID of this Custom Query mapping to createlist of standards with translations..
	*
	* @param publishStdId the publish std ID of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public void setPublishStdId(long publishStdId) {
		_publishStandardsExt.setPublishStdId(publishStdId);
	}

	/**
	* Returns the publish ID of this Custom Query mapping to createlist of standards with translations..
	*
	* @return the publish ID of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public long getPublishId() {
		return _publishStandardsExt.getPublishId();
	}

	/**
	* Sets the publish ID of this Custom Query mapping to createlist of standards with translations..
	*
	* @param publishId the publish ID of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public void setPublishId(long publishId) {
		_publishStandardsExt.setPublishId(publishId);
	}

	/**
	* Returns the std ID of this Custom Query mapping to createlist of standards with translations..
	*
	* @return the std ID of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public long getStdId() {
		return _publishStandardsExt.getStdId();
	}

	/**
	* Sets the std ID of this Custom Query mapping to createlist of standards with translations..
	*
	* @param stdId the std ID of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public void setStdId(long stdId) {
		_publishStandardsExt.setStdId(stdId);
	}

	/**
	* Returns the parent publish ID of this Custom Query mapping to createlist of standards with translations..
	*
	* @return the parent publish ID of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public long getParentPublishId() {
		return _publishStandardsExt.getParentPublishId();
	}

	/**
	* Sets the parent publish ID of this Custom Query mapping to createlist of standards with translations..
	*
	* @param parentPublishId the parent publish ID of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public void setParentPublishId(long parentPublishId) {
		_publishStandardsExt.setParentPublishId(parentPublishId);
	}

	/**
	* Returns the std typ of this Custom Query mapping to createlist of standards with translations..
	*
	* @return the std typ of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public java.lang.String getStdTyp() {
		return _publishStandardsExt.getStdTyp();
	}

	/**
	* Sets the std typ of this Custom Query mapping to createlist of standards with translations..
	*
	* @param stdTyp the std typ of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public void setStdTyp(java.lang.String stdTyp) {
		_publishStandardsExt.setStdTyp(stdTyp);
	}

	/**
	* Returns the title of this Custom Query mapping to createlist of standards with translations..
	*
	* @return the title of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public java.lang.String getTitle() {
		return _publishStandardsExt.getTitle();
	}

	/**
	* Sets the title of this Custom Query mapping to createlist of standards with translations..
	*
	* @param title the title of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_publishStandardsExt.setTitle(title);
	}

	/**
	* Returns the prev publish title of this Custom Query mapping to createlist of standards with translations..
	*
	* @return the prev publish title of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public java.lang.String getPrevPublishTitle() {
		return _publishStandardsExt.getPrevPublishTitle();
	}

	/**
	* Sets the prev publish title of this Custom Query mapping to createlist of standards with translations..
	*
	* @param prevPublishTitle the prev publish title of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public void setPrevPublishTitle(java.lang.String prevPublishTitle) {
		_publishStandardsExt.setPrevPublishTitle(prevPublishTitle);
	}

	/**
	* Returns the description of this Custom Query mapping to createlist of standards with translations..
	*
	* @return the description of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public java.lang.String getDescription() {
		return _publishStandardsExt.getDescription();
	}

	/**
	* Sets the description of this Custom Query mapping to createlist of standards with translations..
	*
	* @param description the description of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_publishStandardsExt.setDescription(description);
	}

	/**
	* Returns the prev description of this Custom Query mapping to createlist of standards with translations..
	*
	* @return the prev description of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public java.lang.String getPrevDescription() {
		return _publishStandardsExt.getPrevDescription();
	}

	/**
	* Sets the prev description of this Custom Query mapping to createlist of standards with translations..
	*
	* @param prevDescription the prev description of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public void setPrevDescription(java.lang.String prevDescription) {
		_publishStandardsExt.setPrevDescription(prevDescription);
	}

	/**
	* Returns the author of this Custom Query mapping to createlist of standards with translations..
	*
	* @return the author of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public java.lang.String getAuthor() {
		return _publishStandardsExt.getAuthor();
	}

	/**
	* Sets the author of this Custom Query mapping to createlist of standards with translations..
	*
	* @param author the author of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public void setAuthor(java.lang.String author) {
		_publishStandardsExt.setAuthor(author);
	}

	/**
	* Returns the business owner of this Custom Query mapping to createlist of standards with translations..
	*
	* @return the business owner of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public java.lang.String getBusinessOwner() {
		return _publishStandardsExt.getBusinessOwner();
	}

	/**
	* Sets the business owner of this Custom Query mapping to createlist of standards with translations..
	*
	* @param businessOwner the business owner of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public void setBusinessOwner(java.lang.String businessOwner) {
		_publishStandardsExt.setBusinessOwner(businessOwner);
	}

	/**
	* Returns the effective date of this Custom Query mapping to createlist of standards with translations..
	*
	* @return the effective date of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public java.util.Date getEffectiveDate() {
		return _publishStandardsExt.getEffectiveDate();
	}

	/**
	* Sets the effective date of this Custom Query mapping to createlist of standards with translations..
	*
	* @param effectiveDate the effective date of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public void setEffectiveDate(java.util.Date effectiveDate) {
		_publishStandardsExt.setEffectiveDate(effectiveDate);
	}

	/**
	* Returns the impl date of this Custom Query mapping to createlist of standards with translations..
	*
	* @return the impl date of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public java.util.Date getImplDate() {
		return _publishStandardsExt.getImplDate();
	}

	/**
	* Sets the impl date of this Custom Query mapping to createlist of standards with translations..
	*
	* @param implDate the impl date of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public void setImplDate(java.util.Date implDate) {
		_publishStandardsExt.setImplDate(implDate);
	}

	/**
	* Returns the prev cmply date of this Custom Query mapping to createlist of standards with translations..
	*
	* @return the prev cmply date of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public java.util.Date getPrevCmplyDate() {
		return _publishStandardsExt.getPrevCmplyDate();
	}

	/**
	* Sets the prev cmply date of this Custom Query mapping to createlist of standards with translations..
	*
	* @param prevCmplyDate the prev cmply date of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public void setPrevCmplyDate(java.util.Date prevCmplyDate) {
		_publishStandardsExt.setPrevCmplyDate(prevCmplyDate);
	}

	/**
	* Returns the waiver of this Custom Query mapping to createlist of standards with translations..
	*
	* @return the waiver of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public java.lang.String getWaiver() {
		return _publishStandardsExt.getWaiver();
	}

	/**
	* Sets the waiver of this Custom Query mapping to createlist of standards with translations..
	*
	* @param waiver the waiver of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public void setWaiver(java.lang.String waiver) {
		_publishStandardsExt.setWaiver(waiver);
	}

	/**
	* Returns the status of this Custom Query mapping to createlist of standards with translations..
	*
	* @return the status of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public java.lang.String getStatus() {
		return _publishStandardsExt.getStatus();
	}

	/**
	* Sets the status of this Custom Query mapping to createlist of standards with translations..
	*
	* @param status the status of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public void setStatus(java.lang.String status) {
		_publishStandardsExt.setStatus(status);
	}

	/**
	* Returns the category of this Custom Query mapping to createlist of standards with translations..
	*
	* @return the category of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public java.lang.String getCategory() {
		return _publishStandardsExt.getCategory();
	}

	/**
	* Sets the category of this Custom Query mapping to createlist of standards with translations..
	*
	* @param category the category of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public void setCategory(java.lang.String category) {
		_publishStandardsExt.setCategory(category);
	}

	/**
	* Returns the created by of this Custom Query mapping to createlist of standards with translations..
	*
	* @return the created by of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public java.lang.String getCreatedBy() {
		return _publishStandardsExt.getCreatedBy();
	}

	/**
	* Sets the created by of this Custom Query mapping to createlist of standards with translations..
	*
	* @param createdBy the created by of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public void setCreatedBy(java.lang.String createdBy) {
		_publishStandardsExt.setCreatedBy(createdBy);
	}

	/**
	* Returns the change of this Custom Query mapping to createlist of standards with translations..
	*
	* @return the change of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public java.lang.String getChange() {
		return _publishStandardsExt.getChange();
	}

	/**
	* Sets the change of this Custom Query mapping to createlist of standards with translations..
	*
	* @param change the change of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public void setChange(java.lang.String change) {
		_publishStandardsExt.setChange(change);
	}

	/**
	* Returns the is global of this Custom Query mapping to createlist of standards with translations..
	*
	* @return the is global of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public java.lang.String getIsGlobal() {
		return _publishStandardsExt.getIsGlobal();
	}

	/**
	* Sets the is global of this Custom Query mapping to createlist of standards with translations..
	*
	* @param isGlobal the is global of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public void setIsGlobal(java.lang.String isGlobal) {
		_publishStandardsExt.setIsGlobal(isGlobal);
	}

	/**
	* Returns the region code of this Custom Query mapping to createlist of standards with translations..
	*
	* @return the region code of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public java.lang.String getRegionCode() {
		return _publishStandardsExt.getRegionCode();
	}

	/**
	* Sets the region code of this Custom Query mapping to createlist of standards with translations..
	*
	* @param regionCode the region code of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public void setRegionCode(java.lang.String regionCode) {
		_publishStandardsExt.setRegionCode(regionCode);
	}

	/**
	* Returns the notes of this Custom Query mapping to createlist of standards with translations..
	*
	* @return the notes of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public java.lang.String getNotes() {
		return _publishStandardsExt.getNotes();
	}

	/**
	* Sets the notes of this Custom Query mapping to createlist of standards with translations..
	*
	* @param notes the notes of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public void setNotes(java.lang.String notes) {
		_publishStandardsExt.setNotes(notes);
	}

	/**
	* Returns the framework of this Custom Query mapping to createlist of standards with translations..
	*
	* @return the framework of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public java.lang.String getFramework() {
		return _publishStandardsExt.getFramework();
	}

	/**
	* Sets the framework of this Custom Query mapping to createlist of standards with translations..
	*
	* @param framework the framework of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public void setFramework(java.lang.String framework) {
		_publishStandardsExt.setFramework(framework);
	}

	/**
	* Returns the internal reference of this Custom Query mapping to createlist of standards with translations..
	*
	* @return the internal reference of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public java.lang.String getInternalReference() {
		return _publishStandardsExt.getInternalReference();
	}

	/**
	* Sets the internal reference of this Custom Query mapping to createlist of standards with translations..
	*
	* @param internalReference the internal reference of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public void setInternalReference(java.lang.String internalReference) {
		_publishStandardsExt.setInternalReference(internalReference);
	}

	/**
	* Returns the region of this Custom Query mapping to createlist of standards with translations..
	*
	* @return the region of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public java.lang.String getRegion() {
		return _publishStandardsExt.getRegion();
	}

	/**
	* Sets the region of this Custom Query mapping to createlist of standards with translations..
	*
	* @param region the region of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public void setRegion(java.lang.String region) {
		_publishStandardsExt.setRegion(region);
	}

	/**
	* Returns the status identifier of this Custom Query mapping to createlist of standards with translations..
	*
	* @return the status identifier of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public java.lang.String getStatusIdentifier() {
		return _publishStandardsExt.getStatusIdentifier();
	}

	/**
	* Sets the status identifier of this Custom Query mapping to createlist of standards with translations..
	*
	* @param statusIdentifier the status identifier of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public void setStatusIdentifier(java.lang.String statusIdentifier) {
		_publishStandardsExt.setStatusIdentifier(statusIdentifier);
	}

	/**
	* Returns the sort order of this Custom Query mapping to createlist of standards with translations..
	*
	* @return the sort order of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public long getSortOrder() {
		return _publishStandardsExt.getSortOrder();
	}

	/**
	* Sets the sort order of this Custom Query mapping to createlist of standards with translations..
	*
	* @param sortOrder the sort order of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public void setSortOrder(long sortOrder) {
		_publishStandardsExt.setSortOrder(sortOrder);
	}

	/**
	* Returns the locale code of this Custom Query mapping to createlist of standards with translations..
	*
	* @return the locale code of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public java.lang.String getLocaleCode() {
		return _publishStandardsExt.getLocaleCode();
	}

	/**
	* Sets the locale code of this Custom Query mapping to createlist of standards with translations..
	*
	* @param localeCode the locale code of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public void setLocaleCode(java.lang.String localeCode) {
		_publishStandardsExt.setLocaleCode(localeCode);
	}

	/**
	* Returns the taxonomy ID of this Custom Query mapping to createlist of standards with translations..
	*
	* @return the taxonomy ID of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public long getTaxonomyId() {
		return _publishStandardsExt.getTaxonomyId();
	}

	/**
	* Sets the taxonomy ID of this Custom Query mapping to createlist of standards with translations..
	*
	* @param taxonomyId the taxonomy ID of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public void setTaxonomyId(long taxonomyId) {
		_publishStandardsExt.setTaxonomyId(taxonomyId);
	}

	/**
	* Returns the prnt taxonomy ID of this Custom Query mapping to createlist of standards with translations..
	*
	* @return the prnt taxonomy ID of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public long getPrntTaxonomyId() {
		return _publishStandardsExt.getPrntTaxonomyId();
	}

	/**
	* Sets the prnt taxonomy ID of this Custom Query mapping to createlist of standards with translations..
	*
	* @param prntTaxonomyId the prnt taxonomy ID of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public void setPrntTaxonomyId(long prntTaxonomyId) {
		_publishStandardsExt.setPrntTaxonomyId(prntTaxonomyId);
	}

	/**
	* Returns the attachment exists of this Custom Query mapping to createlist of standards with translations..
	*
	* @return the attachment exists of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public java.lang.String getAttachmentExists() {
		return _publishStandardsExt.getAttachmentExists();
	}

	/**
	* Sets the attachment exists of this Custom Query mapping to createlist of standards with translations..
	*
	* @param attachmentExists the attachment exists of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public void setAttachmentExists(java.lang.String attachmentExists) {
		_publishStandardsExt.setAttachmentExists(attachmentExists);
	}

	/**
	* Returns the attachment list of this Custom Query mapping to createlist of standards with translations..
	*
	* @return the attachment list of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public java.lang.String getAttachmentList() {
		return _publishStandardsExt.getAttachmentList();
	}

	/**
	* Sets the attachment list of this Custom Query mapping to createlist of standards with translations..
	*
	* @param attachmentList the attachment list of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public void setAttachmentList(java.lang.String attachmentList) {
		_publishStandardsExt.setAttachmentList(attachmentList);
	}

	/**
	* Returns the link exists of this Custom Query mapping to createlist of standards with translations..
	*
	* @return the link exists of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public java.lang.String getLinkExists() {
		return _publishStandardsExt.getLinkExists();
	}

	/**
	* Sets the link exists of this Custom Query mapping to createlist of standards with translations..
	*
	* @param linkExists the link exists of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public void setLinkExists(java.lang.String linkExists) {
		_publishStandardsExt.setLinkExists(linkExists);
	}

	/**
	* Returns the link list of this Custom Query mapping to createlist of standards with translations..
	*
	* @return the link list of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public java.lang.String getLinkList() {
		return _publishStandardsExt.getLinkList();
	}

	/**
	* Sets the link list of this Custom Query mapping to createlist of standards with translations..
	*
	* @param linkList the link list of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public void setLinkList(java.lang.String linkList) {
		_publishStandardsExt.setLinkList(linkList);
	}

	/**
	* Returns the image exists of this Custom Query mapping to createlist of standards with translations..
	*
	* @return the image exists of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public java.lang.String getImageExists() {
		return _publishStandardsExt.getImageExists();
	}

	/**
	* Sets the image exists of this Custom Query mapping to createlist of standards with translations..
	*
	* @param imageExists the image exists of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public void setImageExists(java.lang.String imageExists) {
		_publishStandardsExt.setImageExists(imageExists);
	}

	/**
	* Returns the std xref list std ID of this Custom Query mapping to createlist of standards with translations..
	*
	* @return the std xref list std ID of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public java.lang.String getStdXrefListStdId() {
		return _publishStandardsExt.getStdXrefListStdId();
	}

	/**
	* Sets the std xref list std ID of this Custom Query mapping to createlist of standards with translations..
	*
	* @param stdXrefListStdId the std xref list std ID of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public void setStdXrefListStdId(java.lang.String stdXrefListStdId) {
		_publishStandardsExt.setStdXrefListStdId(stdXrefListStdId);
	}

	/**
	* Returns the attachment status of this Custom Query mapping to createlist of standards with translations..
	*
	* @return the attachment status of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public java.lang.String getAttachmentStatus() {
		return _publishStandardsExt.getAttachmentStatus();
	}

	/**
	* Sets the attachment status of this Custom Query mapping to createlist of standards with translations..
	*
	* @param attachmentStatus the attachment status of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public void setAttachmentStatus(java.lang.String attachmentStatus) {
		_publishStandardsExt.setAttachmentStatus(attachmentStatus);
	}

	/**
	* Returns the link status of this Custom Query mapping to createlist of standards with translations..
	*
	* @return the link status of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public java.lang.String getLinkStatus() {
		return _publishStandardsExt.getLinkStatus();
	}

	/**
	* Sets the link status of this Custom Query mapping to createlist of standards with translations..
	*
	* @param linkStatus the link status of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public void setLinkStatus(java.lang.String linkStatus) {
		_publishStandardsExt.setLinkStatus(linkStatus);
	}

	/**
	* Returns the image status of this Custom Query mapping to createlist of standards with translations..
	*
	* @return the image status of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public java.lang.String getImageStatus() {
		return _publishStandardsExt.getImageStatus();
	}

	/**
	* Sets the image status of this Custom Query mapping to createlist of standards with translations..
	*
	* @param imageStatus the image status of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public void setImageStatus(java.lang.String imageStatus) {
		_publishStandardsExt.setImageStatus(imageStatus);
	}

	/**
	* Returns the image ID list of this Custom Query mapping to createlist of standards with translations..
	*
	* @return the image ID list of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public java.lang.String getImageIdList() {
		return _publishStandardsExt.getImageIdList();
	}

	/**
	* Sets the image ID list of this Custom Query mapping to createlist of standards with translations..
	*
	* @param imageIdList the image ID list of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public void setImageIdList(java.lang.String imageIdList) {
		_publishStandardsExt.setImageIdList(imageIdList);
	}

	/**
	* Returns the index order of this Custom Query mapping to createlist of standards with translations..
	*
	* @return the index order of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public long getIndexOrder() {
		return _publishStandardsExt.getIndexOrder();
	}

	/**
	* Sets the index order of this Custom Query mapping to createlist of standards with translations..
	*
	* @param indexOrder the index order of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public void setIndexOrder(long indexOrder) {
		_publishStandardsExt.setIndexOrder(indexOrder);
	}

	/**
	* Returns the publish taxonomy ID of this Custom Query mapping to createlist of standards with translations..
	*
	* @return the publish taxonomy ID of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public long getPublishTaxonomyId() {
		return _publishStandardsExt.getPublishTaxonomyId();
	}

	/**
	* Sets the publish taxonomy ID of this Custom Query mapping to createlist of standards with translations..
	*
	* @param publishTaxonomyId the publish taxonomy ID of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public void setPublishTaxonomyId(long publishTaxonomyId) {
		_publishStandardsExt.setPublishTaxonomyId(publishTaxonomyId);
	}

	/**
	* Returns the parent taxonomy ID of this Custom Query mapping to createlist of standards with translations..
	*
	* @return the parent taxonomy ID of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public long getParentTaxonomyId() {
		return _publishStandardsExt.getParentTaxonomyId();
	}

	/**
	* Sets the parent taxonomy ID of this Custom Query mapping to createlist of standards with translations..
	*
	* @param parentTaxonomyId the parent taxonomy ID of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public void setParentTaxonomyId(long parentTaxonomyId) {
		_publishStandardsExt.setParentTaxonomyId(parentTaxonomyId);
	}

	/**
	* Returns the index title of this Custom Query mapping to createlist of standards with translations..
	*
	* @return the index title of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public java.lang.String getIndexTitle() {
		return _publishStandardsExt.getIndexTitle();
	}

	/**
	* Sets the index title of this Custom Query mapping to createlist of standards with translations..
	*
	* @param indexTitle the index title of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public void setIndexTitle(java.lang.String indexTitle) {
		_publishStandardsExt.setIndexTitle(indexTitle);
	}

	/**
	* Returns the index lvl of this Custom Query mapping to createlist of standards with translations..
	*
	* @return the index lvl of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public long getIndexLvl() {
		return _publishStandardsExt.getIndexLvl();
	}

	/**
	* Sets the index lvl of this Custom Query mapping to createlist of standards with translations..
	*
	* @param indexLvl the index lvl of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public void setIndexLvl(long indexLvl) {
		_publishStandardsExt.setIndexLvl(indexLvl);
	}

	/**
	* Returns the taxonomy path of this Custom Query mapping to createlist of standards with translations..
	*
	* @return the taxonomy path of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public java.lang.String getTaxonomyPath() {
		return _publishStandardsExt.getTaxonomyPath();
	}

	/**
	* Sets the taxonomy path of this Custom Query mapping to createlist of standards with translations..
	*
	* @param taxonomyPath the taxonomy path of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public void setTaxonomyPath(java.lang.String taxonomyPath) {
		_publishStandardsExt.setTaxonomyPath(taxonomyPath);
	}

	/**
	* Returns the level sort order of this Custom Query mapping to createlist of standards with translations..
	*
	* @return the level sort order of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public long getLevelSortOrder() {
		return _publishStandardsExt.getLevelSortOrder();
	}

	/**
	* Sets the level sort order of this Custom Query mapping to createlist of standards with translations..
	*
	* @param levelSortOrder the level sort order of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public void setLevelSortOrder(long levelSortOrder) {
		_publishStandardsExt.setLevelSortOrder(levelSortOrder);
	}

	/**
	* Returns the index description of this Custom Query mapping to createlist of standards with translations..
	*
	* @return the index description of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public java.lang.String getIndexDescription() {
		return _publishStandardsExt.getIndexDescription();
	}

	/**
	* Sets the index description of this Custom Query mapping to createlist of standards with translations..
	*
	* @param indexDescription the index description of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public void setIndexDescription(java.lang.String indexDescription) {
		_publishStandardsExt.setIndexDescription(indexDescription);
	}

	/**
	* Returns the matched ID of this Custom Query mapping to createlist of standards with translations..
	*
	* @return the matched ID of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public java.lang.String getMatchedId() {
		return _publishStandardsExt.getMatchedId();
	}

	/**
	* Sets the matched ID of this Custom Query mapping to createlist of standards with translations..
	*
	* @param matchedId the matched ID of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public void setMatchedId(java.lang.String matchedId) {
		_publishStandardsExt.setMatchedId(matchedId);
	}

	/**
	* Returns the expiry date of this Custom Query mapping to createlist of standards with translations..
	*
	* @return the expiry date of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public java.util.Date getExpiryDate() {
		return _publishStandardsExt.getExpiryDate();
	}

	/**
	* Sets the expiry date of this Custom Query mapping to createlist of standards with translations..
	*
	* @param expiryDate the expiry date of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public void setExpiryDate(java.util.Date expiryDate) {
		_publishStandardsExt.setExpiryDate(expiryDate);
	}

	/**
	* Returns the prev expiry date of this Custom Query mapping to createlist of standards with translations..
	*
	* @return the prev expiry date of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public java.util.Date getPrevExpiryDate() {
		return _publishStandardsExt.getPrevExpiryDate();
	}

	/**
	* Sets the prev expiry date of this Custom Query mapping to createlist of standards with translations..
	*
	* @param prevExpiryDate the prev expiry date of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public void setPrevExpiryDate(java.util.Date prevExpiryDate) {
		_publishStandardsExt.setPrevExpiryDate(prevExpiryDate);
	}

	/**
	* Returns the expired std ID of this Custom Query mapping to createlist of standards with translations..
	*
	* @return the expired std ID of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public java.lang.String getExpiredStdId() {
		return _publishStandardsExt.getExpiredStdId();
	}

	/**
	* Sets the expired std ID of this Custom Query mapping to createlist of standards with translations..
	*
	* @param expiredStdId the expired std ID of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public void setExpiredStdId(java.lang.String expiredStdId) {
		_publishStandardsExt.setExpiredStdId(expiredStdId);
	}

	/**
	* Returns the flag std ID of this Custom Query mapping to createlist of standards with translations..
	*
	* @return the flag std ID of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public java.lang.String getFlagStdId() {
		return _publishStandardsExt.getFlagStdId();
	}

	/**
	* Sets the flag std ID of this Custom Query mapping to createlist of standards with translations..
	*
	* @param flagStdId the flag std ID of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public void setFlagStdId(java.lang.String flagStdId) {
		_publishStandardsExt.setFlagStdId(flagStdId);
	}

	/**
	* Returns the prev flag std ID of this Custom Query mapping to createlist of standards with translations..
	*
	* @return the prev flag std ID of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public java.lang.String getPrevFlagStdId() {
		return _publishStandardsExt.getPrevFlagStdId();
	}

	/**
	* Sets the prev flag std ID of this Custom Query mapping to createlist of standards with translations..
	*
	* @param prevFlagStdId the prev flag std ID of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public void setPrevFlagStdId(java.lang.String prevFlagStdId) {
		_publishStandardsExt.setPrevFlagStdId(prevFlagStdId);
	}

	/**
	* Returns the title change of this Custom Query mapping to createlist of standards with translations..
	*
	* @return the title change of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public java.lang.String getTitleChange() {
		return _publishStandardsExt.getTitleChange();
	}

	/**
	* Sets the title change of this Custom Query mapping to createlist of standards with translations..
	*
	* @param titleChange the title change of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public void setTitleChange(java.lang.String titleChange) {
		_publishStandardsExt.setTitleChange(titleChange);
	}

	/**
	* Returns the cmply change of this Custom Query mapping to createlist of standards with translations..
	*
	* @return the cmply change of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public java.lang.String getCmplyChange() {
		return _publishStandardsExt.getCmplyChange();
	}

	/**
	* Sets the cmply change of this Custom Query mapping to createlist of standards with translations..
	*
	* @param cmplyChange the cmply change of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public void setCmplyChange(java.lang.String cmplyChange) {
		_publishStandardsExt.setCmplyChange(cmplyChange);
	}

	/**
	* Returns the expr change of this Custom Query mapping to createlist of standards with translations..
	*
	* @return the expr change of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public java.lang.String getExprChange() {
		return _publishStandardsExt.getExprChange();
	}

	/**
	* Sets the expr change of this Custom Query mapping to createlist of standards with translations..
	*
	* @param exprChange the expr change of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public void setExprChange(java.lang.String exprChange) {
		_publishStandardsExt.setExprChange(exprChange);
	}

	/**
	* Returns the hlc change of this Custom Query mapping to createlist of standards with translations..
	*
	* @return the hlc change of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public java.lang.String getHlcChange() {
		return _publishStandardsExt.getHlcChange();
	}

	/**
	* Sets the hlc change of this Custom Query mapping to createlist of standards with translations..
	*
	* @param hlcChange the hlc change of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public void setHlcChange(java.lang.String hlcChange) {
		_publishStandardsExt.setHlcChange(hlcChange);
	}

	/**
	* Returns the changed status of this Custom Query mapping to createlist of standards with translations..
	*
	* @return the changed status of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public java.lang.String getChangedStatus() {
		return _publishStandardsExt.getChangedStatus();
	}

	/**
	* Sets the changed status of this Custom Query mapping to createlist of standards with translations..
	*
	* @param changedStatus the changed status of this Custom Query mapping to createlist of standards with translations.
	*/
	@Override
	public void setChangedStatus(java.lang.String changedStatus) {
		_publishStandardsExt.setChangedStatus(changedStatus);
	}

	@Override
	public boolean isNew() {
		return _publishStandardsExt.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_publishStandardsExt.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _publishStandardsExt.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_publishStandardsExt.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _publishStandardsExt.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _publishStandardsExt.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_publishStandardsExt.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _publishStandardsExt.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_publishStandardsExt.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_publishStandardsExt.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_publishStandardsExt.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PublishStandardsExtWrapper((PublishStandardsExt)_publishStandardsExt.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.PublishStandardsExt publishStandardsExt) {
		return _publishStandardsExt.compareTo(publishStandardsExt);
	}

	@Override
	public int hashCode() {
		return _publishStandardsExt.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.PublishStandardsExt> toCacheModel() {
		return _publishStandardsExt.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.PublishStandardsExt toEscapedModel() {
		return new PublishStandardsExtWrapper(_publishStandardsExt.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.PublishStandardsExt toUnescapedModel() {
		return new PublishStandardsExtWrapper(_publishStandardsExt.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _publishStandardsExt.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _publishStandardsExt.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_publishStandardsExt.persist();
	}

	@Override
	public java.lang.String getStdTitleXlat() {
		return _publishStandardsExt.getStdTitleXlat();
	}

	@Override
	public void setStdTitleXlat(java.lang.String stdTitleXlat) {
		_publishStandardsExt.setStdTitleXlat(stdTitleXlat);
	}

	@Override
	public java.lang.String getStdDescXlat() {
		return _publishStandardsExt.getStdDescXlat();
	}

	@Override
	public void setStdDescXlat(java.lang.String stdDescXlat) {
		_publishStandardsExt.setStdDescXlat(stdDescXlat);
	}

	@Override
	public java.lang.String getIndexTitleXlat() {
		return _publishStandardsExt.getIndexTitleXlat();
	}

	@Override
	public void setIndexTitleXlat(java.lang.String indexTitleXlat) {
		_publishStandardsExt.setIndexTitleXlat(indexTitleXlat);
	}

	@Override
	public java.lang.String getIndexDescXlat() {
		return _publishStandardsExt.getIndexDescXlat();
	}

	@Override
	public void setIndexDescXlat(java.lang.String indexDescXlat) {
		_publishStandardsExt.setIndexDescXlat(indexDescXlat);
	}

	@Override
	public java.lang.String getImageList() {
		return _publishStandardsExt.getImageList();
	}

	@Override
	public void setImageList(java.lang.String imageList) {
		_publishStandardsExt.setImageList(imageList);
	}

	@Override
	public java.lang.String getImageListXlat() {
		return _publishStandardsExt.getImageListXlat();
	}

	@Override
	public void setImageListXlat(java.lang.String imageListXlat) {
		_publishStandardsExt.setImageListXlat(imageListXlat);
	}

	@Override
	public java.lang.String getLinkListXlat() {
		return _publishStandardsExt.getLinkListXlat();
	}

	@Override
	public void setLinkListXlat(java.lang.String linkListXlat) {
		_publishStandardsExt.setLinkListXlat(linkListXlat);
	}

	@Override
	public java.lang.String getAttachmentListXlat() {
		return _publishStandardsExt.getAttachmentListXlat();
	}

	@Override
	public void setAttachmentListXlat(java.lang.String attachmentListXlat) {
		_publishStandardsExt.setAttachmentListXlat(attachmentListXlat);
	}

	@Override
	public java.lang.String getManual() {
		return _publishStandardsExt.getManual();
	}

	@Override
	public void setManual(java.lang.String manual) {
		_publishStandardsExt.setManual(manual);
	}

	@Override
	public java.lang.String getCmplDateStr() {
		return _publishStandardsExt.getCmplDateStr();
	}

	@Override
	public void setCmplDateStr(java.lang.String cmplDateStr) {
		_publishStandardsExt.setCmplDateStr(cmplDateStr);
	}

	@Override
	public java.lang.String getExpiryDateStr() {
		return _publishStandardsExt.getExpiryDateStr();
	}

	@Override
	public void setExpiryDateStr(java.lang.String expiryDateStr) {
		_publishStandardsExt.setExpiryDateStr(expiryDateStr);
	}

	@Override
	public java.lang.String getPrevCmplDateStr() {
		return _publishStandardsExt.getPrevCmplDateStr();
	}

	@Override
	public void setPrevCmplDateStr(java.lang.String prevCmplDateStr) {
		_publishStandardsExt.setPrevCmplDateStr(prevCmplDateStr);
	}

	@Override
	public java.lang.String getPrevExpiryDateStr() {
		return _publishStandardsExt.getPrevExpiryDateStr();
	}

	@Override
	public void setPrevExpiryDateStr(java.lang.String prevExpiryDateStr) {
		_publishStandardsExt.setPrevExpiryDateStr(prevExpiryDateStr);
	}

	@Override
	public boolean isSearchMatches() {
		return _publishStandardsExt.isSearchMatches();
	}

	@Override
	public void setSearchMatches(boolean searchMatches) {
		_publishStandardsExt.setSearchMatches(searchMatches);
	}

	@Override
	public boolean isRemovable() {
		return _publishStandardsExt.isRemovable();
	}

	@Override
	public void setRemovable(boolean isRemovable) {
		_publishStandardsExt.setRemovable(isRemovable);
	}

	@Override
	public java.lang.String getErrorType() {
		return _publishStandardsExt.getErrorType();
	}

	@Override
	public void setErrorType(java.lang.String errorType) {
		_publishStandardsExt.setErrorType(errorType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PublishStandardsExtWrapper)) {
			return false;
		}

		PublishStandardsExtWrapper publishStandardsExtWrapper = (PublishStandardsExtWrapper)obj;

		if (Validator.equals(_publishStandardsExt,
					publishStandardsExtWrapper._publishStandardsExt)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public PublishStandardsExt getWrappedPublishStandardsExt() {
		return _publishStandardsExt;
	}

	@Override
	public PublishStandardsExt getWrappedModel() {
		return _publishStandardsExt;
	}

	@Override
	public void resetOriginalValues() {
		_publishStandardsExt.resetOriginalValues();
	}

	private PublishStandardsExt _publishStandardsExt;
}