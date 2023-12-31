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
 * The base model interface for the PublishCountryStandard service. Represents a row in the &quot;PUBLISH_CTRY_STD&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.ihg.brandstandards.db.model.impl.PublishCountryStandardModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.ihg.brandstandards.db.model.impl.PublishCountryStandardImpl}.
 * </p>
 *
 * @author Mummanedi
 * @see PublishCountryStandard
 * @see com.ihg.brandstandards.db.model.impl.PublishCountryStandardImpl
 * @see com.ihg.brandstandards.db.model.impl.PublishCountryStandardModelImpl
 * @generated
 */
public interface PublishCountryStandardModel extends BaseModel<PublishCountryStandard> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a publish country standard model instance should use the {@link PublishCountryStandard} interface instead.
	 */

	/**
	 * Returns the primary key of this publish country standard.
	 *
	 * @return the primary key of this publish country standard
	 */
	public String getPrimaryKey();

	/**
	 * Sets the primary key of this publish country standard.
	 *
	 * @param primaryKey the primary key of this publish country standard
	 */
	public void setPrimaryKey(String primaryKey);

	/**
	 * Returns the publish country std ID of this publish country standard.
	 *
	 * @return the publish country std ID of this publish country standard
	 */
	@AutoEscape
	public String getPublishCountryStdId();

	/**
	 * Sets the publish country std ID of this publish country standard.
	 *
	 * @param publishCountryStdId the publish country std ID of this publish country standard
	 */
	public void setPublishCountryStdId(String publishCountryStdId);

	/**
	 * Returns the publish ver ID of this publish country standard.
	 *
	 * @return the publish ver ID of this publish country standard
	 */
	public long getPublishVerId();

	/**
	 * Sets the publish ver ID of this publish country standard.
	 *
	 * @param publishVerId the publish ver ID of this publish country standard
	 */
	public void setPublishVerId(long publishVerId);

	/**
	 * Returns the country code of this publish country standard.
	 *
	 * @return the country code of this publish country standard
	 */
	@AutoEscape
	public String getCountryCode();

	/**
	 * Sets the country code of this publish country standard.
	 *
	 * @param countryCode the country code of this publish country standard
	 */
	public void setCountryCode(String countryCode);

	/**
	 * Returns the expired ref txt of this publish country standard.
	 *
	 * @return the expired ref txt of this publish country standard
	 */
	@AutoEscape
	public String getExpiredRefTxt();

	/**
	 * Sets the expired ref txt of this publish country standard.
	 *
	 * @param expiredRefTxt the expired ref txt of this publish country standard
	 */
	public void setExpiredRefTxt(String expiredRefTxt);

	/**
	 * Returns the publish stat code of this publish country standard.
	 *
	 * @return the publish stat code of this publish country standard
	 */
	@AutoEscape
	public String getPublishStatCode();

	/**
	 * Sets the publish stat code of this publish country standard.
	 *
	 * @param publishStatCode the publish stat code of this publish country standard
	 */
	public void setPublishStatCode(String publishStatCode);

	/**
	 * Returns the std comply deadline date of this publish country standard.
	 *
	 * @return the std comply deadline date of this publish country standard
	 */
	public Date getStdComplyDeadlineDate();

	/**
	 * Sets the std comply deadline date of this publish country standard.
	 *
	 * @param stdComplyDeadlineDate the std comply deadline date of this publish country standard
	 */
	public void setStdComplyDeadlineDate(Date stdComplyDeadlineDate);

	/**
	 * Returns the order number of this publish country standard.
	 *
	 * @return the order number of this publish country standard
	 */
	public long getOrderNumber();

	/**
	 * Sets the order number of this publish country standard.
	 *
	 * @param orderNumber the order number of this publish country standard
	 */
	public void setOrderNumber(long orderNumber);

	/**
	 * Returns the creator ID of this publish country standard.
	 *
	 * @return the creator ID of this publish country standard
	 */
	@AutoEscape
	public String getCreatorId();

	/**
	 * Sets the creator ID of this publish country standard.
	 *
	 * @param creatorId the creator ID of this publish country standard
	 */
	public void setCreatorId(String creatorId);

	/**
	 * Returns the created date of this publish country standard.
	 *
	 * @return the created date of this publish country standard
	 */
	public Date getCreatedDate();

	/**
	 * Sets the created date of this publish country standard.
	 *
	 * @param createdDate the created date of this publish country standard
	 */
	public void setCreatedDate(Date createdDate);

	/**
	 * Returns the updated by of this publish country standard.
	 *
	 * @return the updated by of this publish country standard
	 */
	@AutoEscape
	public String getUpdatedBy();

	/**
	 * Sets the updated by of this publish country standard.
	 *
	 * @param updatedBy the updated by of this publish country standard
	 */
	public void setUpdatedBy(String updatedBy);

	/**
	 * Returns the updated date of this publish country standard.
	 *
	 * @return the updated date of this publish country standard
	 */
	public Date getUpdatedDate();

	/**
	 * Sets the updated date of this publish country standard.
	 *
	 * @param updatedDate the updated date of this publish country standard
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
	public int compareTo(PublishCountryStandard publishCountryStandard);

	@Override
	public int hashCode();

	@Override
	public CacheModel<PublishCountryStandard> toCacheModel();

	@Override
	public PublishCountryStandard toEscapedModel();

	@Override
	public PublishCountryStandard toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}