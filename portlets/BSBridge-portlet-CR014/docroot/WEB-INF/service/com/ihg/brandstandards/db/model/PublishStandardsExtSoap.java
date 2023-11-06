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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Mummanedi
 * @generated
 */
public class PublishStandardsExtSoap implements Serializable {
	public static PublishStandardsExtSoap toSoapModel(PublishStandardsExt model) {
		PublishStandardsExtSoap soapModel = new PublishStandardsExtSoap();

		soapModel.setPublishStdId(model.getPublishStdId());
		soapModel.setPublishId(model.getPublishId());
		soapModel.setStdId(model.getStdId());
		soapModel.setParentPublishId(model.getParentPublishId());
		soapModel.setStdTyp(model.getStdTyp());
		soapModel.setTitle(model.getTitle());
		soapModel.setPrevPublishTitle(model.getPrevPublishTitle());
		soapModel.setDescription(model.getDescription());
		soapModel.setPrevDescription(model.getPrevDescription());
		soapModel.setAuthor(model.getAuthor());
		soapModel.setBusinessOwner(model.getBusinessOwner());
		soapModel.setEffectiveDate(model.getEffectiveDate());
		soapModel.setImplDate(model.getImplDate());
		soapModel.setPrevCmplyDate(model.getPrevCmplyDate());
		soapModel.setWaiver(model.getWaiver());
		soapModel.setStatus(model.getStatus());
		soapModel.setCategory(model.getCategory());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setChange(model.getChange());
		soapModel.setIsGlobal(model.getIsGlobal());
		soapModel.setRegionCode(model.getRegionCode());
		soapModel.setNotes(model.getNotes());
		soapModel.setFramework(model.getFramework());
		soapModel.setInternalReference(model.getInternalReference());
		soapModel.setRegion(model.getRegion());
		soapModel.setStatusIdentifier(model.getStatusIdentifier());
		soapModel.setSortOrder(model.getSortOrder());
		soapModel.setLocaleCode(model.getLocaleCode());
		soapModel.setTaxonomyId(model.getTaxonomyId());
		soapModel.setPrntTaxonomyId(model.getPrntTaxonomyId());
		soapModel.setAttachmentExists(model.getAttachmentExists());
		soapModel.setAttachmentList(model.getAttachmentList());
		soapModel.setLinkExists(model.getLinkExists());
		soapModel.setLinkList(model.getLinkList());
		soapModel.setImageExists(model.getImageExists());
		soapModel.setStdXrefListStdId(model.getStdXrefListStdId());
		soapModel.setAttachmentStatus(model.getAttachmentStatus());
		soapModel.setLinkStatus(model.getLinkStatus());
		soapModel.setImageStatus(model.getImageStatus());
		soapModel.setImageIdList(model.getImageIdList());
		soapModel.setIndexOrder(model.getIndexOrder());
		soapModel.setPublishTaxonomyId(model.getPublishTaxonomyId());
		soapModel.setParentTaxonomyId(model.getParentTaxonomyId());
		soapModel.setIndexTitle(model.getIndexTitle());
		soapModel.setIndexLvl(model.getIndexLvl());
		soapModel.setTaxonomyPath(model.getTaxonomyPath());
		soapModel.setLevelSortOrder(model.getLevelSortOrder());
		soapModel.setIndexDescription(model.getIndexDescription());
		soapModel.setMatchedId(model.getMatchedId());
		soapModel.setExpiryDate(model.getExpiryDate());
		soapModel.setPrevExpiryDate(model.getPrevExpiryDate());
		soapModel.setExpiredStdId(model.getExpiredStdId());
		soapModel.setFlagStdId(model.getFlagStdId());
		soapModel.setPrevFlagStdId(model.getPrevFlagStdId());
		soapModel.setTitleChange(model.getTitleChange());
		soapModel.setCmplyChange(model.getCmplyChange());
		soapModel.setExprChange(model.getExprChange());
		soapModel.setHlcChange(model.getHlcChange());
		soapModel.setChangedStatus(model.getChangedStatus());

		return soapModel;
	}

