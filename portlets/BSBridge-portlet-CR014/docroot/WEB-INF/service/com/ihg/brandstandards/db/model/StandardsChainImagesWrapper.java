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
 * This class is a wrapper for {@link StandardsChainImages}.
 * </p>
 *
 * @author Mummanedi
 * @see StandardsChainImages
 * @generated
 */
public class StandardsChainImagesWrapper implements StandardsChainImages,
	ModelWrapper<StandardsChainImages> {
	public StandardsChainImagesWrapper(
		StandardsChainImages standardsChainImages) {
		_standardsChainImages = standardsChainImages;
	}

	@Override
	public Class<?> getModelClass() {
		return StandardsChainImages.class;
	}

	@Override
	public String getModelClassName() {
		return StandardsChainImages.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("stdImageId", getStdImageId());
		attributes.put("chainCode", getChainCode());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long stdImageId = (Long)attributes.get("stdImageId");

		if (stdImageId != null) {
			setStdImageId(stdImageId);
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
	* Returns the primary key of this standards chain images.
	*
	* @return the primary key of this standards chain images
	*/
	@Override
	public com.ihg.brandstandards.db.service.persistence.StandardsChainImagesPK getPrimaryKey() {
		return _standardsChainImages.getPrimaryKey();
	}

	/**
	* Sets the primary key of this standards chain images.
	*
	* @param primaryKey the primary key of this standards chain images
	*/
	@Override
	public void setPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.StandardsChainImagesPK primaryKey) {
		_standardsChainImages.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the std image ID of this standards chain images.
	*
	* @return the std image ID of this standards chain images
	*/
	@Override
	public long getStdImageId() {
		return _standardsChainImages.getStdImageId();
	}

	/**
	* Sets the std image ID of this standards chain images.
	*
	* @param stdImageId the std image ID of this standards chain images
	*/
	@Override
	public void setStdImageId(long stdImageId) {
		_standardsChainImages.setStdImageId(stdImageId);
	}

	/**
	* Returns the chain code of this standards chain images.
	*
	* @return the chain code of this standards chain images
	*/
	@Override
	public java.lang.String getChainCode() {
		return _standardsChainImages.getChainCode();
	}

	/**
	* Sets the chain code of this standards chain images.
	*
	* @param chainCode the chain code of this standards chain images
	*/
	@Override
	public void setChainCode(java.lang.String chainCode) {
		_standardsChainImages.setChainCode(chainCode);
	}

	/**
	* Returns the creator ID of this standards chain images.
	*
	* @return the creator ID of this standards chain images
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _standardsChainImages.getCreatorId();
	}

	/**
	* Sets the creator ID of this standards chain images.
	*
	* @param creatorId the creator ID of this standards chain images
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_standardsChainImages.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this standards chain images.
	*
	* @return the created date of this standards chain images
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _standardsChainImages.getCreatedDate();
	}

	/**
	* Sets the created date of this standards chain images.
	*
	* @param createdDate the created date of this standards chain images
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_standardsChainImages.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this standards chain images.
	*
	* @return the updated by of this standards chain images
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _standardsChainImages.getUpdatedBy();
	}

	/**
	* Sets the updated by of this standards chain images.
	*
	* @param updatedBy the updated by of this standards chain images
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_standardsChainImages.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this standards chain images.
	*
	* @return the updated date of this standards chain images
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _standardsChainImages.getUpdatedDate();
	}

	/**
	* Sets the updated date of this standards chain images.
	*
	* @param updatedDate the updated date of this standards chain images
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_standardsChainImages.setUpdatedDate(updatedDate);
	}

	@Override
	public boolean isNew() {
		return _standardsChainImages.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_standardsChainImages.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _standardsChainImages.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_standardsChainImages.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _standardsChainImages.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _standardsChainImages.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_standardsChainImages.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _standardsChainImages.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_standardsChainImages.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_standardsChainImages.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_standardsChainImages.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new StandardsChainImagesWrapper((StandardsChainImages)_standardsChainImages.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.StandardsChainImages standardsChainImages) {
		return _standardsChainImages.compareTo(standardsChainImages);
	}

	@Override
	public int hashCode() {
		return _standardsChainImages.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.StandardsChainImages> toCacheModel() {
		return _standardsChainImages.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.StandardsChainImages toEscapedModel() {
		return new StandardsChainImagesWrapper(_standardsChainImages.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.StandardsChainImages toUnescapedModel() {
		return new StandardsChainImagesWrapper(_standardsChainImages.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _standardsChainImages.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _standardsChainImages.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_standardsChainImages.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StandardsChainImagesWrapper)) {
			return false;
		}

		StandardsChainImagesWrapper standardsChainImagesWrapper = (StandardsChainImagesWrapper)obj;

		if (Validator.equals(_standardsChainImages,
					standardsChainImagesWrapper._standardsChainImages)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public StandardsChainImages getWrappedStandardsChainImages() {
		return _standardsChainImages;
	}

	@Override
	public StandardsChainImages getWrappedModel() {
		return _standardsChainImages;
	}

	@Override
	public void resetOriginalValues() {
		_standardsChainImages.resetOriginalValues();
	}

	private StandardsChainImages _standardsChainImages;
}