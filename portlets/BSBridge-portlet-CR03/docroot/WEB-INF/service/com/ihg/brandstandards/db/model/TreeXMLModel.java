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
 * The base model interface for the TreeXML service. Represents a row in the &quot;XML&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.ihg.brandstandards.db.model.impl.TreeXMLModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.ihg.brandstandards.db.model.impl.TreeXMLImpl}.
 * </p>
 *
 * @author Mummanedi
 * @see TreeXML
 * @see com.ihg.brandstandards.db.model.impl.TreeXMLImpl
 * @see com.ihg.brandstandards.db.model.impl.TreeXMLModelImpl
 * @generated
 */
public interface TreeXMLModel extends BaseModel<TreeXML> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a tree x m l model instance should use the {@link TreeXML} interface instead.
	 */

	/**
	 * Returns the primary key of this tree x m l.
	 *
	 * @return the primary key of this tree x m l
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this tree x m l.
	 *
	 * @param primaryKey the primary key of this tree x m l
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the i d of this tree x m l.
	 *
	 * @return the i d of this tree x m l
	 */
	public long getID();

	/**
	 * Sets the i d of this tree x m l.
	 *
	 * @param ID the i d of this tree x m l
	 */
	public void setID(long ID);

	/**
	 * Returns the x m l l o b of this tree x m l.
	 *
	 * @return the x m l l o b of this tree x m l
	 */
	@AutoEscape
	public String getXMLLOB();

	/**
	 * Sets the x m l l o b of this tree x m l.
	 *
	 * @param XMLLOB the x m l l o b of this tree x m l
	 */
	public void setXMLLOB(String XMLLOB);

	/**
	 * Returns the creator ID of this tree x m l.
	 *
	 * @return the creator ID of this tree x m l
	 */
	@AutoEscape
	public String getCreatorId();

	/**
	 * Sets the creator ID of this tree x m l.
	 *
	 * @param creatorId the creator ID of this tree x m l
	 */
	public void setCreatorId(String creatorId);

	/**
	 * Returns the created date of this tree x m l.
	 *
	 * @return the created date of this tree x m l
	 */
	public Date getCreatedDate();

	/**
	 * Sets the created date of this tree x m l.
	 *
	 * @param createdDate the created date of this tree x m l
	 */
	public void setCreatedDate(Date createdDate);

	/**
	 * Returns the updated by of this tree x m l.
	 *
	 * @return the updated by of this tree x m l
	 */
	@AutoEscape
	public String getUpdatedBy();

	/**
	 * Sets the updated by of this tree x m l.
	 *
	 * @param updatedBy the updated by of this tree x m l
	 */
	public void setUpdatedBy(String updatedBy);

	/**
	 * Returns the updated date of this tree x m l.
	 *
	 * @return the updated date of this tree x m l
	 */
	public Date getUpdatedDate();

	/**
	 * Sets the updated date of this tree x m l.
	 *
	 * @param updatedDate the updated date of this tree x m l
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
	public int compareTo(TreeXML treeXML);

	@Override
	public int hashCode();

	@Override
	public CacheModel<TreeXML> toCacheModel();

	@Override
	public TreeXML toEscapedModel();

	@Override
	public TreeXML toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}