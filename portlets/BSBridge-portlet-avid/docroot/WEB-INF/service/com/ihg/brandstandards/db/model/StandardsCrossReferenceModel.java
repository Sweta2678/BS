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

import com.ihg.brandstandards.db.service.persistence.StandardsCrossReferencePK;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the StandardsCrossReference service. Represents a row in the &quot;STD_XREF&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.ihg.brandstandards.db.model.impl.StandardsCrossReferenceModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.ihg.brandstandards.db.model.impl.StandardsCrossReferenceImpl}.
 * </p>
 *
 * @author Mummanedi
 * @see StandardsCrossReference
 * @see com.ihg.brandstandards.db.model.impl.StandardsCrossReferenceImpl
 * @see com.ihg.brandstandards.db.model.impl.StandardsCrossReferenceModelImpl
 * @generated
 */
public interface StandardsCrossReferenceModel extends BaseModel<StandardsCrossReference> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a standards cross reference model instance should use the {@link StandardsCrossReference} interface instead.
	 */

	/**
	 * Returns the primary key of this standards cross reference.
	 *
	 * @return the primary key of this standards cross reference
	 */
	public StandardsCrossReferencePK getPrimaryKey();

	/**
	 * Sets the primary key of this standards cross reference.
	 *
	 * @param primaryKey the primary key of this standards cross reference
	 */
	public void setPrimaryKey(StandardsCrossReferencePK primaryKey);

	/**
	 * Returns the std ID of this standards cross reference.
	 *
	 * @return the std ID of this standards cross reference
	 */
	public long getStdId();

	/**
	 * Sets the std ID of this standards cross reference.
	 *
	 * @param stdId the std ID of this standards cross reference
	 */
	public void setStdId(long stdId);

	/**
	 * Returns the xref std ID of this standards cross reference.
	 *
	 * @return the xref std ID of this standards cross reference
	 */
	public long getXrefStdId();

	/**
	 * Sets the xref std ID of this standards cross reference.
	 *
	 * @param xrefStdId the xref std ID of this standards cross reference
	 */
	public void setXrefStdId(long xrefStdId);

	/**
	 * Returns the disp order number of this standards cross reference.
	 *
	 * @return the disp order number of this standards cross reference
	 */
	public long getDispOrderNumber();

	/**
	 * Sets the disp order number of this standards cross reference.
	 *
	 * @param dispOrderNumber the disp order number of this standards cross reference
	 */
	public void setDispOrderNumber(long dispOrderNumber);

	/**
	 * Returns the creator ID of this standards cross reference.
	 *
	 * @return the creator ID of this standards cross reference
	 */
	@AutoEscape
	public String getCreatorId();

	/**
	 * Sets the creator ID of this standards cross reference.
	 *
	 * @param creatorId the creator ID of this standards cross reference
	 */
	public void setCreatorId(String creatorId);

	/**
	 * Returns the created date of this standards cross reference.
	 *
	 * @return the created date of this standards cross reference
	 */
	public Date getCreatedDate();

	/**
	 * Sets the created date of this standards cross reference.
	 *
	 * @param createdDate the created date of this standards cross reference
	 */
	public void setCreatedDate(Date createdDate);

	/**
	 * Returns the updated by of this standards cross reference.
	 *
	 * @return the updated by of this standards cross reference
	 */
	@AutoEscape
	public String getUpdatedBy();

	/**
	 * Sets the updated by of this standards cross reference.
	 *
	 * @param updatedBy the updated by of this standards cross reference
	 */
	public void setUpdatedBy(String updatedBy);

	/**
	 * Returns the updated date of this standards cross reference.
	 *
	 * @return the updated date of this standards cross reference
	 */
	public Date getUpdatedDate();

	/**
	 * Sets the updated date of this standards cross reference.
	 *
	 * @param updatedDate the updated date of this standards cross reference
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
	public int compareTo(StandardsCrossReference standardsCrossReference);

	@Override
	public int hashCode();

	@Override
	public CacheModel<StandardsCrossReference> toCacheModel();

	@Override
	public StandardsCrossReference toEscapedModel();

	@Override
	public StandardsCrossReference toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}