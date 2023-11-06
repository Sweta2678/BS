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
 * The base model interface for the StandardsDisplayOrderExt service. Represents a row in the &quot;STD_DISPLAY_ORDER&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.ihg.brandstandards.db.model.impl.StandardsDisplayOrderExtModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.ihg.brandstandards.db.model.impl.StandardsDisplayOrderExtImpl}.
 * </p>
 *
 * @author Mummanedi
 * @see StandardsDisplayOrderExt
 * @see com.ihg.brandstandards.db.model.impl.StandardsDisplayOrderExtImpl
 * @see com.ihg.brandstandards.db.model.impl.StandardsDisplayOrderExtModelImpl
 * @generated
 */
public interface StandardsDisplayOrderExtModel extends BaseModel<StandardsDisplayOrderExt> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a standards display order ext model instance should use the {@link StandardsDisplayOrderExt} interface instead.
	 */

	/**
	 * Returns the primary key of this standards display order ext.
	 *
	 * @return the primary key of this standards display order ext
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this standards display order ext.
	 *
	 * @param primaryKey the primary key of this standards display order ext
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the std ID of this standards display order ext.
	 *
	 * @return the std ID of this standards display order ext
	 */
	public long getStdId();

	/**
	 * Sets the std ID of this standards display order ext.
	 *
	 * @param stdId the std ID of this standards display order ext
	 */
	public void setStdId(long stdId);

	/**
	 * Returns the title of this standards display order ext.
	 *
	 * @return the title of this standards display order ext
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this standards display order ext.
	 *
	 * @param title the title of this standards display order ext
	 */
	public void setTitle(String title);

	/**
	 * Returns the is global of this standards display order ext.
	 *
	 * @return the is global of this standards display order ext
	 */
	@AutoEscape
	public String getIsGlobal();

	/**
	 * Sets the is global of this standards display order ext.
	 *
	 * @param isGlobal the is global of this standards display order ext
	 */
	public void setIsGlobal(String isGlobal);

	/**
	 * Returns the framework of this standards display order ext.
	 *
	 * @return the framework of this standards display order ext
	 */
	@AutoEscape
	public String getFramework();

	/**
	 * Sets the framework of this standards display order ext.
	 *
	 * @param framework the framework of this standards display order ext
	 */
	public void setFramework(String framework);

	/**
	 * Returns the chain code of this standards display order ext.
	 *
	 * @return the chain code of this standards display order ext
	 */
	@AutoEscape
	public String getChainCode();

	/**
	 * Sets the chain code of this standards display order ext.
	 *
	 * @param chainCode the chain code of this standards display order ext
	 */
	public void setChainCode(String chainCode);

	/**
	 * Returns the region code of this standards display order ext.
	 *
	 * @return the region code of this standards display order ext
	 */
	@AutoEscape
	public String getRegionCode();

	/**
	 * Sets the region code of this standards display order ext.
	 *
	 * @param regionCode the region code of this standards display order ext
	 */
	public void setRegionCode(String regionCode);

	/**
	 * Returns the display order of this standards display order ext.
	 *
	 * @return the display order of this standards display order ext
	 */
	public long getDisplayOrder();

	/**
	 * Sets the display order of this standards display order ext.
	 *
	 * @param displayOrder the display order of this standards display order ext
	 */
	public void setDisplayOrder(long displayOrder);

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
	public int compareTo(StandardsDisplayOrderExt standardsDisplayOrderExt);

	@Override
	public int hashCode();

	@Override
	public CacheModel<StandardsDisplayOrderExt> toCacheModel();

	@Override
	public StandardsDisplayOrderExt toEscapedModel();

	@Override
	public StandardsDisplayOrderExt toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}