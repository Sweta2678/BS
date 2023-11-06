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
 * This class is a wrapper for {@link UIElement}.
 * </p>
 *
 * @author Mummanedi
 * @see UIElement
 * @generated
 */
public class UIElementWrapper implements UIElement, ModelWrapper<UIElement> {
	public UIElementWrapper(UIElement uiElement) {
		_uiElement = uiElement;
	}

	@Override
	public Class<?> getModelClass() {
		return UIElement.class;
	}

	@Override
	public String getModelClassName() {
		return UIElement.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("elementId", getElementId());
		attributes.put("elementKey", getElementKey());
		attributes.put("moduleName", getModuleName());
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

		String elementKey = (String)attributes.get("elementKey");

		if (elementKey != null) {
			setElementKey(elementKey);
		}

		String moduleName = (String)attributes.get("moduleName");

		if (moduleName != null) {
			setModuleName(moduleName);
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
	* Returns the primary key of this u i element.
	*
	* @return the primary key of this u i element
	*/
	@Override
	public long getPrimaryKey() {
		return _uiElement.getPrimaryKey();
	}

	/**
	* Sets the primary key of this u i element.
	*
	* @param primaryKey the primary key of this u i element
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_uiElement.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the element ID of this u i element.
	*
	* @return the element ID of this u i element
	*/
	@Override
	public long getElementId() {
		return _uiElement.getElementId();
	}

	/**
	* Sets the element ID of this u i element.
	*
	* @param elementId the element ID of this u i element
	*/
	@Override
	public void setElementId(long elementId) {
		_uiElement.setElementId(elementId);
	}

	/**
	* Returns the element key of this u i element.
	*
	* @return the element key of this u i element
	*/
	@Override
	public java.lang.String getElementKey() {
		return _uiElement.getElementKey();
	}

	/**
	* Sets the element key of this u i element.
	*
	* @param elementKey the element key of this u i element
	*/
	@Override
	public void setElementKey(java.lang.String elementKey) {
		_uiElement.setElementKey(elementKey);
	}

	/**
	* Returns the module name of this u i element.
	*
	* @return the module name of this u i element
	*/
	@Override
	public java.lang.String getModuleName() {
		return _uiElement.getModuleName();
	}

	/**
	* Sets the module name of this u i element.
	*
	* @param moduleName the module name of this u i element
	*/
	@Override
	public void setModuleName(java.lang.String moduleName) {
		_uiElement.setModuleName(moduleName);
	}

	/**
	* Returns the creator ID of this u i element.
	*
	* @return the creator ID of this u i element
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _uiElement.getCreatorId();
	}

	/**
	* Sets the creator ID of this u i element.
	*
	* @param creatorId the creator ID of this u i element
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_uiElement.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this u i element.
	*
	* @return the created date of this u i element
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _uiElement.getCreatedDate();
	}

	/**
	* Sets the created date of this u i element.
	*
	* @param createdDate the created date of this u i element
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_uiElement.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this u i element.
	*
	* @return the updated by of this u i element
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _uiElement.getUpdatedBy();
	}

	/**
	* Sets the updated by of this u i element.
	*
	* @param updatedBy the updated by of this u i element
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_uiElement.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this u i element.
	*
	* @return the updated date of this u i element
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _uiElement.getUpdatedDate();
	}

	/**
	* Sets the updated date of this u i element.
	*
	* @param updatedDate the updated date of this u i element
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_uiElement.setUpdatedDate(updatedDate);
	}

	@Override
	public boolean isNew() {
		return _uiElement.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_uiElement.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _uiElement.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_uiElement.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _uiElement.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _uiElement.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_uiElement.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _uiElement.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_uiElement.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_uiElement.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_uiElement.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new UIElementWrapper((UIElement)_uiElement.clone());
	}

	@Override
	public int compareTo(com.ihg.brandstandards.db.model.UIElement uiElement) {
		return _uiElement.compareTo(uiElement);
	}

	@Override
	public int hashCode() {
		return _uiElement.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.UIElement> toCacheModel() {
		return _uiElement.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.UIElement toEscapedModel() {
		return new UIElementWrapper(_uiElement.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.UIElement toUnescapedModel() {
		return new UIElementWrapper(_uiElement.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _uiElement.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _uiElement.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_uiElement.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UIElementWrapper)) {
			return false;
		}

		UIElementWrapper uiElementWrapper = (UIElementWrapper)obj;

		if (Validator.equals(_uiElement, uiElementWrapper._uiElement)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public UIElement getWrappedUIElement() {
		return _uiElement;
	}

	@Override
	public UIElement getWrappedModel() {
		return _uiElement;
	}

	@Override
	public void resetOriginalValues() {
		_uiElement.resetOriginalValues();
	}

	private UIElement _uiElement;
}