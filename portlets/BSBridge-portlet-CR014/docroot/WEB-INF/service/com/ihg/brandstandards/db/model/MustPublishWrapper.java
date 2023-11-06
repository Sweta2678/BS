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
 * This class is a wrapper for {@link MustPublish}.
 * </p>
 *
 * @author Mummanedi
 * @see MustPublish
 * @generated
 */
public class MustPublishWrapper implements MustPublish,
	ModelWrapper<MustPublish> {
	public MustPublishWrapper(MustPublish mustPublish) {
		_mustPublish = mustPublish;
	}

	@Override
	public Class<?> getModelClass() {
		return MustPublish.class;
	}

	@Override
	public String getModelClassName() {
		return MustPublish.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("parentId", getParentId());
		attributes.put("stdId", getStdId());
		attributes.put("title", getTitle());
		attributes.put("stdType", getStdType());
		attributes.put("path", getPath());
		attributes.put("currentPath", getCurrentPath());
		attributes.put("regionCode", getRegionCode());
		attributes.put("amer", getAmer());
		attributes.put("amea", getAmea());
		attributes.put("euro", getEuro());
		attributes.put("gc", getGc());
		attributes.put("status", getStatus());
		attributes.put("displayOrder", getDisplayOrder());
		attributes.put("taxonomyId", getTaxonomyId());
		attributes.put("parentTaxonomyId", getParentTaxonomyId());
		attributes.put("indexOrder", getIndexOrder());
		attributes.put("level", getLevel());
		attributes.put("levelSortOrder", getLevelSortOrder());
		attributes.put("isGlobal", getIsGlobal());
		attributes.put("framework", getFramework());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long parentId = (Long)attributes.get("parentId");

		if (parentId != null) {
			setParentId(parentId);
		}

		Long stdId = (Long)attributes.get("stdId");

		if (stdId != null) {
			setStdId(stdId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String stdType = (String)attributes.get("stdType");

		if (stdType != null) {
			setStdType(stdType);
		}

		String path = (String)attributes.get("path");

		if (path != null) {
			setPath(path);
		}

		String currentPath = (String)attributes.get("currentPath");

		if (currentPath != null) {
			setCurrentPath(currentPath);
		}

		String regionCode = (String)attributes.get("regionCode");

		if (regionCode != null) {
			setRegionCode(regionCode);
		}

		String amer = (String)attributes.get("amer");

		if (amer != null) {
			setAmer(amer);
		}

		String amea = (String)attributes.get("amea");

		if (amea != null) {
			setAmea(amea);
		}

		String euro = (String)attributes.get("euro");

		if (euro != null) {
			setEuro(euro);
		}

		String gc = (String)attributes.get("gc");

		if (gc != null) {
			setGc(gc);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long displayOrder = (Long)attributes.get("displayOrder");

		if (displayOrder != null) {
			setDisplayOrder(displayOrder);
		}

		Long taxonomyId = (Long)attributes.get("taxonomyId");

		if (taxonomyId != null) {
			setTaxonomyId(taxonomyId);
		}

		Long parentTaxonomyId = (Long)attributes.get("parentTaxonomyId");

		if (parentTaxonomyId != null) {
			setParentTaxonomyId(parentTaxonomyId);
		}

		Long indexOrder = (Long)attributes.get("indexOrder");

		if (indexOrder != null) {
			setIndexOrder(indexOrder);
		}

		Long level = (Long)attributes.get("level");

		if (level != null) {
			setLevel(level);
		}

		Long levelSortOrder = (Long)attributes.get("levelSortOrder");

		if (levelSortOrder != null) {
			setLevelSortOrder(levelSortOrder);
		}

		String isGlobal = (String)attributes.get("isGlobal");

		if (isGlobal != null) {
			setIsGlobal(isGlobal);
		}

		String framework = (String)attributes.get("framework");

		if (framework != null) {
			setFramework(framework);
		}
	}

	/**
	* Returns the primary key of this must publish.
	*
	* @return the primary key of this must publish
	*/
	@Override
	public long getPrimaryKey() {
		return _mustPublish.getPrimaryKey();
	}

	/**
	* Sets the primary key of this must publish.
	*
	* @param primaryKey the primary key of this must publish
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_mustPublish.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the parent ID of this must publish.
	*
	* @return the parent ID of this must publish
	*/
	@Override
	public long getParentId() {
		return _mustPublish.getParentId();
	}

	/**
	* Sets the parent ID of this must publish.
	*
	* @param parentId the parent ID of this must publish
	*/
	@Override
	public void setParentId(long parentId) {
		_mustPublish.setParentId(parentId);
	}

	/**
	* Returns the std ID of this must publish.
	*
	* @return the std ID of this must publish
	*/
	@Override
	public long getStdId() {
		return _mustPublish.getStdId();
	}

	/**
	* Sets the std ID of this must publish.
	*
	* @param stdId the std ID of this must publish
	*/
	@Override
	public void setStdId(long stdId) {
		_mustPublish.setStdId(stdId);
	}

	/**
	* Returns the title of this must publish.
	*
	* @return the title of this must publish
	*/
	@Override
	public java.lang.String getTitle() {
		return _mustPublish.getTitle();
	}

	/**
	* Sets the title of this must publish.
	*
	* @param title the title of this must publish
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_mustPublish.setTitle(title);
	}

	/**
	* Returns the std type of this must publish.
	*
	* @return the std type of this must publish
	*/
	@Override
	public java.lang.String getStdType() {
		return _mustPublish.getStdType();
	}

	/**
	* Sets the std type of this must publish.
	*
	* @param stdType the std type of this must publish
	*/
	@Override
	public void setStdType(java.lang.String stdType) {
		_mustPublish.setStdType(stdType);
	}

	/**
	* Returns the path of this must publish.
	*
	* @return the path of this must publish
	*/
	@Override
	public java.lang.String getPath() {
		return _mustPublish.getPath();
	}

	/**
	* Sets the path of this must publish.
	*
	* @param path the path of this must publish
	*/
	@Override
	public void setPath(java.lang.String path) {
		_mustPublish.setPath(path);
	}

	/**
	* Returns the current path of this must publish.
	*
	* @return the current path of this must publish
	*/
	@Override
	public java.lang.String getCurrentPath() {
		return _mustPublish.getCurrentPath();
	}

	/**
	* Sets the current path of this must publish.
	*
	* @param currentPath the current path of this must publish
	*/
	@Override
	public void setCurrentPath(java.lang.String currentPath) {
		_mustPublish.setCurrentPath(currentPath);
	}

	/**
	* Returns the region code of this must publish.
	*
	* @return the region code of this must publish
	*/
	@Override
	public java.lang.String getRegionCode() {
		return _mustPublish.getRegionCode();
	}

	/**
	* Sets the region code of this must publish.
	*
	* @param regionCode the region code of this must publish
	*/
	@Override
	public void setRegionCode(java.lang.String regionCode) {
		_mustPublish.setRegionCode(regionCode);
	}

	/**
	* Returns the amer of this must publish.
	*
	* @return the amer of this must publish
	*/
	@Override
	public java.lang.String getAmer() {
		return _mustPublish.getAmer();
	}

	/**
	* Sets the amer of this must publish.
	*
	* @param amer the amer of this must publish
	*/
	@Override
	public void setAmer(java.lang.String amer) {
		_mustPublish.setAmer(amer);
	}

	/**
	* Returns the amea of this must publish.
	*
	* @return the amea of this must publish
	*/
	@Override
	public java.lang.String getAmea() {
		return _mustPublish.getAmea();
	}

	/**
	* Sets the amea of this must publish.
	*
	* @param amea the amea of this must publish
	*/
	@Override
	public void setAmea(java.lang.String amea) {
		_mustPublish.setAmea(amea);
	}

	/**
	* Returns the euro of this must publish.
	*
	* @return the euro of this must publish
	*/
	@Override
	public java.lang.String getEuro() {
		return _mustPublish.getEuro();
	}

	/**
	* Sets the euro of this must publish.
	*
	* @param euro the euro of this must publish
	*/
	@Override
	public void setEuro(java.lang.String euro) {
		_mustPublish.setEuro(euro);
	}

	/**
	* Returns the gc of this must publish.
	*
	* @return the gc of this must publish
	*/
	@Override
	public java.lang.String getGc() {
		return _mustPublish.getGc();
	}

	/**
	* Sets the gc of this must publish.
	*
	* @param gc the gc of this must publish
	*/
	@Override
	public void setGc(java.lang.String gc) {
		_mustPublish.setGc(gc);
	}

	/**
	* Returns the status of this must publish.
	*
	* @return the status of this must publish
	*/
	@Override
	public java.lang.String getStatus() {
		return _mustPublish.getStatus();
	}

	/**
	* Sets the status of this must publish.
	*
	* @param status the status of this must publish
	*/
	@Override
	public void setStatus(java.lang.String status) {
		_mustPublish.setStatus(status);
	}

	/**
	* Returns the display order of this must publish.
	*
	* @return the display order of this must publish
	*/
	@Override
	public long getDisplayOrder() {
		return _mustPublish.getDisplayOrder();
	}

	/**
	* Sets the display order of this must publish.
	*
	* @param displayOrder the display order of this must publish
	*/
	@Override
	public void setDisplayOrder(long displayOrder) {
		_mustPublish.setDisplayOrder(displayOrder);
	}

	/**
	* Returns the taxonomy ID of this must publish.
	*
	* @return the taxonomy ID of this must publish
	*/
	@Override
	public long getTaxonomyId() {
		return _mustPublish.getTaxonomyId();
	}

	/**
	* Sets the taxonomy ID of this must publish.
	*
	* @param taxonomyId the taxonomy ID of this must publish
	*/
	@Override
	public void setTaxonomyId(long taxonomyId) {
		_mustPublish.setTaxonomyId(taxonomyId);
	}

	/**
	* Returns the parent taxonomy ID of this must publish.
	*
	* @return the parent taxonomy ID of this must publish
	*/
	@Override
	public long getParentTaxonomyId() {
		return _mustPublish.getParentTaxonomyId();
	}

	/**
	* Sets the parent taxonomy ID of this must publish.
	*
	* @param parentTaxonomyId the parent taxonomy ID of this must publish
	*/
	@Override
	public void setParentTaxonomyId(long parentTaxonomyId) {
		_mustPublish.setParentTaxonomyId(parentTaxonomyId);
	}

	/**
	* Returns the index order of this must publish.
	*
	* @return the index order of this must publish
	*/
	@Override
	public long getIndexOrder() {
		return _mustPublish.getIndexOrder();
	}

	/**
	* Sets the index order of this must publish.
	*
	* @param indexOrder the index order of this must publish
	*/
	@Override
	public void setIndexOrder(long indexOrder) {
		_mustPublish.setIndexOrder(indexOrder);
	}

	/**
	* Returns the level of this must publish.
	*
	* @return the level of this must publish
	*/
	@Override
	public long getLevel() {
		return _mustPublish.getLevel();
	}

	/**
	* Sets the level of this must publish.
	*
	* @param level the level of this must publish
	*/
	@Override
	public void setLevel(long level) {
		_mustPublish.setLevel(level);
	}

	/**
	* Returns the level sort order of this must publish.
	*
	* @return the level sort order of this must publish
	*/
	@Override
	public long getLevelSortOrder() {
		return _mustPublish.getLevelSortOrder();
	}

	/**
	* Sets the level sort order of this must publish.
	*
	* @param levelSortOrder the level sort order of this must publish
	*/
	@Override
	public void setLevelSortOrder(long levelSortOrder) {
		_mustPublish.setLevelSortOrder(levelSortOrder);
	}

	/**
	* Returns the is global of this must publish.
	*
	* @return the is global of this must publish
	*/
	@Override
	public java.lang.String getIsGlobal() {
		return _mustPublish.getIsGlobal();
	}

	/**
	* Sets the is global of this must publish.
	*
	* @param isGlobal the is global of this must publish
	*/
	@Override
	public void setIsGlobal(java.lang.String isGlobal) {
		_mustPublish.setIsGlobal(isGlobal);
	}

	/**
	* Returns the framework of this must publish.
	*
	* @return the framework of this must publish
	*/
	@Override
	public java.lang.String getFramework() {
		return _mustPublish.getFramework();
	}

	/**
	* Sets the framework of this must publish.
	*
	* @param framework the framework of this must publish
	*/
	@Override
	public void setFramework(java.lang.String framework) {
		_mustPublish.setFramework(framework);
	}

	@Override
	public boolean isNew() {
		return _mustPublish.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_mustPublish.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _mustPublish.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_mustPublish.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _mustPublish.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _mustPublish.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_mustPublish.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _mustPublish.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_mustPublish.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_mustPublish.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_mustPublish.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new MustPublishWrapper((MustPublish)_mustPublish.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.MustPublish mustPublish) {
		return _mustPublish.compareTo(mustPublish);
	}

	@Override
	public int hashCode() {
		return _mustPublish.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.MustPublish> toCacheModel() {
		return _mustPublish.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.MustPublish toEscapedModel() {
		return new MustPublishWrapper(_mustPublish.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.MustPublish toUnescapedModel() {
		return new MustPublishWrapper(_mustPublish.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _mustPublish.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _mustPublish.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_mustPublish.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MustPublishWrapper)) {
			return false;
		}

		MustPublishWrapper mustPublishWrapper = (MustPublishWrapper)obj;

		if (Validator.equals(_mustPublish, mustPublishWrapper._mustPublish)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public MustPublish getWrappedMustPublish() {
		return _mustPublish;
	}

	@Override
	public MustPublish getWrappedModel() {
		return _mustPublish;
	}

	@Override
	public void resetOriginalValues() {
		_mustPublish.resetOriginalValues();
	}

	private MustPublish _mustPublish;
}