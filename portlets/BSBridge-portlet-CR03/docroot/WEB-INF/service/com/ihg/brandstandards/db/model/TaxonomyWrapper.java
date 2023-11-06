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
 * This class is a wrapper for {@link Taxonomy}.
 * </p>
 *
 * @author Mummanedi
 * @see Taxonomy
 * @generated
 */
public class TaxonomyWrapper implements Taxonomy, ModelWrapper<Taxonomy> {
	public TaxonomyWrapper(Taxonomy taxonomy) {
		_taxonomy = taxonomy;
	}

	@Override
	public Class<?> getModelClass() {
		return Taxonomy.class;
	}

	@Override
	public String getModelClassName() {
		return Taxonomy.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("taxId", getTaxId());
		attributes.put("parentId", getParentId());
		attributes.put("title", getTitle());
		attributes.put("desc", getDesc());
		attributes.put("imageLoc", getImageLoc());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("position", getPosition());
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

		Long parentId = (Long)attributes.get("parentId");

		if (parentId != null) {
			setParentId(parentId);
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

		Long position = (Long)attributes.get("position");

		if (position != null) {
			setPosition(position);
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
	* Returns the primary key of this taxonomy.
	*
	* @return the primary key of this taxonomy
	*/
	@Override
	public long getPrimaryKey() {
		return _taxonomy.getPrimaryKey();
	}

	/**
	* Sets the primary key of this taxonomy.
	*
	* @param primaryKey the primary key of this taxonomy
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_taxonomy.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the tax ID of this taxonomy.
	*
	* @return the tax ID of this taxonomy
	*/
	@Override
	public long getTaxId() {
		return _taxonomy.getTaxId();
	}

	/**
	* Sets the tax ID of this taxonomy.
	*
	* @param taxId the tax ID of this taxonomy
	*/
	@Override
	public void setTaxId(long taxId) {
		_taxonomy.setTaxId(taxId);
	}

	/**
	* Returns the parent ID of this taxonomy.
	*
	* @return the parent ID of this taxonomy
	*/
	@Override
	public long getParentId() {
		return _taxonomy.getParentId();
	}

	/**
	* Sets the parent ID of this taxonomy.
	*
	* @param parentId the parent ID of this taxonomy
	*/
	@Override
	public void setParentId(long parentId) {
		_taxonomy.setParentId(parentId);
	}

	/**
	* Returns the title of this taxonomy.
	*
	* @return the title of this taxonomy
	*/
	@Override
	public java.lang.String getTitle() {
		return _taxonomy.getTitle();
	}

	/**
	* Sets the title of this taxonomy.
	*
	* @param title the title of this taxonomy
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_taxonomy.setTitle(title);
	}

	/**
	* Returns the desc of this taxonomy.
	*
	* @return the desc of this taxonomy
	*/
	@Override
	public java.lang.String getDesc() {
		return _taxonomy.getDesc();
	}

	/**
	* Sets the desc of this taxonomy.
	*
	* @param desc the desc of this taxonomy
	*/
	@Override
	public void setDesc(java.lang.String desc) {
		_taxonomy.setDesc(desc);
	}

	/**
	* Returns the image loc of this taxonomy.
	*
	* @return the image loc of this taxonomy
	*/
	@Override
	public java.lang.String getImageLoc() {
		return _taxonomy.getImageLoc();
	}

	/**
	* Sets the image loc of this taxonomy.
	*
	* @param imageLoc the image loc of this taxonomy
	*/
	@Override
	public void setImageLoc(java.lang.String imageLoc) {
		_taxonomy.setImageLoc(imageLoc);
	}

	/**
	* Returns the created by of this taxonomy.
	*
	* @return the created by of this taxonomy
	*/
	@Override
	public java.lang.String getCreatedBy() {
		return _taxonomy.getCreatedBy();
	}

	/**
	* Sets the created by of this taxonomy.
	*
	* @param createdBy the created by of this taxonomy
	*/
	@Override
	public void setCreatedBy(java.lang.String createdBy) {
		_taxonomy.setCreatedBy(createdBy);
	}

	/**
	* Returns the position of this taxonomy.
	*
	* @return the position of this taxonomy
	*/
	@Override
	public long getPosition() {
		return _taxonomy.getPosition();
	}

	/**
	* Sets the position of this taxonomy.
	*
	* @param position the position of this taxonomy
	*/
	@Override
	public void setPosition(long position) {
		_taxonomy.setPosition(position);
	}

	/**
	* Returns the creator ID of this taxonomy.
	*
	* @return the creator ID of this taxonomy
	*/
	@Override
	public java.lang.String getCreatorId() {
		return _taxonomy.getCreatorId();
	}

	/**
	* Sets the creator ID of this taxonomy.
	*
	* @param creatorId the creator ID of this taxonomy
	*/
	@Override
	public void setCreatorId(java.lang.String creatorId) {
		_taxonomy.setCreatorId(creatorId);
	}

	/**
	* Returns the created date of this taxonomy.
	*
	* @return the created date of this taxonomy
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _taxonomy.getCreatedDate();
	}

	/**
	* Sets the created date of this taxonomy.
	*
	* @param createdDate the created date of this taxonomy
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_taxonomy.setCreatedDate(createdDate);
	}

	/**
	* Returns the updated by of this taxonomy.
	*
	* @return the updated by of this taxonomy
	*/
	@Override
	public java.lang.String getUpdatedBy() {
		return _taxonomy.getUpdatedBy();
	}

	/**
	* Sets the updated by of this taxonomy.
	*
	* @param updatedBy the updated by of this taxonomy
	*/
	@Override
	public void setUpdatedBy(java.lang.String updatedBy) {
		_taxonomy.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the updated date of this taxonomy.
	*
	* @return the updated date of this taxonomy
	*/
	@Override
	public java.util.Date getUpdatedDate() {
		return _taxonomy.getUpdatedDate();
	}

	/**
	* Sets the updated date of this taxonomy.
	*
	* @param updatedDate the updated date of this taxonomy
	*/
	@Override
	public void setUpdatedDate(java.util.Date updatedDate) {
		_taxonomy.setUpdatedDate(updatedDate);
	}

	@Override
	public boolean isNew() {
		return _taxonomy.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_taxonomy.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _taxonomy.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_taxonomy.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _taxonomy.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _taxonomy.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_taxonomy.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _taxonomy.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_taxonomy.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_taxonomy.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_taxonomy.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TaxonomyWrapper((Taxonomy)_taxonomy.clone());
	}

	@Override
	public int compareTo(com.ihg.brandstandards.db.model.Taxonomy taxonomy) {
		return _taxonomy.compareTo(taxonomy);
	}

	@Override
	public int hashCode() {
		return _taxonomy.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.Taxonomy> toCacheModel() {
		return _taxonomy.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.Taxonomy toEscapedModel() {
		return new TaxonomyWrapper(_taxonomy.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.Taxonomy toUnescapedModel() {
		return new TaxonomyWrapper(_taxonomy.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _taxonomy.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _taxonomy.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_taxonomy.persist();
	}

	@Override
	public java.lang.String getPath() {
		return _taxonomy.getPath();
	}

	@Override
	public void setPath(java.lang.String path) {
		_taxonomy.setPath(path);
	}

	@Override
	public java.lang.String getLvl() {
		return _taxonomy.getLvl();
	}

	@Override
	public void setLvl(java.lang.String lvl) {
		_taxonomy.setLvl(lvl);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TaxonomyWrapper)) {
			return false;
		}

		TaxonomyWrapper taxonomyWrapper = (TaxonomyWrapper)obj;

		if (Validator.equals(_taxonomy, taxonomyWrapper._taxonomy)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Taxonomy getWrappedTaxonomy() {
		return _taxonomy;
	}

	@Override
	public Taxonomy getWrappedModel() {
		return _taxonomy;
	}

	@Override
	public void resetOriginalValues() {
		_taxonomy.resetOriginalValues();
	}

	private Taxonomy _taxonomy;
}