	public static PublishStandardsExtSoap[] toSoapModels(
		PublishStandardsExt[] models) {
		PublishStandardsExtSoap[] soapModels = new PublishStandardsExtSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PublishStandardsExtSoap[][] toSoapModels(
		PublishStandardsExt[][] models) {
		PublishStandardsExtSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PublishStandardsExtSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PublishStandardsExtSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PublishStandardsExtSoap[] toSoapModels(
		List<PublishStandardsExt> models) {
		List<PublishStandardsExtSoap> soapModels = new ArrayList<PublishStandardsExtSoap>(models.size());

		for (PublishStandardsExt model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PublishStandardsExtSoap[soapModels.size()]);
	}

	public PublishStandardsExtSoap() {
	}

	public long getPrimaryKey() {
		return _publishStdId;
	}

	public void setPrimaryKey(long pk) {
		setPublishStdId(pk);
	}

	public long getPublishStdId() {
		return _publishStdId;
	}

	public void setPublishStdId(long publishStdId) {
		_publishStdId = publishStdId;
	}

	public long getPublishId() {
		return _publishId;
	}

	public void setPublishId(long publishId) {
		_publishId = publishId;
	}

	public long getStdId() {
		return _stdId;
	}

	public void setStdId(long stdId) {
		_stdId = stdId;
	}

	public long getParentPublishId() {
		return _parentPublishId;
	}

	public void setParentPublishId(long parentPublishId) {
		_parentPublishId = parentPublishId;
	}

	public String getStdTyp() {
		return _stdTyp;
	}

	public void setStdTyp(String stdTyp) {
		_stdTyp = stdTyp;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getPrevPublishTitle() {
		return _prevPublishTitle;
	}

	public void setPrevPublishTitle(String prevPublishTitle) {
		_prevPublishTitle = prevPublishTitle;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getPrevDescription() {
		return _prevDescription;
	}

	public void setPrevDescription(String prevDescription) {
		_prevDescription = prevDescription;
	}

	public String getAuthor() {
		return _author;
	}

	public void setAuthor(String author) {
		_author = author;
	}

	public String getBusinessOwner() {
		return _businessOwner;
	}

	public void setBusinessOwner(String businessOwner) {
		_businessOwner = businessOwner;
	}

	public Date getEffectiveDate() {
		return _effectiveDate;
	}

	public void setEffectiveDate(Date effectiveDate) {
		_effectiveDate = effectiveDate;
	}

	public Date getImplDate() {
		return _implDate;
	}

	public void setImplDate(Date implDate) {
		_implDate = implDate;
	}

	public Date getPrevCmplyDate() {
		return _prevCmplyDate;
	}

	public void setPrevCmplyDate(Date prevCmplyDate) {
		_prevCmplyDate = prevCmplyDate;
	}

	public String getWaiver() {
		return _waiver;
	}

	public void setWaiver(String waiver) {
		_waiver = waiver;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	public String getCategory() {
		return _category;
	}

	public void setCategory(String category) {
		_category = category;
	}

	public String getCreatedBy() {
		return _createdBy;
	}

	public void setCreatedBy(String createdBy) {
		_createdBy = createdBy;
	}

	public String getChange() {
		return _change;
	}

	public void setChange(String change) {
		_change = change;
	}

	public String getIsGlobal() {
		return _isGlobal;
	}

	public void setIsGlobal(String isGlobal) {
		_isGlobal = isGlobal;
	}

	public String getRegionCode() {
		return _regionCode;
	}

	public void setRegionCode(String regionCode) {
		_regionCode = regionCode;
	}

	public String getNotes() {
		return _notes;
	}

	public void setNotes(String notes) {
		_notes = notes;
	}

	public String getFramework() {
		return _framework;
	}

	public void setFramework(String framework) {
		_framework = framework;
	}

	public String getInternalReference() {
		return _internalReference;
	}

	public void setInternalReference(String internalReference) {
		_internalReference = internalReference;
	}

	public String getRegion() {
		return _region;
	}

	public void setRegion(String region) {
		_region = region;
	}

	public String getStatusIdentifier() {
		return _statusIdentifier;
	}

	public void setStatusIdentifier(String statusIdentifier) {
		_statusIdentifier = statusIdentifier;
	}

	public long getSortOrder() {
		return _sortOrder;
	}

	public void setSortOrder(long sortOrder) {
		_sortOrder = sortOrder;
	}

	public String getLocaleCode() {
		return _localeCode;
	}

	public void setLocaleCode(String localeCode) {
		_localeCode = localeCode;
	}

	public long getTaxonomyId() {
		return _taxonomyId;
	}

	public void setTaxonomyId(long taxonomyId) {
		_taxonomyId = taxonomyId;
	}

	public long getPrntTaxonomyId() {
		return _prntTaxonomyId;
	}

	public void setPrntTaxonomyId(long prntTaxonomyId) {
		_prntTaxonomyId = prntTaxonomyId;
	}

	public String getAttachmentExists() {
		return _attachmentExists;
	}

	public void setAttachmentExists(String attachmentExists) {
		_attachmentExists = attachmentExists;
	}

	public String getAttachmentList() {
		return _attachmentList;
	}

	public void setAttachmentList(String attachmentList) {
		_attachmentList = attachmentList;
	}

	public String getLinkExists() {
		return _linkExists;
	}

	public void setLinkExists(String linkExists) {
		_linkExists = linkExists;
	}

	public String getLinkList() {
		return _linkList;
	}

	public void setLinkList(String linkList) {
		_linkList = linkList;
	}

	public String getImageExists() {
		return _imageExists;
	}

	public void setImageExists(String imageExists) {
		_imageExists = imageExists;
	}

	public String getStdXrefListStdId() {
		return _stdXrefListStdId;
	}

	public void setStdXrefListStdId(String stdXrefListStdId) {
		_stdXrefListStdId = stdXrefListStdId;
	}

	public String getAttachmentStatus() {
		return _attachmentStatus;
	}

	public void setAttachmentStatus(String attachmentStatus) {
		_attachmentStatus = attachmentStatus;
	}

	public String getLinkStatus() {
		return _linkStatus;
	}

	public void setLinkStatus(String linkStatus) {
		_linkStatus = linkStatus;
	}

	public String getImageStatus() {
		return _imageStatus;
	}

	public void setImageStatus(String imageStatus) {
		_imageStatus = imageStatus;
	}

	public String getImageIdList() {
		return _imageIdList;
	}

	public void setImageIdList(String imageIdList) {
		_imageIdList = imageIdList;
	}

	public long getIndexOrder() {
		return _indexOrder;
	}

	public void setIndexOrder(long indexOrder) {
		_indexOrder = indexOrder;
	}

	public long getPublishTaxonomyId() {
		return _publishTaxonomyId;
	}

	public void setPublishTaxonomyId(long publishTaxonomyId) {
		_publishTaxonomyId = publishTaxonomyId;
	}

	public long getParentTaxonomyId() {
		return _parentTaxonomyId;
	}

	public void setParentTaxonomyId(long parentTaxonomyId) {
		_parentTaxonomyId = parentTaxonomyId;
	}

	public String getIndexTitle() {
		return _indexTitle;
	}

	public void setIndexTitle(String indexTitle) {
		_indexTitle = indexTitle;
	}

	public long getIndexLvl() {
		return _indexLvl;
	}

	public void setIndexLvl(long indexLvl) {
		_indexLvl = indexLvl;
	}

	public String getTaxonomyPath() {
		return _taxonomyPath;
	}

	public void setTaxonomyPath(String taxonomyPath) {
		_taxonomyPath = taxonomyPath;
	}

	public long getLevelSortOrder() {
		return _levelSortOrder;
	}

	public void setLevelSortOrder(long levelSortOrder) {
		_levelSortOrder = levelSortOrder;
	}

	public String getIndexDescription() {
		return _indexDescription;
	}

	public void setIndexDescription(String indexDescription) {
		_indexDescription = indexDescription;
	}

	public String getMatchedId() {
		return _matchedId;
	}

	public void setMatchedId(String matchedId) {
		_matchedId = matchedId;
	}

	public Date getExpiryDate() {
		return _expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		_expiryDate = expiryDate;
	}

	public Date getPrevExpiryDate() {
		return _prevExpiryDate;
	}

	public void setPrevExpiryDate(Date prevExpiryDate) {
		_prevExpiryDate = prevExpiryDate;
	}

	public String getExpiredStdId() {
		return _expiredStdId;
	}

	public void setExpiredStdId(String expiredStdId) {
		_expiredStdId = expiredStdId;
	}

	public String getFlagStdId() {
		return _flagStdId;
	}

	public void setFlagStdId(String flagStdId) {
		_flagStdId = flagStdId;
	}

	public String getPrevFlagStdId() {
		return _prevFlagStdId;
	}

	public void setPrevFlagStdId(String prevFlagStdId) {
		_prevFlagStdId = prevFlagStdId;
	}

	public String getTitleChange() {
		return _titleChange;
	}

	public void setTitleChange(String titleChange) {
		_titleChange = titleChange;
	}

	public String getCmplyChange() {
		return _cmplyChange;
	}

	public void setCmplyChange(String cmplyChange) {
		_cmplyChange = cmplyChange;
	}

	public String getExprChange() {
		return _exprChange;
	}

	public void setExprChange(String exprChange) {
		_exprChange = exprChange;
	}

	public String getHlcChange() {
		return _hlcChange;
	}

	public void setHlcChange(String hlcChange) {
		_hlcChange = hlcChange;
	}

	public String getChangedStatus() {
		return _changedStatus;
	}

	public void setChangedStatus(String changedStatus) {
		_changedStatus = changedStatus;
	}

	private long _publishStdId;
	private long _publishId;
	private long _stdId;
	private long _parentPublishId;
	private String _stdTyp;
	private String _title;
	private String _prevPublishTitle;
	private String _description;
	private String _prevDescription;
	private String _author;
	private String _businessOwner;
	private Date _effectiveDate;
	private Date _implDate;
	private Date _prevCmplyDate;
	private String _waiver;
	private String _status;
	private String _category;
	private String _createdBy;
	private String _change;
	private String _isGlobal;
	private String _regionCode;
	private String _notes;
	private String _framework;
	private String _internalReference;
	private String _region;
	private String _statusIdentifier;
	private long _sortOrder;
	private String _localeCode;
	private long _taxonomyId;
	private long _prntTaxonomyId;
	private String _attachmentExists;
	private String _attachmentList;
	private String _linkExists;
	private String _linkList;
	private String _imageExists;
	private String _stdXrefListStdId;
	private String _attachmentStatus;
	private String _linkStatus;
	private String _imageStatus;
	private String _imageIdList;
	private long _indexOrder;
	private long _publishTaxonomyId;
	private long _parentTaxonomyId;
	private String _indexTitle;
	private long _indexLvl;
	private String _taxonomyPath;
	private long _levelSortOrder;
	private String _indexDescription;
	private String _matchedId;
	private Date _expiryDate;
	private Date _prevExpiryDate;
	private String _expiredStdId;
	private String _flagStdId;
	private String _prevFlagStdId;
	private String _titleChange;
	private String _cmplyChange;
	private String _exprChange;
	private String _hlcChange;
	private String _changedStatus;
}