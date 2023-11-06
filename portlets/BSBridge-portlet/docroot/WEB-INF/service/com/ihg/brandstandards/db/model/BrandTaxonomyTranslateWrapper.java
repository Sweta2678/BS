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
 * This class is a wrapper for {@link BrandTaxonomyTranslate}.
 * </p>
 *
 * @author Mummanedi
 * @see BrandTaxonomyTranslate
 * @generated
 */
public class BrandTaxonomyTranslateWrapper implements BrandTaxonomyTranslate,
	ModelWrapper<BrandTaxonomyTranslate> {
	public BrandTaxonomyTranslateWrapper(
		BrandTaxonomyTranslate brandTaxonomyTranslate) {
		_brandTaxonomyTranslate = brandTaxonomyTranslate;
	}

	@Override
	public Class<?> getModelClass() {
		return BrandTaxonomyTranslate.class;
	}

	@Override
	public String getModelClassName() {
		return BrandTaxonomyTranslate.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("brandTaxId", getBrandTaxId());
		attributes.put("localeCd", getLocaleCd());
		attributes.put("title", getTitle());
		attributes.put("desc", getDesc());
		attributes.put("imageLoc", getImageLoc());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long brandTaxId = (Long)attributes.get("brandTaxId");

		if (brandTaxId != null) {
			setBrandTaxId(brandTaxId);
		}

		String localeCd = (String)attributes.get("localeCd");

		if (localeCd != null) {
			setLocaleCd(localeCd);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String desc = (String)attributes.get("desc");

		if (desc != null) {
			setDesc(desc);
		}

		String imageLoc = (String)attributes.get("imageLoc");

		if (imageLoc != null) {
			setImageLoc(imageLoc);
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
	* Returns the primary key of this brand taxonomy translate.
	*
	* @return the primary key of this brand taxonomy translate
	*/
	@Override
	public com.ihg.brandstandards.db.service.persistence.BrandTaxonomyTranslatePK getPrimaryKey() {
		return _brandTaxonomyTranslate.getPrimaryKey();
	}

	/**
	* Sets the primary key of this brand taxonomy translate.
	*
	* @param primaryKey the primary key of this brand taxonomy translate
	*/
	@Override
	public void setPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.BrandTaxonomyTranslatePK primaryKey) {
		_brandTaxonomyTranslate.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the brand tax ID of this brand taxonomy translate.
	*
	* @return the brand tax ID of this brand taxonomy translate
	*/
	@Override
	public long getBrandTaxId() {
		return _brandTaxonomyTranslate.getBrandTaxId();
	}

	/**
	* Sets the brand tax ID of this brand taxonomy translate.
	*
	* @param brandTaxId the brand tax ID of this brand taxonomy translate
	*/
	@Override
	public void setBrandTaxId(long brandTaxId) {
		_brandTaxonomyTranslate.setBrandTaxId(brandTaxId);
	}

	/**
	* Returns the locale cd of this brand taxonomy translate.
	*
	* @return the locale cd of this brand taxonomy translate
	*/
	@Override
	public java.lang.String getLocaleCd() {
		return _brandTaxonomyTranslate.getLocaleCd();
	}

	/**
	* Sets the locale cd of this brand taxonomy translate.
	*
	* @param localeCd the locale cd of this brand taxonomy translate
	*/
	@Override
	public void setLocaleCd(java.lang.String localeCd) {
		_brandTaxonomyTranslate.setLocaleCd(localeCd);
	}

	/**
	* Returns the title of this brand taxonomy translate.
	*
	* @return the title of this brand taxonomy translate
	*/
	@Override
	public java.lang.String getTitle() {
		return _brandTaxonomyTranslate.getTitle();
	}

	/**
	* Sets the title of this brand taxonomy translate.
	*
	* @param title the title of this brand taxonomy translate
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_brandTaxonomyTranslate.setTitle(title);
	}

	/**
	* Returns the desc of this brand taxonomy translate.
	*
	* @return the desc of this brand taxonomy translate
	*/
	@Override
	public java.lang.String getDesc() {
		return _brandTaxonomyTranslate.getDesc();
	}

	/**
	* Sets the desc of this brand taxonomy translate.
	*
	* @param desc the desc of this brand taxonomy translate
	*/
	@Override
	public void setDesc(java.lang.String desc) {
		_brandTaxonomyTranslate.setDesc(desc);
	}

	/**
	* Returns the image loc of this brand taxonomy translate.
	*
	* @return the image loc of this brand taxonomy translate
	*/
	@Override
	public java.lang.String getImageLoc() {
		return _brandTaxonomyTranslate.getImageLoc();
	}

	/**
	* Sets the image loc of this brand taxonomy translate.
	*
	* @param imageLoc the image loc of this brand taxonomy translate
	*/
	@Override
	public void setImageLoc(java.lang.String imageLoc) {
		_brandTaxonomyTranslate.setImageLoc(imageLoc);
	}

	/**
	* Returns the creator ID of this brand taxonomy translate.
	*
	* @return the creator ID of this brand taxonomy translate
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _brandTaxonomyTranslate.getCreatorId();
	}

	/**
	* Sets the creator ID of this brand taxonomy translate.
	*
	* @param creatorId the creator ID of this brand taxonomy translate
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_brandTaxonomyTranslate.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this brand taxonomy translate.
	*
	* @return the created date of this brand taxonomy translate
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _brandTaxonomyTranslate.getCreatedDate();
	}

	/**
	* Sets the created date of this brand taxonomy translate.
	*
	* @param createdDate the created date of this brand taxonomy translate
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_brandTaxonomyTranslate.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this brand taxonomy translate.
	*
	* @return the updated by of this brand taxonomy translate
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _brandTaxonomyTranslate.getUpdatedBy();
	}

	/**
	* Sets the updated by of this brand taxonomy translate.
	*
	* @param updatedBy the updated by of this brand taxonomy translate
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_brandTaxonomyTranslate.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this brand taxonomy translate.
	*
	* @return the updated date of this brand taxonomy translate
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _brandTaxonomyTranslate.getUpdatedDate();
	}

	/**
	* Sets the updated date of this brand taxonomy translate.
	*
	* @param updatedDate the updated date of this brand taxonomy translate
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_brandTaxonomyTranslate.setUpdatedDate(updatedDate);
	}

	@Override
	public boolean isNew() {
		return _brandTaxonomyTranslate.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_brandTaxonomyTranslate.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _brandTaxonomyTranslate.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_brandTaxonomyTranslate.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _brandTaxonomyTranslate.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _brandTaxonomyTranslate.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_brandTaxonomyTranslate.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _brandTaxonomyTranslate.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_brandTaxonomyTranslate.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_brandTaxonomyTranslate.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_brandTaxonomyTranslate.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BrandTaxonomyTranslateWrapper((BrandTaxonomyTranslate)_brandTaxonomyTranslate.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.BrandTaxonomyTranslate brandTaxonomyTranslate) {
		return _brandTaxonomyTranslate.compareTo(brandTaxonomyTranslate);
	}

	@Override
	public int hashCode() {
		return _brandTaxonomyTranslate.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.BrandTaxonomyTranslate> toCacheModel() {
		return _brandTaxonomyTranslate.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.BrandTaxonomyTranslate toEscapedModel() {
		return new BrandTaxonomyTranslateWrapper(_brandTaxonomyTranslate.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.BrandTaxonomyTranslate toUnescapedModel() {
		return new BrandTaxonomyTranslateWrapper(_brandTaxonomyTranslate.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _brandTaxonomyTranslate.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _brandTaxonomyTranslate.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_brandTaxonomyTranslate.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BrandTaxonomyTranslateWrapper)) {
			return false;
		}

		BrandTaxonomyTranslateWrapper brandTaxonomyTranslateWrapper = (BrandTaxonomyTranslateWrapper)obj;

		if (Validator.equals(_brandTaxonomyTranslate,
					brandTaxonomyTranslateWrapper._brandTaxonomyTranslate)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public BrandTaxonomyTranslate getWrappedBrandTaxonomyTranslate() {
		return _brandTaxonomyTranslate;
	}

	@Override
	public BrandTaxonomyTranslate getWrappedModel() {
		return _brandTaxonomyTranslate;
	}

	@Override
	public void resetOriginalValues() {
		_brandTaxonomyTranslate.resetOriginalValues();
	}

	private BrandTaxonomyTranslate _brandTaxonomyTranslate;
}