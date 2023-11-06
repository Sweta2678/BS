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
 * This class is a wrapper for {@link TaxonomyTranslate}.
 * </p>
 *
 * @author Mummanedi
 * @see TaxonomyTranslate
 * @generated
 */
public class TaxonomyTranslateWrapper implements TaxonomyTranslate,
	ModelWrapper<TaxonomyTranslate> {
	public TaxonomyTranslateWrapper(TaxonomyTranslate taxonomyTranslate) {
		_taxonomyTranslate = taxonomyTranslate;
	}

	@Override
	public Class<?> getModelClass() {
		return TaxonomyTranslate.class;
	}

	@Override
	public String getModelClassName() {
		return TaxonomyTranslate.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("taxId", getTaxId());
		attributes.put("localeCode", getLocaleCode());
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
		Long taxId = (Long)attributes.get("taxId");

		if (taxId != null) {
			setTaxId(taxId);
		}

		String localeCode = (String)attributes.get("localeCode");

		if (localeCode != null) {
			setLocaleCode(localeCode);
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
	* Returns the primary key of this taxonomy translate.
	*
	* @return the primary key of this taxonomy translate
	*/
	@Override
	public com.ihg.brandstandards.db.service.persistence.TaxonomyTranslatePK getPrimaryKey() {
		return _taxonomyTranslate.getPrimaryKey();
	}

	/**
	* Sets the primary key of this taxonomy translate.
	*
	* @param primaryKey the primary key of this taxonomy translate
	*/
	@Override
	public void setPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.TaxonomyTranslatePK primaryKey) {
		_taxonomyTranslate.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the tax ID of this taxonomy translate.
	*
	* @return the tax ID of this taxonomy translate
	*/
	@Override
	public long getTaxId() {
		return _taxonomyTranslate.getTaxId();
	}

	/**
	* Sets the tax ID of this taxonomy translate.
	*
	* @param taxId the tax ID of this taxonomy translate
	*/
	@Override
	public void setTaxId(long taxId) {
		_taxonomyTranslate.setTaxId(taxId);
	}

	/**
	* Returns the locale code of this taxonomy translate.
	*
	* @return the locale code of this taxonomy translate
	*/
	@Override
	public java.lang.String getLocaleCode() {
		return _taxonomyTranslate.getLocaleCode();
	}

	/**
	* Sets the locale code of this taxonomy translate.
	*
	* @param localeCode the locale code of this taxonomy translate
	*/
	@Override
	public void setLocaleCode(java.lang.String localeCode) {
		_taxonomyTranslate.setLocaleCode(localeCode);
	}

	/**
	* Returns the title of this taxonomy translate.
	*
	* @return the title of this taxonomy translate
	*/
	@Override
	public java.lang.String getTitle() {
		return _taxonomyTranslate.getTitle();
	}

	/**
	* Sets the title of this taxonomy translate.
	*
	* @param title the title of this taxonomy translate
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_taxonomyTranslate.setTitle(title);
	}

	/**
	* Returns the desc of this taxonomy translate.
	*
	* @return the desc of this taxonomy translate
	*/
	@Override
	public java.lang.String getDesc() {
		return _taxonomyTranslate.getDesc();
	}

	/**
	* Sets the desc of this taxonomy translate.
	*
	* @param desc the desc of this taxonomy translate
	*/
	@Override
	public void setDesc(java.lang.String desc) {
		_taxonomyTranslate.setDesc(desc);
	}

	/**
	* Returns the image loc of this taxonomy translate.
	*
	* @return the image loc of this taxonomy translate
	*/
	@Override
	public java.lang.String getImageLoc() {
		return _taxonomyTranslate.getImageLoc();
	}

	/**
	* Sets the image loc of this taxonomy translate.
	*
	* @param imageLoc the image loc of this taxonomy translate
	*/
	@Override
	public void setImageLoc(java.lang.String imageLoc) {
		_taxonomyTranslate.setImageLoc(imageLoc);
	}

	/**
	* Returns the creator ID of this taxonomy translate.
	*
	* @return the creator ID of this taxonomy translate
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _taxonomyTranslate.getCreatorId();
	}

	/**
	* Sets the creator ID of this taxonomy translate.
	*
	* @param creatorId the creator ID of this taxonomy translate
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_taxonomyTranslate.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this taxonomy translate.
	*
	* @return the created date of this taxonomy translate
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _taxonomyTranslate.getCreatedDate();
	}

	/**
	* Sets the created date of this taxonomy translate.
	*
	* @param createdDate the created date of this taxonomy translate
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_taxonomyTranslate.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this taxonomy translate.
	*
	* @return the updated by of this taxonomy translate
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _taxonomyTranslate.getUpdatedBy();
	}

	/**
	* Sets the updated by of this taxonomy translate.
	*
	* @param updatedBy the updated by of this taxonomy translate
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_taxonomyTranslate.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this taxonomy translate.
	*
	* @return the updated date of this taxonomy translate
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _taxonomyTranslate.getUpdatedDate();
	}

	/**
	* Sets the updated date of this taxonomy translate.
	*
	* @param updatedDate the updated date of this taxonomy translate
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_taxonomyTranslate.setUpdatedDate(updatedDate);
	}

	@Override
	public boolean isNew() {
		return _taxonomyTranslate.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_taxonomyTranslate.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _taxonomyTranslate.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_taxonomyTranslate.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _taxonomyTranslate.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _taxonomyTranslate.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_taxonomyTranslate.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _taxonomyTranslate.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_taxonomyTranslate.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_taxonomyTranslate.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_taxonomyTranslate.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TaxonomyTranslateWrapper((TaxonomyTranslate)_taxonomyTranslate.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.TaxonomyTranslate taxonomyTranslate) {
		return _taxonomyTranslate.compareTo(taxonomyTranslate);
	}

	@Override
	public int hashCode() {
		return _taxonomyTranslate.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.TaxonomyTranslate> toCacheModel() {
		return _taxonomyTranslate.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.TaxonomyTranslate toEscapedModel() {
		return new TaxonomyTranslateWrapper(_taxonomyTranslate.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.TaxonomyTranslate toUnescapedModel() {
		return new TaxonomyTranslateWrapper(_taxonomyTranslate.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _taxonomyTranslate.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _taxonomyTranslate.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_taxonomyTranslate.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TaxonomyTranslateWrapper)) {
			return false;
		}

		TaxonomyTranslateWrapper taxonomyTranslateWrapper = (TaxonomyTranslateWrapper)obj;

		if (Validator.equals(_taxonomyTranslate,
					taxonomyTranslateWrapper._taxonomyTranslate)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public TaxonomyTranslate getWrappedTaxonomyTranslate() {
		return _taxonomyTranslate;
	}

	@Override
	public TaxonomyTranslate getWrappedModel() {
		return _taxonomyTranslate;
	}

	@Override
	public void resetOriginalValues() {
		_taxonomyTranslate.resetOriginalValues();
	}

	private TaxonomyTranslate _taxonomyTranslate;
}