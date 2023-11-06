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

import com.ihg.brandstandards.db.service.persistence.AttachmentsStandardsCountryPK;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the AttachmentsStandardsCountry service. Represents a row in the &quot;STD_ATTACHMENT_CTRY&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.ihg.brandstandards.db.model.impl.AttachmentsStandardsCountryModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.ihg.brandstandards.db.model.impl.AttachmentsStandardsCountryImpl}.
 * </p>
 *
 * @author Mummanedi
 * @see AttachmentsStandardsCountry
 * @see com.ihg.brandstandards.db.model.impl.AttachmentsStandardsCountryImpl
 * @see com.ihg.brandstandards.db.model.impl.AttachmentsStandardsCountryModelImpl
 * @generated
 */
public interface AttachmentsStandardsCountryModel extends BaseModel<AttachmentsStandardsCountry> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a attachments standards country model instance should use the {@link AttachmentsStandardsCountry} interface instead.
	 */

	/**
	 * Returns the primary key of this attachments standards country.
	 *
	 * @return the primary key of this attachments standards country
	 */
	public AttachmentsStandardsCountryPK getPrimaryKey();

	/**
	 * Sets the primary key of this attachments standards country.
	 *
	 * @param primaryKey the primary key of this attachments standards country
	 */
	public void setPrimaryKey(AttachmentsStandardsCountryPK primaryKey);

	/**
	 * Returns the attachment ID of this attachments standards country.
	 *
	 * @return the attachment ID of this attachments standards country
	 */
	public long getAttachmentId();

	/**
	 * Sets the attachment ID of this attachments standards country.
	 *
	 * @param attachmentId the attachment ID of this attachments standards country
	 */
	public void setAttachmentId(long attachmentId);

	/**
	 * Returns the country code of this attachments standards country.
	 *
	 * @return the country code of this attachments standards country
	 */
	@AutoEscape
	public String getCountryCode();

	/**
	 * Sets the country code of this attachments standards country.
	 *
	 * @param countryCode the country code of this attachments standards country
	 */
	public void setCountryCode(String countryCode);

	/**
	 * Returns the locale code of this attachments standards country.
	 *
	 * @return the locale code of this attachments standards country
	 */
	@AutoEscape
	public String getLocaleCode();

	/**
	 * Sets the locale code of this attachments standards country.
	 *
	 * @param localeCode the locale code of this attachments standards country
	 */
	public void setLocaleCode(String localeCode);

	/**
	 * Returns the creator ID of this attachments standards country.
	 *
	 * @return the creator ID of this attachments standards country
	 */
	@AutoEscape
	public String getCreatorId();

	/**
	 * Sets the creator ID of this attachments standards country.
	 *
	 * @param creatorId the creator ID of this attachments standards country
	 */
	public void setCreatorId(String creatorId);

	/**
	 * Returns the created date of this attachments standards country.
	 *
	 * @return the created date of this attachments standards country
	 */
	public Date getCreatedDate();

	/**
	 * Sets the created date of this attachments standards country.
	 *
	 * @param createdDate the created date of this attachments standards country
	 */
	public void setCreatedDate(Date createdDate);

	/**
	 * Returns the updated by of this attachments standards country.
	 *
	 * @return the updated by of this attachments standards country
	 */
	@AutoEscape
	public String getUpdatedBy();

	/**
	 * Sets the updated by of this attachments standards country.
	 *
	 * @param updatedBy the updated by of this attachments standards country
	 */
	public void setUpdatedBy(String updatedBy);

	/**
	 * Returns the updated date of this attachments standards country.
	 *
	 * @return the updated date of this attachments standards country
	 */
	public Date getUpdatedDate();

	/**
	 * Sets the updated date of this attachments standards country.
	 *
	 * @param updatedDate the updated date of this attachments standards country
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
	public int compareTo(
		AttachmentsStandardsCountry attachmentsStandardsCountry);

	@Override
	public int hashCode();

	@Override
	public CacheModel<AttachmentsStandardsCountry> toCacheModel();

	@Override
	public AttachmentsStandardsCountry toEscapedModel();

	@Override
	public AttachmentsStandardsCountry toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}