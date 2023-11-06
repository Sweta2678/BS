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
 * This class is a wrapper for {@link AttachmentsStandards}.
 * </p>
 *
 * @author Mummanedi
 * @see AttachmentsStandards
 * @generated
 */
public class AttachmentsStandardsWrapper implements AttachmentsStandards,
	ModelWrapper<AttachmentsStandards> {
	public AttachmentsStandardsWrapper(
		AttachmentsStandards attachmentsStandards) {
		_attachmentsStandards = attachmentsStandards;
	}

	@Override
	public Class<?> getModelClass() {
		return AttachmentsStandards.class;
	}

	@Override
	public String getModelClassName() {
		return AttachmentsStandards.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("attachmentId", getAttachmentId());
		attributes.put("localeCode", getLocaleCode());
		attributes.put("parentAttachmentId", getParentAttachmentId());
		attributes.put("stdId", getStdId());
		attributes.put("type", getType());
		attributes.put("title", getTitle());
		attributes.put("translationIndicator", getTranslationIndicator());
		attributes.put("attachmentPath", getAttachmentPath());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long attachmentId = (Long)attributes.get("attachmentId");

		if (attachmentId != null) {
			setAttachmentId(attachmentId);
		}

		String localeCode = (String)attributes.get("localeCode");

		if (localeCode != null) {
			setLocaleCode(localeCode);
		}

		Long parentAttachmentId = (Long)attributes.get("parentAttachmentId");

		if (parentAttachmentId != null) {
			setParentAttachmentId(parentAttachmentId);
		}

		Long stdId = (Long)attributes.get("stdId");

		if (stdId != null) {
			setStdId(stdId);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String translationIndicator = (String)attributes.get(
				"translationIndicator");

		if (translationIndicator != null) {
			setTranslationIndicator(translationIndicator);
		}

		String attachmentPath = (String)attributes.get("attachmentPath");

		if (attachmentPath != null) {
			setAttachmentPath(attachmentPath);
		}

		String creatorId = (String)attributes.get("creatorId");

		if (creatorId != null) {
			setCreatorId(creatorId);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}

		String updatedBy = (String)attributes.get("updatedBy");

		if (updatedBy != null) {
			setUpdatedBy(updatedBy);
		}

		Date updatedDate = (Date)attributes.get("updatedDate");

		if (updatedDate != null) {
			setUpdatedDate(updatedDate);
		}
	}

	/**
	* Returns the primary key of this attachments standards.
	*
	* @return the primary key of this attachments standards
	*/
	@Override
	public com.ihg.brandstandards.db.service.persistence.AttachmentsStandardsPK getPrimaryKey() {
		return _attachmentsStandards.getPrimaryKey();
	}

	/**
	* Sets the primary key of this attachments standards.
	*
	* @param primaryKey the primary key of this attachments standards
	*/
	@Override
	public void setPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.AttachmentsStandardsPK primaryKey) {
		_attachmentsStandards.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the attachment ID of this attachments standards.
	*
	* @return the attachment ID of this attachments standards
	*/
	@Override
	public long getAttachmentId() {
		return _attachmentsStandards.getAttachmentId();
	}

	/**
	* Sets the attachment ID of this attachments standards.
	*
	* @param attachmentId the attachment ID of this attachments standards
	*/
	@Override
	public void setAttachmentId(long attachmentId) {
		_attachmentsStandards.setAttachmentId(attachmentId);
	}

	/**
	* Returns the locale code of this attachments standards.
	*
	* @return the locale code of this attachments standards
	*/
	@Override
	public java.lang.String getLocaleCode() {
		return _attachmentsStandards.getLocaleCode();
	}

	/**
	* Sets the locale code of this attachments standards.
	*
	* @param localeCode the locale code of this attachments standards
	*/
	@Override
	public void setLocaleCode(java.lang.String localeCode) {
		_attachmentsStandards.setLocaleCode(localeCode);
	}

	/**
	* Returns the parent attachment ID of this attachments standards.
	*
	* @return the parent attachment ID of this attachments standards
	*/
	@Override
	public long getParentAttachmentId() {
		return _attachmentsStandards.getParentAttachmentId();
	}

	/**
	* Sets the parent attachment ID of this attachments standards.
	*
	* @param parentAttachmentId the parent attachment ID of this attachments standards
	*/
	@Override
	public void setParentAttachmentId(long parentAttachmentId) {
		_attachmentsStandards.setParentAttachmentId(parentAttachmentId);
	}

	/**
	* Returns the std ID of this attachments standards.
	*
	* @return the std ID of this attachments standards
	*/
	@Override
	public long getStdId() {
		return _attachmentsStandards.getStdId();
	}

	/**
	* Sets the std ID of this attachments standards.
	*
	* @param stdId the std ID of this attachments standards
	*/
	@Override
	public void setStdId(long stdId) {
		_attachmentsStandards.setStdId(stdId);
	}

	/**
	* Returns the type of this attachments standards.
	*
	* @return the type of this attachments standards
	*/
	@Override
	public java.lang.String getType() {
		return _attachmentsStandards.getType();
	}

	/**
	* Sets the type of this attachments standards.
	*
	* @param type the type of this attachments standards
	*/
	@Override
	public void setType(java.lang.String type) {
		_attachmentsStandards.setType(type);
	}

	/**
	* Returns the title of this attachments standards.
	*
	* @return the title of this attachments standards
	*/
	@Override
	public java.lang.String getTitle() {
		return _attachmentsStandards.getTitle();
	}

	/**
	* Sets the title of this attachments standards.
	*
	* @param title the title of this attachments standards
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_attachmentsStandards.setTitle(title);
	}

	/**
	* Returns the translation indicator of this attachments standards.
	*
	* @return the translation indicator of this attachments standards
	*/
	@Override
	public java.lang.String getTranslationIndicator() {
		return _attachmentsStandards.getTranslationIndicator();
	}

	/**
	* Sets the translation indicator of this attachments standards.
	*
	* @param translationIndicator the translation indicator of this attachments standards
	*/
	@Override
	public void setTranslationIndicator(java.lang.String translationIndicator) {
		_attachmentsStandards.setTranslationIndicator(translationIndicator);
	}

	/**
	* Returns the attachment path of this attachments standards.
	*
	* @return the attachment path of this attachments standards
	*/
	@Override
	public java.lang.String getAttachmentPath() {
		return _attachmentsStandards.getAttachmentPath();
	}

	/**
	* Sets the attachment path of this attachments standards.
	*
	* @param attachmentPath the attachment path of this attachments standards
	*/
	@Override
	public void setAttachmentPath(java.lang.String attachmentPath) {
		_attachmentsStandards.setAttachmentPath(attachmentPath);
	}

	/**
	* Returns the creator ID of this attachments standards.
	*
	* @return the creator ID of this attachments standards
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _attachmentsStandards.getCreatorId();
	}

	/**
	* Sets the creator ID of this attachments standards.
	*
	* @param creatorId the creator ID of this attachments standards
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_attachmentsStandards.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this attachments standards.
	*
	* @return the created date of this attachments standards
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _attachmentsStandards.getCreatedDate();
	}

	/**
	* Sets the created date of this attachments standards.
	*
	* @param createdDate the created date of this attachments standards
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_attachmentsStandards.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this attachments standards.
	*
	* @return the updated by of this attachments standards
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _attachmentsStandards.getUpdatedBy();
	}

	/**
	* Sets the updated by of this attachments standards.
	*
	* @param updatedBy the updated by of this attachments standards
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_attachmentsStandards.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this attachments standards.
	*
	* @return the updated date of this attachments standards
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _attachmentsStandards.getUpdatedDate();
	}

	/**
	* Sets the updated date of this attachments standards.
	*
	* @param updatedDate the updated date of this attachments standards
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_attachmentsStandards.setUpdatedDate(updatedDate);
	}

	@Override
	public boolean isNew() {
		return _attachmentsStandards.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_attachmentsStandards.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _attachmentsStandards.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_attachmentsStandards.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _attachmentsStandards.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _attachmentsStandards.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_attachmentsStandards.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _attachmentsStandards.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_attachmentsStandards.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_attachmentsStandards.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_attachmentsStandards.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AttachmentsStandardsWrapper((AttachmentsStandards)_attachmentsStandards.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.AttachmentsStandards attachmentsStandards) {
		return _attachmentsStandards.compareTo(attachmentsStandards);
	}

	@Override
	public int hashCode() {
		return _attachmentsStandards.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.AttachmentsStandards> toCacheModel() {
		return _attachmentsStandards.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.AttachmentsStandards toEscapedModel() {
		return new AttachmentsStandardsWrapper(_attachmentsStandards.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.AttachmentsStandards toUnescapedModel() {
		return new AttachmentsStandardsWrapper(_attachmentsStandards.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _attachmentsStandards.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _attachmentsStandards.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_attachmentsStandards.persist();
	}

	/**
	* @return the isTranslationExist
	*/
	@Override
	public boolean isTranslationExist() {
		return _attachmentsStandards.isTranslationExist();
	}

	/**
	* @param isTranslationExist the isTranslationExist to set
	*/
	@Override
	public void setTranslationExist(boolean isTranslationExist) {
		_attachmentsStandards.setTranslationExist(isTranslationExist);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AttachmentsStandardsWrapper)) {
			return false;
		}

		AttachmentsStandardsWrapper attachmentsStandardsWrapper = (AttachmentsStandardsWrapper)obj;

		if (Validator.equals(_attachmentsStandards,
					attachmentsStandardsWrapper._attachmentsStandards)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public AttachmentsStandards getWrappedAttachmentsStandards() {
		return _attachmentsStandards;
	}

	@Override
	public AttachmentsStandards getWrappedModel() {
		return _attachmentsStandards;
	}

	@Override
	public void resetOriginalValues() {
		_attachmentsStandards.resetOriginalValues();
	}

	private AttachmentsStandards _attachmentsStandards;
}