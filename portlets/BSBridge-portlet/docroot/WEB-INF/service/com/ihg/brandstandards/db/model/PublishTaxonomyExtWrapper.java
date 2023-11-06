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
 * This class is a wrapper for {@link PublishTaxonomyExt}.
 * </p>
 *
 * @author Mummanedi
 * @see PublishTaxonomyExt
 * @generated
 */
public class PublishTaxonomyExtWrapper implements PublishTaxonomyExt,
	ModelWrapper<PublishTaxonomyExt> {
	public PublishTaxonomyExtWrapper(PublishTaxonomyExt publishTaxonomyExt) {
		_publishTaxonomyExt = publishTaxonomyExt;
	}

	@Override
	public Class<?> getModelClass() {
		return PublishTaxonomyExt.class;
	}

	@Override
	public String getModelClassName() {
		return PublishTaxonomyExt.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("publishTaxId", getPublishTaxId());
		attributes.put("publishParentId", getPublishParentId());
		attributes.put("title", getTitle());
		attributes.put("lvl", getLvl());
		attributes.put("path", getPath());
		attributes.put("levelSortOrder", getLevelSortOrder());
		attributes.put("publishId", getPublishId());
		attributes.put("indexOrder", getIndexOrder());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long publishTaxId = (Long)attributes.get("publishTaxId");

		if (publishTaxId != null) {
			setPublishTaxId(publishTaxId);
		}

		Long publishParentId = (Long)attributes.get("publishParentId");

		if (publishParentId != null) {
			setPublishParentId(publishParentId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
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

		Long publishId = (Long)attributes.get("publishId");

		if (publishId != null) {
			setPublishId(publishId);
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
		return _publishTaxonomyExt.getPrimaryKey();
	}

	/**
	* Sets the primary key of this Custom Query mapping to create index path..
	*
	* @param primaryKey the primary key of this Custom Query mapping to create index path.
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_publishTaxonomyExt.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the publish tax ID of this Custom Query mapping to create index path..
	*
	* @return the publish tax ID of this Custom Query mapping to create index path.
	*/
	@Override
	public long getPublishTaxId() {
		return _publishTaxonomyExt.getPublishTaxId();
	}

	/**
	* Sets the publish tax ID of this Custom Query mapping to create index path..
	*
	* @param publishTaxId the publish tax ID of this Custom Query mapping to create index path.
	*/
	@Override
	public void setPublishTaxId(long publishTaxId) {
		_publishTaxonomyExt.setPublishTaxId(publishTaxId);
	}

	/**
	* Returns the publish parent ID of this Custom Query mapping to create index path..
	*
	* @return the publish parent ID of this Custom Query mapping to create index path.
	*/
	@Override
	public long getPublishParentId() {
		return _publishTaxonomyExt.getPublishParentId();
	}

	/**
	* Sets the publish parent ID of this Custom Query mapping to create index path..
	*
	* @param publishParentId the publish parent ID of this Custom Query mapping to create index path.
	*/
	@Override
	public void setPublishParentId(long publishParentId) {
		_publishTaxonomyExt.setPublishParentId(publishParentId);
	}

	/**
	* Returns the title of this Custom Query mapping to create index path..
	*
	* @return the title of this Custom Query mapping to create index path.
	*/
	@Override
	public java.lang.String getTitle() {
		return _publishTaxonomyExt.getTitle();
	}

	/**
	* Sets the title of this Custom Query mapping to create index path..
	*
	* @param title the title of this Custom Query mapping to create index path.
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_publishTaxonomyExt.setTitle(title);
	}

	/**
	* Returns the lvl of this Custom Query mapping to create index path..
	*
	* @return the lvl of this Custom Query mapping to create index path.
	*/
	@Override
	public java.lang.String getLvl() {
		return _publishTaxonomyExt.getLvl();
	}

	/**
	* Sets the lvl of this Custom Query mapping to create index path..
	*
	* @param lvl the lvl of this Custom Query mapping to create index path.
	*/
	@Override
	public void setLvl(java.lang.String lvl) {
		_publishTaxonomyExt.setLvl(lvl);
	}

	/**
	* Returns the path of this Custom Query mapping to create index path..
	*
	* @return the path of this Custom Query mapping to create index path.
	*/
	@Override
	public java.lang.String getPath() {
		return _publishTaxonomyExt.getPath();
	}

	/**
	* Sets the path of this Custom Query mapping to create index path..
	*
	* @param path the path of this Custom Query mapping to create index path.
	*/
	@Override
	public void setPath(java.lang.String path) {
		_publishTaxonomyExt.setPath(path);
	}

	/**
	* Returns the level sort order of this Custom Query mapping to create index path..
	*
	* @return the level sort order of this Custom Query mapping to create index path.
	*/
	@Override
	public long getLevelSortOrder() {
		return _publishTaxonomyExt.getLevelSortOrder();
	}

	/**
	* Sets the level sort order of this Custom Query mapping to create index path..
	*
	* @param levelSortOrder the level sort order of this Custom Query mapping to create index path.
	*/
	@Override
	public void setLevelSortOrder(long levelSortOrder) {
		_publishTaxonomyExt.setLevelSortOrder(levelSortOrder);
	}

	/**
	* Returns the publish ID of this Custom Query mapping to create index path..
	*
	* @return the publish ID of this Custom Query mapping to create index path.
	*/
	@Override
	public long getPublishId() {
		return _publishTaxonomyExt.getPublishId();
	}

	/**
	* Sets the publish ID of this Custom Query mapping to create index path..
	*
	* @param publishId the publish ID of this Custom Query mapping to create index path.
	*/
	@Override
	public void setPublishId(long publishId) {
		_publishTaxonomyExt.setPublishId(publishId);
	}

	/**
	* Returns the index order of this Custom Query mapping to create index path..
	*
	* @return the index order of this Custom Query mapping to create index path.
	*/
	@Override
	public long getIndexOrder() {
		return _publishTaxonomyExt.getIndexOrder();
	}

	/**
	* Sets the index order of this Custom Query mapping to create index path..
	*
	* @param indexOrder the index order of this Custom Query mapping to create index path.
	*/
	@Override
	public void setIndexOrder(long indexOrder) {
		_publishTaxonomyExt.setIndexOrder(indexOrder);
	}

	@Override
	public boolean isNew() {
		return _publishTaxonomyExt.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_publishTaxonomyExt.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _publishTaxonomyExt.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_publishTaxonomyExt.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _publishTaxonomyExt.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _publishTaxonomyExt.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_publishTaxonomyExt.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _publishTaxonomyExt.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_publishTaxonomyExt.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_publishTaxonomyExt.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_publishTaxonomyExt.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PublishTaxonomyExtWrapper((PublishTaxonomyExt)_publishTaxonomyExt.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.PublishTaxonomyExt publishTaxonomyExt) {
		return _publishTaxonomyExt.compareTo(publishTaxonomyExt);
	}

	@Override
	public int hashCode() {
		return _publishTaxonomyExt.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.PublishTaxonomyExt> toCacheModel() {
		return _publishTaxonomyExt.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.PublishTaxonomyExt toEscapedModel() {
		return new PublishTaxonomyExtWrapper(_publishTaxonomyExt.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.PublishTaxonomyExt toUnescapedModel() {
		return new PublishTaxonomyExtWrapper(_publishTaxonomyExt.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _publishTaxonomyExt.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _publishTaxonomyExt.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_publishTaxonomyExt.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PublishTaxonomyExtWrapper)) {
			return false;
		}

		PublishTaxonomyExtWrapper publishTaxonomyExtWrapper = (PublishTaxonomyExtWrapper)obj;

		if (Validator.equals(_publishTaxonomyExt,
					publishTaxonomyExtWrapper._publishTaxonomyExt)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public PublishTaxonomyExt getWrappedPublishTaxonomyExt() {
		return _publishTaxonomyExt;
	}

	@Override
	public PublishTaxonomyExt getWrappedModel() {
		return _publishTaxonomyExt;
	}

	@Override
	public void resetOriginalValues() {
		_publishTaxonomyExt.resetOriginalValues();
	}

	private PublishTaxonomyExt _publishTaxonomyExt;
}