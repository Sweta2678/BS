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
 * This class is a wrapper for {@link FlagCategory}.
 * </p>
 *
 * @author Mummanedi
 * @see FlagCategory
 * @generated
 */
public class FlagCategoryWrapper implements FlagCategory,
	ModelWrapper<FlagCategory> {
	public FlagCategoryWrapper(FlagCategory flagCategory) {
		_flagCategory = flagCategory;
	}

	@Override
	public Class<?> getModelClass() {
		return FlagCategory.class;
	}

	@Override
	public String getModelClassName() {
		return FlagCategory.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("flagCatId", getFlagCatId());
		attributes.put("activeInd", getActiveInd());
		attributes.put("parentCatId", getParentCatId());
		attributes.put("catOrField", getCatOrField());
		attributes.put("txtValue", getTxtValue());
		attributes.put("orderNumber", getOrderNumber());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long flagCatId = (Long)attributes.get("flagCatId");

		if (flagCatId != null) {
			setFlagCatId(flagCatId);
		}

		String activeInd = (String)attributes.get("activeInd");

		if (activeInd != null) {
			setActiveInd(activeInd);
		}

		Long parentCatId = (Long)attributes.get("parentCatId");

		if (parentCatId != null) {
			setParentCatId(parentCatId);
		}

		String catOrField = (String)attributes.get("catOrField");

		if (catOrField != null) {
			setCatOrField(catOrField);
		}

		String txtValue = (String)attributes.get("txtValue");

		if (txtValue != null) {
			setTxtValue(txtValue);
		}

		Long orderNumber = (Long)attributes.get("orderNumber");

		if (orderNumber != null) {
			setOrderNumber(orderNumber);
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
	* Returns the primary key of this flag category.
	*
	* @return the primary key of this flag category
	*/
	@Override
	public com.ihg.brandstandards.db.service.persistence.FlagCategoryPK getPrimaryKey() {
		return _flagCategory.getPrimaryKey();
	}

	/**
	* Sets the primary key of this flag category.
	*
	* @param primaryKey the primary key of this flag category
	*/
	@Override
	public void setPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.FlagCategoryPK primaryKey) {
		_flagCategory.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the flag cat ID of this flag category.
	*
	* @return the flag cat ID of this flag category
	*/
	@Override
	public long getFlagCatId() {
		return _flagCategory.getFlagCatId();
	}

	/**
	* Sets the flag cat ID of this flag category.
	*
	* @param flagCatId the flag cat ID of this flag category
	*/
	@Override
	public void setFlagCatId(long flagCatId) {
		_flagCategory.setFlagCatId(flagCatId);
	}

	/**
	* Returns the active ind of this flag category.
	*
	* @return the active ind of this flag category
	*/
	@Override
	public java.lang.String getActiveInd() {
		return _flagCategory.getActiveInd();
	}

	/**
	* Sets the active ind of this flag category.
	*
	* @param activeInd the active ind of this flag category
	*/
	@Override
	public void setActiveInd(java.lang.String activeInd) {
		_flagCategory.setActiveInd(activeInd);
	}

	/**
	* Returns the parent cat ID of this flag category.
	*
	* @return the parent cat ID of this flag category
	*/
	@Override
	public long getParentCatId() {
		return _flagCategory.getParentCatId();
	}

	/**
	* Sets the parent cat ID of this flag category.
	*
	* @param parentCatId the parent cat ID of this flag category
	*/
	@Override
	public void setParentCatId(long parentCatId) {
		_flagCategory.setParentCatId(parentCatId);
	}

	/**
	* Returns the cat or field of this flag category.
	*
	* @return the cat or field of this flag category
	*/
	@Override
	public java.lang.String getCatOrField() {
		return _flagCategory.getCatOrField();
	}

	/**
	* Sets the cat or field of this flag category.
	*
	* @param catOrField the cat or field of this flag category
	*/
	@Override
	public void setCatOrField(java.lang.String catOrField) {
		_flagCategory.setCatOrField(catOrField);
	}

	/**
	* Returns the txt value of this flag category.
	*
	* @return the txt value of this flag category
	*/
	@Override
	public java.lang.String getTxtValue() {
		return _flagCategory.getTxtValue();
	}

	/**
	* Sets the txt value of this flag category.
	*
	* @param txtValue the txt value of this flag category
	*/
	@Override
	public void setTxtValue(java.lang.String txtValue) {
		_flagCategory.setTxtValue(txtValue);
	}

	/**
	* Returns the order number of this flag category.
	*
	* @return the order number of this flag category
	*/
	@Override
	public long getOrderNumber() {
		return _flagCategory.getOrderNumber();
	}

	/**
	* Sets the order number of this flag category.
	*
	* @param orderNumber the order number of this flag category
	*/
	@Override
	public void setOrderNumber(long orderNumber) {
		_flagCategory.setOrderNumber(orderNumber);
	}

	/**
	* Returns the creator ID of this flag category.
	*
	* @return the creator ID of this flag category
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _flagCategory.getCreatorId();
	}

	/**
	* Sets the creator ID of this flag category.
	*
	* @param creatorId the creator ID of this flag category
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_flagCategory.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this flag category.
	*
	* @return the created date of this flag category
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _flagCategory.getCreatedDate();
	}

	/**
	* Sets the created date of this flag category.
	*
	* @param createdDate the created date of this flag category
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_flagCategory.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this flag category.
	*
	* @return the updated by of this flag category
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _flagCategory.getUpdatedBy();
	}

	/**
	* Sets the updated by of this flag category.
	*
	* @param updatedBy the updated by of this flag category
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_flagCategory.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this flag category.
	*
	* @return the updated date of this flag category
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _flagCategory.getUpdatedDate();
	}

	/**
	* Sets the updated date of this flag category.
	*
	* @param updatedDate the updated date of this flag category
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_flagCategory.setUpdatedDate(updatedDate);
	}

	@Override
	public boolean isNew() {
		return _flagCategory.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_flagCategory.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _flagCategory.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_flagCategory.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _flagCategory.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _flagCategory.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_flagCategory.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _flagCategory.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_flagCategory.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_flagCategory.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_flagCategory.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FlagCategoryWrapper((FlagCategory)_flagCategory.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.FlagCategory flagCategory) {
		return _flagCategory.compareTo(flagCategory);
	}

	@Override
	public int hashCode() {
		return _flagCategory.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.FlagCategory> toCacheModel() {
		return _flagCategory.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.FlagCategory toEscapedModel() {
		return new FlagCategoryWrapper(_flagCategory.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.FlagCategory toUnescapedModel() {
		return new FlagCategoryWrapper(_flagCategory.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _flagCategory.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _flagCategory.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_flagCategory.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FlagCategoryWrapper)) {
			return false;
		}

		FlagCategoryWrapper flagCategoryWrapper = (FlagCategoryWrapper)obj;

		if (Validator.equals(_flagCategory, flagCategoryWrapper._flagCategory)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public FlagCategory getWrappedFlagCategory() {
		return _flagCategory;
	}

	@Override
	public FlagCategory getWrappedModel() {
		return _flagCategory;
	}

	@Override
	public void resetOriginalValues() {
		_flagCategory.resetOriginalValues();
	}

	private FlagCategory _flagCategory;
}