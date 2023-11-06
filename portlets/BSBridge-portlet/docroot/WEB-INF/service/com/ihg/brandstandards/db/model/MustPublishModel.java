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
 * The base model interface for the MustPublish service. Represents a row in the &quot;BRIDGE_GBL_PUBLISH&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.ihg.brandstandards.db.model.impl.MustPublishModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.ihg.brandstandards.db.model.impl.MustPublishImpl}.
 * </p>
 *
 * @author Mummanedi
 * @see MustPublish
 * @see com.ihg.brandstandards.db.model.impl.MustPublishImpl
 * @see com.ihg.brandstandards.db.model.impl.MustPublishModelImpl
 * @generated
 */
public interface MustPublishModel extends BaseModel<MustPublish> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a must publish model instance should use the {@link MustPublish} interface instead.
	 */

	/**
	 * Returns the primary key of this must publish.
	 *
	 * @return the primary key of this must publish
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this must publish.
	 *
	 * @param primaryKey the primary key of this must publish
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the parent ID of this must publish.
	 *
	 * @return the parent ID of this must publish
	 */
	public long getParentId();

	/**
	 * Sets the parent ID of this must publish.
	 *
	 * @param parentId the parent ID of this must publish
	 */
	public void setParentId(long parentId);

	/**
	 * Returns the std ID of this must publish.
	 *
	 * @return the std ID of this must publish
	 */
	public long getStdId();

	/**
	 * Sets the std ID of this must publish.
	 *
	 * @param stdId the std ID of this must publish
	 */
	public void setStdId(long stdId);

	/**
	 * Returns the title of this must publish.
	 *
	 * @return the title of this must publish
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this must publish.
	 *
	 * @param title the title of this must publish
	 */
	public void setTitle(String title);

	/**
	 * Returns the std type of this must publish.
	 *
	 * @return the std type of this must publish
	 */
	@AutoEscape
	public String getStdType();

	/**
	 * Sets the std type of this must publish.
	 *
	 * @param stdType the std type of this must publish
	 */
	public void setStdType(String stdType);

	/**
	 * Returns the path of this must publish.
	 *
	 * @return the path of this must publish
	 */
	@AutoEscape
	public String getPath();

	/**
	 * Sets the path of this must publish.
	 *
	 * @param path the path of this must publish
	 */
	public void setPath(String path);

	/**
	 * Returns the current path of this must publish.
	 *
	 * @return the current path of this must publish
	 */
	@AutoEscape
	public String getCurrentPath();

	/**
	 * Sets the current path of this must publish.
	 *
	 * @param currentPath the current path of this must publish
	 */
	public void setCurrentPath(String currentPath);

	/**
	 * Returns the region code of this must publish.
	 *
	 * @return the region code of this must publish
	 */
	@AutoEscape
	public String getRegionCode();

	/**
	 * Sets the region code of this must publish.
	 *
	 * @param regionCode the region code of this must publish
	 */
	public void setRegionCode(String regionCode);

	/**
	 * Returns the amer of this must publish.
	 *
	 * @return the amer of this must publish
	 */
	@AutoEscape
	public String getAmer();

	/**
	 * Sets the amer of this must publish.
	 *
	 * @param amer the amer of this must publish
	 */
	public void setAmer(String amer);

	/**
	 * Returns the amea of this must publish.
	 *
	 * @return the amea of this must publish
	 */
	@AutoEscape
	public String getAmea();

	/**
	 * Sets the amea of this must publish.
	 *
	 * @param amea the amea of this must publish
	 */
	public void setAmea(String amea);

	/**
	 * Returns the euro of this must publish.
	 *
	 * @return the euro of this must publish
	 */
	@AutoEscape
	public String getEuro();

	/**
	 * Sets the euro of this must publish.
	 *
	 * @param euro the euro of this must publish
	 */
	public void setEuro(String euro);

	/**
	 * Returns the gc of this must publish.
	 *
	 * @return the gc of this must publish
	 */
	@AutoEscape
	public String getGc();

	/**
	 * Sets the gc of this must publish.
	 *
	 * @param gc the gc of this must publish
	 */
	public void setGc(String gc);

	/**
	 * Returns the status of this must publish.
	 *
	 * @return the status of this must publish
	 */
	@AutoEscape
	public String getStatus();

	/**
	 * Sets the status of this must publish.
	 *
	 * @param status the status of this must publish
	 */
	public void setStatus(String status);

	/**
	 * Returns the display order of this must publish.
	 *
	 * @return the display order of this must publish
	 */
	public long getDisplayOrder();

	/**
	 * Sets the display order of this must publish.
	 *
	 * @param displayOrder the display order of this must publish
	 */
	public void setDisplayOrder(long displayOrder);

	/**
	 * Returns the taxonomy ID of this must publish.
	 *
	 * @return the taxonomy ID of this must publish
	 */
	public long getTaxonomyId();

	/**
	 * Sets the taxonomy ID of this must publish.
	 *
	 * @param taxonomyId the taxonomy ID of this must publish
	 */
	public void setTaxonomyId(long taxonomyId);

	/**
	 * Returns the parent taxonomy ID of this must publish.
	 *
	 * @return the parent taxonomy ID of this must publish
	 */
	public long getParentTaxonomyId();

	/**
	 * Sets the parent taxonomy ID of this must publish.
	 *
	 * @param parentTaxonomyId the parent taxonomy ID of this must publish
	 */
	public void setParentTaxonomyId(long parentTaxonomyId);

	/**
	 * Returns the index order of this must publish.
	 *
	 * @return the index order of this must publish
	 */
	public long getIndexOrder();

	/**
	 * Sets the index order of this must publish.
	 *
	 * @param indexOrder the index order of this must publish
	 */
	public void setIndexOrder(long indexOrder);

	/**
	 * Returns the level of this must publish.
	 *
	 * @return the level of this must publish
	 */
	public long getLevel();

	/**
	 * Sets the level of this must publish.
	 *
	 * @param level the level of this must publish
	 */
	public void setLevel(long level);

	/**
	 * Returns the level sort order of this must publish.
	 *
	 * @return the level sort order of this must publish
	 */
	public long getLevelSortOrder();

	/**
	 * Sets the level sort order of this must publish.
	 *
	 * @param levelSortOrder the level sort order of this must publish
	 */
	public void setLevelSortOrder(long levelSortOrder);

	/**
	 * Returns the is global of this must publish.
	 *
	 * @return the is global of this must publish
	 */
	@AutoEscape
	public String getIsGlobal();

	/**
	 * Sets the is global of this must publish.
	 *
	 * @param isGlobal the is global of this must publish
	 */
	public void setIsGlobal(String isGlobal);

	/**
	 * Returns the framework of this must publish.
	 *
	 * @return the framework of this must publish
	 */
	@AutoEscape
	public String getFramework();

	/**
	 * Sets the framework of this must publish.
	 *
	 * @param framework the framework of this must publish
	 */
	public void setFramework(String framework);

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
	public int compareTo(MustPublish mustPublish);

	@Override
	public int hashCode();

	@Override
	public CacheModel<MustPublish> toCacheModel();

	@Override
	public MustPublish toEscapedModel();

	@Override
	public MustPublish toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}