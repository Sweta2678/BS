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
 * This class is a wrapper for {@link ChainAttachmentsStandards}.
 * </p>
 *
 * @author Mummanedi
 * @see ChainAttachmentsStandards
 * @generated
 */
public class ChainAttachmentsStandardsWrapper
	implements ChainAttachmentsStandards,
		ModelWrapper<ChainAttachmentsStandards> {
	public ChainAttachmentsStandardsWrapper(
		ChainAttachmentsStandards chainAttachmentsStandards) {
		_chainAttachmentsStandards = chainAttachmentsStandards;
	}

	@Override
	public Class<?> getModelClass() {
		return ChainAttachmentsStandards.class;
	}

	@Override
	public String getModelClassName() {
		return ChainAttachmentsStandards.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("chainAttachmentId", getChainAttachmentId());
		attributes.put("attachmentId", getAttachmentId());
		attributes.put("localeCode", getLocaleCode());
		attributes.put("chainCode", getChainCode());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long chainAttachmentId = (Long)attributes.get("chainAttachmentId");

		if (chainAttachmentId != null) {
			setChainAttachmentId(chainAttachmentId);
		}

		Long attachmentId = (Long)attributes.get("attachmentId");

		if (attachmentId != null) {
			setAttachmentId(attachmentId);
		}

		String localeCode = (String)attributes.get("localeCode");

		if (localeCode != null) {
			setLocaleCode(localeCode);
		}

		String chainCode = (String)attributes.get("chainCode");

		if (chainCode != null) {
			setChainCode(chainCode);
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
	* Returns the primary key of this chain attachments standards.
	*
	* @return the primary key of this chain attachments standards
	*/
	@Override
	public long getPrimaryKey() {
		return _chainAttachmentsStandards.getPrimaryKey();
	}

	/**
	* Sets the primary key of this chain attachments standards.
	*
	* @param primaryKey the primary key of this chain attachments standards
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_chainAttachmentsStandards.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the chain attachment ID of this chain attachments standards.
	*
	* @return the chain attachment ID of this chain attachments standards
	*/
	@Override
	public long getChainAttachmentId() {
		return _chainAttachmentsStandards.getChainAttachmentId();
	}

	/**
	* Sets the chain attachment ID of this chain attachments standards.
	*
	* @param chainAttachmentId the chain attachment ID of this chain attachments standards
	*/
	@Override
	public void setChainAttachmentId(long chainAttachmentId) {
		_chainAttachmentsStandards.setChainAttachmentId(chainAttachmentId);
	}

	/**
	* Returns the attachment ID of this chain attachments standards.
	*
	* @return the attachment ID of this chain attachments standards
	*/
	@Override
	public long getAttachmentId() {
		return _chainAttachmentsStandards.getAttachmentId();
	}

	/**
	* Sets the attachment ID of this chain attachments standards.
	*
	* @param attachmentId the attachment ID of this chain attachments standards
	*/
	@Override
	public void setAttachmentId(long attachmentId) {
		_chainAttachmentsStandards.setAttachmentId(attachmentId);
	}

	/**
	* Returns the locale code of this chain attachments standards.
	*
	* @return the locale code of this chain attachments standards
	*/
	@Override
	public java.lang.String getLocaleCode() {
		return _chainAttachmentsStandards.getLocaleCode();
	}

	/**
	* Sets the locale code of this chain attachments standards.
	*
	* @param localeCode the locale code of this chain attachments standards
	*/
	@Override
	public void setLocaleCode(java.lang.String localeCode) {
		_chainAttachmentsStandards.setLocaleCode(localeCode);
	}

	/**
	* Returns the chain code of this chain attachments standards.
	*
	* @return the chain code of this chain attachments standards
	*/
	@Override
	public java.lang.String getChainCode() {
		return _chainAttachmentsStandards.getChainCode();
	}

	/**
	* Sets the chain code of this chain attachments standards.
	*
	* @param chainCode the chain code of this chain attachments standards
	*/
	@Override
	public void setChainCode(java.lang.String chainCode) {
		_chainAttachmentsStandards.setChainCode(chainCode);
	}

	/**
	* Returns the creator ID of this chain attachments standards.
	*
	* @return the creator ID of this chain attachments standards
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _chainAttachmentsStandards.getCreatorId();
	}

	/**
	* Sets the creator ID of this chain attachments standards.
	*
	* @param creatorId the creator ID of this chain attachments standards
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_chainAttachmentsStandards.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this chain attachments standards.
	*
	* @return the created date of this chain attachments standards
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _chainAttachmentsStandards.getCreatedDate();
	}

	/**
	* Sets the created date of this chain attachments standards.
	*
	* @param createdDate the created date of this chain attachments standards
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_chainAttachmentsStandards.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this chain attachments standards.
	*
	* @return the updated by of this chain attachments standards
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _chainAttachmentsStandards.getUpdatedBy();
	}

	/**
	* Sets the updated by of this chain attachments standards.
	*
	* @param updatedBy the updated by of this chain attachments standards
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_chainAttachmentsStandards.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this chain attachments standards.
	*
	* @return the updated date of this chain attachments standards
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _chainAttachmentsStandards.getUpdatedDate();
	}

	/**
	* Sets the updated date of this chain attachments standards.
	*
	* @param updatedDate the updated date of this chain attachments standards
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_chainAttachmentsStandards.setUpdatedDate(updatedDate);
	}

	@Override
	public boolean isNew() {
		return _chainAttachmentsStandards.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_chainAttachmentsStandards.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _chainAttachmentsStandards.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_chainAttachmentsStandards.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _chainAttachmentsStandards.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _chainAttachmentsStandards.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_chainAttachmentsStandards.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _chainAttachmentsStandards.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_chainAttachmentsStandards.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_chainAttachmentsStandards.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_chainAttachmentsStandards.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ChainAttachmentsStandardsWrapper((ChainAttachmentsStandards)_chainAttachmentsStandards.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.ChainAttachmentsStandards chainAttachmentsStandards) {
		return _chainAttachmentsStandards.compareTo(chainAttachmentsStandards);
	}

	@Override
	public int hashCode() {
		return _chainAttachmentsStandards.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.ChainAttachmentsStandards> toCacheModel() {
		return _chainAttachmentsStandards.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.ChainAttachmentsStandards toEscapedModel() {
		return new ChainAttachmentsStandardsWrapper(_chainAttachmentsStandards.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.ChainAttachmentsStandards toUnescapedModel() {
		return new ChainAttachmentsStandardsWrapper(_chainAttachmentsStandards.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _chainAttachmentsStandards.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _chainAttachmentsStandards.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_chainAttachmentsStandards.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ChainAttachmentsStandardsWrapper)) {
			return false;
		}

		ChainAttachmentsStandardsWrapper chainAttachmentsStandardsWrapper = (ChainAttachmentsStandardsWrapper)obj;

		if (Validator.equals(_chainAttachmentsStandards,
					chainAttachmentsStandardsWrapper._chainAttachmentsStandards)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ChainAttachmentsStandards getWrappedChainAttachmentsStandards() {
		return _chainAttachmentsStandards;
	}

	@Override
	public ChainAttachmentsStandards getWrappedModel() {
		return _chainAttachmentsStandards;
	}

	@Override
	public void resetOriginalValues() {
		_chainAttachmentsStandards.resetOriginalValues();
	}

	private ChainAttachmentsStandards _chainAttachmentsStandards;
}