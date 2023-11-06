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
 * The base model interface for the BridgePublishStatus service. Represents a row in the &quot;BRIDGE_PUBLISH_STAT&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.ihg.brandstandards.db.model.impl.BridgePublishStatusModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.ihg.brandstandards.db.model.impl.BridgePublishStatusImpl}.
 * </p>
 *
 * @author Mummanedi
 * @see BridgePublishStatus
 * @see com.ihg.brandstandards.db.model.impl.BridgePublishStatusImpl
 * @see com.ihg.brandstandards.db.model.impl.BridgePublishStatusModelImpl
 * @generated
 */
public interface BridgePublishStatusModel extends BaseModel<BridgePublishStatus> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a bridge publish status model instance should use the {@link BridgePublishStatus} interface instead.
	 */

	/**
	 * Returns the primary key of this bridge publish status.
	 *
	 * @return the primary key of this bridge publish status
	 */
	public String getPrimaryKey();

	/**
	 * Sets the primary key of this bridge publish status.
	 *
	 * @param primaryKey the primary key of this bridge publish status
	 */
	public void setPrimaryKey(String primaryKey);

	/**
	 * Returns the publish status code of this bridge publish status.
	 *
	 * @return the publish status code of this bridge publish status
	 */
	@AutoEscape
	public String getPublishStatusCode();

	/**
	 * Sets the publish status code of this bridge publish status.
	 *
	 * @param publishStatusCode the publish status code of this bridge publish status
	 */
	public void setPublishStatusCode(String publishStatusCode);

	/**
	 * Returns the publish status name of this bridge publish status.
	 *
	 * @return the publish status name of this bridge publish status
	 */
	@AutoEscape
	public String getPublishStatusName();

	/**
	 * Sets the publish status name of this bridge publish status.
	 *
	 * @param publishStatusName the publish status name of this bridge publish status
	 */
	public void setPublishStatusName(String publishStatusName);

	/**
	 * Returns the creator ID of this bridge publish status.
	 *
	 * @return the creator ID of this bridge publish status
	 */
	@AutoEscape
	public String getCreatorId();

	/**
	 * Sets the creator ID of this bridge publish status.
	 *
	 * @param creatorId the creator ID of this bridge publish status
	 */
	public void setCreatorId(String creatorId);

	/**
	 * Returns the created date of this bridge publish status.
	 *
	 * @return the created date of this bridge publish status
	 */
	public Date getCreatedDate();

	/**
	 * Sets the created date of this bridge publish status.
	 *
	 * @param createdDate the created date of this bridge publish status
	 */
	public void setCreatedDate(Date createdDate);

	/**
	 * Returns the updated by of this bridge publish status.
	 *
	 * @return the updated by of this bridge publish status
	 */
	@AutoEscape
	public String getUpdatedBy();

	/**
	 * Sets the updated by of this bridge publish status.
	 *
	 * @param updatedBy the updated by of this bridge publish status
	 */
	public void setUpdatedBy(String updatedBy);

	/**
	 * Returns the updated date of this bridge publish status.
	 *
	 * @return the updated date of this bridge publish status
	 */
	public Date getUpdatedDate();

	/**
	 * Sets the updated date of this bridge publish status.
	 *
	 * @param updatedDate the updated date of this bridge publish status
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
	public int compareTo(BridgePublishStatus bridgePublishStatus);

	@Override
	public int hashCode();

	@Override
	public CacheModel<BridgePublishStatus> toCacheModel();

	@Override
	public BridgePublishStatus toEscapedModel();

	@Override
	public BridgePublishStatus toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}