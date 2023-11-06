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

import com.ihg.brandstandards.db.service.ClpSerializer;
import com.ihg.brandstandards.db.service.PublishStandardsExtLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mummanedi
 */
public class PublishStandardsExtClp extends BaseModelImpl<PublishStandardsExt>
	implements PublishStandardsExt {
	public PublishStandardsExtClp() {
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
	public long getPrimaryKey() {
		return _publishStdId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPublishStdId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _publishStdId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getPublishStdId() {
		return _publishStdId;
	}

	@Override
	public void setPublishStdId(long publishStdId) {
		_publishStdId = publishStdId;

		if (_publishStandardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _publishStandardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setPublishStdId", long.class);

				method.invoke(_publishStandardsExtRemoteModel, publishStdId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPublishId() {
		return _publishId;
	}

	@Override
	public void setPublishId(long publishId) {
		_publishId = publishId;

		if (_publishStandardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _publishStandardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setPublishId", long.class);

				method.invoke(_publishStandardsExtRemoteModel, publishId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getStdId() {
		return _stdId;
	}

	@Override
	public void setStdId(long stdId) {
		_stdId = stdId;

		if (_publishStandardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _publishStandardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setStdId", long.class);

				method.invoke(_publishStandardsExtRemoteModel, stdId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getParentPublishId() {
		return _parentPublishId;
	}

	@Override
	public void setParentPublishId(long parentPublishId) {
		_parentPublishId = parentPublishId;

		if (_publishStandardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _publishStandardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setParentPublishId", long.class);

				method.invoke(_publishStandardsExtRemoteModel, parentPublishId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStdTyp() {
		return _stdTyp;
	}

	@Override
	public void setStdTyp(String stdTyp) {
		_stdTyp = stdTyp;

		if (_publishStandardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _publishStandardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setStdTyp", String.class);

				method.invoke(_publishStandardsExtRemoteModel, stdTyp);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTitle() {
		return _title;
	}

	@Override
	public void setTitle(String title) {
		_title = title;

		if (_publishStandardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _publishStandardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_publishStandardsExtRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPrevPublishTitle() {
		return _prevPublishTitle;
	}

	@Override
	public void setPrevPublishTitle(String prevPublishTitle) {
		_prevPublishTitle = prevPublishTitle;

		if (_publishStandardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _publishStandardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setPrevPublishTitle",
						String.class);

				method.invoke(_publishStandardsExtRemoteModel, prevPublishTitle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescription() {
		return _description;
	}

	@Override
	public void setDescription(String description) {
		_description = description;

		if (_publishStandardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _publishStandardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_publishStandardsExtRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPrevDescription() {
		return _prevDescription;
	}

	@Override
	public void setPrevDescription(String prevDescription) {
		_prevDescription = prevDescription;

		if (_publishStandardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _publishStandardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setPrevDescription",
						String.class);

				method.invoke(_publishStandardsExtRemoteModel, prevDescription);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAuthor() {
		return _author;
	}

	@Override
	public void setAuthor(String author) {
		_author = author;

		if (_publishStandardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _publishStandardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setAuthor", String.class);

				method.invoke(_publishStandardsExtRemoteModel, author);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBusinessOwner() {
		return _businessOwner;
	}

	@Override
	public void setBusinessOwner(String businessOwner) {
		_businessOwner = businessOwner;

		if (_publishStandardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _publishStandardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setBusinessOwner", String.class);

				method.invoke(_publishStandardsExtRemoteModel, businessOwner);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getEffectiveDate() {
		return _effectiveDate;
	}

	@Override
	public void setEffectiveDate(Date effectiveDate) {
		_effectiveDate = effectiveDate;

		if (_publishStandardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _publishStandardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setEffectiveDate", Date.class);

				method.invoke(_publishStandardsExtRemoteModel, effectiveDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getImplDate() {
		return _implDate;
	}

	@Override
	public void setImplDate(Date implDate) {
		_implDate = implDate;

		if (_publishStandardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _publishStandardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setImplDate", Date.class);

				method.invoke(_publishStandardsExtRemoteModel, implDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getPrevCmplyDate() {
		return _prevCmplyDate;
	}

	@Override
	public void setPrevCmplyDate(Date prevCmplyDate) {
		_prevCmplyDate = prevCmplyDate;

		if (_publishStandardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _publishStandardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setPrevCmplyDate", Date.class);

				method.invoke(_publishStandardsExtRemoteModel, prevCmplyDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getWaiver() {
		return _waiver;
	}

	@Override
	public void setWaiver(String waiver) {
		_waiver = waiver;

		if (_publishStandardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _publishStandardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setWaiver", String.class);

				method.invoke(_publishStandardsExtRemoteModel, waiver);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStatus() {
		return _status;
	}

	@Override
	public void setStatus(String status) {
		_status = status;

		if (_publishStandardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _publishStandardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", String.class);

				method.invoke(_publishStandardsExtRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCategory() {
		return _category;
	}

	@Override
	public void setCategory(String category) {
		_category = category;

		if (_publishStandardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _publishStandardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setCategory", String.class);

				method.invoke(_publishStandardsExtRemoteModel, category);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCreatedBy() {
		return _createdBy;
	}

	@Override
	public void setCreatedBy(String createdBy) {
		_createdBy = createdBy;

		if (_publishStandardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _publishStandardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedBy", String.class);

				method.invoke(_publishStandardsExtRemoteModel, createdBy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getChange() {
		return _change;
	}

	@Override
	public void setChange(String change) {
		_change = change;

		if (_publishStandardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _publishStandardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setChange", String.class);

				method.invoke(_publishStandardsExtRemoteModel, change);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIsGlobal() {
		return _isGlobal;
	}

	@Override
	public void setIsGlobal(String isGlobal) {
		_isGlobal = isGlobal;

		if (_publishStandardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _publishStandardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setIsGlobal", String.class);

				method.invoke(_publishStandardsExtRemoteModel, isGlobal);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRegionCode() {
		return _regionCode;
	}

	@Override
	public void setRegionCode(String regionCode) {
		_regionCode = regionCode;

		if (_publishStandardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _publishStandardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setRegionCode", String.class);

				method.invoke(_publishStandardsExtRemoteModel, regionCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNotes() {
		return _notes;
	}

	@Override
	public void setNotes(String notes) {
		_notes = notes;

		if (_publishStandardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _publishStandardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setNotes", String.class);

				method.invoke(_publishStandardsExtRemoteModel, notes);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFramework() {
		return _framework;
	}

	@Override
	public void setFramework(String framework) {
		_framework = framework;

		if (_publishStandardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _publishStandardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setFramework", String.class);

				method.invoke(_publishStandardsExtRemoteModel, framework);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getInternalReference() {
		return _internalReference;
	}

	@Override
	public void setInternalReference(String internalReference) {
		_internalReference = internalReference;

		if (_publishStandardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _publishStandardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setInternalReference",
						String.class);

				method.invoke(_publishStandardsExtRemoteModel, internalReference);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRegion() {
		return _region;
	}

	@Override
	public void setRegion(String region) {
		_region = region;

		if (_publishStandardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _publishStandardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setRegion", String.class);

				method.invoke(_publishStandardsExtRemoteModel, region);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStatusIdentifier() {
		return _statusIdentifier;
	}

	@Override
	public void setStatusIdentifier(String statusIdentifier) {
		_statusIdentifier = statusIdentifier;

		if (_publishStandardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _publishStandardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusIdentifier",
						String.class);

				method.invoke(_publishStandardsExtRemoteModel, statusIdentifier);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSortOrder() {
		return _sortOrder;
	}

	@Override
	public void setSortOrder(long sortOrder) {
		_sortOrder = sortOrder;

		if (_publishStandardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _publishStandardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setSortOrder", long.class);

				method.invoke(_publishStandardsExtRemoteModel, sortOrder);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLocaleCode() {
		return _localeCode;
	}

	@Override
	public void setLocaleCode(String localeCode) {
		_localeCode = localeCode;

		if (_publishStandardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _publishStandardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setLocaleCode", String.class);

				method.invoke(_publishStandardsExtRemoteModel, localeCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getTaxonomyId() {
		return _taxonomyId;
	}

	@Override
	public void setTaxonomyId(long taxonomyId) {
		_taxonomyId = taxonomyId;

		if (_publishStandardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _publishStandardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setTaxonomyId", long.class);

				method.invoke(_publishStandardsExtRemoteModel, taxonomyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPrntTaxonomyId() {
		return _prntTaxonomyId;
	}

	@Override
	public void setPrntTaxonomyId(long prntTaxonomyId) {
		_prntTaxonomyId = prntTaxonomyId;

		if (_publishStandardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _publishStandardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setPrntTaxonomyId", long.class);

				method.invoke(_publishStandardsExtRemoteModel, prntTaxonomyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAttachmentExists() {
		return _attachmentExists;
	}

	@Override
	public void setAttachmentExists(String attachmentExists) {
		_attachmentExists = attachmentExists;

		if (_publishStandardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _publishStandardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setAttachmentExists",
						String.class);

				method.invoke(_publishStandardsExtRemoteModel, attachmentExists);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAttachmentList() {
		return _attachmentList;
	}

	@Override
	public void setAttachmentList(String attachmentList) {
		_attachmentList = attachmentList;

		if (_publishStandardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _publishStandardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setAttachmentList",
						String.class);

				method.invoke(_publishStandardsExtRemoteModel, attachmentList);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLinkExists() {
		return _linkExists;
	}

	@Override
	public void setLinkExists(String linkExists) {
		_linkExists = linkExists;

		if (_publishStandardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _publishStandardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setLinkExists", String.class);

				method.invoke(_publishStandardsExtRemoteModel, linkExists);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLinkList() {
		return _linkList;
	}

	@Override
	public void setLinkList(String linkList) {
		_linkList = linkList;

		if (_publishStandardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _publishStandardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setLinkList", String.class);

				method.invoke(_publishStandardsExtRemoteModel, linkList);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getImageExists() {
		return _imageExists;
	}

	@Override
	public void setImageExists(String imageExists) {
		_imageExists = imageExists;

		if (_publishStandardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _publishStandardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setImageExists", String.class);

				method.invoke(_publishStandardsExtRemoteModel, imageExists);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStdXrefListStdId() {
		return _stdXrefListStdId;
	}

	@Override
	public void setStdXrefListStdId(String stdXrefListStdId) {
		_stdXrefListStdId = stdXrefListStdId;

		if (_publishStandardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _publishStandardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setStdXrefListStdId",
						String.class);

				method.invoke(_publishStandardsExtRemoteModel, stdXrefListStdId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAttachmentStatus() {
		return _attachmentStatus;
	}

	@Override
	public void setAttachmentStatus(String attachmentStatus) {
		_attachmentStatus = attachmentStatus;

		if (_publishStandardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _publishStandardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setAttachmentStatus",
						String.class);

				method.invoke(_publishStandardsExtRemoteModel, attachmentStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLinkStatus() {
		return _linkStatus;
	}

	@Override
	public void setLinkStatus(String linkStatus) {
		_linkStatus = linkStatus;

		if (_publishStandardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _publishStandardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setLinkStatus", String.class);

				method.invoke(_publishStandardsExtRemoteModel, linkStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getImageStatus() {
		return _imageStatus;
	}

	@Override
	public void setImageStatus(String imageStatus) {
		_imageStatus = imageStatus;

		if (_publishStandardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _publishStandardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setImageStatus", String.class);

				method.invoke(_publishStandardsExtRemoteModel, imageStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getImageIdList() {
		return _imageIdList;
	}

	@Override
	public void setImageIdList(String imageIdList) {
		_imageIdList = imageIdList;

		if (_publishStandardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _publishStandardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setImageIdList", String.class);

				method.invoke(_publishStandardsExtRemoteModel, imageIdList);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getIndexOrder() {
		return _indexOrder;
	}

	@Override
	public void setIndexOrder(long indexOrder) {
		_indexOrder = indexOrder;

		if (_publishStandardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _publishStandardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setIndexOrder", long.class);

				method.invoke(_publishStandardsExtRemoteModel, indexOrder);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPublishTaxonomyId() {
		return _publishTaxonomyId;
	}

	@Override
	public void setPublishTaxonomyId(long publishTaxonomyId) {
		_publishTaxonomyId = publishTaxonomyId;

		if (_publishStandardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _publishStandardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setPublishTaxonomyId",
						long.class);

				method.invoke(_publishStandardsExtRemoteModel, publishTaxonomyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getParentTaxonomyId() {
		return _parentTaxonomyId;
	}

	@Override
	public void setParentTaxonomyId(long parentTaxonomyId) {
		_parentTaxonomyId = parentTaxonomyId;

		if (_publishStandardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _publishStandardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setParentTaxonomyId",
						long.class);

				method.invoke(_publishStandardsExtRemoteModel, parentTaxonomyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIndexTitle() {
		return _indexTitle;
	}

	@Override
	public void setIndexTitle(String indexTitle) {
		_indexTitle = indexTitle;

		if (_publishStandardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _publishStandardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setIndexTitle", String.class);

				method.invoke(_publishStandardsExtRemoteModel, indexTitle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getIndexLvl() {
		return _indexLvl;
	}

	@Override
	public void setIndexLvl(long indexLvl) {
		_indexLvl = indexLvl;

		if (_publishStandardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _publishStandardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setIndexLvl", long.class);

				method.invoke(_publishStandardsExtRemoteModel, indexLvl);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTaxonomyPath() {
		return _taxonomyPath;
	}

	@Override
	public void setTaxonomyPath(String taxonomyPath) {
		_taxonomyPath = taxonomyPath;

		if (_publishStandardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _publishStandardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setTaxonomyPath", String.class);

				method.invoke(_publishStandardsExtRemoteModel, taxonomyPath);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLevelSortOrder() {
		return _levelSortOrder;
	}

	@Override
	public void setLevelSortOrder(long levelSortOrder) {
		_levelSortOrder = levelSortOrder;

		if (_publishStandardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _publishStandardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setLevelSortOrder", long.class);

				method.invoke(_publishStandardsExtRemoteModel, levelSortOrder);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIndexDescription() {
		return _indexDescription;
	}

	@Override
	public void setIndexDescription(String indexDescription) {
		_indexDescription = indexDescription;

		if (_publishStandardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _publishStandardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setIndexDescription",
						String.class);

				method.invoke(_publishStandardsExtRemoteModel, indexDescription);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMatchedId() {
		return _matchedId;
	}

	@Override
	public void setMatchedId(String matchedId) {
		_matchedId = matchedId;

		if (_publishStandardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _publishStandardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setMatchedId", String.class);

				method.invoke(_publishStandardsExtRemoteModel, matchedId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getExpiryDate() {
		return _expiryDate;
	}

	@Override
	public void setExpiryDate(Date expiryDate) {
		_expiryDate = expiryDate;

		if (_publishStandardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _publishStandardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setExpiryDate", Date.class);

				method.invoke(_publishStandardsExtRemoteModel, expiryDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getPrevExpiryDate() {
		return _prevExpiryDate;
	}

	@Override
	public void setPrevExpiryDate(Date prevExpiryDate) {
		_prevExpiryDate = prevExpiryDate;

		if (_publishStandardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _publishStandardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setPrevExpiryDate", Date.class);

				method.invoke(_publishStandardsExtRemoteModel, prevExpiryDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getExpiredStdId() {
		return _expiredStdId;
	}

	@Override
	public void setExpiredStdId(String expiredStdId) {
		_expiredStdId = expiredStdId;

		if (_publishStandardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _publishStandardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setExpiredStdId", String.class);

				method.invoke(_publishStandardsExtRemoteModel, expiredStdId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFlagStdId() {
		return _flagStdId;
	}

	@Override
	public void setFlagStdId(String flagStdId) {
		_flagStdId = flagStdId;

		if (_publishStandardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _publishStandardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setFlagStdId", String.class);

				method.invoke(_publishStandardsExtRemoteModel, flagStdId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPrevFlagStdId() {
		return _prevFlagStdId;
	}

	@Override
	public void setPrevFlagStdId(String prevFlagStdId) {
		_prevFlagStdId = prevFlagStdId;

		if (_publishStandardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _publishStandardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setPrevFlagStdId", String.class);

				method.invoke(_publishStandardsExtRemoteModel, prevFlagStdId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTitleChange() {
		return _titleChange;
	}

	@Override
	public void setTitleChange(String titleChange) {
		_titleChange = titleChange;

		if (_publishStandardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _publishStandardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setTitleChange", String.class);

				method.invoke(_publishStandardsExtRemoteModel, titleChange);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCmplyChange() {
		return _cmplyChange;
	}

	@Override
	public void setCmplyChange(String cmplyChange) {
		_cmplyChange = cmplyChange;

		if (_publishStandardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _publishStandardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setCmplyChange", String.class);

				method.invoke(_publishStandardsExtRemoteModel, cmplyChange);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getExprChange() {
		return _exprChange;
	}

	@Override
	public void setExprChange(String exprChange) {
		_exprChange = exprChange;

		if (_publishStandardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _publishStandardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setExprChange", String.class);

				method.invoke(_publishStandardsExtRemoteModel, exprChange);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getHlcChange() {
		return _hlcChange;
	}

	@Override
	public void setHlcChange(String hlcChange) {
		_hlcChange = hlcChange;

		if (_publishStandardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _publishStandardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setHlcChange", String.class);

				method.invoke(_publishStandardsExtRemoteModel, hlcChange);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getChangedStatus() {
		return _changedStatus;
	}

	@Override
	public void setChangedStatus(String changedStatus) {
		_changedStatus = changedStatus;

		if (_publishStandardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _publishStandardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setChangedStatus", String.class);

				method.invoke(_publishStandardsExtRemoteModel, changedStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setStdDescXlat(java.lang.String stdDescXlat) {
		try {
			String methodName = "setStdDescXlat";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { stdDescXlat };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setIndexDescXlat(java.lang.String indexDescXlat) {
		try {
			String methodName = "setIndexDescXlat";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { indexDescXlat };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setAttachmentListXlat(java.lang.String attachmentListXlat) {
		try {
			String methodName = "setAttachmentListXlat";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { attachmentListXlat };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getCmplDateStr() {
		try {
			String methodName = "getCmplDateStr";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getPrevExpiryDateStr() {
		try {
			String methodName = "getPrevExpiryDateStr";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setPrevCmplDateStr(java.lang.String prevCmplDateStr) {
		try {
			String methodName = "setPrevCmplDateStr";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { prevCmplDateStr };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getStdTitleXlat() {
		try {
			String methodName = "getStdTitleXlat";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getImageList() {
		try {
			String methodName = "getImageList";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getLinkListXlat() {
		try {
			String methodName = "getLinkListXlat";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getManual() {
		try {
			String methodName = "getManual";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setImageListXlat(java.lang.String imageListXlat) {
		try {
			String methodName = "setImageListXlat";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { imageListXlat };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getIndexTitleXlat() {
		try {
			String methodName = "getIndexTitleXlat";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getErrorType() {
		try {
			String methodName = "getErrorType";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setExpiryDateStr(java.lang.String expiryDateStr) {
		try {
			String methodName = "setExpiryDateStr";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { expiryDateStr };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public boolean isSearchMatches() {
		try {
			String methodName = "isSearchMatches";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			Boolean returnObj = (Boolean)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setRemovable(boolean isRemovable) {
		try {
			String methodName = "setRemovable";

			Class<?>[] parameterTypes = new Class<?>[] { boolean.class };

			Object[] parameterValues = new Object[] { isRemovable };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getPrevCmplDateStr() {
		try {
			String methodName = "getPrevCmplDateStr";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getExpiryDateStr() {
		try {
			String methodName = "getExpiryDateStr";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setIndexTitleXlat(java.lang.String indexTitleXlat) {
		try {
			String methodName = "setIndexTitleXlat";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { indexTitleXlat };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setCmplDateStr(java.lang.String cmplDateStr) {
		try {
			String methodName = "setCmplDateStr";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { cmplDateStr };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setStdTitleXlat(java.lang.String stdTitleXlat) {
		try {
			String methodName = "setStdTitleXlat";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { stdTitleXlat };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setImageList(java.lang.String imageList) {
		try {
			String methodName = "setImageList";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { imageList };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setManual(java.lang.String manual) {
		try {
			String methodName = "setManual";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { manual };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getStdDescXlat() {
		try {
			String methodName = "getStdDescXlat";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getAttachmentListXlat() {
		try {
			String methodName = "getAttachmentListXlat";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getIndexDescXlat() {
		try {
			String methodName = "getIndexDescXlat";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getImageListXlat() {
		try {
			String methodName = "getImageListXlat";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setSearchMatches(boolean searchMatches) {
		try {
			String methodName = "setSearchMatches";

			Class<?>[] parameterTypes = new Class<?>[] { boolean.class };

			Object[] parameterValues = new Object[] { searchMatches };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setLinkListXlat(java.lang.String linkListXlat) {
		try {
			String methodName = "setLinkListXlat";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { linkListXlat };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public boolean isRemovable() {
		try {
			String methodName = "isRemovable";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			Boolean returnObj = (Boolean)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setErrorType(java.lang.String errorType) {
		try {
			String methodName = "setErrorType";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { errorType };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setPrevExpiryDateStr(java.lang.String prevExpiryDateStr) {
		try {
			String methodName = "setPrevExpiryDateStr";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { prevExpiryDateStr };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public BaseModel<?> getPublishStandardsExtRemoteModel() {
		return _publishStandardsExtRemoteModel;
	}

	public void setPublishStandardsExtRemoteModel(
		BaseModel<?> publishStandardsExtRemoteModel) {
		_publishStandardsExtRemoteModel = publishStandardsExtRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _publishStandardsExtRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_publishStandardsExtRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			PublishStandardsExtLocalServiceUtil.addPublishStandardsExt(this);
		}
		else {
			PublishStandardsExtLocalServiceUtil.updatePublishStandardsExt(this);
		}
	}

	@Override
	public PublishStandardsExt toEscapedModel() {
		return (PublishStandardsExt)ProxyUtil.newProxyInstance(PublishStandardsExt.class.getClassLoader(),
			new Class[] { PublishStandardsExt.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PublishStandardsExtClp clone = new PublishStandardsExtClp();

		clone.setPublishStdId(getPublishStdId());
		clone.setPublishId(getPublishId());
		clone.setStdId(getStdId());
		clone.setParentPublishId(getParentPublishId());
		clone.setStdTyp(getStdTyp());
		clone.setTitle(getTitle());
		clone.setPrevPublishTitle(getPrevPublishTitle());
		clone.setDescription(getDescription());
		clone.setPrevDescription(getPrevDescription());
		clone.setAuthor(getAuthor());
		clone.setBusinessOwner(getBusinessOwner());
		clone.setEffectiveDate(getEffectiveDate());
		clone.setImplDate(getImplDate());
		clone.setPrevCmplyDate(getPrevCmplyDate());
		clone.setWaiver(getWaiver());
		clone.setStatus(getStatus());
		clone.setCategory(getCategory());
		clone.setCreatedBy(getCreatedBy());
		clone.setChange(getChange());
		clone.setIsGlobal(getIsGlobal());
		clone.setRegionCode(getRegionCode());
		clone.setNotes(getNotes());
		clone.setFramework(getFramework());
		clone.setInternalReference(getInternalReference());
		clone.setRegion(getRegion());
		clone.setStatusIdentifier(getStatusIdentifier());
		clone.setSortOrder(getSortOrder());
		clone.setLocaleCode(getLocaleCode());
		clone.setTaxonomyId(getTaxonomyId());
		clone.setPrntTaxonomyId(getPrntTaxonomyId());
		clone.setAttachmentExists(getAttachmentExists());
		clone.setAttachmentList(getAttachmentList());
		clone.setLinkExists(getLinkExists());
		clone.setLinkList(getLinkList());
		clone.setImageExists(getImageExists());
		clone.setStdXrefListStdId(getStdXrefListStdId());
		clone.setAttachmentStatus(getAttachmentStatus());
		clone.setLinkStatus(getLinkStatus());
		clone.setImageStatus(getImageStatus());
		clone.setImageIdList(getImageIdList());
		clone.setIndexOrder(getIndexOrder());
		clone.setPublishTaxonomyId(getPublishTaxonomyId());
		clone.setParentTaxonomyId(getParentTaxonomyId());
		clone.setIndexTitle(getIndexTitle());
		clone.setIndexLvl(getIndexLvl());
		clone.setTaxonomyPath(getTaxonomyPath());
		clone.setLevelSortOrder(getLevelSortOrder());
		clone.setIndexDescription(getIndexDescription());
		clone.setMatchedId(getMatchedId());
		clone.setExpiryDate(getExpiryDate());
		clone.setPrevExpiryDate(getPrevExpiryDate());
		clone.setExpiredStdId(getExpiredStdId());
		clone.setFlagStdId(getFlagStdId());
		clone.setPrevFlagStdId(getPrevFlagStdId());
		clone.setTitleChange(getTitleChange());
		clone.setCmplyChange(getCmplyChange());
		clone.setExprChange(getExprChange());
		clone.setHlcChange(getHlcChange());
		clone.setChangedStatus(getChangedStatus());

		return clone;
	}

	@Override
	public int compareTo(PublishStandardsExt publishStandardsExt) {
		long primaryKey = publishStandardsExt.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PublishStandardsExtClp)) {
			return false;
		}

		PublishStandardsExtClp publishStandardsExt = (PublishStandardsExtClp)obj;

		long primaryKey = publishStandardsExt.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(119);

		sb.append("{publishStdId=");
		sb.append(getPublishStdId());
		sb.append(", publishId=");
		sb.append(getPublishId());
		sb.append(", stdId=");
		sb.append(getStdId());
		sb.append(", parentPublishId=");
		sb.append(getParentPublishId());
		sb.append(", stdTyp=");
		sb.append(getStdTyp());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", prevPublishTitle=");
		sb.append(getPrevPublishTitle());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", prevDescription=");
		sb.append(getPrevDescription());
		sb.append(", author=");
		sb.append(getAuthor());
		sb.append(", businessOwner=");
		sb.append(getBusinessOwner());
		sb.append(", effectiveDate=");
		sb.append(getEffectiveDate());
		sb.append(", implDate=");
		sb.append(getImplDate());
		sb.append(", prevCmplyDate=");
		sb.append(getPrevCmplyDate());
		sb.append(", waiver=");
		sb.append(getWaiver());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", category=");
		sb.append(getCategory());
		sb.append(", createdBy=");
		sb.append(getCreatedBy());
		sb.append(", change=");
		sb.append(getChange());
		sb.append(", isGlobal=");
		sb.append(getIsGlobal());
		sb.append(", regionCode=");
		sb.append(getRegionCode());
		sb.append(", notes=");
		sb.append(getNotes());
		sb.append(", framework=");
		sb.append(getFramework());
		sb.append(", internalReference=");
		sb.append(getInternalReference());
		sb.append(", region=");
		sb.append(getRegion());
		sb.append(", statusIdentifier=");
		sb.append(getStatusIdentifier());
		sb.append(", sortOrder=");
		sb.append(getSortOrder());
		sb.append(", localeCode=");
		sb.append(getLocaleCode());
		sb.append(", taxonomyId=");
		sb.append(getTaxonomyId());
		sb.append(", prntTaxonomyId=");
		sb.append(getPrntTaxonomyId());
		sb.append(", attachmentExists=");
		sb.append(getAttachmentExists());
		sb.append(", attachmentList=");
		sb.append(getAttachmentList());
		sb.append(", linkExists=");
		sb.append(getLinkExists());
		sb.append(", linkList=");
		sb.append(getLinkList());
		sb.append(", imageExists=");
		sb.append(getImageExists());
		sb.append(", stdXrefListStdId=");
		sb.append(getStdXrefListStdId());
		sb.append(", attachmentStatus=");
		sb.append(getAttachmentStatus());
		sb.append(", linkStatus=");
		sb.append(getLinkStatus());
		sb.append(", imageStatus=");
		sb.append(getImageStatus());
		sb.append(", imageIdList=");
		sb.append(getImageIdList());
		sb.append(", indexOrder=");
		sb.append(getIndexOrder());
		sb.append(", publishTaxonomyId=");
		sb.append(getPublishTaxonomyId());
		sb.append(", parentTaxonomyId=");
		sb.append(getParentTaxonomyId());
		sb.append(", indexTitle=");
		sb.append(getIndexTitle());
		sb.append(", indexLvl=");
		sb.append(getIndexLvl());
		sb.append(", taxonomyPath=");
		sb.append(getTaxonomyPath());
		sb.append(", levelSortOrder=");
		sb.append(getLevelSortOrder());
		sb.append(", indexDescription=");
		sb.append(getIndexDescription());
		sb.append(", matchedId=");
		sb.append(getMatchedId());
		sb.append(", expiryDate=");
		sb.append(getExpiryDate());
		sb.append(", prevExpiryDate=");
		sb.append(getPrevExpiryDate());
		sb.append(", expiredStdId=");
		sb.append(getExpiredStdId());
		sb.append(", flagStdId=");
		sb.append(getFlagStdId());
		sb.append(", prevFlagStdId=");
		sb.append(getPrevFlagStdId());
		sb.append(", titleChange=");
		sb.append(getTitleChange());
		sb.append(", cmplyChange=");
		sb.append(getCmplyChange());
		sb.append(", exprChange=");
		sb.append(getExprChange());
		sb.append(", hlcChange=");
		sb.append(getHlcChange());
		sb.append(", changedStatus=");
		sb.append(getChangedStatus());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(181);

		sb.append("<model><model-name>");
		sb.append("com.ihg.brandstandards.db.model.PublishStandardsExt");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>publishStdId</column-name><column-value><![CDATA[");
		sb.append(getPublishStdId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>publishId</column-name><column-value><![CDATA[");
		sb.append(getPublishId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stdId</column-name><column-value><![CDATA[");
		sb.append(getStdId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentPublishId</column-name><column-value><![CDATA[");
		sb.append(getParentPublishId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stdTyp</column-name><column-value><![CDATA[");
		sb.append(getStdTyp());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>prevPublishTitle</column-name><column-value><![CDATA[");
		sb.append(getPrevPublishTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>prevDescription</column-name><column-value><![CDATA[");
		sb.append(getPrevDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>author</column-name><column-value><![CDATA[");
		sb.append(getAuthor());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>businessOwner</column-name><column-value><![CDATA[");
		sb.append(getBusinessOwner());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>effectiveDate</column-name><column-value><![CDATA[");
		sb.append(getEffectiveDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>implDate</column-name><column-value><![CDATA[");
		sb.append(getImplDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>prevCmplyDate</column-name><column-value><![CDATA[");
		sb.append(getPrevCmplyDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>waiver</column-name><column-value><![CDATA[");
		sb.append(getWaiver());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>category</column-name><column-value><![CDATA[");
		sb.append(getCategory());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdBy</column-name><column-value><![CDATA[");
		sb.append(getCreatedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>change</column-name><column-value><![CDATA[");
		sb.append(getChange());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isGlobal</column-name><column-value><![CDATA[");
		sb.append(getIsGlobal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>regionCode</column-name><column-value><![CDATA[");
		sb.append(getRegionCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>notes</column-name><column-value><![CDATA[");
		sb.append(getNotes());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>framework</column-name><column-value><![CDATA[");
		sb.append(getFramework());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>internalReference</column-name><column-value><![CDATA[");
		sb.append(getInternalReference());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>region</column-name><column-value><![CDATA[");
		sb.append(getRegion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusIdentifier</column-name><column-value><![CDATA[");
		sb.append(getStatusIdentifier());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sortOrder</column-name><column-value><![CDATA[");
		sb.append(getSortOrder());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>localeCode</column-name><column-value><![CDATA[");
		sb.append(getLocaleCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>taxonomyId</column-name><column-value><![CDATA[");
		sb.append(getTaxonomyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>prntTaxonomyId</column-name><column-value><![CDATA[");
		sb.append(getPrntTaxonomyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>attachmentExists</column-name><column-value><![CDATA[");
		sb.append(getAttachmentExists());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>attachmentList</column-name><column-value><![CDATA[");
		sb.append(getAttachmentList());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>linkExists</column-name><column-value><![CDATA[");
		sb.append(getLinkExists());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>linkList</column-name><column-value><![CDATA[");
		sb.append(getLinkList());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imageExists</column-name><column-value><![CDATA[");
		sb.append(getImageExists());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stdXrefListStdId</column-name><column-value><![CDATA[");
		sb.append(getStdXrefListStdId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>attachmentStatus</column-name><column-value><![CDATA[");
		sb.append(getAttachmentStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>linkStatus</column-name><column-value><![CDATA[");
		sb.append(getLinkStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imageStatus</column-name><column-value><![CDATA[");
		sb.append(getImageStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imageIdList</column-name><column-value><![CDATA[");
		sb.append(getImageIdList());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>indexOrder</column-name><column-value><![CDATA[");
		sb.append(getIndexOrder());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>publishTaxonomyId</column-name><column-value><![CDATA[");
		sb.append(getPublishTaxonomyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentTaxonomyId</column-name><column-value><![CDATA[");
		sb.append(getParentTaxonomyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>indexTitle</column-name><column-value><![CDATA[");
		sb.append(getIndexTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>indexLvl</column-name><column-value><![CDATA[");
		sb.append(getIndexLvl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>taxonomyPath</column-name><column-value><![CDATA[");
		sb.append(getTaxonomyPath());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>levelSortOrder</column-name><column-value><![CDATA[");
		sb.append(getLevelSortOrder());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>indexDescription</column-name><column-value><![CDATA[");
		sb.append(getIndexDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>matchedId</column-name><column-value><![CDATA[");
		sb.append(getMatchedId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>expiryDate</column-name><column-value><![CDATA[");
		sb.append(getExpiryDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>prevExpiryDate</column-name><column-value><![CDATA[");
		sb.append(getPrevExpiryDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>expiredStdId</column-name><column-value><![CDATA[");
		sb.append(getExpiredStdId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>flagStdId</column-name><column-value><![CDATA[");
		sb.append(getFlagStdId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>prevFlagStdId</column-name><column-value><![CDATA[");
		sb.append(getPrevFlagStdId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>titleChange</column-name><column-value><![CDATA[");
		sb.append(getTitleChange());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cmplyChange</column-name><column-value><![CDATA[");
		sb.append(getCmplyChange());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>exprChange</column-name><column-value><![CDATA[");
		sb.append(getExprChange());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hlcChange</column-name><column-value><![CDATA[");
		sb.append(getHlcChange());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>changedStatus</column-name><column-value><![CDATA[");
		sb.append(getChangedStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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
	private BaseModel<?> _publishStandardsExtRemoteModel;
}