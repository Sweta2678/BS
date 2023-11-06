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
 * The base model interface for the Standards service. Represents a row in the &quot;STD&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.ihg.brandstandards.db.model.impl.StandardsModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.ihg.brandstandards.db.model.impl.StandardsImpl}.
 * </p>
 *
 * @author Mummanedi
 * @see Standards
 * @see com.ihg.brandstandards.db.model.impl.StandardsImpl
 * @see com.ihg.brandstandards.db.model.impl.StandardsModelImpl
 * @generated
 */
public interface StandardsModel extends BaseModel<Standards> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a standards model instance should use the {@link Standards} interface instead.
	 */

	/**
	 * Returns the primary key of this standards.
	 *
	 * @return the primary key of this standards
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this standards.
	 *
	 * @param primaryKey the primary key of this standards
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the std ID of this standards.
	 *
	 * @return the std ID of this standards
	 */
	public long getStdId();

	/**
	 * Sets the std ID of this standards.
	 *
	 * @param stdId the std ID of this standards
	 */
	public void setStdId(long stdId);

	/**
	 * Returns the parent ID of this standards.
	 *
	 * @return the parent ID of this standards
	 */
	public long getParentId();

	/**
	 * Sets the parent ID of this standards.
	 *
	 * @param parentId the parent ID of this standards
	 */
	public void setParentId(long parentId);

	/**
	 * Returns the std typ of this standards.
	 *
	 * @return the std typ of this standards
	 */
	@AutoEscape
	public String getStdTyp();

	/**
	 * Sets the std typ of this standards.
	 *
	 * @param stdTyp the std typ of this standards
	 */
	public void setStdTyp(String stdTyp);

	/**
	 * Returns the title of this standards.
	 *
	 * @return the title of this standards
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this standards.
	 *
	 * @param title the title of this standards
	 */
	public void setTitle(String title);

	/**
	 * Returns the description of this standards.
	 *
	 * @return the description of this standards
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this standards.
	 *
	 * @param description the description of this standards
	 */
	public void setDescription(String description);

	/**
	 * Returns the author of this standards.
	 *
	 * @return the author of this standards
	 */
	@AutoEscape
	public String getAuthor();

	/**
	 * Sets the author of this standards.
	 *
	 * @param author the author of this standards
	 */
	public void setAuthor(String author);

	/**
	 * Returns the business owner of this standards.
	 *
	 * @return the business owner of this standards
	 */
	@AutoEscape
	public String getBusinessOwner();

	/**
	 * Sets the business owner of this standards.
	 *
	 * @param businessOwner the business owner of this standards
	 */
	public void setBusinessOwner(String businessOwner);

	/**
	 * Returns the effective date of this standards.
	 *
	 * @return the effective date of this standards
	 */
	public Date getEffectiveDate();

	/**
	 * Sets the effective date of this standards.
	 *
	 * @param effectiveDate the effective date of this standards
	 */
	public void setEffectiveDate(Date effectiveDate);

	/**
	 * Returns the impl date of this standards.
	 *
	 * @return the impl date of this standards
	 */
	public Date getImplDate();

	/**
	 * Sets the impl date of this standards.
	 *
	 * @param implDate the impl date of this standards
	 */
	public void setImplDate(Date implDate);

	/**
	 * Returns the waiver of this standards.
	 *
	 * @return the waiver of this standards
	 */
	@AutoEscape
	public String getWaiver();

	/**
	 * Sets the waiver of this standards.
	 *
	 * @param waiver the waiver of this standards
	 */
	public void setWaiver(String waiver);

	/**
	 * Returns the status of this standards.
	 *
	 * @return the status of this standards
	 */
	@AutoEscape
	public String getStatus();

	/**
	 * Sets the status of this standards.
	 *
	 * @param status the status of this standards
	 */
	public void setStatus(String status);

	/**
	 * Returns the category of this standards.
	 *
	 * @return the category of this standards
	 */
	@AutoEscape
	public String getCategory();

	/**
	 * Sets the category of this standards.
	 *
	 * @param category the category of this standards
	 */
	public void setCategory(String category);

	/**
	 * Returns the created by of this standards.
	 *
	 * @return the created by of this standards
	 */
	@AutoEscape
	public String getCreatedBy();

	/**
	 * Sets the created by of this standards.
	 *
	 * @param createdBy the created by of this standards
	 */
	public void setCreatedBy(String createdBy);

	/**
	 * Returns the change of this standards.
	 *
	 * @return the change of this standards
	 */
	@AutoEscape
	public String getChange();

	/**
	 * Sets the change of this standards.
	 *
	 * @param change the change of this standards
	 */
	public void setChange(String change);

	/**
	 * Returns the is global of this standards.
	 *
	 * @return the is global of this standards
	 */
	@AutoEscape
	public String getIsGlobal();

	/**
	 * Sets the is global of this standards.
	 *
	 * @param isGlobal the is global of this standards
	 */
	public void setIsGlobal(String isGlobal);

	/**
	 * Returns the region code of this standards.
	 *
	 * @return the region code of this standards
	 */
	@AutoEscape
	public String getRegionCode();

	/**
	 * Sets the region code of this standards.
	 *
	 * @param regionCode the region code of this standards
	 */
	public void setRegionCode(String regionCode);

	/**
	 * Returns the notes of this standards.
	 *
	 * @return the notes of this standards
	 */
	@AutoEscape
	public String getNotes();

	/**
	 * Sets the notes of this standards.
	 *
	 * @param notes the notes of this standards
	 */
	public void setNotes(String notes);

	/**
	 * Returns the framework of this standards.
	 *
	 * @return the framework of this standards
	 */
	@AutoEscape
	public String getFramework();

	/**
	 * Sets the framework of this standards.
	 *
	 * @param framework the framework of this standards
	 */
	public void setFramework(String framework);

	/**
	 * Returns the internal reference of this standards.
	 *
	 * @return the internal reference of this standards
	 */
	@AutoEscape
	public String getInternalReference();

	/**
	 * Sets the internal reference of this standards.
	 *
	 * @param internalReference the internal reference of this standards
	 */
	public void setInternalReference(String internalReference);

	/**
	 * Returns the order number of this standards.
	 *
	 * @return the order number of this standards
	 */
	public long getOrderNumber();

	/**
	 * Sets the order number of this standards.
	 *
	 * @param orderNumber the order number of this standards
	 */
	public void setOrderNumber(long orderNumber);

	/**
	 * Returns the creator ID of this standards.
	 *
	 * @return the creator ID of this standards
	 */
	@AutoEscape
	public String getCreatorId();

	/**
	 * Sets the creator ID of this standards.
	 *
	 * @param creatorId the creator ID of this standards
	 */
	public void setCreatorId(String creatorId);

	/**
	 * Returns the created date of this standards.
	 *
	 * @return the created date of this standards
	 */
	public Date getCreatedDate();

	/**
	 * Sets the created date of this standards.
	 *
	 * @param createdDate the created date of this standards
	 */
	public void setCreatedDate(Date createdDate);

	/**
	 * Returns the updated by of this standards.
	 *
	 * @return the updated by of this standards
	 */
	@AutoEscape
	public String getUpdatedBy();

	/**
	 * Sets the updated by of this standards.
	 *
	 * @param updatedBy the updated by of this standards
	 */
	public void setUpdatedBy(String updatedBy);

	/**
	 * Returns the updated date of this standards.
	 *
	 * @return the updated date of this standards
	 */
	public Date getUpdatedDate();

	/**
	 * Sets the updated date of this standards.
	 *
	 * @param updatedDate the updated date of this standards
	 */
	public void setUpdatedDate(Date updatedDate);

	/**
	 * Returns the status ID of this standards.
	 *
	 * @return the status ID of this standards
	 */
	public long getStatusId();

	/**
	 * Sets the status ID of this standards.
	 *
	 * @param statusId the status ID of this standards
	 */
	public void setStatusId(long statusId);

	/**
	 * Returns the region ID of this standards.
	 *
	 * @return the region ID of this standards
	 */
	public long getRegionId();

	/**
	 * Sets the region ID of this standards.
	 *
	 * @param regionId the region ID of this standards
	 */
	public void setRegionId(long regionId);

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
	public int compareTo(Standards standards);

	@Override
	public int hashCode();

	@Override
	public CacheModel<Standards> toCacheModel();

	@Override
	public Standards toEscapedModel();

	@Override
	public Standards toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}