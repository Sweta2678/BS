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
 * This class is a wrapper for {@link StandardsCountryImages}.
 * </p>
 *
 * @author Mummanedi
 * @see StandardsCountryImages
 * @generated
 */
public class StandardsCountryImagesWrapper implements StandardsCountryImages,
	ModelWrapper<StandardsCountryImages> {
	public StandardsCountryImagesWrapper(
		StandardsCountryImages standardsCountryImages) {
		_standardsCountryImages = standardsCountryImages;
	}

	@Override
	public Class<?> getModelClass() {
		return StandardsCountryImages.class;
	}

	@Override
	public String getModelClassName() {
		return StandardsCountryImages.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("stdImageId", getStdImageId());
		attributes.put("countryCode", getCountryCode());
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

		String countryCode = (String)attributes.get("countryCode");

		if (countryCode != null) {
			setCountryCode(countryCode);
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
	* Returns the primary key of this standards country images.
	*
	* @return the primary key of this standards country images
	*/
	@Override
	public com.ihg.brandstandards.db.service.persistence.StandardsCountryImagesPK getPrimaryKey() {
		return _standardsCountryImages.getPrimaryKey();
	}

	/**
	* Sets the primary key of this standards country images.
	*
	* @param primaryKey the primary key of this standards country images
	*/
	@Override
	public void setPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.StandardsCountryImagesPK primaryKey) {
		_standardsCountryImages.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the std image ID of this standards country images.
	*
	* @return the std image ID of this standards country images
	*/
	@Override
	public long getStdImageId() {
		return _standardsCountryImages.getStdImageId();
	}

	/**
	* Sets the std image ID of this standards country images.
	*
	* @param stdImageId the std image ID of this standards country images
	*/
	@Override
	public void setStdImageId(long stdImageId) {
		_standardsCountryImages.setStdImageId(stdImageId);
	}

	/**
	* Returns the country code of this standards country images.
	*
	* @return the country code of this standards country images
	*/
	@Override
	public java.lang.String getCountryCode() {
		return _standardsCountryImages.getCountryCode();
	}

	/**
	* Sets the country code of this standards country images.
	*
	* @param countryCode the country code of this standards country images
	*/
	@Override
	public void setCountryCode(java.lang.String countryCode) {
		_standardsCountryImages.setCountryCode(countryCode);
	}

	/**
	* Returns the creator ID of this standards country images.
	*
	* @return the creator ID of this standards country images
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _standardsCountryImages.getCreatorId();
	}

	/**
	* Sets the creator ID of this standards country images.
	*
	* @param creatorId the creator ID of this standards country images
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_standardsCountryImages.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this standards country images.
	*
	* @return the created date of this standards country images
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _standardsCountryImages.getCreatedDate();
	}

	/**
	* Sets the created date of this standards country images.
	*
	* @param createdDate the created date of this standards country images
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_standardsCountryImages.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this standards country images.
	*
	* @return the updated by of this standards country images
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _standardsCountryImages.getUpdatedBy();
	}

	/**
	* Sets the updated by of this standards country images.
	*
	* @param updatedBy the updated by of this standards country images
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_standardsCountryImages.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this standards country images.
	*
	* @return the updated date of this standards country images
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _standardsCountryImages.getUpdatedDate();
	}

	/**
	* Sets the updated date of this standards country images.
	*
	* @param updatedDate the updated date of this standards country images
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_standardsCountryImages.setUpdatedDate(updatedDate);
	}

	@Override
	public boolean isNew() {
		return _standardsCountryImages.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_standardsCountryImages.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _standardsCountryImages.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_standardsCountryImages.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _standardsCountryImages.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _standardsCountryImages.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_standardsCountryImages.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _standardsCountryImages.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_standardsCountryImages.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_standardsCountryImages.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_standardsCountryImages.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new StandardsCountryImagesWrapper((StandardsCountryImages)_standardsCountryImages.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.StandardsCountryImages standardsCountryImages) {
		return _standardsCountryImages.compareTo(standardsCountryImages);
	}

	@Override
	public int hashCode() {
		return _standardsCountryImages.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.StandardsCountryImages> toCacheModel() {
		return _standardsCountryImages.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.StandardsCountryImages toEscapedModel() {
		return new StandardsCountryImagesWrapper(_standardsCountryImages.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.StandardsCountryImages toUnescapedModel() {
		return new StandardsCountryImagesWrapper(_standardsCountryImages.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _standardsCountryImages.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _standardsCountryImages.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_standardsCountryImages.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StandardsCountryImagesWrapper)) {
			return false;
		}

		StandardsCountryImagesWrapper standardsCountryImagesWrapper = (StandardsCountryImagesWrapper)obj;

		if (Validator.equals(_standardsCountryImages,
					standardsCountryImagesWrapper._standardsCountryImages)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public StandardsCountryImages getWrappedStandardsCountryImages() {
		return _standardsCountryImages;
	}

	@Override
	public StandardsCountryImages getWrappedModel() {
		return _standardsCountryImages;
	}

	@Override
	public void resetOriginalValues() {
		_standardsCountryImages.resetOriginalValues();
	}

	private StandardsCountryImages _standardsCountryImages;
}