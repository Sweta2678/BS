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
 * This class is a wrapper for {@link BridgePublishStateEx}.
 * </p>
 *
 * @author Mummanedi
 * @see BridgePublishStateEx
 * @generated
 */
public class BridgePublishStateExWrapper implements BridgePublishStateEx,
	ModelWrapper<BridgePublishStateEx> {
	public BridgePublishStateExWrapper(
		BridgePublishStateEx bridgePublishStateEx) {
		_bridgePublishStateEx = bridgePublishStateEx;
	}

	@Override
	public Class<?> getModelClass() {
		return BridgePublishStateEx.class;
	}

	@Override
	public String getModelClassName() {
		return BridgePublishStateEx.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("publishId", getPublishId());
		attributes.put("stdId", getStdId());
		attributes.put("taxonomyTitle", getTaxonomyTitle());
		attributes.put("title", getTitle());
		attributes.put("path", getPath());
		attributes.put("parentStdId", getParentStdId());
		attributes.put("stateCd", getStateCd());
		attributes.put("type", getType());
		attributes.put("manualType", getManualType());
		attributes.put("count", getCount());
		attributes.put("displayOrder", getDisplayOrder());
		attributes.put("taxonomyId", getTaxonomyId());
		attributes.put("parentTaxonomyId", getParentTaxonomyId());
		attributes.put("indexOrder", getIndexOrder());
		attributes.put("level", getLevel());
		attributes.put("levelSortOrder", getLevelSortOrder());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long publishId = (Long)attributes.get("publishId");

		if (publishId != null) {
			setPublishId(publishId);
		}

		Long stdId = (Long)attributes.get("stdId");

		if (stdId != null) {
			setStdId(stdId);
		}

		String taxonomyTitle = (String)attributes.get("taxonomyTitle");

		if (taxonomyTitle != null) {
			setTaxonomyTitle(taxonomyTitle);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String path = (String)attributes.get("path");

		if (path != null) {
			setPath(path);
		}

		Long parentStdId = (Long)attributes.get("parentStdId");

		if (parentStdId != null) {
			setParentStdId(parentStdId);
		}

		String stateCd = (String)attributes.get("stateCd");

		if (stateCd != null) {
			setStateCd(stateCd);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String manualType = (String)attributes.get("manualType");

		if (manualType != null) {
			setManualType(manualType);
		}

		Long count = (Long)attributes.get("count");

		if (count != null) {
			setCount(count);
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
	}

	/**
	* Returns the primary key of this bridge publish state ex.
	*
	* @return the primary key of this bridge publish state ex
	*/
	@Override
	public com.ihg.brandstandards.db.service.persistence.BridgePublishStateExPK getPrimaryKey() {
		return _bridgePublishStateEx.getPrimaryKey();
	}

	/**
	* Sets the primary key of this bridge publish state ex.
	*
	* @param primaryKey the primary key of this bridge publish state ex
	*/
	@Override
	public void setPrimaryKey(
		com.ihg.brandstandards.db.service.persistence.BridgePublishStateExPK primaryKey) {
		_bridgePublishStateEx.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the publish ID of this bridge publish state ex.
	*
	* @return the publish ID of this bridge publish state ex
	*/
	@Override
	public long getPublishId() {
		return _bridgePublishStateEx.getPublishId();
	}

	/**
	* Sets the publish ID of this bridge publish state ex.
	*
	* @param publishId the publish ID of this bridge publish state ex
	*/
	@Override
	public void setPublishId(long publishId) {
		_bridgePublishStateEx.setPublishId(publishId);
	}

	/**
	* Returns the std ID of this bridge publish state ex.
	*
	* @return the std ID of this bridge publish state ex
	*/
	@Override
	public long getStdId() {
		return _bridgePublishStateEx.getStdId();
	}

	/**
	* Sets the std ID of this bridge publish state ex.
	*
	* @param stdId the std ID of this bridge publish state ex
	*/
	@Override
	public void setStdId(long stdId) {
		_bridgePublishStateEx.setStdId(stdId);
	}

	/**
	* Returns the taxonomy title of this bridge publish state ex.
	*
	* @return the taxonomy title of this bridge publish state ex
	*/
	@Override
	public java.lang.String getTaxonomyTitle() {
		return _bridgePublishStateEx.getTaxonomyTitle();
	}

	/**
	* Sets the taxonomy title of this bridge publish state ex.
	*
	* @param taxonomyTitle the taxonomy title of this bridge publish state ex
	*/
	@Override
	public void setTaxonomyTitle(java.lang.String taxonomyTitle) {
		_bridgePublishStateEx.setTaxonomyTitle(taxonomyTitle);
	}

	/**
	* Returns the title of this bridge publish state ex.
	*
	* @return the title of this bridge publish state ex
	*/
	@Override
	public java.lang.String getTitle() {
		return _bridgePublishStateEx.getTitle();
	}

	/**
	* Sets the title of this bridge publish state ex.
	*
	* @param title the title of this bridge publish state ex
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_bridgePublishStateEx.setTitle(title);
	}

	/**
	* Returns the path of this bridge publish state ex.
	*
	* @return the path of this bridge publish state ex
	*/
	@Override
	public java.lang.String getPath() {
		return _bridgePublishStateEx.getPath();
	}

	/**
	* Sets the path of this bridge publish state ex.
	*
	* @param path the path of this bridge publish state ex
	*/
	@Override
	public void setPath(java.lang.String path) {
		_bridgePublishStateEx.setPath(path);
	}

	/**
	* Returns the parent std ID of this bridge publish state ex.
	*
	* @return the parent std ID of this bridge publish state ex
	*/
	@Override
	public long getParentStdId() {
		return _bridgePublishStateEx.getParentStdId();
	}

	/**
	* Sets the parent std ID of this bridge publish state ex.
	*
	* @param parentStdId the parent std ID of this bridge publish state ex
	*/
	@Override
	public void setParentStdId(long parentStdId) {
		_bridgePublishStateEx.setParentStdId(parentStdId);
	}

	/**
	* Returns the state cd of this bridge publish state ex.
	*
	* @return the state cd of this bridge publish state ex
	*/
	@Override
	public java.lang.String getStateCd() {
		return _bridgePublishStateEx.getStateCd();
	}

	/**
	* Sets the state cd of this bridge publish state ex.
	*
	* @param stateCd the state cd of this bridge publish state ex
	*/
	@Override
	public void setStateCd(java.lang.String stateCd) {
		_bridgePublishStateEx.setStateCd(stateCd);
	}

	/**
	* Returns the type of this bridge publish state ex.
	*
	* @return the type of this bridge publish state ex
	*/
	@Override
	public java.lang.String getType() {
		return _bridgePublishStateEx.getType();
	}

	/**
	* Sets the type of this bridge publish state ex.
	*
	* @param type the type of this bridge publish state ex
	*/
	@Override
	public void setType(java.lang.String type) {
		_bridgePublishStateEx.setType(type);
	}

	/**
	* Returns the manual type of this bridge publish state ex.
	*
	* @return the manual type of this bridge publish state ex
	*/
	@Override
	public java.lang.String getManualType() {
		return _bridgePublishStateEx.getManualType();
	}

	/**
	* Sets the manual type of this bridge publish state ex.
	*
	* @param manualType the manual type of this bridge publish state ex
	*/
	@Override
	public void setManualType(java.lang.String manualType) {
		_bridgePublishStateEx.setManualType(manualType);
	}

	/**
	* Returns the count of this bridge publish state ex.
	*
	* @return the count of this bridge publish state ex
	*/
	@Override
	public long getCount() {
		return _bridgePublishStateEx.getCount();
	}

	/**
	* Sets the count of this bridge publish state ex.
	*
	* @param count the count of this bridge publish state ex
	*/
	@Override
	public void setCount(long count) {
		_bridgePublishStateEx.setCount(count);
	}

	/**
	* Returns the display order of this bridge publish state ex.
	*
	* @return the display order of this bridge publish state ex
	*/
	@Override
	public long getDisplayOrder() {
		return _bridgePublishStateEx.getDisplayOrder();
	}

	/**
	* Sets the display order of this bridge publish state ex.
	*
	* @param displayOrder the display order of this bridge publish state ex
	*/
	@Override
	public void setDisplayOrder(long displayOrder) {
		_bridgePublishStateEx.setDisplayOrder(displayOrder);
	}

	/**
	* Returns the taxonomy ID of this bridge publish state ex.
	*
	* @return the taxonomy ID of this bridge publish state ex
	*/
	@Override
	public long getTaxonomyId() {
		return _bridgePublishStateEx.getTaxonomyId();
	}

	/**
	* Sets the taxonomy ID of this bridge publish state ex.
	*
	* @param taxonomyId the taxonomy ID of this bridge publish state ex
	*/
	@Override
	public void setTaxonomyId(long taxonomyId) {
		_bridgePublishStateEx.setTaxonomyId(taxonomyId);
	}

	/**
	* Returns the parent taxonomy ID of this bridge publish state ex.
	*
	* @return the parent taxonomy ID of this bridge publish state ex
	*/
	@Override
	public long getParentTaxonomyId() {
		return _bridgePublishStateEx.getParentTaxonomyId();
	}

	/**
	* Sets the parent taxonomy ID of this bridge publish state ex.
	*
	* @param parentTaxonomyId the parent taxonomy ID of this bridge publish state ex
	*/
	@Override
	public void setParentTaxonomyId(long parentTaxonomyId) {
		_bridgePublishStateEx.setParentTaxonomyId(parentTaxonomyId);
	}

	/**
	* Returns the index order of this bridge publish state ex.
	*
	* @return the index order of this bridge publish state ex
	*/
	@Override
	public long getIndexOrder() {
		return _bridgePublishStateEx.getIndexOrder();
	}

	/**
	* Sets the index order of this bridge publish state ex.
	*
	* @param indexOrder the index order of this bridge publish state ex
	*/
	@Override
	public void setIndexOrder(long indexOrder) {
		_bridgePublishStateEx.setIndexOrder(indexOrder);
	}

	/**
	* Returns the level of this bridge publish state ex.
	*
	* @return the level of this bridge publish state ex
	*/
	@Override
	public long getLevel() {
		return _bridgePublishStateEx.getLevel();
	}

	/**
	* Sets the level of this bridge publish state ex.
	*
	* @param level the level of this bridge publish state ex
	*/
	@Override
	public void setLevel(long level) {
		_bridgePublishStateEx.setLevel(level);
	}

	/**
	* Returns the level sort order of this bridge publish state ex.
	*
	* @return the level sort order of this bridge publish state ex
	*/
	@Override
	public long getLevelSortOrder() {
		return _bridgePublishStateEx.getLevelSortOrder();
	}

	/**
	* Sets the level sort order of this bridge publish state ex.
	*
	* @param levelSortOrder the level sort order of this bridge publish state ex
	*/
	@Override
	public void setLevelSortOrder(long levelSortOrder) {
		_bridgePublishStateEx.setLevelSortOrder(levelSortOrder);
	}

	@Override
	public boolean isNew() {
		return _bridgePublishStateEx.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_bridgePublishStateEx.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _bridgePublishStateEx.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_bridgePublishStateEx.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _bridgePublishStateEx.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _bridgePublishStateEx.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_bridgePublishStateEx.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _bridgePublishStateEx.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_bridgePublishStateEx.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_bridgePublishStateEx.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_bridgePublishStateEx.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BridgePublishStateExWrapper((BridgePublishStateEx)_bridgePublishStateEx.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.BridgePublishStateEx bridgePublishStateEx) {
		return _bridgePublishStateEx.compareTo(bridgePublishStateEx);
	}

	@Override
	public int hashCode() {
		return _bridgePublishStateEx.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.BridgePublishStateEx> toCacheModel() {
		return _bridgePublishStateEx.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.BridgePublishStateEx toEscapedModel() {
		return new BridgePublishStateExWrapper(_bridgePublishStateEx.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.BridgePublishStateEx toUnescapedModel() {
		return new BridgePublishStateExWrapper(_bridgePublishStateEx.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _bridgePublishStateEx.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _bridgePublishStateEx.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_bridgePublishStateEx.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BridgePublishStateExWrapper)) {
			return false;
		}

		BridgePublishStateExWrapper bridgePublishStateExWrapper = (BridgePublishStateExWrapper)obj;

		if (Validator.equals(_bridgePublishStateEx,
					bridgePublishStateExWrapper._bridgePublishStateEx)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public BridgePublishStateEx getWrappedBridgePublishStateEx() {
		return _bridgePublishStateEx;
	}

	@Override
	public BridgePublishStateEx getWrappedModel() {
		return _bridgePublishStateEx;
	}

	@Override
	public void resetOriginalValues() {
		_bridgePublishStateEx.resetOriginalValues();
	}

	private BridgePublishStateEx _bridgePublishStateEx;
}