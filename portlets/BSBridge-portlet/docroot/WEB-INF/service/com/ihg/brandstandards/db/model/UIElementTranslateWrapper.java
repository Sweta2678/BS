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
 * This class is a wrapper for {@link UIElementTranslate}.
 * </p>
 *
 * @author Mummanedi
 * @see UIElementTranslate
 * @generated
 */
public class UIElementTranslateWrapper implements UIElementTranslate,
	ModelWrapper<UIElementTranslate> {
	public UIElementTranslateWrapper(UIElementTranslate uiElementTranslate) {
		_uiElementTranslate = uiElementTranslate;
	}

	@Override
	public Class<?> getModelClass() {
		return UIElementTranslate.class;
	}

	@Override
	public String getModelClassName() {
		return UIElementTranslate.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("elementId", getElementId());
		attributes.put("localeCode", getLocaleCode());
		attributes.put("elementValue", getElementValue());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long elementId = (Long)attributes.get("elementId");

		if (elementId != null) {
			setElementId(elementId);
		}

		String localeCode = (String)attributes.get("localeCode");

		if (localeCode != null) {
			setLocaleCode(localeCode);
		}

		String elementValue = (String)attributes.get("elementValue");

		if (elementValue != null) {
			setElementValue(elementValue);
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
	* Returns the primary key of this u i element translate.
	*
	* @return the primary key of this u i element translate
	*/
	@Override
	public com.ihg.brandstandards.db.service.persistence.UIElementTranslatePK getPrimaryKey() {
		return _uiElementTranslate.getPrimaryKey();
	}

	/**
	* Sets the primary key of this u i element translate.
	*
	* @param primaryKey the primary key of this u i element translate
	*/
	@Override
	public void setPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.UIElementTranslatePK primaryKey) {
		_uiElementTranslate.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the element ID of this u i element translate.
	*
	* @return the element ID of this u i element translate
	*/
	@Override
	public long getElementId() {
		return _uiElementTranslate.getElementId();
	}

	/**
	* Sets the element ID of this u i element translate.
	*
	* @param elementId the element ID of this u i element translate
	*/
	@Override
	public void setElementId(long elementId) {
		_uiElementTranslate.setElementId(elementId);
	}

	/**
	* Returns the locale code of this u i element translate.
	*
	* @return the locale code of this u i element translate
	*/
	@Override
	public java.lang.String getLocaleCode() {
		return _uiElementTranslate.getLocaleCode();
	}

	/**
	* Sets the locale code of this u i element translate.
	*
	* @param localeCode the locale code of this u i element translate
	*/
	@Override
	public void setLocaleCode(java.lang.String localeCode) {
		_uiElementTranslate.setLocaleCode(localeCode);
	}

	/**
	* Returns the element value of this u i element translate.
	*
	* @return the element value of this u i element translate
	*/
	@Override
	public java.lang.String getElementValue() {
		return _uiElementTranslate.getElementValue();
	}

	/**
	* Sets the element value of this u i element translate.
	*
	* @param elementValue the element value of this u i element translate
	*/
	@Override
	public void setElementValue(java.lang.String elementValue) {
		_uiElementTranslate.setElementValue(elementValue);
	}

	/**
	* Returns the creator ID of this u i element translate.
	*
	* @return the creator ID of this u i element translate
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _uiElementTranslate.getCreatorId();
	}

	/**
	* Sets the creator ID of this u i element translate.
	*
	* @param creatorId the creator ID of this u i element translate
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_uiElementTranslate.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this u i element translate.
	*
	* @return the created date of this u i element translate
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _uiElementTranslate.getCreatedDate();
	}

	/**
	* Sets the created date of this u i element translate.
	*
	* @param createdDate the created date of this u i element translate
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_uiElementTranslate.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this u i element translate.
	*
	* @return the updated by of this u i element translate
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _uiElementTranslate.getUpdatedBy();
	}

	/**
	* Sets the updated by of this u i element translate.
	*
	* @param updatedBy the updated by of this u i element translate
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_uiElementTranslate.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this u i element translate.
	*
	* @return the updated date of this u i element translate
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _uiElementTranslate.getUpdatedDate();
	}

	/**
	* Sets the updated date of this u i element translate.
	*
	* @param updatedDate the updated date of this u i element translate
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_uiElementTranslate.setUpdatedDate(updatedDate);
	}

	@Override
	public boolean isNew() {
		return _uiElementTranslate.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_uiElementTranslate.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _uiElementTranslate.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_uiElementTranslate.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _uiElementTranslate.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _uiElementTranslate.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_uiElementTranslate.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _uiElementTranslate.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_uiElementTranslate.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_uiElementTranslate.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_uiElementTranslate.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new UIElementTranslateWrapper((UIElementTranslate)_uiElementTranslate.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.UIElementTranslate uiElementTranslate) {
		return _uiElementTranslate.compareTo(uiElementTranslate);
	}

	@Override
	public int hashCode() {
		return _uiElementTranslate.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.UIElementTranslate> toCacheModel() {
		return _uiElementTranslate.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.UIElementTranslate toEscapedModel() {
		return new UIElementTranslateWrapper(_uiElementTranslate.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.UIElementTranslate toUnescapedModel() {
		return new UIElementTranslateWrapper(_uiElementTranslate.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _uiElementTranslate.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _uiElementTranslate.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_uiElementTranslate.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UIElementTranslateWrapper)) {
			return false;
		}

		UIElementTranslateWrapper uiElementTranslateWrapper = (UIElementTranslateWrapper)obj;

		if (Validator.equals(_uiElementTranslate,
					uiElementTranslateWrapper._uiElementTranslate)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public UIElementTranslate getWrappedUIElementTranslate() {
		return _uiElementTranslate;
	}

	@Override
	public UIElementTranslate getWrappedModel() {
		return _uiElementTranslate;
	}

	@Override
	public void resetOriginalValues() {
		_uiElementTranslate.resetOriginalValues();
	}

	private UIElementTranslate _uiElementTranslate;
}