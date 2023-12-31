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
 * The base model interface for the PublishStd service. Represents a row in the &quot;PUBLISH_STD&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.ihg.brandstandards.db.model.impl.PublishStdModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.ihg.brandstandards.db.model.impl.PublishStdImpl}.
 * </p>
 *
 * @author Mummanedi
 * @see PublishStd
 * @see com.ihg.brandstandards.db.model.impl.PublishStdImpl
 * @see com.ihg.brandstandards.db.model.impl.PublishStdModelImpl
 * @generated
 */
public interface PublishStdModel extends BaseModel<PublishStd> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a publish std model instance should use the {@link PublishStd} interface instead.
	 */

	/**
	 * Returns the primary key of this publish std.
	 *
	 * @return the primary key of this publish std
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this publish std.
	 *
	 * @param primaryKey the primary key of this publish std
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the publish std ver ID of this publish std.
	 *
	 * @return the publish std ver ID of this publish std
	 */
	public long getPublishStdVerId();

	/**
	 * Sets the publish std ver ID of this publish std.
	 *
	 * @param publishStdVerId the publish std ver ID of this publish std
	 */
	public void setPublishStdVerId(long publishStdVerId);

	/**
	 * Returns the std ID of this publish std.
	 *
	 * @return the std ID of this publish std
	 */
	public long getStdId();

	/**
	 * Sets the std ID of this publish std.
	 *
	 * @param stdId the std ID of this publish std
	 */
	public void setStdId(long stdId);

	/**
	 * Returns the parent ID of this publish std.
	 *
	 * @return the parent ID of this publish std
	 */
	public long getParentId();

	/**
	 * Sets the parent ID of this publish std.
	 *
	 * @param parentId the parent ID of this publish std
	 */
	public void setParentId(long parentId);

	/**
	 * Returns the std typ of this publish std.
	 *
	 * @return the std typ of this publish std
	 */
	@AutoEscape
	public String getStdTyp();

	/**
	 * Sets the std typ of this publish std.
	 *
	 * @param stdTyp the std typ of this publish std
	 */
	public void setStdTyp(String stdTyp);

	/**
	 * Returns the title of this publish std.
	 *
	 * @return the title of this publish std
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this publish std.
	 *
	 * @param title the title of this publish std
	 */
	public void setTitle(String title);

	/**
	 * Returns the description of this publish std.
	 *
	 * @return the description of this publish std
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this publish std.
	 *
	 * @param description the description of this publish std
	 */
	public void setDescription(String description);

	/**
	 * Returns the author of this publish std.
	 *
	 * @return the author of this publish std
	 */
	@AutoEscape
	public String getAuthor();

	/**
	 * Sets the author of this publish std.
	 *
	 * @param author the author of this publish std
	 */
	public void setAuthor(String author);

	/**
	 * Returns the business owner of this publish std.
	 *
	 * @return the business owner of this publish std
	 */
	@AutoEscape
	public String getBusinessOwner();

	/**
	 * Sets the business owner of this publish std.
	 *
	 * @param businessOwner the business owner of this publish std
	 */
	public void setBusinessOwner(String businessOwner);

	/**
	 * Returns the effective date of this publish std.
	 *
	 * @return the effective date of this publish std
	 */
	public Date getEffectiveDate();

	/**
	 * Sets the effective date of this publish std.
	 *
	 * @param effectiveDate the effective date of this publish std
	 */
	public void setEffectiveDate(Date effectiveDate);

	/**
	 * Returns the impl date of this publish std.
	 *
	 * @return the impl date of this publish std
	 */
	public Date getImplDate();

	/**
	 * Sets the impl date of this publish std.
	 *
	 * @param implDate the impl date of this publish std
	 */
	public void setImplDate(Date implDate);

	/**
	 * Returns the waiver of this publish std.
	 *
	 * @return the waiver of this publish std
	 */
	@AutoEscape
	public String getWaiver();

	/**
	 * Sets the waiver of this publish std.
	 *
	 * @param waiver the waiver of this publish std
	 */
	public void setWaiver(String waiver);

	/**
	 * Returns the status of this publish std.
	 *
	 * @return the status of this publish std
	 */
	@AutoEscape
	public String getStatus();

	/**
	 * Sets the status of this publish std.
	 *
	 * @param status the status of this publish std
	 */
	public void setStatus(String status);

	/**
	 * Returns the category of this publish std.
	 *
	 * @return the category of this publish std
	 */
	@AutoEscape
	public String getCategory();

	/**
	 * Sets the category of this publish std.
	 *
	 * @param category the category of this publish std
	 */
	public void setCategory(String category);

	/**
	 * Returns the created by of this publish std.
	 *
	 * @return the created by of this publish std
	 */
	@AutoEscape
	public String getCreatedBy();

	/**
	 * Sets the created by of this publish std.
	 *
	 * @param createdBy the created by of this publish std
	 */
	public void setCreatedBy(String createdBy);

	/**
	 * Returns the change of this publish std.
	 *
	 * @return the change of this publish std
	 */
	@AutoEscape
	public String getChange();

	/**
	 * Sets the change of this publish std.
	 *
	 * @param change the change of this publish std
	 */
	public void setChange(String change);

	/**
	 * Returns the is global of this publish std.
	 *
	 * @return the is global of this publish std
	 */
	@AutoEscape
	public String getIsGlobal();

	/**
	 * Sets the is global of this publish std.
	 *
	 * @param isGlobal the is global of this publish std
	 */
	public void setIsGlobal(String isGlobal);

	/**
	 * Returns the region code of this publish std.
	 *
	 * @return the region code of this publish std
	 */
	@AutoEscape
	public String getRegionCode();

	/**
	 * Sets the region code of this publish std.
	 *
	 * @param regionCode the region code of this publish std
	 */
	public void setRegionCode(String regionCode);

	/**
	 * Returns the notes of this publish std.
	 *
	 * @return the notes of this publish std
	 */
	@AutoEscape
	public String getNotes();

	/**
	 * Sets the notes of this publish std.
	 *
	 * @param notes the notes of this publish std
	 */
	public void setNotes(String notes);

	/**
	 * Returns the framework of this publish std.
	 *
	 * @return the framework of this publish std
	 */
	@AutoEscape
	public String getFramework();

	/**
	 * Sets the framework of this publish std.
	 *
	 * @param framework the framework of this publish std
	 */
	public void setFramework(String framework);

	/**
	 * Returns the internal reference of this publish std.
	 *
	 * @return the internal reference of this publish std
	 */
	@AutoEscape
	public String getInternalReference();

	/**
	 * Sets the internal reference of this publish std.
	 *
	 * @param internalReference the internal reference of this publish std
	 */
	public void setInternalReference(String internalReference);

	/**
	 * Returns the order number of this publish std.
	 *
	 * @return the order number of this publish std
	 */
	public long getOrderNumber();

	/**
	 * Sets the order number of this publish std.
	 *
	 * @param orderNumber the order number of this publish std
	 */
	public void setOrderNumber(long orderNumber);

	/**
	 * Returns the status identifier of this publish std.
	 *
	 * @return the status identifier of this publish std
	 */
	public long getStatusIdentifier();

	/**
	 * Sets the status identifier of this publish std.
	 *
	 * @param statusIdentifier the status identifier of this publish std
	 */
	public void setStatusIdentifier(long statusIdentifier);

	/**
	 * Returns the region identifier of this publish std.
	 *
	 * @return the region identifier of this publish std
	 */
	public long getRegionIdentifier();

	/**
	 * Sets the region identifier of this publish std.
	 *
	 * @param regionIdentifier the region identifier of this publish std
	 */
	public void setRegionIdentifier(long regionIdentifier);

	/**
	 * Returns the publish ID of this publish std.
	 *
	 * @return the publish ID of this publish std
	 */
	public long getPublishId();

	/**
	 * Sets the publish ID of this publish std.
	 *
	 * @param publishId the publish ID of this publish std
	 */
	public void setPublishId(long publishId);

	/**
	 * Returns the creator ID of this publish std.
	 *
	 * @return the creator ID of this publish std
	 */
	@AutoEscape
	public String getCreatorId();

	/**
	 * Sets the creator ID of this publish std.
	 *
	 * @param creatorId the creator ID of this publish std
	 */
	public void setCreatorId(String creatorId);

	/**
	 * Returns the created date of this publish std.
	 *
	 * @return the created date of this publish std
	 */
	public Date getCreatedDate();

	/**
	 * Sets the created date of this publish std.
	 *
	 * @param createdDate the created date of this publish std
	 */
	public void setCreatedDate(Date createdDate);

	/**
	 * Returns the updated by of this publish std.
	 *
	 * @return the updated by of this publish std
	 */
	@AutoEscape
	public String getUpdatedBy();

	/**
	 * Sets the updated by of this publish std.
	 *
	 * @param updatedBy the updated by of this publish std
	 */
	public void setUpdatedBy(String updatedBy);

	/**
	 * Returns the updated date of this publish std.
	 *
	 * @return the updated date of this publish std
	 */
	public Date getUpdatedDate();

	/**
	 * Sets the updated date of this publish std.
	 *
	 * @param updatedDate the updated date of this publish std
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
	public int compareTo(PublishStd publishStd);

	@Override
	public int hashCode();

	@Override
	public CacheModel<PublishStd> toCacheModel();

	@Override
	public PublishStd toEscapedModel();

	@Override
	public PublishStd toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}