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

import com.ihg.brandstandards.db.service.persistence.StandardsCountryChainPK;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the StandardsCountryChain service. Represents a row in the &quot;STD_CTRY_CHAIN&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.ihg.brandstandards.db.model.impl.StandardsCountryChainModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.ihg.brandstandards.db.model.impl.StandardsCountryChainImpl}.
 * </p>
 *
 * @author Mummanedi
 * @see StandardsCountryChain
 * @see com.ihg.brandstandards.db.model.impl.StandardsCountryChainImpl
 * @see com.ihg.brandstandards.db.model.impl.StandardsCountryChainModelImpl
 * @generated
 */
public interface StandardsCountryChainModel extends BaseModel<StandardsCountryChain> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a standards country chain model instance should use the {@link StandardsCountryChain} interface instead.
	 */

	/**
	 * Returns the primary key of this standards country chain.
	 *
	 * @return the primary key of this standards country chain
	 */
	public StandardsCountryChainPK getPrimaryKey();

	/**
	 * Sets the primary key of this standards country chain.
	 *
	 * @param primaryKey the primary key of this standards country chain
	 */
	public void setPrimaryKey(StandardsCountryChainPK primaryKey);

	/**
	 * Returns the std ID of this standards country chain.
	 *
	 * @return the std ID of this standards country chain
	 */
	public long getStdId();

	/**
	 * Sets the std ID of this standards country chain.
	 *
	 * @param stdId the std ID of this standards country chain
	 */
	public void setStdId(long stdId);

	/**
	 * Returns the country code of this standards country chain.
	 *
	 * @return the country code of this standards country chain
	 */
	@AutoEscape
	public String getCountryCode();

	/**
	 * Sets the country code of this standards country chain.
	 *
	 * @param countryCode the country code of this standards country chain
	 */
	public void setCountryCode(String countryCode);

	/**
	 * Returns the chain code of this standards country chain.
	 *
	 * @return the chain code of this standards country chain
	 */
	@AutoEscape
	public String getChainCode();

	/**
	 * Sets the chain code of this standards country chain.
	 *
	 * @param chainCode the chain code of this standards country chain
	 */
	public void setChainCode(String chainCode);

	/**
	 * Returns the region code of this standards country chain.
	 *
	 * @return the region code of this standards country chain
	 */
	@AutoEscape
	public String getRegionCode();

	/**
	 * Sets the region code of this standards country chain.
	 *
	 * @param regionCode the region code of this standards country chain
	 */
	public void setRegionCode(String regionCode);

	/**
	 * Returns the comp date of this standards country chain.
	 *
	 * @return the comp date of this standards country chain
	 */
	public Date getCompDate();

	/**
	 * Sets the comp date of this standards country chain.
	 *
	 * @param compDate the comp date of this standards country chain
	 */
	public void setCompDate(Date compDate);

	/**
	 * Returns the expr date of this standards country chain.
	 *
	 * @return the expr date of this standards country chain
	 */
	public Date getExprDate();

	/**
	 * Sets the expr date of this standards country chain.
	 *
	 * @param exprDate the expr date of this standards country chain
	 */
	public void setExprDate(Date exprDate);

	/**
	 * Returns the expired IDs of this standards country chain.
	 *
	 * @return the expired IDs of this standards country chain
	 */
	@AutoEscape
	public String getExpiredIds();

	/**
	 * Sets the expired IDs of this standards country chain.
	 *
	 * @param expiredIds the expired IDs of this standards country chain
	 */
	public void setExpiredIds(String expiredIds);

	/**
	 * Returns the creator ID of this standards country chain.
	 *
	 * @return the creator ID of this standards country chain
	 */
	@AutoEscape
	public String getCreatorId();

	/**
	 * Sets the creator ID of this standards country chain.
	 *
	 * @param creatorId the creator ID of this standards country chain
	 */
	public void setCreatorId(String creatorId);

	/**
	 * Returns the created date of this standards country chain.
	 *
	 * @return the created date of this standards country chain
	 */
	public Date getCreatedDate();

	/**
	 * Sets the created date of this standards country chain.
	 *
	 * @param createdDate the created date of this standards country chain
	 */
	public void setCreatedDate(Date createdDate);

	/**
	 * Returns the updated by of this standards country chain.
	 *
	 * @return the updated by of this standards country chain
	 */
	@AutoEscape
	public String getUpdatedBy();

	/**
	 * Sets the updated by of this standards country chain.
	 *
	 * @param updatedBy the updated by of this standards country chain
	 */
	public void setUpdatedBy(String updatedBy);

	/**
	 * Returns the updated date of this standards country chain.
	 *
	 * @return the updated date of this standards country chain
	 */
	public Date getUpdatedDate();

	/**
	 * Sets the updated date of this standards country chain.
	 *
	 * @param updatedDate the updated date of this standards country chain
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
	public int compareTo(StandardsCountryChain standardsCountryChain);

	@Override
	public int hashCode();

	@Override
	public CacheModel<StandardsCountryChain> toCacheModel();

	@Override
	public StandardsCountryChain toEscapedModel();

	@Override
	public StandardsCountryChain toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}