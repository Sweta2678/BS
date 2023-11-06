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
 * This class is a wrapper for {@link BridgePublishPreview}.
 * </p>
 *
 * @author Mummanedi
 * @see BridgePublishPreview
 * @generated
 */
public class BridgePublishPreviewWrapper implements BridgePublishPreview,
	ModelWrapper<BridgePublishPreview> {
	public BridgePublishPreviewWrapper(
		BridgePublishPreview bridgePublishPreview) {
		_bridgePublishPreview = bridgePublishPreview;
	}

	@Override
	public Class<?> getModelClass() {
		return BridgePublishPreview.class;
	}

	@Override
	public String getModelClassName() {
		return BridgePublishPreview.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("stdId", getStdId());
		attributes.put("taxonomyTitle", getTaxonomyTitle());
		attributes.put("title", getTitle());
		attributes.put("path", getPath());
		attributes.put("parentStdId", getParentStdId());
		attributes.put("currentTitle", getCurrentTitle());
		attributes.put("type", getType());
		attributes.put("displayOrder", getDisplayOrder());
		attributes.put("taxonomyId", getTaxonomyId());
		attributes.put("parentTaxonomyId", getParentTaxonomyId());
		attributes.put("indexOrder", getIndexOrder());
		attributes.put("level", getLevel());
		attributes.put("levelSortOrder", getLevelSortOrder());
		attributes.put("status", getStatus());
		attributes.put("imageCount", getImageCount());
		attributes.put("attachmentCount", getAttachmentCount());
		attributes.put("xRefCount", getXRefCount());
		attributes.put("hotelLifeCycle", getHotelLifeCycle());
		attributes.put("complianceCount", getComplianceCount());
		attributes.put("hotelAttributes", getHotelAttributes());
		attributes.put("complianceDate", getComplianceDate());
		attributes.put("stdReference", getStdReference());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
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

		String currentTitle = (String)attributes.get("currentTitle");

		if (currentTitle != null) {
			setCurrentTitle(currentTitle);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
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

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long imageCount = (Long)attributes.get("imageCount");

		if (imageCount != null) {
			setImageCount(imageCount);
		}

		Long attachmentCount = (Long)attributes.get("attachmentCount");

		if (attachmentCount != null) {
			setAttachmentCount(attachmentCount);
		}

		Long xRefCount = (Long)attributes.get("xRefCount");

		if (xRefCount != null) {
			setXRefCount(xRefCount);
		}

		Long hotelLifeCycle = (Long)attributes.get("hotelLifeCycle");

		if (hotelLifeCycle != null) {
			setHotelLifeCycle(hotelLifeCycle);
		}

		Long complianceCount = (Long)attributes.get("complianceCount");

		if (complianceCount != null) {
			setComplianceCount(complianceCount);
		}

		String hotelAttributes = (String)attributes.get("hotelAttributes");

		if (hotelAttributes != null) {
			setHotelAttributes(hotelAttributes);
		}

		String complianceDate = (String)attributes.get("complianceDate");

		if (complianceDate != null) {
			setComplianceDate(complianceDate);
		}

		String stdReference = (String)attributes.get("stdReference");

		if (stdReference != null) {
			setStdReference(stdReference);
		}
	}

	/**
	* Returns the primary key of this bridge publish preview.
	*
	* @return the primary key of this bridge publish preview
	*/
	@Override
	public long getPrimaryKey() {
		return _bridgePublishPreview.getPrimaryKey();
	}

	/**
	* Sets the primary key of this bridge publish preview.
	*
	* @param primaryKey the primary key of this bridge publish preview
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_bridgePublishPreview.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the std ID of this bridge publish preview.
	*
	* @return the std ID of this bridge publish preview
	*/
	@Override
	public long getStdId() {
		return _bridgePublishPreview.getStdId();
	}

	/**
	* Sets the std ID of this bridge publish preview.
	*
	* @param stdId the std ID of this bridge publish preview
	*/
	@Override
	public void setStdId(long stdId) {
		_bridgePublishPreview.setStdId(stdId);
	}

	/**
	* Returns the taxonomy title of this bridge publish preview.
	*
	* @return the taxonomy title of this bridge publish preview
	*/
	@Override
	public java.lang.String getTaxonomyTitle() {
		return _bridgePublishPreview.getTaxonomyTitle();
	}

	/**
	* Sets the taxonomy title of this bridge publish preview.
	*
	* @param taxonomyTitle the taxonomy title of this bridge publish preview
	*/
	@Override
	public void setTaxonomyTitle(java.lang.String taxonomyTitle) {
		_bridgePublishPreview.setTaxonomyTitle(taxonomyTitle);
	}

	/**
	* Returns the title of this bridge publish preview.
	*
	* @return the title of this bridge publish preview
	*/
	@Override
	public java.lang.String getTitle() {
		return _bridgePublishPreview.getTitle();
	}

	/**
	* Sets the title of this bridge publish preview.
	*
	* @param title the title of this bridge publish preview
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_bridgePublishPreview.setTitle(title);
	}

	/**
	* Returns the path of this bridge publish preview.
	*
	* @return the path of this bridge publish preview
	*/
	@Override
	public java.lang.String getPath() {
		return _bridgePublishPreview.getPath();
	}

	/**
	* Sets the path of this bridge publish preview.
	*
	* @param path the path of this bridge publish preview
	*/
	@Override
	public void setPath(java.lang.String path) {
		_bridgePublishPreview.setPath(path);
	}

	/**
	* Returns the parent std ID of this bridge publish preview.
	*
	* @return the parent std ID of this bridge publish preview
	*/
	@Override
	public long getParentStdId() {
		return _bridgePublishPreview.getParentStdId();
	}

	/**
	* Sets the parent std ID of this bridge publish preview.
	*
	* @param parentStdId the parent std ID of this bridge publish preview
	*/
	@Override
	public void setParentStdId(long parentStdId) {
		_bridgePublishPreview.setParentStdId(parentStdId);
	}

	/**
	* Returns the current title of this bridge publish preview.
	*
	* @return the current title of this bridge publish preview
	*/
	@Override
	public java.lang.String getCurrentTitle() {
		return _bridgePublishPreview.getCurrentTitle();
	}

	/**
	* Sets the current title of this bridge publish preview.
	*
	* @param currentTitle the current title of this bridge publish preview
	*/
	@Override
	public void setCurrentTitle(java.lang.String currentTitle) {
		_bridgePublishPreview.setCurrentTitle(currentTitle);
	}

	/**
	* Returns the type of this bridge publish preview.
	*
	* @return the type of this bridge publish preview
	*/
	@Override
	public java.lang.String getType() {
		return _bridgePublishPreview.getType();
	}

	/**
	* Sets the type of this bridge publish preview.
	*
	* @param type the type of this bridge publish preview
	*/
	@Override
	public void setType(java.lang.String type) {
		_bridgePublishPreview.setType(type);
	}

	/**
	* Returns the display order of this bridge publish preview.
	*
	* @return the display order of this bridge publish preview
	*/
	@Override
	public long getDisplayOrder() {
		return _bridgePublishPreview.getDisplayOrder();
	}

	/**
	* Sets the display order of this bridge publish preview.
	*
	* @param displayOrder the display order of this bridge publish preview
	*/
	@Override
	public void setDisplayOrder(long displayOrder) {
		_bridgePublishPreview.setDisplayOrder(displayOrder);
	}

	/**
	* Returns the taxonomy ID of this bridge publish preview.
	*
	* @return the taxonomy ID of this bridge publish preview
	*/
	@Override
	public long getTaxonomyId() {
		return _bridgePublishPreview.getTaxonomyId();
	}

	/**
	* Sets the taxonomy ID of this bridge publish preview.
	*
	* @param taxonomyId the taxonomy ID of this bridge publish preview
	*/
	@Override
	public void setTaxonomyId(long taxonomyId) {
		_bridgePublishPreview.setTaxonomyId(taxonomyId);
	}

	/**
	* Returns the parent taxonomy ID of this bridge publish preview.
	*
	* @return the parent taxonomy ID of this bridge publish preview
	*/
	@Override
	public long getParentTaxonomyId() {
		return _bridgePublishPreview.getParentTaxonomyId();
	}

	/**
	* Sets the parent taxonomy ID of this bridge publish preview.
	*
	* @param parentTaxonomyId the parent taxonomy ID of this bridge publish preview
	*/
	@Override
	public void setParentTaxonomyId(long parentTaxonomyId) {
		_bridgePublishPreview.setParentTaxonomyId(parentTaxonomyId);
	}

	/**
	* Returns the index order of this bridge publish preview.
	*
	* @return the index order of this bridge publish preview
	*/
	@Override
	public long getIndexOrder() {
		return _bridgePublishPreview.getIndexOrder();
	}

	/**
	* Sets the index order of this bridge publish preview.
	*
	* @param indexOrder the index order of this bridge publish preview
	*/
	@Override
	public void setIndexOrder(long indexOrder) {
		_bridgePublishPreview.setIndexOrder(indexOrder);
	}

	/**
	* Returns the level of this bridge publish preview.
	*
	* @return the level of this bridge publish preview
	*/
	@Override
	public long getLevel() {
		return _bridgePublishPreview.getLevel();
	}

	/**
	* Sets the level of this bridge publish preview.
	*
	* @param level the level of this bridge publish preview
	*/
	@Override
	public void setLevel(long level) {
		_bridgePublishPreview.setLevel(level);
	}

	/**
	* Returns the level sort order of this bridge publish preview.
	*
	* @return the level sort order of this bridge publish preview
	*/
	@Override
	public long getLevelSortOrder() {
		return _bridgePublishPreview.getLevelSortOrder();
	}

	/**
	* Sets the level sort order of this bridge publish preview.
	*
	* @param levelSortOrder the level sort order of this bridge publish preview
	*/
	@Override
	public void setLevelSortOrder(long levelSortOrder) {
		_bridgePublishPreview.setLevelSortOrder(levelSortOrder);
	}

	/**
	* Returns the status of this bridge publish preview.
	*
	* @return the status of this bridge publish preview
	*/
	@Override
	public java.lang.String getStatus() {
		return _bridgePublishPreview.getStatus();
	}

	/**
	* Sets the status of this bridge publish preview.
	*
	* @param status the status of this bridge publish preview
	*/
	@Override
	public void setStatus(java.lang.String status) {
		_bridgePublishPreview.setStatus(status);
	}

	/**
	* Returns the image count of this bridge publish preview.
	*
	* @return the image count of this bridge publish preview
	*/
	@Override
	public long getImageCount() {
		return _bridgePublishPreview.getImageCount();
	}

	/**
	* Sets the image count of this bridge publish preview.
	*
	* @param imageCount the image count of this bridge publish preview
	*/
	@Override
	public void setImageCount(long imageCount) {
		_bridgePublishPreview.setImageCount(imageCount);
	}

	/**
	* Returns the attachment count of this bridge publish preview.
	*
	* @return the attachment count of this bridge publish preview
	*/
	@Override
	public long getAttachmentCount() {
		return _bridgePublishPreview.getAttachmentCount();
	}

	/**
	* Sets the attachment count of this bridge publish preview.
	*
	* @param attachmentCount the attachment count of this bridge publish preview
	*/
	@Override
	public void setAttachmentCount(long attachmentCount) {
		_bridgePublishPreview.setAttachmentCount(attachmentCount);
	}

	/**
	* Returns the x ref count of this bridge publish preview.
	*
	* @return the x ref count of this bridge publish preview
	*/
	@Override
	public long getXRefCount() {
		return _bridgePublishPreview.getXRefCount();
	}

	/**
	* Sets the x ref count of this bridge publish preview.
	*
	* @param xRefCount the x ref count of this bridge publish preview
	*/
	@Override
	public void setXRefCount(long xRefCount) {
		_bridgePublishPreview.setXRefCount(xRefCount);
	}

	/**
	* Returns the hotel life cycle of this bridge publish preview.
	*
	* @return the hotel life cycle of this bridge publish preview
	*/
	@Override
	public long getHotelLifeCycle() {
		return _bridgePublishPreview.getHotelLifeCycle();
	}

	/**
	* Sets the hotel life cycle of this bridge publish preview.
	*
	* @param hotelLifeCycle the hotel life cycle of this bridge publish preview
	*/
	@Override
	public void setHotelLifeCycle(long hotelLifeCycle) {
		_bridgePublishPreview.setHotelLifeCycle(hotelLifeCycle);
	}

	/**
	* Returns the compliance count of this bridge publish preview.
	*
	* @return the compliance count of this bridge publish preview
	*/
	@Override
	public long getComplianceCount() {
		return _bridgePublishPreview.getComplianceCount();
	}

	/**
	* Sets the compliance count of this bridge publish preview.
	*
	* @param complianceCount the compliance count of this bridge publish preview
	*/
	@Override
	public void setComplianceCount(long complianceCount) {
		_bridgePublishPreview.setComplianceCount(complianceCount);
	}

	/**
	* Returns the hotel attributes of this bridge publish preview.
	*
	* @return the hotel attributes of this bridge publish preview
	*/
	@Override
	public java.lang.String getHotelAttributes() {
		return _bridgePublishPreview.getHotelAttributes();
	}

	/**
	* Sets the hotel attributes of this bridge publish preview.
	*
	* @param hotelAttributes the hotel attributes of this bridge publish preview
	*/
	@Override
	public void setHotelAttributes(java.lang.String hotelAttributes) {
		_bridgePublishPreview.setHotelAttributes(hotelAttributes);
	}

	/**
	* Returns the compliance date of this bridge publish preview.
	*
	* @return the compliance date of this bridge publish preview
	*/
	@Override
	public java.lang.String getComplianceDate() {
		return _bridgePublishPreview.getComplianceDate();
	}

	/**
	* Sets the compliance date of this bridge publish preview.
	*
	* @param complianceDate the compliance date of this bridge publish preview
	*/
	@Override
	public void setComplianceDate(java.lang.String complianceDate) {
		_bridgePublishPreview.setComplianceDate(complianceDate);
	}

	/**
	* Returns the std reference of this bridge publish preview.
	*
	* @return the std reference of this bridge publish preview
	*/
	@Override
	public java.lang.String getStdReference() {
		return _bridgePublishPreview.getStdReference();
	}

	/**
	* Sets the std reference of this bridge publish preview.
	*
	* @param stdReference the std reference of this bridge publish preview
	*/
	@Override
	public void setStdReference(java.lang.String stdReference) {
		_bridgePublishPreview.setStdReference(stdReference);
	}

	@Override
	public boolean isNew() {
		return _bridgePublishPreview.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_bridgePublishPreview.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _bridgePublishPreview.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_bridgePublishPreview.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _bridgePublishPreview.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _bridgePublishPreview.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_bridgePublishPreview.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _bridgePublishPreview.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_bridgePublishPreview.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_bridgePublishPreview.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_bridgePublishPreview.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BridgePublishPreviewWrapper((BridgePublishPreview)_bridgePublishPreview.clone());
	}

	@Override
	public int compareTo(
		com.ihg.brandstandards.db.model.BridgePublishPreview bridgePublishPreview) {
		return _bridgePublishPreview.compareTo(bridgePublishPreview);
	}

	@Override
	public int hashCode() {
		return _bridgePublishPreview.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.brandstandards.db.model.BridgePublishPreview> toCacheModel() {
		return _bridgePublishPreview.toCacheModel();
	}

	@Override
	public com.ihg.brandstandards.db.model.BridgePublishPreview toEscapedModel() {
		return new BridgePublishPreviewWrapper(_bridgePublishPreview.toEscapedModel());
	}

	@Override
	public com.ihg.brandstandards.db.model.BridgePublishPreview toUnescapedModel() {
		return new BridgePublishPreviewWrapper(_bridgePublishPreview.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _bridgePublishPreview.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _bridgePublishPreview.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_bridgePublishPreview.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BridgePublishPreviewWrapper)) {
			return false;
		}

		BridgePublishPreviewWrapper bridgePublishPreviewWrapper = (BridgePublishPreviewWrapper)obj;

		if (Validator.equals(_bridgePublishPreview,
					bridgePublishPreviewWrapper._bridgePublishPreview)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public BridgePublishPreview getWrappedBridgePublishPreview() {
		return _bridgePublishPreview;
	}

	@Override
	public BridgePublishPreview getWrappedModel() {
		return _bridgePublishPreview;
	}

	@Override
	public void resetOriginalValues() {
		_bridgePublishPreview.resetOriginalValues();
	}

	private BridgePublishPreview _bridgePublishPreview;
}