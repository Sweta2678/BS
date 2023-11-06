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

import com.ihg.brandstandards.db.service.persistence.HistManualChainPK;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the HistManualChain service. Represents a row in the &quot;MNL_CHN&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.ihg.brandstandards.db.model.impl.HistManualChainModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.ihg.brandstandards.db.model.impl.HistManualChainImpl}.
 * </p>
 *
 * @author Mummanedi
 * @see HistManualChain
 * @see com.ihg.brandstandards.db.model.impl.HistManualChainImpl
 * @see com.ihg.brandstandards.db.model.impl.HistManualChainModelImpl
 * @generated
 */
public interface HistManualChainModel extends BaseModel<HistManualChain> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a hist manual chain model instance should use the {@link HistManualChain} interface instead.
	 */

	/**
	 * Returns the primary key of this hist manual chain.
	 *
	 * @return the primary key of this hist manual chain
	 */
	public HistManualChainPK getPrimaryKey();

	/**
	 * Sets the primary key of this hist manual chain.
	 *
	 * @param primaryKey the primary key of this hist manual chain
	 */
	public void setPrimaryKey(HistManualChainPK primaryKey);

	/**
	 * Returns the chain code of this hist manual chain.
	 *
	 * @return the chain code of this hist manual chain
	 */
	@AutoEscape
	public String getChainCode();

	/**
	 * Sets the chain code of this hist manual chain.
	 *
	 * @param chainCode the chain code of this hist manual chain
	 */
	public void setChainCode(String chainCode);

	/**
	 * Returns the hist manual ID of this hist manual chain.
	 *
	 * @return the hist manual ID of this hist manual chain
	 */
	public long getHistManualId();

	/**
	 * Sets the hist manual ID of this hist manual chain.
	 *
	 * @param histManualId the hist manual ID of this hist manual chain
	 */
	public void setHistManualId(long histManualId);

	/**
	 * Returns the creator ID of this hist manual chain.
	 *
	 * @return the creator ID of this hist manual chain
	 */
	@AutoEscape
	public String getCreatorId();

	/**
	 * Sets the creator ID of this hist manual chain.
	 *
	 * @param creatorId the creator ID of this hist manual chain
	 */
	public void setCreatorId(String creatorId);

	/**
	 * Returns the created date of this hist manual chain.
	 *
	 * @return the created date of this hist manual chain
	 */
	public Date getCreatedDate();

	/**
	 * Sets the created date of this hist manual chain.
	 *
	 * @param createdDate the created date of this hist manual chain
	 */
	public void setCreatedDate(Date createdDate);

	/**
	 * Returns the updated by of this hist manual chain.
	 *
	 * @return the updated by of this hist manual chain
	 */
	@AutoEscape
	public String getUpdatedBy();

	/**
	 * Sets the updated by of this hist manual chain.
	 *
	 * @param updatedBy the updated by of this hist manual chain
	 */
	public void setUpdatedBy(String updatedBy);

	/**
	 * Returns the updated date of this hist manual chain.
	 *
	 * @return the updated date of this hist manual chain
	 */
	public Date getUpdatedDate();

	/**
	 * Sets the updated date of this hist manual chain.
	 *
	 * @param updatedDate the updated date of this hist manual chain
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
	public int compareTo(HistManualChain histManualChain);

	@Override
	public int hashCode();

	@Override
	public CacheModel<HistManualChain> toCacheModel();

	@Override
	public HistManualChain toEscapedModel();

	@Override
	public HistManualChain toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}