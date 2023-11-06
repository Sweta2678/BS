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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link TaxonomyExt}.
 * </p>
 *
 * @author Mummanedi
 * @see TaxonomyExt
 * @generated
 */
public class TaxonomyExtWrapper implements TaxonomyExt,
	ModelWrapper<TaxonomyExt> {
	public TaxonomyExtWrapper(TaxonomyExt taxonomyExt) {
		_taxonomyExt = taxonomyExt;
	}

	@Override
	public Class<?> getModelClass() {
		return TaxonomyExt.class;
	}

	@Override
	public String getModelClassName() {
		return TaxonomyExt.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("taxId", getTaxId());
		attributes.put("parentId", getParentId());
		attributes.put("title", getTitle());
		attributes.put("desc", getDesc());
		attributes.put("imageLoc", getImageLoc());
		attributes.put("lvl", getLvl());
		attributes.put("path", getPath());
		attributes.put("levelSortOrder", getLevelSortOrder());
		attributes.put("indexOrder", getIndexOrder());

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

		String lvl = (String)attributes.get("lvl");

		if (lvl != null) {
			setLvl(lvl);
		}

		String path = (String)attributes.get("path");

		if (path != null) {
			setPath(path);
		}

		Long levelSortOrder = (Long)attributes.get("levelSortOrder");

		if (levelSortOrder != null) {
			setLevelSortOrder(levelSortOrder);
		}

		Long indexOrder = (Long)attributes.get("indexOrder");

		if (indexOrder != null) {
			setIndexOrder(indexOrder);
		}
	}

	/**
	* Returns the primary key of this Custom Query mapping to create index path..
	*
	* @return the primary key of this Custom Query mapping to create index path.
	*/
	@Override
	public long getPrimaryKey() {
		return _taxonomyExt.getPrimaryKey();
	}

	/**
	* Sets the primary key of this Custom Query mapping to create index path..
	*
	* @param primaryKey the primary key of this Custom Query mapping to create index path.
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_taxonomyExt.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the tax ID of this Custom Query mapping to create index path..
	*
	* @return the tax ID of this Custom Query mapping to create index path.
	*/
	@Override
	public long getTaxId() {
		return _taxonomyExt.getTaxId();
	}

	/**
	* Sets the tax ID of this Custom Query mapping to create index path..
	*
	* @param taxId the tax ID of this Custom Query mapping to create index path.
	*/
	@Override
	public void setTaxId(long taxId) {
		_taxonomyExt.setTaxId(taxId);
	}

	/**
	* Returns the parent ID of this Custom Query mapping to create index path..
	*
	* @return the parent ID of this Custom Query mapping to create index path.
	*/
	@Override
	public long getParentId() {
		return _taxonomyExt.getParentId();
	}

	/**
	* Sets the parent ID of this Custom Query mapping to create index path..
	*
	* @param parentId the parent ID of this Custom Query mapping to create index path.
	*/
	@Override
	public void setParentId(long parentId) {
		_taxonomyExt.setParentId(parentId);
	}

	/**
	* Returns the title of this Custom Query mapping to create index path..
	*
	* @return the title of this Custom Query mapping to create index path.
	*/
	@Override
	public java.lang.String getTitle() {
		return _taxonomyExt.getTitle();
	}

	/**
	* Sets the title of this Custom Query mapping to create index path..
	*
	* @param title the title of this Custom Query mapping to create index path.
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_taxonomyExt.setTitle(title);
	}

	/**
	* Returns the desc of this Custom Query mapping to create index path..
	*
	* @return the desc of this Custom Query mapping to create index path.
	*/
	@Override
	public java.lang.String getDesc() {
		return _taxonomyExt.getDesc();
	}

	/**
	* Sets the desc of this Custom Query mapping to create index path..
	*
	* @param desc the desc of this Custom Query mapping to create index path.
	*/
	@Override
	public void setDesc(java.lang.String desc) {
		_taxonomyExt.setDesc(desc);
	}

	/**
	* Returns the image loc of this Custom Query mapping to create index path..
	*
	* @return the image loc of this Custom Query mapping to create index path.
	*/
	@Override
	public java.lang.String getImageLoc() {
		return _taxonomyExt.getImageLoc();
	}

	/**
	* Sets the image loc of this Custom Query mapping to create index path..
	*
	* @param imageLoc the image loc of this Custom Query mapping to create index path.
	*/
	@Override
	public void setImageLoc(java.lang.String imageLoc) {
		_taxonomyExt.setImageLoc(imageLoc);
	}

	/**
	* Returns the lvl of this Custom Query mapping to create index path..
	*
	* @return the lvl of this Custom Query mapping to create index path.
	*/
	@Override
	public java.lang.String getLvl() {
		return _taxonomyExt.getLvl();
	}

	/**
	* Sets the lvl of this Custom Query mapping to create index path..
	*
	* @param lvl the lvl of this Custom Query mapping to create index path.
	*/
	@Override
	public void setLvl(java.lang.String lvl) {
		_taxonomyExt.setLvl(lvl);
	}

	/**
	* Returns the path of this Custom Query mapping to create index path..
	*
	* @return the path of this Custom Query mapping to create index path.
	*/
	@Override
	public java.lang.String getPath() {
		return _taxonomyExt.getPath();
	}

	/**
	* Sets the path of this Custom Query mapping to create index path..
	*
	* @param path the path of this Custom Query mapping to create index path.
	*/
	@Override
	public void setPath(java.lang.String path) {
		_taxonomyExt.setPath(path);
	}

	/**
	* Returns the level sort order of this Custom Query mapping to create index path..
	*
	* @return the level sort order of this Custom Query mapping to create index path.
	*/
	@Override
	public long getLevelSortOrder() {
		return _taxonomyExt.getLevelSortOrder();
	}

	/**
	* Sets the level sort order of this Custom Query mapping to create index path..
	*
	* @param levelSortOrder the level sort order of this Custom Query mapping to create index path.
	*/
	@Override
	public void setLevelSortOrder(long levelSortOrder) {
		_taxonomyExt.setLevelSortOrder(levelSortOrder);
	}

	/**
	* Returns the index order of this Custom Query mapping to create index path..
	*
	* @return the index order of this Custom Query mapping to create index path.
	*/
	@Override
	public long getIndexOrder() {
		return _taxonomyExt.getIndexOrder();
	}

	/**
	* Sets the index order of this Custom Query mapping to create index path..
	*
	* @param indexOrder the index order of this Custom Query mapping to create index path.
	*/
	@Override
	public void setIndexOrder(long indexOrder) {
		_taxonomyExt.setIndexOrder(indexOrder);
	}

	@Override
	public boolean isNew() {
		return _taxonomyExt.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_taxonomyExt.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _taxonomyExt.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_taxonomyExt.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _taxonomyExt.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _taxonomyExt.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_taxonomyExt.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _taxonomyExt.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_taxonomyExt.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_taxonomyExt.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_taxonomyExt.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new TaxonomyExtWrapper((TaxonomyExt)_taxonomyExt.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.TaxonomyExt taxonomyExt) {
		return _taxonomyExt.compareTo(taxonomyExt);
	}

	@Override
	public int hashCode() {
		return _taxonomyExt.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.TaxonomyExt> toCacheModel() {
		return _taxonomyExt.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.TaxonomyExt toEscapedModel() {
		return new TaxonomyExtWrapper(_taxonomyExt.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.TaxonomyExt toUnescapedModel() {
		return new TaxonomyExtWrapper(_taxonomyExt.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _taxonomyExt.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _taxonomyExt.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_taxonomyExt.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof TaxonomyExtWrapper)) {
			return false;
		}

		TaxonomyExtWrapper taxonomyExtWrapper = (TaxonomyExtWrapper)obj;

		if (Validator.equals(_taxonomyExt, taxonomyExtWrapper._taxonomyExt)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public TaxonomyExt getWrappedTaxonomyExt() {
		return _taxonomyExt;
	}

	@Override
	public TaxonomyExt getWrappedModel() {
		return _taxonomyExt;
	}

	@Override
	public void resetOriginalValues() {
		_taxonomyExt.resetOriginalValues();
	}

	private TaxonomyExt _taxonomyExt;
}