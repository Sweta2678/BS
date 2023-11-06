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
 * The base model interface for the StandardsAuthors service. Represents a row in the &quot;STD_AUTHOR&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.ihg.brandstandards.db.model.impl.StandardsAuthorsModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.ihg.brandstandards.db.model.impl.StandardsAuthorsImpl}.
 * </p>
 *
 * @author Mummanedi
 * @see StandardsAuthors
 * @see com.ihg.brandstandards.db.model.impl.StandardsAuthorsImpl
 * @see com.ihg.brandstandards.db.model.impl.StandardsAuthorsModelImpl
 * @generated
 */
public interface StandardsAuthorsModel extends BaseModel<StandardsAuthors> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a standards authors model instance should use the {@link StandardsAuthors} interface instead.
	 */

	/**
	 * Returns the primary key of this standards authors.
	 *
	 * @return the primary key of this standards authors
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this standards authors.
	 *
	 * @param primaryKey the primary key of this standards authors
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the std author ID of this standards authors.
	 *
	 * @return the std author ID of this standards authors
	 */
	public long getStdAuthorId();

	/**
	 * Sets the std author ID of this standards authors.
	 *
	 * @param stdAuthorId the std author ID of this standards authors
	 */
	public void setStdAuthorId(long stdAuthorId);

	/**
	 * Returns the std ID of this standards authors.
	 *
	 * @return the std ID of this standards authors
	 */
	public long getStdId();

	/**
	 * Sets the std ID of this standards authors.
	 *
	 * @param stdId the std ID of this standards authors
	 */
	public void setStdId(long stdId);

	/**
	 * Returns the author name of this standards authors.
	 *
	 * @return the author name of this standards authors
	 */
	@AutoEscape
	public String getAuthorName();

	/**
	 * Sets the author name of this standards authors.
	 *
	 * @param authorName the author name of this standards authors
	 */
	public void setAuthorName(String authorName);

	/**
	 * Returns the is primary of this standards authors.
	 *
	 * @return the is primary of this standards authors
	 */
	@AutoEscape
	public String getIsPrimary();

	/**
	 * Sets the is primary of this standards authors.
	 *
	 * @param isPrimary the is primary of this standards authors
	 */
	public void setIsPrimary(String isPrimary);

	/**
	 * Returns the creator ID of this standards authors.
	 *
	 * @return the creator ID of this standards authors
	 */
	@AutoEscape
	public String getCreatorId();

	/**
	 * Sets the creator ID of this standards authors.
	 *
	 * @param creatorId the creator ID of this standards authors
	 */
	public void setCreatorId(String creatorId);

	/**
	 * Returns the created date of this standards authors.
	 *
	 * @return the created date of this standards authors
	 */
	public Date getCreatedDate();

	/**
	 * Sets the created date of this standards authors.
	 *
	 * @param createdDate the created date of this standards authors
	 */
	public void setCreatedDate(Date createdDate);

	/**
	 * Returns the updated by of this standards authors.
	 *
	 * @return the updated by of this standards authors
	 */
	@AutoEscape
	public String getUpdatedBy();

	/**
	 * Sets the updated by of this standards authors.
	 *
	 * @param updatedBy the updated by of this standards authors
	 */
	public void setUpdatedBy(String updatedBy);

	/**
	 * Returns the updated date of this standards authors.
	 *
	 * @return the updated date of this standards authors
	 */
	public Date getUpdatedDate();

	/**
	 * Sets the updated date of this standards authors.
	 *
	 * @param updatedDate the updated date of this standards authors
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
	public int compareTo(StandardsAuthors standardsAuthors);

	@Override
	public int hashCode();

	@Override
	public CacheModel<StandardsAuthors> toCacheModel();

	@Override
	public StandardsAuthors toEscapedModel();

	@Override
	public StandardsAuthors toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}