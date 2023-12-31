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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the BridgePublishPreview service. Represents a row in the &quot;BRIDGE_PUBLISH&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.ihg.brandstandards.db.model.impl.BridgePublishPreviewModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.ihg.brandstandards.db.model.impl.BridgePublishPreviewImpl}.
 * </p>
 *
 * @author Mummanedi
 * @see BridgePublishPreview
 * @see com.ihg.brandstandards.db.model.impl.BridgePublishPreviewImpl
 * @see com.ihg.brandstandards.db.model.impl.BridgePublishPreviewModelImpl
 * @generated
 */
public interface BridgePublishPreviewModel extends BaseModel<BridgePublishPreview> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a bridge publish preview model instance should use the {@link BridgePublishPreview} interface instead.
	 */

	/**
	 * Returns the primary key of this bridge publish preview.
	 *
	 * @return the primary key of this bridge publish preview
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this bridge publish preview.
	 *
	 * @param primaryKey the primary key of this bridge publish preview
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the std ID of this bridge publish preview.
	 *
	 * @return the std ID of this bridge publish preview
	 */
	public long getStdId();

	/**
	 * Sets the std ID of this bridge publish preview.
	 *
	 * @param stdId the std ID of this bridge publish preview
	 */
	public void setStdId(long stdId);

	/**
	 * Returns the taxonomy title of this bridge publish preview.
	 *
	 * @return the taxonomy title of this bridge publish preview
	 */
	@AutoEscape
	public String getTaxonomyTitle();

	/**
	 * Sets the taxonomy title of this bridge publish preview.
	 *
	 * @param taxonomyTitle the taxonomy title of this bridge publish preview
	 */
	public void setTaxonomyTitle(String taxonomyTitle);

	/**
	 * Returns the title of this bridge publish preview.
	 *
	 * @return the title of this bridge publish preview
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this bridge publish preview.
	 *
	 * @param title the title of this bridge publish preview
	 */
	public void setTitle(String title);

	/**
	 * Returns the path of this bridge publish preview.
	 *
	 * @return the path of this bridge publish preview
	 */
	@AutoEscape
	public String getPath();

	/**
	 * Sets the path of this bridge publish preview.
	 *
	 * @param path the path of this bridge publish preview
	 */
	public void setPath(String path);

	/**
	 * Returns the parent std ID of this bridge publish preview.
	 *
	 * @return the parent std ID of this bridge publish preview
	 */
	public long getParentStdId();

	/**
	 * Sets the parent std ID of this bridge publish preview.
	 *
	 * @param parentStdId the parent std ID of this bridge publish preview
	 */
	public void setParentStdId(long parentStdId);

	/**
	 * Returns the current title of this bridge publish preview.
	 *
	 * @return the current title of this bridge publish preview
	 */
	@AutoEscape
	public String getCurrentTitle();

	/**
	 * Sets the current title of this bridge publish preview.
	 *
	 * @param currentTitle the current title of this bridge publish preview
	 */
	public void setCurrentTitle(String currentTitle);

	/**
	 * Returns the type of this bridge publish preview.
	 *
	 * @return the type of this bridge publish preview
	 */
	@AutoEscape
	public String getType();

	/**
	 * Sets the type of this bridge publish preview.
	 *
	 * @param type the type of this bridge publish preview
	 */
	public void setType(String type);

	/**
	 * Returns the display order of this bridge publish preview.
	 *
	 * @return the display order of this bridge publish preview
	 */
	public long getDisplayOrder();

	/**
	 * Sets the display order of this bridge publish preview.
	 *
	 * @param displayOrder the display order of this bridge publish preview
	 */
	public void setDisplayOrder(long displayOrder);

	/**
	 * Returns the taxonomy ID of this bridge publish preview.
	 *
	 * @return the taxonomy ID of this bridge publish preview
	 */
	public long getTaxonomyId();

	/**
	 * Sets the taxonomy ID of this bridge publish preview.
	 *
	 * @param taxonomyId the taxonomy ID of this bridge publish preview
	 */
	public void setTaxonomyId(long taxonomyId);

	/**
	 * Returns the parent taxonomy ID of this bridge publish preview.
	 *
	 * @return the parent taxonomy ID of this bridge publish preview
	 */
	public long getParentTaxonomyId();

	/**
	 * Sets the parent taxonomy ID of this bridge publish preview.
	 *
	 * @param parentTaxonomyId the parent taxonomy ID of this bridge publish preview
	 */
	public void setParentTaxonomyId(long parentTaxonomyId);

	/**
	 * Returns the index order of this bridge publish preview.
	 *
	 * @return the index order of this bridge publish preview
	 */
	public long getIndexOrder();

	/**
	 * Sets the index order of this bridge publish preview.
	 *
	 * @param indexOrder the index order of this bridge publish preview
	 */
	public void setIndexOrder(long indexOrder);

	/**
	 * Returns the level of this bridge publish preview.
	 *
	 * @return the level of this bridge publish preview
	 */
	public long getLevel();

	/**
	 * Sets the level of this bridge publish preview.
	 *
	 * @param level the level of this bridge publish preview
	 */
	public void setLevel(long level);

	/**
	 * Returns the level sort order of this bridge publish preview.
	 *
	 * @return the level sort order of this bridge publish preview
	 */
	public long getLevelSortOrder();

	/**
	 * Sets the level sort order of this bridge publish preview.
	 *
	 * @param levelSortOrder the level sort order of this bridge publish preview
	 */
	public void setLevelSortOrder(long levelSortOrder);

	/**
	 * Returns the status of this bridge publish preview.
	 *
	 * @return the status of this bridge publish preview
	 */
	@AutoEscape
	public String getStatus();

	/**
	 * Sets the status of this bridge publish preview.
	 *
	 * @param status the status of this bridge publish preview
	 */
	public void setStatus(String status);

	/**
	 * Returns the image count of this bridge publish preview.
	 *
	 * @return the image count of this bridge publish preview
	 */
	public long getImageCount();

	/**
	 * Sets the image count of this bridge publish preview.
	 *
	 * @param imageCount the image count of this bridge publish preview
	 */
	public void setImageCount(long imageCount);

	/**
	 * Returns the attachment count of this bridge publish preview.
	 *
	 * @return the attachment count of this bridge publish preview
	 */
	public long getAttachmentCount();

	/**
	 * Sets the attachment count of this bridge publish preview.
	 *
	 * @param attachmentCount the attachment count of this bridge publish preview
	 */
	public void setAttachmentCount(long attachmentCount);

	/**
	 * Returns the x ref count of this bridge publish preview.
	 *
	 * @return the x ref count of this bridge publish preview
	 */
	public long getXRefCount();

	/**
	 * Sets the x ref count of this bridge publish preview.
	 *
	 * @param xRefCount the x ref count of this bridge publish preview
	 */
	public void setXRefCount(long xRefCount);

	/**
	 * Returns the hotel life cycle of this bridge publish preview.
	 *
	 * @return the hotel life cycle of this bridge publish preview
	 */
	public long getHotelLifeCycle();

	/**
	 * Sets the hotel life cycle of this bridge publish preview.
	 *
	 * @param hotelLifeCycle the hotel life cycle of this bridge publish preview
	 */
	public void setHotelLifeCycle(long hotelLifeCycle);

	/**
	 * Returns the compliance count of this bridge publish preview.
	 *
	 * @return the compliance count of this bridge publish preview
	 */
	public long getComplianceCount();

	/**
	 * Sets the compliance count of this bridge publish preview.
	 *
	 * @param complianceCount the compliance count of this bridge publish preview
	 */
	public void setComplianceCount(long complianceCount);

	/**
	 * Returns the hotel attributes of this bridge publish preview.
	 *
	 * @return the hotel attributes of this bridge publish preview
	 */
	@AutoEscape
	public String getHotelAttributes();

	/**
	 * Sets the hotel attributes of this bridge publish preview.
	 *
	 * @param hotelAttributes the hotel attributes of this bridge publish preview
	 */
	public void setHotelAttributes(String hotelAttributes);

	/**
	 * Returns the compliance date of this bridge publish preview.
	 *
	 * @return the compliance date of this bridge publish preview
	 */
	@AutoEscape
	public String getComplianceDate();

	/**
	 * Sets the compliance date of this bridge publish preview.
	 *
	 * @param complianceDate the compliance date of this bridge publish preview
	 */
	public void setComplianceDate(String complianceDate);

	/**
	 * Returns the std reference of this bridge publish preview.
	 *
	 * @return the std reference of this bridge publish preview
	 */
	@AutoEscape
	public String getStdReference();

	/**
	 * Sets the std reference of this bridge publish preview.
	 *
	 * @param stdReference the std reference of this bridge publish preview
	 */
	public void setStdReference(String stdReference);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(BridgePublishPreview bridgePublishPreview);

	@Override
	public int hashCode();

	@Override
	public CacheModel<BridgePublishPreview> toCacheModel();

	@Override
	public BridgePublishPreview toEscapedModel();

	@Override
	public BridgePublishPreview toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}