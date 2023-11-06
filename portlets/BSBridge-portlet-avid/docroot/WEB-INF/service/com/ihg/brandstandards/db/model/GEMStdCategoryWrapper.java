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
 * This class is a wrapper for {@link GEMStdCategory}.
 * </p>
 *
 * @author Mummanedi
 * @see GEMStdCategory
 * @generated
 */
public class GEMStdCategoryWrapper implements GEMStdCategory,
	ModelWrapper<GEMStdCategory> {
	public GEMStdCategoryWrapper(GEMStdCategory gemStdCategory) {
		_gemStdCategory = gemStdCategory;
	}

	@Override
	public Class<?> getModelClass() {
		return GEMStdCategory.class;
	}

	@Override
	public String getModelClassName() {
		return GEMStdCategory.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("gemStdCategoryId", getGemStdCategoryId());
		attributes.put("stdId", getStdId());
		attributes.put("categoryId", getCategoryId());
		attributes.put("templateType", getTemplateType());
		attributes.put("chainCode", getChainCode());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long gemStdCategoryId = (Long)attributes.get("gemStdCategoryId");

		if (gemStdCategoryId != null) {
			setGemStdCategoryId(gemStdCategoryId);
		}

		Long stdId = (Long)attributes.get("stdId");

		if (stdId != null) {
			setStdId(stdId);
		}

		Long categoryId = (Long)attributes.get("categoryId");

		if (categoryId != null) {
			setCategoryId(categoryId);
		}

		String templateType = (String)attributes.get("templateType");

		if (templateType != null) {
			setTemplateType(templateType);
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
	* Returns the primary key of this g e m std category.
	*
	* @return the primary key of this g e m std category
	*/
	@Override
	public long getPrimaryKey() {
		return _gemStdCategory.getPrimaryKey();
	}

	/**
	* Sets the primary key of this g e m std category.
	*
	* @param primaryKey the primary key of this g e m std category
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_gemStdCategory.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the gem std category ID of this g e m std category.
	*
	* @return the gem std category ID of this g e m std category
	*/
	@Override
	public long getGemStdCategoryId() {
		return _gemStdCategory.getGemStdCategoryId();
	}

	/**
	* Sets the gem std category ID of this g e m std category.
	*
	* @param gemStdCategoryId the gem std category ID of this g e m std category
	*/
	@Override
	public void setGemStdCategoryId(long gemStdCategoryId) {
		_gemStdCategory.setGemStdCategoryId(gemStdCategoryId);
	}

	/**
	* Returns the std ID of this g e m std category.
	*
	* @return the std ID of this g e m std category
	*/
	@Override
	public long getStdId() {
		return _gemStdCategory.getStdId();
	}

	/**
	* Sets the std ID of this g e m std category.
	*
	* @param stdId the std ID of this g e m std category
	*/
	@Override
	public void setStdId(long stdId) {
		_gemStdCategory.setStdId(stdId);
	}

	/**
	* Returns the category ID of this g e m std category.
	*
	* @return the category ID of this g e m std category
	*/
	@Override
	public long getCategoryId() {
		return _gemStdCategory.getCategoryId();
	}

	/**
	* Sets the category ID of this g e m std category.
	*
	* @param categoryId the category ID of this g e m std category
	*/
	@Override
	public void setCategoryId(long categoryId) {
		_gemStdCategory.setCategoryId(categoryId);
	}

	/**
	* Returns the template type of this g e m std category.
	*
	* @return the template type of this g e m std category
	*/
	@Override
	public java.lang.String getTemplateType() {
		return _gemStdCategory.getTemplateType();
	}

	/**
	* Sets the template type of this g e m std category.
	*
	* @param templateType the template type of this g e m std category
	*/
	@Override
	public void setTemplateType(java.lang.String templateType) {
		_gemStdCategory.setTemplateType(templateType);
	}

	/**
	* Returns the chain code of this g e m std category.
	*
	* @return the chain code of this g e m std category
	*/
	@Override
	public java.lang.String getChainCode() {
		return _gemStdCategory.getChainCode();
	}

	/**
	* Sets the chain code of this g e m std category.
	*
	* @param chainCode the chain code of this g e m std category
	*/
	@Override
	public void setChainCode(java.lang.String chainCode) {
		_gemStdCategory.setChainCode(chainCode);
	}

	/**
	* Returns the creator ID of this g e m std category.
	*
	* @return the creator ID of this g e m std category
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _gemStdCategory.getCreatorId();
	}

	/**
	* Sets the creator ID of this g e m std category.
	*
	* @param creatorId the creator ID of this g e m std category
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_gemStdCategory.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this g e m std category.
	*
	* @return the created date of this g e m std category
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _gemStdCategory.getCreatedDate();
	}

	/**
	* Sets the created date of this g e m std category.
	*
	* @param createdDate the created date of this g e m std category
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_gemStdCategory.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this g e m std category.
	*
	* @return the updated by of this g e m std category
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _gemStdCategory.getUpdatedBy();
	}

	/**
	* Sets the updated by of this g e m std category.
	*
	* @param updatedBy the updated by of this g e m std category
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_gemStdCategory.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this g e m std category.
	*
	* @return the updated date of this g e m std category
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _gemStdCategory.getUpdatedDate();
	}

	/**
	* Sets the updated date of this g e m std category.
	*
	* @param updatedDate the updated date of this g e m std category
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_gemStdCategory.setUpdatedDate(updatedDate);
	}

	@Override
	public boolean isNew() {
		return _gemStdCategory.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_gemStdCategory.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _gemStdCategory.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_gemStdCategory.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _gemStdCategory.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _gemStdCategory.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_gemStdCategory.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _gemStdCategory.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_gemStdCategory.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_gemStdCategory.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_gemStdCategory.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new GEMStdCategoryWrapper((GEMStdCategory)_gemStdCategory.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.GEMStdCategory gemStdCategory) {
		return _gemStdCategory.compareTo(gemStdCategory);
	}

	@Override
	public int hashCode() {
		return _gemStdCategory.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.GEMStdCategory> toCacheModel() {
		return _gemStdCategory.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.GEMStdCategory toEscapedModel() {
		return new GEMStdCategoryWrapper(_gemStdCategory.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.GEMStdCategory toUnescapedModel() {
		return new GEMStdCategoryWrapper(_gemStdCategory.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _gemStdCategory.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _gemStdCategory.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_gemStdCategory.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GEMStdCategoryWrapper)) {
			return false;
		}

		GEMStdCategoryWrapper gemStdCategoryWrapper = (GEMStdCategoryWrapper)obj;

		if (Validator.equals(_gemStdCategory,
					gemStdCategoryWrapper._gemStdCategory)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public GEMStdCategory getWrappedGEMStdCategory() {
		return _gemStdCategory;
	}

	@Override
	public GEMStdCategory getWrappedModel() {
		return _gemStdCategory;
	}

	@Override
	public void resetOriginalValues() {
		_gemStdCategory.resetOriginalValues();
	}

	private GEMStdCategory _gemStdCategory;
}