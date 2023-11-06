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

import com.ihg.brandstandards.db.service.persistence.BridgeProgressDiscrepancyPK;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the BridgeProgressDiscrepancy service. Represents a row in the &quot;BRIDGE_PUB_PROG_DISCREPANCY&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.ihg.brandstandards.db.model.impl.BridgeProgressDiscrepancyModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.ihg.brandstandards.db.model.impl.BridgeProgressDiscrepancyImpl}.
 * </p>
 *
 * @author Mummanedi
 * @see BridgeProgressDiscrepancy
 * @see com.ihg.brandstandards.db.model.impl.BridgeProgressDiscrepancyImpl
 * @see com.ihg.brandstandards.db.model.impl.BridgeProgressDiscrepancyModelImpl
 * @generated
 */
public interface BridgeProgressDiscrepancyModel extends BaseModel<BridgeProgressDiscrepancy> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a bridge progress discrepancy model instance should use the {@link BridgeProgressDiscrepancy} interface instead.
	 */

	/**
	 * Returns the primary key of this bridge progress discrepancy.
	 *
	 * @return the primary key of this bridge progress discrepancy
	 */
	public BridgeProgressDiscrepancyPK getPrimaryKey();

	/**
	 * Sets the primary key of this bridge progress discrepancy.
	 *
	 * @param primaryKey the primary key of this bridge progress discrepancy
	 */
	public void setPrimaryKey(BridgeProgressDiscrepancyPK primaryKey);

	/**
	 * Returns the progress category ID of this bridge progress discrepancy.
	 *
	 * @return the progress category ID of this bridge progress discrepancy
	 */
	public long getProgressCategoryId();

	/**
	 * Sets the progress category ID of this bridge progress discrepancy.
	 *
	 * @param progressCategoryId the progress category ID of this bridge progress discrepancy
	 */
	public void setProgressCategoryId(long progressCategoryId);

	/**
	 * Returns the progress sub category ID of this bridge progress discrepancy.
	 *
	 * @return the progress sub category ID of this bridge progress discrepancy
	 */
	public long getProgressSubCategoryId();

	/**
	 * Sets the progress sub category ID of this bridge progress discrepancy.
	 *
	 * @param progressSubCategoryId the progress sub category ID of this bridge progress discrepancy
	 */
	public void setProgressSubCategoryId(long progressSubCategoryId);

	/**
	 * Returns the publish ID of this bridge progress discrepancy.
	 *
	 * @return the publish ID of this bridge progress discrepancy
	 */
	public long getPublishId();

	/**
	 * Sets the publish ID of this bridge progress discrepancy.
	 *
	 * @param publishId the publish ID of this bridge progress discrepancy
	 */
	public void setPublishId(long publishId);

	/**
	 * Returns the region ID of this bridge progress discrepancy.
	 *
	 * @return the region ID of this bridge progress discrepancy
	 */
	public long getRegionId();

	/**
	 * Sets the region ID of this bridge progress discrepancy.
	 *
	 * @param regionId the region ID of this bridge progress discrepancy
	 */
	public void setRegionId(long regionId);

	/**
	 * Returns the error count of this bridge progress discrepancy.
	 *
	 * @return the error count of this bridge progress discrepancy
	 */
	public long getErrorCount();

	/**
	 * Sets the error count of this bridge progress discrepancy.
	 *
	 * @param errorCount the error count of this bridge progress discrepancy
	 */
	public void setErrorCount(long errorCount);

	/**
	 * Returns the creator ID of this bridge progress discrepancy.
	 *
	 * @return the creator ID of this bridge progress discrepancy
	 */
	@AutoEscape
	public String getCreatorId();

	/**
	 * Sets the creator ID of this bridge progress discrepancy.
	 *
	 * @param creatorId the creator ID of this bridge progress discrepancy
	 */
	public void setCreatorId(String creatorId);

	/**
	 * Returns the created date of this bridge progress discrepancy.
	 *
	 * @return the created date of this bridge progress discrepancy
	 */
	public Date getCreatedDate();

	/**
	 * Sets the created date of this bridge progress discrepancy.
	 *
	 * @param createdDate the created date of this bridge progress discrepancy
	 */
	public void setCreatedDate(Date createdDate);

	/**
	 * Returns the updated by of this bridge progress discrepancy.
	 *
	 * @return the updated by of this bridge progress discrepancy
	 */
	@AutoEscape
	public String getUpdatedBy();

	/**
	 * Sets the updated by of this bridge progress discrepancy.
	 *
	 * @param updatedBy the updated by of this bridge progress discrepancy
	 */
	public void setUpdatedBy(String updatedBy);

	/**
	 * Returns the updated date of this bridge progress discrepancy.
	 *
	 * @return the updated date of this bridge progress discrepancy
	 */
	public Date getUpdatedDate();

	/**
	 * Sets the updated date of this bridge progress discrepancy.
	 *
	 * @param updatedDate the updated date of this bridge progress discrepancy
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
	public int compareTo(BridgeProgressDiscrepancy bridgeProgressDiscrepancy);

	@Override
	public int hashCode();

	@Override
	public CacheModel<BridgeProgressDiscrepancy> toCacheModel();

	@Override
	public BridgeProgressDiscrepancy toEscapedModel();

	@Override
	public BridgeProgressDiscrepancy toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}