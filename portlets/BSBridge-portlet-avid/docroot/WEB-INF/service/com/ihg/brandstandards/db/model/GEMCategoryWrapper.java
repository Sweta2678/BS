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
 * This class is a wrapper for {@link GEMCategory}.
 * </p>
 *
 * @author Mummanedi
 * @see GEMCategory
 * @generated
 */
public class GEMCategoryWrapper implements GEMCategory,
	ModelWrapper<GEMCategory> {
	public GEMCategoryWrapper(GEMCategory gemCategory) {
		_gemCategory = gemCategory;
	}

	@Override
	public Class<?> getModelClass() {
		return GEMCategory.class;
	}

	@Override
	public String getModelClassName() {
		return GEMCategory.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("categoryId", getCategoryId());
		attributes.put("cmsCategoryId", getCmsCategoryId());
		attributes.put("gemCategoryCode", getGemCategoryCode());
		attributes.put("gemPrntCategoryId", getGemPrntCategoryId());
		attributes.put("categoryName", getCategoryName());
		attributes.put("categoryViewType", getCategoryViewType());
		attributes.put("categoryAnsAll", getCategoryAnsAll());
		attributes.put("duplicatable", getDuplicatable());
		attributes.put("displayOrderNumber", getDisplayOrderNumber());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		Long cmsCategoryId = (Long)attributes.get("cmsCategoryId");

		if (cmsCategoryId != null) {
			setCmsCategoryId(cmsCategoryId);
		}

		String gemCategoryCode = (String)attributes.get("gemCategoryCode");

		if (gemCategoryCode != null) {
			setGemCategoryCode(gemCategoryCode);
		}

		String gemPrntCategoryId = (String)attributes.get("gemPrntCategoryId");

		if (gemPrntCategoryId != null) {
			setGemPrntCategoryId(gemPrntCategoryId);
		}

		String categoryName = (String)attributes.get("categoryName");

		if (categoryName != null) {
			setCategoryName(categoryName);
		}

		String categoryViewType = (String)attributes.get("categoryViewType");

		if (categoryViewType != null) {
			setCategoryViewType(categoryViewType);
		}

		String categoryAnsAll = (String)attributes.get("categoryAnsAll");

		if (categoryAnsAll != null) {
			setCategoryAnsAll(categoryAnsAll);
		}

		String duplicatable = (String)attributes.get("duplicatable");

		if (duplicatable != null) {
			setDuplicatable(duplicatable);
		}

		Long displayOrderNumber = (Long)attributes.get("displayOrderNumber");

		if (displayOrderNumber != null) {
			setDisplayOrderNumber(displayOrderNumber);
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
	* Returns the primary key of this g e m category.
	*
	* @return the primary key of this g e m category
	*/
	@Override
	public long getPrimaryKey() {
		return _gemCategory.getPrimaryKey();
	}

	/**
	* Sets the primary key of this g e m category.
	*
	* @param primaryKey the primary key of this g e m category
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_gemCategory.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the category ID of this g e m category.
	*
	* @return the category ID of this g e m category
	*/
	@Override
	public long getCategoryId() {
		return _gemCategory.getCategoryId();
	}

	/**
	* Sets the category ID of this g e m category.
	*
	* @param categoryId the category ID of this g e m category
	*/
	@Override
	public void setCategoryId(long categoryId) {
		_gemCategory.setCategoryId(categoryId);
	}

	/**
	* Returns the cms category ID of this g e m category.
	*
	* @return the cms category ID of this g e m category
	*/
	@Override
	public long getCmsCategoryId() {
		return _gemCategory.getCmsCategoryId();
	}

	/**
	* Sets the cms category ID of this g e m category.
	*
	* @param cmsCategoryId the cms category ID of this g e m category
	*/
	@Override
	public void setCmsCategoryId(long cmsCategoryId) {
		_gemCategory.setCmsCategoryId(cmsCategoryId);
	}

	/**
	* Returns the gem category code of this g e m category.
	*
	* @return the gem category code of this g e m category
	*/
	@Override
	public java.lang.String getGemCategoryCode() {
		return _gemCategory.getGemCategoryCode();
	}

	/**
	* Sets the gem category code of this g e m category.
	*
	* @param gemCategoryCode the gem category code of this g e m category
	*/
	@Override
	public void setGemCategoryCode(java.lang.String gemCategoryCode) {
		_gemCategory.setGemCategoryCode(gemCategoryCode);
	}

	/**
	* Returns the gem prnt category ID of this g e m category.
	*
	* @return the gem prnt category ID of this g e m category
	*/
	@Override
	public java.lang.String getGemPrntCategoryId() {
		return _gemCategory.getGemPrntCategoryId();
	}

	/**
	* Sets the gem prnt category ID of this g e m category.
	*
	* @param gemPrntCategoryId the gem prnt category ID of this g e m category
	*/
	@Override
	public void setGemPrntCategoryId(java.lang.String gemPrntCategoryId) {
		_gemCategory.setGemPrntCategoryId(gemPrntCategoryId);
	}

	/**
	* Returns the category name of this g e m category.
	*
	* @return the category name of this g e m category
	*/
	@Override
	public java.lang.String getCategoryName() {
		return _gemCategory.getCategoryName();
	}

	/**
	* Sets the category name of this g e m category.
	*
	* @param categoryName the category name of this g e m category
	*/
	@Override
	public void setCategoryName(java.lang.String categoryName) {
		_gemCategory.setCategoryName(categoryName);
	}

	/**
	* Returns the category view type of this g e m category.
	*
	* @return the category view type of this g e m category
	*/
	@Override
	public java.lang.String getCategoryViewType() {
		return _gemCategory.getCategoryViewType();
	}

	/**
	* Sets the category view type of this g e m category.
	*
	* @param categoryViewType the category view type of this g e m category
	*/
	@Override
	public void setCategoryViewType(java.lang.String categoryViewType) {
		_gemCategory.setCategoryViewType(categoryViewType);
	}

	/**
	* Returns the category ans all of this g e m category.
	*
	* @return the category ans all of this g e m category
	*/
	@Override
	public java.lang.String getCategoryAnsAll() {
		return _gemCategory.getCategoryAnsAll();
	}

	/**
	* Sets the category ans all of this g e m category.
	*
	* @param categoryAnsAll the category ans all of this g e m category
	*/
	@Override
	public void setCategoryAnsAll(java.lang.String categoryAnsAll) {
		_gemCategory.setCategoryAnsAll(categoryAnsAll);
	}

	/**
	* Returns the duplicatable of this g e m category.
	*
	* @return the duplicatable of this g e m category
	*/
	@Override
	public java.lang.String getDuplicatable() {
		return _gemCategory.getDuplicatable();
	}

	/**
	* Sets the duplicatable of this g e m category.
	*
	* @param duplicatable the duplicatable of this g e m category
	*/
	@Override
	public void setDuplicatable(java.lang.String duplicatable) {
		_gemCategory.setDuplicatable(duplicatable);
	}

	/**
	* Returns the display order number of this g e m category.
	*
	* @return the display order number of this g e m category
	*/
	@Override
	public long getDisplayOrderNumber() {
		return _gemCategory.getDisplayOrderNumber();
	}

	/**
	* Sets the display order number of this g e m category.
	*
	* @param displayOrderNumber the display order number of this g e m category
	*/
	@Override
	public void setDisplayOrderNumber(long displayOrderNumber) {
		_gemCategory.setDisplayOrderNumber(displayOrderNumber);
	}

	/**
	* Returns the creator ID of this g e m category.
	*
	* @return the creator ID of this g e m category
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _gemCategory.getCreatorId();
	}

	/**
	* Sets the creator ID of this g e m category.
	*
	* @param creatorId the creator ID of this g e m category
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_gemCategory.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this g e m category.
	*
	* @return the created date of this g e m category
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _gemCategory.getCreatedDate();
	}

	/**
	* Sets the created date of this g e m category.
	*
	* @param createdDate the created date of this g e m category
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_gemCategory.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this g e m category.
	*
	* @return the updated by of this g e m category
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _gemCategory.getUpdatedBy();
	}

	/**
	* Sets the updated by of this g e m category.
	*
	* @param updatedBy the updated by of this g e m category
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_gemCategory.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this g e m category.
	*
	* @return the updated date of this g e m category
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _gemCategory.getUpdatedDate();
	}

	/**
	* Sets the updated date of this g e m category.
	*
	* @param updatedDate the updated date of this g e m category
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_gemCategory.setUpdatedDate(updatedDate);
	}

	@Override
	public boolean isNew() {
		return _gemCategory.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_gemCategory.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _gemCategory.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_gemCategory.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _gemCategory.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _gemCategory.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_gemCategory.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _gemCategory.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_gemCategory.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_gemCategory.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_gemCategory.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new GEMCategoryWrapper((GEMCategory)_gemCategory.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.GEMCategory gemCategory) {
		return _gemCategory.compareTo(gemCategory);
	}

	@Override
	public int hashCode() {
		return _gemCategory.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.GEMCategory> toCacheModel() {
		return _gemCategory.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.GEMCategory toEscapedModel() {
		return new GEMCategoryWrapper(_gemCategory.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.GEMCategory toUnescapedModel() {
		return new GEMCategoryWrapper(_gemCategory.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _gemCategory.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _gemCategory.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_gemCategory.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GEMCategoryWrapper)) {
			return false;
		}

		GEMCategoryWrapper gemCategoryWrapper = (GEMCategoryWrapper)obj;

		if (Validator.equals(_gemCategory, gemCategoryWrapper._gemCategory)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public GEMCategory getWrappedGEMCategory() {
		return _gemCategory;
	}

	@Override
	public GEMCategory getWrappedModel() {
		return _gemCategory;
	}

	@Override
	public void resetOriginalValues() {
		_gemCategory.resetOriginalValues();
	}

	private GEMCategory _gemCategory;
}