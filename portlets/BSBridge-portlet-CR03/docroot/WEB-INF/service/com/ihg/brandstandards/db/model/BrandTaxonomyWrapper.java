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
 * This class is a wrapper for {@link BrandTaxonomy}.
 * </p>
 *
 * @author Mummanedi
 * @see BrandTaxonomy
 * @generated
 */
public class BrandTaxonomyWrapper implements BrandTaxonomy,
	ModelWrapper<BrandTaxonomy> {
	public BrandTaxonomyWrapper(BrandTaxonomy brandTaxonomy) {
		_brandTaxonomy = brandTaxonomy;
	}

	@Override
	public Class<?> getModelClass() {
		return BrandTaxonomy.class;
	}

	@Override
	public String getModelClassName() {
		return BrandTaxonomy.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("taxId", getTaxId());
		attributes.put("chain", getChain());
		attributes.put("title", getTitle());
		attributes.put("desc", getDesc());
		attributes.put("imageLoc", getImageLoc());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long taxId = (Long)attributes.get("taxId");

		if (taxId != null) {
			setTaxId(taxId);
		}

		String chain = (String)attributes.get("chain");

		if (chain != null) {
			setChain(chain);
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

		String createdBy = (String)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
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
	* Returns the primary key of this brand taxonomy.
	*
	* @return the primary key of this brand taxonomy
	*/
	@Override
	public long getPrimaryKey() {
		return _brandTaxonomy.getPrimaryKey();
	}

	/**
	* Sets the primary key of this brand taxonomy.
	*
	* @param primaryKey the primary key of this brand taxonomy
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_brandTaxonomy.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ID of this brand taxonomy.
	*
	* @return the ID of this brand taxonomy
	*/
	@Override
	public long getId() {
		return _brandTaxonomy.getId();
	}

	/**
	* Sets the ID of this brand taxonomy.
	*
	* @param id the ID of this brand taxonomy
	*/
	@Override
	public void setId(long id) {
		_brandTaxonomy.setId(id);
	}

	/**
	* Returns the tax ID of this brand taxonomy.
	*
	* @return the tax ID of this brand taxonomy
	*/
	@Override
	public long getTaxId() {
		return _brandTaxonomy.getTaxId();
	}

	/**
	* Sets the tax ID of this brand taxonomy.
	*
	* @param taxId the tax ID of this brand taxonomy
	*/
	@Override
	public void setTaxId(long taxId) {
		_brandTaxonomy.setTaxId(taxId);
	}

	/**
	* Returns the chain of this brand taxonomy.
	*
	* @return the chain of this brand taxonomy
	*/
	@Override
	public java.lang.String getChain() {
		return _brandTaxonomy.getChain();
	}

	/**
	* Sets the chain of this brand taxonomy.
	*
	* @param chain the chain of this brand taxonomy
	*/
	@Override
	public void setChain(java.lang.String chain) {
		_brandTaxonomy.setChain(chain);
	}

	/**
	* Returns the title of this brand taxonomy.
	*
	* @return the title of this brand taxonomy
	*/
	@Override
	public java.lang.String getTitle() {
		return _brandTaxonomy.getTitle();
	}

	/**
	* Sets the title of this brand taxonomy.
	*
	* @param title the title of this brand taxonomy
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_brandTaxonomy.setTitle(title);
	}

	/**
	* Returns the desc of this brand taxonomy.
	*
	* @return the desc of this brand taxonomy
	*/
	@Override
	public java.lang.String getDesc() {
		return _brandTaxonomy.getDesc();
	}

	/**
	* Sets the desc of this brand taxonomy.
	*
	* @param desc the desc of this brand taxonomy
	*/
	@Override
	public void setDesc(java.lang.String desc) {
		_brandTaxonomy.setDesc(desc);
	}

	/**
	* Returns the image loc of this brand taxonomy.
	*
	* @return the image loc of this brand taxonomy
	*/
	@Override
	public java.lang.String getImageLoc() {
		return _brandTaxonomy.getImageLoc();
	}

	/**
	* Sets the image loc of this brand taxonomy.
	*
	* @param imageLoc the image loc of this brand taxonomy
	*/
	@Override
	public void setImageLoc(java.lang.String imageLoc) {
		_brandTaxonomy.setImageLoc(imageLoc);
	}

	/**
	* Returns the created by of this brand taxonomy.
	*
	* @return the created by of this brand taxonomy
	*/
	@Override
	public java.lang.String getCreatedBy() {
		return _brandTaxonomy.getCreatedBy();
	}

	/**
	* Sets the created by of this brand taxonomy.
	*
	* @param createdBy the created by of this brand taxonomy
	*/
	@Override
	public void setCreatedBy(java.lang.String createdBy) {
		_brandTaxonomy.setCreatedBy(createdBy);
	}

	/**
	* Returns the creator ID of this brand taxonomy.
	*
	* @return the creator ID of this brand taxonomy
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _brandTaxonomy.getCreatorId();
	}

	/**
	* Sets the creator ID of this brand taxonomy.
	*
	* @param creatorId the creator ID of this brand taxonomy
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_brandTaxonomy.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this brand taxonomy.
	*
	* @return the created date of this brand taxonomy
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _brandTaxonomy.getCreatedDate();
	}

	/**
	* Sets the created date of this brand taxonomy.
	*
	* @param createdDate the created date of this brand taxonomy
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_brandTaxonomy.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this brand taxonomy.
	*
	* @return the updated by of this brand taxonomy
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _brandTaxonomy.getUpdatedBy();
	}

	/**
	* Sets the updated by of this brand taxonomy.
	*
	* @param updatedBy the updated by of this brand taxonomy
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_brandTaxonomy.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this brand taxonomy.
	*
	* @return the updated date of this brand taxonomy
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _brandTaxonomy.getUpdatedDate();
	}

	/**
	* Sets the updated date of this brand taxonomy.
	*
	* @param updatedDate the updated date of this brand taxonomy
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_brandTaxonomy.setUpdatedDate(updatedDate);
	}

	@Override
	public boolean isNew() {
		return _brandTaxonomy.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_brandTaxonomy.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _brandTaxonomy.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_brandTaxonomy.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _brandTaxonomy.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _brandTaxonomy.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_brandTaxonomy.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _brandTaxonomy.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_brandTaxonomy.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_brandTaxonomy.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_brandTaxonomy.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BrandTaxonomyWrapper((BrandTaxonomy)_brandTaxonomy.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.BrandTaxonomy brandTaxonomy) {
		return _brandTaxonomy.compareTo(brandTaxonomy);
	}

	@Override
	public int hashCode() {
		return _brandTaxonomy.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.BrandTaxonomy> toCacheModel() {
		return _brandTaxonomy.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.BrandTaxonomy toEscapedModel() {
		return new BrandTaxonomyWrapper(_brandTaxonomy.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.BrandTaxonomy toUnescapedModel() {
		return new BrandTaxonomyWrapper(_brandTaxonomy.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _brandTaxonomy.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _brandTaxonomy.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_brandTaxonomy.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BrandTaxonomyWrapper)) {
			return false;
		}

		BrandTaxonomyWrapper brandTaxonomyWrapper = (BrandTaxonomyWrapper)obj;

		if (Validator.equals(_brandTaxonomy, brandTaxonomyWrapper._brandTaxonomy)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public BrandTaxonomy getWrappedBrandTaxonomy() {
		return _brandTaxonomy;
	}

	@Override
	public BrandTaxonomy getWrappedModel() {
		return _brandTaxonomy;
	}

	@Override
	public void resetOriginalValues() {
		_brandTaxonomy.resetOriginalValues();
	}

	private BrandTaxonomy _brandTaxonomy;
}