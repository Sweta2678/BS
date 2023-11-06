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

import java.util.Date;

/**
 * The base model interface for the BridgePublishLang service. Represents a row in the &quot;BRIDGE_PUBLISH_LANG&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.ihg.brandstandards.db.model.impl.BridgePublishLangModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.ihg.brandstandards.db.model.impl.BridgePublishLangImpl}.
 * </p>
 *
 * @author Mummanedi
 * @see BridgePublishLang
 * @see com.ihg.brandstandards.db.model.impl.BridgePublishLangImpl
 * @see com.ihg.brandstandards.db.model.impl.BridgePublishLangModelImpl
 * @generated
 */
public interface BridgePublishLangModel extends BaseModel<BridgePublishLang> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a bridge publish lang model instance should use the {@link BridgePublishLang} interface instead.
	 */

	/**
	 * Returns the primary key of this bridge publish lang.
	 *
	 * @return the primary key of this bridge publish lang
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this bridge publish lang.
	 *
	 * @param primaryKey the primary key of this bridge publish lang
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the publish lang ID of this bridge publish lang.
	 *
	 * @return the publish lang ID of this bridge publish lang
	 */
	public long getPublishLangId();

	/**
	 * Sets the publish lang ID of this bridge publish lang.
	 *
	 * @param publishLangId the publish lang ID of this bridge publish lang
	 */
	public void setPublishLangId(long publishLangId);

	/**
	 * Returns the publish ID of this bridge publish lang.
	 *
	 * @return the publish ID of this bridge publish lang
	 */
	public long getPublishId();

	/**
	 * Sets the publish ID of this bridge publish lang.
	 *
	 * @param publishId the publish ID of this bridge publish lang
	 */
	public void setPublishId(long publishId);

	/**
	 * Returns the region ID of this bridge publish lang.
	 *
	 * @return the region ID of this bridge publish lang
	 */
	public long getRegionId();

	/**
	 * Sets the region ID of this bridge publish lang.
	 *
	 * @param regionId the region ID of this bridge publish lang
	 */
	public void setRegionId(long regionId);

	/**
	 * Returns the locale code of this bridge publish lang.
	 *
	 * @return the locale code of this bridge publish lang
	 */
	@AutoEscape
	public String getLocaleCode();

	/**
	 * Sets the locale code of this bridge publish lang.
	 *
	 * @param localeCode the locale code of this bridge publish lang
	 */
	public void setLocaleCode(String localeCode);

	/**
	 * Returns the creator ID of this bridge publish lang.
	 *
	 * @return the creator ID of this bridge publish lang
	 */
	@AutoEscape
	public String getCreatorId();

	/**
	 * Sets the creator ID of this bridge publish lang.
	 *
	 * @param creatorId the creator ID of this bridge publish lang
	 */
	public void setCreatorId(String creatorId);

	/**
	 * Returns the created date of this bridge publish lang.
	 *
	 * @return the created date of this bridge publish lang
	 */
	public Date getCreatedDate();

	/**
	 * Sets the created date of this bridge publish lang.
	 *
	 * @param createdDate the created date of this bridge publish lang
	 */
	public void setCreatedDate(Date createdDate);

	/**
	 * Returns the updated by of this bridge publish lang.
	 *
	 * @return the updated by of this bridge publish lang
	 */
	@AutoEscape
	public String getUpdatedBy();

	/**
	 * Sets the updated by of this bridge publish lang.
	 *
	 * @param updatedBy the updated by of this bridge publish lang
	 */
	public void setUpdatedBy(String updatedBy);

	/**
	 * Returns the updated date of this bridge publish lang.
	 *
	 * @return the updated date of this bridge publish lang
	 */
	public Date getUpdatedDate();

	/**
	 * Sets the updated date of this bridge publish lang.
	 *
	 * @param updatedDate the updated date of this bridge publish lang
	 */
	public void setUpdatedDate(Date updatedDate);

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
	public int compareTo(BridgePublishLang bridgePublishLang);

	@Override
	public int hashCode();

	@Override
	public CacheModel<BridgePublishLang> toCacheModel();

	@Override
	public BridgePublishLang toEscapedModel();

	@Override
	public BridgePublishLang toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}