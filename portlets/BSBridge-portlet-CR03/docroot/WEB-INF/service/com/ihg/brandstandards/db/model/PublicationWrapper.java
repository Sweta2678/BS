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
 * This class is a wrapper for {@link Publication}.
 * </p>
 *
 * @author Mummanedi
 * @see Publication
 * @generated
 */
public class PublicationWrapper implements Publication,
	ModelWrapper<Publication> {
	public PublicationWrapper(Publication publication) {
		_publication = publication;
	}

	@Override
	public Class<?> getModelClass() {
		return Publication.class;
	}

	@Override
	public String getModelClassName() {
		return Publication.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("publishId", getPublishId());
		attributes.put("publishVerId", getPublishVerId());
		attributes.put("publishStatCd", getPublishStatCd());
		attributes.put("chainCode", getChainCode());
		attributes.put("publishEnvName", getPublishEnvName());
		attributes.put("publishLocaleList", getPublishLocaleList());
		attributes.put("publishDate", getPublishDate());
		attributes.put("publishContentType", getPublishContentType());
		attributes.put("parentPublishId", getParentPublishId());
		attributes.put("validateTranslation", getValidateTranslation());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long publishId = (Long)attributes.get("publishId");

		if (publishId != null) {
			setPublishId(publishId);
		}

		Long publishVerId = (Long)attributes.get("publishVerId");

		if (publishVerId != null) {
			setPublishVerId(publishVerId);
		}

		String publishStatCd = (String)attributes.get("publishStatCd");

		if (publishStatCd != null) {
			setPublishStatCd(publishStatCd);
		}

		String chainCode = (String)attributes.get("chainCode");

		if (chainCode != null) {
			setChainCode(chainCode);
		}

		String publishEnvName = (String)attributes.get("publishEnvName");

		if (publishEnvName != null) {
			setPublishEnvName(publishEnvName);
		}

		String publishLocaleList = (String)attributes.get("publishLocaleList");

		if (publishLocaleList != null) {
			setPublishLocaleList(publishLocaleList);
		}

		Date publishDate = (Date)attributes.get("publishDate");

		if (publishDate != null) {
			setPublishDate(publishDate);
		}

		String publishContentType = (String)attributes.get("publishContentType");

		if (publishContentType != null) {
			setPublishContentType(publishContentType);
		}

		Long parentPublishId = (Long)attributes.get("parentPublishId");

		if (parentPublishId != null) {
			setParentPublishId(parentPublishId);
		}

		String validateTranslation = (String)attributes.get(
				"validateTranslation");

		if (validateTranslation != null) {
			setValidateTranslation(validateTranslation);
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
	* Returns the primary key of this publication.
	*
	* @return the primary key of this publication
	*/
	@Override
	public long getPrimaryKey() {
		return _publication.getPrimaryKey();
	}

	/**
	* Sets the primary key of this publication.
	*
	* @param primaryKey the primary key of this publication
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_publication.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the publish ID of this publication.
	*
	* @return the publish ID of this publication
	*/
	@Override
	public long getPublishId() {
		return _publication.getPublishId();
	}

	/**
	* Sets the publish ID of this publication.
	*
	* @param publishId the publish ID of this publication
	*/
	@Override
	public void setPublishId(long publishId) {
		_publication.setPublishId(publishId);
	}

	/**
	* Returns the publish ver ID of this publication.
	*
	* @return the publish ver ID of this publication
	*/
	@Override
	public long getPublishVerId() {
		return _publication.getPublishVerId();
	}

	/**
	* Sets the publish ver ID of this publication.
	*
	* @param publishVerId the publish ver ID of this publication
	*/
	@Override
	public void setPublishVerId(long publishVerId) {
		_publication.setPublishVerId(publishVerId);
	}

	/**
	* Returns the publish stat cd of this publication.
	*
	* @return the publish stat cd of this publication
	*/
	@Override
	public java.lang.String getPublishStatCd() {
		return _publication.getPublishStatCd();
	}

	/**
	* Sets the publish stat cd of this publication.
	*
	* @param publishStatCd the publish stat cd of this publication
	*/
	@Override
	public void setPublishStatCd(java.lang.String publishStatCd) {
		_publication.setPublishStatCd(publishStatCd);
	}

	/**
	* Returns the chain code of this publication.
	*
	* @return the chain code of this publication
	*/
	@Override
	public java.lang.String getChainCode() {
		return _publication.getChainCode();
	}

	/**
	* Sets the chain code of this publication.
	*
	* @param chainCode the chain code of this publication
	*/
	@Override
	public void setChainCode(java.lang.String chainCode) {
		_publication.setChainCode(chainCode);
	}

	/**
	* Returns the publish env name of this publication.
	*
	* @return the publish env name of this publication
	*/
	@Override
	public java.lang.String getPublishEnvName() {
		return _publication.getPublishEnvName();
	}

	/**
	* Sets the publish env name of this publication.
	*
	* @param publishEnvName the publish env name of this publication
	*/
	@Override
	public void setPublishEnvName(java.lang.String publishEnvName) {
		_publication.setPublishEnvName(publishEnvName);
	}

	/**
	* Returns the publish locale list of this publication.
	*
	* @return the publish locale list of this publication
	*/
	@Override
	public java.lang.String getPublishLocaleList() {
		return _publication.getPublishLocaleList();
	}

	/**
	* Sets the publish locale list of this publication.
	*
	* @param publishLocaleList the publish locale list of this publication
	*/
	@Override
	public void setPublishLocaleList(java.lang.String publishLocaleList) {
		_publication.setPublishLocaleList(publishLocaleList);
	}

	/**
	* Returns the publish date of this publication.
	*
	* @return the publish date of this publication
	*/
	@Override
	public java.util.Date getPublishDate() {
		return _publication.getPublishDate();
	}

	/**
	* Sets the publish date of this publication.
	*
	* @param publishDate the publish date of this publication
	*/
	@Override
	public void setPublishDate(java.util.Date publishDate) {
		_publication.setPublishDate(publishDate);
	}

	/**
	* Returns the publish content type of this publication.
	*
	* @return the publish content type of this publication
	*/
	@Override
	public java.lang.String getPublishContentType() {
		return _publication.getPublishContentType();
	}

	/**
	* Sets the publish content type of this publication.
	*
	* @param publishContentType the publish content type of this publication
	*/
	@Override
	public void setPublishContentType(java.lang.String publishContentType) {
		_publication.setPublishContentType(publishContentType);
	}

	/**
	* Returns the parent publish ID of this publication.
	*
	* @return the parent publish ID of this publication
	*/
	@Override
	public long getParentPublishId() {
		return _publication.getParentPublishId();
	}

	/**
	* Sets the parent publish ID of this publication.
	*
	* @param parentPublishId the parent publish ID of this publication
	*/
	@Override
	public void setParentPublishId(long parentPublishId) {
		_publication.setParentPublishId(parentPublishId);
	}

	/**
	* Returns the validate translation of this publication.
	*
	* @return the validate translation of this publication
	*/
	@Override
	public java.lang.String getValidateTranslation() {
		return _publication.getValidateTranslation();
	}

	/**
	* Sets the validate translation of this publication.
	*
	* @param validateTranslation the validate translation of this publication
	*/
	@Override
	public void setValidateTranslation(java.lang.String validateTranslation) {
		_publication.setValidateTranslation(validateTranslation);
	}

	/**
	* Returns the creator ID of this publication.
	*
	* @return the creator ID of this publication
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _publication.getCreatorId();
	}

	/**
	* Sets the creator ID of this publication.
	*
	* @param creatorId the creator ID of this publication
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_publication.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this publication.
	*
	* @return the created date of this publication
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _publication.getCreatedDate();
	}

	/**
	* Sets the created date of this publication.
	*
	* @param createdDate the created date of this publication
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_publication.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this publication.
	*
	* @return the updated by of this publication
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _publication.getUpdatedBy();
	}

	/**
	* Sets the updated by of this publication.
	*
	* @param updatedBy the updated by of this publication
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_publication.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this publication.
	*
	* @return the updated date of this publication
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _publication.getUpdatedDate();
	}

	/**
	* Sets the updated date of this publication.
	*
	* @param updatedDate the updated date of this publication
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_publication.setUpdatedDate(updatedDate);
	}

	@Override
	public boolean isNew() {
		return _publication.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_publication.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _publication.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_publication.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _publication.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _publication.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_publication.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _publication.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_publication.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_publication.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_publication.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PublicationWrapper((Publication)_publication.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.Publication publication) {
		return _publication.compareTo(publication);
	}

	@Override
	public int hashCode() {
		return _publication.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.Publication> toCacheModel() {
		return _publication.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.Publication toEscapedModel() {
		return new PublicationWrapper(_publication.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.Publication toUnescapedModel() {
		return new PublicationWrapper(_publication.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _publication.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _publication.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_publication.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PublicationWrapper)) {
			return false;
		}

		PublicationWrapper publicationWrapper = (PublicationWrapper)obj;

		if (Validator.equals(_publication, publicationWrapper._publication)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Publication getWrappedPublication() {
		return _publication;
	}

	@Override
	public Publication getWrappedModel() {
		return _publication;
	}

	@Override
	public void resetOriginalValues() {
		_publication.resetOriginalValues();
	}

	private Publication _publication;
}